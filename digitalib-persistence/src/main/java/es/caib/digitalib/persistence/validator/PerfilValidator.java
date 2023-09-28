package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.Perfil;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.ApiSimpleFields;
import es.caib.digitalib.model.fields.ConfiguracioFirmaFields;
import es.caib.digitalib.model.fields.PluginFields;
import es.caib.digitalib.model.fields.TraduccioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class PerfilValidator<I extends Perfil>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements PerfilFields {

    protected final Logger log = Logger.getLogger(getClass());


  public PerfilValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager
    ,es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager
    ,es.caib.digitalib.model.dao.IPerfilManager __perfilManager
    ,es.caib.digitalib.model.dao.IPluginManager __pluginManager
    ,es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,CODI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SCANFORMATFITXER, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SCANFORMATFITXER)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PLUGINSCANWEBID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PLUGINSCANWEBID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUSFIRMA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUSFIRMA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUSCUSTODIA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUSCUSTODIA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,USPERFIL, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USPERFIL)));

    // Check size
    if (__vr.getFieldErrorCount(CODI) == 0) {
      java.lang.String __codi = __target__.getCodi();
      if (__codi!= null && __codi.length() > 255) {
        __vr.rejectValue(CODI, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(CODI) == 0) {
      String val = __target__.getCodi();
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[a-zA-Z0-9._-]{3,}$");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(CODI, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)));
        }
      }
    }

    if (__vr.getFieldErrorCount(URLBASE) == 0) {
      java.lang.String __urlbase = __target__.getUrlBase();
      if (__urlbase!= null && __urlbase.length() > 255) {
        __vr.rejectValue(URLBASE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(URLBASE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      if (__vr.getFieldErrorCount(CODI) == 0) {
        java.lang.String __codi = __target__.getCodi();
        Long __count_ = null;
        try { __count_ = __perfilManager.count(org.fundaciobit.genapp.common.query.Where.AND(CODI.equal(__codi))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(CODI, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__codi)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)));
        }
      }

      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
      if (__vr.getFieldErrorCount(CODI) == 0 && __vr.getFieldErrorCount(PERFILID) == 0) {
        java.lang.String __codi = __target__.getCodi();
        java.lang.Long __perfilid = __target__.getPerfilID();
        Long __count_ = null;
        try { __count_ = __perfilManager.count(org.fundaciobit.genapp.common.query.Where.AND(CODI.equal(__codi), PERFILID.notEqual(__perfilid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(CODI, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__codi)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)));
        }
      }

    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(NOMID) == 0) {
      java.lang.Long __nomid = __target__.getNomID();
      if (__nomid != null ) {
        Long __count_ = null;
        try { __count_ = __traduccioManager.count(TraduccioFields.TRADUCCIOID.equal(__nomid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(NOMID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__nomid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(DESCRIPCIOID) == 0) {
      java.lang.Long __descripcioid = __target__.getDescripcioID();
      if (__descripcioid != null ) {
        Long __count_ = null;
        try { __count_ = __traduccioManager.count(TraduccioFields.TRADUCCIOID.equal(__descripcioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(DESCRIPCIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__descripcioid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PLUGINSCANWEBID) == 0) {
      java.lang.Long __pluginscanwebid = __target__.getPluginScanWebID();
      Long __count_ = null;
      try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__pluginscanwebid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(PLUGINSCANWEBID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__pluginscanwebid)));
      }
    }

    if (__vr.getFieldErrorCount(PLUGINSCANWEB2ID) == 0) {
      java.lang.Long __pluginscanweb2id = __target__.getPluginScanWeb2ID();
      if (__pluginscanweb2id != null ) {
        Long __count_ = null;
        try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__pluginscanweb2id)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PLUGINSCANWEB2ID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__pluginscanweb2id)));
        }
      }
    }

    if (__vr.getFieldErrorCount(APISIMPLEID) == 0) {
      java.lang.Long __apisimpleid = __target__.getApiSimpleID();
      if (__apisimpleid != null ) {
        Long __count_ = null;
        try { __count_ = __apiSimpleManager.count(ApiSimpleFields.APISIMPLEID.equal(__apisimpleid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(APISIMPLEID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("apiSimple.apiSimple"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("apiSimple.apiSimpleID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__apisimpleid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(CONFIGURACIOFIRMAID) == 0) {
      java.lang.Long __configuraciofirmaid = __target__.getConfiguracioFirmaID();
      if (__configuraciofirmaid != null ) {
        Long __count_ = null;
        try { __count_ = __configuracioFirmaManager.count(ConfiguracioFirmaFields.CONFIGURACIOFIRMAID.equal(__configuraciofirmaid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(CONFIGURACIOFIRMAID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("configuracioFirma.configuracioFirma"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("configuracioFirma.configuracioFirmaID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__configuraciofirmaid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PLUGINARXIUID) == 0) {
      java.lang.Long __pluginarxiuid = __target__.getPluginArxiuID();
      if (__pluginarxiuid != null ) {
        Long __count_ = null;
        try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__pluginarxiuid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PLUGINARXIUID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__pluginarxiuid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PLUGINDOCCUSTODYID) == 0) {
      java.lang.Long __plugindoccustodyid = __target__.getPluginDocCustodyID();
      if (__plugindoccustodyid != null ) {
        Long __count_ = null;
        try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__plugindoccustodyid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PLUGINDOCCUSTODYID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__plugindoccustodyid)));
        }
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}