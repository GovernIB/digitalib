
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.ConfiguracioFirmaJPA;
import es.caib.digitalib.persistence.ConfiguracioFirmaIJPAManager;
import es.caib.digitalib.model.dao.IConfiguracioFirmaManager;

import es.caib.digitalib.model.entity.ConfiguracioFirma;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ConfiguracioFirmaService extends ConfiguracioFirmaIJPAManager,IConfiguracioFirmaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/ConfiguracioFirmaEJB!es.caib.digitalib.ejb.ConfiguracioFirmaService";

    public ConfiguracioFirmaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(ConfiguracioFirma instance, FitxerService fitxerEjb) throws I18NException;
}
