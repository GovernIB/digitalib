
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface TransaccioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_transaccio";


  public static final String _TABLE_MODEL = "transaccio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField TRANSACCIOID = new LongField(_TABLE_MODEL, "transaccioID", "transaccioid");  // PK
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "datainici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "datafi", "datafi");
	 public static final LongField USUARIAPLICACIOID = new LongField(_TABLE_MODEL, "usuariaplicacioid", "usuariaplicacioid");
	 public static final LongField USUARIPERSONAID = new LongField(_TABLE_MODEL, "usuaripersonaid", "usuaripersonaid");


  public static final Field<?>[] ALL_TRANSACCIO_FIELDS = {
    TRANSACCIOID,
    DATAINICI,
    DATAFI,
    USUARIAPLICACIOID,
    USUARIPERSONAID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
TRANSACCIOID
  };
}
