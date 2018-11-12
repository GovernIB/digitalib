
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.dao.IUsuariPersonaManager;

@Local
public interface UsuariPersonaLocal extends IUsuariPersonaManager {

 public static final String JNDI_NAME = "digitalib/UsuariPersonaEJB/local";
  public UsuariPersonaJPA findByPrimaryKey(Long _ID_);
}
