package es.caib.digitalib.back.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractInfoSignatureController;
import es.caib.digitalib.back.form.webdb.InfoSignaturaFilterForm;
import es.caib.digitalib.back.form.webdb.InfoSignaturaForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.InfoSignaturaJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */

@Controller
@RequestMapping(value = InfoSignatureUserController.CONTEXT_WEB_USER_INFO_SIGNATURE)
@SessionAttributes(types = { InfoSignaturaForm.class, InfoSignaturaFilterForm.class })
public class InfoSignatureUserController extends AbstractInfoSignatureController {

  public static final String CONTEXT_WEB_USER_INFO_SIGNATURE = "/user/infoSignatura";

  @Override
  public boolean isAdmin() {
    return false;
  }
  
  @Override
  public InfoSignaturaForm getInfoSignaturaForm(InfoSignaturaJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    InfoSignaturaForm infoSignaturaForm = super.getInfoSignaturaForm(_jpa, __isView, request,
        mav);

    Utils.hideNullFields(infoSignaturaForm.getInfoSignatura(), infoSignaturaForm,
        ALL_INFOSIGNATURA_FIELDS);
    infoSignaturaForm.setCancelButtonVisible(false);

    return infoSignaturaForm;

  }

}
