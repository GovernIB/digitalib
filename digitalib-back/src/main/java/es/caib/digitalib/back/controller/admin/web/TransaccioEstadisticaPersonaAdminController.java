package es.caib.digitalib.back.controller.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.admin.AbstractTransaccioEstadisticaAdminController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;

/**
 * 
 * @author anadal(u80067)
 */
@Controller
@RequestMapping(value = TransaccioEstadisticaPersonaAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioEstadisticaPersonaAdminController extends AbstractTransaccioEstadisticaAdminController {

    public static final String CONTEXTWEB = "/admin/transaccioestadisticapersona";

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return false;
    }

    @Override
    public String getPipella() {
        return "DigitalIB";
    }

}
