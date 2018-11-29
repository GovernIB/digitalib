package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.webdb.TransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;

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

			filterForm.setOrderBy(TransaccioFields.DATAFI.fullName);
			filterForm.setOrderAsc(false);

			filterForm.addAdditionalButtonForEachItem(new AdditionalButton(
					"icon-eye-open icon-white", "transaccio.veuredetall",
					TransaccioAdminController.CONTEXTWEB + "/view/{0}", "btn-primary"));

			filterForm.addAdditionalButtonForEachItem(new AdditionalButton(
					"icon-user icon-white", "transaccio.veureperfil",
					TransaccioAdminController.CONTEXTWEB + "/viewperfil/{0}", "btn-info"));
		}
		filterForm.setVisibleMultipleSelection(false);
		filterForm.setAddButtonVisible(false);
		filterForm.setDeleteButtonVisible(false);
		filterForm.setEditButtonVisible(false);

		return filterForm;
	}

	@RequestMapping(value = "/viewperfil/{transaccioID}", method = RequestMethod.GET)
	public ModelAndView veurePerfilGet(@PathVariable("transaccioID") java.lang.Long transaccioID,
			HttpServletRequest request,
			HttpServletResponse response) throws I18NException {
		Long perfilID = transaccioEjb.executeQueryOne(TransaccioFields.PERFILID, TransaccioFields.TRANSACCIOID.equal(transaccioID));

		return new ModelAndView(new RedirectView(PerfilInfoTransaccioAdminController.CONTEXTWEB + "/view/"+ perfilID, true));
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
		return false;
	}

	@Override
	public boolean isActiveFormView() {
		return true;
	}

	@Override
	public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
			ModelAndView mav, Where where)  throws I18NException {

		List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_EXPIRED), I18NUtils.tradueix("estatcodi._3")));
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_CANCELLED), I18NUtils.tradueix("estatcodi._2")));
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_FINAL_ERROR), I18NUtils.tradueix("estatcodi._1")));
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_REQUESTED_ID), I18NUtils.tradueix("estatcodi._0")));
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_IN_PROGRESS), I18NUtils.tradueix("estatcodi._1")));
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_FINAL_OK), I18NUtils.tradueix("estatcodi._2")));
		return __tmp;
	}

	@Override
	public void postList(HttpServletRequest request, ModelAndView mav, TransaccioFilterForm filterForm,  List<Transaccio> list) throws I18NException {

	}

}
