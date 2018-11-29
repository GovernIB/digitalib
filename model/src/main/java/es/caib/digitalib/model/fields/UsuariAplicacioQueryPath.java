
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class UsuariAplicacioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public UsuariAplicacioQueryPath() {
  }

  protected UsuariAplicacioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField USUARIAPLICACIOID() {
    return new LongField(getQueryPath(), UsuariAplicacioFields.USUARIAPLICACIOID);
  }

  public StringField USERNAME() {
    return new StringField(getQueryPath(), UsuariAplicacioFields.USERNAME);
  }

  public StringField CONTRASENYA() {
    return new StringField(getQueryPath(), UsuariAplicacioFields.CONTRASENYA);
  }

  public StringField EMAILADMIN() {
    return new StringField(getQueryPath(), UsuariAplicacioFields.EMAILADMIN);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), UsuariAplicacioFields.DESCRIPCIO);
  }

  public BooleanField ACTIU() {
    return new BooleanField(getQueryPath(), UsuariAplicacioFields.ACTIU);
  }

  public BooleanField ROLESCAN() {
    return new BooleanField(getQueryPath(), UsuariAplicacioFields.ROLESCAN);
  }

  public BooleanField ROLECOAU() {
    return new BooleanField(getQueryPath(), UsuariAplicacioFields.ROLECOAU);
  }

  public BooleanField ROLECUST() {
    return new BooleanField(getQueryPath(), UsuariAplicacioFields.ROLECUST);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (UsuariAplicacioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilUsuariAplicacioQueryPath PERFILUSUARIAPLICACIOS() {
    return new PerfilUsuariAplicacioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuariAplicacioQueryPath.this.getQueryPath() + "perfilUsuariAplicacios" + ".";
      }
    });
  }
*/

}
