package es.caib.digitalib.logic;


import javax.ejb.Local;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface TransaccioPublicLogicaLocal extends TransaccioLogicaLocal {

  public static final String JNDI_NAME = "digitalib/TransaccioPublicLogicaEJB/local";

}