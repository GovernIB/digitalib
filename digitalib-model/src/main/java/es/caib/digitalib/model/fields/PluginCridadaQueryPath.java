
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class PluginCridadaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public PluginCridadaQueryPath() {
  }

  protected PluginCridadaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PLUGINCRIDADAID() {
    return new LongField(getQueryPath(), PluginCridadaFields.PLUGINCRIDADAID);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), PluginCridadaFields.DATA);
  }

  public LongField PLUGINID() {
    return new LongField(getQueryPath(), PluginCridadaFields.PLUGINID);
  }

  public StringField METODEPLUGIN() {
    return new StringField(getQueryPath(), PluginCridadaFields.METODEPLUGIN);
  }

  public IntegerField TIPUSRESULTAT() {
    return new IntegerField(getQueryPath(), PluginCridadaFields.TIPUSRESULTAT);
  }

  public LongField TEMPSEXECUCIO() {
    return new LongField(getQueryPath(), PluginCridadaFields.TEMPSEXECUCIO);
  }

  public LongField USUARIPERSONAID() {
    return new LongField(getQueryPath(), PluginCridadaFields.USUARIPERSONAID);
  }

  public LongField USUARIAPLICACIOID() {
    return new LongField(getQueryPath(), PluginCridadaFields.USUARIAPLICACIOID);
  }

  public StringField PARAMETRESTEXT() {
    return new StringField(getQueryPath(), PluginCridadaFields.PARAMETRESTEXT);
  }

  public LongField PARAMETRESFITXERID() {
    return new LongField(getQueryPath(), PluginCridadaFields.PARAMETRESFITXERID);
  }

  public StringField RETORNTEXT() {
    return new StringField(getQueryPath(), PluginCridadaFields.RETORNTEXT);
  }

  public LongField RETORNFITXERID() {
    return new LongField(getQueryPath(), PluginCridadaFields.RETORNFITXERID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (PluginCridadaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public PluginQueryPath PLUGIN() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginCridadaQueryPath.this.getQueryPath() + "plugin" + ".";
      }
    });
  }

  public FitxerQueryPath PARAMETRESFITXER() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginCridadaQueryPath.this.getQueryPath() + "parametresFitxer" + ".";
      }
    });
  }

  public FitxerQueryPath RETORNFITXER() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PluginCridadaQueryPath.this.getQueryPath() + "retornFitxer" + ".";
      }
    });
  }

}
