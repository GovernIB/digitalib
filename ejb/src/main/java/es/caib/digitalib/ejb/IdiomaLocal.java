
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.IdiomaJPA;
import es.caib.digitalib.model.dao.IIdiomaManager;

@Local
public interface IdiomaLocal extends IIdiomaManager {

 public static final String JNDI_NAME = "digitalib/IdiomaEJB/local";
  public IdiomaJPA findByPrimaryKey(String _ID_);
}
