package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.Estadistica;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.EstadisticaFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class EstadisticaValidator<I extends Estadistica>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements EstadisticaFields {

    protected final Logger log = Logger.getLogger(getClass());


  public EstadisticaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IEstadisticaManager __estadisticaManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUS, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUS)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,VALOR, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(VALOR)));

    // Check size
    if (__vr.getFieldErrorCount(PARAMETRES) == 0) {
      java.lang.String __parametres = __target__.getParametres();
      if (__parametres!= null && __parametres.length() > 3000) {
        __vr.rejectValue(PARAMETRES, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PARAMETRES)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(3000)));
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