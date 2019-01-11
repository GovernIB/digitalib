package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Transaccio;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "TransaccioPublicLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class TransaccioPublicLogicaEJB extends TransaccioLogicaEJB implements
    TransaccioPublicLogicaLocal {

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
