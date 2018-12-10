
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.ConfiguracioFirmaJPA;
import es.caib.digitalib.model.dao.IConfiguracioFirmaManager;

@Local
public interface ConfiguracioFirmaLocal extends IConfiguracioFirmaManager {

 public static final String JNDI_NAME = "digitalib/ConfiguracioFirmaEJB/local";
  public ConfiguracioFirmaJPA findByPrimaryKey(Long _ID_);
}
