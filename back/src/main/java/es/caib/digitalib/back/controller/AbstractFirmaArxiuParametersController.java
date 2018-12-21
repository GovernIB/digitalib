package es.caib.digitalib.back.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.plugins.scanweb.api.ScanWebStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
public abstract class AbstractFirmaArxiuParametersController extends
    AbstractTransaccioController {

  public static final String CONTEXTWEB_PUBLIC = "/public/firmaarxiuparameters";

  public static final String CONTEXTWEB_USER = "/user/firmaarxiuparameters";

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
  protected ScanWebModuleLocal scanWebModuleEjb;

  @Override
  public String getPerfilInfoContextWeb() {
    return null;
  }
  
  @Override
  public boolean isAdmin() {
    // No serveix per res
    return false;
  }

  @Override
  public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    TransaccioForm transaccioForm = super.getTransaccioForm(_jpa, __isView, request, mav);

    Set<Field<?>> hiddenFields = new HashSet<Field<?>>(
        Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

    final int tipusPerfil = Math.abs(perfilEjb.executeQueryOne(PerfilFields.USPERFIL,
        PerfilFields.PERFILID.equal(transaccioForm.getTransaccio().getPerfilID())));

    // Tots
    hiddenFields.remove(TransaccioFields.NOM);

    // Copia Autentica
    if (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA
        || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {
      hiddenFields.remove(TransaccioFields.FUNCIONARIUSERNAME);
      hiddenFields.remove(TransaccioFields.SIGNPARAMFUNCIONARINIF);
      hiddenFields.remove(TransaccioFields.SIGNPARAMFUNCIONARINOM);

      transaccioForm.addReadOnlyField(TransaccioFields.FUNCIONARIUSERNAME);
      transaccioForm.addReadOnlyField(TransaccioFields.SIGNPARAMFUNCIONARINIF);
      transaccioForm.addReadOnlyField(TransaccioFields.SIGNPARAMFUNCIONARINOM);

      hiddenFields.remove(TransaccioFields.SIGNPARAMLANGUAGEDOC);
    }

    // Digitalitzacio
    if (tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

      /*
       * // XYZ ZZZ Per DEBUG
       * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI);
       * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM);
       * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMORGANS);
       * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL);
       * hiddenFields.remove(TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID);
       * 
       * // XYZ ZZZ Per Debug
       * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI);
       * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM);
       * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMORGANS);
       * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL);
       * transaccioForm.addReadOnlyField(TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID);
       */

      hiddenFields.remove(TransaccioFields.ARXIUREQPARAMCIUTADANIF);
      hiddenFields.remove(TransaccioFields.ARXIUREQPARAMCIUTADANOM);
      hiddenFields.remove(TransaccioFields.ARXIUREQPARAMDOCESTATELABORA);
      hiddenFields.remove(TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS);
      hiddenFields.remove(TransaccioFields.ARXIUREQPARAMINTERESSATS);
      hiddenFields.remove(TransaccioFields.ARXIUREQPARAMORIGEN);
    }

    transaccioForm.setTitleCode("dadesrequerides");

    transaccioForm.setHiddenFields(hiddenFields);

    // XYZ ZZZ Obtenir idioma per defecte
    transaccioForm.getTransaccio().setSignParamLanguageDoc("ca");

    transaccioForm.setDeleteButtonVisible(false);

    return transaccioForm;
  }

  @Override
  public void postValidate(HttpServletRequest request, TransaccioForm transaccioForm,
      BindingResult result) throws I18NException {

    ValidationUtils.rejectIfEmptyOrWhitespace(result, NOM.fullName,
        "genapp.validation.required", new Object[] { I18NUtils.tradueix(NOM.fullName) });

    final int tipusPerfil = Math.abs(perfilEjb.executeQueryOne(PerfilFields.USPERFIL,
        PerfilFields.PERFILID.equal(transaccioForm.getTransaccio().getPerfilID())));

    if (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA
        || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

      Field<?>[] signFields = { TransaccioFields.SIGNPARAMFUNCIONARINIF,
          TransaccioFields.SIGNPARAMFUNCIONARINOM, TransaccioFields.SIGNPARAMLANGUAGEDOC };

      for (Field<?> field : signFields) {
        ValidationUtils.rejectIfEmptyOrWhitespace(result, field.fullName,
            "genapp.validation.required", new Object[] { I18NUtils.tradueix(field.fullName) });
      }

    }

    if (tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

      Field<?>[] reqFields = { TransaccioFields.ARXIUREQPARAMDOCESTATELABORA,
          TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS, TransaccioFields.ARXIUREQPARAMORIGEN
      // TransaccioFields.ARXIUREQPARAMCIUTADANIF, No és obligatori
      // TransaccioFields.ARXIUREQPARAMCIUTADANOM, No és obligatori
      // TransaccioFields.ARXIUREQPARAMINTERESSATS, No és obligatori
      };

      for (Field<?> field : reqFields) {
        ValidationUtils.rejectIfEmptyOrWhitespace(result, field.fullName,
            "genapp.validation.required", new Object[] { I18NUtils.tradueix(field.fullName) });
      }
    }

  }

  @Override
  public String getRedirectWhenModified(HttpServletRequest request,
      TransaccioForm transaccioForm, Throwable __e) {
    if (__e == null) {

      request.getSession().removeAttribute(HtmlUtils.MISSATGES);
      return "redirect:"
          + request.getSession().getAttribute(
              AbstractScanWebProcessController.SESSION_URL_TO_SELECT_SCANWEB_MODULE);
    } else {
      return getTileForm();
    }
  }

  @Override
  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long transaccioID) {

    String transaccioWebId = null;
    try {
      transaccioWebId = transaccioEjb.executeQueryOne(TransaccioFields.TRANSACTIONWEBID,
          TransaccioFields.TRANSACCIOID.equal(transaccioID));
    } catch (I18NException e) {
      // TODO XYZ ZZZ Que faig si error ????
      e.printStackTrace();
    }

    if (transaccioWebId != null) {

      ScanWebConfig swc;
      swc = scanWebModuleEjb.getScanWebConfig(request, transaccioWebId);

      swc.getStatus().setStatus(ScanWebStatus.STATUS_CANCELLED);
    }

    String finalURL = AbstractScanWebProcessController
        .getFinalURL("", transaccioWebId, isPublic());

    log.warn("XYZ ZZZ URL despres de CANCEL.LAR: " + finalURL);

    return "redirect:" + finalURL;
  }

  @Override
  public String getTileForm() {
    return "FirmaArxiuParametersForm_" + (isPublic() ? "public" : "user");
  }

  public abstract boolean isPublic();

  @Override
  public String getSessionAttributeFilterForm() {
    return "FirmaArxiuParameters_FilterForm";
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
    return true;
  }

  @Override
  public boolean isActiveDelete() {
    return false;
  }

  @Override
  public boolean isActiveFormView() {
    return false;
  }

}
