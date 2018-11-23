package es.caib.digitalib.logic;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.logic.utils.ScanWebConfigTester;
import es.caib.digitalib.model.entity.Plugin;



/**
 * 
 * @author anadal
 *
 */
@Local
public interface ScanWebModuleLocal {
  
  public static final String JNDI_NAME = "digitalib/ScanWebModuleEJB/local";

  public void closeScanWebProcess(HttpServletRequest request, String scanWebID);
  
  
  public void startScanWebProcess(ScanWebConfigTester ess);
  
  
  public String scanDocument(
      HttpServletRequest request, String absoluteRequestPluginBasePath,
      String relativeRequestPluginBasePath,      
      String scanWebID) throws Exception, I18NException;
  
  
  public void requestPlugin(HttpServletRequest request, HttpServletResponse response,
      String absoluteRequestPluginBasePath, String relativeRequestPluginBasePath,
      String scanWebID, String query, boolean isPost)  throws Exception, I18NException;
  
  
  public ScanWebConfigTester getScanWebConfig(HttpServletRequest request,
      String scanWebID);
  
  public List<Plugin> getAllPluginsFiltered(HttpServletRequest request, String scanWebID) throws Exception,I18NException;
  
  
  public Set<String> getDefaultFlags(ScanWebConfigTester ss) throws Exception;
  
}
