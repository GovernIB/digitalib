package es.caib.digitalib.logic.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleCommonArxiuCustody {

  /** eEMGDE.Firma.FormatoFirma.ValorCSV (eEMGDE17.3) */

  protected String csv;


  protected String originalFileURL;


  protected String printableFileURL;


  protected String eniFileURL;


  protected String csvValidationWeb;

  /**
   * eEMGDE.DefinicionGeneracionCSV (eEMGDE17.4):
   */

  protected String csvGenerationDefinition;


  protected String validationFileUrl;

  public ScanWebSimpleCommonArxiuCustody() {
    super();
  }

  public ScanWebSimpleCommonArxiuCustody(String csv, String originalFileURL,
      String printableFileURL, String eniFileURL, String csvValidationWeb,
      String csvGenerationDefinition, String validationFileUrl) {
    super();
    this.csv = csv;
    this.originalFileURL = originalFileURL;
    this.printableFileURL = printableFileURL;
    this.eniFileURL = eniFileURL;
    this.csvValidationWeb = csvValidationWeb;
    this.csvGenerationDefinition = csvGenerationDefinition;
    this.validationFileUrl = validationFileUrl;
  }

  public String getCsv() {
    return csv;
  }

  public void setCsv(String csv) {
    this.csv = csv;
  }

  public String getOriginalFileURL() {
    return originalFileURL;
  }

  public void setOriginalFileURL(String originalFileURL) {
    this.originalFileURL = originalFileURL;
  }

  public String getPrintableFileURL() {
    return printableFileURL;
  }

  public void setPrintableFileURL(String printableFileURL) {
    this.printableFileURL = printableFileURL;
  }

  public String getEniFileURL() {
    return eniFileURL;
  }

  public void setEniFileURL(String eniFileURL) {
    this.eniFileURL = eniFileURL;
  }

  public String getCsvValidationWeb() {
    return csvValidationWeb;
  }

  public void setCsvValidationWeb(String csvValidationWeb) {
    this.csvValidationWeb = csvValidationWeb;
  }

  public String getCsvGenerationDefinition() {
    return csvGenerationDefinition;
  }

  public void setCsvGenerationDefinition(String csvGenerationDefinition) {
    this.csvGenerationDefinition = csvGenerationDefinition;
  }

  public String getValidationFileUrl() {
    return validationFileUrl;
  }

  public void setValidationFileUrl(String validationFileUrl) {
    this.validationFileUrl = validationFileUrl;
  }

}
