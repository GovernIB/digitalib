package org.fundaciobit.apisib.apimassivescanwebsimple.v1;

import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfiles;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleProfileRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResultRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResult;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStartTransactionRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubTransactionsOfTransaction;

/**
 * 
 * @author anadal(u80067)
 *
 */
public interface ApiMassiveScanWebSimple {

  // Nom de les operacions en constants
  
  public static final String GETSEPARATORPAGE = "getSeparatorPage";

  public static final String GETAVAILABLEPROFILES = "getAvailableProfiles";

  public static final String GETPROFILE = "getProfile";

  public static final String GETTRANSACTIONID = "getTransactionID";

  public static final String STARTTRANSACTION = "startTransaction";

  public static final String GETMASSIVETRANSACTIONSTATUS = "getMassiveTransactionStatus";
  
  public static final String GETSUBTRANSACTIONSTATUS = "getSubTransactionStatus"; 
  
  public static final String GETSUBTRANSACTIONRESULT = "getSubTransactionResult";
  
  public static final String GETSUBTRANSACTIONSOFTRANSACTION = "getSubTransactionsOfTransaction";

  public static final String CLOSETRANSACTION = "closeTransaction";

  
  
  /**
   * Retorna un fitxer PDF que s'usarà com a separador en el fitxers massius
   * @return
   * @throws Exception
   */
  public MassiveScanWebSimpleFile getSeparatorPage(String locale) throws Exception;
  
  
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public MassiveScanWebSimpleAvailableProfiles getAvailableProfiles(String locale)
      throws Exception;

  /**
   * 
   * @return
   * @throws Exception
   */
  public MassiveScanWebSimpleAvailableProfile getProfile(
      MassiveScanWebSimpleProfileRequest profileRequest) throws Exception;

  /**
   * 
   * 
   * @param signaturesSet
   * @return Retorna l'ID de la transacció
   * @throws Exception
   */
  public String getTransactionID(
      MassiveScanWebSimpleGetTransactionIdRequest transactionRequest) throws Exception;

  /**
   *
   * @param startTransactionInfo
   * @return Retorna la URL on redireccionar per realitzar l'Escaneig o Copia Autentica
   * @throws Exception
   */
  public String startTransaction(
      MassiveScanWebSimpleStartTransactionRequest startTransactionInfo) throws Exception;

  /**
   * Retorna l'estat de la transacció massiva.
   * 
   * @param transactionID
   * @return
   * @throws Exception
   */

  public MassiveScanWebSimpleStatus getMassiveTransactionStatus(String transactionID)
      throws Exception;

  /**
   * Retorna les subtransaccions d'una transacció massiva. Les subtransaccions estiran
   * disponibles un cop s'hagi escanejat i s'hagin processat els subdocuments.
   * 
   * @param transactionID
   * @return
   * @throws Exception
   */
  public MassiveScanWebSimpleSubTransactionsOfTransaction getSubTransactionsOfTransaction(String transactionID) throws Exception;

  /**
   * Retorna l'estat d'una subtransacció.
   * 
   * @param subtransactionID
   * @return
   * @throws Exception
   */
  public MassiveScanWebSimpleStatus getSubTransactionStatus(String subtransactionID)
      throws Exception;

  /**
   * Retorna fitxers i informació del resultat d'escaneig, firma i/o arxivat. Permet elegir
   * quins fitxers descarregar
   * 
   * 
   * @return
   * @throws Exception
   */
  public MassiveScanWebSimpleSubtransactionResult getSubTransactionResult(
      MassiveScanWebSimpleSubtransactionResultRequest resultRequest) throws Exception;

  /**
   * 
   * @param transactionID
   * @throws Exception
   */
  public void closeTransaction(String transactionID) throws Exception;

}
