package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.plugins.signatureserver.api.ISignatureServerPlugin;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.ConfiguracioFirmaController;
import es.caib.digitalib.back.form.webdb.ConfiguracioFirmaFilterForm;
import es.caib.digitalib.back.form.webdb.ConfiguracioFirmaForm;
import es.caib.digitalib.jpa.ConfiguracioFirmaJPA;
import es.caib.digitalib.jpa.TraduccioJPA;
import es.caib.digitalib.jpa.TraduccioMapJPA;
import es.caib.digitalib.logic.PluginFirmaEnServidorLogicaLocal;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.ConfiguracioFirma;
import es.caib.digitalib.model.fields.PluginFields;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = ConfiguracioFirmaAdminController.CONTEXT_WEB)
@SessionAttributes(types = { ConfiguracioFirmaForm.class, ConfiguracioFirmaFilterForm.class })
public class ConfiguracioFirmaAdminController extends ConfiguracioFirmaController {

  @EJB(mappedName = PluginFirmaEnServidorLogicaLocal.JNDI_NAME)
  protected PluginFirmaEnServidorLogicaLocal pluginFirmaServidorLogicaEjb;

  public static final String CONTEXT_WEB = "/admin/conffirma";

  @Override
  public String getTileForm() {
    return "configuracioFirmaFormAdmin";
  }

  @Override
  public String getTileList() {
    return "configuracioFirmaListAdmin";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "ConfiguracioFirmaAdmin_FilterForm";
  }

  @PostConstruct
  public void init() {

  }

  @Override
  public ConfiguracioFirmaForm getConfiguracioFirmaForm(ConfiguracioFirmaJPA _jpa,
      boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {

    ConfiguracioFirmaForm form = super.getConfiguracioFirmaForm(_jpa, __isView, request, mav);

    if (form.isNou()) {
      // Creació

      ConfiguracioFirma uac = form.getConfiguracioFirma();

      uac.setTipusOperacioFirma(Constants.TIPUS_OPERACIO_FIRMA_FIRMAR);

      uac.setPosicioTaulaFirmesID(Constants.TAULADEFIRMES_SENSETAULA);

      form.addHiddenField(PROPIETATSTAULAFIRMES);

      form.addHiddenField(PLUGINSEGELLATID);
      
      form.addReadOnlyField(POSICIOTAULAFIRMESID);

      // NOTA 
      if (!form.getReadOnlyFields().contains(POSICIOTAULAFIRMESID)) {
        {
          Map<String, TraduccioMapJPA> tracM = new HashMap<String, TraduccioMapJPA>();
          tracM.put("ca", new TraduccioMapJPA(I18NLogicUtils.tradueix(new Locale("ca"), "firmatperformat")));
          tracM.put("es", new TraduccioMapJPA(I18NLogicUtils.tradueix(new Locale("es"), "firmatperformat")));
    
          TraduccioJPA trac = new TraduccioJPA();
          trac.setTraduccions(tracM);
    
          form.getConfiguracioFirma().setFirmatPerFormat(trac);
        }
        
        {
          Map<String, TraduccioMapJPA> tracM = new HashMap<String, TraduccioMapJPA>();
          tracM.put("ca", new TraduccioMapJPA(I18NLogicUtils.tradueix(new Locale("ca"), "motiudelegacio")));
          tracM.put("es", new TraduccioMapJPA(I18NLogicUtils.tradueix(new Locale("es"), "motiudelegacio")));
    
          TraduccioJPA trac = new TraduccioJPA();
          trac.setTraduccions(tracM);
    
          form.getConfiguracioFirma().setMotiuDelegacio(trac);
        }
      }

    } else {

      if (form.getConfiguracioFirma().getPluginSegellatID() == null) {
        form.addHiddenField(PLUGINSEGELLATID);
      }

    }

    // Codi comu

    form.addHelpToField(MOTIUDELEGACIOID, I18NUtils.tradueix("motiudelegacio.help"));
    form.addHelpToField(FIRMATPERFORMATID, I18NUtils.tradueix("firmatperformat.help"));

    form.addReadOnlyField(TIPUSOPERACIOFIRMA);

    // Pentent de que s'implementi XYZ ZZZ
    // #176 Configuració etiquetes de la Taula de Firmes
    form.addHiddenField(PROPIETATSTAULAFIRMES);

    if (!__isView) {
      form.setAttachedAdditionalJspCode(true);
    }

    return form;

  }

  @Override
  public ConfiguracioFirmaFilterForm getConfiguracioFirmaFilterForm(Integer pagina,
      ModelAndView mav, HttpServletRequest request) throws I18NException {
    ConfiguracioFirmaFilterForm configuracioFirmaFilterForm = super
        .getConfiguracioFirmaFilterForm(pagina, mav, request);

    if (configuracioFirmaFilterForm.isNou()) {

      Set<Field<?>> hiddenFields = new HashSet<Field<?>>(
          Arrays.asList(ALL_CONFIGURACIOFIRMA_FIELDS));

      hiddenFields.remove(NOM);
      hiddenFields.remove(PLUGINFIRMASERVIDORID);
      hiddenFields.remove(INCLOURESEGELLDETEMPS);
      hiddenFields.remove(TIPUSFIRMAID);
      hiddenFields.remove(POSICIOTAULAFIRMESID);
      
      configuracioFirmaFilterForm.setHiddenFields(hiddenFields);

      // AFEGIR COLUMNA DE POLITICA FIRMA

      // hiddenFields.remove();

      configuracioFirmaFilterForm.setDeleteSelectedButtonVisible(true);
      configuracioFirmaFilterForm.setVisibleMultipleSelection(false);

    }

    return configuracioFirmaFilterForm;
  }

  @Override
  public List<StringKeyValue> getReferenceListForUsPoliticaDeFirma(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {

    // XYZ ZZZ FALTEN TRADUCCIONS !!!!

    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("" + Constants.US_POLITICA_DE_FIRMA_NO_USAR, I18NUtils
        .tradueix("uspoliticadefirma." + Constants.US_POLITICA_DE_FIRMA_NO_USAR)));
    __tmp.add(new StringKeyValue("" + Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT,
        I18NUtils.tradueix("uspoliticadefirma."
            + +Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT)));

    return __tmp;

  }

  @Override
  public List<StringKeyValue> getReferenceListForTipusOperacioFirma(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {

    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_OPERACIO_FIRMA_FIRMAR, I18NUtils
        .tradueix("operaciofirma." + Constants.TIPUS_OPERACIO_FIRMA_FIRMAR)));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_OPERACIO_FIRMA_COFIRMAR, I18NUtils
        .tradueix("operaciofirma." + +Constants.TIPUS_OPERACIO_FIRMA_COFIRMAR)));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_OPERACIO_FIRMA_CONTRAFIRMAR, I18NUtils
        .tradueix("operaciofirma." + +Constants.TIPUS_OPERACIO_FIRMA_CONTRAFIRMAR)));
    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForPosicioTaulaFirmesID(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    return staticGetReferenceListForPosicioTaulaFirmes();
  }

  public static List<StringKeyValue> staticGetReferenceListForPosicioTaulaFirmes() {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    for (int i = 0; i < Constants.TAULADEFIRMES.length; i++) {
      int val = Constants.TAULADEFIRMES[i];
      __tmp.add(new StringKeyValue(String.valueOf(val), I18NUtils.tradueix("tauladefirmes."
          + val)));
    }
    return __tmp;
  }
  
  
  @Override
  public List<StringKeyValue> getReferenceListForPluginSegellatID(HttpServletRequest request,
      ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
//   if (configuracioFirmaForm.isHiddenField(PLUGINSEGELLATID)) {
//     return EMPTY_STRINGKEYVALUE_LIST;
//   }
   Where _where = null;
   if (configuracioFirmaForm.isReadOnlyField(PLUGINSEGELLATID)) {
     _where = PluginFields.PLUGINID.equal(configuracioFirmaForm.getConfiguracioFirma().getPluginSegellatID());
   }
   return getReferenceListForPluginSegellatID(request, mav, Where.AND(where, _where));
 }

  
  

  @Override
  public List<StringKeyValue> getReferenceListForPluginSegellatID(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {

    // XYZ ZZZ Esta Actiu !!!!

    Where where2 = Where.AND(where,
        PluginFields.TIPUS.equal(Constants.TIPUS_PLUGIN_SEGELLDETEMPS));

    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where2);
  }

  @Override
  public List<StringKeyValue> getReferenceListForPluginFirmaServidorID(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {

    // XYZ ZZZ Esta Actiu !!!!

    Where where2 = Where.AND(where,
        PluginFields.TIPUS.equal(Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR));

    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where2);

  }

  @Override
  public void postValidate(HttpServletRequest request,
      ConfiguracioFirmaForm configuracioFirmaForm, BindingResult result) throws I18NException {

    ConfiguracioFirma uac = configuracioFirmaForm.getConfiguracioFirma();

    // Politica de Firma
    int usPoliticaDeFirma = uac.getUsPoliticaDeFirma();

    if (usPoliticaDeFirma == Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT) {

      Field<?>[] fields = { POLICYIDENTIFIER, POLICYIDENTIFIERHASH,
          POLICYIDENTIFIERHASHALGORITHM, POLICYURLDOCUMENT };

      for (Field<?> field : fields) {
        String value = (String) result.getFieldValue(get(field));

        log.info(" VALOR CAMP[" + field.getFullName() + "] => " + value);

        if (value == null || value.trim().length() == 0) {
          // El camp {0} és obligatori.
          result.rejectValue(get(field), "genapp.validation.required",
              new String[] { I18NUtils.tradueix(get(field)) }, null);
        }
      }

    } else {
      uac.setPolicyIdentifier(null);
      uac.setPolicyIdentifierHash(null);
      uac.setPolicyIdentifierHashAlgorithm(null);
      uac.setPolicyUrlDocument(null);
    }

    // Segellat de temps
    if (uac.getPluginFirmaServidorID() != 0) {
      if (uac.isIncloureSegellDeTemps()) {

        // Si el plugin de Firma té sellejador intern llavors no és necessari

        ISignatureServerPlugin issp = pluginFirmaServidorLogicaEjb.getInstanceByPluginID(uac
            .getPluginFirmaServidorID());

        String tipusFirma = getTipusFromInteger(uac.getTipusFirmaID());

        if (issp.providesTimeStampGenerator(tipusFirma)) {
          // OK
          uac.setPluginSegellatID(null);
        } else {

          if (issp.acceptExternalTimeStampGenerator(tipusFirma)) {

            if (uac.getPluginSegellatID() == null) {
              //  El camp {0} és obligatori.
              result.rejectValue(get(PLUGINSEGELLATID), "genapp.validation.required",
                new String[] { I18NUtils.tradueix(get(PLUGINSEGELLATID)) }, null);
            }

            configuracioFirmaForm.getHiddenFields().remove(PLUGINSEGELLATID);
          } else {
            // No te segellador ni n'accepta d'externs
            result.rejectValue(get(INCLOURESEGELLDETEMPS), "segelldetemps.niexternniintern",
                new String[] { tipusFirma }, null);

            uac.setPluginSegellatID(null);
          }
        }

      } else {
        uac.setPluginSegellatID(null);
      }
    }

  }

  private String getTipusFromInteger(int tipusID) {
    switch (tipusID) {
      case Constants.TIPUSFIRMA_PADES:
        return FileInfoSignature.SIGN_TYPE_PADES;

      case Constants.TIPUSFIRMA_XADES:
        return FileInfoSignature.SIGN_TYPE_XADES;

      case Constants.TIPUSFIRMA_CADES:
        return FileInfoSignature.SIGN_TYPE_CADES;
    }

    return null;
  }

  /*
   * @Override public String getRedirectWhenCreated(HttpServletRequest request,
   * ConfiguracioFirmaForm ConfiguracioFirmaForm) { return getRedirectWhenCancel(request,
   * ConfiguracioFirmaForm .getConfiguracioFirma().getUsuariAplicacioConfigID()); }
   * 
   * @Override public String getRedirectWhenModified(HttpServletRequest request,
   * ConfiguracioFirmaForm ConfiguracioFirmaForm, Throwable __e) { if (__e == null) { return
   * getRedirectWhenCancel(request, ConfiguracioFirmaForm
   * .getConfiguracioFirma().getUsuariAplicacioConfigID()); } else { return getTileForm(); } }
   * 
   * 
   * @Override public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long
   * usuariAplicacioConfigID, Throwable __e) { return getRedirectWhenCancel(request,
   * usuariAplicacioConfigID); }
   * 
   * @Override public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long
   * usuariAplicacioConfigID) { return "redirect:" +
   * GestioUsuariAplicacioAdenController.GESTIO_USUARI_APLICACIO_CONTEXTWEB + "/list"; }
   */

  @Override
  public List<StringKeyValue> getReferenceListForTipusFirmaID(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = staticGetReferenceListForTipusFirmaID();
    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForAlgorismeDeFirmaID(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    return staticGetReferenceListForAlgorismeDeFirmaID();
  }

  // #199
  public static List<StringKeyValue> staticGetReferenceListForTipusFirmaID() {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_PADES), "PAdES"));
    __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_XADES), "XAdES"));
    __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_CADES), "CAdES"));
    // __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_SMIME), "SMIME"));
    return __tmp;
  }

  public static List<StringKeyValue> staticGetReferenceListForAlgorismeDeFirmaID() {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    __tmp
        .add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA1WITHRSA), "SHA-1"));
    __tmp.add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA256WITHRSA),
        "SHA-256"));
    __tmp.add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA384WITHRSA),
        "SHA-384"));
    __tmp.add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA512WITHRSA),
        "SHA-512"));
    return __tmp;
  }

}
