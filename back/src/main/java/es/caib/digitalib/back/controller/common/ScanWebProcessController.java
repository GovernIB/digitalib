package es.caib.digitalib.back.controller.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.plugins.documentcustody.api.AnnexCustody;
import org.fundaciobit.plugins.scanweb.api.IScanWebPlugin;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.plugins.scanweb.api.ScanWebMode;
import org.fundaciobit.plugins.scanweb.api.ScanWebStatus;
import org.fundaciobit.plugins.scanweb.api.ScannedDocument;
import org.fundaciobit.pluginsib.core.utils.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.ScanWebModuleController;
import es.caib.digitalib.back.form.ScanWebConfigForm;
import es.caib.digitalib.back.form.ScanWebConfigValidator;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.utils.ScanWebConfigTester;

/**
 *
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = ScanWebProcessController.CONTEXTWEB)
@SessionAttributes(types = { ScanWebConfigForm.class })
public class ScanWebProcessController {

  /** Logger for this class and subclasses */
  protected final Logger log = Logger.getLogger(getClass());

  public static final String CONTEXTWEB = "/common/scan";

  public static final String LAST_SCANNED_FILES = "LAST_SCANNED_FILES";
  
  public static final String LAST_CONFIG = "LAST_CONFIG";

  @Autowired
  protected ScanWebConfigValidator scanWebValidator;

  @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
  protected ScanWebModuleLocal scanWebModuleEjb;

  /**
   * 
   */
  public ScanWebProcessController() {
    super();
  }

  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public ModelAndView scanWebGet(HttpServletRequest request) throws Exception {

    ScanWebConfigForm form = new ScanWebConfigForm();

    form.setMode("S"); // S = Sincron | A=Asincron

    // Acceptam qualsevol combinació
    Set<String> flags = new HashSet<String>();
    form.setFlags(flags);

    form.setId(String.valueOf(ScanWebModuleController.generateUniqueScanWebID()));

    List<String> supportedTypes = new ArrayList<String>();
    supportedTypes.add(IScanWebPlugin.SCANTYPE_PDF);
    supportedTypes.add(IScanWebPlugin.SCANTYPE_JPG);
    supportedTypes.add(IScanWebPlugin.SCANTYPE_PNG);
    supportedTypes.add(IScanWebPlugin.SCANTYPE_GIF);
    supportedTypes.add(IScanWebPlugin.SCANTYPE_TIFF);

    List<String> supportedFlags = new ArrayList<String>();
    supportedFlags.add(IScanWebPlugin.FLAG_NON_SIGNED);
    supportedFlags.add(IScanWebPlugin.FLAG_SIGNED);
    supportedFlags.add(IScanWebPlugin.FLAG_TIMESTAMP);
    supportedFlags.add(IScanWebPlugin.FLAG_CSV);

    ModelAndView mav = new ModelAndView("scanWebForm");
    mav.addObject(form);

    mav.addObject("supportedTypes", supportedTypes);
    mav.addObject("supportedFlags", supportedFlags);

    return mav;

  }

  @RequestMapping(value = "/form", method = RequestMethod.POST)
  public ModelAndView scanWebPost(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute ScanWebConfigForm form, BindingResult result) throws Exception {

    scanWebValidator.validate(form, result);

    if (result.hasErrors()) {
      ModelAndView mav = new ModelAndView("scanWebForm");
      mav.addObject(form);
      return mav;
    }

    final String scanWebID = form.getId();

    final String scanType = form.getType();

    Set<String> flags = form.getFlags();
    if (flags != null && flags.size() == 0) {
      flags = null; // acceptam la primera configuració disponible del plugin
    }

    // TODO per ara està buit
    final List<Metadata> metadades = new ArrayList<Metadata>();

    ScanWebMode mode = "S".equals("" + form.getMode()) ? ScanWebMode.SYNCHRONOUS
        : ScanWebMode.ASYNCHRONOUS;

    String languageUI = form.getLangUI();

    String relativeControllerBase = ScanWebModuleController.getRelativeControllerBase(request,
        CONTEXTWEB);
    final String urlFinal = relativeControllerBase + "/final/" + scanWebID;

    // Vull suposar que abans de 20 minuts haurà escanejat
    Calendar caducitat = Calendar.getInstance();
    caducitat.add(Calendar.MINUTE, 20);

    long expiryTransaction = caducitat.getTimeInMillis();

    ScanWebConfigTester swc = new ScanWebConfigTester(scanWebID, scanType, flags, metadades,
        mode, languageUI, urlFinal, expiryTransaction);

    String urlBase = ScanWebModuleController.getAbsoluteURLBase(request);
    
    final boolean isPublic = false;
    
    // /WEB-INF/views/plugindescan_contenidor.jsp
    final String view = "plugindescan_contenidor";
    ModelAndView mav = ScanWebModuleController.startScanWebProcess(request, view,
        scanWebModuleEjb, swc, urlBase, isPublic);

    return mav;

  }
  
  

  
  

  @RequestMapping(value = "/final/{scanWebID}")
  public ModelAndView finalProcesDeScan(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("scanWebID") String scanWebID)
      throws Exception {

    ScanWebConfig swc;
    swc = scanWebModuleEjb.getScanWebConfig(request, scanWebID);

    ScanWebStatus scanWebStatus = swc.getStatus();

    ScanWebStatus statusError = null;

    int status = scanWebStatus.getStatus();

    if (status == ScanWebStatus.STATUS_FINAL_ERROR) {
      statusError = scanWebStatus;
    } else if (status == ScanWebStatus.STATUS_CANCELLED) {

      if (scanWebStatus.getErrorMsg() == null) {
        scanWebStatus.setErrorMsg("plugindescan.cancelat");
      }
      statusError = scanWebStatus;
    } else if (status == ScanWebStatus.STATUS_IN_PROGRESS) {
      // Comprovam que s'hagin escanejat coses

      List<ScannedDocument> listDocs = swc.getScannedFiles();

      if (listDocs.size() == 0) {
        statusError = new ScanWebStatus();
        statusError.setErrorMsg(" L'usuari no ha escanejat cap fitxer.");
      } else {
        request.getSession().setAttribute(LAST_SCANNED_FILES, listDocs);
        request.getSession().setAttribute(LAST_CONFIG, swc);
      }

    } else {
      String inconsistentState = "El mòdul d´escaneig ha finalitzat inesperadament"
          + " amb un estat desconegut " + status;
      statusError = new ScanWebStatus();
      scanWebStatus.setErrorMsg(inconsistentState);
      scanWebStatus.setErrorException(new Exception());
    }

    scanWebModuleEjb.closeScanWebProcess(request, scanWebID);

    String urlRetorn = request.getContextPath() + CONTEXTWEB + "/form";
        
    if (statusError != null) {

      if (statusError.getErrorMsg() == null) {
        statusError
            .setErrorMsg("Error desconegut ja que no s'ha definit el missatge de l'error !!!!!");
      }
      // Mostrar excepció per log
      if (statusError.getErrorException() == null) {
        log.error(statusError.getErrorMsg());
      } else {
        log.error(statusError.getErrorMsg(), statusError.getErrorException());
      }

      HtmlUtils.saveMessageError(request, statusError.getErrorMsg());

      ModelAndView mav = new ModelAndView("finalsortiriframe");
      mav.addObject("urlRetorn", urlRetorn);
      return mav; 
      
      
    } else {

      ModelAndView mav = new ModelAndView("scanWebFinal");
      mav.addObject("urlRetorn", urlRetorn);

      return mav;
    }

  }

  /**
   * Descàrrega del document escanejat
   */
  @RequestMapping(value = "/download/{index}", method = RequestMethod.GET)
  public void download(@PathVariable("index") int index, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    download(index, false, response, request);
  }

  /**
   * Descàrrega del document escanejat ja firmat
   */
  @RequestMapping(value = "/downloadSignature/{index}", method = RequestMethod.GET)
  public void downloadSignature(@PathVariable("index") int index, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    download(index, true, response, request);
  }

  /**
   * 
   * @param index
   * @param isSignature
   * @param response
   * @param request
   * @throws Exception
   */
  private void download(int index, boolean isSignature, HttpServletResponse response,
      HttpServletRequest request) throws Exception {

    List<ScannedDocument> listDocs = (List<ScannedDocument>) request.getSession()
        .getAttribute(LAST_SCANNED_FILES);

    ScannedDocument sd = listDocs.get(index);

    AnnexCustody file = isSignature ? sd.getScannedSignedFile() : sd.getScannedPlainFile();

    final byte[] data = file.getData();

    if (data == null || data.length == 0) {
      response.setStatus(HttpServletResponse.SC_NO_CONTENT);
      return;
    }

    String mime = file.getMime();
    String filename = file.getName();
    if (mime == null || mime.trim().length() == 0) {
      mime = "application/octet-stream";
    }

    {
      response.setContentType(mime);
      response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
      response.setContentLength(data.length);

      java.io.OutputStream output = response.getOutputStream();

      output.write(data);

      output.flush();
    }
  }

  @InitBinder("scanWebForm")
  public void initBinder(WebDataBinder binder) {

    binder.setValidator(this.scanWebValidator);

    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

  }

}
