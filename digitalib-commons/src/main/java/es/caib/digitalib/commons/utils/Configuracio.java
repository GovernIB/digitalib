package es.caib.digitalib.commons.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

/**
 * 
 * @author GenApp
 * 
 */
public class Configuracio implements Constants {

    public static final Logger log = Logger.getLogger(Configuracio.class);

    private static Properties digitalibProperties;

    private static Properties digitalibSystemProperties;

    public static Properties getDigitalIBProperties() {
        if (digitalibProperties == null) {
            digitalibProperties = loadPropertiesFromKey(Constants.DIGITALIB_PROPERTY_BASE + "properties");
        }
        return digitalibProperties;
    }

    public static Properties getDigitalIBSystemProperties() {
        if (digitalibSystemProperties == null) {
            digitalibSystemProperties = loadPropertiesFromKey(Constants.DIGITALIB_PROPERTY_BASE + "system.properties");
        }
        return digitalibSystemProperties;
    }

    private static Properties loadPropertiesFromKey(String key) {
        String propertyFileName = System.getProperty(key);

        if (propertyFileName == null) {
            String msg = "No existeix la propietat: " + key
                    + " al fitxer standalone. S'hauria d'incloure aquesta propietat a l'etiqueta <system-properties> del fitxer standalone.";
            throw new RuntimeException(msg);
        }

        if (propertyFileName.trim().length() == 0) {
            String msg = "La propietat: " + key
                    + " del fitxer standalone no té valor. Se li ha de posar el fitxer corresponent a la propietat al fitxer standalone";
            throw new RuntimeException(msg);
        }

        File file = new File(propertyFileName);

        if (!file.exists()) {
            throw new RuntimeException("La propietat: " + key
                    + " del fitxer standalone apunta a un fitxer que no existeix (" + propertyFileName + ")");
        }

        try (Reader reader = new FileReader(file)) {
            Properties prop = new Properties();
            prop.load(reader);
            return prop;
        } catch (Exception e) {
            throw new RuntimeException("La propietat: " + key + " del fitxer standalone apunta a un fitxer("
                    + propertyFileName + ") que no es pot llegir:" + e.getMessage(), e);
        }
    }

    public static Properties getSystemAndFileProperties() {

        Properties properties = new Properties();
        properties.putAll(System.getProperties());
        properties.putAll(getDigitalIBSystemProperties());
        properties.putAll(getDigitalIBProperties());
        return properties;
    }

    public static Properties getAllFileProperties() {

        Properties properties = new Properties();
        properties.putAll(getDigitalIBSystemProperties());
        properties.putAll(getDigitalIBProperties());
        return properties;
    }

    public static String getProperty(String key) {

        return getAllFileProperties().getProperty(key);

    }

    public static String getProperty(String key, String def) {

        return getAllFileProperties().getProperty(key, def);

    }

    public static boolean isDesenvolupament() {

        return Boolean.parseBoolean(getProperty(DIGITALIB_PROPERTY_BASE + "development"));
    }

    public static boolean isCAIB() {
        return Boolean.parseBoolean(getProperty(DIGITALIB_PROPERTY_BASE + "iscaib"));
    }

    public static String getAppEmail() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "email.from");
    }

    public static String getAppName() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "name", "DigitalIB");
    }

    public static String getFrontUrl() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "url.front");
    }

    public static String getBackUrl() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "url.back");
    }

    public static String getDefaultLanguage() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "defaultlanguage", "ca");
    }

    public static byte[] getEncryptKey() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "encryptkey", "0123456789123456").getBytes();
    }

    public static Long getMaxUploadSizeInBytes() {
        return Long.getLong(DIGITALIB_PROPERTY_BASE + "maxuploadsizeinbytes");
    }

    public static Long getMaxFitxerAdaptatSizeInBytes() {
        return Long.getLong(DIGITALIB_PROPERTY_BASE + "maxfitxeradaptatsizeinbytes");
    }

    public static File getFilesDirectory() {
        String path = getDigitalIBSystemProperties().getProperty(DIGITALIB_PROPERTY_BASE + "filesdirectory");
        if (path == null) {
            throw new RuntimeException("No existeix la propietat '" + DIGITALIB_PROPERTY_BASE + "filesdirectory'"
                    + " al fitxer " + System.getProperty(DIGITALIB_PROPERTY_BASE + "system.properties")
                    + ". S'hauria d'anar al fitxer " + System.getProperty(DIGITALIB_PROPERTY_BASE + "system.properties")
                    + " i incloure la propietat '" + DIGITALIB_PROPERTY_BASE + "filesdirectory'"
                    + " amb una ruta al directori on l'aplició gestionara els fitxers.");
        }

        if (path.isEmpty()) {
            throw new RuntimeException("No s'ha definit la propietat '" + DIGITALIB_PROPERTY_BASE + "filesdirectory'"
                    + " al fitxer " + System.getProperty(DIGITALIB_PROPERTY_BASE + "system.properties")
                    + ". S'hauria d'anar al fitxer " + System.getProperty(DIGITALIB_PROPERTY_BASE + "system.properties")
                    + " i donar valor a la propietat '" + DIGITALIB_PROPERTY_BASE + "filesdirectory'"
                    + " amb una ruta al directori on l'aplició gestionara els fitxers.");
        }

        File filesFolder = new File(path);

        if (!filesFolder.exists()) {
            throw new RuntimeException("El directori indicat a la propietat '" + DIGITALIB_PROPERTY_BASE
                    + ".filesdirectory'" + " del fitxer "
                    + System.getProperty(DIGITALIB_PROPERTY_BASE + "system.properties")
                    + " no existeix. S'hauria de modificar la ruta indicada per la d'un directori existent, o crear un directori amb la ruta: "
                    + path);
        }

        if (!filesFolder.isDirectory()) {
            throw new RuntimeException("El directori indicat a la propietat '" + DIGITALIB_PROPERTY_BASE
                    + ".filesdirectory'" + " del fitxer "
                    + System.getProperty(DIGITALIB_PROPERTY_BASE + "system.properties")
                    + " no es un directori, probablement es tracti d'un fitxer. S'hauria de modificar la ruta indicada per la d'un directori existent.");
        }

        if (!filesFolder.canWrite()) {
            throw new RuntimeException("El directori indicat a la propietat '" + DIGITALIB_PROPERTY_BASE
                    + ".filesdirectory'" + " del fitxer "
                    + System.getProperty(DIGITALIB_PROPERTY_BASE + "system.properties")
                    + " es un directori sense permisos d'escriptura. S'haurien de donar permisos d'escriptura al directori, o canviar la ruta a un directori amb permisos.");
        }
        return new File(path);

    }

    public static String getFileSystemManager() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "filesystemmanagerclass");
    }

    public static Long getMaxSizeForScannedDocument() {
        String strVal = getProperty(DIGITALIB_PROPERTY_BASE + "maxsizeforscanneddocument");
        if (strVal == null || strVal.trim().length() == 0) {
            return null;
        } else {
            return Long.valueOf(strVal);
        }
    }

    public static String getSignReasonEL() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "signreasonEL");
    }

    public static String getSignLocationEL() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "signlocationEL");
    }

    public static String getSignerEmailEL() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "signeremailEL");
    }

    /**
     * @return Si aquest valor és true, llavors: (1) No es permetrà l'edició del camp Dir3Codi
     *         de l'objecte Usuari-Persona (2) Durant l'inici d'una transacció via entorn web,
     *         s'utilitzaria el codi dir3 de la Configuració de Grup de la persona
     * 
     */
    public static boolean useDir3OfGroupConfiguration() {
        return "true".equals(getProperty(DIGITALIB_PROPERTY_BASE + "usedir3ofgroupconfiguration"));
    }

    /**
     * Retorna el DIR3 per defecte a utilitzar quan es fan cridades des de l'API normal de
     * DigitalIB, ja que aquesta API no inclou el Funcionari DIR3.
     * 
     * @return
     */
    public static String getDefaultFuncionariDir3() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "defaultfuncionaridir3");
    }

    // 15 minuts
    private static final long DEFAULT_EXPIRATION_TIME_MS = 900000L;

    public static long getTransactionExpirationTimeInMs() {
        String strVal = getProperty(DIGITALIB_PROPERTY_BASE + "transactionexpirationtimeinms");
        if (strVal == null || strVal.trim().length() == 0) {
            return DEFAULT_EXPIRATION_TIME_MS;
        } else {
            try {
                return Long.valueOf(strVal);
            } catch (NumberFormatException nfe) {
                String msg = "Valor per la propietat 'transactionexpirationtimeinms' no correspon a un número: "
                        + strVal;
                log.error(msg, nfe);
                return DEFAULT_EXPIRATION_TIME_MS;
            }
        }
    }

    /** 
     Si aquest valor val true serveix per mostrar un boto durant el processament de subdocuments
     en un escaneig massiu. Aquest boto només es farà visible si pàgina de després d'un Separador 
     està en blanc, cosa que fa suposar que no és una pàgina del document sinó la part posterior 
     d'un separador que només han imprès a una cara i s'ha fet un escaneig a doble cara. 
     Per defecte val false
    */
    public static boolean showButtonToDeleteFirstPage() {
        String strVal = getProperty(DIGITALIB_PROPERTY_BASE + "showbuttontodeletefirstpage");
        if ("true".equals(strVal)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return Si val true llavors permeten escanejos massius emprant Separadors des de web.
     * Si es true, mostrar un boto per descarregar el separador. En cas contrari, es permeten 
     * escanejos simples i s'ignoren els Separadors.
     */
    public static boolean isAllowedMassiveScanInWeb() {
        String strVal = getProperty(DIGITALIB_PROPERTY_BASE + "allowedmassivescaninweb");
        if ("true".equals(strVal)) {
            return true;
        } else {
            return false;
        }
    }

    public static final String PROPERTY_DIESPERNETEJADEFITXERSAPLICACIO = "transactioncleanfilesappindays";
    public static final String PROPERTY_DIESPERNETEJADEFITXERSPERSONA = "transactioncleanfilespersonindays";

    public static Integer getDiesPerNetejaDeFitxersAplicacio() {
        return getDiesPerNetejaDeFitxers(PROPERTY_DIESPERNETEJADEFITXERSAPLICACIO);
    }

    public static Integer getDiesPerNetejaDeFitxersPersona() {
        return getDiesPerNetejaDeFitxers(PROPERTY_DIESPERNETEJADEFITXERSPERSONA);
    }

    protected static Integer getDiesPerNetejaDeFitxers(String propName) {
        String strVal = getProperty(DIGITALIB_PROPERTY_BASE + propName);
        if (strVal == null || strVal.trim().length() == 0) {
            return null;
        } else {
            try {
                return Integer.valueOf(strVal);
            } catch (NumberFormatException nfe) {

                String msg = "Valor per la propietat " + propName + " no correspon a un número: " + strVal;
                log.error(msg, nfe);

                return null;
            }
        }
    }

    public static boolean isOcultarMenuInici() {
        return "true".equals(getProperty(DIGITALIB_PROPERTY_BASE + "ocultarmenuinici"));
    }

    public static String getConfiguracioGrupPerDefecteEL() {
        return getProperty(DIGITALIB_PROPERTY_BASE + "configuraciogrupperdefecteEL");
    }

}
