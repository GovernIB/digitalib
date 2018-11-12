
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.Traduccio;
import es.caib.digitalib.jpa.TraduccioJPA;
import es.caib.digitalib.jpa.TraduccioJPAManager;

@Stateless(name = "TraduccioEJB")
@SecurityDomain("seycon")
public class TraduccioEJB extends TraduccioJPAManager implements TraduccioLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(Traduccio instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Traduccio create(Traduccio instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Traduccio update(Traduccio instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public TraduccioJPA findByPrimaryKey(Long _ID_) {
    return (TraduccioJPA)super.findByPrimaryKey(_ID_);
  }

}
