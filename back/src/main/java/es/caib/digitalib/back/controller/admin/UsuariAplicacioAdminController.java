package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.UsuariAplicacioController;
import es.caib.digitalib.back.form.webdb.UsuariAplicacioFilterForm;
import es.caib.digitalib.back.form.webdb.UsuariAplicacioForm;
import es.caib.digitalib.jpa.TraduccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.model.entity.UsuariAplicacio;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioQueryPath;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = UsuariAplicacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { UsuariAplicacioForm.class, UsuariAplicacioFilterForm.class })
public class UsuariAplicacioAdminController extends UsuariAplicacioController {

	public static final int PERFILCOLUMN = 1;

	public static final String CONTEXTWEB = "/admin/usuariAplicacio";

	public static final String USUARI_APLICACIO_PER_AFEGIR_PERFIL = "USUARI_APLICACIO_PER_AFEGIR_PERFIL";

	@EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal.JNDI_NAME)
	protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;
	
	@EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;
	
	@EJB(mappedName = es.caib.digitalib.ejb.TraduccioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.TraduccioLocal traduccioEjb;

	@Override
	public String getTileForm() {
		return "usuariAplicacioFormAdmin";
	}

	@Override
	public String getTileList() {
		return "usuariAplicacioListAdmin";
	}

	@Override
	public String getSessionAttributeFilterForm() {
		return "UsuariAplicacioAdmin_FilterForm";
	}

	@Override
	public UsuariAplicacioFilterForm getUsuariAplicacioFilterForm(Integer pagina,
			ModelAndView mav, HttpServletRequest request) throws I18NException {
		UsuariAplicacioFilterForm usuariAplicacioFilterForm = super.getUsuariAplicacioFilterForm(
				pagina, mav, request);

		usuariAplicacioFilterForm.setTitleCode("usuariaplicacio.llistat");

		if (usuariAplicacioFilterForm.isNou()) {

			Set<Field<?>> ocults = new HashSet<Field<?>>(
					Arrays.asList(UsuariAplicacioFields.ALL_USUARIAPLICACIO_FIELDS));

			ocults.remove(USERNAME);
			ocults.remove(UsuariAplicacioFields.DESCRIPCIO);
			ocults.remove(UsuariAplicacioFields.EMAILADMIN);

			usuariAplicacioFilterForm.setHiddenFields(ocults);

			usuariAplicacioFilterForm.setOrderBy(USERNAME.fullName);

			usuariAplicacioFilterForm.addAdditionalButtonForEachItem(new AdditionalButton(
					"icon-plus-sign icon-white", "perfil.afegir",
					UsuariAplicacioAdminController.CONTEXTWEB + "/createperfilusrapp/{0}", "btn-primary"));

			AdditionalField<Long, String> adfield4 = new AdditionalField<Long, String>();
			adfield4.setCodeName("perfil.perfil.plural");
			adfield4.setPosition(PERFILCOLUMN);
			// Els valors s'ompliran al mètode postList()
			adfield4.setValueMap(new HashMap<Long, String>());
			adfield4.setEscapeXml(false);

			usuariAplicacioFilterForm.addAdditionalField(adfield4);

		}

		return usuariAplicacioFilterForm;
	}

	@Override
	public UsuariAplicacioForm getUsuariAplicacioForm(UsuariAplicacioJPA _jpa, boolean __isView,
			HttpServletRequest request, ModelAndView mav) throws I18NException {
		UsuariAplicacioForm usuariAplicacioForm = super.getUsuariAplicacioForm(_jpa, __isView,
				request, mav);

		usuariAplicacioForm.getUsuariAplicacio().setActiu(true);
		usuariAplicacioForm.addHiddenField(CONTRASENYA);

		return usuariAplicacioForm;
	}

	@RequestMapping(value = "/createperfilusrapp/{usrappid}", method = RequestMethod.GET)
	public String crearUserAppPerfil(HttpServletRequest request, HttpServletResponse response,
			@PathVariable Long usrappid) throws I18NException {

		request.getSession().setAttribute(USUARI_APLICACIO_PER_AFEGIR_PERFIL, usrappid);

		return "redirect:" + PerfilUsuariAplicacioAdminController.CONTEXTWEB +  "/new";

	}

	@RequestMapping(value = "/deleteperfilusrapp/{id}", method = RequestMethod.GET)
	public String deleteUserAppPerfil(HttpServletRequest request, HttpServletResponse response,
			@PathVariable Long id) throws I18NException {

		perfilUsuariAplicacioEjb.delete(id);

		// request.getSession().setAttribute("USUARI_APLICAIO_PER_AFEGIR_PERFIL", usrappid);

		return "redirect:" + UsuariAplicacioAdminController.CONTEXTWEB + "/list";

	}


	@RequestMapping(value = "/editarperfil/{id}", method = RequestMethod.GET)
	public String editarperfil(HttpServletRequest request, HttpServletResponse response,
			@PathVariable Long id) throws I18NException {

		PerfilUsuariAplicacio perusrapp = perfilUsuariAplicacioEjb.findByPrimaryKey(id);

		// request.getSession().setAttribute("USUARI_APLICAIO_PER_AFEGIR_PERFIL", usrappid);
		
		Perfil perf = perfilEjb.findByPrimaryKey(perusrapp.getPerfilID());
		String contextWeb = "";
		
		switch (perf.getUsPerfil()) {
		  case Constants.PERFIL_US_NOMES_ESCANEIG:
		    contextWeb = PerfilEscaneigPerAplicacioAdminController.CONTEXTWEB;
		    break;
		  case Constants.PERFIL_US_COPIA_AUTENTICA:
		    contextWeb = PerfilCopiaAutenticaPerAplicacioAdminController.CONTEXTWEB;
		    break;
		  case Constants.PERFIL_US_CUSTODIA:
		    contextWeb = PerfilCustodiaPerAplicacioAdminController.CONTEXTWEB;
		    break;
		}
		contextWeb += "/";
		return "redirect:" + contextWeb + perusrapp.getPerfilID() + "/edit";
	}


	@Override
	public void postList(HttpServletRequest request, ModelAndView mav,
			UsuariAplicacioFilterForm filterForm, List<UsuariAplicacio> list) throws I18NException {

		Map<Long, String> map;
		map = (Map<Long, String>) filterForm.getAdditionalField(PERFILCOLUMN).getValueMap();
		map.clear();
		long key;

		for (UsuariAplicacio ua : list) {
			key = ua.getUsuariAplicacioID();

			SelectMultipleStringKeyValue smskv = new SelectMultipleStringKeyValue(
					PerfilUsuariAplicacioFields.PERFILUSRAPPID.select,
					new PerfilUsuariAplicacioQueryPath().PERFIL().NOMID().select);

			List<StringKeyValue> perfils = perfilUsuariAplicacioEjb.executeQuery(smskv,
					PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(key));

			StringBuffer str = new StringBuffer();

			for (StringKeyValue per : perfils) {
			  TraduccioJPA trad = traduccioEjb.findByPrimaryKey(Long.valueOf(per.getValue()));
				
			  str.append("<a style=\"padding: 0px; margin-bottom: 4px; margin-right: 4px\" href=\"" + request.getContextPath() + getContextWeb()
				+ "/deleteperfilusrapp/" + per.getKey()
				+ "\" class=\"btn btn-mini btn-danger\" type=\"button\">"
				+ "<i style=\"padding: 0px 4px 4px 0px; margin: 4px 0px 0px 3px \" class=\"icon-trash icon-white\"></i></a><a href=\""
				+ request.getContextPath() + getContextWeb() + "/editarperfil/" + per.getKey()
				+ "\">" + trad.getTraduccio("ca").getValor() +"/"+trad.getTraduccio("es").getValor()
				+ "</a><br/>\n");
			}

			map.put(key, str.toString());
		}
	}

}
