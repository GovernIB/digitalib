package org.fundaciobit.apisib.apimassivescanwebsimple.v1.exceptions;

/**
 * 
 * @author anadal
 *
 */
public abstract class AbstractScanWebSimpleException extends Exception {

  protected String description = null;

  /**
   * 
   */
  public AbstractScanWebSimpleException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public AbstractScanWebSimpleException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @param message
   */
  public AbstractScanWebSimpleException(String message) {
    super(message);
  }

  /**
   * @param message
   */
  public AbstractScanWebSimpleException(String message, String description) {
    super(message);
    this.description = description;
  }

  /**
   * @param cause
   */
  public AbstractScanWebSimpleException(Throwable cause) {
    super(cause);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String toString() {
    String msg = super.toString();

    if (this.description != null) {
      msg = msg + "\n" + this.description;
    }

    return msg;

  }

}
