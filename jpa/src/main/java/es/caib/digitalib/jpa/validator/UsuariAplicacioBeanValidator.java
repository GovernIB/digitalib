package es.caib.digitalib.jpa.validator;

import es.caib.digitalib.jpa.UsuariAplicacioJPA;
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
public class UsuariAplicacioBeanValidator 
      extends AbstractBeanValidator<UsuariAplicacioJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager;


  public final UsuariAplicacioValidator<UsuariAplicacioJPA> _validator;


  public UsuariAplicacioBeanValidator(es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager) { 
    this.__usuariAplicacioManager = __usuariAplicacioManager;
    _validator = new UsuariAplicacioValidator<UsuariAplicacioJPA>();
  }

  public UsuariAplicacioBeanValidator(UsuariAplicacioValidator<UsuariAplicacioJPA> _validator,
     es.caib.digitalib.model.dao.IUsuariAplicacioManager __usuariAplicacioManager) {
    this.__usuariAplicacioManager = __usuariAplicacioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(UsuariAplicacioJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<UsuariAplicacioJPA> _bvr_ = new BeanValidatorResult<UsuariAplicacioJPA>();
    _validator.validate(_bvr_, target, isNou, __usuariAplicacioManager);
    return _bvr_.getErrors();
  }
}
