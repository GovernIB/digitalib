
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ConfiguracioFirmaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ConfiguracioFirmaQueryPath() {
  }

  protected ConfiguracioFirmaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField CONFIGURACIOFIRMAID() {
    return new LongField(getQueryPath(), ConfiguracioFirmaFields.CONFIGURACIOFIRMAID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), ConfiguracioFirmaFields.NOM);
  }

  public LongField PLUGINFIRMASERVIDORID() {
    return new LongField(getQueryPath(), ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID);
  }

  public BooleanField INCLOURESEGELLDETEMPS() {
    return new BooleanField(getQueryPath(), ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS);
  }

  public LongField PLUGINSEGELLATID() {
    return new LongField(getQueryPath(), ConfiguracioFirmaFields.PLUGINSEGELLATID);
  }

  public IntegerField TIPUSOPERACIOFIRMA() {
    return new IntegerField(getQueryPath(), ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA);
  }

  public IntegerField TIPUSFIRMAID() {
    return new IntegerField(getQueryPath(), ConfiguracioFirmaFields.TIPUSFIRMAID);
  }

  public IntegerField ALGORISMEDEFIRMAID() {
    return new IntegerField(getQueryPath(), ConfiguracioFirmaFields.ALGORISMEDEFIRMAID);
  }

  public BooleanField MODEDEFIRMA() {
    return new BooleanField(getQueryPath(), ConfiguracioFirmaFields.MODEDEFIRMA);
  }

  public IntegerField USPOLITICADEFIRMA() {
    return new IntegerField(getQueryPath(), ConfiguracioFirmaFields.USPOLITICADEFIRMA);
  }

  public StringField POLICYIDENTIFIER() {
    return new StringField(getQueryPath(), ConfiguracioFirmaFields.POLICYIDENTIFIER);
  }

  public StringField POLICYIDENTIFIERHASH() {
    return new StringField(getQueryPath(), ConfiguracioFirmaFields.POLICYIDENTIFIERHASH);
  }

  public StringField POLICYIDENTIFIERHASHALGORITHM() {
    return new StringField(getQueryPath(), ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM);
  }

  public StringField POLICYURLDOCUMENT() {
    return new StringField(getQueryPath(), ConfiguracioFirmaFields.POLICYURLDOCUMENT);
  }

  public IntegerField POSICIOTAULAFIRMESID() {
    return new IntegerField(getQueryPath(), ConfiguracioFirmaFields.POSICIOTAULAFIRMESID);
  }

  public LongField FIRMATPERFORMATID() {
    return new LongField(getQueryPath(), ConfiguracioFirmaFields.FIRMATPERFORMATID);
  }

  public LongField MOTIUDELEGACIOID() {
    return new LongField(getQueryPath(), ConfiguracioFirmaFields.MOTIUDELEGACIOID);
  }

  public StringField PROPIETATSTAULAFIRMES() {
    return new StringField(getQueryPath(), ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ConfiguracioFirmaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PerfilQueryPath PERFILS() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioFirmaQueryPath.this.getQueryPath() + "perfils" + ".";
      }
    });
  }
*/

  public PluginQueryPath PLUGINFIRMASERVIDOR() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioFirmaQueryPath.this.getQueryPath() + "pluginFirmaServidor" + ".";
      }
    });
  }

  public PluginQueryPath PLUGINSEGELLAT() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioFirmaQueryPath.this.getQueryPath() + "pluginSegellat" + ".";
      }
    });
  }

  public TraduccioQueryPath FIRMATPERFORMAT() {
    return new TraduccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioFirmaQueryPath.this.getQueryPath() + "firmatPerFormat" + ".";
      }
    });
  }

  public TraduccioQueryPath MOTIUDELEGACIO() {
    return new TraduccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioFirmaQueryPath.this.getQueryPath() + "motiuDelegacio" + ".";
      }
    });
  }

}
