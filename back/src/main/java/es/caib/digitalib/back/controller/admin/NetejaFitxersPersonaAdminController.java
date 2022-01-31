package es.caib.digitalib.back.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;

/**
 * 
 * @author anadal (u80067)
 *
 */
@Controller
@RequestMapping(value = NetejaFitxersPersonaAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class NetejaFitxersPersonaAdminController
        extends NetejaFitxersAplicacioAdminController {

    public static final String CONTEXTWEB = "/admin/netejafitxerspersona";

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return false;
    }

}
