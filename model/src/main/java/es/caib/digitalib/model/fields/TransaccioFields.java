
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface TransaccioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_transaccio";


  public static final String _TABLE_MODEL = "transaccio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField TRANSACCIOID = new LongField(_TABLE_MODEL, "transaccioID", "transaccioid");  // PK
	 public static final StringField TRANSACTIONWEBID = new StringField(_TABLE_MODEL, "transactionWebId", "webid");
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "dataInici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "dataFi", "datafi");
	 public static final LongField USUARIAPLICACIOID = new LongField(_TABLE_MODEL, "usuariAplicacioId", "usuariaplicacioid");
	 public static final LongField USUARIPERSONAID = new LongField(_TABLE_MODEL, "usuariPersonaId", "usuaripersonaid");
	 public static final IntegerField ESTATCODI = new IntegerField(_TABLE_MODEL, "estatCodi", "estatcodi");
	 public static final StringField ESTATMISSATGE = new StringField(_TABLE_MODEL, "estatMissatge", "estatmissatge");
	 public static final StringField ESTATEXCEPCIO = new StringField(_TABLE_MODEL, "estatExcepcio", "estatexcepcio");
	 public static final LongField FITXERESCANEJATID = new LongField(_TABLE_MODEL, "fitxerEscanejatID", "fitxerescanejatid");
	 public static final LongField FITXERSIGNATURAID = new LongField(_TABLE_MODEL, "fitxerSignaturaID", "fitxersignaturaid");
	 public static final IntegerField INFOSCANPIXELTYPE = new IntegerField(_TABLE_MODEL, "infoScanPixelType", "infoscanpixeltype");
	 public static final IntegerField INFOSCANRESOLUCIOPPP = new IntegerField(_TABLE_MODEL, "infoScanResolucioPpp", "infoscanresolucioppp");
	 public static final BooleanField INFOSCANOCR = new BooleanField(_TABLE_MODEL, "infoScanOcr", "infoscanocr");
	 public static final LongField INFOSIGNATURAID = new LongField(_TABLE_MODEL, "infoSignaturaID", "infosignaturaid");
	 public static final LongField INFOCUSTODYID = new LongField(_TABLE_MODEL, "infoCustodyID", "infocustodyid");
	 public static final StringField LANGUAGEUI = new StringField(_TABLE_MODEL, "languageUI", "languageui");
	 public static final StringField LANGUAGEDOC = new StringField(_TABLE_MODEL, "languageDoc", "languagedoc");
	 public static final StringField CIUTADANIF = new StringField(_TABLE_MODEL, "ciutadaNif", "ciutadanif");
	 public static final StringField CIUTADANOM = new StringField(_TABLE_MODEL, "ciutadaNom", "ciutadanom");
	 public static final StringField FUNCIONARIUSERNAME = new StringField(_TABLE_MODEL, "funcionariUsername", "funcionariusername");
	 public static final StringField FUNCIONARINOM = new StringField(_TABLE_MODEL, "funcionariNom", "funcionarinom");
	 public static final StringField EXPEDIENT = new StringField(_TABLE_MODEL, "expedient", "expedient");
	 public static final StringField USERNAMEREQUEST = new StringField(_TABLE_MODEL, "usernameRequest", "usernamerequest");
	 public static final StringField RETURNURL = new StringField(_TABLE_MODEL, "returnUrl", "returnurl");
	 public static final IntegerField VIEW = new IntegerField(_TABLE_MODEL, "view", "view");
	 public static final LongField PERFILID = new LongField(_TABLE_MODEL, "perfilID", "perfilid");
	 public static final StringField IP = new StringField(_TABLE_MODEL, "ip", "ip");
	 public static final StringField HASHESCANEIG = new StringField(_TABLE_MODEL, "hashEscaneig", "hashescaneig");
	 public static final StringField HASHFIRMA = new StringField(_TABLE_MODEL, "hashFirma", "hashfirma");


  public static final Field<?>[] ALL_TRANSACCIO_FIELDS = {
    TRANSACCIOID,
    TRANSACTIONWEBID,
    DATAINICI,
    DATAFI,
    USUARIAPLICACIOID,
    USUARIPERSONAID,
    ESTATCODI,
    ESTATMISSATGE,
    ESTATEXCEPCIO,
    FITXERESCANEJATID,
    FITXERSIGNATURAID,
    INFOSCANPIXELTYPE,
    INFOSCANRESOLUCIOPPP,
    INFOSCANOCR,
    INFOSIGNATURAID,
    INFOCUSTODYID,
    LANGUAGEUI,
    LANGUAGEDOC,
    CIUTADANIF,
    CIUTADANOM,
    FUNCIONARIUSERNAME,
    FUNCIONARINOM,
    EXPEDIENT,
    USERNAMEREQUEST,
    RETURNURL,
    VIEW,
    PERFILID,
    IP,
    HASHESCANEIG,
    HASHFIRMA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
TRANSACCIOID
  };
}
