package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.ejb.ConfiguracioGrupLocal;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface ConfiguracioGrupLogicaLocal extends ConfiguracioGrupLocal {

  public static final String JNDI_NAME = "digitalib/ConfiguracioGrupLogicaEJB/local";

  /**
   * 
   * @param configuracioGrupID
   * @return
   * @throws I18NException
   */
  public ConfiguracioGrupJPA findByPrimaryKeyFull(long configuracioGrupID)
      throws I18NException;

}
