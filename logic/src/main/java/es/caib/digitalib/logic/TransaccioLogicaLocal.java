package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;

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
  //XYZ ZZZpublic TransaccioJPA createWithProfile(TransaccioJPA transaccio) throws I18NException;
  
  /**
   * 
   * @param transactionWebID
   * @return
   * @throws I18NException
   */
  public TransaccioJPA searchTransaccioByTransactionWebID(String transactionWebID) throws I18NException;
  
  /**
   * 
   * @param requestTransaction
   * @param usuariAplicacio
   * @param usuariPersona
   * @return
   * @throws I18NException
   */
  public TransaccioJPA crearTransaccio(ScanWebSimpleGetTransactionIdRequest requestTransaction,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String returnURL) throws I18NException;
}
