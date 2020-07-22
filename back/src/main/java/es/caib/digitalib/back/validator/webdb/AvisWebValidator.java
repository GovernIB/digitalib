package es.caib.digitalib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.digitalib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.digitalib.jpa.validator.AvisValidator;

import es.caib.digitalib.back.form.webdb.AvisForm;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class AvisWebValidator  implements Validator, AvisFields {

  protected final Logger log = Logger.getLogger(getClass());

  protected AvisValidator<Object> validator = new AvisValidator<Object>();

  // EJB's
  @javax.ejb.EJB(mappedName = "digitalib/AvisEJB/local")
  protected es.caib.digitalib.ejb.AvisLocal avisEjb;

  @javax.ejb.EJB(mappedName = "digitalib/ConfiguracioGrupEJB/local")
  protected es.caib.digitalib.ejb.ConfiguracioGrupLocal configuracioGrupEjb;

  @javax.ejb.EJB(mappedName = "digitalib/TraduccioEJB/local")
  protected es.caib.digitalib.ejb.TraduccioLocal traduccioEjb;



  public AvisWebValidator() {
    super();    
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return AvisForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

java.util.List<Field<?>> _ignoreFields = new java.util.ArrayList<Field<?>>();
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
    es.caib.digitalib.jpa.AvisJPA avis;
    if (target instanceof AvisForm) {
      avis = ((AvisForm)target).getAvis();
    } else {
      avis = (es.caib.digitalib.jpa.AvisJPA)target;
    }
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      es.caib.digitalib.jpa.TraduccioJPA tradJPA = avis.getDescripcio();
      if (tradJPA != null) {
        // TODO ERROR
        java.util.Map<String,es.caib.digitalib.jpa.TraduccioMapJPA> _trad = tradJPA.getTraduccions();
        int countNotNull = 0;
        for (String _idioma : _trad.keySet()) {
          es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
          if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
          } else {
            countNotNull++;
          }
        }

          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              es.caib.digitalib.jpa.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("avis.descripcio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
                errors.rejectValue("avis.descripcio.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
              }
            }
          }
      } else {
        errors.rejectValue("avis.descripcio", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(DESCRIPCIOID.fullName)}, null);
      }
    }

  }
    validator.validate(wvr, target,
      isNou, avisEjb, configuracioGrupEjb, traduccioEjb);

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public AvisValidator<Object> getValidator() {
    return validator;
  }

  public void setValidator(AvisValidator<Object> validator) {
    this.validator = validator;
  }

}