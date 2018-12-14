package es.caib.digitalib.back.controller.all;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.utils.Configuracio;

/**
 *
 * @author anadal(u80067)
 *
 *
 */
@Controller
@RequestMapping(value = ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH)
public class ScanWebProcessControllerPublic extends AbstractScanWebProcessController {

  public static final String SCANWEB_CONTEXTPATH = "/public/scanweb";

  @RequestMapping(value = "/start/{transactionWebID}", method = RequestMethod.GET)
  public ModelAndView scanWebStart(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("transactionWebID") String transactionWebID) throws Exception,
      I18NException {

    @SuppressWarnings("unused")
    String languageUI = "ca";
    TransaccioJPA transaccio = null;
    {

      transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);

      if (transaccio == null) {
        // XYZ ZZZ ZZZ Traduir
        throw new Exception("NO existeix la transacció amb ID " + transactionWebID);
      }

      languageUI = transaccio.getLanguageUI();

      if (transaccio.getEstatCodi() < 0) {
        // XYZ ZZZ ZZZ Traduir
        String msg = "La transacció amb ID " + transactionWebID + " te un estat no vàlid ("
            + transaccio.getEstatCodi() + ") per iniciar el proces d'escaneig.";
        throw new Exception(msg);
      }
    }

    languageUI = transaccio.getLanguageUI();

    String urlBase = transaccio.getPerfil().getUrlBase();

    if (urlBase == null || urlBase.trim().length() == 0) {
      urlBase = Configuracio.getAppUrl();
    }

    log.info(" XYZ ZZZ URLBASE = " + urlBase);

    final String urlFinal = urlBase + SCANWEB_CONTEXTPATH + SCANWEB_CONTEXTPATH_FINAL + "/"
        + transactionWebID;

    log.info(" XYZ ZZZ URLFINAL = " + urlFinal);

    /*
     * final String scanType = ScanWebUtils.formatFileToScanWebApi(transaccio.getPerfil()
     * .getScanFormatFitxer());
     * 
     * final Set<String> flags = null; // acceptam la primera configuració disponible del
     * plugin
     * 
     * // TODO per ara està buit final List<Metadata> metadades = new ArrayList<Metadata>();
     * 
     * // ScanWebMode mode = "S".equals("" + form.getMode()) ? ScanWebMode.SYNCHRONOUS // :
     * ScanWebMode.ASYNCHRONOUS; final ScanWebMode mode = ScanWebMode.SYNCHRONOUS;
     * 
     * ScanWebConfig swc = new ScanWebConfig(transaccio.getTransactionWebId(), scanType, flags,
     * metadades, mode, languageUI, urlFinal);
     */

    final boolean isPublic = true;

    // /WEB-INF/views/plugindescan_contenidor.jsp

    // final boolean fullView = (transaccio.getView() ==
    // ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN);

    ModelAndView mav = startScanWebProcess(request, transaccio, isPublic, urlFinal, urlBase);

    // , fullView, Math.abs(transaccio.getPerfil().getUsPerfil()), isPublic);

    // XYZ ZZZ
    // En passarela de firma requerim dins d'un frame
    // mav.addObject("fullView",
    // transaccio.getView() == ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN);

    return mav;

  }

  @Override
  public boolean isPublic() {
    return true;
  }

}
