package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.PerfilService;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PerfilLogicaService extends PerfilService {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/PerfilLogicaEJB";

}
