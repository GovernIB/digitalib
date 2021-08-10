package es.caib.digitalib.back.controller.all;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import es.caib.digitalib.back.controller.AbstractScanWebModuleController;
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
    String languageUI;
    TransaccioJPA transaccio = null;
    {

      transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);

      if (transaccio == null) {
        throw new Exception(I18NUtils.tradueix("transaccio.noexisteix", transactionWebID));
      }

      languageUI = transaccio.getLanguageUI();

      if (transaccio.getEstatCodi() < 0) {
        String msg = I18NUtils.tradueix("transaccio.estat.novalid", String.valueOf(transactionWebID), String.valueOf(transaccio.getEstatCodi()));
        throw new Exception(msg);
      }
    }

    // Establint idioma de la UI
    {        
        String where = "ScanWebProcessControllerPublic::scanWebStart()";        
        AbstractScanWebModuleController.setLanguageUI(request, response, languageUI, where);
    }

    String urlBase = transaccio.getPerfil().getUrlBase();

    if (urlBase == null || urlBase.trim().length() == 0) {
      urlBase = Configuracio.getAppUrl();
    }

    boolean isDebug = log.isDebugEnabled();
    
    if (isDebug) {
      log.debug(" URLBASE = " + urlBase);
    }

    final String urlFinal = AbstractScanWebProcessController.getFinalURL(urlBase, transactionWebID, isPublic()); 
        
    //final String urlFinal =  urlBase + SCANWEB_CONTEXTPATH + SCANWEB_CONTEXTPATH_FINAL + "/"   + transactionWebID;

    if (isDebug) {
      log.info(" URLFINAL = " + urlFinal);
    }

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

    ModelAndView mav = startScanWebProcess(request, response, transaccio, isPublic, urlFinal, urlBase);



    return mav;

  }

  @Override
  public boolean isPublic() {
    return true;
  }

}
