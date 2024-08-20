package es.caib.digitalib.logic;

import javax.ejb.Local;
import org.fundaciobit.pluginsib.timestamp.api.ITimeStampPlugin;


/**
 * 
 * @author anadal(u80067)
 *
 */
@Local
public interface PluginSegellDeTempsLogicaService extends
    AbstractPluginLogicaLocal<ITimeStampPlugin> {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginSegellDeTempsLogicaEJB";

}
