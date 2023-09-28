
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.persistence.TransaccioIJPAManager;
import es.caib.digitalib.model.dao.ITransaccioManager;

import es.caib.digitalib.model.entity.Transaccio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface TransaccioService extends TransaccioIJPAManager,ITransaccioManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/TransaccioEJB!es.caib.digitalib.ejb.TransaccioService";

    public TransaccioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Transaccio instance, FitxerService fitxerEjb) throws I18NException;
}
