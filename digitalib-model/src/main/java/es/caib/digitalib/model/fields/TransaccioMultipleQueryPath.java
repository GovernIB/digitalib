
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class TransaccioMultipleQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public TransaccioMultipleQueryPath() {
  }

  protected TransaccioMultipleQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField TRANSMULTIPLEID() {
    return new LongField(getQueryPath(), TransaccioMultipleFields.TRANSMULTIPLEID);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), TransaccioMultipleFields.DESCRIPCIO);
  }

  public LongField FITXERESCANEJATID() {
    return new LongField(getQueryPath(), TransaccioMultipleFields.FITXERESCANEJATID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (TransaccioMultipleFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public TransaccioQueryPath TRANSACCIOS() {
    return new TransaccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioMultipleQueryPath.this.getQueryPath() + "transaccios" + ".";
      }
    });
  }
*/

  public FitxerQueryPath FITXERESCANEJAT() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioMultipleQueryPath.this.getQueryPath() + "fitxerEscanejat" + ".";
      }
    });
  }

}
