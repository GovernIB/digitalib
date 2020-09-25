package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.TransaccioMultipleValidator;

import es.caib.digitalib.back.form.webdb.TransaccioMultipleForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class TransaccioMultipleWebValidator  implements Validator, TransaccioMultipleFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected TransaccioMultipleValidator<Object> validator = new TransaccioMultipleValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/TransaccioMultipleEJB/local")
  protected es.caib.digitalib.ejb.TransaccioMultipleLocal transaccioMultipleEjb;



  public TransaccioMultipleWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return TransaccioMultipleForm.class.isAssignableFrom(clazz);
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

    if (isNou) { // Creacio
      // ================ CREATION
      // Fitxers 
    }
    validator.validate(wvr, target,
      isNou, transaccioMultipleEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public TransaccioMultipleValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(TransaccioMultipleValidator<Object> validator) {
    this.validator = validator;
  }

}