package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.Auditoria;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.AuditoriaFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class AuditoriaValidator<I extends Auditoria>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements AuditoriaFields {

    protected final Logger log = Logger.getLogger(getClass());


  public AuditoriaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IAuditoriaManager __auditoriaManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,DATA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TRANSACCIOID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACCIOID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUS, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUS)));

    __vr.rejectIfEmptyOrWhitespace(__target__,MISSATGE, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(MISSATGE)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ISAPP, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ISAPP)));

    // Check size
    if (__vr.getFieldErrorCount(MISSATGE) == 0) {
      java.lang.String __missatge = __target__.getMissatge();
      if (__missatge!= null && __missatge.length() > 255) {
        __vr.rejectValue(MISSATGE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(MISSATGE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ADDITIONALINFO) == 0) {
      java.lang.String __additionalinfo = __target__.getAdditionalInfo();
      if (__additionalinfo!= null && __additionalinfo.length() > 3000) {
        __vr.rejectValue(ADDITIONALINFO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ADDITIONALINFO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(3000)));
      }
    }

    if (__vr.getFieldErrorCount(USERNAMEAPLICACIO) == 0) {
      java.lang.String __usernameaplicacio = __target__.getUsernameAplicacio();
      if (__usernameaplicacio!= null && __usernameaplicacio.length() > 255) {
        __vr.rejectValue(USERNAMEAPLICACIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USERNAMEAPLICACIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(USERNAMEPERSONA) == 0) {
      java.lang.String __usernamepersona = __target__.getUsernamePersona();
      if (__usernamepersona!= null && __usernamepersona.length() > 255) {
        __vr.rejectValue(USERNAMEPERSONA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USERNAMEPERSONA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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