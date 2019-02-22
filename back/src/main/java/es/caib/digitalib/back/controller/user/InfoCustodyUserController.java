package es.caib.digitalib.back.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractInfoCustodyController;
import es.caib.digitalib.back.form.webdb.InfoCustodyFilterForm;
import es.caib.digitalib.back.form.webdb.InfoCustodyForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.InfoCustodyJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */

@Controller
@RequestMapping(value = InfoCustodyUserController.CONTEXT_WEB_USER_INFO_CUSTODY)
@SessionAttributes(types = { InfoCustodyForm.class, InfoCustodyFilterForm.class })
public class InfoCustodyUserController extends AbstractInfoCustodyController {

  public static final String CONTEXT_WEB_USER_INFO_CUSTODY = "/user/infoCustody";

  @Override
  public boolean isAdmin() {
    return false;
  }

  @Override
  public InfoCustodyForm getInfoCustodyForm(InfoCustodyJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    InfoCustodyForm infoCForm = super.getInfoCustodyForm(_jpa, __isView, request,
        mav);

    Utils.hideNullFields(infoCForm.getInfoCustody(), infoCForm,
        ALL_INFOCUSTODY_FIELDS);
    infoCForm.setCancelButtonVisible(false);

    return infoCForm;

  }
}
