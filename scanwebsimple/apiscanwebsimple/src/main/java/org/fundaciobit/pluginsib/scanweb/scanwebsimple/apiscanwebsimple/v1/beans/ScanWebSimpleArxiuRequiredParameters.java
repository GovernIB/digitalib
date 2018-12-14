package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
public class ScanWebSimpleArxiuRequiredParameters {

  public final static int ORIGEN_CIUTADA = 0;
  public final static int ORIGEN_ADMINISTRACIO = 1;

  /**
   * Original (Llei 11/2007 Art. 30)
   * 
   * @return
   */
  public final static String DOCUMENTESTATELABORACIO_ORIGINAL = "EE01";

  /**
   * Còpia electrònica autèntica amb canvi de format (Llei 11/2007 Art. 30.1).
   */
  public final static String DOCUMENTESTATELABORACIO_COPIA_CF = "EE02";

  /**
   * Còpia electrònica autèntica de document en paper amb canvi de format (Llei 11/2007 Art.
   * 30.2 i 30.3).
   */
  public final static String DOCUMENTESTATELABORACIO_COPIA_DP = "EE03";
  /**
   * Còpia electrònica parcial autèntica.
   */
  public final static String DOCUMENTESTATELABORACIO_COPIA_PR = "EE04";

  /**
   * ALTRES("EE99"): Altres estats d'elaboració.
   */
  public final static String DOCUMENTESTATELABORACIO_ALTRES = "EE99";

  public static final String DOCUMENTTIPUS_RESOLUCIO = "TD01";
  public static final String DOCUMENTTIPUS_ACORD = "TD02";
  public static final String DOCUMENTTIPUS_CONTRACTE = "TD03";
  public static final String DOCUMENTTIPUS_CONVENI = "TD04";
  public static final String DOCUMENTTIPUS_DECLARACIO = "TD05";
  public static final String DOCUMENTTIPUS_COMUNICACIO = "TD06";
  public static final String DOCUMENTTIPUS_NOTIFICACIO = "TD07";
  public static final String DOCUMENTTIPUS_PUBLICACIO = "TD08";
  public static final String DOCUMENTTIPUS_JUSTIFICANT_RECEPCIO = "TD09";
  public static final String DOCUMENTTIPUS_ACTA = "TD10";
  public static final String DOCUMENTTIPUS_CERTIFICAT = "TD11";
  public static final String DOCUMENTTIPUS_DILIGENCIA = "TD12";
  public static final String DOCUMENTTIPUS_INFORME = "TD13";
  public static final String DOCUMENTTIPUS_SOLICITUD = "TD14";
  public static final String DOCUMENTTIPUS_DENUNCIA = "TD15";
  public static final String DOCUMENTTIPUS_ALEGACIO = "TD16";
  public static final String DOCUMENTTIPUS_RECURS = "TD17";
  public static final String DOCUMENTTIPUS_COMUNICACIO_CIUTADA = "TD18";
  public static final String DOCUMENTTIPUS_FACTURA = "TD19";
  public static final String DOCUMENTTIPUS_ALTRES_INCAUTATS = "TD20";
  public static final String DOCUMENTTIPUS_ALTRES = "TD99";

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String ciutadaNif;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String ciutadaNom;

  // "12345678X,87654321Z"
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected List<String> interessats;

  /**
   * @see ScanWebSimpleArxiuRequiredParameters.ORIGEN_CIUTADA
   * @see ScanWebSimpleArxiuRequiredParameters.ORIGEN_ADMINISTRACIO
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected int origen; // ContingutOrigen.CIUTADA

  /**
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_ORIGINAL
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_CF
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_DP
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_PR
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String documentEstatElaboracio;

  /**
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_RESOLUCIO
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ACORD
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_CONTRACTE
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_CONVENI
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_DECLARACIO
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_COMUNICACIO
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_NOTIFICACIO
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_PUBLICACIO
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_JUSTIFICANT_RECEPCIO
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ACTA
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_CERTIFICAT
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_DILIGENCIA
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_INFORME
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_SOLICITUD
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_DENUNCIA
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ALEGACIO
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_RECURS
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_COMUNICACIO_CIUTADA
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_FACTURA
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ALTRES_INCAUTATS
   * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ALTRES
   */
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String documentTipus;

  public ScanWebSimpleArxiuRequiredParameters() {
    super();
  }

  public ScanWebSimpleArxiuRequiredParameters(String ciutadaNif, String ciutadaNom,
      List<String> interessats, int origen, String documentEstatElaboracio,
      String documentTipus) {
    super();
    this.ciutadaNif = ciutadaNif;
    this.ciutadaNom = ciutadaNom;
    this.interessats = interessats;
    this.origen = origen;
    this.documentEstatElaboracio = documentEstatElaboracio;
    this.documentTipus = documentTipus;
  }

  public List<String> getInteressats() {
    return interessats;
  }

  public void setInteressats(List<String> interessats) {
    this.interessats = interessats;
  }

  public int getOrigen() {
    return origen;
  }

  public void setOrigen(int origen) {
    this.origen = origen;
  }

  public String getDocumentEstatElaboracio() {
    return documentEstatElaboracio;
  }

  public void setDocumentEstatElaboracio(String documentEstatElaboracio) {
    this.documentEstatElaboracio = documentEstatElaboracio;
  }

  public String getDocumentTipus() {
    return documentTipus;
  }

  public void setDocumentTipus(String documentTipus) {
    this.documentTipus = documentTipus;
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

}
