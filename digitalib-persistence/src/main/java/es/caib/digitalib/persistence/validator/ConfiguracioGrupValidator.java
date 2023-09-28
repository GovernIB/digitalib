package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.ConfiguracioGrup;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.PerfilFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class ConfiguracioGrupValidator<I extends ConfiguracioGrup>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements ConfiguracioGrupFields {

    protected final Logger log = Logger.getLogger(getClass());


  public ConfiguracioGrupValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager
    ,es.caib.digitalib.model.dao.IPerfilManager __perfilManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ADREZA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ADREZA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,CODIDIR3PERDEFECTE, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODIDIR3PERDEFECTE)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 100) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(SUPORTWEB) == 0) {
      java.lang.String __suportweb = __target__.getSuportWeb();
      if (__suportweb!= null && __suportweb.length() > 255) {
        __vr.rejectValue(SUPORTWEB, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SUPORTWEB)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(SUPORTEMAIL) == 0) {
      java.lang.String __suportemail = __target__.getSuportEmail();
      if (__suportemail!= null && __suportemail.length() > 255) {
        __vr.rejectValue(SUPORTEMAIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SUPORTEMAIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(SUPORTTELEFON) == 0) {
      java.lang.String __suporttelefon = __target__.getSuportTelefon();
      if (__suporttelefon!= null && __suporttelefon.length() > 255) {
        __vr.rejectValue(SUPORTTELEFON, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SUPORTTELEFON)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ADREZA) == 0) {
      java.lang.String __adreza = __target__.getAdreza();
      if (__adreza!= null && __adreza.length() > 2147483647) {
        __vr.rejectValue(ADREZA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ADREZA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(CODIDIR3PERDEFECTE) == 0) {
      java.lang.String __codidir3perdefecte = __target__.getCodiDir3PerDefecte();
      if (__codidir3perdefecte!= null && __codidir3perdefecte.length() > 50) {
        __vr.rejectValue(CODIDIR3PERDEFECTE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CODIDIR3PERDEFECTE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
    if (__vr.getFieldErrorCount(LOGOHEADERID) == 0) { // FITXER
      Object __value = __vr.getFieldValue(__target__,LOGOHEADERID);
      if (__value == null || String.valueOf(__value).trim().length() == 0 || String.valueOf(__value).trim().equals("0") ) {
          __vr.rejectValue(LOGOHEADERID, "genapp.validation.required",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGOHEADERID)));
      }
    }

    if (__vr.getFieldErrorCount(LOGOFOOTERID) == 0) { // FITXER
      Object __value = __vr.getFieldValue(__target__,LOGOFOOTERID);
      if (__value == null || String.valueOf(__value).trim().length() == 0 || String.valueOf(__value).trim().equals("0") ) {
          __vr.rejectValue(LOGOFOOTERID, "genapp.validation.required",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LOGOFOOTERID)));
      }
    }

      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      if (__vr.getFieldErrorCount(NOM) == 0) {
        java.lang.String __nom = __target__.getNom();
        Long __count_ = null;
        try { __count_ = __configuracioGrupManager.count(org.fundaciobit.genapp.common.query.Where.AND(NOM.equal(__nom))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(NOM, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__nom)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));
        }
      }

      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
      if (__vr.getFieldErrorCount(NOM) == 0 && __vr.getFieldErrorCount(CONFIGURACIOGRUPID) == 0) {
        java.lang.String __nom = __target__.getNom();
        java.lang.Long __configuraciogrupid = __target__.getConfiguracioGrupID();
        Long __count_ = null;
        try { __count_ = __configuracioGrupManager.count(org.fundaciobit.genapp.common.query.Where.AND(NOM.equal(__nom), CONFIGURACIOGRUPID.notEqual(__configuraciogrupid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(NOM, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__nom)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));
        }
      }

    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(PERFILNOMESESCANEIGID) == 0) {
      java.lang.Long __perfilnomesescaneigid = __target__.getPerfilNomesEscaneigID();
      if (__perfilnomesescaneigid != null ) {
        Long __count_ = null;
        try { __count_ = __perfilManager.count(PerfilFields.PERFILID.equal(__perfilnomesescaneigid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PERFILNOMESESCANEIGID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfil"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfilID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilnomesescaneigid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PERFILNOMESESCANEIG2ID) == 0) {
      java.lang.Long __perfilnomesescaneig2id = __target__.getPerfilNomesEscaneig2ID();
      if (__perfilnomesescaneig2id != null ) {
        Long __count_ = null;
        try { __count_ = __perfilManager.count(PerfilFields.PERFILID.equal(__perfilnomesescaneig2id)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PERFILNOMESESCANEIG2ID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfil"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfilID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilnomesescaneig2id)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PERFILCOPIAAUTENTICAID) == 0) {
      java.lang.Long __perfilcopiaautenticaid = __target__.getPerfilCopiaAutenticaID();
      if (__perfilcopiaautenticaid != null ) {
        Long __count_ = null;
        try { __count_ = __perfilManager.count(PerfilFields.PERFILID.equal(__perfilcopiaautenticaid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PERFILCOPIAAUTENTICAID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfil"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfilID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilcopiaautenticaid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PERFILCOPIAAUTENTICA2ID) == 0) {
      java.lang.Long __perfilcopiaautentica2id = __target__.getPerfilCopiaAutentica2ID();
      if (__perfilcopiaautentica2id != null ) {
        Long __count_ = null;
        try { __count_ = __perfilManager.count(PerfilFields.PERFILID.equal(__perfilcopiaautentica2id)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PERFILCOPIAAUTENTICA2ID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfil"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfilID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilcopiaautentica2id)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PERFILCUSTODIAID) == 0) {
      java.lang.Long __perfilcustodiaid = __target__.getPerfilCustodiaID();
      if (__perfilcustodiaid != null ) {
        Long __count_ = null;
        try { __count_ = __perfilManager.count(PerfilFields.PERFILID.equal(__perfilcustodiaid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PERFILCUSTODIAID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfil"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfilID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilcustodiaid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(PERFILCUSTODIA2ID) == 0) {
      java.lang.Long __perfilcustodia2id = __target__.getPerfilCustodia2ID();
      if (__perfilcustodia2id != null ) {
        Long __count_ = null;
        try { __count_ = __perfilManager.count(PerfilFields.PERFILID.equal(__perfilcustodia2id)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PERFILCUSTODIA2ID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfil"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("perfil.perfilID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__perfilcustodia2id)));
        }
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}