package es.caib.digitalib.back.controller.admin;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.ConfiguracioFirmaController;
import es.caib.digitalib.back.form.webdb.ConfiguracioFirmaFilterForm;
import es.caib.digitalib.back.form.webdb.ConfiguracioFirmaForm;
import es.caib.digitalib.jpa.ConfiguracioFirmaJPA;
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
public class ConfiguracioFirmaAdminController extends
    ConfiguracioFirmaController {

  public static final String CONTEXT_WEB = "/admin/conffirma";

 

  @Override
  public String getTileForm() {
    return "ConfiguracioFirmaFormAden";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "ConfiguracioFirmaADEN_FilterForm";
  }

  @PostConstruct
  public void init() {
   
  }



  @Override
  public ConfiguracioFirmaForm getConfiguracioFirmaForm(
      ConfiguracioFirmaJPA _jpa, boolean __isView, HttpServletRequest request,
      ModelAndView mav) throws I18NException {

    ConfiguracioFirmaForm form = super.getConfiguracioFirmaForm(_jpa,
        __isView, request, mav);

    if (form.isNou()) {
      // Creació
      
      ConfiguracioFirma uac = form.getConfiguracioFirma();
     
      uac.setTipusOperacioFirma(Constants.TIPUS_OPERACIO_FIRMA_FIRMAR);

      
      uac.setPosicioTaulaFirmesID(Constants.TAULADEFIRMES_SENSETAULA);

    }

    // Codi comu
    
    form.addHelpToField(MOTIUDELEGACIOID,
        I18NUtils.tradueix("usuariaplicacioconfig.definitenentitat.ajuda"));
    form.addHelpToField(FIRMATPERFORMATID,
        I18NUtils.tradueix("usuariaplicacioconfig.definitenentitat.ajuda"));
    
    form.addReadOnlyField(TIPUSOPERACIOFIRMA);

    // Pentent de que s'implementi XYZ ZZZ
    // #176 Configuració etiquetes de la Taula de Firmes 
    form.addReadOnlyField(PROPIETATSTAULAFIRMES);

    if (!__isView) {
      form.setAttachedAdditionalJspCode(true);
    }

    return form;

  }

  @Override
  public List<StringKeyValue> getReferenceListForUsPoliticaDeFirma(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {
    
	  // XYZ ZZZ FALTEN TRADUCCIONS !!!!

	  List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
	    __tmp.add(new StringKeyValue("" + Constants.US_POLITICA_DE_FIRMA_NO_USAR, I18NUtils
	        .tradueix("politicadefirma."
	            + Constants.TIPUS_OPERACIO_FIRMA_FIRMAR)));
	    __tmp.add(new StringKeyValue("" + Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT, I18NUtils
	        .tradueix("politicadefirma."
	            + +Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT)));
	   
	    return __tmp;
    
    
    
  }

  @Override
  public List<StringKeyValue> getReferenceListForTipusOperacioFirma(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {

    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_OPERACIO_FIRMA_FIRMAR, I18NUtils
        .tradueix("usuariaplicacioconfig.operaciofirma."
            + Constants.TIPUS_OPERACIO_FIRMA_FIRMAR)));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_OPERACIO_FIRMA_COFIRMAR, I18NUtils
        .tradueix("usuariaplicacioconfig.operaciofirma."
            + +Constants.TIPUS_OPERACIO_FIRMA_COFIRMAR)));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_OPERACIO_FIRMA_CONTRAFIRMAR, I18NUtils
        .tradueix("usuariaplicacioconfig.operaciofirma."
            + +Constants.TIPUS_OPERACIO_FIRMA_CONTRAFIRMAR)));
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
	      __tmp.add(new StringKeyValue(String.valueOf(val), I18NUtils.tradueix("tauladefirmes." + val) ));
	    }
	    return __tmp;
	  }

 

  @Override
  public List<StringKeyValue> getReferenceListForPluginSegellatID(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {
    Where where2 = Where.AND(where,        
        PluginFields.TIPUS.equal(Constants.TIPUS_PLUGIN_SEGELLDETEMPS));

    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where2);
  }



  
  @Override
  public void postValidate(HttpServletRequest request,
      ConfiguracioFirmaForm ConfiguracioFirmaForm, BindingResult result)
          throws I18NException {
    
    ConfiguracioFirma uac = ConfiguracioFirmaForm.getConfiguracioFirma();
    
    
    // Politica de Firma
    int usPoliticaDeFirma = uac.getUsPoliticaDeFirma();
    
    if (usPoliticaDeFirma == Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT) { 
      
      Field<?>[] fields = { POLICYIDENTIFIER, POLICYIDENTIFIERHASH,
          POLICYIDENTIFIERHASHALGORITHM,  POLICYURLDOCUMENT
      };

      for (Field<?> field : fields) {
        String value = (String)result.getFieldValue(get(field));
        
        log.info(" VALOR CAMP[" + field.getFullName()+ "] => " + value);
        
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
   {
      if (uac.getPluginSegellatID() == null) {
        // El camp {0} és obligatori.
        result.rejectValue(get(PLUGINSEGELLATID), "genapp.validation.required",
            new String[] { I18NUtils.tradueix(get(PLUGINSEGELLATID)) }, null);
      }
    }



    
  }

  /*
  @Override
  public String getRedirectWhenCreated(HttpServletRequest request,
      ConfiguracioFirmaForm ConfiguracioFirmaForm) {
    return getRedirectWhenCancel(request, ConfiguracioFirmaForm
        .getConfiguracioFirma().getUsuariAplicacioConfigID());
  }

  @Override
  public String getRedirectWhenModified(HttpServletRequest request,
      ConfiguracioFirmaForm ConfiguracioFirmaForm, Throwable __e) {
    if (__e == null) {
      return getRedirectWhenCancel(request, ConfiguracioFirmaForm
          .getConfiguracioFirma().getUsuariAplicacioConfigID());
    } else {
      return getTileForm();
    }
  }


  @Override
  public String getRedirectWhenDelete(HttpServletRequest request,
      java.lang.Long usuariAplicacioConfigID, Throwable __e) {
    return getRedirectWhenCancel(request, usuariAplicacioConfigID);
  }

  @Override
  public String getRedirectWhenCancel(HttpServletRequest request,
      java.lang.Long usuariAplicacioConfigID) {
    return "redirect:"
        + GestioUsuariAplicacioAdenController.GESTIO_USUARI_APLICACIO_CONTEXTWEB + "/list";
  }
  
    */
  
  
  @Override
  public List<StringKeyValue> getReferenceListForTipusFirmaID(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = staticGetReferenceListForTipusFirmaID();
    return __tmp;
  }
  
  
  
  @Override
  public List<StringKeyValue> getReferenceListForAlgorismeDeFirmaID(HttpServletRequest request,
      ModelAndView mav, Where where)  throws I18NException {
   return staticGetReferenceListForAlgorismeDeFirmaID();
 }
  
  

  // #199
  public static List<StringKeyValue> staticGetReferenceListForTipusFirmaID() {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_PADES), "PAdES"));
    __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_XADES), "XAdES"));
    __tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_CADES), "CAdES"));
    //__tmp.add(new StringKeyValue(String.valueOf(Constants.TIPUSFIRMA_SMIME), "SMIME"));
    return __tmp;
  }


  public static List<StringKeyValue> staticGetReferenceListForAlgorismeDeFirmaID() {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    
     __tmp.add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA1WITHRSA) , "SHA-1"));
     __tmp.add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA256WITHRSA) , "SHA-256"));
     __tmp.add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA384WITHRSA) , "SHA-384"));
     __tmp.add(new StringKeyValue(String.valueOf(Constants.SIGN_ALGORITHM_SHA512WITHRSA) , "SHA-512"));
     return __tmp;
  }
  

}
