package es.caib.digitalib.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignedFileInfo;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.core.utils.Metadata;
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
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.model.fields.TransaccioFields;
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
public class PluginArxiuLogicaEJB extends AbstractPluginLogicaEJB<IArxiuPlugin>
        implements PluginArxiuLogicaLocal {

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
        Properties prop;
        try {

            plugin = getInstanceByPluginID(perfil.getPluginArxiuID());

            Plugin pluginArxiuJPA = this.findByPrimaryKey(perfil.getPluginArxiuID());

            String propertiesStr = pluginArxiuJPA.getProperties();
            prop = LogicUtils.stringToProperties(propertiesStr);

        } catch (I18NException e1) {

            final String msg = "XYZ ZZZ Error Instanciant PLugins de Arxiu: "
                    + I18NLogicUtils.getMessage(e1, locale);

            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
            transaccio.setEstatMissatge(msg);
            transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e1));

            return null;
        }

        final String parametresText = null;
        PluginCridadaJPA monitorIntegracions = pluginCridada.preCridada(
                perfil.getPluginArxiuID(), "expedientCrear,documentCrear,tancar",
                transaccio.getUsuariPersonaId(), transaccio.getUsuariAplicacioId(),
                parametresText);

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

            // XYZ ZZZ On es fica això !!!!!!
            String procedimentNom = transaccio.getArxiuOptParamProcedimentNom(); // "Subvenciones
                                                                                 // empleo";
            if (procedimentNom == null) {
                procedimentNom = prop
                        .getProperty(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM.javaName);
            }

            String procedimentCodi = transaccio.getArxiuOptParamProcedimentCodi();
            if (procedimentCodi == null) {
                procedimentCodi = prop
                        .getProperty(TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI.javaName);
            }

            // No hauria de ser null
            List<String> organs;
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
            }

            if (transaccio.getSignParamFuncionariDir3() != null) {
                if (organs == null) {
                    organs = new ArrayList<String>();
                }
                organs.add(transaccio.getSignParamFuncionariDir3());
            }

            if (organs == null || organs.size() == 0) {
                log.error("\n\n ================ ORGANS VAL NULL ====================\n\n");
            }

            String serieDocumental = transaccio.getArxiuOptParamSerieDocumental(); // "S0001";
            if (serieDocumental == null) {
                serieDocumental = prop
                        .getProperty(TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL.javaName);
            }

            // XYZ ZZZ Això és per quan l'usuari pugui indicar el nom de l'expedient on vol el
            // document
            // String custodyOrExpedientID = prop
            // .getProperty(TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID.javaName);
            final String interessatsStr = transaccio.getArxiuReqParamInteressats();

            // XYZ ZZZ Fer un tiquet per posar-ho en una propietat del PLugin ????
            final String nomExpedient = "DigitalIB_" + transaccio.getTransactionWebId();

            ExpedientMetadades expedientMetadades = new ExpedientMetadades();
            expedientMetadades.setClassificacio(procedimentCodi);
            expedientMetadades.setDataObertura(new Date());

            expedientMetadades.setInteressats(LogicUtils.stringToListString(interessatsStr));
            expedientMetadades.setMetadadesAddicionals(null);

            expedientMetadades.setOrgans(organs);
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
            final ContingutOrigen origen = (transaccio
                    .getArxiuReqParamOrigen() == ScanWebSimpleArxiuRequiredParameters.DOCUMENTORIGEN_ADMINISTRACIO)
                            ? ContingutOrigen.ADMINISTRACIO
                            : ContingutOrigen.CIUTADA;
            documentMetadades.setOrigen(origen);
            documentMetadades.setOrgans(organs);
            documentMetadades.setDataCaptura(new Date());

            documentMetadades.setEstatElaboracio(DocumentEstatElaboracio
                    .toEnum(transaccio.getArxiuReqParamDocEstatElabora()));
            documentMetadades.setTipusDocumental(
                    DocumentTipus.toEnum(transaccio.getInfoScanDocumentTipus()));
            documentMetadades.setFormat(documentFormat);
            documentMetadades.setExtensio(documentExtensio);

            // ================== METADADES ==================

            // Si posam alguna cosa llavors peta [HTTP_500, COD_021] nodeId is not valid
            // (unknown)
            // El plugin internament ja actualitza aquesta dada
            java.lang.String csvGenerationDefinition = null;

            Map<String, Object> metadadesAddicionals = new HashMap<String, Object>();

            {
                List<Metadata> metadades = PluginDocumentCustodyLogicaEJB
                        .generaMetadades(transaccio, csvGenerationDefinition, log);
                if (metadades != null && metadades.size() != 0) {
                    for (Metadata metadata : metadades) {
                        metadadesAddicionals.put(metadata.getKey(), metadata.getValue());
                    }
                }
            }

            documentMetadades.setMetadadesAddicionals(metadadesAddicionals);

            final FirmaTipus firmaTipus;
            final FirmaPerfil firmaPerfil;
            final Integer signMode;

            InfoSignaturaJPA infoSignatura = transaccio.getInfoSignatura();

            if (infoSignatura == null) {
                firmaTipus = null;
                firmaPerfil = null;
                signMode = null;
            } else {

                signMode = infoSignatura.getSignMode();

                /*
                 * CSV("TF01"), XADES_DET("TF02"), XADES_ENV("TF03"), CADES_DET("TF04"),
                 * CADES_ATT("TF05"), PADES("TF06"), SMIME("TF07"), ODT("TF08"), OOXML("TF09");
                 */
                firmaTipus = FirmaTipus.toEnum(infoSignatura.getEniTipoFirma());

                firmaPerfil = firmaPerfilToEnum(infoSignatura.getEniPerfilFirma());

            }

            // XYZ ZZZ TRA TODO
            final String commonError = "Comprovi que el procés de firma realitza la validació de la mateixa.";

            if (signMode == null) {
                // XYZ ZZZ TRA TODO
                String msg = "SignMode val null." + commonError;
                log.error(msg, new Exception());
                throw new I18NException("genapp.comodi", msg);
            }

            if (firmaTipus == null) {
                // XYZ ZZZ TRA TODO
                String msg = "FirmaTipus val null (infoSignatura.getEniTipoFirma() == "
                        + infoSignatura.getEniTipoFirma() + " )" + commonError;
                log.error(msg, new Exception());
                throw new I18NException("genapp.comodi", msg);
            }

            if (firmaPerfil == null) {
                // XYZ ZZZ TRA TODO
                String msg = "FirmaPerfil val null (infoSignatura.getEniPerfilFirma() == "
                        + infoSignatura.getEniPerfilFirma() + " )" + commonError;
                log.error(msg, new Exception());
                throw new I18NException("genapp.comodi", msg);
            }

            final boolean esDetached;
            esDetached = (infoSignatura.getSignMode() == FileInfoSignature.SIGN_MODE_EXPLICIT);

            DocumentContingut documentContingut;
            if (esDetached) {

                // ES DETACHED

                // FITXER PLA

                FitxerJPA fitxerEscanejat = transaccio.getFitxerEscanejat();
                byte[] plainData = FileSystemManager
                        .getFileContent(fitxerEscanejat.getFitxerID());

                documentContingut = new DocumentContingut();
                documentContingut.setArxiuNom(fitxerEscanejat.getNom());
                documentContingut.setContingut(plainData);
                documentContingut.setTamany(plainData.length);
                documentContingut.setTipusMime(fitxerEscanejat.getMime());

                // nomDocument = fitxerEscanejat.getNom();

            } else {
                // nomDocument = null;
                documentContingut = null;
            }

            // FITXER SIGNAT

            byte[] signedData = FileSystemManager.getFileContent(fitxerFirmat.getFitxerID());

            // final String signatureType = infoSignatura.getSignType();
            String nomDocument = fitxerFirmat.getNom();
            Firma firma;
            firma = new Firma();
            firma.setContingut(signedData);
            // firma.setCsvRegulacio(csvRegulacio);
            firma.setFitxerNom(nomDocument);

            firma.setTipus(firmaTipus);
            firma.setPerfil(firmaPerfil);

            firma.setTamany(signedData.length);

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
            pluginCridada.postCridadaOK(monitorIntegracions,
                    "expedientID=" + expedientId + "\nDocumentID=" + uuidDoc);

            log.info("\n FINAL \n");

            java.lang.String originalFileUrl = plugin.getOriginalFileUrl(uuidDoc);
            String printableFileUrl = plugin.getPrintableFileUrl(uuidDoc);
            String eniFileUrl = plugin.getEniFileUrl(uuidDoc);
            java.lang.String csv = plugin.getCsv(uuidDoc);

            java.lang.String csvValidationWeb = plugin.getCsvValidationWeb(uuidDoc);

            java.lang.String validationFileUrl = plugin.getValidationFileUrl(uuidDoc);

            // Només per DocumentCustody
            java.lang.String custodyID = null;

            InfoCustodyJPA infoCust = new InfoCustodyJPA(custodyID, expedientId, uuidDoc, csv,
                    originalFileUrl, csvValidationWeb, csvGenerationDefinition,
                    printableFileUrl, eniFileUrl, validationFileUrl);

            infoCust = (InfoCustodyJPA) infoCustodyEjb.create(infoCust);

            transaccio.setInfoCustodyID(infoCust.getInfoCustodyID());

            return infoCust;

        } catch (Throwable e) {
            final String msg;

            if (e instanceof I18NException) {
                msg = "XYZ ZZZ Error custodiant fitxer firmat(I18NException): "
                        + I18NLogicUtils.getMessage((I18NException) e, locale);
            } else if (e instanceof ArxiuException) {
                msg = "XYZ ZZZ Error custodiant fitxer firmat(ArxiuException): "
                        + e.getMessage();
            } else {
                msg = "XYZ ZZZ Error custodiant fitxer firmat(" + e.getClass() + "): "
                        + e.getMessage();
            }

            log.error("Error intenant enviar a API d'Arxiu: " + msg, e);

            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
            transaccio.setEstatMissatge(msg);
            transaccio.setEstatExcepcio(LogicUtils.exceptionToString(e));

            // Cridades de Plugin
            pluginCridada.postCridadaError(monitorIntegracions,
                    msg + "\n\n" + transaccio.getEstatExcepcio());
        }

        return null;

    }

    public FirmaPerfil firmaPerfilToEnum(String perfil) throws I18NException {

        if (perfil == null || perfil.trim().length() == 0) {
            log.warn("Perfil de Firma val null. Retornam BES.");
            return FirmaPerfil.BES;
        }

        perfil = perfil.trim();


        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_BES)) {
            return FirmaPerfil.BES;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_EPES)) {
            return FirmaPerfil.EPES;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_T)) {
            return FirmaPerfil.T;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_C)) {
            return FirmaPerfil.C;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_X)) {
            return FirmaPerfil.X;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_X1)) {
            return FirmaPerfil.X;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_X2)) {
            return FirmaPerfil.X;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_XL)) {
            return FirmaPerfil.XL;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_XL1)) {
            return FirmaPerfil.XL;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_XL2)) {
            return FirmaPerfil.XL;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_A)) {
            return FirmaPerfil.A;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_PADES_LTV)) {
            return FirmaPerfil.LTV;
        }
        if (perfil.equals(FirmaSimpleSignedFileInfo.SIGNPROFILE_PADES_BASIC)) {
            return FirmaPerfil.BASIC; // o FirmaPerfil.Basic;
        } else {
            // Cercar traducció
            throw new I18NException("genapp.comodi",
                    "S'ha rebut un perfil de firma de l'acció de firma ]" + perfil
                            + "[ però no s'ha trobat l'equivalent en FirmaPerfil de l'API d'arxiu");
        }

    }

}
