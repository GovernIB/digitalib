
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class EstadisticaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public EstadisticaQueryPath() {
  }

  protected EstadisticaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField ESTADISTICAID() {
    return new LongField(getQueryPath(), EstadisticaFields.ESTADISTICAID);
  }

  public IntegerField TIPUS() {
    return new IntegerField(getQueryPath(), EstadisticaFields.TIPUS);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), EstadisticaFields.DATA);
  }

  public DoubleField VALOR() {
    return new DoubleField(getQueryPath(), EstadisticaFields.VALOR);
  }

  public StringField PARAMETRES() {
    return new StringField(getQueryPath(), EstadisticaFields.PARAMETRES);
  }

  public LongField USUARIAPLICACIOID() {
    return new LongField(getQueryPath(), EstadisticaFields.USUARIAPLICACIOID);
  }

  public LongField USUARIPERSONAID() {
    return new LongField(getQueryPath(), EstadisticaFields.USUARIPERSONAID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (EstadisticaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


}
