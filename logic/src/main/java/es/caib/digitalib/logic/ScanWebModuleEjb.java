package es.caib.digitalib.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.scanweb.api.IScanWebPlugin;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.model.fields.PluginFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Constants;


/**
 *
 * @author anadal
 *
 */
@Stateless(name = "ScanWebModuleEJB")
@SecurityDomain("seycon")
public class ScanWebModuleEjb implements ScanWebModuleLocal {

  protected static Logger log = Logger.getLogger(ScanWebModuleEjb.class);
  
  @EJB(mappedName = PluginScanWebLogicaLocal.JNDI_NAME)
  protected PluginScanWebLogicaLocal pluginScanWebLogicaEjb;
  
  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;
  
  
  @Override
  public List<Plugin> getAllPluginsFiltered(HttpServletRequest request, String transactionWebID, Long[] pluginsID)
      throws Exception, I18NException {

    //ScanWebConfig scanWebConfig = ScanWebUtils.generateScanWebConfig(
    //    transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID), null);
    ScanWebConfig scanWebConfig = getScanWebConfig(request, transactionWebID);

    // TODO CHECK scanWebConfig
    List<Plugin> plugins = pluginScanWebLogicaEjb.select(PluginFields.PLUGINID.in(pluginsID));
    if (plugins == null || plugins.size() == 0) {
      String msg = "S'ha produit un error llegint els plugins o no se n'han definit.";
      throw new Exception(msg);
    }
    
    List<Plugin> pluginsFiltered = new ArrayList<Plugin>();

    IScanWebPlugin scanWebPlugin;

    for (Plugin pluginDeScanWeb : plugins) {
      // 1.- Es pot instanciar el plugin ?
      scanWebPlugin = pluginScanWebLogicaEjb
          .getInstanceByPluginID(pluginDeScanWeb.getPluginID());

      if (scanWebPlugin == null) {
        throw new Exception("No s'ha pogut instanciar Plugin amb ID "
            + pluginDeScanWeb.getPluginID());
      }

      // 2.- Passa el filtre ...
      if (scanWebPlugin.filter(request, scanWebConfig)) {
        pluginsFiltered.add(pluginDeScanWeb);
      } else {
        // Exclude Plugin
        log.info("Exclos plugin [" + pluginDeScanWeb.getNom() + "]: NO PASSA FILTRE");
      }

    }

    return pluginsFiltered;

  }
  
  
  
  
  
  

  @Override
  public String scanDocument(HttpServletRequest request, String absolutePluginRequestPath,
      String relativePluginRequestPath, String transactionWebID, long pluginID) throws Exception, I18NException {

    
    
    @SuppressWarnings("unused")
    TransaccioJPA trans = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
    
    ScanWebConfig scanWebConfig = getScanWebConfig(request, transactionWebID);

    //Long pluginID = trans.getPerfil().getPluginScanWebID();****

    log.info("SMC :: scanDocument: PluginID = " + pluginID);
    log.info("SMC :: scanDocument: scanWebID = " + transactionWebID);

    // El plugin existeix?
    IScanWebPlugin scanWebPlugin;

    scanWebPlugin = pluginScanWebLogicaEjb.getInstanceByPluginID(pluginID);

    if (scanWebPlugin == null) {
      String msg = "plugin.scanweb.noexist: " + String.valueOf(pluginID);
      throw new Exception(msg);
    }

    String urlToPluginWebPage;
    urlToPluginWebPage = scanWebPlugin.startScanWebTransaction(absolutePluginRequestPath,
        relativePluginRequestPath, request, scanWebConfig);

    return urlToPluginWebPage;

  }

  /**
   * 
   */
  public void requestPlugin(HttpServletRequest request, HttpServletResponse response,
      String absoluteRequestPluginBasePath, String relativeRequestPluginBasePath,
      String transactionWebID, String query, boolean isPost) throws Exception, I18NException {

    
    TransaccioJPA trans = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
    
    //ScanWebConfigTester ss = getScanWebConfig(request, scanWebID);
    
    if (trans == null) {
      response.sendRedirect("/index.jsp");
      return;
    }
    

    long pluginID = trans.getPerfil().getPluginScanWebID();

    // log.info(" TesterScanWebConfig ss = " + ss);
    // log.info(" ScanWebConfig pluginID = ss.getPluginID(); =>  " + pluginID);

    IScanWebPlugin scanWebPlugin;
    try {
      scanWebPlugin = pluginScanWebLogicaEjb.getInstanceByPluginID(pluginID);
    } catch (Exception e) {

      String msg = "plugin.scanweb.noexist: " + String.valueOf(pluginID);
      throw new Exception(msg);
    }
    if (scanWebPlugin == null) {
      String msg = "plugin.scanweb.noexist: " + String.valueOf(pluginID);
      throw new Exception(msg);
    }

    if (isPost) {
      scanWebPlugin.requestPOST(absoluteRequestPluginBasePath, relativeRequestPluginBasePath,
          transactionWebID, query, request, response);
    } else {
      scanWebPlugin.requestGET(absoluteRequestPluginBasePath, relativeRequestPluginBasePath,
          transactionWebID, query, request, response);
    }

  }

  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------
  // ----------------------------- U T I L I T A T S ----------------------
  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------

  @Override
  public void closeScanWebProcess(HttpServletRequest request, String transactionWebID) throws I18NException {

    TransaccioJPA trans = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
    
    //XYZ ZZZ ScanWebConfigTester ss = getScanWebConfig(request, scanWebID);

    if (trans == null) {
      log.warn("NO Existeix scanWebID igual a " + transactionWebID);
      return;
    }


    long pluginID = trans.getPerfil().getPluginScanWebID();

    // final String scanWebID = pss.getscanWebID();
    {

      IScanWebPlugin scanWebPlugin = null;
      try {
        scanWebPlugin = pluginScanWebLogicaEjb.getInstanceByPluginID(pluginID);
      } catch (Throwable e) {
        log.error(e.getMessage(), e);
        return;
      }
      if (scanWebPlugin == null) {
        log.error("plugin.scanweb.noexist: " + String.valueOf(pluginID));
      }

      try {
        scanWebPlugin.endScanWebTransaction(transactionWebID, request);
      } catch (Exception e) {
        log.error(
            "Error borrant dades d'un Proces d'escaneig " + transactionWebID + ": " + e.getMessage(),
            e);
      }
    }
    scanWebConfigMap.remove(transactionWebID);
    
    if(log.isDebugEnabled()) {
      log.debug(" ESBORRAT TRANSACCIO " + transactionWebID + ".");
    }
    
  }

  
  
  private static final Map<String, ScanWebConfig> scanWebConfigMap = new HashMap<String, ScanWebConfig>();

  private static long lastCheckScanProcessCaducades = 0;
  

  /**
   * Fa neteja
   * 
   * @param scanWebID
   * @return
   */
  public ScanWebConfig getScanWebConfig(HttpServletRequest request, String scanWebID) {
    // Fer net peticions caducades
    // Check si existeix algun proces de escaneig caducat s'ha d'esborrar
    // Com a mínim cada minut es revisa si hi ha caducats
    
    Long now = System.currentTimeMillis();

    final long un_minut_en_ms = 60 * 60 * 1000;

    if (now + un_minut_en_ms > lastCheckScanProcessCaducades) {
      lastCheckScanProcessCaducades = now;
      Map<String, ScanWebConfig> keysToDelete = new HashMap<String, ScanWebConfig>();
      
      
      Set<String> ids = scanWebConfigMap.keySet();
      for (String id : ids) {
        ScanWebConfig ss = scanWebConfigMap.get(id);
        // XYZ ZZZ Optimitzar amb un SelectMultiple de scanwebid i DATAINICI
        Timestamp ts;
        try {
          ts = transaccioLogicaEjb.executeQueryOne(TransaccioFields.DATAINICI, TransaccioFields.TRANSACTIONWEBID.equal(scanWebID));
        } catch (I18NException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          continue;
        }

        long expiryTransaction = ts.getTime() + Constants.EXPIRATION_TIME_MS;
            
        if (now > expiryTransaction) {
          keysToDelete.put(id, ss);
          SimpleDateFormat sdf = new SimpleDateFormat();
          log.info("Tancant ScanWebConfig amb ID = " + id + " a causa de que està caducat "
              + "( ARA: " + sdf.format(new Date(now)) + " | CADUCITAT: "
              + sdf.format(new Date(expiryTransaction)) + ")");
        }
      }

      if (keysToDelete.size() != 0) {
        synchronized (scanWebConfigMap) {

          for (Entry<String, ScanWebConfig> pss : keysToDelete.entrySet()) {
            try {
              closeScanWebProcess(request, pss.getKey());
            } catch (I18NException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
        }
      }
    }
    

    return scanWebConfigMap.get(scanWebID);
  }


  @Override
  public void startScanWebProcess(ScanWebConfig scanWebConfig) {
    final String scanWebID = scanWebConfig.getScanWebID();
    synchronized (scanWebConfigMap) {
      scanWebConfigMap.put(scanWebID, scanWebConfig);
    }

  }
    
  
  /*
  @Override
  public Set<String> getDefaultFlags(ScanWebConfigTester ss) throws Exception  {
    
    long pluginID = ss.getPluginID();
    
    IScanWebPlugin scanWebPlugin;
    try {
      scanWebPlugin = pluginScanWebLogicaEjb.getInstanceByPluginID(pluginID);
    } catch (Throwable e) {

      String msg = "plugin.scanweb.noexist: " + String.valueOf(pluginID);
      throw new Exception(msg);
    }
    if (scanWebPlugin == null) {
      String msg = "plugin.scanweb.noexist: " + String.valueOf(pluginID);
      throw new Exception(msg);
    }
    
    List<Set<String>> supFlags = scanWebPlugin.getSupportedFlagsByScanType(ss.getScanType());
    
    return supFlags.get(0);
    
  }
  */

}
