package es.caib.digitalib.back.form;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 
 * @author anadal
 *
 */
@Component
public class ScanWebConfigValidator implements Validator {

  protected final Logger log = Logger.getLogger(getClass());

  public ScanWebConfigValidator() {
    super();
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return ScanWebConfigForm.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

    // Valors Not Null
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "genapp.validation.required",
        new Object[] { "type" });
/*
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "flags", "genapp.validation.required",
        new Object[] { "flags" });
*/
  }

}
