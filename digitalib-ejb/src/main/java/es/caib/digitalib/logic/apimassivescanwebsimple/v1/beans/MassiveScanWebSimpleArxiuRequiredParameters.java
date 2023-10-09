package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

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
public class MassiveScanWebSimpleArxiuRequiredParameters {

  public final static int DOCUMENTORIGEN_CIUTADA = 0;
  public final static int DOCUMENTORIGEN_ADMINISTRACIO = 1;

  /**
   * Original (Llei 11/2007 Art. 30)
   * 
   * @return
   */
  public final static String DOCUMENTELABORATIONSTATE_ORIGINAL = "EE01";

  /**
   * Còpia electrònica autèntica amb canvi de format (Llei 11/2007 Art. 30.1).
   */
  public final static String DOCUMENTELABORATIONSTATE_COPIA_CF = "EE02";

  /**
   * Còpia electrònica autèntica de document en paper amb canvi de format (Llei 11/2007 Art.
   * 30.2 i 30.3).
   */
  public final static String DOCUMENTELABORATIONSTATE_COPIA_DP = "EE03";
  /**
   * Còpia electrònica parcial autèntica.
   */
  public final static String DOCUMENTELABORATIONSTATE_COPIA_PR = "EE04";

  /**
   * ALTRES("EE99"): Altres estats d'elaboració.
   */
  public final static String DOCUMENTELABORATIONSTATE_ALTRES = "EE99";

  /**
   * NIF del ciutadà
   */
  protected String citizenAdministrationID;

  /**
   * Nom complet del ciutada
   */
  protected String citizenFullName;

  /**
   * Document Estat Elaboració EE01 - Original EE02 - Còpia electrònica autèntica amb canvi de
   * format EE03 - Còpia electrònica autèntica de document en paper EE04 - Còpia electrònica
   * parcial autèntica EE99 - Altres
   * 
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_ORIGINAL
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_COPIA_CF
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_COPIA_DP
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_COPIA_PR
   */

  protected String documentElaborationState;

  /**
   *
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTORIGEN_CIUTADA
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTORIGEN_ADMINISTRACIO Origen: 1
   *      =>Administració 0 =>Ciutadà
   */
  protected Integer documentOrigen = null;

  /**
   * Llista de NIFs (AdministrationIDs) deles persones relacionaes/interesades en aquest
   * document
   */
  protected List<String> interestedPersons; // "12345678X,87654321Z"

  /**
   * Codi DIR3 dels organs afectats si són administracions públiques o CIF si són empreses
   * externes
   */
  protected List<String> affectedOrganisms; // = "A04013511";

  public MassiveScanWebSimpleArxiuRequiredParameters() {
    super();
  }

  public MassiveScanWebSimpleArxiuRequiredParameters(String citizenAdministrationID,
      String citizenFullName, String documentElaborationState, Integer documentOrigen,
      List<String> interestedPersons, List<String> affectedOrganisms) {
    super();
    this.citizenAdministrationID = citizenAdministrationID;
    this.citizenFullName = citizenFullName;
    this.documentElaborationState = documentElaborationState;
    this.documentOrigen = documentOrigen;
    this.interestedPersons = interestedPersons;
    this.affectedOrganisms = affectedOrganisms;
  }

  public String getCitizenAdministrationID() {
    return citizenAdministrationID;
  }

  public void setCitizenAdministrationID(String citizenAdministrationID) {
    this.citizenAdministrationID = citizenAdministrationID;
  }

  public String getCitizenFullName() {
    return citizenFullName;
  }

  public void setCitizenFullName(String citizenFullName) {
    this.citizenFullName = citizenFullName;
  }

  public String getDocumentElaborationState() {
    return documentElaborationState;
  }

  public void setDocumentElaborationState(String documentElaborationState) {
    this.documentElaborationState = documentElaborationState;
  }

  public Integer getDocumentOrigen() {
    return documentOrigen;
  }

  public void setDocumentOrigen(Integer documentOrigen) {
    this.documentOrigen = documentOrigen;
  }

  public List<String> getInterestedPersons() {
    return interestedPersons;
  }

  public void setInterestedPersons(List<String> interestedPersons) {
    this.interestedPersons = interestedPersons;
  }

  public List<String> getAffectedOrganisms() {
    return affectedOrganisms;
  }

  public void setAffectedOrganisms(List<String> affectedOrganisms) {
    this.affectedOrganisms = affectedOrganisms;
  }

}
