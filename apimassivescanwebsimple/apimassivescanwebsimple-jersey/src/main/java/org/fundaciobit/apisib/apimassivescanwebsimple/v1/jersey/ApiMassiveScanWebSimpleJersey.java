package org.fundaciobit.apisib.apimassivescanwebsimple.v1.jersey;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.codehaus.jackson.map.ObjectMapper;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.ApiMassiveScanWebSimple;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfiles;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleError;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleProfileRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResult;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResultRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStartTransactionRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubTransactionsOfTransaction;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.exceptions.AbstractScanWebSimpleException;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.exceptions.CancelledUserException;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.exceptions.ClientException;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.exceptions.NoAvailablePluginException;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.exceptions.ServerException;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.exceptions.TimeOutException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.urlconnection.HTTPSProperties;

/**
 * 
 * @author anadal(u80067)
 *
 */
public class ApiMassiveScanWebSimpleJersey implements ApiMassiveScanWebSimple {

  protected final String endPointBase;

  protected String username = null;

  protected String password = null;


  /**
   * 
   * @param endPointBase
   */
  public ApiMassiveScanWebSimpleJersey(String endPointBase) {
    super();
    this.endPointBase = endPointBase;
  }

  /**
   * 
   * @param endPointBase
   * @param username
   * @param password
   */
  public ApiMassiveScanWebSimpleJersey(String endPointBase, String username, String password) {
    super();
    this.endPointBase = endPointBase;
    this.username = username;
    this.password = password;
  }

  
  @Override
  public MassiveScanWebSimpleFile getSeparatorPage(String locale) throws Exception {
    
    ClientResponse response = commonCall(locale, GETSEPARATORPAGE);

    MassiveScanWebSimpleFile result = response.getEntity(MassiveScanWebSimpleFile.class);

    return result;
  }

  

  /**
   * 
   * @return
   * @throws Exception
   */
  @Override
  public MassiveScanWebSimpleAvailableProfiles getAvailableProfiles(String locale) throws Exception {

    ClientResponse response = commonCall(locale, GETAVAILABLEPROFILES);

    MassiveScanWebSimpleAvailableProfiles result = response
        .getEntity(MassiveScanWebSimpleAvailableProfiles.class);

    return result;
  }

  /**
   * 
   */
  @Override
  public MassiveScanWebSimpleAvailableProfile getProfile(MassiveScanWebSimpleProfileRequest profileRequest)
      throws Exception {
    ClientResponse response = commonCall(profileRequest, GETPROFILE);

    MassiveScanWebSimpleAvailableProfile result = response
        .getEntity(MassiveScanWebSimpleAvailableProfile.class);

    return result;
  }

  /**
   * 
   * 
   * @param signaturesSet
   * @return Retorna l'ID de la transacció
   * @throws Exception
   */
  @Override
  public String getTransactionID(MassiveScanWebSimpleGetTransactionIdRequest getTransactionRequest)
      throws Exception {

    ClientResponse response = commonCall(getTransactionRequest, GETTRANSACTIONID);

    String result = response.getEntity(String.class);

    result = cleanString(result);

    return result;
  }

  /**
   *
   * @param startTransactionInfo
   * @return Retorna la URL on redireccionar per realitzar l'Escaneig o Copia Autentica
   * @throws Exception
   */
  @Override
  public String startTransaction(MassiveScanWebSimpleStartTransactionRequest startTransactionInfo)
      throws Exception {

    ClientResponse response = commonCall(startTransactionInfo, STARTTRANSACTION);

    String result = response.getEntity(String.class);

    result = cleanString(result);

    return result;
  }

  /**
   * Retorna l'estat de la transacció.
   * 
   * @param transactionID
   * @return
   * @throws Exception
   */
  @Override
  public MassiveScanWebSimpleStatus getMassiveTransactionStatus(String transactionID) throws Exception {

    ClientResponse response = commonCall(transactionID, GETMASSIVETRANSACTIONSTATUS);

    MassiveScanWebSimpleStatus result = response.getEntity(MassiveScanWebSimpleStatus.class);

    return result;
  }

  
  @Override
  public MassiveScanWebSimpleSubTransactionsOfTransaction getSubTransactionsOfTransaction(String transactionID) throws Exception {
    ClientResponse response = commonCall(transactionID, GETSUBTRANSACTIONSOFTRANSACTION);

    MassiveScanWebSimpleSubTransactionsOfTransaction result = response.getEntity(MassiveScanWebSimpleSubTransactionsOfTransaction.class);

    return result;
  }

  @Override
  public MassiveScanWebSimpleStatus getSubTransactionStatus(String subtransactionID)
      throws Exception {
    ClientResponse response = commonCall(subtransactionID, GETSUBTRANSACTIONSTATUS);

    MassiveScanWebSimpleStatus result = response.getEntity(MassiveScanWebSimpleStatus.class);

    return result;
  }


  /**
   * Retorna fitxers i informació del resultat d'escaneig, firma i/o arxivat. Permet elegir
   * quins fitxers descarregar
   *    * 
   * @param transactionID
   * @return
   * @throws Exception
   */
  @Override
  public MassiveScanWebSimpleSubtransactionResult getSubTransactionResult(
      MassiveScanWebSimpleSubtransactionResultRequest resultRequest) throws Exception {

    ClientResponse response = commonCall(resultRequest, GETSUBTRANSACTIONRESULT);

    MassiveScanWebSimpleSubtransactionResult result = response.getEntity(MassiveScanWebSimpleSubtransactionResult.class);

    return result;
  }

  /**
   * 
   * @param transactionID
   * @throws Exception
   */
  @Override
  public void closeTransaction(String transactionID) throws Exception {

    commonCall(transactionID, CLOSETRANSACTION);

  }

  /**
   * 
   * @param result
   * @return
   */
  protected String cleanString(String result) {
    if (result != null) {
      result = result.trim();
      if (result.startsWith("\"")) {
        result = result.substring(1);
      }
      if (result.endsWith("\"")) {
        result = result.substring(0, result.length() - 1);
      }
    }
    return result;
  }

  /**
   * 
   * @param parameter
   * @param method
   * @return
   * @throws AbstractScanWebSimpleException
   */
  protected ClientResponse commonCall(Object parameter, String method)
      throws AbstractScanWebSimpleException {

    ClientResponse response;
    try {
      String endPoint = endPointBase + (endPointBase.endsWith("/") ? "" : "/") + method;

      ClientConfig config = new DefaultClientConfig();
      final Client client;
      if (endPoint.toLowerCase().startsWith("https")) {
        // Ignorar Certificats de la part servidora
        HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

        SSLContext ctx = SSLContext.getInstance("SSL");
        ctx.init(null, new TrustManager[] { new InsecureTrustManager() }, null);
        config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES,
            new HTTPSProperties(hostnameVerifier, ctx));
      }

      config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

      client = Client.create(config);

      if (this.username != null) {
        client.addFilter(new HTTPBasicAuthFilter(this.username, this.password));
      }

      WebResource webResource = client.resource(endPoint);

      if (parameter == null) {
        response = webResource.type("application/json").post(ClientResponse.class);
      } else {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(parameter);
        response = webResource.type("application/json").post(ClientResponse.class, json);
      }

    } catch (Exception e) {
      throw new ClientException(e.getMessage(), e);
    }

    if (response.getStatus() == 200) {
      return response;
    } else {

      // Miram si ho podem transformar a ApiSimpleError
      MassiveScanWebSimpleError simple = null;
      try {
        simple = response.getEntity(MassiveScanWebSimpleError.class);
      } catch (Exception e) {
        // Error no controlat
        e.printStackTrace();
      }

      //System.out.println("ERROR SIMPLE: ]" + simple + "[");

      if (simple != null) {
        String tipus = simple.getType();
        //System.out.println(" ERROR TIPUS: ]" + tipus + "[");

        if (tipus != null && tipus.trim().length() != 0) {

          // System.out.println(" ERROR TIPUS IS SERVER EXCEPTION: ]"
          // + tipus.equals(ServerException.class.getName()) + "[");

          if (tipus.equals(NoAvailablePluginException.class.getName())) {
            throw new NoAvailablePluginException(simple.getMessage(), simple.getStackTrace());
          } else if (tipus.equals(CancelledUserException.class.getName())) {
            throw new CancelledUserException(simple.getMessage(), simple.getStackTrace());
          } else if (tipus.equals(TimeOutException.class.getName())) {
            throw new TimeOutException(simple.getMessage(), simple.getStackTrace());
          } else if (tipus.equals(ServerException.class.getName())) {
            throw new ServerException(simple.getMessage(), simple.getStackTrace());
          } else {
            // TODO Altres Excepcions
            throw new ClientException(simple.getMessage(), simple.getStackTrace());
          }

        }
      }

      // Error de Comunicació o no controlat
      String raw_msg = response.getEntity(String.class);
      throw new ClientException("Error desconegut (Codi de servidor " + +response.getStatus()
          + "): " + raw_msg);

    }

  }

  /**
   * 
   * @author anadal
   *
   */
  public class InsecureTrustManager implements X509TrustManager {
    /**
     * {@inheritDoc}
     */
    @Override
    public void checkClientTrusted(final java.security.cert.X509Certificate[] chain,
        final String authType) throws CertificateException {
      // Everyone is trusted!
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkServerTrusted(final java.security.cert.X509Certificate[] chain,
        final String authType) throws CertificateException {
      // Everyone is trusted!
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[0];
    }
  }



}
