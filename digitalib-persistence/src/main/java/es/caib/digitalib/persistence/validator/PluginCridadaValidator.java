package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.PluginCridada;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.PluginCridadaFields;
import es.caib.digitalib.model.fields.PluginFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class PluginCridadaValidator<I extends PluginCridada>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements PluginCridadaFields {

    protected final Logger log = Logger.getLogger(getClass());


  public PluginCridadaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IPluginManager __pluginManager
    ,es.caib.digitalib.model.dao.IPluginCridadaManager __pluginCridadaManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,DATA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PLUGINID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PLUGINID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,METODEPLUGIN, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(METODEPLUGIN)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUSRESULTAT, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUSRESULTAT)));

    // Check size
    if (__vr.getFieldErrorCount(METODEPLUGIN) == 0) {
      java.lang.String __metodeplugin = __target__.getMetodePlugin();
      if (__metodeplugin!= null && __metodeplugin.length() > 100) {
        __vr.rejectValue(METODEPLUGIN, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(METODEPLUGIN)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(PARAMETRESTEXT) == 0) {
      java.lang.String __parametrestext = __target__.getParametresText();
      if (__parametrestext!= null && __parametrestext.length() > 2147483647) {
        __vr.rejectValue(PARAMETRESTEXT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PARAMETRESTEXT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(RETORNTEXT) == 0) {
      java.lang.String __retorntext = __target__.getRetornText();
      if (__retorntext!= null && __retorntext.length() > 2147483647) {
        __vr.rejectValue(RETORNTEXT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(RETORNTEXT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
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
    if (__vr.getFieldErrorCount(PLUGINID) == 0) {
      java.lang.Long __pluginid = __target__.getPluginID();
      Long __count_ = null;
      try { __count_ = __pluginManager.count(PluginFields.PLUGINID.equal(__pluginid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(PLUGINID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.plugin"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("plugin.pluginID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__pluginid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}