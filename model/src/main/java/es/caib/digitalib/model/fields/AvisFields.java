
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface AvisFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_avis";


  public static final String _TABLE_MODEL = "avis";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField AVISID = new LongField(_TABLE_MODEL, "avisID", "avisid");  // PK
	 public static final LongField DESCRIPCIOID = new LongField(_TABLE_MODEL, "descripcioID", "descripcioid");
	 public static final IntegerField TIPUS = new IntegerField(_TABLE_MODEL, "tipus", "tipus");
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "dataInici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "dataFi", "datafi");
	 public static final LongField CONFIGGRUPID = new LongField(_TABLE_MODEL, "configGrupID", "configgrupid");
	 public static final BooleanField BLOQUEJAR = new BooleanField(_TABLE_MODEL, "bloquejar", "bloquejar");


  public static final Field<?>[] ALL_AVIS_FIELDS = {
    AVISID,
    DESCRIPCIOID,
    TIPUS,
    DATAINICI,
    DATAFI,
    CONFIGGRUPID,
    BLOQUEJAR
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
AVISID
  };
}
