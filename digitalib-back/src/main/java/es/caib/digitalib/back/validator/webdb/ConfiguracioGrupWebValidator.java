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
import es.caib.digitalib.persistence.validator.ConfiguracioGrupValidator;

import es.caib.digitalib.back.form.webdb.ConfiguracioGrupForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.ConfiguracioGrup;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ConfiguracioGrupWebValidator extends AbstractWebValidator<ConfiguracioGrupForm, ConfiguracioGrup>
     implements Validator, ConfiguracioGrupFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ConfiguracioGrupValidator<ConfiguracioGrup> validator = new ConfiguracioGrupValidator<ConfiguracioGrup>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioGrupService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioGrupService configuracioGrupEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilService perfilEjb;



  public ConfiguracioGrupWebValidator() {
    super();    
  }
  
  @Override
  public ConfiguracioGrup getBeanOfForm(ConfiguracioGrupForm form) {
    return  form.getConfiguracioGrup();
  }

  @Override
  public Class<ConfiguracioGrupForm> getClassOfForm() {
    return ConfiguracioGrupForm.class;
  }

  @Override
  public void validate(ConfiguracioGrupForm __form, ConfiguracioGrup __bean, Errors errors) {

    WebValidationResult<ConfiguracioGrupForm> wvr;
    wvr = new WebValidationResult<ConfiguracioGrupForm>(errors);

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


  public void validate(ConfiguracioGrupForm __form, ConfiguracioGrup __bean, Errors errors,
    WebValidationResult<ConfiguracioGrupForm> wvr, boolean isNou) {

    BeanValidatorResult<ConfiguracioGrup> __vr = new BeanValidatorResult<ConfiguracioGrup>();
    validator.validate(__vr, __bean,
      isNou, configuracioGrupEjb, perfilEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }

    if (isNou) { // Creacio
      // ================ CREATION
      // Fitxers 
        if (!errors.hasFieldErrors(get(LOGOHEADERID))){
            CommonsMultipartFile logoHeaderID = ((ConfiguracioGrupForm)__form).getLogoHeaderID();
            if (logoHeaderID == null || logoHeaderID.isEmpty()) {
                errors.rejectValue(get(LOGOHEADERID), "genapp.validation.required",
                new String[]{ org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(get(LOGOHEADERID)) },
                null);
            }
        }

        if (!errors.hasFieldErrors(get(LOGOFOOTERID))){
            CommonsMultipartFile logoFooterID = ((ConfiguracioGrupForm)__form).getLogoFooterID();
            if (logoFooterID == null || logoFooterID.isEmpty()) {
                errors.rejectValue(get(LOGOFOOTERID), "genapp.validation.required",
                new String[]{ org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(get(LOGOFOOTERID)) },
                null);
            }
        }

    }

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public ConfiguracioGrupValidator<ConfiguracioGrup> getValidator() {
    return validator;
  }

  public void setValidator(ConfiguracioGrupValidator<ConfiguracioGrup> validator) {
    this.validator = validator;
  }

}