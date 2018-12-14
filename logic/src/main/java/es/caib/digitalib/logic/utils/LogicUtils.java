package es.caib.digitalib.logic.utils;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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
  
  
  public static  String listToString(List<String> list) {

    String interessats;
    if (list != null && list.size() != 0) {
      interessats = list.toString().replace("[", "").replace("]", "")
          .replace(", ", ",");
    } else {
      interessats = null;
    }
    return interessats;
  }
  
  
  public static List<String> stringToListString(String listStr) {

    List<String> list;
    if (listStr != null && listStr.trim().length() != 0) {
       String[] values = listStr.split(",");
       list = new ArrayList<String>(Arrays.asList(values));
    } else {
      list = null;
    }
    
   return list;
  }

  public static Properties stringToProperties(String propertiesStr) {
    Properties prop = new Properties();
    if (propertiesStr != null && propertiesStr.trim().length() != 0) {
      try {
        prop.load(new StringReader(propertiesStr));
      } catch (Exception e) {
        // TODO Crec que no es cridarà mai
        e.printStackTrace();
      }
    }
    return prop;
  }
  
}
