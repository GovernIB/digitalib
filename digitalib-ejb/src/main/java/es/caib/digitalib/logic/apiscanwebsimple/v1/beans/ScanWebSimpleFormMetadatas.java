package es.caib.digitalib.logic.apiscanwebsimple.v1.beans;

import java.util.Arrays;
import java.util.List;

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
public class ScanWebSimpleFormMetadatas {

  protected String transactionName;

  protected String functionaryUsername = null;

  /**
   * Obligatori si el perfil requereix firma
   */
  protected ScanWebSimpleSignatureParameters signatureParameters;

  /**
   * Obligatori si el perfil requeix Arxiu o Custodia
   */
  protected ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;

  /**
   * Paràmetres opcionals per Arxiu o Custòdia
   */
  protected ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;

  /**
   * Propietats del Formulari Addicionals
   */
  protected List<ScanWebSimpleKeyValue> additionalMetadatas = null;

  public ScanWebSimpleFormMetadatas() {
    super();
  }

  public ScanWebSimpleFormMetadatas(String transactionName, String functionaryUsername,
      ScanWebSimpleSignatureParameters signatureParameters,
      ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters,
      ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters,
      List<ScanWebSimpleKeyValue> additionalMetadatas) {
    super();
    this.transactionName = transactionName;
    this.functionaryUsername = functionaryUsername;
    this.signatureParameters = signatureParameters;
    this.arxiuRequiredParameters = arxiuRequiredParameters;
    this.arxiuOptionalParameters = arxiuOptionalParameters;
    this.additionalMetadatas = additionalMetadatas;
  }

  public String getTransactionName() {
    return transactionName;
  }

  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }

  public String getFunctionaryUsername() {
    return functionaryUsername;
  }

  public void setFunctionaryUsername(String functionaryUsername) {
    this.functionaryUsername = functionaryUsername;
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

  public List<ScanWebSimpleKeyValue> getAdditionalMetadatas() {
    return additionalMetadatas;
  }

  public void setAdditionalMetadatas(List<ScanWebSimpleKeyValue> additionalMetadatas) {
    this.additionalMetadatas = additionalMetadatas;
  }

  public static String toString(ScanWebSimpleFormMetadatas formMetadatas) {

    if (formMetadatas == null) {
      return "";
    }

    StringBuffer str = new StringBuffer();

    str.append("\n").append("  + FORM METADATAS");

    str.append("\n").append("      * Transaction Name: ")
        .append(formMetadatas.getTransactionName());

    if (formMetadatas.getFunctionaryUsername() != null) {
      str.append("\n").append("      * Functionary Username:")
          .append(formMetadatas.getFunctionaryUsername());
    }

    // -----------------
    // SIGNATURA
    // -----------------

    ScanWebSimpleSignatureParameters signatureParameters = formMetadatas
        .getSignatureParameters();
    if (signatureParameters != null) {

      str.append("\n").append("      * Functionary Full Name:")
          .append(signatureParameters.getFunctionaryFullName());

      str.append("\n").append("      * Functionary AdministrationID:")
          .append(signatureParameters.getFunctionaryAdministrationID());

      str.append("\n").append("      * Document Language:")
          .append(signatureParameters.getDocumentLanguage());

    }

    // -----------------
    // ARXIU: VALORS REQUERITS
    // -----------------

    ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters = formMetadatas
        .getArxiuRequiredParameters();
    if (arxiuRequiredParameters != null) {

      // NIF del ciutadà
      str.append("\n").append("      * citizenAdministrationID:")
          .append(arxiuRequiredParameters.getCitizenAdministrationID());

      // Nom complet del ciutada
      str.append("\n").append("      * citizenFullName:")
          .append(arxiuRequiredParameters.getCitizenFullName());

      /**
       * Document Estat Elaboració EE01 - Original EE02 - Còpia electrònica autèntica amb canvi
       * de format EE03 - Còpia electrònica autèntica de document en paper EE04 - Còpia
       * electrònica parcial autèntica EE99 - Altres
       */
      str.append("\n").append("      * Document Estat Elaboracio:")
          .append(arxiuRequiredParameters.getDocumentElaborationState());

      /**
       * Document Tipus: TD01 - Resolució,TD02 - Acord,TD03 - Contracte,TD04 - Conveni, TD05 -
       * Declaració,TD06 - Comunicació,TD07 - Notificació,TD08 - Publicació, TD09 - Justificant
       * recepció,TD10 - Acta,TD11 - Certificat,TD12 - Diligència, TD13 - Informe,TD14 -
       * Sol·licitud,TD15 - Denúncia, TD16 - Al·legació,TD17 - Recurs,TD18 - Comunicació
       * ciutadà,TD19 - Factura, TD20 - Altres incautats,TD99 - Altres,
       */
      str.append("\n").append("      * Document Type:")
          .append(arxiuRequiredParameters.getDocumentType());

      /**
       * Origen: 1 =>Administració 0 =>Ciutadà
       */
      {
        Integer origen = arxiuRequiredParameters.getDocumentOrigen();
        str.append("\n").append("      * Document Origen:")
            .append((origen == null ? "null" : (origen == 0) ? "Ciutadà" : "Administració"));
      }

      // Interessats
      {
        List<String> interessats = arxiuRequiredParameters.getInterestedPersons();
        str.append("\n").append("      * Persones Interessades: ");
        if (interessats == null || interessats.size() == 0) {
          str.append(" null");
        } else {
          str.append(Arrays.toString(interessats.toArray()));
        }
      }

      /**
       * Codi DIR3 dels organs afectats si són administracions públiques o CIF si són empreses
       * externes
       */
      {
        str.append("\n").append("      * Organismes Afectats: ");
        List<String> organs = arxiuRequiredParameters.getAffectedOrganisms();
        if (organs == null || organs.size() == 0) {
          str.append(" null");
        } else {
          str.append(Arrays.toString(organs.toArray()));
        }
      }

    }

    ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = formMetadatas
        .getArxiuOptionalParameters();

    if (arxiuOptionalParameters != null) {

      str.append("\n").append("      * Nom del Procediment:")
          .append(arxiuOptionalParameters.getProcedureName());

      str.append("\n").append("      * Codi del Procediment:")
          .append(arxiuOptionalParameters.getProcedureCode());

      // Serie Documental = "S0001"
      str.append("\n").append("      * Serie Documental:")
          .append(arxiuOptionalParameters.getDocumentarySerie());

      // Custòdia o expedient ja existent. Si val null llavors en crearà un de nou
      str.append("\n").append("      * CustodyID o ExpedientID:")
          .append(arxiuOptionalParameters.getCustodyIDOrExpedientID());

    }

    /**
     * Propietats del Formulari Addicionals
     */
    {
      List<ScanWebSimpleKeyValue> list = formMetadatas.getAdditionalMetadatas();
      str.append("\n").append("    + Additional Metadatas:");
      if (list == null || list.size() == 0) {
        str.append("  << EMPTY >>");
      } else {
        for (ScanWebSimpleKeyValue kv : list) {
          str.append("\n").append("       - ").append(kv.getKey()).append(" => ]")
              .append(kv.getValue()).append("[");
        }
      }
    }

    return str.toString();
  }
}
