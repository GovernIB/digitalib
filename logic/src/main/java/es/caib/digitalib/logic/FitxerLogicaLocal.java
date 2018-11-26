package es.caib.digitalib.logic;

import javax.ejb.Local;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface FitxerLogicaLocal extends es.caib.digitalib.ejb.FitxerLocal {
  
  public static final String JNDI_NAME = "digitalib/FitxerLogicaEJB/local";



}
