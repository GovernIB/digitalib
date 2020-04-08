
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface MetadadaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_metadada";


  public static final String _TABLE_MODEL = "metadada";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField METADADAID = new LongField(_TABLE_MODEL, "metadadaid", "metadadaid");  // PK
	 public static final LongField TRANSACCIOID = new LongField(_TABLE_MODEL, "transaccioID", "transaccioid");
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField VALOR = new StringField(_TABLE_MODEL, "valor", "valor");


  public static final Field<?>[] ALL_METADADA_FIELDS = {
    METADADAID,
    TRANSACCIOID,
    NOM,
    VALOR
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
METADADAID
  };
}
