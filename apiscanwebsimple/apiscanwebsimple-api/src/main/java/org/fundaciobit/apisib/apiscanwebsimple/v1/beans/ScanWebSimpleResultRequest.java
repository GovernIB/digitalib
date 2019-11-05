package org.fundaciobit.apisib.apiscanwebsimple.v1.beans;

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

  protected boolean returnScannedFile = true;

  protected boolean returnSignedFile = false;

  public ScanWebSimpleResultRequest() {
    super();
  }

  public ScanWebSimpleResultRequest(String transactionID, boolean returnScannedFile,
      boolean returnSignedFile) {
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

  public boolean isReturnScannedFile() {
    return returnScannedFile;
  }

  public void setReturnScannedFile(boolean returnScannedFile) {
    this.returnScannedFile = returnScannedFile;
  }

  public boolean isReturnSignedFile() {
    return returnSignedFile;
  }

  public void setReturnSignedFile(boolean returnSignedFile) {
    this.returnSignedFile = returnSignedFile;
  }

}
