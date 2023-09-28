
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.UsuariPersonaJPA;
import es.caib.digitalib.persistence.UsuariPersonaIJPAManager;
import es.caib.digitalib.model.dao.IUsuariPersonaManager;

import es.caib.digitalib.model.entity.UsuariPersona;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface UsuariPersonaService extends UsuariPersonaIJPAManager,IUsuariPersonaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/UsuariPersonaEJB!es.caib.digitalib.ejb.UsuariPersonaService";

    public UsuariPersonaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(UsuariPersona instance, FitxerService fitxerEjb) throws I18NException;
}
