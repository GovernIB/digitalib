package es.caib.digitalib.back.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.AbstractInfoSignatureController;
import es.caib.digitalib.back.form.webdb.InfoSignaturaFilterForm;
import es.caib.digitalib.back.form.webdb.InfoSignaturaForm;

/**
 * 
 * @author anadal(u80067)
 *
 */

@Controller
@RequestMapping(value = InfoSignatureAdminController.CONTEXT_WEB_ADMIN_INFO_SIGNATURE)
@SessionAttributes(types = { InfoSignaturaForm.class, InfoSignaturaFilterForm.class })
public class InfoSignatureAdminController extends AbstractInfoSignatureController {

  public static final String CONTEXT_WEB_ADMIN_INFO_SIGNATURE = "/admin/infoSignatura";

  @Override
  public boolean isAdmin() {
    return true;
  }

}
