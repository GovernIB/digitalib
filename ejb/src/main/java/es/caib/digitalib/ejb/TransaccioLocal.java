
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.dao.ITransaccioManager;

@Local
public interface TransaccioLocal extends ITransaccioManager {

 public static final String JNDI_NAME = "digitalib/TransaccioEJB/local";
  public TransaccioJPA findByPrimaryKey(Long _ID_);
}
