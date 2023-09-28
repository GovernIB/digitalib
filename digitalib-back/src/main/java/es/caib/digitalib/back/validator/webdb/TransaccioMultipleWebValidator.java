package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import java.util.List;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.persistence.validator.TransaccioMultipleValidator;

import es.caib.digitalib.back.form.webdb.TransaccioMultipleForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.TransaccioMultiple;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class TransaccioMultipleWebValidator extends AbstractWebValidator<TransaccioMultipleForm, TransaccioMultiple>
     implements Validator, TransaccioMultipleFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected TransaccioMultipleValidator<TransaccioMultiple> validator = new TransaccioMultipleValidator<TransaccioMultiple>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.TransaccioMultipleService.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioMultipleService transaccioMultipleEjb;



  public TransaccioMultipleWebValidator() {
    super();    
  }
  
  @Override
  public TransaccioMultiple getBeanOfForm(TransaccioMultipleForm form) {
    return  form.getTransaccioMultiple();
  }

  @Override
  public Class<TransaccioMultipleForm> getClassOfForm() {
    return TransaccioMultipleForm.class;
  }

  @Override
  public void validate(TransaccioMultipleForm __form, TransaccioMultiple __bean, Errors errors) {

    WebValidationResult<TransaccioMultipleForm> wvr;
    wvr = new WebValidationResult<TransaccioMultipleForm>(errors);

    boolean isNou;
    {
        Object objNou = errors.getFieldValue("nou");
        if (objNou == null) {
            isNou = false;
        } else { 
         Boolean nou = Boolean.parseBoolean(String.valueOf(objNou));
         isNou =  nou != null && nou.booleanValue();
        }
    }

    validate(__form, __bean , errors, wvr, isNou);
  }


  public void validate(TransaccioMultipleForm __form, TransaccioMultiple __bean, Errors errors,
    WebValidationResult<TransaccioMultipleForm> wvr, boolean isNou) {

    BeanValidatorResult<TransaccioMultiple> __vr = new BeanValidatorResult<TransaccioMultiple>();
    validator.validate(__vr, __bean,
      isNou, transaccioMultipleEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }

    if (isNou) { // Creacio
      // ================ CREATION
      // Fitxers 
    }

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public TransaccioMultipleValidator<TransaccioMultiple> getValidator() {
    return validator;
  }

  public void setValidator(TransaccioMultipleValidator<TransaccioMultiple> validator) {
    this.validator = validator;
  }

}