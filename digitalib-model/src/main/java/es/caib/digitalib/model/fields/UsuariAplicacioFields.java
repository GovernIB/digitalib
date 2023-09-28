
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface UsuariAplicacioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_usuariaplicacio";


  public static final String _TABLE_MODEL = "usuariAplicacio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField USUARIAPLICACIOID = new LongField(_TABLE_MODEL, "usuariAplicacioID", "usuariaplicacioid");  // PK
	 public static final StringField USERNAME = new StringField(_TABLE_MODEL, "username", "username");
	 public static final StringField CONTRASENYA = new StringField(_TABLE_MODEL, "contrasenya", "contrasenya");
	 public static final StringField EMAILADMIN = new StringField(_TABLE_MODEL, "emailAdmin", "emailadmin");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");
	 public static final BooleanField ACTIU = new BooleanField(_TABLE_MODEL, "actiu", "actiu");
	 public static final BooleanField ROLESCAN = new BooleanField(_TABLE_MODEL, "roleScan", "rolescan");
	 public static final BooleanField ROLECOAU = new BooleanField(_TABLE_MODEL, "roleCoAu", "rolecoau");
	 public static final BooleanField ROLECUST = new BooleanField(_TABLE_MODEL, "roleCust", "rolecust");


  public static final Field<?>[] ALL_USUARIAPLICACIO_FIELDS = {
    USUARIAPLICACIOID,
    USERNAME,
    CONTRASENYA,
    EMAILADMIN,
    DESCRIPCIO,
    ACTIU,
    ROLESCAN,
    ROLECOAU,
    ROLECUST
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
USUARIAPLICACIOID
  };
}
