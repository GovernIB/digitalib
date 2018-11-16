
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.ApiSimple;
import es.caib.digitalib.jpa.ApiSimpleJPA;
import es.caib.digitalib.jpa.ApiSimpleJPAManager;

@Stateless(name = "ApiSimpleEJB")
@SecurityDomain("seycon")
public class ApiSimpleEJB extends ApiSimpleJPAManager implements ApiSimpleLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(ApiSimple instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public ApiSimple create(ApiSimple instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public ApiSimple update(ApiSimple instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public ApiSimpleJPA findByPrimaryKey(Long _ID_) {
    return (ApiSimpleJPA)super.findByPrimaryKey(_ID_);
  }

}
