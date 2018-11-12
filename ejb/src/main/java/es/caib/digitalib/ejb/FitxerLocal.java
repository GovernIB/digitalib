
package es.caib.digitalib.ejb;

import javax.ejb.Local;

import es.caib.digitalib.jpa.FitxerJPA;
import es.caib.digitalib.model.dao.IFitxerManager;

@Local
public interface FitxerLocal extends IFitxerManager {

 public static final String JNDI_NAME = "digitalib/FitxerEJB/local";
  public FitxerJPA findByPrimaryKey(Long _ID_);
}
