package es.caib.digitalib.back.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.plugins.scanweb.api.ScanWebStatus;
import org.fundaciobit.plugins.scanweb.api.ScannedDocument;
import org.fundaciobit.plugins.scanweb.api.ScannedPlainFile;
import org.fundaciobit.pluginsib.core.utils.ISO8601;
import org.fundaciobit.pluginsib.core.utils.Metadata;
import org.fundaciobit.pluginsib.core.utils.MetadataConstants;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.hash.Hashing;

import es.caib.digitalib.back.controller.all.FirmaArxiuParametersPublicController;
import es.caib.digitalib.back.controller.all.ScanWebProcessControllerPublic;
import es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1.SplitPdf;
import es.caib.digitalib.back.controller.user.ScanWebProcessControllerUser;
import es.caib.digitalib.jpa.FitxerJPA;
import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.AuditoriaLogicaLocal;
import es.caib.digitalib.logic.FitxerLogicaLocal;
import es.caib.digitalib.logic.MetadadaLogicaLocal;
import es.caib.digitalib.logic.PluginArxiuLogicaLocal;
import es.caib.digitalib.logic.PluginDocumentCustodyLogicaLocal;
import es.caib.digitalib.logic.PluginFirmaEnServidorLogicaLocal;
import es.caib.digitalib.logic.PluginScanWebLogicaLocal;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.ScanWebUtils;
import es.caib.digitalib.model.bean.FitxerBean;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.TransaccioMultiple;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Constants;

/**
 *
 * @author anadal
 */
public abstract class AbstractScanWebProcessController {

  private static final String SCANWEB_CONTEXTPATH_FINAL = "/final";

  private static final String SCANWEB_CONTEXTPATH_ESPERA = "/wait";

  public static final String SCANWEB_CONTEXTPATH_UPDATE_MASSIVE = "/updatemassive";
  
  public static final String SCANWEB_CONTEXTPATH_WAIT_MASSIVE = "/waitmassive";
  
  public static final String SCANWEB_CONTEXTPATH_RETURNTOORIGEN_MASSIVE = "/returnmassive";

  public static final String SESSION_URL_TO_SELECT_SCANWEB_MODULE = "SESSION_URL_TO_SELECT_SCANWEB_MODULE";

  public static final String SESSION_MASIVE_POINTER_POST_SCAN = "SESSION_MASIVE_POINTER_POST_SCAN";  
  
  

  protected final Logger log = Logger.getLogger(this.getClass());

  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
  protected ScanWebModuleLocal scanWebModuleEjb;

  @EJB(mappedName = FitxerLogicaLocal.JNDI_NAME)
  protected FitxerLogicaLocal fitxerEjb;

  @EJB(mappedName = PluginScanWebLogicaLocal.JNDI_NAME)
  protected PluginScanWebLogicaLocal pluginScanWebLogicaEjb;

  @EJB(mappedName = PluginFirmaEnServidorLogicaLocal.JNDI_NAME)
  protected PluginFirmaEnServidorLogicaLocal pluginFirmaServidorLogicaEjb;

  @EJB(mappedName = PluginDocumentCustodyLogicaLocal.JNDI_NAME)
  protected PluginDocumentCustodyLogicaLocal pluginDocumentcustodyLogicaEjb;

  @EJB(mappedName = PluginArxiuLogicaLocal.JNDI_NAME)
  protected PluginArxiuLogicaLocal pluginArxiuLogicaEjb;

  @EJB(mappedName = AuditoriaLogicaLocal.JNDI_NAME)
  protected AuditoriaLogicaLocal auditoriaLogicaEjb;

  @EJB(mappedName = MetadadaLogicaLocal.JNDI_NAME)
  protected MetadadaLogicaLocal metadadaLogicaEjb;
  
  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;
  
  

  public static String getFinalURL(String baseURL, String transactionWebID, boolean isPublic) {
    String cp = isPublic ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH
        : ScanWebProcessControllerUser.CONTEXTWEB;
    return baseURL + cp + SCANWEB_CONTEXTPATH_ESPERA + "/" + transactionWebID;
  }

  @RequestMapping(value = SCANWEB_CONTEXTPATH_ESPERA + "/{transactionWebID}")
  public ModelAndView esperaProcesDeScanWebController(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transactionWebID") String transactionWebID)
      throws Exception, I18NException {

    String cp = isPublic() ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH
        : ScanWebProcessControllerUser.CONTEXTWEB;
    String finalURL = cp + SCANWEB_CONTEXTPATH_FINAL + "/" + transactionWebID;
    
    Long transMultipleID = transaccioLogicaEjb.executeQueryOne(TransaccioFields.TRANSACCIOMULTIPLEID, TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));

    ModelAndView mav;

    mav = new ModelAndView(isPublic() ? "public_wait" : "wait");
    mav.addObject("finalURL", finalURL);
    
    if (transMultipleID == null) {
         // Peticio Senzilla
      mav.addObject("missatgeespera", "esperarfirmacustodia");
    } else {
      // Peticio Multiple
      mav.addObject("missatgeespera", "esperarcercaseparadors");
    }
    return mav;

  }

  @RequestMapping(value = SCANWEB_CONTEXTPATH_FINAL + "/{transactionWebID}")
  public final ModelAndView finalProcesDeScanWebController(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transactionWebID") String transactionWebID)
      throws Exception, I18NException {

    return finalProcesDeScanWeb(request, transactionWebID);

  }

  @SuppressWarnings("deprecation")
  protected ModelAndView finalProcesDeScanWeb(HttpServletRequest request,
      String transactionWebID) throws I18NException, Exception {
    final boolean debug = log.isDebugEnabled();

    log.info("XYZ ZZZ finalProcesDeScanWeb():: [transactionWebID] = " + transactionWebID);

    if (debug) {
      log.debug(" ===finalProcesEscaneig() ==> scanWebID: " + transactionWebID);
    }

    TransaccioJPA transaccio = null;
    {

      transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
      if (transaccio == null) {
        throw new Exception(I18NUtils.tradueix("transaccio.noexisteix", transactionWebID));
      }

      // if (transaccio.getEstatcodi() < 0) {
      // // XYZ ZZZ ZZZ
      // String msg = "La transacció amb ID " + transactionWebID +
      // " te un estat no vàlid ("
      // + transaccio.getEstatcodi() +
      // ") per iniciar el proces d'escaneig.";
      // throw new Exception(msg);
      // }
    }

    ScanWebConfig swc;
    swc = scanWebModuleEjb.getScanWebConfig(request, transactionWebID);
    // ScanWebStatus scanWebStatus = swc.getStatus();

    int status = swc.getStatus().getStatus();

    // Auditoria
    final boolean isApp = isPublic();
    {
      final String msg = I18NUtils.tradueix("scanwebprocess.scan.proces.ok",
          String.valueOf(status));
      final int auditType = Constants.AUDIT_TYPE_FINISH_SCAN;
      String additionalInfo = scanCodeToString(status, swc);
      auditoriaLogicaEjb.audita(transaccio, msg, additionalInfo, auditType, isApp);

    }

    switch (status) {
      case ScanWebStatus.STATUS_FINAL_OK:
      case ScanWebStatus.STATUS_IN_PROGRESS: {
        // Comprovam que s'hagin escanejat coses

        List<ScannedDocument> listDocs = swc.getScannedFiles();

        if (listDocs.size() == 1) {

          Map<Long, FitxerEscanejatInfo> infos = processScannedFile(request, transactionWebID,
              transaccio, swc, listDocs);

          if (transaccio.getTransaccioMultipleID() == null) {
            // Procés simple
            
            log.info("\n\n XYZ ZZZ  Escaneig Simple FS: " + transaccio.getFitxerEscanejat() + "\n\n");
            
            procesDeFirmaCustodia(request, infos, transaccio.getPerfil().getUsPerfil());
            
            
            log.info("\n\n XYZ ZZZ  FINAL Escaneig Simple: STATUS[ " + transaccio.getEstatCodi() + "] \n\n");
            
          } else {
            
            log.info("\n\n XYZ ZZZ  Escaneig MASSIU: #subdocs " + infos.size() + " \n\n");
            
            // Procés massiu: demanar informacio per cada subfitxer
            String cp = isPublic() ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH
                : ScanWebProcessControllerUser.CONTEXTWEB;
            String massiveInfo = cp + SCANWEB_CONTEXTPATH_UPDATE_MASSIVE + "/"
                + transaccio.getTransaccioMultipleID();

            return new ModelAndView(new RedirectView(massiveInfo, true));
          }

        } else {

          transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
          if (listDocs.size() == 0) {
            transaccio.setEstatMissatge(I18NUtils.tradueix("scanwebprocess.scan.fitxer.no"));
          } else {
            transaccio
                .setEstatMissatge(I18NUtils.tradueix("scanwebprocess.scan.fitxer.molts"));
          }
        }
      }
      break;

      case ScanWebStatus.STATUS_FINAL_ERROR: {
        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio.setEstatMissatge(swc.getStatus().getErrorMsg());
        // transaccio.setEstatExcepcio(swc.getStatus().getErrorException());
      }
      break;

      case ScanWebStatus.STATUS_CANCELLED: {
        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_CANCELLED);
        transaccio.setEstatMissatge(swc.getStatus().getErrorMsg());
        if (transaccio.getEstatMissatge() == null) {
          transaccio.setEstatMissatge(I18NUtils.tradueix("plugindescan.cancelat"));
        }
      }
      break;

      default: {
        String inconsistentState = I18NUtils
            .tradueix("scanwebprocess.scan.proces.error.desconegut", String.valueOf(status));
        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio.setEstatMissatge(inconsistentState);
        transaccio.setEstatExcepcio(new Exception().toString()); // XYZ
        // ZZZ
      }
    }

    // String languageUI = transaccio.getLanguageui();
    
    log.info("XYZ ZZZ finalProcesDeScanWeb  STATUS => " + transaccio.getEstatCodi());
    

    if (transaccio.getEstatCodi() != ScanWebStatus.STATUS_FINAL_OK) {

      if (transaccio.getEstatMissatge() == null) {
        transaccio.setEstatMissatge(
            I18NUtils.tradueix("scanwebprocess.transaccio.missatge.error.desconegut"));
      }

      final String msg = I18NUtils.tradueix("scanwebprocess.scan.proces.digitalitzacio.error",
          String.valueOf(status));
      final int auditType = Constants.AUDIT_TYPE_ANY_ACTION_OVER_TRANSACTION;
      final String additionalInfo = I18NUtils.tradueix(
          "scanwebprocess.scan.proces.error.missatge", transaccio.getEstatMissatge());
      // XYZ ZZZ falta afegir Excepció sense superar el 300 caracters

      auditoriaLogicaEjb.audita(transaccio, msg, additionalInfo, auditType, isApp);

    }

    transaccio.setDataFi(new Timestamp(System.currentTimeMillis()));
    transaccioLogicaEjb.update(transaccio);

    return returnToOrigen(transaccio);
  }

  protected Map<Long, FitxerEscanejatInfo> processScannedFile(HttpServletRequest request,
      String transactionWebID, TransaccioJPA transaccio, ScanWebConfig swc,
      List<ScannedDocument> listDocs) throws I18NException {
    {

      // Recollir Metadades del PLugin
      List<Metadata> metadades = swc.getScannedFiles().get(0).getMetadatas();
      if (metadades != null) {
        log.info("XYZ ZZZ   Metadades transacció " + transaccio.getTransaccioID());

        for (Metadata metadata : metadades) {
          final String name = metadata.getKey();
          final String value = metadata.getValue();

          log.info("XYZ ZZZ   Metadada[" + name + "] => " + value);

          if (MetadataConstants.PAPER_SIZE.equals(name)) {
            transaccio.setInfoScanPaperSize(value);
          } else if (MetadataConstants.OCR.equals(name)) {
            if ("true".equalsIgnoreCase(value)) {
              transaccio.setInfoScanOcr(true);
            } else if ("false".equalsIgnoreCase(value)) {
              transaccio.setInfoScanOcr(false);
            } else {
              transaccio.setInfoScanOcr(null);
            }
          } else if (MetadataConstants.FUNCTIONARY_FULLNAME.equals(name)) {
            if (isEmpty(transaccio.getSignParamFuncionariNom())) {
              transaccio.setSignParamFuncionariNom(value);
            }
          } else if (MetadataConstants.FUNCTIONARY_USERNAME.equals(name)) {
            if (isEmpty(transaccio.getFuncionariUsername())) {
              transaccio.setFuncionariUsername(value);
            }
          } else if (MetadataConstants.FUNCTIONARY_ADMINISTRATIONID.equals(name)) {
            if (isEmpty(transaccio.getSignParamFuncionariNif())) {
              transaccio.setSignParamFuncionariNif(value);
            }
          } else if (MetadataConstants.EEMGDE_RESOLUCION.equals(name)) {
            try {
              transaccio.setInfoScanResolucioPpp(Integer.valueOf(value));
            } catch (NumberFormatException nfe) {
              log.error("Error processant Resolution: " + name + " => ]" + value + "[", nfe);
            }

          } else if (MetadataConstants.EEMGDE_PROFUNDIDAD_COLOR.equals(name)) {
            try {
              int bits = Integer.valueOf(value);
              if (bits == 8) {
                transaccio
                    .setInfoScanPixelType(MetadataConstants.ProfundidadColorConstants.GRAY);
              } else if (bits < 8) {
                transaccio
                    .setInfoScanPixelType(MetadataConstants.ProfundidadColorConstants.BW);
              } else {
                transaccio
                    .setInfoScanPixelType(MetadataConstants.ProfundidadColorConstants.COLOR);
              }
            } catch (NumberFormatException nfe) {
              log.error("Error processant PixelType: " + name + " => ]" + value + "[", nfe);
            }
          } else if (MetadataConstants.ENI_TIPO_DOCUMENTAL.equals(name)) {

            if (transaccio.getArxiuReqParamDocumentTipus() == null) {
              transaccio.setArxiuReqParamDocumentTipus(value);
            }
          } else if (MetadataConstants.ENI_IDIOMA.equals(name)
              || MetadataConstants.EEMGDE_IDIOMA.equals(name)) {

            if (transaccio.getSignParamLanguageDoc() == null) {
              transaccio.setSignParamLanguageDoc(value);
            }
          } else if (MetadataConstants.ENI_FECHA_INICIO.equals(name)) {
            // DATA CAPTURA
            try {
              Date data = ISO8601.ISO8601ToDate(value);
              transaccio.setInfoScanDataCaptura(new Timestamp(data.getTime()));
            } catch (ParseException e) {
              log.error(
                  "Error processant DataCaptura(FechaInicio): " + name + " => ]" + value + "[",
                  e);
            }

          } else {
            // afegir a taula de metadades
            metadadaLogicaEjb.create(transaccio.getTransaccioID(), name, value);
          }
        }
      }

      // TOTS HO EXECUTEN AIXÒ
      Map<Long, FitxerEscanejatInfo> infos = recuperarDocumentEscanejat(transaccio, listDocs);

      return infos;

    }
  }

  protected void procesDeFirmaCustodia(HttpServletRequest request,
      Map<Long, FitxerEscanejatInfo> infos, int usPerfil) throws I18NException {

    List<TransaccioJPA> transaccions = new ArrayList<TransaccioJPA>(infos.size());

    for (FitxerEscanejatInfo info : infos.values()) {
      transaccions.add(info.transaccio);
    }

    procesDeFirmaCustodia(request, transaccions, usPerfil);

  }

  protected void procesDeFirmaCustodia(HttpServletRequest request,
      List<TransaccioJPA> transaccions, int usPerfil) throws I18NException {
    String transactionWebID;

    for (TransaccioJPA transaccio : transaccions) {

      // TransaccioJPA transaccio = info.transaccio;

      Fitxer fitxer = transaccio.getFitxerEscanejat();
          
      log.info("\n\n XYZ ZZZ   Fitxer Escanejat: " + fitxer + "  ||   TRANSACCIO: " + transaccio.getTransaccioID() +  "\n\n");

      transactionWebID = transaccio.getTransactionWebId();

      switch (usPerfil) {

        default:
        case Constants.PERFIL_US_NOMES_ESCANEIG_INFO: {

          scanWebModuleEjb.closeScanWebProcess(request, transactionWebID);
          if (fitxer == null) {
             log.error("Per alguna causa desconeguda el fitxer escanejat val NULL (Escaneig)");
          } else {
            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);
          }
        }
        break;

        case Constants.PERFIL_US_COPIA_AUTENTICA_INFO: {

          scanWebModuleEjb.closeScanWebProcess(request, transactionWebID);
          if (fitxer == null) {
            log.error("Per alguna causa desconeguda el fitxer escanejat val NULL (Escaneig + Firma)");
          } else {
            Fitxer fitxerFirmat = firmarFitxer(transaccio, fitxer);
            if (fitxerFirmat != null) {
              transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);
            }
          }
        }
        break;

        case Constants.PERFIL_US_CUSTODIA_INFO: {

          scanWebModuleEjb.closeScanWebProcess(request, transactionWebID);

          if (fitxer == null) {
            log.error("Per alguna causa desconeguda el fitxer escanejat val NULL (Escaneig + Firma + Custòdia)");
          } else {
            Fitxer fitxerFirmat = firmarFitxer(transaccio, fitxer);

            if (fitxerFirmat != null) {
              // XYZ ZZZ Aqui falta CUSTODIA
              // NOMES CUSTODIA
              InfoCustodyJPA infoCustodyJPA = custodia(transaccio, fitxerFirmat);

              if (infoCustodyJPA != null) {
                transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);
              }

            }
          }
        }
        break;
      }; // Final switch
      
      
      transaccioLogicaEjb.update(transaccio);
      
      
    }; // Final For
  }

  protected ModelAndView returnToOrigen(TransaccioJPA transaccio) throws I18NException {
    String urlRetorn = transaccio.getReturnUrl();
    ModelAndView mav;
    if (transaccio.getView() == ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN) {
      // Simple REDIRECCIO

      log.info("XYZ ZZZ ZZZZZ\n\n SIMPLE REDIRECCIO = " + urlRetorn);

      mav = new ModelAndView(new RedirectView(urlRetorn, false));

    } else {
      // Sortir de IFRAME

      log.info("XYZ ZZZ ZZZZZ\n\n Sortir de IFRAME = " + urlRetorn);
      mav = new ModelAndView(isPublic() ? "public_finalsortiriframe" : "finalsortiriframe");
      mav.addObject("urlRetorn", urlRetorn);
    }

    return mav;
  }

  public static boolean isEmpty(String str) {
    return str == null || str.trim().length() == 0;
  }

  /**
   * 
   * @param status
   * @param swc
   * @return
   */
  protected String scanCodeToString(int status, ScanWebConfig swc) {

    final String additionalInfo;
    switch (status) {
      case ScanWebStatus.STATUS_FINAL_OK:
        additionalInfo = I18NUtils.tradueix("scanwebprocess.scan.estat.ok");
      break;
      case ScanWebStatus.STATUS_IN_PROGRESS:
        additionalInfo = I18NUtils.tradueix("scanwebprocess.scan.estat.progres");
      break;

      case ScanWebStatus.STATUS_FINAL_ERROR:
        additionalInfo = I18NUtils.tradueix("scanwebprocess.scan.estat.error") + "\nError: "
            + swc.getStatus().getErrorMsg();
      // XYZ ZZZ Afegir Excepció si no val null. Controlar que no superi màxim

      break;
      case ScanWebStatus.STATUS_CANCELLED:
        additionalInfo = I18NUtils.tradueix("scanwebprocess.scan.estat.cancelat");
      break;

      case ScanWebStatus.STATUS_INITIALIZING:
        additionalInfo = I18NUtils.tradueix("scanwebprocess.scan.estat.inicialitzant");
      break;

      default:
        additionalInfo = I18NUtils.tradueix("scanwebprocess.scan.estat.desconegut");
      break;
    }

    return additionalInfo;
  }

  /**
   * 
   * @author anadal (u80067)
   *
   */
  public static class FitxerEscanejatInfo {

    protected final TransaccioJPA transaccio;

    protected final Fitxer fitxer;

    protected final File dataFile;

    protected final byte[] dataByteArray;

    public FitxerEscanejatInfo(TransaccioJPA transaccio, Fitxer fitxer, File dataFile) {
      super();
      this.transaccio = transaccio;
      this.fitxer = fitxer;
      this.dataFile = dataFile;
      this.dataByteArray = null;
    }

    public FitxerEscanejatInfo(TransaccioJPA transaccio, Fitxer fitxer, byte[] dataByteArray) {
      super();
      this.transaccio = transaccio;
      this.fitxer = fitxer;
      this.dataFile = null;
      this.dataByteArray = dataByteArray;
    }

    /*
     * public InputStream getInputStream() throws Exception {
     * 
     * if (dataFile != null) { return new FileInputStream(this.dataFile); } else if
     * (this.dataByteArray != null) { return new ByteArrayInputStream(this.dataByteArray); }
     * else { // XYZ ZZZZ return null; }
     * 
     * }
     */

  }

  /**
   * 
   * @param transaccio
   * @param listDocs
   * @return
   */
  public Map<Long, FitxerEscanejatInfo> recuperarDocumentEscanejat(
      TransaccioJPA transaccioOriginal, List<ScannedDocument> listDocs) throws I18NException {

    Map<Long, FitxerEscanejatInfo> allFiles = new TreeMap<Long, AbstractScanWebProcessController.FitxerEscanejatInfo>();
    {
      ScannedDocument sd = listDocs.get(0);

      ScannedPlainFile scannedFile = sd.getScannedPlainFile();

      byte[] data = scannedFile.getData();

      if (transaccioOriginal.getTransaccioMultipleID() == null) {

        // ES UNA TRANSACCIO SIMPLE
        log.info("XYZ ZZZ ZZZZZ\n\n recuperarDocumentEscanejat::ES UNA TRANSACCIO SIMPLE ");

        FitxerJPA fitxer = new FitxerJPA("", scannedFile.getMime(), scannedFile.getName(),
            data.length);
        
        fitxer = (FitxerJPA)fitxerEjb.create(fitxer);

        final long fileID = fitxer.getFitxerID();

        FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fileID);

        transaccioOriginal.setFitxerEscanejatID(fileID);
        
        transaccioLogicaEjb.update(transaccioOriginal);
        
        log.info("XYZ ZZZ SIMPLE  PRIMER FITXER : " + fitxer + " Per transaccio " + transaccioOriginal.getTransaccioID());
        
        transaccioOriginal.setFitxerEscanejat(fitxer);

        allFiles.put(transaccioOriginal.getTransaccioID(),
            new FitxerEscanejatInfo(transaccioOriginal, fitxer, data));

      } else {

        // TRANSACCIO MASSIVA
        log.info("XYZ ZZZ ZZZZZ\n\n recuperarDocumentEscanejat::ES UNA TRANSACCIO MASSIVA ");

        // Split del document !!!!!
        File destDir = new File(FileSystemManager.getFilesPath(), "MASSIVE_TRANSACCTIONS");
        destDir.mkdirs();
        File[] fitxers;
        try {
          fitxers = SplitPdf.detectPagesWithQR(destDir, data,
              transaccioOriginal.getTransaccioID() + "_"
                  + transaccioOriginal.getTransactionWebId());
        } catch (Exception e) {
          String msg = "Error desconegut fent Split del document: " + e.getMessage();
          log.error(msg, e);
          throw new I18NException("comodi", msg);
        }
        
        
        log.info("XYZ ZZZ ZZZZZ\n\n recuperarDocumentEscanejat:: subFitxer despres de SPLIT => " + fitxers.length);

        {
          // Moure fitxer escanejat a Transaccio Multiple

          TransaccioMultiple tm = transaccioLogicaEjb.findTransaccioMultipleByPrimaryKey(transaccioOriginal.getTransaccioMultipleID());

          Fitxer fitxer = new FitxerBean("", scannedFile.getMime(), scannedFile.getName(),
              data.length);

          fitxer = fitxerEjb.create(fitxer);

          tm.setFitxerEscanejatID(fitxer.getFitxerID());
          tm.setDescripcio(transaccioOriginal.getNom());
          
          transaccioLogicaEjb.updateTransaccioMultiple(tm);

          FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fitxer.getFitxerID());

        }
      

        for (int i = 0; i < fitxers.length; i++) {

          if (i == 0) {
            // El primer fitxer el posam dins la transaccio original
            File file = fitxers[i];

            FitxerJPA fitxer = new FitxerJPA("", "application/pdf", fitxers[i].getName(),
                fitxers[i].length());
            fitxer = (FitxerJPA)fitxerEjb.create(fitxer);

            final long fileID = fitxer.getFitxerID();

            FileSystemManager.sobreescriureFitxer(file, fileID);

            transaccioOriginal.setFitxerEscanejatID(fileID);
            
            transaccioLogicaEjb.update(transaccioOriginal);
            
            log.info("XYZ ZZZ  PRIMER FITXER : " + fitxer + " Per transaccio " + transaccioOriginal.getTransaccioID());
            
            transaccioOriginal.setFitxerEscanejat(fitxer);

            FitxerEscanejatInfo fei = new FitxerEscanejatInfo(transaccioOriginal, fitxer,
                FileSystemManager.getFile(fitxer.getFitxerID()));

            allFiles.put(transaccioOriginal.getTransaccioID(), fei);

          } else {

            // clonar transaccioOriginal
            TransaccioJPA transaccio = TransaccioJPA.toJPA(transaccioOriginal);

            // fer nou fitxer
            FitxerJPA fitxer = new FitxerJPA("", "application/pdf", fitxers[i].getName(),
                fitxers[i].length());

            fitxer = (FitxerJPA)fitxerEjb.create(fitxer);

            final long fileID = fitxer.getFitxerID();

            FileSystemManager.sobreescriureFitxer(fitxers[i], fileID);

            transaccio.setTransaccioID(0);
            transaccio.setFitxerEscanejatID(fileID);
            
            transaccio.setTransactionWebId(transaccioLogicaEjb.generateTransactionWebID());
                       
            
            String hashEscaneig = Hashing.sha256()
                .hashString(String.valueOf(fileID),
                    Charset.forName("UTF-8"))
                .toString();

            transaccio.setHashEscaneig(hashEscaneig);
            

            // crear transaccio
            transaccio = (TransaccioJPA) transaccioLogicaEjb.create(transaccio);
            
            transaccio.setFitxerEscanejat(fitxer);
            transaccio.setPerfil(transaccioOriginal.getPerfil());


            FitxerEscanejatInfo fei = new FitxerEscanejatInfo(transaccio, fitxer,
                FileSystemManager.getFile(fileID));

            allFiles.put(transaccio.getTransaccioID(), fei);

          }

        }

      }

    }

    /*
    for (Map.Entry<Long, FitxerEscanejatInfo> entry : allFiles.entrySet()) {

      FitxerEscanejatInfo fei = entry.getValue();
      TransaccioJPA transaccio = fei.transaccio;

      try {
        Fitxer f = fitxerEjb.create(fei.fitxer);

        if (fei.dataFile != null) {
          FileSystemManager.sobreescriureFitxer(fei.dataFile, f.getFitxerID());
        } else if (fei.dataByteArray != null) {
          FileSystemManager.crearFitxer(new ByteArrayInputStream(fei.dataByteArray),
              f.getFitxerID());
        } else {
          // XYZ ZZZ
          throw new I18NException("comodi", "No trobam dades per la transacció "
              + transaccio.getTransaccioID() + "(" + transaccio.getNom() + ")");
        }

        transaccio.setFitxerEscanejatID(f.getFitxerID());
        String hashEscaneig = Hashing.sha256()
            .hashString(String.valueOf(transaccio.getFitxerEscanejatID()),
                Charset.forName("UTF-8"))
            .toString();

        transaccio.setHashEscaneig(hashEscaneig);

      } catch (I18NException e) {

        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio
            .setEstatMissatge(I18NUtils.tradueix("scanwebprocess.scan.fitxer.recuperar.error")
                + I18NUtils.getMessage(e));
        transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));

      }
    }
    */

    return allFiles;

  }



  protected InfoCustodyJPA custodia(TransaccioJPA transaccio, Fitxer fitxerFirmat) {

    PerfilJPA perfil = transaccio.getPerfil();

    log.info(" XYZ ZZZ AbstractScanWebProcessController:custodia():: PERFIL = " + perfil);

    int tipus = perfil.getTipusCustodia();

    log.info(
        " XYZ ZZZ AbstractScanWebProcessController:custodia():: TIPUS CUSTODIA = " + perfil);

    Locale locale = new Locale(transaccio.getLanguageUI());

    String tipusStr = (tipus == Constants.TIPUS_CUSTODIA_ARXIU
        ? I18NUtils.tradueix("scanwebprocess.scan.arxiu")
        : I18NUtils.tradueix("scanwebprocess.scan.custodia"));

    final boolean isApp = isPublic();

    final int auditType = Constants.AUDIT_TYPE_CUSTODY_INFO;
    String[] users;
    {
      final String msg = I18NUtils.tradueix("scanwebprocess.scan.inici") + tipusStr;
      final String additionalInfo = null;
      users = auditoriaLogicaEjb.audita(transaccio, msg, additionalInfo, auditType, isApp);
    }

    InfoCustodyJPA infoCust;
    if (tipus == Constants.TIPUS_CUSTODIA_ARXIU) {
      // throw new Exception();

      infoCust = pluginArxiuLogicaEjb.custodiaAmbApiArxiu(transaccio, fitxerFirmat, locale);

    } else {

      infoCust = pluginDocumentcustodyLogicaEjb.custodiaAmbApiDocumentCustody(transaccio,
          fitxerFirmat, locale);
    }

    {
      final String additionalInfo;
      String msg = I18NUtils.tradueix("scanwebprocess.scan.final") + tipusStr + ": ";
      if (infoCust == null) {
        msg = msg + "ERROR";
        additionalInfo = null;
      } else {
        msg = msg + "OK";
        additionalInfo = "CSV: " + infoCust.getCsv() + "\n" + "CustodyID: "
            + infoCust.getCustodyId() + "\n" + "ExpedientID: " + infoCust.getArxiuExpedientId()
            + "\n" + "DocumentID: " + infoCust.getArxiuDocumentId() + "\n"
            + "getCsvValidationWeb: " + infoCust.getCsvValidationWeb() + "\n"
            + "getCsvGenerationDefinition: " + infoCust.getCsvGenerationDefinition() + "\n"
            + "originalFileURL: " + infoCust.getOriginalFileUrl() + "\n" + "printableFileURL: "
            + infoCust.getPrintableFileUrl() + "\n" + "ENIFileURL: " + infoCust.getEniFileUrl()
            + "\n" + "ValidationFileUrl: " + infoCust.getValidationFileUrl();
      }
      auditoriaLogicaEjb.audita(transaccio, isApp, msg, additionalInfo, auditType, users[0],
          users[1]);
    }

    return infoCust;

  }

  protected Fitxer firmarFitxer(TransaccioJPA transaccio, Fitxer fitxer) {

    PerfilJPA perfil =  transaccio.getPerfil();

    log.info(
        " XYZ ZZZ AbstractScanWebProcessController:firmarFitxer():: PERFIL PRE = " + perfil);

    final boolean isApiFirmaSimple = (perfil
        .getTipusFirma() == Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE);

    final boolean isApp = isPublic();
    final String additionalInfo = null;
    final int auditType = Constants.AUDIT_TYPE_SIGN_INFO;
    String[] users;
    {
      final String msg = I18NUtils.tradueix("scanwebprocess.scan.inici.firma",
          (isApiFirmaSimple ? "Api Firma Simple" : "Api Firma en Servidor"));
      users = auditoriaLogicaEjb.audita(transaccio, msg, additionalInfo, auditType, isApp);
    }

    Fitxer fitxerSignat;

    if (isApiFirmaSimple) {
      // throw new Exception();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio
          .setEstatMissatge(I18NUtils.tradueix("scanwebprocess.scan.firmasimple.suportat.no"));

      final String msg = I18NUtils.tradueix("scanwebprocess.scan.firmasimple.suportat.no");
      auditoriaLogicaEjb.audita(transaccio, isApp, msg, additionalInfo, auditType, users[0],
          users[1]);

      fitxerSignat = null;

    } else {

      fitxerSignat = pluginFirmaServidorLogicaEjb.firmarFitxerAmbApiFirmaEnServidor(transaccio,
          fitxer, LocaleContextHolder.getLocale(), users[0], users[1]);
    }

    {
      final String msg = "Final Procés de Firma: " + (fitxerSignat == null ? "ERROR" : "OK");
      auditoriaLogicaEjb.audita(transaccio, isApp, msg, additionalInfo, auditType, users[0],
          users[1]);
    }

    log.info(
        " XYZ ZZZ AbstractScanWebProcessController:firmarFitxer():: PERFIL POST = " + perfil);

    return fitxerSignat;

  }

  public abstract boolean isPublic();

  public static class UrlSelectScanModule {

    final long startDate;

    final String urlToSelectPluginPage;

    public UrlSelectScanModule(String urlToSelectPluginPage) {
      super();
      this.startDate = System.currentTimeMillis();
      this.urlToSelectPluginPage = urlToSelectPluginPage;
    }

  }

  public static final Map<Long, UrlSelectScanModule> transID2Url = new HashMap<Long, UrlSelectScanModule>();

  /**
   * 
   * @param request
   * @param view
   * @param scanWebConfig
   * @return
   * @throws Exception
   */
  public ModelAndView startScanWebProcess(HttpServletRequest request,
      HttpServletResponse response, TransaccioJPA transaction, boolean isPublic,
      String urlFinal, String urlBase) throws Exception, I18NException {

    // final int tipusPerfil = transaction.getPerfil().getUsPerfil();

    final boolean fullView = (transaction
        .getView() == ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN);

    final String contextWeb = AbstractScanWebModuleController.getContextWeb(isPublic);

    final String viewModel = isPublic ? "public_plugindescan_contenidor"
        : "plugindescan_contenidor";
    final String scanWebID = transaction.getTransactionWebId();

    ScanWebConfig scanWebConfig = ScanWebUtils.generateScanWebConfig(transaction, urlFinal);

    scanWebModuleEjb.startScanWebProcess(scanWebConfig);

    final String urlToSelectPluginPage = urlBase + contextWeb + "/selectscanwebmodule/"
        + scanWebID;
    
    
    request.getSession().removeAttribute(SESSION_MASIVE_POINTER_POST_SCAN);
    

    ModelAndView mav = new ModelAndView(viewModel);
    mav.addObject("scanWebID", scanWebID);

    request.getSession().setAttribute(SESSION_URL_TO_SELECT_SCANWEB_MODULE,
        urlToSelectPluginPage);

    // if (log.isDebugEnabled())
    { // XYZ ZZZ
      log.info(" SET SESSION_URL_TO_SELECT_SCANWEB_MODULE => " + urlToSelectPluginPage);
      log.info(" getTransaccioID => " + transaction.getTransaccioID());
    }

    synchronized (transID2Url) {
      transID2Url.put(transaction.getTransaccioID(),
          new UrlSelectScanModule(urlToSelectPluginPage));
    }

    final String urlToRequestFirmaArxiuParameters = urlBase
        + (isPublic ? AbstractFirmaArxiuParametersController.CONTEXTWEB_PUBLIC
            : AbstractFirmaArxiuParametersController.CONTEXTWEB_USER)
        + "/" + transaction.getTransaccioID() + "/edit";

    mav.addObject("urlToSelectPluginPage", urlToRequestFirmaArxiuParameters);

    mav.addObject("fullView", fullView);

    return mav;
  }

  // ----------------------------------------------------------------
  // ---------------- MASSIU ---------------------------------------

  @RequestMapping(value = SCANWEB_CONTEXTPATH_UPDATE_MASSIVE
      + "/{transaccioMultipleID}", method = RequestMethod.GET)
  public ModelAndView demanarInformacioPeticioMassivaGet(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transaccioMultipleID") Long transaccioMultipleID)
      throws Exception, I18NException {
    /*  XYZ ZZZ
     * String cp = isPublic() ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH :
     * ScanWebProcessControllerUser.CONTEXTWEB; String finalURL = cp +
     * SCANWEB_CONTEXTPATH_FINAL + "/" + transactionWebID;
     */
    List<TransaccioJPA> transaccions = transaccioLogicaEjb.searchMassiveTransaccioByTransaccioMultipleID(transaccioMultipleID);

    //String submitURL = (isPublic() ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH : ScanWebProcessControllerUser.CONTEXTWEB) +  SCANWEB_CONTEXTPATH_UPDATE_MASSIVE + "/" + transactionWebID;

    Integer pos = (Integer)request.getSession().getAttribute(SESSION_MASIVE_POINTER_POST_SCAN);
    
    
    if (pos == null) {
      
      log.info(" XYZ ZZZ  demanarInformacioPeticioMassivaGet:: PRIMERA ENTRADA ");
      pos = 0;
      
    } else {
      
      int next = pos + 1;
      if (next >= transaccions.size()) {
        
        
        log.info(" XYZ ZZZ  demanarInformacioPeticioMassivaGet:: DARRERA ENTRADA ");
        
        // ANAR A WAIT DE MASSIVE
        String waitUrl = getContextWeb()  + SCANWEB_CONTEXTPATH_WAIT_MASSIVE + "/" + transaccions.get(0).getTransactionWebId();
        ModelAndView mav = new ModelAndView(new RedirectView(waitUrl, true));
        return mav;
      }
      pos = next;
    }
    
    request.getSession().setAttribute(SESSION_MASIVE_POINTER_POST_SCAN, pos);
        
    {   
        String cp = isPublic() ? FirmaArxiuParametersPublicController.CONTEXTWEB_PUBLIC : FirmaArxiuParametersPublicController.CONTEXTWEB_USER;
        String redirect = cp  + "/" + transaccions.get(pos).getTransaccioID() + "/edit" ; 
        
        log.info(" XYZ ZZZ   Redireccionam a " + redirect);
        
        ModelAndView mav = new ModelAndView(new RedirectView(redirect, true));

       // TODO XYZ ZZZ Això necessita un altre vista si suportessim AUTENTICAT
       // mav = new ModelAndView("transaccionsmassives_public");
       // mav.addObject("transaccions", transaccions);

        return mav;

    }

  }

  protected String getContextWeb() {
    
    return isPublic() ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH
        : ScanWebProcessControllerUser.CONTEXTWEB;

  }

  

  @RequestMapping(value = SCANWEB_CONTEXTPATH_WAIT_MASSIVE + "/{transaccioWebID}", method = RequestMethod.GET)
  public ModelAndView finalPeticioMassiva(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transaccioWebID") String transaccioWebID)
      throws Exception, I18NException {
    
    
    String finalMassiveURL = getContextWeb() + SCANWEB_CONTEXTPATH_RETURNTOORIGEN_MASSIVE + "/" + transaccioWebID;
    
    ModelAndView mav;
    mav = new ModelAndView(isPublic() ? "public_wait" : "wait");
    mav.addObject("finalURL", finalMassiveURL);
    mav.addObject("missatgeespera", "esperarfirmacustodia");
    
    return mav;

    

  }
  
  @RequestMapping(value = SCANWEB_CONTEXTPATH_RETURNTOORIGEN_MASSIVE + "/{transaccioWebID}", method = RequestMethod.GET)
  public ModelAndView returnOrigenMassiva(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transaccioWebID") String transaccioWebID)
      throws Exception, I18NException {
    
    List<TransaccioJPA> transaccions = transaccioLogicaEjb.searchMassiveTransaccioByTransactionWebID(transaccioWebID);
    
    //Long perfilID = transaccioLogicaEjb.executeQueryOne(TransaccioFields.PERFILID, TransaccioFields.TRANSACCIOID.equal(transaccioID));
    
    
    // XYZ ZZZ ZZZ  OPTIMITZAR  Cec que transaccions.get(0).getPerfil() funciona !!!!
    
    Perfil perfil = perfilEjb.findByPrimaryKey(transaccions.get(0).getPerfilID());
    
    int usPerfil = perfil.getUsPerfil(); 
    
    procesDeFirmaCustodia(request, transaccions, usPerfil);
    
    for (TransaccioJPA transaccio : transaccions) {
      transaccio.setDataFi(new Timestamp(System.currentTimeMillis()));
      transaccioLogicaEjb.update(transaccio);
    }
    
    return returnToOrigen(transaccions.get(0));
      
  }
  
  /*
  @RequestMapping(value = SCANWEB_CONTEXTPATH_UPDATE_MASSIVE + "/final/{transactionWebID}", method = RequestMethod.POST)
  public ModelAndView demanarInformacioPeticioMassivaFinal(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transactionWebID") String transactionWebID)
      throws Exception, I18NException {
    List<TransaccioJPA> transaccions = transaccioLogicaEjb.searchMassiveTransaccioByTransactionWebID(transactionWebID);

    // XYZ ZZZ ZZZ   FALTA ACTUALITZAR AMB DADES 
    
    
    Perfil perfil = perfilEjb.findByPrimaryKey(transaccions.get(0).getPerfilID());
    
    int usPerfil = perfil.getUsPerfil(); 
    
    procesDeFirmaCustodia(request, transaccions, usPerfil);


    return returnToOrigen(transaccions.get(0));

  }
  */
  

}
