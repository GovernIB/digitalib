package es.caib.digitalib.logic;

import java.util.Locale;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.pluginsib.arxiu.api.IArxiuPlugin;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginArxiuLogicaService extends AbstractPluginLogicaLocal<IArxiuPlugin> {


    public static final String KEY_ERROR = "* ERROR: ";
    
    public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginArxiuLogicaEJB";

    /**
     * 
     * @param transaccio
     * @param fitxer
     * @param locale
     * @return
     */
    public InfoCustodyJPA custodiaAmbApiArxiu(TransaccioJPA transaccio, Fitxer fitxer,
            Locale locale);
    
    
    /**
     * 
     * @param transaccio
     * @param expedientID
     * @param locale
     * @throws I18NException
     */
    public void tancarExpedient(Long infoCustodyID, String expedientID, Locale locale) throws I18NException;

}
