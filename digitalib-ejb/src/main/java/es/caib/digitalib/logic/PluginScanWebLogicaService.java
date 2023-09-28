package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.pluginsib.scanweb.api.IScanWebPlugin;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginScanWebLogicaService extends
    AbstractPluginLogicaLocal<IScanWebPlugin> {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginScanWebLogicaEJB";

}
