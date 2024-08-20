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
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.PluginController;
import es.caib.digitalib.back.form.webdb.PluginFilterForm;
import es.caib.digitalib.back.form.webdb.PluginForm;
import es.caib.digitalib.persistence.PluginJPA;
import es.caib.digitalib.logic.PerfilLogicaService;
import es.caib.digitalib.logic.PluginLogicaService;
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.model.fields.ConfiguracioFirmaFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
public abstract class AbstractPluginAdminController extends PluginController {

  @EJB(mappedName = PluginLogicaService.JNDI_NAME)
  protected PluginLogicaService pluginLogicaEjb;
  
  @EJB(mappedName = PerfilLogicaService.JNDI_NAME)
  protected PerfilLogicaService perfilLogicaEjb;
  
  @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioFirmaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioFirmaService configuracioFirmaEjb;

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
        pluginForm.addAdditionalButton(new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_BAN_CIRCLE), "plugin.desactivar",
            getContextWebPlugin() + "/desactivarplugin/" + p.getPluginID()  , AdditionalButtonStyle.WARNING));
      } else {
        pluginForm.addAdditionalButton(new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_OK_CIRCLE), "plugin.activar",
            getContextWebPlugin() + "/activarplugin/" + p.getPluginID()  , AdditionalButtonStyle.SUCCESS));
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

    String msg = I18NUtils.tradueix("success.activarplugin", String.valueOf(p.getPluginID()));
    HtmlUtils.saveMessageSuccess(request, msg);

    return "redirect:" + getContextWebPlugin() + "/list/";
  }
  
  @RequestMapping(value = "/desactivarplugin/{pluginid}", method = RequestMethod.GET)
  public String pluginDeactivate(HttpServletRequest request, HttpServletResponse response,
      @PathVariable Long pluginid) throws I18NException {

    PluginJPA p = pluginLogicaEjb.findByPrimaryKey(pluginid);
    
    int tipusPlugin = getTipusDePlugin();
    
    
    List<String> infoCodiNom;
    
    switch (tipusPlugin) {
      case Constants.TIPUS_PLUGIN_ARXIU:
        Where w1 = Where.AND( 
            PerfilFields.PLUGINARXIUID.equal(p.getPluginID()),
            PerfilFields.USPERFIL.greaterThan(0)
            );
        infoCodiNom = perfilLogicaEjb.executeQuery(PerfilFields.CODI, w1);
        break;
      case Constants.TIPUS_PLUGIN_DOCUMENT_CUSTODY:
        Where w2 = Where.AND( 
           PerfilFields.PLUGINDOCCUSTODYID.equal(p.getPluginID()),
           PerfilFields.USPERFIL.greaterThan(0)
           );
        infoCodiNom = perfilLogicaEjb.executeQuery(PerfilFields.CODI, w2);
        break;
      case Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR:
        Where w3 = ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID.equal(p.getPluginID());
        infoCodiNom = configuracioFirmaEjb.executeQuery(ConfiguracioFirmaFields.NOM, w3);
        break;
        
      case Constants.TIPUS_PLUGIN_SEGELLDETEMPS:
        Where w4 = ConfiguracioFirmaFields.PLUGINSEGELLATID.equal(p.getPluginID());
        infoCodiNom = configuracioFirmaEjb.executeQuery(ConfiguracioFirmaFields.NOM, w4);
        break;
        
      case Constants.TIPUS_PLUGIN_SCANWEB:
        Where w5 = Where.AND( 
            Where.OR(PerfilFields.PLUGINSCANWEBID.equal(p.getPluginID()), PerfilFields.PLUGINSCANWEB2ID.equal(p.getPluginID())),
            PerfilFields.USPERFIL.greaterThan(0)
            );
                
        infoCodiNom = perfilLogicaEjb.executeQuery(PerfilFields.CODI, w5);
        break;
        
      default:
        throw new I18NException("genapp.comodi", I18NUtils.tradueix("plugin.tipus.notrobat", String.valueOf(tipusPlugin)));
    }
    
    
    
    if (infoCodiNom.size() > 0) {
      String codiNom = infoCodiNom.get(0);
      String msg;
      if (tipusPlugin == Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR || tipusPlugin == Constants.TIPUS_PLUGIN_SEGELLDETEMPS) {
        // No es pot desactivar el plugin perquè el fa servir la configuració de firma amb nom {0}.
        msg = I18NUtils.tradueix("error.desactivarplugin.2", codiNom);
      } else {
        // No es pot desactivar el plugin perquè el fa servir el perfil amb codi {0}.
        msg = I18NUtils.tradueix("error.desactivarplugin", codiNom);
      }
      HtmlUtils.saveMessageError(request, msg);
      
      return "redirect:" + getContextWebPlugin() + "/" + p.getPluginID() + "/edit";
    }
    
    p.setActiu(false);
    pluginLogicaEjb.update(p);
    String msg = I18NUtils.tradueix("success.desactivarplugin", p.getCodi());
    
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
  public PluginJPA update(HttpServletRequest request, PluginJPA plugin) throws I18NException, I18NValidationException {
    return (PluginJPA) pluginLogicaEjb.update(plugin);
  }

  @Override
  public void delete(HttpServletRequest request, Plugin plugin) throws I18NException {
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
