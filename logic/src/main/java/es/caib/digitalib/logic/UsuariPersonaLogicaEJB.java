package es.caib.digitalib.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.UsuariPersonaEJB;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.entity.ConfiguracioGrup;
import es.caib.digitalib.model.fields.UsuariPersonaFields;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "UsuariPersonaLogicaEJB")
@SecurityDomain("seycon")
public class UsuariPersonaLogicaEJB extends UsuariPersonaEJB implements
    UsuariPersonaLogicaLocal {
  
  @EJB(mappedName = ConfiguracioGrupLogicaLocal.JNDI_NAME)
  protected ConfiguracioGrupLogicaLocal configuracioGrupLogicaEjb;
  

  @Override
  public UsuariPersonaJPA createFull(UsuariPersonaJPA usuariPersona, boolean adjustRolesToConfgrup) throws I18NException {

    if (adjustRolesToConfgrup) {
      
      ConfiguracioGrup cgrup;
      cgrup = configuracioGrupLogicaEjb.findByPrimaryKey(usuariPersona.getConfiguracioGrupID());
      
      if (cgrup == null) {
        log.error("No es troba la Configuracio Grup amb ID = " + usuariPersona.getConfiguracioGrupID());
        usuariPersona.setConfiguracioGrupID(null);
      } else {
        
        if (cgrup.getPerfilNomesEscaneigID()  != null || cgrup.getPerfilNomesEscaneig2ID()  != null) {
          usuariPersona.setRoleScan(true);
        }
        
        if (cgrup.getPerfilCopiaAutenticaID()  != null || cgrup.getPerfilCopiaAutentica2ID()  != null) {
          usuariPersona.setRoleCoAu(true);
        }
        
        if (cgrup.getPerfilCustodiaID()  != null || cgrup.getPerfilCustodia2ID()  != null) {
          usuariPersona.setRoleCust(true);
        }
      }
    }
    
    
    return (UsuariPersonaJPA) create(usuariPersona);

  }

  @Override
  public UsuariPersonaJPA findByUsernameFull(String username) throws I18NException {

    UsuariPersonaJPA usuariPersona;

    Long usuariPersonaID = executeQueryOne(UsuariPersonaFields.USUARIPERSONAID,
        UsuariPersonaFields.USERNAME.equal(username));

    if (usuariPersonaID == null) {
      usuariPersona = null;
    } else {
      usuariPersona = findByPrimaryKey(usuariPersonaID);
    }

    if (usuariPersona != null) {
      Hibernate.initialize(usuariPersona.getConfiguracioGrup());
    }

    return usuariPersona;
  }

}
