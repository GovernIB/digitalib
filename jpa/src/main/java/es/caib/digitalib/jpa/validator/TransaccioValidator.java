package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.InfoCustodyFields;
import es.caib.digitalib.model.fields.InfoSignaturaFields;
import es.caib.digitalib.model.fields.PerfilFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class TransaccioValidator<T> implements TransaccioFields {

  protected final Logger log = Logger.getLogger(getClass());


  public TransaccioValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<T> __vr, T __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager
    ,es.caib.digitalib.model.dao.IInfoSignaturaManager __infoSignaturaManager
    ,es.caib.digitalib.model.dao.IPerfilManager __perfilManager
    ,es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,TRANSACTIONWEBID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACTIONWEBID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATAINICI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATAINICI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ESTATCODI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATCODI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PERFILID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERFILID)));

    // Check size
    if (__vr.getFieldErrorCount(TRANSACTIONWEBID) == 0) {
      java.lang.String __transactionwebid = (java.lang.String)__vr.getFieldValue(__target__,TRANSACTIONWEBID);
      if (__transactionwebid!= null && __transactionwebid.length() > 100) {
        __vr.rejectValue(TRANSACTIONWEBID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACTIONWEBID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(ESTATMISSATGE) == 0) {
      java.lang.String __estatmissatge = (java.lang.String)__vr.getFieldValue(__target__,ESTATMISSATGE);
      if (__estatmissatge!= null && __estatmissatge.length() > 3000) {
        __vr.rejectValue(ESTATMISSATGE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATMISSATGE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(3000)));
      }
    }
    
    if (__vr.getFieldErrorCount(ESTATEXCEPCIO) == 0) {
      java.lang.String __estatexcepcio = (java.lang.String)__vr.getFieldValue(__target__,ESTATEXCEPCIO);
      if (__estatexcepcio!= null && __estatexcepcio.length() > 2147483647) {
        __vr.rejectValue(ESTATEXCEPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATEXCEPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }
    
    if (__vr.getFieldErrorCount(INFOSCANFORMATFITXER) == 0) {
      java.lang.String __infoscanformatfitxer = (java.lang.String)__vr.getFieldValue(__target__,INFOSCANFORMATFITXER);
      if (__infoscanformatfitxer!= null && __infoscanformatfitxer.length() > 100) {
        __vr.rejectValue(INFOSCANFORMATFITXER, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANFORMATFITXER)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(LANGUAGEUI) == 0) {
      java.lang.String __languageui = (java.lang.String)__vr.getFieldValue(__target__,LANGUAGEUI);
      if (__languageui!= null && __languageui.length() > 10) {
        __vr.rejectValue(LANGUAGEUI, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LANGUAGEUI)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(10)));
      }
    }
    
    if (__vr.getFieldErrorCount(LANGUAGEDOC) == 0) {
      java.lang.String __languagedoc = (java.lang.String)__vr.getFieldValue(__target__,LANGUAGEDOC);
      if (__languagedoc!= null && __languagedoc.length() > 10) {
        __vr.rejectValue(LANGUAGEDOC, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LANGUAGEDOC)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(10)));
      }
    }
    
    if (__vr.getFieldErrorCount(CIUTADANIF) == 0) {
      java.lang.String __ciutadanif = (java.lang.String)__vr.getFieldValue(__target__,CIUTADANIF);
      if (__ciutadanif!= null && __ciutadanif.length() > 15) {
        __vr.rejectValue(CIUTADANIF, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CIUTADANIF)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(15)));
      }
    }
    
    if (__vr.getFieldErrorCount(CIUTADANOM) == 0) {
      java.lang.String __ciutadanom = (java.lang.String)__vr.getFieldValue(__target__,CIUTADANOM);
      if (__ciutadanom!= null && __ciutadanom.length() > 255) {
        __vr.rejectValue(CIUTADANOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CIUTADANOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(FUNCIONARIUSERNAME) == 0) {
      java.lang.String __funcionariusername = (java.lang.String)__vr.getFieldValue(__target__,FUNCIONARIUSERNAME);
      if (__funcionariusername!= null && __funcionariusername.length() > 255) {
        __vr.rejectValue(FUNCIONARIUSERNAME, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FUNCIONARIUSERNAME)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(FUNCIONARINOM) == 0) {
      java.lang.String __funcionarinom = (java.lang.String)__vr.getFieldValue(__target__,FUNCIONARINOM);
      if (__funcionarinom!= null && __funcionarinom.length() > 255) {
        __vr.rejectValue(FUNCIONARINOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FUNCIONARINOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(EXPEDIENT) == 0) {
      java.lang.String __expedient = (java.lang.String)__vr.getFieldValue(__target__,EXPEDIENT);
      if (__expedient!= null && __expedient.length() > 255) {
        __vr.rejectValue(EXPEDIENT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EXPEDIENT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(USERNAMEREQUEST) == 0) {
      java.lang.String __usernamerequest = (java.lang.String)__vr.getFieldValue(__target__,USERNAMEREQUEST);
      if (__usernamerequest!= null && __usernamerequest.length() > 255) {
        __vr.rejectValue(USERNAMEREQUEST, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USERNAMEREQUEST)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      if (__vr.getFieldErrorCount(TRANSACTIONWEBID) == 0) {
        java.lang.String __transactionwebid = (java.lang.String)__vr.getFieldValue(__target__,TRANSACTIONWEBID);
        Long __count_ = null;
        try { __count_ = __transaccioManager.count(org.fundaciobit.genapp.common.query.Where.AND(TRANSACTIONWEBID.equal(__transactionwebid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(TRANSACTIONWEBID, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__transactionwebid)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACTIONWEBID)));
        }
      }

      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
      if (__vr.getFieldErrorCount(TRANSACTIONWEBID) == 0 && __vr.getFieldErrorCount(TRANSACCIOID) == 0) {
        java.lang.String __transactionwebid = (java.lang.String)__vr.getFieldValue(__target__,TRANSACTIONWEBID);
        java.lang.Long __transaccioid = (java.lang.Long)__vr.getFieldValue(__target__,TRANSACCIOID);
        Long __count_ = null;
        try { __count_ = __transaccioManager.count(org.fundaciobit.genapp.common.query.Where.AND(TRANSACTIONWEBID.equal(__transactionwebid), TRANSACCIOID.notEqual(__transaccioid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(TRANSACTIONWEBID, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__transactionwebid)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACTIONWEBID)));
        }
      }

    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(INFOSIGNATURAID) == 0) {
      java.lang.Long __infosignaturaid = (java.lang.Long)__vr.getFieldValue(__target__,INFOSIGNATURAID);
      if (__infosignaturaid != null ) {
        Long __count_ = null;
        try { __count_ = __infoSignaturaManager.count(InfoSignaturaFields.INFOSIGNATURAID.equal(__infosignaturaid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(INFOSIGNATURAID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("infoSignatura.infoSignatura"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("infoSignatura.infoSignaturaID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__infosignaturaid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(INFOCUSTODYID) == 0) {
      java.lang.Long __infocustodyid = (java.lang.Long)__vr.getFieldValue(__target__,INFOCUSTODYID);
      if (__infocustodyid != null ) {
        Long __count_ = null;
        try { __count_ = __infoCustodyManager.count(InfoCustodyFields.INFOCUSTODYID.equal(__infocustodyid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(INFOCUSTODYID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("infoCustody.infoCustody"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("infoCustody.infoCustodyID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__infocustodyid)));
        }
      }
    }

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

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}