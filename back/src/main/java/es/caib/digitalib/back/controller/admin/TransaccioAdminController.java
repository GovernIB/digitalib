package es.caib.digitalib.back.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.AbstractTransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
@Controller
@RequestMapping(value = TransaccioAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioAdminController extends AbstractTransaccioController {

  public static final String CONTEXTWEB = "/admin/transaccio";

  @Override
  public String getTileForm() {
    return "transaccioFormAdmin";
  }

  @Override
  public String getTileList() {
    return "transaccioListAdmin";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "TransaccioAdmin_FilterForm";
  }
  
  @Override
  public String getPerfilInfoContextWeb() {
    return PerfilInfoTransaccioAdminController.CONTEXTWEB;
  }

}
