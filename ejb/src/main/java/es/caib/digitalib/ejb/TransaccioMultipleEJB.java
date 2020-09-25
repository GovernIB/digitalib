
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.TransaccioMultiple;
import es.caib.digitalib.jpa.TransaccioMultipleJPA;
import es.caib.digitalib.jpa.TransaccioMultipleJPAManager;

@Stateless(name = "TransaccioMultipleEJB")
@SecurityDomain("seycon")
public class TransaccioMultipleEJB extends TransaccioMultipleJPAManager implements TransaccioMultipleLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(TransaccioMultiple instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public TransaccioMultiple create(TransaccioMultiple instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public TransaccioMultiple update(TransaccioMultiple instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public TransaccioMultipleJPA findByPrimaryKey(Long _ID_) {
    return (TransaccioMultipleJPA)super.findByPrimaryKey(_ID_);
  }

}
