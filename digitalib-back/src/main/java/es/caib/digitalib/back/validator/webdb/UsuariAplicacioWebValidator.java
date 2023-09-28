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
import es.caib.digitalib.persistence.validator.UsuariAplicacioValidator;

import es.caib.digitalib.back.form.webdb.UsuariAplicacioForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.UsuariAplicacio;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class UsuariAplicacioWebValidator extends AbstractWebValidator<UsuariAplicacioForm, UsuariAplicacio>
     implements Validator, UsuariAplicacioFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected UsuariAplicacioValidator<UsuariAplicacio> validator = new UsuariAplicacioValidator<UsuariAplicacio>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;



  public UsuariAplicacioWebValidator() {
    super();    
  }
  
  @Override
  public UsuariAplicacio getBeanOfForm(UsuariAplicacioForm form) {
    return  form.getUsuariAplicacio();
  }

  @Override
  public Class<UsuariAplicacioForm> getClassOfForm() {
    return UsuariAplicacioForm.class;
  }

  @Override
  public void validate(UsuariAplicacioForm __form, UsuariAplicacio __bean, Errors errors) {

    WebValidationResult<UsuariAplicacioForm> wvr;
    wvr = new WebValidationResult<UsuariAplicacioForm>(errors);

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


  public void validate(UsuariAplicacioForm __form, UsuariAplicacio __bean, Errors errors,
    WebValidationResult<UsuariAplicacioForm> wvr, boolean isNou) {

    BeanValidatorResult<UsuariAplicacio> __vr = new BeanValidatorResult<UsuariAplicacio>();
    validator.validate(__vr, __bean,
      isNou, usuariAplicacioEjb);

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

  public UsuariAplicacioValidator<UsuariAplicacio> getValidator() {
    return validator;
  }

  public void setValidator(UsuariAplicacioValidator<UsuariAplicacio> validator) {
    this.validator = validator;
  }

}