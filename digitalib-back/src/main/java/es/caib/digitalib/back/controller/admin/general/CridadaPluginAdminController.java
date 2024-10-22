package es.caib.digitalib.back.controller.admin.general;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.PluginCridadaController;
import es.caib.digitalib.back.form.webdb.PluginCridadaFilterForm;
import es.caib.digitalib.back.form.webdb.PluginCridadaForm;
import es.caib.digitalib.persistence.PluginCridadaJPA;
import es.caib.digitalib.model.entity.PluginCridada;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = "/admin/plugincridada")
@SessionAttributes(types = { PluginCridadaForm.class, PluginCridadaFilterForm.class })
public class CridadaPluginAdminController extends PluginCridadaController {
  
  
  public static final int ESTAT = 1;
  

  @Override
  public String getTileForm() {
    return "pluginCridadaFormAdmin";
  }

  @Override
  public String getTileList() {
    return "pluginCridadaListAdmin";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "PluginCridadaAdmin_FilterForm";
  }

  @Override
  public boolean isActiveList() {
    return true;
  }

  @Override
  public boolean isActiveFormNew() {
    return false;
  }

  @Override
  public boolean isActiveFormEdit() {
    return false;
  }

  @Override
  public boolean isActiveDelete() {
    return true;
  }

  @Override
  public boolean isActiveFormView() {
    return true;
  }
  
  @Override
  public PluginCridadaForm getPluginCridadaForm(PluginCridadaJPA _jpa,
      boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
     PluginCridadaForm pluginCridadaForm = super.getPluginCridadaForm(_jpa, __isView, request, mav);
     
     PluginCridadaForm.hideNullFields(_jpa, pluginCridadaForm, ALL_PLUGINCRIDADA_FIELDS);
     
     return pluginCridadaForm;
     
  }
  

  @Override
  public PluginCridadaFilterForm getPluginCridadaFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {
    PluginCridadaFilterForm pluginCridadaFilterForm;
    pluginCridadaFilterForm = super.getPluginCridadaFilterForm(pagina, mav, request);

    if (pluginCridadaFilterForm.isNou()) {
      pluginCridadaFilterForm.setAddButtonVisible(false);
      //pluginCridadaFilterForm.setEditButtonVisible(false);

      pluginCridadaFilterForm.addHiddenField(PARAMETRESFITXERID);
      pluginCridadaFilterForm.addHiddenField(PARAMETRESTEXT);
      pluginCridadaFilterForm.addHiddenField(RETORNFITXERID);
      pluginCridadaFilterForm.addHiddenField(RETORNTEXT);
      pluginCridadaFilterForm.addHiddenField(TEMPSEXECUCIO);
      pluginCridadaFilterForm.addHiddenField(PLUGINCRIDADAID);
      pluginCridadaFilterForm.addHiddenField(USUARIAPLICACIOID);
      pluginCridadaFilterForm.addHiddenField(USUARIPERSONAID);
      pluginCridadaFilterForm.addHiddenField(TIPUSRESULTAT);
      
      pluginCridadaFilterForm.setOrderBy(DATA.javaName);
      pluginCridadaFilterForm.setOrderAsc(false);

      
      {
        AdditionalField<Long, String> adfield4 = new AdditionalField<Long, String>();
        adfield4.setCodeName(TransaccioFields.ESTATCODI.fullName);
        adfield4.setPosition(ESTAT);
        // Els valors s'ompliran al mètode postList()
        adfield4.setValueMap(new HashMap<Long, String>());
        adfield4.setEscapeXml(false);
        pluginCridadaFilterForm.addAdditionalField(adfield4);
      }
      
    }

    return pluginCridadaFilterForm;

  }

  @Override
  public List<StringKeyValue> getReferenceListForTipusResultat(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("-1", "Error"));
    __tmp.add(new StringKeyValue("0", "En procés"));
    __tmp.add(new StringKeyValue("1", "Correcte"));
    return __tmp;
  }
  
  @Override
  public void postList(HttpServletRequest request, ModelAndView mav, 
      PluginCridadaFilterForm filterForm,  List<PluginCridada> list) throws I18NException {


  
    Map<Long, String> map;
    map = (Map<Long, String>) filterForm.getAdditionalField(
        ESTAT).getValueMap();
  
    map.clear();
    long key;
    String value;
    
    final String base = "<img src=\"" + request.getContextPath() + "/img/" + "icn_alert_";
    
    for (PluginCridada c : list) {
      key = c.getPluginCridadaID();
 
      switch(c.getTipusResultat()) {
        
        default:
        case Constants.CRIDADA_PLUGIN_RESULTAT_EN_PROCES:
          value = "";
        break;
        
        case Constants.CRIDADA_PLUGIN_RESULTAT_OK:
          value = base + "success.png\"/>";
          break;
          
        case  Constants.CRIDADA_PLUGIN_RESULTAT_ERROR:
            value = base + "error.png\"/>";
        break;
      }
      
      map.put(key, value);
      
    }
  }
  
  @Override
  @RequestMapping(value = "/{pluginCridadaID}/edit", method = RequestMethod.GET)
  public ModelAndView editarPluginCridadaGet(@PathVariable("pluginCridadaID") java.lang.Long pluginCridadaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewPluginCridadaGet(pluginCridadaID,
        request, response, true);
  }
  

  // TODO *** AGRUPACIO PER TIPUS DE PLUGIN

}
