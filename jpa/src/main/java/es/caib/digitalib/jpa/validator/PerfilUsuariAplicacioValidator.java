package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class PerfilUsuariAplicacioValidator<T> implements PerfilUsuariAplicacioFields {

  protected final Logger log = Logger.getLogger(getClass());


  public PerfilUsuariAplicacioValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<T> __vr, T __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IPerfilManager __perfilManager
    ,es.caib.digitalib.model.dao.IPerfilUsuariAplicacioManager __perfilUsuariAplicacioManager
    ,es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,PERFILID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERFILID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,USUARIAPLICACIOID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIAPLICACIOID)));

    // Check size
    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique MULTIPLE for (perfilid, usuariaplicacioid)
      if (__vr.getFieldErrorCount(PERFILID) == 0 && __vr.getFieldErrorCount(USUARIAPLICACIOID) == 0) {
        java.lang.Long __perfilid = (java.lang.Long)__vr.getFieldValue(__target__,PERFILID);
        java.lang.Long __usuariaplicacioid = (java.lang.Long)__vr.getFieldValue(__target__,USUARIAPLICACIOID);
        Long __count_ = null;
        try { __count_ = __perfilUsuariAplicacioManager.count(org.fundaciobit.genapp.common.query.Where.AND(PERFILID.equal(__perfilid), USUARIAPLICACIOID.equal(__usuariaplicacioid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(PERFILID, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilid)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERFILID)));
            __vr.rejectValue(USUARIAPLICACIOID, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__usuariaplicacioid)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIAPLICACIOID)));
        }
      }

      // Check Unique - no PK
      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique MULTIPLE for (perfilid, usuariaplicacioid)
      if (__vr.getFieldErrorCount(PERFILID) == 0 && __vr.getFieldErrorCount(USUARIAPLICACIOID) == 0 && __vr.getFieldErrorCount(PERFILUSRAPPID) == 0) {
        java.lang.Long __perfilid = (java.lang.Long)__vr.getFieldValue(__target__,PERFILID);
        java.lang.Long __usuariaplicacioid = (java.lang.Long)__vr.getFieldValue(__target__,USUARIAPLICACIOID);
        java.lang.Long __perfilusrappid = (java.lang.Long)__vr.getFieldValue(__target__,PERFILUSRAPPID);
        Long __count_ = null;
        try { __count_ = __perfilUsuariAplicacioManager.count(org.fundaciobit.genapp.common.query.Where.AND(PERFILID.equal(__perfilid), USUARIAPLICACIOID.equal(__usuariaplicacioid), PERFILUSRAPPID.notEqual(__perfilusrappid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(PERFILID, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilid)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERFILID)));
            __vr.rejectValue(USUARIAPLICACIOID, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__usuariaplicacioid)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIAPLICACIOID)));
        }
      }

      // Check Unique - no PK
    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(PERFILID) == 0) {
      java.lang.Long __perfilid = (java.lang.Long)__vr.getFieldValue(__target__,PERFILID);
      Long __count_ = null;
      try { __count_ = __perfilManager.count(PerfilFields.PERFILID.equal(__perfilid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(PERFILID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfil"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfilID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilid)));
      }
    }

    if (__vr.getFieldErrorCount(USUARIAPLICACIOID) == 0) {
      java.lang.Long __usuariaplicacioid = (java.lang.Long)__vr.getFieldValue(__target__,USUARIAPLICACIOID);
      Long __count_ = null;
      try { __count_ = __usuariAplicacioManager.count(UsuariAplicacioFields.USUARIAPLICACIOID.equal(__usuariaplicacioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(USUARIAPLICACIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuariAplicacio.usuariAplicacio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuariAplicacio.usuariAplicacioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__usuariaplicacioid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}