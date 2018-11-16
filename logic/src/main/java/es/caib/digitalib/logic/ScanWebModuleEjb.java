package es.caib.digitalib.logic;

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
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.logic.utils.ScanWebConfigTester;
import es.caib.digitalib.model.entity.Plugin;


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
  
  
  @Override
  public List<Plugin> getAllPluginsFiltered(HttpServletRequest request, long scanWebID)
      throws Exception, I18NException {

    ScanWebConfigTester scanWebConfig = getScanWebConfig(request, scanWebID);

    // TODO CHECK scanWebConfig
    List<Plugin> plugins = pluginScanWebLogicaEjb.getAllPlugins();
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
      String relativePluginRequestPath, long scanWebID) throws Exception, I18NException {

    ScanWebConfigTester scanWebConfig = getScanWebConfig(request, scanWebID);

    Long pluginID = scanWebConfig.getPluginID();

    log.info("SMC :: scanDocument: PluginID = " + pluginID);
    log.info("SMC :: scanDocument: scanWebID = " + scanWebID);

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
      long scanWebID, String query, boolean isPost) throws Exception, I18NException {

    ScanWebConfigTester ss = getScanWebConfig(request, scanWebID);
    
    if (ss == null) {
      response.sendRedirect("/index.jsp");
      return;
    }
    

    long pluginID = ss.getPluginID();

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
          scanWebID, query, request, response);
    } else {
      scanWebPlugin.requestGET(absoluteRequestPluginBasePath, relativeRequestPluginBasePath,
          scanWebID, query, request, response);
    }

  }

  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------
  // ----------------------------- U T I L I T A T S ----------------------
  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------

  @Override
  public void closeScanWebProcess(HttpServletRequest request, long scanWebID) {

    ScanWebConfigTester pss = getScanWebConfig(request, scanWebID);

    if (pss == null) {
      log.warn("NO Existeix scanWebID igual a " + scanWebID);
      return;
    }

    closeScanWebProcess(request, scanWebID, pss);
  }

  private void closeScanWebProcess(HttpServletRequest request, long scanWebID,
      ScanWebConfigTester pss) {

    Long pluginID = pss.getPluginID();

    // final String scanWebID = pss.getscanWebID();
    if (pluginID == null) {
      // Encara no s'ha asignat plugin al proces d'escaneig
    } else {

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
        scanWebPlugin.endScanWebTransaction(scanWebID, request);
      } catch (Exception e) {
        log.error(
            "Error borrant dades d'un Proces d'escaneig " + scanWebID + ": " + e.getMessage(),
            e);
      }
    }
    scanWebConfigMap.remove(scanWebID);
  }

  private static final Map<Long, ScanWebConfigTester> scanWebConfigMap = new HashMap<Long, ScanWebConfigTester>();

  private static long lastCheckScanProcessCaducades = 0;

  /**
   * Fa neteja
   * 
   * @param scanWebID
   * @return
   */
  public ScanWebConfigTester getScanWebConfig(HttpServletRequest request, long scanWebID) {
    // Fer net peticions caducades
    // Check si existeix algun proces de escaneig caducat s'ha d'esborrar
    // Com a mínim cada minut es revisa si hi ha caducats
    Long now = System.currentTimeMillis();

    final long un_minut_en_ms = 60 * 60 * 1000;

    if (now + un_minut_en_ms > lastCheckScanProcessCaducades) {
      lastCheckScanProcessCaducades = now;
      Map<Long, ScanWebConfigTester> keysToDelete = new HashMap<Long, ScanWebConfigTester>();

      Set<Long> ids = scanWebConfigMap.keySet();
      for (Long id : ids) {
        ScanWebConfigTester ss = scanWebConfigMap.get(id);
        if (now > ss.getExpiryTransaction()) {
          keysToDelete.put(id, ss);
          SimpleDateFormat sdf = new SimpleDateFormat();
          log.info("Tancant ScanWebConfig amb ID = " + id + " a causa de que està caducat "
              + "( ARA: " + sdf.format(new Date(now)) + " | CADUCITAT: "
              + sdf.format(new Date(ss.getExpiryTransaction())) + ")");
        }
      }

      if (keysToDelete.size() != 0) {
        synchronized (scanWebConfigMap) {

          for (Entry<Long, ScanWebConfigTester> pss : keysToDelete.entrySet()) {
            closeScanWebProcess(request, pss.getKey(), pss.getValue());
          }
        }
      }
    }

    return scanWebConfigMap.get(scanWebID);
  }

  @Override
  public void startScanWebProcess(ScanWebConfigTester scanWebConfig) {
    final long scanWebID = scanWebConfig.getScanWebID();
    synchronized (scanWebConfigMap) {
      scanWebConfigMap.put(scanWebID, scanWebConfig);
    }

  }
  
  
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

}
