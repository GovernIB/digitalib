package es.caib.digitalib.back.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.ConfiguracioGrupController;
import es.caib.digitalib.back.form.webdb.ConfiguracioGrupFilterForm;
import es.caib.digitalib.back.form.webdb.ConfiguracioGrupForm;
import es.caib.digitalib.back.form.webdb.UsuariAplicacioFilterForm;
import es.caib.digitalib.back.form.webdb.UsuariAplicacioForm;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.PerfilFields;

/**
 * 
 * @author u139636
 *
 */
@Controller
@RequestMapping(value = ConfiguracioGrupAdminController.CONTEXTWEB)
@SessionAttributes(types = { ConfiguracioGrupForm.class, ConfiguracioGrupFilterForm.class })
public class ConfiguracioGrupAdminController extends ConfiguracioGrupController{

	public static final String CONTEXTWEB = "/admin/configuracioGrup";

	public String getTileForm() {
		return "configuracioGrupFormAdmin";
	}

	public String getTileList() {
		return "configuracioGrupListAdmin";
	}

	public String getSessionAttributeFilterForm() {
		return "ConfiguracioGrupAdmin_FilterForm";
	}

	public ConfiguracioGrupFilterForm getConfiguracioGrupFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		ConfiguracioGrupFilterForm configuracioGrupFilterForm = super.getConfiguracioGrupFilterForm(pagina, mav, request);

		if (configuracioGrupFilterForm.isNou()) {
			Set<Field<?>> ocults = new HashSet<Field<?>>(
					Arrays.asList(ConfiguracioGrupFields.ALL_CONFIGURACIOGRUP_FIELDS));
	
			ocults.remove(CONFIGURACIOGRUPID);
			ocults.remove(NOM);
	
			configuracioGrupFilterForm.setHiddenFields(ocults);
			
		}
		return configuracioGrupFilterForm;

	}

	public ConfiguracioGrupForm getConfiguracioGrupForm(ConfiguracioGrupJPA _jpa,
			boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {

		ConfiguracioGrupForm configuracioGrupForm = super.getConfiguracioGrupForm(_jpa, __isView, request, mav);


		return configuracioGrupForm;

	}
}
