package es.caib.digitalib.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.admin.InfoSignatureAdminController;
import es.caib.digitalib.back.controller.user.InfoSignatureUserController;
import es.caib.digitalib.back.controller.webdb.InfoSignaturaController;
import es.caib.digitalib.back.form.webdb.InfoSignaturaForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.InfoSignaturaJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */
public abstract class AbstractInfoSignatureController extends InfoSignaturaController {

    public abstract boolean isAdmin();

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
        return false;
    }

    @Override
    public boolean isActiveDelete() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return true;
    }

    @Override
    public String getTileForm() {
        return "infoSignaturaForm" + (isAdmin() ? "Admin" : "_user");
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "InfoSignatura_" + isAdmin() + "_FilterForm";
    }

    @Override
    public InfoSignaturaForm getInfoSignaturaForm(InfoSignaturaJPA _jpa, boolean __isView,
            HttpServletRequest request, ModelAndView mav) throws I18NException {
        InfoSignaturaForm infoSignaturaForm = super.getInfoSignaturaForm(_jpa, __isView,
                request, mav);

        Utils.hideNullFields(infoSignaturaForm.getInfoSignatura(), infoSignaturaForm,
                ALL_INFOSIGNATURA_FIELDS);

        return infoSignaturaForm;

    }

    public static String getContextWeb(boolean isAdmin) {
        return isAdmin ? InfoSignatureAdminController.CONTEXT_WEB_ADMIN_INFO_SIGNATURE
                : InfoSignatureUserController.CONTEXT_WEB_USER_INFO_SIGNATURE;
    }

    @Override
    public List<StringKeyValue> getReferenceListForSignMode(HttpServletRequest request,
            ModelAndView mav, Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

        /*
         * SIGN_MODE_IMPLICIT = 0; SIGN_MODE_EXPLICIT = 1;
         */

        __tmp.add(new StringKeyValue("0", "Attached"));
        __tmp.add(new StringKeyValue("1", "Dettached"));

        return __tmp;
    }

    @Override
    public List<StringKeyValue> getReferenceListForSignaturesTableLocation(
            HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue("-1", "Darrera pàgina"));
        __tmp.add(new StringKeyValue("0", "Sense Taula de Firmes"));
        __tmp.add(new StringKeyValue("1", "Primera pàgina"));
        return __tmp;
    }

    public List<StringKeyValue> getReferenceListForSignOperation(HttpServletRequest request,
            ModelAndView mav, Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue("0", "Firma"));
        __tmp.add(new StringKeyValue("1", "Cofirma"));
        __tmp.add(new StringKeyValue("2", "Contrafirma"));
        return __tmp;
    }
}
