package es.caib.digitalib.back.controller.admin.general;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractPluginAdminController;
import es.caib.digitalib.back.form.webdb.PluginFilterForm;
import es.caib.digitalib.back.form.webdb.PluginForm;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = ScanWebPluginAdminController.CONTEXTWEB)
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class ScanWebPluginAdminController extends AbstractPluginAdminController {

    public static final String CONTEXTWEB = "/admin/pluginscanweb";

    @Override
    public String getTileForm() {
        return "pluginScanWebFormAdmin";
    }

    @Override
    public String getTileList() {
        return "pluginScanWebListAdmin";
    }

    @Override
    public int getTipusDePlugin() {
        return Constants.TIPUS_PLUGIN_SCANWEB;
    }

    @Override
    public String getCodeName() {
        return "scanwebplugin";
    }

    @Override
    public String getContextWebPlugin() {
        return CONTEXTWEB;

    }

    @Override
    public PluginFilterForm getPluginFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {

        PluginFilterForm pluginFilterForm = super.getPluginFilterForm(pagina, mav, request);

        if (pluginFilterForm.isNou()) {
            // Afegir botó de reiniciar (netejar cache) per a cada element de la llista
            pluginFilterForm
                    .addAdditionalButtonForEachItem(new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_RELOAD),
                            "scanwebplugin.reiniciarplugin", CONTEXTWEB + "/reiniciarplugin/{0}", AdditionalButtonStyle.WARNING));
        }

        return pluginFilterForm;
    }

    /**
     * Endpoint per reiniciar (netejar la cache) d'un plugin concret.
     *
     * @param request  petició HTTP
     * @param response resposta HTTP
     * @param pluginid identificador del plugin a reiniciar
     * @return redirecció al llistat de plugins
     * @throws I18NException si hi ha un error d'internacionalització
     */
    @RequestMapping(value = "/reiniciarplugin/{pluginid}", method = RequestMethod.GET)
    public String reiniciarPlugin(HttpServletRequest request, HttpServletResponse response, @PathVariable
    Long pluginid) throws I18NException {

        // Netejar la cache del plugin per forçar la seva reinicialització
        boolean existeix = pluginLogicaEjb.clearCache(pluginid);
        
        String msg;
        if (existeix == true) {
            msg = I18NUtils.tradueix("scanwebplugin.reiniciatplugin", String.valueOf(pluginid));
        } else {
            msg = I18NUtils.tradueix("scanwebplugin.pluginnoestavaencache", String.valueOf(pluginid));
        }

        
        HtmlUtils.saveMessageSuccess(request, msg);

        return "redirect:" + CONTEXTWEB + "/list/";
    }

}