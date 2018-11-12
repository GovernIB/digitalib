
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.ConfiguracioGrup;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
import es.caib.digitalib.jpa.ConfiguracioGrupJPAManager;

@Stateless(name = "ConfiguracioGrupEJB")
@SecurityDomain("seycon")
public class ConfiguracioGrupEJB extends ConfiguracioGrupJPAManager implements ConfiguracioGrupLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(ConfiguracioGrup instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public ConfiguracioGrup create(ConfiguracioGrup instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public ConfiguracioGrup update(ConfiguracioGrup instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public ConfiguracioGrupJPA findByPrimaryKey(Long _ID_) {
    return (ConfiguracioGrupJPA)super.findByPrimaryKey(_ID_);
  }

}
