package es.caib.digitalib.logic.utils;

import javax.annotation.PostConstruct;
import javax.annotation.security.RunAs;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.jboss.logging.Logger;

import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.ejb.ConfiguracioFirmaService;
import es.caib.digitalib.logic.PluginDocumentCustodyLogicaService;
import es.caib.digitalib.logic.PluginFirmaEnServidorLogicaService;
import es.caib.digitalib.logic.PluginSegellDeTempsLogicaService;

/**
 * EJB que s'executa automàticament en arrencar l'aplicació.
 * @author anadal (u80067)
 * 18 jun 2026 13:47:51
 */

@RunAs(Constants.DIB_ADMIN)
@Singleton
@Startup
public class CheckPluginsAtStartUpEJB {

    private final Logger log = Logger.getLogger(this.getClass());

    @PostConstruct
    public void checksAtStartUp() {

        log.info("Iniciant CheckPluginsAtStartUpEJB...");

        try {
            InitialContext ctx = new InitialContext();

            if (Configuracio.isOcultarDocumentCustody()) {

                // Cerca JNDI del servei de Document Custody
                PluginDocumentCustodyLogicaService pluginDocumentCustodyLogicaEjb = (PluginDocumentCustodyLogicaService) ctx
                        .lookup(PluginDocumentCustodyLogicaService.JNDI_NAME);
                
                
                

                if (pluginDocumentCustodyLogicaEjb.countPlugins() != 0) {
                    throw new RuntimeException("\n\nNo hi pot haver cap item a la taula de BBDD de "
                            + "PluginDocumentCustodyLogicaEJB (opció de menu 'Plugins de Document Custody') si està"
                            + " activada l'opció d'ocultar plugin de document custody:\n"
                            + "  (1) Posa la propietat es.caib.digitalib.ocultardocumentcustody=false\n"
                            + "  (2) Atura i arranca de nou el servidor\n"
                            + "  (3) Esborra els elements que indica el missatge inicial.\n"
                            + "  (4) Posa la propietat es.caib.digitalib.ocultardocumentcustody=true\n"
                            + "  (5) Atura i arranca de nou el servidor\n" + "\n\n");
                }

            }

            if (Configuracio.isOcultarPluginFirmaEnServidor()) {

                final String plantillaError = "  (1) Posa la propietat es.caib.digitalib.ocultarpluginfirmaenservidor=false\n"
                        + "  (2) Atura i arranca de nou el servidor\n"
                        + "  (3) Esborra els elements que indica el missatge inicial.\n"
                        + "  (4) Posa la propietat es.caib.digitalib.ocultarpluginfirmaenservidor=true\n"
                        + "  (5) Atura i arranca de nou el servidor\n\n\n";

                // Cerca JNDI del servei de Configuració de Firma
                ConfiguracioFirmaService configuracioFirmaEjb = (ConfiguracioFirmaService) ctx
                        .lookup(ConfiguracioFirmaService.JNDI_NAME);

                if (configuracioFirmaEjb.count(null) != 0) {
                    throw new RuntimeException("\n\nNo hi pot haver cap item a la taula de BBDD de "
                            + "ConfiguracioFirmaEJB (Opció de menú 'Configuració de Firma') si està activada l'opció "
                            + "d'ocultar plugin de firma en servidor:\n" + plantillaError);
                }

                // Cerca JNDI del servei de Segell de Temps
                PluginSegellDeTempsLogicaService pluginSegellDeTempsLogicaEjb = (PluginSegellDeTempsLogicaService) ctx
                        .lookup(PluginSegellDeTempsLogicaService.JNDI_NAME);

                if (pluginSegellDeTempsLogicaEjb.countPlugins() != 0) {
                    throw new RuntimeException("\n\nNo hi pot haver cap item a la taula de BBDD de "
                            + "PluginSegellDeTempsLogicaEJB (Opció de menú 'Plugins de Segell de temps') si està activada"
                            + " l'opció d'ocultar plugin de firma en servidor:" + plantillaError);
                }

                // Cerca JNDI del servei de Firma en Servidor
                PluginFirmaEnServidorLogicaService pluginFirmaServidorLogicaEjb = (PluginFirmaEnServidorLogicaService) ctx
                        .lookup(PluginFirmaEnServidorLogicaService.JNDI_NAME);

                if (pluginFirmaServidorLogicaEjb.countPlugins() != 0) {
                    throw new RuntimeException("\n\nNo hi pot haver cap item a la taula de BBDD de "
                            + "PluginFirmaServidorLogicaEJB (Opció de menú 'Plugins de Firma en Servidor') si està activada"
                            + " l'opció d'ocultar plugin de firma en servidor: " + plantillaError);
                }

            }

        } catch (NamingException e) {
            throw new RuntimeException("Error fent lookup JNDI durant les comprovacions d'arrencada: " + e.getMessage(),
                    e);
        } catch (I18NException e) {
            throw new RuntimeException("Error durant les comprovacions d'arrencada: " + e.getMessage(), e);
        }

        log.info("Final de CheckPluginsAtStartUpEJB...");

    }
}