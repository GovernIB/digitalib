
package es.caib.digitalib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.entity.ConfiguracioFirma;
import es.caib.digitalib.jpa.ConfiguracioFirmaJPA;
import es.caib.digitalib.jpa.ConfiguracioFirmaJPAManager;

@Stateless(name = "ConfiguracioFirmaEJB")
@SecurityDomain("seycon")
public class ConfiguracioFirmaEJB extends ConfiguracioFirmaJPAManager implements ConfiguracioFirmaLocal {

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public void delete(ConfiguracioFirma instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public ConfiguracioFirma create(ConfiguracioFirma instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
	public ConfiguracioFirma update(ConfiguracioFirma instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public ConfiguracioFirmaJPA findByPrimaryKey(Long _ID_) {
    return (ConfiguracioFirmaJPA)super.findByPrimaryKey(_ID_);
  }

}
