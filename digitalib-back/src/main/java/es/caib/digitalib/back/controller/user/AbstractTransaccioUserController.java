package es.caib.digitalib.back.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractTransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.TransaccioQueryPath;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
public abstract class AbstractTransaccioUserController extends AbstractTransaccioController {



  @Override
  public String getTileForm() {
    return "transaccioFormUser";
  }

  @Override
  public String getTileList() {
    return "transaccioListUser";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "TransaccioUser_FilterForm_" + getTipusPerfil();
  }



  @Override
  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    // XYZ ZZZ Aixo s'ha de fer collint LoginINfo

    Long usuariPersonaID = usuariPersonaEjb.executeQueryOne(
        UsuariPersonaFields.USUARIPERSONAID,
        UsuariPersonaFields.USERNAME.equal(LoginInfo.getInstance().getUsername()));

    int tipusPerfil = getTipusPerfil();

    TransaccioQueryPath tqp = new TransaccioQueryPath();

    Where wPerfil;
    if (tipusPerfil == Constants.PERFIL_US_ALL_INFO) {
      wPerfil = null;
    } else {
      wPerfil = tqp.PERFIL().USPERFIL().equal(tipusPerfil);
    }

    wPerfil = Where.AND(TransaccioFields.USUARIPERSONAID.equal(usuariPersonaID), wPerfil);
    
    return wPerfil;
  }

  @Override
  public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {
    TransaccioFilterForm transaccioFilterForm = super.getTransaccioFilterForm(pagina, mav,
        request);

    if (transaccioFilterForm.isNou()) {
      int tipusPerfil = getTipusPerfil();
      transaccioFilterForm.setEntityNameCode("transaccio.tipus." + Math.abs(tipusPerfil));
      transaccioFilterForm.setEntityNameCodePlural("transaccio.tipus." + Math.abs(tipusPerfil)
          + ".plural");
      
      List<Field<?>> campsFiltre = transaccioFilterForm.getDefaultGroupByFields();

      campsFiltre.remove(TransaccioFields.USUARIPERSONAID);
      campsFiltre.remove(TransaccioFields.USUARIAPLICACIOID);
      
      transaccioFilterForm.setGroupByFields(campsFiltre);

    }

    

    return transaccioFilterForm;
  }

  @Override
  public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    TransaccioForm form = super.getTransaccioForm(_jpa, __isView, request, mav);

    int tipusPerfil = getTipusPerfil();
    form.setEntityNameCode("transaccio.tipus." + Math.abs(tipusPerfil));
    form.setEntityNameCodePlural("transaccio.tipus." + Math.abs(tipusPerfil) + ".plural");

    return form;

  }

  @Override
  public String getPerfilInfoContextWeb() {
    return PerfilInfoTransaccioUserController.CONTEXTWEB;
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
    return true;
  }

  @Override
  public boolean isActiveFormView() {
    return true;
  }

  @Override
  public boolean isUtilitzatPerAplicacio() {
    return false;
  }

  @Override
  public boolean isAdmin() {
    return false;
  }

}
