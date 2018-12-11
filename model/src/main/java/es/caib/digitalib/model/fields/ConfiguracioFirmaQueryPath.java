
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

  public IntegerField POLITICATAULAFIRMES() {
    return new IntegerField(getQueryPath(), ConfiguracioFirmaFields.POLITICATAULAFIRMES);
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

  public BooleanField INCLOURESEGELLDETEMPS() {
    return new BooleanField(getQueryPath(), ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS);
  }

  public LongField PLUGINSEGELLATID() {
    return new LongField(getQueryPath(), ConfiguracioFirmaFields.PLUGINSEGELLATID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ConfiguracioFirmaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
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

  public PluginQueryPath PLUGIN() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioFirmaQueryPath.this.getQueryPath() + "plugin" + ".";
      }
    });
  }

}
