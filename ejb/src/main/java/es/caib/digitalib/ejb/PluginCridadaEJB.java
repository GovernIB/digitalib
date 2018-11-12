
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.PluginCridada;
import es.caib.digitalib.jpa.PluginCridadaJPA;
import es.caib.digitalib.jpa.PluginCridadaJPAManager;

@Stateless(name = "PluginCridadaEJB")
@SecurityDomain("seycon")
public class PluginCridadaEJB extends PluginCridadaJPAManager implements PluginCridadaLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(PluginCridada instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public PluginCridada create(PluginCridada instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public PluginCridada update(PluginCridada instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public PluginCridadaJPA findByPrimaryKey(Long _ID_) {
    return (PluginCridadaJPA)super.findByPrimaryKey(_ID_);
  }

}
