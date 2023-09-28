
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.AvisJPA;
import es.caib.digitalib.persistence.AvisIJPAManager;
import es.caib.digitalib.model.dao.IAvisManager;

import es.caib.digitalib.model.entity.Avis;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface AvisService extends AvisIJPAManager,IAvisManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/AvisEJB!es.caib.digitalib.ejb.AvisService";

    public AvisJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Avis instance, FitxerService fitxerEjb) throws I18NException;
}
