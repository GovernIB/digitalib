package es.caib.digitalib.logic.utils;

import org.fundaciobit.pluginsib.scanweb.api.ScanWebRequest;
import org.fundaciobit.pluginsib.scanweb.api.ScanWebResult;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class ScanWebConfig {

  public final ScanWebRequest request;

  public ScanWebResult result;

  public ScanWebConfig(ScanWebRequest request) {
    super();
    this.request = request;
  }

  public ScanWebRequest getRequest() {
    return request;
  }

  public ScanWebResult getResult() {
    return result;
  }

  public void setResult(ScanWebResult result) {
    this.result = result;
  }

}
