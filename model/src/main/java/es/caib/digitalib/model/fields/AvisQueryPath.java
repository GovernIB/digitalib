
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class AvisQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public AvisQueryPath() {
  }

  protected AvisQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField AVISID() {
    return new LongField(getQueryPath(), AvisFields.AVISID);
  }

  public LongField DESCRIPCIOID() {
    return new LongField(getQueryPath(), AvisFields.DESCRIPCIOID);
  }

  public IntegerField TIPUS() {
    return new IntegerField(getQueryPath(), AvisFields.TIPUS);
  }

  public TimestampField DATAINICI() {
    return new TimestampField(getQueryPath(), AvisFields.DATAINICI);
  }

  public TimestampField DATAFI() {
    return new TimestampField(getQueryPath(), AvisFields.DATAFI);
  }

  public LongField CONFIGGRUPID() {
    return new LongField(getQueryPath(), AvisFields.CONFIGGRUPID);
  }

  public BooleanField BLOQUEJAR() {
    return new BooleanField(getQueryPath(), AvisFields.BLOQUEJAR);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (AvisFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public TraduccioQueryPath DESCRIPCIO() {
    return new TraduccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return AvisQueryPath.this.getQueryPath() + "descripcio" + ".";
      }
    });
  }

  public ConfiguracioGrupQueryPath CONFIGURACIOGRUP() {
    return new ConfiguracioGrupQueryPath(new QueryPath() {
      public String getQueryPath() {
          return AvisQueryPath.this.getQueryPath() + "configuracioGrup" + ".";
      }
    });
  }

}
