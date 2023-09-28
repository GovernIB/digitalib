package es.caib.digitalib.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractInfoSignatureController;
import es.caib.digitalib.back.form.webdb.InfoSignaturaFilterForm;
import es.caib.digitalib.back.form.webdb.InfoSignaturaForm;
import es.caib.digitalib.persistence.InfoSignaturaJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */

@Controller
@RequestMapping(value = InfoSignatureAdminController.CONTEXT_WEB_ADMIN_INFO_SIGNATURE)
@SessionAttributes(types = { InfoSignaturaForm.class, InfoSignaturaFilterForm.class })
public class InfoSignatureAdminController extends AbstractInfoSignatureController {

  public static final String CONTEXT_WEB_ADMIN_INFO_SIGNATURE = "/admin/infoSignatura";

  @Override
  public boolean isAdmin() {
    return true;
  }
  
  @Override
  public InfoSignaturaForm getInfoSignaturaForm(InfoSignaturaJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    InfoSignaturaForm infoSignaturaForm = super.getInfoSignaturaForm(_jpa, __isView, request,
        mav);

    infoSignaturaForm.setCancelButtonVisible(false);

    return infoSignaturaForm;

  }

}
