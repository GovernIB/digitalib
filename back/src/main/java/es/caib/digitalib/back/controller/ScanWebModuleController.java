package es.caib.digitalib.back.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.plugins.scanweb.api.ScanWebMode;
import org.fundaciobit.plugins.scanweb.api.ScanWebStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.utils.ScanWebConfigTester;
import es.caib.digitalib.model.entity.Plugin;

/**
 *
 * @author anadal
 *
 */
public abstract class ScanWebModuleController extends HttpServlet {

  protected static Logger log = Logger.getLogger(ScanWebModuleController.class);

  public static final String CONTEXTWEB_COMMON = "/common/scanwebmodule";
  
  public static final String CONTEXTWEB_PUBLIC = "/public/scanwebmodule";

  public static final boolean stepSelectionWhenOnlyOnePlugin = false;

  @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
  protected ScanWebModuleLocal scanWebModuleEjb;

  @RequestMapping(value = "/selectscanwebmodule/{scanWebID}")
  public ModelAndView selectScanWebModule(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("scanWebID") String scanWebID)
      throws Exception, I18NException {

    List<Plugin> pluginsFiltered = scanWebModuleEjb.getAllPluginsFiltered(request, scanWebID);

    // Si només hi ha un mòdul de scan llavors anar a scan directament
    if (stepSelectionWhenOnlyOnePlugin) {
      if (pluginsFiltered.size() == 1) {
        Plugin modul = pluginsFiltered.get(0);
        long pluginID = modul.getPluginID();
        String url = getContextWeb() + "/showscanwebmodule/" + pluginID + "/" + scanWebID;
        return new ModelAndView(new RedirectView(url, true));
      }
    }

    // Si cap modul compleix llavors mostrar missatge
    if (pluginsFiltered.size() == 0) {
      String msg = "No existeix cap mòdul de scan que passi els filtres";
      return generateErrorMAV(request, scanWebID, msg, null);
    }

    // /WEB-INF/views/plugindescan_seleccio.jsp
    boolean isPublic = (CONTEXTWEB_PUBLIC.equals(getContextWeb()));
    
    ModelAndView mav = new ModelAndView(isPublic? "public_plugindescan_seleccio" :  "plugindescan_seleccio");
    mav.addObject("scanWebID", scanWebID);
    mav.addObject("plugins", pluginsFiltered);
    mav.addObject("scancontext", getContextWeb());

    return mav;

  }


  @RequestMapping(value = "/error")
  public ModelAndView errorProcesDeScan(HttpServletRequest request,
      HttpServletResponse response, @RequestParam("URL_FINAL") String urlFinal)
      throws Exception {

    boolean isPublic = (CONTEXTWEB_PUBLIC.equals(getContextWeb()));
    
    ModelAndView mav = new ModelAndView(isPublic? "public_plugindescan_final": "plugindescan_final");

    mav.addObject("URL_FINAL", urlFinal);

    return mav;
  }

  @RequestMapping(value = "/showscanwebmodule/{pluginID}/{scanWebID}")
  public ModelAndView showScanWebModule(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("pluginID") Long pluginID,
      @PathVariable("scanWebID") String scanWebID) throws Exception, I18NException {

    log.info("SMC :: showscanwebmodule: PluginID = " + pluginID);
    log.info("SMC :: showscanwebmodule: scanWebID = " + scanWebID);

    // Assignar plugin Elegit
    ScanWebConfigTester ss = scanWebModuleEjb.getScanWebConfig(request, scanWebID);
    ss.setPluginID(pluginID);
    
    if (ss.getFlags() == null || ss.getFlags().size() == 0) {
      // Seleccionam el primer suportat
      Set<String> defaultFlags = scanWebModuleEjb.getDefaultFlags(ss);
      ss.setFlags(defaultFlags);
    }
    

    String relativeControllerBase = getRelativeControllerBase(request, getContextWeb());
    String relativeRequestPluginBasePath = getRequestPluginBasePath(relativeControllerBase,
        scanWebID);

    String absoluteControllerBase = getAbsoluteControllerBase(request, getContextWeb());
    String absoluteRequestPluginBasePath = getRequestPluginBasePath(absoluteControllerBase,
        scanWebID);

    String urlToPluginWebPage;
    urlToPluginWebPage = scanWebModuleEjb.scanDocument(request,
        absoluteRequestPluginBasePath, relativeRequestPluginBasePath, scanWebID);

    log.info("SMC :: showscanwebmodule: redirectTO = " + urlToPluginWebPage);

    return new ModelAndView(new RedirectView(urlToPluginWebPage, false));

  }

  
  
  
  /*
  @RequestMapping(value = "/requestPlugin/{scanWebID}", method = RequestMethod.GET)
  public void requestPluginGET(HttpServletRequest request, HttpServletResponse response,
      @PathVariable long scanWebID,
      @RequestParam("restOfTheUrl") String query) throws Exception {

    final boolean isPost = false;

    requestPlugin(request, response, scanWebID,  query, isPost);

  }


  @RequestMapping(value = "/requestPlugin/{scanWebID}", method = RequestMethod.POST)
  public void requestPluginPOST(HttpServletRequest request, HttpServletResponse response,
      @PathVariable long scanWebID,
      @RequestParam("restOfTheUrl") String query) throws Exception {

    final boolean isPost = true;
    requestPlugin(request, response, scanWebID, query, isPost);

  }
*/
  
  
  
  @Override
  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException  {
    
    
    processServlet(request, response, false);
    
    
    
  }
  
  
  @Override
  public void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException  {
    
    
    processServlet(request, response, true);
    
    
    
  }
  
  
  
  protected void processServlet(HttpServletRequest request,
      HttpServletResponse response, boolean isPost) throws ServletException, IOException {
    
    final boolean debug = log.isDebugEnabled();
    
    if (debug) {
      log.debug(servletRequestInfoToStr(request));
    }
    
    // uri = /scanweb/common/scanwebmodule/requestPlugin/1466408733012148444/index.html
    String uri = request.getRequestURI();
    if (debug) {
      log.debug(" uri = " + uri);
    }
    final String BASE = getContextWeb() + "/requestPlugin";
    int index = uri.indexOf(BASE);
    
    if (index == -1) {
      String msg = "URL base incorrecte !!!! Esperat " + BASE + ". URI = " + uri;
      throw new IOException(msg);
    }
  
    //  idAndQuery = 1466408733012148444/index.html
    String idAndQuery = uri.substring(index + BASE.length() + 1);
    if (debug) {
      log.debug(" idAndQuery = " + idAndQuery);
    }
    
    index = idAndQuery.indexOf('/');
    
    String idStr = idAndQuery.substring(0, index);
    String query = idAndQuery.substring(index + 1, idAndQuery.length());
        
    if (debug) {
      log.debug(" idStr = " + idStr);
      log.debug(" query = " + query);
    }
    
    String scanWebID = idStr;
        
    try {
      requestPlugin(request, response, scanWebID, query, isPost);
    } catch (Throwable e) {
      throw new IOException(e.getMessage(), e);
    }
  
  }
  

  

  protected void requestPlugin(HttpServletRequest request, HttpServletResponse response,
      String scanWebID, String query, boolean isPost)
      throws Exception, I18NException {

    String absoluteRequestPluginBasePath = getAbsoluteRequestPluginBasePath(request,
        getContextWeb(), scanWebID);
    String relativeRequestPluginBasePath = getRelativeRequestPluginBasePath(request,
        getContextWeb(), scanWebID);

   // Map<String, IUploadedFile> uploadedFiles = getMultipartFiles(request);

    scanWebModuleEjb.requestPlugin(request, response, absoluteRequestPluginBasePath,
        relativeRequestPluginBasePath, scanWebID, query, isPost);

  }

  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------
  // ----------------------------- U T I L I T A T S ----------------------
  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------

  protected ModelAndView generateErrorMAV(HttpServletRequest request, String scanWebID,
      String msg, Throwable th) {
    
    ScanWebConfigTester pss = scanWebModuleEjb.getScanWebConfig(request, scanWebID);
    return generateErrorMAV(request, pss, msg, th);
  }

  protected static ModelAndView generateErrorMAV(HttpServletRequest request,
      ScanWebConfigTester pss, String msg, Throwable th) {

    String urlFinal = processError(request, pss, msg, th);

    ModelAndView mav = new ModelAndView("plugindescan_final");
    // request.getSession().setAttribute("URL_FINAL", urlError);
    mav.addObject("URL_FINAL", urlFinal);

    return mav;
  }

  protected static void generateErrorAndRedirect(HttpServletRequest request,
      HttpServletResponse response, ScanWebConfigTester pss, String msg, Throwable th, boolean isPublic) {

    String urlFinal = processError(request, pss, msg, th);

    try {

      String r = request.getContextPath() + getContextWeb(isPublic) + "/error?URL_FINAL="
          + URLEncoder.encode(urlFinal, "UTF8");

      response.sendRedirect(r);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  protected static String processError(HttpServletRequest request, ScanWebConfigTester pss,
      String msg, Throwable th) {

    String urlFinal;
    if (pss == null) {
      HtmlUtils.saveMessageError(request, msg);
      urlFinal = getRelativeURLBase(request);
    } else {

      ScanWebStatus sss = pss.getStatus();
      sss.setErrorMsg(msg);
      sss.setErrorException(th);
      sss.setStatus(ScanWebStatus.STATUS_FINAL_ERROR);
      if (th == null) {
        log.warn(msg);
      } else {
        log.warn(msg, th);
      }

      urlFinal = pss.getUrlFinal();

    }

    return urlFinal;
  }

  /**
   * 
   * @param request
   * @param view
   * @param scanWebConfig
   * @return
   * @throws Exception
   */
  public static ModelAndView startScanWebProcess(HttpServletRequest request, String view,
      ScanWebModuleLocal scanWebModuleEjb, ScanWebConfigTester scanWebConfig, String urlBase,
      boolean isPublic)
      throws Exception {

    final String scanWebID = scanWebConfig.getScanWebID();
    
    scanWebModuleEjb.startScanWebProcess(scanWebConfig);

    final String urlToSelectPluginPage = urlBase + getContextWeb(isPublic)
        + "/selectscanwebmodule/" + scanWebID;

    ModelAndView mav = new ModelAndView(view);
    mav.addObject("scanWebID", scanWebID);
    mav.addObject("urlToSelectPluginPage", urlToSelectPluginPage);
    
    if (scanWebConfig.getMode() == ScanWebMode.ASYNCHRONOUS) {
      mav.addObject("urlFinal", scanWebConfig.getUrlFinal());
    }

    return mav;
  }


  protected abstract String getContextWeb();
  
  protected static String getContextWeb(boolean isPublic) {
    return isPublic? CONTEXTWEB_PUBLIC : CONTEXTWEB_COMMON;  
  }

  public static String getAbsoluteURLBase(HttpServletRequest request) {
    return request.getScheme() + "://" + request.getServerName() + ":"
        + +request.getServerPort() + request.getContextPath();
  }

  public static String getRelativeURLBase(HttpServletRequest request) {
    return request.getContextPath();
  }

  protected static String getAbsoluteControllerBase(HttpServletRequest request,
      String webContext) {
    return getAbsoluteURLBase(request) + webContext;
  }

  public static String getRelativeControllerBase(HttpServletRequest request, String webContext) {
    return getRelativeURLBase(request) + webContext;
  }

  protected static String getAbsoluteRequestPluginBasePath(HttpServletRequest request,
      String webContext, String scanWebID) {

    String base = getAbsoluteControllerBase(request, webContext);
    return getRequestPluginBasePath(base, scanWebID);
  }

  public static String getRelativeRequestPluginBasePath(HttpServletRequest request,
      String webContext, String scanWebID) {

    String base = getRelativeControllerBase(request, webContext);
    return getRequestPluginBasePath(base, scanWebID);
  }

  private static String getRequestPluginBasePath(String base, String scanWebID) {
    String absoluteRequestPluginBasePath = base + "/requestPlugin/" + scanWebID;
    return absoluteRequestPluginBasePath;
  }

  /**
   * 
   * @return
   */
  public static long generateUniqueScanWebID() {
    long id;
    synchronized (log) {
      id = (System.currentTimeMillis() * 1000000L) + System.nanoTime() % 1000000L;
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
      }
    }
    return id;
  }






  
  /* XYZ TODO MOURE A CLASSE D'UTILITAT DE PLUGIN */
  protected String servletRequestInfoToStr(HttpServletRequest request) {
    StringBuffer str = new StringBuffer(
        " +++++++++++++++++ SERVLET REQUEST INFO ++++++++++++++++++++++\n");
    str.append(" ++++ Scheme: " + request.getScheme() + "\n");
    str.append(" ++++ ServerName: " + request.getServerName() + "\n");
    str.append(" ++++ ServerPort: " + request.getServerPort() + "\n");
    str.append(" ++++ PathInfo: " + request.getPathInfo() + "\n");
    str.append(" ++++ PathTrans: " + request.getPathTranslated() + "\n");
    str.append(" ++++ ContextPath: " + request.getContextPath() + "\n");
    str.append(" ++++ ServletPath: " + request.getServletPath() + "\n");
    str.append(" ++++ getRequestURI: " + request.getRequestURI() + "\n");
    str.append(" ++++ getRequestURL: " + request.getRequestURL() + "\n");
    str.append(" ++++ getQueryString: " + request.getQueryString() + "\n");
    str.append(" ++++ javax.servlet.forward.request_uri: "
        + (String) request.getAttribute("javax.servlet.forward.request_uri")  + "\n");
    str.append(" ===============================================================");
    return str.toString();
  }
  
  
}
