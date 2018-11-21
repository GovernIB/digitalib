
package es.caib.digitalib.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.ejb.InfoSignaturaLocal;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.fields.InfoSignaturaFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class InfoSignaturaRefList extends RefListBase
    implements InfoSignaturaFields {

  @EJB(mappedName = InfoSignaturaLocal.JNDI_NAME)
  private InfoSignaturaLocal infoSignaturaEjb;

  public InfoSignaturaRefList(InfoSignaturaRefList __clone) {
    super(__clone);
    this.infoSignaturaEjb = __clone.infoSignaturaEjb;
  }
  public InfoSignaturaRefList() {
    setSelects(new Select<?>[] { SIGNOPERATION.select, SIGNTYPE.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = infoSignaturaEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
