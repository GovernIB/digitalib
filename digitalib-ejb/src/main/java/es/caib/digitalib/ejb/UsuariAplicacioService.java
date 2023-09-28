
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.UsuariAplicacioJPA;
import es.caib.digitalib.persistence.UsuariAplicacioIJPAManager;
import es.caib.digitalib.model.dao.IUsuariAplicacioManager;

import es.caib.digitalib.model.entity.UsuariAplicacio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface UsuariAplicacioService extends UsuariAplicacioIJPAManager,IUsuariAplicacioManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/UsuariAplicacioEJB!es.caib.digitalib.ejb.UsuariAplicacioService";

    public UsuariAplicacioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(UsuariAplicacio instance, FitxerService fitxerEjb) throws I18NException;
}
