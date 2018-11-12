
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.EstadisticaJPA;
import es.caib.digitalib.model.dao.IEstadisticaManager;

@Local
public interface EstadisticaLocal extends IEstadisticaManager {

 public static final String JNDI_NAME = "digitalib/EstadisticaEJB/local";
  public EstadisticaJPA findByPrimaryKey(Long _ID_);
}
