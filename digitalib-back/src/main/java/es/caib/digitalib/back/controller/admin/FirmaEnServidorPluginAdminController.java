package es.caib.digitalib.back.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.AbstractPluginAdminController;
import es.caib.digitalib.back.form.webdb.PluginFilterForm;
import es.caib.digitalib.back.form.webdb.PluginForm;
import es.caib.digitalib.commons.utils.Constants;


/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = FirmaEnServidorPluginAdminController.CONTEXTWEB)
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class FirmaEnServidorPluginAdminController extends AbstractPluginAdminController {
  
  public static final String CONTEXTWEB = "/admin/pluginfirmaenservidor";

  @Override
  public String getTileForm() {
    return "pluginFirmaEnServidorFormAdmin";
  }

  @Override
  public String getTileList() {
    return "pluginFirmaEnServidorListAdmin";
  }

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR;
  }

  @Override
  public String getCodeName() {
    return "firmaenservidorplugin";
  }

  @Override
  public String getContextWebPlugin() {
    return CONTEXTWEB;
  }
  
}
