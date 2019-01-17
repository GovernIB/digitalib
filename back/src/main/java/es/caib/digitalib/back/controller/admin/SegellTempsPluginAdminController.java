package es.caib.digitalib.back.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.AbstractPluginAdminController;
import es.caib.digitalib.back.form.webdb.PluginFilterForm;
import es.caib.digitalib.back.form.webdb.PluginForm;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author u139636
 *
 */
@Controller
@RequestMapping(value = "/admin/pluginsegelltemps")
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class SegellTempsPluginAdminController extends AbstractPluginAdminController {

  @Override
  public String getTileForm() {
    return "pluginSegellTempsFormAdmin";
  }

  @Override
  public String getTileList() {
    return "pluginSegellTempsListAdmin";
  }

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_SEGELLDETEMPS;
  }

  @Override
  public String getCodeName() {
    return "pluginsegelltemps";
  }
  
}