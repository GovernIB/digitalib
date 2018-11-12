
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.model.dao.IPerfilManager;

@Local
public interface PerfilLocal extends IPerfilManager {

 public static final String JNDI_NAME = "digitalib/PerfilEJB/local";
  public PerfilJPA findByPrimaryKey(Long _ID_);
}
