package es.caib.digitalib.back.controller.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.UsuariPersonaController;
import es.caib.digitalib.back.form.webdb.UsuariPersonaForm;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.persistence.ConfiguracioGrupJPA;
import es.caib.digitalib.persistence.UsuariPersonaJPA;
import es.caib.digitalib.logic.ConfiguracioGrupLogicaService;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/common/usuaripersona")
public class UsuariPersonaCommonController extends UsuariPersonaController {

  @EJB(mappedName = ConfiguracioGrupLogicaService.JNDI_NAME)
  protected ConfiguracioGrupLogicaService configuracioGrupLogicaEjb;
  
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

    if (Configuracio.useDir3OfGroupConfiguration()) {
        usuariPersonaForm.addHiddenField(UNITATDIR3);
    }
        
    usuariPersonaForm.setDeleteButtonVisible(false);
    usuariPersonaForm.setCancelButtonVisible(false);
    
    return usuariPersonaForm;
  }

  @Override
  public UsuariPersonaJPA update(HttpServletRequest request, UsuariPersonaJPA usuariPersona) throws I18NException, I18NValidationException {
	  updateLoginInfo(usuariPersona);
	  return super.update(request, usuariPersona);  
  }
  
  private void updateLoginInfo(UsuariPersonaJPA usuariPersona) {
	  //Si hi ha canvis entre les noves dades de UsuariPersona i el LoginInfo, s'actualitza LoginInfo
	SecurityContext sc = SecurityContextHolder.getContext();
    Authentication au = sc.getAuthentication();
	  
	User user = (User) au.getPrincipal();
	  
	Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
	Collection<GrantedAuthority> seyconAuthorities = user.getAuthorities();
	  
	roles.addAll(seyconAuthorities);
	  
    LoginInfo logInf = LoginInfo.getInstance();
    UsuariPersonaJPA up = logInf.getUsuariPersona();
    
    //Dades normals
    if (up.getUsername().equals(usuariPersona.getUsername())) {
      
      if (!up.getNif().equals(usuariPersona.getNif())) {
        up.setNif(usuariPersona.getNif());
      } 
      if (!up.getNom().equals(usuariPersona.getNom())) {
        up.setNom(usuariPersona.getNom());
      }
      if (!up.getLlinatges().equals(usuariPersona.getLlinatges())) {
        up.setLlinatges(usuariPersona.getLlinatges());
      } 
      if (!up.getEmail().equals(usuariPersona.getEmail())) {
        up.setEmail(usuariPersona.getEmail());
      } 
      if (!up.getIdiomaID().equals(usuariPersona.getIdiomaID())) {
        up.setIdiomaID(usuariPersona.getIdiomaID());
      } 
     
      //Permisos
      if (up.isRoleCoAu() != usuariPersona.isRoleCoAu()) 
        up.setRoleCoAu(usuariPersona.isRoleCoAu());
      if (up.isRoleCust() != usuariPersona.isRoleCust()) 
        up.setRoleCust(usuariPersona.isRoleCust());
      if (up.isRoleScan() != usuariPersona.isRoleScan()) 
        up.setRoleScan(usuariPersona.isRoleCust());
      
      if (up.isRoleScan())
        roles.add(new SimpleGrantedAuthority(Constants.ROLE_SCAN));
      if (up.isRoleCoAu())
        roles.add(new SimpleGrantedAuthority(Constants.ROLE_COAU));
      if (up.isRoleCust())
        roles.add(new SimpleGrantedAuthority(Constants.ROLE_CUST));
    
      //Configuracio Grup
      if (up.getConfiguracioGrupID() != usuariPersona.getConfiguracioGrupID()) {
        ConfiguracioGrupJPA configuracioGrup = configuracioGrupLogicaEjb.findByPrimaryKey(usuariPersona.getConfiguracioGrupID());
        up.setConfiguracioGrup(configuracioGrup);
      }
      
      boolean necesitaConfigurar = false;
      LoginInfo loginInfo = new LoginInfo(user, up, roles, necesitaConfigurar);
      
      SecurityContextHolder.getContext().setAuthentication(loginInfo.generateToken());
    }
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
