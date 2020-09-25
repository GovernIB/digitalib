
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.TransaccioMultipleJPA;
import es.caib.digitalib.model.dao.ITransaccioMultipleManager;

@Local
public interface TransaccioMultipleLocal extends ITransaccioMultipleManager {

 public static final String JNDI_NAME = "digitalib/TransaccioMultipleEJB/local";
  public TransaccioMultipleJPA findByPrimaryKey(Long _ID_);
}
