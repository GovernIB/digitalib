package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.PluginCridadaLocal;
import es.caib.digitalib.jpa.PluginCridadaJPA;
import es.caib.digitalib.model.entity.PluginCridada;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Local
public interface CridadaPluginLogicaLocal extends PluginCridadaLocal {

  public static final String JNDI_NAME = "digitalib/CridadaPluginLogicaEJB/local";

  public PluginCridadaJPA preCridada(Long pluginID, String metodePlugin, Long usuariPersonaId,
      Long usuariAplicacioId, String parametresText);

  public PluginCridada postCridadaOK(PluginCridadaJPA cridada, String retornText);

  public PluginCridada postCridadaError(PluginCridadaJPA cridada, String retornText);

}
