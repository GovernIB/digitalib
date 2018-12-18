package es.caib.digitalib.back.controller.admin;

import java.util.ArrayList;
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
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.PerfilController;
import es.caib.digitalib.back.form.webdb.PerfilFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilForm;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PluginFields;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal
 * @author u139636
 *
 */
public abstract class AbstractPerfilAdminController extends PerfilController {

	public static final int TIPUSFIRMACOLUMN = 1;

	public abstract int getTipusPerfil();
	
	public abstract boolean isUtilitzatPerAplicacio();

	public static final String CONTEXTWEB = "/admin/perfil";

	@Override
	public String getTileForm() {
		return "perfilFormAdmin";
	}

	@Override
	public String getTileList() {
		return "perfilListAdmin";
	}

	@Override
	public String getSessionAttributeFilterForm() {
		return "PerfilAdmin_FilterForm_" + getTipusPerfil();
	}

	@Override
	public PerfilFilterForm getPerfilFilterForm(Integer pagina,
			ModelAndView mav, HttpServletRequest request) throws I18NException {

		PerfilFilterForm filterForm = super.getPerfilFilterForm(pagina, mav,
				request);

		int tipusperfil = getTipusPerfil();

		if (filterForm.isNou()) {
			// Per configurar

			Set<Field<?>> ocults = new HashSet<Field<?>>(
					Arrays.asList(PerfilFields.ALL_PERFIL_FIELDS));

			ocults.remove(CODI);
			ocults.remove(NOM);
			ocults.remove(DESCRIPCIO);

			filterForm.setHiddenFields(ocults);

			filterForm.setOrderBy(NOM.fullName);

			filterForm.setGroupByFields(new ArrayList<Field<?>>(filterForm
					.getDefaultGroupByFields()));

			// filterForm.setTitleCode("perfil.us." + tipusperfil);
			filterForm.setEntityNameCode("perfil.us." + tipusperfil);
			filterForm.setEntityNameCodePlural("perfil.us." + tipusperfil
					+ ".plural");

			if (tipusperfil != Constants.PERFIL_US_NOMES_ESCANEIG
					&& tipusperfil != Constants.PERFIL_US_NOMES_ESCANEIG_INFO) {
				AdditionalField<Long, String> adfield4 = new AdditionalField<Long, String>();
				adfield4.setCodeName("perfil.tipusFirma");
				adfield4.setPosition(TIPUSFIRMACOLUMN);
				// Els valors s'ompliran al mètode postList()
				adfield4.setValueMap(new HashMap<Long, String>());
				filterForm.addAdditionalField(adfield4);
			}

			switch (tipusperfil) {
				case Constants.PERFIL_US_NOMES_ESCANEIG_INFO :
				case Constants.PERFIL_US_NOMES_ESCANEIG :
					filterForm.addHiddenField(TIPUSFIRMA);
					filterForm.addHiddenField(APISIMPLEID);
					filterForm.addHiddenField(PLUGINFIRMASERVIDORID);

					filterForm.getGroupByFields().remove(
							PerfilFields.TIPUSFIRMA);
					filterForm.getGroupByFields().remove(
							PerfilFields.APISIMPLEID);
					filterForm.getGroupByFields().remove(
							PerfilFields.PLUGINFIRMASERVIDORID);

				case Constants.PERFIL_US_COPIA_AUTENTICA_INFO :
				case Constants.PERFIL_US_COPIA_AUTENTICA :
					filterForm.addHiddenField(TIPUSCUSTODIA);
					filterForm.addHiddenField(PLUGINARXIUID);
					filterForm.addHiddenField(PLUGINDOCCUSTODYID);

					filterForm.getGroupByFields().remove(
							PerfilFields.TIPUSCUSTODIA);
					filterForm.getGroupByFields().remove(
							PerfilFields.PLUGINDOCCUSTODYID);
					filterForm.getGroupByFields().remove(
							PerfilFields.PLUGINARXIUID);

				case Constants.PERFIL_US_CUSTODIA_INFO :
				case Constants.PERFIL_US_CUSTODIA :

					filterForm.addHiddenField(USPERFIL);
					break;
			}
		}

		return filterForm;

	}

	@Override
	public PerfilForm getPerfilForm(PerfilJPA _jpa, boolean __isView,
			HttpServletRequest request, ModelAndView mav) throws I18NException {
		PerfilForm perfilForm = super.getPerfilForm(_jpa, __isView, request,
				mav);

		int tipusPerfil = getTipusPerfil();

		if (perfilForm.isNou()) {
			perfilForm.getPerfil().setUsPerfil(tipusPerfil);

			switch (tipusPerfil) {
				case Constants.PERFIL_US_NOMES_ESCANEIG :
					perfilForm.getPerfil().setTipusFirma(
							Constants.TIPUS_FIRMA_EN_SERVIDOR_SENSE);
					perfilForm.getPerfil().setTipusCustodia(
							Constants.TIPUS_CUSTODIA_SENSE);
					break;
				case Constants.PERFIL_US_COPIA_AUTENTICA :
					perfilForm.getPerfil().setTipusCustodia(
							Constants.TIPUS_CUSTODIA_SENSE);
					perfilForm.getPerfil().setTipusFirma(
							Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE);
					break;

				case Constants.PERFIL_US_CUSTODIA :
					perfilForm.getPerfil().setTipusFirma(
							Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE);
					perfilForm.getPerfil().setTipusCustodia(
							Constants.TIPUS_CUSTODIA_ARXIU);
					break;
			}
			
			
			perfilForm.getPerfil().setUtilitzatPerAplicacio(isUtilitzatPerAplicacio());

		}

		// XYZ ZZZ perfilForm.setTitleCode("perfil.us." + tipusPerfil);
		perfilForm.setEntityNameCode("perfil.us." + Math.abs(tipusPerfil));
		perfilForm.setEntityNameCodePlural("perfil.us." + Math.abs(tipusPerfil)
				+ ".plural");

		switch (tipusPerfil) {
			case Constants.PERFIL_US_NOMES_ESCANEIG_INFO :
			case Constants.PERFIL_US_NOMES_ESCANEIG :
				perfilForm.addHiddenField(TIPUSFIRMA);
				perfilForm.addHiddenField(APISIMPLEID);
				perfilForm.addHiddenField(PLUGINFIRMASERVIDORID);

			case Constants.PERFIL_US_COPIA_AUTENTICA_INFO :
			case Constants.PERFIL_US_COPIA_AUTENTICA :
				perfilForm.addHiddenField(TIPUSCUSTODIA);
				perfilForm.addHiddenField(PLUGINARXIUID);
				perfilForm.addHiddenField(PLUGINDOCCUSTODYID);

			case Constants.PERFIL_US_CUSTODIA_INFO :
			case Constants.PERFIL_US_CUSTODIA :
				perfilForm.addHiddenField(USPERFIL);
				break;
		}
		perfilForm.setAttachedAdditionalJspCode(true);

		return perfilForm;

	}

	@Override
	public List<StringKeyValue> getReferenceListForTipusFirma(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    int tipusPerfil = getTipusPerfil();
    if (tipusPerfil == Constants.PERFIL_US_NOMES_ESCANEIG || tipusPerfil == Constants.PERFIL_US_NOMES_ESCANEIG_INFO) {

      __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUS_FIRMA_EN_SERVIDOR_SENSE),
          I18NUtils.tradueix("tipusfirmaenservidor." + Constants.TIPUS_FIRMA_EN_SERVIDOR_SENSE)));
    } else {
      for (int i = 0; i < Constants.TIPUS_FIRMA_EN_SERVIDOR.length; i++) {
        
        if (Constants.TIPUS_FIRMA_EN_SERVIDOR[i] == Constants.TIPUS_FIRMA_EN_SERVIDOR_SENSE) {
          continue;
        }
        __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUS_FIRMA_EN_SERVIDOR[i]),
            I18NUtils.tradueix("tipusfirmaenservidor." + Constants.TIPUS_FIRMA_EN_SERVIDOR[i])));
      }
    }

    return __tmp;
	}

	@Override
	public List<StringKeyValue> getReferenceListForPluginScanWebID(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {

		Where w = Where.AND(where,
				PluginFields.TIPUS.equal(Constants.TIPUS_PLUGIN_SCANWEB));

		return pluginRefList.getReferenceList(PluginFields.PLUGINID, w);
	}

	@Override
	public List<StringKeyValue> getReferenceListForPluginScanWeb2ID(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
		Where w = Where.AND(where,
				PluginFields.TIPUS.equal(Constants.TIPUS_PLUGIN_SCANWEB));

		return pluginRefList.getReferenceList(PluginFields.PLUGINID, w);
	}

	@Override
	public List<StringKeyValue> getReferenceListForPluginFirmaServidorID(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {

		Where w = Where.AND(where, PluginFields.TIPUS
				.equal(Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR));
		return pluginRefList.getReferenceList(PluginFields.PLUGINID, w);
	}

	@Override
	public List<StringKeyValue> getReferenceListForUsPerfil(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
		List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
		__tmp.add(new StringKeyValue(String
				.valueOf(Constants.PERFIL_US_NOMES_ESCANEIG), "Només escaneig"));
		__tmp.add(new StringKeyValue(String
				.valueOf(Constants.PERFIL_US_COPIA_AUTENTICA),
				"Còpia autèntica"));
		__tmp.add(new StringKeyValue(String
				.valueOf(Constants.PERFIL_US_CUSTODIA), "Custòdia"));

		__tmp.add(new StringKeyValue(String
				.valueOf(Constants.PERFIL_US_NOMES_ESCANEIG_INFO),
				"Només escaneig - Info"));
		__tmp.add(new StringKeyValue(String
				.valueOf(Constants.PERFIL_US_COPIA_AUTENTICA_INFO),
				"Còpia autèntica - Info"));
		__tmp.add(new StringKeyValue(String
				.valueOf(Constants.PERFIL_US_CUSTODIA_INFO), "Custòdia - Info"));
		return __tmp;
	}

	@Override
	public List<StringKeyValue> getReferenceListForScanFormatFitxer(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
		List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
		__tmp.add(new StringKeyValue(String.valueOf(Constants.FORMAT_FILE_PDF),
				"PDF"));
		__tmp.add(new StringKeyValue(String.valueOf(Constants.FORMAT_FILE_JPG),
				"JPG"));
		__tmp.add(new StringKeyValue(String.valueOf(Constants.FORMAT_FILE_PNG),
				"PNG"));
		__tmp.add(new StringKeyValue(String.valueOf(Constants.FORMAT_FILE_GIF),
				"GIF"));
		__tmp.add(new StringKeyValue(
				String.valueOf(Constants.FORMAT_FILE_TIFF), "TIF"));
		return __tmp;
	}

	@Override
	public List<StringKeyValue> getReferenceListForScanPixelType(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
		List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
		__tmp.add(new StringKeyValue(String
				.valueOf(Constants.PIXEL_TYPE_BLACK_WHITE), I18NUtils
				.tradueix("pixeltype.0")));
		__tmp.add(new StringKeyValue(String.valueOf(Constants.PIXEL_TYPE_GRAY),
				I18NUtils.tradueix("pixeltype.1")));
		__tmp.add(new StringKeyValue(
				String.valueOf(Constants.PIXEL_TYPE_COLOR), I18NUtils
						.tradueix("pixeltype.2")));
		return __tmp;
	}

	@Override
	public List<StringKeyValue> getReferenceListForTipusCustodia(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    
    int tipusPerfil = getTipusPerfil();
    
    if (tipusPerfil == Constants.PERFIL_US_CUSTODIA || tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO) {
      __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUS_CUSTODIA_ARXIU), I18NUtils
          .tradueix("tipuscustodia.1")));
      __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUS_CUSTODIA_DOCUMENTCUSTODY),
          I18NUtils.tradueix("tipuscustodia.2")));
    } else {
      __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUS_CUSTODIA_SENSE), I18NUtils
          .tradueix("tipuscustodia.0")));
    }
    return __tmp;
	}

	@Override
	public List<StringKeyValue> getReferenceListForPluginArxiuID(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
		Where w = Where.AND(where,
				PluginFields.TIPUS.equal(Constants.TIPUS_PLUGIN_ARXIU));

		return pluginRefList.getReferenceList(PluginFields.PLUGINID, w);
	}

	@Override
	public List<StringKeyValue> getReferenceListForPluginDocCustodyID(
			HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {
		Where w = Where.AND(where, PluginFields.TIPUS
				.equal(Constants.TIPUS_PLUGIN_DOCUMENT_CUSTODY));

		return pluginRefList.getReferenceList(PluginFields.PLUGINID, w);
	}

	@Override
	public Where getAdditionalCondition(HttpServletRequest request)
			throws I18NException {
		int tipusPerfil = getTipusPerfil();
		Where w;
		if (tipusPerfil == Constants.PERFIL_US_ALL_INFO) {
			w = USPERFIL.in(new Integer[]{
					Constants.PERFIL_US_NOMES_ESCANEIG_INFO,
					Constants.PERFIL_US_COPIA_AUTENTICA_INFO,
					Constants.PERFIL_US_CUSTODIA_INFO});
		} else {
			w = USPERFIL.equal(getTipusPerfil());
		}
		Where w2 = Where.OR(UTILITZATPERAPLICACIO.equal(isUtilitzatPerAplicacio()), UTILITZATPERAPLICACIO.isNull());  
		return Where.AND(w, w2);
		
	}

	private void validaTipusFirma(PerfilJPA perfil, BindingResult result) {
		switch (perfil.getTipusFirma()) {

			case Constants.TIPUS_FIRMA_EN_SERVIDOR_SENSE :
				perfil.setPluginFirmaServidorID(null);
				perfil.setApiSimpleID(null);
				break;
			case Constants.TIPUS_FIRMA_EN_SERVIDOR_PLUGIN :
				if (perfil.getPluginFirmaServidorID() == null) {
					result.rejectValue(get(PLUGINFIRMASERVIDORID),
							"genapp.validation.required",
							new Object[]{I18NUtils
									.tradueix(get(PLUGINFIRMASERVIDORID))},
							null);
				}
				perfil.setApiSimpleID(null);
				break;

			case Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE :
				if (perfil.getApiSimpleID() == null) {
					result.rejectValue(get(APISIMPLEID),
							"genapp.validation.required",
							new Object[]{I18NUtils.tradueix(get(APISIMPLEID))},
							null);

				}
				perfil.setPluginFirmaServidorID(null);
				break;
		}

	}

	private void validaTipusCustodia(PerfilJPA perfil, BindingResult result) {

		switch (perfil.getTipusCustodia()) {
			case Constants.TIPUS_CUSTODIA_ARXIU :
				if (perfil.getPluginArxiuID() == null) {
					result.rejectValue(
							get(PLUGINARXIUID),
							"genapp.validation.required",
							new Object[]{I18NUtils.tradueix(get(PLUGINARXIUID))},
							null);
				}
				perfil.setPluginDocCustodyID(null);				
				break;

			case Constants.TIPUS_CUSTODIA_DOCUMENTCUSTODY :
				if (perfil.getPluginDocCustodyID() == null) {
					result.rejectValue(get(PLUGINDOCCUSTODYID),
							"genapp.validation.required",
							new Object[]{I18NUtils
									.tradueix(get(PLUGINDOCCUSTODYID))}, null);
				}
				perfil.setPluginArxiuID(null);
				
				break;
		}
	}

	@Override
	public void preValidate(HttpServletRequest request, PerfilForm perfilForm,
			BindingResult result) throws I18NException {

		PerfilJPA perfil = perfilForm.getPerfil();

		switch (getTipusPerfil()) {
			case Constants.PERFIL_US_COPIA_AUTENTICA :
				validaTipusFirma(perfil, result);
				break;
			case Constants.PERFIL_US_CUSTODIA :
				validaTipusFirma(perfil, result);
				validaTipusCustodia(perfil, result);
		}
	}

	@Override
	public void postList(HttpServletRequest request, ModelAndView mav,
			PerfilFilterForm filterForm, List<Perfil> list)
			throws I18NException {

		int tipusperfil = getTipusPerfil();

		if (tipusperfil != Constants.PERFIL_US_NOMES_ESCANEIG
				&& tipusperfil != Constants.PERFIL_US_NOMES_ESCANEIG_INFO) {

			Map<Long, String> map;
			map = (Map<Long, String>) filterForm.getAdditionalField(
					TIPUSFIRMACOLUMN).getValueMap();

			map.clear();
			long key;
			String value;
			for (Perfil p : list) {
				key = p.getPerfilID();

				switch (p.getTipusFirma()) {

					default :

					case Constants.TIPUS_FIRMA_EN_SERVIDOR_PLUGIN :
						value = "Plugin";
						break;

					case Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE :
						value = "ApiSimple";

						break;

				}
				map.put(key, value);

			}

		}

	}

}
