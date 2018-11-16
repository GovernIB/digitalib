package es.caib.digitalib.utils;


/**
 *
 * @author anadal
 *
 */
public interface Constants {

  public static final String DIGITALIB_PROPERTY_BASE = "es.caib.digitalib.";

  public static final String SECURITY_DOMAIN = "seycon";

  public static final String MAIL_SERVICE = "java:/es.caib.digitalib.mail";

  public static final String MAIL_QUEUE = "jms/DigitalIBMailsQueue";
  
  public static final String DIB_ADMIN = "DIB_ADMIN";

  public static final String DIB_USER = "DIB_USER";
  
  // ROLE ADMIN 
  public static final String ROLE_ADMIN = "ROLE_ADMIN";
  // ROLE USER
  public static final String ROLE_USER = "ROLE_USER"; 
  
  
  
  public static final int TIPUS_PLUGIN_SCANWEB = 0;
  
  public static final int TIPUS_PLUGIN_FIRMA_EN_SERVIDOR = 1;
  
  public static final int TIPUS_PLUGIN_DOCUMENT_CUSTODY = 2;
  
  public static final int TIPUS_PLUGIN_ARXIU = 3;
  
  
  public static final int TIPUS_CUSTODIA_SENSE = 0;
  public static final int TIPUS_CUSTODIA_ARXIU = 1;
  public static final int TIPUS_CUSTODIA_DOCUMENTCUSTODY = 2;
  
  public static final int TIPUS_FIRMA_EN_SERVIDOR_SENSE = 0;
  public static final int TIPUS_FIRMA_EN_SERVIDOR_PLUGIN = 1;
  public static final int TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE = 2;
  
  public static final int[] TIPUS_FIRMA_EN_SERVIDOR = {
    TIPUS_FIRMA_EN_SERVIDOR_SENSE,
    TIPUS_FIRMA_EN_SERVIDOR_PLUGIN,
    TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE
  };

}
