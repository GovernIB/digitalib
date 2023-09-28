package es.caib.digitalib.logic;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.plugins.timestamp.api.ITimeStampPlugin;


import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "PluginSegellDeTempsLogicaEJB")

@RunAs("DIB_ADMIN")
public class PluginSegellDeTempsLogicaEJB extends AbstractPluginLogicaEJB<ITimeStampPlugin>
    implements PluginSegellDeTempsLogicaService {

  // XYZ ZZZ s'utilitza
  @EJB(mappedName = FitxerLogicaService.JNDI_NAME)
  protected FitxerLogicaService fitxerEjb;

  // XYZ ZZZ s'utilitza
  @EJB(mappedName = CridadaPluginLogicaService.JNDI_NAME)
  protected CridadaPluginLogicaService pluginCridada;

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_SEGELLDETEMPS;
  }

  @Override
  protected String getName() {
    return "Segell de Temps";
  }

}
