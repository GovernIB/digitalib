package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MassiveScanWebSimpleProfileRequest {

  protected String profileCode;
  protected String locale;

  public MassiveScanWebSimpleProfileRequest() {
    super();
  }

  public MassiveScanWebSimpleProfileRequest(String profileCode, String locale) {
    super();
    this.profileCode = profileCode;
    this.locale = locale;
  }

  public String getProfileCode() {
    return profileCode;
  }

  public void setProfileCode(String profileCode) {
    this.profileCode = profileCode;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

}
