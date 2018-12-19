package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
public class ScanWebSimpleCommonArxiuCustody {

  /** eEMGDE.Firma.FormatoFirma.ValorCSV (eEMGDE17.3) */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String csv;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String originalFileURL;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String printableFileURL;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String eniFileURL;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String csvValidationWeb;

  /**
   * eEMGDE.DefinicionGeneracionCSV (eEMGDE17.4):
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String csvGenerationDefinition;

  public ScanWebSimpleCommonArxiuCustody() {
    super();
  }

  public ScanWebSimpleCommonArxiuCustody(String csv, String originalFileURL,
      String printableFileURL, String eniFileURL, String csvValidationWeb,
      String csvGenerationDefinition) {
    super();
    this.csv = csv;
    this.originalFileURL = originalFileURL;
    this.printableFileURL = printableFileURL;
    this.eniFileURL = eniFileURL;
    this.csvValidationWeb = csvValidationWeb;
    this.csvGenerationDefinition = csvGenerationDefinition;
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

}
