package es.caib.digitalib.logic;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.fundaciobit.apisib.apifirmasimple.v1.ApiFirmaEnServidorSimple;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleCommonInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleFile;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleFileInfoSignature;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignDocumentRequest;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignatureResult;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignedFileInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignerInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleStatus;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleValidationInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.jersey.ApiFirmaEnServidorSimpleJersey;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.apisib.core.exceptions.AbstractApisIBException;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.fundaciobit.pluginsib.utils.templateengine.TemplateEngine;

import com.google.common.hash.Hashing;

import es.caib.digitalib.persistence.ApiSimpleJPA;
import es.caib.digitalib.persistence.InfoSignaturaJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.model.bean.FitxerBean;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.ejb.InfoSignaturaService;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "ApiFirmaSimpleLogicaEJB")
@RunAs("DIB_ADMIN")
public class ApiFirmaSimpleLogicaEJB implements ApiFirmaSimpleLogicaService {

    protected final Logger log = Logger.getLogger(this.getClass());

    @EJB(mappedName = FitxerLogicaService.JNDI_NAME)
    protected FitxerLogicaService fitxerLogicaEjb;

    @EJB(mappedName = InfoSignaturaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.InfoSignaturaService infoSignaturaEjb;

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    /**
     * 
     */
    @Override
    public Fitxer signUsingApiFirmaSimple(TransaccioJPA transaccio, ApiSimpleJPA apisimple,
            Fitxer fitxer)  {

        ApiFirmaEnServidorSimple api; 
        try {
        
          final Map<String, Object> map = new HashMap<String, Object>();
          map.put("SP", System.getProperties());
        
          final Locale loc = new Locale("ca");
          
          log.info(" =============================================");
          log.info("URL PRE => " + apisimple.getUrl()); 
          String url = TemplateEngine.processExpressionLanguageSquareBrackets(apisimple.getUrl(), map, loc);
          log.info("URL POST => |" + url  + "|");
          log.info("USERNAME PRE => " + apisimple.getUsername());
          String username = TemplateEngine.processExpressionLanguageSquareBrackets(apisimple.getUsername(), map, loc);
          log.info("USERNAME POST => |" + username  + "|");
          log.info("PASSWORD PRE => " + apisimple.getContrasenya());
          String password = TemplateEngine.processExpressionLanguageSquareBrackets(apisimple.getContrasenya(), map, loc);
          log.info("PASSWORD POST => |" + password + "|");
        
          log.info(" =============================================");
        
          api = new ApiFirmaEnServidorSimpleJersey(url, username, password);
        } catch (Exception e) {

            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
            transaccio.setEstatMissatge(
                    "ApiFirmaSimple::Error durant instanciació de l'API de Firma Simple: " + e.getMessage());
            transaccio
                    .setEstatExcepcio(org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e));
            log.error(transaccio.getEstatMissatge(), e);
            return null;
        }

        String signID = "1";
        String name = transaccio.getNom();

        String reason = templateEngine(Configuracio.getSignReasonEL(), transaccio);

        log.info("\n\n  getSignReasonEL => ]" + reason + "[\n\n");

        String location = templateEngine(Configuracio.getSignLocationEL(), transaccio);
        String signerEmail = templateEngine(Configuracio.getSignerEmailEL(), transaccio);

        int signNumber = 1;
        String languageSign = transaccio.getInfoScanLanguageDoc();
        if (languageSign == null || languageSign.trim().length() == 0) {
            languageSign = Configuracio.getDefaultLanguage();
        }

        long tipusDocumentalID;
        {
            String tipusStr = transaccio.getInfoScanDocumentTipus();
            if (tipusStr == null || tipusStr.trim().length() == 0) {
                tipusDocumentalID = 99; // =TD99
            } else {
                try {
                    tipusDocumentalID = Long.parseLong(tipusStr.replace("TD", ""));
                } catch (NumberFormatException nfe) {
                    log.error("Error parsejant tipus documental ]" + tipusStr + "[:"
                            + nfe.getMessage(), nfe);
                    tipusDocumentalID = 99;
                }
            }
        }

        File source = FileSystemManager.getFile(fitxer.getFitxerID());

        byte[] data;
        try {
            data = FileUtils.readFromFile(source);
        } catch (Exception e) {

            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
            transaccio.setEstatMissatge(
                    "ApiFirmaSimple::Error durant la lectura del document a signar ("
                            + source.getAbsolutePath() + "): " + e.getMessage());
            transaccio
                    .setEstatExcepcio(ExceptionUtils.getStackTrace(e));
            log.error(transaccio.getEstatMissatge(), e);
            return null;
        }

        FirmaSimpleFile fileToSign = new FirmaSimpleFile(fitxer.getNom(), fitxer.getMime(),
                data);

        FirmaSimpleFileInfoSignature fileInfoSignature = new FirmaSimpleFileInfoSignature(
                fileToSign, signID, name, reason, location, signNumber, languageSign,
                tipusDocumentalID);

        String languageUI = transaccio.getLanguageUI();
        // Es la configuració del Servidor
        String username = apisimple.getConfigDeFirma();
        String administrationID = null;

        FirmaSimpleCommonInfo commonInfo;
        commonInfo = new FirmaSimpleCommonInfo(apisimple.getPerfil(), languageUI, username,
                administrationID, signerEmail);

        FirmaSimpleSignDocumentRequest signature;
        signature = new FirmaSimpleSignDocumentRequest(commonInfo, fileInfoSignature);

        FirmaSimpleSignatureResult fullResults;
        try {
            log.info(" Cridant a signDocument() ... ");
            fullResults = api.signDocument(signature);
        } catch (AbstractApisIBException e) {
            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
            transaccio.setEstatMissatge(
                    "ApiFirmaSimple::Error durant la cridada a signar document: "
                            + e.getMessage());
            transaccio.setEstatExcepcio(getStackTrace(e));
            log.error(transaccio.getEstatMissatge(), e);
            return null;
        }

        FirmaSimpleStatus transactionStatus = fullResults.getStatus();

        int status = transactionStatus.getStatus();

        Fitxer fitxerSignat = null;
        String error = null;

        switch (status) {

            case FirmaSimpleStatus.STATUS_INITIALIZING: // = 0;
                error = "El Procés de Firma ha finalitzat en un estat Initializing, que es un estat inconsistent.";
            break;

            case FirmaSimpleStatus.STATUS_IN_PROGRESS: // = 1;
                error = "El Procés de Firma ha finalitzat en un estat In Progres, que es un estat inconsistent.";
            break;

            case FirmaSimpleStatus.STATUS_FINAL_ERROR: // = -1;

                error = "Error durant la realització de la firma: "
                        + transactionStatus.getErrorMessage();
                String desc = transactionStatus.getErrorStackTrace();
                if (desc != null) {
                    log.error(error + "\n" + desc);
                }
            break;

            case FirmaSimpleStatus.STATUS_CANCELLED: // = -2;
                error = "El Procés de Firma s'ha cancel·lat.";
            break;

            case FirmaSimpleStatus.STATUS_FINAL_OK: // = 2;
            {
                try {

                    FirmaSimpleFile fsf = fullResults.getSignedFile();

                    /*
                     * FileOutputStream fos = new FileOutputStream(fsf.getNom());
                     * fos.write(fsf.getData()); fos.flush(); fos.close();
                     */

                    String nom = fitxer.getNom();

                    int punt = nom.lastIndexOf('.');

                    if (punt == -1) {
                        nom = nom + ".signed";
                    } else {
                        nom = nom.substring(0, punt) + "-signed" + nom.substring(punt);
                    }

                    fitxerSignat = new FitxerBean("", FileInfoSignature.PDF_MIME_TYPE, nom,
                            fsf.getData().length);

                    fitxerSignat = fitxerLogicaEjb.create(fitxerSignat);

                    File dest = FileSystemManager.crearFitxer(
                            new ByteArrayInputStream(fsf.getData()),
                            fitxerSignat.getFitxerID());

                    transaccio.setFitxerSignaturaID(fitxerSignat.getFitxerID());

                    String hashSignatura = Hashing.sha256()
                            .hashString(String.valueOf(transaccio.getFitxerSignaturaID()),
                                    Charset.forName("UTF-8"))
                            .toString();

                    transaccio.setHashFirma(hashSignatura);
                    log.info("XYZ ZZZ Guardada Firma a " + dest.getAbsolutePath());

                    transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_OK);

                    FirmaSimpleSignedFileInfo sfi = fullResults.getSignedFileInfo();

                    // XYZ ZZZ Afegir Informacio de la Firma

                    // XYZ ZZZ FALTA INFO
                    java.lang.String eniTipoFirma = sfi.getEniTipoFirma();
                    java.lang.String eniPerfilFirma = sfi.getEniPerfilFirma();

                    log.info("\n\n\n eniTipoFirma = " + sfi.getEniTipoFirma()
                            + "\neniPerfilFirma = " + sfi.getEniPerfilFirma() + "\n\n\n");

                    if (eniPerfilFirma == null) {
                        eniPerfilFirma = FirmaSimpleSignedFileInfo.SIGNPROFILE_BES;
                        log.warn("eniPerfilFirma es NULL. Posam per defecte " + eniPerfilFirma
                                + "!!!!!");
                    }

                    java.lang.String eniRolFirma = null;

                    String eniSignerName = null;
                    String eniSignerAdministrationId = null;
                    String eniSignLevel = null;

                    FirmaSimpleSignerInfo signerInfo = sfi.getSignerInfo();
                    if (signerInfo != null) {
                        eniSignerName = signerInfo.getEniSignerName();
                        eniSignerAdministrationId = signerInfo.getEniSignerAdministrationId();
                        eniSignLevel = signerInfo.getEniSignLevel();
                    }

                    Boolean checkAdministrationIdOfSigner = null;
                    Boolean checkDocumentModifications = null;
                    Boolean checkValidationSignature = null;

                    FirmaSimpleValidationInfo vi = sfi.getValidationInfo();
                    if (vi != null) {
                        checkAdministrationIdOfSigner = vi.getCheckAdministrationIDOfSigner();
                        checkDocumentModifications = vi.getCheckDocumentModifications();
                        checkValidationSignature = vi.getCheckValidationSignature();
                    }

                    int signOperation = sfi.getSignOperation();
                    String signType = sfi.getSignType();
                    String signAlgorithm = sfi.getSignAlgorithm();

                    Integer signMode = sfi.getSignMode();

                    Integer signaturesTableLocation = sfi.getSignaturesTableLocation();

                    Boolean timestampIncluded = sfi.isTimeStampIncluded();

                    Boolean policyIncluded = sfi.isPolicyIncluded();

                    InfoSignaturaJPA infoSign = new InfoSignaturaJPA(signOperation, signType,
                            signAlgorithm, signMode, signaturesTableLocation,
                            timestampIncluded, policyIncluded, eniTipoFirma, eniPerfilFirma,
                            eniRolFirma, eniSignerName, eniSignerAdministrationId,
                            eniSignLevel, checkAdministrationIdOfSigner,
                            checkDocumentModifications, checkValidationSignature);

                    infoSign = (InfoSignaturaJPA) infoSignaturaEjb.create(infoSign);

                    transaccio.setInfoSignaturaID(infoSign.getInfoSignaturaID());

                    log.info("XYZ ZZZ Assignant  Info Signatura a Transaccio: " + infoSign);

                    transaccio.setInfoSignatura(infoSign);

                } catch (Throwable e) {

                    String msg;
                    if (e instanceof I18NException) {
                        msg = I18NCommonUtils.getMessage((I18NException) e,
                                new Locale(transaccio.getLanguageUI()));
                    } else {
                        msg = e.getMessage();
                    }

                    transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
                    transaccio.setEstatMissatge(
                            "ApiFirmaSimple::Error durant el processament dels resultats de la signatura en servidor: "
                                    + msg);
                    transaccio.setEstatExcepcio(getStackTrace(e));
                    log.error(transaccio.getEstatMissatge(), e);
                    return null;
                }

            } // Final Case Firma OK
            break;

            default:

                error = "Error durant la realització de la firma. Estat desconegut " + status;

        } // Final Switch Firma

        if (error != null) {
            transaccio.setEstatCodi(ScanWebSimpleStatus.STATUS_FINAL_ERROR);
            transaccio.setEstatMissatge(error);
        }

        return fitxerSignat;
    }

    protected String getStackTrace(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

    protected String templateEngine(String valueEL, TransaccioJPA transaccio) {

        if (valueEL == null || valueEL.trim().length() == 0) {
            return "";
        }

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("transaction", transaccio);

        try {
            return TemplateEngine.processExpressionLanguage(valueEL, parameters);
        } catch (IOException e) {
            log.error("error substituin valors de la firma en servidor: " + e.getMessage(), e);
            return null;
        }

    }

}
