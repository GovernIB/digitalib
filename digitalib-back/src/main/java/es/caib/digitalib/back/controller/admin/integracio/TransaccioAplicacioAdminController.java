package es.caib.digitalib.back.controller.admin.integracio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.admin.AbstractTransaccioAdminController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
@Controller
@RequestMapping(value = TransaccioAplicacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioAplicacioAdminController extends AbstractTransaccioAdminController {

    public static final String CONTEXTWEB = "/admin/transaccioaplicacio";

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return true;
    }

    @Override
    public String getPipella() {
        return "Integracions";
    }

}
