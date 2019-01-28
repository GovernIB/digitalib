package es.caib.digitalib.logic.utils;

/**
 * 
 * @author anadal(u80067)
 *
 */
public class SignatureUtils {

  /* 
   * Si es modifica el valor d'aquesta constant llavors s'ha d'adaptar el web.xml 
   * del projecte back. 
   *  
   */
  public static final String CONTEXTWEB_FOR_TIMESTAMP_GENERATOR_PER_FIRMA_EN_SERVIDOR = "/public/timestampgenerator";
  
  /**
   * 
   * @param request
   * @param webContext
   * @param pluginID
   * @param signaturesSetID
   * @param signatureIndex
   * @return
   */
  public static String getAbsoluteURLToTimeStampGeneratorPerFirmaEnServidor(
      String basePath, Long pluginID) {

    String absoluteRequestPluginBasePath = basePath 
        + CONTEXTWEB_FOR_TIMESTAMP_GENERATOR_PER_FIRMA_EN_SERVIDOR         
        + "/" + pluginID;
    // NOTA signaturesSetID i signatureIndex s'afegeix dins dels propi plugin;

    return absoluteRequestPluginBasePath;
  }

  
}
