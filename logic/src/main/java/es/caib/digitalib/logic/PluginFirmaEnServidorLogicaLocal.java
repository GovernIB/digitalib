package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.plugins.signatureserver.api.ISignatureServerPlugin;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginFirmaEnServidorLogicaLocal extends
    AbstractPluginLogicaLocal<ISignatureServerPlugin> {

  public static final String JNDI_NAME = "digitalib/PluginFirmaEnServidorLogicaEJB/local";

}
