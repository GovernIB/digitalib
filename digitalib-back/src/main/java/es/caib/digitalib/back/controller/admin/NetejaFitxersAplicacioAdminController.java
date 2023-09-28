package es.caib.digitalib.back.controller.admin;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal (u80067)
 *
 */
@Controller
@RequestMapping(value = NetejaFitxersAplicacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class NetejaFitxersAplicacioAdminController extends AbstractTransaccioAdminController {

    public static final String CONTEXTWEB = "/admin/netejafitxersaplicacio";

    @Override
    public String getSessionAttributeFilterForm() {
      return "TransaccioAdmin_FilterForm_NetejaFitxersAplicacio";
    }

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return true;
    }

    protected int getDiesPerNetejaDeFitxersDefaultWeb() {
        return isUtilitzatPerAplicacio() ? 180 : 365;
    }

    protected String getDiesPerNetejaDeFitxersSession() {
        return "DiesPerNetejaDeFitxersSession"
                + (isUtilitzatPerAplicacio() ? "Aplicacio" : "Persona");
    }

    protected Integer getDiesPerNetejaDeFitxers() {
        return isUtilitzatPerAplicacio() ? Configuracio.getDiesPerNetejaDeFitxersAplicacio()
                : Configuracio.getDiesPerNetejaDeFitxersPersona();
    }

    @Override
    public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav,
            HttpServletRequest request) throws I18NException {

        log.info(" Passa per  filter form");

        TransaccioFilterForm filterForm = super.getTransaccioFilterForm(pagina, mav, request);

        if (filterForm.isNou()) {

            filterForm.setTitleCode("netejafitxerstransaccions.plural");

            filterForm.setOrderBy(DATAINICI.javaName);
            filterForm.setOrderAsc(true);

            String subtitol;

            final String propietat = Constants.DIGITALIB_PROPERTY_BASE
                    + (isUtilitzatPerAplicacio()
                            ? Configuracio.PROPERTY_DIESPERNETEJADEFITXERSAPLICACIO
                            : Configuracio.PROPERTY_DIESPERNETEJADEFITXERSPERSONA);

            Integer days = getDiesPerNetejaDeFitxers();
            if (days == null) {
                subtitol = "No s'ha definit la propietat " + propietat
                        + ", per la qual el procés nocturn no esborrarà fitxers de transaccions antigues";
            } else {
                subtitol = "Es netegen els fitxers de les Transaccions amb més de " + days
                        + " de vida.(Veure propietat " + propietat + ")";
            }
            filterForm.setSubTitleCode("=" + subtitol);
                    
            // Netejar fitxers 
            filterForm.addAdditionalButton(new AdditionalButton("fas fa-file-excel",
                    "netejarfitxers.button", "javascript:netejarSeleccionats()", "btn-danger"));

            // Canviar dies
            filterForm.addAdditionalButton(new AdditionalButton("fas fa-history",
                    "canviardies.button", "javascript:canviarDies()", "btn-primary"));

            filterForm.setAttachedAdditionalJspCode(true);

            // Posam un valor per defecte a l'esborrat de fitxers
            request.getSession().setAttribute(getDiesPerNetejaDeFitxersSession(),
                    getDiesPerNetejaDeFitxersDefaultWeb());
        }

        filterForm.setVisibleMultipleSelection(true);
        filterForm.setDeleteSelectedButtonVisible(false);

        Integer dies = (Integer) request.getSession()
                .getAttribute(getDiesPerNetejaDeFitxersSession());
        filterForm.setTitleParam(String.valueOf(dies));

        mav.addObject("canviarDies", dies);

        return filterForm;

    }

    @Override
    public void postList(HttpServletRequest request, ModelAndView mav,
            TransaccioFilterForm filterForm, List<Transaccio> list) throws I18NException {
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {

        log.info(" Passa per additional condition");

        Where w = super.getAdditionalCondition(request);

        Where w2 = Where.OR(TransaccioFields.FITXERESCANEJATID.isNotNull(),
                TransaccioFields.FITXERSIGNATURAID.isNotNull());

        Integer days = (Integer) request.getSession()
                .getAttribute(getDiesPerNetejaDeFitxersSession());
        Timestamp ts;
        if (days == null) {
            ts = new Timestamp(0);
        } else {
            Calendar date = Calendar.getInstance();
            date.add(Calendar.DATE, -1 * days);
            ts = new Timestamp(date.getTimeInMillis());
        }
        w2 = Where.AND(w2, TransaccioFields.DATAINICI.lessThan(ts));

        return Where.AND(w, w2);
    }

    @RequestMapping(value = "/netejarseleccionats", method = RequestMethod.POST)
    public String netejarSeleccionats(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute TransaccioFilterForm filterForm) throws Exception {

        String[] seleccionats = filterForm.getSelectedItems();

        if (seleccionats != null && seleccionats.length != 0) {
            for (int i = 0; i < seleccionats.length; i++) {
                try {
                    transaccioLogicaEjb.netejaFitxers(Long.parseLong(seleccionats[i]));
                    HtmlUtils.saveMessageInfo(request,
                            "Netejats fitxers de la Transaccio amb ID " + seleccionats[i]);
                } catch (I18NException i18n) {
                    HtmlUtils.saveMessageError(request,
                            "Error netejant fitxers de tansaccion amb ID " + seleccionats[i]
                                    + ": " + I18NUtils.getMessage(i18n));
                }

            }
        } else {
            HtmlUtils.saveMessageWarning(request, "No s'ha seleccionat cap fitxer.");
        }
        return getRedirectWhenDelete(request, null, null);
    }

    @RequestMapping(value = "/canviardies", method = RequestMethod.POST)
    public String canviarDies(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute TransaccioFilterForm filterForm) throws Exception {

        log.info("\nNOUS DIES = ]" + request.getParameter("nousdies") + "[\n");

        request.getSession().setAttribute(getDiesPerNetejaDeFitxersSession(),
                Integer.parseInt(request.getParameter("nousdies")));

        return getRedirectWhenDelete(request, null, null);
    }

}
