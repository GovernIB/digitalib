package es.caib.digitalib.back.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Where;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.PluginController;
import es.caib.digitalib.back.form.webdb.PluginFilterForm;
import es.caib.digitalib.back.form.webdb.PluginForm;
import es.caib.digitalib.jpa.PluginJPA;
import es.caib.digitalib.logic.PluginLogicaLocal;
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
public abstract class AbstractPluginAdminController extends PluginController {

  @EJB(mappedName = PluginLogicaLocal.JNDI_NAME)
  protected PluginLogicaLocal pluginLogicaEjb;

  public abstract int getTipusDePlugin();

  public abstract String getCodeName();

  @Override
  public String getSessionAttributeFilterForm() {
    return getClass().getName() + "_FilterForm";
  }

  @Override
  public final Where getAdditionalCondition(HttpServletRequest request) throws I18NException {

    return TIPUS.equal(getTipusDePlugin());
  }

  @Override
  public PluginFilterForm getPluginFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {
    PluginFilterForm pluginFilterForm;
    pluginFilterForm = super.getPluginFilterForm(pagina, mav, request);

    if (pluginFilterForm.isNou()) {

      pluginFilterForm.getDefaultGroupByFields().remove(TIPUS);

      pluginFilterForm.addHiddenField(PLUGINID);
      pluginFilterForm.addHiddenField(ORDRE);
      pluginFilterForm.addHiddenField(CLASSE);
      pluginFilterForm.addHiddenField(TIPUS);
      pluginFilterForm.addHiddenField(DESCRIPCIO);
      pluginFilterForm.addHiddenField(PROPERTIES);

      
      pluginFilterForm.setOrderBy(ORDRE.javaName);
      pluginFilterForm.setOrderAsc(true);
      
      
      // TODO Ordenar per camp Traduit
      // pluginFilterForm.setDefaultOrderBy(new OrderBy[] { new OrderBy( new
      // PluginQueryPath().NOM(). )} );
    }

    return pluginFilterForm;
  }

  @Override
  public PluginForm getPluginForm(PluginJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    PluginForm pluginForm = super.getPluginForm(_jpa, __isView, request, mav);
    if (pluginForm.isNou()) {
      PluginJPA p = pluginForm.getPlugin();
      p.setActiu(true);
      p.setTipus(getTipusDePlugin());
    }

    pluginForm.addHiddenField(TIPUS);

    return pluginForm;
  }

  @Override
  public void preValidate(HttpServletRequest request, PluginForm pluginForm,
      BindingResult result) throws I18NException {

  }

  @Override
  public String getEntityNameCode() {
    return getCodeName();
  }

  @Override
  public String getEntityNameCodePlural() {
    return getCodeName() + ".plural";
  }

  @Override
  public PluginJPA update(HttpServletRequest request, PluginJPA plugin) throws Exception,
      I18NException, I18NValidationException {
    return (PluginJPA) pluginLogicaEjb.update(plugin);
  }

  @Override
  public void delete(HttpServletRequest request, Plugin plugin) throws Exception,
      I18NException {
    pluginLogicaEjb.delete(plugin);
  }

  @Override
  public List<StringKeyValue> getReferenceListForTipus(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_PLUGIN_SCANWEB, "PLUGIN SCAN WEB"));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_PLUGIN_DOCUMENT_CUSTODY,
        "PLUGIN DOCUMENT CUSTODY"));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR,
        "PLUGIN FIRMA EN SERVIDOR"));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_PLUGIN_ARXIU, "PLUGIN ARXIU"));
    __tmp.add(new StringKeyValue("" + Constants.TIPUS_PLUGIN_SEGELLDETEMPS, "PLUGIN SEGELL TEMPS"));
    return __tmp;
  }

}
