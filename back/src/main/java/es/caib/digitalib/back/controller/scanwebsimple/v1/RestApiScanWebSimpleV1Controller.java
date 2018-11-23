package es.caib.digitalib.back.controller.scanwebsimple.v1;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.SubQuery;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.ApiScanWebSimple;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfile;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfiles;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleFile;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleScanResult;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleScannedFileInfo;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStartTransactionRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.caib.digitalib.back.controller.all.RestScanWebProcessController;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioQueryPath;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.utils.Constants;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created 19/11/18 10:10
 *
 * @author anadal
 */
@Controller
@RequestMapping(value = RestApiScanWebSimpleV1Controller.CONTEXT)
public class RestApiScanWebSimpleV1Controller extends RestApiScanWebUtils {

  public static final String CONTEXT = "/common/rest/apiscanwebsimple/v1";

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioLocal usuariAplicacioEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;

  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  // XYZ ZZZ ZZZ ELIMINAR !!! HA d'ANAR A BBDD !!!!!!!!
  // protected static final Map<String, TransactionInfo> currentTransactions = new
  // HashMap<String, RestApiScanWebSimpleV1Controller.TransactionInfo>();

  @RequestMapping(value = "/" + ApiScanWebSimple.AVAILABLEPROFILES, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getAvailableProfiles(HttpServletRequest request,
      @RequestBody String locale) {

    String error = autenticate(request, locale, usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {

      RestLoginInfo restLoginInfo = commonChecks();

      LoginInfo loginInfo = restLoginInfo.loginInfo;

      log.info(" XYZ ZZZ LOGININFO => " + loginInfo);

      // Checks Globals
      if (loginInfo.getUsuariPersona() != null) {
        throw new Exception("Aquest servei només el poden fer servir el usuariAPP XYZ ZZZ");
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

        for (Perfil perfil : perfils) {
          ScanWebSimpleAvailableProfile ap = new ScanWebSimpleAvailableProfile(
              perfil.getCodi(), perfil.getNom(), perfil.getDescripcio());
          list.add(ap);
        }

        fsap.setAvailableProfiles(list);

      }

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleAvailableProfiles>(fsap, headers,
          HttpStatus.OK);

      return re;

    } catch (Throwable th) {

      // XYZ ZZZ Traduir XYZ ZZZ ZZZ
      String msg = "Error desconegut retornant el perfils d'un usuari aplicacio: "
          + th.getMessage();

      log.error(msg, th);

      return generateServerError(msg, th);
    }

  }

  @RequestMapping(value = "/" + ApiScanWebSimple.GETTRANSACTIONID, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getTransactionID(HttpServletRequest request,
      @RequestBody ScanWebSimpleGetTransactionIdRequest requestTransactionID) {

    String language = "ca";

    String error = autenticate(request, language, usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    // Fer neteja de transaccions Obsoletes !!!!
    try {
      cleanExpiredTransactions();
    } catch (I18NException e2) {
      // XYZ ZZZ ZZZ
      String msg = "Error fent neteja de transaccions caducades: "
          + I18NLogicUtils.getMessage(e2, new Locale(language));
      return generateServerError(msg, e2.getCause());
    }

    // Check de requestTransactionID
    if (requestTransactionID == null) {
      return generateServerError("El parametre d'entrada no pot ser null.");
    }

    // Valida Idioma
    String lang = requestTransactionID.getLanguageUI();
    if (lang == null || lang.trim().length() == 0) {
      return generateServerError("El camp LanguageUI del tipus FirmaSimpleCommonInfo no pot ser null o buit.");
    }

    // XYZ ZZZ ZZZ Valida Idioma DOC
    
    final String transactionWebID = internalGetTransacction();

    // Valida Perfil
    String scanWebProfile = requestTransactionID.getScanWebProfile();
    if (scanWebProfile == null || scanWebProfile.trim().length() == 0) {
      return generateServerError("El camp scanWebProfile no pot ser null o buit.");
    }

    UsuariAplicacioJPA usuariAplicacio = usuariAplicacioCache.get();

    PerfilUsuariAplicacioQueryPath qp = new PerfilUsuariAplicacioQueryPath();

    Long perfilID = null;
    try {
      perfilID = perfilUsuariAplicacioEjb.executeQueryOne(qp.PERFIL().PERFILID(), Where.AND(
          PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(usuariAplicacio
              .getUsuariAplicacioID()),
          // Dels perfils assignats esta el del codi enviat
          qp.PERFIL().CODI().equal(scanWebProfile)));
    } catch (I18NException e1) {
      log.error("Error desconegut cercant perfil"
          + I18NLogicUtils.getMessage(e1, new Locale("ca")));
    }

    if (perfilID == null) {
      return generateServerError("El pefil " + scanWebProfile
          + " no està assignat a usuari aplicacio " + usuariAplicacio.getUsername());
    }

    PerfilJPA perfil = perfilEjb.findByPrimaryKey(perfilID);

    PerfilJPA clonedPerfil = PerfilJPA.toJPA(perfil);

    clonedPerfil.setCodi(clonedPerfil.getCodi() + "-" + transactionWebID);
    clonedPerfil.setPerfilID(0);
    clonedPerfil.setUsPerfil(Constants.PERFIL_US_TRANSACCIO_INFO);

    // XYZ ZZZ ZZZ Falten altres comprovacions


    HttpHeaders headers = addAccessControllAllowOrigin();
    ResponseEntity<?> res = new ResponseEntity<String>(transactionWebID, headers, HttpStatus.OK);

    TransaccioJPA t = new TransaccioJPA();

    t.setDatainici(new Timestamp(System.currentTimeMillis()));
    t.setEstatcodi(ScanWebSimpleStatus.STATUS_REQUESTED_ID);
    t.setTransactionWebId(transactionWebID);
    t.setLanguageui(requestTransactionID.getLanguageUI());
    t.setLanguagedoc(requestTransactionID.getLanguageDoc());

    t.setUsuariaplicacioid(usuariAplicacio.getUsuariAplicacioID());
    t.setUsuaripersonaid(null); // Falta cercarla a partir de
                                // requestTransactionID.usernameRequest;

    t.setFuncionariusername(requestTransactionID.getFuncionariUsername());
    t.setFuncionarinom(requestTransactionID.getFuncionariNom());
    t.setCiutadanif(requestTransactionID.getCiutadaNif());
    t.setCiutadanom(requestTransactionID.getCiutadaNom());
    t.setExpedient(requestTransactionID.getExpedientID());

    t.setPerfil(clonedPerfil);

    try {
      transaccioLogicaEjb.createWithProfile(t);
    } catch (I18NException e) {
      return generateServerError("Error creant la transaccio amb Perfil");
    }

    return res;

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

    String error = autenticate(request, "ca", usuariAplicacioEjb);
    if (error != null) {
      return generateServerError(error, HttpStatus.UNAUTHORIZED);
    }

    try {
      cleanExpiredTransactions();
    } catch (I18NException e2) {
      // XYZ ZZZ ZZZ
      String msg = "Error fent neteja de transaccions caducades: "
          + I18NLogicUtils.getMessage(e2, new Locale(languageUI));
      return generateServerError(msg, e2.getCause());
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
          // XYZ ZZZ ZZZ
          String msg = "NO existeix la transacció amb ID " + transactionWebID;
          return generateServerError(msg);
        }

        if (transaccio.getEstatcodi() < 0) {
          // XYZ ZZZ ZZZ
          String msg = "La transacció amb ID " + transactionWebID + " te un estat no vàlid ("
              + transaccio.getEstatcodi() + ") per iniciar el proces d'escaneig.";
          return generateServerError(msg);
        }

      }

      languageUI = transaccio.getLanguageui();

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

      int view = startTransactionRequest.getView();

      if (view == ScanWebSimpleStartTransactionRequest.VIEW_FULLSCREEN
          || view == ScanWebSimpleStartTransactionRequest.VIEW_IFRAME) {
        // OK
        transaccio.setView(view);
      } else {

        // XYZ ZZZ ZZZ
        String msg = "La transacció amb ID " + transactionWebID + " s'ha intentat iniciar"
            + "amb un id de vista desconegut (" + view + ")";
        return generateServerError(msg);

      }

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
      // XYZ ZZZ TODO Això ho ha de collir de la propietat URL PortaFIB de
      // UsuariApplicacioConfig
      // XYZ ZZZ TODO Configurar que si getAppUrl val null llavors llanci excepció
      final String redirectUrl = urlBase + RestScanWebProcessController.SCANWEB_CONTEXTPATH + "/start/"
          + transaccio.getTransactionWebId();
      if (log.isDebugEnabled()) {
        log.debug("Inici de TRANSACCIO SCANWEB = " + redirectUrl);
      }

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<String>(redirectUrl, headers, HttpStatus.OK);
      log.info(" XYZ ZZZ SURT DE startTransaction => FINAL OK");

      transaccio.setEstatcodi(ScanWebSimpleStatus.STATUS_IN_PROGRESS);
      transaccioLogicaEjb.update(transaccio);

      return re;
      /*
       * } catch (I18NValidationException i18nve) {
       * 
       * String idioma = ti.getRequestTransactionID().getLanguageUI(); String msg =
       * I18NLogicUtils.getMessage(i18nve, new Locale(idioma)); log.error(msg, i18nve); return
       * generateServerError(msg);
       */
    } catch (I18NException i18ne) {

      String msg = I18NLogicUtils.getMessage(i18ne, new Locale(languageUI));

      log.error(msg, i18ne);

      return generateServerError(msg);

    } catch (Throwable th) {

      // XYZ ZZZ ZZZ TRADUIR
      String msg = "Error desconegut iniciant el proces de Firma: " + th.getMessage();

      log.error(msg, th);

      return generateServerError(msg, th);
    }

  }


  @RequestMapping(value = "/" + ApiScanWebSimple.TRANSACTIONSTATUS, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getTransactionStatus(@RequestBody String transactionID,
      HttpServletRequest request) {
    try {

      log.info(" XYZ ZZZ ENTRA A getTransactionStatus => " + transactionID);

      String error = autenticate(request, "ca", usuariAplicacioEjb);
      if (error != null) {
        return generateServerError(error, HttpStatus.UNAUTHORIZED);
      }

      ScanWebSimpleStatus status = new ScanWebSimpleStatus();

      // XYZ ZZZ ZZZ LLegir de BBDD per saber l'estat !!!!

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleStatus>(status, headers,
          HttpStatus.OK);
      log.info(" XYZ ZZZ surt de  getTransactionStatus => FINAL OK");

      return re;

    } catch (Throwable th) {
      final String msg = "Error desconegut intentant recuperar informació de l'estat de la transacció: "
          + transactionID + ": " + th.getMessage();

      log.error(msg, th);

      return generateServerError(msg, th);
    }

  }

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

    String languageUI = "ca";

    try {
      // Clean Transactions caducades
      cleanExpiredTransactions();
    } catch (I18NException e2) {
      // XYZ ZZZ ZZZ
      String msg = "Error fent neteja de transaccions caducades: "
          + I18NLogicUtils.getMessage(e2, new Locale(languageUI));
      return generateServerError(msg, e2.getCause());
    }

    // XYZ ZZZ
    // Revisar que existeix currentTransaccitions

    try {

      // if (result == null) {
      // // XYZ ZZZ Traduir
      // String msg = "No s'ha pogut trobar informació de la firma [" + signID
      // + "] de la transacció: " + transactionID;
      // return generateServerError(msg);
      // }
      
      TransaccioJPA transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
      
      

      // TODO XYZ ZZZ ZZZZ
      ScanWebSimpleScanResult fssr = new ScanWebSimpleScanResult();
      
      ScanWebSimpleStatus status = new ScanWebSimpleStatus();
      status.setStatus(transaccio.getEstatcodi());
      status.setErrorStackTrace(transaccio.getEstatexcepcio());
      // XYZ ZZZ Recuperar una Excepcio a partir d'un stack trace
      //status.setErrorException(errorException);
      
      fssr.setStatus(status);
      
      
      if (status.getStatus() == ScanWebSimpleStatus.STATUS_FINAL_OK) {
      
        fssr.setCustodyInfo(null);
        
        fssr.setDetachedSignatureFile(null);
        
        // Document escanejat
        long scannedFileID= transaccio.getFitxerEscanejatID();
        
        byte[] data = FileSystemManager.getFileContent(scannedFileID);

        String nom = transaccio.getFitxerEscanejat().getNom();
        
        // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
        String mime = transaccio.getFitxerEscanejat().getMime();
        
        fssr.setScannedFile(new ScanWebSimpleFile(nom, mime, data));
        
        // Informació de Document escanejat
        Integer pixelType = null;
        Integer pppResolution = null;
        String formatFile =  RestScanWebProcessController.formatFileToScanWebApi(transaccio.getPerfil().getScanFormatFitxer()); // S'ha de treure de Perfil        
        Boolean ocr = null;
        ScanWebSimpleScannedFileInfo scannedFileInfo = new ScanWebSimpleScannedFileInfo(pixelType, pppResolution,
            formatFile, ocr);

        fssr.setScannedFileInfo(scannedFileInfo);

      }

      // // TODO XYZ ZZZ ZZZZ
      // fssr.setStatus(status);
      // // TODO XYZ ZZZ ZZZZ
      // fssr.setDetachedSignatureFile(detachedSignatureFile);
      // fssr.setScannedFile(scannedFile);
      //
      // fssr.setScannedFileInfo(new ScanWebSimpleScannedFileInfo());
      // fssr.setSignedFileInfo(new ScanWebSimpleSignedFileInfo());
      //
      // fssr.setCustodyInfo(new ScanWebSimpleCustodyInfo() );

      HttpHeaders headers = addAccessControllAllowOrigin();
      ResponseEntity<?> re = new ResponseEntity<ScanWebSimpleScanResult>(fssr, headers,
          HttpStatus.OK);
      log.info(" XYZ ZZZ getScanWebResult => FINAL OK");
      return re;

    } catch (Throwable th) {

      // TRADUIR
      final String msg = "Error desconegut intentant recuperar resultat de"
          + " l'escaneig amb numero transacció: " + transactionWebID + ": " + th.getMessage();

      log.error(msg, th);

      return generateServerError(msg, th);
    }

  }

  @RequestMapping(value = "/" + ApiScanWebSimple.CLOSETRANSACTION, method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public void closeTransaction(@RequestBody String transactionID, HttpServletRequest request,
      HttpServletResponse response) {

    log.info(" XYZ ZZZ closeTransaction => ENTRA");

    String error = autenticate(request, "ca", usuariAplicacioEjb);
    if (error != null) {
      try {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, error);
      } catch (IOException e) {
        log.error(e.getMessage(), e);
      }
      return;
    }

    log.info(" XYZ ZZZ closeTransaction => FINAL OK");

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
        trans.setEstatcodi(ScanWebSimpleStatus.STATUS_EXPIRED);
        trans.setDatafi(new Timestamp(now));

        log.warn("Marcant transaccio com caducada: " + trans.getTransactionWebId());
        transaccioLogicaEjb.update(trans);

      } catch (Exception e) {
        log.error("Error desconegut"
            + " netejant transaccions expirades de l'APIScanWebSimple: " + e.getMessage(), e);
      }
    }
  }

  /**
   * 
   * @author anadal
   *
   */
  /*
   * public class VirtualSignaturePlugin implements ISignaturePlugin {
   * 
   * protected String entitatID;
   * 
   * protected List<Long> filterByPluginIDList;
   * 
   * 
   * 
   * 
   * public VirtualSignaturePlugin(String entitatID) { super(); this.entitatID = entitatID; }
   * 
   * @Override public String getName(Locale locale) { return "VirtualSignaturePlugin"; }
   * 
   * public List<Long> getFilterByPluginIDList() { return this.filterByPluginIDList; }
   * 
   * @Override public String[] getSupportedSignatureTypes() { return
   * passarelaDeFirmaWebEjb.getSupportedSignatureTypes(entitatID, getFilterByPluginIDList(),
   * null); }
   * 
   * @Override public String[] getSupportedSignatureAlgorithms(String signType) { return
   * passarelaDeFirmaWebEjb.getSupportedSignatureAlgorithms(signType, entitatID,
   * getFilterByPluginIDList(), null); }
   * 
   * @Override public List<String> getSupportedBarCodeTypes() { try { return
   * passarelaDeFirmaWebEjb.getSupportedBarCodeTypes(); } catch (I18NException e) { log.error(
   * " Error cridant a passarelaDeFirmaWebEjb.getSupportedBarCodeTypes(): " + e.getMessage(),
   * e); return null; } }
   * 
   * 
   * @return true true indica que el plugin accepta generadors de Segell de Temps definits dins
   * FileInfoSignature.timeStampGenerator
   * 
   * @Override public boolean acceptExternalTimeStampGenerator(String signType) { return false;
   * }
   * 
   * 
   * 
   * @return true, indica que el plugin internament ofereix un generador de segellat de temps.
   * 
   * @Override public boolean providesTimeStampGenerator(String signType) {
   * 
   * // S'ha de fer una cridada a PortaFIB per a que passi per tots // els plugins a veure si
   * suporten estampació de segellat de temps per // aquest tipus try { return
   * passarelaDeFirmaWebEjb.providesTimeStampGenerator(signType, entitatID,
   * getFilterByPluginIDList(), null); } catch (Exception e) { log.error(e.getMessage(), e); }
   * 
   * return false;
   * 
   * }
   * 
   * @Override public boolean acceptExternalRubricGenerator() { return false; }
   * 
   * @Override public boolean providesRubricGenerator() { return true; }
   * 
   * @Override public boolean acceptExternalSecureVerificationCodeStamper() { return false; }
   * 
   * @Override public boolean providesSecureVerificationCodeStamper() { return true; } }
   */

  /**
   * 
   * @author anadal
   *
   */
  /*
   * public class TransactionInfo {
   * 
   * 
   * public static final int STATUS_RESERVED_ID = 0;
   * 
   * public static final int STATUS_IN_PROGRESS = 1;
   * 
   * final String transactionID;
   * 
   * final ScanWebSimpleGetTransactionIdRequest requestTransactionID;
   * 
   * ScanWebSimpleScanResult result = null;
   * 
   * public int internalStatus = -1;
   * 
   * final Date startTime;
   * 
   * *
   * 
   * @param transactionID
   * 
   * @param startTime
   * 
   * @param status
   * 
   * public TransactionInfo(String transactionID, ScanWebSimpleGetTransactionIdRequest
   * requestTransactionID, int internalStatus) { super(); this.transactionID = transactionID;
   * this.startTime = new Date(); this.requestTransactionID = requestTransactionID;
   * 
   * this.internalStatus = internalStatus; }
   * 
   * public String getTransactionID() { return transactionID; }
   * 
   * public Date getStartTime() { return startTime; }
   * 
   * public ScanWebSimpleScanResult getResult() { return result; }
   * 
   * public void setResult(ScanWebSimpleScanResult result) { this.result = result; }
   * 
   * public ScanWebSimpleGetTransactionIdRequest getRequestTransactionID() { return
   * requestTransactionID; }
   * 
   * public int getInternalStatus() { return internalStatus; }
   * 
   * public void setInternalStatus(int internalStatus) { this.internalStatus = internalStatus;
   * }
   * 
   * }
   */

}
