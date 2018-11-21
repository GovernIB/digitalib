
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.InfoSignatura;
import es.caib.digitalib.jpa.InfoSignaturaJPA;
import es.caib.digitalib.jpa.InfoSignaturaJPAManager;

@Stateless(name = "InfoSignaturaEJB")
@SecurityDomain("seycon")
public class InfoSignaturaEJB extends InfoSignaturaJPAManager implements InfoSignaturaLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(InfoSignatura instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public InfoSignatura create(InfoSignatura instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public InfoSignatura update(InfoSignatura instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public InfoSignaturaJPA findByPrimaryKey(Long _ID_) {
    return (InfoSignaturaJPA)super.findByPrimaryKey(_ID_);
  }

}
