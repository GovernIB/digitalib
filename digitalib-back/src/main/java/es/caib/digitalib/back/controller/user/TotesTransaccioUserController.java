package es.caib.digitalib.back.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/user/transaccio/totes")
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TotesTransaccioUserController extends AbstractTransaccioUserController {

  @Override
  public int getTipusPerfil() {
    return Constants.PERFIL_US_ALL_INFO;
  }

}
