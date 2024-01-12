package es.caib.digitalib.back.controller.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractScanWebModuleController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController.FitxerEscanejatInfo;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.persistence.TransaccioJPA;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/user/transaccio/custodia")
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class CustodiaTransaccioUserController extends AbstractTransaccioUserController {


    @Override
    public int getTipusPerfil() {
        return Constants.PERFIL_US_CUSTODIA_INFO;
    }


}
