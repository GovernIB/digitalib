package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.persistence.UsuariPersonaJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface UsuariPersonaLogicaService extends es.caib.digitalib.ejb.UsuariPersonaService {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/UsuariPersonaLogicaEJB";

  /**
   * @param adjustRolesToConfgrup  Fa check si la configuracioGrup amb ID confID existeix i 
               // sincronitza roles d'usuari amb perfils de configuraciogrup
   * @param usuariPersona
   * @throws I18NException
   */
  public UsuariPersonaJPA createFull(UsuariPersonaJPA usuariPersona, boolean adjustRolesToConfgrup) throws I18NException;

  /**
   * 
   * @param username
   * @return
   * @throws I18NException
   */
  public UsuariPersonaJPA findByUsernameFull(String username) throws I18NException;

}
