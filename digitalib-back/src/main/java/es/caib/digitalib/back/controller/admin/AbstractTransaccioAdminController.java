package es.caib.digitalib.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractTransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
public abstract class AbstractTransaccioAdminController extends AbstractTransaccioController {

  @Override
  public String getTileForm() {
    return "transaccioFormAdmin";
  }

  @Override
  public String getTileList() {
    return "transaccioListAdmin";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "TransaccioAdmin_FilterForm_" + isUtilitzatPerAplicacio();
  }

  @Override
  public String getPerfilInfoContextWeb() {
    return PerfilInfoTransaccioAdminController.CONTEXTWEB;
  }

  @Override
  public boolean isAdmin() {
    return true;
  }

  @Override
  public boolean isActiveDelete() {
    return true;
  }

  @Override
  public int getTipusPerfil() {
    return Constants.PERFIL_US_ALL_INFO; // No s'utilitza dins ADMIN
  }

  @Override
  public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    TransaccioForm form = super.getTransaccioForm(_jpa, __isView, request, mav);

    if (__isView) {
      // Afegir Boto de Veure Auditoria
      form.addAdditionalButton(new AdditionalButton(
              IconUtils.getWhite("fa-solid fa-user"),
          "transaccio.veureauditoria", "/admin/auditoria/transaccio/"
              + (isUtilitzatPerAplicacio() ? "aplicacio" : "persona") + "/t/"
              + _jpa.getTransaccioID(), "btn-info"));
    }

    return form;
  }

}
