package es.caib.digitalib.logic;

import java.util.Locale;

import javax.ejb.Local;

import org.fundaciobit.plugins.signatureserver.api.ISignatureServerPlugin;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginFirmaEnServidorLogicaLocal
        extends AbstractPluginLogicaLocal<ISignatureServerPlugin> {

    public static final String JNDI_NAME = "digitalib/PluginFirmaEnServidorLogicaEJB/local";

    public Fitxer firmarFitxerAmbApiFirmaEnServidor(TransaccioJPA transaccio, Fitxer fitxer,
            Locale locale, String userApp, String userPerson);

}
