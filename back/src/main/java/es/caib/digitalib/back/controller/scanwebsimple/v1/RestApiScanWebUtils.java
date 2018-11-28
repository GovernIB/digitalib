package es.caib.digitalib.back.controller.scanwebsimple.v1;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleError;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleFile;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.exceptions.NoAvailablePluginException;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.exceptions.ServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
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
    String sStackTrace = null;
    if (th != null) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      th.printStackTrace(pw);
      sStackTrace = sw.toString();
    }

    HttpHeaders headers = addAccessControllAllowOrigin();
    return new ResponseEntity<ScanWebSimpleError>(new ScanWebSimpleError(msg,
        ServerException.class.getName(), sStackTrace), headers, status);
  }

  public ResponseEntity<ScanWebSimpleError> generateNoAvailablePlugin(String language) {
    // TODO XYZ ZZZ Traduir
    String msg;
    msg = "No s'ha trobat cap plugin que pugui realitzar l'operacio sol·licitades.";
   
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






  /*
  public ScanWebSimpleSignatureResult convertPassarelaSignatureResult2ScanWebSimpleSignatureResult(
      PassarelaSignatureResult psr, PassarelaCommonInfoSignature commonInfo,
      PassarelaFileInfoSignature infoSignature, boolean isSignatureInServer) throws Exception {

    ScanWebSimpleStatus status = new ScanWebSimpleStatus(psr.getStatus(),
        psr.getErrorMessage(), psr.getErrorStackTrace());

    ScanWebSimpleSignedFileInfo sfi = null;
    ScanWebSimpleFile file = null;

    if (status.getStatus() == StatusSignature.STATUS_FINAL_OK) {

      file = convertFitxerBeanToScanWebSimpleFile(psr.getSignedFile());

      final int signOperation = infoSignature.getSignOperation();
      final String signType = infoSignature.getSignType();
      final String signAlgorithm = infoSignature.getSignAlgorithm();
      final int signMode = infoSignature.getSignMode();
      final int signaturesTableLocation = infoSignature.getSignaturesTableLocation();
      final boolean timeStampIncluded = infoSignature.isUseTimeStamp();
      final boolean policyIncluded = (commonInfo.getPolicyInfoSignature() != null);

      
      // eEMGDE.Firma.TipoFirma.FormatoFirma (eEMGDE17.1.1): TF01 (CSV), TF02 (XAdES internally
      // detached signature), TF03 (XAdES enveloped signature), TF04 (CAdES detached/explicit
      // signature), TF05 (CAdES attached/implicit signature), TF06 (PAdES)

      String eniTipoFirma; // TF01, ...
      {
        if (FileInfoSignature.SIGN_TYPE_PADES.equals(signType)) {
          eniTipoFirma = "TF06";
        } else if (psr.getCustodyInfo() != null) {

          eniTipoFirma = "TF01";
        } else if (FileInfoSignature.SIGN_TYPE_CADES.equals(signType)) {
          if (signMode == FileInfoSignature.SIGN_MODE_IMPLICIT) {
            eniTipoFirma = "TF04"; // (CAdES detached/explicit
          } else {
            eniTipoFirma = "TF05"; // (CAdES attached/implicit signature),
          }
        } else if (FileInfoSignature.SIGN_TYPE_XADES.equals(signType)) {
          if (signMode == FileInfoSignature.SIGN_MODE_IMPLICIT) {
            eniTipoFirma = "TF03"; // (XAdES enveloped signature)
          } else {
            eniTipoFirma = "TF02"; // (XAdES internally detached signature), ,
          }
        } else {
          eniTipoFirma = null;
        }

      }

      // EPES T C X XL A 'BASELINE B-Level' 'BASELINE LT-Level' 'BASELINE LTA-Level' 'BASELINE
      // T-Level' LTV
      String eniPerfilFirma;
      if (FileInfoSignature.SIGN_TYPE_PADES.equals(signType)) {
        // 2.- Para las firmas PADES: EPES, LTV, BASELINE B-Level, BASELINE T-Level
        // TODO XYZ ZZZ Falta LTV
        if (timeStampIncluded) {
          eniPerfilFirma = "BASELINE T-Level";
        } else if (policyIncluded) {
          eniPerfilFirma = "EPES";
        } else {
          eniPerfilFirma = "BASELINE B-Level";
        }
      } else {
        // 1.- Para las firmas XADES y CADES:
        // EPES, T, C, X, XL, A, BASELINE B-Level, BASELINE T-Level, BASELINE LT-Level,
        // BASELINE
        // LTA-Level.
        // TODO XYZ ZZZ Falta EPES, T, C, X, XL, A, BASELINE LTA-Level.
        if (timeStampIncluded) {
          eniPerfilFirma = "BASELINE T-Level";
        } else if (policyIncluded) {
          eniPerfilFirma = "EPES";
        } else {
          eniPerfilFirma = "BASELINE B-Level";
        }

      }

      // válida, autentica, refrenda, visa, representa, testimonia, ..
      final String eniRolFirma = "firma"; // ???

      String eniSignerName;
      String eniSignerAdministrationId;
      if (isSignatureInServer) {
        eniSignerName = null;
        eniSignerAdministrationId = null;
      } else {
        eniSignerName = commonInfo.getUsername();
        eniSignerAdministrationId = commonInfo.getAdministrationID();
      }

      // eEMGDE.Firma.NivelFirma (eEMGDE17.5.4) Indicador normalizado que refleja el grado de
      // confianza de la firma utilizado. Ejemplos: Nick, PIN ciudadano, Firma electrónica
      // avanzada, Claves concertadas, Firma electrónica avanzada basada en certificados, CSV,
      // ..
      // TODO XYZ ZZZ Aixó ha de venir del plugin
      String eniSignLevel = null;

      ScanWebSimpleCustodyInfo custody = null;
      {

        PassarelaCustodyInfo pci = psr.getCustodyInfo();

        if (pci != null) {
          custody = new ScanWebSimpleCustodyInfo(pci.getCustodyFileID(),
              pci.getCustodyFileURL(), pci.getCustodyFileCSV(),
              pci.getCustodyFileCSVGenerationDefinition(),
              pci.getCustodyFileCSVValidationWeb());

        }
      }

      // XYZ ZZZ ZZZ
      ScanWebSimpleValidationInfo validation = null;
      {
        PassarelaValidationInfo pvi = psr.getValidationInfo();
        if (pvi != null) {
          validation = new ScanWebSimpleValidationInfo(pvi.getCheckAdministrationIDOfSigner(),
              pvi.getCheckDocumentModifications(), pvi.getCheckValidationSignature());
        }
      }

      final List<ScanWebSimpleKeyValue> additionInformation = null;

      sfi = new ScanWebSimpleSignedFileInfo(signOperation, signType, signAlgorithm, signMode,
          signaturesTableLocation, timeStampIncluded, policyIncluded, eniTipoFirma,
          eniPerfilFirma, eniRolFirma, eniSignerName, eniSignerAdministrationId, eniSignLevel,
          custody, validation, additionInformation);
    }

    return new ScanWebSimpleSignatureResult(psr.getSignID(), status, file, sfi);

  }
  */


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
      // TODO XYZ ZZZ Traduir
      throw new RestException("Aquest servei només el poden fer servir els usuari-aplicació");
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
