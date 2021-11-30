
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface TransaccioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_transaccio";


  public static final String _TABLE_MODEL = "transaccio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField TRANSACCIOID = new LongField(_TABLE_MODEL, "transaccioID", "transaccioid");  // PK
	 public static final LongField TRANSACCIOMULTIPLEID = new LongField(_TABLE_MODEL, "transaccioMultipleID", "transmultipleid");
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField TRANSACTIONWEBID = new StringField(_TABLE_MODEL, "transactionWebId", "webid");
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "dataInici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "dataFi", "datafi");
	 public static final LongField USUARIAPLICACIOID = new LongField(_TABLE_MODEL, "usuariAplicacioId", "usuariaplicacioid");
	 public static final LongField USUARIPERSONAID = new LongField(_TABLE_MODEL, "usuariPersonaId", "usuaripersonaid");
	 public static final StringField IP = new StringField(_TABLE_MODEL, "ip", "ip");
	 public static final StringField RETURNURL = new StringField(_TABLE_MODEL, "returnUrl", "returnurl");
	 public static final IntegerField ESTATCODI = new IntegerField(_TABLE_MODEL, "estatCodi", "estatcodi");
	 public static final StringField ESTATMISSATGE = new StringField(_TABLE_MODEL, "estatMissatge", "estatmissatge");
	 public static final StringField ESTATEXCEPCIO = new StringField(_TABLE_MODEL, "estatExcepcio", "estatexcepcio");
	 public static final LongField FITXERESCANEJATID = new LongField(_TABLE_MODEL, "fitxerEscanejatID", "fitxerescanejatid");
	 public static final StringField HASHESCANEIG = new StringField(_TABLE_MODEL, "hashEscaneig", "hashescaneig");
	 public static final LongField FITXERSIGNATURAID = new LongField(_TABLE_MODEL, "fitxerSignaturaID", "fitxersignaturaid");
	 public static final StringField HASHFIRMA = new StringField(_TABLE_MODEL, "hashFirma", "hashfirma");
	 public static final StringField INFOSCANPAPERSIZE = new StringField(_TABLE_MODEL, "infoScanPaperSize", "infoscanpapersize");
	 public static final IntegerField INFOSCANPIXELTYPE = new IntegerField(_TABLE_MODEL, "infoScanPixelType", "infoscanpixeltype");
	 public static final IntegerField INFOSCANRESOLUCIOPPP = new IntegerField(_TABLE_MODEL, "infoScanResolucioPpp", "infoscanresolucioppp");
	 public static final BooleanField INFOSCANOCR = new BooleanField(_TABLE_MODEL, "infoScanOcr", "infoscanocr");
	 public static final BooleanField INFOSCANDUPLEX = new BooleanField(_TABLE_MODEL, "infoScanDuplex", "infoscanduplex");
	 public static final TimestampField INFOSCANDATACAPTURA = new TimestampField(_TABLE_MODEL, "infoScanDataCaptura", "infoscandatacaptura");
	 public static final StringField INFOSCANLANGUAGEDOC = new StringField(_TABLE_MODEL, "infoScanLanguageDoc", "signparamlanguagedoc");
	 public static final StringField INFOSCANDOCUMENTTIPUS = new StringField(_TABLE_MODEL, "infoScanDocumentTipus", "arxiureqparamdocumenttipus");
	 public static final IntegerField VIEW = new IntegerField(_TABLE_MODEL, "view", "vista");
	 public static final StringField LANGUAGEUI = new StringField(_TABLE_MODEL, "languageUI", "languageui");
	 public static final StringField FUNCIONARIUSERNAME = new StringField(_TABLE_MODEL, "funcionariUsername", "funcionariusername");
	 public static final StringField SIGNPARAMFUNCIONARINOM = new StringField(_TABLE_MODEL, "signParamFuncionariNom", "signparamfuncionarinom");
	 public static final StringField SIGNPARAMFUNCIONARINIF = new StringField(_TABLE_MODEL, "signParamFuncionariNif", "signparamfuncionarinif");
	 public static final StringField SIGNPARAMFUNCIONARIDIR3 = new StringField(_TABLE_MODEL, "signParamFuncionariDir3", "signparamfuncionaridir3");
	 public static final StringField ARXIUREQPARAMDOCESTATELABORA = new StringField(_TABLE_MODEL, "arxiuReqParamDocEstatElabora", "arxiureqparamdocestatelabora");
	 public static final IntegerField ARXIUREQPARAMORIGEN = new IntegerField(_TABLE_MODEL, "arxiuReqParamOrigen", "arxiureqparamorigen");
	 public static final StringField ARXIUREQPARAMINTERESSATS = new StringField(_TABLE_MODEL, "arxiuReqParamInteressats", "arxiureqparaminteressats");
	 public static final StringField ARXIUREQPARAMCIUTADANIF = new StringField(_TABLE_MODEL, "arxiuReqParamCiutadaNif", "arxiureqparamciutadanif");
	 public static final StringField ARXIUREQPARAMCIUTADANOM = new StringField(_TABLE_MODEL, "arxiuReqParamCiutadaNom", "arxiureqparamciutadanom");
	 public static final StringField ARXIUREQPARAMORGANS = new StringField(_TABLE_MODEL, "arxiuReqParamOrgans", "arxiureqparamorgans");
	 public static final StringField ARXIUOPTPARAMPROCEDIMENTCODI = new StringField(_TABLE_MODEL, "arxiuOptParamProcedimentCodi", "arxiuoptparamprocedimentcodi");
	 public static final StringField ARXIUOPTPARAMPROCEDIMENTNOM = new StringField(_TABLE_MODEL, "arxiuOptParamProcedimentNom", "arxiuoptparamprocedimentnom");
	 public static final StringField ARXIUOPTPARAMSERIEDOCUMENTAL = new StringField(_TABLE_MODEL, "arxiuOptParamSerieDocumental", "arxiuoptparamseriedocumental");
	 public static final StringField ARXIUOPTPARAMCUSTODYOREXPEDIENTID = new StringField(_TABLE_MODEL, "arxiuOptParamCustodyOrExpedientId", "arxiuoptparamcustorexpid");
	 public static final LongField PERFILID = new LongField(_TABLE_MODEL, "perfilID", "perfilid");
	 public static final LongField INFOSIGNATURAID = new LongField(_TABLE_MODEL, "infoSignaturaID", "infosignaturaid");
	 public static final LongField INFOCUSTODYID = new LongField(_TABLE_MODEL, "infoCustodyID", "infocustodyid");


  public static final Field<?>[] ALL_TRANSACCIO_FIELDS = {
    TRANSACCIOID,
    TRANSACCIOMULTIPLEID,
    NOM,
    TRANSACTIONWEBID,
    DATAINICI,
    DATAFI,
    USUARIAPLICACIOID,
    USUARIPERSONAID,
    IP,
    RETURNURL,
    ESTATCODI,
    ESTATMISSATGE,
    ESTATEXCEPCIO,
    FITXERESCANEJATID,
    HASHESCANEIG,
    FITXERSIGNATURAID,
    HASHFIRMA,
    INFOSCANPAPERSIZE,
    INFOSCANPIXELTYPE,
    INFOSCANRESOLUCIOPPP,
    INFOSCANOCR,
    INFOSCANDUPLEX,
    INFOSCANDATACAPTURA,
    INFOSCANLANGUAGEDOC,
    INFOSCANDOCUMENTTIPUS,
    VIEW,
    LANGUAGEUI,
    FUNCIONARIUSERNAME,
    SIGNPARAMFUNCIONARINOM,
    SIGNPARAMFUNCIONARINIF,
    SIGNPARAMFUNCIONARIDIR3,
    ARXIUREQPARAMDOCESTATELABORA,
    ARXIUREQPARAMORIGEN,
    ARXIUREQPARAMINTERESSATS,
    ARXIUREQPARAMCIUTADANIF,
    ARXIUREQPARAMCIUTADANOM,
    ARXIUREQPARAMORGANS,
    ARXIUOPTPARAMPROCEDIMENTCODI,
    ARXIUOPTPARAMPROCEDIMENTNOM,
    ARXIUOPTPARAMSERIEDOCUMENTAL,
    ARXIUOPTPARAMCUSTODYOREXPEDIENTID,
    PERFILID,
    INFOSIGNATURAID,
    INFOCUSTODYID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
TRANSACCIOID
  };
}
