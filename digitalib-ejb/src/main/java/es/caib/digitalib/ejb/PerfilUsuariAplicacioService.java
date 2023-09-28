
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.PerfilUsuariAplicacioJPA;
import es.caib.digitalib.persistence.PerfilUsuariAplicacioIJPAManager;
import es.caib.digitalib.model.dao.IPerfilUsuariAplicacioManager;

import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface PerfilUsuariAplicacioService extends PerfilUsuariAplicacioIJPAManager,IPerfilUsuariAplicacioManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/PerfilUsuariAplicacioEJB!es.caib.digitalib.ejb.PerfilUsuariAplicacioService";

    public PerfilUsuariAplicacioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(PerfilUsuariAplicacio instance, FitxerService fitxerEjb) throws I18NException;
}
