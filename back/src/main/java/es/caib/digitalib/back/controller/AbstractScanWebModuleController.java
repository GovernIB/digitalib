package es.caib.digitalib.back.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.ScanWebModuleLocal;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.model.entity.Plugin;

/**
 *
 * @author anadal
 *
 */
public abstract class AbstractScanWebModuleController extends HttpServlet {

  protected static Logger log = Logger.getLogger(AbstractScanWebModuleController.class);

  public static final String CONTEXTWEB_USER = "/user/scanwebmodule";
  
  public static final String CONTEXTWEB_PUBLIC = "/public/scanwebmodule";


  @EJB(mappedName = ScanWebModuleLocal.JNDI_NAME)
  protected ScanWebModuleLocal scanWebModuleEjb;
  
  @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
  protected TransaccioLogicaLocal transaccioLogicaEjb;

  @RequestMapping(value = "/selectscanwebmodule/{transactionWebID}")
  public ModelAndView selectScanWebModule(HttpServletRequest request,
      HttpServletResponse response, @PathVariable("transactionWebID") String transactionWebID)
      throws Exception, I18NException {

    // Miram la transacció
    TransaccioJPA transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
    
    // XYZ ZZZ Revisar si esta caducada (mirar que ja hi ha mètodes)
    
    long pluginSelectedID;    
    if (transaccio.getUsuaripersonaid() != null) {
      // Obtindrem de Configuracio Grup
      // XYZ ZZZ ZZZ
      pluginSelectedID = transaccio.getPerfil().getPluginScanWebID();
    } else {
      // Obtenim del Perfil el plugin d'escaneig a utilitzar
      pluginSelectedID = transaccio.getPerfil().getPluginScanWebID();
    }
    
    
    List<Plugin> pluginsFiltered = scanWebModuleEjb.getAllPluginsFiltered(request,
        transactionWebID, new Long[] { pluginSelectedID});

    
    // Si cap modul compleix llavors mostrar missatge
    if (pluginsFiltered.size() == 0) {
      String msg = "No existeix cap mòdul de scan que passi els filtres";
      return generateErrorMAV(request, transactionWebID, msg, null);
    }
    
    // Si només hi ha un mòdul de scan llavors anar a scan directament
    if (pluginsFiltered.size() == 1) {
      Plugin modul = pluginsFiltered.get(0);
      long pluginID = modul.getPluginID();
      String url = getContextWeb() + "/showscanwebmodule/" + pluginID + "/" + transactionWebID;
      return new ModelAndView(new RedirectView(url, true));
    }

    // /WEB-INF/views/plugindescan_seleccio.jsp
    boolean isPublic = (CONTEXTWEB_PUBLIC.equals(getContextWeb()));
    
    ModelAndView mav = new ModelAndView(isPublic? "public_plugindescan_seleccio" :  "plugindescan_seleccio");
    mav.addObject("scanWebID", transactionWebID);
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
//    ScanWebConfigTester ss = scanWebModuleEjb.getScanWebConfig(request, scanWebID);
//    ss.setPluginID(pluginID);
//    
//    if (ss.getFlags() == null || ss.getFlags().size() == 0) {
//      // Seleccionam el primer suportat
//      Set<String> defaultFlags = scanWebModuleEjb.getDefaultFlags(ss);
//      ss.setFlags(defaultFlags);
//    }
    

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
    
    // uri = /scanweb/user/scanwebmodule/requestPlugin/1466408733012148444/index.html
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

  protected ModelAndView generateErrorMAV(HttpServletRequest request, String transactionWebID,
      String msg, Throwable th)  throws I18NException {

    TransaccioJPA transaccio =  transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);

    String urlFinal = processError(request, transaccio, msg, th);

    ModelAndView mav = new ModelAndView("plugindescan_final");
    // request.getSession().setAttribute("URL_FINAL", urlError);
    mav.addObject("URL_FINAL", urlFinal);

    return mav;
  }

  /*
  protected static void generateErrorAndRedirect(HttpServletRequest request,
      HttpServletResponse response, TransaccioJPA trans, String msg, Throwable th, boolean isPublic) {

    String urlFinal = processError(request, trans, msg, th);

    try {

      String r = request.getContextPath() + getContextWeb(isPublic) + "/error?URL_FINAL="
          + URLEncoder.encode(urlFinal, "UTF8");

      response.sendRedirect(r);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
*/
  protected String processError(HttpServletRequest request, TransaccioJPA trans,
      String msg, Throwable th) throws I18NException {

    String urlFinal;
    if (trans == null) {
      HtmlUtils.saveMessageError(request, msg);
      urlFinal = getRelativeURLBase(request);
    } else {


      trans.setEstatmissatge(msg);
      
      trans.setEstatcodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      if (th == null) {
        log.warn(msg);
      } else {
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        th.printStackTrace(pw);
        
        trans.setEstatexcepcio(pw.toString()); // XYZ ZZZ Passar StackTrace
        log.warn(msg, th);
      }

      transaccioLogicaEjb.update(trans);
      
      urlFinal = trans.getReturnUrl();

    }

    return urlFinal;
  }

 


  protected abstract String getContextWeb();
  
  public static String getContextWeb(boolean isPublic) {
    return isPublic? CONTEXTWEB_PUBLIC : CONTEXTWEB_USER;  
  }

/*  XYZ ZZZ ESBORRARARAR **/
  
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
