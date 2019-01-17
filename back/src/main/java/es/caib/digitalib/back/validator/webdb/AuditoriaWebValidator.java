package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.AuditoriaValidator;

import es.caib.digitalib.back.form.webdb.AuditoriaForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class AuditoriaWebValidator  implements Validator, AuditoriaFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected AuditoriaValidator<Object> validator = new AuditoriaValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/AuditoriaEJB/local")
  protected es.caib.digitalib.ejb.AuditoriaLocal auditoriaEjb;



  public AuditoriaWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return AuditoriaForm.class.isAssignableFrom(clazz);
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
      isNou, auditoriaEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public AuditoriaValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(AuditoriaValidator<Object> validator) {
    this.validator = validator;
  }

}