package es.caib.digitalib.logic;

import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.hibernate.Hibernate;

import es.caib.digitalib.ejb.ConfiguracioGrupEJB;
import es.caib.digitalib.persistence.ConfiguracioGrupJPA;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "ConfiguracioGrupLogicaEJB")

public class ConfiguracioGrupLogicaEJB extends ConfiguracioGrupEJB implements
    ConfiguracioGrupLogicaService {

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