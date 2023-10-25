# ApiMassiveScanWebSimpleApi

All URIs are relative to */digitalibapi/externa*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**closeTransaction**](ApiMassiveScanWebSimpleApi.md#closeTransaction) | **POST** /secure/apimassivescanwebsimple/v1/closeTransaction | Tanca una transacció a partir del seu transaccionWebID |
| [**getAvailableProfiles**](ApiMassiveScanWebSimpleApi.md#getAvailableProfiles) | **POST** /secure/apimassivescanwebsimple/v1/getAvailableProfiles | Retorna els Perfils Disponibles per aquest usuari aplicacio |
| [**getMassiveTransactionStatus**](ApiMassiveScanWebSimpleApi.md#getMassiveTransactionStatus) | **POST** /secure/apimassivescanwebsimple/v1/getMassiveTransactionStatus | Retorna l&#39;estat d&#39;una transacció massiva |
| [**getProfile**](ApiMassiveScanWebSimpleApi.md#getProfile) | **POST** /secure/apimassivescanwebsimple/v1/getProfile | Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar |
| [**getSeparatorPage**](ApiMassiveScanWebSimpleApi.md#getSeparatorPage) | **POST** /secure/apimassivescanwebsimple/v1/getSeparatorPage | Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar |
| [**getSubTransactionResult**](ApiMassiveScanWebSimpleApi.md#getSubTransactionResult) | **POST** /secure/apimassivescanwebsimple/v1/getSubTransactionResult | Retorna els resultats d&#39;una subtransacció. |
| [**getSubTransactionStatus**](ApiMassiveScanWebSimpleApi.md#getSubTransactionStatus) | **POST** /secure/apimassivescanwebsimple/v1/getSubTransactionStatus | Retorna l&#39;estat d&#39;una subtransacció. |
| [**getSubTransactionsOfTransaction**](ApiMassiveScanWebSimpleApi.md#getSubTransactionsOfTransaction) | **POST** /secure/apimassivescanwebsimple/v1/getSubTransactionsOfTransaction | Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar |
| [**getTransactionID**](ApiMassiveScanWebSimpleApi.md#getTransactionID) | **POST** /secure/apimassivescanwebsimple/v1/getTransactionID | Retorna una transacció a partir de l&#39;identificador |
| [**startTransaction**](ApiMassiveScanWebSimpleApi.md#startTransaction) | **POST** /secure/apimassivescanwebsimple/v1/startTransaction | Posa en marxa una transacció |



## closeTransaction

> closeTransaction(body)

Tanca una transacció a partir del seu transaccionWebID

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        String body = "body_example"; // String | transactionWebID
        try {
            apiInstance.closeTransaction(body);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#closeTransaction");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **String**| transactionWebID | [optional] |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getAvailableProfiles

> MassiveScanWebSimpleAvailableProfiles getAvailableProfiles(body)

Retorna els Perfils Disponibles per aquest usuari aplicacio

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        String body = "body_example"; // String | Idioma. Valors permesos 'es' o 'ca'
        try {
            MassiveScanWebSimpleAvailableProfiles result = apiInstance.getAvailableProfiles(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getAvailableProfiles");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **String**| Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; | [optional] |

### Return type

[**MassiveScanWebSimpleAvailableProfiles**](MassiveScanWebSimpleAvailableProfiles.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getMassiveTransactionStatus

> MassiveScanWebSimpleStatus getMassiveTransactionStatus(body)

Retorna l&#39;estat d&#39;una transacció massiva

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        String body = "body_example"; // String | Id de la transacció WEB
        try {
            MassiveScanWebSimpleStatus result = apiInstance.getMassiveTransactionStatus(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getMassiveTransactionStatus");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **String**| Id de la transacció WEB | [optional] |

### Return type

[**MassiveScanWebSimpleStatus**](MassiveScanWebSimpleStatus.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getProfile

> MassiveScanWebSimpleAvailableProfile getProfile(massiveScanWebSimpleProfileRequest)

Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        MassiveScanWebSimpleProfileRequest massiveScanWebSimpleProfileRequest = new MassiveScanWebSimpleProfileRequest(); // MassiveScanWebSimpleProfileRequest | Idioma. Valors permesos 'es' o 'ca'
        try {
            MassiveScanWebSimpleAvailableProfile result = apiInstance.getProfile(massiveScanWebSimpleProfileRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getProfile");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **massiveScanWebSimpleProfileRequest** | [**MassiveScanWebSimpleProfileRequest**](MassiveScanWebSimpleProfileRequest.md)| Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; | [optional] |

### Return type

[**MassiveScanWebSimpleAvailableProfile**](MassiveScanWebSimpleAvailableProfile.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getSeparatorPage

> MassiveScanWebSimpleFile getSeparatorPage(body)

Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        String body = "body_example"; // String | Idioma. Valors permesos 'es' o 'ca'
        try {
            MassiveScanWebSimpleFile result = apiInstance.getSeparatorPage(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getSeparatorPage");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **String**| Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; | [optional] |

### Return type

[**MassiveScanWebSimpleFile**](MassiveScanWebSimpleFile.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |
| **510** | Només s&#39;utilitza per crear fitxer de constants... |  -  |


## getSubTransactionResult

> MassiveScanWebSimpleSubtransactionResult getSubTransactionResult(massiveScanWebSimpleSubtransactionResultRequest)

Retorna els resultats d&#39;una subtransacció.

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        MassiveScanWebSimpleSubtransactionResultRequest massiveScanWebSimpleSubtransactionResultRequest = new MassiveScanWebSimpleSubtransactionResultRequest(); // MassiveScanWebSimpleSubtransactionResultRequest | Idioma. Valors permesos 'es' o 'ca'
        try {
            MassiveScanWebSimpleSubtransactionResult result = apiInstance.getSubTransactionResult(massiveScanWebSimpleSubtransactionResultRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getSubTransactionResult");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **massiveScanWebSimpleSubtransactionResultRequest** | [**MassiveScanWebSimpleSubtransactionResultRequest**](MassiveScanWebSimpleSubtransactionResultRequest.md)| Idioma. Valors permesos &#39;es&#39; o &#39;ca&#39; | [optional] |

### Return type

[**MassiveScanWebSimpleSubtransactionResult**](MassiveScanWebSimpleSubtransactionResult.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getSubTransactionStatus

> MassiveScanWebSimpleStatus getSubTransactionStatus(body)

Retorna l&#39;estat d&#39;una subtransacció.

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        String body = "body_example"; // String | subTransactionID
        try {
            MassiveScanWebSimpleStatus result = apiInstance.getSubTransactionStatus(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getSubTransactionStatus");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **String**| subTransactionID | |

### Return type

[**MassiveScanWebSimpleStatus**](MassiveScanWebSimpleStatus.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getSubTransactionsOfTransaction

> MassiveScanWebSimpleSubTransactionsOfTransaction getSubTransactionsOfTransaction(body)

Retorna el PDF que s&#39;ha de ficar entre els diferents documents a escanejar

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        String body = "body_example"; // String | transactionWebID
        try {
            MassiveScanWebSimpleSubTransactionsOfTransaction result = apiInstance.getSubTransactionsOfTransaction(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getSubTransactionsOfTransaction");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **String**| transactionWebID | |

### Return type

[**MassiveScanWebSimpleSubTransactionsOfTransaction**](MassiveScanWebSimpleSubTransactionsOfTransaction.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |
| **510** | Només s&#39;utilitza per crear fitxer de constants... |  -  |


## getTransactionID

> String getTransactionID(massiveScanWebSimpleGetTransactionIdRequest)

Retorna una transacció a partir de l&#39;identificador

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        MassiveScanWebSimpleGetTransactionIdRequest massiveScanWebSimpleGetTransactionIdRequest = new MassiveScanWebSimpleGetTransactionIdRequest(); // MassiveScanWebSimpleGetTransactionIdRequest | Dades de la petició
        try {
            String result = apiInstance.getTransactionID(massiveScanWebSimpleGetTransactionIdRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#getTransactionID");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **massiveScanWebSimpleGetTransactionIdRequest** | [**MassiveScanWebSimpleGetTransactionIdRequest**](MassiveScanWebSimpleGetTransactionIdRequest.md)| Dades de la petició | [optional] |

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## startTransaction

> String startTransaction(massiveScanWebSimpleStartTransactionRequest)

Posa en marxa una transacció

### Example

```java
// Import classes:
import es.caib.digitalib.apiexterna.client.services.ApiClient;
import es.caib.digitalib.apiexterna.client.services.ApiException;
import es.caib.digitalib.apiexterna.client.services.Configuration;
import es.caib.digitalib.apiexterna.client.services.auth.*;
import es.caib.digitalib.apiexterna.client.services.models.*;
import es.caib.digitalib.apiexterna.client.api.ApiMassiveScanWebSimpleApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        ApiMassiveScanWebSimpleApi apiInstance = new ApiMassiveScanWebSimpleApi(defaultClient);
        MassiveScanWebSimpleStartTransactionRequest massiveScanWebSimpleStartTransactionRequest = new MassiveScanWebSimpleStartTransactionRequest(); // MassiveScanWebSimpleStartTransactionRequest | Dades necessàries per posa en marxa una transacció
        try {
            String result = apiInstance.startTransaction(massiveScanWebSimpleStartTransactionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiMassiveScanWebSimpleApi#startTransaction");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **massiveScanWebSimpleStartTransactionRequest** | [**MassiveScanWebSimpleStartTransactionRequest**](MassiveScanWebSimpleStartTransactionRequest.md)| Dades necessàries per posa en marxa una transacció | [optional] |

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Operació realitzada correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |

