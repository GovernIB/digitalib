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
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MassiveScanWebSimpleScannedFileInfo
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_TRANSACTION_NAME,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_SCAN_DATE,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_PIXEL_TYPE,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_PPP_RESOLUTION,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_FORMAT_FILE,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_OCR,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_DUPLEX,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_PAPER_SIZE,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_DOCUMENT_LANGUAGE,
  MassiveScanWebSimpleScannedFileInfo.JSON_PROPERTY_DOCUMENT_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MassiveScanWebSimpleScannedFileInfo {
  public static final String JSON_PROPERTY_TRANSACTION_NAME = "transactionName";
  private String transactionName;

  public static final String JSON_PROPERTY_SCAN_DATE = "scanDate";
  private OffsetDateTime scanDate;

  public static final String JSON_PROPERTY_PIXEL_TYPE = "pixelType";
  private Integer pixelType;

  public static final String JSON_PROPERTY_PPP_RESOLUTION = "pppResolution";
  private Integer pppResolution;

  public static final String JSON_PROPERTY_FORMAT_FILE = "formatFile";
  private String formatFile;

  public static final String JSON_PROPERTY_OCR = "ocr";
  private Boolean ocr;

  public static final String JSON_PROPERTY_DUPLEX = "duplex";
  private Boolean duplex;

  public static final String JSON_PROPERTY_PAPER_SIZE = "paperSize";
  private String paperSize;

  public static final String JSON_PROPERTY_DOCUMENT_LANGUAGE = "documentLanguage";
  private String documentLanguage;

  public static final String JSON_PROPERTY_DOCUMENT_TYPE = "documentType";
  private String documentType;

  public MassiveScanWebSimpleScannedFileInfo() {
  }

  public MassiveScanWebSimpleScannedFileInfo transactionName(String transactionName) {
    
    this.transactionName = transactionName;
    return this;
  }

   /**
   * Get transactionName
   * @return transactionName
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRANSACTION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTransactionName() {
    return transactionName;
  }


  @JsonProperty(JSON_PROPERTY_TRANSACTION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }


  public MassiveScanWebSimpleScannedFileInfo scanDate(OffsetDateTime scanDate) {
    
    this.scanDate = scanDate;
    return this;
  }

   /**
   * Get scanDate
   * @return scanDate
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SCAN_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getScanDate() {
    return scanDate;
  }


  @JsonProperty(JSON_PROPERTY_SCAN_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScanDate(OffsetDateTime scanDate) {
    this.scanDate = scanDate;
  }


  public MassiveScanWebSimpleScannedFileInfo pixelType(Integer pixelType) {
    
    this.pixelType = pixelType;
    return this;
  }

   /**
   * Get pixelType
   * @return pixelType
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PIXEL_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPixelType() {
    return pixelType;
  }


  @JsonProperty(JSON_PROPERTY_PIXEL_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPixelType(Integer pixelType) {
    this.pixelType = pixelType;
  }


  public MassiveScanWebSimpleScannedFileInfo pppResolution(Integer pppResolution) {
    
    this.pppResolution = pppResolution;
    return this;
  }

   /**
   * Get pppResolution
   * @return pppResolution
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PPP_RESOLUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPppResolution() {
    return pppResolution;
  }


  @JsonProperty(JSON_PROPERTY_PPP_RESOLUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPppResolution(Integer pppResolution) {
    this.pppResolution = pppResolution;
  }


  public MassiveScanWebSimpleScannedFileInfo formatFile(String formatFile) {
    
    this.formatFile = formatFile;
    return this;
  }

   /**
   * Get formatFile
   * @return formatFile
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FORMAT_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFormatFile() {
    return formatFile;
  }


  @JsonProperty(JSON_PROPERTY_FORMAT_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFormatFile(String formatFile) {
    this.formatFile = formatFile;
  }


  public MassiveScanWebSimpleScannedFileInfo ocr(Boolean ocr) {
    
    this.ocr = ocr;
    return this;
  }

   /**
   * Get ocr
   * @return ocr
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_OCR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isOcr() {
    return ocr;
  }


  @JsonProperty(JSON_PROPERTY_OCR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOcr(Boolean ocr) {
    this.ocr = ocr;
  }


  public MassiveScanWebSimpleScannedFileInfo duplex(Boolean duplex) {
    
    this.duplex = duplex;
    return this;
  }

   /**
   * Get duplex
   * @return duplex
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DUPLEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isDuplex() {
    return duplex;
  }


  @JsonProperty(JSON_PROPERTY_DUPLEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDuplex(Boolean duplex) {
    this.duplex = duplex;
  }


  public MassiveScanWebSimpleScannedFileInfo paperSize(String paperSize) {
    
    this.paperSize = paperSize;
    return this;
  }

   /**
   * Get paperSize
   * @return paperSize
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAPER_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPaperSize() {
    return paperSize;
  }


  @JsonProperty(JSON_PROPERTY_PAPER_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaperSize(String paperSize) {
    this.paperSize = paperSize;
  }


  public MassiveScanWebSimpleScannedFileInfo documentLanguage(String documentLanguage) {
    
    this.documentLanguage = documentLanguage;
    return this;
  }

   /**
   * Get documentLanguage
   * @return documentLanguage
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DOCUMENT_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDocumentLanguage() {
    return documentLanguage;
  }


  @JsonProperty(JSON_PROPERTY_DOCUMENT_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocumentLanguage(String documentLanguage) {
    this.documentLanguage = documentLanguage;
  }


  public MassiveScanWebSimpleScannedFileInfo documentType(String documentType) {
    
    this.documentType = documentType;
    return this;
  }

   /**
   * Get documentType
   * @return documentType
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DOCUMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDocumentType() {
    return documentType;
  }


  @JsonProperty(JSON_PROPERTY_DOCUMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleScannedFileInfo massiveScanWebSimpleScannedFileInfo = (MassiveScanWebSimpleScannedFileInfo) o;
    return Objects.equals(this.transactionName, massiveScanWebSimpleScannedFileInfo.transactionName) &&
        Objects.equals(this.scanDate, massiveScanWebSimpleScannedFileInfo.scanDate) &&
        Objects.equals(this.pixelType, massiveScanWebSimpleScannedFileInfo.pixelType) &&
        Objects.equals(this.pppResolution, massiveScanWebSimpleScannedFileInfo.pppResolution) &&
        Objects.equals(this.formatFile, massiveScanWebSimpleScannedFileInfo.formatFile) &&
        Objects.equals(this.ocr, massiveScanWebSimpleScannedFileInfo.ocr) &&
        Objects.equals(this.duplex, massiveScanWebSimpleScannedFileInfo.duplex) &&
        Objects.equals(this.paperSize, massiveScanWebSimpleScannedFileInfo.paperSize) &&
        Objects.equals(this.documentLanguage, massiveScanWebSimpleScannedFileInfo.documentLanguage) &&
        Objects.equals(this.documentType, massiveScanWebSimpleScannedFileInfo.documentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionName, scanDate, pixelType, pppResolution, formatFile, ocr, duplex, paperSize, documentLanguage, documentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleScannedFileInfo {\n");
    sb.append("    transactionName: ").append(toIndentedString(transactionName)).append("\n");
    sb.append("    scanDate: ").append(toIndentedString(scanDate)).append("\n");
    sb.append("    pixelType: ").append(toIndentedString(pixelType)).append("\n");
    sb.append("    pppResolution: ").append(toIndentedString(pppResolution)).append("\n");
    sb.append("    formatFile: ").append(toIndentedString(formatFile)).append("\n");
    sb.append("    ocr: ").append(toIndentedString(ocr)).append("\n");
    sb.append("    duplex: ").append(toIndentedString(duplex)).append("\n");
    sb.append("    paperSize: ").append(toIndentedString(paperSize)).append("\n");
    sb.append("    documentLanguage: ").append(toIndentedString(documentLanguage)).append("\n");
    sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
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

