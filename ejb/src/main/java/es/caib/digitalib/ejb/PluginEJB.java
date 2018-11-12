
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.jpa.PluginJPA;
import es.caib.digitalib.jpa.PluginJPAManager;

@Stateless(name = "PluginEJB")
@SecurityDomain("seycon")
public class PluginEJB extends PluginJPAManager implements PluginLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(Plugin instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Plugin create(Plugin instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public Plugin update(Plugin instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public PluginJPA findByPrimaryKey(Long _ID_) {
    return (PluginJPA)super.findByPrimaryKey(_ID_);
  }

}
