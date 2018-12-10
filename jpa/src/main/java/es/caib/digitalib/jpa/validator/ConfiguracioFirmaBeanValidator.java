package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.ConfiguracioFirmaJPA;
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
public class ConfiguracioFirmaBeanValidator 
      extends AbstractBeanValidator<ConfiguracioFirmaJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager;

  protected final es.caib.digitalib.model.dao.IPluginManager __pluginManager;

  protected final es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager;


  public final ConfiguracioFirmaValidator<ConfiguracioFirmaJPA> _validator;


  public ConfiguracioFirmaBeanValidator(es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager,
     es.caib.digitalib.model.dao.IPluginManager __pluginManager,
     es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) { 
    this.__configuracioFirmaManager = __configuracioFirmaManager;
    this.__pluginManager = __pluginManager;
    this.__traduccioManager = __traduccioManager;
    _validator = new ConfiguracioFirmaValidator<ConfiguracioFirmaJPA>();
  }

  public ConfiguracioFirmaBeanValidator(ConfiguracioFirmaValidator<ConfiguracioFirmaJPA> _validator,
     es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager,
     es.caib.digitalib.model.dao.IPluginManager __pluginManager,
     es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) {
    this.__configuracioFirmaManager = __configuracioFirmaManager;
    this.__pluginManager = __pluginManager;
    this.__traduccioManager = __traduccioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ConfiguracioFirmaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ConfiguracioFirmaJPA> _bvr_ = new BeanValidatorResult<ConfiguracioFirmaJPA>();
    _validator.validate(_bvr_, target, isNou, __configuracioFirmaManager, __pluginManager, __traduccioManager);
    return _bvr_.getErrors();
  }
}
