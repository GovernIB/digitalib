package es.caib.digitalib.logic;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.scanweb.api.IScanWebPlugin;
import org.fundaciobit.plugins.signature.api.CommonInfoSignature;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.plugins.signature.api.ITimeStampGenerator;
import org.fundaciobit.plugins.signature.api.PdfVisibleSignature;
import org.fundaciobit.plugins.signature.api.PolicyInfoSignature;
import org.fundaciobit.plugins.signature.api.SecureVerificationCodeStampInfo;
import org.fundaciobit.plugins.signature.api.SignaturesSet;
import org.fundaciobit.plugins.signature.api.SignaturesTableHeader;
import org.fundaciobit.plugins.signature.api.StatusSignature;
import org.fundaciobit.plugins.signature.api.StatusSignaturesSet;
import org.fundaciobit.plugins.signatureserver.api.ISignatureServerPlugin;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.jpa.InfoSignaturaJPA;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.PluginCridadaJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.bean.FitxerBean;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.utils.Constants;

/**
 *
 * @author anadal
 */
@Stateless(name = "PluginFirmaEnServidorLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class PluginFirmaEnServidorLogicaEJB extends
    AbstractPluginLogicaEJB<ISignatureServerPlugin> implements
    PluginFirmaEnServidorLogicaLocal {

  @EJB(mappedName = FitxerLogicaLocal.JNDI_NAME)
  protected FitxerLogicaLocal fitxerEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.InfoSignaturaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoSignaturaLocal infoSignaturaEjb;

  @EJB(mappedName = CridadaPluginLogicaLocal.JNDI_NAME)
  protected CridadaPluginLogicaLocal pluginCridada;

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

    log.info("\n\n" + "XYZ ZZZ ZZZ  perfil.getScanFormatFitxer() => "
        + perfil.getScanFormatFitxer() + "\n\n");

    Fitxer fitxerSignat;
    // XYZ ZZZ NOMES SUPORTAM PERFIL PDF
    // XYZ ZZZ NO ESTA BË !!!!!
    if (IScanWebPlugin.SCANTYPE_PDF.equals(perfil.getScanFormatFitxer())) {
      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge("XYZ ZZZ Nomes es suporta el Format de Escaneig PDF. "
          + "El seu perfil requereix " + perfil.getScanFormatFitxer()
          + ". Consulti amb el seu Administrador");
      return null;
    }

    ISignatureServerPlugin plugin;
    try {
      plugin = getInstanceByPluginID(perfil.getPluginFirmaServidorID());
    } catch (I18NException e1) {

      final String msg = "XYZ ZZZ Error Instanciant PLugins de Firma en Servidor: "
          + I18NLogicUtils.getMessage(e1, locale);

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e1));

      return null;
    }

    String signType = FileInfoSignature.SIGN_TYPE_PADES;
    int signMode = FileInfoSignature.SIGN_MODE_IMPLICIT;

    // Cridades de Plugin
    final String parametresText = "Tipus: "
        + signType
        + "\nMode:"
        + (signMode == FileInfoSignature.SIGN_MODE_IMPLICIT ? "Implicit/Attached"
            : "Explicid/Detached");
    PluginCridadaJPA monitorIntegracions = pluginCridada.preCridada(
        perfil.getPluginFirmaServidorID(), "filter,signDocuments",
        transaccio.getUsuariPersonaId(), transaccio.getUsuariAplicacioId(), parametresText);

    boolean userRequiresTimeStamp = false;
    boolean epes = true;
    final String username = null;

    String languageUI = transaccio.getLanguageUI();
    String filtreCertificats = "";
    String administrationID = null; // No te sentit en API Firma En Servidor
    PolicyInfoSignature policyInfoSignature = null;
    if (epes) {
      // XYZ ZZZ
      policyInfoSignature = new PolicyInfoSignature();
      policyInfoSignature.setPolicyIdentifier("urn:oid:2.16.724.1.3.1.1.2.1.9");
      policyInfoSignature.setPolicyIdentifierHash("G7roucf600+f03r/o0bAOQ6WAs0=");
      policyInfoSignature.setPolicyIdentifierHashAlgorithm("SHA1");
      policyInfoSignature
          .setPolicyUrlDocument("https://sede.060.gob.es/politica_de_firma_anexo_1.pdf");
    }

    CommonInfoSignature commonInfoSignature = new CommonInfoSignature(languageUI,
        filtreCertificats, username, administrationID, policyInfoSignature);

    String signID = transaccio.getTransactionWebId();

    String name = fitxer.getNom();
    String reason = "TEST SIGN"; // XYZ ZZZ
    String location = "Palma"; // XYZ ZZZ
    String signerEmail = null; // XYZ ZZZ
    final int signNumber = 1;
    String languageSign = transaccio.getSignParamLanguageDoc();

    String signAlgorithm = FileInfoSignature.SIGN_ALGORITHM_SHA1;

    int signaturesTableLocation = FileInfoSignature.SIGNATURESTABLELOCATION_WITHOUT;
    final PdfVisibleSignature pdfInfoSignature = null;
    final ITimeStampGenerator timeStampGenerator = null;

    // Valors per defcte
    final SignaturesTableHeader signaturesTableHeader = null;
    final SecureVerificationCodeStampInfo csvStampInfo = null;

    final File previusSignatureDetachedFile = null;
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
        previusSignatureDetachedFile, FileInfoSignature.PDF_MIME_TYPE, name, reason, location,
        signerEmail, signNumber, languageSign, signOperation, signType, signAlgorithm,
        signMode, signaturesTableLocation, signaturesTableHeader, pdfInfoSignature,
        csvStampInfo, userRequiresTimeStamp, timeStampGenerator, expedientCode, expedientName,
        expedientUrl, procedureCode, procedureName);

    final String signaturesSetID = String.valueOf(System.currentTimeMillis());
    SignaturesSet signaturesSet = new SignaturesSet(signaturesSetID, commonInfoSignature,
        new FileInfoSignature[] { fileInfo });

    String timestampUrlBase = null;

    Map<String, Object> parameters = new HashMap<String, Object>();

    // TODO Check si passa filtre
    String error = plugin.filter(signaturesSet, parameters);
    if (error != null) {

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge("XYZ ZZZ Plugin " + plugin.getName(locale)
          + " No passa el filtre. Raó:  " + error);

      return null;
    }

    signaturesSet = plugin.signDocuments(signaturesSet, timestampUrlBase, parameters);
    StatusSignaturesSet sss = signaturesSet.getStatusSignaturesSet();

    if (sss.getStatus() != StatusSignaturesSet.STATUS_FINAL_OK) {
      String msg = "XYZ ZZZ Error General MSG = " + sss.getErrorMsg();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
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

    try {
      fitxerSignat = fitxerEjb.create(fitxerSignat);

      File dest = FileSystemManager.crearFitxer(fileSigned, fitxerSignat.getFitxerID());

      transaccio.setFitxerSignaturaID(fitxerSignat.getFitxerID());

      log.info("XYZ ZZZ Guardada Firma a " + dest.getAbsolutePath());

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);

      // XYZ ZZZ Afegir Informacio de la Firma

      // XYZ ZZZ FALTA INFO
      java.lang.String eniTipoFirma = "TF06";
      java.lang.String eniPerfilFirma = epes ? "EPES" : "BES";
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
    } catch (I18NException e) {

      String msg = "XYZ ZZZ Error creant fitxer firmat, guardant a BBDD el fitxer firmat o guardant informació de la firma: "
          + I18NLogicUtils.getMessage(e, locale);

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));

      // Cridades de Plugin
      pluginCridada.postCridadaError(monitorIntegracions,
          msg + "\n\n" + transaccio.getEstatExcepcio());

      return null;

    }

  }

}
