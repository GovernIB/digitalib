package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.jpa.UsuariPersonaJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface UsuariPersonaLogicaLocal extends es.caib.digitalib.ejb.UsuariPersonaLocal {

  public static final String JNDI_NAME = "digitalib/UsuariPersonaLogicaEJB/local";

  /**
   * 
   * @param usuariPersona
   * @throws I18NException
   */
  public UsuariPersonaJPA createFull(UsuariPersonaJPA usuariPersona) throws I18NException;

  /**
   * 
   * @param username
   * @return
   * @throws I18NException
   */
  public UsuariPersonaJPA findByUsernameFull(String username) throws I18NException;

}
