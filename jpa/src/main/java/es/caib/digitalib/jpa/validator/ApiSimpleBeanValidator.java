package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.ApiSimpleJPA;
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
public class ApiSimpleBeanValidator 
      extends AbstractBeanValidator<ApiSimpleJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager;


  public final ApiSimpleValidator<ApiSimpleJPA> _validator;


  public ApiSimpleBeanValidator(es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager) { 
    this.__apiSimpleManager = __apiSimpleManager;
    _validator = new ApiSimpleValidator<ApiSimpleJPA>();
  }

  public ApiSimpleBeanValidator(ApiSimpleValidator<ApiSimpleJPA> _validator,
     es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager) {
    this.__apiSimpleManager = __apiSimpleManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ApiSimpleJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ApiSimpleJPA> _bvr_ = new BeanValidatorResult<ApiSimpleJPA>();
    _validator.validate(_bvr_, target, isNou, __apiSimpleManager);
    return _bvr_.getErrors();
  }
}
