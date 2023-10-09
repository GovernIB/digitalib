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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MassiveScanWebSimpleSubTransactionsOfTransaction
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleSubTransactionsOfTransaction.JSON_PROPERTY_TRANSACTION_I_D,
  MassiveScanWebSimpleSubTransactionsOfTransaction.JSON_PROPERTY_SUBTRANSACIONS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MassiveScanWebSimpleSubTransactionsOfTransaction {
  public static final String JSON_PROPERTY_TRANSACTION_I_D = "transactionID";
  private String transactionID;

  public static final String JSON_PROPERTY_SUBTRANSACIONS = "subtransacions";
  private List<String> subtransacions;

  public MassiveScanWebSimpleSubTransactionsOfTransaction() {
  }

  public MassiveScanWebSimpleSubTransactionsOfTransaction transactionID(String transactionID) {
    
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


  public MassiveScanWebSimpleSubTransactionsOfTransaction subtransacions(List<String> subtransacions) {
    
    this.subtransacions = subtransacions;
    return this;
  }

  public MassiveScanWebSimpleSubTransactionsOfTransaction addSubtransacionsItem(String subtransacionsItem) {
    if (this.subtransacions == null) {
      this.subtransacions = new ArrayList<>();
    }
    this.subtransacions.add(subtransacionsItem);
    return this;
  }

   /**
   * Get subtransacions
   * @return subtransacions
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBTRANSACIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getSubtransacions() {
    return subtransacions;
  }


  @JsonProperty(JSON_PROPERTY_SUBTRANSACIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubtransacions(List<String> subtransacions) {
    this.subtransacions = subtransacions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleSubTransactionsOfTransaction massiveScanWebSimpleSubTransactionsOfTransaction = (MassiveScanWebSimpleSubTransactionsOfTransaction) o;
    return Objects.equals(this.transactionID, massiveScanWebSimpleSubTransactionsOfTransaction.transactionID) &&
        Objects.equals(this.subtransacions, massiveScanWebSimpleSubTransactionsOfTransaction.subtransacions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionID, subtransacions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleSubTransactionsOfTransaction {\n");
    sb.append("    transactionID: ").append(toIndentedString(transactionID)).append("\n");
    sb.append("    subtransacions: ").append(toIndentedString(subtransacions)).append("\n");
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

