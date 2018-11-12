package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.PerfilUsuariAplicacioValidator;

import es.caib.digitalib.back.form.webdb.PerfilUsuariAplicacioForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class PerfilUsuariAplicacioWebValidator  implements Validator, PerfilUsuariAplicacioFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected PerfilUsuariAplicacioValidator<Object> validator = new PerfilUsuariAplicacioValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/PerfilEJB/local")
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @javax.ejb.EJB(mappedName = "digitalib/PerfilUsuariAplicacioEJB/local")
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;

  @javax.ejb.EJB(mappedName = "digitalib/UsuariAplicacioEJB/local")
  protected es.caib.digitalib.ejb.UsuariAplicacioLocal usuariAplicacioEjb;



  public PerfilUsuariAplicacioWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return PerfilUsuariAplicacioForm.class.isAssignableFrom(clazz);
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
      isNou, perfilEjb, perfilUsuariAplicacioEjb, usuariAplicacioEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public PerfilUsuariAplicacioValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(PerfilUsuariAplicacioValidator<Object> validator) {
    this.validator = validator;
  }

}