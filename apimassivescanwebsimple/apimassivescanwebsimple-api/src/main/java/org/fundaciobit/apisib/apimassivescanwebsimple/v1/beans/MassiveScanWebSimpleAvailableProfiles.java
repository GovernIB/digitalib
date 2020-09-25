package org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans;

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
public class MassiveScanWebSimpleAvailableProfiles {


  protected List<MassiveScanWebSimpleAvailableProfile> availableProfiles = null;

  /**
   * 
   */
  public MassiveScanWebSimpleAvailableProfiles() {
    super();
  }

  /**
   * 
   * @param availableProfiles
   */
  public MassiveScanWebSimpleAvailableProfiles(List<MassiveScanWebSimpleAvailableProfile> availableProfiles) {
    super();
    this.availableProfiles = availableProfiles;
  }

  public List<MassiveScanWebSimpleAvailableProfile> getAvailableProfiles() {
    return availableProfiles;
  }

  public void setAvailableProfiles(List<MassiveScanWebSimpleAvailableProfile> availableProfiles) {
    this.availableProfiles = availableProfiles;
  }

}
