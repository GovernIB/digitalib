package org.fundaciobit.apisib.apiscanwebsimple.v1;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfiles;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleError;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleScanResult;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStartTransactionRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.AbstractScanWebSimpleException;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.CancelledUserException;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.ClientException;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.NoAvailablePluginException;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.ServerException;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.TimeOutException;


/**
 * 
 * @author anadal(u80067)
 *
 */
public interface ApiScanWebSimple {

  // Nom de les operacions en constants
  public static final String AVAILABLEPROFILES = "getAvailableProfiles";

  public static final String GETTRANSACTIONID = "getTransactionID";

  public static final String STARTTRANSACTION = "startTransaction";

  public static final String TRANSACTIONSTATUS = "getTransactionStatus";

  public static final String SCANWEBRESULT = "getScanWebResult";

  public static final String CLOSETRANSACTION = "closeTransaction";

  /**
   * 
   * @return
   * @throws Exception
   */
  public ScanWebSimpleAvailableProfiles getAvailableProfiles(String locale) throws Exception;

  /**
   * 
   * 
   * @param signaturesSet
   * @return Retorna l'ID de la transacció
   * @throws Exception
   */
  public String getTransactionID(ScanWebSimpleGetTransactionIdRequest getTransactionRequest)
      throws Exception;

  /**
   *
   * @param startTransactionInfo
   * @return Retorna la URL on redireccionar per realitzar l'Escaneig o Copia Autentica
   * @throws Exception
   */
  public String startTransaction(ScanWebSimpleStartTransactionRequest startTransactionInfo)
      throws Exception;

  /**
   * Retorna l'estat de la transacció.
   * 
   * @param transactionID
   * @return
   * @throws Exception
   */

  public ScanWebSimpleStatus getTransactionStatus(String transactionID) throws Exception;

  /**
   * Retorna el resultat i les fitxers signats de les firmes enviades.
   * 
   * @param transactionID
   * @return
   * @throws Exception
   */
  public ScanWebSimpleScanResult getScanWebResult(String transactionID) throws Exception;

  /**
   * 
   * @param transactionID
   * @throws Exception
   */
  public void closeTransaction(String transactionID) throws Exception;

}
