
package es.caib.digitalib.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.ejb.PluginCridadaService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.fields.PluginCridadaFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PluginCridadaRefList extends RefListBase
    implements PluginCridadaFields {

  @EJB(mappedName = PluginCridadaService.JNDI_NAME)
  private PluginCridadaService pluginCridadaEjb;

  public PluginCridadaRefList(PluginCridadaRefList __clone) {
    super(__clone);
    this.pluginCridadaEjb = __clone.pluginCridadaEjb;
  }
  public PluginCridadaRefList() {
    setSelects(new Select<?>[] { PLUGINCRIDADAID.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = pluginCridadaEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}