
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface ConfiguracioFirmaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_configuraciofirma";


  public static final String _TABLE_MODEL = "configuracioFirma";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField CONFIGURACIOFIRMAID = new LongField(_TABLE_MODEL, "configuracioFirmaID", "configuraciofirmaid");  // PK
	 public static final IntegerField USPOLITICADEFIRMA = new IntegerField(_TABLE_MODEL, "usPoliticaDeFirma", "uspoliticadefirma");
	 public static final StringField POLICYIDENTIFIER = new StringField(_TABLE_MODEL, "policyIdentifier", "policyidentifier");
	 public static final StringField POLICYIDENTIFIERHASH = new StringField(_TABLE_MODEL, "policyIdentifierHash", "policyidentifierhash");
	 public static final StringField POLICYIDENTIFIERHASHALGORITHM = new StringField(_TABLE_MODEL, "policyIdentifierHashAlgorithm", "policyidentifierhashalgorithm");
	 public static final StringField POLICYURLDOCUMENT = new StringField(_TABLE_MODEL, "policyUrlDocument", "policyurldocument");
	 public static final IntegerField TIPUSOPERACIOFIRMA = new IntegerField(_TABLE_MODEL, "tipusOperacioFirma", "tipusoperaciofirma");
	 public static final IntegerField TIPUSFIRMAID = new IntegerField(_TABLE_MODEL, "tipusFirmaID", "tipusfirmaid");
	 public static final IntegerField ALGORISMEDEFIRMAID = new IntegerField(_TABLE_MODEL, "algorismeDeFirmaID", "algorismedefirmaid");
	 public static final BooleanField MODEDEFIRMA = new BooleanField(_TABLE_MODEL, "modeDeFirma", "modedefirma");
	 public static final IntegerField POLITICATAULAFIRMES = new IntegerField(_TABLE_MODEL, "politicaTaulaFirmes", "politicataulafirmes");
	 public static final IntegerField POSICIOTAULAFIRMESID = new IntegerField(_TABLE_MODEL, "posicioTaulaFirmesID", "posiciotaulafirmesid");
	 public static final LongField FIRMATPERFORMATID = new LongField(_TABLE_MODEL, "firmatPerFormatID", "firmatperformatid");
	 public static final LongField MOTIUDELEGACIOID = new LongField(_TABLE_MODEL, "motiuDelegacioID", "motiudelegacioid");
	 public static final StringField PROPIETATSTAULAFIRMES = new StringField(_TABLE_MODEL, "propietatsTaulaFirmes", "propietatstaulafirmes");
	 public static final LongField PLUGINFIRMASERVIDORID = new LongField(_TABLE_MODEL, "pluginFirmaServidorID", "pluginfirmaservidorid");
	 public static final BooleanField INCLOURESEGELLDETEMPS = new BooleanField(_TABLE_MODEL, "incloureSegellDeTemps", "inclouresegelldetemps");
	 public static final LongField PLUGINSEGELLATID = new LongField(_TABLE_MODEL, "pluginSegellatID", "pluginsegellatid");


  public static final Field<?>[] ALL_CONFIGURACIOFIRMA_FIELDS = {
    CONFIGURACIOFIRMAID,
    USPOLITICADEFIRMA,
    POLICYIDENTIFIER,
    POLICYIDENTIFIERHASH,
    POLICYIDENTIFIERHASHALGORITHM,
    POLICYURLDOCUMENT,
    TIPUSOPERACIOFIRMA,
    TIPUSFIRMAID,
    ALGORISMEDEFIRMAID,
    MODEDEFIRMA,
    POLITICATAULAFIRMES,
    POSICIOTAULAFIRMESID,
    FIRMATPERFORMATID,
    MOTIUDELEGACIOID,
    PROPIETATSTAULAFIRMES,
    PLUGINFIRMASERVIDORID,
    INCLOURESEGELLDETEMPS,
    PLUGINSEGELLATID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
CONFIGURACIOFIRMAID
  };
}
