
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.Metadada;
import es.caib.digitalib.jpa.MetadadaJPA;
import es.caib.digitalib.jpa.MetadadaJPAManager;

@Stateless(name = "MetadadaEJB")
@SecurityDomain("seycon")
public class MetadadaEJB extends MetadadaJPAManager implements MetadadaLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(Metadada instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Metadada create(Metadada instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Metadada update(Metadada instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public MetadadaJPA findByPrimaryKey(Long _ID_) {
    return (MetadadaJPA)super.findByPrimaryKey(_ID_);
  }

}
