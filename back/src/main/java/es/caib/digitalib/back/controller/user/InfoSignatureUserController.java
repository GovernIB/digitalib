package es.caib.digitalib.back.controller.user;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractInfoSignatureController;
import es.caib.digitalib.back.form.webdb.InfoSignaturaFilterForm;
import es.caib.digitalib.back.form.webdb.InfoSignaturaForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.InfoSignaturaJPA;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;

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

  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;
  
  @Override
  public boolean isAdmin() {
    return false;
  }
  
  @Override
  public String cancelInfoSignatura(@PathVariable("infoSignaturaID") java.lang.Long infoSignaturaID,
	      HttpServletRequest request,HttpServletResponse response) {
	     
	Long id = 0L;
	try {
		List<Transaccio> list = transaccioLogicaEjb.select(TransaccioFields.INFOSIGNATURAID.equal(infoSignaturaID));
		if (list == null || list.size() == 0) {
	      return null;
	    }

		id = list.get(0).getTransaccioID();
		
	} catch (I18NException e) {
		e.printStackTrace();
	}
	  return "redirect:/user/transaccio/custodia/view/"+ id;
  }
  
  @Override
  public InfoSignaturaForm getInfoSignaturaForm(InfoSignaturaJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    InfoSignaturaForm infoSignaturaForm = super.getInfoSignaturaForm(_jpa, __isView, request,
        mav);

    Utils.hideNullFields(infoSignaturaForm.getInfoSignatura(), infoSignaturaForm,
        ALL_INFOSIGNATURA_FIELDS);
    infoSignaturaForm.setCancelButtonVisible(true);

    return infoSignaturaForm;

  }

}
