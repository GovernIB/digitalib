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
import es.caib.digitalib.persistence.validator.AuditoriaValidator;

import es.caib.digitalib.back.form.webdb.AuditoriaForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.Auditoria;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class AuditoriaWebValidator extends AbstractWebValidator<AuditoriaForm, Auditoria>
     implements Validator, AuditoriaFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected AuditoriaValidator<Auditoria> validator = new AuditoriaValidator<Auditoria>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.AuditoriaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.AuditoriaService auditoriaEjb;



  public AuditoriaWebValidator() {
    super();    
  }
  
  @Override
  public Auditoria getBeanOfForm(AuditoriaForm form) {
    return  form.getAuditoria();
  }

  @Override
  public Class<AuditoriaForm> getClassOfForm() {
    return AuditoriaForm.class;
  }

  @Override
  public void validate(AuditoriaForm __form, Auditoria __bean, Errors errors) {

    WebValidationResult<AuditoriaForm> wvr;
    wvr = new WebValidationResult<AuditoriaForm>(errors);

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


  public void validate(AuditoriaForm __form, Auditoria __bean, Errors errors,
    WebValidationResult<AuditoriaForm> wvr, boolean isNou) {

    BeanValidatorResult<Auditoria> __vr = new BeanValidatorResult<Auditoria>();
    validator.validate(__vr, __bean,
      isNou, auditoriaEjb);

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

  public AuditoriaValidator<Auditoria> getValidator() {
    return validator;
  }

  public void setValidator(AuditoriaValidator<Auditoria> validator) {
    this.validator = validator;
  }

}