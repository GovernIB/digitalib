
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.MetadadaJPA;
import es.caib.digitalib.persistence.MetadadaIJPAManager;
import es.caib.digitalib.model.dao.IMetadadaManager;

import es.caib.digitalib.model.entity.Metadada;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface MetadadaService extends MetadadaIJPAManager,IMetadadaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/MetadadaEJB!es.caib.digitalib.ejb.MetadadaService";

    public MetadadaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Metadada instance, FitxerService fitxerEjb) throws I18NException;
}
