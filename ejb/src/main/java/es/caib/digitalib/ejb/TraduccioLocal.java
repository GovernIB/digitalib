
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.TraduccioJPA;
import es.caib.digitalib.model.dao.ITraduccioManager;

@Local
public interface TraduccioLocal extends ITraduccioManager {

 public static final String JNDI_NAME = "digitalib/TraduccioEJB/local";
  public TraduccioJPA findByPrimaryKey(Long _ID_);
}
