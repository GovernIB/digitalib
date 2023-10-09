package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

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
public class MassiveScanWebSimpleAvailableProfile {

  public static final int PROFILE_TYPE_ONLY_SCAN = 1;
  public static final int PROFILE_TYPE_SCAN_AND_SIGNATURE = 2;
  public static final int PROFILE_TYPE_SCAN_AND_SIGNATURE_AND_CUSTODY = 3;

  protected String code;

  protected String name;

  protected String description;

  protected int profileType;

  /**
   * 
   */
  public MassiveScanWebSimpleAvailableProfile() {
    super();
  }

  /**
   * 
   * @param code
   * @param name
   * @param description
   */
  public MassiveScanWebSimpleAvailableProfile(String code, String name, String description,
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
