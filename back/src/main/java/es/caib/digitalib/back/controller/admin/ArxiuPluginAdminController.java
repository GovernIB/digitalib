package es.caib.digitalib.back.controller.admin;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractPluginAdminController;
import es.caib.digitalib.back.form.webdb.PluginFilterForm;
import es.caib.digitalib.back.form.webdb.PluginForm;
import es.caib.digitalib.jpa.PluginJPA;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.fields.PluginFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = ArxiuPluginAdminController.CONTEXTWEB)
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class ArxiuPluginAdminController extends AbstractPluginAdminController {

  public static final String CONTEXTWEB = "/admin/pluginarxiu";

  public static final Field<?>[] CAMPS = { TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI,
      TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM,
      // TransaccioFields.ARXIUREQPARAMORGANS,
      TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL
  // TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID
  };

  @Override
  public PluginForm getPluginForm(PluginJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    PluginForm pluginForm = super.getPluginForm(_jpa, __isView, request, mav);
    if (pluginForm.isNou()) {

      StringBuffer properties = new StringBuffer("# Aquí propietats de l'Arxiu\n" + "\n"
          + "# Propietat Requerides per DigitalIB\n");

      for (Field<?> field : ALL_PLUGIN_FIELDS) {
        properties.append(field.javaName).append("=\n");
      }

      pluginForm.getPlugin().setProperties(properties.toString());
    }

    return pluginForm;
  }

  @Override
  public String getTileForm() {
    return "pluginArxiuFormAdmin";
  }

  @Override
  public String getTileList() {
    return "pluginArxiuListAdmin";
  }

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_ARXIU;
  }

  @Override
  public String getCodeName() {
    return "arxiuplugin";
  }

  @Override
  public void postValidate(HttpServletRequest request, PluginForm pluginForm,
      BindingResult result) throws I18NException {

    Properties prop = LogicUtils.stringToProperties(pluginForm.getPlugin().getProperties());

    for (Field<?> field : CAMPS) {
      String javaName = field.javaName;

      String value = prop.getProperty(javaName);

      if (value == null || value.trim().isEmpty()) {
        result.rejectValue(PluginFields.PROPERTIES.fullName, "error.propietatrequerida",
            new Object[] { field.javaName }, "No hi ha propietat " + field.fullName);
      }

    }

  }

  @Override
  public String getContextWebPlugin() {
    return CONTEXTWEB;
  }

}
