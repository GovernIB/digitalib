
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.persistence.PerfilIJPAManager;
import es.caib.digitalib.model.dao.IPerfilManager;

import es.caib.digitalib.model.entity.Perfil;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface PerfilService extends PerfilIJPAManager,IPerfilManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/PerfilEJB!es.caib.digitalib.ejb.PerfilService";

    public PerfilJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Perfil instance, FitxerService fitxerEjb) throws I18NException;
}
