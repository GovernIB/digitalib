package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.ApiSimpleValidator;

import es.caib.digitalib.back.form.webdb.ApiSimpleForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ApiSimpleWebValidator  implements Validator, ApiSimpleFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected ApiSimpleValidator<Object> validator = new ApiSimpleValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/ApiSimpleEJB/local")
  protected es.caib.digitalib.ejb.ApiSimpleLocal apiSimpleEjb;



  public ApiSimpleWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return ApiSimpleForm.class.isAssignableFrom(clazz);
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
      isNou, apiSimpleEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public ApiSimpleValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(ApiSimpleValidator<Object> validator) {
    this.validator = validator;
  }

}