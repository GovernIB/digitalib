package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.ejb.ConfiguracioGrupService;
import es.caib.digitalib.persistence.ConfiguracioGrupJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface ConfiguracioGrupLogicaService extends ConfiguracioGrupService {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/ConfiguracioGrupLogicaEJB";

  /**
   * 
   * @param configuracioGrupID
   * @return
   * @throws I18NException
   */
  public ConfiguracioGrupJPA findByPrimaryKeyFull(long configuracioGrupID)
      throws I18NException;

}
