package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Resultat d'un Escaneig o Copia Autentica
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MassiveScanWebSimpleSubtransactionResult {

    protected long transactionID;

    protected String transactionWebID;

    protected MassiveScanWebSimpleStatus status;

    protected MassiveScanWebSimpleFile scannedFile;

    protected MassiveScanWebSimpleScannedFileInfo scannedFileInfo;

    protected MassiveScanWebSimpleFile signedFile;

    protected MassiveScanWebSimpleFile detachedSignatureFile;

    protected MassiveScanWebSimpleSignedFileInfo signedFileInfo;

    /**
     * Informacio de Plugin de Custòdia
     */
    protected MassiveScanWebSimpleCustodyInfo custodyInfo = null;

    /**
     * Informació de Plugin d'Arxiu
     */
    protected MassiveScanWebSimpleArxiuInfo arxiuInfo = null;
    
    /**
     * Obligatori si el perfil requeix Arxiu o Custodia
     */
    protected MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;

    /**
     * Paràmetres opcionals per Arxiu o Custòdia
     */
    protected MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;

    /**
     * Propietats del Formulari Addicionals
     */
    protected List<MassiveScanWebSimpleKeyValue> additionalMetadatas = null;

    /**
     * 
     */
    public MassiveScanWebSimpleSubtransactionResult() {
        super();
    }

    public MassiveScanWebSimpleSubtransactionResult(long transactionID,
            String transactionWebID, MassiveScanWebSimpleStatus status) {
        super();
        this.transactionID = transactionID;
        this.transactionWebID = transactionWebID;
        this.status = status;
    }
    
    public MassiveScanWebSimpleSubtransactionResult(long transactionID,
            String transactionWebID, MassiveScanWebSimpleStatus status,
            MassiveScanWebSimpleFile scannedFile,
            MassiveScanWebSimpleScannedFileInfo scannedFileInfo,                              
            List<MassiveScanWebSimpleKeyValue> additionalMetadatas) {
        super();
        this.transactionID = transactionID;
        this.transactionWebID = transactionWebID;
        this.status = status;
        this.scannedFile = scannedFile;
        this.scannedFileInfo = scannedFileInfo;
        this.additionalMetadatas = additionalMetadatas;
    }

    
    
    public MassiveScanWebSimpleSubtransactionResult(long transactionID,
            String transactionWebID, MassiveScanWebSimpleStatus status,
            MassiveScanWebSimpleFile scannedFile,
            MassiveScanWebSimpleScannedFileInfo scannedFileInfo,
            MassiveScanWebSimpleFile signedFile,
            MassiveScanWebSimpleFile detachedSignatureFile,
            MassiveScanWebSimpleSignedFileInfo signedFileInfo,                     
            List<MassiveScanWebSimpleKeyValue> additionalMetadatas) {
        super();
        this.transactionID = transactionID;
        this.transactionWebID = transactionWebID;
        this.status = status;
        this.scannedFile = scannedFile;
        this.scannedFileInfo = scannedFileInfo;
        this.signedFile = signedFile;
        this.detachedSignatureFile = detachedSignatureFile;
        this.signedFileInfo = signedFileInfo;
        this.additionalMetadatas = additionalMetadatas;
    }

    
    public MassiveScanWebSimpleSubtransactionResult(long transactionID,
            String transactionWebID, MassiveScanWebSimpleStatus status,
            MassiveScanWebSimpleFile scannedFile,
            MassiveScanWebSimpleScannedFileInfo scannedFileInfo,
            MassiveScanWebSimpleFile signedFile,
            MassiveScanWebSimpleFile detachedSignatureFile,
            MassiveScanWebSimpleSignedFileInfo signedFileInfo,
            MassiveScanWebSimpleCustodyInfo custodyInfo,            
            List<MassiveScanWebSimpleKeyValue> additionalMetadatas) {
        super();
        this.transactionID = transactionID;
        this.transactionWebID = transactionWebID;
        this.status = status;
        this.scannedFile = scannedFile;
        this.scannedFileInfo = scannedFileInfo;
        this.signedFile = signedFile;
        this.detachedSignatureFile = detachedSignatureFile;
        this.signedFileInfo = signedFileInfo;
        this.custodyInfo = custodyInfo;
        this.additionalMetadatas = additionalMetadatas;
    }


    public MassiveScanWebSimpleSubtransactionResult(long transactionID,
            String transactionWebID, MassiveScanWebSimpleStatus status,
            MassiveScanWebSimpleFile scannedFile,
            MassiveScanWebSimpleScannedFileInfo scannedFileInfo,
            MassiveScanWebSimpleFile signedFile,
            MassiveScanWebSimpleFile detachedSignatureFile,
            MassiveScanWebSimpleSignedFileInfo signedFileInfo,
            MassiveScanWebSimpleCustodyInfo custodyInfo,
            MassiveScanWebSimpleArxiuInfo arxiuInfo,
            MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters,
            MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters,
            List<MassiveScanWebSimpleKeyValue> additionalMetadatas) {
        super();
        this.transactionID = transactionID;
        this.transactionWebID = transactionWebID;
        this.status = status;
        this.scannedFile = scannedFile;
        this.scannedFileInfo = scannedFileInfo;
        this.signedFile = signedFile;
        this.detachedSignatureFile = detachedSignatureFile;
        this.signedFileInfo = signedFileInfo;
        this.custodyInfo = custodyInfo;
        this.arxiuInfo = arxiuInfo;
        this.arxiuRequiredParameters = arxiuRequiredParameters;
        this.arxiuOptionalParameters = arxiuOptionalParameters;
        this.additionalMetadatas = additionalMetadatas;
    }

    public MassiveScanWebSimpleStatus getStatus() {
        return status;
    }

    public void setStatus(MassiveScanWebSimpleStatus status) {
        this.status = status;
    }

    public MassiveScanWebSimpleFile getScannedFile() {
        return scannedFile;
    }

    public void setScannedFile(MassiveScanWebSimpleFile scannedFile) {
        this.scannedFile = scannedFile;
    }

    public MassiveScanWebSimpleScannedFileInfo getScannedFileInfo() {
        return scannedFileInfo;
    }

    public void setScannedFileInfo(MassiveScanWebSimpleScannedFileInfo scannedFileInfo) {
        this.scannedFileInfo = scannedFileInfo;
    }

    public MassiveScanWebSimpleSignedFileInfo getSignedFileInfo() {
        return signedFileInfo;
    }

    public void setSignedFileInfo(MassiveScanWebSimpleSignedFileInfo signedFileInfo) {
        this.signedFileInfo = signedFileInfo;
    }

    public MassiveScanWebSimpleCustodyInfo getCustodyInfo() {
        return custodyInfo;
    }

    public void setCustodyInfo(MassiveScanWebSimpleCustodyInfo custodyInfo) {
        this.custodyInfo = custodyInfo;
    }

    public MassiveScanWebSimpleFile getDetachedSignatureFile() {
        return detachedSignatureFile;
    }

    public void setDetachedSignatureFile(MassiveScanWebSimpleFile detachedSignatureFile) {
        this.detachedSignatureFile = detachedSignatureFile;
    }

    public MassiveScanWebSimpleArxiuInfo getArxiuInfo() {
        return arxiuInfo;
    }

    public void setArxiuInfo(MassiveScanWebSimpleArxiuInfo arxiuInfo) {
        this.arxiuInfo = arxiuInfo;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionWebID() {
        return transactionWebID;
    }

    public void setTransactionWebID(String transactionWebID) {
        this.transactionWebID = transactionWebID;
    }

    public MassiveScanWebSimpleFile getSignedFile() {
        return signedFile;
    }

    public void setSignedFile(MassiveScanWebSimpleFile signedFile) {
        this.signedFile = signedFile;
    }

    
    
    public MassiveScanWebSimpleArxiuRequiredParameters getArxiuRequiredParameters() {
        return arxiuRequiredParameters;
    }

    public void setArxiuRequiredParameters(
            MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters) {
        this.arxiuRequiredParameters = arxiuRequiredParameters;
    }

    public MassiveScanWebSimpleArxiuOptionalParameters getArxiuOptionalParameters() {
        return arxiuOptionalParameters;
    }

    public void setArxiuOptionalParameters(
            MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters) {
        this.arxiuOptionalParameters = arxiuOptionalParameters;
    }

    public List<MassiveScanWebSimpleKeyValue> getAdditionalMetadatas() {
        return additionalMetadatas;
    }

    public void setAdditionalMetadatas(List<MassiveScanWebSimpleKeyValue> additionalMetadatas) {
        this.additionalMetadatas = additionalMetadatas;
    }

    public static String toString(MassiveScanWebSimpleSubtransactionResult result) {

        StringBuffer str = new StringBuffer();

        str.append("\n").append("====== SCANWEB =====");

        str.append("\n").append(" * TransactionID: " + result.getTransactionID());
        str.append("\n").append(" * TransactionWebID: " + result.getTransactionWebID());

        int status = result.getStatus().getStatus();
        String statusStr;
        switch (status) {
            case MassiveScanWebSimpleStatus.STATUS_REQUESTED_ID:
                statusStr = "REQUESTED_ID";
            break;

            case MassiveScanWebSimpleStatus.STATUS_IN_PROGRESS:
                statusStr = "";
            break;

            case MassiveScanWebSimpleStatus.STATUS_FINAL_OK:
                statusStr = "FINAL_OK";
            break;

            default:
            case MassiveScanWebSimpleStatus.STATUS_FINAL_ERROR:
                statusStr = "ERROR => " + result.getStatus().getErrorMessage();
            break;

            case MassiveScanWebSimpleStatus.STATUS_CANCELLED:
                statusStr = "CANCELLED => " + result.getStatus().getErrorMessage();
            break;

            case MassiveScanWebSimpleStatus.STATUS_EXPIRED:
                statusStr = "EXPIRED";
            break;

        }
        str.append("\n").append(" * Estat: ").append(statusStr);

        if (status != MassiveScanWebSimpleStatus.STATUS_FINAL_OK) {
            return str.toString();
        }


        // Escaneig
        MassiveScanWebSimpleScannedFileInfo scannedFileInfo = result.getScannedFileInfo();
        str.append("\n").append("  + SCANINFO:");

        str.append("\n").append("      * FormatFile: " + scannedFileInfo.getFormatFile());

        String pixelType;

        if (scannedFileInfo.getPixelType() != null) {

            switch (scannedFileInfo.getPixelType()) {

                case MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_BLACK_WHITE:
                    pixelType = "B&W";
                break;
                case MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_GRAY:
                    pixelType = "Gris";
                break;
                case MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_COLOR:
                    pixelType = "Color";
                break;
                default:
                    pixelType = "--VALOR DESCONEGUT (" + scannedFileInfo.getPixelType()
                            + ")--";

            }
        } else {
            pixelType = "--NO DEFINIT--";
        }

        str.append("\n").append("      * PixelType: " + pixelType);
        str.append("\n")
                .append("      * Resolució(PPP): " + scannedFileInfo.getPppResolution());
        str.append("\n").append("      * OCR: " + scannedFileInfo.getOcr());

        
        str.append("\n").append("      * Document Type:")
        .append(scannedFileInfo.getDocumentType());
        
        // Signatura
        str.append("\n").append(
                MassiveScanWebSimpleSignedFileInfo.toString(result.getSignedFileInfo()));

        // ARXIU i CUSTODIA
        MassiveScanWebSimpleCustodyInfo custody = result.getCustodyInfo();

        if (custody != null) {

            str.append("\n").append("  + CUSTODIA:");
            str.append("\n").append("      * custodyFileID: " + custody.getCustodyID());
            str.append("\n").append("      * CSV: " + custody.getCsv());
            str.append("\n")
                    .append("      * getCsvValidationWeb: " + custody.getCsvValidationWeb());
            str.append("\n").append("      * getCsvGenerationDefinition: "
                    + custody.getCsvGenerationDefinition());
            str.append("\n")
                    .append("      * OriginalFileURL: " + custody.getOriginalFileURL());
            str.append("\n")
                    .append("      * PrintableFileURL: " + custody.getPrintableFileURL());
            str.append("\n").append("      * ENIFileURL: " + custody.getEniFileURL());
            str.append("\n")
                    .append("      * ValidationFileUrl: " + custody.getValidationFileUrl());

        }

        MassiveScanWebSimpleArxiuInfo arxiu = result.getArxiuInfo();

        if (arxiu != null) {
            str.append("\n").append("  + ARXIU:");

            str.append("\n").append("      * expedientID: " + arxiu.getExpedientID());
            str.append("\n").append("      * documentID: " + arxiu.getDocumentID());
            str.append("\n").append("      * CSV: " + arxiu.getCsv());
            str.append("\n")
                    .append("      * getCsvValidationWeb: " + arxiu.getCsvValidationWeb());
            str.append("\n").append("      * getCsvGenerationDefinition: "
                    + arxiu.getCsvGenerationDefinition());
            str.append("\n").append("      * OriginalFileURL: " + arxiu.getOriginalFileURL());
            str.append("\n")
                    .append("      * PrintableFileURL: " + arxiu.getPrintableFileURL());
            str.append("\n").append("      * ENIFileURL: " + arxiu.getEniFileURL());
            str.append("\n")
                    .append("      * ValidationFileUrl: " + arxiu.getValidationFileUrl());
        }
        
        

        str.append("\n").append("  + FORM METADATAS");

        



        // -----------------
        // ARXIU: VALORS REQUERITS
        // -----------------

        MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters = result
            .getArxiuRequiredParameters();
        if (arxiuRequiredParameters != null) {

          // NIF del ciutadà
          str.append("\n").append("      * citizenAdministrationID:")
              .append(arxiuRequiredParameters.getCitizenAdministrationID());

          // Nom complet del ciutada
          str.append("\n").append("      * citizenFullName:")
              .append(arxiuRequiredParameters.getCitizenFullName());

          /**
           * Document Estat Elaboració EE01 - Original EE02 - Còpia electrònica autèntica amb canvi
           * de format EE03 - Còpia electrònica autèntica de document en paper EE04 - Còpia
           * electrònica parcial autèntica EE99 - Altres
           */
          str.append("\n").append("      * Document Estat Elaboracio:")
              .append(arxiuRequiredParameters.getDocumentElaborationState());

          /**
           * Document Tipus: TD01 - Resolució,TD02 - Acord,TD03 - Contracte,TD04 - Conveni, TD05 -
           * Declaració,TD06 - Comunicació,TD07 - Notificació,TD08 - Publicació, TD09 - Justificant
           * recepció,TD10 - Acta,TD11 - Certificat,TD12 - Diligència, TD13 - Informe,TD14 -
           * Sol·licitud,TD15 - Denúncia, TD16 - Al·legació,TD17 - Recurs,TD18 - Comunicació
           * ciutadà,TD19 - Factura, TD20 - Altres incautats,TD99 - Altres,
           */


          /**
           * Origen: 1 =>Administració 0 =>Ciutadà
           */
          {
            Integer origen = arxiuRequiredParameters.getDocumentOrigen();
            str.append("\n").append("      * Document Origen:")
                .append((origen == null ? "null" : (origen == 0) ? "Ciutadà" : "Administració"));
          }

          // Interessats
          {
            List<String> interessats = arxiuRequiredParameters.getInterestedPersons();
            str.append("\n").append("      * Persones Interessades: ");
            if (interessats == null || interessats.size() == 0) {
              str.append(" null");
            } else {
              str.append(Arrays.toString(interessats.toArray()));
            }
          }

          /**
           * Codi DIR3 dels organs afectats si són administracions públiques o CIF si són empreses
           * externes
           */
          {
            str.append("\n").append("      * Organismes Afectats: ");
            List<String> organs = arxiuRequiredParameters.getAffectedOrganisms();
            if (organs == null || organs.size() == 0) {
              str.append(" null");
            } else {
              str.append(Arrays.toString(organs.toArray()));
            }
          }

        }

        MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = result
            .getArxiuOptionalParameters();

        if (arxiuOptionalParameters != null) {

          str.append("\n").append("      * Nom del Procediment:")
              .append(arxiuOptionalParameters.getProcedureName());

          str.append("\n").append("      * Codi del Procediment:")
              .append(arxiuOptionalParameters.getProcedureCode());

          // Serie Documental = "S0001"
          str.append("\n").append("      * Serie Documental:")
              .append(arxiuOptionalParameters.getDocumentarySerie());

          // Custòdia o expedient ja existent. Si val null llavors en crearà un de nou
          str.append("\n").append("      * CustodyID o ExpedientID:")
              .append(arxiuOptionalParameters.getCustodyIDOrExpedientID());

        }

        /**
         * Propietats del Formulari Addicionals
         */
        {
          List<MassiveScanWebSimpleKeyValue> list = result.getAdditionalMetadatas();
          str.append("\n").append("    + Additional Metadatas:");
          if (list == null || list.size() == 0) {
            str.append("  << EMPTY >>");
          } else {
            for (MassiveScanWebSimpleKeyValue kv : list) {
              str.append("\n").append("       - ").append(kv.getKey()).append(" => ]")
                  .append(kv.getValue()).append("[");
            }
          }
        }
        

        return str.toString();

    }
}
