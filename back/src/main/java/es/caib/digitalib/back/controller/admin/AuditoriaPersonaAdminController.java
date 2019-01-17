package es.caib.digitalib.back.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.form.webdb.AuditoriaFilterForm;
import es.caib.digitalib.back.form.webdb.AuditoriaForm;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = "/admin/auditoria/persona")
@SessionAttributes(types = { AuditoriaForm.class, AuditoriaFilterForm.class })
public class AuditoriaPersonaAdminController extends AbstractAuditoriaAdminController {

  @Override
  public boolean isAplicacio() {
    return false;
  }

  @Override
  public boolean isFilterByTransaccio() {
    return false;
  }

}
