package es.caib.digitalib.logic;

import java.util.Locale;

import javax.ejb.Local;

import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.plugins.arxiu.api.IArxiuPlugin;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginArxiuLogicaLocal extends AbstractPluginLogicaLocal<IArxiuPlugin> {

  public static final String JNDI_NAME = "digitalib/PluginArxiuLogicaEJB/local";

  /**
   * 
   * @param transaccio
   * @param fitxer
   * @param locale
   * @return
   */
  public InfoCustodyJPA custodiaAmbApiArxiu(TransaccioJPA transaccio, Fitxer fitxer,
      Locale locale);

}
