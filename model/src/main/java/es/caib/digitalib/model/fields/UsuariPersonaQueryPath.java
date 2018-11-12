
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class UsuariPersonaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public UsuariPersonaQueryPath() {
  }

  protected UsuariPersonaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField USUARIPERSONAID() {
    return new LongField(getQueryPath(), UsuariPersonaFields.USUARIPERSONAID);
  }

  public StringField USERNAME() {
    return new StringField(getQueryPath(), UsuariPersonaFields.USERNAME);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), UsuariPersonaFields.NOM);
  }

  public StringField LLINATGES() {
    return new StringField(getQueryPath(), UsuariPersonaFields.LLINATGES);
  }

  public StringField EMAIL() {
    return new StringField(getQueryPath(), UsuariPersonaFields.EMAIL);
  }

  public StringField NIF() {
    return new StringField(getQueryPath(), UsuariPersonaFields.NIF);
  }

  public StringField IDIOMAID() {
    return new StringField(getQueryPath(), UsuariPersonaFields.IDIOMAID);
  }

  public LongField CONFIGURACIOGRUPID() {
    return new LongField(getQueryPath(), UsuariPersonaFields.CONFIGURACIOGRUPID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (UsuariPersonaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public IdiomaQueryPath IDIOMA() {
    return new IdiomaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuariPersonaQueryPath.this.getQueryPath() + "idioma" + ".";
      }
    });
  }

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuariPersonaQueryPath.this.getQueryPath() + "configuracioGrup" + ".";
      }
    });
  }

}
