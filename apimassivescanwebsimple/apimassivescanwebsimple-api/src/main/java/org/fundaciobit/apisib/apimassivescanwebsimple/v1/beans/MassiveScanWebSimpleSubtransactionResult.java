package org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans;

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
public class MassiveScanWebSimpleSubtransactionResult {

  protected long transactionID;

  protected String transactionWebID;

  protected MassiveScanWebSimpleStatus status;

  protected MassiveScanWebSimpleFormMetadatas formMetadatas;

  protected MassiveScanWebSimpleFile scannedFile;

  protected MassiveScanWebSimpleScannedFileInfo scannedFileInfo;

  protected MassiveScanWebSimpleFile signedFile;

  protected MassiveScanWebSimpleFile detachedSignatureFile;

  protected MassiveScanWebSimpleSignedFileInfo signedFileInfo;

  /**
   * Informacio de Plugin de Custòdia
   */
  protected MassiveScanWebSimpleCustodyInfo custodyInfo = null;

  /**
   * Informació de Plugin d'Arxiu
   */
  protected MassiveScanWebSimpleArxiuInfo arxiuInfo = null;

  /**
   * 
   */
  public MassiveScanWebSimpleSubtransactionResult() {
    super();
  }

  public MassiveScanWebSimpleSubtransactionResult(long transactionID, String transactionWebID,
      MassiveScanWebSimpleStatus status) {
    super();
    this.transactionID = transactionID;
    this.transactionWebID = transactionWebID;
    this.status = status;
  }

  public MassiveScanWebSimpleSubtransactionResult(long transactionID, String transactionWebID,
      MassiveScanWebSimpleStatus status, MassiveScanWebSimpleFormMetadatas formMetadatas,
      MassiveScanWebSimpleFile scannedFile, MassiveScanWebSimpleScannedFileInfo scannedFileInfo,
      MassiveScanWebSimpleFile signedFile, MassiveScanWebSimpleFile detachedSignatureFile,
      MassiveScanWebSimpleSignedFileInfo signedFileInfo, MassiveScanWebSimpleCustodyInfo custodyInfo,
      MassiveScanWebSimpleArxiuInfo arxiuInfo) {
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

  public MassiveScanWebSimpleStatus getStatus() {
    return status;
  }

  public void setStatus(MassiveScanWebSimpleStatus status) {
    this.status = status;
  }

  public MassiveScanWebSimpleFile getScannedFile() {
    return scannedFile;
  }

  public void setScannedFile(MassiveScanWebSimpleFile scannedFile) {
    this.scannedFile = scannedFile;
  }

  public MassiveScanWebSimpleScannedFileInfo getScannedFileInfo() {
    return scannedFileInfo;
  }

  public void setScannedFileInfo(MassiveScanWebSimpleScannedFileInfo scannedFileInfo) {
    this.scannedFileInfo = scannedFileInfo;
  }

  public MassiveScanWebSimpleSignedFileInfo getSignedFileInfo() {
    return signedFileInfo;
  }

  public void setSignedFileInfo(MassiveScanWebSimpleSignedFileInfo signedFileInfo) {
    this.signedFileInfo = signedFileInfo;
  }

  public MassiveScanWebSimpleCustodyInfo getCustodyInfo() {
    return custodyInfo;
  }

  public void setCustodyInfo(MassiveScanWebSimpleCustodyInfo custodyInfo) {
    this.custodyInfo = custodyInfo;
  }

  public MassiveScanWebSimpleFile getDetachedSignatureFile() {
    return detachedSignatureFile;
  }

  public void setDetachedSignatureFile(MassiveScanWebSimpleFile detachedSignatureFile) {
    this.detachedSignatureFile = detachedSignatureFile;
  }

  public MassiveScanWebSimpleArxiuInfo getArxiuInfo() {
    return arxiuInfo;
  }

  public void setArxiuInfo(MassiveScanWebSimpleArxiuInfo arxiuInfo) {
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

  public MassiveScanWebSimpleFormMetadatas getFormMetadatas() {
    return formMetadatas;
  }

  public void setFormMetadatas(MassiveScanWebSimpleFormMetadatas formMetadatas) {
    this.formMetadatas = formMetadatas;
  }

  public MassiveScanWebSimpleFile getSignedFile() {
    return signedFile;
  }

  public void setSignedFile(MassiveScanWebSimpleFile signedFile) {
    this.signedFile = signedFile;
  }

  public static String toString(MassiveScanWebSimpleSubtransactionResult result) {

    StringBuffer str = new StringBuffer();

    str.append("\n").append("====== SCANWEB =====");

    str.append("\n").append(" * TransactionID: " + result.getTransactionID());
    str.append("\n").append(" * TransactionWebID: " + result.getTransactionWebID());

    int status = result.getStatus().getStatus();
    String statusStr;
    switch (status) {
      case MassiveScanWebSimpleStatus.STATUS_REQUESTED_ID:
        statusStr = "REQUESTED_ID";
      break;

      case MassiveScanWebSimpleStatus.STATUS_IN_PROGRESS:
        statusStr = "";
      break;

      case MassiveScanWebSimpleStatus.STATUS_FINAL_OK:
        statusStr = "FINAL_OK";
      break;

      default:
      case MassiveScanWebSimpleStatus.STATUS_FINAL_ERROR:
        statusStr = "ERROR => " + result.getStatus().getErrorMessage();
      break;

      case MassiveScanWebSimpleStatus.STATUS_CANCELLED:
        statusStr = "CANCELLED => " + result.getStatus().getErrorMessage();
      break;

      case MassiveScanWebSimpleStatus.STATUS_EXPIRED:
        statusStr = "EXPIRED";
      break;

    }
    str.append("\n").append(" * Estat: ").append(statusStr);

    if (status != MassiveScanWebSimpleStatus.STATUS_FINAL_OK) {
      return str.toString();
    }

    // Form metadatas
    str.append("\n").append(MassiveScanWebSimpleFormMetadatas.toString(result.getFormMetadatas()));

    // Escaneig
    MassiveScanWebSimpleScannedFileInfo scannedFileInfo = result.getScannedFileInfo();
    str.append("\n").append("  + SCANINFO:");

    str.append("\n").append("      * FormatFile: " + scannedFileInfo.getFormatFile());

    String pixelType;

    if (scannedFileInfo.getPixelType() != null) {

      switch (scannedFileInfo.getPixelType()) {

        case MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_BLACK_WHITE:
          pixelType = "B&W";
        break;
        case MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_GRAY:
          pixelType = "Gris";
        break;
        case MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_COLOR:
          pixelType = "Color";
        break;
        default:
          pixelType = "--VALOR DESCONEGUT (" + scannedFileInfo.getPixelType() +  ")--";

      }
    } else {
      pixelType = "--NO DEFINIT--";
    }

    str.append("\n").append("      * PixelType: " + pixelType);
    str.append("\n").append("      * Resolució(PPP): " + scannedFileInfo.getPppResolution());
    str.append("\n").append("      * OCR: " + scannedFileInfo.getOcr());

    // Signatura
    str.append("\n").append(MassiveScanWebSimpleSignedFileInfo.toString(result.getSignedFileInfo()));

    // ARXIU i CUSTODIA
    MassiveScanWebSimpleCustodyInfo custody = result.getCustodyInfo();

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

    MassiveScanWebSimpleArxiuInfo arxiu = result.getArxiuInfo();

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
