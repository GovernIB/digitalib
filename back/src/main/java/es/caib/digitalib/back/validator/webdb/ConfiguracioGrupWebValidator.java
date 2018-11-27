package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.ConfiguracioGrupValidator;

import es.caib.digitalib.back.form.webdb.ConfiguracioGrupForm;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ConfiguracioGrupWebValidator  implements Validator, ConfiguracioGrupFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected ConfiguracioGrupValidator<Object> validator = new ConfiguracioGrupValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/ConfiguracioGrupEJB/local")
  protected es.caib.digitalib.ejb.ConfiguracioGrupLocal configuracioGrupEjb;

  @javax.ejb.EJB(mappedName = "digitalib/PerfilEJB/local")
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;



  public ConfiguracioGrupWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return ConfiguracioGrupForm.class.isAssignableFrom(clazz);
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
      CommonsMultipartFile logoHeaderID = ((ConfiguracioGrupForm)target).getLogoHeaderID();
      if (logoHeaderID == null || logoHeaderID.isEmpty()) {
        errors.rejectValue(get(LOGOHEADERID), "genapp.validation.required",
          new String[]{ org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(get(LOGOHEADERID)) },
          null);
      }

      CommonsMultipartFile logoFooterID = ((ConfiguracioGrupForm)target).getLogoFooterID();
      if (logoFooterID == null || logoFooterID.isEmpty()) {
        errors.rejectValue(get(LOGOFOOTERID), "genapp.validation.required",
          new String[]{ org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(get(LOGOFOOTERID)) },
          null);
      }

    }
    validator.validate(wvr, target,
      isNou, configuracioGrupEjb, perfilEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public ConfiguracioGrupValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(ConfiguracioGrupValidator<Object> validator) {
    this.validator = validator;
  }

}