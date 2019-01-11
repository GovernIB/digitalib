package es.caib.digitalib.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
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
    InfoSignaturaForm infoSignaturaForm = super.getInfoSignaturaForm(_jpa, __isView, request,
        mav);

    Utils.hideNullFields(infoSignaturaForm.getInfoSignatura(), infoSignaturaForm,
        ALL_INFOSIGNATURA_FIELDS);

    return infoSignaturaForm;

  }

  public static String getContextWeb(boolean isAdmin) {
    return isAdmin ? InfoSignatureAdminController.CONTEXT_WEB_ADMIN_INFO_SIGNATURE
        : InfoSignatureUserController.CONTEXT_WEB_USER_INFO_SIGNATURE;
  }
}