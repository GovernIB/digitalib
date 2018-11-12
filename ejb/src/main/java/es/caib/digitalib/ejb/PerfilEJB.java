
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.PerfilJPAManager;

@Stateless(name = "PerfilEJB")
@SecurityDomain("seycon")
public class PerfilEJB extends PerfilJPAManager implements PerfilLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(Perfil instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Perfil create(Perfil instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Perfil update(Perfil instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public PerfilJPA findByPrimaryKey(Long _ID_) {
    return (PerfilJPA)super.findByPrimaryKey(_ID_);
  }

}
