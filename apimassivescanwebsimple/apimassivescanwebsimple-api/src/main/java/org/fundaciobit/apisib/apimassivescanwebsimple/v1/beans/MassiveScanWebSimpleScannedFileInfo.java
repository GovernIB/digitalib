package org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans;

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

  /** Pixel Type.  Null significa que no ho sab. Exemples: B&W Gray Color **/
  protected Integer pixelType;

  /** píxeles por pulgada.  Null significa que no ho sab. Exemples: 100, 150, 20, ... 300, ... **/
  protected Integer pppResolution;

  /** Null significa que no ho sab. Exemples BMP JPEG TIFF PNG PDF **/
  protected String formatFile;

  /** Null significa que no ho sab. **/
  protected Boolean ocr;

  public MassiveScanWebSimpleScannedFileInfo() {
    super();
  }

  public MassiveScanWebSimpleScannedFileInfo(Integer pixelType, Integer pppResolution,
      String formatFile, Boolean ocr) {
    super();
    this.pixelType = pixelType;
    this.pppResolution = pppResolution;
    this.formatFile = formatFile;
    this.ocr = ocr;
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

}
