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
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/admin/pluginscanweb")
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class ScanWebPluginAdminController extends AbstractPluginAdminController {

  @Override
  public String getTileForm() {
    return "pluginScanWebFormAdmin";
  }

  @Override
  public String getTileList() {
    return "pluginScanWebListAdmin";
  }

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_SCANWEB;
  }

  @Override
  public String getCodeName() {
    return "scanwebplugin";
  }
  
}
