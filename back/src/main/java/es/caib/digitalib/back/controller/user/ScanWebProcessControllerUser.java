package es.caib.digitalib.back.controller.user;

import java.net.URL;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xerces.impl.dv.util.Base64;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.AbstractScanWebModuleController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.back.form.ScanWebConfigForm;
import es.caib.digitalib.back.form.ScanWebConfigValidator;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.utils.ScanWebUtils;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;

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

  /** Logger for this class and subclasses */
  /*
   * protected final Logger log = Logger.getLogger(getClass());
   */

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariPersonaLocal usuariPersonaEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioGrupLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioGrupLocal configuracioGrupEjb;

  /*
   * @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME) protected TransaccioLogicaLocal
   * transaccioLogicaEjb;
   */

  // XYZ ZZZ
  // public static final String LAST_SCANNED_FILES = "LAST_SCANNED_FILES";
  //
  // public static final String LAST_CONFIG = "LAST_CONFIG";

  // XYZ ZZZ Eliminar
  @Autowired
  protected ScanWebConfigValidator scanWebValidator;

  @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
  protected ScanWebModuleLocal scanWebModuleEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  /**
   * 
   */
  public ScanWebProcessControllerUser() {
    super();
  }

  /*
   * @RequestMapping(value = "/form", method = RequestMethod.GET) public ModelAndView
   * scanWebGet(HttpServletRequest request) throws Exception {
   * 
   * ScanWebConfigForm form = new ScanWebConfigForm();
   * 
   * form.setMode("S"); // S = Sincron | A=Asincron
   * 
   * // Acceptam qualsevol combinació Set<String> flags = new HashSet<String>();
   * form.setFlags(flags);
   * 
   * form.setId(String.valueOf(ScanWebModuleController.generateUniqueScanWebID()));
   * 
   * List<String> supportedTypes = new ArrayList<String>();
   * supportedTypes.add(IScanWebPlugin.SCANTYPE_PDF);
   * supportedTypes.add(IScanWebPlugin.SCANTYPE_JPG);
   * supportedTypes.add(IScanWebPlugin.SCANTYPE_PNG);
   * supportedTypes.add(IScanWebPlugin.SCANTYPE_GIF);
   * supportedTypes.add(IScanWebPlugin.SCANTYPE_TIFF);
   * 
   * List<String> supportedFlags = new ArrayList<String>();
   * supportedFlags.add(IScanWebPlugin.FLAG_NON_SIGNED);
   * supportedFlags.add(IScanWebPlugin.FLAG_SIGNED);
   * supportedFlags.add(IScanWebPlugin.FLAG_TIMESTAMP);
   * supportedFlags.add(IScanWebPlugin.FLAG_CSV);
   * 
   * ModelAndView mav = new ModelAndView("scanWebForm"); mav.addObject(form);
   * 
   * mav.addObject("supportedTypes", supportedTypes); mav.addObject("supportedFlags",
   * supportedFlags);
   * 
   * return mav;
   * 
   * }
   * 
   * @RequestMapping(value = "/form", method = RequestMethod.POST) public ModelAndView
   * scanWebPost(HttpServletRequest request, HttpServletResponse response,
   * 
   * @ModelAttribute ScanWebConfigForm form, BindingResult result) throws Exception {
   * 
   * scanWebValidator.validate(form, result);
   * 
   * if (result.hasErrors()) { ModelAndView mav = new ModelAndView("scanWebForm");
   * mav.addObject(form); return mav; }
   * 
   * final String scanWebID = form.getId();
   * 
   * final String scanType = form.getType();
   * 
   * Set<String> flags = form.getFlags(); if (flags != null && flags.size() == 0) { flags =
   * null; // acceptam la primera configuració disponible del plugin }
   * 
   * // TODO per ara està buit final List<Metadata> metadades = new ArrayList<Metadata>();
   * 
   * ScanWebMode mode = "S".equals("" + form.getMode()) ? ScanWebMode.SYNCHRONOUS :
   * ScanWebMode.ASYNCHRONOUS;
   * 
   * String languageUI = form.getLangUI();
   * 
   * String relativeControllerBase = ScanWebModuleController.getRelativeControllerBase(request,
   * CONTEXTWEB); final String urlFinal = relativeControllerBase + "/final/" + scanWebID;
   * 
   * // Vull suposar que abans de 20 minuts haurà escanejat Calendar caducitat =
   * Calendar.getInstance(); caducitat.add(Calendar.MINUTE, 20);
   * 
   * long expiryTransaction = caducitat.getTimeInMillis();
   * 
   * ScanWebConfigTester swc = new ScanWebConfigTester(scanWebID, scanType, flags, metadades,
   * mode, languageUI, urlFinal, expiryTransaction);
   * 
   * String urlBase = ScanWebModuleController.getAbsoluteURLBase(request);
   * 
   * final boolean isPublic = false;
   * 
   * // /WEB-INF/views/plugindescan_contenidor.jsp final String view =
   * "plugindescan_contenidor"; ModelAndView mav =
   * ScanWebModuleController.startScanWebProcess(request, view, scanWebModuleEjb, swc, urlBase,
   * isPublic);
   * 
   * return mav;
   * 
   * }
   */

  @RequestMapping(value = "/start/{baseURL64}", method = RequestMethod.GET)
  public ModelAndView scanWebGet(HttpServletRequest request,
      @PathVariable("baseURL64") String baseURL64) throws Exception {

    try {

      // XYZ ZZZ Llegir-ho de LoginINfo
      // Usuari Té configuració de grup assignada

      String username = LoginInfo.getInstance().getUsername();

      log.info("XYZ ZZZ Username = " + username);

      String baseURLFull = new String(Base64.decode(baseURL64));

      log.info("XYZ ZZZ BaseURL ORIGINAL FULL = " + baseURLFull);

      Long usuariPersonaID = usuariPersonaEjb.executeQueryOne(
          UsuariPersonaFields.USUARIPERSONAID, UsuariPersonaFields.USERNAME.equal(username));

      log.info("XYZ ZZZ usuariPersonaID = " + usuariPersonaID);
      if (usuariPersonaID == null) {
        // XYZ ZZZ Traduir
        HtmlUtils.saveMessageError(request,
            "No hi ha informació d'aquet usuari. Consulti amb el seu administrador");
        ModelAndView mav = new ModelAndView(new RedirectView("/canviarPipella/user", true));
        return mav;
      }

      UsuariPersonaJPA usuariPersona = usuariPersonaEjb.findByPrimaryKey(usuariPersonaID);

      Long configGrupID = usuariPersona.getConfiguraciogrupid();

      if (configGrupID == null) {
        // XYZ ZZZ Traduir
        HtmlUtils
            .saveMessageError(
                request,
                "No està assignat a cap Configuració de Grup. Contacti amb el seu administrador per solventar aquest problema.");
        ModelAndView mav = new ModelAndView(new RedirectView("/canviarPipella/user", true));
        return mav;
      }

      ConfiguracioGrupJPA configGrup = configuracioGrupEjb.findByPrimaryKey(configGrupID);

      Long perfilID;
      switch (getTipusPerfil()) {
      case 1: // Només Escaneig XYZ ZZZ Constants.PERFIL_US_NOMES_ESCANEIG
        perfilID = configGrup.getPerfilNomesEscaneigID();
        break;

      case 2:
        // XYZ ZZZ Falta
      case 3:
        // XYZ ZZZ Falta

      default:
        // XYZ ZZZ
        HtmlUtils.saveMessageError(request, "Tipus Perfil desconegut " + getTipusPerfil());
        ModelAndView mav = new ModelAndView(new RedirectView("/canviarPipella/user", true));
        return mav;
      }

      String scanWebProfile = perfilEjb.executeQueryOne(PerfilFields.CODI,
          PerfilFields.PERFILID.equal(perfilID));

      log.info("PERFIL CODI = " + scanWebProfile);

      // XYZ ZZZ M'ho han de passar de pagina web
      String languageDoc = "ca";
      String usernameRequest = username;

      // XYZ ZZZ recollir de Web quan Copia Autentica
      String ciutadaNif = null;
      String ciutadaNom = null;
      String funcionariNom = "Funcionari DeProfessio";
      String funcionariUsername = username;
      String funcionariNif = "12345678X";

      // XYZ ZZZ recollir de Web quan Custodia
      String expedientID = null;

      Locale locale = LocaleContextHolder.getLocale();
      String languageUI = locale.getLanguage();

      final int view = ScanWebSimpleGetTransactionIdRequest.VIEW_IFRAME;

      ScanWebSimpleGetTransactionIdRequest requestTransaction;
      requestTransaction = new ScanWebSimpleGetTransactionIdRequest(scanWebProfile, view,
          languageUI, languageDoc, usernameRequest, ciutadaNif, ciutadaNom,
          funcionariUsername, funcionariNom, funcionariNif, expedientID);

      // final String transactionWebID = internalGetTransacction();
      //
      // // Valida Perfil
      // String scanWebProfile = requestTransactionID.getScanWebProfile();
      // if (scanWebProfile == null || scanWebProfile.trim().length() == 0) {
      // return generateServerError("El camp scanWebProfile no pot ser null o buit.");
      // }

      // String relativeControllerBase =
      // ScanWebModuleController.getRelativeControllerBase(request,
      // CONTEXTWEB);

      URL url = new URL(baseURLFull);

      String baseUrl = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort()
          + request.getContextPath();
      log.info("XYZ ZZZ  baseUrl OK = " + baseUrl);

      // http://10.215.216.175:8080/digitalib/user/llistatperfilsdisponibles

      String urlRetorn = baseUrl + "/user/llistatperfilsdisponibles";

      TransaccioJPA transaction = transaccioLogicaEjb.crearTransaccio(requestTransaction,
          null, usuariPersona, urlRetorn);

      final String transactionWebID = transaction.getTransactionWebId();

      // TODO per ara està buit

      final String urlFinal = baseUrl + CONTEXTWEB + "/final/" + transactionWebID;

      log.info("XYZ ZZZ WEB USER urlFinal OK = " + urlFinal);

      // final String urlFinal = urlBase + SCANWEB_CONTEXTPATH + SCANWEB_CONTEXTPATH_FINAL +
      // "/"
      // + transactionWebID;

      ScanWebConfig swc = ScanWebUtils.generateScanWebConfig(transaction, urlFinal);

      final boolean isPublic = false;

      // /WEB-INF/views/plugindescan_contenidor.jsp
      final String viewModel = "plugindescan_contenidor";

      final boolean fullView = (transaction.getView() == ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN);

      ModelAndView mav = startScanWebProcess(request, viewModel,
          transaction.getTransactionWebId(), swc, baseUrl,
          AbstractScanWebModuleController.getContextWeb(isPublic), fullView);

      return mav;

    } catch (I18NException e) {

      // XYZ ZZZ
      HtmlUtils.saveMessageError(request, "Error general iniciant el proces d'escaneig: "
          + I18NUtils.getMessage(e));
      ModelAndView mav = new ModelAndView(new RedirectView("/canviarPipella/user", true));
      return mav;
    }

  }

  protected int getTipusPerfil() {
    return 1; // Només Escaneig XYZ ZZZ Constants.PERFIL_US_NOMES_ESCANEIG
  }

  @RequestMapping(value = SCANWEB_CONTEXTPATH_FINAL + "/{transactionWebID}")
  public ModelAndView finalProcesDeScanWeb(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transactionWebID") String transactionWebID)
      throws Exception, I18NException {

    ModelAndView mav = super.finalProcesDeScanWeb(request, response, transactionWebID);

    TransaccioJPA transaccio = transaccioLogicaEjb
        .searchTransaccioByTransactionWebID(transactionWebID);

    int status = transaccio.getEstatcodi();

    if (status == ScanWebSimpleStatus.STATUS_FINAL_OK) {
      HtmlUtils.saveMessageSuccess(request, "Operacio realitzada correctament");
      return new ModelAndView(new RedirectView("/user/transaccio/view/"
          + transaccio.getTransaccioID() , true));
    }

    if (transaccio.getEstatmissatge() == null) {

      switch (status) {
      case ScanWebSimpleStatus.STATUS_IN_PROGRESS:
        // XYZ ZZZ
        transaccio.setEstatmissatge("Estat inconsistent: EN PROGRESS");
        break;
      case ScanWebSimpleStatus.STATUS_EXPIRED:
        // XYZ ZZZ
        transaccio.setEstatmissatge("Estat inconsistent: EXPIRED");
        break;
      case ScanWebSimpleStatus.STATUS_REQUESTED_ID:
        // XYZ ZZZ
        transaccio.setEstatmissatge("Estat inconsistent: REQUESTEDID");

        break;

      default:
        transaccio.setEstatmissatge("Estat final desconegut: " + status);
      }
      transaccioLogicaEjb.update(transaccio);

    }

    HtmlUtils.saveMessageError(request, transaccio.getEstatmissatge());

    /*
     * 
     * if (status == ScanWebSimpleStatus.STATUS_IN_PROGRESS || || status ==
     * ScanWebSimpleStatus.STATUS_EXPIRED || status ==ScanWebSimpleStatus.STATUS_REQUESTED_ID)
     * {
     * 
     * HtmlUtils }
     * 
     * 
     * if (status == ScanWebStatus.STATUS_FINAL_ERROR) {
     * 
     * 
     * } else if (status == ScanWebStatus.STATUS_CANCELLED) {
     * 
     * if (transaccio.getEstatmissatge() == null) { // XYZ ZZZ traduir
     * transaccio.setEstatmissatge("plugindescan.cancelat"); } } else if (status ==
     * ScanWebStatus.STATUS_IN_PROGRESS) {
     * 
     * 
     * //
     */

    return mav;

  }

  /*
   * 
   * @RequestMapping(value = "/final/{scanWebID}") public ModelAndView
   * finalProcesDeScan(HttpServletRequest request, HttpServletResponse response,
   * @PathVariable("scanWebID") String scanWebID) throws Exception {
   * 
   * ScanWebConfig swc; swc = scanWebModuleEjb.getScanWebConfig(request, scanWebID);
   * 
   * ScanWebStatus scanWebStatus = swc.getStatus();
   * 
   * ScanWebStatus statusError = null;
   * 
   * int status = scanWebStatus.getStatus();
   * 
   * if (status == ScanWebStatus.STATUS_FINAL_ERROR) { statusError = scanWebStatus; } else if
   * (status == ScanWebStatus.STATUS_CANCELLED) {
   * 
   * if (scanWebStatus.getErrorMsg() == null) {
   * scanWebStatus.setErrorMsg("plugindescan.cancelat"); } statusError = scanWebStatus; } else
   * if (status == ScanWebStatus.STATUS_IN_PROGRESS) { // Comprovam que s'hagin escanejat coses
   * 
   * List<ScannedDocument> listDocs = swc.getScannedFiles();
   * 
   * if (listDocs.size() == 0) { statusError = new ScanWebStatus();
   * statusError.setErrorMsg(" L'usuari no ha escanejat cap fitxer."); } else { // XYZ ZZZ
   * //request.getSession().setAttribute(LAST_SCANNED_FILES, listDocs);
   * //request.getSession().setAttribute(LAST_CONFIG, swc);**
   * 
   * // FIRMAR I CUSTODIAR !!!
   * 
   * 
   * 
   * }
   * 
   * } else { String inconsistentState = "El mòdul d´escaneig ha finalitzat inesperadament" +
   * " amb un estat desconegut " + status; statusError = new ScanWebStatus();
   * scanWebStatus.setErrorMsg(inconsistentState); scanWebStatus.setErrorException(new
   * Exception()); }
   * 
   * scanWebModuleEjb.closeScanWebProcess(request, scanWebID);
   * 
   * String urlRetorn = request.getContextPath() + CONTEXTWEB + "/form";
   * 
   * if (statusError != null) {
   * 
   * if (statusError.getErrorMsg() == null) { statusError
   * .setErrorMsg("Error desconegut ja que no s'ha definit el missatge de l'error !!!!!"); } //
   * Mostrar excepció per log if (statusError.getErrorException() == null) {
   * log.error(statusError.getErrorMsg()); } else { log.error(statusError.getErrorMsg(),
   * statusError.getErrorException()); }
   * 
   * HtmlUtils.saveMessageError(request, statusError.getErrorMsg());
   * 
   * ModelAndView mav = new ModelAndView("finalsortiriframe"); mav.addObject("urlRetorn",
   * urlRetorn); return mav;
   * 
   * 
   * } else {
   * 
   * ModelAndView mav = new ModelAndView("scanWebFinal"); mav.addObject("urlRetorn",
   * urlRetorn);
   * 
   * return mav; }
   * 
   * }
   */
  /**
   * XYZ ZZZZ Descàrrega del document escanejat
   */
  /*
   * @RequestMapping(value = "/download/{index}", method = RequestMethod.GET) public void
   * download(@PathVariable("index") int index, HttpServletRequest request, HttpServletResponse
   * response) throws Exception { download(index, false, response, request); }
   */

  /**
   * XYZ ZZZZ Descàrrega del document escanejat ja firmat
   */
  /*
   * XYZ ZZZ
   * 
   * @RequestMapping(value = "/downloadSignature/{index}", method = RequestMethod.GET) public
   * void downloadSignature(@PathVariable("index") int index, HttpServletRequest request,
   * HttpServletResponse response) throws Exception { download(index, true, response, request);
   * }
   */

  /**
   * 
   * @param index
   * @param isSignature
   * @param response
   * @param request
   * @throws Exception
   */
  /*
   * private void download(int index, boolean isSignature, HttpServletResponse response,
   * HttpServletRequest request) throws Exception {
   * 
   * List<ScannedDocument> listDocs = (List<ScannedDocument>) request.getSession()
   * .getAttribute(LAST_SCANNED_FILES);
   * 
   * ScannedDocument sd = listDocs.get(index);
   * 
   * AnnexCustody file = isSignature ? sd.getScannedSignedFile() : sd.getScannedPlainFile();
   * 
   * final byte[] data = file.getData();
   * 
   * if (data == null || data.length == 0) {
   * response.setStatus(HttpServletResponse.SC_NO_CONTENT); return; }
   * 
   * String mime = file.getMime(); String filename = file.getName(); if (mime == null ||
   * mime.trim().length() == 0) { mime = "application/octet-stream"; }
   * 
   * { response.setContentType(mime); response.setHeader("Content-Disposition",
   * "inline; filename=\"" + filename + "\""); response.setContentLength(data.length);
   * 
   * java.io.OutputStream output = response.getOutputStream();
   * 
   * output.write(data);
   * 
   * output.flush(); } }
   */

  @InitBinder("scanWebForm")
  public void initBinder(WebDataBinder binder) {

    binder.setValidator(this.scanWebValidator);

    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

  }

}
