
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.AuditoriaJPA;
import es.caib.digitalib.model.dao.IAuditoriaManager;

@Local
public interface AuditoriaLocal extends IAuditoriaManager {

 public static final String JNDI_NAME = "digitalib/AuditoriaEJB/local";
  public AuditoriaJPA findByPrimaryKey(Long _ID_);
}
