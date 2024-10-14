package es.caib.digitalib.back.controller.admin;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;

/**
 * 
 * @author anadal
 * 14 oct 2024 8:44:50
 */
@Controller
public class NetejarTransaccionsCaducades implements TransaccioFields {

    protected Logger log = Logger.getLogger(this.getClass());

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @RequestMapping(value = "/admin/netejartransaccionscaducades", method = RequestMethod.GET)
    public ModelAndView netejarTransaccionsCaducades(HttpServletRequest request) {
        try {

            List<Transaccio> transaccions = transaccioLogicaEjb.expiraTransaccionsCaducades();

            HtmlUtils.saveMessageSuccess(request,
                    "Marcades com expirades " + transaccions.size() + " transaccions caducades.");

        } catch (I18NException i18ne) {
            String msg = I18NUtils.getMessage(i18ne);
            log.error(msg, i18ne);
            HtmlUtils.saveMessageError(request, msg);

        } catch (Exception e) {
            String msg = "Error no controlat revisant Transaccions Expirades: " + e.getMessage();
            log.error(msg, e);
            HtmlUtils.saveMessageError(request, msg);
        }

        return new ModelAndView("netejartransaccionscaducades");

    }

}
