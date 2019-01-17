
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class AuditoriaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public AuditoriaQueryPath() {
  }

  protected AuditoriaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField AUDITORIAID() {
    return new LongField(getQueryPath(), AuditoriaFields.AUDITORIAID);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), AuditoriaFields.DATA);
  }

  public LongField TRANSACCIOID() {
    return new LongField(getQueryPath(), AuditoriaFields.TRANSACCIOID);
  }

  public IntegerField TIPUS() {
    return new IntegerField(getQueryPath(), AuditoriaFields.TIPUS);
  }

  public StringField MISSATGE() {
    return new StringField(getQueryPath(), AuditoriaFields.MISSATGE);
  }

  public StringField ADDITIONALINFO() {
    return new StringField(getQueryPath(), AuditoriaFields.ADDITIONALINFO);
  }

  public BooleanField ISAPP() {
    return new BooleanField(getQueryPath(), AuditoriaFields.ISAPP);
  }

  public StringField USERNAMEAPLICACIO() {
    return new StringField(getQueryPath(), AuditoriaFields.USERNAMEAPLICACIO);
  }

  public StringField USERNAMEPERSONA() {
    return new StringField(getQueryPath(), AuditoriaFields.USERNAMEPERSONA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (AuditoriaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


}
