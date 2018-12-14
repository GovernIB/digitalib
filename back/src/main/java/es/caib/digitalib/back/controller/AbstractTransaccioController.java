package es.caib.digitalib.back.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.webdb.TransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.fields.TransaccioFields;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
public abstract class AbstractTransaccioController extends TransaccioController {


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
					getContextWeb() + "/view/{0}", "btn-primary"));

			
			if (getPerfilInfoContextWeb() != null) {
				filterForm.addAdditionalButtonForEachItem(new AdditionalButton(
					"icon-user icon-white", "transaccio.veureperfil",
					getContextWeb() + "/viewperfil/{0}", "btn-info"));
			}
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

		return new ModelAndView(new RedirectView(getPerfilInfoContextWeb() + "/view/"+ perfilID, true));
	}
	

	public abstract String getPerfilInfoContextWeb();

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
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_REQUESTED_ID), I18NUtils.tradueix("estatcodi.0")));
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_IN_PROGRESS), I18NUtils.tradueix("estatcodi.1")));
		__tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_FINAL_OK), I18NUtils.tradueix("estatcodi.2")));
		return __tmp;
	}

		

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamDocEstatElabora(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("EE01", "EE01 - Original (Llei 11/2007 Art. 30)"));
    __tmp.add(new StringKeyValue("EE02",
        "EE02 - Còpia electrònica autèntica amb canvi de format (Llei 11/2007 Art. 30.1)"));
    __tmp.add(new StringKeyValue("EE03", "EE03 - Còpia electrònica autèntica de document en"
        + " paper amb canvi de format (Llei 11/2007 Art. 30.2 i 30.3)."));
    __tmp.add(new StringKeyValue("EE04", "EE04 - Còpia electrònica parcial autèntica."));
    __tmp.add(new StringKeyValue("EE99", "EE99 - Altres estats d'elaboració."));

    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamDocumentTipus(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("TD01", "TD01 - RESOLUCIO"));
    __tmp.add(new StringKeyValue("TD02", "TD02 - ACORD"));
    __tmp.add(new StringKeyValue("TD03", "TD03 - CONTRACTE"));
    __tmp.add(new StringKeyValue("TD04", "TD04 - CONVENI"));
    __tmp.add(new StringKeyValue("TD05", "TD05 - DECLARACIO"));
    __tmp.add(new StringKeyValue("TD06", "TD06 - COMUNICACIO"));
    __tmp.add(new StringKeyValue("TD07", "TD07 - NOTIFICACIO"));
    __tmp.add(new StringKeyValue("TD08", "TD08 - PUBLICACIO"));
    __tmp.add(new StringKeyValue("TD09", "TD09 - JUSTIFICANT RECEPCIO"));
    __tmp.add(new StringKeyValue("TD10", "TD10 - ACTA"));
    __tmp.add(new StringKeyValue("TD11", "TD11 - CERTIFICAT"));
    __tmp.add(new StringKeyValue("TD12", "TD12 - DILIGENCIA"));
    __tmp.add(new StringKeyValue("TD13", "TD13 - INFORME"));
    __tmp.add(new StringKeyValue("TD14", "TD14 - SOLICITUD"));
    __tmp.add(new StringKeyValue("TD15", "TD15 - DENUNCIA"));
    __tmp.add(new StringKeyValue("TD16", "TD16 - ALEGACIO"));
    __tmp.add(new StringKeyValue("TD17", "TD17 - RECURS"));
    __tmp.add(new StringKeyValue("TD18", "TD18 - COMUNICACIO_CIUTADA"));
    __tmp.add(new StringKeyValue("TD19", "TD19 - FACTURA"));
    __tmp.add(new StringKeyValue("TD20", "TD20 - ALTRES_INCAUTATS"));
    __tmp.add(new StringKeyValue("TD99", "TD99 - ALTRES"));

    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamOrigen(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("0", "Ciutadà"));
    __tmp.add(new StringKeyValue("1", "Administració"));
    return __tmp;
  }

  public List<StringKeyValue> getReferenceListForSignParamLanguageDoc(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("ca", "Català"));
    __tmp.add(new StringKeyValue("es", "Castellà"));
    __tmp.add(new StringKeyValue("en", "Anglès"));
    __tmp.add(new StringKeyValue("de", "Alemany"));
    return __tmp;
  }

}
