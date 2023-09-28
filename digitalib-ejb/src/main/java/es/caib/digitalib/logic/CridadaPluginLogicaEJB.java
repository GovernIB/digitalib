package es.caib.digitalib.logic;

import java.sql.Timestamp;

import javax.annotation.security.RunAs;
import javax.ejb.Stateless;



import es.caib.digitalib.ejb.PluginCridadaEJB;
import es.caib.digitalib.persistence.PluginCridadaJPA;

import es.caib.digitalib.model.entity.PluginCridada;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "CridadaPluginLogicaEJB")

@RunAs("DIB_ADMIN")
public class CridadaPluginLogicaEJB extends PluginCridadaEJB implements
    CridadaPluginLogicaService {

  @Override
  public PluginCridadaJPA preCridada(Long pluginID, String metodePlugin, Long usuariPersonaId,
      Long usuariAplicacioId, String parametresText) {
    try {

      final int tipusResultat = Constants.CRIDADA_PLUGIN_RESULTAT_EN_PROCES;
      final Timestamp data = new Timestamp(System.currentTimeMillis());
      final Long tempsExecucio = null;
      final Long parametresFitxerID = null;
      final String retornText = null;
      final Long retornFitxerID = null;

      PluginCridadaJPA cridada = new PluginCridadaJPA(data, pluginID, metodePlugin, tipusResultat,
          tempsExecucio,  usuariPersonaId, usuariAplicacioId, parametresText,
          parametresFitxerID, retornText, retornFitxerID);

      return (PluginCridadaJPA) this.create(cridada);
    } catch (Throwable th) {
      log.error("Error creant entrada al Monitor d'Integracions: " + th.getMessage(), th);
      return null;
    }
  }

  @Override
  public PluginCridada postCridadaOK(PluginCridadaJPA cridada, String retornText) {
    try {

      if (cridada == null) {
        return null;
      }

      cridada.setTipusResultat(Constants.CRIDADA_PLUGIN_RESULTAT_OK);

      cridada.setTempsExecucio(System.currentTimeMillis() - cridada.getData().getTime());

      cridada.setRetornText(retornText);

      return this.update(cridada);

    } catch (Throwable th) {
      log.error(
          "Error actualitzant entrada al Monitor d'Integracions(OK): " + th.getMessage(), th);
      return null;
    }
  }

  @Override
  public PluginCridada postCridadaError(PluginCridadaJPA cridada, String retornText) {
    try {

      if (cridada == null) {
        return null;
      }

      cridada.setTipusResultat(Constants.CRIDADA_PLUGIN_RESULTAT_ERROR);

      cridada.setTempsExecucio(System.currentTimeMillis() - cridada.getData().getTime());

      cridada.setRetornText(retornText);

      return this.update(cridada);

    } catch (Throwable th) {
      log.error(
          "Error actualitzant entrada al Monitor d'Integracions(ERROR): " + th.getMessage(),
          th);
      return null;
    }
  }

}
