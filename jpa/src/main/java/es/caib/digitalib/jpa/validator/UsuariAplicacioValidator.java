package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class UsuariAplicacioValidator<T> implements UsuariAplicacioFields {

  protected final Logger log = Logger.getLogger(getClass());


  public UsuariAplicacioValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<T> __vr, T __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,USERNAME, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USERNAME)));

    __vr.rejectIfEmptyOrWhitespace(__target__,EMAILADMIN, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EMAILADMIN)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ACTIU, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ACTIU)));

    // Check size
    if (__vr.getFieldErrorCount(USERNAME) == 0) {
      java.lang.String __username = (java.lang.String)__vr.getFieldValue(__target__,USERNAME);
      if (__username!= null && __username.length() > 101) {
        __vr.rejectValue(USERNAME, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USERNAME)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(101)));
      }
    }
    
    if (__vr.getFieldErrorCount(CONTRASENYA) == 0) {
      java.lang.String __contrasenya = (java.lang.String)__vr.getFieldValue(__target__,CONTRASENYA);
      if (__contrasenya!= null && __contrasenya.length() > 50) {
        __vr.rejectValue(CONTRASENYA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CONTRASENYA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }
    
    if (__vr.getFieldErrorCount(EMAILADMIN) == 0) {
      java.lang.String __emailadmin = (java.lang.String)__vr.getFieldValue(__target__,EMAILADMIN);
      if (__emailadmin!= null && __emailadmin.length() > 100) {
        __vr.rejectValue(EMAILADMIN, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EMAILADMIN)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(EMAILADMIN) == 0) {
      String val = String.valueOf(__vr.getFieldValue(__target__,EMAILADMIN));
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(EMAILADMIN, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EMAILADMIN)));
        }
      }
    }

    if (__vr.getFieldErrorCount(DESCRIPCIO) == 0) {
      java.lang.String __descripcio = (java.lang.String)__vr.getFieldValue(__target__,DESCRIPCIO);
      if (__descripcio!= null && __descripcio.length() > 255) {
        __vr.rejectValue(DESCRIPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DESCRIPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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