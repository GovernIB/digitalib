package es.caib.digitalib.logic;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignedFileInfo;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.scanweb.api.ScanWebDocument;
import org.fundaciobit.pluginsib.signature.api.CommonInfoSignature;
import org.fundaciobit.pluginsib.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.signature.api.ITimeStampGenerator;
import org.fundaciobit.pluginsib.signature.api.PdfVisibleSignature;
import org.fundaciobit.pluginsib.signature.api.PolicyInfoSignature;
import org.fundaciobit.pluginsib.signature.api.SecureVerificationCodeStampInfo;
import org.fundaciobit.pluginsib.signature.api.SignaturesSet;
import org.fundaciobit.pluginsib.signature.api.SignaturesTableHeader;
import org.fundaciobit.pluginsib.signature.api.StatusSignature;
import org.fundaciobit.pluginsib.signature.api.StatusSignaturesSet;
import org.fundaciobit.pluginsib.signatureserver.api.ISignatureServerPlugin;
import org.fundaciobit.pluginsib.utils.templateengine.TemplateEngine;


import com.google.common.hash.Hashing;

import es.caib.digitalib.persistence.InfoSignaturaJPA;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.persistence.PluginCridadaJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.logic.utils.DigitalIBTimeStampGenerator;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.logic.utils.ScanWebUtils;
import es.caib.digitalib.logic.utils.SignatureUtils;
import es.caib.digitalib.model.bean.FitxerBean;
import es.caib.digitalib.model.entity.ConfiguracioFirma;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.ejb.PerfilService;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "PluginFirmaEnServidorLogicaEJB")

@RunAs("DIB_ADMIN")
public class PluginFirmaEnServidorLogicaEJB extends
    AbstractPluginLogicaEJB<ISignatureServerPlugin> implements
    PluginFirmaEnServidorLogicaService {

  @EJB(mappedName = FitxerLogicaService.JNDI_NAME)
  protected FitxerLogicaService fitxerEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.InfoSignaturaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoSignaturaService infoSignaturaEjb;

  @EJB(mappedName = CridadaPluginLogicaService.JNDI_NAME)
  protected CridadaPluginLogicaService pluginCridada;

  @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioFirmaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioFirmaService configuracioFirmaEjb;

  @EJB(mappedName = PluginSegellDeTempsLogicaService.JNDI_NAME)
  protected PluginSegellDeTempsLogicaService pluginSegellDeTempsEjb;
  
  @EJB(mappedName = PerfilService.JNDI_NAME)
  protected PerfilService perfilEjb;

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR;
  }

  @Override
  protected String getName() {
    return "Firma en Servidor";
  }

  @Override
  public Fitxer firmarFitxerAmbApiFirmaEnServidor(TransaccioJPA transaccio, Fitxer fitxer,
      Locale locale, String userApp, String userPerson) {

    PerfilJPA perfil = transaccio.getPerfil();
    
    log.info("firmarFitxerAmbApiFirmaEnServidor => PerfilID=" + transaccio.getPerfilID());
    log.info("firmarFitxerAmbApiFirmaEnServidor => Perfil=" + perfil);
    
    if (perfil == null) {
        perfil = (PerfilJPA)perfilEjb.findByPrimaryKey(transaccio.getPerfilID());
    }
    
    
    Long confFirmaID = perfil.getConfiguracioFirmaID();
    log.info("firmarFitxerAmbApiFirmaEnServidor => confFirmaID=" + confFirmaID);

    ConfiguracioFirma confFirma = configuracioFirmaEjb.findByPrimaryKey(confFirmaID);

    // CHECK 1: Si el tipus de Firma és PADES llavors el perfil de SCAN ha de ser PDF

    if (confFirma.getTipusFirmaID() == Constants.TIPUSFIRMA_PADES) {

      log.info("\n\n" + "XYZ ZZZ ZZZ  perfil.getScanFormatFitxer() => "
          + perfil.getScanFormatFitxer() + "\n\n");

      // XYZ ZZZ NOMES SUPORTAM PERFIL PDF
      // XYZ ZZZ NO ESTA BÉ !!!!!

      // FORMAT_FILE_PDF

      String scanType = ScanWebUtils.formatFileToScanWebApi(perfil.getScanFormatFitxer());

      if (scanType == null) {

        final String msg = "No s'ha trobat el format de fitxer per escaneig amb ID "
            + perfil.getScanFormatFitxer();

        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio.setEstatMissatge(msg);
        transaccio.setEstatExcepcio(null);

        return null;
      }

      if (!ScanWebDocument.SCANTYPE_MIME_PDF.equalsIgnoreCase(scanType)) {
        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio
            .setEstatMissatge("El perfil de firma PADES només pot signar documents PADES "
                + "però el format requerit en el Perfil és " + scanType
                + ". Consulti amb el seu Administrador");
        return null;
      }
    }

    Fitxer fitxerSignat;
    ISignatureServerPlugin plugin;
    try {
      plugin = getInstanceByPluginID(confFirma.getPluginFirmaServidorID());
    } catch (I18NException e1) {

      final String msg = "XYZ ZZZ Error Instanciant Plugin de Firma en Servidor: "
          + I18NLogicUtils.getMessage(e1, locale);
      
      log.error(msg,e1);

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(StringUtils.truncate(msg, 2990));
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e1));

      return null;
    }

    PluginCridadaJPA monitorIntegracions = null;
    try {
      final String signType = convertSignType(confFirma.getTipusFirmaID());
      // modefirma.false=Implícita (Attached) || modefirma.true=Explícita (Detached)
      final int signMode = confFirma.isModeDeFirma() ? FileInfoSignature.SIGN_MODE_EXPLICIT
          : FileInfoSignature.SIGN_MODE_IMPLICIT;

      // Cridades de Plugin
      final String parametresText = "Tipus: "
          + signType
          + "\nMode:"
          + (signMode == FileInfoSignature.SIGN_MODE_IMPLICIT ? "Implicit/Attached"
              : "Explicid/Detached");
      monitorIntegracions = pluginCridada.preCridada(confFirma.getPluginFirmaServidorID(),
          "filter,signDocuments", transaccio.getUsuariPersonaId(),
          transaccio.getUsuariAplicacioId(), parametresText);

      boolean epes = confFirma.getUsPoliticaDeFirma() == Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT;
      final String username = null;

      String languageUI = transaccio.getLanguageUI();
      String filtreCertificats = "";
      String administrationID = null; // No te sentit en API Firma En Servidor
      PolicyInfoSignature policyInfoSignature = null;
      if (epes) {
        policyInfoSignature = new PolicyInfoSignature();
        policyInfoSignature.setPolicyIdentifier(confFirma.getPolicyIdentifier()); // "urn:oid:2.16.724.1.3.1.1.2.1.9");
        policyInfoSignature.setPolicyIdentifierHash(confFirma.getPolicyIdentifierHash()); // "G7roucf600+f03r/o0bAOQ6WAs0=");
        policyInfoSignature.setPolicyIdentifierHashAlgorithm(confFirma
            .getPolicyIdentifierHashAlgorithm()); // "SHA1");
        policyInfoSignature.setPolicyUrlDocument(confFirma.getPolicyUrlDocument());// "https://sede.060.gob.es/politica_de_firma_anexo_1.pdf");
      }

      CommonInfoSignature commonInfoSignature = new CommonInfoSignature(languageUI,
          filtreCertificats, username, administrationID);

      String signID = transaccio.getTransactionWebId();
      


      String name = fitxer.getNom();
      String reason = templateEngine(Configuracio.getSignReasonEL(), transaccio); 
      
      log.info("\n\n  getSignReasonEL => " + reason  + "\n\n");
      
      String location = templateEngine(Configuracio.getSignLocationEL(), transaccio); 
      String signerEmail = templateEngine(Configuracio.getSignerEmailEL(), transaccio); 

      final int signNumber = 1;
      String languageDoc = transaccio.getInfoScanLanguageDoc();

      final String signAlgorithm = getAlgorisme(confFirma.getAlgorismeDeFirmaID()); // FileInfoSignature.SIGN_ALGORITHM_SHA1;

      final int signaturesTableLocation = getPosicioTaulaDeFirmes(confFirma
          .getPosicioTaulaFirmesID());
      final PdfVisibleSignature pdfInfoSignature = null;
      final SignaturesTableHeader signaturesTableHeader = null;

      boolean userRequiresTimeStamp = confFirma.isIncloureSegellDeTemps();
      final ITimeStampGenerator timeStampGenerator;
      final String timestampUrlBase;
      if (userRequiresTimeStamp && confFirma.getPluginSegellatID() != null) {

        // Cridar al plugin per a que firmi
        // XYZ hauria de cridar a l'altre
        String absoluteURL = Configuracio.getBackUrl();
        
        log.info("\n\n\n XYZ ZZZ absoluteURL ==> " + absoluteURL + "\n\n\n");

        // Segellat de temps
        timestampUrlBase = SignatureUtils
            .getAbsoluteURLToTimeStampGeneratorPerFirmaEnServidor(absoluteURL,
                confFirma.getPluginFirmaServidorID());
        
        log.info("\n\n\n XYZ ZZZ timestampUrlBase ==> " + timestampUrlBase + "\n\n\n");

        timeStampGenerator = DigitalIBTimeStampGenerator.getInstance(pluginSegellDeTempsEjb,
            confFirma.getPluginSegellatID());

      } else {
        timeStampGenerator = null;
        timestampUrlBase = null;
      }

      // Valors per defcte
      final SecureVerificationCodeStampInfo csvStampInfo = null;

      final File previusSignatureDetachedFile = null;

      // XYZ ZZZ Collir-ho de confFirma.getTipusOperacioFirma()
      final int signOperation = FileInfoSignature.SIGN_OPERATION_SIGN;

      final String expedientCode = null;
      // XYZ ZZZ S'ha de demanar ????
      final String expedientName = null;
      final String expedientUrl = null;
      final String procedureCode = null;
      final String procedureName = null;

      File source = FileSystemManager.getFile(fitxer.getFitxerID());

      // XYZ ZZZ PDF MIME
      FileInfoSignature fileInfo = new FileInfoSignature(signID, source,
          previusSignatureDetachedFile, FileInfoSignature.PDF_MIME_TYPE, name, reason,
          location, signerEmail, signNumber, languageDoc, signOperation, signType,
          signAlgorithm, signMode, signaturesTableLocation, signaturesTableHeader,
          pdfInfoSignature, csvStampInfo, userRequiresTimeStamp, timeStampGenerator,
          policyInfoSignature,
          expedientCode, expedientName, expedientUrl, procedureCode, procedureName);

      final String signaturesSetID = String.valueOf(System.currentTimeMillis());
      SignaturesSet signaturesSet = new SignaturesSet(signaturesSetID, commonInfoSignature,
          new FileInfoSignature[] { fileInfo });

      Map<String, Object> parameters = new HashMap<String, Object>();

      // TODO Check si passa filtre
      String error = plugin.filter(signaturesSet, parameters);
      if (error != null) {

        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio.setEstatMissatge(StringUtils.truncate("XYZ ZZZ Plugin " + plugin.getName(locale)
            + " No passa el filtre. Raó:  " + error, 2990));

        return null;
      }

      signaturesSet = plugin.signDocuments(signaturesSet, timestampUrlBase, parameters);
      
      StatusSignaturesSet sss = signaturesSet.getStatusSignaturesSet();

      if (sss.getStatus() != StatusSignaturesSet.STATUS_FINAL_OK) {
        String msg = "XYZ ZZZ Error General MSG = " + sss.getErrorMsg();

        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio.setEstatMissatge(StringUtils.truncate(msg, 2990));
        transaccio.setEstatExcepcio(LogicUtils.exceptionToString(sss.getErrorException()));

        // Cridades de Plugin
        pluginCridada.postCridadaError(monitorIntegracions,
            msg + "\n\n" + transaccio.getEstatExcepcio());

        return null;

      }

      FileInfoSignature fis = signaturesSet.getFileInfoSignatureArray()[0];
      StatusSignature status = fis.getStatusSignature();
      if (status.getStatus() != StatusSignaturesSet.STATUS_FINAL_OK) {
        // XYZ ZZZ
        String msg = "Error Firma 1. MSG = " + status.getErrorMsg();
        transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
        transaccio.setEstatMissatge(msg);
        transaccio.setEstatExcepcio(LogicUtils.exceptionToString(status.getErrorException()));

        // Cridades de Plugin
        pluginCridada.postCridadaError(monitorIntegracions,
            msg + "\n\n" + transaccio.getEstatExcepcio());

        return null;
      } else {
        // Cridades de Plugin
        pluginCridada.postCridadaOK(monitorIntegracions, "");

      }

      File fileSigned = status.getSignedData();

      String nom = fitxer.getNom();

      int punt = nom.lastIndexOf('.');

      if (punt == -1) {
        nom = nom + ".signed";
      } else {
        nom = nom.substring(0, punt) + "-signed" + nom.substring(punt);
      }

      fitxerSignat = new FitxerBean("", FileInfoSignature.PDF_MIME_TYPE, nom,
          fileSigned.length());

      fitxerSignat = fitxerEjb.create(fitxerSignat);

      File dest = FileSystemManager.crearFitxer(fileSigned, fitxerSignat.getFitxerID());

      transaccio.setFitxerSignaturaID(fitxerSignat.getFitxerID());

      String hashSignatura = Hashing.sha256().hashString(String.valueOf(transaccio.getFitxerSignaturaID()), Charset.forName("UTF-8"))
          .toString();
      
      transaccio.setHashFirma(hashSignatura);
      log.info("XYZ ZZZ Guardada Firma a " + dest.getAbsolutePath());

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);

      // XYZ ZZZ Afegir Informacio de la Firma

      // XYZ ZZZ FALTA INFO
      java.lang.String eniTipoFirma = "TF06";
      java.lang.String eniPerfilFirma = epes ? FirmaSimpleSignedFileInfo.SIGNPROFILE_EPES : FirmaSimpleSignedFileInfo.SIGNPROFILE_BES;
      java.lang.String eniRolFirma = null;

      java.lang.String eniSignerName = null;
      java.lang.String eniSignerAdministrationId = null;
      java.lang.String eniSignLevel = null;

      Boolean checkAdministrationIdOfSigner = null;
      Boolean checkDocumentModifications = null;
      Boolean checkValidationSignature = null;

      log.info("XYZ ZZZ    eniTipoFirma = " + eniTipoFirma);
      log.info("XYZ ZZZ    eniPerfilFirma = " + eniPerfilFirma);

      InfoSignaturaJPA infoSign = new InfoSignaturaJPA(signOperation, signType, signAlgorithm,
          signMode, signaturesTableLocation, userRequiresTimeStamp, epes, eniTipoFirma,
          eniPerfilFirma, eniRolFirma, eniSignerName, eniSignerAdministrationId, eniSignLevel,
          checkAdministrationIdOfSigner, checkDocumentModifications, checkValidationSignature);

      infoSign = (InfoSignaturaJPA) infoSignaturaEjb.create(infoSign);

      transaccio.setInfoSignaturaID(infoSign.getInfoSignaturaID());

      log.info("XYZ ZZZ Assignant  Info Signatura a Transaccio: " + infoSign);

      transaccio.setInfoSignatura(infoSign);

      return fitxerSignat;
    } catch (Throwable th) {
      
      String emsg;
      if (th instanceof I18NException) {
        emsg = I18NLogicUtils.getMessage((I18NException)th, locale);
      } else {
        emsg = th.getMessage();
      }

      String msg = "XYZ ZZZ Error realitzant la firma, guardant a BBDD el fitxer firmat o guardant informació de la firma: "
          + emsg;

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(StringUtils.truncate(msg, 2990));
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(th));

      // Cridades de Plugin
      if (monitorIntegracions != null) {
        pluginCridada.postCridadaError(monitorIntegracions,
            msg + "\n\n" + transaccio.getEstatExcepcio());
      }

      return null;

    }

  }
  
  
  
  protected String templateEngine(String valueEL, TransaccioJPA transaccio)  {
    
    if (valueEL == null || valueEL.trim().length() == 0) {
      return "";
    }
    
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("transaction", transaccio);
    
    try {
      return TemplateEngine.processExpressionLanguage(valueEL,parameters);
    } catch (IOException e) {
      log.error("error substituin valors de la firma en servidor: " + e.getMessage(), e);
      return null;
    }
    
    
    
  }
  
  

  public static int getPosicioTaulaDeFirmes(int pos) {

    switch (pos) {

      default:
      case Constants.TAULADEFIRMES_SENSETAULA:
        return FileInfoSignature.SIGNATURESTABLELOCATION_WITHOUT;

      case Constants.TAULADEFIRMES_PRIMERAPAGINA:
        return FileInfoSignature.SIGNATURESTABLELOCATION_FIRSTPAGE;

      case Constants.TAULADEFIRMES_DARRERAPAGINA:
        return FileInfoSignature.SIGNATURESTABLELOCATION_LASTPAGE;

    }
  };

  public static String getAlgorisme(int algo) throws I18NException {

    switch (algo) {

      case Constants.SIGN_ALGORITHM_SHA1WITHRSA:
        return FileInfoSignature.SIGN_ALGORITHM_SHA1;

      case Constants.SIGN_ALGORITHM_SHA256WITHRSA:
        return FileInfoSignature.SIGN_ALGORITHM_SHA256;

      case Constants.SIGN_ALGORITHM_SHA384WITHRSA:
        return FileInfoSignature.SIGN_ALGORITHM_SHA384;

      case Constants.SIGN_ALGORITHM_SHA512WITHRSA:
        return FileInfoSignature.SIGN_ALGORITHM_SHA512;

      default:
        // XYZ ZZZ TRA
        throw new I18NException("Es desconeix el tipus d'algorime de firma amb ID = " + algo);

    }

  };

  public static String convertSignType(int tipusFirma) throws I18NException {

    switch (tipusFirma) {

      case Constants.TIPUSFIRMA_PADES:
        return FileInfoSignature.SIGN_TYPE_PADES;

      case Constants.TIPUSFIRMA_CADES:
        return FileInfoSignature.SIGN_TYPE_CADES;

      case Constants.TIPUSFIRMA_XADES:
        return FileInfoSignature.SIGN_TYPE_XADES;

      case Constants.TIPUSFIRMA_SMIME:
        return FileInfoSignature.SIGN_TYPE_SMIME;

      default:
        // XYZ ZZZ TRA
        throw new I18NException("Es desconeix el tipus de Firma amb ID = " + tipusFirma);

    }

  }

}
