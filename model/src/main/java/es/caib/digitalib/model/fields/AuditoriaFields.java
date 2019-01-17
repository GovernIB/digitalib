
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface AuditoriaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_auditoria";


  public static final String _TABLE_MODEL = "auditoria";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField AUDITORIAID = new LongField(_TABLE_MODEL, "auditoriaID", "auditoriaid");  // PK
	 public static final TimestampField DATA = new TimestampField(_TABLE_MODEL, "data", "data");
	 public static final LongField TRANSACCIOID = new LongField(_TABLE_MODEL, "transaccioId", "transaccioid");
	 public static final IntegerField TIPUS = new IntegerField(_TABLE_MODEL, "tipus", "tipus");
	 public static final StringField MISSATGE = new StringField(_TABLE_MODEL, "missatge", "missatge");
	 public static final StringField ADDITIONALINFO = new StringField(_TABLE_MODEL, "additionalInfo", "additionalinfo");
	 public static final BooleanField ISAPP = new BooleanField(_TABLE_MODEL, "isApp", "isapp");
	 public static final StringField USERNAMEAPLICACIO = new StringField(_TABLE_MODEL, "usernameAplicacio", "usernameaplicacio");
	 public static final StringField USERNAMEPERSONA = new StringField(_TABLE_MODEL, "usernamePersona", "usernamepersona");


  public static final Field<?>[] ALL_AUDITORIA_FIELDS = {
    AUDITORIAID,
    DATA,
    TRANSACCIOID,
    TIPUS,
    MISSATGE,
    ADDITIONALINFO,
    ISAPP,
    USERNAMEAPLICACIO,
    USERNAMEPERSONA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
AUDITORIAID
  };
}
