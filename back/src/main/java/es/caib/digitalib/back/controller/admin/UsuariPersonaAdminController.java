package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.UsuariPersonaController;
import es.caib.digitalib.back.form.webdb.UsuariPersonaFilterForm;
import es.caib.digitalib.back.form.webdb.UsuariPersonaForm;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.logic.ConfiguracioGrupLogicaLocal;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.model.fields.UsuariPersonaQueryPath;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author u139636
 *
 */
@Controller
@RequestMapping(value = UsuariPersonaAdminController.CONTEXTWEB)
@SessionAttributes(types = { UsuariPersonaForm.class, UsuariPersonaFilterForm.class })
public class UsuariPersonaAdminController extends UsuariPersonaController{

	public static final String CONTEXTWEB = "/admin/usuariPersona";

	public static final int CONFIGURACIOGRUPCOLUMN= 1;
	
	@EJB(mappedName = ConfiguracioGrupLogicaLocal.JNDI_NAME)
  protected ConfiguracioGrupLogicaLocal configuracioGrupLogicaEjb;

	@Override
	public String getTileForm() {
		return "usuariPersonaFormAdmin";
	}

	@Override
	public String getTileList() {
		return "usuariPersonaListAdmin";
	}

	@Override
	public String getSessionAttributeFilterForm() {
		return "UsuariPersonaAdmin_FilterForm";
	}

	@Override
	public UsuariPersonaForm getUsuariPersonaForm(UsuariPersonaJPA _jpa,
      boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
	  UsuariPersonaForm form = super.getUsuariPersonaForm(_jpa, __isView, request, mav);
	  
	  Set<Field<?>> readOnly = new HashSet<Field<?>>();
	  readOnly.add(USERNAME);
	  
	  form.setReadOnlyFields(readOnly);
	  
	  return form;
	}
	
	@Override
	public UsuariPersonaFilterForm getUsuariPersonaFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		UsuariPersonaFilterForm usuariPersonaFilterForm = super.getUsuariPersonaFilterForm(pagina, mav, request);

		usuariPersonaFilterForm.setTitleCode("usuaripersona.llistat");

		if (usuariPersonaFilterForm.isNou()) {
			usuariPersonaFilterForm.addGroupByField(CONFIGURACIOGRUPID);

			Set<Field<?>> ocults = new HashSet<Field<?>>(
					Arrays.asList(UsuariPersonaFields.ALL_USUARIPERSONA_FIELDS));

			ocults.remove(NOM);
			ocults.remove(LLINATGES);
			ocults.remove(USERNAME);
			ocults.remove(EMAIL);
			ocults.remove(NIF);

			usuariPersonaFilterForm.setHiddenFields(ocults);

			usuariPersonaFilterForm.setVisibleMultipleSelection(false);

			AdditionalField<Long,String> adfield4 = new AdditionalField<Long,String>(); 
			adfield4.setCodeName("configuracioGrup.configuracioGrup");
			adfield4.setPosition(CONFIGURACIOGRUPCOLUMN);
			// Els valors s'ompliran al mètode postList()
			adfield4.setValueMap(new HashMap<Long, String>());
			adfield4.setEscapeXml(false);

			usuariPersonaFilterForm.addAdditionalField(adfield4);
		}
		return usuariPersonaFilterForm;
	}
	
	@Override
	public UsuariPersonaJPA update(HttpServletRequest request, UsuariPersonaJPA usuariPersona)
		    throws Exception,I18NException, I18NValidationException {
		
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
	public void postList(HttpServletRequest request, ModelAndView mav, 
			UsuariPersonaFilterForm filterForm,  List<UsuariPersona> list) throws I18NException {

		Map<Long, String> map;
		map = (Map<Long, String>) filterForm.getAdditionalField(CONFIGURACIOGRUPCOLUMN).getValueMap();
		map.clear();
		long key;

		for (UsuariPersona up : list) {
			key = up.getUsuariPersonaID();

			SelectMultipleStringKeyValue smskv = new SelectMultipleStringKeyValue(
					UsuariPersonaFields.USUARIPERSONAID.select,
					new UsuariPersonaQueryPath().CONFIGURACIOGRUP().NOM().select);

			List<StringKeyValue> confgrups = usuariPersonaEjb.executeQuery(smskv,
					UsuariPersonaFields.USUARIPERSONAID.equal(key));

			StringBuffer str = new StringBuffer();

			for (StringKeyValue confgrup : confgrups) {

				str.append("<a href=\""
						+ request.getContextPath() + ConfiguracioGrupAdminController.CONTEXTWEB + up.getConfiguracioGrupID()
						+ "/edit\">" + confgrup.getValue() + "</a><br/>\n");

				map.put(key, str.toString());
			}
		}
	}
}
