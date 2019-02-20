package org.fundaciobit.apisib.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleStartTransactionRequest {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String transactionID;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String returnUrl;

  /**
   * 
   */
  public ScanWebSimpleStartTransactionRequest() {
    super();
  }

  /**
   * @param transactionID
   * @param fileInfoSignatureArray
   */
  public ScanWebSimpleStartTransactionRequest(String transactionID, String returnUrl) {
    this.transactionID = transactionID;
    this.returnUrl = returnUrl;
  }

  public String getReturnUrl() {
    return returnUrl;
  }

  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }

}
