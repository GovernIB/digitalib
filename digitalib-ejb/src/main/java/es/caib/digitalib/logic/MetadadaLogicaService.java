package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.MetadadaService;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface MetadadaLogicaService extends MetadadaService {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/MetadadaLogicaEJB";

}
