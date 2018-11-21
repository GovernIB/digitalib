package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.InfoSignaturaValidator;

import es.caib.digitalib.back.form.webdb.InfoSignaturaForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class InfoSignaturaWebValidator  implements Validator, InfoSignaturaFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected InfoSignaturaValidator<Object> validator = new InfoSignaturaValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/InfoSignaturaEJB/local")
  protected es.caib.digitalib.ejb.InfoSignaturaLocal infoSignaturaEjb;



  public InfoSignaturaWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return InfoSignaturaForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

    WebValidationResult<Object> wvr;
    wvr = new WebValidationResult<Object>(errors);

    Boolean nou = (Boolean)errors.getFieldValue("nou");
    boolean isNou =  nou != null && nou.booleanValue();

    validate(target, errors, wvr, isNou);
  }


  public void validate(Object target, Errors errors,
    WebValidationResult<Object> wvr, boolean isNou) {

    validator.validate(wvr, target,
      isNou, infoSignaturaEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public InfoSignaturaValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(InfoSignaturaValidator<Object> validator) {
    this.validator = validator;
  }

}