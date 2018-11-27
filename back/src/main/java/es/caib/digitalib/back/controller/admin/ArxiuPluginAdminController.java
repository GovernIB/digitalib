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
@RequestMapping(value = "/admin/pluginarxiu")
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class ArxiuPluginAdminController extends AbstractPluginAdminController {

  @Override
  public String getTileForm() {
    return "pluginArxiuFormAdmin";
  }

  @Override
  public String getTileList() {
    return "pluginArxiuListAdmin";
  }

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_ARXIU;
  }

  @Override
  public String getCodeName() {
    return "arxiuplugin";
  }
  
}
