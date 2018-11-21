package es.caib.digitalib.logic.utils;

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

  
}
