package es.caib.digitalib.back.controller.all;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.scanweb.api.IScanWebPlugin;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.plugins.scanweb.api.ScanWebMode;
import org.fundaciobit.plugins.scanweb.api.ScanWebStatus;
import org.fundaciobit.plugins.scanweb.api.ScannedDocument;
import org.fundaciobit.plugins.scanweb.api.ScannedPlainFile;
import org.fundaciobit.pluginsib.core.utils.Metadata;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStartTransactionRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.ScanWebModuleController;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.FitxerLogicaLocal;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.ScanWebConfigTester;
import es.caib.digitalib.model.bean.FitxerBean;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.utils.Constants;

/**
 *
 * @author anadal
 *
 *
 */
@Controller
@RequestMapping(value = RestScanWebProcessController.SCANWEB_CONTEXTPATH)
public class RestScanWebProcessController {

  public static final String SCANWEB_CONTEXTPATH = "/public/scanweb";

  public static final String SCANWEB_CONTEXTPATH_FINAL = "/final";

  protected final Logger log = Logger.getLogger(this.getClass());

  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
  protected ScanWebModuleLocal scanWebModuleEjb;

  @EJB(mappedName = FitxerLogicaLocal.JNDI_NAME)
  protected FitxerLogicaLocal fitxerEjb;

  @RequestMapping(value = "/start/{transactionWebID}", method = RequestMethod.GET)
  public ModelAndView scanWebStart(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("transactionWebID") String transactionWebID) throws Exception,
      I18NException {

    String languageUI = "ca";

    TransaccioJPA transaccio = null;
    {

      transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
      if (transaccio == null) {
        // XYZ ZZZ ZZZ
        throw new Exception("NO existeix la transacció amb ID " + transactionWebID);
      }

      if (transaccio.getEstatcodi() < 0) {
        // XYZ ZZZ ZZZ
        String msg = "La transacció amb ID " + transactionWebID + " te un estat no vàlid ("
            + transaccio.getEstatcodi() + ") per iniciar el proces d'escaneig.";
        throw new Exception(msg);
      }
    }

    languageUI = transaccio.getLanguageui();

    long expiryTransaction = transaccio.getDatainici().getTime()
        + Constants.EXPIRATION_TIME_MS;

    String urlBase = transaccio.getPerfil().getUrlBase();

    if (urlBase == null || urlBase.trim().length() == 0) {
      urlBase = Configuracio.getAppUrl();
    }

    log.info(" XYZ ZZZ URLBASE = " + urlBase);

    final String urlFinal = urlBase + SCANWEB_CONTEXTPATH + SCANWEB_CONTEXTPATH_FINAL + "/"
        + transactionWebID;

    log.info(" XYZ ZZZ URLFINAL = " + urlBase);

    final String scanType = formatFileToScanWebApi(transaccio.getPerfil()
        .getScanFormatFitxer());

    final Set<String> flags = null; // acceptam la primera configuració disponible del plugin

    // TODO per ara està buit
    final List<Metadata> metadades = new ArrayList<Metadata>();

    // ScanWebMode mode = "S".equals("" + form.getMode()) ? ScanWebMode.SYNCHRONOUS
    // : ScanWebMode.ASYNCHRONOUS;
    final ScanWebMode mode = ScanWebMode.SYNCHRONOUS;

    ScanWebConfigTester swc = new ScanWebConfigTester(transaccio.getTransactionWebId(),
        scanType, flags, metadades, mode, languageUI, urlFinal, expiryTransaction);

    final boolean isPublic = true;
    
    // /WEB-INF/views/plugindescan_contenidor.jsp
    final String view = "public_plugindescan_contenidor";
    ModelAndView mav = ScanWebModuleController.startScanWebProcess(request, view,
        scanWebModuleEjb, swc, urlBase, isPublic);

    // En passarela de firma requerim dins d'un frame
    mav.addObject("fullView",
        transaccio.getView() == ScanWebSimpleStartTransactionRequest.VIEW_FULLSCREEN);

    return mav;

  }

  public static String formatFileToScanWebApi(int formatType) throws I18NException {

    switch (formatType) {

    case Constants.FORMAT_FILE_PDF:
      return IScanWebPlugin.SCANTYPE_PDF; // "pdf";

    case Constants.FORMAT_FILE_JPG:
      return IScanWebPlugin.SCANTYPE_JPG;// "jpg";

    case Constants.FORMAT_FILE_TIFF:
      return IScanWebPlugin.SCANTYPE_TIFF; // "tif";

    case Constants.FORMAT_FILE_PNG:
      return IScanWebPlugin.SCANTYPE_PNG; // "png";

    case Constants.FORMAT_FILE_GIF:
      return IScanWebPlugin.SCANTYPE_GIF; // "gif";

    default:
      throw new I18NException("genapp.comodi",
          "No s'ha trobat el format de fitxer per escaneig amb ID " + formatType);

    }

  }

  @RequestMapping(value = SCANWEB_CONTEXTPATH_FINAL + "/{scanWebID}")
  public ModelAndView finalProcesDeScanWeb(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("scanWebID") String transactionWebID)
      throws Exception, I18NException {

    final boolean debug = log.isDebugEnabled();

    if (debug) {
      log.debug(" ===finalProcesEscaneig() ==> scanWebID: " + transactionWebID);
    }

    TransaccioJPA transaccio = null;
    {

      transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
      if (transaccio == null) {
        // XYZ ZZZ ZZZ
        throw new Exception("NO existeix la transacció amb ID " + transactionWebID);
      }

      if (transaccio.getEstatcodi() < 0) {
        // XYZ ZZZ ZZZ
        String msg = "La transacció amb ID " + transactionWebID + " te un estat no vàlid ("
            + transaccio.getEstatcodi() + ") per iniciar el proces d'escaneig.";
        throw new Exception(msg);
      }
    }

    ScanWebConfig swc;
    swc = scanWebModuleEjb.getScanWebConfig(request, transactionWebID);

    ScanWebStatus scanWebStatus = swc.getStatus();

    int status = scanWebStatus.getStatus();

    transaccio.setEstatcodi(status);

    if (status == ScanWebStatus.STATUS_FINAL_ERROR) {
      transaccio.setEstatmissatge(scanWebStatus.getErrorMsg());

      Throwable th = scanWebStatus.getErrorException();
      if (th != null) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        th.printStackTrace(pw);
        transaccio.setEstatexcepcio(sw.toString());
      }
    } else if (status == ScanWebStatus.STATUS_CANCELLED) {

      if (scanWebStatus.getErrorMsg() == null) {
        scanWebStatus.setErrorMsg("plugindescan.cancelat");
      }
      transaccio.setEstatmissatge(scanWebStatus.getErrorMsg());
    } else if (status == ScanWebStatus.STATUS_IN_PROGRESS) {
      // Comprovam que s'hagin escanejat coses

      List<ScannedDocument> listDocs = swc.getScannedFiles();

      if (listDocs.size() == 1) {

        ScannedDocument sd = listDocs.get(0);

        ScannedPlainFile scannedFile = sd.getScannedPlainFile();

        byte[] data = scannedFile.getData();
        Fitxer fitxer = new FitxerBean("", scannedFile.getMime(), scannedFile.getName(),
            data.length);

        fitxer = fitxerEjb.create(fitxer);

        FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fitxer.getFitxerID());

        transaccio.setFitxerEscanejatID(fitxer.getFitxerID());
        transaccio.setEstatcodi(ScanWebStatus.STATUS_FINAL_OK);

      } else {

        transaccio.setEstatcodi(ScanWebStatus.STATUS_FINAL_ERROR);
        if (listDocs.size() == 0) {
          // XYZ ZZZ Traduir
          transaccio.setEstatmissatge(" L'usuari no ha escanejat cap fitxer.");
        } else {
          // XYZ ZZZ Traduir
          transaccio.setEstatmissatge(" L'usuari ha escanejat més d'1 fitxer.");
        }
      }

    } else {
      // XYZ ZZZ Traduir
      String inconsistentState = "El mòdul d´escaneig ha finalitzat inesperadament"
          + " amb un estat desconegut " + status;
      transaccio.setEstatmissatge(inconsistentState);
      scanWebStatus.setErrorException(new Exception());
    }

    scanWebModuleEjb.closeScanWebProcess(request, transactionWebID);

    // String languageUI = transaccio.getLanguageui();

    String urlRetorn = transaccio.getReturnUrl();

    if (transaccio.getEstatcodi() != ScanWebStatus.STATUS_FINAL_OK) {

      if (transaccio.getEstatmissatge() == null) {
        // XYZ ZZZ
        transaccio
            .setEstatmissatge("Error desconegut ja que no s'ha definit el missatge de l'error !!!!!");
      }
    }

    ModelAndView mav;
    if (transaccio.getView() == ScanWebSimpleStartTransactionRequest.VIEW_FULLSCREEN) {
      // Simple REDIRECCIO
      mav = new ModelAndView(new RedirectView(urlRetorn, false));

    } else {
      // Sortir de IFRAME
      mav = new ModelAndView("public_finalsortiriframe");
      mav.addObject("urlRetorn", urlRetorn);
    }

    transaccio.setDatafi(new Timestamp(System.currentTimeMillis()));

    transaccioLogicaEjb.update(transaccio);

    return mav;

  }

}
