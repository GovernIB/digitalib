package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.UsuariPersonaController;
import es.caib.digitalib.back.form.webdb.UsuariPersonaFilterForm;
import es.caib.digitalib.back.form.webdb.UsuariPersonaForm;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.model.fields.UsuariPersonaQueryPath;

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
	public static final String CONTEXTWEBCONFGRUP = "/admin/configuracioGrup/";

	public static final int CONFIGURACIOGRUPCOLUMN= 1;

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
	public UsuariPersonaForm getUsuariPersonaForm(UsuariPersonaJPA _jpa,
			boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
		UsuariPersonaForm usuariPersonaForm = super.getUsuariPersonaForm(_jpa, __isView, request, mav);


		return usuariPersonaForm;
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
						+ request.getContextPath() + CONTEXTWEBCONFGRUP + up.getConfiguracioGrupID()
						+ "/edit\">" + confgrup.getValue() + "</a><br/>\n");

				map.put(key, str.toString());
			}
		}
	}
}
