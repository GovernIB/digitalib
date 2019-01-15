package es.caib.digitalib.back.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.AbstractInfoCustodyController;
import es.caib.digitalib.back.form.webdb.InfoCustodyFilterForm;
import es.caib.digitalib.back.form.webdb.InfoCustodyForm;

/**
 * 
 * @author anadal(u80067)
 *
 */

@Controller
@RequestMapping(value = InfoCustodyAdminController.CONTEXT_WEB_ADMIN_INFO_CUSTODY)
@SessionAttributes(types = { InfoCustodyForm.class, InfoCustodyFilterForm.class })
public class InfoCustodyAdminController extends AbstractInfoCustodyController {

  public static final String CONTEXT_WEB_ADMIN_INFO_CUSTODY = "/admin/infoCustody";

  @Override
  public boolean isAdmin() {
    return true;
  }

}
