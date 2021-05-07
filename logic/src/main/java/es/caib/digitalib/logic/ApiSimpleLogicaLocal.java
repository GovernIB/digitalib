package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.ApiSimpleLocal;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface ApiSimpleLogicaLocal extends ApiSimpleLocal {

  public static final String JNDI_NAME = "digitalib/ApiSimpleLogicaEJB/local";

}
