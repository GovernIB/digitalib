
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.ApiSimpleJPA;
import es.caib.digitalib.model.dao.IApiSimpleManager;

@Local
public interface ApiSimpleLocal extends IApiSimpleManager {

 public static final String JNDI_NAME = "digitalib/ApiSimpleEJB/local";
  public ApiSimpleJPA findByPrimaryKey(Long _ID_);
}
