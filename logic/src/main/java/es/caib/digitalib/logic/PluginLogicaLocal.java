package es.caib.digitalib.logic;

import javax.ejb.Local;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginLogicaLocal extends es.caib.digitalib.ejb.PluginLocal {
  
  public static final String JNDI_NAME = "digitalib/PluginLogicaEJB/local";

  public void clearCache();

}
