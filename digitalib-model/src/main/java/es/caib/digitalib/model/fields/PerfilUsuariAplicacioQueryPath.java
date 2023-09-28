
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class PerfilUsuariAplicacioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public PerfilUsuariAplicacioQueryPath() {
  }

  protected PerfilUsuariAplicacioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PERFILUSRAPPID() {
    return new LongField(getQueryPath(), PerfilUsuariAplicacioFields.PERFILUSRAPPID);
  }

  public LongField PERFILID() {
    return new LongField(getQueryPath(), PerfilUsuariAplicacioFields.PERFILID);
  }

  public LongField USUARIAPLICACIOID() {
    return new LongField(getQueryPath(), PerfilUsuariAplicacioFields.USUARIAPLICACIOID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (PerfilUsuariAplicacioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public PerfilQueryPath PERFIL() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilUsuariAplicacioQueryPath.this.getQueryPath() + "perfil" + ".";
      }
    });
  }

  public UsuariAplicacioQueryPath USUARIAPLICACIO() {
    return new UsuariAplicacioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilUsuariAplicacioQueryPath.this.getQueryPath() + "usuariAplicacio" + ".";
      }
    });
  }

}
