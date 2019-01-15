package es.caib.digitalib.back.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.PerfilUsuariAplicacioController;
import es.caib.digitalib.back.form.webdb.PerfilUsuariAplicacioFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilUsuariAplicacioForm;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.PerfilUsuariAplicacioJPA;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = PerfilUsuariAplicacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { PerfilUsuariAplicacioForm.class, PerfilUsuariAplicacioFilterForm.class })
public class PerfilUsuariAplicacioAdminController extends PerfilUsuariAplicacioController {

	public static final String CONTEXTWEB = "/admin/perfilUsuariAplicacio";
	
  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

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

		Long id = (Long)request.getSession().getAttribute(UsuariAplicacioAdminController.USUARI_APLICACIO_PER_AFEGIR_PERFIL);

		perfilUsuariAplicacioForm.getPerfilUsuariAplicacio().setUsuariAplicacioID(id);

		perfilUsuariAplicacioForm.addReadOnlyField(USUARIAPLICACIOID);

		return perfilUsuariAplicacioForm;
	}

	
	@Override
  public List<StringKeyValue> getReferenceListForPerfilID(HttpServletRequest request,
      ModelAndView mav, Where where)  throws I18NException {
	  
	  
	  Long idApp = (Long)request.getSession().getAttribute(UsuariAplicacioAdminController.USUARI_APLICACIO_PER_AFEGIR_PERFIL);

	  
	  Where w = Where.AND(
	      where, 
	      PerfilFields.USPERFIL.greaterThan(0),
	      PerfilFields.PERFILID.notIn(perfilUsuariAplicacioEjb.getSubQuery(PerfilUsuariAplicacioFields.PERFILID, PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(idApp)))
	      );
	  
	  List<Perfil> perfils = perfilEjb.select(w);
	  
	  List<StringKeyValue> listSKV = new ArrayList<StringKeyValue>(perfils.size());
	  for (Perfil perfil : perfils) {
	    
	    listSKV.add(new StringKeyValue(String.valueOf(perfil.getPerfilID()), 
	        perfil.getCodi() + " - " 
	        + ((PerfilJPA)perfil).getNom().getTraduccio(I18NUtils.getLocale().getLanguage()).getValor()
	        + " [" + I18NUtils.tradueix( "transaccio.tipus." + perfil.getUsPerfil()) + "]") );
	    
	    
	    
    }
	  
	  
   return listSKV;
  }


}
