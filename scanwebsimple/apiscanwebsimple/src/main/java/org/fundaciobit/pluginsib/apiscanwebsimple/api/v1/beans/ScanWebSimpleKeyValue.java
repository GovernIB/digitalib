package org.fundaciobit.pluginsib.apiscanwebsimple.api.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * 
 * @author anadal
 *
 */
@XmlRootElement
public class ScanWebSimpleKeyValue {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String key;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String value;

  /**
 * 
 */
  public ScanWebSimpleKeyValue() {
    super();
  }

  /**
   * @param key
   * @param value
   */
  public ScanWebSimpleKeyValue(String key, String value) {
    super();
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
