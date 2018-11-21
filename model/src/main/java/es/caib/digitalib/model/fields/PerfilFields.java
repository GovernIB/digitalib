
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface PerfilFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_perfil";


  public static final String _TABLE_MODEL = "perfil";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField PERFILID = new LongField(_TABLE_MODEL, "perfilID", "perfilid");  // PK
	 public static final StringField CODI = new StringField(_TABLE_MODEL, "codi", "codi");
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField DESCRIPCIO = new StringField(_TABLE_MODEL, "descripcio", "descripcio");
	 public static final LongField PLUGINSCANWEBID = new LongField(_TABLE_MODEL, "pluginScanWebID", "pluginscanwebid");
	 public static final IntegerField TIPUSFIRMA = new IntegerField(_TABLE_MODEL, "tipusFirma", "tipusfirma");
	 public static final LongField PLUGINFIRMASERVIDORID = new LongField(_TABLE_MODEL, "pluginFirmaServidorID", "pluginfirmaservidorid");
	 public static final LongField APISIMPLEID = new LongField(_TABLE_MODEL, "apiSimpleID", "apisimpleid");
	 public static final IntegerField TIPUSCUSTODIA = new IntegerField(_TABLE_MODEL, "tipusCustodia", "tipuscustodia");
	 public static final LongField PLUGINARXIUID = new LongField(_TABLE_MODEL, "pluginArxiuID", "pluginarxiuid");
	 public static final LongField PLUGINDOCCUSTODYID = new LongField(_TABLE_MODEL, "pluginDocCustodyID", "plugindoccustodyid");
	 public static final IntegerField USPERFIL = new IntegerField(_TABLE_MODEL, "usPerfil", "usperfil");


  public static final Field<?>[] ALL_PERFIL_FIELDS = {
    PERFILID,
    CODI,
    NOM,
    DESCRIPCIO,
    PLUGINSCANWEBID,
    TIPUSFIRMA,
    PLUGINFIRMASERVIDORID,
    APISIMPLEID,
    TIPUSCUSTODIA,
    PLUGINARXIUID,
    PLUGINDOCCUSTODYID,
    USPERFIL
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
PERFILID
  };
}
