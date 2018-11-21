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

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String code;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String name;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String description;

  public ScanWebSimpleAvailableProfile() {
    super();
  }

  /**
   * 
   * @param code
   * @param name
   * @param description
   */
  public ScanWebSimpleAvailableProfile(String code, String name, String description) {
    super();
    this.code = code;
    this.name = name;
    this.description = description;
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

}
