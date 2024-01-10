package es.caib.digitalib.commons.utils;

/**
 *
 * @author anadal
 *
 */
public interface Constants {

    public static final String DIGITALIB_APP_NAME = "digitalib";
    
    public static final String DIGITALIB_PROPERTY_BASE="es.caib.digitalib.";

    public static final String MAIL_SERVICE = "java:/es.caib.digitalib.mail";

    // TRUE ROLES
    public static final String DIB_ADMIN="DIB_ADMIN";
    public static final String DIB_USER="DIB_USER";
    public static final String DIB_WS="DIB_WS";

    // VIRTUAL SECURITY ROLES
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
    // EJB HIGH LEVEL ROLES
    public static final String ROLE_EJB_FULL_ACCESS  = DIB_ADMIN;
    public static final String ROLE_EJB_BASIC_ACCESS = DIB_USER;
    public static final String ROLE_EJB_WS_ACCESS = DIB_WS;
    
    public static final String PREFIX = "DIB";

    public static final String MIME_PDF = "application/pdf";


    // ROLE SCAN
    public static final String ROLE_SCAN = "ROLE_SCAN";
    // ROLE COAU
    public static final String ROLE_COAU = "ROLE_COAU";
    // ROLE CUST
    public static final String ROLE_CUST = "ROLE_CUST";

    // MONITOR INTEGRACIONS (PLUGINCRIDADA)
    public static final int CRIDADA_PLUGIN_RESULTAT_EN_PROCES = 0;

    public static final int CRIDADA_PLUGIN_RESULTAT_OK = +1;

    public static final int CRIDADA_PLUGIN_RESULTAT_ERROR = -1;

    // AUDITORIA

    public static final int AUDIT_TYPE_ANY_ACTION_OVER_TRANSACTION = 0;

    public static final int AUDIT_TYPE_CREATE_TRANSACTION = 1;

    public static final int AUDIT_TYPE_FINISH_INSERT_DATA = 2;

    public static final int AUDIT_TYPE_FINISH_SCAN = 3;

    public static final int AUDIT_TYPE_SIGN_INFO = 4;

    public static final int AUDIT_TYPE_CUSTODY_INFO = 5;

    public static final int AUDIT_TYPE_END_TRANSACITION = 6;

    public static final int AUDIT_TYPE_CANCEL_USER = 10;

    public static final int AUDIT_TYPE_DELETE_TRANSACTION = 20;

    // TIPUS DE PLUGINS

    public static final int TIPUS_PLUGIN_SCANWEB = 0;

    public static final int TIPUS_PLUGIN_FIRMA_EN_SERVIDOR = 1;

    public static final int TIPUS_PLUGIN_DOCUMENT_CUSTODY = 2;

    public static final int TIPUS_PLUGIN_ARXIU = 3;

    public static final int TIPUS_PLUGIN_SEGELLDETEMPS = 4;

    public static final int TIPUS_CUSTODIA_SENSE = 0;
    public static final int TIPUS_CUSTODIA_ARXIU = 1;
    public static final int TIPUS_CUSTODIA_DOCUMENTCUSTODY = 2;

    public static final int[] TIPUS_CUSTODIA = { TIPUS_CUSTODIA_SENSE, TIPUS_CUSTODIA_ARXIU,
        TIPUS_CUSTODIA_DOCUMENTCUSTODY };

    public static final int TIPUS_FIRMA_EN_SERVIDOR_SENSE = 0;
    public static final int TIPUS_FIRMA_EN_SERVIDOR_PLUGIN = 1;
    public static final int TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE = 2;

    public static final int[] TIPUS_FIRMA_EN_SERVIDOR = { TIPUS_FIRMA_EN_SERVIDOR_SENSE,
        TIPUS_FIRMA_EN_SERVIDOR_PLUGIN, TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE };

    public static final int FORMAT_FILE_PDF = 0; // "pdf";

    public static final int FORMAT_FILE_JPG = 1; // "jpg";

    public static final int FORMAT_FILE_TIFF = 2; // "tif";

    public static final int FORMAT_FILE_PNG = 3; // "png";

    public static final int FORMAT_FILE_GIF = 4; // "gif";

    // public static final int PERFIL_US_PLANTILLA = 0;
    //
    // public static final int PERFIL_US_TRANSACCIO_INFO = 1;

    public static final int PIXEL_TYPE_BLACK_WHITE = 0;

    public static final int PIXEL_TYPE_GRAY = 1;

    public static final int PIXEL_TYPE_COLOR = 2;

    public static final int[] PIXEL_TYPE = { PIXEL_TYPE_BLACK_WHITE, PIXEL_TYPE_GRAY,
        PIXEL_TYPE_COLOR };

    // public static final int PERFIL_US_TRANSACCIO_INFO = 0;

    public static final int PERFIL_US_ALL_INFO = 0;

    public static final int PERFIL_US_NOMES_ESCANEIG_INFO = -1;
    public static final int PERFIL_US_COPIA_AUTENTICA_INFO = -2;
    public static final int PERFIL_US_CUSTODIA_INFO = -3;

    public static final int PERFIL_US_NOMES_ESCANEIG = 1;
    public static final int PERFIL_US_COPIA_AUTENTICA = 2;
    public static final int PERFIL_US_CUSTODIA = 3;

    public static final int[] PERFIL_US = { PERFIL_US_NOMES_ESCANEIG_INFO,
        PERFIL_US_COPIA_AUTENTICA_INFO, PERFIL_US_CUSTODIA_INFO,

        PERFIL_US_NOMES_ESCANEIG, PERFIL_US_COPIA_AUTENTICA, PERFIL_US_CUSTODIA };

    public static final int TIPUS_OPERACIO_FIRMA_FIRMAR = 0;
    public static final int TIPUS_OPERACIO_FIRMA_COFIRMAR = 1;
    public static final int TIPUS_OPERACIO_FIRMA_CONTRAFIRMAR = 2;

    public static final int TIPUSFIRMA_PADES = 0;
    public static final int TIPUSFIRMA_XADES = 1;
    public static final int TIPUSFIRMA_CADES = 2;
    public static final int TIPUSFIRMA_SMIME = 3;

    public static final int SIGN_ALGORITHM_SHA1WITHRSA = 0;
    public static final int SIGN_ALGORITHM_SHA256WITHRSA = 1;
    public static final int SIGN_ALGORITHM_SHA384WITHRSA = 2;
    public static final int SIGN_ALGORITHM_SHA512WITHRSA = 3;

    public static final int SIGN_MODE_IMPLICIT = 0;

    public static final int SIGN_MODE_EXPLICIT = 1;

    public static final int TAULADEFIRMES_SENSETAULA = 0;
    public static final int TAULADEFIRMES_PRIMERAPAGINA = 1;
    public static final int TAULADEFIRMES_DARRERAPAGINA = -1;

    public static final int[] TAULADEFIRMES = { TAULADEFIRMES_SENSETAULA,
        TAULADEFIRMES_PRIMERAPAGINA, TAULADEFIRMES_DARRERAPAGINA };

    // 0 => no usar politica de firma,
    public static final int US_POLITICA_DE_FIRMA_NO_USAR = 0;

    // 1=> usar politica d'aquesta configuracio
    public static final int US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT = 1;

    public static final int TRANSACCIO_ESTAT_CODI_EXPIRAT = -3;
    public static final int TRANSACCIO_ESTAT_CODI_CANCELAT = -2;
    public static final int TRANSACCIO_ESTAT_CODI_ERROR = -1;
    public static final int TRANSACCIO_ESTAT_CODI_ID = 0;
    public static final int TRANSACCIO_ESTAT_CODI_ENPROGRES = 1;
    public static final int TRANSACCIO_ESTAT_CODI_OK = 2;


    public static final int ORIGEN_CIUTADA = 0; 
    public static final int ORIGEN_ADMINISTRACIO = 1;
    
    
    
    // CONTEXTES WEB 
    
    public static final String SCANWEB_PROCESS_CONTROLLER_PUBLIC_CONTEXTPATH = "/public/scanweb";
    
    
}