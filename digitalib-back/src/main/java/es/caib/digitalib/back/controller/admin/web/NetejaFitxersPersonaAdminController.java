package es.caib.digitalib.back.controller.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.admin.integracio.NetejaFitxersAplicacioAdminController;
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
    
    @Override
    public String getSessionAttributeFilterForm() {
      return "TransaccioAdmin_FilterForm_NetejaFitxersPersona";
    }
    
    @Override
    public String getPipella() {
        return "DigitalIB";
    }


}