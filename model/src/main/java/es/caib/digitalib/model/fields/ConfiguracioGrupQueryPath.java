
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ConfiguracioGrupQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ConfiguracioGrupQueryPath() {
  }

  protected ConfiguracioGrupQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField CONFIGURACIOGRUPID() {
    return new LongField(getQueryPath(), ConfiguracioGrupFields.CONFIGURACIOGRUPID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), ConfiguracioGrupFields.NOM);
  }

  public StringField SUPORTWEB() {
    return new StringField(getQueryPath(), ConfiguracioGrupFields.SUPORTWEB);
  }

  public StringField SUPORTEMAIL() {
    return new StringField(getQueryPath(), ConfiguracioGrupFields.SUPORTEMAIL);
  }

  public StringField SUPORTTELEFON() {
    return new StringField(getQueryPath(), ConfiguracioGrupFields.SUPORTTELEFON);
  }

  public LongField LOGOHEADERID() {
    return new LongField(getQueryPath(), ConfiguracioGrupFields.LOGOHEADERID);
  }

  public LongField LOGOFOOTERID() {
    return new LongField(getQueryPath(), ConfiguracioGrupFields.LOGOFOOTERID);
  }

  public StringField ADREZA() {
    return new StringField(getQueryPath(), ConfiguracioGrupFields.ADREZA);
  }

  public LongField PERFILNOMESESCANEIGID() {
    return new LongField(getQueryPath(), ConfiguracioGrupFields.PERFILNOMESESCANEIGID);
  }

  public LongField PERFILCOPIAAUTENTICAID() {
    return new LongField(getQueryPath(), ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID);
  }

  public LongField PERFILCUSTODIAID() {
    return new LongField(getQueryPath(), ConfiguracioGrupFields.PERFILCUSTODIAID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ConfiguracioGrupFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public UsuariPersonaQueryPath USUARIPERSONAS() {
    return new UsuariPersonaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioGrupQueryPath.this.getQueryPath() + "usuariPersonas" + ".";
      }
    });
  }
*/

  public FitxerQueryPath LOGOHEADER() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioGrupQueryPath.this.getQueryPath() + "logoHeader" + ".";
      }
    });
  }

  public FitxerQueryPath LOGOFOOTER() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioGrupQueryPath.this.getQueryPath() + "logoFooter" + ".";
      }
    });
  }

  public PerfilQueryPath PERFILNOMESESCANEIG() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioGrupQueryPath.this.getQueryPath() + "perfilNomesEscaneig" + ".";
      }
    });
  }

  public PerfilQueryPath PERFILCOPIAAUTENTICA() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioGrupQueryPath.this.getQueryPath() + "perfilCopiaAutentica" + ".";
      }
    });
  }

  public PerfilQueryPath PERFILCUSTODIA() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ConfiguracioGrupQueryPath.this.getQueryPath() + "perfilCustodia" + ".";
      }
    });
  }

}
