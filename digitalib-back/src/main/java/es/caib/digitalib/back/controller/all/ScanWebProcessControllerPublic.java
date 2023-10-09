package es.caib.digitalib.back.controller.all;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.AbstractScanWebModuleController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 *
 * @author anadal(u80067)
 *
 *
 */
@Controller
@RequestMapping(value = Constants.SCANWEB_PROCESS_CONTROLLER_PUBLIC_CONTEXTPATH)
public class ScanWebProcessControllerPublic extends AbstractScanWebProcessController {

    @RequestMapping(value = "/start/{transactionWebID}", method = RequestMethod.GET)
    public ModelAndView scanWebStart(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("transactionWebID") String transactionWebID) throws Exception, I18NException {

        String languageUI;
        TransaccioJPA transaccio = null;
        {

            transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);

            if (transaccio == null) {
                throw new Exception(I18NUtils.tradueix("transaccio.noexisteix", transactionWebID));
            }

            languageUI = transaccio.getLanguageUI();

            if (transaccio.getEstatCodi() < 0) {
                String msg = I18NUtils.tradueix("transaccio.estat.novalid", String.valueOf(transactionWebID),
                        String.valueOf(transaccio.getEstatCodi()));
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
            urlBase = Configuracio.getBackUrl();
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

    @Override
    protected ModelAndView returnToOrigen(HttpServletRequest request, TransaccioJPA transaccio) throws I18NException {
        String urlRetorn = transaccio.getReturnUrl();
        ModelAndView mav;
        if (transaccio.getView() == ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN) {
            // Simple REDIRECCIO

            log.info("SIMPLE REDIRECCIO = " + urlRetorn);

            mav = new ModelAndView(new RedirectView(urlRetorn, false));

        } else {
            // Sortir de IFRAME

            log.info("Sortir de IFRAME = " + urlRetorn);
            mav = new ModelAndView("public_finalsortiriframe");
            //isPublic() ? "public_finalsortiriframe" : "finalsortiriframe");
            mav.addObject("urlRetorn", urlRetorn);
        }

        return mav;
    }

}
