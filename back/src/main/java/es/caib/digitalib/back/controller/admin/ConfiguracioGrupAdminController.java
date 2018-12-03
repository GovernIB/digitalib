package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.ConfiguracioGrupController;
import es.caib.digitalib.back.form.webdb.ConfiguracioGrupFilterForm;
import es.caib.digitalib.back.form.webdb.ConfiguracioGrupForm;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.utils.Constants;

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

	@Override
	public List<StringKeyValue> getReferenceListForPerfilNomesEscaneigID(HttpServletRequest request,
			ModelAndView mav, Where where)  throws I18NException {

		Where w = Where.AND(where,
				PerfilFields.USPERFIL.equal(Constants.PERFIL_US_NOMES_ESCANEIG));

		return perfilRefList.getReferenceList(PerfilFields.PERFILID, w );
	}

	@Override
	public List<StringKeyValue> getReferenceListForPerfilCopiaAutenticaID(HttpServletRequest request,
			ModelAndView mav, Where where)  throws I18NException {
		Where w = Where.AND(where,
				PerfilFields.USPERFIL.equal(Constants.PERFIL_US_COPIA_AUTENTICA));
		
		return perfilRefList.getReferenceList(PerfilFields.PERFILID, w );
	}

	@Override
	public List<StringKeyValue> getReferenceListForPerfilCustodiaID(HttpServletRequest request,
			ModelAndView mav, Where where)  throws I18NException {
		Where w = Where.AND(where,
				PerfilFields.USPERFIL.equal(Constants.PERFIL_US_CUSTODIA));
		
		return perfilRefList.getReferenceList(PerfilFields.PERFILID, w );
	}

	public ConfiguracioGrupFilterForm getConfiguracioGrupFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		ConfiguracioGrupFilterForm configuracioGrupFilterForm = super.getConfiguracioGrupFilterForm(pagina, mav, request);

		configuracioGrupFilterForm.setTitleCode("configuraciogrup.llistat");

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
