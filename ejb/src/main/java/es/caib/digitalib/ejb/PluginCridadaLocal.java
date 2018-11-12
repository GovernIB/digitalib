
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.PluginCridadaJPA;
import es.caib.digitalib.model.dao.IPluginCridadaManager;

@Local
public interface PluginCridadaLocal extends IPluginCridadaManager {

 public static final String JNDI_NAME = "digitalib/PluginCridadaEJB/local";
  public PluginCridadaJPA findByPrimaryKey(Long _ID_);
}
