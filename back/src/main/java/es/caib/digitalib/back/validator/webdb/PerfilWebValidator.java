package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.PerfilValidator;

import es.caib.digitalib.back.form.webdb.PerfilForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class PerfilWebValidator  implements Validator, PerfilFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected PerfilValidator<Object> validator = new PerfilValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/ApiSimpleEJB/local")
  protected es.caib.digitalib.ejb.ApiSimpleLocal apiSimpleEjb;

  @javax.ejb.EJB(mappedName = "digitalib/ConfiguracioFirmaEJB/local")
  protected es.caib.digitalib.ejb.ConfiguracioFirmaLocal configuracioFirmaEjb;

  @javax.ejb.EJB(mappedName = "digitalib/PerfilEJB/local")
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @javax.ejb.EJB(mappedName = "digitalib/PluginEJB/local")
  protected es.caib.digitalib.ejb.PluginLocal pluginEjb;

  @javax.ejb.EJB(mappedName = "digitalib/TraduccioEJB/local")
  protected es.caib.digitalib.ejb.TraduccioLocal traduccioEjb;



  public PerfilWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return PerfilForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

java.util.List<Field<?>> _ignoreFields = new java.util.ArrayList<Field<?>>();
_ignoreFields.add(NOMID);
_ignoreFields.add(DESCRIPCIOID);
    WebValidationResult<Object> wvr;
    wvr = new WebValidationResult<Object>(errors, _ignoreFields);

    Boolean nou = (Boolean)errors.getFieldValue("nou");
    boolean isNou =  nou != null && nou.booleanValue();

    validate(target, errors, wvr, isNou);
  }


  public void validate(Object target, Errors errors,
    WebValidationResult<Object> wvr, boolean isNou) {

  {
    es.caib.digitalib.jpa.PerfilJPA perfil;
    if (target instanceof PerfilForm) {
      perfil = ((PerfilForm)target).getPerfil();
    } else {
      perfil = (es.caib.digitalib.jpa.PerfilJPA)target;
    }
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.jpa.TraduccioJPA tradJPA = perfil.getNom();
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
          perfil.setNomID(null);
          perfil.setNom(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("perfil.nom", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(NOMID.fullName)}, null);
                errors.rejectValue("perfil.nom.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(NOMID.fullName)}, null);
              }
            }
          }
        }
      } else {
        errors.rejectValue("perfil.nom", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(NOMID.fullName)}, null);
      }
    }
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.jpa.TraduccioJPA tradJPA = perfil.getDescripcio();
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
          perfil.setDescripcioID(null);
          perfil.setDescripcio(null);
        } else {
          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("perfil.descripcio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
                errors.rejectValue("perfil.descripcio.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
              }
            }
          }
        }
      } else {
        errors.rejectValue("perfil.descripcio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
      }
    }

  }
    validator.validate(wvr, target,
      isNou, apiSimpleEjb, configuracioFirmaEjb, perfilEjb, pluginEjb, traduccioEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public PerfilValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(PerfilValidator<Object> validator) {
    this.validator = validator;
  }

}