
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface PerfilUsuariAplicacioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_perfilusrapp";


  public static final String _TABLE_MODEL = "perfilUsuariAplicacio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField PERFILUSRAPPID = new LongField(_TABLE_MODEL, "perfilUsrAppID", "perfilusrappid");  // PK
	 public static final LongField PERFILID = new LongField(_TABLE_MODEL, "perfilID", "perfilid");
	 public static final LongField USUARIAPLICACIOID = new LongField(_TABLE_MODEL, "usuariAplicacioID", "usuariaplicacioid");


  public static final Field<?>[] ALL_PERFILUSUARIAPLICACIO_FIELDS = {
    PERFILUSRAPPID,
    PERFILID,
    USUARIAPLICACIOID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
PERFILUSRAPPID
  };
}
