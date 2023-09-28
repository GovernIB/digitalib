package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;


import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.model.entity.Transaccio;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "TransaccioPublicLogicaEJB")

@RunAs("DIB_ADMIN")
public class TransaccioPublicLogicaEJB extends TransaccioLogicaEJB implements
    TransaccioPublicLogicaService {

  @Override
  @PermitAll
  public TransaccioJPA findByPrimaryKey(Long _ID_) {
    return super.findByPrimaryKey(_ID_);
  }

  @Override
  @PermitAll
  public Transaccio update(Transaccio instance) throws I18NException {
    return super.update(instance);
  }

}
