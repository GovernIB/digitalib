package es.caib.digitalib.back.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.admin.PerfilInfoTransaccioAdminController;
import es.caib.digitalib.back.form.webdb.PerfilFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilForm;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = PerfilInfoTransaccioUserController.CONTEXTWEB)
@SessionAttributes(types = { PerfilForm.class, PerfilFilterForm.class })
public class PerfilInfoTransaccioUserController extends PerfilInfoTransaccioAdminController {

    public static final String CONTEXTWEB = "/user/perfilinfotransaccio";

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return false;
    }

    @Override
    public boolean isRoleAdmin() {
        return false;
    };

}
