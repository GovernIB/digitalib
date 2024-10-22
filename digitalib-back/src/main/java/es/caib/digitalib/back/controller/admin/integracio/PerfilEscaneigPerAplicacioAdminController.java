package es.caib.digitalib.back.controller.admin.integracio;

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
@RequestMapping(value = PerfilEscaneigPerAplicacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { PerfilForm.class, PerfilFilterForm.class })
public class PerfilEscaneigPerAplicacioAdminController extends AbstractPerfilAdminController {

    public static final String CONTEXTWEB = "/admin/perfilnomesescaneig/peraplicacio";

    @Override
    public int getTipusPerfil() {
        return Constants.PERFIL_US_NOMES_ESCANEIG;
    }

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return true;
    }

}
