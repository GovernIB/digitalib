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
@RequestMapping(value = "/admin/plugindoccustody")
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class DocCustodyPluginAdminController extends AbstractPluginAdminController {

  @Override
  public String getTileForm() {
    return "pluginDocCustodyFormAdmin";
  }

  @Override
  public String getTileList() {
    return "pluginDocCustodyListAdmin";
  }

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_DOCUMENT_CUSTODY;
  }

  @Override
  public String getCodeName() {
    return "doccustodyplugin";
  }
  
}
