
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.ConfiguracioGrupJPA;
import es.caib.digitalib.persistence.ConfiguracioGrupIJPAManager;
import es.caib.digitalib.model.dao.IConfiguracioGrupManager;

import es.caib.digitalib.model.entity.ConfiguracioGrup;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ConfiguracioGrupService extends ConfiguracioGrupIJPAManager,IConfiguracioGrupManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/ConfiguracioGrupEJB!es.caib.digitalib.ejb.ConfiguracioGrupService";

    public ConfiguracioGrupJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(ConfiguracioGrup instance, FitxerService fitxerEjb) throws I18NException;
}
