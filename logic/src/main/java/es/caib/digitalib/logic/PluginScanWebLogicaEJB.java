package es.caib.digitalib.logic;



import javax.ejb.Stateless;

import org.fundaciobit.pluginsib.scanweb.api.IScanWebPlugin;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.utils.Constants;

/**
 *
 * @author anadal
 */
@Stateless(name = "PluginScanWebLogicaEJB")
@SecurityDomain("seycon")
public class PluginScanWebLogicaEJB extends
    AbstractPluginLogicaEJB<IScanWebPlugin> implements PluginScanWebLogicaLocal {

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_SCANWEB;
  }

  @Override
  protected String getName() {
    return "Escaneig Web";
  }

}
