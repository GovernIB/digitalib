package es.caib.digitalib.back.controller.admin;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.form.webdb.PerfilFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilForm;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author u139636
 *
 */
@Controller
@RequestMapping(value = "/admin/perfilinfotransaccio")
@SessionAttributes(types = { PerfilForm.class, PerfilFilterForm.class })
public class PerfilInfoTransaccioAdminController extends AbstractPerfilAdminController {

	
	@Override
	public int getTipusPerfil() {
		return Constants.PERFIL_US_TRANSACCIO_INFO;
	}

	
}
