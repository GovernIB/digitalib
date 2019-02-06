package org.fundaciobit.pluginsib.apiscanwebsimple.api.v1.beans;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
public class ScanWebSimpleArxiuOptionalParameters {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String procedimentNom; // = "Subvenciones empleo"

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String procedimentCodi; // = "organo1_PRO_123456789";

  // "A04013511";
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected List<String> organs; // = "A04013511";

  // = "S0001"
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String serieDocumental;

  /**
   * Si val null llavors en crearà un de nou
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String custodyOrExpedientID;

  public ScanWebSimpleArxiuOptionalParameters() {
    super();
  }

  public ScanWebSimpleArxiuOptionalParameters(String procedimentNom, String procedimentCodi,
      List<String> organs, String serieDocumental, String custodyOrExpedientID) {
    super();
    this.procedimentNom = procedimentNom;
    this.procedimentCodi = procedimentCodi;
    this.organs = organs;
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

  public List<String> getOrgans() {
    return organs;
  }

  public void setOrgans(List<String> organs) {
    this.organs = organs;
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
