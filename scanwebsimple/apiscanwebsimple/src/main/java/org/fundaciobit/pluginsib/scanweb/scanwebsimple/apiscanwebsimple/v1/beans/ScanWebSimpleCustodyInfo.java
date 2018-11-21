package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
public class ScanWebSimpleCustodyInfo {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String custodyFileID;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String custodyFileURL;

  /** eEMGDE.Firma.FormatoFirma.ValorCSV (eEMGDE17.3) */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String custodyFileCSV;

  /**
   * eEMGDE.DefinicionGeneracionCSV (eEMGDE17.4):
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String custodyFileCSVGenerationDefinition;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String custodyFileCSVValidationWeb;

  public ScanWebSimpleCustodyInfo() {
    super();
  }

  public ScanWebSimpleCustodyInfo(String custodyFileID, String custodyFileURL,
      String custodyFileCSV, String custodyFileCSVGenerationDefinition,
      String custodyFileCSVValidationWeb) {
    super();
    this.custodyFileID = custodyFileID;
    this.custodyFileURL = custodyFileURL;
    this.custodyFileCSV = custodyFileCSV;
    this.custodyFileCSVGenerationDefinition = custodyFileCSVGenerationDefinition;
    this.custodyFileCSVValidationWeb = custodyFileCSVValidationWeb;
  }

  public String getCustodyFileID() {
    return custodyFileID;
  }

  public void setCustodyFileID(String custodyFileID) {
    this.custodyFileID = custodyFileID;
  }

  public String getCustodyFileURL() {
    return custodyFileURL;
  }

  public void setCustodyFileURL(String custodyFileURL) {
    this.custodyFileURL = custodyFileURL;
  }

  public String getCustodyFileCSV() {
    return custodyFileCSV;
  }

  public void setCustodyFileCSV(String custodyFileCSV) {
    this.custodyFileCSV = custodyFileCSV;
  }

  public String getCustodyFileCSVGenerationDefinition() {
    return custodyFileCSVGenerationDefinition;
  }

  public void setCustodyFileCSVGenerationDefinition(String custodyFileCSVGenerationDefinition) {
    this.custodyFileCSVGenerationDefinition = custodyFileCSVGenerationDefinition;
  }

  public String getCustodyFileCSVValidationWeb() {
    return custodyFileCSVValidationWeb;
  }

  public void setCustodyFileCSVValidationWeb(String custodyFileCSVValidationWeb) {
    this.custodyFileCSVValidationWeb = custodyFileCSVValidationWeb;
  }

}
