package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.PerfilUsuariAplicacioJPA;
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
public class PerfilUsuariAplicacioBeanValidator 
      extends AbstractBeanValidator<PerfilUsuariAplicacioJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IPerfilManager __perfilManager;

  protected final es.caib.digitalib.model.dao.IPerfilUsuariAplicacioManager __perfilUsuariAplicacioManager;

  protected final es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager;


  public final PerfilUsuariAplicacioValidator<PerfilUsuariAplicacioJPA> _validator;


  public PerfilUsuariAplicacioBeanValidator(es.caib.digitalib.model.dao.IPerfilManager __perfilManager,
     es.caib.digitalib.model.dao.IPerfilUsuariAplicacioManager __perfilUsuariAplicacioManager,
     es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager) { 
    this.__perfilManager = __perfilManager;
    this.__perfilUsuariAplicacioManager = __perfilUsuariAplicacioManager;
    this.__usuariAplicacioManager = __usuariAplicacioManager;
    _validator = new PerfilUsuariAplicacioValidator<PerfilUsuariAplicacioJPA>();
  }

  public PerfilUsuariAplicacioBeanValidator(PerfilUsuariAplicacioValidator<PerfilUsuariAplicacioJPA> _validator,
     es.caib.digitalib.model.dao.IPerfilManager __perfilManager,
     es.caib.digitalib.model.dao.IPerfilUsuariAplicacioManager __perfilUsuariAplicacioManager,
     es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager) {
    this.__perfilManager = __perfilManager;
    this.__perfilUsuariAplicacioManager = __perfilUsuariAplicacioManager;
    this.__usuariAplicacioManager = __usuariAplicacioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(PerfilUsuariAplicacioJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<PerfilUsuariAplicacioJPA> _bvr_ = new BeanValidatorResult<PerfilUsuariAplicacioJPA>();
    _validator.validate(_bvr_, target, isNou, __perfilManager, __perfilUsuariAplicacioManager, __usuariAplicacioManager);
    return _bvr_.getErrors();
  }
}
