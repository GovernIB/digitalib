
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class PerfilQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public PerfilQueryPath() {
  }

  protected PerfilQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PERFILID() {
    return new LongField(getQueryPath(), PerfilFields.PERFILID);
  }

  public StringField CODI() {
    return new StringField(getQueryPath(), PerfilFields.CODI);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), PerfilFields.NOM);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), PerfilFields.DESCRIPCIO);
  }

  public LongField PLUGINSCANWEBID() {
    return new LongField(getQueryPath(), PerfilFields.PLUGINSCANWEBID);
  }

  public IntegerField TIPUSFIRMA() {
    return new IntegerField(getQueryPath(), PerfilFields.TIPUSFIRMA);
  }

  public LongField PLUGINFIRMASERVIDORID() {
    return new LongField(getQueryPath(), PerfilFields.PLUGINFIRMASERVIDORID);
  }

  public LongField APISIMPLEID() {
    return new LongField(getQueryPath(), PerfilFields.APISIMPLEID);
  }

  public IntegerField TIPUSCUSTODIA() {
    return new IntegerField(getQueryPath(), PerfilFields.TIPUSCUSTODIA);
  }

  public LongField PLUGINARXIUID() {
    return new LongField(getQueryPath(), PerfilFields.PLUGINARXIUID);
  }

  public LongField PLUGINDOCCUSTODYID() {
    return new LongField(getQueryPath(), PerfilFields.PLUGINDOCCUSTODYID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (PerfilFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilUsuariAplicacioQueryPath PERFILUSUARIAPLICACIOS() {
    return new PerfilUsuariAplicacioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "perfilUsuariAplicacios" + ".";
      }
    });
  }
*/

  public PluginQueryPath PLUGINSCANWEB() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "pluginScanWeb" + ".";
      }
    });
  }

  public PluginQueryPath PLUGINFIRMASERVIDOR() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "pluginFirmaServidor" + ".";
      }
    });
  }

  public ApiSimpleQueryPath APISIMPLE() {
    return new ApiSimpleQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "apiSimple" + ".";
      }
    });
  }

  public PluginQueryPath PLUGINARXIU() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "pluginArxiu" + ".";
      }
    });
  }

  public PluginQueryPath PLUGINDOCCUSTODY() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "pluginDocCustody" + ".";
      }
    });
  }

}
