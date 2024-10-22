package es.caib.digitalib.back.controller.admin.general;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.admin.InfoCustodyAdminController;
import es.caib.digitalib.back.form.webdb.InfoCustodyFilterForm;
import es.caib.digitalib.back.form.webdb.InfoCustodyForm;
import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.model.fields.InfoCustodyFields;

/**
 * 
 * @author anadal (u80067)
 *
 */

@Controller
@RequestMapping(value = InfoCustodyExpedientNoTancatAdminController.CONTEXT_WEB_ADMIN_INFO_CUSTODY_NO_TANCAT)
@SessionAttributes(types = { InfoCustodyForm.class, InfoCustodyFilterForm.class })
public class InfoCustodyExpedientNoTancatAdminController extends InfoCustodyAdminController {

    public static final String CONTEXT_WEB_ADMIN_INFO_CUSTODY_NO_TANCAT = "/admin/infoCustodyNoTancat";

    @Override
    public InfoCustodyFilterForm getInfoCustodyFilterForm(Integer pagina, ModelAndView mav,
            HttpServletRequest request) throws I18NException {
        InfoCustodyFilterForm infoCustodyFilterForm = super.getInfoCustodyFilterForm(pagina,
                mav, request);

        if (infoCustodyFilterForm.isNou()) {
            infoCustodyFilterForm.setAddButtonVisible(false);
            infoCustodyFilterForm.setDeleteButtonVisible(false);
            infoCustodyFilterForm.setEditButtonVisible(false);
            infoCustodyFilterForm.setDeleteSelectedButtonVisible(false);
            infoCustodyFilterForm.setVisibleMultipleSelection(false);

            {
                HashSet<Field<?>> hidden = new HashSet<Field<?>>(
                        Arrays.asList(InfoCustodyFields.ALL_INFOCUSTODY_FIELDS));

                hidden.remove(ARXIUDOCUMENTID);
                hidden.remove(ARXIUEXPEDIENTID);
                hidden.remove(CUSTODYID);

                infoCustodyFilterForm.setHiddenFields(hidden);
            }
            
            // Hi ha un error de tancament d'Expedient
            infoCustodyFilterForm.addLabel(CUSTODYID, "errortancantexpedient");

            infoCustodyFilterForm.setTitleCode("expedientsnotancats");

            infoCustodyFilterForm.addAdditionalButtonForEachItem(
                    new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_INFO), "genapp.viewtitle",
                            getContextWeb() + "/view/{0}", AdditionalButtonStyle.INFO));
        }

        return infoCustodyFilterForm;
    }

    @Override
    public String getTileList() {
        return "infoCustodyListAdmin";
    }

    @Override
    public InfoCustodyForm getInfoCustodyForm(InfoCustodyJPA _jpa, boolean __isView,
            HttpServletRequest request, ModelAndView mav) throws I18NException {
        
        InfoCustodyForm infoCForm = super.getInfoCustodyForm(_jpa, __isView, request, mav);

        infoCForm.setCancelButtonVisible(true);

        return infoCForm;
    }

    @Override
    public boolean isActiveList() {
        return true;
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        return Where.AND(ARXIUDOCUMENTID.isNotNull(), ARXIUEXPEDIENTID.isNotNull(),
                CUSTODYID.isNotNull());
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "InfoCustodyNoTancat_FilterForm";
    }

}
