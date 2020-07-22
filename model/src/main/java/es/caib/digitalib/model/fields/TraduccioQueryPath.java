
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class TraduccioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public TraduccioQueryPath() {
  }

  protected TraduccioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField TRADUCCIOID() {
    return new LongField(getQueryPath(), TraduccioFields.TRADUCCIOID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (TraduccioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public AvisQueryPath AVISS() {
    return new AvisQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TraduccioQueryPath.this.getQueryPath() + "aviss" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioFirmaQueryPath CONFIGURACIOFIRMA_FIRMATPERFORMATIDS() {
    return new ConfiguracioFirmaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TraduccioQueryPath.this.getQueryPath() + "configuracioFirma_firmatperformatids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioFirmaQueryPath CONFIGURACIOFIRMA_MOTIUDELEGACIOIDS() {
    return new ConfiguracioFirmaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TraduccioQueryPath.this.getQueryPath() + "configuracioFirma_motiudelegacioids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFIL_NOMIDS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TraduccioQueryPath.this.getQueryPath() + "perfil_nomids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFIL_DESCRIPCIOIDS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TraduccioQueryPath.this.getQueryPath() + "perfil_descripcioids" + ".";
      }
    });
  }
*/

}
