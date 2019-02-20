package org.fundaciobit.apisib.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Classe encarregada d'enviar excepcions des del servidor al client
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleError {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String message;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String type;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String stackTrace;

  /**
   * @param message
   */
  public ScanWebSimpleError() {
    super();
  }

  /**
   * @param message
   */
  public ScanWebSimpleError(String message, String type) {
    super();
    this.message = message;
    this.type = type;
  }

  /**
   * @param message
   * @param type
   * @param stackTrace
   */
  public ScanWebSimpleError(String message, String type, String stackTrace) {
    super();
    this.message = message;
    this.type = type;
    this.stackTrace = stackTrace;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStackTrace() {
    return stackTrace;
  }

  public void setStackTrace(String stackTrace) {
    this.stackTrace = stackTrace;
  }

}
