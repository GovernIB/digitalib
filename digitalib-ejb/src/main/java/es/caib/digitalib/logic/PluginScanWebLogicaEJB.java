package es.caib.digitalib.logic;



import javax.ejb.Stateless;

import org.fundaciobit.pluginsib.scanweb.api.IScanWebPlugin;


import es.caib.digitalib.commons.utils.Constants;

/**
 *
 * @author anadal
 */
@Stateless(name = "PluginScanWebLogicaEJB")

public class PluginScanWebLogicaEJB extends
    AbstractPluginLogicaEJB<IScanWebPlugin> implements PluginScanWebLogicaService {

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_SCANWEB;
  }

  @Override
  protected String getName() {
    return "Escaneig Web";
  }

}
