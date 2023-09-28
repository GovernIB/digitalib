package es.caib.digitalib.logic.utils;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.signature.api.ITimeStampGenerator;
import org.fundaciobit.plugins.timestamp.api.ITimeStampPlugin;

import es.caib.digitalib.logic.PluginSegellDeTempsLogicaService;

/**
 * 
 * @author anadal(u80067)
 *
 */
public class DigitalIBTimeStampGenerator implements ITimeStampGenerator {

  protected static Logger log = Logger.getLogger(DigitalIBTimeStampGenerator.class);

  final ITimeStampPlugin timeStampPlugin;

  private DigitalIBTimeStampGenerator(ITimeStampPlugin timeStampPlugin) {
    this.timeStampPlugin = timeStampPlugin;
  }

  public static ITimeStampGenerator getInstance(
      PluginSegellDeTempsLogicaService segellDeTempsEjb, Long pluginSegellatDeTempsID)
      throws I18NException {

    if (segellDeTempsEjb == null) {
      // TODO Traduir com toca
      throw new I18NException("error.unknown", "La instancia de segellDeTempsEjb val null ");
    }

    ITimeStampPlugin plugin = segellDeTempsEjb.getInstanceByPluginID(pluginSegellatDeTempsID);

    if (plugin == null) {
      // TODO Traduir com toca
      throw new I18NException("error.unknown",
          "No s'ha pogut instanciar el plugin de segellat amb ID " + pluginSegellatDeTempsID);
    }

    return new DigitalIBTimeStampGenerator(plugin);

  }

  @Override
  public byte[] getTimeStamp(byte[] data, Calendar cal) throws Exception {

    log.debug(" ============  DigitalIBTimeStampGenerator::getTimeStamp ");
    return timeStampPlugin.getTimeStampDirect(data, cal);

  }

  @Override
  public String getTimeStampPolicyOID() {
    return timeStampPlugin.getTimeStampPolicyOID();
  }

  @Override
  public String getTimeStampHashAlgorithm() {
    return timeStampPlugin.getTimeStampHashAlgorithm();
  }

}
