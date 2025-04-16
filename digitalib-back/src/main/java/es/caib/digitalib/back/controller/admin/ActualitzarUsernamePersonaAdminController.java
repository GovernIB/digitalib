package es.caib.digitalib.back.controller.admin;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.UpdateItemValue;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.FitxerController;
import es.caib.digitalib.back.form.webdb.FitxerFilterForm;
import es.caib.digitalib.back.form.webdb.FitxerForm;
import es.caib.digitalib.logic.UsuariPersonaLogicaService;
import es.caib.digitalib.model.fields.FitxerFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.persistence.FitxerJPA;

/**
 * 
 * @author anadal
 * 1 abr 2025 13:33:50
 */

@Controller
@RequestMapping(value = "/admin/actualitzarusername")
@SessionAttributes(types = { FitxerForm.class, FitxerFilterForm.class })
/*
@MenuOption(
        labelCode = "updateusername.title",
        baseLink = "/admin/actualitzarusername/new",
        relativeLink = "",
        order = 45,
        group = Tab.MENU_ADMIN)
@Tile(name = "actualitzarUsernameAdmin", extendsTile = Tab.MENU_ADMIN, type = TileType.WEBDB_FORM)
*/
public class ActualitzarUsernamePersonaAdminController extends FitxerController {

    @EJB(mappedName = UsuariPersonaLogicaService.JNDI_NAME)
    protected UsuariPersonaLogicaService usuariPersonaLogicaEjb;

    public String getEntityNameCode() {
        return "fitxer.fitxer";
    }

    @Override
    public String getTileForm() {
        return "actualitzarUsernameAdmin";
    }

    @Override
    public FitxerJPA create(HttpServletRequest request, FitxerJPA fitxer)
            throws I18NException, I18NValidationException {

        Properties prop = new Properties();
        try {
            prop.load(new StringReader(fitxer.getDescripcio()));
        } catch (IOException e) {
            HtmlUtils.saveMessageError(request, "Error processant el mapeig d'usuaris: " + e.getMessage());
            return fitxer;
        }

        Map<String, String> resultat = updateUsernameOfPerson(prop, LocaleContextHolder.getLocale().getLanguage());

        StringBuffer oks = new StringBuffer();
        StringBuffer fluxos = new StringBuffer();

        for (String key : resultat.keySet()) {

            String r = resultat.get(key);
            if ("OK".equals(r)) {
                oks.append(key).append(" a ").append(prop.get(key)).append(", ");
            } else if ("FLUX".equals(r)) {
                fluxos.append(key).append(" a ").append(prop.get(key)).append(", ");
            } else {
                HtmlUtils.saveMessageError(request, I18NUtils.tradueix("updateusername.error", key, r));
            }
        }

        if (oks.length() != 0) {
            HtmlUtils.saveMessageSuccess(request, I18NUtils.tradueix("updateusername.ok", oks.toString()));
        }

        if (fluxos.length() != 0) {
            HtmlUtils.saveMessageWarning(request, I18NUtils.tradueix("updateusername.flux", fluxos.toString()));
        }

        return (FitxerJPA) fitxer;

    }

    public Map<String, String> updateUsernameOfPerson(Properties prop, String langUI) throws I18NException {

        Map<String, String> resultat = new HashMap<String, String>();

        for (Object usrActual : prop.keySet()) {
            Object usrNou = prop.get(usrActual);

            final String currentUsername = (String) usrActual;
            final String newUsername = (String) usrNou;

            try {

                // (2) Actualitzam tots els usuarientitat que contenguin la persona actual
                int canvis = usuariPersonaLogicaEjb.update(UsuariPersonaFields.USERNAME.equal(currentUsername),
                        new UpdateItemValue<String>(UsuariPersonaFields.USERNAME, newUsername));

                if (canvis == 0) {
                    resultat.put(currentUsername, "No s'ha trobat aquest usuari.");
                } else {
                    resultat.put(currentUsername, "OK");
                }

            } catch (I18NException i18n) {
                resultat.put(currentUsername, "Error actualitzant usuari de '" + currentUsername + "' a '" + newUsername
                        + "': " + I18NUtils.getMessage(i18n));
            }
        }

        return resultat;
    }

    @Override
    public String createMessageSuccess(HttpServletRequest request, String msg, Object id) {
        return "";
    }

    @Override
    public FitxerForm getFitxerForm(FitxerJPA _jpa, boolean __isView, HttpServletRequest request, ModelAndView mav)
            throws I18NException {
        FitxerForm fitxerForm = super.getFitxerForm(_jpa, __isView, request, mav);

        FitxerJPA fitxer = fitxerForm.getFitxer();
        fitxer.setNom("Prova.txt");
        fitxer.setTamany(12);
        fitxer.setMime("text/x-java-properties");
        fitxer.setDescripcio("#Exemple\n" + "usuari_actual=usuari_nou");

        Set<Field<?>> hidden = new HashSet<Field<?>>(Arrays.asList(FitxerFields.ALL_FITXER_FIELDS));
        hidden.remove(DESCRIPCIO);
        fitxerForm.setHiddenFields(hidden);

        fitxerForm.setTitleCode("updateusername.title");

        fitxerForm.addLabel(DESCRIPCIO, "updateusername.descripcio");

        fitxerForm.setSubTitleCode("updateusername.subtitle");

        return fitxerForm;
    }

    @Override
    public String getRedirectWhenCreated(HttpServletRequest request, FitxerForm fitxerForm) {
        return "redirect:" + getContextWeb() + "/new";
    }

}
