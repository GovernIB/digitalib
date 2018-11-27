package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
public class ScanWebSimpleGetTransactionIdRequest {

  public static final int VIEW_FULLSCREEN = 0; // "fullview";

  public static final int VIEW_IFRAME = 1; // "iframe";

  // Perfil d'Escaneig definit en el servidor intermig
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String scanWebProfile;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected int view;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String languageUI;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String languageDoc;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String usernameRequest;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String ciutadaNif;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String ciutadaNom;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String funcionariUsername;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String funcionariNom;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String funcionariNif;

  // XYZ ZZZ
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String expedientID;

  public ScanWebSimpleGetTransactionIdRequest() {
    super();
  }

  // XYZ ZZZ Fer constructors per escaneig, per copia autentic ai per custòdia

  public ScanWebSimpleGetTransactionIdRequest(String scanWebProfile, int view,
      String languageUI, String languageDoc, String usernameRequest, String ciutadaNif,
      String ciutadaNom, String funcionariUsername, String funcionariNom,
      String funcionariNif, String expedientID) {
    super();
    this.scanWebProfile = scanWebProfile;
    this.view = view;
    this.languageUI = languageUI;
    this.languageDoc = languageDoc;
    this.usernameRequest = usernameRequest;
    this.ciutadaNif = ciutadaNif;
    this.ciutadaNom = ciutadaNom;
    this.funcionariUsername = funcionariUsername;
    this.funcionariNom = funcionariNom;
    this.funcionariNif = funcionariNif;
    this.expedientID = expedientID;
  }

  public String getScanWebProfile() {
    return scanWebProfile;
  }

  public void setScanWebProfile(String scanWebProfile) {
    this.scanWebProfile = scanWebProfile;
  }

  public String getLanguageUI() {
    return languageUI;
  }

  public void setLanguageUI(String languageUI) {
    this.languageUI = languageUI;
  }

  public String getLanguageDoc() {
    return languageDoc;
  }

  public void setLanguageDoc(String languageDoc) {
    this.languageDoc = languageDoc;
  }

  public String getUsernameRequest() {
    return usernameRequest;
  }

  public void setUsernameRequest(String usernameRequest) {
    this.usernameRequest = usernameRequest;
  }

  public String getCiutadaNif() {
    return ciutadaNif;
  }

  public void setCiutadaNif(String ciutadaNif) {
    this.ciutadaNif = ciutadaNif;
  }

  public String getCiutadaNom() {
    return ciutadaNom;
  }

  public void setCiutadaNom(String ciutadaNom) {
    this.ciutadaNom = ciutadaNom;
  }

  public String getFuncionariUsername() {
    return funcionariUsername;
  }

  public void setFuncionariUsername(String funcionariUsername) {
    this.funcionariUsername = funcionariUsername;
  }

  public String getFuncionariNom() {
    return funcionariNom;
  }

  public void setFuncionariNom(String funcionariNom) {
    this.funcionariNom = funcionariNom;
  }

  public String getExpedientID() {
    return expedientID;
  }

  public void setExpedientID(String expedientID) {
    this.expedientID = expedientID;
  }

  public int getView() {
    return view;
  }

  public void setView(int view) {
    this.view = view;
  }

  public String getFuncionariNif() {
    return funcionariNif;
  }

  public void setFuncionariNif(String funcionariNif) {
    this.funcionariNif = funcionariNif;
  }

}
