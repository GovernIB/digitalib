
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.TransaccioMultipleJPA;
import es.caib.digitalib.persistence.TransaccioMultipleIJPAManager;
import es.caib.digitalib.model.dao.ITransaccioMultipleManager;

import es.caib.digitalib.model.entity.TransaccioMultiple;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface TransaccioMultipleService extends TransaccioMultipleIJPAManager,ITransaccioMultipleManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/TransaccioMultipleEJB!es.caib.digitalib.ejb.TransaccioMultipleService";

    public TransaccioMultipleJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(TransaccioMultiple instance, FitxerService fitxerEjb) throws I18NException;
}
