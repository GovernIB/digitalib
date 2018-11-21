package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Transaccio;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface TransaccioLogicaLocal extends es.caib.digitalib.ejb.TransaccioLocal {

  public static final String JNDI_NAME = "digitalib/TransaccioLogicaEJB/local";

  /**
   * 
   * @param transaccio
   * @return
   * @throws I18NException
   */
  public Transaccio createWithProfile(TransaccioJPA transaccio) throws I18NException;
}
