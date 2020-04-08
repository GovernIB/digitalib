package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.MetadadaJPA;
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
public class MetadadaBeanValidator 
      extends AbstractBeanValidator<MetadadaJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IMetadadaManager __metadadaManager;

  protected final es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager;


  public final MetadadaValidator<MetadadaJPA> _validator;


  public MetadadaBeanValidator(es.caib.digitalib.model.dao.IMetadadaManager __metadadaManager,
     es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager) { 
    this.__metadadaManager = __metadadaManager;
    this.__transaccioManager = __transaccioManager;
    _validator = new MetadadaValidator<MetadadaJPA>();
  }

  public MetadadaBeanValidator(MetadadaValidator<MetadadaJPA> _validator,
     es.caib.digitalib.model.dao.IMetadadaManager __metadadaManager,
     es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager) {
    this.__metadadaManager = __metadadaManager;
    this.__transaccioManager = __transaccioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(MetadadaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<MetadadaJPA> _bvr_ = new BeanValidatorResult<MetadadaJPA>();
    _validator.validate(_bvr_, target, isNou, __metadadaManager, __transaccioManager);
    return _bvr_.getErrors();
  }
}
