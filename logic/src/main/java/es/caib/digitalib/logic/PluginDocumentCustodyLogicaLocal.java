package es.caib.digitalib.logic;

import java.util.Locale;

import javax.ejb.Local;

import org.fundaciobit.plugins.documentcustody.api.IDocumentCustodyPlugin;

import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginDocumentCustodyLogicaLocal extends
    AbstractPluginLogicaLocal<IDocumentCustodyPlugin> {

  public static final String JNDI_NAME = "digitalib/PluginDocumentCustodyLogicaEJB/local";
  
  /**
   * 
   * @param transaccio
   * @param fitxer
   * @param locale
   * @return
   */
  public InfoCustodyJPA custodiaAmbApiDocumentCustody(TransaccioJPA transaccio, Fitxer fitxer,
	      Locale locale);

}
