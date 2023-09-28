
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.PluginCridadaJPA;
import es.caib.digitalib.persistence.PluginCridadaIJPAManager;
import es.caib.digitalib.model.dao.IPluginCridadaManager;

import es.caib.digitalib.model.entity.PluginCridada;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface PluginCridadaService extends PluginCridadaIJPAManager,IPluginCridadaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/PluginCridadaEJB!es.caib.digitalib.ejb.PluginCridadaService";

    public PluginCridadaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(PluginCridada instance, FitxerService fitxerEjb) throws I18NException;
}
