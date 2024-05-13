package es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.api;

import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.services.ApiException;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.services.ApiClient;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.services.Configuration;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.services.Pair;

import javax.ws.rs.core.GenericType;

import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleAvailableProfile;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleAvailableProfiles;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleConstants;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleFile;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleProfileRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleStartTransactionRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleStatus;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleSubTransactionsOfTransaction;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleSubtransactionResult;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleSubtransactionResultRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.RestExceptionInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ApiMassiveScanWebSimpleApi {
  private ApiClient apiClient;

  public ApiMassiveScanWebSimpleApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ApiMassiveScanWebSimpleApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Tanca una transacció a partir del seu transaccionWebID
   * 
   * @param body transactionWebID (optional)
   * @throws ApiException if fails to make API call
   */
  public void closeTransaction(String body) throws ApiException {
    Object localVarPostBody = body;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/closeTransaction".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Retorna els Perfils Disponibles per aquest usuari aplicacio
   * 
   * @param body Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; (optional)
   * @return a {@code MassiveScanWebSimpleAvailableProfiles}
   * @throws ApiException if fails to make API call
   */
  public MassiveScanWebSimpleAvailableProfiles getAvailableProfiles(String body) throws ApiException {
    Object localVarPostBody = body;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getAvailableProfiles".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<MassiveScanWebSimpleAvailableProfiles> localVarReturnType = new GenericType<MassiveScanWebSimpleAvailableProfiles>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna l&#39;estat d&#39;una transacció massiva
   * 
   * @param body Id de la transacció WEB (optional)
   * @return a {@code MassiveScanWebSimpleStatus}
   * @throws ApiException if fails to make API call
   */
  public MassiveScanWebSimpleStatus getMassiveTransactionStatus(String body) throws ApiException {
    Object localVarPostBody = body;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getMassiveTransactionStatus".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<MassiveScanWebSimpleStatus> localVarReturnType = new GenericType<MassiveScanWebSimpleStatus>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar
   * 
   * @param massiveScanWebSimpleProfileRequest Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; (optional)
   * @return a {@code MassiveScanWebSimpleAvailableProfile}
   * @throws ApiException if fails to make API call
   */
  public MassiveScanWebSimpleAvailableProfile getProfile(MassiveScanWebSimpleProfileRequest massiveScanWebSimpleProfileRequest) throws ApiException {
    Object localVarPostBody = massiveScanWebSimpleProfileRequest;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getProfile".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<MassiveScanWebSimpleAvailableProfile> localVarReturnType = new GenericType<MassiveScanWebSimpleAvailableProfile>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar
   * 
   * @param body Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; (optional)
   * @return a {@code MassiveScanWebSimpleFile}
   * @throws ApiException if fails to make API call
   */
  public MassiveScanWebSimpleFile getSeparatorPage(String body) throws ApiException {
    Object localVarPostBody = body;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getSeparatorPage".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<MassiveScanWebSimpleFile> localVarReturnType = new GenericType<MassiveScanWebSimpleFile>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna els resultats d&#39;una subtransacció.
   * 
   * @param massiveScanWebSimpleSubtransactionResultRequest Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; (optional)
   * @return a {@code MassiveScanWebSimpleSubtransactionResult}
   * @throws ApiException if fails to make API call
   */
  public MassiveScanWebSimpleSubtransactionResult getSubTransactionResult(MassiveScanWebSimpleSubtransactionResultRequest massiveScanWebSimpleSubtransactionResultRequest) throws ApiException {
    Object localVarPostBody = massiveScanWebSimpleSubtransactionResultRequest;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getSubTransactionResult".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<MassiveScanWebSimpleSubtransactionResult> localVarReturnType = new GenericType<MassiveScanWebSimpleSubtransactionResult>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna l&#39;estat d&#39;una subtransacció.
   * 
   * @param body subTransactionID (required)
   * @return a {@code MassiveScanWebSimpleStatus}
   * @throws ApiException if fails to make API call
   */
  public MassiveScanWebSimpleStatus getSubTransactionStatus(String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling getSubTransactionStatus");
    }
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getSubTransactionStatus".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<MassiveScanWebSimpleStatus> localVarReturnType = new GenericType<MassiveScanWebSimpleStatus>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar
   * 
   * @param body transactionWebID (required)
   * @return a {@code MassiveScanWebSimpleSubTransactionsOfTransaction}
   * @throws ApiException if fails to make API call
   */
  public MassiveScanWebSimpleSubTransactionsOfTransaction getSubTransactionsOfTransaction(String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling getSubTransactionsOfTransaction");
    }
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getSubTransactionsOfTransaction".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<MassiveScanWebSimpleSubTransactionsOfTransaction> localVarReturnType = new GenericType<MassiveScanWebSimpleSubTransactionsOfTransaction>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna una transacció a partir de l&#39;identificador
   * 
   * @param massiveScanWebSimpleGetTransactionIdRequest Dades de la petició (optional)
   * @return a {@code String}
   * @throws ApiException if fails to make API call
   */
  public String getTransactionID(MassiveScanWebSimpleGetTransactionIdRequest massiveScanWebSimpleGetTransactionIdRequest) throws ApiException {
    Object localVarPostBody = massiveScanWebSimpleGetTransactionIdRequest;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/getTransactionID".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Posa en marxa una transacció
   * 
   * @param massiveScanWebSimpleStartTransactionRequest Dades necessàries per posa en marxa una transacció (optional)
   * @return a {@code String}
   * @throws ApiException if fails to make API call
   */
  public String startTransaction(MassiveScanWebSimpleStartTransactionRequest massiveScanWebSimpleStartTransactionRequest) throws ApiException {
    Object localVarPostBody = massiveScanWebSimpleStartTransactionRequest;
    
    // create path and map variables
    String localVarPath = "/secure/apimassivescanwebsimple/v1/startTransaction".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
