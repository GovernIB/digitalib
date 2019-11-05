package org.fundaciobit.apisib.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Resultat d'un Escaneig o Copia Autentica
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleScanResult {

  protected long transactionID;

  protected String transactionWebID;

  protected ScanWebSimpleStatus status;

  protected ScanWebSimpleFormMetadatas formMetadatas;

  protected ScanWebSimpleFile scannedFile;

  protected ScanWebSimpleScannedFileInfo scannedFileInfo;

  protected ScanWebSimpleFile signedFile;

  protected ScanWebSimpleFile detachedSignatureFile;

  protected ScanWebSimpleSignedFileInfo signedFileInfo;

  /**
   * Informacio de Plugin de Custòdia
   */
  protected ScanWebSimpleCustodyInfo custodyInfo = null;

  /**
   * Informació de Plugin d'Arxiu
   */
  protected ScanWebSimpleArxiuInfo arxiuInfo = null;

  /**
   * 
   */
  public ScanWebSimpleScanResult() {
    super();
  }

  public ScanWebSimpleScanResult(long transactionID, String transactionWebID,
      ScanWebSimpleStatus status) {
    super();
    this.transactionID = transactionID;
    this.transactionWebID = transactionWebID;
    this.status = status;
  }

  public ScanWebSimpleScanResult(long transactionID, String transactionWebID,
      ScanWebSimpleStatus status, ScanWebSimpleFormMetadatas formMetadatas,
      ScanWebSimpleFile scannedFile, ScanWebSimpleScannedFileInfo scannedFileInfo,
      ScanWebSimpleFile signedFile, ScanWebSimpleFile detachedSignatureFile,
      ScanWebSimpleSignedFileInfo signedFileInfo, ScanWebSimpleCustodyInfo custodyInfo,
      ScanWebSimpleArxiuInfo arxiuInfo) {
    super();
    this.transactionID = transactionID;
    this.transactionWebID = transactionWebID;
    this.status = status;
    this.formMetadatas = formMetadatas;
    this.scannedFile = scannedFile;
    this.scannedFileInfo = scannedFileInfo;
    this.signedFile = signedFile;
    this.detachedSignatureFile = detachedSignatureFile;
    this.signedFileInfo = signedFileInfo;
    this.custodyInfo = custodyInfo;
    this.arxiuInfo = arxiuInfo;
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

  public ScanWebSimpleArxiuInfo getArxiuInfo() {
    return arxiuInfo;
  }

  public void setArxiuInfo(ScanWebSimpleArxiuInfo arxiuInfo) {
    this.arxiuInfo = arxiuInfo;
  }

  public long getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(long transactionID) {
    this.transactionID = transactionID;
  }

  public String getTransactionWebID() {
    return transactionWebID;
  }

  public void setTransactionWebID(String transactionWebID) {
    this.transactionWebID = transactionWebID;
  }

  public ScanWebSimpleFormMetadatas getFormMetadatas() {
    return formMetadatas;
  }

  public void setFormMetadatas(ScanWebSimpleFormMetadatas formMetadatas) {
    this.formMetadatas = formMetadatas;
  }

  public ScanWebSimpleFile getSignedFile() {
    return signedFile;
  }

  public void setSignedFile(ScanWebSimpleFile signedFile) {
    this.signedFile = signedFile;
  }

  public static String toString(ScanWebSimpleScanResult result) {

    StringBuffer str = new StringBuffer();

    str.append("\n").append("====== SCANWEB =====");

    str.append("\n").append(" * TransactionID: " + result.getTransactionID());
    str.append("\n").append(" * TransactionWebID: " + result.getTransactionWebID());

    int status = result.getStatus().getStatus();
    String statusStr;
    switch (status) {
      case ScanWebSimpleStatus.STATUS_REQUESTED_ID:
        statusStr = "REQUESTED_ID";
      break;

      case ScanWebSimpleStatus.STATUS_IN_PROGRESS:
        statusStr = "";
      break;

      case ScanWebSimpleStatus.STATUS_FINAL_OK:
        statusStr = "FINAL_OK";
      break;

      default:
      case ScanWebSimpleStatus.STATUS_FINAL_ERROR:
        statusStr = "ERROR => " + result.getStatus().getErrorMessage();
      break;

      case ScanWebSimpleStatus.STATUS_CANCELLED:
        statusStr = "CANCELLED => " + result.getStatus().getErrorMessage();
      break;

      case ScanWebSimpleStatus.STATUS_EXPIRED:
        statusStr = "EXPIRED";
      break;

    }
    str.append("\n").append(" * Estat: ").append(statusStr);

    if (status != ScanWebSimpleStatus.STATUS_FINAL_OK) {
      return str.toString();
    }

    // Form metadatas
    str.append("\n").append(ScanWebSimpleFormMetadatas.toString(result.getFormMetadatas()));

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

    // ARXIU i CUSTODIA
    ScanWebSimpleCustodyInfo custody = result.getCustodyInfo();

    if (custody != null) {

      str.append("\n").append("  + CUSTODIA:");
      str.append("\n").append("      * custodyFileID: " + custody.getCustodyID());
      str.append("\n").append("      * CSV: " + custody.getCsv());
      str.append("\n").append("      * getCsvValidationWeb: " + custody.getCsvValidationWeb());
      str.append("\n").append(
          "      * getCsvGenerationDefinition: " + custody.getCsvGenerationDefinition());
      str.append("\n").append("      * OriginalFileURL: " + custody.getOriginalFileURL());
      str.append("\n").append("      * PrintableFileURL: " + custody.getPrintableFileURL());
      str.append("\n").append("      * ENIFileURL: " + custody.getEniFileURL());
      str.append("\n").append("      * ValidationFileUrl: " + custody.getValidationFileUrl());

    }

    ScanWebSimpleArxiuInfo arxiu = result.getArxiuInfo();

    if (arxiu != null) {
      str.append("\n").append("  + ARXIU:");

      str.append("\n").append("      * expedientID: " + arxiu.getExpedientID());
      str.append("\n").append("      * documentID: " + arxiu.getDocumentID());
      str.append("\n").append("      * CSV: " + arxiu.getCsv());
      str.append("\n").append("      * getCsvValidationWeb: " + arxiu.getCsvValidationWeb());
      str.append("\n").append(
          "      * getCsvGenerationDefinition: " + arxiu.getCsvGenerationDefinition());
      str.append("\n").append("      * OriginalFileURL: " + arxiu.getOriginalFileURL());
      str.append("\n").append("      * PrintableFileURL: " + arxiu.getPrintableFileURL());
      str.append("\n").append("      * ENIFileURL: " + arxiu.getEniFileURL());
      str.append("\n").append("      * ValidationFileUrl: " + arxiu.getValidationFileUrl());
    }

    return str.toString();

  }
}
