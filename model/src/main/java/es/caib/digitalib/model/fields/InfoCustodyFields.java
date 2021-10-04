
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface InfoCustodyFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_infocustody";


  public static final String _TABLE_MODEL = "infoCustody";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField INFOCUSTODYID = new LongField(_TABLE_MODEL, "infoCustodyID", "infocustodyid");  // PK
	 public static final StringField CUSTODYID = new StringField(_TABLE_MODEL, "custodyId", "custodyid");
	 public static final StringField ARXIUEXPEDIENTID = new StringField(_TABLE_MODEL, "arxiuExpedientId", "arxiuexpedientid");
	 public static final StringField ARXIUDOCUMENTID = new StringField(_TABLE_MODEL, "arxiuDocumentId", "arxiudocumentid");
	 public static final StringField CSV = new StringField(_TABLE_MODEL, "csv", "csv");
	 public static final StringField ORIGINALFILEURL = new StringField(_TABLE_MODEL, "originalFileUrl", "originalfileurl");
	 public static final StringField CSVVALIDATIONWEB = new StringField(_TABLE_MODEL, "csvValidationWeb", "csvvalidationweb");
	 public static final StringField CSVGENERATIONDEFINITION = new StringField(_TABLE_MODEL, "csvGenerationDefinition", "csvgenerationdefinition");
	 public static final StringField PRINTABLEFILEURL = new StringField(_TABLE_MODEL, "printableFileUrl", "printablefileurl");
	 public static final StringField ENIFILEURL = new StringField(_TABLE_MODEL, "eniFileUrl", "enifileurl");
	 public static final StringField VALIDATIONFILEURL = new StringField(_TABLE_MODEL, "validationFileUrl", "validationfileurl");


  public static final Field<?>[] ALL_INFOCUSTODY_FIELDS = {
    INFOCUSTODYID,
    CUSTODYID,
    ARXIUEXPEDIENTID,
    ARXIUDOCUMENTID,
    CSV,
    ORIGINALFILEURL,
    CSVVALIDATIONWEB,
    CSVGENERATIONDEFINITION,
    PRINTABLEFILEURL,
    ENIFILEURL,
    VALIDATIONFILEURL
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
INFOCUSTODYID
  };
}