package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

import java.util.Date;

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
public class MassiveScanWebSimpleScannedFileInfo {

    public static final String FORMAT_FILE_PDF = "pdf";

    public static final String FORMAT_FILE_JPG = "jpg";

    public static final String FORMAT_FILE_TIFF = "tif";

    public static final String FORMAT_FILE_PNG = "png";

    public static final String FORMAT_FILE_GIF = "gif";

    public static final int PIXEL_TYPE_BLACK_WHITE = 0;

    public static final int PIXEL_TYPE_GRAY = 1;

    public static final int PIXEL_TYPE_COLOR = 2;

    protected String transactionName;

    protected Date scanDate;

    /** Pixel Type. Null significa que no ho sab. Exemples: B&W Gray Color **/
    protected Integer pixelType;

    /**
     * píxeles por pulgada. Null significa que no ho sab. Exemples: 100, 150, 20, ... 300, ...
     **/
    protected Integer pppResolution;

    /** Null significa que no ho sab. Exemples BMP JPEG TIFF PNG PDF **/
    protected String formatFile;

    /** Null significa que no ho sab. **/
    protected Boolean ocr;

    /** Null significa que no ho sab. **/
    protected Boolean duplex;

    /**
     * @see MetadataConstants.PAPER_SIZE
     * @see MetadataConstants._PAPER_SIZE
     */
    protected String paperSize;

    protected String documentLanguage;

    /**
     * @see org.fundaciobit.pluginsib.core.utils.MetadataConstants#_ENI_TIPO_DOCUMENTAL
     *
     * @see org.fundaciobit.pluginsib.core.utils.MetadataConstants#TIPO_DOCUMENTAL_TD01_RESOLUCIO
     * @see org.fundaciobit.pluginsib.core.utils.MetadataConstants#TIPO_DOCUMENTAL_TD02_ACORD
     * @see org.fundaciobit.pluginsib.core.utils.MetadataConstants#TIPO_DOCUMENTAL_TD03_CONTRACTE
     *      ...
     * @see org.fundaciobit.pluginsib.core.utils.MetadataConstants#TIPO_DOCUMENTAL_TD99_ALTRES
     * 
     */
    protected String documentType;

    public MassiveScanWebSimpleScannedFileInfo() {
        super();
    }

    public MassiveScanWebSimpleScannedFileInfo(String transactionName, Date scanDate,
            Integer pixelType, Integer pppResolution, String formatFile, Boolean ocr,
            Boolean duplex, String paperSize, String documentLanguage, String documentType) {
        super();
        this.transactionName = transactionName;
        this.scanDate = scanDate;
        this.pixelType = pixelType;
        this.pppResolution = pppResolution;
        this.formatFile = formatFile;
        this.ocr = ocr;
        this.duplex = duplex;
        this.paperSize = paperSize;
        this.documentLanguage = documentLanguage;
        this.documentType = documentType;
    }

    public Integer getPixelType() {
        return pixelType;
    }

    public void setPixelType(Integer pixelType) {
        this.pixelType = pixelType;
    }

    public Integer getPppResolution() {
        return pppResolution;
    }

    public void setPppResolution(Integer pppResolution) {
        this.pppResolution = pppResolution;
    }

    public String getFormatFile() {
        return formatFile;
    }

    public void setFormatFile(String formatFile) {
        this.formatFile = formatFile;
    }

    public Boolean getOcr() {
        return ocr;
    }

    public void setOcr(Boolean ocr) {
        this.ocr = ocr;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public Date getScanDate() {
        return scanDate;
    }

    public void setScanDate(Date scanDate) {
        this.scanDate = scanDate;
    }

    public Boolean getDuplex() {
        return duplex;
    }

    public void setDuplex(Boolean duplex) {
        this.duplex = duplex;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public String getDocumentLanguage() {
        return documentLanguage;
    }

    public void setDocumentLanguage(String documentLanguage) {
        this.documentLanguage = documentLanguage;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

}
