package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.Avis;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.AvisFields;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.TraduccioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class AvisValidator<I extends Avis>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements AvisFields {

    protected final Logger log = Logger.getLogger(getClass());


  public AvisValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IAvisManager __avisManager
    ,es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager
    ,es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,DESCRIPCIOID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DESCRIPCIOID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TIPUS, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TIPUS)));

    __vr.rejectIfEmptyOrWhitespace(__target__,BLOQUEJAR, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(BLOQUEJAR)));

    // Check size
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
    if (__vr.getFieldErrorCount(DESCRIPCIOID) == 0) {
      java.lang.Long __descripcioid = __target__.getDescripcioID();
      Long __count_ = null;
      try { __count_ = __traduccioManager.count(TraduccioFields.TRADUCCIOID.equal(__descripcioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(DESCRIPCIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__descripcioid)));
      }
    }

    if (__vr.getFieldErrorCount(CONFIGGRUPID) == 0) {
      java.lang.Long __configgrupid = __target__.getConfigGrupID();
      if (__configgrupid != null ) {
        Long __count_ = null;
        try { __count_ = __configuracioGrupManager.count(ConfiguracioGrupFields.CONFIGURACIOGRUPID.equal(__configgrupid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(CONFIGGRUPID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("configuracioGrup.configuracioGrup"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("configuracioGrup.configuracioGrupID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__configgrupid)));
        }
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}