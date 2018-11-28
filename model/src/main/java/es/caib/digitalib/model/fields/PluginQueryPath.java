
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class PluginQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public PluginQueryPath() {
  }

  protected PluginQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PLUGINID() {
    return new LongField(getQueryPath(), PluginFields.PLUGINID);
  }

  public StringField CODI() {
    return new StringField(getQueryPath(), PluginFields.CODI);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), PluginFields.NOM);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), PluginFields.DESCRIPCIO);
  }

  public StringField CLASSE() {
    return new StringField(getQueryPath(), PluginFields.CLASSE);
  }

  public StringField PROPERTIES() {
    return new StringField(getQueryPath(), PluginFields.PROPERTIES);
  }

  public BooleanField ACTIU() {
    return new BooleanField(getQueryPath(), PluginFields.ACTIU);
  }

  public IntegerField TIPUS() {
    return new IntegerField(getQueryPath(), PluginFields.TIPUS);
  }

  public IntegerField ORDRE() {
    return new IntegerField(getQueryPath(), PluginFields.ORDRE);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (PluginFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFIL_PLUGINSCANWEBIDS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginQueryPath.this.getQueryPath() + "perfil_pluginscanwebids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFIL_PLUGINFIRMASERVIDORIDS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginQueryPath.this.getQueryPath() + "perfil_pluginfirmaservidorids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFIL_PLUGINARXIUIDS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginQueryPath.this.getQueryPath() + "perfil_pluginarxiuids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFIL_PLUGINDOCCUSTODYIDS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginQueryPath.this.getQueryPath() + "perfil_plugindoccustodyids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFIL_PLUGINSCANWEB2IDS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginQueryPath.this.getQueryPath() + "perfil_pluginscanweb2ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PluginCridadaQueryPath PLUGINCRIDADAS() {
    return new PluginCridadaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginQueryPath.this.getQueryPath() + "pluginCridadas" + ".";
      }
    });
  }
*/

}
