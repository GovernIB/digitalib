package es.caib.digitalib.logic;

import java.util.Locale;

import javax.ejb.Local;

import org.fundaciobit.pluginsib.signatureserver.api.ISignatureServerPlugin;

import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginFirmaEnServidorLogicaService
        extends AbstractPluginLogicaLocal<ISignatureServerPlugin> {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginFirmaEnServidorLogicaEJB";

    public Fitxer firmarFitxerAmbApiFirmaEnServidor(TransaccioJPA transaccio, Fitxer fitxer,
            Locale locale, String userApp, String userPerson);

}
