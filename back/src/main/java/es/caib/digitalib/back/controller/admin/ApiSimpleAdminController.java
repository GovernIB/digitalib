package es.caib.digitalib.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.ApiSimpleController;
import es.caib.digitalib.back.form.webdb.ApiSimpleFilterForm;
import es.caib.digitalib.back.form.webdb.ApiSimpleForm;
import es.caib.digitalib.back.form.webdb.PerfilFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilForm;
import es.caib.digitalib.jpa.ApiSimpleJPA;

/**
 * 
 * @author u139636
 *
 */
@Controller
@RequestMapping(value = "/admin/apisimple")
@SessionAttributes(types = { ApiSimpleForm.class, ApiSimpleFilterForm.class })
public class ApiSimpleAdminController extends ApiSimpleController {

	@Override
	public String getTileForm() {
		return "apiSimpleFormAdmin";
	}

	@Override
	public String getTileList() {
		return "apiSimpleListAdmin";
	}

	@Override
	public String getSessionAttributeFilterForm() {
		return "ApiSimpleAdmin_FilterForm";
	}

	@Override
	public ApiSimpleFilterForm getApiSimpleFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {

		ApiSimpleFilterForm apiSimpleFilterForm = super.getApiSimpleFilterForm(pagina, mav, request);

		return apiSimpleFilterForm;
	}

	@Override
	public ApiSimpleForm getApiSimpleForm(ApiSimpleJPA _jpa,
			boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {

		ApiSimpleForm apiSimpleForm = super.getApiSimpleForm(_jpa, __isView, request, mav);

		return apiSimpleForm;
	}



}
