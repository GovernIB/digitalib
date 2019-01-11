package es.caib.digitalib.back.controller.user;

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
@RequestMapping(value = InfoSignatureUserController.CONTEXT_WEB_USER_INFO_SIGNATURE)
@SessionAttributes(types = { InfoSignaturaForm.class, InfoSignaturaFilterForm.class })
public class InfoSignatureUserController extends AbstractInfoSignatureController {

  public static final String CONTEXT_WEB_USER_INFO_SIGNATURE = "/user/infoSignatura";

  @Override
  public boolean isAdmin() {
    return false;
  }

}
