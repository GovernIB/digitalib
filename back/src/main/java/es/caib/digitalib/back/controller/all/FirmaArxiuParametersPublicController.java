package es.caib.digitalib.back.controller.all;

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
@RequestMapping(value = FirmaArxiuParametersPublicController.CONTEXTWEB_PUBLIC)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class FirmaArxiuParametersPublicController extends
    AbstractFirmaArxiuParametersController {

  @Override
  public boolean isPublic() {
    return true;
  }

  @Override
  public boolean isUtilitzatPerAplicacio() {
    return true;
  }
  

  
}
