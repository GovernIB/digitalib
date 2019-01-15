package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.PerfilLocal;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PerfilLogicaLocal extends PerfilLocal {

  public static final String JNDI_NAME = "digitalib/PerfilLogicaEJB/local";

}
