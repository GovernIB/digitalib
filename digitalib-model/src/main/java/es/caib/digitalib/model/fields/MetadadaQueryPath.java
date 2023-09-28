
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class MetadadaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public MetadadaQueryPath() {
  }

  protected MetadadaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField METADADAID() {
    return new LongField(getQueryPath(), MetadadaFields.METADADAID);
  }

  public LongField TRANSACCIOID() {
    return new LongField(getQueryPath(), MetadadaFields.TRANSACCIOID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), MetadadaFields.NOM);
  }

  public StringField VALOR() {
    return new StringField(getQueryPath(), MetadadaFields.VALOR);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (MetadadaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public TransaccioQueryPath TRANSACCIO() {
    return new TransaccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return MetadadaQueryPath.this.getQueryPath() + "transaccio" + ".";
      }
    });
  }

}
