package es.caib.digitalib.back.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.UsuariPersonaController;
import es.caib.digitalib.back.form.webdb.UsuariPersonaForm;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.utils.Configuracio;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/common/usuaripersona")
public class UsuariPersonaCommonController extends UsuariPersonaController {

  @Override
  public String getTileForm() {
    return "usuariPersonaFormCommon";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "UsuariPersonaCommon_FilterForm";
  }

  @Override
  public UsuariPersonaForm getUsuariPersonaForm(UsuariPersonaJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    UsuariPersonaForm usuariPersonaForm = super.getUsuariPersonaForm(_jpa, __isView, request,
        mav);

    usuariPersonaForm.setTitleCode("inici.usuaripersona");
    
    UsuariPersona up = usuariPersonaForm.getUsuariPersona();
    // Comprovam que no es modifiqui un usuari que no es amb el que t'has logueat
    if (!up.getUsername().equals(LoginInfo.getInstance().getUsername())) {
      throw new I18NException("error.unknown",
          I18NUtils.tradueix("error.desconegut.modificar.persona"));
    }

    if (usuariPersonaForm.getUsuariPersona().getEmail() != null) {
      usuariPersonaForm.addReadOnlyField(EMAIL);
    }
    usuariPersonaForm.addReadOnlyField(USERNAME);
    usuariPersonaForm.addReadOnlyField(NIF);
    
    if (Configuracio.isCAIB()) {
      usuariPersonaForm.addHiddenField(CONFIGURACIOGRUPID);
      usuariPersonaForm.addHiddenField(ROLECUST);
      usuariPersonaForm.addHiddenField(ROLECOAU);
      usuariPersonaForm.addHiddenField(ROLESCAN);
    } else {
      usuariPersonaForm.addReadOnlyField(ROLECOAU);
      usuariPersonaForm.addReadOnlyField(ROLESCAN);
      usuariPersonaForm.addReadOnlyField(ROLECUST);
      usuariPersonaForm.addReadOnlyField(CONFIGURACIOGRUPID);
    }
        
    usuariPersonaForm.setDeleteButtonVisible(false);
    usuariPersonaForm.setCancelButtonVisible(false);
    
    return usuariPersonaForm;
  }

  @Override
  public String getRedirectWhenModified(HttpServletRequest request,
      UsuariPersonaForm usuariPersonaForm, Throwable __e) {
//    return "redirect:" + getContextWeb() + "/"
//        + usuariPersonaForm.getUsuariPersona().getUsuariPersonaID() + "/edit";
    return "redirect:/canviarPipella/user";
  }

  // Mètodes a sobreescriure

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

  public boolean isActiveFormView() {
    return false;
  }

}
