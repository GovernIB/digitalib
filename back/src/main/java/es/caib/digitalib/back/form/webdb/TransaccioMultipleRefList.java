
package es.caib.digitalib.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.ejb.TransaccioMultipleLocal;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.fields.TransaccioMultipleFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class TransaccioMultipleRefList extends RefListBase
    implements TransaccioMultipleFields {

  @EJB(mappedName = TransaccioMultipleLocal.JNDI_NAME)
  private TransaccioMultipleLocal transaccioMultipleEjb;

  public TransaccioMultipleRefList(TransaccioMultipleRefList __clone) {
    super(__clone);
    this.transaccioMultipleEjb = __clone.transaccioMultipleEjb;
  }
  public TransaccioMultipleRefList() {
    setSelects(new Select<?>[] { DESCRIPCIO.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = transaccioMultipleEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
