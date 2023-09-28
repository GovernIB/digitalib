
package es.caib.digitalib.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.ejb.PerfilService;
import es.caib.digitalib.ejb.TraduccioService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.digitalib.model.fields.PerfilFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PerfilRefList extends RefListBase
    implements PerfilFields {

  @EJB(mappedName = PerfilService.JNDI_NAME)
  private PerfilService perfilEjb;

  @EJB(mappedName = TraduccioService.JNDI_NAME)
  private TraduccioService traduccioEjb;
  public PerfilRefList(PerfilRefList __clone) {
    super(__clone);
    this.perfilEjb = __clone.perfilEjb;
    this.traduccioEjb = __clone.traduccioEjb;
  }
  public PerfilRefList() {
    setSelects(new Select<?>[] { CODI.select });
    addCampTraduible(NOMID.select);
    addCampTraduible(DESCRIPCIOID.select);
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<Long> _transSelect = checkTranslationFields();
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = perfilEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    if (_transSelect == null) {
      return list;
    }
    // key => TransID | value => perfilEjb_PK
    java.util.Map<String,String> keysMap = org.fundaciobit.genapp.common.utils.Utils.listToMapInverse(list);
    org.fundaciobit.genapp.common.query.Where _w1 = es.caib.digitalib.model.fields.TraduccioFields.TRADUCCIOID.in(perfilEjb.executeQuery(_transSelect, where));
    List<es.caib.digitalib.model.entity.Traduccio> traduccions = traduccioEjb.select(_w1);
    List<StringKeyValue> _list = new java.util.ArrayList<StringKeyValue>(traduccions.size());
    final String _lang = org.fundaciobit.genapp.common.web.i18n.I18NUtils.getLocale().getLanguage();
    for (es.caib.digitalib.model.entity.Traduccio traduccio : traduccions) {
      es.caib.digitalib.persistence.TraduccioJPA traduccioJPA = (es.caib.digitalib.persistence.TraduccioJPA) traduccio;
      String key = keysMap.get(String.valueOf(traduccioJPA.getTraduccioID()));
      es.caib.digitalib.persistence.TraduccioMapJPA _tm = traduccioJPA.getTraduccio(_lang);
      String value;
      if (_tm == null) {
          value = "NO_TRADUCCIO_PER_CODI_" + traduccio.getTraduccioID() + "_[" + _lang + "]";
      } else {
          value= _tm.getValor();
      }
      StringKeyValue skv = new StringKeyValue(key, value);
      _list.add(skv);
    }
    if (!_list.isEmpty()) {
      java.util.Collections.sort(_list, new org.fundaciobit.genapp.common.KeyValue.KeyValueComparator<String>());
    }
    return _list;

  }
}
