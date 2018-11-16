package es.caib.digitalib.logic;

import javax.ejb.Stateless;

import org.fundaciobit.plugins.signatureserver.api.ISignatureServerPlugin;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.utils.Constants;

/**
 *
 * @author anadal
 */
@Stateless(name = "PluginFirmaEnServidorLogicaEJB")
@SecurityDomain("seycon")
public class PluginFirmaEnServidorLogicaEJB extends
    AbstractPluginLogicaEJB<ISignatureServerPlugin> implements PluginFirmaEnServidorLogicaLocal {

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR;
  }

  @Override
  protected String getName() {
    return "Firma en Servidor";
  }

}
