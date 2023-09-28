package es.caib.digitalib.persistence.validator;

import es.caib.digitalib.persistence.InfoCustodyJPA;
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
public class InfoCustodyBeanValidator 
      extends AbstractBeanValidator<InfoCustodyJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager;


  public final InfoCustodyValidator<InfoCustodyJPA> _validator;


  public InfoCustodyBeanValidator(es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager) { 
    this.__infoCustodyManager = __infoCustodyManager;
    _validator = new InfoCustodyValidator<InfoCustodyJPA>();
  }

  public InfoCustodyBeanValidator(InfoCustodyValidator<InfoCustodyJPA> _validator,
     es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager) {
    this.__infoCustodyManager = __infoCustodyManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(InfoCustodyJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<InfoCustodyJPA> _bvr_ = new BeanValidatorResult<InfoCustodyJPA>();
    _validator.validate(_bvr_, target, isNou, __infoCustodyManager);
    return _bvr_.getErrors();
  }
}
