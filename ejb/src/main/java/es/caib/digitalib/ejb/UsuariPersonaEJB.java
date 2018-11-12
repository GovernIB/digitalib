
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPAManager;

@Stateless(name = "UsuariPersonaEJB")
@SecurityDomain("seycon")
public class UsuariPersonaEJB extends UsuariPersonaJPAManager implements UsuariPersonaLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(UsuariPersona instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public UsuariPersona create(UsuariPersona instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public UsuariPersona update(UsuariPersona instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public UsuariPersonaJPA findByPrimaryKey(Long _ID_) {
    return (UsuariPersonaJPA)super.findByPrimaryKey(_ID_);
  }

}
