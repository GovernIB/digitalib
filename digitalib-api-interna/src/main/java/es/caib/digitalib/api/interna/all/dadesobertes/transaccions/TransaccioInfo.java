package es.caib.digitalib.api.interna.all.dadesobertes.transaccions;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class TransaccioInfo {
    protected long transaccioID;
    protected Long transaccioMultipleID;
    protected String funcionariUsername;
    protected String appname;
    protected String usrname;
    protected long fitxerMidaBytes;
    protected String color; // 1,'B/N',8,'Gris',32,'Color'
    protected Integer resolucio; // infoscanresolucioppp
    protected String midaPaper;
    protected String dataCapturaISO8601;
    protected String estat;

    protected String codiDir3;
    protected String configuracioGrupNom;
    protected String idiomaDocument;
    protected Boolean duplex;
    protected String missatgeError;
    protected String origen;
    protected String tipusDocumental;

    public TransaccioInfo() {
        super();
    }

    public TransaccioInfo(long transaccioID, Long transaccioMultipleID,
            String funcionariUsername, String appname, String usrname, long fitxerMidaBytes,
            String color, Integer resolucio, String midaPaper, String dataCapturaISO8601,
            String estat, String codiDir3, String configuracioGrupNom, String idiomaDocument,
            Boolean duplex, String missatgeError, String origen, String tipusDocumental) {
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
        this.dataCapturaISO8601 = dataCapturaISO8601;
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

    public String getDataCapturaISO8601() {
        return dataCapturaISO8601;
    }

    public void setDataCapturaISO8601(String dataCapturaISO8601) {
        this.dataCapturaISO8601 = dataCapturaISO8601;
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
