package es.caib.digitalib.back.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
@Controller
@RequestMapping(value = TransaccioPersonaAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioPersonaAdminController extends AbstractTransaccioAdminController {

  public static final String CONTEXTWEB = "/admin/transacciopersona";

  @Override
  public boolean isUtilitzatPerAplicacio() {
    return false;
  }

}
