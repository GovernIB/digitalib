package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.UsuariPersonaValidator;

import es.caib.digitalib.back.form.webdb.UsuariPersonaForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class UsuariPersonaWebValidator  implements Validator, UsuariPersonaFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected UsuariPersonaValidator<Object> validator = new UsuariPersonaValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/ConfiguracioGrupEJB/local")
  protected es.caib.digitalib.ejb.ConfiguracioGrupLocal configuracioGrupEjb;

  @javax.ejb.EJB(mappedName = "digitalib/IdiomaEJB/local")
  protected es.caib.digitalib.ejb.IdiomaLocal idiomaEjb;

  @javax.ejb.EJB(mappedName = "digitalib/UsuariPersonaEJB/local")
  protected es.caib.digitalib.ejb.UsuariPersonaLocal usuariPersonaEjb;



  public UsuariPersonaWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return UsuariPersonaForm.class.isAssignableFrom(clazz);
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
      isNou, configuracioGrupEjb, idiomaEjb, usuariPersonaEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public UsuariPersonaValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(UsuariPersonaValidator<Object> validator) {
    this.validator = validator;
  }

}