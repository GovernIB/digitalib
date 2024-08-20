package es.caib.digitalib.logic;

import java.util.Locale;

import javax.ejb.Local;

import org.fundaciobit.pluginsib.documentcustody.api.IDocumentCustodyPlugin;

import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginDocumentCustodyLogicaService extends
    AbstractPluginLogicaLocal<IDocumentCustodyPlugin> {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginDocumentCustodyLogicaEJB";
  
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
