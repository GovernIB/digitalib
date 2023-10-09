/*
 * API REST EXTERNA de DigitalIB
 * Conjunt de Serveis REST de DigitalIB per ser accedits des de l'exterior
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package es.caib.digitalib.apiexterna.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MassiveScanWebSimpleStartTransactionRequest
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleStartTransactionRequest.JSON_PROPERTY_TRANSACTION_I_D,
  MassiveScanWebSimpleStartTransactionRequest.JSON_PROPERTY_RETURN_URL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MassiveScanWebSimpleStartTransactionRequest {
  public static final String JSON_PROPERTY_TRANSACTION_I_D = "transactionID";
  private String transactionID;

  public static final String JSON_PROPERTY_RETURN_URL = "returnUrl";
  private String returnUrl;

  public MassiveScanWebSimpleStartTransactionRequest() {
  }

  public MassiveScanWebSimpleStartTransactionRequest transactionID(String transactionID) {
    
    this.transactionID = transactionID;
    return this;
  }

   /**
   * Get transactionID
   * @return transactionID
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRANSACTION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTransactionID() {
    return transactionID;
  }


  @JsonProperty(JSON_PROPERTY_TRANSACTION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }


  public MassiveScanWebSimpleStartTransactionRequest returnUrl(String returnUrl) {
    
    this.returnUrl = returnUrl;
    return this;
  }

   /**
   * Get returnUrl
   * @return returnUrl
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RETURN_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReturnUrl() {
    return returnUrl;
  }


  @JsonProperty(JSON_PROPERTY_RETURN_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleStartTransactionRequest massiveScanWebSimpleStartTransactionRequest = (MassiveScanWebSimpleStartTransactionRequest) o;
    return Objects.equals(this.transactionID, massiveScanWebSimpleStartTransactionRequest.transactionID) &&
        Objects.equals(this.returnUrl, massiveScanWebSimpleStartTransactionRequest.returnUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionID, returnUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleStartTransactionRequest {\n");
    sb.append("    transactionID: ").append(toIndentedString(transactionID)).append("\n");
    sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

