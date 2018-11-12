
package es.caib.digitalib.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PerfilUsuariAplicacioRefList extends RefListBase
    implements PerfilUsuariAplicacioFields {

  @EJB(mappedName = PerfilUsuariAplicacioLocal.JNDI_NAME)
  private PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;

  public PerfilUsuariAplicacioRefList(PerfilUsuariAplicacioRefList __clone) {
    super(__clone);
    this.perfilUsuariAplicacioEjb = __clone.perfilUsuariAplicacioEjb;
  }
  public PerfilUsuariAplicacioRefList() {
    setSelects(new Select<?>[] { PERFILID.select, USUARIAPLICACIOID.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = perfilUsuariAplicacioEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
