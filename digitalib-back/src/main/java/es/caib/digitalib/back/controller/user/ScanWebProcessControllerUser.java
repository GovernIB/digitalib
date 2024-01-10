package es.caib.digitalib.back.controller.user;


import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuOptionalParameters;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleSignatureParameters;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.back.controller.AbstractTransaccioController;
import es.caib.digitalib.back.form.ScanWebConfigForm;
import es.caib.digitalib.back.form.ScanWebConfigValidator;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.persistence.ConfiguracioGrupJPA;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.persistence.UsuariPersonaJPA;
import es.caib.digitalib.logic.ConfiguracioGrupLogicaService;
import es.caib.digitalib.logic.ScanWebModuleService;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 *
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = ScanWebProcessControllerUser.CONTEXTWEB)
@SessionAttributes(types = { ScanWebConfigForm.class })
public class ScanWebProcessControllerUser extends AbstractScanWebProcessController {

    public static final String CONTEXTWEB = "/user/scan";

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariPersonaService usuariPersonaEjb;

    @EJB(mappedName = ConfiguracioGrupLogicaService.JNDI_NAME)
    protected ConfiguracioGrupLogicaService configuracioGrupLogicaEjb;

    // XYZ ZZZ Eliminar
    @Autowired
    protected ScanWebConfigValidator scanWebValidator;

    @EJB(mappedName = ScanWebModuleService.JNDI_NAME)
    protected ScanWebModuleService scanWebModuleEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilService perfilEjb;

    /**
     * 
     */
    public ScanWebProcessControllerUser() {
        super();
    }

    public static final String SCANWEB_SESSION_BASEURL = "SCANWEB_SESSION_BASEURL";

    public static final String SCANWEB_SESSION_TIPUSPERFIL = "SCANWEB_SESSION_TIPUSPERFIL";

    public static final String SCANWEB_SESSION_TRANSACCIO = "SCANWEB_SESSION_TRANSACCIO";
    
    
    
    
    @RequestMapping(value = "/separator", method = RequestMethod.GET)
    public void downloadSeparator(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        MassiveScanWebSimpleFile separador=  transaccioLogicaEjb.getSeparator();

        try {
            byte[] data = separador.getData();
            response.setContentType(Constants.MIME_PDF);
            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + separador.getNom()
                    + "\"");
            response.setContentLength(data.length);

            OutputStream output = response.getOutputStream();
            output.write(data);
            output.close();

        } catch (Exception e) {
            String msg = "Error descarregant separador: " + e.getMessage();
            log.error(msg, e);
            response.setHeader("MsgDigitalIB", msg);
            try {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException e1) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }

    }


    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public ModelAndView scanWebGet(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("perfil_tipus") int tipusPerfil, @RequestParam("perfil_pos") int pos,
            @RequestParam("url_user") String baseUrlFull) throws Exception {

        log.info("XYZ ZZZ baseUrlFull = " + baseUrlFull);

        log.info("XYZ ZZZ Tipus Perfil = " + tipusPerfil);

        log.info("XYZ ZZZ POS Perfil = " + pos);

        try {

            // XYZ ZZZ Llegir-ho de LoginINfo
            // Usuari Té configuració de grup assignada

            final String username = LoginInfo.getInstance().getUsername();

            log.info("XYZ ZZZ Username = " + username);

            Long usuariPersonaID = usuariPersonaEjb.executeQueryOne(
                    UsuariPersonaFields.USUARIPERSONAID,
                    UsuariPersonaFields.USERNAME.equal(username));

            log.info("XYZ ZZZ usuariPersonaID = " + usuariPersonaID);
            if (usuariPersonaID == null) {
                // XYZ ZZZ Traduir
                HtmlUtils.saveMessageError(request,
                        I18NUtils.tradueix("scanwebget.usuari.noinfo"));
                ModelAndView mav = new ModelAndView(
                        new RedirectView("/canviarPipella/user", true));
                return mav;
            }

            UsuariPersonaJPA usuariPersona = usuariPersonaEjb
                    .findByPrimaryKey(usuariPersonaID);

            Long configGrupID = usuariPersona.getConfiguracioGrupID();

            if (configGrupID == null) {
                HtmlUtils.saveMessageError(request,
                        I18NUtils.tradueix("scanwebget.usuari.nogrup"));
                ModelAndView mav = new ModelAndView(
                        new RedirectView("/canviarPipella/user", true));
                return mav;
            }

            ConfiguracioGrupJPA configGrup = configuracioGrupLogicaEjb
                    .findByPrimaryKeyFull(configGrupID);

            Long perfilID;
            switch (tipusPerfil) {
                case Constants.PERFIL_US_NOMES_ESCANEIG:
                    perfilID = (pos == 1) ? configGrup.getPerfilNomesEscaneigID()
                            : configGrup.getPerfilNomesEscaneig2ID();
                break;

                case Constants.PERFIL_US_COPIA_AUTENTICA:
                    perfilID = (pos == 1) ? configGrup.getPerfilCopiaAutenticaID()
                            : configGrup.getPerfilCopiaAutentica2ID();
                break;

                case Constants.PERFIL_US_CUSTODIA:
                    perfilID = (pos == 1) ? configGrup.getPerfilCustodiaID()
                            : configGrup.getPerfilCustodia2ID();
                break;

                default:
                    HtmlUtils.saveMessageError(request, I18NUtils.tradueix(
                            "scanwebget.perfil.desconegut", String.valueOf(tipusPerfil)));
                    ModelAndView mav = new ModelAndView(new RedirectView(
                            request.getContextPath() + "/canviarPipella/user", false));
                    return mav;
            }

            PerfilJPA perfil = perfilEjb.findByPrimaryKey(perfilID);

            final String scanWebProfileCodi = perfil.getCodi();
            // perfilEjb.executeQueryOne(PerfilFields.CODI,
            // PerfilFields.PERFILID.equal(perfilID));

            log.info("PERFIL CODI = " + scanWebProfileCodi);

            final int view = ScanWebSimpleGetTransactionIdRequest.VIEW_IFRAME;
            Locale locale = LocaleContextHolder.getLocale();
            final String languageUI = locale.getLanguage();

            final String funcionariUsername = username;

            ScanWebSimpleGetTransactionIdRequest requestTransaction;
            requestTransaction = new ScanWebSimpleGetTransactionIdRequest(scanWebProfileCodi,
                    view, languageUI, funcionariUsername);

            if (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA
                    || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {
                // Establir informacio de Firma

                /* XYZ ZZZ AIXÒ JA HO OBTINDREM EN PAGINES POSTERIORS */
                final String languageDoc = null;

                UsuariPersona up = LoginInfo.getInstance().getUsuariPersona();

                String funcionariNom = up.getNom() + " " + up.getLlinatges();
                String funcionariNif = up.getNif();

                ScanWebSimpleSignatureParameters signatureParameters = new ScanWebSimpleSignatureParameters(
                        languageDoc, funcionariNom, funcionariNif);

                requestTransaction.setSignatureParameters(signatureParameters);

            }

            if (tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

                /*
                 * XYZ ZZZ AIXÔ JA HO OBTINDREM EN PAGINES POSTERIORS
                 * ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
                 * arxiuRequiredParameters = new ScanWebSimpleArxiuRequiredParameters(
                 * LogicUtils.stringToListString(parametresFirmaArxiu.
                 * getArxiuReqParamInteressats()),
                 * parametresFirmaArxiu.getArxiuReqParamOrigen(),
                 * parametresFirmaArxiu.getArxiuReqParamDocEstatElabora(),
                 * parametresFirmaArxiu.getArxiuReqParamDocumentTipus());
                 * 
                 * requestTransaction.setArxiuRequiredParameters(arxiuRequiredParameters);
                 */

                // Arxiu Optional Parameters

                if (perfil.getPluginArxiuID() != null
                        || perfil.getPluginDocCustodyID() != null) {
                    // S'utilitza Arxiu enlloc de Custody. Necessitam aquests valors

                    // Els tenc que obtenir dels parametres del plugin
                    Properties prop;
                    if (perfil.getPluginArxiuID() != null) {
                        long pluginArxiuID = perfil.getPluginArxiuID();

                        Plugin pluginArxiuJPA = pluginArxiuLogicaEjb
                                .findByPrimaryKey(pluginArxiuID);

                        String propertiesStr = pluginArxiuJPA.getProperties();
                        prop = LogicUtils.stringToProperties(propertiesStr);
                    } else {
                        long pluginCustodyID = perfil.getPluginDocCustodyID();

                        Plugin pluginDocCustodyJPA = pluginDocumentcustodyLogicaEjb
                                .findByPrimaryKey(pluginCustodyID);

                        String propertiesStr = pluginDocCustodyJPA.getProperties();
                        prop = LogicUtils.stringToProperties(propertiesStr);
                    }

                    String procedimentNom = prop.getProperty(
                            TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM.javaName);
                    String procedimentCodi = prop.getProperty(
                            TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI.javaName);
                    String serieDocumental = prop.getProperty(
                            TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL.javaName);
                    String custodyOrExpedientID = prop.getProperty(
                            TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID.javaName);

                    if (procedimentNom == null && procedimentCodi == null
                            && serieDocumental == null && custodyOrExpedientID == null) {
                        // SI tot val null no feim res
                    } else {
                        ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;
                        arxiuOptionalParameters = new ScanWebSimpleArxiuOptionalParameters(
                                procedimentNom, procedimentCodi, serieDocumental,
                                custodyOrExpedientID);

                        requestTransaction.setArxiuOptionalParameters(arxiuOptionalParameters);
                    }

                }

            }

            URL url = new URL(baseUrlFull);

            String port;
            if (url.getPort() == -1) {
                port = "";
            } else {
                port = ":" + url.getPort();
            }

            String baseUrl = url.getProtocol() + "://" + url.getHost() + port
                    + request.getContextPath();
            log.info("XYZ ZZZ  baseUrl OK = " + baseUrl);

            String urlRetorn = baseUrl + "/user/llistatperfilsdisponibles";

            String ip = request.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                ip = request.getRemoteAddr();
            }

            TransaccioJPA transaction = transaccioLogicaEjb.crearTransaccio(requestTransaction,
                    null, usuariPersona, baseUrl, urlRetorn, ip);

            final String transactionWebID = transaction.getTransactionWebId();

            auditCreateTransaction(usuariPersona, transaction);

            // TODO per ara està buit
            final boolean isPublic = false;

            final String urlFinal = getFinalURL(baseUrl, transactionWebID, isPublic);

            log.info("XYZ ZZZ WEB USER urlFinal OK = " + urlFinal);

            // final String urlFinal = urlBase + SCANWEB_CONTEXTPATH +
            // SCANWEB_CONTEXTPATH_FINAL +
            // "/"
            // + transactionWebID;

            // ScanWebConfig swc = ScanWebUtils.generateScanWebConfig(transaction, urlFinal);

            // final boolean fullView = (transaction.getView() ==
            // ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN);

            ModelAndView mav = startScanWebProcess(request, response, transaction, isPublic,
                    urlFinal, baseUrl);
            // XYZ ZZZ
            // , swc, baseUrl,
            // AbstractScanWebModuleController.getContextWeb(isPublic),
            // fullView);

            // Obtenir ConfiguracioGrup amb detalls de Perfils

            return mav;

        } catch (I18NException e) {

            e.printStackTrace();

            HtmlUtils.saveMessageError(request,
                    I18NUtils.tradueix("scanwebget.error.general") + I18NUtils.getMessage(e));
            ModelAndView mav = new ModelAndView(new RedirectView(
                    request.getContextPath() + "/canviarPipella/user", false));
            return mav;
        }

    }

    protected void auditCreateTransaction(UsuariPersonaJPA usuariPersona,
            TransaccioJPA transaccio) throws I18NException {
        final boolean isApp = isPublic();

        final String additionalInfo = "IP: " + transaccio.getIp() + "\n" + "Username: "
                + usuariPersona.getUsername() + "\n" + "TransacctionWebID: "
                + transaccio.getTransactionWebId() + "\n" + "Tipus Transacció: "
                + I18NUtils.tradueix(new Locale("ca"),
                        "transaccio.tipus." + Math.abs(transaccio.getPerfil().getUsPerfil()));

        final int auditType = Constants.AUDIT_TYPE_CREATE_TRANSACTION;

        final String msg = I18NUtils.tradueix("transaccio.aplicacio.crear",
                String.valueOf(transaccio.getTransaccioID()));
        auditoriaLogicaEjb.audita(transaccio, isApp, msg, additionalInfo, auditType, null,
                usuariPersona.getUsername());

    }

    @Override
    protected ModelAndView finalProcesDeScanWeb(HttpServletRequest request,
            String transactionWebID) throws I18NException, Exception {

        log.info(" ENTRA A  finalProcesDeScanWeb de USER");

        ModelAndView mav = super.finalProcesDeScanWeb(request, transactionWebID);

        log.info(" POST de cridada a super.finalProcesDeScanWeb de USER");

        if (!Configuracio.isAllowedMassiveScanInWeb()) {

            TransaccioJPA transaccio = transaccioLogicaEjb
                    .searchTransaccioByTransactionWebID(transactionWebID);

            int status = transaccio.getEstatCodi();

            log.info(" STATUS => " + status);

            if (status == ScanWebSimpleStatus.STATUS_FINAL_OK) {

                HtmlUtils.saveMessageSuccess(request,
                        I18NUtils.tradueix("scanwebget.operacio.ok"));
                /*
                 * switch (transaccio.getPerfil().getUsPerfil()) { case
                 * Constants.PERFIL_US_NOMES_ESCANEIG_INFO: mav.addObject("urlRetorn",
                 * request.getContextPath() + "/user/transaccio/nomesescaneig/view/" +
                 * transaccio.getTransaccioID()); break; case
                 * Constants.PERFIL_US_COPIA_AUTENTICA_INFO: mav.addObject("urlRetorn",
                 * request.getContextPath() + "/user/transaccio/copiaautentica/view/" +
                 * transaccio.getTransaccioID()); break; case
                 * Constants.PERFIL_US_CUSTODIA_INFO: if (Configuracio.isCAIB()) {
                 * mav.addObject("urlRetorn", request.getContextPath() +
                 * "/user/transaccio/custodia/list/"); } else { mav.addObject("urlRetorn",
                 * request.getContextPath() + "/user/transaccio/custodia/view/" +
                 * transaccio.getTransaccioID()); } break;
                 * 
                 * default: throw new
                 * Exception(I18NUtils.tradueix("scanwebget.operacio.error")); }
                 */
            } else {

                if (transaccio.getEstatMissatge() == null) {

                    switch (status) {
                        case ScanWebSimpleStatus.STATUS_IN_PROGRESS:
                            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
                            transaccio.setEstatMissatge(I18NUtils
                                    .tradueix("scanwebget.operacio.inconsistent.progress"));
                        break;
                        case ScanWebSimpleStatus.STATUS_EXPIRED:
                            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
                            transaccio.setEstatMissatge(I18NUtils
                                    .tradueix("scanwebget.operacio.inconsistent.expirat"));
                        break;
                        case ScanWebSimpleStatus.STATUS_REQUESTED_ID:
                            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
                            String msg = I18NUtils
                                    .tradueix("scanwebget.operacio.inconsistent.requested");
                            transaccio.setEstatMissatge(msg);
                        // PROVAR D'ON VE PER INTENTAR POSAR l'ESTAT !!!!!!
                        // log.error("XMASSOFT " + msg, new Exception());
                        break;
                        case ScanWebSimpleStatus.STATUS_CANCELLED: // OK break;

                        default:
                            transaccio.setEstatMissatge(I18NUtils.tradueix(
                                    "scanwebget.operacio.desconegut", String.valueOf(status)));
                    }
                    transaccioLogicaEjb.update(transaccio);

                }

                HtmlUtils.saveMessageError(request, transaccio.getEstatMissatge());
            }

        }
        return mav;
    }

    @Override
    protected ModelAndView returnToOrigen(HttpServletRequest request, TransaccioJPA transaccio)
            throws I18NException {

        final long countTransactions;
        final long countTransactionsOK;        
        Long transMultipleID = transaccio.getTransaccioMultipleID();

        if (transMultipleID == null) {
            countTransactions = 1;
            countTransactionsOK = 1;
        } else {
            Long[] resum = transaccioLogicaEjb
                    .countTransaccionsByTransaccioMultipleID(transMultipleID);
            if (resum == null) {
                countTransactions = 1;
                countTransactionsOK = 1;
            } else {
                countTransactions = resum[0];
                countTransactionsOK = resum[1];
            }
        }
        
        if (countTransactions == countTransactionsOK) {
            HtmlUtils.saveMessageSuccess(request,
                    I18NUtils.tradueix("scanwebget.operacio.ok"));
        } else {
            String code;
            if (countTransactions == 1) {
               code = "scanwebget.operacio.errorsubtransaccio"; 
            } else {
               code = "scanwebget.operacio.erroralgunasubtransaccio";
            }
            HtmlUtils.saveMessageWarning(request,
                    I18NUtils.tradueix(code));
        }
        

        String r;
        switch (transaccio.getPerfil().getUsPerfil()) {
            case Constants.PERFIL_US_NOMES_ESCANEIG_INFO: {
                String base = request.getContextPath() + "/user/transaccio/nomesescaneig";
                
                log.info(" PERFIL NOMES ESCANEIG: { countTransactions : " + countTransactions + "}");
                
                if (countTransactions == 1) {
                    r = base + "/view/" + transaccio.getTransaccioID();
                } else {
                    r = base + AbstractTransaccioController.AGRUPA_PER_TRANSACCIO_MULTIPLE
                            + "/" + transMultipleID;
                }
            }
            break;
            case Constants.PERFIL_US_COPIA_AUTENTICA_INFO: {
                String base = request.getContextPath() + "/user/transaccio/copiaautentica";
                if (countTransactions == 1) {
                    r = base + "/view/" + transaccio.getTransaccioID();
                } else {
                    r = base + AbstractTransaccioController.AGRUPA_PER_TRANSACCIO_MULTIPLE
                            + "/" + transMultipleID;
                }
            }
            break;
            case Constants.PERFIL_US_CUSTODIA_INFO:
            /*
             * if (Configuracio.isCAIB()) { r = request.getContextPath() +
             * "/user/transaccio/custodia/list/"; } else { r = request.getContextPath() +
             * "/user/transaccio/custodia/view/" + transaccio.getTransaccioID(); }
             */

            {
                String base = request.getContextPath() + "/user/transaccio/custodia";
                if (countTransactions == 1) {
                    if (Configuracio.isCAIB()) {
                        r = base + "/list";
                    } else {
                        r = base + "/view/" + transaccio.getTransaccioID();
                    }
                } else {
                    r = base + AbstractTransaccioController.AGRUPA_PER_TRANSACCIO_MULTIPLE
                            + "/" + transMultipleID;
                }
            }

            break;

            default:
                log.error("S'ha rebut un getUsPerfil() desconegut: "
                        + transaccio.getPerfil().getUsPerfil());
                throw new I18NException("scanwebget.operacio.error");
        }

        ModelAndView mav = new ModelAndView("finalsortiriframe");

        mav.addObject("urlRetorn", r);

        return mav;

    }

    @InitBinder("scanWebForm")
    public void initBinder(WebDataBinder binder) {

        binder.setValidator(this.scanWebValidator);

        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

    }

    @Override
    public boolean isPublic() {
        return false;
    }

}