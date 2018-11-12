
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.PerfilUsuariAplicacioJPA;
import es.caib.digitalib.model.dao.IPerfilUsuariAplicacioManager;

@Local
public interface PerfilUsuariAplicacioLocal extends IPerfilUsuariAplicacioManager {

 public static final String JNDI_NAME = "digitalib/PerfilUsuariAplicacioEJB/local";
  public PerfilUsuariAplicacioJPA findByPrimaryKey(Long _ID_);
}
