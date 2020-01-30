package es.caib.digitalib.back.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.context.i18n.LocaleContextHolder;
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
import es.caib.digitalib.ejb.InfoCustodyLocal;
import es.caib.digitalib.jpa.FitxerJPA;
import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.PerfilLogicaLocal;
import es.caib.digitalib.logic.PluginArxiuLogicaLocal;
import es.caib.digitalib.logic.PluginDocumentCustodyLogicaLocal;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.EmailUtil;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.model.entity.InfoCustody;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.utils.Constants;
import es.caib.plugins.arxiu.api.Document;
import es.caib.plugins.arxiu.api.DocumentContingut;
import es.caib.plugins.arxiu.api.IArxiuPlugin;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
public abstract class AbstractTransaccioController extends TransaccioController {

  public static final int USUARICOLUMN = 1;
  private static final String PDF = "PDF";
  private static final String ENI = "ENI";

  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  @EJB(mappedName = InfoCustodyLocal.JNDI_NAME)
  protected InfoCustodyLocal infoCustodyEjb;
  
  @EJB(mappedName = PerfilLogicaLocal.JNDI_NAME)
  protected PerfilLogicaLocal perfilLogicaEjb;
  
  @EJB(mappedName = PluginArxiuLogicaLocal.JNDI_NAME)
  protected PluginArxiuLogicaLocal pluginArxiuLogicaEjb;
  
  @EJB(mappedName = PluginDocumentCustodyLogicaLocal.JNDI_NAME)
  protected PluginDocumentCustodyLogicaLocal pluginDocumentCustodyLogicaEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariPersonaLocal usuariPersonaEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioLocal usuariAplicacioEjb;

  public abstract String getPerfilInfoContextWeb();

  public abstract boolean isUtilitzatPerAplicacio();

  public abstract boolean isAdmin();

  public abstract int getTipusPerfil();

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
        form.addAdditionalButton(new AdditionalButton(" icon-info-sign icon-white",
            INFOSIGNATURAID.fullName, AbstractInfoSignatureController.getContextWeb(isAdmin())
                + "/view" + "/" + _jpa.getInfoSignaturaID(), "btn-info"));
      }

      // Afegir botos de info cust
      if (_jpa.getInfoCustodyID() != null) {
        form.addAdditionalButton(new AdditionalButton(" icon-info-sign icon-white",
            INFOCUSTODYID.fullName, AbstractInfoCustodyController.getContextWeb(isAdmin())
                + "/view" + "/" + _jpa.getInfoCustodyID(), "btn-info"));
      }

      // Afegir Boto de Veure Perfil
      if (isAdmin()) {
        form.addAdditionalButton(new AdditionalButton("icon-user icon-white",
            "transaccio.veureperfil", getContextWeb() + "/viewperfil/"
                + _jpa.getTransaccioID(), "btn-info"));
      }
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

      filterForm.setOrderBy(TransaccioFields.TRANSACCIOID.fullName);
      
      filterForm.setOrderAsc(false);


        filterForm.addAdditionalButtonForEachItem(new AdditionalButton(      
          "icon-eye-open icon-white", "transaccio.veuredetall", getContextWeb() + "/view/{0}",
          "btn-primary"));
      if (isAdmin()) {        
        if (getPerfilInfoContextWeb() != null) {
          filterForm.addAdditionalButtonForEachItem(new AdditionalButton("icon-user icon-white",
              "transaccio.veureperfil", getContextWeb() + "/viewperfil/{0}", "btn-info"));
        }
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

    __tmp.add(new StringKeyValue("EE01", I18NUtils.tradueix("estatelaboracio.ee01")));
    __tmp.add(new StringKeyValue("EE02", I18NUtils.tradueix("estatelaboracio.ee02")));
    __tmp.add(new StringKeyValue("EE03", I18NUtils.tradueix("estatelaboracio.ee03")));
    __tmp.add(new StringKeyValue("EE04", I18NUtils.tradueix("estatelaboracio.ee04")));
    __tmp.add(new StringKeyValue("EE99", I18NUtils.tradueix("estatelaboracio.ee99")));

    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamDocumentTipus(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

    __tmp.add(new StringKeyValue("TD01", I18NUtils.tradueix("documenttipus.td01")));
    __tmp.add(new StringKeyValue("TD02", I18NUtils.tradueix("documenttipus.td02")));
    __tmp.add(new StringKeyValue("TD03", I18NUtils.tradueix("documenttipus.td03")));
    __tmp.add(new StringKeyValue("TD04", I18NUtils.tradueix("documenttipus.td04")));
    __tmp.add(new StringKeyValue("TD05", I18NUtils.tradueix("documenttipus.td05")));
    __tmp.add(new StringKeyValue("TD06", I18NUtils.tradueix("documenttipus.td06")));
    __tmp.add(new StringKeyValue("TD07", I18NUtils.tradueix("documenttipus.td07")));
    __tmp.add(new StringKeyValue("TD08", I18NUtils.tradueix("documenttipus.td08")));
    __tmp.add(new StringKeyValue("TD09", I18NUtils.tradueix("documenttipus.td09")));
    __tmp.add(new StringKeyValue("TD10", I18NUtils.tradueix("documenttipus.td10")));
    __tmp.add(new StringKeyValue("TD11", I18NUtils.tradueix("documenttipus.td11")));
    __tmp.add(new StringKeyValue("TD12", I18NUtils.tradueix("documenttipus.td12")));
    __tmp.add(new StringKeyValue("TD13", I18NUtils.tradueix("documenttipus.td13")));
    __tmp.add(new StringKeyValue("TD14", I18NUtils.tradueix("documenttipus.td14")));
    __tmp.add(new StringKeyValue("TD15", I18NUtils.tradueix("documenttipus.td15")));
    __tmp.add(new StringKeyValue("TD16", I18NUtils.tradueix("documenttipus.td16")));
    __tmp.add(new StringKeyValue("TD17", I18NUtils.tradueix("documenttipus.td17")));
    __tmp.add(new StringKeyValue("TD18", I18NUtils.tradueix("documenttipus.td18")));
    __tmp.add(new StringKeyValue("TD19", I18NUtils.tradueix("documenttipus.td19")));
    __tmp.add(new StringKeyValue("TD20", I18NUtils.tradueix("documenttipus.td20")));
    __tmp.add(new StringKeyValue("TD99", I18NUtils.tradueix("documenttipus.td99")));

    return __tmp;
  }

  @Override
  public List<StringKeyValue> getReferenceListForArxiuReqParamOrigen(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0", I18NUtils.tradueix("origen.ciutada")));
    __tmp.add(new StringKeyValue("1", I18NUtils.tradueix("origen.administracio")));
    return __tmp;
  }

  public List<StringKeyValue> getReferenceListForSignParamLanguageDoc(
      HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("ca", I18NUtils.tradueix("idiomadoc.catala")));
    __tmp.add(new StringKeyValue("es", I18NUtils.tradueix("idiomadoc.castella")));
    __tmp.add(new StringKeyValue("en", I18NUtils.tradueix("idiomadoc.angles")));
    __tmp.add(new StringKeyValue("de", I18NUtils.tradueix("idiomadoc.alemany")));
    return __tmp;
  }

  @RequestMapping(value = "/enviaremail")
  public String enviaremail(@RequestParam("transaccioID") java.lang.Long transaccioID,
      @RequestParam("email") String email, @RequestParam("content") String contingutExtra, HttpServletRequest request,
      HttpServletResponse response) {

    try {

      TransaccioJPA transaccio = transaccioLogicaEjb.findByPrimaryKeyFull(transaccioID);
      if (transaccio == null) {
        
        String __msg = createMessageError(request, "error.notfound", transaccioID);
        HtmlUtils.saveMessageError(request, __msg);
        return getRedirectWhenCancel(request, transaccioID);
      }

      java.util.regex.Pattern p = java.util.regex.Pattern
          .compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
      
      String[] emails = email.split(",");
      for (String em : emails) {
        em = em.trim();
        if (!p.matcher(em).matches()) {
          String __msg = I18NUtils.tradueix("genapp.validation.malformed", em,
              I18NUtils.tradueix(UsuariPersonaFields.EMAIL.fullName));
          HtmlUtils.saveMessageError(request, __msg);
          return getRedirectWhenCancel(request, transaccioID);
        }
      }

      final boolean isHtml = true;

      //Hauria de ser configurable des del form d'enviament de correu #79 
      Locale loc = LocaleContextHolder.getLocale();
      // "Enviament de Correu des de DigitalIB"
      String subject = I18NLogicUtils.tradueix(loc, "email.subject");

      LoginInfo loginInfo = LoginInfo.getInstance();

      UsuariPersona up = loginInfo.getUsuariPersona();

      String message;
      final Fitxer fitxer;

      if (transaccio.getPerfil().getUsPerfil() == Constants.PERFIL_US_CUSTODIA_INFO) {
        // Si esta custodiat llavors li hem d'enviar la informació de comunicació

        StringBuffer stb = new StringBuffer("<br/>");

        // XYZ ZZZ TRA Configurable per part de Grup
        // up.getNom()).append(" ").append(up.getLlinatges())   .append(" li envia la referència al següent fitxer:"
        stb.append(I18NLogicUtils.tradueix(loc, "email.custody.common", up.getNom() + " " +up.getLlinatges())).append("<br/>");

        InfoCustody info = transaccio.getInfoCustody();

        stb.append("<ul>");

        
        if (!StringUtils.isEmpty(info.getValidationFileUrl())) {
          
          // email.custody.validateurl=Pot accedir a tota la informació del document a través de la següent adreça {0}
          String msg = I18NLogicUtils.tradueix(loc, "email.custody.validateurl",info.getValidationFileUrl());
          stb.append("<li>").append(msg).append("</li></ul>");
          message = stb.toString();
          fitxer = null;
          
        } else if (!StringUtils.isEmpty(info.getCsv()) && !StringUtils.isEmpty(info.getCsvValidationWeb())) {
          
          // email.custody.csv=Pot accedir al document a traves de la següent adreça {0} indicant el següent CSV {1}
          //String msg = I18NLogicUtils.tradueix(loc, "email.custody.csv", info.getCsvValidationWeb(), info.getCsv());
          String msg = I18NLogicUtils.tradueix(loc, "email.custody.csvurl", "<a href=\"" + Configuracio.getPublicCsvUrl() + "view.xhtml?hash=" + info.getCsv()+"\">aquí</a>");
          stb.append("<li>").append(msg).append("</li></ul>");
          message = stb.toString();
          fitxer = null;
          
        } else if (!StringUtils.isEmpty(info.getOriginalFileUrl()) || !StringUtils.isEmpty(info.getPrintableFileUrl())) {
          
          String msg = "";
          if (!StringUtils.isEmpty(info.getOriginalFileUrl())) {
            // email.custody.original=Pot accedir al document original a través de la següent adreça {0}
            msg =  I18NLogicUtils.tradueix(loc, "email.custody.original", info.getOriginalFileUrl());
          }
          if (!StringUtils.isEmpty(info.getPrintableFileUrl())) {
            //email.custody.printable=Pot accedir a la versió imprimible del document a través de la següent adreça {0}
            msg = msg + I18NLogicUtils.tradueix(loc, "email.custody.printable", info.getPrintableFileUrl());
          }
        
          stb.append("<li>").append(msg).append("</li></ul>");
          message = stb.toString();
          fitxer = null;
          
        } else if (transaccio.getFitxerSignaturaID() != null) {
          message = I18NLogicUtils.tradueix(loc, "email.document", up.getNom() + " " + up.getLlinatges());

          fitxer = transaccio.getFitxerSignatura();
        } else {
          
          String msg;
          if (info.getCustodyId() != null) {
            // email.custody.error.custody=No es té informació suficient per enviar el document amb custodyID {0}. Consulti amb el seu administrador.
            msg = I18NLogicUtils.tradueix(loc," email.custody.error.custody", info.getCustodyId());
            
          } else {
            // email.custody.error.arxiu=No es té informació suficient per enviar el document amb ExpedientID {0} i UUID de document {1}. Consulti amb el seu administrador
            msg = I18NLogicUtils.tradueix(loc,"email.custody.error.arxiu", info.getArxiuExpedientId(), info.getArxiuDocumentId());
          }
          HtmlUtils.saveMessageError(request, msg);
          return getRedirectWhenCancel(request, transaccioID);
        }
        
        /*
        if (info.getCustodyId() == null) {
          // XYZ ZZZ TRA
          stb.append("<li><b>Arxiu::ExpedientID:</b> ").append(info.getArxiuExpedientId())
              .append("</li>");
          // XYZ ZZZ TRA
          stb.append("<li><b>Arxiu::DocumentID:</b> ").append(info.getArxiuDocumentId())
              .append("</li>");
        } else {
          // XYZ ZZZ TRA
          stb.append("<li><b>CustodyID:</b> ").append(info.getCustodyId()).append("</li>");
        }
        // XYZ ZZZ TRA
        stb.append("<li><b>CSV:</b> ").append(info.getCsv()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>CSV Validation Web:</b> ").append(info.getCsvValidationWeb())
            .append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>CSV Generation Definition:</b> ")
            .append(info.getCsvGenerationDefinition()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>Original File URL:</b> ").append(info.getOriginalFileUrl())
            .append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>Printable File URL:</b> ").append(info.getPrintableFileUrl())
            .append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>ENI File URL:</b> ").append(info.getEniFileUrl()).append("</li>");
        // XYZ ZZZ TRA
        stb.append("<li><b>Validation File URL:</b> ").append(info.getValidationFileUrl())
            .append("</li>");
*/
   

        
      } else {
        // XYZ ZZZ Configurable per part de Grup
        // {0} li envia el document adjunt.
        message = I18NLogicUtils.tradueix(loc, "email.document", up.getNom() + " " + up.getLlinatges()); 

        fitxer = transaccio.getFitxerSignaturaID() == null ? transaccio.getFitxerEscanejat()
            : transaccio.getFitxerSignatura();

      }

      StringBuffer bff = new StringBuffer("<br/>----------------------------------------------------------------------------------------"
          + "<br><br>"+I18NUtils.tradueix("email.addicional")+"<br><br>   ");
      contingutExtra = bff.toString() + "\""+ contingutExtra;
      bff = new StringBuffer("<br><br/>----------------------------------------------------------------------------------------");
      contingutExtra = contingutExtra + "\"" + bff.toString();
      
      message += contingutExtra;
      
      for (String em : emails) {
        em = em.trim();
        
        EmailUtil.postMail(subject, message, isHtml, Configuracio.getAppEmail(), fitxer, em);
        HtmlUtils.saveMessageSuccess(request, I18NLogicUtils.tradueix(loc, "email.custody.success", em));
      }
      

      return getRedirectWhenCancel(request, transaccioID);

    } catch (Throwable e) {
      String msg = I18NUtils.tradueix("transaccio.mail.enviar.error.desconegut", e.getMessage());
      log.error(msg, e);
      HtmlUtils.saveMessageError(request, msg);
      return getRedirectWhenCancel(request, transaccioID);
    }

  }
  
  @Override
  public void delete(HttpServletRequest request, Transaccio transaccio) throws Exception,I18NException {

      // XYZ ZZZ Verificar que es pot esborrar
      // (1) No te fitxer
      // (2) Esta en error i té més d'un dia
      transaccioLogicaEjb.deleteFull(transaccio, true, null, LoginInfo.getInstance()
          .getUsername());
    
  }

  @RequestMapping(value = "/descarregar/{transaccioID}", method = RequestMethod.GET)
  public void descarregarFitxer(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request, HttpServletResponse response) throws I18NException {

    TransaccioJPA trans = transaccioEjb.findByPrimaryKey(transaccioID);

    FitxerJPA fitxer = trans.getFitxerEscanejat();
    FileDownloadController.fullDownload(fitxer.getFitxerID(), fitxer.getNom(),
        fitxer.getMime(), response);
  }
  
  @RequestMapping(value = "/descarregarfirmat/{transaccioID}", method = RequestMethod.GET)
  public void descarregarFitxerFirmat(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request, HttpServletResponse response) throws I18NException {

    TransaccioJPA trans = transaccioEjb.findByPrimaryKey(transaccioID);
    FitxerJPA fitxer = trans.getFitxerSignatura();
    FileDownloadController.fullDownload(fitxer.getFitxerID(), fitxer.getNom(),
        fitxer.getMime(), response);
  }
  
  
  protected enum TipusFile {
    
    ORIGINAL,
    ENI_DOC,
    VERSIO_IMPRIMIBLE
    
  }
  
  

  @RequestMapping(value = "/descarregaroriginal/{transaccioID}", method = RequestMethod.GET)
  public void descarregarOriginal(
      @PathVariable("transaccioID") java.lang.Long transaccioID, HttpServletRequest request,
      HttpServletResponse response) throws I18NException, IOException {
    
    final String format = PDF;
    TipusFile tipusFile = TipusFile.ORIGINAL;

    internalDownload(transaccioID, response, format, tipusFile);
  }

  protected void internalDownload(java.lang.Long transaccioID, HttpServletResponse response,
      final String format, TipusFile tipusFile) throws I18NException, IOException {
    
    if (transaccioID == null) {
      return;
    }
    
    TransaccioJPA transaccio = transaccioLogicaEjb.findByPrimaryKey(transaccioID);

    InfoCustodyJPA infoCustody = infoCustodyEjb.findByPrimaryKey(transaccio.getInfoCustodyID());
    Perfil perfil = perfilLogicaEjb.findByPrimaryKey(transaccio.getPerfilID());
    
    int tipusCustodia = perfil.getTipusCustodia();
    
    switch (tipusCustodia) {
      case Constants.TIPUS_CUSTODIA_ARXIU:
        IArxiuPlugin arxiuPlugin = pluginArxiuLogicaEjb.getInstanceByPluginID(perfil.getPluginArxiuID()); 
        byte[] data = null;
        switch(tipusFile) {
          case ORIGINAL:
            Document original = arxiuPlugin.documentDetalls(infoCustody.getArxiuDocumentId(), null, true);
            data = original.getContingut().getContingut();
          break;

          case ENI_DOC:
            String enidoc = arxiuPlugin.documentExportarEni(infoCustody.getArxiuDocumentId());
            data = enidoc.getBytes();
          break;
          
          case VERSIO_IMPRIMIBLE:
            DocumentContingut imprimible = arxiuPlugin.documentImprimible(infoCustody.getArxiuDocumentId());
            data = imprimible.getContingut();
          break;
            
        }
        prepareAndDownload(data, response, transaccio, format);

      break;
      
      case Constants.TIPUS_CUSTODIA_DOCUMENTCUSTODY:
        // IDocumentCustodyPlugin custodyPlugin = pluginDocumentCustodyLogicaEjb
        //    .getInstanceByPluginID(perfil.getPluginDocCustodyID());

        String urlStr = null;

        // Map<String, Object> parameters = new HashMap<String, Object>();
        // parameters.put("transaccio", transaccio);

        // } catch (CustodyException e) {
        // XYZ ZZZ TRA
        // throw new I18NException("genapp.comodi",
        // "Error desconegut llegint document de DocumetnCustody: " + e.getMessage());
        // }

        switch (tipusFile) {
          case ORIGINAL:
            // urlStr = custodyPlugin.getOriginalFileUrl(infoCustody.getCustodyId(),
            // parameters);
            urlStr = transaccio.getInfoCustody().getOriginalFileUrl();
          break;

          case ENI_DOC:
            urlStr = transaccio.getInfoCustody().getEniFileUrl();
          break;

          case VERSIO_IMPRIMIBLE:
            urlStr = transaccio.getInfoCustody().getPrintableFileUrl();
          break;

        }

        if (urlStr == null) {
          throw new I18NException("genapp.comodi",
              "El sistema de custòdia no ha definit la URL a aquest fitxer");
        }

        try {
          response.sendRedirect(urlStr);
        } catch (IOException e) {
          throw new I18NException("genapp.comodi", "Error reenviant la petició a " + urlStr);
        }

      break;
      
      case Constants.TIPUS_CUSTODIA_SENSE:
        // XYZ ZZZ TRA
        throw new I18NException("genapp.comodi", "Aquesta transacció no ha realitzat custòdia !!!! ");
      
    }

  }
  
  
  @RequestMapping(value = "/descarregarenidoc/{transaccioID}", method = RequestMethod.GET)
  public void descarregarEnidoc(
      @PathVariable("transaccioID") java.lang.Long transaccioID, HttpServletRequest request,
      HttpServletResponse response) throws I18NException, IOException {

    final String format = ENI;
    TipusFile tipusFile = TipusFile.ENI_DOC;

    internalDownload(transaccioID, response, format, tipusFile);

  }
  
  @RequestMapping(value = "/descarregarimprimible/{transaccioID}", method = RequestMethod.GET)
  public void descarregarVersioImprible(
      @PathVariable("transaccioID") java.lang.Long transaccioID, HttpServletRequest request,
      HttpServletResponse response) throws I18NException, IOException {
    
    final String format = PDF;
    TipusFile tipusFile = TipusFile.VERSIO_IMPRIMIBLE;

    internalDownload(transaccioID, response, format, tipusFile);

  }

  private void prepareAndDownload(byte[] data, HttpServletResponse response, TransaccioJPA transaccio, String format) {
    
	//s'eliminen els espais en el cas de noms de transaccions amb més d'una paraula, així queda només el nom amb una paraula 
	//motiu: no se li afegia l'extensió correctament al document descarregat
    String documentName = transaccio.getNom().replace(" ", "_");
    
    if (format.equals(PDF)) {
      response.setContentType("application/pdf");
      
      if (documentName != null && !documentName.toLowerCase().endsWith(".pdf")) {
          documentName += ".pdf";
      }
      
    } else if (format.equals(ENI)) {
      response.setContentType("text/xml");
      
      if (documentName != null && !documentName.toLowerCase().endsWith(".xml"      )) {
          documentName += ".xml";
      }
    }
    response.setHeader("Content-disposition", "attachment; filename="+documentName);
    response.setContentLength(data.length);
    
    OutputStream out;
    
    try {
      out = response.getOutputStream();
      out.write(data);
      out.flush();
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
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

      delete = canBeDeleted(isAdmin, (TransaccioJPA)transaccio);

      if (transaccio.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_OK) {
        // Afegir boto de Descarrega de document escanejat o de versio imprimible segons si es
        // escaneig o copia autentica
        
        Perfil perfil = perfilLogicaEjb.findByPrimaryKey(transaccio.getPerfilID());
        
        switch (perfil.getUsPerfil()) {
            case Constants.PERFIL_US_CUSTODIA_INFO:
                AdditionalButton addOriginalButton = new AdditionalButton("icon-download-alt icon-white",
                        "transaccio.descarregar.original", getContextWeb()
                            + "/descarregaroriginal/{0}", "btn-success\" target=\"_blank");
            	AdditionalButton addImprimibleButton = new AdditionalButton("icon-print icon-white",
                        "transaccio.descarregar.imprimible", getContextWeb()
                            + "/descarregarimprimible/{0}", "btn-success\" target=\"_blank");
            
                filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), addOriginalButton);
                filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), addImprimibleButton);
            
                if (isAdmin) {
                    AdditionalButton addEniButton = new AdditionalButton("icon-file icon-white",
                        "transaccio.descarregar.enidoc", getContextWeb()
                            + "/descarregarenidoc/{0}", "btn-success\" target=\"_blank");
                    
                    filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), addEniButton);
                }
                break;
            case Constants.PERFIL_US_COPIA_AUTENTICA_INFO:
                AdditionalButton addFirmatButton = new AdditionalButton("icon-download-alt icon-white",
                        "transaccio.descarregar.firmat", getContextWeb()
                            + "/descarregarfirmat/{0}", "btn-success");
                filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), addFirmatButton);
                
                break;
            default: // cas de PERFIL_US_NOMES_ESCANEIG_INFO
                AdditionalButton addEscaneigButton = new AdditionalButton("icon-download-alt icon-white",
                     "transaccio.descarregar.escaneig", getContextWeb() + "/descarregar/{0}",
                     "btn-success");
                filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), addEscaneigButton);
                break;	
        }
        
      }

      if (delete) {
        AdditionalButton additionalButton = new AdditionalButton("icon-trash icon-white",
            "genapp.delete",
            "javascript:openModal('" + request.getContextPath()+ getContextWeb() + "/" + transaccio.getTransaccioID() + "/delete','show');",           
            "btn-danger");

        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), additionalButton);
      }

      if (!isAdmin && transaccio.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_OK) {

        AdditionalButton additionalButton = new AdditionalButton("icon-envelope icon-white",
            "enviar.email", "javascript:enviarEmail(" + transaccio.getTransaccioID() + ", 'show')",
            "btn-warning");

        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(), additionalButton);

      }

    }

    if (isAdmin) {
      // XYZ ZZZ Ocultar columnes de datafi, missatgeerror, fitxersignat
      // si tots els valors de les columnes són NULL
      Map<Long, String> map;
      map = (Map<Long, String>) filterForm.getAdditionalField(USUARICOLUMN).getValueMap();
      map.clear();

      for (Transaccio ua : list) {

        SelectMultipleStringKeyValue smskv;
        StringKeyValue usuari;
        String web;

        if (isUtilitzatPerAplicacio()) {

          smskv = new SelectMultipleStringKeyValue(
              UsuariAplicacioFields.USUARIAPLICACIOID.select,
              UsuariAplicacioFields.USERNAME.select);

          usuari = usuariAplicacioEjb.executeQueryOne(smskv,
              UsuariAplicacioFields.USUARIAPLICACIOID.equal(ua.getUsuariAplicacioId()));
          
          web = request.getContextPath() + "/admin/usuariAplicacio/" + ua.getUsuariAplicacioId() + "/edit";

        } else {

          smskv = new SelectMultipleStringKeyValue(UsuariPersonaFields.USUARIPERSONAID.select,
              UsuariPersonaFields.NOM.select, UsuariPersonaFields.LLINATGES.select);

          usuari = usuariPersonaEjb.executeQueryOne(smskv,
              UsuariPersonaFields.USUARIPERSONAID.equal(ua.getUsuariPersonaId()));
          
          
          web = request.getContextPath() + "/admin/usuariPersona/" + ua.getUsuariPersonaId() + "/edit";

        }

        if (usuari != null) {
          map.put(ua.getTransaccioID(), "<a href=\"" + web + "\">"  + usuari.getValue() + "</a>");
        }
      }

    }

  }

  protected boolean canBeDeleted(final boolean isAdmin, Transaccio transaccio) {

    if (transaccio.getFitxerEscanejatID() == null) {
      return true;
    }
    if (transaccio.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_ERROR) {
      return true;
    }

    if (isAdmin) {
      if (transaccio.getInfoCustodyID() == null) {
        return true;
      }
    } else {
      if (getTipusPerfil() != Constants.PERFIL_US_CUSTODIA_INFO) {
        return true;
      }
    }

    return false;
  }

}
