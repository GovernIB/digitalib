
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.PluginJPA;
import es.caib.digitalib.persistence.PluginIJPAManager;
import es.caib.digitalib.model.dao.IPluginManager;

import es.caib.digitalib.model.entity.Plugin;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface PluginService extends PluginIJPAManager,IPluginManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginEJB!es.caib.digitalib.ejb.PluginService";

    public PluginJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Plugin instance, FitxerService fitxerEjb) throws I18NException;
}