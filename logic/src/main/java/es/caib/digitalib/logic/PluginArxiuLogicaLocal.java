package es.caib.digitalib.logic;

import java.util.Locale;

import javax.ejb.Local;

import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.plugins.arxiu.api.IArxiuPlugin;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginArxiuLogicaLocal extends AbstractPluginLogicaLocal<IArxiuPlugin> {

    /**
     * TDO XYZ ZZZ S'han d'eliminar
     * S'haurien de utilitzar les constants de la classe 
     * [PORTAFIB]/apifirmasimple-api/src/main/java/org/fundaciobit/apisib/apifirmasimple/v1/beans/FirmaSimpleSignedFileInfo.java
     * https://github.com/GovernIB/portafib/issues/595 
     */
    public static final String SIGNPROFILE_BES = "AdES-BES";
    public static final String SIGNPROFILE_EPES = "AdES-EPES";
    public static final String SIGNPROFILE_T = "AdES-T";
    public static final String SIGNPROFILE_C = "AdES-C";
    public static final String SIGNPROFILE_X = "AdES-X";
    public static final String SIGNPROFILE_X1 = "AdES-X1";
    public static final String SIGNPROFILE_X2 = "AdES-X2";
    public static final String SIGNPROFILE_XL = "AdES-XL";
    public static final String SIGNPROFILE_XL1 = "AdES-XL1";
    public static final String SIGNPROFILE_XL2 = "AdES-XL2";
    public static final String SIGNPROFILE_A = "AdES-A";
    public static final String SIGNPROFILE_PADES_LTV = "PAdES-LTV";
    public static final String SIGNPROFILE_PADES_BASIC = "PAdES-Basic";

    public static final String JNDI_NAME = "digitalib/PluginArxiuLogicaEJB/local";

    /**
     * 
     * @param transaccio
     * @param fitxer
     * @param locale
     * @return
     */
    public InfoCustodyJPA custodiaAmbApiArxiu(TransaccioJPA transaccio, Fitxer fitxer,
            Locale locale);

}
