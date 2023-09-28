package es.caib.digitalib.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.form.webdb.PerfilFilterForm;
import es.caib.digitalib.back.form.webdb.PerfilForm;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author u139636
 *
 */
@Controller
@RequestMapping(value = PerfilInfoTransaccioAdminController.CONTEXTWEB)
@SessionAttributes(types = { PerfilForm.class, PerfilFilterForm.class })
public class PerfilInfoTransaccioAdminController extends AbstractPerfilAdminController {

  public static final String CONTEXTWEB = "/admin/perfilinfotransaccio";
  
  

  @Override
  public int getTipusPerfil() {
    return Constants.PERFIL_US_ALL_INFO;
  }

  @Override
  public boolean isActiveList() {
    return false;
  }

  @Override
  public boolean isActiveFormNew() {
    return false;
  }

  @Override
  public boolean isActiveFormEdit() {
    return false;
  }

  @Override
  public boolean isActiveDelete() {
    return false;
  }

  @Override
  public boolean isActiveFormView() {
    return true;
  }

  @Override
  public PerfilForm getPerfilForm(PerfilJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    PerfilForm perfilForm = super.getPerfilForm(_jpa, __isView, request, mav);

    int firma = perfilForm.getPerfil().getTipusFirma();

    switch (firma) {
    case Constants.TIPUS_FIRMA_EN_SERVIDOR_SENSE:
      perfilForm.addHiddenField(APISIMPLEID);
      perfilForm.addHiddenField(CONFIGURACIOFIRMAID);
      break;
    case Constants.TIPUS_FIRMA_EN_SERVIDOR_PLUGIN:
      perfilForm.addHiddenField(APISIMPLEID);
      break;

    case Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE:
      perfilForm.addHiddenField(CONFIGURACIOFIRMAID);
      break;
    }

    int custodia = perfilForm.getPerfil().getTipusCustodia();

    switch (custodia) {
    case Constants.TIPUS_CUSTODIA_SENSE:
      perfilForm.addHiddenField(PLUGINDOCCUSTODYID);
      perfilForm.addHiddenField(PLUGINARXIUID);
      break;
    case Constants.TIPUS_CUSTODIA_ARXIU:

      perfilForm.addHiddenField(PLUGINDOCCUSTODYID);
      break;

    case Constants.TIPUS_CUSTODIA_DOCUMENTCUSTODY:
      perfilForm.addHiddenField(PLUGINARXIUID);
      break;
    }
    
    Utils.hideNullFields(perfilForm.getPerfil(), perfilForm, ALL_PERFIL_FIELDS);
    perfilForm.setCancelButtonVisible(false);

    return perfilForm;
  }

  @Override
  public boolean isUtilitzatPerAplicacio() {
    // tant dona el que valgui: NO crearem Nous elements
    return false;
  }
}
