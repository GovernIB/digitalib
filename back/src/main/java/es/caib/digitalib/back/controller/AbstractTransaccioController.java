package es.caib.digitalib.back.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.webdb.TransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.back.utils.Utils;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.EmailUtil;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.model.entity.InfoCustody;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
public abstract class AbstractTransaccioController extends TransaccioController {

  public static final int USUARICOLUMN = 1;

  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  public abstract String getPerfilInfoContextWeb();

  public abstract boolean isUtilitzatPerAplicacio();

  public abstract boolean isAdmin();

  @Override
  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    // TransaccioQueryPath tqp = new TransaccioQueryPath();
    // Where w =
    // Where.OR(tqp.PERFIL().UTILITZATPERAPLICACIO().equal(isUtilitzatPerAplicacio()));
    Where w;
    if (isUtilitzatPerAplicacio()) {
      w = USUARIAPLICACIOID.isNotNull();
    } else {
      w = USUARIPERSONAID.isNotNull();
    }

    return w;
  }

  @Override
  public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {
    TransaccioForm form = super.getTransaccioForm(_jpa, __isView, request, mav);

    if (isUtilitzatPerAplicacio()) {
      form.setEntityNameCode("transaccio.aplicacio");
      form.setEntityNameCodePlural("transaccio.aplicacio.plural");
      form.addHiddenField(USUARIPERSONAID);
    } else {
      form.setEntityNameCode("transaccio.persona");
      form.setEntityNameCodePlural("transaccio.persona.plural");
      form.addHiddenField(USUARIAPLICACIOID);
    }
    
    if (__isView) {
      // Ocultar tots els camps null
      Utils.hideNullFields(_jpa, form, ALL_TRANSACCIO_FIELDS);
      
      if (_jpa.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_OK) {
        form.addHiddenField(ESTATCODI);
      }
      
      
      form.addHiddenField(INFOCUSTODYID);
      form.addHiddenField(INFOSIGNATURAID);
      form.addHiddenField(PERFILID);
      
      form.addHiddenField(IP);
      form.addHiddenField(USUARIPERSONAID);
      form.addHiddenField(RETURNURL);

      // Afegir botos de info sign
      if (_jpa.getInfoSignaturaID() != null) {
        form.addAdditionalButton(new AdditionalButton(
            " icon-info-sign icon-white", INFOSIGNATURAID.fullName,
            AbstractInfoSignatureController.getContextWeb(isAdmin())  + "/view" + "/" + _jpa.getInfoSignaturaID() , "btn-info"));
      }
      
      
      // Afegir botos de info cust
      if (_jpa.getInfoCustodyID() != null) {
        form.addAdditionalButton(new AdditionalButton(
            " icon-info-sign icon-white", INFOCUSTODYID.fullName,
            AbstractInfoCustodyController.getContextWeb(isAdmin())  + "/view" + "/" + _jpa.getInfoCustodyID() , "btn-info"));
      }
      
      // Afegir Boto de Veure Perfil
      form.addAdditionalButton(new AdditionalButton("icon-user icon-white",
          "transaccio.veureperfil", getContextWeb() + "/viewperfil/" + _jpa.getTransaccioID(), "btn-info"));

    }
    

    return form;

  }




  @Override
  public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {

    TransaccioFilterForm filterForm = super.getTransaccioFilterForm(pagina, mav, request);

    if (filterForm.isNou()) {

      Set<Field<?>> ocults = new HashSet<Field<?>>(
          Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

      ocults.remove(TransaccioFields.TRANSACCIOID);
      ocults.remove(TransaccioFields.NOM);
      ocults.remove(TransaccioFields.DATAINICI);
      ocults.remove(TransaccioFields.DATAFI);
      ocults.remove(TransaccioFields.ESTATCODI);
      ocults.remove(TransaccioFields.USUARIPERSONAID);
      ocults.remove(TransaccioFields.USUARIAPLICACIOID);

      filterForm.setHiddenFields(ocults);

      filterForm.setOrderBy(TransaccioFields.DATAFI.fullName);
      filterForm.setOrderAsc(false);

      filterForm.addAdditionalButtonForEachItem(new AdditionalButton(
          "icon-eye-open icon-white", "transaccio.veuredetall", getContextWeb() + "/view/{0}",
          "btn-primary"));

      if (getPerfilInfoContextWeb() != null) {
        filterForm.addAdditionalButtonForEachItem(new AdditionalButton("icon-user icon-white",
            "transaccio.veureperfil", getContextWeb() + "/viewperfil/{0}", "btn-info"));
      }

      List<Field<?>> campsFiltre = filterForm.getDefaultGroupByFields();
      if (isAdmin()) {
        AdditionalField<Long, String> adfield4 = new AdditionalField<Long, String>();
        adfield4.setPosition(USUARICOLUMN);
        // Els valors s'ompliran al mètode postList()
        adfield4.setValueMap(new HashMap<Long, String>());
        adfield4.setEscapeXml(false);

        if (isUtilitzatPerAplicacio()) {
          filterForm.setEntityNameCode("transaccio.aplicacio");
          filterForm.setEntityNameCodePlural("transaccio.aplicacio.plural");
          filterForm.addHiddenField(USUARIPERSONAID);
          filterForm.addHiddenField(USUARIAPLICACIOID);

          adfield4.setCodeName("usuariAplicacio.usuariAplicacio");
          campsFiltre.remove(TransaccioFields.USUARIPERSONAID);
        } else {
          filterForm.setEntityNameCode("transaccio.persona");
          filterForm.setEntityNameCodePlural("transaccio.persona.plural");
          filterForm.addHiddenField(USUARIAPLICACIOID);
          filterForm.addHiddenField(USUARIPERSONAID);

          adfield4.setCodeName("usuariPersona.usuariPersona");
          campsFiltre.remove(TransaccioFields.USUARIAPLICACIOID);
        }

        filterForm.addAdditionalField(adfield4);
      } else {
        campsFiltre.remove(TransaccioFields.USUARIPERSONAID);
        campsFiltre.remove(TransaccioFields.USUARIAPLICACIOID);

        filterForm.addHiddenField(USUARIAPLICACIOID);
        filterForm.addHiddenField(USUARIPERSONAID);

        filterForm.setAttachedAdditionalJspCode(true);

      }

      filterForm.setGroupByFields(campsFiltre);
    }
    filterForm.setVisibleMultipleSelection(false);
    filterForm.setAddButtonVisible(false);
    filterForm.setDeleteButtonVisible(false);
    filterForm.setEditButtonVisible(false);

    return filterForm;
  }

  @RequestMapping(value = "/viewperfil/{transaccioID}", method = RequestMethod.GET)
  public ModelAndView veurePerfilGet(
      @PathVariable("transaccioID") java.lang.Long transaccioID, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
    Long perfilID = transaccioEjb.executeQueryOne(TransaccioFields.PERFILID,
        TransaccioFields.TRANSACCIOID.equal(transaccioID));

    return new ModelAndView(new RedirectView(getPerfilInfoContextWeb() + "/view/" + perfilID,
        true));
  }

  @Override
  public boolean isActiveList() {
    return true;
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
  public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
      ModelAndView mav, Where where) throws I18NException {

    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_EXPIRED), I18NUtils
        .tradueix("estatcodi._3")));
    __tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_CANCELLED),
        I18NUtils.tradueix("estatcodi._2")));
    __tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_FINAL_ERROR),
        I18NUtils.tradueix("estatcodi._1")));
    __tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_REQUESTED_ID),
        I18NUtils.tradueix("estatcodi.0")));
    __tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_IN_PROGRESS),
        I18NUtils.tradueix("estatcodi.1")));
    __tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_FINAL_OK),
        I18NUtils.tradueix("estatcodi.2")));
    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamDocEstatElabora(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("EE01", "EE01 - Original (Llei 11/2007 Art. 30)"));
    __tmp.add(new StringKeyValue("EE02",
        "EE02 - Còpia electrònica autèntica amb canvi de format (Llei 11/2007 Art. 30.1)"));
    __tmp.add(new StringKeyValue("EE03", "EE03 - Còpia electrònica autèntica de document en"
        + " paper amb canvi de format (Llei 11/2007 Art. 30.2 i 30.3)."));
    __tmp.add(new StringKeyValue("EE04", "EE04 - Còpia electrònica parcial autèntica."));
    __tmp.add(new StringKeyValue("EE99", "EE99 - Altres estats d'elaboració."));

    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamDocumentTipus(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("TD01", "TD01 - RESOLUCIO"));
    __tmp.add(new StringKeyValue("TD02", "TD02 - ACORD"));
    __tmp.add(new StringKeyValue("TD03", "TD03 - CONTRACTE"));
    __tmp.add(new StringKeyValue("TD04", "TD04 - CONVENI"));
    __tmp.add(new StringKeyValue("TD05", "TD05 - DECLARACIO"));
    __tmp.add(new StringKeyValue("TD06", "TD06 - COMUNICACIO"));
    __tmp.add(new StringKeyValue("TD07", "TD07 - NOTIFICACIO"));
    __tmp.add(new StringKeyValue("TD08", "TD08 - PUBLICACIO"));
    __tmp.add(new StringKeyValue("TD09", "TD09 - JUSTIFICANT RECEPCIO"));
    __tmp.add(new StringKeyValue("TD10", "TD10 - ACTA"));
    __tmp.add(new StringKeyValue("TD11", "TD11 - CERTIFICAT"));
    __tmp.add(new StringKeyValue("TD12", "TD12 - DILIGENCIA"));
    __tmp.add(new StringKeyValue("TD13", "TD13 - INFORME"));
    __tmp.add(new StringKeyValue("TD14", "TD14 - SOLICITUD"));
    __tmp.add(new StringKeyValue("TD15", "TD15 - DENUNCIA"));
    __tmp.add(new StringKeyValue("TD16", "TD16 - ALEGACIO"));
    __tmp.add(new StringKeyValue("TD17", "TD17 - RECURS"));
    __tmp.add(new StringKeyValue("TD18", "TD18 - COMUNICACIO_CIUTADA"));
    __tmp.add(new StringKeyValue("TD19", "TD19 - FACTURA"));
    __tmp.add(new StringKeyValue("TD20", "TD20 - ALTRES_INCAUTATS"));
    __tmp.add(new StringKeyValue("TD99", "TD99 - ALTRES"));

    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamOrigen(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("0", "Ciutadà"));
    __tmp.add(new StringKeyValue("1", "Administració"));
    return __tmp;
  }

  public List<StringKeyValue> getReferenceListForSignParamLanguageDoc(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    // XYZ ZZZ Falta Traduir
    __tmp.add(new StringKeyValue("ca", "Català"));
    __tmp.add(new StringKeyValue("es", "Castellà"));
    __tmp.add(new StringKeyValue("en", "Anglès"));
    __tmp.add(new StringKeyValue("de", "Alemany"));
    return __tmp;
  }

  @RequestMapping(value = "/enviaremail")
  public String enviaremail(@RequestParam("transaccioID") java.lang.Long transaccioID,
      @RequestParam("email") String email, HttpServletRequest request,
      HttpServletResponse response) {

    try {

      TransaccioJPA transaccio = transaccioLogicaEjb.findByPrimaryKeyFull(transaccioID);
      if (transaccio == null) {
        String __msg = createMessageError(request, "error.notfound", transaccioID);
        HtmlUtils.saveMessageError(request, __msg);
        return getRedirectWhenCancel(request, transaccioID);
      }

      java.util.regex.Pattern p = java.util.regex.Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
      if (!p.matcher(email).matches()) {
        String __msg = I18NUtils.tradueix("genapp.validation.malformed",
            email, I18NUtils.tradueix(UsuariPersonaFields.EMAIL.fullName));
        HtmlUtils.saveMessageError(request, __msg);
        return getRedirectWhenCancel(request, transaccioID);
      }

      final boolean isHtml = true;

      // XYZ ZZZ TRA Configurable per part de Grup
      String subject = "Enviament de Correu des de DigitalIB";

      LoginInfo loginInfo = LoginInfo.getInstance();

      UsuariPersona up = loginInfo.getUsuariPersona();

      final String message;
      final Fitxer fitxer;

      if (transaccio.getPerfil().getUsPerfil() == Constants.PERFIL_US_CUSTODIA_INFO) {
        // Si esta custodiat llavors li hem d'enviar la informació de comunicació
        

        StringBuffer stb = new StringBuffer("<br/>");

        // XYZ ZZZ TRA Configurable per part de Grup
        stb.append(up.getNom()).append(" ").append(up.getLlinatges())
            .append(" li envia la referència al següent fitxer:").append("<br/>");

        InfoCustody info = transaccio.getInfoCustody();

        stb.append("<ul>");

        if (info.getCustodyId() == null) {
          // XYZ ZZZ TRA
          stb.append("<li><b>Arxiu::ExpedientID:</b> ").append(info.getArxiuExpedientId())
              .append("</li>");
          // XYZ ZZZ TRA
          stb.append("<li><b>Arxiu::DocumentID:</b> ").append(info.getArxiuDocumentId()).append("</li>");
        } else {
          // XYZ ZZZ TRA
          stb.append("<li><b>CustodyID:</b> ").append(info.getCustodyId()).append("</li>");
        }
        // XYZ ZZZ TRA
        stb.append("<li><b>CSV:</b> ").append(info.getCsv()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>CSV Validation Web:</b> ").append(info.getCsvValidationWeb()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>CSV Generation Definition:</b> ").append(info.getCsvGenerationDefinition())
            .append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>Original File URL:</b> ").append(info.getOriginalFileUrl()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>Printable File URL:</b> ").append(info.getPrintableFileUrl()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>ENI File URL:</b> ").append(info.getEniFileUrl()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>Validation File URL:</b> ").append(info.getValidationFileUrl()).append("</li>");

        stb.append("</ul>");
        
        message = stb.toString();

        fitxer = null;
      } else {
        // XYZ ZZZ Configurable per part de Grup
        message = up.getNom() + " " + up.getLlinatges() + " li envia el document adjunt.";

        fitxer = transaccio.getFitxerSignaturaID() == null ? transaccio.getFitxerEscanejat()
            : transaccio.getFitxerSignatura();

      }

      EmailUtil.postMail(subject, message, isHtml, Configuracio.getAppEmail(), fitxer, email);

      // XYZ ZZZ TRA
      HtmlUtils.saveMessageInfo(request, "Enviat correctament el document a " + email);

      return getRedirectWhenCancel(request, transaccioID);

    } catch (Throwable e) {
      // XYZ ZZZ TRA
      String msg = "Error desconegut intentant enviar un correu";
      log.error(msg, e);
      HtmlUtils.saveMessageError(request, msg);
      return getRedirectWhenCancel(request, transaccioID);
    }

  }

  @RequestMapping(value = "/delete/{transaccioID}")
  public String deleteTransaccio(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request, HttpServletResponse response) {

    try {
      Transaccio transaccio = transaccioEjb.findByPrimaryKey(transaccioID);
      if (transaccio == null) {
        String __msg = createMessageError(request, "error.notfound", transaccioID);
        return getRedirectWhenDelete(request, transaccioID, new Exception(__msg));
      } else {

        // XYZ ZZZ Verificar que es pot esborrar
        // (1) No te fitxer
        // (2) Esta en error i té més d'un dia
        transaccioLogicaEjb.deleteFull(transaccio, true, null, LoginInfo.getInstance().getUsername());

        createMessageSuccess(request, "success.deleted", transaccioID);
        return getRedirectWhenDelete(request, transaccioID, null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", transaccioID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, transaccioID, e);
    }
  }

  @Override
  public void postList(HttpServletRequest request, ModelAndView mav,
      TransaccioFilterForm filterForm, List<Transaccio> list) throws I18NException {

    // Afegir boto d'esborrar per transaccions buides
    filterForm.getAdditionalButtonsByPK().clear();
    boolean delete;

    final boolean isAdmin = isAdmin();

    for (Transaccio transaccio : list) {

      if (isAdmin) { // XYZ ZZZ Llevar
        delete = true;

      } else if (transaccio.getFitxerEscanejatID() == null) {
        delete = true;

      } else if (transaccio.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_ERROR) {
        delete = true;

      } else {
        delete = false;
      }

      if (delete) {
        AdditionalButton additionalButton = new AdditionalButton("icon-trash icon-white",
            "genapp.delete", getContextWeb() + "/delete/" + transaccio.getTransaccioID(),
            "btn-danger");

        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), additionalButton);
      }

      if (!isAdmin && transaccio.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_OK) {

        AdditionalButton additionalButton = new AdditionalButton("icon-envelope icon-white",
            "enviar.email", "javascript:enviarEmail(" + transaccio.getTransaccioID() + ")",
            "btn-warning");

        // getContextWeb() + "/enviaremail/" + transaccio.getTransaccioID()

        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), additionalButton);

      }

    }

    // XYZ ZZZ Ocultar columnes de datafi, missatgeerror, fitxersignat
    // si tots els valors de les columnes són NULL
    // Map<Long, String> map;
    // map = (Map<Long, String>) filterForm.getAdditionalField(USUARICOLUMN).getValueMap();
    // map.clear();
    // long key;
    //
    // for (Transaccio ua : list) {
    // key = ua.getTransaccioID();
    //
    // SelectMultipleStringKeyValue smskv;
    // List<StringKeyValue> usuaris;
    //
    // if (isUtilitzatPerAplicacio()) {
    //
    // smskv = new SelectMultipleStringKeyValue(
    // TransaccioFields.TRANSACCIOID.select,
    // new TransaccioQueryPath().USUARIAPLICACIOID().select);
    //
    // usuaris = transaccioEjb.executeQuery(smskv,
    // TransaccioFields.USUARIAPLICACIOID.equal(key));
    // //usuariAplicacioEjb
    //
    // // smskv = new SelectMultipleStringKeyValue(
    // // PerfilUsuariAplicacioFields.PERFILUSRAPPID.select,
    // // new PerfilUsuariAplicacioQueryPath().PERFIL().CODI().select);
    //
    // // usuaris = perfilUsuariAplicacioEjb.executeQuery(smskv_per_codi,
    // // PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(key));
    // } else {
    //
    // smskv = new SelectMultipleStringKeyValue(
    // TransaccioFields.TRANSACCIOID.select,
    // new TransaccioQueryPath().USUARIPERSONAID().select);
    //
    // usuaris = transaccioEjb.executeQuery(smskv,
    // TransaccioFields.USUARIPERSONAID.equal(key));
    // }
    //
    // StringBuffer str = new StringBuffer();
    //
    // System.out.println("USUARIS.SIZE = "+ usuaris.size());
    // for (StringKeyValue per : usuaris) {
    // System.out.println("KEY = "+per.getKey());
    // System.out.println("VALUE = "+per.getValue());
    // str.append(per.getValue());
    // }
    //
    // map.put(key, str.toString());
    // }

  }

}
