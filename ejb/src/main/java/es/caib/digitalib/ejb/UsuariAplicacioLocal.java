
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.model.dao.IUsuariAplicacioManager;

@Local
public interface UsuariAplicacioLocal extends IUsuariAplicacioManager {

 public static final String JNDI_NAME = "digitalib/UsuariAplicacioEJB/local";
  public UsuariAplicacioJPA findByPrimaryKey(Long _ID_);
}
