package es.caib.digitalib.back.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.PluginController;
import es.caib.digitalib.back.form.webdb.PluginFilterForm;
import es.caib.digitalib.back.form.webdb.PluginForm;
import es.caib.digitalib.jpa.PluginJPA;
import es.caib.digitalib.logic.PerfilLogicaLocal;
import es.caib.digitalib.logic.PluginLogicaLocal;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
public abstract class AbstractPluginAdminController extends PluginController {

  @EJB(mappedName = PluginLogicaLocal.JNDI_NAME)
  protected PluginLogicaLocal pluginLogicaEjb;
  
  @EJB(mappedName = PerfilLogicaLocal.JNDI_NAME)
  protected PerfilLogicaLocal perfilLogicaEjb;

  public abstract String getContextWebPlugin();
  
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
    
    PluginJPA p = pluginForm.getPlugin();
    
    if (pluginForm.isNou()) {
      p.setActiu(true);
      p.setTipus(getTipusDePlugin());
    } else {
      if (p.isActiu()) {
        pluginForm.addAdditionalButton(new AdditionalButton("icon-ban-circle icon-white", "plugin.desactivar",
            getContextWebPlugin() + "/desactivarplugin/" + p.getPluginID()  , "btn-warning"));
      } else {
        pluginForm.addAdditionalButton(new AdditionalButton("icon-ok-circle icon-white", "plugin.activar",
            getContextWebPlugin() + "/activarplugin/" + p.getPluginID()  , "btn-success"));
      }
    }

    Set<Field<?>> readOnly = new HashSet<Field<?>>();
    readOnly.add(ACTIU);
    
    pluginForm.setReadOnlyFields(readOnly);
    
    pluginForm.addHiddenField(TIPUS);

    return pluginForm;
  }
  
  @RequestMapping(value = "/activarplugin/{pluginid}", method = RequestMethod.GET)
  public String pluginActivate(HttpServletRequest request, HttpServletResponse response,
      @PathVariable Long pluginid) throws I18NException {

    PluginJPA p = pluginLogicaEjb.findByPrimaryKey(pluginid);

    p.setActiu(true);
    pluginLogicaEjb.update(p);

    String msg = createMessageSuccess(request, "success.activarplugin", p.getPluginID());
    HtmlUtils.saveMessageSuccess(request, msg);

    return "redirect:" + getContextWebPlugin() + "/list/";
  }
  
  @RequestMapping(value = "/desactivarplugin/{pluginid}", method = RequestMethod.GET)
  public String pluginDeactivate(HttpServletRequest request, HttpServletResponse response,
      @PathVariable Long pluginid) throws I18NException {

    PluginJPA p = pluginLogicaEjb.findByPrimaryKey(pluginid);
    
    int tipusPlugin = getTipusDePlugin();
    
    Where w = null;
    
    switch (tipusPlugin) {
      case Constants.TIPUS_PLUGIN_ARXIU:
        w = PerfilFields.PLUGINARXIUID.equal(p.getPluginID());
        break;
      case Constants.TIPUS_PLUGIN_DOCUMENT_CUSTODY:
        w = PerfilFields.PLUGINDOCCUSTODYID.equal(p.getPluginID());
        break;
      case Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR:
        w = PerfilFields.PLUGINFIRMASERVIDORID.equal(p.getPluginID());
        break;
      case Constants.TIPUS_PLUGIN_SCANWEB:
        w = Where.AND(PerfilFields.PLUGINSCANWEBID.equal(p.getPluginID()), PerfilFields.PLUGINSCANWEB2ID.equal(p.getPluginID()));
        break;
    }
    
    List<Perfil> perfils = perfilLogicaEjb.select(w);
    
    if (perfils.size() > 0) {
      Long id = perfils.get(0).getPerfilID();
      String msg = createMessageError(request, "error.desactivarplugin", id);
      System.out.println("ERROR = "+msg);
      
      return "redirect:" + getContextWebPlugin() + "/" + p.getPluginID() + "/edit";
    }
    
    p.setActiu(false);
    pluginLogicaEjb.update(p);
    String msg = createMessageSuccess(request, "success.desactivarplugin", p.getPluginID());
    
    HtmlUtils.saveMessageSuccess(request,msg);
    
    return "redirect:" + getContextWebPlugin() + "/list/";

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
