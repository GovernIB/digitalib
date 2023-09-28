package es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleProfileRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.ApiMassiveScanWebSimple;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuInfo;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfiles;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleCustodyInfo;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleKeyValue;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResultRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResult;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleScannedFileInfo;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSignedFileInfo;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStartTransactionRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubTransactionsOfTransaction;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleValidationInfo;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NTranslation;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.SubQuery;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.fundaciobit.pluginsib.core.utils.MetadataConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.caib.digitalib.back.controller.all.ScanWebProcessControllerPublic;
import es.caib.digitalib.back.controller.scanwebsimple.RestApiScanWebUtils;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.persistence.InfoSignaturaJPA;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.persistence.UsuariAplicacioJPA;
import es.caib.digitalib.logic.AuditoriaLogicaService;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.ScanWebUtils;
import es.caib.digitalib.model.bean.AuditoriaBean;
import es.caib.digitalib.model.entity.Auditoria;
import es.caib.digitalib.model.entity.Metadada;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.model.fields.MetadadaFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 * Created 19/11/18 10:10
 *
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = RestApiMassiveScanWebSimpleV1Controller.CONTEXT)
public class RestApiMassiveScanWebSimpleV1Controller extends RestApiScanWebUtils
        implements ApiMassiveScanWebSimple {

    public static final String CONTEXT = "/common/rest/apimassivescanwebsimple/v1";


    @EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilService perfilEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilUsuariAplicacioService perfilUsuariAplicacioEjb;

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @EJB(mappedName = AuditoriaLogicaService.JNDI_NAME)
    protected AuditoriaLogicaService auditoriaLogicaEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.MetadadaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.MetadadaService metadadaEjb;


    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETSEPARATORPAGE, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getSeparatorPageRest(@RequestBody String locale) {

        RestCaller<MassiveScanWebSimpleFile> restCaller = new RestCaller<MassiveScanWebSimpleFile>(
                locale) {
            public MassiveScanWebSimpleFile cridadaReal() throws Exception {
                return getSeparatorPage(this.locale);
            };
        };

        return restCaller.cridada();

        /*
         * try {
         * 
         * String error = autenticate(request, locale, usuariAplicacioEjb); if (error != null)
         * { return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * MassiveScanWebSimpleFile fsap = getSeparatorPage(locale);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> re = new
         * ResponseEntity<MassiveScanWebSimpleFile>(fsap, headers, HttpStatus.OK);
         * 
         * return re;
         * 
         * } catch (Throwable th) { String msg = th.getMessage(); log.error(msg, th); return
         * generateServerError(msg, th); }
         */

    }

    @Override
    public MassiveScanWebSimpleFile getSeparatorPage(String locale) throws Exception {

        byte[] data = getSeparador();

        MassiveScanWebSimpleFile msf = new MassiveScanWebSimpleFile(
                SEPARADOR_ESCANEIG_MASSIU_NOM, Constants.MIME_PDF, data);

        return msf;
    }

    public static final String SEPARADOR_ESCANEIG_MASSIU_NOM = "separador_escanig_massiu.pdf";

    public static byte[] getSeparador() throws Exception, IOException {
        // XYZ ZZZ Tenir aquest fitxer en memòria cache ??????

        InputStream is = RestApiMassiveScanWebSimpleV1Controller.class.getClassLoader()
                .getResourceAsStream(SEPARADOR_ESCANEIG_MASSIU_NOM);

        if (is == null) {
            // XYZ ZZZ TRA
            throw new Exception("No puc carregar el fitxer " + SEPARADOR_ESCANEIG_MASSIU_NOM
                    + " dels recursos.");
        }
        byte[] data = FileUtils.toByteArray(is);
        is.close();
        return data;
    }

    

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETAVAILABLEPROFILES, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getAvailableProfilesRest(@RequestBody String locale) {

        RestCaller<MassiveScanWebSimpleAvailableProfiles> restCaller = new RestCaller<MassiveScanWebSimpleAvailableProfiles>(
                locale) {
            @Override
            public MassiveScanWebSimpleAvailableProfiles cridadaReal() throws Exception {
                return getAvailableProfiles(this.locale);
            }
        };

        return restCaller.cridada();

        /*
         * try {
         * 
         * String error = autenticate(request, locale, usuariAplicacioEjb); if (error != null)
         * { return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * MassiveScanWebSimpleAvailableProfiles fsap = getAvailableProfiles(locale);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> re = new
         * ResponseEntity<MassiveScanWebSimpleAvailableProfiles>(fsap, headers, HttpStatus.OK);
         * 
         * return re;
         * 
         * 
         * } catch (Throwable th) { String msg = th.getMessage(); log.error(msg, th); return
         * generateServerError(msg, th); }
         */

    }

    /**
     * 
     * @param locale
     * @return
     * @throws Exception
     */
    @Override
    public MassiveScanWebSimpleAvailableProfiles getAvailableProfiles(String locale)
            throws Exception {

        try {

            RestLoginInfo restLoginInfo = commonChecks();

            LoginInfo loginInfo = restLoginInfo.loginInfo;

            log.info(" XYZ ZZZ LOGININFO => " + loginInfo);

            // Checks Globals
            if (loginInfo.getUsuariPersona() != null) {
                throw new Exception(I18NUtils.tradueix("excepcio.nomes.usuariapp"));
            }

            // Checks usuari aplicacio
            UsuariAplicacioJPA usuariAplicacio = loginInfo.getUsuariAplicacio();
            log.info(" XYZ ZZZ Usuari-APP = " + usuariAplicacio);
            long usuariAplicacioID = usuariAplicacio.getUsuariAplicacioID();

            SubQuery<PerfilUsuariAplicacio, Long> subquery = perfilUsuariAplicacioEjb
                    .getSubQuery(PerfilUsuariAplicacioFields.PERFILID,
                            PerfilUsuariAplicacioFields.USUARIAPLICACIOID
                                    .equal(usuariAplicacioID));

            List<Perfil> perfils = perfilEjb.select(PerfilFields.PERFILID.in(subquery));

            MassiveScanWebSimpleAvailableProfiles fsap = new MassiveScanWebSimpleAvailableProfiles();

            if (perfils != null && perfils.size() != 0) {

                List<MassiveScanWebSimpleAvailableProfile> list = new ArrayList<MassiveScanWebSimpleAvailableProfile>();

                for (Perfil p : perfils) {

                    PerfilJPA perfil = (PerfilJPA) p;
                    MassiveScanWebSimpleAvailableProfile ap = new MassiveScanWebSimpleAvailableProfile(
                            perfil.getCodi(), perfil.getNom().getTraduccio(locale).getValor(),
                            perfil.getDescripcio().getTraduccio(locale).getValor(),
                            perfil.getUsPerfil());
                    list.add(ap);
                }

                fsap.setAvailableProfiles(list);

            }

            return fsap;

        } catch (I18NException i18n) {
            throw new Exception(getMessageFromI18nException(locale, i18n));
        }
    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETPROFILE, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getProfileRest(
            @RequestBody final MassiveScanWebSimpleProfileRequest profileRequest)
            throws Exception {

        String locale;
        if (profileRequest == null || profileRequest.getLocale() == null) {
            locale = "ca";
        } else {
            locale = profileRequest.getLocale();
        }

        RestCaller<MassiveScanWebSimpleAvailableProfile> restCaller = new RestCaller<MassiveScanWebSimpleAvailableProfile>(
                locale) {
            @Override
            public MassiveScanWebSimpleAvailableProfile cridadaReal() throws Exception {
                return getProfile(profileRequest);
            }
        };

        return restCaller.cridada();

        /*
         * 
         * String error = autenticate(request, locale, usuariAplicacioEjb); if (error != null)
         * { return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * try { MassiveScanWebSimpleAvailableProfile prof = getProfile(profileRequest);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> re = new
         * ResponseEntity<MassiveScanWebSimpleAvailableProfile>(prof, headers, HttpStatus.OK);
         * 
         * return re;
         * 
         * } catch (Throwable th) { String msg = th.getMessage(); log.error(msg, th); return
         * generateServerError(msg, th); }
         */
    }

    /**
     * 
     */
    @Override
    public MassiveScanWebSimpleAvailableProfile getProfile(
            MassiveScanWebSimpleProfileRequest profileRequest) throws Exception {
        try {

            RestLoginInfo restLoginInfo = commonChecks();

            LoginInfo loginInfo = restLoginInfo.loginInfo;

            log.info(" XYZ ZZZ LOGININFO => " + loginInfo);

            // Checks Globals
            if (loginInfo.getUsuariPersona() != null) {
                throw new Exception(I18NUtils.tradueix("excepcio.nomes.usuariapp"));
            }

            // Checks usuari aplicacio
            UsuariAplicacioJPA usuariAplicacio = loginInfo.getUsuariAplicacio();
            log.info(" XYZ ZZZ Usuari-APP = " + usuariAplicacio);
            long usuariAplicacioID = usuariAplicacio.getUsuariAplicacioID();

            SubQuery<PerfilUsuariAplicacio, Long> subquery = perfilUsuariAplicacioEjb
                    .getSubQuery(PerfilUsuariAplicacioFields.PERFILID,
                            PerfilUsuariAplicacioFields.USUARIAPLICACIOID
                                    .equal(usuariAplicacioID));

            List<Perfil> perfils = perfilEjb
                    .select(Where.AND(PerfilFields.CODI.equal(profileRequest.getProfileCode()),
                            PerfilFields.PERFILID.in(subquery)));

            MassiveScanWebSimpleAvailableProfile fsap = null;

            if (perfils != null && perfils.size() != 0) {

                String locale = profileRequest.getLocale();

                PerfilJPA perfil = (PerfilJPA) perfils.get(0);
                fsap = new MassiveScanWebSimpleAvailableProfile(perfil.getCodi(),
                        perfil.getNom().getTraduccio(locale).getValor(),
                        perfil.getDescripcio().getTraduccio(locale).getValor(),
                        perfil.getUsPerfil());

            }

            return fsap;

        } catch (I18NException i18n) {
            throw new Exception(getMessageFromI18nException(profileRequest.getLocale(), i18n));
        }
    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETTRANSACTIONID, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getTransactionIDRest(
            @RequestBody final MassiveScanWebSimpleGetTransactionIdRequest requestTransaction) {

        String language = "ca";

        RestCaller<String> restCaller = new RestCaller<String>(language) {
            @Override
            public String cridadaReal() throws Exception {
                return getTransactionID(requestTransaction);
            }
        };

        return restCaller.cridada();

        /*
         * String error = autenticate(request, language, usuariAplicacioEjb); if (error !=
         * null) { return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * try { String transactionWebID = getTransactionID(requestTransaction);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> res = new
         * ResponseEntity<String>(transactionWebID, headers, HttpStatus.OK);
         * 
         * return res; } catch (Throwable th) { String msg = th.getMessage(); log.error(msg,
         * th); return generateServerError(msg, th); }
         */
    }

    @Override
    public String getTransactionID(
            MassiveScanWebSimpleGetTransactionIdRequest requestTransaction) throws Exception {

        String language = "ca";

        // Fer neteja de transaccions Obsoletes !!!!
        try {
            cleanExpiredTransactions();
        } catch (I18NException e2) {
            String msg = I18NUtils.tradueix("error.neteja.traduccions.caducades")
                    + I18NLogicUtils.getMessage(e2, new Locale(language));

            log.error(msg, e2);

            throw new Exception(msg, e2);
        }

        // Check de requestTransactionID
        if (requestTransaction == null) {
            throw new Exception(I18NUtils.tradueix("error.entrada.parametre.null"));
        }

        // Valida NOm de la Transacció
        String transactionName = requestTransaction.getTransactionName();
        if (transactionName == null || transactionName.trim().length() == 0) {
            throw new Exception(I18NUtils.tradueix("error.transactionname.notnull"));
        }

        // Valida Idioma UI
        String lang = requestTransaction.getLanguageUI();
        if (lang == null || lang.trim().length() == 0) {
            throw new Exception(I18NUtils.tradueix("error.language.notnull"));
        }

        // XYZ ZZZ ZZZ Valida Idioma DOC

        // Valida Perfil
        String scanWebProfile = requestTransaction.getScanWebProfile();
        if (scanWebProfile == null || scanWebProfile.trim().length() == 0) {
            throw new Exception(I18NUtils.tradueix("error.scanwebprofile.notnull"));
        }

        UsuariAplicacioJPA usuariAplicacio = usuariAplicacioCache.get();

        // Valida VISTA
        int view = requestTransaction.getView();

        if (view == MassiveScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN
                || view == MassiveScanWebSimpleGetTransactionIdRequest.VIEW_IFRAME) {
            // OK
        } else {
            String msg = I18NUtils.tradueix("error.transaccio.desconegut.idvista",
                    String.valueOf(view));
            throw new Exception(msg);
        }

        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null || "".equals(ip)) {
            ip = request.getRemoteAddr();
        }

        // Crea Transacció
        try {
            TransaccioJPA transaccio = transaccioLogicaEjb.crearTransaccio(requestTransaction,
                    usuariAplicacio, null, null, null, ip);

            auditCreateTransaction(usuariAplicacio, transaccio);

            return transaccio.getTransactionWebId();
        } catch (I18NException e) {
            String msg = I18NUtils.tradueix("error.transaccio.crear")
                    + I18NLogicUtils.getMessage(e, new Locale(lang));
            throw new Exception(msg);
        }
    }

    protected void auditCreateTransaction(UsuariAplicacioJPA usuariAplicacio,
            TransaccioJPA transaction) throws I18NException {
        final boolean isApp = true;
        final String ip = transaction.getIp();
        final String remoteUsernamePerson = transaction.getFuncionariUsername();

        final String additionalInfo = "IP: " + ip + "\n" + "Aplicacio: "
                + usuariAplicacio.getUsername() + "\n" + "Remote Usuari Persona: "
                + remoteUsernamePerson + "\n" + "TransacctionWebID: "
                + transaction.getTransactionWebId() + "\n" + "Tipus Transacció: "
                + I18NUtils.tradueix(new Locale("ca"),
                        "transaccio.tipus." + Math.abs(transaction.getPerfil().getUsPerfil()));

        Auditoria audit = new AuditoriaBean(new Timestamp(System.currentTimeMillis()),
                transaction.getTransaccioID(), Constants.AUDIT_TYPE_CREATE_TRANSACTION,
                I18NUtils.tradueix("transaccio.aplicacio.crear",
                        String.valueOf(transaction.getTransaccioID())),
                additionalInfo, isApp, usuariAplicacio.getUsername(), remoteUsernamePerson);

        auditoriaLogicaEjb.create(audit);
    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.STARTTRANSACTION, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> startTransactionRest(HttpServletRequest request,
            @RequestBody final MassiveScanWebSimpleStartTransactionRequest startTransactionRequest) {

        String languageUI = "ca";

        log.info(
                " XYZ ZZZ eNTRA A startTransaction => MassiveScanWebSimpleStartTransactionRequest: "
                        + startTransactionRequest);

        RestCaller<String> restCaller = new RestCaller<String>(languageUI) {
            @Override
            public String cridadaReal() throws Exception {
                return startTransaction(startTransactionRequest);
            }
        };

        return restCaller.cridada();

        /*
         * String error = autenticate(request, languageUI, usuariAplicacioEjb); if (error !=
         * null) { return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * try {
         * 
         * String redirectUrl = startTransaction(startTransactionRequest);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> re = new
         * ResponseEntity<String>(redirectUrl, headers, HttpStatus.OK);
         * log.info(" XYZ ZZZ SURT DE startTransaction => FINAL OK");
         * 
         * return re;
         * 
         * } catch (Throwable th) { String msg = th.getMessage(); log.error(msg, th); return
         * generateServerError(msg, th); }
         */
    }

    @Override
    public String startTransaction(
            MassiveScanWebSimpleStartTransactionRequest startTransactionRequest)
            throws Exception {

        String languageUI = "ca";

        try {
            cleanExpiredTransactions();
        } catch (I18NException e2) {
            String msg = I18NUtils.tradueix("error.transaccio.neteja.caducats")
                    + getMessageFromI18nException(languageUI, e2);
            throw new Exception(msg, e2);
        }
        // TODO XYZ ZZZ CHECKS DE LOGIN

        // CHECKS DE variable
        final String transactionWebID = startTransactionRequest.getTransactionID();

        log.info(" XYZ ZZZ startTransaction::transactionWebID => |" + transactionWebID + "|");

        try {
            // XYZ ZZZ TREURE A METODE ????
            TransaccioJPA transaccio = null;
            {

                transaccio = transaccioLogicaEjb
                        .searchTransaccioByTransactionWebID(transactionWebID);
                if (transaccio == null) {
                    String msg = I18NUtils.tradueix("transaccio.noexisteix", transactionWebID);
                    throw new Exception(msg);
                }

                if (transaccio.getEstatCodi() < 0) {
                    String msg = I18NUtils.tradueix("transaccio.estat.novalid",
                            String.valueOf(transactionWebID),
                            String.valueOf(transaccio.getEstatCodi()));
                    throw new Exception(msg);
                }

            }

            languageUI = transaccio.getLanguageUI();

            // XYZ ZZZ TODO
            // Falta verificar estructura de

            // Date dataCreacio = ti.getStartTime();
            //
            // if (dataCreacio.getTime() + TransactionInfo.MAX_TIME <
            // System.currentTimeMillis()) {
            // // TODO XYZ ZZZ Traduir
            // currentTransactions.remove(transactionID);
            // return generateServerError("La transacció amb ID " + transactionID + " ha
            // expirat");
            // }

            // TODO XYZ ZZZ VALIDAR ESTRUCTURA simpleSignaturesSet

            LoginInfo loginInfo = LoginInfo.getInstance();

            log.info(" XYZ ZZZ LOGININFO => " + loginInfo);

            // Checks Globals
            // if (loginInfo.getUsuariPersona() != null) {
            // throw new Exception("Aquest servei només el poden fer servir el usuariAPP XYZ
            // ZZZ");
            // }

            // Checks usuari aplicacio
            UsuariAplicacioJPA usuariAplicacio = loginInfo.getUsuariAplicacio();
            log.info(" XYZ ZZZ Usuari-APP = " + usuariAplicacio);
            long usuariAplicacioID = usuariAplicacio.getUsuariAplicacioID();
            log.info(" XYZ ZZZ Usuari-APP ID = " + usuariAplicacioID);

            transaccio.setReturnUrl(startTransactionRequest.getReturnUrl());

            // CRIDAR A START TRANSACION
            // Cercar plugin d'escaneig

            Perfil p = transaccio.getPerfil();


            String urlBase = p.getUrlBase();
            if (urlBase == null) {
                urlBase = Configuracio.getBackUrl();
            }

            // URL on Iniciar el proces de firma
            // XYZ ZZZ TODO Això ho ha de collir de la propietat URL
            // XYZ ZZZ TODO Configurar que si getAppUrl val null llavors llanci excepció
            final String redirectUrl = urlBase
                    + ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH + "/start/"
                    + transaccio.getTransactionWebId();
            if (log.isDebugEnabled()) {
                log.debug("Inici de TRANSACCIO SCANWEB = " + redirectUrl);
            }

            transaccio.setEstatCodi(MassiveScanWebSimpleStatus.STATUS_IN_PROGRESS);
            transaccioLogicaEjb.update(transaccio);

            return redirectUrl;

        } catch (I18NException i18n) {
            throw new Exception(getMessageFromI18nException(languageUI, i18n));
        }

    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETMASSIVETRANSACTIONSTATUS, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getMassiveTransactionStatusRest(
            @RequestBody final String transactionID) {

        log.info(" XYZ ZZZ ENTRA A getTransactionStatus => " + transactionID);

        String languageUI = "ca";

        RestCaller<MassiveScanWebSimpleStatus> restCaller = new RestCaller<MassiveScanWebSimpleStatus>(
                languageUI) {
            @Override
            public MassiveScanWebSimpleStatus cridadaReal() throws Exception {
                return getMassiveTransactionStatus(transactionID);
            }
        };

        return restCaller.cridada();

        /*
         * String error = autenticate(request, "ca", usuariAplicacioEjb); if (error != null) {
         * return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * try { MassiveScanWebSimpleStatus status =
         * getMassiveTransactionStatus(transactionID);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> re = new
         * ResponseEntity<MassiveScanWebSimpleStatus>(status, headers, HttpStatus.OK);
         * log.info(" XYZ ZZZ surt de  getTransactionStatus => FINAL OK");
         * 
         * return re;
         * 
         * } catch (Throwable th) { final String msg =
         * I18NUtils.tradueix("error.desconegut.transaccio.estat.informacio", transactionID) +
         * ": " + th.getMessage(); log.error(msg, th); return generateServerError(msg, th); }
         */

    }

    @Override
    public MassiveScanWebSimpleStatus getMassiveTransactionStatus(String transactionWebID)
            throws Exception {

        return getCommonTransactionStatus(transactionWebID);

    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETSUBTRANSACTIONSTATUS, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getSubTransactionStatusRest(
            @RequestBody final String transactionID) {

        log.info(" XYZ ZZZ ENTRA A getSUBTransactionStatus => " + transactionID);

        String languageUI = "ca";

        RestCaller<MassiveScanWebSimpleStatus> restCaller = new RestCaller<MassiveScanWebSimpleStatus>(
                languageUI) {
            @Override
            public MassiveScanWebSimpleStatus cridadaReal() throws Exception {
                return getSubTransactionStatus(transactionID);
            }
        };

        return restCaller.cridada();
    }

    @Override
    public MassiveScanWebSimpleStatus getSubTransactionStatus(String transactionWebID)
            throws Exception {

        return getCommonTransactionStatus(transactionWebID);

    }

    public MassiveScanWebSimpleStatus getCommonTransactionStatus(String transactionWebID)
            throws Exception {

        String lang = "ca";
        try {
            TransaccioJPA transaccio;

            transaccio = transaccioLogicaEjb
                    .searchTransaccioByTransactionWebID(transactionWebID);
            if (transaccio == null) {
                String msg = I18NCommonUtils.tradueix(new Locale(lang),
                        "transaccio.noexisteix", transactionWebID);
                throw new Exception(msg);
            }

            lang = transaccio.getLanguageUI();

            MassiveScanWebSimpleStatus status = new MassiveScanWebSimpleStatus();
            status.setStatus(transaccio.getEstatCodi());
            status.setErrorMessage(transaccio.getEstatMissatge());
            status.setErrorStackTrace(transaccio.getEstatExcepcio());

            return status;

        } catch (I18NException e) {
            String msg = I18NUtils.tradueix("error.transaccio.crear")
                    + I18NLogicUtils.getMessage(e, new Locale(lang));
            throw new Exception(msg);
        }

    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETSUBTRANSACTIONRESULT, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getSubtransactionResultRest(
            @RequestBody final MassiveScanWebSimpleSubtransactionResultRequest resultRequest) {

        String languageUI = "ca";

        RestCaller<MassiveScanWebSimpleSubtransactionResult> restCaller = new RestCaller<MassiveScanWebSimpleSubtransactionResult>(
                languageUI) {
            @Override
            public MassiveScanWebSimpleSubtransactionResult cridadaReal() throws Exception {
                return getSubTransactionResult(resultRequest);
            }
        };

        return restCaller.cridada();

        /*
         * String error = autenticate(request, locale, usuariAplicacioEjb); if (error != null)
         * { return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * try { MassiveScanWebSimpleSubtransactionResult prof =
         * getSubTransactionResult(resultRequest);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> re = new
         * ResponseEntity<MassiveScanWebSimpleSubtransactionResult>(prof, headers,
         * HttpStatus.OK);
         * 
         * return re;
         * 
         * } catch (Throwable th) { String msg = th.getMessage(); log.error(msg, th); return
         * generateServerError(msg, th); }
         */
    }

    @Override
    public MassiveScanWebSimpleSubtransactionResult getSubTransactionResult(
            MassiveScanWebSimpleSubtransactionResultRequest resultRequest) throws Exception {

        String transactionWebID = resultRequest.getSubtransactionID();

        String languageUI = "ca";

        try {
            // Clean Transactions caducades
            cleanExpiredTransactions();
        } catch (I18NException e2) {
            String msg = I18NUtils.tradueix("error.transaccio.neteja.caducats")
                    + I18NLogicUtils.getMessage(e2, new Locale(languageUI));
            throw new Exception(msg, e2);
        }

        // XYZ ZZZ
        // Revisar que existeix currentTransaccitions

        try {

            TransaccioJPA transaccio = transaccioLogicaEjb
                    .searchTransaccioByTransactionWebID(transactionWebID);

            final long transactionID = transaccio.getTransaccioID();

            languageUI = transaccio.getLanguageUI();

            MassiveScanWebSimpleStatus status = new MassiveScanWebSimpleStatus();
            status.setStatus(transaccio.getEstatCodi());
            status.setErrorMessage(transaccio.getEstatMissatge());
            status.setErrorStackTrace(transaccio.getEstatExcepcio());

            if (status.getStatus() != MassiveScanWebSimpleStatus.STATUS_FINAL_OK) {
                return new MassiveScanWebSimpleSubtransactionResult(transactionID,
                        transactionWebID, status);
            }

            final int tipusPerfil = transaccio.getPerfil().getUsPerfil();

            MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;
            MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters = null;
            if (tipusPerfil == Constants.PERFIL_US_CUSTODIA
                    || tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO) {

                /**
                 * Obligatori si el perfil requeix Arxiu o Custodia
                 */

                {
                    final String citizenAdministrationID = transaccio
                            .getArxiuReqParamCiutadaNif();
                    final String citizenFullName = transaccio.getArxiuReqParamCiutadaNom();

                    final String documentElaborationState = transaccio
                            .getArxiuReqParamDocEstatElabora();
                    final Integer documentOrigen = transaccio.getArxiuReqParamOrigen();
                    final List<String> interestedPersons;
                    {
                        String tmp = transaccio.getArxiuReqParamInteressats();
                        if (tmp == null || tmp.trim().length() == 0) {
                            interestedPersons = null;
                        } else {
                            interestedPersons = Arrays.asList(tmp.split("\\s*,\\s*"));
                        }
                    }

                    final List<String> affectedOrganisms;
                    {
                        String tmp = transaccio.getArxiuReqParamOrgans();
                        if (tmp == null || tmp.trim().length() == 0) {
                            affectedOrganisms = null;
                        } else {
                            affectedOrganisms = Arrays.asList(tmp.split("\\s*,\\s*"));
                        }
                    }

                    arxiuRequiredParameters = new MassiveScanWebSimpleArxiuRequiredParameters(
                            citizenAdministrationID, citizenFullName, documentElaborationState,
                            documentOrigen, interestedPersons, affectedOrganisms);
                }

                /**
                 * Paràmetres opcionals per Arxiu o Custòdia
                 */

                {
                    final String procedureName = transaccio.getArxiuOptParamProcedimentNom();
                    final String procedureCode = transaccio.getArxiuOptParamProcedimentCodi();
                    final String documentarySerie = transaccio
                            .getArxiuOptParamSerieDocumental();
                    final String custodyIDOrExpedientID = transaccio
                            .getArxiuOptParamCustodyOrExpedientId();

                    arxiuOptionalParameters = new MassiveScanWebSimpleArxiuOptionalParameters(
                            procedureName, procedureCode, documentarySerie,
                            custodyIDOrExpedientID);

                }
            }

            // Metadades Addicionals
            final List<MassiveScanWebSimpleKeyValue> additionalMetadatas = new ArrayList<MassiveScanWebSimpleKeyValue>();
            List<Metadada> metadades = metadadaEjb.select(
                    MetadadaFields.TRANSACCIOID.equal(transactionID),
                    new OrderBy(MetadadaFields.NOM));
            if (metadades != null && !metadades.isEmpty()) {
                for (Metadada metadada : metadades) {
                    additionalMetadatas.add(new MassiveScanWebSimpleKeyValue(metadada.getNom(),
                            metadada.getValor()));
                }
            }

            final MassiveScanWebSimpleFile scannedFile;
            final MassiveScanWebSimpleScannedFileInfo scannedFileInfo;
            final boolean perfilFirmaOArxiu = (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA_INFO
                    || tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO);

            Boolean returnScannedFile = resultRequest.getReturnScannedFile();
            if ((returnScannedFile == null && !perfilFirmaOArxiu)
                    || Boolean.TRUE.equals(returnScannedFile)) {

                // Document escanejat
                long scannedFileID = transaccio.getFitxerEscanejatID();

                byte[] data = FileSystemManager.getFileContent(scannedFileID);

                String nom = transaccio.getFitxerEscanejat().getNom();

                // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
                String mime = transaccio.getFitxerEscanejat().getMime();

                scannedFile = new MassiveScanWebSimpleFile(nom, mime, data);
            } else {
                scannedFile = null;
            }

            // Informació de Document escanejat
            // XYZ ZZZ ZZZ
            Integer pixelType = null;
            if (transaccio.getInfoScanPixelType() != null) {
                switch (transaccio.getInfoScanPixelType()) {
                    case MetadataConstants.ProfundidadColorConstants.GRAY:
                        pixelType = MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_GRAY;
                    break;
                    case MetadataConstants.ProfundidadColorConstants.BW:
                        pixelType = MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_BLACK_WHITE;
                    break;
                    case MetadataConstants.ProfundidadColorConstants.COLOR:
                        pixelType = MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_COLOR;
                    break;

                    default:
                        pixelType = transaccio.getInfoScanPixelType();

                }
            }

            final String transactionName = transaccio.getNom();
            Integer pppResolution = transaccio.getInfoScanResolucioPpp();
            String formatFile = ScanWebUtils
                    .formatFileToScanWebApi(transaccio.getPerfil().getScanFormatFitxer());

            Boolean ocr = transaccio.getInfoScanOcr();
            
            Boolean duplex = transaccio.getInfoScanDuplex();

            final String documentLanguage = transaccio.getInfoScanLanguageDoc();

            
            final String paperSize = transaccio.getInfoScanPaperSize();

            Date scanDate = transaccio.getDataInici();
            
            
            
            String documentType = transaccio.getInfoScanDocumentTipus();

            scannedFileInfo = new MassiveScanWebSimpleScannedFileInfo(transactionName,
                    scanDate, pixelType, pppResolution, formatFile, ocr, duplex, paperSize,
                    documentLanguage, documentType);

            final MassiveScanWebSimpleSignedFileInfo signedFileInfo;
            final MassiveScanWebSimpleFile signedFile;
            final MassiveScanWebSimpleFile detachedSignatureFile;
            // XYZ ZZZ Falta Informacio de Firma

            if (perfilFirmaOArxiu) {

                InfoSignaturaJPA infoSign = transaccio.getInfoSignatura();

                Integer signMode = infoSign.getSignMode();

                Boolean returnSignedFile = resultRequest.getReturnSignedFile();
                if (returnSignedFile == null || returnSignedFile == true) {

                    // Document Signat
                    {
                        long signedFileID = transaccio.getFitxerSignaturaID();

                        byte[] data = FileSystemManager.getFileContent(signedFileID);

                        String nom = transaccio.getFitxerSignatura().getNom();

                        // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
                        String mime = transaccio.getFitxerSignatura().getMime();

                        signedFile = new MassiveScanWebSimpleFile(nom, mime, data);
                    }

                    // Document Detached de la Fima (És el documnt escanejat)
                    if (signMode != null && signMode == FileInfoSignature.SIGN_MODE_EXPLICIT) {

                        long scannedFileID = transaccio.getFitxerEscanejatID();

                        byte[] data = FileSystemManager.getFileContent(scannedFileID);

                        String nom = transaccio.getFitxerEscanejat().getNom();

                        // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
                        String mime = transaccio.getFitxerEscanejat().getMime();

                        detachedSignatureFile = new MassiveScanWebSimpleFile(nom, mime, data);

                    } else {
                        detachedSignatureFile = null;
                    }

                } else {
                    signedFile = null;
                    detachedSignatureFile = null;
                }

                {

                    int signOperation = infoSign.getSignOperation();
                    String signType = infoSign.getSignType();
                    String signAlgorithm = infoSign.getSignAlgorithm();

                    Integer signaturesTableLocation = infoSign.getSignaturesTableLocation();
                    Boolean timeStampIncluded = infoSign.getTimestampIncluded();
                    Boolean policyIncluded = infoSign.getPolicyIncluded();
                    String eniTipoFirma = infoSign.getEniTipoFirma();
                    String eniPerfilFirma = infoSign.getEniPerfilFirma();
                    String eniRolFirma = infoSign.getEniRolFirma();
                    String eniSignerName = infoSign.getEniSignerName();
                    String eniSignerAdministrationId = infoSign.getEniSignerAdministrationId();
                    String eniSignLevel = infoSign.getEniSignLevel();

                    Boolean checkAdministrationIDOfSigner = infoSign
                            .getCheckAdministrationIdOfSigner();
                    Boolean checkDocumentModifications = infoSign
                            .getCheckDocumentModifications();
                    Boolean checkValidationSignature = infoSign.getCheckValidationSignature();
                    MassiveScanWebSimpleValidationInfo validationInfo = new MassiveScanWebSimpleValidationInfo(
                            checkAdministrationIDOfSigner, checkDocumentModifications,
                            checkValidationSignature);

                    List<MassiveScanWebSimpleKeyValue> additionInformation = null;

                    signedFileInfo = new MassiveScanWebSimpleSignedFileInfo(signOperation,
                            signType, signAlgorithm, signMode, signaturesTableLocation,
                            timeStampIncluded, policyIncluded, eniTipoFirma, eniPerfilFirma,
                            eniRolFirma, eniSignerName, eniSignerAdministrationId,
                            eniSignLevel, validationInfo, additionInformation);
                }

            } else {
                signedFileInfo = null;
                signedFile = null;
                detachedSignatureFile = null;
            }

            // XYZ ZZZ Falta Informació de Custòdia i Arxiu
            final MassiveScanWebSimpleCustodyInfo custodyInfo;
            final MassiveScanWebSimpleArxiuInfo arxiuInfo;

            if (tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO) {

                InfoCustodyJPA custody = transaccio.getInfoCustody();

                if (custody == null) {
                    log.error("tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO "
                            + "però el valor de transaccio.getInfoCustody() val null. QUE HA PASSAT !!!!!!!");
                }

                {

                    String csv = custody.getCsv();
                    String originalFileURL = custody.getOriginalFileUrl();
                    String printableFileURL = custody.getPrintableFileUrl();
                    String eniFileURL = custody.getEniFileUrl();
                    String csvValidationWeb = custody.getCsvValidationWeb();
                    String csvGenerationDefinition = custody.getCsvGenerationDefinition();
                    String validationFileUrl = custody.getValidationFileUrl();

                    if (custody.getCustodyId() != null) {
                        String custodyID = custody.getCustodyId();

                        custodyInfo = new MassiveScanWebSimpleCustodyInfo(custodyID, csv,
                                originalFileURL, printableFileURL, eniFileURL,
                                csvValidationWeb, csvGenerationDefinition, validationFileUrl);

                        arxiuInfo = null;
                    } else {

                        String expedientID = custody.getArxiuExpedientId();
                        String documentID = custody.getArxiuDocumentId();

                        arxiuInfo = new MassiveScanWebSimpleArxiuInfo(expedientID, documentID,
                                csv, originalFileURL, printableFileURL, eniFileURL,
                                csvValidationWeb, csvGenerationDefinition, validationFileUrl);

                        custodyInfo = null;

                    }
                }
            } else {
                custodyInfo = null;
                arxiuInfo = null;
            }

            MassiveScanWebSimpleSubtransactionResult fssr = new MassiveScanWebSimpleSubtransactionResult(
                    transactionID, transactionWebID, status, scannedFile, scannedFileInfo,
                    signedFile, detachedSignatureFile, signedFileInfo, custodyInfo, arxiuInfo,
                    arxiuRequiredParameters, arxiuOptionalParameters, additionalMetadatas);

            return fssr;

        } catch (I18NException i18n) {
            throw new Exception(getMessageFromI18nException(languageUI, i18n));
        }
    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.CLOSETRANSACTION, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> closeTransactionRest(@RequestBody String transactionWebID) {

        log.info(" XYZ ZZZ closeTransaction => ENTRA");

        String error = autenticate(request, "ca", usuariAplicacioEjb);
        if (error != null) {
            return generateServerError(error, HttpStatus.UNAUTHORIZED);
        }

        try {
            closeTransaction(transactionWebID);
            log.info(" XYZ ZZZ closeTransaction => FINAL OK");

            return new ResponseEntity<Void>(HttpStatus.OK);

        } catch (Throwable th) {
            String msg = th.getMessage();
            log.error(msg, th);
            return generateServerError(msg, th);
        }

    }

    @Override
    public void closeTransaction(String transactionWebID) throws Exception {

        try {
            cleanExpiredTransactions();
        } catch (Throwable th) {
        }

    }

    public static long lastCheckExpiredTransaccions = 0;

    /**
     * Fer neteja de transaccions Obsoletes
     */
    protected synchronized void cleanExpiredTransactions() throws I18NException {

        final long now = System.currentTimeMillis();

        if (lastCheckExpiredTransaccions + 5000 > now) {
            return; // Esperam un poc entre
        }

        Timestamp expired = new Timestamp(now - Configuracio.getTransactionExpirationTimeInMs());

        Where where = Where.AND(TransaccioFields.DATAFI.isNull(),
                TransaccioFields.DATAINICI.lessThan(expired));

        List<Long> caducades = transaccioLogicaEjb.executeQuery(TransaccioFields.TRANSACCIOID,
                where);

        for (Long tid : caducades) {
            try {

                TransaccioJPA trans = transaccioLogicaEjb.findByPrimaryKey(tid);
                trans.setEstatCodi(MassiveScanWebSimpleStatus.STATUS_EXPIRED);
                trans.setDataFi(new Timestamp(now));

                log.warn("Marcant transaccio com caducada: " + trans.getTransactionWebId());
                transaccioLogicaEjb.update(trans);

            } catch (Exception e) {
                log.error("Error desconegut"
                        + " netejant transaccions expirades de l'ApiMassiveScanWebSimple: "
                        + e.getMessage(), e);
            }
        }
    }

    protected String getMessageFromI18nException(String locale, I18NException i18n)
            throws Exception {
        I18NTranslation translation = i18n.getTraduccio();
        String code = translation.getCode();
        String[] args = I18NUtils.tradueixArguments(translation.getArgs());
        return I18NUtils.tradueix(null, new Locale(locale), code, args);
    }

    @RequestMapping(value = "/"
            + ApiMassiveScanWebSimple.GETSUBTRANSACTIONSOFTRANSACTION, method = RequestMethod.POST)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getSubTransactionsOfTransactionRest(
            @RequestBody final String transactionID) {

        String language = "ca";

        RestCaller<MassiveScanWebSimpleSubTransactionsOfTransaction> restCaller;
        restCaller = new RestCaller<MassiveScanWebSimpleSubTransactionsOfTransaction>(
                language) {
            @Override
            public MassiveScanWebSimpleSubTransactionsOfTransaction cridadaReal()
                    throws Exception {
                return getSubTransactionsOfTransaction(transactionID);
            }
        };

        return restCaller.cridada();

        /*
         * String language = "ca";
         **
         * String error = autenticate(request, language, usuariAplicacioEjb); if (error !=
         * null) { return generateServerError(error, HttpStatus.UNAUTHORIZED); }
         * 
         * try { MassiveScanWebSimpleSubTransactionsOfTransaction subs =
         * getSubTransactionsOfTransaction( transactionID);
         * 
         * HttpHeaders headers = addAccessControllAllowOrigin(); ResponseEntity<?> res = new
         * ResponseEntity<MassiveScanWebSimpleSubTransactionsOfTransaction>( subs, headers,
         * HttpStatus.OK);
         * 
         * return res; } catch (Throwable th) { String msg = th.getMessage(); log.error(msg,
         * th); return generateServerError(msg, th); }
         */
    }

    @Override
    public MassiveScanWebSimpleSubTransactionsOfTransaction getSubTransactionsOfTransaction(
            String transactionWebID) throws Exception {

        String locale = "ca";

        try {
            // Extreim la transaccio massiva de la transactionWebID
            Long transactionMultipleID = transaccioLogicaEjb.executeQueryOne(
                    TransaccioFields.TRANSACCIOMULTIPLEID,
                    TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));

            if (transactionMultipleID == null) {
                // XYZ ZZZ transactionMultipleID is null
                throw new Exception(
                        "No s'ha pogut obtenir l'ID de transactionMultipleID de la transacció amb webID "
                                + transactionWebID);
            }

            List<String> subtransacions = transaccioLogicaEjb.executeQuery(
                    TransaccioFields.TRANSACTIONWEBID,
                    TransaccioFields.TRANSACCIOMULTIPLEID.equal(transactionMultipleID),
                    new OrderBy(TransaccioFields.TRANSACCIOID));

            MassiveScanWebSimpleSubTransactionsOfTransaction massivesubs;
            massivesubs = new MassiveScanWebSimpleSubTransactionsOfTransaction(
                    transactionWebID, subtransacions);

            return massivesubs;
        } catch (I18NException i18n) {

            try {
                locale = transaccioLogicaEjb.executeQueryOne(TransaccioFields.LANGUAGEUI,
                        TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));
            } catch (I18NException e) {
                log.error("Error intentant esbrinar el locale de la transaccio web "
                        + transactionWebID);
            }

            throw new Exception(getMessageFromI18nException(locale, i18n));
        }
    }



}
