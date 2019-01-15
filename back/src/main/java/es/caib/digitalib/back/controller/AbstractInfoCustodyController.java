package es.caib.digitalib.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.admin.InfoCustodyAdminController;
import es.caib.digitalib.back.controller.user.InfoCustodyUserController;
import es.caib.digitalib.back.controller.webdb.InfoCustodyController;
import es.caib.digitalib.back.form.webdb.InfoCustodyForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.InfoCustodyJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */
public abstract class AbstractInfoCustodyController extends InfoCustodyController {

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
  
  
  @Override
  public InfoCustodyForm getInfoCustodyForm(InfoCustodyJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    InfoCustodyForm infoCForm = super.getInfoCustodyForm(_jpa, __isView, request,
        mav);

    Utils.hideNullFields(infoCForm.getInfoCustody(), infoCForm,
        ALL_INFOCUSTODY_FIELDS);

    return infoCForm;

  }

  public static String getContextWeb(boolean isAdmin) {
    return isAdmin ? InfoCustodyAdminController.CONTEXT_WEB_ADMIN_INFO_CUSTODY
        : InfoCustodyUserController.CONTEXT_WEB_USER_INFO_CUSTODY;
  }
}
