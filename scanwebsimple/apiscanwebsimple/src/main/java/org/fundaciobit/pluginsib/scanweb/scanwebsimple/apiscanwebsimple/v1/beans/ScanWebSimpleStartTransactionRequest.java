package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
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
