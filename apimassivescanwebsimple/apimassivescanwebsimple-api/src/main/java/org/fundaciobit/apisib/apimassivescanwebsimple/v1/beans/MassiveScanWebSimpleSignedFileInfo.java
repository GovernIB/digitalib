package org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MassiveScanWebSimpleSignedFileInfo {

    /** Identificador de la firma PAdES. */
    public static final String SIGN_TYPE_PADES = "PAdES";
    /** Identificador de la firma XAdES por defecto. */
    public static final String SIGN_TYPE_XADES = "XAdES";
    /** Identificador de la firma CAdES. */
    public static final String SIGN_TYPE_CADES = "CAdES";
    /** Identificador de la firma Factura-e (derivado de XAdES-EPES). */
    public static final String SIGN_TYPE_FACTURAE = "FacturaE";
    /** Identificador de la firma OOXML (<i>Office Open XML</i>). */
    public static final String SIGN_TYPE_OOXML = "OOXML";
    /** Identificador de la firma ODF (<i>Open Document Format</i>). */
    public static final String SIGN_TYPE_ODF = "ODF";
    /** Identificador de Firma SMIME */
    public static final String SIGN_TYPE_SMIME = "SMIME";
    /** CAdES-ASiC-S: Formato de firma avanzada ASiC de tipo CAdES. */
    public static final String SIGN_TYPE_CADES_ASIC_S = "CAdES-ASiC-S";
    /** XAdES-ASiC-S: Formato de firma avanzada ASiC de tipo XAdES. */
    public static final String SIGN_TYPE_XADES_ASIC_S = "XAdES-ASiC-S";
    /** NONE: Firma PKCS#1. **/
    public static final String SIGN_TYPE_PKCS1 = "PKCS#1";

    public static final String SIGN_ALGORITHM_SHA1 = "SHA-1";
    public static final String SIGN_ALGORITHM_SHA256 = "SHA-256";
    public static final String SIGN_ALGORITHM_SHA384 = "SHA-384";
    public static final String SIGN_ALGORITHM_SHA512 = "SHA-512";

    /*
     * implicit La firma resultante incluirá internamente una copia de los datos firmados. El
     * uso de este valor podría generar firmas de gran tamaño.
     */
    public static final int SIGN_MODE_IMPLICIT_ATTACHED = 0;
    /*
     * explicit La firma resultante no incluirá los datos firmados. Si no se indica el
     * parámetro mode se configura automáticamente este comportamiento.
     */
    public static final int SIGN_MODE_EXPLICIT_DETACHED = 1;

    public static final int SIGNATURESTABLELOCATION_WITHOUT = 0;
    public static final int SIGNATURESTABLELOCATION_FIRSTPAGE = 1;
    public static final int SIGNATURESTABLELOCATION_LASTPAGE = -1;

    // FIRMA
    public static final int SIGN_OPERATION_SIGN = 0;
    // COFIRMA
    public static final int SIGN_OPERATION_COSIGN = 1;
    // CONTRAFIRMA
    public static final int SIGN_OPERATION_COUNTERSIGN = 2;

    /**
     * eEMGDE.Firma.Firmante.EnCalidadDe(eEMGDE17.5.3): Firmante; Cofirmante; Contrafirmante
     * 
     */
    protected Integer signOperation;

    protected String signType;

    protected String signAlgorithm;

    protected Integer signMode;

    protected Integer signaturesTableLocation;

    protected Boolean timeStampIncluded;

    /** BES(falsE) o EPES(true) **/
    protected Boolean policyIncluded;

    /**
     * eEMGDE.Firma.TipoFirma.FormatoFirma (eEMGDE17.1.1): TF01 (CSV), TF02 (XAdES internally
     * detached signature), TF03 (XAdES enveloped signature), TF04 (CAdES detached/explicit
     * signature), TF05 (CAdES attached/implicit signature), TF06 (PAdES)
     * 
     * 
     * Denominación normalizada del tipo de firma. Los posibles valores asignables son los
     * siguientes: TF01 - CSV TF02 - XAdES internally detached signature"); TF03 - XAdES
     * enveloped signature. TF04 - CAdES detached/explicit signature. TF05 - CAdES
     * attached/implicit signature. TF06 - PAdES. El tipo TF04 será establecido por defecto
     * para documentos firmados, exceptuando los documentos en formato PDF o PDF/A, cuyo tipo
     * será TF06. MetadataConstants.ENI_TIPO_FIRMA = "eni:tipoFirma";
     * 
     */
    protected String eniTipoFirma;

    /**
     * - eEMGDE.Firma.TipoFirma.PerfilFirma (eEMGDE17.1.2): 1.- Para las firmas XADES y CADES:
     * EPES, T, C, X, XL, A, BASELINE B-Level, BASELINE T-Level, BASELINE LT-Level, BASELINE
     * LTA-Level. 2.- Para las firmas PADES: EPES, LTV, BASELINE B-Level, BASELINE T
     * 
     * Perfil empleado en una firma con certificado electrónico. Los posibles valores
     * asignables son los siguientes: EPES T C X XL A BASELINE B-Level BASELINE LT-Level
     * BASELINE LTA-Level BASELINE T-Level LTV
     * 
     * - MetadataConstants.ENI_PERFIL_FIRMA = "eni:perfil_firma";
     */
    protected String eniPerfilFirma;

    /**
     * - eEMGDE.Firma.RolFirma (eEMGDE17.2): Esquemas desarrollados a nivel local y que pueden
     * incluir valores como válida, autentica, refrenda, visa, representa, testimonia, etc..
     */
    protected String eniRolFirma;

    /**
     * eEMGDE.Firma.Firmante.NombreApellidos (eEMGDE17.5.1): Texto libre. Nombre o razón social
     * de los firmantes.
     */
    protected String eniSignerName;

    /**
     * eEMGDE.Firma.Firmante (eEMGDE17.5.2). NúmeroIdentificacionFirmantes
     */
    protected String eniSignerAdministrationId;

    /**
     * eEMGDE.Firma.NivelFirma (eEMGDE17.5.4) Indicador normalizado que refleja el grado de
     * confianza de la firma utilizado. Ejemplos: Nick, PIN ciudadano, Firma electrónica
     * avanzada, Claves concertadas, Firma electrónica avanzada basada en certificados, CSV, ..
     */
    protected String eniSignLevel;

    /**
     * Informació de les validacions realitzades
     */
    protected MassiveScanWebSimpleValidationInfo validationInfo = null;

    /**
     * eEMGDE.Firma.InformacionAdicional (eEMGDE17.5.5) Ofrecer cualquier otra información que
     * se considere útil acerca del firmante.
     *
     */
    protected List<MassiveScanWebSimpleKeyValue> additionInformation = null;

    public MassiveScanWebSimpleSignedFileInfo() {
        super();
    }

    /**
     * 
     * @param signOperation
     * @param signType
     * @param signAlgorithm
     * @param signMode
     * @param signaturesTableLocation
     * @param timeStampIncluded
     * @param policyIncluded
     * @param eniTipoFirma
     * @param eniPerfilFirma
     * @param eniRolFirma
     * @param eniSignerName
     * @param eniSignerAdministrationId
     * @param eniSignLevel
     * @param validationInfo
     * @param additionInformation
     */
    public MassiveScanWebSimpleSignedFileInfo(Integer signOperation, String signType,
            String signAlgorithm, Integer signMode, Integer signaturesTableLocation,
            Boolean timeStampIncluded, Boolean policyIncluded, String eniTipoFirma,
            String eniPerfilFirma, String eniRolFirma, String eniSignerName,
            String eniSignerAdministrationId, String eniSignLevel,
            MassiveScanWebSimpleValidationInfo validationInfo,
            List<MassiveScanWebSimpleKeyValue> additionInformation) {
        super();
        this.signOperation = signOperation;
        this.signType = signType;
        this.signAlgorithm = signAlgorithm;
        this.signMode = signMode;
        this.signaturesTableLocation = signaturesTableLocation;
        this.timeStampIncluded = timeStampIncluded;
        this.policyIncluded = policyIncluded;
        this.eniTipoFirma = eniTipoFirma;
        this.eniPerfilFirma = eniPerfilFirma;
        this.eniRolFirma = eniRolFirma;
        this.eniSignerName = eniSignerName;
        this.eniSignerAdministrationId = eniSignerAdministrationId;
        this.eniSignLevel = eniSignLevel;
        this.validationInfo = validationInfo;
        this.additionInformation = additionInformation;
    }

    public Integer getSignOperation() {
        return signOperation;
    }

    public void setSignOperation(Integer signOperation) {
        this.signOperation = signOperation;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSignAlgorithm() {
        return signAlgorithm;
    }

    public void setSignAlgorithm(String signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
    }

    public Integer getSignMode() {
        return signMode;
    }

    public void setSignMode(Integer signMode) {
        this.signMode = signMode;
    }

    public Integer getSignaturesTableLocation() {
        return signaturesTableLocation;
    }

    public void setSignaturesTableLocation(Integer signaturesTableLocation) {
        this.signaturesTableLocation = signaturesTableLocation;
    }

    public Boolean getTimeStampIncluded() {
        return timeStampIncluded;
    }

    public void setTimeStampIncluded(Boolean timeStampIncluded) {
        this.timeStampIncluded = timeStampIncluded;
    }

    public Boolean getPolicyIncluded() {
        return policyIncluded;
    }

    public void setPolicyIncluded(Boolean policyIncluded) {
        this.policyIncluded = policyIncluded;
    }

    public String getEniTipoFirma() {
        return eniTipoFirma;
    }

    public void setEniTipoFirma(String eniTipoFirma) {
        this.eniTipoFirma = eniTipoFirma;
    }

    public String getEniPerfilFirma() {
        return eniPerfilFirma;
    }

    public void setEniPerfilFirma(String eniPerfilFirma) {
        this.eniPerfilFirma = eniPerfilFirma;
    }

    public String getEniRolFirma() {
        return eniRolFirma;
    }

    public void setEniRolFirma(String eniRolFirma) {
        this.eniRolFirma = eniRolFirma;
    }

    public String getEniSignerName() {
        return eniSignerName;
    }

    public void setEniSignerName(String eniSignerName) {
        this.eniSignerName = eniSignerName;
    }

    public String getEniSignerAdministrationId() {
        return eniSignerAdministrationId;
    }

    public void setEniSignerAdministrationId(String eniSignerAdministrationId) {
        this.eniSignerAdministrationId = eniSignerAdministrationId;
    }

    public String getEniSignLevel() {
        return eniSignLevel;
    }

    public void setEniSignLevel(String eniSignLevel) {
        this.eniSignLevel = eniSignLevel;
    }

    public MassiveScanWebSimpleValidationInfo getValidationInfo() {
        return validationInfo;
    }

    public void setValidationInfo(MassiveScanWebSimpleValidationInfo validationInfo) {
        this.validationInfo = validationInfo;
    }

    public List<MassiveScanWebSimpleKeyValue> getAdditionInformation() {
        return additionInformation;
    }

    public void setAdditionInformation(
            List<MassiveScanWebSimpleKeyValue> additionInformation) {
        this.additionInformation = additionInformation;
    }

    public static String toString(MassiveScanWebSimpleSignedFileInfo sfi) {

        if (sfi == null) {
            return "";
        }

        StringBuffer str = new StringBuffer("  + FIRMA:");

        String operation;
        switch (sfi.getSignOperation()) {
            case MassiveScanWebSimpleSignedFileInfo.SIGN_OPERATION_SIGN:
                operation = "FIRMA";
            break;
            case MassiveScanWebSimpleSignedFileInfo.SIGN_OPERATION_COSIGN:
                operation = "COFIRMA";
            break;

            case MassiveScanWebSimpleSignedFileInfo.SIGN_OPERATION_COUNTERSIGN:
                operation = "CONTRAFIRMA";
            break;

            default:
                operation = "DESCONEGUDA (" + sfi.getSignOperation() + ")";
        }
        str.append("\n").append("      * Operacio:\t" + operation);

        str.append("\n").append("      * Tipus:\t" + sfi.getSignType());

        str.append("\n").append("      * Algorisme:\t" + sfi.getSignAlgorithm());

        str.append("\n").append("      * Mode:\t" + ((sfi
                .getSignMode() == MassiveScanWebSimpleSignedFileInfo.SIGN_MODE_IMPLICIT_ATTACHED)
                        ? "Attached - Implicit"
                        : "Detached- Explicit"));

        String posicioTaulaDeFirmes;
        switch (sfi.getSignaturesTableLocation()) {

            case MassiveScanWebSimpleSignedFileInfo.SIGNATURESTABLELOCATION_WITHOUT:
                posicioTaulaDeFirmes = "Sense taula de Firmes";
            break;
            case MassiveScanWebSimpleSignedFileInfo.SIGNATURESTABLELOCATION_FIRSTPAGE:
                posicioTaulaDeFirmes = "Taula de Firmes en la primera pagina";
            break;
            case MassiveScanWebSimpleSignedFileInfo.SIGNATURESTABLELOCATION_LASTPAGE:
                posicioTaulaDeFirmes = "Taula de Firmes en la darrera pagina";
            break;

            default:
                posicioTaulaDeFirmes = "Desconeguda(" + sfi.getSignaturesTableLocation() + ")";

        }
        str.append("\n").append("      * Posicio Taula De Firmes:\t" + posicioTaulaDeFirmes);

        str.append("\n").append("      * Inclou Politica de Firmes(o sigui es EPES):\t"
                + sfi.getPolicyIncluded());
        str.append("\n")
                .append("      * Inclou Segell de Temps:\t" + sfi.getTimeStampIncluded());

        str.append("\n").append("      * eniTipoFirma:\t" + sfi.getEniTipoFirma());
        str.append("\n").append("      * eniPerfilFirma:\t" + sfi.getEniPerfilFirma());
        str.append("\n").append("      * eniRolFirma:\t" + sfi.getEniRolFirma());
        str.append("\n").append("      * eniSignerName:\t" + sfi.getEniSignerName());
        str.append("\n").append(
                "      * eniSignerAdministrationId:\t" + sfi.getEniSignerAdministrationId());
        str.append("\n").append("      * eniSignLevel:\t" + sfi.getEniSignLevel());

        MassiveScanWebSimpleValidationInfo validationInfo = sfi.getValidationInfo();
        if (validationInfo != null) {

            str.append("\n").append("  + VALIDACIO:");
            str.append("\n").append("      * CheckAdministrationIDOfSigner: "
                    + null2Str(validationInfo.getCheckAdministrationIDOfSigner()));
            str.append("\n").append("      * CheckDocumentModifications: "
                    + null2Str(validationInfo.getCheckDocumentModifications()));
            str.append("\n").append("      * CheckValidationSignature: "
                    + null2Str(validationInfo.getCheckValidationSignature()));
        }

        List<MassiveScanWebSimpleKeyValue> additionInformation = sfi.getAdditionInformation();

        if (additionInformation != null && additionInformation.size() != 0) {
            str.append("\n").append("  + INFORMACIO ADDICIONAL:");
            for (MassiveScanWebSimpleKeyValue firmaSimpleKeyValue : additionInformation) {
                str.append("\n").append("      * KEY[" + firmaSimpleKeyValue.getKey() + "]: "
                        + firmaSimpleKeyValue.getValue());
            }
        }

        return str.toString();

    }

    private static String null2Str(Boolean b) {
        if (b == null) {
            return "-";
        } else if (b == true) {
            return "SI";
        } else {
            return "NO";
        }
    }

}
