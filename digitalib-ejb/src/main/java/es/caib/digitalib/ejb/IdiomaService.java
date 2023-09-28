
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.IdiomaJPA;
import es.caib.digitalib.persistence.IdiomaIJPAManager;
import es.caib.digitalib.model.dao.IIdiomaManager;

import es.caib.digitalib.model.entity.Idioma;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface IdiomaService extends IdiomaIJPAManager,IIdiomaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/IdiomaEJB!es.caib.digitalib.ejb.IdiomaService";

    public IdiomaJPA findByPrimaryKey(String _ID_);

    public void deleteIncludingFiles(Idioma instance, FitxerService fitxerEjb) throws I18NException;
}
