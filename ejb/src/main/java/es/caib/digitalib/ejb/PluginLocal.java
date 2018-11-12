
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.PluginJPA;
import es.caib.digitalib.model.dao.IPluginManager;

@Local
public interface PluginLocal extends IPluginManager {

 public static final String JNDI_NAME = "digitalib/PluginEJB/local";
  public PluginJPA findByPrimaryKey(Long _ID_);
}
