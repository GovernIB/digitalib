package es.caib.digitalib.logic.apiscanwebsimple.v1.beans;

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
public class ScanWebSimpleCustodyInfo extends ScanWebSimpleCommonArxiuCustody {


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
