package es.caib.digitalib.logic;

import java.util.Set;

import javax.ejb.Local;

import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
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
   public Set<Long> deleteFull(Transaccio transaccio, boolean esborrarFitxers,
       String usernameApp, String usernamePerson) throws I18NException;
  
  /**
   * 
   * @param transactionWebID
   * @return
   * @throws I18NException
   */
  public TransaccioJPA searchTransaccioByTransactionWebID(String transactionWebID) throws I18NException;
  
  /**
   * 
   * @param _ID_
   * @return
   */
  public TransaccioJPA findByPrimaryKeyFull(Long _ID_);
  
  /**
   * 
   * @param requestTransaction
   * @param usuariAplicacio
   * @param usuariPersona
   * @return
   * @throws I18NException
   */
  public TransaccioJPA crearTransaccio(ScanWebSimpleGetTransactionIdRequest requestTransaction,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, 
      String urlBase, String returnURL, String ip) throws I18NException;
}
