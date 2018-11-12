
package es.caib.digitalib.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.ejb.TransaccioLocal;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.fields.TransaccioFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class TransaccioRefList extends RefListBase
    implements TransaccioFields {

  @EJB(mappedName = TransaccioLocal.JNDI_NAME)
  private TransaccioLocal transaccioEjb;

  public TransaccioRefList(TransaccioRefList __clone) {
    super(__clone);
    this.transaccioEjb = __clone.transaccioEjb;
  }
  public TransaccioRefList() {
    setSelects(new Select<?>[] { TRANSACCIOID.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = transaccioEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
