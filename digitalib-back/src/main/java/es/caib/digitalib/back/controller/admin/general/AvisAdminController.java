package es.caib.digitalib.back.controller.admin.general;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.AvisController;
import es.caib.digitalib.back.form.webdb.AvisFilterForm;
import es.caib.digitalib.back.form.webdb.AvisForm;

/**
 * 
 * @author anadal (u80067)
 *
 */
@Controller
@RequestMapping(value = "/admin/avis")
@SessionAttributes(types = { AvisForm.class, AvisFilterForm.class })
public class AvisAdminController extends AvisController {

  
  @Override
  public String getTileForm() {
    return "avisFormAdmin";
  }

  @Override
  public String getTileList() {
    return "avisListAdmin";
  }


  @Override
  public String getSessionAttributeFilterForm() {
    return "AvisAdmin_FilterForm";
  }

  @Override
  public List<StringKeyValue> getReferenceListForTipus(HttpServletRequest request,
      ModelAndView mav, Where where)  throws I18NException {
   List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
   
   for (int j = 0; j < 3; j++) {
     __tmp.add(new StringKeyValue("" +j ,I18NUtils.tradueix("avis.tipus." + j )));
   }
   return __tmp;
 }

  
  
}
