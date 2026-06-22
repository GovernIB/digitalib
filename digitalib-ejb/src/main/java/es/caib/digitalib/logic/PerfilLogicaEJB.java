package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.ejb.PerfilEJB;
import es.caib.digitalib.ejb.PerfilUsuariAplicacioService;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "PerfilLogicaEJB")
@RunAs("DIB_ADMIN")
public class PerfilLogicaEJB extends PerfilEJB implements PerfilLogicaService {

    @EJB(mappedName = PerfilUsuariAplicacioService.JNDI_NAME)
    protected PerfilUsuariAplicacioService perfilUsrAppEjb;
    
    @EJB(mappedName = ConfiguracioGrupLogicaService.JNDI_NAME)
    protected ConfiguracioGrupLogicaService configuracioGrupLogicaEjb;

    @Override
    @PermitAll
    public PerfilJPA findByPrimaryKey(Long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public Perfil update(Perfil instance) throws I18NException {
        return super.update(instance);
    }

    /**
     * Esborra les associacions dels perfil amb els usuaris aplicació i la definició del perfil en "Configuració de Grup" 
     * @param instance
     * @throws I18NException
     */
    @Override
    public void deletePerfilsAndRelations(Perfil instance) throws I18NException {

        if (instance == null) {
            return;
        }

        // Esborrem les associacions amb els usuaris aplicació
        perfilUsrAppEjb.delete(PerfilUsuariAplicacioFields.PERFILID.equal(instance.getPerfilID()));
        
        // Actualitzam a null la definició del perfil en "Configuració de Grup"
        
        configuracioGrupLogicaEjb.update(ConfiguracioGrupLogicaEJB.PERFILNOMESESCANEIGID, null,
                ConfiguracioGrupLogicaEJB.PERFILNOMESESCANEIGID.equal(instance.getPerfilID()));
        
        configuracioGrupLogicaEjb.update(ConfiguracioGrupLogicaEJB.PERFILNOMESESCANEIG2ID, null,
                ConfiguracioGrupLogicaEJB.PERFILNOMESESCANEIG2ID.equal(instance.getPerfilID()));
        
        configuracioGrupLogicaEjb.update(ConfiguracioGrupLogicaEJB.PERFILCOPIAAUTENTICAID, null,
                ConfiguracioGrupLogicaEJB.PERFILCOPIAAUTENTICAID.equal(instance.getPerfilID()));
        
        configuracioGrupLogicaEjb.update(ConfiguracioGrupLogicaEJB.PERFILCOPIAAUTENTICA2ID, null,
                ConfiguracioGrupLogicaEJB.PERFILCOPIAAUTENTICA2ID.equal(instance.getPerfilID()));
        
        configuracioGrupLogicaEjb.update(ConfiguracioGrupLogicaEJB.PERFILCUSTODIAID, null,
                ConfiguracioGrupLogicaEJB.PERFILCUSTODIAID.equal(instance.getPerfilID()));
        
        configuracioGrupLogicaEjb.update(ConfiguracioGrupLogicaEJB.PERFILCUSTODIA2ID, null,
                ConfiguracioGrupLogicaEJB.PERFILCUSTODIA2ID.equal(instance.getPerfilID()));
        

        super.delete(instance);
    }


}
