package es.caib.digitalib.logic;


import javax.ejb.Local;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface TransaccioPublicLogicaService extends TransaccioLogicaService {

  //public static final String JNDI_NAME = "java:app/digitalib-ejb/TransaccioPublicLogicaEJB";
    
    public static final String JNDI_NAME = "java:app/digitalib-ejb/TransaccioPublicLogicaEJB";

}
