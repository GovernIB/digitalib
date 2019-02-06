package org.fundaciobit.pluginsib.apiscanwebsimple.api.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
public class ScanWebSimpleArxiuInfo extends ScanWebSimpleCommonArxiuCustody {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String expedientID;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String documentID;

  public ScanWebSimpleArxiuInfo() {
    super();
  }

  public ScanWebSimpleArxiuInfo(String expedientID, String documentID, String csv,
      String originalFileURL, String printableFileURL, String eniFileURL,
      String csvValidationWeb, String csvGenerationDefinition, String validationFileUrl) {
    super(csv, originalFileURL, printableFileURL, eniFileURL, csvValidationWeb,
        csvGenerationDefinition, validationFileUrl);
    this.expedientID = expedientID;
    this.documentID = documentID;
  }

  public String getExpedientID() {
    return expedientID;
  }

  public void setExpedientID(String expedientID) {
    this.expedientID = expedientID;
  }

  public String getDocumentID() {
    return documentID;
  }

  public void setDocumentID(String documentID) {
    this.documentID = documentID;
  }

}
