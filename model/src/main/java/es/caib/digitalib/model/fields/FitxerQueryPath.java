
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class FitxerQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public FitxerQueryPath() {
  }

  protected FitxerQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField FITXERID() {
    return new LongField(getQueryPath(), FitxerFields.FITXERID);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), FitxerFields.DESCRIPCIO);
  }

  public StringField MIME() {
    return new StringField(getQueryPath(), FitxerFields.MIME);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), FitxerFields.NOM);
  }

  public LongField TAMANY() {
    return new LongField(getQueryPath(), FitxerFields.TAMANY);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (FitxerFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_LOGOHEADERIDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "configuracioGrup_logoheaderids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_LOGOFOOTERIDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "configuracioGrup_logofooterids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PluginCridadaQueryPath PLUGINCRIDADA_PARAMETRESFITXERIDS() {
    return new PluginCridadaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "pluginCridada_parametresfitxerids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PluginCridadaQueryPath PLUGINCRIDADA_RETORNFITXERIDS() {
    return new PluginCridadaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "pluginCridada_retornfitxerids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public TransaccioQueryPath TRANSACCIO_FITXERESCANEJATIDS() {
    return new TransaccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "transaccio_fitxerescanejatids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public TransaccioQueryPath TRANSACCIO_FITXERSIGNATURAIDS() {
    return new TransaccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "transaccio_fitxersignaturaids" + ".";
      }
    });
  }
*/

}
