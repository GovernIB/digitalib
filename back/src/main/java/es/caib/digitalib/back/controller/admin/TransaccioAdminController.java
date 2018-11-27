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
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.plugins.scanweb.api.ScanWebStatus;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.TransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.back.form.webdb.UsuariAplicacioFilterForm;
import es.caib.digitalib.back.form.webdb.UsuariAplicacioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.UsuariAplicacio;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioQueryPath;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.back.controller.scanwebsimple.*;

/**
 * 
 * @author u139636
 *
 */
@Controller
@RequestMapping(value = TransaccioAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioAdminController extends TransaccioController {

	public static final String CONTEXTWEB = "/admin/transaccio";

	@Override
	public String getTileForm() {
		return "transaccioFormAdmin";
	}

	@Override
	public String getTileList() {
		return "transaccioListAdmin";
	}

	@Override
	public String getSessionAttributeFilterForm() {
		return "TransaccioAdmin_FilterForm";
	}

	@Override
	public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {

		TransaccioFilterForm filterForm = super.getTransaccioFilterForm(pagina, mav, request);

		if (filterForm.isNou()) {

			Set<Field<?>> ocults = new HashSet<Field<?>>(
					Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

			ocults.remove(TransaccioFields.TRANSACTIONWEBID);
			ocults.remove(TransaccioFields.DATAINICI);
			ocults.remove(TransaccioFields.DATAFI);
			ocults.remove(TransaccioFields.ESTATCODI);
			ocults.remove(TransaccioFields.USUARIPERSONAID);
			ocults.remove(TransaccioFields.USUARIAPLICACIOID);

			filterForm.setHiddenFields(ocults);

		}
		filterForm.setVisibleMultipleSelection(false);
		filterForm.setAddButtonVisible(false);
		filterForm.setDeleteButtonVisible(false);
		filterForm.setEditButtonVisible(false);

		return filterForm;
	}

	@Override
	public TransaccioForm getTransaccioForm(TransaccioJPA _jpa,
			boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
		TransaccioForm form = super.getTransaccioForm(_jpa, __isView, request, mav);

		return form;

	}

	@Override
	public boolean isActiveList() {
		return true;
	}

	@Override
	public boolean isActiveFormNew() {
		return false;
	}

	@Override
	public boolean isActiveFormEdit() {
		return false;
	}

	@Override
	public boolean isActiveDelete() {
		return true;
	}

	@Override
	public boolean isActiveFormView() {
		return isActiveFormEdit();
	}

//	XYZ ZZZ
//	@Override
//	public List<StringKeyValue> getReferenceListForEstatcodi(HttpServletRequest request,
//			ModelAndView mav, Where where)  throws I18NException {
//		
//		List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
//		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_EXPIRED), "-3"));
//		__tmp.add(new StringKeyValue("-2-" , "-2-"));
//		__tmp.add(new StringKeyValue("1" , "1"));
//		__tmp.add(new StringKeyValue("0" , "0"));
//		__tmp.add(new StringKeyValue("1" , "1"));
//		__tmp.add(new StringKeyValue("2" , "2"));
//		return __tmp;
//	}

	@Override
	public void postList(HttpServletRequest request, ModelAndView mav, TransaccioFilterForm filterForm,  List<Transaccio> list) throws I18NException {

	}

}
