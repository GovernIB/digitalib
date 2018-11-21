
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.model.dao.IInfoCustodyManager;

@Local
public interface InfoCustodyLocal extends IInfoCustodyManager {

 public static final String JNDI_NAME = "digitalib/InfoCustodyEJB/local";
  public InfoCustodyJPA findByPrimaryKey(Long _ID_);
}
