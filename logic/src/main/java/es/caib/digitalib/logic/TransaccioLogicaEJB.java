package es.caib.digitalib.logic;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.TransaccioEJB;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.Transaccio;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "TransaccioLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class TransaccioLogicaEJB extends TransaccioEJB implements TransaccioLogicaLocal {

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @Override
  public Transaccio createWithProfile(TransaccioJPA transaccio) throws I18NException {

    Perfil perfil = (Perfil) transaccio.getPerfil();

    if (perfil == null) {
      // XYZ ZZZ ZZZ Llança excepcio I18NException
    }

    perfil = perfilEjb.create(perfil);

    transaccio.setPerfil(null);
    transaccio.setPerfilid(perfil.getPerfilID());

    return this.create(transaccio);

  }

}
