
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface TransaccioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_transaccio";


  public static final String _TABLE_MODEL = "transaccio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField TRANSACCIOID = new LongField(_TABLE_MODEL, "transaccioID", "transaccioid");  // PK
	 public static final StringField TRANSACTIONWEBID = new StringField(_TABLE_MODEL, "transactionWebId", "webid");
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "datainici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "datafi", "datafi");
	 public static final LongField USUARIAPLICACIOID = new LongField(_TABLE_MODEL, "usuariaplicacioid", "usuariaplicacioid");
	 public static final LongField USUARIPERSONAID = new LongField(_TABLE_MODEL, "usuaripersonaid", "usuaripersonaid");
	 public static final IntegerField ESTATCODI = new IntegerField(_TABLE_MODEL, "estatcodi", "estatcodi");
	 public static final StringField ESTATMISSATGE = new StringField(_TABLE_MODEL, "estatmissatge", "estatmissatge");
	 public static final StringField ESTATEXCEPCIO = new StringField(_TABLE_MODEL, "estatexcepcio", "estatexcepcio");
	 public static final LongField FITXERESCANEJATID = new LongField(_TABLE_MODEL, "fitxerEscanejatID", "fitxerescanejatid");
	 public static final LongField FITXERSIGNATURAID = new LongField(_TABLE_MODEL, "fitxerSignaturaID", "fitxersignaturaid");
	 public static final IntegerField INFOSCANPIXELTYPE = new IntegerField(_TABLE_MODEL, "infoscanpixeltype", "infoscanpixeltype");
	 public static final IntegerField INFOSCANRESOLUCIOPPP = new IntegerField(_TABLE_MODEL, "infoscanresolucioppp", "infoscanresolucioppp");
	 public static final BooleanField INFOSCANOCR = new BooleanField(_TABLE_MODEL, "infoscanocr", "infoscanocr");
	 public static final LongField INFOSIGNATURAID = new LongField(_TABLE_MODEL, "infosignaturaid", "infosignaturaid");
	 public static final LongField INFOCUSTODYID = new LongField(_TABLE_MODEL, "infocustodyid", "infocustodyid");
	 public static final StringField LANGUAGEUI = new StringField(_TABLE_MODEL, "languageui", "languageui");
	 public static final StringField LANGUAGEDOC = new StringField(_TABLE_MODEL, "languagedoc", "languagedoc");
	 public static final StringField CIUTADANIF = new StringField(_TABLE_MODEL, "ciutadanif", "ciutadanif");
	 public static final StringField CIUTADANOM = new StringField(_TABLE_MODEL, "ciutadanom", "ciutadanom");
	 public static final StringField FUNCIONARIUSERNAME = new StringField(_TABLE_MODEL, "funcionariusername", "funcionariusername");
	 public static final StringField FUNCIONARINOM = new StringField(_TABLE_MODEL, "funcionarinom", "funcionarinom");
	 public static final StringField EXPEDIENT = new StringField(_TABLE_MODEL, "expedient", "expedient");
	 public static final LongField PERFILID = new LongField(_TABLE_MODEL, "perfilid", "perfilid");
	 public static final StringField USERNAMEREQUEST = new StringField(_TABLE_MODEL, "usernameRequest", "usernamerequest");
	 public static final StringField RETURNURL = new StringField(_TABLE_MODEL, "returnUrl", "returnurl");
	 public static final IntegerField VIEW = new IntegerField(_TABLE_MODEL, "view", "view");


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
    PERFILID,
    USERNAMEREQUEST,
    RETURNURL,
    VIEW
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
TRANSACCIOID
  };
}
