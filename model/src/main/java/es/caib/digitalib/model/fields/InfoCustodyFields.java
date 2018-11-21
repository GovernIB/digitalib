
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface InfoCustodyFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "dib_infocustody";


  public static final String _TABLE_MODEL = "infoCustody";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField INFOCUSTODYID = new LongField(_TABLE_MODEL, "infoCustodyID", "infocustodyid");  // PK
	 public static final StringField CUSTODYFILEID = new StringField(_TABLE_MODEL, "custodyFileId", "custodyfileid");
	 public static final StringField CUSTODYFILEURL = new StringField(_TABLE_MODEL, "custodyFileUrl", "custodyfileurl");
	 public static final StringField CSV = new StringField(_TABLE_MODEL, "csv", "csv");
	 public static final StringField CSVVALIDATIONWEB = new StringField(_TABLE_MODEL, "csvValidationWeb", "csvvalidationweb");
	 public static final StringField CSVGENERATIONDEFINITION = new StringField(_TABLE_MODEL, "csvGenerationDefinition", "csvgenerationdefinition");


  public static final Field<?>[] ALL_INFOCUSTODY_FIELDS = {
    INFOCUSTODYID,
    CUSTODYFILEID,
    CUSTODYFILEURL,
    CSV,
    CSVVALIDATIONWEB,
    CSVGENERATIONDEFINITION
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
INFOCUSTODYID
  };
}
