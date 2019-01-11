package es.caib.digitalib.back.controller.user;

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
@RequestMapping(value = InfoCustodyUserController.CONTEXT_WEB_USER_INFO_CUSTODY)
@SessionAttributes(types = { InfoCustodyForm.class, InfoCustodyFilterForm.class })
public class InfoCustodyUserController extends AbstractInfoCustodyController {

  public static final String CONTEXT_WEB_USER_INFO_CUSTODY = "/user/infoCustody";

  @Override
  public boolean isAdmin() {
    return false;
  }

}
