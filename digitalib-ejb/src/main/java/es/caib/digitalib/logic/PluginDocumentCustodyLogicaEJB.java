package es.caib.digitalib.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.documentcustody.api.CustodyException;
import org.fundaciobit.plugins.documentcustody.api.DocumentCustody;
import org.fundaciobit.plugins.documentcustody.api.IDocumentCustodyPlugin;
import org.fundaciobit.plugins.documentcustody.api.NotSupportedCustodyException;
import org.fundaciobit.plugins.documentcustody.api.SignatureCustody;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.core.utils.Metadata;
import org.fundaciobit.pluginsib.core.utils.MetadataConstants;
import org.fundaciobit.pluginsib.core.utils.MetadataFormatException;


import es.caib.digitalib.persistence.FitxerJPA;
import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.persistence.InfoSignaturaJPA;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.persistence.PluginCridadaJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.commons.utils.Constants;

/**
 *
 * @author anadal
 */
@Stateless(name = "PluginDocumentCustodyLogicaEJB")

@RunAs("DIB_ADMIN")
public class PluginDocumentCustodyLogicaEJB extends
    AbstractPluginLogicaEJB<IDocumentCustodyPlugin> implements
    PluginDocumentCustodyLogicaService {

  @EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyService.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoCustodyService infoCustodyEjb;

  @EJB(mappedName = CridadaPluginLogicaService.JNDI_NAME)
  protected CridadaPluginLogicaService pluginCridada;

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
      transaccio.setEstatMissatge(StringUtils.truncate(msg, 254));
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e1));

      return null;
    }

    // Cridades de Plugin
    final String parametresText = null;
    PluginCridadaJPA monitorIntegracions = pluginCridada.preCridada(
        perfil.getPluginDocCustodyID(), "reserveCustodyID, saveAll",
        transaccio.getUsuariPersonaId(), transaccio.getUsuariAplicacioId(), parametresText);

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
        final Boolean attachedDocument = false;
        final String signatureType = infoSignatura.getSignType();

        byte[] signedData = FileSystemManager.getFileContent(fitxerFirmat.getFitxerID());
        signatureCustody = new SignatureCustody(fitxerFirmat.getNom(), fitxerFirmat.getMime(),
            signedData, signatureType, attachedDocument);

      } else {

        document = null;
        byte[] signedData = FileSystemManager.getFileContent(fitxerFirmat.getFitxerID());

        final Boolean attachedDocument = true;
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

      // ============ METADADES =================
      
      java.lang.String csvGenerationDefinition = plugin.getCsvGenerationDefinition(custodyID,
          parameters);

      List<Metadata> metadadesAddicionals = generaMetadades(transaccio, csvGenerationDefinition, log);


      // ============= GUARDAR  !!!

      plugin.saveAll(custodyID, parameters, document, signatureCustody,
          metadadesAddicionals.toArray(new Metadata[metadadesAddicionals.size()]));

      // Cridades de Plugin
      pluginCridada.postCridadaOK(monitorIntegracions, "custodyID=" + custodyID
          + "\ndocument=" + document + "\nfirma=" + signatureCustody);

      // Per Custòdia
      java.lang.String originalFileUrl = plugin.getOriginalFileUrl(custodyID, parameters);
      String printableFileUrl = plugin.getPrintableFileUrl(custodyID, parameters);
      String eniFileUrl = plugin.getEniFileUrl(custodyID, parameters);
      java.lang.String csv = plugin.getCsv(custodyID, parameters);
      java.lang.String csvValidationWeb = plugin.getCsvValidationWeb(custodyID, parameters);
      java.lang.String validationFileUrl = plugin.getValidationFileUrl(custodyID, parameters);

      // Només per Arxiu
      final String arxiuExpedientId = null;
      final String arxiuDocumentId = null;

      InfoCustodyJPA infoCust = new InfoCustodyJPA(custodyID, arxiuExpedientId,
          arxiuDocumentId, csv, originalFileUrl, csvValidationWeb, csvGenerationDefinition,
          printableFileUrl, eniFileUrl, validationFileUrl);

      infoCust = (InfoCustodyJPA) infoCustodyEjb.create(infoCust);

      transaccio.setInfoCustodyID(infoCust.getInfoCustodyID());

      return infoCust;

    } catch (Throwable e) {

      final String msg;
      if (e instanceof MetadataFormatException) {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(MetadataFormatException): "
            + e.getMessage();
      } else if (e instanceof NotSupportedCustodyException) {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(NotSupportedCustodyException): "
            + e.getMessage();
      } else if (e instanceof I18NException) {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(I18NException): "
            + I18NLogicUtils.getMessage((I18NException) e, locale);
      } else if (e instanceof CustodyException) {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(CustodyException): " + e.getMessage();
      } else {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(Throwable): " + e.getMessage();
      }

      log.error(msg, e);

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(StringUtils.truncate(msg, 254));
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));

      // Cridades de Plugin
      pluginCridada.postCridadaError(monitorIntegracions,
          msg + "\n\n" + transaccio.getEstatExcepcio());
    }

    return null;

  }

  public static  List<Metadata> generaMetadades(TransaccioJPA transaccio,String csvGenerationDefinition, Logger log) {
    List<Metadata> metadadesAddicionals = new ArrayList<Metadata>();
    
    // Resolució
    Integer resolucio = transaccio.getInfoScanResolucioPpp();
    if (resolucio != null) {
      //log.info("\n\n  RESOLUCIO: " + resolucio );
      metadadesAddicionals.add(new Metadata("eni:resolucion", resolucio));
    }
    // Idioma del Document
    String languageDoc = transaccio.getInfoScanLanguageDoc();
    if (languageDoc != null) {
      //log.info("\n\n  LANGUAGEDOC: " + languageDoc );
      metadadesAddicionals.add(new Metadata("eni:idioma", languageDoc));
    }
    // Profunditat de Color
    Integer profundidad_color = transaccio.getInfoScanPixelType();
    if (profundidad_color != null) {
      metadadesAddicionals.add(new Metadata("eni:profundidad_color", profundidad_color));
    }
    

    // Identificador único del procedimiento administrativo con el que se relaciona el expediente.
    {
      String procCodi = transaccio.getArxiuOptParamProcedimentCodi();
      if (procCodi != null && procCodi.trim().length() != 0) {
        metadadesAddicionals.add(new Metadata("eni:id_tramite", procCodi));
      }
    }

    metadadesAddicionals.add(new Metadata("eni:tamano_logico",
        FileSystemManager.getFile(transaccio.getFitxerEscanejatID()).length()));
    
    metadadesAddicionals.add(new Metadata("eni:unidades","bytes"));
    
    // Referencia a la disposición normativa que define la creación y uso del CSV correspondiente.
    if (csvGenerationDefinition!= null && csvGenerationDefinition.trim().length() != 0) {
      metadadesAddicionals.add(new Metadata("eni:def_csv",csvGenerationDefinition));
    }
    
    
    String estatElabora =transaccio.getArxiuReqParamDocEstatElabora();
    
    if (estatElabora != null && 
          (
            // EE02
            MetadataConstants.EstadoElaboracionConstants.ESTADO_ELABORACION_COPIA_CF.equals(estatElabora)
            // EE03
            || MetadataConstants.EstadoElaboracionConstants.ESTADO_ELABORACION_COPIA_DP.equals(estatElabora)
            // EE04
            || MetadataConstants.EstadoElaboracionConstants.ESTADO_ELABORACION_COPIA_PR.equals(estatElabora)
          )) {
        
   
    
        //  ES_<Órgano>_<AAAA>_<ID_específico>  ==>  "ES_3456789_2020_ES"
        // No hauria de ser null
        List<String> organs;
        String firstOrgan;
        {
          final String organsStr = transaccio.getArxiuReqParamOrgans(); // "A04013511";
          
          if (organsStr == null) {
            organs = null;
          } else if (organsStr.trim().length() == 0) {
            organs = null;
          } else {
            List<String> tmp = LogicUtils.stringToListString(organsStr);
            organs = new ArrayList<String>();
            for (String organ : tmp) {
              if (organ.trim().length() != 0) {
                organs.add(organ);
              }
            }
            if (organs.size() == 0) {
              organs = null;
            }
          }
          firstOrgan = (organs == null)? null : organs.get(0);
        }
        
        if (firstOrgan != null) {
          String idOrigen = "ES_" + firstOrgan + "_" + Calendar.getInstance().get(Calendar.YEAR) + "_" + Constants.PREFIX + transaccio.getTransaccioID();
          metadadesAddicionals.add(new Metadata("eni:id_origen", idOrigen));
        }
    }
    
    
    // XYZ ZZZ ESBORRAR !!!!!
    /*
    metadadesAddicionals.add(new Metadata("eni:subtipo_doc", "Especial CAIB"));
    */
    return metadadesAddicionals;
  }

}
