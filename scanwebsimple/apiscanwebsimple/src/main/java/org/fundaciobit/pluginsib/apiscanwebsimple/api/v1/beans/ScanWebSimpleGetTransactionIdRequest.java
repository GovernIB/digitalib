package org.fundaciobit.pluginsib.apiscanwebsimple.api.v1.beans;

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

  /**
   * Obligatori tant si es funcionari com si no (~ usernameRequest)
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String funcionariUsername;

  /**
   * Obligatori si el perfil requereix firma
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected ScanWebSimpleSignatureParameters signatureParameters;

  /**
   * Obligatori si el perfil requeix Arxiu o Custodia
   */
  protected ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;

  protected ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;

  public ScanWebSimpleGetTransactionIdRequest() {
    super();
  }

  /**
   * Constructor per Only_Scan
   * 
   * @param scanWebProfile
   * @param view
   * @param languageUI
   * @param funcionariUsername
   */
  public ScanWebSimpleGetTransactionIdRequest(String scanWebProfile, int view,
      String languageUI, String funcionariUsername) {
    super();
    this.scanWebProfile = scanWebProfile;
    this.view = view;
    this.languageUI = languageUI;
    this.funcionariUsername = funcionariUsername;
  }

  /**
   * Constructor per Only_Scan + Signature
   * 
   * @param scanWebProfile
   * @param view
   * @param languageUI
   * @param funcionariUsername
   * @param signatureParameters
   */
  public ScanWebSimpleGetTransactionIdRequest(String scanWebProfile, int view,
      String languageUI, String funcionariUsername,
      ScanWebSimpleSignatureParameters signatureParameters) {
    super();
    this.scanWebProfile = scanWebProfile;
    this.view = view;
    this.languageUI = languageUI;
    this.funcionariUsername = funcionariUsername;
    this.signatureParameters = signatureParameters;
  }

  /**
   * Constructor per Only_Scan + Signature + Arxiu
   * 
   * @param scanWebProfile
   * @param view
   * @param languageUI
   * @param funcionariUsername
   * @param signatureParameters
   * @param arxiuRequiredParameters
   * @param arxiuOptionalParameters
   */
  public ScanWebSimpleGetTransactionIdRequest(String scanWebProfile, int view,
      String languageUI, String funcionariUsername,
      ScanWebSimpleSignatureParameters signatureParameters,
      ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters,
      ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters) {
    super();
    this.scanWebProfile = scanWebProfile;
    this.view = view;
    this.languageUI = languageUI;
    this.funcionariUsername = funcionariUsername;
    this.signatureParameters = signatureParameters;
    this.arxiuRequiredParameters = arxiuRequiredParameters;
    this.arxiuOptionalParameters = arxiuOptionalParameters;
  }

  public String getScanWebProfile() {
    return scanWebProfile;
  }

  public void setScanWebProfile(String scanWebProfile) {
    this.scanWebProfile = scanWebProfile;
  }

  public int getView() {
    return view;
  }

  public void setView(int view) {
    this.view = view;
  }

  public String getLanguageUI() {
    return languageUI;
  }

  public void setLanguageUI(String languageUI) {
    this.languageUI = languageUI;
  }

  public String getFuncionariUsername() {
    return funcionariUsername;
  }

  public void setFuncionariUsername(String funcionariUsername) {
    this.funcionariUsername = funcionariUsername;
  }

  public ScanWebSimpleSignatureParameters getSignatureParameters() {
    return signatureParameters;
  }

  public void setSignatureParameters(ScanWebSimpleSignatureParameters signatureParameters) {
    this.signatureParameters = signatureParameters;
  }

  public ScanWebSimpleArxiuRequiredParameters getArxiuRequiredParameters() {
    return arxiuRequiredParameters;
  }

  public void setArxiuRequiredParameters(
      ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters) {
    this.arxiuRequiredParameters = arxiuRequiredParameters;
  }

  public ScanWebSimpleArxiuOptionalParameters getArxiuOptionalParameters() {
    return arxiuOptionalParameters;
  }

  public void setArxiuOptionalParameters(
      ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters) {
    this.arxiuOptionalParameters = arxiuOptionalParameters;
  }

}
