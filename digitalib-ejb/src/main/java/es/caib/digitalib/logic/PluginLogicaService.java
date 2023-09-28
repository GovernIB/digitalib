package es.caib.digitalib.logic;

import javax.ejb.Local;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginLogicaService extends es.caib.digitalib.ejb.PluginService {
  
  //public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginLogicaEJB";
    public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginLogicaEJB";

  public void clearCache();

}
