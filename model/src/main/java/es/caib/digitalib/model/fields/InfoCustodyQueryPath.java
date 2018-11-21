
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

  public StringField CUSTODYFILEID() {
    return new StringField(getQueryPath(), InfoCustodyFields.CUSTODYFILEID);
  }

  public StringField CUSTODYFILEURL() {
    return new StringField(getQueryPath(), InfoCustodyFields.CUSTODYFILEURL);
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
