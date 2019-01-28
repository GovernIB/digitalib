package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.PerfilJPA;
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
public class PerfilBeanValidator 
      extends AbstractBeanValidator<PerfilJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager;

  protected final es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager;

  protected final es.caib.digitalib.model.dao.IPerfilManager __perfilManager;

  protected final es.caib.digitalib.model.dao.IPluginManager __pluginManager;

  protected final es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager;


  public final PerfilValidator<PerfilJPA> _validator;


  public PerfilBeanValidator(es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager,
     es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager,
     es.caib.digitalib.model.dao.IPerfilManager __perfilManager,
     es.caib.digitalib.model.dao.IPluginManager __pluginManager,
     es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) { 
    this.__apiSimpleManager = __apiSimpleManager;
    this.__configuracioFirmaManager = __configuracioFirmaManager;
    this.__perfilManager = __perfilManager;
    this.__pluginManager = __pluginManager;
    this.__traduccioManager = __traduccioManager;
    _validator = new PerfilValidator<PerfilJPA>();
  }

  public PerfilBeanValidator(PerfilValidator<PerfilJPA> _validator,
     es.caib.digitalib.model.dao.IApiSimpleManager __apiSimpleManager,
     es.caib.digitalib.model.dao.IConfiguracioFirmaManager __configuracioFirmaManager,
     es.caib.digitalib.model.dao.IPerfilManager __perfilManager,
     es.caib.digitalib.model.dao.IPluginManager __pluginManager,
     es.caib.digitalib.model.dao.ITraduccioManager __traduccioManager) {
    this.__apiSimpleManager = __apiSimpleManager;
    this.__configuracioFirmaManager = __configuracioFirmaManager;
    this.__perfilManager = __perfilManager;
    this.__pluginManager = __pluginManager;
    this.__traduccioManager = __traduccioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(PerfilJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<PerfilJPA> _bvr_ = new BeanValidatorResult<PerfilJPA>();
    _validator.validate(_bvr_, target, isNou, __apiSimpleManager, __configuracioFirmaManager, __perfilManager, __pluginManager, __traduccioManager);
    return _bvr_.getErrors();
  }
}
