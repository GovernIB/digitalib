package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.persistence.ApiSimpleJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface ApiFirmaSimpleLogicaService {

    
    //
    public static final String JNDI_NAME = "java:app/digitalib-ejb/ApiFirmaSimpleLogicaEJB";

    public Fitxer signUsingApiFirmaSimple(TransaccioJPA transaccio, ApiSimpleJPA apisimple,
            Fitxer fitxer);

}
