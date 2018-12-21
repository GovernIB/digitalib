
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

  public LongField NOMID() {
    return new LongField(getQueryPath(), PerfilFields.NOMID);
  }

  public LongField DESCRIPCIOID() {
    return new LongField(getQueryPath(), PerfilFields.DESCRIPCIOID);
  }

  public StringField URLBASE() {
    return new StringField(getQueryPath(), PerfilFields.URLBASE);
  }

  public IntegerField SCANFORMATFITXER() {
    return new IntegerField(getQueryPath(), PerfilFields.SCANFORMATFITXER);
  }

  public IntegerField SCANMINIMARESOLUCIO() {
    return new IntegerField(getQueryPath(), PerfilFields.SCANMINIMARESOLUCIO);
  }

  public IntegerField SCANPIXELTYPE() {
    return new IntegerField(getQueryPath(), PerfilFields.SCANPIXELTYPE);
  }

  public LongField PLUGINSCANWEBID() {
    return new LongField(getQueryPath(), PerfilFields.PLUGINSCANWEBID);
  }

  public LongField PLUGINSCANWEB2ID() {
    return new LongField(getQueryPath(), PerfilFields.PLUGINSCANWEB2ID);
  }

  public IntegerField TIPUSFIRMA() {
    return new IntegerField(getQueryPath(), PerfilFields.TIPUSFIRMA);
  }

  public LongField APISIMPLEID() {
    return new LongField(getQueryPath(), PerfilFields.APISIMPLEID);
  }

  public LongField PLUGINFIRMASERVIDORID() {
    return new LongField(getQueryPath(), PerfilFields.PLUGINFIRMASERVIDORID);
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

  public IntegerField USPERFIL() {
    return new IntegerField(getQueryPath(), PerfilFields.USPERFIL);
  }

  public BooleanField UTILITZATPERAPLICACIO() {
    return new BooleanField(getQueryPath(), PerfilFields.UTILITZATPERAPLICACIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (PerfilFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_PERFILNOMESESCANEIG2IDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "configuracioGrup_perfilnomesescaneig2ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_PERFILCOPIAAUTENTICA2IDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "configuracioGrup_perfilcopiaautentica2ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_PERFILCUSTODIA2IDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "configuracioGrup_perfilcustodia2ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_PERFILNOMESESCANEIGIDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "configuracioGrup_perfilnomesescaneigids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_PERFILCOPIAAUTENTICAIDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "configuracioGrup_perfilcopiaautenticaids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP_PERFILCUSTODIAIDS() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "configuracioGrup_perfilcustodiaids" + ".";
      }
    });
  }
*/

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

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public TransaccioQueryPath TRANSACCIOS() {
    return new TransaccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "transaccios" + ".";
      }
    });
  }
*/

  public TraduccioQueryPath NOM() {
    return new TraduccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "nom" + ".";
      }
    });
  }

  public TraduccioQueryPath DESCRIPCIO() {
    return new TraduccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "descripcio" + ".";
      }
    });
  }

  public PluginQueryPath PLUGINSCANWEB() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "pluginScanWeb" + ".";
      }
    });
  }

  public PluginQueryPath PLUGINSCANWEB2() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "pluginScanWeb2" + ".";
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

  public PluginQueryPath PLUGINFIRMASERVIDOR() {
    return new PluginQueryPath(new QueryPath() {
      public String getQueryPath() {
          return PerfilQueryPath.this.getQueryPath() + "pluginFirmaServidor" + ".";
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
