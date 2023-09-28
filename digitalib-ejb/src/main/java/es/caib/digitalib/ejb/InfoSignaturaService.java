
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.InfoSignaturaJPA;
import es.caib.digitalib.persistence.InfoSignaturaIJPAManager;
import es.caib.digitalib.model.dao.IInfoSignaturaManager;

import es.caib.digitalib.model.entity.InfoSignatura;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface InfoSignaturaService extends InfoSignaturaIJPAManager,IInfoSignaturaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/InfoSignaturaEJB!es.caib.digitalib.ejb.InfoSignaturaService";

    public InfoSignaturaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(InfoSignatura instance, FitxerService fitxerEjb) throws I18NException;
}
