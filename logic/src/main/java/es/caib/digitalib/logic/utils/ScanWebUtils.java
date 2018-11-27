package es.caib.digitalib.logic.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.scanweb.api.IScanWebPlugin;
import org.fundaciobit.plugins.scanweb.api.ScanWebConfig;
import org.fundaciobit.plugins.scanweb.api.ScanWebMode;
import org.fundaciobit.pluginsib.core.utils.Metadata;

import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
public class ScanWebUtils {

  /**
   * 
   * @param formatType
   * @return
   * @throws I18NException
   */
  public static String formatFileToScanWebApi(int formatType) throws I18NException {

    switch (formatType) {

    case Constants.FORMAT_FILE_PDF:
      return IScanWebPlugin.SCANTYPE_PDF; // "pdf";

    case Constants.FORMAT_FILE_JPG:
      return IScanWebPlugin.SCANTYPE_JPG;// "jpg";

    case Constants.FORMAT_FILE_TIFF:
      return IScanWebPlugin.SCANTYPE_TIFF; // "tif";

    case Constants.FORMAT_FILE_PNG:
      return IScanWebPlugin.SCANTYPE_PNG; // "png";

    case Constants.FORMAT_FILE_GIF:
      return IScanWebPlugin.SCANTYPE_GIF; // "gif";

    default:
      throw new I18NException("genapp.comodi",
          "No s'ha trobat el format de fitxer per escaneig amb ID " + formatType);

    }

  }
  
  
  public static ScanWebConfig generateScanWebConfig(
      TransaccioJPA transaction, final String urlFinal)
      throws I18NException {
    
   
    
    final String transactionWebID = transaction.getTransactionWebId();
    
    final String languageUI = transaction.getLanguageui();
    
    final String scanType = ScanWebUtils.formatFileToScanWebApi(transaction.getPerfil()
        .getScanFormatFitxer());
    
    final Set<String> flags = new HashSet<String>();
    flags.add(IScanWebPlugin.FLAG_NON_SIGNED);
    
    final List<Metadata> metadades = new ArrayList<Metadata>();
    
    final ScanWebMode mode = ScanWebMode.SYNCHRONOUS;
 
    ScanWebConfig swc = new ScanWebConfig(transactionWebID, scanType, flags, metadades,
        mode, languageUI, urlFinal);
    return swc;
  }
  
  
}
