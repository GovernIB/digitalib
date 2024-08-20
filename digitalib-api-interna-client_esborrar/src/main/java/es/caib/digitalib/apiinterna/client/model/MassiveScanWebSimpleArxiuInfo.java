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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MassiveScanWebSimpleArxiuInfo
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_CSV,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_ORIGINAL_FILE_U_R_L,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_PRINTABLE_FILE_U_R_L,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_ENI_FILE_U_R_L,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_CSV_VALIDATION_WEB,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_CSV_GENERATION_DEFINITION,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_VALIDATION_FILE_URL,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_EXPEDIENT_I_D,
  MassiveScanWebSimpleArxiuInfo.JSON_PROPERTY_DOCUMENT_I_D
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.4.0")
public class MassiveScanWebSimpleArxiuInfo {
  public static final String JSON_PROPERTY_CSV = "csv";
  private String csv;

  public static final String JSON_PROPERTY_ORIGINAL_FILE_U_R_L = "originalFileURL";
  private String originalFileURL;

  public static final String JSON_PROPERTY_PRINTABLE_FILE_U_R_L = "printableFileURL";
  private String printableFileURL;

  public static final String JSON_PROPERTY_ENI_FILE_U_R_L = "eniFileURL";
  private String eniFileURL;

  public static final String JSON_PROPERTY_CSV_VALIDATION_WEB = "csvValidationWeb";
  private String csvValidationWeb;

  public static final String JSON_PROPERTY_CSV_GENERATION_DEFINITION = "csvGenerationDefinition";
  private String csvGenerationDefinition;

  public static final String JSON_PROPERTY_VALIDATION_FILE_URL = "validationFileUrl";
  private String validationFileUrl;

  public static final String JSON_PROPERTY_EXPEDIENT_I_D = "expedientID";
  private String expedientID;

  public static final String JSON_PROPERTY_DOCUMENT_I_D = "documentID";
  private String documentID;

  public MassiveScanWebSimpleArxiuInfo() {
  }

  public MassiveScanWebSimpleArxiuInfo csv(String csv) {
    
    this.csv = csv;
    return this;
  }

   /**
   * Get csv
   * @return csv
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CSV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCsv() {
    return csv;
  }


  @JsonProperty(JSON_PROPERTY_CSV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCsv(String csv) {
    this.csv = csv;
  }


  public MassiveScanWebSimpleArxiuInfo originalFileURL(String originalFileURL) {
    
    this.originalFileURL = originalFileURL;
    return this;
  }

   /**
   * Get originalFileURL
   * @return originalFileURL
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ORIGINAL_FILE_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOriginalFileURL() {
    return originalFileURL;
  }


  @JsonProperty(JSON_PROPERTY_ORIGINAL_FILE_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOriginalFileURL(String originalFileURL) {
    this.originalFileURL = originalFileURL;
  }


  public MassiveScanWebSimpleArxiuInfo printableFileURL(String printableFileURL) {
    
    this.printableFileURL = printableFileURL;
    return this;
  }

   /**
   * Get printableFileURL
   * @return printableFileURL
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PRINTABLE_FILE_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPrintableFileURL() {
    return printableFileURL;
  }


  @JsonProperty(JSON_PROPERTY_PRINTABLE_FILE_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrintableFileURL(String printableFileURL) {
    this.printableFileURL = printableFileURL;
  }


  public MassiveScanWebSimpleArxiuInfo eniFileURL(String eniFileURL) {
    
    this.eniFileURL = eniFileURL;
    return this;
  }

   /**
   * Get eniFileURL
   * @return eniFileURL
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENI_FILE_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEniFileURL() {
    return eniFileURL;
  }


  @JsonProperty(JSON_PROPERTY_ENI_FILE_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEniFileURL(String eniFileURL) {
    this.eniFileURL = eniFileURL;
  }


  public MassiveScanWebSimpleArxiuInfo csvValidationWeb(String csvValidationWeb) {
    
    this.csvValidationWeb = csvValidationWeb;
    return this;
  }

   /**
   * Get csvValidationWeb
   * @return csvValidationWeb
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CSV_VALIDATION_WEB)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCsvValidationWeb() {
    return csvValidationWeb;
  }


  @JsonProperty(JSON_PROPERTY_CSV_VALIDATION_WEB)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCsvValidationWeb(String csvValidationWeb) {
    this.csvValidationWeb = csvValidationWeb;
  }


  public MassiveScanWebSimpleArxiuInfo csvGenerationDefinition(String csvGenerationDefinition) {
    
    this.csvGenerationDefinition = csvGenerationDefinition;
    return this;
  }

   /**
   * Get csvGenerationDefinition
   * @return csvGenerationDefinition
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CSV_GENERATION_DEFINITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCsvGenerationDefinition() {
    return csvGenerationDefinition;
  }


  @JsonProperty(JSON_PROPERTY_CSV_GENERATION_DEFINITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCsvGenerationDefinition(String csvGenerationDefinition) {
    this.csvGenerationDefinition = csvGenerationDefinition;
  }


  public MassiveScanWebSimpleArxiuInfo validationFileUrl(String validationFileUrl) {
    
    this.validationFileUrl = validationFileUrl;
    return this;
  }

   /**
   * Get validationFileUrl
   * @return validationFileUrl
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALIDATION_FILE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValidationFileUrl() {
    return validationFileUrl;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATION_FILE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidationFileUrl(String validationFileUrl) {
    this.validationFileUrl = validationFileUrl;
  }


  public MassiveScanWebSimpleArxiuInfo expedientID(String expedientID) {
    
    this.expedientID = expedientID;
    return this;
  }

   /**
   * Get expedientID
   * @return expedientID
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXPEDIENT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExpedientID() {
    return expedientID;
  }


  @JsonProperty(JSON_PROPERTY_EXPEDIENT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpedientID(String expedientID) {
    this.expedientID = expedientID;
  }


  public MassiveScanWebSimpleArxiuInfo documentID(String documentID) {
    
    this.documentID = documentID;
    return this;
  }

   /**
   * Get documentID
   * @return documentID
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DOCUMENT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDocumentID() {
    return documentID;
  }


  @JsonProperty(JSON_PROPERTY_DOCUMENT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocumentID(String documentID) {
    this.documentID = documentID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleArxiuInfo massiveScanWebSimpleArxiuInfo = (MassiveScanWebSimpleArxiuInfo) o;
    return Objects.equals(this.csv, massiveScanWebSimpleArxiuInfo.csv) &&
        Objects.equals(this.originalFileURL, massiveScanWebSimpleArxiuInfo.originalFileURL) &&
        Objects.equals(this.printableFileURL, massiveScanWebSimpleArxiuInfo.printableFileURL) &&
        Objects.equals(this.eniFileURL, massiveScanWebSimpleArxiuInfo.eniFileURL) &&
        Objects.equals(this.csvValidationWeb, massiveScanWebSimpleArxiuInfo.csvValidationWeb) &&
        Objects.equals(this.csvGenerationDefinition, massiveScanWebSimpleArxiuInfo.csvGenerationDefinition) &&
        Objects.equals(this.validationFileUrl, massiveScanWebSimpleArxiuInfo.validationFileUrl) &&
        Objects.equals(this.expedientID, massiveScanWebSimpleArxiuInfo.expedientID) &&
        Objects.equals(this.documentID, massiveScanWebSimpleArxiuInfo.documentID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(csv, originalFileURL, printableFileURL, eniFileURL, csvValidationWeb, csvGenerationDefinition, validationFileUrl, expedientID, documentID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleArxiuInfo {\n");
    sb.append("    csv: ").append(toIndentedString(csv)).append("\n");
    sb.append("    originalFileURL: ").append(toIndentedString(originalFileURL)).append("\n");
    sb.append("    printableFileURL: ").append(toIndentedString(printableFileURL)).append("\n");
    sb.append("    eniFileURL: ").append(toIndentedString(eniFileURL)).append("\n");
    sb.append("    csvValidationWeb: ").append(toIndentedString(csvValidationWeb)).append("\n");
    sb.append("    csvGenerationDefinition: ").append(toIndentedString(csvGenerationDefinition)).append("\n");
    sb.append("    validationFileUrl: ").append(toIndentedString(validationFileUrl)).append("\n");
    sb.append("    expedientID: ").append(toIndentedString(expedientID)).append("\n");
    sb.append("    documentID: ").append(toIndentedString(documentID)).append("\n");
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
