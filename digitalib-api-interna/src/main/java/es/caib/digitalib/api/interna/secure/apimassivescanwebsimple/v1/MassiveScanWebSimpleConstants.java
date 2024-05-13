package es.caib.digitalib.api.interna.secure.apimassivescanwebsimple.v1;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuRequiredParameters;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfile;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleScannedFileInfo;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;

/**
 * 
 * @author anadal
 *
 */

@Schema(name = "MassiveScanWebSimpleConstants")
public class MassiveScanWebSimpleConstants {

    // -------------------------------------
    // MassiveScanWebSimpleGetTransactionIdRequest 
    // -------------------------------------

    @Schema(
            description = "Constant MassiveScanWebSimpleGetTransactionIdRequest_VIEW_FULLSCREEN",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleGetTransactionIdRequest_VIEW_FULLSCREEN;

    @Schema(
            description = "Constant MassiveScanWebSimpleGetTransactionIdRequest_VIEW_IFRAME",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleGetTransactionIdRequest.VIEW_IFRAME,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleGetTransactionIdRequest_VIEW_IFRAME;

    // -------------------------------------
    // MassiveScanWebSimpleAvailableProfile 
    // -------------------------------------

    @Schema(
            description = "Constant MassiveScanWebSimpleAvailableProfile_PROFILE_TYPE_ONLY_SCAN",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleAvailableProfile.PROFILE_TYPE_ONLY_SCAN,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleAvailableProfile_PROFILE_TYPE_ONLY_SCAN;

    @Schema(
            description = "Constant MassiveScanWebSimpleAvailableProfile_PROFILE_TYPE_SCAN_AND_SIGNATURE",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleAvailableProfile.PROFILE_TYPE_SCAN_AND_SIGNATURE,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleAvailableProfile_PROFILE_TYPE_SCAN_AND_SIGNATURE;

    @Schema(
            description = "Constant MassiveScanWebSimpleAvailableProfile_PROFILE_TYPE_SCAN_AND_SIGNATURE_AND_CUSTODY",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleAvailableProfile.PROFILE_TYPE_SCAN_AND_SIGNATURE_AND_CUSTODY,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleAvailableProfile_PROFILE_TYPE_SCAN_AND_SIGNATURE_AND_CUSTODY;

    // -------------------------------------
    //      MassiveScanWebSimpleStatus 
    // -------------------------------------

    @Schema(
            description = "Constant MassiveScanWebSimpleStatus_STATUS_REQUESTED_ID",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleStatus.STATUS_REQUESTED_ID,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleStatus_STATUS_REQUESTED_ID;

    @Schema(
            description = "Constant MassiveScanWebSimpleStatus_STATUS_IN_PROGRESS",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleStatus.STATUS_IN_PROGRESS,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleStatus_STATUS_IN_PROGRESS;

    @Schema(
            description = "Constant MassiveScanWebSimpleStatus_STATUS_FINAL_OK",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleStatus.STATUS_FINAL_OK,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public Integer MassiveScanWebSimpleStatus_STATUS_FINAL_OK;

    @Schema(
            description = "Constant MassiveScanWebSimpleStatus_STATUS_FINAL_ERROR",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleStatus.STATUS_FINAL_ERROR,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public Integer MassiveScanWebSimpleStatus_STATUS_FINAL_ERROR;

    @Schema(
            description = "Constant MassiveScanWebSimpleStatus_STATUS_CANCELLED",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleStatus.STATUS_CANCELLED,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleStatus_STATUS_CANCELLED;

    @Schema(
            description = "Constant MassiveScanWebSimpleStatus_STATUS_EXPIRED",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleStatus.STATUS_EXPIRED,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleStatus_STATUS_EXPIRED;

    // -------------------------------------
    //      MassiveScanWebSimpleArxiuRequiredParameters 
    // -------------------------------------

    /** public final static int DOCUMENTORIGEN_CIUTADA = 0; */

    @Schema(
            description = "Constant MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTORIGEN_CIUTADA",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTORIGEN_CIUTADA,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTORIGEN_CIUTADA;

    /** DOCUMENTORIGEN_ADMINISTRACIO = 1; */

    @Schema(
            description = "Constant MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTORIGEN_ADMINISTRACIO",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTORIGEN_ADMINISTRACIO,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTORIGEN_ADMINISTRACIO;

    /**
     * Original (Llei 11/2007 Art. 30)
     * 
     * @return"EE01"
     */
    @Schema(
            description = "Constant MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_ORIGINAL",
            nullable = false,
            defaultValue = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_ORIGINAL,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_ORIGINAL;

    /**
     * Còpia electrònica autèntica amb canvi de format (Llei 11/2007 Art. 30.1)."EE02"
     */
    @Schema(
            description = "Constant MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_COPIA_CF",
            nullable = false,
            defaultValue = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_COPIA_CF,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_COPIA_CF;

    /**
     * Còpia electrònica autèntica de document en paper amb canvi de format (Llei 11/2007 Art.
     * 30.2 i 30.3)."EE03"
     */
    @Schema(
            description = "Constant MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_COPIA_DP",
            nullable = false,
            defaultValue = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_COPIA_DP,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_COPIA_DP;

    /**
     * Còpia electrònica parcial autèntica."EE04";
     */
    @Schema(
            description = "Constant MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_COPIA_PR",
            nullable = false,
            defaultValue = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_COPIA_PR,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_COPIA_PR;

    /**
     * ALTRES("EE99"): Altres estats d'elaboració.
     */
    @Schema(
            description = "Constant MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_ALTRES",
            nullable = false,
            defaultValue = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_ALTRES,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleArxiuRequiredParameters_DOCUMENTELABORATIONSTATE_ALTRES;

    // -------------------------------------
    //      MassiveScanWebSimpleScannedFileInfo 
    // -------------------------------------

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_PDF",
            nullable = false,
            defaultValue = MassiveScanWebSimpleScannedFileInfo.FORMAT_FILE_PDF,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_PDF;

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_JPG",
            nullable = false,
            defaultValue = MassiveScanWebSimpleScannedFileInfo.FORMAT_FILE_JPG,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_JPG;

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_TIFF",
            nullable = false,
            defaultValue = MassiveScanWebSimpleScannedFileInfo.FORMAT_FILE_TIFF,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_TIFF;

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_PNG",
            nullable = false,
            defaultValue = MassiveScanWebSimpleScannedFileInfo.FORMAT_FILE_PNG,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_PNG;

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_GIF",
            nullable = false,
            defaultValue = MassiveScanWebSimpleScannedFileInfo.FORMAT_FILE_GIF,
            implementation = String.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public String MassiveScanWebSimpleScannedFileInfo_FORMAT_FILE_GIF;

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_PIXEL_TYPE_BLACK_WHITE",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_BLACK_WHITE,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleScannedFileInfo_PIXEL_TYPE_BLACK_WHITE;

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_PIXEL_TYPE_GRAY",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_GRAY,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleScannedFileInfo_PIXEL_TYPE_GRAY;

    @Schema(
            description = "Constant MassiveScanWebSimpleScannedFileInfo_PIXEL_TYPE_COLOR",
            nullable = false,
            defaultValue = "" + MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_COLOR,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int MassiveScanWebSimpleScannedFileInfo_PIXEL_TYPE_COLOR;
}