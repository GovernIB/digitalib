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

  public static final int VIEW_FULLSCREEN = 0; // "fullview";

  public static final int VIEW_IFRAME = 1; // "iframe";

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String transactionID;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String returnUrl;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected int view;

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
      int view) {

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

  public int getView() {
    return view;
  }

  public void setView(int view) {
    this.view = view;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }

}
