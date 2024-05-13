/*
 * API REST INTERNA de DigitalIB - ApiMassiveScanWebSimple
 * Conjunt de Serveis REST de DigitalIB per la realització remota d'escanejos
 *
 * The version of the OpenAPI document: 1.0-SNAPSHOT
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model;

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
 * MassiveScanWebSimpleArxiuOptionalParameters
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleArxiuOptionalParameters.JSON_PROPERTY_PROCEDURE_NAME,
  MassiveScanWebSimpleArxiuOptionalParameters.JSON_PROPERTY_PROCEDURE_CODE,
  MassiveScanWebSimpleArxiuOptionalParameters.JSON_PROPERTY_DOCUMENTARY_SERIE,
  MassiveScanWebSimpleArxiuOptionalParameters.JSON_PROPERTY_CUSTODY_I_D_OR_EXPEDIENT_I_D
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MassiveScanWebSimpleArxiuOptionalParameters {
  public static final String JSON_PROPERTY_PROCEDURE_NAME = "procedureName";
  private String procedureName;

  public static final String JSON_PROPERTY_PROCEDURE_CODE = "procedureCode";
  private String procedureCode;

  public static final String JSON_PROPERTY_DOCUMENTARY_SERIE = "documentarySerie";
  private String documentarySerie;

  public static final String JSON_PROPERTY_CUSTODY_I_D_OR_EXPEDIENT_I_D = "custodyIDOrExpedientID";
  private String custodyIDOrExpedientID;

  public MassiveScanWebSimpleArxiuOptionalParameters() {
  }

  public MassiveScanWebSimpleArxiuOptionalParameters procedureName(String procedureName) {
    
    this.procedureName = procedureName;
    return this;
  }

   /**
   * Get procedureName
   * @return procedureName
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROCEDURE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getProcedureName() {
    return procedureName;
  }


  @JsonProperty(JSON_PROPERTY_PROCEDURE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcedureName(String procedureName) {
    this.procedureName = procedureName;
  }


  public MassiveScanWebSimpleArxiuOptionalParameters procedureCode(String procedureCode) {
    
    this.procedureCode = procedureCode;
    return this;
  }

   /**
   * Get procedureCode
   * @return procedureCode
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROCEDURE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getProcedureCode() {
    return procedureCode;
  }


  @JsonProperty(JSON_PROPERTY_PROCEDURE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcedureCode(String procedureCode) {
    this.procedureCode = procedureCode;
  }


  public MassiveScanWebSimpleArxiuOptionalParameters documentarySerie(String documentarySerie) {
    
    this.documentarySerie = documentarySerie;
    return this;
  }

   /**
   * Get documentarySerie
   * @return documentarySerie
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DOCUMENTARY_SERIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDocumentarySerie() {
    return documentarySerie;
  }


  @JsonProperty(JSON_PROPERTY_DOCUMENTARY_SERIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocumentarySerie(String documentarySerie) {
    this.documentarySerie = documentarySerie;
  }


  public MassiveScanWebSimpleArxiuOptionalParameters custodyIDOrExpedientID(String custodyIDOrExpedientID) {
    
    this.custodyIDOrExpedientID = custodyIDOrExpedientID;
    return this;
  }

   /**
   * Get custodyIDOrExpedientID
   * @return custodyIDOrExpedientID
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CUSTODY_I_D_OR_EXPEDIENT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustodyIDOrExpedientID() {
    return custodyIDOrExpedientID;
  }


  @JsonProperty(JSON_PROPERTY_CUSTODY_I_D_OR_EXPEDIENT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustodyIDOrExpedientID(String custodyIDOrExpedientID) {
    this.custodyIDOrExpedientID = custodyIDOrExpedientID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleArxiuOptionalParameters massiveScanWebSimpleArxiuOptionalParameters = (MassiveScanWebSimpleArxiuOptionalParameters) o;
    return Objects.equals(this.procedureName, massiveScanWebSimpleArxiuOptionalParameters.procedureName) &&
        Objects.equals(this.procedureCode, massiveScanWebSimpleArxiuOptionalParameters.procedureCode) &&
        Objects.equals(this.documentarySerie, massiveScanWebSimpleArxiuOptionalParameters.documentarySerie) &&
        Objects.equals(this.custodyIDOrExpedientID, massiveScanWebSimpleArxiuOptionalParameters.custodyIDOrExpedientID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(procedureName, procedureCode, documentarySerie, custodyIDOrExpedientID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleArxiuOptionalParameters {\n");
    sb.append("    procedureName: ").append(toIndentedString(procedureName)).append("\n");
    sb.append("    procedureCode: ").append(toIndentedString(procedureCode)).append("\n");
    sb.append("    documentarySerie: ").append(toIndentedString(documentarySerie)).append("\n");
    sb.append("    custodyIDOrExpedientID: ").append(toIndentedString(custodyIDOrExpedientID)).append("\n");
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

