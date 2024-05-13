# VersioApi

All URIs are relative to */digitalibapi/interna*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**versio**](VersioApi.md#versio) | **GET** /public/versio/versio | Versio de l&#39;Aplicació |



## versio

> Versio versio(language)

Versio de l&#39;Aplicació

### Example

```java
// Import classes:
import es.caib.digitalib.api.interna.client.versio.v1.services.ApiClient;
import es.caib.digitalib.api.interna.client.versio.v1.services.ApiException;
import es.caib.digitalib.api.interna.client.versio.v1.services.Configuration;
import es.caib.digitalib.api.interna.client.versio.v1.services.models.*;
import es.caib.digitalib.api.interna.client.versio.v1.api.VersioApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/digitalibapi/interna");

        VersioApi apiInstance = new VersioApi(defaultClient);
        String language = "ca"; // String | Codi de l'idioma
        try {
            Versio result = apiInstance.versio(language);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VersioApi#versio");
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
| **language** | **String**| Codi de l&#39;idioma | [optional] |

### Return type

[**Versio**](Versio.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Versió de l&#39;Aplicació DigitalIB |  -  |
| **404** | Paràmetres incorrectes |  -  |
| **500** | Error no controlat en el servidor |  -  |

