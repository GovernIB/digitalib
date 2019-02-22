package org.fundaciobit.apisib.apiscanwebsimple.v1.beans;

import java.util.List;

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
public class ScanWebSimpleAvailableProfiles {


  protected List<ScanWebSimpleAvailableProfile> availableProfiles = null;

  /**
   * 
   */
  public ScanWebSimpleAvailableProfiles() {
    super();
  }

  /**
   * 
   * @param availableProfiles
   */
  public ScanWebSimpleAvailableProfiles(List<ScanWebSimpleAvailableProfile> availableProfiles) {
    super();
    this.availableProfiles = availableProfiles;
  }

  public List<ScanWebSimpleAvailableProfile> getAvailableProfiles() {
    return availableProfiles;
  }

  public void setAvailableProfiles(List<ScanWebSimpleAvailableProfile> availableProfiles) {
    this.availableProfiles = availableProfiles;
  }

}
