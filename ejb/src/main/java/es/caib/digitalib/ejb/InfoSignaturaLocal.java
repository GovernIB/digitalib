
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.InfoSignaturaJPA;
import es.caib.digitalib.model.dao.IInfoSignaturaManager;

@Local
public interface InfoSignaturaLocal extends IInfoSignaturaManager {

 public static final String JNDI_NAME = "digitalib/InfoSignaturaEJB/local";
  public InfoSignaturaJPA findByPrimaryKey(Long _ID_);
}
