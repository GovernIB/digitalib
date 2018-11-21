package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleAvailableProfiles {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
