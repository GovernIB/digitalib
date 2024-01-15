package es.caib.digitalib.back.controller;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.admin.InfoCustodyAdminController;
import es.caib.digitalib.back.controller.user.InfoCustodyUserController;
import es.caib.digitalib.back.controller.webdb.InfoCustodyController;
import es.caib.digitalib.back.form.webdb.InfoCustodyForm;
import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.logic.PluginArxiuLogicaService;
import es.caib.digitalib.model.entity.InfoCustody;


/**
 * 
 * @author anadal(u80067)
 *
 */
public abstract class AbstractInfoCustodyController extends InfoCustodyController {

    @EJB(mappedName = PluginArxiuLogicaService.JNDI_NAME)
    protected PluginArxiuLogicaService pluginArxiuLogicaEjb;


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
        return "infoCustodyForm" + (isAdmin() ? "Admin" : "_user");
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "InfoCustody_" + isAdmin() + "_FilterForm";
    }

    @RequestMapping(value = "/tancarexpedient/{infoCustodyID}")
    public String tancarExpdient(@PathVariable("infoCustodyID") java.lang.Long infoCustodyID,
            HttpServletRequest request, HttpServletResponse response) {

        InfoCustody ic = infoCustodyEjb.findByPrimaryKey(infoCustodyID);
        if (ic == null) {

            HtmlUtils.saveMessageError(request,
                    "No s'ha trobat InfoCustody amb ID " + infoCustodyID);

        } else {

            String expedientID = ic.getArxiuExpedientId();

            if (expedientID == null) {
                HtmlUtils.saveMessageError(request,
                        "El camp expedientID de InfoCustody amb ID " + infoCustodyID
                                + " val null.");
            } else {

                try {
                    pluginArxiuLogicaEjb.tancarExpedient(infoCustodyID, expedientID, null);

                    ic.setCustodyId(null);
                    infoCustodyEjb.update(ic);
                    
                    HtmlUtils.saveMessageSuccess(request,
                            "Expedient amb ID " + expedientID + " tancat correctament");

                } catch (Throwable th) {
                    String msg = "Error reintentant tancar expedient " + expedientID + ": "
                            + th.getMessage();
                    log.error(msg, th);
                    HtmlUtils.saveMessageError(request, msg);
                }
                
            }
        }

        return "redirect:" + getContextWeb() + "/view/" + infoCustodyID;
    }

    @Override
    public InfoCustodyForm getInfoCustodyForm(InfoCustodyJPA _jpa, boolean __isView,
            HttpServletRequest request, ModelAndView mav) throws I18NException {
        InfoCustodyForm infoCForm = super.getInfoCustodyForm(_jpa, __isView, request, mav);

        InfoCustodyForm.hideNullFields(infoCForm.getInfoCustody(), infoCForm, ALL_INFOCUSTODY_FIELDS);

        InfoCustody ic = infoCForm.getInfoCustody();

        if (ic.getArxiuDocumentId() != null && ic.getArxiuExpedientId() != null
                && ic.getCustodyId() != null) {
            // Hi ha un error de tancament d'Expedient
            infoCForm.addLabel(CUSTODYID, "errortancantexpedient");

            if (isAdmin()) {
                // Reintentar tancar Expedient
                infoCForm.addAdditionalButton(new AdditionalButton("fas fa-redo icon-white",
                        "reintentartancarexpedient", 
                        getContextWeb() + "/tancarexpedient/" + ic.getInfoCustodyID(),
                        "btn-warning"));
            }

        }
        return infoCForm;

    }

    public static String getContextWeb(boolean isAdmin) {
        return isAdmin ? InfoCustodyAdminController.CONTEXT_WEB_ADMIN_INFO_CUSTODY
                : InfoCustodyUserController.CONTEXT_WEB_USER_INFO_CUSTODY;
    }
}
