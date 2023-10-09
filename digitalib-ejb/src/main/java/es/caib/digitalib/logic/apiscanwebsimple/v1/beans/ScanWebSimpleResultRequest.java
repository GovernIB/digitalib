package es.caib.digitalib.logic.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleResultRequest {

  protected String transactionID;

  protected Boolean returnScannedFile = null;

  protected Boolean returnSignedFile = null;

  public ScanWebSimpleResultRequest() {
    super();
  }

  
  
  public ScanWebSimpleResultRequest(String transactionID) {
    super();
    this.transactionID = transactionID;
  }



  public ScanWebSimpleResultRequest(String transactionID, Boolean returnScannedFile,
      Boolean returnSignedFile) {
    super();
    this.transactionID = transactionID;
    this.returnScannedFile = returnScannedFile;
    this.returnSignedFile = returnSignedFile;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }

  public Boolean isReturnScannedFile() {
    return returnScannedFile;
  }

  public void setReturnScannedFile(Boolean returnScannedFile) {
    this.returnScannedFile = returnScannedFile;
  }

  public Boolean isReturnSignedFile() {
    return returnSignedFile;
  }

  public void setReturnSignedFile(Boolean returnSignedFile) {
    this.returnSignedFile = returnSignedFile;
  }

}
