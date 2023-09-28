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
import es.caib.digitalib.persistence.validator.ConfiguracioFirmaValidator;

import es.caib.digitalib.back.form.webdb.ConfiguracioFirmaForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.ConfiguracioFirma;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ConfiguracioFirmaWebValidator extends AbstractWebValidator<ConfiguracioFirmaForm, ConfiguracioFirma>
     implements Validator, ConfiguracioFirmaFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ConfiguracioFirmaValidator<ConfiguracioFirma> validator = new ConfiguracioFirmaValidator<ConfiguracioFirma>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioFirmaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioFirmaService configuracioFirmaEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.PluginService.JNDI_NAME)
  protected es.caib.digitalib.ejb.PluginService pluginEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.TraduccioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.TraduccioService traduccioEjb;



  public ConfiguracioFirmaWebValidator() {
    super();    
  }
  
  @Override
  public ConfiguracioFirma getBeanOfForm(ConfiguracioFirmaForm form) {
    return  form.getConfiguracioFirma();
  }

  @Override
  public Class<ConfiguracioFirmaForm> getClassOfForm() {
    return ConfiguracioFirmaForm.class;
  }

  @Override
  public void validate(ConfiguracioFirmaForm __form, ConfiguracioFirma __bean, Errors errors) {

java.util.List<Field<?>> _ignoreFields = new java.util.ArrayList<Field<?>>();
_ignoreFields.add(FIRMATPERFORMATID);
_ignoreFields.add(MOTIUDELEGACIOID);
    WebValidationResult<ConfiguracioFirmaForm> wvr;
    wvr = new WebValidationResult<ConfiguracioFirmaForm>(errors, _ignoreFields);

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


  public void validate(ConfiguracioFirmaForm __form, ConfiguracioFirma __bean, Errors errors,
    WebValidationResult<ConfiguracioFirmaForm> wvr, boolean isNou) {

  {
      es.caib.digitalib.persistence.ConfiguracioFirmaJPA __jpa;
      __jpa = (es.caib.digitalib.persistence.ConfiguracioFirmaJPA)__bean;
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.persistence.TraduccioJPA tradJPA = __jpa.getFirmatPerFormat();
      if (tradJPA != null) {
        // TODO ERROR
        java.util.Map<String,es.caib.digitalib.persistence.TraduccioMapJPA> _trad = tradJPA.getTraduccions();
        int countNull= 0;
        int countNotNull = 0;
        for (String _idioma : _trad.keySet()) {
          es.caib.digitalib.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
          if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
            countNull++;
          } else {
            countNotNull++;
          }
        }

        if (countNull == _trad.size()) {
          // OK Tot esta buit ==> passam el camp a NULL
          __jpa.setFirmatPerFormatID(null);
          __jpa.setFirmatPerFormat(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("configuracioFirma.firmatPerFormat", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(FIRMATPERFORMATID.fullName)}, null);
                errors.rejectValue("configuracioFirma.firmatPerFormat.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(FIRMATPERFORMATID.fullName)}, null);
              }
            }
          }
        }
      } else {
          __jpa.setFirmatPerFormatID(null);
          __jpa.setFirmatPerFormat(null);
      }
    }
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.persistence.TraduccioJPA tradJPA = __jpa.getMotiuDelegacio();
      if (tradJPA != null) {
        // TODO ERROR
        java.util.Map<String,es.caib.digitalib.persistence.TraduccioMapJPA> _trad = tradJPA.getTraduccions();
        int countNull= 0;
        int countNotNull = 0;
        for (String _idioma : _trad.keySet()) {
          es.caib.digitalib.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
          if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
            countNull++;
          } else {
            countNotNull++;
          }
        }

        if (countNull == _trad.size()) {
          // OK Tot esta buit ==> passam el camp a NULL
          __jpa.setMotiuDelegacioID(null);
          __jpa.setMotiuDelegacio(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("configuracioFirma.motiuDelegacio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(MOTIUDELEGACIOID.fullName)}, null);
                errors.rejectValue("configuracioFirma.motiuDelegacio.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(MOTIUDELEGACIOID.fullName)}, null);
              }
            }
          }
        }
      } else {
          __jpa.setMotiuDelegacioID(null);
          __jpa.setMotiuDelegacio(null);
      }
    }

  }
    BeanValidatorResult<ConfiguracioFirma> __vr = new BeanValidatorResult<ConfiguracioFirma>();
    validator.validate(__vr, __bean,
      isNou, configuracioFirmaEjb, pluginEjb, traduccioEjb);

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

  public ConfiguracioFirmaValidator<ConfiguracioFirma> getValidator() {
    return validator;
  }

  public void setValidator(ConfiguracioFirmaValidator<ConfiguracioFirma> validator) {
    this.validator = validator;
  }

}