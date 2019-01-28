package es.caib.digitalib.logic;

import javax.ejb.Local;
import org.fundaciobit.plugins.timestamp.api.ITimeStampPlugin;


/**
 * 
 * @author anadal(u80067)
 *
 */
@Local
public interface PluginSegellDeTempsLogicaLocal extends
    AbstractPluginLogicaLocal<ITimeStampPlugin> {

  public static final String JNDI_NAME = "digitalib/PluginSegellDeTempsLogicaEJB/local";

}
