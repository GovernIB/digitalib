package es.caib.digitalib.jpa.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import es.caib.digitalib.model.fields.InfoCustodyFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class InfoCustodyValidator<T> implements InfoCustodyFields {

  protected final Logger log = Logger.getLogger(getClass());


  public InfoCustodyValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<T> __vr, T __target__, boolean __isNou__
    ,es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager) {

    // Valors Not Null
    // Check size
    if (__vr.getFieldErrorCount(CUSTODYFILEID) == 0) {
      java.lang.String __custodyfileid = (java.lang.String)__vr.getFieldValue(__target__,CUSTODYFILEID);
      if (__custodyfileid!= null && __custodyfileid.length() > 255) {
        __vr.rejectValue(CUSTODYFILEID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CUSTODYFILEID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUEXPEDIENTID) == 0) {
      java.lang.String __arxiuexpedientid = (java.lang.String)__vr.getFieldValue(__target__,ARXIUEXPEDIENTID);
      if (__arxiuexpedientid!= null && __arxiuexpedientid.length() > 255) {
        __vr.rejectValue(ARXIUEXPEDIENTID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUEXPEDIENTID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(ARXIUDOCUMENTID) == 0) {
      java.lang.String __arxiudocumentid = (java.lang.String)__vr.getFieldValue(__target__,ARXIUDOCUMENTID);
      if (__arxiudocumentid!= null && __arxiudocumentid.length() > 255) {
        __vr.rejectValue(ARXIUDOCUMENTID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ARXIUDOCUMENTID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(FILEURL) == 0) {
      java.lang.String __fileurl = (java.lang.String)__vr.getFieldValue(__target__,FILEURL);
      if (__fileurl!= null && __fileurl.length() > 255) {
        __vr.rejectValue(FILEURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FILEURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(CSV) == 0) {
      java.lang.String __csv = (java.lang.String)__vr.getFieldValue(__target__,CSV);
      if (__csv!= null && __csv.length() > 255) {
        __vr.rejectValue(CSV, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CSV)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(CSVVALIDATIONWEB) == 0) {
      java.lang.String __csvvalidationweb = (java.lang.String)__vr.getFieldValue(__target__,CSVVALIDATIONWEB);
      if (__csvvalidationweb!= null && __csvvalidationweb.length() > 255) {
        __vr.rejectValue(CSVVALIDATIONWEB, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CSVVALIDATIONWEB)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }
    
    if (__vr.getFieldErrorCount(CSVGENERATIONDEFINITION) == 0) {
      java.lang.String __csvgenerationdefinition = (java.lang.String)__vr.getFieldValue(__target__,CSVGENERATIONDEFINITION);
      if (__csvgenerationdefinition!= null && __csvgenerationdefinition.length() > 255) {
        __vr.rejectValue(CSVGENERATIONDEFINITION, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CSVGENERATIONDEFINITION)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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