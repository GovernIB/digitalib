package es.caib.digitalib.persistence.validator;

import es.caib.digitalib.persistence.PluginJPA;
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
public class PluginBeanValidator 
      extends AbstractBeanValidator<PluginJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IPluginManager __pluginManager;


  public final PluginValidator<PluginJPA> _validator;


  public PluginBeanValidator(es.caib.digitalib.model.dao.IPluginManager __pluginManager) { 
    this.__pluginManager = __pluginManager;
    _validator = new PluginValidator<PluginJPA>();
  }

  public PluginBeanValidator(PluginValidator<PluginJPA> _validator,
     es.caib.digitalib.model.dao.IPluginManager __pluginManager) {
    this.__pluginManager = __pluginManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(PluginJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<PluginJPA> _bvr_ = new BeanValidatorResult<PluginJPA>();
    _validator.validate(_bvr_, target, isNou, __pluginManager);
    return _bvr_.getErrors();
  }
}