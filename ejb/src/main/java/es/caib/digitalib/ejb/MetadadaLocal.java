
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.MetadadaJPA;
import es.caib.digitalib.model.dao.IMetadadaManager;

@Local
public interface MetadadaLocal extends IMetadadaManager {

 public static final String JNDI_NAME = "digitalib/MetadadaEJB/local";
  public MetadadaJPA findByPrimaryKey(Long _ID_);
}
