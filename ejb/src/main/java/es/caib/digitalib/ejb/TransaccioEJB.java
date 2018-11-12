
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.TransaccioJPAManager;

@Stateless(name = "TransaccioEJB")
@SecurityDomain("seycon")
public class TransaccioEJB extends TransaccioJPAManager implements TransaccioLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(Transaccio instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Transaccio create(Transaccio instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Transaccio update(Transaccio instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public TransaccioJPA findByPrimaryKey(Long _ID_) {
    return (TransaccioJPA)super.findByPrimaryKey(_ID_);
  }

}
