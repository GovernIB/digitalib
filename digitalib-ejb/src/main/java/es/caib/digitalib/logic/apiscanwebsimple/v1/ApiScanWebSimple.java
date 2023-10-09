package es.caib.digitalib.logic.apiscanwebsimple.v1;


import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfile;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfiles;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleProfileRequest;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleResultRequest;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleScanResult;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleStartTransactionRequest;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;


/**
 * 
 * @author anadal(u80067)
 *
 */
public interface ApiScanWebSimple {

  // Nom de les operacions en constants

  public static final String AVAILABLEPROFILES = "getAvailableProfiles";
  
  public static final String GETPROFILE = "getProfile";
  
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
   * @return
   * @throws Exception
   */
  public ScanWebSimpleAvailableProfile getProfile(ScanWebSimpleProfileRequest profileRequest) throws Exception;

  /**
   * 
   * 
   * @param signaturesSet
   * @return Retorna l'ID de la transacció
   * @throws Exception
   */
  public String getTransactionID(ScanWebSimpleGetTransactionIdRequest transactionRequest)
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
   * Retorna fitxers i informació del resultat d'escaneig, firma i/o arxivat. 
   * Permet elegir quins fitxers descarregar
   * 
   * 
   * @return
   * @throws Exception
   */
  public ScanWebSimpleScanResult getScanWebResult(ScanWebSimpleResultRequest resultRequest) throws Exception;

  /**
   * 
   * @param transactionID
   * @throws Exception
   */
  public void closeTransaction(String transactionID) throws Exception;

}
