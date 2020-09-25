
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface TransaccioMultipleFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_transmultiple";


  public static final String _TABLE_MODEL = "transaccioMultiple";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField TRANSMULTIPLEID = new LongField(_TABLE_MODEL, "transmultipleid", "transmultipleid");  // PK
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");
	 public static final LongField FITXERESCANEJATID = new LongField(_TABLE_MODEL, "fitxerEscanejatID", "fitxerescanejatid");


  public static final Field<?>[] ALL_TRANSACCIOMULTIPLE_FIELDS = {
    TRANSMULTIPLEID,
    DESCRIPCIO,
    FITXERESCANEJATID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
TRANSMULTIPLEID
  };
}
