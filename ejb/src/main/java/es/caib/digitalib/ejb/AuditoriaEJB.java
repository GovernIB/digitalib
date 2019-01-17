
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.Auditoria;
import es.caib.digitalib.jpa.AuditoriaJPA;
import es.caib.digitalib.jpa.AuditoriaJPAManager;

@Stateless(name = "AuditoriaEJB")
@SecurityDomain("seycon")
public class AuditoriaEJB extends AuditoriaJPAManager implements AuditoriaLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(Auditoria instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Auditoria create(Auditoria instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Auditoria update(Auditoria instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public AuditoriaJPA findByPrimaryKey(Long _ID_) {
    return (AuditoriaJPA)super.findByPrimaryKey(_ID_);
  }

}
