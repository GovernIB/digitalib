package es.caib.digitalib.logic;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.documentcustody.api.CustodyException;
import org.fundaciobit.plugins.documentcustody.api.DocumentCustody;
import org.fundaciobit.plugins.documentcustody.api.IDocumentCustodyPlugin;
import org.fundaciobit.plugins.documentcustody.api.NotSupportedCustodyException;
import org.fundaciobit.plugins.documentcustody.api.SignatureCustody;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.core.utils.Metadata;
import org.fundaciobit.pluginsib.core.utils.MetadataFormatException;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.jpa.FitxerJPA;
import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.InfoSignaturaJPA;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.utils.Constants;

/**
 *
 * @author anadal
 */
@Stateless(name = "PluginDocumentCustodyLogicaEJB")
@SecurityDomain("seycon")
public class PluginDocumentCustodyLogicaEJB extends
    AbstractPluginLogicaEJB<IDocumentCustodyPlugin> implements
    PluginDocumentCustodyLogicaLocal {

  @EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoCustodyLocal infoCustodyEjb;

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_DOCUMENT_CUSTODY;
  }

  @Override
  protected String getName() {
    return "Document Custody";
  }

  @Override
  public InfoCustodyJPA custodiaAmbApiDocumentCustody(TransaccioJPA transaccio,
      Fitxer fitxerFirmat, Locale locale) {

    PerfilJPA perfil = transaccio.getPerfil();

    // XYZ ZZZ NOMES SUPORTAM PERFIL PDF
    // if (IScanWebPlugin.SCANTYPE_PDF.equals(perfil.getScanFormatFitxer())) {
    // transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
    // transaccio.setEstatMissatge("XYZ ZZZ Nomes es suporta el Format de Escaneig PDF. "
    // + "El seu perfil requereix " + perfil.getScanFormatFitxer()
    // + ". Consulti amb el seu Administrador");
    // return null;
    // }

    log.info(" XYZ ZZZ custodiaAmbApiDocumentCustody:: PERFIL = " + perfil);
    log.info(" XYZ ZZZ custodiaAmbApiDocumentCustody:: PERFIL.getPluginDocCustodyID = "
        + perfil.getPluginDocCustodyID());

    IDocumentCustodyPlugin plugin;
    try {

      plugin = getInstanceByPluginID(perfil.getPluginDocCustodyID());

    } catch (I18NException e1) {

      final String msg = "XYZ ZZZ Error Instanciant PLugins de DocumentCustody: "
          + I18NLogicUtils.getMessage(e1, locale);

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e1));

      return null;
    }

    try {

      Map<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("transaccio", transaccio);
      parameters.put("fitxerFirmat", fitxerFirmat);

      if (transaccio.getArxiuOptParamCustodyOrExpedientId() != null) {
        // XYZ ZZZ Falta implementar que s'hagi de guardar en un CUSTODY DETERMINAT
        log.error(
            "\n\n Falta implementar que s'hagi definit un CUSTODY ID (no s'hauria de fer reserva) \n\n",
            new Exception());
      }

      String custodyID = plugin.reserveCustodyID(parameters);

      InfoSignaturaJPA infoSignatura = transaccio.getInfoSignatura();

      // String tipusFirma = infoSignatura.getSignType();
      int modoFirma = infoSignatura.getSignMode();

      boolean esDetached = (modoFirma == FileInfoSignature.SIGN_MODE_EXPLICIT);

      DocumentCustody document;
      SignatureCustody signatureCustody;

      if (esDetached) {

        FitxerJPA fitxerEscanejat = transaccio.getFitxerEscanejat();

        byte[] plainData = FileSystemManager.getFileContent(fitxerEscanejat.getFitxerID());

        document = new DocumentCustody(fitxerEscanejat.getNom(), fitxerEscanejat.getMime(),
            plainData);
        final Boolean attachedDocument = true;
        final String signatureType = infoSignatura.getSignType();

        byte[] signedData = FileSystemManager.getFileContent(fitxerFirmat.getFitxerID());
        signatureCustody = new SignatureCustody(fitxerFirmat.getNom(), fitxerFirmat.getMime(),
            signedData, signatureType, attachedDocument);

      } else {

        document = null;
        byte[] signedData = FileSystemManager.getFileContent(fitxerFirmat.getFitxerID());

        final Boolean attachedDocument = false;
        final String signatureType = infoSignatura.getSignType();

        String signatureTypeDC;
        if (FileInfoSignature.SIGN_TYPE_PADES.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.PADES_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_CADES.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.CADES_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_CADES_ASIC_S.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.CADES_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_FACTURAE.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.XADES_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_ODF.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.ODF_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_OOXML.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.OOXML_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_PKCS1.equals(signatureType)) {
          // XYZ ZZZ Traduir
          throw new Exception("Firma de tipus PKCS1 no està suportada per DOCUMENT CUSTODY ");
        } else if (FileInfoSignature.SIGN_TYPE_SMIME.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.SMIME_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_XADES.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.XADES_SIGNATURE;
        } else if (FileInfoSignature.SIGN_TYPE_XADES_ASIC_S.equals(signatureType)) {
          signatureTypeDC = SignatureCustody.XADES_SIGNATURE;
        } else {
          // XYZ ZZZ Traduir
          throw new Exception("Firma de tipus " + signatureType
              + " no està suportada per DOCUMENT CUSTODY ");
        }

        signatureCustody = new SignatureCustody(fitxerFirmat.getNom(), fitxerFirmat.getMime(),
            signedData, signatureTypeDC, attachedDocument);
      }

      // XYZ ZZZ Falten metadades
      Metadata[] metadata = new Metadata[] {}; // XYZ ZZZ

      plugin.saveAll(custodyID, parameters, document, signatureCustody, metadata);
      
      log.info("\n FINAL \n");

      // Per Custòdia
      java.lang.String originalFileUrl = plugin.getOriginalFileUrl(custodyID, parameters);
      String printableFileUrl = plugin.getPrintableFileUrl(custodyID, parameters);
      String eniFileUrl = plugin.getEniFileUrl(custodyID, parameters);
      java.lang.String csv = plugin.getCsv(custodyID, parameters);
      java.lang.String csvValidationWeb = plugin.getCsvValidationWeb(custodyID, parameters);
      java.lang.String csvGenerationDefinition = plugin.getCsvGenerationDefinition(custodyID,
          parameters);
      java.lang.String validationFileUrl = plugin.getValidationFileUrl(custodyID,
          parameters);

      // Només per Arxiu
      final String arxiuExpedientId = null;
      final String arxiuDocumentId = null;

      InfoCustodyJPA infoCust = new InfoCustodyJPA(custodyID ,
            arxiuExpedientId ,  arxiuDocumentId ,  csv ,  originalFileUrl ,  csvValidationWeb ,
             csvGenerationDefinition , printableFileUrl ,  eniFileUrl , validationFileUrl);


      infoCust = (InfoCustodyJPA) infoCustodyEjb.create(infoCust);

      transaccio.setInfoCustodyID(infoCust.getInfoCustodyID());

      return infoCust;

    } catch (I18NException e) {
      String msg = "XYZ ZZZ Error custodiant fitxer firmat(I18NException): "
          + I18NLogicUtils.getMessage(e, locale);

      // XYZ ZZZ
      e.printStackTrace();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));

    } catch (CustodyException e) {
      String msg = "XYZ ZZZ Error custodiant fitxer firmat(CustodyException): "
          + e.getMessage();

      // XYZ ZZZ
      e.printStackTrace();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));
    } catch (NotSupportedCustodyException e) {
      String msg = "XYZ ZZZ Error custodiant fitxer firmat(NotSupportedCustodyException): "
          + e.getMessage();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));

    } catch (MetadataFormatException e) {
      String msg = "XYZ ZZZ Error custodiant fitxer firmat(MetadataFormatException): "
          + e.getMessage();

      // XYZ ZZZ
      e.printStackTrace();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));
    } catch (Exception e) {
      String msg = "XYZ ZZZ Error custodiant fitxer firmat(Exception): " + e.getMessage();

      // XYZ ZZZ
      e.printStackTrace();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));
    }

    return null;

  }

}
