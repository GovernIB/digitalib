package es.caib.digitalib.back.controller;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.plugins.scanweb.api.ScanWebStatus;
import org.fundaciobit.plugins.scanweb.api.ScannedDocument;
import org.fundaciobit.plugins.scanweb.api.ScannedPlainFile;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.FitxerLogicaLocal;
import es.caib.digitalib.logic.PluginFirmaEnServidorLogicaLocal;
import es.caib.digitalib.logic.PluginScanWebLogicaLocal;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.bean.FitxerBean;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.utils.Constants;

/**
 *
 * @author anadal
 *
 *
 */
public abstract class AbstractScanWebProcessController {

  public static final String SCANWEB_CONTEXTPATH_FINAL = "/final";

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



  @RequestMapping(value = SCANWEB_CONTEXTPATH_FINAL + "/{transactionWebID}")
  public ModelAndView finalProcesDeScanWeb(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transactionWebID") String transactionWebID)
      throws Exception, I18NException {

    final boolean debug = log.isDebugEnabled();

    log.info("XYZ ZZZ finalProcesDeScanWeb():: [transactionWebID] = " + transactionWebID);

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

      // if (transaccio.getEstatcodi() < 0) {
      // // XYZ ZZZ ZZZ
      // String msg = "La transacció amb ID " + transactionWebID + " te un estat no vàlid ("
      // + transaccio.getEstatcodi() + ") per iniciar el proces d'escaneig.";
      // throw new Exception(msg);
      // }
    }

    ScanWebConfig swc;
    swc = scanWebModuleEjb.getScanWebConfig(request, transactionWebID);
    // ScanWebStatus scanWebStatus = swc.getStatus();

    int status = swc.getStatus().getStatus();

    switch (status) {
    case ScanWebStatus.STATUS_IN_PROGRESS: {
      // Comprovam que s'hagin escanejat coses

      List<ScannedDocument> listDocs = swc.getScannedFiles();

      if (listDocs.size() == 1) {

        // TOTS HO EXECUTEN AIXÒ
        int usPerfil = transaccio.getPerfil().getUsPerfil();

        switch (usPerfil) {

        case Constants.PERFIL_US_NOMES_ESCANEIG_INFO: {
          Fitxer fitxer = recuperarDocumentEscanejat(transaccio, listDocs);
          if (fitxer != null) {
            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);
          }
        }
          break;

        case Constants.PERFIL_US_COPIA_AUTENTICA_INFO: {
          Fitxer fitxer = recuperarDocumentEscanejat(transaccio, listDocs);
          if (fitxer != null) {
            Fitxer fitxerFirmat = firmarFitxer(transaccio, fitxer);
            if (fitxerFirmat != null) {
              transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);
            }
          }
        }
          break;

        case Constants.PERFIL_US_CUSTODIA_INFO: {

          Fitxer fitxer = recuperarDocumentEscanejat(transaccio, listDocs);

          if (fitxer != null) {
            Fitxer fitxerFirmat = firmarFitxer(transaccio, fitxer);

            if (fitxerFirmat != null) {
              // XYZ ZZZ Aqui falta CUSTODIA
              // NOMES CUSTODIA
              //infoCustodyJPA =  custodia(transaccio, fitxerFirmat);
              InfoCustodyJPA infoCustodyJPA = new InfoCustodyJPA();
              
              if (infoCustodyJPA != null) {
                transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);
              }
              
            }
          }
        }
          break;
        }

      } else {

        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        if (listDocs.size() == 0) {
          // XYZ ZZZ Traduir
          transaccio.setEstatMissatge(" L'usuari no ha escanejat cap fitxer.");
        } else {
          // XYZ ZZZ Traduir
          transaccio.setEstatMissatge(" L'usuari ha escanejat més d'1 fitxer.");
        }
      }
    }
      break;

    case ScanWebStatus.STATUS_FINAL_ERROR: {
      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
    }
      break;

    case ScanWebStatus.STATUS_CANCELLED: {
      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_CANCELLED);
      if (transaccio.getEstatMissatge() == null) {
        transaccio.setEstatMissatge(I18NUtils.tradueix("plugindescan.cancelat"));
      }
    }
      break;

    default: {
      // XYZ ZZZ Traduir
      String inconsistentState = "El mòdul d´escaneig ha finalitzat inesperadament"
          + " amb un codi d'estat desconegut " + status;
      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(inconsistentState);
      transaccio.setEstatExcepcio(new Exception().toString()); // XYZ ZZZ
    }
    }

    scanWebModuleEjb.closeScanWebProcess(request, transactionWebID);

    // String languageUI = transaccio.getLanguageui();

    String urlRetorn = transaccio.getReturnUrl();

    if (transaccio.getEstatCodi() != ScanWebStatus.STATUS_FINAL_OK) {

      if (transaccio.getEstatMissatge() == null) {
        // XYZ ZZZ
        transaccio
            .setEstatMissatge("Error desconegut ja que no s'ha definit el missatge de l'error !!!!!");
      }
    }

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

    transaccio.setDataFi(new Timestamp(System.currentTimeMillis()));

    transaccioLogicaEjb.update(transaccio);

    return mav;

  }

  public Fitxer recuperarDocumentEscanejat(TransaccioJPA transaccio,
      List<ScannedDocument> listDocs) {
    ScannedDocument sd = listDocs.get(0);

    ScannedPlainFile scannedFile = sd.getScannedPlainFile();

    byte[] data = scannedFile.getData();
    Fitxer fitxer = new FitxerBean("", scannedFile.getMime(), scannedFile.getName(),
        data.length);

    try {
      fitxer = fitxerEjb.create(fitxer);

      FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fitxer.getFitxerID());

      transaccio.setFitxerEscanejatID(fitxer.getFitxerID());
      return fitxer;

    } catch (I18NException e) {

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge("XYZ ZZZ Error intentant recuperar el fitxer escanejat: "
          + I18NUtils.getMessage(e));
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));

      return null;
    }

  }

  protected Fitxer firmarFitxer(TransaccioJPA transaccio, Fitxer fitxer) {

    PerfilJPA perfil = transaccio.getPerfil();

    int tipus = perfil.getTipusFirma();

    Fitxer fitxerSignat;
    if (tipus == Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE) {
      // throw new Exception();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge("XYZ ZZZ TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE no suportat  ");

      fitxerSignat = null;

    } else {

      fitxerSignat = pluginFirmaServidorLogicaEjb.firmarFitxerAmbApiFirmaEnServidor(
          transaccio, fitxer, LocaleContextHolder.getLocale());
    }

    return fitxerSignat;

  }

  

  public abstract boolean isPublic();

  /**
   * 
   * @param request
   * @param view
   * @param scanWebConfig
   * @return
   * @throws Exception
   */
  public ModelAndView startScanWebProcess(HttpServletRequest request, String view,
      String scanWebID, ScanWebConfig scanWebConfig, String urlBase, String contextWeb,
      boolean fullView) throws Exception {

    scanWebModuleEjb.startScanWebProcess(scanWebConfig);

    final String urlToSelectPluginPage = urlBase + contextWeb + "/selectscanwebmodule/"
        + scanWebID;

    ModelAndView mav = new ModelAndView(view);
    mav.addObject("scanWebID", scanWebID);
    mav.addObject("urlToSelectPluginPage", urlToSelectPluginPage);
    mav.addObject("fullView", fullView);

    return mav;
  }

}
