package es.caib.digitalib.back.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.scanweb.api.ScanWebStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractScanWebProcessController.UrlSelectScanModule;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.AuditoriaLogicaLocal;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.TransaccioPublicLogicaLocal;
import es.caib.digitalib.logic.utils.ScanWebConfig;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
public abstract class AbstractFirmaArxiuParametersController
        extends AbstractTransaccioController {

    public static final String CONTEXTWEB_PUBLIC = "/public/firmaarxiuparameters";

    public static final String CONTEXTWEB_USER = "/user/firmaarxiuparameters";

    @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

    @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
    protected ScanWebModuleLocal scanWebModuleEjb;

    @EJB(mappedName = TransaccioPublicLogicaLocal.JNDI_NAME)
    protected TransaccioPublicLogicaLocal transaccioLogicaEjb;

    @EJB(mappedName = AuditoriaLogicaLocal.JNDI_NAME)
    protected AuditoriaLogicaLocal auditoriaLogicaEjb;

    @Override
    public String getPerfilInfoContextWeb() {
        return null;
    }

    @Override
    public boolean isAdmin() {
        // No serveix per res
        return false;
    }

    @Override
    public int getTipusPerfil() {
        return Constants.PERFIL_US_ALL_INFO; // No s'utilitza per res
    }

    @Override
    public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
            HttpServletRequest request, ModelAndView mav) throws I18NException {
        TransaccioForm transaccioForm = super.getTransaccioForm(_jpa, __isView, request, mav);

        Set<Field<?>> hiddenFields = new HashSet<Field<?>>(
                Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

        final int tipusPerfil = Math.abs(perfilEjb.executeQueryOne(PerfilFields.USPERFIL,
                PerfilFields.PERFILID.equal(transaccioForm.getTransaccio().getPerfilID())));

        // Tots excepte NOM
        hiddenFields.remove(TransaccioFields.NOM);

        // Copia Autentica
        if (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA
                || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {
            hiddenFields.remove(TransaccioFields.FUNCIONARIUSERNAME);
            hiddenFields.remove(TransaccioFields.SIGNPARAMFUNCIONARINIF);
            hiddenFields.remove(TransaccioFields.SIGNPARAMFUNCIONARINOM);
            hiddenFields.remove(TransaccioFields.SIGNPARAMFUNCIONARIDIR3);

            TransaccioJPA tra = transaccioForm.getTransaccio();

            if (!Utils.isEmpty(tra.getFuncionariUsername())) {
                transaccioForm.addReadOnlyField(TransaccioFields.FUNCIONARIUSERNAME);
            }
            if (!Utils.isEmpty(tra.getSignParamFuncionariNif())) {
                transaccioForm.addReadOnlyField(TransaccioFields.SIGNPARAMFUNCIONARINIF);
            }
            if (!Utils.isEmpty(tra.getSignParamFuncionariNom())) {
                transaccioForm.addReadOnlyField(TransaccioFields.SIGNPARAMFUNCIONARINOM);
            }
            if (!Utils.isEmpty(tra.getSignParamFuncionariDir3())) {
                transaccioForm.addReadOnlyField(TransaccioFields.SIGNPARAMFUNCIONARIDIR3);
            }

            hiddenFields.remove(TransaccioFields.INFOSCANLANGUAGEDOC);
        }

        // Digitalitzacio
        if (tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

            /*
             * // XYZ ZZZ Per DEBUG
             * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI);
             * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM);
             * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL);
             * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID);
             * 
             * // XYZ ZZZ Per Debug
             * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI);
             * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM);
             * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL);
             * transaccioForm.addReadOnlyField(TransaccioFields.
             * ARXIUOPTPARAMCUSTODYOREXPEDIENTID);
             */

            // hiddenFields.remove(TransaccioFields.ARXIUREQPARAMCIUTADANIF);
            // hiddenFields.remove(TransaccioFields.ARXIUREQPARAMCIUTADANOM);
            hiddenFields.remove(TransaccioFields.ARXIUREQPARAMDOCESTATELABORA);
            hiddenFields.remove(TransaccioFields.INFOSCANDOCUMENTTIPUS);
            hiddenFields.remove(TransaccioFields.ARXIUREQPARAMINTERESSATS);
            hiddenFields.remove(TransaccioFields.ARXIUREQPARAMORIGEN);
            // hiddenFields.remove(TransaccioFields.ARXIUREQPARAMORGANS);

            if (Configuracio.isCAIB()) {
                transaccioForm.addReadOnlyField(ARXIUREQPARAMDOCESTATELABORA);
                transaccioForm.getTransaccio().setArxiuReqParamDocEstatElabora("EE03");
            }

        }
        
        
        if (transaccioForm.getTransaccio().getInfoScanLanguageDoc() == null) {
            transaccioForm.getTransaccio().setInfoScanLanguageDoc(Configuracio.getDefaultLanguage());
        }
        

        transaccioForm.setTitleCode("dadesrequerides");

        transaccioForm.setHiddenFields(hiddenFields);

        transaccioForm.setDeleteButtonVisible(false);

        // XYZ ZZZ Obtenir idioma per defecte
        // transaccioForm.getTransaccio().setSignParamLanguageDoc("ca");

        return transaccioForm;
    }

    @Override
    public void postValidate(HttpServletRequest request, TransaccioForm transaccioForm,
            BindingResult result) throws I18NException {

        ValidationUtils.rejectIfEmptyOrWhitespace(result, NOM.fullName,
                "genapp.validation.required",
                new Object[] { I18NUtils.tradueix(NOM.fullName) });

        final int tipusPerfil = Math.abs(perfilEjb.executeQueryOne(PerfilFields.USPERFIL,
                PerfilFields.PERFILID.equal(transaccioForm.getTransaccio().getPerfilID())));

        if (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA
                || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

            // XYZ ZZZ Aqui falta el camp de DIR3Unit !!!
            Field<?>[] signFields = { TransaccioFields.SIGNPARAMFUNCIONARINIF,
                    TransaccioFields.SIGNPARAMFUNCIONARINOM,
                    TransaccioFields.SIGNPARAMFUNCIONARIDIR3 };

            for (Field<?> field : signFields) {
                ValidationUtils.rejectIfEmptyOrWhitespace(result, field.fullName,
                        "genapp.validation.required",
                        new Object[] { I18NUtils.tradueix(field.fullName) });
            }

        }

        if (tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

            Field<?>[] reqFields = { TransaccioFields.ARXIUREQPARAMDOCESTATELABORA,
                    TransaccioFields.INFOSCANDOCUMENTTIPUS,
                    TransaccioFields.ARXIUREQPARAMORIGEN
                    // TransaccioFields.ARXIUREQPARAMCIUTADANIF, No és obligatori
                    // TransaccioFields.ARXIUREQPARAMCIUTADANOM, No és obligatori
                    // TransaccioFields.ARXIUREQPARAMINTERESSATS, No és obligatori
            };

            for (Field<?> field : reqFields) {
                ValidationUtils.rejectIfEmptyOrWhitespace(result, field.fullName,
                        "genapp.validation.required",
                        new Object[] { I18NUtils.tradueix(field.fullName) });
            }

            if (isPublic()) {
                // Si la petició arriba des d'APP llavors, requerim que ens afegeixin quin organ
                ValidationUtils.rejectIfEmptyOrWhitespace(result,
                        TransaccioFields.ARXIUREQPARAMORGANS.fullName,
                        "genapp.validation.required", new Object[] { I18NUtils
                                .tradueix(TransaccioFields.ARXIUREQPARAMORGANS.fullName) });
            }

        }

    }
/*
    @Override
    public TransaccioJPA update(HttpServletRequest request, TransaccioJPA transaccio)
            throws Exception, I18NException, I18NValidationException {

        final String dir3 = transaccio.getArxiuReqParamOrgans();

        log.info("\n\n  XYZ ZZZZZ  PRE UPDATE: dir3 -> ]" + dir3 + "[");

        if (!isPublic() && (dir3 == null || dir3.isEmpty())) {
            // Obtenim el codidir3 per defecte de la ConfiguracioGrup
            transaccio.setArxiuReqParamOrgans(LoginInfo.getInstance().getUsuariPersona()
                    .getConfiguracioGrup().getCodiDir3PerDefecte());
        }

        return super.update(request, transaccio);
    }
*/
    public static long lastCheck = 0;

    @Override
    public String getRedirectWhenModified(HttpServletRequest request,
            TransaccioForm transaccioForm, Throwable __e) {
        if (__e == null) {

            final String msg = I18NUtils.tradueix("transaccio.firma.insercio.dades.ok");
            final boolean isApp = (transaccioForm.getTransaccio()
                    .getUsuariAplicacioId() != null);
            final String additionalInfo = null;
            final int auditType = Constants.AUDIT_TYPE_FINISH_INSERT_DATA;

            auditoriaLogicaEjb.audita(transaccioForm.getTransaccio(), msg, additionalInfo,
                    auditType, isApp);

            request.getSession().removeAttribute(HtmlUtils.MISSATGES);

            String url = (String) request.getSession().getAttribute(
                    AbstractScanWebProcessController.SESSION_URL_TO_SELECT_SCANWEB_MODULE);

            log.info(
                    " XYZ ZZZ ZZZ ============== AbstractFirmaArxiuParametersController::getRedirectWhenModified GET SESSION_URL_TO_SELECT_SCANWEB_MODULE => "
                            + url);

            log.info(
                    " XYZ ZZZ ZZZ ============== AbstractFirmaArxiuParametersController::getTransactionId => "
                            + transaccioForm.getTransaccio().getTransaccioID());
            synchronized (AbstractScanWebProcessController.transID2Url) {

                if (url == null) {
                    final Map<Long, UrlSelectScanModule> transID2Url = AbstractScanWebProcessController.transID2Url;
                    AbstractScanWebProcessController.UrlSelectScanModule urlInfo;
                    urlInfo = transID2Url
                            .get(transaccioForm.getTransaccio().getTransaccioID());

                    if (urlInfo == null) {

                        if (transID2Url.isEmpty()) {
                            log.info(
                                    " XYZ ZZZ ZZZ ============== AbstractFirmaArxiuParametersController:: ES BUIT !!!!!");
                        } else {
                            for (Long k : transID2Url.keySet()) {
                                log.info(" XYZ ZZZ  KEYS[" + k + "]");
                            }
                        }
                    } else {
                        url = urlInfo.urlToSelectPluginPage;
                    }
                }

                AbstractScanWebProcessController.transID2Url
                        .remove(transaccioForm.getTransaccio().getTransaccioID());

                long now = System.currentTimeMillis();
                if (lastCheck < (now - 5 * 60000)) { // Cada 2 minuts farem neteja

                    List<Long> aEsborrar = new ArrayList<Long>();
                    for (Map.Entry<Long, UrlSelectScanModule> info : AbstractScanWebProcessController.transID2Url
                            .entrySet()) {
                        final long MINUTS_30 = 1000 * 60 * 30;
                        if ((info.getValue().startDate + MINUTS_30) < now) {
                            // L'esborram
                            aEsborrar.add(info.getKey());
                        }

                    }

                    for (Long id : aEsborrar) {
                        AbstractScanWebProcessController.transID2Url.remove(id);
                    }

                    lastCheck = now;

                }
            }

            log.info(
                    " XYZ ZZZ ZZZ ============== AbstractFirmaArxiuParametersController::getRedirectWhenModified FINAL => "
                            + url);

            return "redirect:" + url;
        } else {
            // log.info("\n =====================
            // AbstractFirmaArxiuParametersController::getTileForm() " + getTileForm());
            return getTileForm();
        }
    }

    @Override
    public String getRedirectWhenCancel(HttpServletRequest request,
            java.lang.Long transaccioID) {

        String transaccioWebId = null;
        try {
            transaccioWebId = transaccioEjb.executeQueryOne(TransaccioFields.TRANSACTIONWEBID,
                    TransaccioFields.TRANSACCIOID.equal(transaccioID));
        } catch (I18NException e) {
            // TODO XYZ ZZZ Que faig si error ????
            e.printStackTrace();
        }

        if (transaccioWebId != null) {

            ScanWebConfig swc;
            swc = scanWebModuleEjb.getScanWebConfig(request, transaccioWebId);

            swc.getResult().getStatus().setStatus(ScanWebStatus.STATUS_CANCELLED);

            // AUDITA
            final String msg = I18NUtils.tradueix("transaccio.firma.insercio.dades.cancelat");
            final boolean isApp = isPublic();
            final String additionalInfo = null;
            final int auditType = Constants.AUDIT_TYPE_CANCEL_USER;

            auditoriaLogicaEjb.audita(transaccioLogicaEjb, (long) transaccioID, msg,
                    additionalInfo, auditType, isApp);

        }

        String finalURL = AbstractScanWebProcessController.getFinalURL("", transaccioWebId,
                isPublic());

        log.warn("XYZ ZZZ URL despres de CANCEL.LAR: " + finalURL);

        return "redirect:" + finalURL;
    }

    @Override
    public String getTileForm() {
        return "FirmaArxiuParametersForm_" + (isPublic() ? "public" : "user");
    }

    public abstract boolean isPublic();

    @Override
    public String getSessionAttributeFilterForm() {
        return "FirmaArxiuParameters_FilterForm_" + isPublic();
    }

    @Override
    public boolean isActiveList() {
        return false;
    }

    @Override
    public boolean isActiveFormNew() {
        return false;
    }

    @Override
    public boolean isActiveFormEdit() {
        return true;
    }

    @Override
    public boolean isActiveDelete() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return false;
    }

}
