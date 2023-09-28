
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface PluginCridadaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_plugincridada";


  public static final String _TABLE_MODEL = "pluginCridada";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField PLUGINCRIDADAID = new LongField(_TABLE_MODEL, "pluginCridadaID", "plugincridadaid");  // PK
	 public static final TimestampField DATA = new TimestampField(_TABLE_MODEL, "data", "data");
	 public static final LongField PLUGINID = new LongField(_TABLE_MODEL, "pluginID", "pluginid");
	 public static final StringField METODEPLUGIN = new StringField(_TABLE_MODEL, "metodePlugin", "metodeplugin");
	 public static final IntegerField TIPUSRESULTAT = new IntegerField(_TABLE_MODEL, "tipusResultat", "tipusresultat");
	 public static final LongField TEMPSEXECUCIO = new LongField(_TABLE_MODEL, "tempsExecucio", "tempsexecucio");
	 public static final LongField USUARIPERSONAID = new LongField(_TABLE_MODEL, "usuariPersonaId", "usuaripersonaid");
	 public static final LongField USUARIAPLICACIOID = new LongField(_TABLE_MODEL, "usuariAplicacioId", "usuariaplicacioid");
	 public static final StringField PARAMETRESTEXT = new StringField(_TABLE_MODEL, "parametresText", "parametrestext");
	 public static final LongField PARAMETRESFITXERID = new LongField(_TABLE_MODEL, "parametresFitxerID", "parametresfitxerid");
	 public static final StringField RETORNTEXT = new StringField(_TABLE_MODEL, "retornText", "retorntext");
	 public static final LongField RETORNFITXERID = new LongField(_TABLE_MODEL, "retornFitxerID", "retornfitxerid");


  public static final Field<?>[] ALL_PLUGINCRIDADA_FIELDS = {
    PLUGINCRIDADAID,
    DATA,
    PLUGINID,
    METODEPLUGIN,
    TIPUSRESULTAT,
    TEMPSEXECUCIO,
    USUARIPERSONAID,
    USUARIAPLICACIOID,
    PARAMETRESTEXT,
    PARAMETRESFITXERID,
    RETORNTEXT,
    RETORNFITXERID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
PLUGINCRIDADAID
  };
}
