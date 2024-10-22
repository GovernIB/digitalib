package es.caib.digitalib.back.controller.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.admin.AbstractPerfilAdminController;
import es.caib.digitalib.back.form.webdb.PerfilFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilForm;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = PerfilCustodiaPerPersonaAdminController.CONTEXTWEB)
@SessionAttributes(types = { PerfilForm.class, PerfilFilterForm.class })
public class PerfilCustodiaPerPersonaAdminController extends AbstractPerfilAdminController {

	public static final String CONTEXTWEB = "/admin/perfilcustodia/perpersona";
  
	@Override
	public int getTipusPerfil() {
		return Constants.PERFIL_US_CUSTODIA;
	}

  @Override
  public boolean isUtilitzatPerAplicacio() {    
    return false;
  }
	
}
