
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.Avis;
import es.caib.digitalib.jpa.AvisJPA;
import es.caib.digitalib.jpa.AvisJPAManager;

@Stateless(name = "AvisEJB")
@SecurityDomain("seycon")
public class AvisEJB extends AvisJPAManager implements AvisLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(Avis instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Avis create(Avis instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Avis update(Avis instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public AvisJPA findByPrimaryKey(Long _ID_) {
    return (AvisJPA)super.findByPrimaryKey(_ID_);
  }

}
