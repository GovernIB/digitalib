package es.caib.digitalib.logic;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.plugins.timestamp.api.ITimeStampPlugin;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "PluginSegellDeTempsLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class PluginSegellDeTempsLogicaEJB extends AbstractPluginLogicaEJB<ITimeStampPlugin>
    implements PluginSegellDeTempsLogicaLocal {

  // XYZ ZZZ s'utilitza
  @EJB(mappedName = FitxerLogicaLocal.JNDI_NAME)
  protected FitxerLogicaLocal fitxerEjb;

  // XYZ ZZZ s'utilitza
  @EJB(mappedName = CridadaPluginLogicaLocal.JNDI_NAME)
  protected CridadaPluginLogicaLocal pluginCridada;

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_SEGELLDETEMPS;
  }

  @Override
  protected String getName() {
    return "Segell de Temps";
  }

}
