package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.PluginCridadaJPA;
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
public class PluginCridadaBeanValidator 
      extends AbstractBeanValidator<PluginCridadaJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IPluginManager __pluginManager;

  protected final es.caib.digitalib.model.dao.IPluginCridadaManager __pluginCridadaManager;


  public final PluginCridadaValidator<PluginCridadaJPA> _validator;


  public PluginCridadaBeanValidator(es.caib.digitalib.model.dao.IPluginManager __pluginManager,
     es.caib.digitalib.model.dao.IPluginCridadaManager __pluginCridadaManager) { 
    this.__pluginManager = __pluginManager;
    this.__pluginCridadaManager = __pluginCridadaManager;
    _validator = new PluginCridadaValidator<PluginCridadaJPA>();
  }

  public PluginCridadaBeanValidator(PluginCridadaValidator<PluginCridadaJPA> _validator,
     es.caib.digitalib.model.dao.IPluginManager __pluginManager,
     es.caib.digitalib.model.dao.IPluginCridadaManager __pluginCridadaManager) {
    this.__pluginManager = __pluginManager;
    this.__pluginCridadaManager = __pluginCridadaManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(PluginCridadaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<PluginCridadaJPA> _bvr_ = new BeanValidatorResult<PluginCridadaJPA>();
    _validator.validate(_bvr_, target, isNou, __pluginManager, __pluginCridadaManager);
    return _bvr_.getErrors();
  }
}
