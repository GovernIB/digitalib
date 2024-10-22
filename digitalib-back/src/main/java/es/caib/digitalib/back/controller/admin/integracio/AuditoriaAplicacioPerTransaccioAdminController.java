package es.caib.digitalib.back.controller.admin.integracio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.admin.AbstractAuditoriaAdminController;
import es.caib.digitalib.back.form.webdb.AuditoriaFilterForm;
import es.caib.digitalib.back.form.webdb.AuditoriaForm;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = "/admin/auditoria/transaccio/aplicacio")
@SessionAttributes(types = { AuditoriaForm.class, AuditoriaFilterForm.class })
public class AuditoriaAplicacioPerTransaccioAdminController extends AbstractAuditoriaAdminController {

    @Override
    public boolean isAplicacio() {
        return true;
    }

    @Override
    public boolean isFilterByTransaccio() {
        return true;
    }

    @Override
    public String getPipella() {
        return "Integracions";
    }

}
