package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.ConfiguracioFirma;
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
public class ConfiguracioFirmaValidator<I extends ConfiguracioFirma>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements ConfiguracioFirmaFields {

    protected final Logger log = Logger.getLogger(getClass());


  public ConfiguracioFirmaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager
    ,es.caib.digitalib.model.dao.IPluginManager __pluginManager
    ,es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PLUGINFIRMASERVIDORID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PLUGINFIRMASERVIDORID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,INCLOURESEGELLDETEMPS, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INCLOURESEGELLDETEMPS)));

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

    __vr.rejectIfEmptyOrWhitespace(__target__,USPOLITICADEFIRMA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USPOLITICADEFIRMA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,POSICIOTAULAFIRMESID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POSICIOTAULAFIRMESID)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(POLICYIDENTIFIER) == 0) {
      java.lang.String __policyidentifier = __target__.getPolicyIdentifier();
      if (__policyidentifier!= null && __policyidentifier.length() > 100) {
        __vr.rejectValue(POLICYIDENTIFIER, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYIDENTIFIER)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(POLICYIDENTIFIERHASH) == 0) {
      java.lang.String __policyidentifierhash = __target__.getPolicyIdentifierHash();
      if (__policyidentifierhash!= null && __policyidentifierhash.length() > 256) {
        __vr.rejectValue(POLICYIDENTIFIERHASH, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYIDENTIFIERHASH)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(256)));
      }
    }

    if (__vr.getFieldErrorCount(POLICYIDENTIFIERHASHALGORITHM) == 0) {
      java.lang.String __policyidentifierhashalgorithm = __target__.getPolicyIdentifierHashAlgorithm();
      if (__policyidentifierhashalgorithm!= null && __policyidentifierhashalgorithm.length() > 50) {
        __vr.rejectValue(POLICYIDENTIFIERHASHALGORITHM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYIDENTIFIERHASHALGORITHM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }

    if (__vr.getFieldErrorCount(POLICYURLDOCUMENT) == 0) {
      java.lang.String __policyurldocument = __target__.getPolicyUrlDocument();
      if (__policyurldocument!= null && __policyurldocument.length() > 255) {
        __vr.rejectValue(POLICYURLDOCUMENT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POLICYURLDOCUMENT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PROPIETATSTAULAFIRMES) == 0) {
      java.lang.String __propietatstaulafirmes = __target__.getPropietatsTaulaFirmes();
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
      if (__vr.getFieldErrorCount(NOM) == 0) {
        java.lang.String __nom = __target__.getNom();
        Long __count_ = null;
        try { __count_ = __configuracioFirmaManager.count(org.fundaciobit.genapp.common.query.Where.AND(NOM.equal(__nom))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(NOM, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__nom)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));
        }
      }

      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
      if (__vr.getFieldErrorCount(NOM) == 0 && __vr.getFieldErrorCount(CONFIGURACIOFIRMAID) == 0) {
        java.lang.String __nom = __target__.getNom();
        java.lang.Long __configuraciofirmaid = __target__.getConfiguracioFirmaID();
        Long __count_ = null;
        try { __count_ = __configuracioFirmaManager.count(org.fundaciobit.genapp.common.query.Where.AND(NOM.equal(__nom), CONFIGURACIOFIRMAID.notEqual(__configuraciofirmaid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(NOM, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__nom)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));
        }
      }

    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(PLUGINFIRMASERVIDORID) == 0) {
      java.lang.Long __pluginfirmaservidorid = __target__.getPluginFirmaServidorID();
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
      java.lang.Long __pluginsegellatid = __target__.getPluginSegellatID();
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

    if (__vr.getFieldErrorCount(FIRMATPERFORMATID) == 0) {
      java.lang.Long __firmatperformatid = __target__.getFirmatPerFormatID();
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
      java.lang.Long __motiudelegacioid = __target__.getMotiuDelegacioID();
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

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}