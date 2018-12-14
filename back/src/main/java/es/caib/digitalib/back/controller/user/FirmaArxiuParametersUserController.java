package es.caib.digitalib.back.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.AbstractFirmaArxiuParametersController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = FirmaArxiuParametersUserController.CONTEXTWEB_USER)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class FirmaArxiuParametersUserController extends AbstractFirmaArxiuParametersController {

  @Override
  public boolean isPublic() {
    return false;
  }

}
