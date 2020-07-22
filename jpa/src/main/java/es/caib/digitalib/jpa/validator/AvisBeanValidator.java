package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.AvisJPA;
import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import java.util.List;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.validation.AbstractBeanValidator;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class AvisBeanValidator 
      extends AbstractBeanValidator<AvisJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IAvisManager __avisManager;

  protected final es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager;

  protected final es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager;


  public final AvisValidator<AvisJPA> _validator;


  public AvisBeanValidator(es.caib.digitalib.model.dao.IAvisManager __avisManager,
     es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager,
     es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) { 
    this.__avisManager = __avisManager;
    this.__configuracioGrupManager = __configuracioGrupManager;
    this.__traduccioManager = __traduccioManager;
    _validator = new AvisValidator<AvisJPA>();
  }

  public AvisBeanValidator(AvisValidator<AvisJPA> _validator,
     es.caib.digitalib.model.dao.IAvisManager __avisManager,
     es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager,
     es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) {
    this.__avisManager = __avisManager;
    this.__configuracioGrupManager = __configuracioGrupManager;
    this.__traduccioManager = __traduccioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(AvisJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<AvisJPA> _bvr_ = new BeanValidatorResult<AvisJPA>();
    _validator.validate(_bvr_, target, isNou, __avisManager, __configuracioGrupManager, __traduccioManager);
    return _bvr_.getErrors();
  }
}
