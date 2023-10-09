package es.caib.digitalib.logic.apiscanwebsimple.v1.beans;

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
public class ScanWebSimpleArxiuOptionalParameters {

  protected String procedureName; // = "Subvenciones empleo"

  protected String procedureCode; // = "organo1_PRO_123456789";

  /** Serie Documental = "S0001" */
  protected String documentarySerie;

  /**
   * Custòdia o expedient ja existent. Si val null llavors en crearà un de nou
   */
  protected String custodyIDOrExpedientID;

  public ScanWebSimpleArxiuOptionalParameters() {
    super();
  }

  public ScanWebSimpleArxiuOptionalParameters(String procedureName, String procedureCode,
      String documentarySerie, String custodyIDOrExpedientID) {
    super();
    this.procedureName = procedureName;
    this.procedureCode = procedureCode;
    this.documentarySerie = documentarySerie;
    this.custodyIDOrExpedientID = custodyIDOrExpedientID;
  }

  public String getProcedureName() {
    return procedureName;
  }

  public void setProcedureName(String procedureName) {
    this.procedureName = procedureName;
  }

  public String getProcedureCode() {
    return procedureCode;
  }

  public void setProcedureCode(String procedureCode) {
    this.procedureCode = procedureCode;
  }

  public String getDocumentarySerie() {
    return documentarySerie;
  }

  public void setDocumentarySerie(String documentarySerie) {
    this.documentarySerie = documentarySerie;
  }

  public String getCustodyIDOrExpedientID() {
    return custodyIDOrExpedientID;
  }

  public void setCustodyIDOrExpedientID(String custodyIDOrExpedientID) {
    this.custodyIDOrExpedientID = custodyIDOrExpedientID;
  }

}
