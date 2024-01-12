package es.caib.digitalib.back.controller.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractFirmaArxiuParametersController;
import es.caib.digitalib.back.controller.AbstractScanWebModuleController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController.FitxerEscanejatInfo;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.persistence.TransaccioJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = FirmaArxiuParametersUserController.CONTEXTWEB_USER)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class FirmaArxiuParametersUserController extends AbstractFirmaArxiuParametersController {

    //public String rewriteTileForm = null;
    public static final String REWRITE_TILE_FORM_SESSION_ID = "REWRITE_TILE_FORM_SESSION_ID";

    @Override
    public boolean isPublic() {
        return false;
    }

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return false;
    }

    @Override
    public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {

        log.info("XYZ ZZZ Entra a FirmaArxiuParametersUserController::getTransaccioForm() ...");

        TransaccioForm transaccioForm = super.getTransaccioForm(_jpa, __isView, request, mav);

        if (transaccioForm.getTransaccio().getTransaccioMultipleID() != null) {

            if (_jpa.getFitxerEscanejatID() == null) {

                // == PRE-ESCANEIG

                // Posam tots els camps a buit excepte nom

                Set<Field<?>> hiddenFields = new HashSet<Field<?>>(
                        Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

                // Tots excepte NOM
                hiddenFields.remove(TransaccioFields.NOM);

                transaccioForm.setHiddenFields(hiddenFields);

            } else {

                // == POST-ESCANEIG

                transaccioForm.setTitleCode("documentescanejat");
                Integer pos = (Integer) request.getSession()
                        .getAttribute(AbstractScanWebProcessController.SESSION_MASIVE_POINTER_POST_SCAN);
                transaccioForm.setTitleParam(String.valueOf(pos + 1));

                transaccioForm.setCancelButtonVisible(false);

                mav.addObject("thumbnailPDF", getContextWeb() + THUMBNAIL_PDF_MASSIVE + "/"
                        + transaccioForm.getTransaccio().getTransactionWebId());

                transaccioForm.setAttachedAdditionalJspCode(true);

                // En aquesta pàgina web hi ha algun tipus de BUG i no captura correctament
                // l'idioma
                {
                    String languageUI = transaccioForm.getTransaccio().getLanguageUI();
                    String where = "AbstractScanWebModuleController::selectScanWebModule()";
                    HttpServletResponse response = null;
                    AbstractScanWebModuleController.setLanguageUI(request, response, languageUI, where);
                }

                if (Configuracio.showButtonToDeleteFirstPage()) {
                    Map<Long, FitxerEscanejatInfo> infos = (Map<Long, FitxerEscanejatInfo>) request.getSession()
                            .getAttribute(AbstractScanWebProcessController.SESSION_MASSIVE_INFO_BY_ID);
                    if (infos == null) {
                        log.error("\n\n\n ERROR infos val null. \n\n\n");
                    } else {
                        long id = transaccioForm.getTransaccio().getTransaccioID();
                        FitxerEscanejatInfo fei = infos.get(id);
                        if (fei == null) {
                            log.error("\n\n\n infos[" + id + "] => " + fei + "  \n\n\n");
                            log.error("\n\n\n IDs de Transaccions:");
                            for (Long ids : infos.keySet()) {
                                log.info("     => " + ids);
                            }
                        } else {
                            if (fei.firstPageEmpty) {
                                transaccioForm.addAdditionalButton(new AdditionalButton(
                                        IconUtils.getWhite(IconUtils.ICON_TRASH), "esborrarprimerapagina",
                                        "javascript:eliminarPrimeraPagina();", "btn-warning"));
                            }
                        }
                    }
                }

                request.getSession().setAttribute(REWRITE_TILE_FORM_SESSION_ID, "transaccionsmassives_user");
                //rewriteTileForm = "transaccionsmassives_user";

                mav.setViewName("transaccionsmassives_user");

            }

            /// XYZ ZZZ ZZZ TODO Si hi ha error en la transacció hem d'anar directament a la
            /// següent
            /// !!!!
        }

        return transaccioForm;
    }

    @Override
    public void postValidate(HttpServletRequest request, TransaccioForm transaccioForm, BindingResult result)
            throws I18NException {

        log.info("XYZ ZZZ Passa per FirmaArxiuParametersUserController::postValidate() ... FITXER => "
                + transaccioForm.getTransaccio().getFitxerEscanejatID());

        // Aqui s'ha de controlar que si es nou llavors només mostrar nom, si és edit llavors controlar-ho tot !!!!
        if (transaccioForm.getTransaccio().getFitxerEscanejatID() != null) {
            super.postValidate(request, transaccioForm, result);
        } else {
            ValidationUtils.rejectIfEmptyOrWhitespace(result, NOM.fullName, "genapp.validation.required",
                    new Object[] { I18NUtils.tradueix(NOM.fullName) });
        }

    }

    @Override
    public String getTileForm() {

        HttpServletRequest requestContext;
        requestContext = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        log.info("XYZ ZZZ ZZZZ Passa per per FirmaArxiuParametersUserController::getTileForm() =>>  " + requestContext);

        String rewriteTileForm = (String) requestContext.getSession().getAttribute(REWRITE_TILE_FORM_SESSION_ID);

        if (rewriteTileForm == null) {
            return super.getTileForm();
        } else {
            return rewriteTileForm;
        }

    }

    @Override
    public String getRedirectWhenModified(HttpServletRequest request, TransaccioForm transaccioForm, Throwable __e) {

        log.info("XYZ ZZZ Passa per per FirmaArxiuParametersUserController::getRedirectWhenModified() => "
                + transaccioForm.getTransaccio().getFitxerEscanejatID());

        String str = super.getRedirectWhenModified(request, transaccioForm, __e);

        if (transaccioForm.getTransaccio().getFitxerEscanejatID() == null) {
            //String str = super.getRedirectWhenModified(request, transaccioForm, __e);
            //return str;
        } else {

            Long transaccioMultipleID = transaccioForm.getTransaccio().getTransaccioMultipleID();

            String r = (isPublic() ? Constants.SCANWEB_PROCESS_CONTROLLER_PUBLIC_CONTEXTPATH
                    : ScanWebProcessControllerUser.CONTEXTWEB)
                    + AbstractScanWebProcessController.SCANWEB_CONTEXTPATH_UPDATE_MASSIVE + "/" + transaccioMultipleID;

            log.info("FirmaArxiuParametersUserController::getRedirectWhenModified  STATUS => "
                    + transaccioForm.getTransaccio().getEstatCodi());
            log.info("FirmaArxiuParametersUserController::PASSAM A SEGÜENT ENTRADA: " + r);

            // Venim de MASSIVE
            str = "redirect:" + r;

        }

        return str;
    }

}
