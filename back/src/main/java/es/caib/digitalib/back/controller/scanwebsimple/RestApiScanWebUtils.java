package es.caib.digitalib.back.controller.scanwebsimple;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleError;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleFile;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.NoAvailablePluginException;
import org.fundaciobit.apisib.apiscanwebsimple.v1.exceptions.ServerException;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.bean.FitxerBean;

/**
 * 
 * @author anadal
 *
 */
public abstract class RestApiScanWebUtils extends RestUtils {

  public ResponseEntity<ScanWebSimpleError> generateServerError(String msg) {
    return generateServerError(msg, null, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public ResponseEntity<ScanWebSimpleError> generateServerError(String msg, HttpStatus status) {
    return generateServerError(msg, null, status);
  }

  public ResponseEntity<ScanWebSimpleError> generateServerError(String msg, Throwable th) {
    return generateServerError(msg, th, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public ResponseEntity<ScanWebSimpleError> generateServerError(String msg, Throwable th,
      HttpStatus status) {
    String sStackTrace = LogicUtils.exceptionToString(th);

    HttpHeaders headers = addAccessControllAllowOrigin();
    return new ResponseEntity<ScanWebSimpleError>(new ScanWebSimpleError(msg,
        ServerException.class.getName(), sStackTrace), headers, status);
  }

 
  public ResponseEntity<ScanWebSimpleError> generateNoAvailablePlugin(String language) {
    String msg;
    msg = I18NUtils.tradueix("plugin.notfound");
   
    return new ResponseEntity<ScanWebSimpleError>(new ScanWebSimpleError(msg,
        NoAvailablePluginException.class.getName()), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public ScanWebSimpleFile convertFitxerBeanToScanWebSimpleFile(FitxerBean fb)
      throws Exception {

    if (fb == null) {
      return null;
    }
    InputStream is = null;
    try {
      is = fb.getData().getInputStream();
      byte[] data = IOUtils.toByteArray(is);
      return new ScanWebSimpleFile(fb.getNom(), fb.getMime(), data);
    } catch (Exception e) {
      throw e;
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (Exception e2) {
        }
      }
    }

  }






  /**
   *
   * @param esFirmaEnServidor
   * @return
   * @throws RestException
   * @throws I18NException
   */
  protected RestLoginInfo commonChecks() throws RestException,
      I18NException {

    LoginInfo loginInfo = LoginInfo.getInstance();

    log.info(" XYZ ZZZ LOGININFO => " + loginInfo);

    // Checks Globals
    if (loginInfo.getUsuariPersona() != null) {
      throw new RestException(I18NUtils.tradueix("excepcio.restriccio.usuari.aplicacio"));
    }

    // Checks usuari aplicacio
    final UsuariAplicacioJPA usuariAplicacio = loginInfo.getUsuariAplicacio();
    log.info(" XYZ ZZZ Usuari-APP = " + usuariAplicacio.getUsername());
    
    
    

    // Cercam que tengui configuracio    
    return new RestLoginInfo(loginInfo);

  }



  /**
   *
   * @author anadal
   *
   */
  public class RestLoginInfo {

    // XYZ ZZZZ    AFEGIR PERFILS !!!!

    public final es.caib.digitalib.back.security.LoginInfo loginInfo;

    public RestLoginInfo(LoginInfo loginInfo) {
      super();
      this.loginInfo = loginInfo;
    }

  }

}
