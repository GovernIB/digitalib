package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.ConfiguracioFirmaValidator;

import es.caib.digitalib.back.form.webdb.ConfiguracioFirmaForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ConfiguracioFirmaWebValidator  implements Validator, ConfiguracioFirmaFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected ConfiguracioFirmaValidator<Object> validator = new ConfiguracioFirmaValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/ConfiguracioFirmaEJB/local")
  protected es.caib.digitalib.ejb.ConfiguracioFirmaLocal configuracioFirmaEjb;

  @javax.ejb.EJB(mappedName = "digitalib/PluginEJB/local")
  protected es.caib.digitalib.ejb.PluginLocal pluginEjb;

  @javax.ejb.EJB(mappedName = "digitalib/TraduccioEJB/local")
  protected es.caib.digitalib.ejb.TraduccioLocal traduccioEjb;



  public ConfiguracioFirmaWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return ConfiguracioFirmaForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

java.util.List<Field<?>> _ignoreFields = new java.util.ArrayList<Field<?>>();
_ignoreFields.add(FIRMATPERFORMATID);
_ignoreFields.add(MOTIUDELEGACIOID);
    WebValidationResult<Object> wvr;
    wvr = new WebValidationResult<Object>(errors, _ignoreFields);

    Boolean nou = (Boolean)errors.getFieldValue("nou");
    boolean isNou =  nou != null && nou.booleanValue();

    validate(target, errors, wvr, isNou);
  }


  public void validate(Object target, Errors errors,
    WebValidationResult<Object> wvr, boolean isNou) {

  {
    es.caib.digitalib.jpa.ConfiguracioFirmaJPA configuracioFirma;
    if (target instanceof ConfiguracioFirmaForm) {
      configuracioFirma = ((ConfiguracioFirmaForm)target).getConfiguracioFirma();
    } else {
      configuracioFirma = (es.caib.digitalib.jpa.ConfiguracioFirmaJPA)target;
    }
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.jpa.TraduccioJPA tradJPA = configuracioFirma.getFirmatPerFormat();
      if (tradJPA != null) {
        // TODO ERROR
        java.util.Map<String,es.caib.digitalib.jpa.TraduccioMapJPA> _trad = tradJPA.getTraduccions();
        int countNull= 0;
        int countNotNull = 0;
        for (String _idioma : _trad.keySet()) {
          es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
          if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
            countNull++;
          } else {
            countNotNull++;
          }
        }

        if (countNull == _trad.size()) {
          // OK Tot esta buit ==> passam el camp a NULL
          configuracioFirma.setFirmatPerFormatID(null);
          configuracioFirma.setFirmatPerFormat(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("configuracioFirma.firmatPerFormat", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(FIRMATPERFORMATID.fullName)}, null);
                errors.rejectValue("configuracioFirma.firmatPerFormat.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(FIRMATPERFORMATID.fullName)}, null);
              }
            }
          }
        }
      } else {
        errors.rejectValue("configuracioFirma.firmatPerFormat", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(FIRMATPERFORMATID.fullName)}, null);
      }
    }
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.jpa.TraduccioJPA tradJPA = configuracioFirma.getMotiuDelegacio();
      if (tradJPA != null) {
        // TODO ERROR
        java.util.Map<String,es.caib.digitalib.jpa.TraduccioMapJPA> _trad = tradJPA.getTraduccions();
        int countNull= 0;
        int countNotNull = 0;
        for (String _idioma : _trad.keySet()) {
          es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
          if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
            countNull++;
          } else {
            countNotNull++;
          }
        }

        if (countNull == _trad.size()) {
          // OK Tot esta buit ==> passam el camp a NULL
          configuracioFirma.setMotiuDelegacioID(null);
          configuracioFirma.setMotiuDelegacio(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("configuracioFirma.motiuDelegacio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(MOTIUDELEGACIOID.fullName)}, null);
                errors.rejectValue("configuracioFirma.motiuDelegacio.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(MOTIUDELEGACIOID.fullName)}, null);
              }
            }
          }
        }
      } else {
        errors.rejectValue("configuracioFirma.motiuDelegacio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(MOTIUDELEGACIOID.fullName)}, null);
      }
    }

  }
    validator.validate(wvr, target,
      isNou, configuracioFirmaEjb, pluginEjb, traduccioEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public ConfiguracioFirmaValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(ConfiguracioFirmaValidator<Object> validator) {
    this.validator = validator;
  }

}