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
import es.caib.digitalib.persistence.validator.TransaccioValidator;

import es.caib.digitalib.back.form.webdb.TransaccioForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.Transaccio;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class TransaccioWebValidator extends AbstractWebValidator<TransaccioForm, Transaccio>
     implements Validator, TransaccioFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected TransaccioValidator<Transaccio> validator = new TransaccioValidator<Transaccio>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyService.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoCustodyService infoCustodyEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.InfoSignaturaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoSignaturaService infoSignaturaEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilService perfilEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.TransaccioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioService transaccioEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.TransaccioMultipleService.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioMultipleService transaccioMultipleEjb;



  public TransaccioWebValidator() {
    super();    
  }
  
  @Override
  public Transaccio getBeanOfForm(TransaccioForm form) {
    return  form.getTransaccio();
  }

  @Override
  public Class<TransaccioForm> getClassOfForm() {
    return TransaccioForm.class;
  }

  @Override
  public void validate(TransaccioForm __form, Transaccio __bean, Errors errors) {

    WebValidationResult<TransaccioForm> wvr;
    wvr = new WebValidationResult<TransaccioForm>(errors);

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


  public void validate(TransaccioForm __form, Transaccio __bean, Errors errors,
    WebValidationResult<TransaccioForm> wvr, boolean isNou) {

    BeanValidatorResult<Transaccio> __vr = new BeanValidatorResult<Transaccio>();
    validator.validate(__vr, __bean,
      isNou, infoCustodyEjb, infoSignaturaEjb, perfilEjb, transaccioEjb, transaccioMultipleEjb);

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

  public TransaccioValidator<Transaccio> getValidator() {
    return validator;
  }

  public void setValidator(TransaccioValidator<Transaccio> validator) {
    this.validator = validator;
  }

}