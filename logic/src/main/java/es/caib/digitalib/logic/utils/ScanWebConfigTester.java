package es.caib.digitalib.logic.utils;

import java.util.List;
import java.util.Set;

import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.plugins.scanweb.api.ScanWebMode;
import org.fundaciobit.pluginsib.core.utils.Metadata;


/**
 *
 * @author anadal
 *
 */
public class ScanWebConfigTester extends ScanWebConfig {

  protected Long pluginID = null;

  protected final long expiryTransaction; 


  public ScanWebConfigTester(String scanWebID, String scanType, Set<String> flags, List<Metadata> metadades,
      ScanWebMode mode, String languageUI, String urlFinal, long expiryTransaction) {
    super(scanWebID, scanType, flags, metadades, mode, languageUI, urlFinal);
    this.expiryTransaction = expiryTransaction;
  }

  public Long getPluginID() {
    return pluginID;
  }

  public void setPluginID(Long pluginID) {
    this.pluginID = pluginID;
  }

  public long getExpiryTransaction() {
    return expiryTransaction;
  }

}
