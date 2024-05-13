package es.caib.digitalib.api.interna.all.dadesobertes.transaccions.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal (u80067)
 *
 */
@Schema(description = "Informació bàsica d'una transacció d'escaneig a DigitalIB.")
public class TransaccioInfo {
    protected long transaccioID;
    protected Long transaccioMultipleID;
    protected String funcionariUsername;
    protected String appname;
    protected String usrname;
    protected long fitxerMidaBytes;
    @Schema(description = "Mode en que es va fer l'escaneig. Valors possibles: \"B/N\",\"Gris\" o \"Color\"")
    protected String color;
    protected Integer resolucio; // infoscanresolucioppp
    protected String midaPaper;

    @Schema(
            required = true,
            description = "Data en que es va fer la transacció",
            type = "string",
            format = "date-time",
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty("dataCaptura")
    protected java.sql.Timestamp dataCaptura;

    @Schema(
            description = "Estat final de la transacció. Valors possibles: 'EXPIRAT','CANCELAT','ERROR','ID','ENPROGRES','OK'")
    protected String estat;

    protected String codiDir3;
    protected String configuracioGrupNom;
    protected String idiomaDocument;
    protected Boolean duplex;
    protected String missatgeError;
    @Schema(
            description = "Origen del Document. Valors possibles: Ciudadano o Administración en Castellà i Ciutadà o Administració en català")
    protected String origen;
    @Schema(
            description = "Tipus Documental NTI. Valors possibles: 'TD01','TD02','TD03','TD04','TD05','TD06','TD07','TD08','TD09','TD10','TD11','TD12','TD13','TD14','TD15','TD16','TD17','TD18','TD19','TD20','TD51','TD52','TD53','TD54','TD55','TD56','TD57','TD58','TD59','TD60','TD61','TD62','TD63','TD64','TD65','TD66','TD67','TD68','TD69','TD99'")
    protected String tipusDocumental;

    public TransaccioInfo() {
        super();
    }

    public TransaccioInfo(long transaccioID, Long transaccioMultipleID, String funcionariUsername, String appname,
            String usrname, long fitxerMidaBytes, String color, Integer resolucio, String midaPaper,
            java.sql.Timestamp dataCapturaISO8601, String estat, String codiDir3, String configuracioGrupNom,
            String idiomaDocument, Boolean duplex, String missatgeError, String origen, String tipusDocumental) {
        super();
        this.transaccioID = transaccioID;
        this.transaccioMultipleID = transaccioMultipleID;
        this.funcionariUsername = funcionariUsername;
        this.appname = appname;
        this.usrname = usrname;
        this.fitxerMidaBytes = fitxerMidaBytes;
        this.color = color;
        this.resolucio = resolucio;
        this.midaPaper = midaPaper;
        this.dataCaptura = dataCapturaISO8601;
        this.estat = estat;
        this.codiDir3 = codiDir3;
        this.configuracioGrupNom = configuracioGrupNom;
        this.idiomaDocument = idiomaDocument;
        this.duplex = duplex;
        this.missatgeError = missatgeError;
        this.origen = origen;
        this.tipusDocumental = tipusDocumental;
    }

    public long getTransaccioID() {
        return transaccioID;
    }

    public void setTransaccioID(long transaccioID) {
        this.transaccioID = transaccioID;
    }

    public String getFuncionariUsername() {
        return funcionariUsername;
    }

    public void setFuncionariUsername(String funcionariUsername) {
        this.funcionariUsername = funcionariUsername;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public long getFitxerMidaBytes() {
        return fitxerMidaBytes;
    }

    public void setFitxerMidaBytes(long fitxerMidaBytes) {
        this.fitxerMidaBytes = fitxerMidaBytes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getResolucio() {
        return resolucio;
    }

    public void setResolucio(Integer resolucio) {
        this.resolucio = resolucio;
    }

    public String getMidaPaper() {
        return midaPaper;
    }

    public void setMidaPaper(String midaPaper) {
        this.midaPaper = midaPaper;
    }

    public java.sql.Timestamp getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(java.sql.Timestamp dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public Long getTransaccioMultipleID() {
        return transaccioMultipleID;
    }

    public void setTransaccioMultipleID(Long transaccioMultipleID) {
        this.transaccioMultipleID = transaccioMultipleID;
    }

    public String getCodiDir3() {
        return codiDir3;
    }

    public void setCodiDir3(String codiDir3) {
        this.codiDir3 = codiDir3;
    }

    public String getConfiguracioGrupNom() {
        return configuracioGrupNom;
    }

    public void setConfiguracioGrupNom(String configuracioGrupNom) {
        this.configuracioGrupNom = configuracioGrupNom;
    }

    public String getIdiomaDocument() {
        return idiomaDocument;
    }

    public void setIdiomaDocument(String idiomaDocument) {
        this.idiomaDocument = idiomaDocument;
    }

    public Boolean getDuplex() {
        return duplex;
    }

    public void setDuplex(Boolean duplex) {
        this.duplex = duplex;
    }

    public String getMissatgeError() {
        return missatgeError;
    }

    public void setMissatgeError(String missatgeError) {
        this.missatgeError = missatgeError;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipusDocumental() {
        return tipusDocumental;
    }

    public void setTipusDocumental(String tipusDocumental) {
        this.tipusDocumental = tipusDocumental;
    }

}
