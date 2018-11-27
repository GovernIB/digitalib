package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
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
public class ConfiguracioGrupBeanValidator 
      extends AbstractBeanValidator<ConfiguracioGrupJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager;

  protected final es.caib.digitalib.model.dao.IPerfilManager __perfilManager;


  public final ConfiguracioGrupValidator<ConfiguracioGrupJPA> _validator;


  public ConfiguracioGrupBeanValidator(es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager,
     es.caib.digitalib.model.dao.IPerfilManager __perfilManager) { 
    this.__configuracioGrupManager = __configuracioGrupManager;
    this.__perfilManager = __perfilManager;
    _validator = new ConfiguracioGrupValidator<ConfiguracioGrupJPA>();
  }

  public ConfiguracioGrupBeanValidator(ConfiguracioGrupValidator<ConfiguracioGrupJPA> _validator,
     es.caib.digitalib.model.dao.IConfiguracioGrupManager __configuracioGrupManager,
     es.caib.digitalib.model.dao.IPerfilManager __perfilManager) {
    this.__configuracioGrupManager = __configuracioGrupManager;
    this.__perfilManager = __perfilManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ConfiguracioGrupJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ConfiguracioGrupJPA> _bvr_ = new BeanValidatorResult<ConfiguracioGrupJPA>();
    _validator.validate(_bvr_, target, isNou, __configuracioGrupManager, __perfilManager);
    return _bvr_.getErrors();
  }
}
