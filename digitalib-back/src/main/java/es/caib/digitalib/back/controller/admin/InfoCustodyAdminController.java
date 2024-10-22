package es.caib.digitalib.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractInfoCustodyController;
import es.caib.digitalib.back.form.webdb.InfoCustodyFilterForm;
import es.caib.digitalib.back.form.webdb.InfoCustodyForm;
import es.caib.digitalib.persistence.InfoCustodyJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */

@Controller
@RequestMapping(value = InfoCustodyAdminController.CONTEXT_WEB_ADMIN_INFO_CUSTODY)
@SessionAttributes(types = { InfoCustodyForm.class, InfoCustodyFilterForm.class })
public class InfoCustodyAdminController extends AbstractInfoCustodyController {

    public static final String CONTEXT_WEB_ADMIN_INFO_CUSTODY = "/admin/infoCustody";

    @Override
    public boolean isAdmin() {
        return true;
    }

    @Override
    public InfoCustodyForm getInfoCustodyForm(InfoCustodyJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        InfoCustodyForm infoCForm = super.getInfoCustodyForm(_jpa, __isView, request, mav);

        infoCForm.setCancelButtonVisible(false);

        return infoCForm;

    }
}
