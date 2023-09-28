
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.ApiSimpleJPA;
import es.caib.digitalib.persistence.ApiSimpleIJPAManager;
import es.caib.digitalib.model.dao.IApiSimpleManager;

import es.caib.digitalib.model.entity.ApiSimple;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ApiSimpleService extends ApiSimpleIJPAManager,IApiSimpleManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/ApiSimpleEJB!es.caib.digitalib.ejb.ApiSimpleService";

    public ApiSimpleJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(ApiSimple instance, FitxerService fitxerEjb) throws I18NException;
}
