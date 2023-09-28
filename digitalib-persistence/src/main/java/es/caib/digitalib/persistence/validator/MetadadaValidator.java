package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.Metadada;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.MetadadaFields;
import es.caib.digitalib.model.fields.TransaccioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class MetadadaValidator<I extends Metadada>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements MetadadaFields {

    protected final Logger log = Logger.getLogger(getClass());


  public MetadadaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IMetadadaManager __metadadaManager
    ,es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,TRANSACCIOID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACCIOID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,VALOR, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(VALOR)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(VALOR) == 0) {
      java.lang.String __valor = __target__.getValor();
      if (__valor!= null && __valor.length() > 3000) {
        __vr.rejectValue(VALOR, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(VALOR)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(3000)));
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
    if (__vr.getFieldErrorCount(TRANSACCIOID) == 0) {
      java.lang.Long __transaccioid = __target__.getTransaccioID();
      Long __count_ = null;
      try { __count_ = __transaccioManager.count(TransaccioFields.TRANSACCIOID.equal(__transaccioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(TRANSACCIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("transaccio.transaccio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("transaccio.transaccioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__transaccioid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}