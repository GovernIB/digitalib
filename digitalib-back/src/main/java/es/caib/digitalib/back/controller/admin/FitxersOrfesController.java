package es.caib.digitalib.back.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.FitxerController;
import es.caib.digitalib.back.form.webdb.FitxerFilterForm;
import es.caib.digitalib.back.form.webdb.FitxerForm;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.TransaccioFields;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/admin/fitxersorfes")
@SessionAttributes(types = { FitxerForm.class, FitxerFilterForm.class })
public class FitxersOrfesController extends FitxerController {

    public static final String SESSION_ESBORRAR_FISICS_NO_BBDD = "SESSION_ESBORRAR_FISICS_NO_BBDD";

    @EJB(mappedName = es.caib.digitalib.ejb.TransaccioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.TransaccioService transaccioEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioGrupService.JNDI_NAME)
    protected es.caib.digitalib.ejb.ConfiguracioGrupService configuracioGrupEjb;

    @Override
    public String getTileList() {
        return "fitxersOrfesList";
    }

    @Override
    public boolean isActiveFormNew() {
        return false;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveDelete() {
        return true;
    }

    @Override
    public boolean isActiveFormView() {
        return true;
    }

    @Override
    public FitxerFilterForm getFitxerFilterForm(Integer pagina, ModelAndView mav,
            HttpServletRequest request) throws I18NException {
        FitxerFilterForm fitxerFilterForm;
        fitxerFilterForm = (FitxerFilterForm) super.getFitxerFilterForm(pagina, mav, request);

        if (fitxerFilterForm.isNou()) {
            fitxerFilterForm.setTitleCode("fitxers.orfes");
            fitxerFilterForm.setAddButtonVisible(false);
        }

        return fitxerFilterForm;
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        Where parent = super.getAdditionalCondition(request);

        Where w1 = FITXERID
                .notIn(transaccioEjb.getSubQuery(TransaccioFields.FITXERESCANEJATID, null));
        Where w2 = FITXERID
                .notIn(transaccioEjb.getSubQuery(TransaccioFields.FITXERSIGNATURAID, null));
        Where w3 = FITXERID.notIn(
                configuracioGrupEjb.getSubQuery(ConfiguracioGrupFields.LOGOFOOTERID, null));
        Where w4 = FITXERID.notIn(
                configuracioGrupEjb.getSubQuery(ConfiguracioGrupFields.LOGOHEADERID, null));

        return Where.AND(parent, w1, w2, w3, w4);
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "FitxersOrfes_FilterForm";
    }

    @Override
    public void postList(HttpServletRequest request, ModelAndView mav,
            FitxerFilterForm filterForm, List<Fitxer> list) throws I18NException {

        Map<Long, File> fitxersFisics = FileSystemManager.getAllFiles();

        List<Long> fitxersBBDD = fitxerEjb.executeQuery(FITXERID, new OrderBy(FITXERID));

        // Fitxers que existeixen en BBDD però no fisicament
        for (Long fID : fitxersBBDD) {
            if (!fitxersFisics.containsKey(fID)) {
                HtmlUtils.saveMessageError(request,
                        I18NUtils.tradueix("fitxersorfes.noexistex", String.valueOf(fID)));
            }
        }

        // Fitxers que existeixen fisicament però no en BBDD
        for (Long fBDID : fitxersBBDD) {

            if (fitxersFisics.containsKey(fBDID)) {
                fitxersFisics.remove(fBDID);
            }
        }

        Boolean esborrarFisiscNoBbdd = (Boolean) request.getSession()
                .getAttribute(SESSION_ESBORRAR_FISICS_NO_BBDD);

        if (esborrarFisiscNoBbdd == null) {

            for (Map.Entry<Long, File> fFisic : fitxersFisics.entrySet()) {
                HtmlUtils.saveMessageError(request,
                        "Fitxer Fisic amb id ]" + fFisic.getKey() + "[ ("
                                + fFisic.getValue().getAbsolutePath()
                                + ") no existeix en la BBDD !!!");
            }

            if (fitxersFisics.size() != 0) {
                filterForm.addAdditionalButton(
                        new AdditionalButton(
                                IconUtils.getWhite(IconUtils.ICON_TRASH), //IconUtils.getWhite(IconUtils.ICON_TRASH),
                                "esborrarfisicsnobbdd",
                                getContextWeb() + "/esborrarfisicsnobbdd", AdditionalButtonStyle.DANGER));
            }
        } else {

            FileSystemManager.eliminarArxius(fitxersFisics.keySet());

            HtmlUtils.saveMessageSuccess(request,
                    "Esborrats tots els Fitxers Físics que no existien en la BBDD.");
            
            request.getSession().removeAttribute(SESSION_ESBORRAR_FISICS_NO_BBDD);
            
            filterForm.setAdditionalButtons(new ArrayList<AdditionalButton>()); 
        }
    }

    @RequestMapping(value = "/esborrarfisicsnobbdd", method = RequestMethod.GET)
    public String esborrarFisicsNoBbdd(HttpServletRequest request,
            HttpServletResponse response) throws I18NException {

        request.getSession().setAttribute(SESSION_ESBORRAR_FISICS_NO_BBDD, true);

        return "redirect:" + getContextWeb() + "/list";
    }

}
