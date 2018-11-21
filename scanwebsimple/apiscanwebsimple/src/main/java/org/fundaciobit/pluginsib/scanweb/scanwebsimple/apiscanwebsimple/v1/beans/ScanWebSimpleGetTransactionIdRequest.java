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

  // Perfil d'Escaneig definit en el servidor intermig
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String scanWebProfile;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String languageUI;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String languageDoc;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String usernameRequest;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String ciutadaNif;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String ciutadaNom;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String funcionariUsername;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String funcionariNom;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  String expedientID;

  public ScanWebSimpleGetTransactionIdRequest() {
    super();
  }

  public ScanWebSimpleGetTransactionIdRequest(String scanWebProfile, String languageUI,
      String languageDoc, String usernameRequest, String ciutadaNif, String ciutadaNom,
      String funcionariUsername, String funcionariNom, String expedientID) {
    super();
    this.scanWebProfile = scanWebProfile;
    this.languageUI = languageUI;
    this.languageDoc = languageDoc;
    this.usernameRequest = usernameRequest;
    this.ciutadaNif = ciutadaNif;
    this.ciutadaNom = ciutadaNom;
    this.funcionariUsername = funcionariUsername;
    this.funcionariNom = funcionariNom;
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

}
