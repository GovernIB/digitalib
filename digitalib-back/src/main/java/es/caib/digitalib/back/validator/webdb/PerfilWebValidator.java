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
import es.caib.digitalib.persistence.validator.PerfilValidator;

import es.caib.digitalib.back.form.webdb.PerfilForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.digitalib.model.entity.Perfil;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class PerfilWebValidator extends AbstractWebValidator<PerfilForm, Perfil>
     implements Validator, PerfilFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected PerfilValidator<Perfil> validator = new PerfilValidator<Perfil>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.ApiSimpleService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ApiSimpleService apiSimpleEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioFirmaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioFirmaService configuracioFirmaEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilService perfilEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.PluginService.JNDI_NAME)
  protected es.caib.digitalib.ejb.PluginService pluginEjb;

  @javax.ejb.EJB(mappedName = es.caib.digitalib.ejb.TraduccioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.TraduccioService traduccioEjb;



  public PerfilWebValidator() {
    super();    
  }
  
  @Override
  public Perfil getBeanOfForm(PerfilForm form) {
    return  form.getPerfil();
  }

  @Override
  public Class<PerfilForm> getClassOfForm() {
    return PerfilForm.class;
  }

  @Override
  public void validate(PerfilForm __form, Perfil __bean, Errors errors) {

java.util.List<Field<?>> _ignoreFields = new java.util.ArrayList<Field<?>>();
_ignoreFields.add(NOMID);
_ignoreFields.add(DESCRIPCIOID);
    WebValidationResult<PerfilForm> wvr;
    wvr = new WebValidationResult<PerfilForm>(errors, _ignoreFields);

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


  public void validate(PerfilForm __form, Perfil __bean, Errors errors,
    WebValidationResult<PerfilForm> wvr, boolean isNou) {

  {
      es.caib.digitalib.persistence.PerfilJPA __jpa;
      __jpa = (es.caib.digitalib.persistence.PerfilJPA)__bean;
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.persistence.TraduccioJPA tradJPA = __jpa.getNom();
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
          __jpa.setNomID(null);
          __jpa.setNom(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("perfil.nom", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(NOMID.fullName)}, null);
                errors.rejectValue("perfil.nom.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(NOMID.fullName)}, null);
              }
            }
          }
        }
      } else {
          __jpa.setNomID(null);
          __jpa.setNom(null);
      }
    }
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.persistence.TraduccioJPA tradJPA = __jpa.getDescripcio();
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
          __jpa.setDescripcioID(null);
          __jpa.setDescripcio(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("perfil.descripcio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
                errors.rejectValue("perfil.descripcio.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
              }
            }
          }
        }
      } else {
          __jpa.setDescripcioID(null);
          __jpa.setDescripcio(null);
      }
    }

  }
    BeanValidatorResult<Perfil> __vr = new BeanValidatorResult<Perfil>();
    validator.validate(__vr, __bean,
      isNou, apiSimpleEjb, configuracioFirmaEjb, perfilEjb, pluginEjb, traduccioEjb);

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

  public PerfilValidator<Perfil> getValidator() {
    return validator;
  }

  public void setValidator(PerfilValidator<Perfil> validator) {
    this.validator = validator;
  }

}