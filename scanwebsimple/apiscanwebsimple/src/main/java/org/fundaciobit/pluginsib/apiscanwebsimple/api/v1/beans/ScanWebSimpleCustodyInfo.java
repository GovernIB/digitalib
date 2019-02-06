package org.fundaciobit.pluginsib.apiscanwebsimple.api.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
public class ScanWebSimpleCustodyInfo extends ScanWebSimpleCommonArxiuCustody {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String custodyID;

  public ScanWebSimpleCustodyInfo() {
    super();
  }

  public ScanWebSimpleCustodyInfo(String custodyID, String csv, String originalFileURL,
      String printableFileURL, String eniFileURL, String csvValidationWeb,
      String csvGenerationDefinition, String validationFileUrl) {
    super(csv, originalFileURL, printableFileURL, eniFileURL, csvValidationWeb,
        csvGenerationDefinition, validationFileUrl);
    this.custodyID = custodyID;
  }

  public String getCustodyID() {
    return custodyID;
  }

  public void setCustodyID(String custodyID) {
    this.custodyID = custodyID;
  }

}
