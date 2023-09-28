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
import es.caib.digitalib.persistence.validator.ApiSimpleValidator;

import es.caib.digitalib.back.form.webdb.ApiSimpleForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.ApiSimple;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ApiSimpleWebValidator extends AbstractWebValidator<ApiSimpleForm, ApiSimple>
     implements Validator, ApiSimpleFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ApiSimpleValidator<ApiSimple> validator = new ApiSimpleValidator<ApiSimple>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.ApiSimpleService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ApiSimpleService apiSimpleEjb;



  public ApiSimpleWebValidator() {
    super();    
  }
  
  @Override
  public ApiSimple getBeanOfForm(ApiSimpleForm form) {
    return  form.getApiSimple();
  }

  @Override
  public Class<ApiSimpleForm> getClassOfForm() {
    return ApiSimpleForm.class;
  }

  @Override
  public void validate(ApiSimpleForm __form, ApiSimple __bean, Errors errors) {

    WebValidationResult<ApiSimpleForm> wvr;
    wvr = new WebValidationResult<ApiSimpleForm>(errors);

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


  public void validate(ApiSimpleForm __form, ApiSimple __bean, Errors errors,
    WebValidationResult<ApiSimpleForm> wvr, boolean isNou) {

    BeanValidatorResult<ApiSimple> __vr = new BeanValidatorResult<ApiSimple>();
    validator.validate(__vr, __bean,
      isNou, apiSimpleEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }


  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public ApiSimpleValidator<ApiSimple> getValidator() {
    return validator;
  }

  public void setValidator(ApiSimpleValidator<ApiSimple> validator) {
    this.validator = validator;
  }

}