package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.ejb.PluginCridadaService;
import es.caib.digitalib.persistence.PluginCridadaJPA;
import es.caib.digitalib.model.entity.PluginCridada;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Local
public interface CridadaPluginLogicaService extends PluginCridadaService {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/CridadaPluginLogicaEJB";

  public PluginCridadaJPA preCridada(Long pluginID, String metodePlugin, Long usuariPersonaId,
      Long usuariAplicacioId, String parametresText);

  public PluginCridada postCridadaOK(PluginCridadaJPA cridada, String retornText);

  public PluginCridada postCridadaError(PluginCridadaJPA cridada, String retornText);

}
