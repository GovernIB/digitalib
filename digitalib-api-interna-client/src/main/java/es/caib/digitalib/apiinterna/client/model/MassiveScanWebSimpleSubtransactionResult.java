/*
 * API REST INTERNA de DigitalIB
 * Conjunt de Serveis REST de DigitalIB per ser accedits des de l'interior
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package es.caib.digitalib.apiinterna.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleArxiuInfo;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleArxiuOptionalParameters;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleArxiuRequiredParameters;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleCustodyInfo;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleFile;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleKeyValue;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleScannedFileInfo;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleSignedFileInfo;
import es.caib.digitalib.apiinterna.client.model.MassiveScanWebSimpleStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MassiveScanWebSimpleSubtransactionResult
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_TRANSACTION_I_D,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_TRANSACTION_WEB_I_D,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_STATUS,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_SCANNED_FILE,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_SCANNED_FILE_INFO,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_SIGNED_FILE,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_DETACHED_SIGNATURE_FILE,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_SIGNED_FILE_INFO,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_CUSTODY_INFO,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_ARXIU_INFO,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_ARXIU_REQUIRED_PARAMETERS,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_ARXIU_OPTIONAL_PARAMETERS,
  MassiveScanWebSimpleSubtransactionResult.JSON_PROPERTY_ADDITIONAL_METADATAS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.4.0")
public class MassiveScanWebSimpleSubtransactionResult {
  public static final String JSON_PROPERTY_TRANSACTION_I_D = "transactionID";
  private Long transactionID;

  public static final String JSON_PROPERTY_TRANSACTION_WEB_I_D = "transactionWebID";
  private String transactionWebID;

  public static final String JSON_PROPERTY_STATUS = "status";
  private MassiveScanWebSimpleStatus status;

  public static final String JSON_PROPERTY_SCANNED_FILE = "scannedFile";
  private MassiveScanWebSimpleFile scannedFile;

  public static final String JSON_PROPERTY_SCANNED_FILE_INFO = "scannedFileInfo";
  private MassiveScanWebSimpleScannedFileInfo scannedFileInfo;

  public static final String JSON_PROPERTY_SIGNED_FILE = "signedFile";
  private MassiveScanWebSimpleFile signedFile;

  public static final String JSON_PROPERTY_DETACHED_SIGNATURE_FILE = "detachedSignatureFile";
  private MassiveScanWebSimpleFile detachedSignatureFile;

  public static final String JSON_PROPERTY_SIGNED_FILE_INFO = "signedFileInfo";
  private MassiveScanWebSimpleSignedFileInfo signedFileInfo;

  public static final String JSON_PROPERTY_CUSTODY_INFO = "custodyInfo";
  private MassiveScanWebSimpleCustodyInfo custodyInfo;

  public static final String JSON_PROPERTY_ARXIU_INFO = "arxiuInfo";
  private MassiveScanWebSimpleArxiuInfo arxiuInfo;

  public static final String JSON_PROPERTY_ARXIU_REQUIRED_PARAMETERS = "arxiuRequiredParameters";
  private MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;

  public static final String JSON_PROPERTY_ARXIU_OPTIONAL_PARAMETERS = "arxiuOptionalParameters";
  private MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;

  public static final String JSON_PROPERTY_ADDITIONAL_METADATAS = "additionalMetadatas";
  private List<MassiveScanWebSimpleKeyValue> additionalMetadatas;

  public MassiveScanWebSimpleSubtransactionResult() {
  }

  public MassiveScanWebSimpleSubtransactionResult transactionID(Long transactionID) {
    
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

  public Long getTransactionID() {
    return transactionID;
  }


  @JsonProperty(JSON_PROPERTY_TRANSACTION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransactionID(Long transactionID) {
    this.transactionID = transactionID;
  }


  public MassiveScanWebSimpleSubtransactionResult transactionWebID(String transactionWebID) {
    
    this.transactionWebID = transactionWebID;
    return this;
  }

   /**
   * Get transactionWebID
   * @return transactionWebID
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRANSACTION_WEB_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTransactionWebID() {
    return transactionWebID;
  }


  @JsonProperty(JSON_PROPERTY_TRANSACTION_WEB_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransactionWebID(String transactionWebID) {
    this.transactionWebID = transactionWebID;
  }


  public MassiveScanWebSimpleSubtransactionResult status(MassiveScanWebSimpleStatus status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleStatus getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(MassiveScanWebSimpleStatus status) {
    this.status = status;
  }


  public MassiveScanWebSimpleSubtransactionResult scannedFile(MassiveScanWebSimpleFile scannedFile) {
    
    this.scannedFile = scannedFile;
    return this;
  }

   /**
   * Get scannedFile
   * @return scannedFile
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SCANNED_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleFile getScannedFile() {
    return scannedFile;
  }


  @JsonProperty(JSON_PROPERTY_SCANNED_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScannedFile(MassiveScanWebSimpleFile scannedFile) {
    this.scannedFile = scannedFile;
  }


  public MassiveScanWebSimpleSubtransactionResult scannedFileInfo(MassiveScanWebSimpleScannedFileInfo scannedFileInfo) {
    
    this.scannedFileInfo = scannedFileInfo;
    return this;
  }

   /**
   * Get scannedFileInfo
   * @return scannedFileInfo
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SCANNED_FILE_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleScannedFileInfo getScannedFileInfo() {
    return scannedFileInfo;
  }


  @JsonProperty(JSON_PROPERTY_SCANNED_FILE_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScannedFileInfo(MassiveScanWebSimpleScannedFileInfo scannedFileInfo) {
    this.scannedFileInfo = scannedFileInfo;
  }


  public MassiveScanWebSimpleSubtransactionResult signedFile(MassiveScanWebSimpleFile signedFile) {
    
    this.signedFile = signedFile;
    return this;
  }

   /**
   * Get signedFile
   * @return signedFile
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIGNED_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleFile getSignedFile() {
    return signedFile;
  }


  @JsonProperty(JSON_PROPERTY_SIGNED_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignedFile(MassiveScanWebSimpleFile signedFile) {
    this.signedFile = signedFile;
  }


  public MassiveScanWebSimpleSubtransactionResult detachedSignatureFile(MassiveScanWebSimpleFile detachedSignatureFile) {
    
    this.detachedSignatureFile = detachedSignatureFile;
    return this;
  }

   /**
   * Get detachedSignatureFile
   * @return detachedSignatureFile
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DETACHED_SIGNATURE_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleFile getDetachedSignatureFile() {
    return detachedSignatureFile;
  }


  @JsonProperty(JSON_PROPERTY_DETACHED_SIGNATURE_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetachedSignatureFile(MassiveScanWebSimpleFile detachedSignatureFile) {
    this.detachedSignatureFile = detachedSignatureFile;
  }


  public MassiveScanWebSimpleSubtransactionResult signedFileInfo(MassiveScanWebSimpleSignedFileInfo signedFileInfo) {
    
    this.signedFileInfo = signedFileInfo;
    return this;
  }

   /**
   * Get signedFileInfo
   * @return signedFileInfo
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIGNED_FILE_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleSignedFileInfo getSignedFileInfo() {
    return signedFileInfo;
  }


  @JsonProperty(JSON_PROPERTY_SIGNED_FILE_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignedFileInfo(MassiveScanWebSimpleSignedFileInfo signedFileInfo) {
    this.signedFileInfo = signedFileInfo;
  }


  public MassiveScanWebSimpleSubtransactionResult custodyInfo(MassiveScanWebSimpleCustodyInfo custodyInfo) {
    
    this.custodyInfo = custodyInfo;
    return this;
  }

   /**
   * Get custodyInfo
   * @return custodyInfo
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CUSTODY_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleCustodyInfo getCustodyInfo() {
    return custodyInfo;
  }


  @JsonProperty(JSON_PROPERTY_CUSTODY_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustodyInfo(MassiveScanWebSimpleCustodyInfo custodyInfo) {
    this.custodyInfo = custodyInfo;
  }


  public MassiveScanWebSimpleSubtransactionResult arxiuInfo(MassiveScanWebSimpleArxiuInfo arxiuInfo) {
    
    this.arxiuInfo = arxiuInfo;
    return this;
  }

   /**
   * Get arxiuInfo
   * @return arxiuInfo
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ARXIU_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleArxiuInfo getArxiuInfo() {
    return arxiuInfo;
  }


  @JsonProperty(JSON_PROPERTY_ARXIU_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArxiuInfo(MassiveScanWebSimpleArxiuInfo arxiuInfo) {
    this.arxiuInfo = arxiuInfo;
  }


  public MassiveScanWebSimpleSubtransactionResult arxiuRequiredParameters(MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters) {
    
    this.arxiuRequiredParameters = arxiuRequiredParameters;
    return this;
  }

   /**
   * Get arxiuRequiredParameters
   * @return arxiuRequiredParameters
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ARXIU_REQUIRED_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleArxiuRequiredParameters getArxiuRequiredParameters() {
    return arxiuRequiredParameters;
  }


  @JsonProperty(JSON_PROPERTY_ARXIU_REQUIRED_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArxiuRequiredParameters(MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters) {
    this.arxiuRequiredParameters = arxiuRequiredParameters;
  }


  public MassiveScanWebSimpleSubtransactionResult arxiuOptionalParameters(MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters) {
    
    this.arxiuOptionalParameters = arxiuOptionalParameters;
    return this;
  }

   /**
   * Get arxiuOptionalParameters
   * @return arxiuOptionalParameters
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ARXIU_OPTIONAL_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleArxiuOptionalParameters getArxiuOptionalParameters() {
    return arxiuOptionalParameters;
  }


  @JsonProperty(JSON_PROPERTY_ARXIU_OPTIONAL_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArxiuOptionalParameters(MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters) {
    this.arxiuOptionalParameters = arxiuOptionalParameters;
  }


  public MassiveScanWebSimpleSubtransactionResult additionalMetadatas(List<MassiveScanWebSimpleKeyValue> additionalMetadatas) {
    
    this.additionalMetadatas = additionalMetadatas;
    return this;
  }

  public MassiveScanWebSimpleSubtransactionResult addAdditionalMetadatasItem(MassiveScanWebSimpleKeyValue additionalMetadatasItem) {
    if (this.additionalMetadatas == null) {
      this.additionalMetadatas = new ArrayList<>();
    }
    this.additionalMetadatas.add(additionalMetadatasItem);
    return this;
  }

   /**
   * Get additionalMetadatas
   * @return additionalMetadatas
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_METADATAS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MassiveScanWebSimpleKeyValue> getAdditionalMetadatas() {
    return additionalMetadatas;
  }


  @JsonProperty(JSON_PROPERTY_ADDITIONAL_METADATAS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdditionalMetadatas(List<MassiveScanWebSimpleKeyValue> additionalMetadatas) {
    this.additionalMetadatas = additionalMetadatas;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleSubtransactionResult massiveScanWebSimpleSubtransactionResult = (MassiveScanWebSimpleSubtransactionResult) o;
    return Objects.equals(this.transactionID, massiveScanWebSimpleSubtransactionResult.transactionID) &&
        Objects.equals(this.transactionWebID, massiveScanWebSimpleSubtransactionResult.transactionWebID) &&
        Objects.equals(this.status, massiveScanWebSimpleSubtransactionResult.status) &&
        Objects.equals(this.scannedFile, massiveScanWebSimpleSubtransactionResult.scannedFile) &&
        Objects.equals(this.scannedFileInfo, massiveScanWebSimpleSubtransactionResult.scannedFileInfo) &&
        Objects.equals(this.signedFile, massiveScanWebSimpleSubtransactionResult.signedFile) &&
        Objects.equals(this.detachedSignatureFile, massiveScanWebSimpleSubtransactionResult.detachedSignatureFile) &&
        Objects.equals(this.signedFileInfo, massiveScanWebSimpleSubtransactionResult.signedFileInfo) &&
        Objects.equals(this.custodyInfo, massiveScanWebSimpleSubtransactionResult.custodyInfo) &&
        Objects.equals(this.arxiuInfo, massiveScanWebSimpleSubtransactionResult.arxiuInfo) &&
        Objects.equals(this.arxiuRequiredParameters, massiveScanWebSimpleSubtransactionResult.arxiuRequiredParameters) &&
        Objects.equals(this.arxiuOptionalParameters, massiveScanWebSimpleSubtransactionResult.arxiuOptionalParameters) &&
        Objects.equals(this.additionalMetadatas, massiveScanWebSimpleSubtransactionResult.additionalMetadatas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionID, transactionWebID, status, scannedFile, scannedFileInfo, signedFile, detachedSignatureFile, signedFileInfo, custodyInfo, arxiuInfo, arxiuRequiredParameters, arxiuOptionalParameters, additionalMetadatas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleSubtransactionResult {\n");
    sb.append("    transactionID: ").append(toIndentedString(transactionID)).append("\n");
    sb.append("    transactionWebID: ").append(toIndentedString(transactionWebID)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    scannedFile: ").append(toIndentedString(scannedFile)).append("\n");
    sb.append("    scannedFileInfo: ").append(toIndentedString(scannedFileInfo)).append("\n");
    sb.append("    signedFile: ").append(toIndentedString(signedFile)).append("\n");
    sb.append("    detachedSignatureFile: ").append(toIndentedString(detachedSignatureFile)).append("\n");
    sb.append("    signedFileInfo: ").append(toIndentedString(signedFileInfo)).append("\n");
    sb.append("    custodyInfo: ").append(toIndentedString(custodyInfo)).append("\n");
    sb.append("    arxiuInfo: ").append(toIndentedString(arxiuInfo)).append("\n");
    sb.append("    arxiuRequiredParameters: ").append(toIndentedString(arxiuRequiredParameters)).append("\n");
    sb.append("    arxiuOptionalParameters: ").append(toIndentedString(arxiuOptionalParameters)).append("\n");
    sb.append("    additionalMetadatas: ").append(toIndentedString(additionalMetadatas)).append("\n");
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

