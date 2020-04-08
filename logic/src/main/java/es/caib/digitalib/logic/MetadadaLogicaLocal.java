package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.MetadadaLocal;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface MetadadaLogicaLocal extends MetadadaLocal {

  public static final String JNDI_NAME = "digitalib/MetadadaLogicaEJB/local";

}
