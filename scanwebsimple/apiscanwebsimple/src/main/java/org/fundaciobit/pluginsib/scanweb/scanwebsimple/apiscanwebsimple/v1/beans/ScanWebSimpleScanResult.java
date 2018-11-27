package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Resultat d'un Escaneig o Copia Autentica
 * 
 * @author anadal
 *
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ScanWebSimpleScanResult {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected ScanWebSimpleStatus status;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected ScanWebSimpleFile scannedFile;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected ScanWebSimpleFile detachedSignatureFile;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected ScanWebSimpleScannedFileInfo scannedFileInfo;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected ScanWebSimpleSignedFileInfo signedFileInfo;

  /**
   * Informacio de Custòdia
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected ScanWebSimpleCustodyInfo custodyInfo = null;

  /**
   * 
   */
  public ScanWebSimpleScanResult() {
    super();
  }

  public ScanWebSimpleScanResult(ScanWebSimpleStatus status, ScanWebSimpleFile scannedFile,
      ScanWebSimpleScannedFileInfo scannedFileInfo,
      ScanWebSimpleSignedFileInfo signedFileInfo, ScanWebSimpleCustodyInfo custodyInfo) {
    super();
    this.status = status;
    this.scannedFile = scannedFile;
    this.scannedFileInfo = scannedFileInfo;
    this.signedFileInfo = signedFileInfo;
    this.custodyInfo = custodyInfo;
  }

  public ScanWebSimpleScanResult(ScanWebSimpleStatus status, ScanWebSimpleFile scannedFile,
      ScanWebSimpleFile detachedSignatureFile, ScanWebSimpleScannedFileInfo scannedFileInfo,
      ScanWebSimpleSignedFileInfo signedFileInfo, ScanWebSimpleCustodyInfo custodyInfo) {
    super();
    this.status = status;
    this.scannedFile = scannedFile;
    this.detachedSignatureFile = detachedSignatureFile;
    this.scannedFileInfo = scannedFileInfo;
    this.signedFileInfo = signedFileInfo;
    this.custodyInfo = custodyInfo;
  }

  public ScanWebSimpleStatus getStatus() {
    return status;
  }

  public void setStatus(ScanWebSimpleStatus status) {
    this.status = status;
  }

  public ScanWebSimpleFile getScannedFile() {
    return scannedFile;
  }

  public void setScannedFile(ScanWebSimpleFile scannedFile) {
    this.scannedFile = scannedFile;
  }

  public ScanWebSimpleScannedFileInfo getScannedFileInfo() {
    return scannedFileInfo;
  }

  public void setScannedFileInfo(ScanWebSimpleScannedFileInfo scannedFileInfo) {
    this.scannedFileInfo = scannedFileInfo;
  }

  public ScanWebSimpleSignedFileInfo getSignedFileInfo() {
    return signedFileInfo;
  }

  public void setSignedFileInfo(ScanWebSimpleSignedFileInfo signedFileInfo) {
    this.signedFileInfo = signedFileInfo;
  }

  public ScanWebSimpleCustodyInfo getCustodyInfo() {
    return custodyInfo;
  }

  public void setCustodyInfo(ScanWebSimpleCustodyInfo custodyInfo) {
    this.custodyInfo = custodyInfo;
  }

  public ScanWebSimpleFile getDetachedSignatureFile() {
    return detachedSignatureFile;
  }

  public void setDetachedSignatureFile(ScanWebSimpleFile detachedSignatureFile) {
    this.detachedSignatureFile = detachedSignatureFile;
  }

  public static String toString(ScanWebSimpleScanResult result) {

    StringBuffer str = new StringBuffer();

    str.append("\n").append("====== SCANWEB =====");
    // Escaneig
    ScanWebSimpleScannedFileInfo scannedFileInfo = result.getScannedFileInfo();
    str.append("\n").append("  + SCANINFO:");

    str.append("\n").append("      * FormatFile: " + scannedFileInfo.getFormatFile());

    String pixelType;

    if (scannedFileInfo.getPixelType() != null) {

      switch (scannedFileInfo.getPixelType()) {

      case ScanWebSimpleScannedFileInfo.PIXEL_TYPE_BLACK_WHITE:
        pixelType = "B&W";
        break;
      case ScanWebSimpleScannedFileInfo.PIXEL_TYPE_GRAY:
        pixelType = "Gris";
        break;
      case ScanWebSimpleScannedFileInfo.PIXEL_TYPE_COLOR:
        pixelType = "Color";
        break;
      default:
        pixelType = "--DESCONEGUT--";

      }
    } else {
      pixelType = "--NO DEFINIT--";
    }

    str.append("\n").append("      * PixelType: " + pixelType);
    str.append("\n").append("      * Resolució(PPP): " + scannedFileInfo.getPppResolution());
    str.append("\n").append("      * OCR: " + scannedFileInfo.getOcr());

    // Signatura
    str.append("\n").append(ScanWebSimpleSignedFileInfo.toString(result.getSignedFileInfo()));

    ScanWebSimpleCustodyInfo custody = result.getCustodyInfo();

    if (custody != null) {

      str.append("\n").append("  + CUSTODIA:");
      str.append("\n").append("      * custodyFileID: " + custody.getCustodyFileID());
      str.append("\n").append("      * custodyFileURL: " + custody.getCustodyFileURL());
      str.append("\n").append("      * custodyFileCSV: " + custody.getCustodyFileCSV());
      str.append("\n").append(
          "      * custodyFileCSVValidationWeb: " + custody.getCustodyFileCSVValidationWeb());
      str.append("\n").append(
          "      * custodyFileCSVGenerationDefinition: "
              + custody.getCustodyFileCSVGenerationDefinition());
    }

    return str.toString();

  }

}
