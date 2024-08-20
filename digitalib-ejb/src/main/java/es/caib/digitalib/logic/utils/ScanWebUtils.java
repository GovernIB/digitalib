package es.caib.digitalib.logic.utils;

import java.util.ArrayList;
import java.util.List;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.scanweb.api.ScanWebDocument;
import org.fundaciobit.pluginsib.scanweb.api.ScanWebMode;
import org.fundaciobit.pluginsib.scanweb.api.ScanWebRequest;
import org.fundaciobit.pluginsib.core.v3.utils.Metadata;

import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.commons.utils.Constants;

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
  public static String formatFileToScanWebApi(int formatType) {

    switch (formatType) {

    case Constants.FORMAT_FILE_PDF:
      return ScanWebDocument.SCANTYPE_MIME_PDF; // "pdf";

    case Constants.FORMAT_FILE_JPG:
      return ScanWebDocument.SCANTYPE_MIME_JPG;// "jpg";

    case Constants.FORMAT_FILE_TIFF:
      return ScanWebDocument.SCANTYPE_MIME_TIFF; // "tif";

    case Constants.FORMAT_FILE_PNG:
      return ScanWebDocument.SCANTYPE_MIME_PNG; // "png";

    case Constants.FORMAT_FILE_GIF:
      return ScanWebDocument.SCANTYPE_MIME_GIF; // "gif";

    default:
      return null;

    }

  }
  
  
  public static ScanWebRequest generateScanWebRequest(
      TransaccioJPA transaction, final String urlFinal)
      throws I18NException {
    
   
    
    final String transactionWebID = transaction.getTransactionWebId();
    
    final String languageUI = transaction.getLanguageUI();
    
    final String scanType = ScanWebUtils.formatFileToScanWebApi(transaction.getPerfil()
        .getScanFormatFitxer());
    
    final String flag = ScanWebDocument.FLAG_PLAIN;
    
    final List<Metadata> metadades = new ArrayList<Metadata>();
    
    final ScanWebMode mode = ScanWebMode.SYNCHRONOUS;
 
    ScanWebRequest swc = new ScanWebRequest(transactionWebID, transaction.getNom(), 
        scanType,  flag, mode,languageUI, transaction.getFuncionariUsername(),
        urlFinal, metadades);
    return swc;
  }
  
  
}
