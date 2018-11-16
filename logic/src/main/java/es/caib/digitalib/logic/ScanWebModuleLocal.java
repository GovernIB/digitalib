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

  public void closeScanWebProcess(HttpServletRequest request, long scanWebID);
  
  
  public void startScanWebProcess(ScanWebConfigTester ess);
  
  
  public String scanDocument(
      HttpServletRequest request, String absoluteRequestPluginBasePath,
      String relativeRequestPluginBasePath,      
      long scanWebID) throws Exception, I18NException;
  
  
  public void requestPlugin(HttpServletRequest request, HttpServletResponse response,
      String absoluteRequestPluginBasePath, String relativeRequestPluginBasePath,
      long scanWebID, String query, boolean isPost)  throws Exception, I18NException;
  
  
  public ScanWebConfigTester getScanWebConfig(HttpServletRequest request,
      long scanWebID);
  
  public List<Plugin> getAllPluginsFiltered(HttpServletRequest request, long scanWebID) throws Exception,I18NException;
  
  
  public Set<String> getDefaultFlags(ScanWebConfigTester ss) throws Exception;
  
}
