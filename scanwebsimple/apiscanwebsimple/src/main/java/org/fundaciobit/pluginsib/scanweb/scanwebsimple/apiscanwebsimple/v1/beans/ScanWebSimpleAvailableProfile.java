package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

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
public class ScanWebSimpleAvailableProfile {

  public static final int PROFILE_TYPE_ONLY_SCAN = 1;
  public static final int PROFILE_TYPE_SCAN_AND_SIGNATURE = 2;
  public static final int PROFILE_TYPE_SCAN_AND_SIGNATURE_AND_CUSTODY = 3;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String code;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String name;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String description;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected int profileType;

  /**
   * 
   */
  public ScanWebSimpleAvailableProfile() {
    super();
  }

  /**
   * 
   * @param code
   * @param name
   * @param description
   */
  public ScanWebSimpleAvailableProfile(String code, String name, String description,
      int profileType) {
    super();
    this.code = code;
    this.name = name;
    this.description = description;
    this.profileType = profileType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getProfileType() {
    return profileType;
  }

  public void setProfileType(int profileType) {
    this.profileType = profileType;
  }

}
