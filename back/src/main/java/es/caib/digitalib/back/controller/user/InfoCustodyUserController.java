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

import es.caib.digitalib.back.controller.AbstractInfoCustodyController;
import es.caib.digitalib.back.form.webdb.InfoCustodyFilterForm;
import es.caib.digitalib.back.form.webdb.InfoCustodyForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;

/**
 * 
 * @author anadal(u80067)
 *
 */

@Controller
@RequestMapping(value = InfoCustodyUserController.CONTEXT_WEB_USER_INFO_CUSTODY)
@SessionAttributes(types = { InfoCustodyForm.class, InfoCustodyFilterForm.class })
public class InfoCustodyUserController extends AbstractInfoCustodyController {

  public static final String CONTEXT_WEB_USER_INFO_CUSTODY = "/user/infoCustody";
  
  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  @Override
  public boolean isAdmin() {
    return false;
  }
  
  @Override
  public String cancelInfoCustody(@PathVariable("infoCustodyID") java.lang.Long infoCustodyID,
	      HttpServletRequest request,HttpServletResponse response) {
	     
	Long id = 0L;
	try {
		List<Transaccio> list = transaccioLogicaEjb.select(TransaccioFields.INFOCUSTODYID.equal(infoCustodyID));
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
  public InfoCustodyForm getInfoCustodyForm(InfoCustodyJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    InfoCustodyForm infoCForm = super.getInfoCustodyForm(_jpa, __isView, request,
        mav);

    Utils.hideNullFields(infoCForm.getInfoCustody(), infoCForm,
        ALL_INFOCUSTODY_FIELDS);
    
    infoCForm.addHiddenField(CSVGENERATIONDEFINITION);
    infoCForm.addHiddenField(ORIGINALFILEURL);
    infoCForm.addHiddenField(PRINTABLEFILEURL);
    infoCForm.addHiddenField(ENIFILEURL);
    
    infoCForm.setCancelButtonVisible(true);

    return infoCForm;

  }
}
