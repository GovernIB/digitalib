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
public class MassiveScanWebSimpleCustodyInfo extends MassiveScanWebSimpleCommonArxiuCustody {


  protected String custodyID;

  public MassiveScanWebSimpleCustodyInfo() {
    super();
  }

  public MassiveScanWebSimpleCustodyInfo(String custodyID, String csv, String originalFileURL,
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
