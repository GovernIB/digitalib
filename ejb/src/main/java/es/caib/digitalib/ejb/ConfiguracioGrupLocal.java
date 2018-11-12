
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
import es.caib.digitalib.model.dao.IConfiguracioGrupManager;

@Local
public interface ConfiguracioGrupLocal extends IConfiguracioGrupManager {

 public static final String JNDI_NAME = "digitalib/ConfiguracioGrupEJB/local";
  public ConfiguracioGrupJPA findByPrimaryKey(Long _ID_);
}
