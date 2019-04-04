package org.fundaciobit.apisib.apiscanwebsimple.v1.beans;

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

  protected String procedimentNom; // = "Subvenciones empleo"

  protected String procedimentCodi; // = "organo1_PRO_123456789";

  // = "S0001"
  protected String serieDocumental;

  /**
   * Si val null llavors en crearà un de nou
   */
  protected String custodyOrExpedientID;

  public ScanWebSimpleArxiuOptionalParameters() {
    super();
  }

  public ScanWebSimpleArxiuOptionalParameters(String procedimentNom, String procedimentCodi,
      String serieDocumental, String custodyOrExpedientID) {
    super();
    this.procedimentNom = procedimentNom;
    this.procedimentCodi = procedimentCodi;
    this.serieDocumental = serieDocumental;
    this.custodyOrExpedientID = custodyOrExpedientID;
  }

  public String getProcedimentNom() {
    return procedimentNom;
  }

  public void setProcedimentNom(String procedimentNom) {
    this.procedimentNom = procedimentNom;
  }

  public String getProcedimentCodi() {
    return procedimentCodi;
  }

  public void setProcedimentCodi(String procedimentCodi) {
    this.procedimentCodi = procedimentCodi;
  }

  public String getSerieDocumental() {
    return serieDocumental;
  }

  public void setSerieDocumental(String serieDocumental) {
    this.serieDocumental = serieDocumental;
  }

  public String getCustodyOrExpedientID() {
    return custodyOrExpedientID;
  }

  public void setCustodyOrExpedientID(String custodyOrExpedientID) {
    this.custodyOrExpedientID = custodyOrExpedientID;
  }

}