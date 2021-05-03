package es.caib.digitalib.logic;

import javax.ejb.Local;

import es.caib.digitalib.jpa.ApiSimpleJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface ApiFirmaSimpleLogicaLocal {

    public static final String JNDI_NAME = "digitalib/ApiFirmaSimpleLogicaEJB/local";

    public Fitxer signUsingApiFirmaSimple(TransaccioJPA transaccio, ApiSimpleJPA apisimple,
            Fitxer fitxer);

}
