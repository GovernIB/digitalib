
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface TraduccioMapFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_traducciomap";


  public static final String _TABLE_MODEL = "traduccioMap";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField TRADUCCIOMAPID = new LongField(_TABLE_MODEL, "traducciomapid", "traducciomapid");  // PK
	 public static final StringField IDIOMAID = new StringField(_TABLE_MODEL, "idiomaid", "idiomaid");  // PK
	 public static final StringField VALOR = new StringField(_TABLE_MODEL, "valor", "valor");


  public static final Field<?>[] ALL_TRADUCCIOMAP_FIELDS = {
    TRADUCCIOMAPID,
    IDIOMAID,
    VALOR
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
TRADUCCIOMAPID, IDIOMAID
  };
}