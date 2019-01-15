package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.PerfilEJB;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.model.entity.Perfil;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "PerfilLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class PerfilLogicaEJB extends PerfilEJB implements PerfilLogicaLocal {

  @Override
  @PermitAll
  public PerfilJPA findByPrimaryKey(Long _ID_) {
    return super.findByPrimaryKey(_ID_);
  }

  @Override
  @PermitAll
  public Perfil update(Perfil instance) throws I18NException {
    return super.update(instance);
  }

}
