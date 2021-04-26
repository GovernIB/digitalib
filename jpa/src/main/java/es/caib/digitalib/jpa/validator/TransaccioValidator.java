package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.InfoCustodyFields;
import es.caib.digitalib.model.fields.InfoSignaturaFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.TransaccioMultipleFields;

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
    ,es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager
    ,es.caib.digitalib.model.dao.ITransaccioMultipleManager __transaccioMultipleManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,TRANSACTIONWEBID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACTIONWEBID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATAINICI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATAINICI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,IP, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(IP)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ESTATCODI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATCODI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,VIEW, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(VIEW)));

    __vr.rejectIfEmptyOrWhitespace(__target__,LANGUAGEUI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LANGUAGEUI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,FUNCIONARIUSERNAME, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FUNCIONARIUSERNAME)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PERFILID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PERFILID)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = (java.lang.String)__vr.getFieldValue(__target__,NOM);
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(TRANSACTIONWEBID) == 0) {
      java.lang.String __transactionwebid = (java.lang.String)__vr.getFieldValue(__target__,TRANSACTIONWEBID);
      if (__transactionwebid!= null && __transactionwebid.length() > 100) {
        __vr.rejectValue(TRANSACTIONWEBID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACTIONWEBID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(IP) == 0) {
      java.lang.String __ip = (java.lang.String)__vr.getFieldValue(__target__,IP);
      if (__ip!= null && __ip.length() > 50) {
        __vr.rejectValue(IP, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(IP)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }
    
    if (__vr.getFieldErrorCount(RETURNURL) == 0) {
      java.lang.String __returnurl = (java.lang.String)__vr.getFieldValue(__target__,RETURNURL);
      if (__returnurl!= null && __returnurl.length() > 255) {
        __vr.rejectValue(RETURNURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(RETURNURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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
    
    if (__vr.getFieldErrorCount(HASHESCANEIG) == 0) {
      java.lang.String __hashescaneig = (java.lang.String)__vr.getFieldValue(__target__,HASHESCANEIG);
      if (__hashescaneig!= null && __hashescaneig.length() > 255) {
        __vr.rejectValue(HASHESCANEIG, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(HASHESCANEIG)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(HASHFIRMA) == 0) {
      java.lang.String __hashfirma = (java.lang.String)__vr.getFieldValue(__target__,HASHFIRMA);
      if (__hashfirma!= null && __hashfirma.length() > 255) {
        __vr.rejectValue(HASHFIRMA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(HASHFIRMA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(INFOSCANPAPERSIZE) == 0) {
      java.lang.String __infoscanpapersize = (java.lang.String)__vr.getFieldValue(__target__,INFOSCANPAPERSIZE);
      if (__infoscanpapersize!= null && __infoscanpapersize.length() > 100) {
        __vr.rejectValue(INFOSCANPAPERSIZE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANPAPERSIZE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(INFOSCANLANGUAGEDOC) == 0) {
      java.lang.String __infoscanlanguagedoc = (java.lang.String)__vr.getFieldValue(__target__,INFOSCANLANGUAGEDOC);
      if (__infoscanlanguagedoc!= null && __infoscanlanguagedoc.length() > 10) {
        __vr.rejectValue(INFOSCANLANGUAGEDOC, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANLANGUAGEDOC)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(10)));
      }
    }
    
    if (__vr.getFieldErrorCount(INFOSCANLANGUAGEDOC) == 0) {
      String val = String.valueOf(__vr.getFieldValue(__target__,INFOSCANLANGUAGEDOC));
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("(ca|es|gl|eu|en|fr|it|de)");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(INFOSCANLANGUAGEDOC, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANLANGUAGEDOC)));
        }
      }
    }

    if (__vr.getFieldErrorCount(INFOSCANDOCUMENTTIPUS) == 0) {
      java.lang.String __infoscandocumenttipus = (java.lang.String)__vr.getFieldValue(__target__,INFOSCANDOCUMENTTIPUS);
      if (__infoscandocumenttipus!= null && __infoscandocumenttipus.length() > 4) {
        __vr.rejectValue(INFOSCANDOCUMENTTIPUS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANDOCUMENTTIPUS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(4)));
      }
    }
    
    if (__vr.getFieldErrorCount(INFOSCANDOCUMENTTIPUS) == 0) {
      String val = String.valueOf(__vr.getFieldValue(__target__,INFOSCANDOCUMENTTIPUS));
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("(TD01|TD02|TD03|TD04|TD05|TD06|TD07|TD08|TD09|TD10|TD11|TD12|TD13|TD14|TD15|TD16|TD17|TD18|TD19|TD20|TD51|TD52|TD53|TD54|TD55|TD56|TD57|TD58|TD59|TD60|TD61|TD62|TD63|TD64|TD65|TD66|TD67|TD68|TD69|TD99)");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(INFOSCANDOCUMENTTIPUS, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANDOCUMENTTIPUS)));
        }
      }
    }

    if (__vr.getFieldErrorCount(LANGUAGEUI) == 0) {
      java.lang.String __languageui = (java.lang.String)__vr.getFieldValue(__target__,LANGUAGEUI);
      if (__languageui!= null && __languageui.length() > 10) {
        __vr.rejectValue(LANGUAGEUI, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LANGUAGEUI)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(10)));
      }
    }
    
    if (__vr.getFieldErrorCount(FUNCIONARIUSERNAME) == 0) {
      java.lang.String __funcionariusername = (java.lang.String)__vr.getFieldValue(__target__,FUNCIONARIUSERNAME);
      if (__funcionariusername!= null && __funcionariusername.length() > 255) {
        __vr.rejectValue(FUNCIONARIUSERNAME, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FUNCIONARIUSERNAME)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(SIGNPARAMFUNCIONARINOM) == 0) {
      java.lang.String __signparamfuncionarinom = (java.lang.String)__vr.getFieldValue(__target__,SIGNPARAMFUNCIONARINOM);
      if (__signparamfuncionarinom!= null && __signparamfuncionarinom.length() > 255) {
        __vr.rejectValue(SIGNPARAMFUNCIONARINOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SIGNPARAMFUNCIONARINOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(SIGNPARAMFUNCIONARINIF) == 0) {
      java.lang.String __signparamfuncionarinif = (java.lang.String)__vr.getFieldValue(__target__,SIGNPARAMFUNCIONARINIF);
      if (__signparamfuncionarinif!= null && __signparamfuncionarinif.length() > 255) {
        __vr.rejectValue(SIGNPARAMFUNCIONARINIF, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SIGNPARAMFUNCIONARINIF)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(SIGNPARAMFUNCIONARIDIR3) == 0) {
      java.lang.String __signparamfuncionaridir3 = (java.lang.String)__vr.getFieldValue(__target__,SIGNPARAMFUNCIONARIDIR3);
      if (__signparamfuncionaridir3!= null && __signparamfuncionaridir3.length() > 100) {
        __vr.rejectValue(SIGNPARAMFUNCIONARIDIR3, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SIGNPARAMFUNCIONARIDIR3)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUREQPARAMDOCESTATELABORA) == 0) {
      java.lang.String __arxiureqparamdocestatelabora = (java.lang.String)__vr.getFieldValue(__target__,ARXIUREQPARAMDOCESTATELABORA);
      if (__arxiureqparamdocestatelabora!= null && __arxiureqparamdocestatelabora.length() > 4) {
        __vr.rejectValue(ARXIUREQPARAMDOCESTATELABORA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMDOCESTATELABORA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(4)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUREQPARAMDOCESTATELABORA) == 0) {
      String val = String.valueOf(__vr.getFieldValue(__target__,ARXIUREQPARAMDOCESTATELABORA));
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("(EE01|EE02|EE03|EE04|EE99)");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(ARXIUREQPARAMDOCESTATELABORA, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMDOCESTATELABORA)));
        }
      }
    }

    if (__vr.getFieldErrorCount(ARXIUREQPARAMINTERESSATS) == 0) {
      java.lang.String __arxiureqparaminteressats = (java.lang.String)__vr.getFieldValue(__target__,ARXIUREQPARAMINTERESSATS);
      if (__arxiureqparaminteressats!= null && __arxiureqparaminteressats.length() > 255) {
        __vr.rejectValue(ARXIUREQPARAMINTERESSATS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMINTERESSATS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUREQPARAMCIUTADANIF) == 0) {
      java.lang.String __arxiureqparamciutadanif = (java.lang.String)__vr.getFieldValue(__target__,ARXIUREQPARAMCIUTADANIF);
      if (__arxiureqparamciutadanif!= null && __arxiureqparamciutadanif.length() > 15) {
        __vr.rejectValue(ARXIUREQPARAMCIUTADANIF, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMCIUTADANIF)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(15)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUREQPARAMCIUTADANOM) == 0) {
      java.lang.String __arxiureqparamciutadanom = (java.lang.String)__vr.getFieldValue(__target__,ARXIUREQPARAMCIUTADANOM);
      if (__arxiureqparamciutadanom!= null && __arxiureqparamciutadanom.length() > 255) {
        __vr.rejectValue(ARXIUREQPARAMCIUTADANOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMCIUTADANOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUREQPARAMORGANS) == 0) {
      java.lang.String __arxiureqparamorgans = (java.lang.String)__vr.getFieldValue(__target__,ARXIUREQPARAMORGANS);
      if (__arxiureqparamorgans!= null && __arxiureqparamorgans.length() > 255) {
        __vr.rejectValue(ARXIUREQPARAMORGANS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMORGANS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUOPTPARAMPROCEDIMENTCODI) == 0) {
      java.lang.String __arxiuoptparamprocedimentcodi = (java.lang.String)__vr.getFieldValue(__target__,ARXIUOPTPARAMPROCEDIMENTCODI);
      if (__arxiuoptparamprocedimentcodi!= null && __arxiuoptparamprocedimentcodi.length() > 255) {
        __vr.rejectValue(ARXIUOPTPARAMPROCEDIMENTCODI, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUOPTPARAMPROCEDIMENTCODI)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUOPTPARAMPROCEDIMENTNOM) == 0) {
      java.lang.String __arxiuoptparamprocedimentnom = (java.lang.String)__vr.getFieldValue(__target__,ARXIUOPTPARAMPROCEDIMENTNOM);
      if (__arxiuoptparamprocedimentnom!= null && __arxiuoptparamprocedimentnom.length() > 255) {
        __vr.rejectValue(ARXIUOPTPARAMPROCEDIMENTNOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUOPTPARAMPROCEDIMENTNOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUOPTPARAMSERIEDOCUMENTAL) == 0) {
      java.lang.String __arxiuoptparamseriedocumental = (java.lang.String)__vr.getFieldValue(__target__,ARXIUOPTPARAMSERIEDOCUMENTAL);
      if (__arxiuoptparamseriedocumental!= null && __arxiuoptparamseriedocumental.length() > 255) {
        __vr.rejectValue(ARXIUOPTPARAMSERIEDOCUMENTAL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUOPTPARAMSERIEDOCUMENTAL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUOPTPARAMCUSTODYOREXPEDIENTID) == 0) {
      java.lang.String __arxiuoptparamcustodyorexpedientid = (java.lang.String)__vr.getFieldValue(__target__,ARXIUOPTPARAMCUSTODYOREXPEDIENTID);
      if (__arxiuoptparamcustodyorexpedientid!= null && __arxiuoptparamcustodyorexpedientid.length() > 255) {
        __vr.rejectValue(ARXIUOPTPARAMCUSTODYOREXPEDIENTID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUOPTPARAMCUSTODYOREXPEDIENTID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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

    if (__vr.getFieldErrorCount(TRANSACCIOMULTIPLEID) == 0) {
      java.lang.Long __transacciomultipleid = (java.lang.Long)__vr.getFieldValue(__target__,TRANSACCIOMULTIPLEID);
      if (__transacciomultipleid != null ) {
        Long __count_ = null;
        try { __count_ = __transaccioMultipleManager.count(TransaccioMultipleFields.TRANSMULTIPLEID.equal(__transacciomultipleid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(TRANSACCIOMULTIPLEID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("transaccioMultiple.transaccioMultiple"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("transaccioMultiple.transmultipleid"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__transacciomultipleid)));
        }
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}