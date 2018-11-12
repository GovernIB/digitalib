
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.UsuariAplicacio;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPAManager;

@Stateless(name = "UsuariAplicacioEJB")
@SecurityDomain("seycon")
public class UsuariAplicacioEJB extends UsuariAplicacioJPAManager implements UsuariAplicacioLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(UsuariAplicacio instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public UsuariAplicacio create(UsuariAplicacio instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public UsuariAplicacio update(UsuariAplicacio instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public UsuariAplicacioJPA findByPrimaryKey(Long _ID_) {
    return (UsuariAplicacioJPA)super.findByPrimaryKey(_ID_);
  }

}
