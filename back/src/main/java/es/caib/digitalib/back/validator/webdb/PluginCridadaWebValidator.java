package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.PluginCridadaValidator;

import es.caib.digitalib.back.form.webdb.PluginCridadaForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class PluginCridadaWebValidator  implements Validator, PluginCridadaFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected PluginCridadaValidator<Object> validator = new PluginCridadaValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/PluginEJB/local")
  protected es.caib.digitalib.ejb.PluginLocal pluginEjb;

  @javax.ejb.EJB(mappedName = "digitalib/PluginCridadaEJB/local")
  protected es.caib.digitalib.ejb.PluginCridadaLocal pluginCridadaEjb;



  public PluginCridadaWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return PluginCridadaForm.class.isAssignableFrom(clazz);
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
      isNou, pluginEjb, pluginCridadaEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public PluginCridadaValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(PluginCridadaValidator<Object> validator) {
    this.validator = validator;
  }

}