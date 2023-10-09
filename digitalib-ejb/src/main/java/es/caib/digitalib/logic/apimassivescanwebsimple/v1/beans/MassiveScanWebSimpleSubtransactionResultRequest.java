package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

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
public class MassiveScanWebSimpleSubtransactionResultRequest {
  
  protected String transactionID;

  protected String subtransactionID;

  protected Boolean returnScannedFile = null;

  protected Boolean returnSignedFile = null;

  public MassiveScanWebSimpleSubtransactionResultRequest() {
    super();
  }

  public MassiveScanWebSimpleSubtransactionResultRequest(String subtransactionID) {
    super();
    this.subtransactionID = subtransactionID;
  }

  public MassiveScanWebSimpleSubtransactionResultRequest(String subtransactionID, Boolean returnScannedFile,
      Boolean returnSignedFile) {
    super();
    this.subtransactionID = subtransactionID;
    this.returnScannedFile = returnScannedFile;
    this.returnSignedFile = returnSignedFile;
  }

  public String getSubtransactionID() {
    return subtransactionID;
  }

  public void setSubtransactionID(String subtransactionID) {
    this.subtransactionID = subtransactionID;
  }

  public Boolean getReturnScannedFile() {
    return returnScannedFile;
  }

  public void setReturnScannedFile(Boolean returnScannedFile) {
    this.returnScannedFile = returnScannedFile;
  }

  public Boolean getReturnSignedFile() {
    return returnSignedFile;
  }

  public void setReturnSignedFile(Boolean returnSignedFile) {
    this.returnSignedFile = returnSignedFile;
  }

}
