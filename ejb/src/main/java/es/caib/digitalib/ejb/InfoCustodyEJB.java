
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.InfoCustody;
import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.InfoCustodyJPAManager;

@Stateless(name = "InfoCustodyEJB")
@SecurityDomain("seycon")
public class InfoCustodyEJB extends InfoCustodyJPAManager implements InfoCustodyLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(InfoCustody instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public InfoCustody create(InfoCustody instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public InfoCustody update(InfoCustody instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public InfoCustodyJPA findByPrimaryKey(Long _ID_) {
    return (InfoCustodyJPA)super.findByPrimaryKey(_ID_);
  }

}
