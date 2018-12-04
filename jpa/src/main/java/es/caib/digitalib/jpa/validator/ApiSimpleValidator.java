package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.ApiSimpleFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class ApiSimpleValidator<T> implements ApiSimpleFields {

  protected final Logger log = Logger.getLogger(getClass());


  public ApiSimpleValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<T> __vr, T __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,URL, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(URL)));

    __vr.rejectIfEmptyOrWhitespace(__target__,USERNAME, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USERNAME)));

    __vr.rejectIfEmptyOrWhitespace(__target__,CONTRASENYA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CONTRASENYA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PERFIL, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERFIL)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = (java.lang.String)__vr.getFieldValue(__target__,NOM);
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(URL) == 0) {
      java.lang.String __url = (java.lang.String)__vr.getFieldValue(__target__,URL);
      if (__url!= null && __url.length() > 255) {
        __vr.rejectValue(URL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(URL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(USERNAME) == 0) {
      java.lang.String __username = (java.lang.String)__vr.getFieldValue(__target__,USERNAME);
      if (__username!= null && __username.length() > 255) {
        __vr.rejectValue(USERNAME, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USERNAME)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(CONTRASENYA) == 0) {
      java.lang.String __contrasenya = (java.lang.String)__vr.getFieldValue(__target__,CONTRASENYA);
      if (__contrasenya!= null && __contrasenya.length() > 255) {
        __vr.rejectValue(CONTRASENYA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CONTRASENYA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(PERFIL) == 0) {
      java.lang.String __perfil = (java.lang.String)__vr.getFieldValue(__target__,PERFIL);
      if (__perfil!= null && __perfil.length() > 255) {
        __vr.rejectValue(PERFIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERFIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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
  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}