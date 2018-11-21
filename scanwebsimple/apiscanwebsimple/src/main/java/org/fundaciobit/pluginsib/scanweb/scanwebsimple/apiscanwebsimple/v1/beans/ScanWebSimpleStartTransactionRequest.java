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

  public static final String VIEW_FULLSCREEN = "fullview";

  public static final String VIEW_IFRAME = "iframe";

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String transactionID;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String returnUrl;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String view;

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
  public ScanWebSimpleStartTransactionRequest(String transactionID, String returnUrl,
      String view) {

    this.transactionID = transactionID;
    this.returnUrl = returnUrl;
    this.view = view;
  }

  public String getReturnUrl() {
    return returnUrl;
  }

  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public String getView() {
    return view;
  }

  public void setView(String view) {
    this.view = view;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }

}
