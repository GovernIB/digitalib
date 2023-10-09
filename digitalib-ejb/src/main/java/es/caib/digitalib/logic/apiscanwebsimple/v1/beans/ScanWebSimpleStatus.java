package es.caib.digitalib.logic.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleStatus {

  public static final int STATUS_REQUESTED_ID = 0;

  public static final int STATUS_IN_PROGRESS = 1;

  public static final int STATUS_FINAL_OK = 2;

  public static final int STATUS_FINAL_ERROR = -1;

  public static final int STATUS_CANCELLED = -2;
  
  public static final int STATUS_EXPIRED = -3;

  protected int status = STATUS_REQUESTED_ID;


  protected String errorMessage;


  protected String errorStackTrace;

  /**
   * 
   */
  public ScanWebSimpleStatus() {
    super();
  }

  /**
   * @param status
   * @param errorMessage
   * @param errorStackTrace
   */
  public ScanWebSimpleStatus(int status, String errorMessage, String errorStackTrace) {
    super();
    this.status = status;
    this.errorMessage = errorMessage;
    this.errorStackTrace = errorStackTrace;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorStackTrace() {
    return errorStackTrace;
  }

  public void setErrorStackTrace(String errorStackTrace) {
    this.errorStackTrace = errorStackTrace;
  }

}
