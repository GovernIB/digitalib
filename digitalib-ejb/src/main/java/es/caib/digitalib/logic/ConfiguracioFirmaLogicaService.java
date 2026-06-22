package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.ejb.ConfiguracioFirmaService;
import es.caib.digitalib.model.entity.ConfiguracioFirma;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface ConfiguracioFirmaLogicaService extends ConfiguracioFirmaService {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/ConfiguracioFirmaLogicaEJB";

    /**
     * 
     * @param ConfiguracioFirmaID
     * @return
     * @throws I18NException
     */
    public void deleteWithChecks(ConfiguracioFirma configuracioFirma) throws I18NException;

}
