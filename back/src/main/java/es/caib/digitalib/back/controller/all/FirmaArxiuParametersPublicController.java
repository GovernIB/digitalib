package es.caib.digitalib.back.controller.all;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.controller.AbstractFirmaArxiuParametersController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.TransaccioPublicLogicaLocal;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = FirmaArxiuParametersPublicController.CONTEXTWEB_PUBLIC)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class FirmaArxiuParametersPublicController extends
    AbstractFirmaArxiuParametersController {

  @EJB(mappedName = TransaccioPublicLogicaLocal.JNDI_NAME)
  protected TransaccioPublicLogicaLocal transaccioPublicEjb;

  @Override
  public boolean isPublic() {
    return true;
  }

  @Override
  public boolean isUtilitzatPerAplicacio() {
    return true;
  }

  @Override
  public TransaccioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long transaccioID)
      throws I18NException {
    return (TransaccioJPA) transaccioPublicEjb.findByPrimaryKey(transaccioID);
  }

  @Override
  public TransaccioJPA update(HttpServletRequest request, TransaccioJPA transaccio)
      throws Exception, I18NException, I18NValidationException {
    return (TransaccioJPA) transaccioPublicEjb.update(transaccio);
  }

}
