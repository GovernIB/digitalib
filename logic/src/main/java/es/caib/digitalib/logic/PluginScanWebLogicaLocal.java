package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.pluginsib.scanweb.api.IScanWebPlugin;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginScanWebLogicaLocal extends
    AbstractPluginLogicaLocal<IScanWebPlugin> {

  public static final String JNDI_NAME = "digitalib/PluginScanWebLogicaEJB/local";

}
