package es.caib.digitalib.logic;

import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.ConfiguracioGrupEJB;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "ConfiguracioGrupLogicaEJB")
@SecurityDomain("seycon")
public class ConfiguracioGrupLogicaEJB extends ConfiguracioGrupEJB implements
    ConfiguracioGrupLogicaLocal {

  @Override
  public ConfiguracioGrupJPA findByPrimaryKeyFull(long configuracioGrupID)
      throws I18NException {
    ConfiguracioGrupJPA cg = (ConfiguracioGrupJPA) findByPrimaryKey(configuracioGrupID);
    
    if (cg != null) {

      Hibernate.initialize(cg.getPerfilNomesEscaneig());
      Hibernate.initialize(cg.getPerfilNomesEscaneig2());
  
      Hibernate.initialize(cg.getPerfilCopiaAutentica());
      Hibernate.initialize(cg.getPerfilCopiaAutentica2());
  
      Hibernate.initialize(cg.getPerfilCustodia());
      Hibernate.initialize(cg.getPerfilCustodia2());
    }

    return cg;
  }

}