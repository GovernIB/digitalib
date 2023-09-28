package es.caib.digitalib.persistence.validator;

import org.apache.log4j.Logger;

import es.caib.digitalib.model.entity.InfoCustody;
import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.InfoCustodyFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class InfoCustodyValidator<I extends InfoCustody>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements InfoCustodyFields {

    protected final Logger log = Logger.getLogger(getClass());


  public InfoCustodyValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager) {

    // Valors Not Null
    // Check size
    if (__vr.getFieldErrorCount(CUSTODYID) == 0) {
      java.lang.String __custodyid = __target__.getCustodyId();
      if (__custodyid!= null && __custodyid.length() > 255) {
        __vr.rejectValue(CUSTODYID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CUSTODYID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUEXPEDIENTID) == 0) {
      java.lang.String __arxiuexpedientid = __target__.getArxiuExpedientId();
      if (__arxiuexpedientid!= null && __arxiuexpedientid.length() > 255) {
        __vr.rejectValue(ARXIUEXPEDIENTID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUEXPEDIENTID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ARXIUDOCUMENTID) == 0) {
      java.lang.String __arxiudocumentid = __target__.getArxiuDocumentId();
      if (__arxiudocumentid!= null && __arxiudocumentid.length() > 255) {
        __vr.rejectValue(ARXIUDOCUMENTID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUDOCUMENTID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(CSV) == 0) {
      java.lang.String __csv = __target__.getCsv();
      if (__csv!= null && __csv.length() > 255) {
        __vr.rejectValue(CSV, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CSV)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ORIGINALFILEURL) == 0) {
      java.lang.String __originalfileurl = __target__.getOriginalFileUrl();
      if (__originalfileurl!= null && __originalfileurl.length() > 255) {
        __vr.rejectValue(ORIGINALFILEURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ORIGINALFILEURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(CSVVALIDATIONWEB) == 0) {
      java.lang.String __csvvalidationweb = __target__.getCsvValidationWeb();
      if (__csvvalidationweb!= null && __csvvalidationweb.length() > 255) {
        __vr.rejectValue(CSVVALIDATIONWEB, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CSVVALIDATIONWEB)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(CSVGENERATIONDEFINITION) == 0) {
      java.lang.String __csvgenerationdefinition = __target__.getCsvGenerationDefinition();
      if (__csvgenerationdefinition!= null && __csvgenerationdefinition.length() > 255) {
        __vr.rejectValue(CSVGENERATIONDEFINITION, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CSVGENERATIONDEFINITION)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(PRINTABLEFILEURL) == 0) {
      java.lang.String __printablefileurl = __target__.getPrintableFileUrl();
      if (__printablefileurl!= null && __printablefileurl.length() > 255) {
        __vr.rejectValue(PRINTABLEFILEURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PRINTABLEFILEURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ENIFILEURL) == 0) {
      java.lang.String __enifileurl = __target__.getEniFileUrl();
      if (__enifileurl!= null && __enifileurl.length() > 255) {
        __vr.rejectValue(ENIFILEURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ENIFILEURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(VALIDATIONFILEURL) == 0) {
      java.lang.String __validationfileurl = __target__.getValidationFileUrl();
      if (__validationfileurl!= null && __validationfileurl.length() > 255) {
        __vr.rejectValue(VALIDATIONFILEURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(VALIDATIONFILEURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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