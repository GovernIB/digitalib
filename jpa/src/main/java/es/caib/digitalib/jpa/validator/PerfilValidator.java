package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.ApiSimpleFields;
import es.caib.digitalib.model.fields.PluginFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class PerfilValidator<T> implements PerfilFields {

  protected final Logger log = Logger.getLogger(getClass());


  public PerfilValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<T> __vr, T __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager
    ,es.caib.digitalib.model.dao.IPerfilManager __perfilManager
    ,es.caib.digitalib.model.dao.IPluginManager __pluginManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,CODI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

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
      java.lang.String __codi = (java.lang.String)__vr.getFieldValue(__target__,CODI);
      if (__codi!= null && __codi.length() > 255) {
        __vr.rejectValue(CODI, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(CODI) == 0) {
      String val = String.valueOf(__vr.getFieldValue(__target__,CODI));
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[a-zA-Z0-9._-]{3,}$");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(CODI, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODI)));
        }
      }
    }

    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = (java.lang.String)__vr.getFieldValue(__target__,NOM);
      if (__nom!= null && __nom.length() > 100) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(DESCRIPCIO) == 0) {
      java.lang.String __descripcio = (java.lang.String)__vr.getFieldValue(__target__,DESCRIPCIO);
      if (__descripcio!= null && __descripcio.length() > 255) {
        __vr.rejectValue(DESCRIPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DESCRIPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(URLBASE) == 0) {
      java.lang.String __urlbase = (java.lang.String)__vr.getFieldValue(__target__,URLBASE);
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
        java.lang.String __codi = (java.lang.String)__vr.getFieldValue(__target__,CODI);
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
        java.lang.String __codi = (java.lang.String)__vr.getFieldValue(__target__,CODI);
        java.lang.Long __perfilid = (java.lang.Long)__vr.getFieldValue(__target__,PERFILID);
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
    if (__vr.getFieldErrorCount(PLUGINSCANWEBID) == 0) {
      java.lang.Long __pluginscanwebid = (java.lang.Long)__vr.getFieldValue(__target__,PLUGINSCANWEBID);
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
      java.lang.Long __pluginscanweb2id = (java.lang.Long)__vr.getFieldValue(__target__,PLUGINSCANWEB2ID);
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
      java.lang.Long __apisimpleid = (java.lang.Long)__vr.getFieldValue(__target__,APISIMPLEID);
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

    if (__vr.getFieldErrorCount(PLUGINFIRMASERVIDORID) == 0) {
      java.lang.Long __pluginfirmaservidorid = (java.lang.Long)__vr.getFieldValue(__target__,PLUGINFIRMASERVIDORID);
      if (__pluginfirmaservidorid != null ) {
        Long __count_ = null;
        try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__pluginfirmaservidorid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PLUGINFIRMASERVIDORID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__pluginfirmaservidorid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PLUGINARXIUID) == 0) {
      java.lang.Long __pluginarxiuid = (java.lang.Long)__vr.getFieldValue(__target__,PLUGINARXIUID);
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
      java.lang.Long __plugindoccustodyid = (java.lang.Long)__vr.getFieldValue(__target__,PLUGINDOCCUSTODYID);
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