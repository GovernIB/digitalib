package es.caib.digitalib.persistence.validator;

import es.caib.digitalib.persistence.InfoSignaturaJPA;
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
public class InfoSignaturaBeanValidator 
      extends AbstractBeanValidator<InfoSignaturaJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IInfoSignaturaManager __infoSignaturaManager;


  public final InfoSignaturaValidator<InfoSignaturaJPA> _validator;


  public InfoSignaturaBeanValidator(es.caib.digitalib.model.dao.IInfoSignaturaManager __infoSignaturaManager) { 
    this.__infoSignaturaManager = __infoSignaturaManager;
    _validator = new InfoSignaturaValidator<InfoSignaturaJPA>();
  }

  public InfoSignaturaBeanValidator(InfoSignaturaValidator<InfoSignaturaJPA> _validator,
     es.caib.digitalib.model.dao.IInfoSignaturaManager __infoSignaturaManager) {
    this.__infoSignaturaManager = __infoSignaturaManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(InfoSignaturaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<InfoSignaturaJPA> _bvr_ = new BeanValidatorResult<InfoSignaturaJPA>();
    _validator.validate(_bvr_, target, isNou, __infoSignaturaManager);
    return _bvr_.getErrors();
  }
}
