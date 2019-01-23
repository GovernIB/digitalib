package es.caib.digitalib.logic;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.jpa.FitxerJPA;
import es.caib.digitalib.jpa.InfoCustodyJPA;
import es.caib.digitalib.jpa.InfoSignaturaJPA;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.PluginCridadaJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.utils.Constants;
import es.caib.plugins.arxiu.api.ArxiuException;
import es.caib.plugins.arxiu.api.ContingutArxiu;
import es.caib.plugins.arxiu.api.ContingutOrigen;
import es.caib.plugins.arxiu.api.Document;
import es.caib.plugins.arxiu.api.DocumentContingut;
import es.caib.plugins.arxiu.api.DocumentEstat;
import es.caib.plugins.arxiu.api.DocumentEstatElaboracio;
import es.caib.plugins.arxiu.api.DocumentExtensio;
import es.caib.plugins.arxiu.api.DocumentFormat;
import es.caib.plugins.arxiu.api.DocumentMetadades;
import es.caib.plugins.arxiu.api.DocumentTipus;
import es.caib.plugins.arxiu.api.Expedient;
import es.caib.plugins.arxiu.api.ExpedientMetadades;
import es.caib.plugins.arxiu.api.Firma;
import es.caib.plugins.arxiu.api.FirmaPerfil;
import es.caib.plugins.arxiu.api.FirmaTipus;
import es.caib.plugins.arxiu.api.IArxiuPlugin;

/**
 *
 * @author anadal(u80067)
 */
@Stateless(name = "PluginArxiuLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class PluginArxiuLogicaEJB extends AbstractPluginLogicaEJB<IArxiuPlugin> implements
    PluginArxiuLogicaLocal {

  @EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoCustodyLocal infoCustodyEjb;
  

  @EJB(mappedName = CridadaPluginLogicaLocal.JNDI_NAME)
  protected CridadaPluginLogicaLocal pluginCridada;

  @Override
  public int getTipusDePlugin() {
    return Constants.TIPUS_PLUGIN_ARXIU;
  }

  @Override
  protected String getName() {
    return "Arxiu";
  }

  @Override
  public InfoCustodyJPA custodiaAmbApiArxiu(TransaccioJPA transaccio, Fitxer fitxerFirmat,
      Locale locale) {

    PerfilJPA perfil = transaccio.getPerfil();

    log.info(" XYZ ZZZ custodiaAmbApiArxiu:: PERFIL = " + perfil);
    log.info(" XYZ ZZZ custodiaAmbApiArxiu:: PERFIL.getPluginArxiuID = "
        + perfil.getPluginArxiuID());

    IArxiuPlugin plugin;
    try {

      plugin = getInstanceByPluginID(perfil.getPluginArxiuID());

    } catch (I18NException e1) {

      final String msg = "XYZ ZZZ Error Instanciant PLugins de Arxiu: "
          + I18NLogicUtils.getMessage(e1, locale);

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e1));

      return null;
    }

    
    
    final String parametresText = null;
    PluginCridadaJPA monitorIntegracions = pluginCridada.preCridada(perfil.getPluginArxiuID(), "expedientCrear,documentCrear,tancar", transaccio.getUsuariPersonaId(), transaccio.getUsuariAplicacioId(), parametresText);
    
    InfoSignaturaJPA infoSignatura = transaccio.getInfoSignatura();
    try {

      // ============ CALCULATS
      // ----- Format i Extensio
      DocumentFormat documentFormat;
      DocumentExtensio documentExtensio;
      {
        switch (transaccio.getPerfil().getScanFormatFitxer()) {

        case Constants.FORMAT_FILE_PDF:
          documentFormat = DocumentFormat.PDF;
          documentExtensio = DocumentExtensio.PDF;
          break;

        case Constants.FORMAT_FILE_JPG:
          documentFormat = DocumentFormat.JPEG;
          documentExtensio = DocumentExtensio.JPEG;
          break;

        case Constants.FORMAT_FILE_TIFF:
          documentFormat = DocumentFormat.TIFF;
          documentExtensio = DocumentExtensio.TIFF;
          break;

        case Constants.FORMAT_FILE_PNG:
          documentFormat = DocumentFormat.PNG;
          documentExtensio = DocumentExtensio.PNG;
          break;

        case Constants.FORMAT_FILE_GIF:
          // XYZ ZZZ
          final String msg1 = "XYZ ZZZ Format de Fitxer GIF no està suportat per l'ARXIU ";

          transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
          transaccio.setEstatMissatge(msg1);

          return null;

        default:
          final String msg = "XYZ ZZZ identificador de Format de Fitxer escanejat desconegut ("
              + transaccio.getPerfil().getScanFormatFitxer() + ").";
          transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
          transaccio.setEstatMissatge(msg);
          return null;
        }

      }
      /*
       * // XYZ ZZZ INFO BBDD ARXIU final String procedimentCodi = "organo1_PRO_123456789";
       * final String procedimentNom = "Subvenciones empleo"; final String nomExpedient =
       * "DigitalIB_" + transaccio.getTransactionWebId(); final String organsStr = "A04013511";
       * final String serieDocumental = "S0001";
       * 
       * // XYZ ZZZ Formulari Usuari final String interessatsStr = "12345678X,87654321Z"; final
       * ContingutOrigen origen = ContingutOrigen.ADMINISTRACIO; // ContingutOrigen.CIUTADA
       * 
       * // * ORIGINAL("EE01"): Original (Llei 11/2007 Art. 30)COPIA_CF("EE02"): Còpia
       * electrònica // * autèntica amb canvi de format (Llei 11/2007 Art.
       * 30.1).COPIA_DP("EE03"): Còpia // * electrònica autèntica de document en paper amb
       * canvi de format (Llei 11/2007 Art. 30.2 // * i 30.3).COPIA_PR("EE04"): Còpia
       * electrònica parcial autèntica.ALTRES("EE99"): Altres // * estats d'elaboració.
       * 
       * final DocumentEstatElaboracio documentEstatElaboracio =
       * DocumentEstatElaboracio.ORIGINAL;
       * 
       * // * RESOLUCIO("TD01"), ACORD("TD02"), CONTRACTE("TD03"), CONVENI("TD04"), // *
       * DECLARACIO("TD05"), COMUNICACIO("TD06"), NOTIFICACIO("TD07"), PUBLICACIO("TD08"), // *
       * JUSTIFICANT_RECEPCIO("TD09"), ACTA("TD10"), CERTIFICAT("TD11"), DILIGENCIA("TD12"), //
       * * INFORME("TD13"), SOLICITUD("TD14"), DENUNCIA("TD15"), ALEGACIO("TD16"), // *
       * RECURS("TD17"), COMUNICACIO_CIUTADA("TD18"), FACTURA("TD19"), // *
       * ALTRES_INCAUTATS("TD20"), ALTRES("TD99"); // * // * toEnum(TDxx) converteix de TDxx a
       * DocumentTipus
       * 
       * final DocumentTipus documentTipus = DocumentTipus.ACORD;
       */

      // Map<String, Object> parameters = new HashMap<String, Object>();
      // parameters.put("transaccio", transaccio);
      // parameters.put("fitxerFirmat", fitxerFirmat);

      final String procedimentCodi = transaccio.getArxiuOptParamProcedimentCodi();

      // XYZ ZZZ On es fica això !!!!!!
      final String procedimentNom = transaccio.getArxiuOptParamProcedimentNom(); // "Subvenciones empleo";

      final String interessatsStr = transaccio.getArxiuReqParamInteressats();

      // XYZ ZZZ Fer un tiquet per posar-ho en una propietat del PLugin ????
      final String nomExpedient = "DigitalIB_" + transaccio.getTransactionWebId();
      final String organsStr = transaccio.getArxiuOptParamOrgans(); // "A04013511";
      final String serieDocumental = transaccio.getArxiuOptParamSerieDocumental(); // "S0001";

      ExpedientMetadades expedientMetadades = new ExpedientMetadades();
      expedientMetadades.setClassificacio(procedimentCodi);
      expedientMetadades.setDataObertura(new Date());

      expedientMetadades.setInteressats(LogicUtils.stringToListString(interessatsStr));
      expedientMetadades.setMetadadesAddicionals(null);
      expedientMetadades.setOrgans(LogicUtils.stringToListString(organsStr));
      expedientMetadades.setSerieDocumental(serieDocumental);
      // expedientMetadades.setVersioNti(versioNti);

      Expedient expedient = new Expedient();
      expedient.setNom(nomExpedient);
      // expedient.setVersio("1.0");
      expedient.setMetadades(expedientMetadades);

      if (transaccio.getArxiuOptParamCustodyOrExpedientId() != null) {
        // XYZ ZZZ Falta implementar que s'hagi definit un EXPEDIENT
        log.error(
            "\n\n Falta implementar que s'hagi definit un EXPEDIENT (no s'hauria de fer creacio d'expedient) \n\n",
            new Exception());
      }

      log.info("XYZ ZZZ  Creant expedient... ");
      ContingutArxiu expedientCreat = plugin.expedientCrear(expedient);

      final String expedientId = expedientCreat.getIdentificador();

      log.info("XYZ ZZZ  Creat expedient amd ID = " + expedientId);

      log.info("XYZ ZZZ  Creant document ... ");
      final DocumentMetadades documentMetadades = new DocumentMetadades();
      final ContingutOrigen origen = (transaccio.getArxiuReqParamOrigen() == ScanWebSimpleArxiuRequiredParameters.ORIGEN_ADMINISTRACIO) ? ContingutOrigen.ADMINISTRACIO
          : ContingutOrigen.CIUTADA;
      documentMetadades.setOrigen(origen);
      documentMetadades.setOrgans(LogicUtils.stringToListString(organsStr));
      documentMetadades.setDataCaptura(new Date());

      documentMetadades.setEstatElaboracio(DocumentEstatElaboracio.toEnum(transaccio
          .getArxiuReqParamDocEstatElabora()));
      documentMetadades.setTipusDocumental(DocumentTipus.toEnum(transaccio
          .getArxiuReqParamDocumentTipus()));
      documentMetadades.setFormat(documentFormat);
      documentMetadades.setExtensio(documentExtensio);

      DocumentContingut documentContingut;
      Firma firma;

      final boolean esDetached = (infoSignatura.getSignMode() == FileInfoSignature.SIGN_MODE_EXPLICIT);

      String nomDocument;
      if (esDetached) {

        // ES DETACHED

        // FITXER PLA

        FitxerJPA fitxerEscanejat = transaccio.getFitxerEscanejat();
        byte[] plainData = FileSystemManager.getFileContent(fitxerEscanejat.getFitxerID());

        documentContingut = new DocumentContingut();
        documentContingut.setArxiuNom(fitxerEscanejat.getNom());
        documentContingut.setContingut(plainData);
        documentContingut.setTamany(plainData.length);
        documentContingut.setTipusMime(fitxerEscanejat.getMime());

        nomDocument = fitxerEscanejat.getNom();

      } else {
        nomDocument = null;
        documentContingut = null;
      }

      // FITXER SIGNAT

      byte[] signedData = FileSystemManager.getFileContent(fitxerFirmat.getFitxerID());

      // final String signatureType = infoSignatura.getSignType();
      firma = new Firma();
      firma.setContingut(signedData);
      // firma.setCsvRegulacio(csvRegulacio);
      firma.setFitxerNom(fitxerFirmat.getNom());
      nomDocument = fitxerFirmat.getNom();
      FirmaPerfil firmaPerfil = FirmaPerfil.toEnum(infoSignatura.getEniPerfilFirma());
      if (firmaPerfil == null) {
        log.error("FirmaPerfil val null (infoSignatura.getEniPerfilFirma() == "
            + infoSignatura.getEniPerfilFirma() + " )");
      }
      firma.setPerfil(firmaPerfil);
      firma.setTamany(signedData.length);

      /*
       * CSV("TF01"), XADES_DET("TF02"), XADES_ENV("TF03"), CADES_DET("TF04"),
       * CADES_ATT("TF05"), PADES("TF06"), SMIME("TF07"), ODT("TF08"), OOXML("TF09");
       */
      FirmaTipus firmaTipus = FirmaTipus.toEnum(infoSignatura.getEniTipoFirma());
      if (firmaTipus == null) {
        log.error("FirmaTipus val null (infoSignatura.getEniTipoFirma() == "
            + infoSignatura.getEniTipoFirma() + " )");
      }
      firma.setTipus(firmaTipus);
      firma.setTipusMime(fitxerFirmat.getMime());

      final Document documentPerCrear = new Document();
      documentPerCrear.setContingut(documentContingut);
      documentPerCrear.setEstat(DocumentEstat.DEFINITIU);

      documentPerCrear.setFirmes(Arrays.asList(firma));

      // documentPerCrear.setIdentificador(identificador);

      documentPerCrear.setMetadades(documentMetadades);

      documentPerCrear.setNom(nomDocument);

      ContingutArxiu documentCreat = plugin.documentCrear(documentPerCrear, expedientId);

      log.info("XYZ ZZZ  Creat document ... ");
      
      log.info("XYZ ZZZ  Tancar Expedient ... ");
      plugin.expedientTancar(expedientId);
      log.info("XYZ ZZZ  Expedient Tancat... ");
      
      String uuidDoc = documentCreat.getIdentificador();
      
      // Cridades de Plugin
      pluginCridada.postCridadaOK(monitorIntegracions, "expedientID=" + expedientId 
           + "\nDocumentID=" + uuidDoc );
      
      log.info("\n FINAL \n");

      

      java.lang.String originalFileUrl = plugin.getOriginalFileUrl(uuidDoc);
      String printableFileUrl = plugin.getPrintableFileUrl(uuidDoc);
      String eniFileUrl = plugin.getEniFileUrl(uuidDoc);
      java.lang.String csv = plugin.getCsv(uuidDoc);
      
      
      
      java.lang.String csvValidationWeb = plugin.getCsvValidationWeb(uuidDoc);
      java.lang.String csvGenerationDefinition = plugin.getCsvGenerationDefinition(uuidDoc);
      java.lang.String validationFileUrl = plugin.getValidationFileUrl(uuidDoc);

      // Només per DocumentCustody
      java.lang.String custodyID = null;

      InfoCustodyJPA infoCust = new InfoCustodyJPA(custodyID ,
          expedientId ,  uuidDoc ,  csv ,  originalFileUrl ,  csvValidationWeb ,
          csvGenerationDefinition , printableFileUrl ,  eniFileUrl , validationFileUrl);

      infoCust = (InfoCustodyJPA) infoCustodyEjb.create(infoCust);

      transaccio.setInfoCustodyID(infoCust.getInfoCustodyID());

      return infoCust;

    } catch (Throwable e) {
      final String msg;
      
      if (e instanceof I18NException) {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(I18NException): "
            + I18NLogicUtils.getMessage((I18NException)e, locale);
      } else if (e instanceof ArxiuException) {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(ArxiuException): "
            + e.getMessage();
      } else {
        msg = "XYZ ZZZ Error custodiant fitxer firmat(" + e.getClass()+ "): " + e.getMessage();
      }

      
      // XYZ ZZZ
      e.printStackTrace();

      transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
      transaccio.setEstatMissatge(msg);
      transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));
      
      
      // Cridades de Plugin
      pluginCridada.postCridadaError(monitorIntegracions, msg + "\n\n" + transaccio.getEstatExcepcio());
    }


    return null;

  }

}
