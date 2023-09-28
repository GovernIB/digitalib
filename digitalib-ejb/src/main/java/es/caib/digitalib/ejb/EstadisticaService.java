
package es.caib.digitalib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.digitalib.persistence.EstadisticaJPA;
import es.caib.digitalib.persistence.EstadisticaIJPAManager;
import es.caib.digitalib.model.dao.IEstadisticaManager;

import es.caib.digitalib.model.entity.Estadistica;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EstadisticaService extends EstadisticaIJPAManager,IEstadisticaManager {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/EstadisticaEJB!es.caib.digitalib.ejb.EstadisticaService";

    public EstadisticaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Estadistica instance, FitxerService fitxerEjb) throws I18NException;
}
