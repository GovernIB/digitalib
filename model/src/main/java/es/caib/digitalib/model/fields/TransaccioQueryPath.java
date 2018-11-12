
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class TransaccioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public TransaccioQueryPath() {
  }

  protected TransaccioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField TRANSACCIOID() {
    return new LongField(getQueryPath(), TransaccioFields.TRANSACCIOID);
  }

  public TimestampField DATAINICI() {
    return new TimestampField(getQueryPath(), TransaccioFields.DATAINICI);
  }

  public TimestampField DATAFI() {
    return new TimestampField(getQueryPath(), TransaccioFields.DATAFI);
  }

  public LongField USUARIAPLICACIOID() {
    return new LongField(getQueryPath(), TransaccioFields.USUARIAPLICACIOID);
  }

  public LongField USUARIPERSONAID() {
    return new LongField(getQueryPath(), TransaccioFields.USUARIPERSONAID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (TransaccioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


}
