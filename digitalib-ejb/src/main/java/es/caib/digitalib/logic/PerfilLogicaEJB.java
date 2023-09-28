package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;


import es.caib.digitalib.ejb.PerfilEJB;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.model.entity.Perfil;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "PerfilLogicaEJB")

@RunAs("DIB_ADMIN")
public class PerfilLogicaEJB extends PerfilEJB implements PerfilLogicaService {

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
