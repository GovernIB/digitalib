package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.TransaccioMultipleJPA;
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
public class TransaccioMultipleBeanValidator 
      extends AbstractBeanValidator<TransaccioMultipleJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.ITransaccioMultipleManager __transaccioMultipleManager;


  public final TransaccioMultipleValidator<TransaccioMultipleJPA> _validator;


  public TransaccioMultipleBeanValidator(es.caib.digitalib.model.dao.ITransaccioMultipleManager __transaccioMultipleManager) { 
    this.__transaccioMultipleManager = __transaccioMultipleManager;
    _validator = new TransaccioMultipleValidator<TransaccioMultipleJPA>();
  }

  public TransaccioMultipleBeanValidator(TransaccioMultipleValidator<TransaccioMultipleJPA> _validator,
     es.caib.digitalib.model.dao.ITransaccioMultipleManager __transaccioMultipleManager) {
    this.__transaccioMultipleManager = __transaccioMultipleManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(TransaccioMultipleJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<TransaccioMultipleJPA> _bvr_ = new BeanValidatorResult<TransaccioMultipleJPA>();
    _validator.validate(_bvr_, target, isNou, __transaccioMultipleManager);
    return _bvr_.getErrors();
  }
}
