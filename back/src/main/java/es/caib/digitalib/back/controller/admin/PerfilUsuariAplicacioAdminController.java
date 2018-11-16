package es.caib.digitalib.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.PerfilUsuariAplicacioController;
import es.caib.digitalib.back.form.webdb.PerfilUsuariAplicacioFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilUsuariAplicacioForm;
import es.caib.digitalib.jpa.PerfilUsuariAplicacioJPA;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/admin/perfilUsuariAplicacio")
@SessionAttributes(types = { PerfilUsuariAplicacioForm.class, PerfilUsuariAplicacioFilterForm.class })
public class PerfilUsuariAplicacioAdminController extends PerfilUsuariAplicacioController {

  
  @Override
  public String getRedirectWhenCreated(HttpServletRequest request, PerfilUsuariAplicacioForm perfilUsuariAplicacioForm) {
    return "redirect:" + UsuariAplicacioAdminController.CONTEXTWEB + "/list";
  }

  @Override
  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long perfilUsrAppID) {
    return "redirect:" + UsuariAplicacioAdminController.CONTEXTWEB + "/list";
  }

  @Override
  public String getTileForm() {
    return "perfilUsuariAplicacioFormAdmin";
  }


  @Override
  public String getSessionAttributeFilterForm() {
    return "PerfilUsuariAplicacioAdmin_FilterForm";
  }


  @Override
  public boolean isActiveList() {
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
    return false;
  }
  
  @Override
  public PerfilUsuariAplicacioForm getPerfilUsuariAplicacioForm(PerfilUsuariAplicacioJPA _jpa,
      boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
   PerfilUsuariAplicacioForm perfilUsuariAplicacioForm = super.getPerfilUsuariAplicacioForm(_jpa, __isView, request, mav);
   
   Long id = (Long)request.getSession().getAttribute(UsuariAplicacioAdminController.USUARI_APLICAIO_PER_AFEGIR_PERFIL);
   
   perfilUsuariAplicacioForm.getPerfilUsuariAplicacio().setUsuariAplicacioID(id);
   
   perfilUsuariAplicacioForm.addReadOnlyField(USUARIAPLICACIOID);

   return perfilUsuariAplicacioForm;
  }
   
  
  
}
