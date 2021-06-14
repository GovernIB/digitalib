
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface ApiSimpleFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_apisimple";


  public static final String _TABLE_MODEL = "apiSimple";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField APISIMPLEID = new LongField(_TABLE_MODEL, "apiSimpleID", "apisimpleid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField URL = new StringField(_TABLE_MODEL, "url", "url");
	 public static final StringField USERNAME = new StringField(_TABLE_MODEL, "username", "username");
	 public static final StringField CONTRASENYA = new StringField(_TABLE_MODEL, "contrasenya", "contrasenya");
	 public static final StringField PERFIL = new StringField(_TABLE_MODEL, "perfil", "perfil");
	 public static final StringField CONFIGDEFIRMA = new StringField(_TABLE_MODEL, "configDeFirma", "configdefirma");


  public static final Field<?>[] ALL_APISIMPLE_FIELDS = {
    APISIMPLEID,
    NOM,
    URL,
    USERNAME,
    CONTRASENYA,
    PERFIL,
    CONFIGDEFIRMA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
APISIMPLEID
  };
}
