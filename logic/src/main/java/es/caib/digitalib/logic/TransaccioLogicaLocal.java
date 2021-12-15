package es.caib.digitalib.logic;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.TransaccioMultiple;

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
   * @param usernameApp
   * @param usernamePerson
   * @return
   * @throws I18NException
   */
  public Set<Long> deleteFull(Transaccio transaccio, 
      String usernameApp, String usernamePerson) throws I18NException;

  /**
   * 
   * @param transactionWebID
   * @return
   * @throws I18NException
   */
  public TransaccioJPA searchTransaccioByTransactionWebID(String transactionWebID)
      throws I18NException;

  /**
   * 
   * @param transactionWebID
   * @return
   * @throws I18NException
   */
  public List<TransaccioJPA> searchMassiveTransaccioByTransactionWebID(String transactionWebID)
      throws I18NException;

  /**
   * 
   * @param transaccioMultipleID
   * @return
   * @throws I18NException
   */
  public List<TransaccioJPA> searchMassiveTransaccioByTransaccioMultipleID(
      long transaccioMultipleID) throws I18NException;

  /**
   * retorna un array de sencers de dues posicions:
   *     - Posició 0: Compte les transaccions associades a una Transacció Massiva
   *     - Posició 1: Numero de transaccions acabades amb OK
   * @param transaccioMultipleID
   * @return
   * @throws I18NException
   */
  public Long[] countTransaccionsByTransaccioMultipleID(
          long transaccioMultipleID) throws I18NException;
  
  /**
   * 
   * @param _ID_
   * @return
   */
  public TransaccioJPA findByPrimaryKeyFull(Long _ID_);

  /**
   * 
   * @param transaccioMultipleID
   * @return
   * @throws I18NException
   */
  public TransaccioMultiple findTransaccioMultipleByPrimaryKey(Long transaccioMultipleID)
      throws I18NException;

  /**
   * 
   * @param tm
   * @return
   * @throws I18NException
   */
  public TransaccioMultiple updateTransaccioMultiple(TransaccioMultiple tm) throws I18NException;

  /**
   * 
   * @return
   */
  public String generateTransactionWebID();

  /**
   * 
   * @param requestTransaction
   * @param usuariAplicacio
   * @param usuariPersona
   * @return
   * @throws I18NException
   */
  public TransaccioJPA crearTransaccio(ScanWebSimpleGetTransactionIdRequest requestTransaction,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase,
      String returnURL, String ip) throws I18NException;

  /**
   * 
   * @param requestTransaction
   * @param usuariAplicacio
   * @param usuariPersona
   * @return
   * @throws I18NException
   */
  public TransaccioJPA crearTransaccio(
      MassiveScanWebSimpleGetTransactionIdRequest requestTransaction,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase,
      String returnURL, String ip) throws I18NException;
  
  
  
  /**
   * 
   * @param transaccioOriginal
   * @param nom
   * @return
   * @throws I18NException
   */
  public TransaccioJPA cloneTransaccio(TransaccioJPA transaccioOriginal, String nom)  throws I18NException;
  
  
  @Override
  public Transaccio update(Transaccio __bean) throws I18NException;

}
