package es.caib.digitalib.logic.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.versio.Versio;


/**
 * 
 * @author anadal
 *
 */
public class LogicUtils {

  protected static Logger log = Logger.getLogger(LogicUtils.class);
  
  
  public static String getVersio() {
    return Versio.VERSIO + (Configuracio.isCAIB()?"-caib" : "");
  }

  public static String exceptionToString(Throwable th) {
    String sStackTrace = null;
    if (th != null) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      th.printStackTrace(pw);
      sStackTrace = sw.toString();
    }
    return sStackTrace;
  }

  
}
