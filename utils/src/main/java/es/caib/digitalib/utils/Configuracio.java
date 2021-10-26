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
        return System.getProperty(DIGITALIB_PROPERTY_BASE + "encryptkey", "0123456789123456")
                .getBytes();
    }

    public static Long getMaxUploadSizeInBytes() {
        return Long.getLong(DIGITALIB_PROPERTY_BASE + "maxuploadsizeinbytes");
    }

    public static String getPublicCsvUrl() {
        return System.getProperty(DIGITALIB_PROPERTY_BASE + "publiccsvurl");
    }

    public static Long getMaxSizeForScannedDocument() {
        String strVal = System
                .getProperty(DIGITALIB_PROPERTY_BASE + "maxsizeforscanneddocument");
        if (strVal == null || strVal.trim().length() == 0) {
            return null;
        } else {
            return Long.valueOf(strVal);
        }
    }

    public static String getSignReasonEL() {
        return System.getProperty(DIGITALIB_PROPERTY_BASE + "signreasonEL");
    }

    public static String getSignLocationEL() {
        return System.getProperty(DIGITALIB_PROPERTY_BASE + "signlocationEL");
    }

    public static String getSignerEmailEL() {
        return System.getProperty(DIGITALIB_PROPERTY_BASE + "signeremailEL");
    }

    /**
     * @return Si aquest valor és true, llavors: 
     * (1) No es permetrà l'edició del camp Dir3Codi de l'objecte Usuari-Persona 
     * (2) Durant l'inici d'una transacció via entorn web, s'utilitzaria el codi dir3 de la Configuració de Grup de la persona
     * 
     */
    public static boolean useDir3OfGroupConfiguration() {
        return Boolean.getBoolean(DIGITALIB_PROPERTY_BASE + "usedir3ofgroupconfiguration");
    }
    
    
    /**
     * Retorna el DIR3 per defecte a utilitzar quan es fan cridades des de l'API normal de DigitalIB,
     * ja que aquesta API no inclou el Funcionari DIR3.
     * @return
     */
    public static String getDefaultFuncionariDir3() {
        return System.getProperty(DIGITALIB_PROPERTY_BASE + "defaultfuncionaridir3");
    }

}
