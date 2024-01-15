package es.caib.digitalib.back.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.KeyValue;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.GroupByItem;
import org.fundaciobit.genapp.common.query.SelectMultipleKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
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
import es.caib.digitalib.ejb.InfoCustodyService;
import es.caib.digitalib.persistence.FitxerJPA;
import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.logic.PerfilLogicaService;
import es.caib.digitalib.logic.PluginArxiuLogicaService;
import es.caib.digitalib.logic.PluginDocumentCustodyLogicaService;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.logic.TransaccioPublicLogicaService;
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
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.plugins.arxiu.api.Document;
import es.caib.plugins.arxiu.api.DocumentContingut;
import es.caib.plugins.arxiu.api.IArxiuPlugin;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
public abstract class AbstractTransaccioController extends TransaccioController {

    /**
     * NOTA: Alerta al canviar aquesta constant, ja que està definida en jsp's
     */
    public static final String THUMBNAIL_PDF_MASSIVE = "/thumbnailpdf";

    private static final String PDF = "PDF";
    private static final String ENI = "ENI";

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @EJB(mappedName = InfoCustodyService.JNDI_NAME)
    protected InfoCustodyService infoCustodyEjb;

    @EJB(mappedName = PerfilLogicaService.JNDI_NAME)
    protected PerfilLogicaService perfilLogicaEjb;

    @EJB(mappedName = PluginArxiuLogicaService.JNDI_NAME)
    protected PluginArxiuLogicaService pluginArxiuLogicaEjb;

    @EJB(mappedName = PluginDocumentCustodyLogicaService.JNDI_NAME)
    protected PluginDocumentCustodyLogicaService pluginDocumentCustodyLogicaEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariPersonaService usuariPersonaEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;
    
    @EJB(mappedName = TransaccioPublicLogicaService.JNDI_NAME)
    protected TransaccioPublicLogicaService transaccioPublicEjb;

    public abstract String getPerfilInfoContextWeb();

    public abstract boolean isUtilitzatPerAplicacio();

    public abstract boolean isAdmin();

    public abstract int getTipusPerfil();

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {

        Where w;

        {
            if (isUtilitzatPerAplicacio() == true) {
                w = USUARIAPLICACIOID.isNotNull();
            } else {
                w = USUARIPERSONAID.isNotNull();
            }
        }

        return w;
    }

    @Override
    public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
            HttpServletRequest request, ModelAndView mav) throws I18NException {
        TransaccioForm form = super.getTransaccioForm(_jpa, __isView, request, mav);

        {

            if (isUtilitzatPerAplicacio() == true) {
                form.setEntityNameCode("transaccio.aplicacio");
                form.setEntityNameCodePlural("transaccio.aplicacio.plural");
                if (!__isView) {
                    form.addHiddenField(USUARIPERSONAID);
                }
            } else {
                form.setEntityNameCode("transaccio.persona");
                form.setEntityNameCodePlural("transaccio.persona.plural");
                if (!__isView) {
                    form.addHiddenField(USUARIAPLICACIOID);
                }
            }
        }

        if (__isView) {

            
            if (_jpa.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_OK) {
                
                form.setAttachedAdditionalJspCode(true);
    
                // Ocultar tots els camps null
                TransaccioForm.hideNullFields(_jpa, form, ALL_TRANSACCIO_FIELDS);
    
                
                form.addHiddenField(ESTATCODI);
                
    
                form.addHiddenField(INFOCUSTODYID);
                form.addHiddenField(INFOSIGNATURAID);
                form.addHiddenField(PERFILID);
    
                form.addHiddenField(VIEW);
                form.addHiddenField(IP);
                form.addHiddenField(USUARIPERSONAID);
                form.addHiddenField(RETURNURL);
    
                // Afegir botos de info sign
                if (_jpa.getInfoSignaturaID() != null) {
                    form.addAdditionalButton(
                            new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_INFO),
                                    INFOSIGNATURAID.fullName,
                                    AbstractInfoSignatureController.getContextWeb(isAdmin())
                                            + "/view" + "/" + _jpa.getInfoSignaturaID(),
                                    "btn-info"));
                }
    
                // Afegir botos de info cust
                if (_jpa.getInfoCustodyID() != null) {
                    form.addAdditionalButton(
                            new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_INFO),
                                    INFOCUSTODYID.fullName,
                                    AbstractInfoCustodyController.getContextWeb(isAdmin())
                                            + "/view" + "/" + _jpa.getInfoCustodyID(),
                                    "btn-info"));
                }
    
                // Afegir Boto de Veure Perfil
                if (isAdmin()) {
                    form.addAdditionalButton(
                            new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_USER), "transaccio.veureperfil",
                                    getContextWeb() + "/viewperfil/" + _jpa.getTransaccioID(),
                                    "btn-info"));
                }
            } else {
                // Cancel·lat, Error, ...
                Set<Field<?>> fields = new HashSet<Field<?>>(Arrays.asList(ALL_TRANSACCIO_FIELDS));
                
                fields.remove(NOM);
                fields.remove(DATAINICI);
                fields.remove(DATAFI);
                fields.remove(ESTATCODI);
                fields.remove(ESTATMISSATGE);
                if (form.getTransaccio().getEstatExcepcio() != null) {
                    fields.remove(ESTATEXCEPCIO);
                }

                form.setHiddenFields(fields);

            }
        } else {
            
            // EDICIÓ

            // Ha d'escriure els DNIs, CIFs o NIFs de les persones interessades separats per coma.
            String msgIn = I18NUtils.tradueix("transaccio.interessats.ajuda");
            form.addHelpToField(ARXIUREQPARAMINTERESSATS, msgIn);
            
            
            // Ha d'escriure la unitat DIR3 del funcionari. Pot esbrinar aquest codi accedint a la
            // pàgina web
            // https://intranet.caib.es/dir3caib i introduint les dades requerides.";
            String msgFD3 = I18NUtils.tradueix("transaccio.fundacionaridir3.ajuda");

            form.addHelpToField(SIGNPARAMFUNCIONARIDIR3, msgFD3);
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
            ocults.remove(TransaccioFields.TRANSACCIOMULTIPLEID);
            ocults.remove(TransaccioFields.NOM);
            ocults.remove(TransaccioFields.DATAINICI);
            ocults.remove(TransaccioFields.DATAFI);
            ocults.remove(TransaccioFields.ESTATCODI);
            ocults.remove(TransaccioFields.USUARIPERSONAID);
            ocults.remove(TransaccioFields.USUARIAPLICACIOID);

            filterForm.setHiddenFields(ocults);

            filterForm.setOrderBy(TransaccioFields.TRANSACCIOID.fullName);

            filterForm.setOrderAsc(false);

            filterForm.addAdditionalButtonForEachItem(
                    new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_EYE), "transaccio.veuredetall",
                            getContextWeb() + "/view/{0}", "btn-primary"));
            if (isAdmin()) {
                if (getPerfilInfoContextWeb() != null) {
                    filterForm.addAdditionalButtonForEachItem(new AdditionalButton(
                            IconUtils.getWhite(IconUtils.ICON_EYE), "transaccio.veureperfil",
                            getContextWeb() + "/viewperfil/{0}", "btn-info"));
                }
            }

            List<Field<?>> campsFiltre = filterForm.getDefaultGroupByFields();
            if (isAdmin()) {
                /*
                 * AdditionalField<Long, String> adfield4 = new AdditionalField<Long,
                 * String>(); adfield4.setPosition(USUARICOLUMN); // Els valors s'ompliran al
                 * mètode postList() adfield4.setValueMap(new HashMap<Long, String>());
                 * adfield4.setEscapeXml(false);
                 */

                if (isUtilitzatPerAplicacio()) {
                    filterForm.setEntityNameCode("transaccio.aplicacio");
                    filterForm.setEntityNameCodePlural("transaccio.aplicacio.plural");
                    filterForm.addHiddenField(USUARIPERSONAID);
                    // filterForm.addHiddenField(USUARIAPLICACIOID);

                    // adfield4.setCodeName("usuariAplicacio.usuariAplicacio");
                    campsFiltre.remove(TransaccioFields.USUARIPERSONAID);
                } else {
                    filterForm.setEntityNameCode("transaccio.persona");
                    filterForm.setEntityNameCodePlural("transaccio.persona.plural");
                    filterForm.addHiddenField(USUARIAPLICACIOID);
                    // filterForm.addHiddenField(USUARIPERSONAID);

                    // adfield4.setCodeName("usuariPersona.usuariPersona");
                    campsFiltre.remove(TransaccioFields.USUARIAPLICACIOID);
                }

                // filterForm.addAdditionalField(adfield4);
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
            @PathVariable("transaccioID") java.lang.Long transaccioID,
            HttpServletRequest request, HttpServletResponse response) throws I18NException {
        Long perfilID = transaccioEjb.executeQueryOne(TransaccioFields.PERFILID,
                TransaccioFields.TRANSACCIOID.equal(transaccioID));

        return new ModelAndView(
                new RedirectView(getPerfilInfoContextWeb() + "/view/" + perfilID, true));
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
        __tmp.add(new StringKeyValue(String.valueOf(ScanWebSimpleStatus.STATUS_EXPIRED),
                I18NUtils.tradueix("estatcodi._3")));
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
    public List<StringKeyValue> getReferenceListForInfoScanDocumentTipus(
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
        __tmp.add(new StringKeyValue(String.valueOf(Constants.ORIGEN_CIUTADA), I18NUtils.tradueix("origen.ciutada")));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.ORIGEN_ADMINISTRACIO), I18NUtils.tradueix("origen.administracio")));
        return __tmp;
    }

    @Override
    public List<StringKeyValue> getReferenceListForInfoScanLanguageDoc(
            HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue("ca", I18NUtils.tradueix("idiomadoc.catala")));
        __tmp.add(new StringKeyValue("es", I18NUtils.tradueix("idiomadoc.castella")));
        __tmp.add(new StringKeyValue("en", I18NUtils.tradueix("idiomadoc.angles")));
        __tmp.add(new StringKeyValue("de", I18NUtils.tradueix("idiomadoc.alemany")));
        __tmp.add(new StringKeyValue("gl", "Galego"));
        __tmp.add(new StringKeyValue("eu", "Euskara"));
        __tmp.add(new StringKeyValue("fr", "Français"));
        __tmp.add(new StringKeyValue("it", "Italiano"));

        return __tmp;
    }

    @Override
    public List<StringKeyValue> getReferenceListForInfoScanPixelType(
            HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue("1", "BW"));
        __tmp.add(new StringKeyValue("8", "GRAY"));
        __tmp.add(new StringKeyValue("32", "COLOR"));
        return __tmp;
    }

    @RequestMapping(value = "/enviaremail")
    public String enviaremail(@RequestParam("transaccioID") java.lang.Long transaccioID,
            @RequestParam("email") String email,
            @RequestParam("content") String contingutExtra, HttpServletRequest request,
            HttpServletResponse response) {

        try {

            TransaccioJPA transaccio = transaccioLogicaEjb.findByPrimaryKeyFull(transaccioID);
            if (transaccio == null) {

                String __msg = createMessageError(request, "error.notfound", transaccioID);
                HtmlUtils.saveMessageError(request, __msg);
                return getRedirectWhenCancel(request, transaccioID);
            }

            java.util.regex.Pattern p = java.util.regex.Pattern.compile(
                    "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");

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

            // Hauria de ser configurable des del form d'enviament de correu #79
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
                // up.getNom()).append(" ").append(up.getLlinatges()) .append(" li envia la
                // referència al següent fitxer:"
                stb.append(I18NLogicUtils.tradueix(loc, "email.custody.common",
                        up.getNom() + " " + up.getLlinatges())).append("<br/>");

                InfoCustody info = transaccio.getInfoCustody();

                stb.append("<ul>");

                if (!StringUtils.isEmpty(info.getValidationFileUrl())) {

                    // email.custody.validateurl=Pot accedir a tota la informació del document
                    // a través de la següent adreça {0}
                    String msg = I18NLogicUtils.tradueix(loc, "email.custody.validateurl",
                            info.getValidationFileUrl());
                    stb.append("<li>").append(msg).append("</li></ul>");
                    message = stb.toString();
                    fitxer = null;

                } else if (!StringUtils.isEmpty(info.getCsv())
                        && !StringUtils.isEmpty(info.getCsvValidationWeb())) {

                    // email.custody.csv=Pot accedir al document a traves de la següent adreça
                    // {0} indicant el següent CSV {1}
                    // String msg = I18NLogicUtils.tradueix(loc, "email.custody.csv",
                    // info.getCsvValidationWeb(), info.getCsv());
                    String msg = I18NLogicUtils.tradueix(loc, "email.custody.csvurl",
                            "<a href=\"" + Configuracio.getPublicCsvUrl() + "view.xhtml?hash="
                                    + info.getCsv() + "\">aquí</a>");
                    stb.append("<li>").append(msg).append("</li></ul>");
                    message = stb.toString();
                    fitxer = null;

                } else if (!StringUtils.isEmpty(info.getOriginalFileUrl())
                        || !StringUtils.isEmpty(info.getPrintableFileUrl())) {

                    String msg = "";
                    if (!StringUtils.isEmpty(info.getOriginalFileUrl())) {
                        // email.custody.original=Pot accedir al document original a través de
                        // la següent adreça {0}
                        msg = I18NLogicUtils.tradueix(loc, "email.custody.original",
                                info.getOriginalFileUrl());
                    }
                    if (!StringUtils.isEmpty(info.getPrintableFileUrl())) {
                        // email.custody.printable=Pot accedir a la versió imprimible del
                        // document a través de la següent adreça {0}
                        msg = msg + I18NLogicUtils.tradueix(loc, "email.custody.printable",
                                info.getPrintableFileUrl());
                    }

                    stb.append("<li>").append(msg).append("</li></ul>");
                    message = stb.toString();
                    fitxer = null;

                } else if (transaccio.getFitxerSignaturaID() != null) {
                    message = I18NLogicUtils.tradueix(loc, "email.document",
                            up.getNom() + " " + up.getLlinatges());

                    fitxer = transaccio.getFitxerSignatura();
                } else {

                    String msg;
                    if (info.getCustodyId() != null) {
                        // email.custody.error.custody=No es té informació suficient per enviar
                        // el document amb custodyID {0}. Consulti amb el seu administrador.
                        msg = I18NLogicUtils.tradueix(loc, " email.custody.error.custody",
                                info.getCustodyId());

                    } else {
                        // email.custody.error.arxiu=No es té informació suficient per enviar
                        // el document amb ExpedientID {0} i UUID de document {1}. Consulti amb
                        // el seu administrador
                        msg = I18NLogicUtils.tradueix(loc, "email.custody.error.arxiu",
                                info.getArxiuExpedientId(), info.getArxiuDocumentId());
                    }
                    HtmlUtils.saveMessageError(request, msg);
                    return getRedirectWhenCancel(request, transaccioID);
                }

            } else {
                // XYZ ZZZ Configurable per part de Grup
                // {0} li envia el document adjunt.
                message = I18NLogicUtils.tradueix(loc, "email.document",
                        up.getNom() + " " + up.getLlinatges());

                fitxer = transaccio.getFitxerSignaturaID() == null
                        ? transaccio.getFitxerEscanejat()
                        : transaccio.getFitxerSignatura();

            }

            StringBuffer bff = new StringBuffer(
                    "<br/>----------------------------------------------------------------------------------------"
                            + "<br><br>" + I18NUtils.tradueix("email.addicional")
                            + "<br><br>   ");
            contingutExtra = bff.toString() + "\"" + contingutExtra;
            bff = new StringBuffer(
                    "<br><br/>----------------------------------------------------------------------------------------");
            contingutExtra = contingutExtra + "\"" + bff.toString();

            message += contingutExtra;

            for (String em : emails) {
                em = em.trim();

                EmailUtil.postMail(subject, message, isHtml, Configuracio.getAppEmail(),
                        fitxer, em);
                HtmlUtils.saveMessageSuccess(request,
                        I18NLogicUtils.tradueix(loc, "email.custody.success", em));
            }

            return getRedirectWhenCancel(request, transaccioID);

        } catch (Throwable e) {
            String msg = I18NUtils.tradueix("transaccio.mail.enviar.error.desconegut",
                    e.getMessage());
            log.error(msg, e);
            HtmlUtils.saveMessageError(request, msg);
            return getRedirectWhenCancel(request, transaccioID);
        }

    }

    @Override
    public void delete(HttpServletRequest request, Transaccio transaccio) throws I18NException {
        // XYZ ZZZ Verificar que es pot esborrar
        // (1) No te fitxer
        // (2) Esta en error i té més d'un dia
        transaccioLogicaEjb.deleteFull(transaccio, null, LoginInfo.getInstance().getUsername());
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
    public void descarregarFitxerFirmat(
            @PathVariable("transaccioID") java.lang.Long transaccioID,
            HttpServletRequest request, HttpServletResponse response) throws I18NException {

        TransaccioJPA trans = transaccioEjb.findByPrimaryKey(transaccioID);
        FitxerJPA fitxer = trans.getFitxerSignatura();
        FileDownloadController.fullDownload(fitxer.getFitxerID(), fitxer.getNom(),
                fitxer.getMime(), response);
    }

    protected enum TipusFile {
        ORIGINAL, ENI_DOC, VERSIO_IMPRIMIBLE
    }

    @RequestMapping(value = "/descarregaroriginal/{transaccioID}", method = RequestMethod.GET)
    public void descarregarOriginal(@PathVariable("transaccioID") java.lang.Long transaccioID,
            HttpServletRequest request, HttpServletResponse response)
            throws I18NException, IOException {

        final String format = PDF;
        TipusFile tipusFile = TipusFile.ORIGINAL;

        internalDownload(transaccioID, response, format, tipusFile);
    }

    protected void internalDownload(java.lang.Long transaccioID, HttpServletResponse response,
            final String format, TipusFile tipusFile) throws I18NException, IOException {

        if (transaccioID == null) {
            return;
        }

        TransaccioJPA transaccio = transaccioLogicaEjb.findByPrimaryKeyFull(transaccioID);

        InfoCustodyJPA infoCustody = infoCustodyEjb
                .findByPrimaryKey(transaccio.getInfoCustodyID());
        Perfil perfil = perfilLogicaEjb.findByPrimaryKey(transaccio.getPerfilID());

        int tipusCustodia = perfil.getTipusCustodia();

        switch (tipusCustodia) {
            case Constants.TIPUS_CUSTODIA_ARXIU:
                IArxiuPlugin arxiuPlugin = pluginArxiuLogicaEjb
                        .getInstanceByPluginID(perfil.getPluginArxiuID());
                byte[] data = null;
                switch (tipusFile) {
                    case ORIGINAL:
                        Document original = arxiuPlugin
                                .documentDetalls(infoCustody.getArxiuDocumentId(), null, true);
                        data = original.getContingut().getContingut();
                    break;

                    case ENI_DOC:
                        String enidoc = arxiuPlugin
                                .documentExportarEni(infoCustody.getArxiuDocumentId());
                        data = enidoc.getBytes();
                    break;

                    case VERSIO_IMPRIMIBLE:
                        DocumentContingut imprimible = arxiuPlugin
                                .documentImprimible(infoCustody.getArxiuDocumentId());
                        data = imprimible.getContingut();
                    break;

                }
                prepareAndDownload(data, response, transaccio, format);

            break;

            case Constants.TIPUS_CUSTODIA_DOCUMENTCUSTODY:

                String urlStr = null;

                switch (tipusFile) {
                    case ORIGINAL:
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
                    throw new I18NException("genapp.comodi",
                            "Error reenviant la petició a " + urlStr);
                }

            break;

            case Constants.TIPUS_CUSTODIA_SENSE:
                // XYZ ZZZ TRA
                throw new I18NException("genapp.comodi",
                        "Aquesta transacció no ha realitzat custòdia !!!! ");

        }

    }

    @RequestMapping(value = "/descarregarenidoc/{transaccioID}", method = RequestMethod.GET)
    public void descarregarEnidoc(@PathVariable("transaccioID") java.lang.Long transaccioID,
            HttpServletRequest request, HttpServletResponse response)
            throws I18NException, IOException {

        final String format = ENI;
        TipusFile tipusFile = TipusFile.ENI_DOC;

        internalDownload(transaccioID, response, format, tipusFile);

    }

    @RequestMapping(value = "/descarregarimprimible/{transaccioID}", method = RequestMethod.GET)
    public void descarregarVersioImprible(
            @PathVariable("transaccioID") java.lang.Long transaccioID,
            HttpServletRequest request, HttpServletResponse response)
            throws I18NException, IOException {

        final String format = PDF;
        TipusFile tipusFile = TipusFile.VERSIO_IMPRIMIBLE;

        internalDownload(transaccioID, response, format, tipusFile);

    }

    private void prepareAndDownload(byte[] data, HttpServletResponse response,
            TransaccioJPA transaccio, String format) {

        // s'eliminen els espais en el cas de noms de transaccions amb més d'una paraula, així
        // queda només el nom amb una paraula
        // motiu: no se li afegia l'extensió correctament al document descarregat
        String documentName = transaccio.getNom().replace(" ", "_");

        if (format.equals(PDF)) {
            response.setContentType("application/pdf");

            if (documentName != null && !documentName.toLowerCase().endsWith(".pdf")) {
                documentName += ".pdf";
            }

        } else if (format.equals(ENI)) {
            response.setContentType("text/xml");

            if (documentName != null && !documentName.toLowerCase().endsWith(".xml")) {
                documentName += ".xml";
            }
        }
        response.setHeader("Content-disposition", "attachment; filename=" + documentName);
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

            delete = canBeDeleted(isAdmin, (TransaccioJPA) transaccio);

            if (transaccio.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_OK) {
                // Afegir boto de Descarrega de document escanejat o de versio imprimible
                // segons si es escaneig o copia autentica

                Perfil perfil = perfilLogicaEjb.findByPrimaryKey(transaccio.getPerfilID());

                switch (perfil.getUsPerfil()) {
                    case Constants.PERFIL_US_CUSTODIA_INFO:
                        AdditionalButton addOriginalButton = new AdditionalButton(
                                IconUtils.getWhite(IconUtils.ICON_FILE_DOWNLOAD),
                                "transaccio.descarregar.firmat",
                                getContextWeb() + "/descarregaroriginal/{0}",
                                "btn-success\" target=\"_blank");
                        AdditionalButton addImprimibleButton = new AdditionalButton(
                                IconUtils.getWhite(IconUtils.ICON_PRINT), "transaccio.descarregar.imprimible",
                                getContextWeb() + "/descarregarimprimible/{0}",
                                "btn-success\" target=\"_blank");

                        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(),
                                addOriginalButton);
                        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(),
                                addImprimibleButton);

//                        if (isAdmin) {
                            AdditionalButton addEniButton = new AdditionalButton(
                                    IconUtils.getWhite(IconUtils.ICON_FILE), "transaccio.descarregar.enidoc",
                                    getContextWeb() + "/descarregarenidoc/{0}",
                                    "btn-success\" target=\"_blank");

                            filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(),
                                    addEniButton);
//                        }
                    break;
                    case Constants.PERFIL_US_COPIA_AUTENTICA_INFO:
                        AdditionalButton addFirmatButton = new AdditionalButton(
                                IconUtils.getWhite(IconUtils.ICON_FILE_DOWNLOAD),
                                "transaccio.descarregar.firmat",
                                getContextWeb() + "/descarregarfirmat/{0}", "btn-success");
                        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(),
                                addFirmatButton);

                    break;
                    default: // cas de PERFIL_US_NOMES_ESCANEIG_INFO
                        AdditionalButton addEscaneigButton = new AdditionalButton(
                                IconUtils.getWhite(IconUtils.ICON_FILE_DOWNLOAD),
                                "transaccio.descarregar.escaneig",
                                getContextWeb() + "/descarregar/{0}", "btn-success");
                        filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(),
                                addEscaneigButton);
                    break;
                }

            }

            if (delete) {
                AdditionalButton additionalButton = new AdditionalButton(
                        IconUtils.getWhite(IconUtils.ICON_TRASH), "genapp.delete",
                        "javascript:openModal('" + request.getContextPath() + getContextWeb()
                                + "/" + transaccio.getTransaccioID() + "/delete','show');",
                        "btn-danger");

                filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(),
                        additionalButton);
            } 

            if (!isAdmin && transaccio.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_OK) {

                AdditionalButton additionalButton = new AdditionalButton(
                        IconUtils.getWhite(IconUtils.ICON_ENVELOPE), "enviar.email",
                        "javascript:enviarEmail(" + transaccio.getTransaccioID() + ", 'show')",
                        "btn-warning");

                filterForm.addAdditionalButtonByPK(transaccio.getTransaccioID(),
                        additionalButton);

            }
            
            

        }
        
        postListNomPersonaAplicacio(request, filterForm, list, isAdmin);
        
        
       

    }

    protected void postListNomPersonaAplicacio(HttpServletRequest request,
            TransaccioFilterForm filterForm, List<Transaccio> list, final boolean isAdmin)
            throws I18NException {

    }

    public static final String AGRUPA_PER_TRANSACCIO_MULTIPLE = "/transaccionsMultiples";

    @RequestMapping(value = AGRUPA_PER_TRANSACCIO_MULTIPLE
            + "/{transaccioMultipleID}", method = RequestMethod.GET)
    public ModelAndView agrupaPerTransaccioMultiple(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("transaccioMultipleID") java.lang.Long transaccioMultipleID)
            throws IOException, I18NException {

        log.info(" XYZ ZZZ ENTRA A AGRUPA_PER_TRANSACCIO_MULTIPLE ... [" + transaccioMultipleID
                + "] ");

        TransaccioFilterForm filterForm = getTransaccioFilterForm(null, null, request);

        ArrayList<Field<?>> filterByFields = new ArrayList<Field<?>>();
        filterByFields.add(TRANSACCIOMULTIPLEID);

        filterForm.setFilterByFields(filterByFields);

        filterForm.setTransaccioMultipleIDDesde(transaccioMultipleID);
        filterForm.setTransaccioMultipleIDFins(transaccioMultipleID);

        request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

        return new ModelAndView(new RedirectView(getContextWeb() + "/list", true));

    }

    @RequestMapping(value = "/listreset", method = RequestMethod.GET)
    public ModelAndView llistatInicialSenseAgrupaPerTransaccioMultiple(
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, I18NException {

        TransaccioFilterForm filterForm = getTransaccioFilterForm(null, null, request);

        List<Field<?>> list = filterForm.getFilterByFields();
        if (list != null && list.contains(TRANSACCIOMULTIPLEID)) {
            list.remove(TRANSACCIOMULTIPLEID);
        }
        filterForm.setTransaccioMultipleIDDesde(null);
        filterForm.setTransaccioMultipleIDFins(null);

        return new ModelAndView(new RedirectView(getContextWeb() + "/list", true));

    }


    /**
     * 
     * @param isAdmin
     * @param transaccio
     * @return
     */
    protected boolean canBeDeleted(final boolean isAdmin, Transaccio transaccio) {

        final int codi = transaccio.getEstatCodi(); 
        if (codi == ScanWebSimpleStatus.STATUS_CANCELLED
           || codi == ScanWebSimpleStatus.STATUS_EXPIRED
           || codi == ScanWebSimpleStatus.STATUS_FINAL_ERROR) {
            return true;
        }
        
        if (codi == ScanWebSimpleStatus.STATUS_IN_PROGRESS
           || codi == ScanWebSimpleStatus.STATUS_REQUESTED_ID) {
            
            final long ONE_DAY_IN_MS = 86_400_000;
            
            if (System.currentTimeMillis() - transaccio.getDataInici().getTime() > ONE_DAY_IN_MS) {
                return true;
            }
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

    @Override
    public List<StringKeyValue> getReferenceListForUsuariAplicacioId(
            HttpServletRequest request, ModelAndView mav, TransaccioForm transaccioForm,
            Where where) throws I18NException {
        if (transaccioForm.isHiddenField(USUARIAPLICACIOID)) {
            return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
        }
        List<StringKeyValue> l = getReferenceListForUsuariAplicacioId(request, mav, where);
        if (l.size() != 1) {
            String app = String.valueOf(transaccioForm.getTransaccio().getUsuariAplicacioId());
            l.add(new StringKeyValue(app, app));
        }
        return l;
    }

    @Override
    public List<StringKeyValue> getReferenceListForUsuariAplicacioId(
            HttpServletRequest request, ModelAndView mav,
            TransaccioFilterForm transaccioFilterForm, List<Transaccio> list,
            Map<Field<?>, GroupByItem> _groupByItemsMap, Where where) throws I18NException {
        if (transaccioFilterForm.isHiddenField(USUARIAPLICACIOID)
                && !transaccioFilterForm.isGroupByField(USUARIAPLICACIOID)) {
            return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
        }

        Where _w = null;
        List<StringKeyValue> l = getReferenceListForUsuariAplicacioId(request, mav,
                Where.AND(where, _w));

        if (l.size() != list.size()) {
            Map<String, String> map = org.fundaciobit.genapp.common.utils.Utils.listToMap(l);
            for (Transaccio transaccio : list) {

                final String key = String.valueOf(transaccio.getUsuariAplicacioId());

                String value = map.get(key);

                if (value == null) {
                    l.add(new StringKeyValue(key, key));
                }
            }

        }

        return l;
    }

    @Override
    public List<StringKeyValue> getReferenceListForUsuariAplicacioId(
            HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {

        SelectMultipleKeyValue<Long> select = new SelectMultipleKeyValue<Long>(
                UsuariAplicacioFields.USUARIAPLICACIOID.select,
                UsuariAplicacioFields.USERNAME.select);
        List<KeyValue<Long>> list = this.usuariAplicacioEjb.executeQuery(select, where);
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        for (KeyValue<Long> keyValue : list) {
            String value = keyValue.getValue();
            String key = String.valueOf(keyValue.getKey());
            __tmp.add(new StringKeyValue(key,
                    (value == null || (value.trim().length() == 0)) ? key : value));
        }

        return __tmp;
    }

    @Override
    public List<StringKeyValue> getReferenceListForUsuariPersonaId(HttpServletRequest request,
            ModelAndView mav, TransaccioForm transaccioForm, Where where)
            throws I18NException {
        if (transaccioForm.isHiddenField(USUARIPERSONAID)) {
            return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
        }
        List<StringKeyValue> l = getReferenceListForUsuariPersonaId(request, mav, where);
        if (l.size() != 1) {
            String usr = String.valueOf(transaccioForm.getTransaccio().getUsuariPersonaId());
            l.add(new StringKeyValue(usr, usr));
        }
        return l;
    }

    @Override
    public List<StringKeyValue> getReferenceListForUsuariPersonaId(HttpServletRequest request,
            ModelAndView mav, TransaccioFilterForm transaccioFilterForm, List<Transaccio> list,
            Map<Field<?>, GroupByItem> _groupByItemsMap, Where where) throws I18NException {
        if (transaccioFilterForm.isHiddenField(USUARIPERSONAID)
                && !transaccioFilterForm.isGroupByField(USUARIPERSONAID)) {
            return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
        }
        Where _w = null;
        List<StringKeyValue> l = getReferenceListForUsuariPersonaId(request, mav,
                Where.AND(where, _w));

        if (l.size() != list.size()) {
            Map<String, String> map = org.fundaciobit.genapp.common.utils.Utils.listToMap(l);
            for (Transaccio transaccio : list) {

                final String key = String.valueOf(transaccio.getUsuariPersonaId());

                String value = map.get(key);

                if (value == null) {
                    l.add(new StringKeyValue(key, key));
                }
            }

        }

        return l;
    }

    @Override
    public List<StringKeyValue> getReferenceListForUsuariPersonaId(HttpServletRequest request,
            ModelAndView mav, Where where) throws I18NException {
        SelectMultipleKeyValue<Long> select = new SelectMultipleKeyValue<Long>(
                UsuariPersonaFields.USUARIPERSONAID.select,
                UsuariPersonaFields.USERNAME.select);
        List<KeyValue<Long>> list = this.usuariPersonaEjb.executeQuery(select, where);
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        for (KeyValue<Long> keyValue : list) {
            String value = keyValue.getValue();
            String key = String.valueOf(keyValue.getKey());
            __tmp.add(new StringKeyValue(key,
                    (value == null || (value.trim().length() == 0)) ? key : value));
        }

        return __tmp;
    }
    
    
    
    @Override
    public void postValidate(HttpServletRequest request, TransaccioForm transaccioForm,
            BindingResult result) throws I18NException {
        
        super.postValidate(request, transaccioForm, result);


    }
    
    

    @RequestMapping(value = THUMBNAIL_PDF_MASSIVE + "/{transaccioWebID}", method = RequestMethod.GET)
    public void createThumbnailPdf(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("transaccioWebID") String transaccioWebID) throws Exception, I18NException {

        long fitxerID = transaccioPublicEjb.executeQueryOne(FITXERESCANEJATID, TRANSACTIONWEBID.equal(transaccioWebID));

        PDDocument document = null;
        try {
            File file = FileSystemManager.getFile(fitxerID);
            document = PDDocument.load(file);
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            BufferedImage bim = pdfRenderer.renderImage(0, 0.5f);

            BufferedImage scaled = scale(bim, 350);

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", -1); // Proxies.

            ImageIO.write(scaled, "PNG", response.getOutputStream());

        } finally {
            if (document != null) {
                document.close();
            }
        }

    }

    public static BufferedImage scale(BufferedImage image, int max) {

        int width = image.getWidth(null);
        int height = image.getHeight(null);
        double dWidth = 0;
        double dHeight = 0;
        if (width == height) {
            dWidth = max;
            dHeight = max;
        } else if (width > height) {
            dWidth = max;
            dHeight = ((double) height / (double) width) * max;
        } else {
            dHeight = max;
            dWidth = ((double) width / (double) height) * max;
        }
        Image scaled = image.getScaledInstance((int) dWidth, (int) dHeight, Image.SCALE_SMOOTH);

        return toBufferedImage(scaled);

    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }


}
