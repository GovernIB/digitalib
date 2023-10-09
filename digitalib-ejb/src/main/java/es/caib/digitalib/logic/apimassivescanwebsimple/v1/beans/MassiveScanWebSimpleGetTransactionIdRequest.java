package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MassiveScanWebSimpleGetTransactionIdRequest {

  public static final int VIEW_FULLSCREEN = 0; // "fullview";

  public static final int VIEW_IFRAME = 1; // "iframe";

  // Perfil d'Escaneig definit en el servidor intermig
  @Schema(required=true, description = "Perfil d'escaneig")
  protected String scanWebProfile;

  @Schema(nullable = false, type = "integer",  defaultValue = "" + VIEW_FULLSCREEN , description = "Tipus de Vista. Veure MassiveScanWebSimpleConstants.")
  protected int view;

  @Schema(required=true,defaultValue = "ca", description = "Idioma del document en ISO 639-1. Valors permesos 'ca' i 'es'", example = "ca", pattern = "^(ca|es)$")
  protected String languageUI;

  @Schema(required=true, description = "Nom descriptiu de la transacció d'escaneig.")
  protected String transactionName;

  /**
   * Obligatori tant si es funcionari com si no (~ usernameRequest)
   */
  @Schema(required=true, description = "Username del funcionari.")
  protected String funcionariUsername;

  /**
   * Obligatori si el perfil requereix firma
   */
  protected MassiveScanWebSimpleSignatureParameters signatureParameters;

  /**
   * Obligatori si el perfil requeix Arxiu o Custodia
   */
  protected MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;

  protected MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;

  public MassiveScanWebSimpleGetTransactionIdRequest() {
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
  public MassiveScanWebSimpleGetTransactionIdRequest(String transactionName,
      String scanWebProfile, int view, String languageUI, String funcionariUsername) {
    super();
    this.transactionName = transactionName;
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
  public MassiveScanWebSimpleGetTransactionIdRequest(String transactionName,
      String scanWebProfile, int view, String languageUI, String funcionariUsername,
      MassiveScanWebSimpleSignatureParameters signatureParameters) {
    super();
    this.transactionName = transactionName;
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
  public MassiveScanWebSimpleGetTransactionIdRequest(String transactionName,
      String scanWebProfile, int view, String languageUI, String funcionariUsername,
      MassiveScanWebSimpleSignatureParameters signatureParameters,
      MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters,
      MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters) {
    super();
    this.transactionName = transactionName;
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

  @Schema(required=true,nullable = false, type = "integer", format="int32", defaultValue = "" + VIEW_IFRAME , description = "Tipus de Vista. Veure MassiveScanWebSimpleConstants.")
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

  public MassiveScanWebSimpleSignatureParameters getSignatureParameters() {
    return signatureParameters;
  }

  public void setSignatureParameters(
      MassiveScanWebSimpleSignatureParameters signatureParameters) {
    this.signatureParameters = signatureParameters;
  }

  public MassiveScanWebSimpleArxiuRequiredParameters getArxiuRequiredParameters() {
    return arxiuRequiredParameters;
  }

  public void setArxiuRequiredParameters(
      MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters) {
    this.arxiuRequiredParameters = arxiuRequiredParameters;
  }

  public MassiveScanWebSimpleArxiuOptionalParameters getArxiuOptionalParameters() {
    return arxiuOptionalParameters;
  }

  public void setArxiuOptionalParameters(
      MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters) {
    this.arxiuOptionalParameters = arxiuOptionalParameters;
  }

  public String getTransactionName() {
    return transactionName;
  }

  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }

}
