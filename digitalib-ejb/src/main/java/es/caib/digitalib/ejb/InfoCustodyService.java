
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.persistence.InfoCustodyIJPAManager;
import es.caib.digitalib.model.dao.IInfoCustodyManager;

import es.caib.digitalib.model.entity.InfoCustody;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface InfoCustodyService extends InfoCustodyIJPAManager,IInfoCustodyManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/InfoCustodyEJB!es.caib.digitalib.ejb.InfoCustodyService";

    public InfoCustodyJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(InfoCustody instance, FitxerService fitxerEjb) throws I18NException;
}
