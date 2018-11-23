package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.UsuariPersonaController;
import es.caib.digitalib.back.form.webdb.UsuariPersonaFilterForm;
import es.caib.digitalib.back.form.webdb.UsuariPersonaForm;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.fields.UsuariPersonaFields;

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
	public UsuariPersonaFilterForm getUsuariPersonaFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		UsuariPersonaFilterForm usuariPersonaFilterForm = super.getUsuariPersonaFilterForm(pagina, mav, request);

		if (usuariPersonaFilterForm.isNou()) {
			usuariPersonaFilterForm.addGroupByField(CONFIGURACIOGRUPID);
			
			Set<Field<?>> idioma_ocult = new HashSet<Field<?>>(
					Arrays.asList(UsuariPersonaFields.IDIOMAID));

			usuariPersonaFilterForm.setHiddenFields(idioma_ocult);
			
			
		}
		return usuariPersonaFilterForm;
	}

	@Override
	public UsuariPersonaForm getUsuariPersonaForm(UsuariPersonaJPA _jpa,
			boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
		UsuariPersonaForm usuariPersonaForm = super.getUsuariPersonaForm(_jpa, __isView, request, mav);


		return usuariPersonaForm;
	}
}
