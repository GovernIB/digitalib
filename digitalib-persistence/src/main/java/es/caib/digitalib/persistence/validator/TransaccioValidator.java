package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.Transaccio;
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
public class TransaccioValidator<I extends Transaccio>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements TransaccioFields {

    protected final Logger log = Logger.getLogger(getClass());


  public TransaccioValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
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
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(TRANSACTIONWEBID) == 0) {
      java.lang.String __transactionwebid = __target__.getTransactionWebId();
      if (__transactionwebid!= null && __transactionwebid.length() > 100) {
        __vr.rejectValue(TRANSACTIONWEBID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TRANSACTIONWEBID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(IP) == 0) {
      java.lang.String __ip = __target__.getIp();
      if (__ip!= null && __ip.length() > 50) {
        __vr.rejectValue(IP, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(IP)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }

    if (__vr.getFieldErrorCount(RETURNURL) == 0) {
      java.lang.String __returnurl = __target__.getReturnUrl();
      if (__returnurl!= null && __returnurl.length() > 255) {
        __vr.rejectValue(RETURNURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(RETURNURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ESTATMISSATGE) == 0) {
      java.lang.String __estatmissatge = __target__.getEstatMissatge();
      if (__estatmissatge!= null && __estatmissatge.length() > 3000) {
        __vr.rejectValue(ESTATMISSATGE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATMISSATGE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(3000)));
      }
    }

    if (__vr.getFieldErrorCount(ESTATEXCEPCIO) == 0) {
      java.lang.String __estatexcepcio = __target__.getEstatExcepcio();
      if (__estatexcepcio!= null && __estatexcepcio.length() > 2147483647) {
        __vr.rejectValue(ESTATEXCEPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ESTATEXCEPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(HASHESCANEIG) == 0) {
      java.lang.String __hashescaneig = __target__.getHashEscaneig();
      if (__hashescaneig!= null && __hashescaneig.length() > 255) {
        __vr.rejectValue(HASHESCANEIG, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(HASHESCANEIG)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(HASHFIRMA) == 0) {
      java.lang.String __hashfirma = __target__.getHashFirma();
      if (__hashfirma!= null && __hashfirma.length() > 255) {
        __vr.rejectValue(HASHFIRMA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(HASHFIRMA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(INFOSCANPAPERSIZE) == 0) {
      java.lang.String __infoscanpapersize = __target__.getInfoScanPaperSize();
      if (__infoscanpapersize!= null && __infoscanpapersize.length() > 100) {
        __vr.rejectValue(INFOSCANPAPERSIZE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANPAPERSIZE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(INFOSCANLANGUAGEDOC) == 0) {
      java.lang.String __infoscanlanguagedoc = __target__.getInfoScanLanguageDoc();
      if (__infoscanlanguagedoc!= null && __infoscanlanguagedoc.length() > 10) {
        __vr.rejectValue(INFOSCANLANGUAGEDOC, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANLANGUAGEDOC)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(10)));
      }
    }

    if (__vr.getFieldErrorCount(INFOSCANDOCUMENTTIPUS) == 0) {
      java.lang.String __infoscandocumenttipus = __target__.getInfoScanDocumentTipus();
      if (__infoscandocumenttipus!= null && __infoscandocumenttipus.length() > 4) {
        __vr.rejectValue(INFOSCANDOCUMENTTIPUS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(INFOSCANDOCUMENTTIPUS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(4)));
      }
    }

    if (__vr.getFieldErrorCount(LANGUAGEUI) == 0) {
      java.lang.String __languageui = __target__.getLanguageUI();
      if (__languageui!= null && __languageui.length() > 10) {
        __vr.rejectValue(LANGUAGEUI, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LANGUAGEUI)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(10)));
      }
    }

    if (__vr.getFieldErrorCount(FUNCIONARIUSERNAME) == 0) {
      java.lang.String __funcionariusername = __target__.getFuncionariUsername();
      if (__funcionariusername!= null && __funcionariusername.length() > 255) {
        __vr.rejectValue(FUNCIONARIUSERNAME, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FUNCIONARIUSERNAME)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(SIGNPARAMFUNCIONARINOM) == 0) {
      java.lang.String __signparamfuncionarinom = __target__.getSignParamFuncionariNom();
      if (__signparamfuncionarinom!= null && __signparamfuncionarinom.length() > 255) {
        __vr.rejectValue(SIGNPARAMFUNCIONARINOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SIGNPARAMFUNCIONARINOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(SIGNPARAMFUNCIONARINIF) == 0) {
      java.lang.String __signparamfuncionarinif = __target__.getSignParamFuncionariNif();
      if (__signparamfuncionarinif!= null && __signparamfuncionarinif.length() > 255) {
        __vr.rejectValue(SIGNPARAMFUNCIONARINIF, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SIGNPARAMFUNCIONARINIF)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(SIGNPARAMFUNCIONARIDIR3) == 0) {
      java.lang.String __signparamfuncionaridir3 = __target__.getSignParamFuncionariDir3();
      if (__signparamfuncionaridir3!= null && __signparamfuncionaridir3.length() > 100) {
        __vr.rejectValue(SIGNPARAMFUNCIONARIDIR3, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SIGNPARAMFUNCIONARIDIR3)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUREQPARAMDOCESTATELABORA) == 0) {
      java.lang.String __arxiureqparamdocestatelabora = __target__.getArxiuReqParamDocEstatElabora();
      if (__arxiureqparamdocestatelabora!= null && __arxiureqparamdocestatelabora.length() > 4) {
        __vr.rejectValue(ARXIUREQPARAMDOCESTATELABORA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMDOCESTATELABORA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(4)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUREQPARAMINTERESSATS) == 0) {
      java.lang.String __arxiureqparaminteressats = __target__.getArxiuReqParamInteressats();
      if (__arxiureqparaminteressats!= null && __arxiureqparaminteressats.length() > 255) {
        __vr.rejectValue(ARXIUREQPARAMINTERESSATS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMINTERESSATS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUREQPARAMCIUTADANIF) == 0) {
      java.lang.String __arxiureqparamciutadanif = __target__.getArxiuReqParamCiutadaNif();
      if (__arxiureqparamciutadanif!= null && __arxiureqparamciutadanif.length() > 15) {
        __vr.rejectValue(ARXIUREQPARAMCIUTADANIF, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMCIUTADANIF)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(15)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUREQPARAMCIUTADANOM) == 0) {
      java.lang.String __arxiureqparamciutadanom = __target__.getArxiuReqParamCiutadaNom();
      if (__arxiureqparamciutadanom!= null && __arxiureqparamciutadanom.length() > 255) {
        __vr.rejectValue(ARXIUREQPARAMCIUTADANOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMCIUTADANOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUREQPARAMORGANS) == 0) {
      java.lang.String __arxiureqparamorgans = __target__.getArxiuReqParamOrgans();
      if (__arxiureqparamorgans!= null && __arxiureqparamorgans.length() > 255) {
        __vr.rejectValue(ARXIUREQPARAMORGANS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUREQPARAMORGANS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUOPTPARAMPROCEDIMENTCODI) == 0) {
      java.lang.String __arxiuoptparamprocedimentcodi = __target__.getArxiuOptParamProcedimentCodi();
      if (__arxiuoptparamprocedimentcodi!= null && __arxiuoptparamprocedimentcodi.length() > 255) {
        __vr.rejectValue(ARXIUOPTPARAMPROCEDIMENTCODI, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUOPTPARAMPROCEDIMENTCODI)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUOPTPARAMPROCEDIMENTNOM) == 0) {
      java.lang.String __arxiuoptparamprocedimentnom = __target__.getArxiuOptParamProcedimentNom();
      if (__arxiuoptparamprocedimentnom!= null && __arxiuoptparamprocedimentnom.length() > 255) {
        __vr.rejectValue(ARXIUOPTPARAMPROCEDIMENTNOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUOPTPARAMPROCEDIMENTNOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUOPTPARAMSERIEDOCUMENTAL) == 0) {
      java.lang.String __arxiuoptparamseriedocumental = __target__.getArxiuOptParamSerieDocumental();
      if (__arxiuoptparamseriedocumental!= null && __arxiuoptparamseriedocumental.length() > 255) {
        __vr.rejectValue(ARXIUOPTPARAMSERIEDOCUMENTAL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUOPTPARAMSERIEDOCUMENTAL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUOPTPARAMCUSTODYOREXPEDIENTID) == 0) {
      java.lang.String __arxiuoptparamcustodyorexpedientid = __target__.getArxiuOptParamCustodyOrExpedientId();
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
        java.lang.String __transactionwebid = __target__.getTransactionWebId();
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
        java.lang.String __transactionwebid = __target__.getTransactionWebId();
        java.lang.Long __transaccioid = __target__.getTransaccioID();
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
    if (__vr.getFieldErrorCount(TRANSACCIOMULTIPLEID) == 0) {
      java.lang.Long __transacciomultipleid = __target__.getTransaccioMultipleID();
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

    if (__vr.getFieldErrorCount(PERFILID) == 0) {
      java.lang.Long __perfilid = __target__.getPerfilID();
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
      java.lang.Long __infosignaturaid = __target__.getInfoSignaturaID();
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
      java.lang.Long __infocustodyid = __target__.getInfoCustodyID();
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

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}