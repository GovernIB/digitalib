package es.caib.digitalib.api.interna.client.versio.v1.api;

import es.caib.digitalib.api.interna.client.versio.v1.services.ApiException;
import es.caib.digitalib.api.interna.client.versio.v1.services.ApiClient;
import es.caib.digitalib.api.interna.client.versio.v1.services.Configuration;
import es.caib.digitalib.api.interna.client.versio.v1.services.Pair;

import javax.ws.rs.core.GenericType;

import es.caib.digitalib.api.interna.client.versio.v1.model.RestExceptionInfo;
import es.caib.digitalib.api.interna.client.versio.v1.model.Versio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class VersioApi {
  private ApiClient apiClient;

  public VersioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public VersioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Versio de l&#39;Aplicació
   * 
   * @param language Codi de l&#39;idioma (optional)
   * @return a {@code Versio}
   * @throws ApiException if fails to make API call
   */
  public Versio versio(String language) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/public/versio/versio".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Versio> localVarReturnType = new GenericType<Versio>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
