package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.ApiSimpleService;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface ApiSimpleLogicaService extends ApiSimpleService {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/ApiSimpleLogicaEJB";

}
