
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.AuditoriaJPA;
import es.caib.digitalib.persistence.AuditoriaIJPAManager;
import es.caib.digitalib.model.dao.IAuditoriaManager;

import es.caib.digitalib.model.entity.Auditoria;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface AuditoriaService extends AuditoriaIJPAManager,IAuditoriaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/AuditoriaEJB!es.caib.digitalib.ejb.AuditoriaService";

    public AuditoriaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Auditoria instance, FitxerService fitxerEjb) throws I18NException;
}
