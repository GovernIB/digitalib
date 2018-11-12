
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface ConfiguracioGrupFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_configuraciogrup";


  public static final String _TABLE_MODEL = "configuracioGrup";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField CONFIGURACIOGRUPID = new LongField(_TABLE_MODEL, "configuracioGrupID", "configuraciogrupid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField SUPORTWEB = new StringField(_TABLE_MODEL, "suportWeb", "suportweb");
	 public static final StringField SUPORTEMAIL = new StringField(_TABLE_MODEL, "suportEmail", "suportemail");
	 public static final StringField SUPORTTELEFON = new StringField(_TABLE_MODEL, "suportTelefon", "suporttelefon");
	 public static final LongField LOGOHEADERID = new LongField(_TABLE_MODEL, "logoHeaderID", "logoheaderid");
	 public static final LongField LOGOFOOTERID = new LongField(_TABLE_MODEL, "logoFooterID", "logofooterid");


  public static final Field<?>[] ALL_CONFIGURACIOGRUP_FIELDS = {
    CONFIGURACIOGRUPID,
    NOM,
    SUPORTWEB,
    SUPORTEMAIL,
    SUPORTTELEFON,
    LOGOHEADERID,
    LOGOFOOTERID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
CONFIGURACIOGRUPID
  };
}
