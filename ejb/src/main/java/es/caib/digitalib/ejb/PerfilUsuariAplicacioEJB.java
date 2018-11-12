
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.jpa.PerfilUsuariAplicacioJPA;
import es.caib.digitalib.jpa.PerfilUsuariAplicacioJPAManager;

@Stateless(name = "PerfilUsuariAplicacioEJB")
@SecurityDomain("seycon")
public class PerfilUsuariAplicacioEJB extends PerfilUsuariAplicacioJPAManager implements PerfilUsuariAplicacioLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(PerfilUsuariAplicacio instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public PerfilUsuariAplicacio create(PerfilUsuariAplicacio instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public PerfilUsuariAplicacio update(PerfilUsuariAplicacio instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public PerfilUsuariAplicacioJPA findByPrimaryKey(Long _ID_) {
    return (PerfilUsuariAplicacioJPA)super.findByPrimaryKey(_ID_);
  }

}
