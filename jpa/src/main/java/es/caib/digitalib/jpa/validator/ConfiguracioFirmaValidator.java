package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.ConfiguracioFirmaFields;
import es.caib.digitalib.model.fields.PluginFields;
import es.caib.digitalib.model.fields.TraduccioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class ConfiguracioFirmaValidator<T> implements ConfiguracioFirmaFields {

  protected final Logger log = Logger.getLogger(getClass());


  public ConfiguracioFirmaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<T> __vr, T __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager
    ,es.caib.digitalib.model.dao.IPluginManager __pluginManager
    ,es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,USPOLITICADEFIRMA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USPOLITICADEFIRMA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUSOPERACIOFIRMA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUSOPERACIOFIRMA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUSFIRMAID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUSFIRMAID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ALGORISMEDEFIRMAID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ALGORISMEDEFIRMAID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,MODEDEFIRMA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(MODEDEFIRMA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,POLITICATAULAFIRMES, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLITICATAULAFIRMES)));

    __vr.rejectIfEmptyOrWhitespace(__target__,POSICIOTAULAFIRMESID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POSICIOTAULAFIRMESID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PLUGINFIRMASERVIDORID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PLUGINFIRMASERVIDORID)));

    // Check size
    if (__vr.getFieldErrorCount(POLICYIDENTIFIER) == 0) {
      java.lang.String __policyidentifier = (java.lang.String)__vr.getFieldValue(__target__,POLICYIDENTIFIER);
      if (__policyidentifier!= null && __policyidentifier.length() > 100) {
        __vr.rejectValue(POLICYIDENTIFIER, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYIDENTIFIER)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(POLICYIDENTIFIERHASH) == 0) {
      java.lang.String __policyidentifierhash = (java.lang.String)__vr.getFieldValue(__target__,POLICYIDENTIFIERHASH);
      if (__policyidentifierhash!= null && __policyidentifierhash.length() > 256) {
        __vr.rejectValue(POLICYIDENTIFIERHASH, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYIDENTIFIERHASH)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(256)));
      }
    }
    
    if (__vr.getFieldErrorCount(POLICYIDENTIFIERHASHALGORITHM) == 0) {
      java.lang.String __policyidentifierhashalgorithm = (java.lang.String)__vr.getFieldValue(__target__,POLICYIDENTIFIERHASHALGORITHM);
      if (__policyidentifierhashalgorithm!= null && __policyidentifierhashalgorithm.length() > 50) {
        __vr.rejectValue(POLICYIDENTIFIERHASHALGORITHM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYIDENTIFIERHASHALGORITHM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }
    
    if (__vr.getFieldErrorCount(POLICYURLDOCUMENT) == 0) {
      java.lang.String __policyurldocument = (java.lang.String)__vr.getFieldValue(__target__,POLICYURLDOCUMENT);
      if (__policyurldocument!= null && __policyurldocument.length() > 255) {
        __vr.rejectValue(POLICYURLDOCUMENT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYURLDOCUMENT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(PROPIETATSTAULAFIRMES) == 0) {
      java.lang.String __propietatstaulafirmes = (java.lang.String)__vr.getFieldValue(__target__,PROPIETATSTAULAFIRMES);
      if (__propietatstaulafirmes!= null && __propietatstaulafirmes.length() > 2147483647) {
        __vr.rejectValue(PROPIETATSTAULAFIRMES, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PROPIETATSTAULAFIRMES)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }
    
    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(FIRMATPERFORMATID) == 0) {
      java.lang.Long __firmatperformatid = (java.lang.Long)__vr.getFieldValue(__target__,FIRMATPERFORMATID);
      if (__firmatperformatid != null ) {
        Long __count_ = null;
        try { __count_ = __traduccioManager.count(TraduccioFields.TRADUCCIOID.equal(__firmatperformatid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(FIRMATPERFORMATID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__firmatperformatid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(MOTIUDELEGACIOID) == 0) {
      java.lang.Long __motiudelegacioid = (java.lang.Long)__vr.getFieldValue(__target__,MOTIUDELEGACIOID);
      if (__motiudelegacioid != null ) {
        Long __count_ = null;
        try { __count_ = __traduccioManager.count(TraduccioFields.TRADUCCIOID.equal(__motiudelegacioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(MOTIUDELEGACIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__motiudelegacioid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PLUGINFIRMASERVIDORID) == 0) {
      java.lang.Long __pluginfirmaservidorid = (java.lang.Long)__vr.getFieldValue(__target__,PLUGINFIRMASERVIDORID);
      Long __count_ = null;
      try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__pluginfirmaservidorid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(PLUGINFIRMASERVIDORID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__pluginfirmaservidorid)));
      }
    }

    if (__vr.getFieldErrorCount(PLUGINSEGELLATID) == 0) {
      java.lang.Long __pluginsegellatid = (java.lang.Long)__vr.getFieldValue(__target__,PLUGINSEGELLATID);
      if (__pluginsegellatid != null ) {
        Long __count_ = null;
        try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__pluginsegellatid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PLUGINSEGELLATID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__pluginsegellatid)));
        }
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}