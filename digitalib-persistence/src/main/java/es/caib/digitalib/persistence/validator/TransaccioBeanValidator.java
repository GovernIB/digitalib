package es.caib.digitalib.persistence.validator;

import es.caib.digitalib.persistence.TransaccioJPA;
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
public class TransaccioBeanValidator 
      extends AbstractBeanValidator<TransaccioJPA> {


  // EJB's
  protected final es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager;

  protected final es.caib.digitalib.model.dao.IInfoSignaturaManager __infoSignaturaManager;

  protected final es.caib.digitalib.model.dao.IPerfilManager __perfilManager;

  protected final es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager;

  protected final es.caib.digitalib.model.dao.ITransaccioMultipleManager __transaccioMultipleManager;


  public final TransaccioValidator<TransaccioJPA> _validator;


  public TransaccioBeanValidator(es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager,
     es.caib.digitalib.model.dao.IInfoSignaturaManager __infoSignaturaManager,
     es.caib.digitalib.model.dao.IPerfilManager __perfilManager,
     es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager,
     es.caib.digitalib.model.dao.ITransaccioMultipleManager __transaccioMultipleManager) { 
    this.__infoCustodyManager = __infoCustodyManager;
    this.__infoSignaturaManager = __infoSignaturaManager;
    this.__perfilManager = __perfilManager;
    this.__transaccioManager = __transaccioManager;
    this.__transaccioMultipleManager = __transaccioMultipleManager;
    _validator = new TransaccioValidator<TransaccioJPA>();
  }

  public TransaccioBeanValidator(TransaccioValidator<TransaccioJPA> _validator,
     es.caib.digitalib.model.dao.IInfoCustodyManager __infoCustodyManager,
     es.caib.digitalib.model.dao.IInfoSignaturaManager __infoSignaturaManager,
     es.caib.digitalib.model.dao.IPerfilManager __perfilManager,
     es.caib.digitalib.model.dao.ITransaccioManager __transaccioManager,
     es.caib.digitalib.model.dao.ITransaccioMultipleManager __transaccioMultipleManager) {
    this.__infoCustodyManager = __infoCustodyManager;
    this.__infoSignaturaManager = __infoSignaturaManager;
    this.__perfilManager = __perfilManager;
    this.__transaccioManager = __transaccioManager;
    this.__transaccioMultipleManager = __transaccioMultipleManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(TransaccioJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<TransaccioJPA> _bvr_ = new BeanValidatorResult<TransaccioJPA>();
    _validator.validate(_bvr_, target, isNou, __infoCustodyManager, __infoSignaturaManager, __perfilManager, __transaccioManager, __transaccioMultipleManager);
    return _bvr_.getErrors();
  }
}
