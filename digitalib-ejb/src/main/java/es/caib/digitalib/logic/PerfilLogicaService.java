package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.ejb.PerfilService;
import es.caib.digitalib.model.entity.Perfil;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PerfilLogicaService extends PerfilService {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/PerfilLogicaEJB";


    /**
     * Esborra les associacions dels perfil amb els usuaris aplicació i la definició del perfil en "Configuració de Grup" 
     * @param instance
     * @throws I18NException
     */
    void deletePerfilsAndRelations(Perfil instance) throws I18NException;

}
