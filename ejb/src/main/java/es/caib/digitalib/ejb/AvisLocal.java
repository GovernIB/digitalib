
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.AvisJPA;
import es.caib.digitalib.model.dao.IAvisManager;

@Local
public interface AvisLocal extends IAvisManager {

 public static final String JNDI_NAME = "digitalib/AvisEJB/local";
  public AvisJPA findByPrimaryKey(Long _ID_);
}
