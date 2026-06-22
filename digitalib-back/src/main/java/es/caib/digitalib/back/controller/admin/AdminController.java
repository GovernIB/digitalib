package es.caib.digitalib.back.controller.admin;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

import es.caib.digitalib.back.utils.Tab;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.logic.FitxerLogicaService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 
 * @author anadal
 *
 */

@MenuOption(
        labelCode = "=Contents of digitalib.properties file",
        order = 1000,
        group = Constants.DIB_ADMIN,
        baseLink = "/admin/properties",
        relativeLink = "",
        addSeparatorBefore = true)
@MenuOption(
        labelCode = "=Contents of digitalib.system.properties file",
        order = 1010,
        group = Constants.DIB_ADMIN,
        baseLink = "/admin/systemproperties",
        relativeLink = "")
@MenuOption(
        labelCode = "=Reload contents of property files",
        order = 1020,
        group = Constants.DIB_ADMIN,
        baseLink = "/admin/reloadproperties",
        relativeLink = "")
@MenuOption(
        labelCode = "=Edit digitalib.properties file",
        order = 1030,
        group = Constants.DIB_ADMIN,
        baseLink = "/admin/editproperties",
        relativeLink = "")
@MenuOption(
        labelCode = "=Size of database tables",
        order = 156,
        group = Tab.MENU_ADMIN,
        baseLink = "/admin/sizeofdatabasetables",
        relativeLink = "")
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
//
//    @RequestMapping(value = "/option1")
//    public ModelAndView option1(HttpSession session, HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//
//        ModelAndView mav = new ModelAndView("option1Admin");
//        mav.addObject("optionNumber", "OPCIÓ ADMIN -1-");
//        return mav;
//
//    }
//
//    @RequestMapping(value = "/option2")
//    public ModelAndView option2(HttpSession session, HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//
//        ModelAndView mav = new ModelAndView("option2Admin");
//        mav.addObject("optionNumber", "OPCIÓ ADMIN -2-");
//        return mav;
//    }

    //------ CODI FONT - METODES

    @RequestMapping(value = "/properties")
    public ModelAndView properties(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Properties prop = Configuracio.getDigitalIBProperties();

        List<KeyValueItem> keyValuelist = new ArrayList<KeyValueItem>();

        for (Object key : prop.keySet()) {
            keyValuelist.add(new KeyValueItem((String) key, prop.getProperty((String) key, ""),
                    "<i class=\"" + IconUtils.ICON_INFO + "\"></i>", ""));
        }

        Collections.sort(keyValuelist);

        ModelAndView mav = new ModelAndView("keyvalueAdmin");
        mav.addObject("title", "Item list of demogenapp.app.properties file");
        mav.addObject("subtitle", "");
        mav.addObject("keyValueList", keyValuelist);
        return mav;
    }

    @RequestMapping(value = "/systemproperties")
    public ModelAndView systemproperties(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Properties prop = Configuracio.getDigitalIBSystemProperties();

        List<KeyValueItem> keyValuelist = new ArrayList<KeyValueItem>();

        for (Object key : prop.keySet()) {
            keyValuelist.add(new KeyValueItem((String) key, "***************"));
        }

        Collections.sort(keyValuelist);

        ModelAndView mav = new ModelAndView("keyvalueAdmin");
        mav.addObject("title", "Item list of demogenapp.system.properties file");
        mav.addObject("subtitle", "");
        mav.addObject("keyValueList", keyValuelist);
        return mav;
    }

    @RequestMapping(value = "/reloadproperties")
    public String reloadproperties(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Configuracio.reloadProperties();

        return "redirect:/admin/properties";
    }

    /**
    * Show the form to edit the contents of the digitalib.properties file.
    * 
    * @param model Model to hold attributes for the view
    * @return The name of the view to render
    */
    @RequestMapping(value = "/editproperties", method = RequestMethod.GET)
    public ModelAndView showEditForm(Model model, HttpServletRequest request) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(Configuracio.getPathToDigitalIBProperties()), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            model.addAttribute("fileContent", content.toString());
            return new ModelAndView("editpropertiesAdmin");
        } catch (IOException e) {
            HtmlUtils.saveMessageError(request, "No se pudo leer el fichero: " + e.getMessage());
            return new ModelAndView(new RedirectView("/canviarPipella/admin", true));
        }

    }

    @RequestMapping(value = "/editproperties", method = RequestMethod.POST)
    public String saveFile(@RequestParam("fileContent")
    String fileContent, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(Configuracio.getPathToDigitalIBProperties()), StandardCharsets.UTF_8))) {
            writer.write(fileContent);

            HtmlUtils.saveMessageSuccess(request, "El fitxer s´ha guardat correctament.");
        } catch (IOException e) {
            HtmlUtils.saveMessageError(request, "No s´ha pogut guardar el fitxer: " + e.getMessage());

        }

        return "redirect:/admin/editproperties";
    }

    public class KeyValueItem implements Comparable<KeyValueItem> {
        private String key;
        private String value;
        private String pre;
        private String post;

        public KeyValueItem(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public KeyValueItem(String key, String value, String pre, String post) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.post = post;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getPre() {
            return pre;
        }

        public void setPre(String pre) {
            this.pre = pre;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        @Override
        public int compareTo(KeyValueItem o2) {
            return this.getKey().compareTo(o2.getKey());
        }
    }
    
    
    @EJB(mappedName = FitxerLogicaService.JNDI_NAME)
    protected FitxerLogicaService fitxerLogicaEjb;
    

    @RequestMapping(value = "/sizeofdatabasetables")
    public ModelAndView tablesize(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Map<String, Long> sizes = fitxerLogicaEjb.getTableSizes();

        List<KeyValueItem> keyValuelist = new ArrayList<KeyValueItem>();

        for (Map.Entry<String, Long> entry : sizes.entrySet()) {
            keyValuelist.add(new KeyValueItem((String) entry.getKey(), entry.getValue() + " bytes",
                    "<i class=\"fas fa-database\"></i>", humanReadableByteCount(entry.getValue())));
        }

        ModelAndView mav = new ModelAndView("keyvalueAdmin");
        mav.addObject("title", "Size of database tables");
        mav.addObject("subtitle", "");
        mav.addObject("keyValueList", keyValuelist);
        return mav;
    }

    public static String humanReadableByteCount(long bytes) {
        int unit = 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String prefix = "KMGTPE".charAt(exp - 1) + "B"; // KB, MB, GB, TB, PB, EB
        return String.format("%.2f %s", bytes / Math.pow(unit, exp), prefix);
    }

}
