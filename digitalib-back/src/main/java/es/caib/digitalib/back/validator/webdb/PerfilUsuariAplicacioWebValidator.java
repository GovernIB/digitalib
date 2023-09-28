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
import es.caib.digitalib.persistence.validator.PerfilUsuariAplicacioValidator;

import es.caib.digitalib.back.form.webdb.PerfilUsuariAplicacioForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class PerfilUsuariAplicacioWebValidator extends AbstractWebValidator<PerfilUsuariAplicacioForm, PerfilUsuariAplicacio>
     implements Validator, PerfilUsuariAplicacioFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected PerfilUsuariAplicacioValidator<PerfilUsuariAplicacio> validator = new PerfilUsuariAplicacioValidator<PerfilUsuariAplicacio>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilService perfilEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioService perfilUsuariAplicacioEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;



  public PerfilUsuariAplicacioWebValidator() {
    super();    
  }
  
  @Override
  public PerfilUsuariAplicacio getBeanOfForm(PerfilUsuariAplicacioForm form) {
    return  form.getPerfilUsuariAplicacio();
  }

  @Override
  public Class<PerfilUsuariAplicacioForm> getClassOfForm() {
    return PerfilUsuariAplicacioForm.class;
  }

  @Override
  public void validate(PerfilUsuariAplicacioForm __form, PerfilUsuariAplicacio __bean, Errors errors) {

    WebValidationResult<PerfilUsuariAplicacioForm> wvr;
    wvr = new WebValidationResult<PerfilUsuariAplicacioForm>(errors);

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


  public void validate(PerfilUsuariAplicacioForm __form, PerfilUsuariAplicacio __bean, Errors errors,
    WebValidationResult<PerfilUsuariAplicacioForm> wvr, boolean isNou) {

    BeanValidatorResult<PerfilUsuariAplicacio> __vr = new BeanValidatorResult<PerfilUsuariAplicacio>();
    validator.validate(__vr, __bean,
      isNou, perfilEjb, perfilUsuariAplicacioEjb, usuariAplicacioEjb);

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

  public PerfilUsuariAplicacioValidator<PerfilUsuariAplicacio> getValidator() {
    return validator;
  }

  public void setValidator(PerfilUsuariAplicacioValidator<PerfilUsuariAplicacio> validator) {
    this.validator = validator;
  }

}