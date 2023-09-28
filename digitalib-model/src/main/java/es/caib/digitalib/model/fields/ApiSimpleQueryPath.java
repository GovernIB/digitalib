
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ApiSimpleQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ApiSimpleQueryPath() {
  }

  protected ApiSimpleQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField APISIMPLEID() {
    return new LongField(getQueryPath(), ApiSimpleFields.APISIMPLEID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), ApiSimpleFields.NOM);
  }

  public StringField URL() {
    return new StringField(getQueryPath(), ApiSimpleFields.URL);
  }

  public StringField USERNAME() {
    return new StringField(getQueryPath(), ApiSimpleFields.USERNAME);
  }

  public StringField CONTRASENYA() {
    return new StringField(getQueryPath(), ApiSimpleFields.CONTRASENYA);
  }

  public StringField PERFIL() {
    return new StringField(getQueryPath(), ApiSimpleFields.PERFIL);
  }

  public StringField CONFIGDEFIRMA() {
    return new StringField(getQueryPath(), ApiSimpleFields.CONFIGDEFIRMA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ApiSimpleFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFILS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ApiSimpleQueryPath.this.getQueryPath() + "perfils" + ".";
      }
    });
  }
*/

}
