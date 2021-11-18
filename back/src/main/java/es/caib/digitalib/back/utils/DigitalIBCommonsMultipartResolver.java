package es.caib.digitalib.back.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import es.caib.digitalib.utils.Configuracio;

/**
 * 
 * @author anadal
 * 
 */
@Component
public class DigitalIBCommonsMultipartResolver extends
    org.springframework.web.multipart.commons.CommonsMultipartResolver {

  protected final Logger log = Logger.getLogger(getClass());

  public DigitalIBCommonsMultipartResolver() {
    super();
  }

  @Override
  public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request)
      throws MultipartException {
    /*
     * log.info(" ++++ Scheme: " + request.getScheme());
     * log.info(" ++++ PathInfo: " + request.getPathInfo());
     * log.info(" ++++ PathTrans: " + request.getPathTranslated());
     * log.info(" ++++ ContextPath: " + request.getContextPath());
     * log.info(" ++++ ServletPath: " + request.getServletPath());
     * log.info(" ++++ getRequestURI: " + request.getRequestURI());
     * log.info(" ++++ getRequestURL: " + request.getRequestURL().toString());
     * log.info(" ++++ getQueryString: " + request.getQueryString());
     */

	 
    // NOTA: Les pujades des de l'applet no tenen límit i no es controlen des
    // d'aquí
    Long maxUploadSize;
    String msgCode;

	{
      // Pujada d'un fitxer
      // Es fa una mescla entre el màxim global i màxim per entitat
      maxUploadSize = getMaxUploadSize();
      msgCode = "tamanyfitxerpujatsuperat";
    }

    if (maxUploadSize == null) {
      this.setMaxUploadSize(-1); // -1 = No Limit
    } else {
      this.setMaxUploadSize(maxUploadSize);
    }
    if (log.isDebugEnabled()) {
      log.debug("Tamany de pujada de Fitxers: "
        + (maxUploadSize == null ? "Sense limit" : maxUploadSize));
    }


    try {
      return super.resolveMultipart(request);
    } catch (MaxUploadSizeExceededException musee) {
      throw new DigitalIBMaxUploadSizeExceededException(musee.getCause(),
          musee.getMaxUploadSize(), msgCode);
    }

  }

  private Long getMaxUploadSize() {
    Long maxUploadSizeGlobal = Configuracio.getMaxUploadSizeInBytes();
    if (log.isDebugEnabled()) {
      if (maxUploadSizeGlobal == null) {
        log.debug("No s'ha definit limit de grandaria global en la pujada de Fitxers");
      } else {
        log.info("S'ha definit una grandaria màxima de pujada global de Fitxers a "
            + maxUploadSizeGlobal + " bytes");
      }
    }

    Long maxUploadSize = maxUploadSizeGlobal;
    return maxUploadSize;
  }

  
}
