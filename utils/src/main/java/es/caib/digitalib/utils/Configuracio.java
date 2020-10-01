package es.caib.digitalib.utils;

import java.io.File;

/**
 * 
 * @author anadal
 * 
 */
public class Configuracio implements Constants {
 
  public static boolean isCAIB() {
    return Boolean.getBoolean(DIGITALIB_PROPERTY_BASE + "iscaib");
  }

  public static File getFilesDirectory() {
    String path = System.getProperty(DIGITALIB_PROPERTY_BASE + "filesdirectory");
    return new File(path);
  }
  
  public static boolean isDesenvolupament() {
    return Boolean.getBoolean(DIGITALIB_PROPERTY_BASE + "development");
  }

  public static boolean isOcultarMenuInici() {
    return Boolean.getBoolean(DIGITALIB_PROPERTY_BASE + "ocultarmenuinici");
  }

  public static String getConfiguracioGrupPerDefecteEL() {
    return System.getProperty(DIGITALIB_PROPERTY_BASE + "configuraciogruppereefecteEL");
  }

  public static String getAppUrl() {
    return System.getProperty(DIGITALIB_PROPERTY_BASE + "url");
  }

  public static String getAppEmail() {
    return System.getProperty(DIGITALIB_PROPERTY_BASE + "email.from");
  }

  public static String getAppName() {
    return System.getProperty(DIGITALIB_PROPERTY_BASE + "name", "DigitalIB");
  }

  public static String getDefaultLanguage() {
    return System.getProperty(DIGITALIB_PROPERTY_BASE + "defaultlanguage", "ca");
  }

  public static byte[] getEncryptKey() {
    return System.getProperty(DIGITALIB_PROPERTY_BASE + "encryptkey", "0123456789123456").getBytes();
  }

  public static Long getMaxUploadSizeInBytes() {
    return Long.getLong(DIGITALIB_PROPERTY_BASE + "maxuploadsizeinbytes");
  }
  
  public static String getPublicCsvUrl() {
    return System.getProperty(DIGITALIB_PROPERTY_BASE + "publiccsvurl");
  }
  
  public static Long getMaxSizeForScannedDocument() {
    String strVal = System.getProperty(DIGITALIB_PROPERTY_BASE + "maxsizeforscanneddocument");
    if (strVal == null || strVal.trim().length() == 0) {
      return null;
    } else {
      return Long.valueOf(strVal);
    }
  }

}
