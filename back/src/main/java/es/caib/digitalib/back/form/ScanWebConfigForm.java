package es.caib.digitalib.back.form;

import java.util.Set;

/**
 * 
 * @author anadal
 * 
 */
public class ScanWebConfigForm {

  protected String type;

  protected Set<String> flags;

  // S => Sincon i A => Asincron
  protected String mode;
  
  protected String langUI;

  String id;

  public ScanWebConfigForm() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLangUI() {
    return langUI;
  }

  public void setLangUI(String langUI) {
    this.langUI = langUI;
  }

  public Set<String> getFlags() {
    return flags;
  }

  public void setFlags(Set<String> flags) {
    this.flags = flags;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

}
