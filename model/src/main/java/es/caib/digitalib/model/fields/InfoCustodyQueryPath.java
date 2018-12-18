
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class InfoCustodyQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public InfoCustodyQueryPath() {
  }

  protected InfoCustodyQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField INFOCUSTODYID() {
    return new LongField(getQueryPath(), InfoCustodyFields.INFOCUSTODYID);
  }

  public StringField CUSTODYID() {
    return new StringField(getQueryPath(), InfoCustodyFields.CUSTODYID);
  }

  public StringField ARXIUEXPEDIENTID() {
    return new StringField(getQueryPath(), InfoCustodyFields.ARXIUEXPEDIENTID);
  }

  public StringField ARXIUDOCUMENTID() {
    return new StringField(getQueryPath(), InfoCustodyFields.ARXIUDOCUMENTID);
  }

  public StringField FILEURL() {
    return new StringField(getQueryPath(), InfoCustodyFields.FILEURL);
  }

  public StringField CSV() {
    return new StringField(getQueryPath(), InfoCustodyFields.CSV);
  }

  public StringField CSVVALIDATIONWEB() {
    return new StringField(getQueryPath(), InfoCustodyFields.CSVVALIDATIONWEB);
  }

  public StringField CSVGENERATIONDEFINITION() {
    return new StringField(getQueryPath(), InfoCustodyFields.CSVGENERATIONDEFINITION);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (InfoCustodyFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public TransaccioQueryPath TRANSACCIOS() {
    return new TransaccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InfoCustodyQueryPath.this.getQueryPath() + "transaccios" + ".";
      }
    });
  }
*/

}
