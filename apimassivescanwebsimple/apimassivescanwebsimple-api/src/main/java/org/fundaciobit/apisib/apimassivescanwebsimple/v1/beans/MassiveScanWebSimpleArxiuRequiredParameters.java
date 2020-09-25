package org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans;

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

  public static final String DOCUMENTTYPE_RESOLUCIO = "TD01";
  public static final String DOCUMENTTYPE_ACORD = "TD02";
  public static final String DOCUMENTTYPE_CONTRACTE = "TD03";
  public static final String DOCUMENTTYPE_CONVENI = "TD04";
  public static final String DOCUMENTTYPE_DECLARACIO = "TD05";
  public static final String DOCUMENTTYPE_COMUNICACIO = "TD06";
  public static final String DOCUMENTTYPE_NOTIFICACIO = "TD07";
  public static final String DOCUMENTTYPE_PUBLICACIO = "TD08";
  public static final String DOCUMENTTYPE_JUSTIFICANT_RECEPCIO = "TD09";
  public static final String DOCUMENTTYPE_ACTA = "TD10";
  public static final String DOCUMENTTYPE_CERTIFICAT = "TD11";
  public static final String DOCUMENTTYPE_DILIGENCIA = "TD12";
  public static final String DOCUMENTTYPE_INFORME = "TD13";
  public static final String DOCUMENTTYPE_SOLICITUD = "TD14";
  public static final String DOCUMENTTYPE_DENUNCIA = "TD15";
  public static final String DOCUMENTTYPE_ALEGACIO = "TD16";
  public static final String DOCUMENTTYPE_RECURS = "TD17";
  public static final String DOCUMENTTYPE_COMUNICACIO_CIUTADA = "TD18";
  public static final String DOCUMENTTYPE_FACTURA = "TD19";
  public static final String DOCUMENTTYPE_ALTRES_INCAUTATS = "TD20";
  public static final String DOCUMENTTYPE_ALTRES = "TD99";

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
   * /** Document Tipus: TD01 - Resolució,TD02 - Acord,TD03 - Contracte,TD04 - Conveni, TD05 -
   * Declaració,TD06 - Comunicació,TD07 - Notificació,TD08 - Publicació, TD09 - Justificant
   * recepció,TD10 - Acta,TD11 - Certificat,TD12 - Diligència, TD13 - Informe,TD14 -
   * Sol·licitud,TD15 - Denúncia, TD16 - Al·legació,TD17 - Recurs,TD18 - Comunicació
   * ciutadà,TD19 - Factura, TD20 - Altres incautats,TD99 - Altres,
   *
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_RESOLUCIO
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_ACORD
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_CONTRACTE
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_CONVENI
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_DECLARACIO
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_COMUNICACIO
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_NOTIFICACIO
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_PUBLICACIO
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_JUSTIFICANT_RECEPCIO
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_ACTA
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_CERTIFICAT
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_DILIGENCIA
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_INFORME
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_SOLICITUD
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_DENUNCIA
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_ALEGACIO
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_RECURS
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_COMUNICACIO_CIUTADA
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_FACTURA
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_ALTRES_INCAUTATS
   * @see MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_ALTRES
   */
  protected String documentType;

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
      String citizenFullName, String documentElaborationState, String documentType,
      Integer documentOrigen, List<String> interestedPersons, List<String> affectedOrganisms) {
    super();
    this.citizenAdministrationID = citizenAdministrationID;
    this.citizenFullName = citizenFullName;
    this.documentElaborationState = documentElaborationState;
    this.documentType = documentType;
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

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
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
