package es.caib.digitalib.back.controller.scanwebsimple.v1;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fundaciobit.apisib.apiscanwebsimple.v1.ApiScanWebSimple;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuInfo;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfile;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfiles;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleCustodyInfo;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleFile;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleFormMetadatas;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleKeyValue;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleProfileRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleResultRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleScanResult;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleScannedFileInfo;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleSignatureParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleSignedFileInfo;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStartTransactionRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleValidationInfo;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NTranslation;
import org.fundaciobit.genapp.common.query.SubQuery;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.caib.digitalib.back.controller.all.ScanWebProcessControllerPublic;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.InfoSignaturaJPA;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.logic.AuditoriaLogicaLocal;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.ScanWebUtils;
import es.caib.digitalib.model.bean.AuditoriaBean;
import es.caib.digitalib.model.entity.Auditoria;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.utils.Constants;

/**
 * Created 19/11/18 10:10
 *
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = RestApiScanWebSimpleV1Controller.CONTEXT)
public class RestApiScanWebSimpleV1Controller extends RestApiScanWebUtils implements
    ApiScanWebSimple {

  public static final String CONTEXT = "/common/rest/apiscanwebsimple/v1";

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioLocal usuariAplicacioEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;

  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  @EJB(mappedName = AuditoriaLogicaLocal.JNDI_NAME)
  protected AuditoriaLogicaLocal auditoriaLogicaEjb;

  @Autowired
  private HttpServletRequest request;

  @RequestMapping(value = "/" + ApiScanWebSimple.AVAILABLEPROFILES, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getAvailableProfilesRest(@RequestBody String locale) {
    try {

      String error = autenticate(request, locale, usuariAplicacioEjb);
      if (error != null) {
        return generateServerError(error, HttpStatus.UNAUTHORIZED);
      }

      ScanWebSimpleAvailableProfiles fsap = getAvailableProfiles(locale);

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleAvailableProfiles>(fsap, headers,
          HttpStatus.OK);

      return re;

    } catch (Throwable th) {
      String msg = th.getMessage();
      log.error(msg, th);
      return generateServerError(msg, th);
    }

  }

  /**
   * 
   * @param locale
   * @return
   * @throws Exception
   */
  @Override
  public ScanWebSimpleAvailableProfiles getAvailableProfiles(String locale) throws Exception {

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

      SubQuery<PerfilUsuariAplicacio, Long> subquery = perfilUsuariAplicacioEjb.getSubQuery(
          PerfilUsuariAplicacioFields.PERFILID,
          PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(usuariAplicacioID));

      List<Perfil> perfils = perfilEjb.select(PerfilFields.PERFILID.in(subquery));

      ScanWebSimpleAvailableProfiles fsap = new ScanWebSimpleAvailableProfiles();

      if (perfils != null && perfils.size() != 0) {

        List<ScanWebSimpleAvailableProfile> list = new ArrayList<ScanWebSimpleAvailableProfile>();

        for (Perfil p : perfils) {

          PerfilJPA perfil = (PerfilJPA) p;
          ScanWebSimpleAvailableProfile ap = new ScanWebSimpleAvailableProfile(
              perfil.getCodi(), perfil.getNom().getTraduccio(locale).getValor(), perfil
                  .getDescripcio().getTraduccio(locale).getValor(), perfil.getUsPerfil());
          list.add(ap);
        }

        fsap.setAvailableProfiles(list);

      }

      return fsap;

    } catch (I18NException i18n) {
      throw new Exception(getMessageFromI18nException(locale, i18n));
    }
  }

  @RequestMapping(value = "/" + ApiScanWebSimple.GETPROFILE, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getProfileRest(
      @RequestBody ScanWebSimpleProfileRequest profileRequest) throws Exception {

    String locale;
    if (profileRequest == null || profileRequest.getLocale() == null) {
      locale = "ca";
    } else {
      locale = profileRequest.getLocale();
    }

    String error = autenticate(request, locale, usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {
      ScanWebSimpleAvailableProfile prof = getProfile(profileRequest);

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleAvailableProfile>(prof, headers,
          HttpStatus.OK);

      return re;

    } catch (Throwable th) {
      String msg = th.getMessage();
      log.error(msg, th);
      return generateServerError(msg, th);
    }
  }

  /**
   * 
   */
  @Override
  public ScanWebSimpleAvailableProfile getProfile(ScanWebSimpleProfileRequest profileRequest)
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

      SubQuery<PerfilUsuariAplicacio, Long> subquery = perfilUsuariAplicacioEjb.getSubQuery(
          PerfilUsuariAplicacioFields.PERFILID,
          PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(usuariAplicacioID));

      List<Perfil> perfils = perfilEjb.select(Where.AND(
          PerfilFields.CODI.equal(profileRequest.getProfileCode()),
          PerfilFields.PERFILID.in(subquery)));

      ScanWebSimpleAvailableProfile fsap = null;

      if (perfils != null && perfils.size() != 0) {

        String locale = profileRequest.getLocale();

        PerfilJPA perfil = (PerfilJPA) perfils.get(0);
        fsap = new ScanWebSimpleAvailableProfile(perfil.getCodi(), perfil.getNom()
            .getTraduccio(locale).getValor(), perfil.getDescripcio().getTraduccio(locale)
            .getValor(), perfil.getUsPerfil());

      }

      return fsap;

    } catch (I18NException i18n) {
      throw new Exception(getMessageFromI18nException(profileRequest.getLocale(), i18n));
    }
  }

  @RequestMapping(value = "/" + ApiScanWebSimple.GETTRANSACTIONID, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getTransactionIDRest(
      @RequestBody ScanWebSimpleGetTransactionIdRequest requestTransaction) {

    String language = "ca";

    String error = autenticate(request, language, usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {
      String transactionWebID = getTransactionID(requestTransaction);

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> res = new ResponseEntity<String>(transactionWebID, headers,
          HttpStatus.OK);

      return res;
    } catch (Throwable th) {
      String msg = th.getMessage();
      log.error(msg, th);
      return generateServerError(msg, th);
    }

  }

  @Override
  public String getTransactionID(ScanWebSimpleGetTransactionIdRequest requestTransaction)
      throws Exception {

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

    // Valida Idioma
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

    if (view == ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN
        || view == ScanWebSimpleGetTransactionIdRequest.VIEW_IFRAME) {
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

    final String additionalInfo = "IP: "
        + ip
        + "\n"
        + "Aplicacio: "
        + usuariAplicacio.getUsername()
        + "\n"
        + "Remote Usuari Persona: "
        + remoteUsernamePerson
        + "\n"
        + "TransacctionWebID: "
        + transaction.getTransactionWebId()
        + "\n"
        + "Tipus Transacció: "
        + I18NUtils.tradueix(new Locale("ca"),
            "transaccio.tipus." + Math.abs(transaction.getPerfil().getUsPerfil()));

    Auditoria audit = new AuditoriaBean(new Timestamp(System.currentTimeMillis()),
        transaction.getTransaccioID(), Constants.AUDIT_TYPE_CREATE_TRANSACTION,
        I18NUtils.tradueix("transaccio.aplicacio.crear",
            String.valueOf(transaction.getTransaccioID())), additionalInfo, isApp,
        usuariAplicacio.getUsername(), remoteUsernamePerson);

    auditoriaLogicaEjb.create(audit);
  }

  @RequestMapping(value = "/" + ApiScanWebSimple.STARTTRANSACTION, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> startTransaction(HttpServletRequest request,
      @RequestBody ScanWebSimpleStartTransactionRequest startTransactionRequest) {

    String languageUI = "ca";

    log.info(" XYZ ZZZ eNTRA A startTransaction => ScanWebSimpleStartTransactionRequest: "
        + startTransactionRequest);

    String error = autenticate(request, languageUI, usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {

      String redirectUrl = startTransaction(startTransactionRequest);

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<String>(redirectUrl, headers, HttpStatus.OK);
      log.info(" XYZ ZZZ SURT DE startTransaction => FINAL OK");

      return re;

    } catch (Throwable th) {
      String msg = th.getMessage();
      log.error(msg, th);
      return generateServerError(msg, th);
    }

  }

  @Override
  public String startTransaction(ScanWebSimpleStartTransactionRequest startTransactionRequest)
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

        transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
        if (transaccio == null) {
          String msg = I18NUtils.tradueix("transaccio.noexisteix", transactionWebID);
          throw new Exception(msg);
        }

        if (transaccio.getEstatCodi() < 0) {
          String msg = I18NUtils.tradueix("transaccio.estat.novalid",
              String.valueOf(transactionWebID), String.valueOf(transaccio.getEstatCodi()));
          throw new Exception(msg);
        }

      }

      languageUI = transaccio.getLanguageUI();

      // XYZ ZZZ TODO
      // Falta verificar estructura de

      // Date dataCreacio = ti.getStartTime();
      //
      // if (dataCreacio.getTime() + TransactionInfo.MAX_TIME < System.currentTimeMillis()) {
      // // TODO XYZ ZZZ Traduir
      // currentTransactions.remove(transactionID);
      // return generateServerError("La transacció amb ID " + transactionID + " ha expirat");
      // }

      // TODO XYZ ZZZ VALIDAR ESTRUCTURA simpleSignaturesSet

      LoginInfo loginInfo = LoginInfo.getInstance();

      log.info(" XYZ ZZZ LOGININFO => " + loginInfo);

      // Checks Globals
      // if (loginInfo.getUsuariPersona() != null) {
      // throw new Exception("Aquest servei només el poden fer servir el usuariAPP XYZ ZZZ");
      // }

      // Checks usuari aplicacio
      UsuariAplicacioJPA usuariAplicacio = loginInfo.getUsuariAplicacio();
      log.info(" XYZ ZZZ Usuari-APP = " + usuariAplicacio);
      long usuariAplicacioID = usuariAplicacio.getUsuariAplicacioID();
      log.info(" XYZ ZZZ Usuari-APP ID = " + usuariAplicacioID);

      transaccio.setReturnUrl(startTransactionRequest.getReturnUrl());

      // CRIDAR A START TRANSACION

      // XYZ ZZZ ZZZ Validar
      // SignaturesSetBeanValidator ssbv = new SignaturesSetBeanValidator(validator, this,
      // entitatID);
      // final boolean isNou = true;
      // ssbv.throwValidationExceptionIfErrors(signaturesSet, isNou);

      // Cercar plugin d'escaneig

      Perfil p = transaccio.getPerfil();

      // List<Long> filterPluginsByIDs = new ArrayList<Long>();
      //
      //
      // filterPluginsByIDs.add(p.getPluginScanWebID());

      String urlBase = p.getUrlBase();
      if (urlBase == null) {
        urlBase = Configuracio.getAppUrl();
      }

      // URL on Iniciar el proces de firma
      // XYZ ZZZ TODO Això ho ha de collir de la propietat URL
      // XYZ ZZZ TODO Configurar que si getAppUrl val null llavors llanci excepció
      final String redirectUrl = urlBase + ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH
          + "/start/" + transaccio.getTransactionWebId();
      if (log.isDebugEnabled()) {
        log.debug("Inici de TRANSACCIO SCANWEB = " + redirectUrl);
      }

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_IN_PROGRESS);
      transaccioLogicaEjb.update(transaccio);

      return redirectUrl;

    } catch (I18NException i18n) {
      throw new Exception(getMessageFromI18nException(languageUI, i18n));
    }

  }

  @RequestMapping(value = "/" + ApiScanWebSimple.TRANSACTIONSTATUS, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getTransactionStatusRest(@RequestBody String transactionID) {

    log.info(" XYZ ZZZ ENTRA A getTransactionStatus => " + transactionID);

    String error = autenticate(request, "ca", usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {
      ScanWebSimpleStatus status = getTransactionStatus(transactionID);

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleStatus>(status, headers,
          HttpStatus.OK);
      log.info(" XYZ ZZZ surt de  getTransactionStatus => FINAL OK");

      return re;

    } catch (Throwable th) {
      final String msg = I18NUtils.tradueix("error.desconegut.transaccio.estat.informacio",
          transactionID) + ": " + th.getMessage();
      log.error(msg, th);
      return generateServerError(msg, th);
    }

  }

  @Override
  public ScanWebSimpleStatus getTransactionStatus(String transactionWebID) throws Exception {

    String lang = "ca";
    try {
      TransaccioJPA transaccio;

      transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
      if (transaccio == null) {
        String msg = I18NCommonUtils.tradueix(new Locale(lang), "transaccio.noexisteix",
            transactionWebID);
        throw new Exception(msg);
      }

      lang = transaccio.getLanguageUI();

      ScanWebSimpleStatus status = new ScanWebSimpleStatus();
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

  /*
  @RequestMapping(value = "/" + ApiScanWebSimple.SCANWEBRESULT, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getScanWebResult(@RequestBody String transactionWebID,
      HttpServletRequest request) {

    log.info(" XYZ ZZZ getSignaturesResult => ENTRA");

    String error = autenticate(request, "ca", usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }
    try {
      ScanWebSimpleScanResult fssr = getScanWebResult(transactionWebID);

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleScanResult>(fssr, headers,
          HttpStatus.OK);
      log.info(" XYZ ZZZ getScanWebResult => FINAL OK");
      return re;

    } catch (Throwable th) {

      final String msg = I18NUtils.tradueix("error.desconegut.transaccio.numero.escaneig",
          transactionWebID) + ": " + th.getMessage();

      log.error(msg, th);

      return generateServerError(msg, th);
    }

  }

  @Override
  public ScanWebSimpleScanResult getScanWebResult(String transactionID) throws Exception {

    boolean returnScannedFile = true;
    boolean returnSignedFile = true;

    ScanWebSimpleResultRequest resultRequest = new ScanWebSimpleResultRequest(transactionID,
        returnScannedFile, returnSignedFile);

    return getScanWebResultSelectFiles(resultRequest);

  }
  */

  @RequestMapping(value = "/" + ApiScanWebSimple.SCANWEBRESULT, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getScanWebResultRest(
      @RequestBody ScanWebSimpleResultRequest resultRequest) {

    // XYZ ZZZ ZZZ
    String locale = "ca";
    String error = autenticate(request, locale, usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {
      ScanWebSimpleScanResult prof = getScanWebResult(resultRequest);

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleScanResult>(prof, headers,
          HttpStatus.OK);

      return re;

    } catch (Throwable th) {
      String msg = th.getMessage();
      log.error(msg, th);
      return generateServerError(msg, th);
    }

  }

  @Override
  public ScanWebSimpleScanResult getScanWebResult(
      ScanWebSimpleResultRequest resultRequest) throws Exception {

    String transactionWebID = resultRequest.getTransactionID();

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

      ScanWebSimpleStatus status = new ScanWebSimpleStatus();
      status.setStatus(transaccio.getEstatCodi());
      status.setErrorMessage(transaccio.getEstatMissatge());
      status.setErrorStackTrace(transaccio.getEstatExcepcio());

      if (status.getStatus() != ScanWebSimpleStatus.STATUS_FINAL_OK) {
        return new ScanWebSimpleScanResult(transactionID, transactionWebID, status);
      }

      ScanWebSimpleFormMetadatas formMetadatas;
      {

        final String transactionName = transaccio.getNom();
        final String functionaryUsername = transaccio.getFuncionariUsername();

        ScanWebSimpleSignatureParameters signatureParameters;
        {
          final String functionaryFullName = transaccio.getSignParamFuncionariNom();
          final String functionaryAdministrationID = transaccio.getSignParamFuncionariNif();
          final String documentLanguage = transaccio.getSignParamLanguageDoc();
          signatureParameters = new ScanWebSimpleSignatureParameters(documentLanguage,
              functionaryFullName, functionaryAdministrationID);
        }

        /**
         * Obligatori si el perfil requeix Arxiu o Custodia
         */
        ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
        {
          final String citizenAdministrationID = transaccio.getArxiuReqParamCiutadaNif();
          final String citizenFullName = transaccio.getArxiuReqParamCiutadaNom();

          final String documentElaborationState = transaccio.getArxiuReqParamDocEstatElabora();
          final String documentType = transaccio.getArxiuReqParamDocumentTipus();
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

          arxiuRequiredParameters = new ScanWebSimpleArxiuRequiredParameters(
              citizenAdministrationID, citizenFullName, documentElaborationState,
              documentType, documentOrigen, interestedPersons, affectedOrganisms);
        }

        /**
         * Paràmetres opcionals per Arxiu o Custòdia
         */
        ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;
        {
          final String procedureName = transaccio.getArxiuOptParamProcedimentNom();
          final String procedureCode = transaccio.getArxiuOptParamProcedimentCodi();
          final String documentarySerie = transaccio.getArxiuOptParamSerieDocumental();
          final String custodyIDOrExpedientID = transaccio
              .getArxiuOptParamCustodyOrExpedientId();

          arxiuOptionalParameters = new ScanWebSimpleArxiuOptionalParameters(procedureName,
              procedureCode, documentarySerie, custodyIDOrExpedientID);

        }

        final List<ScanWebSimpleKeyValue> additionalMetadatas = null;

        formMetadatas = new ScanWebSimpleFormMetadatas(transactionName, functionaryUsername,
            signatureParameters, arxiuRequiredParameters, arxiuOptionalParameters,
            additionalMetadatas);

      }
      
      final int tipusPerfil = transaccio.getPerfil().getUsPerfil();
      final boolean perfilFirmaOArxiu = (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA_INFO
          || tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO);

      final ScanWebSimpleFile scannedFile;
      final ScanWebSimpleScannedFileInfo scannedFileInfo;
      {

        Boolean returnScannedFile = resultRequest.isReturnScannedFile(); 
        if ((returnScannedFile == null && !perfilFirmaOArxiu) || Boolean.TRUE.equals(returnScannedFile)) {

          // Document escanejat
          long scannedFileID = transaccio.getFitxerEscanejatID();

          byte[] data = FileSystemManager.getFileContent(scannedFileID);

          String nom = transaccio.getFitxerEscanejat().getNom();

          // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
          String mime = transaccio.getFitxerEscanejat().getMime();

          scannedFile = new ScanWebSimpleFile(nom, mime, data);
        } else {
          scannedFile = null;
        }

        // Informació de Document escanejat
        // XYZ ZZZ ZZZ
        Integer pixelType = null;
        Integer pppResolution = null;
        String formatFile = ScanWebUtils.formatFileToScanWebApi(transaccio.getPerfil()
            .getScanFormatFitxer());

        // S'ha de treure de Perfil
        // XYZ ZZZ ZZZ
        Boolean ocr = null;
        scannedFileInfo = new ScanWebSimpleScannedFileInfo(pixelType, pppResolution,
            formatFile, ocr);

      }

      

      final ScanWebSimpleSignedFileInfo signedFileInfo;
      final ScanWebSimpleFile signedFile;
      final ScanWebSimpleFile detachedSignatureFile;
      // XYZ ZZZ Falta Informacio de Firma
      
      if (perfilFirmaOArxiu) {

        InfoSignaturaJPA infoSign = transaccio.getInfoSignatura();

        Integer signMode = infoSign.getSignMode();

        Boolean returnSignedFile = resultRequest.isReturnSignedFile(); 
        if (returnSignedFile == null || returnSignedFile == true) {

          // Document Signat
          {
            long signedFileID = transaccio.getFitxerSignaturaID();

            byte[] data = FileSystemManager.getFileContent(signedFileID);

            String nom = transaccio.getFitxerSignatura().getNom();

            // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
            String mime = transaccio.getFitxerSignatura().getMime();

            signedFile = new ScanWebSimpleFile(nom, mime, data);
          }

          // Document Detached de la Fima (És el documnt escanejat)
          if (signMode != null && signMode == FileInfoSignature.SIGN_MODE_EXPLICIT) {

            long scannedFileID = transaccio.getFitxerEscanejatID();

            byte[] data = FileSystemManager.getFileContent(scannedFileID);

            String nom = transaccio.getFitxerEscanejat().getNom();

            // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
            String mime = transaccio.getFitxerEscanejat().getMime();

            detachedSignatureFile = new ScanWebSimpleFile(nom, mime, data);

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

          Boolean checkAdministrationIDOfSigner = infoSign.getCheckAdministrationIdOfSigner();
          Boolean checkDocumentModifications = infoSign.getCheckDocumentModifications();
          Boolean checkValidationSignature = infoSign.getCheckValidationSignature();
          ScanWebSimpleValidationInfo validationInfo = new ScanWebSimpleValidationInfo(
              checkAdministrationIDOfSigner, checkDocumentModifications,
              checkValidationSignature);

          List<ScanWebSimpleKeyValue> additionInformation = null;

          signedFileInfo = new ScanWebSimpleSignedFileInfo(signOperation, signType,
              signAlgorithm, signMode, signaturesTableLocation, timeStampIncluded,
              policyIncluded, eniTipoFirma, eniPerfilFirma, eniRolFirma, eniSignerName,
              eniSignerAdministrationId, eniSignLevel, validationInfo, additionInformation);
        }

      } else {
        signedFileInfo = null;
        signedFile = null;
        detachedSignatureFile = null;
      }

      // XYZ ZZZ Falta Informació de Custòdia i Arxiu
      final ScanWebSimpleCustodyInfo custodyInfo;
      final ScanWebSimpleArxiuInfo arxiuInfo;

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

            custodyInfo = new ScanWebSimpleCustodyInfo(custodyID, csv, originalFileURL,
                printableFileURL, eniFileURL, csvValidationWeb, csvGenerationDefinition,
                validationFileUrl);

            arxiuInfo = null;
          } else {

            String expedientID = custody.getArxiuExpedientId();
            String documentID = custody.getArxiuDocumentId();

            arxiuInfo = new ScanWebSimpleArxiuInfo(expedientID, documentID, csv,
                originalFileURL, printableFileURL, eniFileURL, csvValidationWeb,
                csvGenerationDefinition, validationFileUrl);

            custodyInfo = null;

          }
        }
      } else {
        custodyInfo = null;
        arxiuInfo = null;
      }

      ScanWebSimpleScanResult fssr = new ScanWebSimpleScanResult(transactionID,
          transactionWebID, status, formMetadatas, scannedFile, scannedFileInfo, signedFile,
          detachedSignatureFile, signedFileInfo, custodyInfo, arxiuInfo);

      return fssr;

    } catch (I18NException i18n) {
      throw new Exception(getMessageFromI18nException(languageUI, i18n));
    }
  }

  @RequestMapping(value = "/" + ApiScanWebSimple.CLOSETRANSACTION, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> closeTransactionRest(@RequestBody String transactionID) {

    log.info(" XYZ ZZZ closeTransaction => ENTRA");

    String error = autenticate(request, "ca", usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {
      closeTransaction(transactionID);
      log.info(" XYZ ZZZ closeTransaction => FINAL OK");

      return new ResponseEntity<Void>(HttpStatus.OK);

    } catch (Throwable th) {
      String msg = th.getMessage();
      log.error(msg, th);
      return generateServerError(msg, th);
    }

  }

  @Override
  public void closeTransaction(String transactionID) throws Exception {

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

    Timestamp expired = new Timestamp(now - Constants.EXPIRATION_TIME_MS);

    Where where = Where.AND(TransaccioFields.DATAFI.isNull(),
        TransaccioFields.DATAINICI.lessThan(expired));

    List<Long> caducades = transaccioLogicaEjb.executeQuery(TransaccioFields.TRANSACCIOID,
        where);

    for (Long tid : caducades) {
      try {

        TransaccioJPA trans = transaccioLogicaEjb.findByPrimaryKey(tid);
        trans.setEstatCodi(ScanWebSimpleStatus.STATUS_EXPIRED);
        trans.setDataFi(new Timestamp(now));

        log.warn("Marcant transaccio com caducada: " + trans.getTransactionWebId());
        transaccioLogicaEjb.update(trans);

      } catch (Exception e) {
        log.error("Error desconegut"
            + " netejant transaccions expirades de l'APIScanWebSimple: " + e.getMessage(), e);
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

}
