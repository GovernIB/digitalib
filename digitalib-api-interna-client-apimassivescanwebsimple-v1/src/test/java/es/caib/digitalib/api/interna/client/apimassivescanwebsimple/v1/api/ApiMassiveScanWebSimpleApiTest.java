/*
 * API REST INTERNA de DigitalIB
 * Conjunt de Serveis REST de DigitalIB per ser accedits des de l'exterior
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: otae@fundaciobit.org
 *
 */
package es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.api;

import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleArxiuOptionalParameters;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleArxiuRequiredParameters;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleAvailableProfile;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleAvailableProfiles;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleConstants;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleFile;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleProfileRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleSignatureParameters;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleStartTransactionRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleStatus;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleSubTransactionsOfTransaction;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleSubtransactionResult;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleSubtransactionResultRequest;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.services.ApiClient;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/**
 * API tests for ApiMassiveScanWebSimpleApi
 * @author anadal
 */
public class ApiMassiveScanWebSimpleApiTest {

    public static final MassiveScanWebSimpleConstants CONSTANTS = new MassiveScanWebSimpleConstants();

    public static void main(String[] args) {
        try {
            ApiMassiveScanWebSimpleApiTest test = new ApiMassiveScanWebSimpleApiTest();

            //test.getAvailableProfilesTest();

            //test.getSeparatorPageTest();

            test.fullTest();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ApiMassiveScanWebSimpleApi getApi() throws Exception {

        Properties props = new Properties();

        props.load(new FileInputStream("test.properties"));
        String host = props.getProperty("host");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        ApiClient client = new ApiClient();
        client.setBasePath(host);
        client.setUsername(username);
        client.setPassword(password);

        ApiMassiveScanWebSimpleApi api = new ApiMassiveScanWebSimpleApi(client);

        return api;

    }

    /**
     * Retorna els Perfils Disponibles per aquest usuari
     *
     * @throws ApiException
     *          if the Api call fails
     */

    public void getAvailableProfilesTest() throws Exception {

        ApiMassiveScanWebSimpleApi api = getApi();

        String language = "ca";
        MassiveScanWebSimpleAvailableProfiles response = api.getAvailableProfiles(language);

        System.out.println(response);
    }

    public void getSeparatorPageTest() throws Exception {

        ApiMassiveScanWebSimpleApi api = getApi();

        String language = "ca";
        MassiveScanWebSimpleFile response = api.getSeparatorPage(language);

        System.out.println(response);

        FileUtils.writeByteArrayToFile(new File("SEPARADOR.pdf"), response.getData());
    }

    public void fullTest() {

        String transactionID = null;
        final String languageUI = "ca";
        ApiMassiveScanWebSimpleApi api = null;
        try {
            api = getApi();

            // Recuperar Perfils disponibles
            MassiveScanWebSimpleAvailableProfile scanWebProfileSelected = getAvailableProfiles(api, languageUI);

            if (scanWebProfileSelected == null) {
                return;
            }

            System.out.println(" -----------------------------");

            // Només per provar el mètode getProfile(). Es pot comentar aquesta linia
            MassiveScanWebSimpleProfileRequest msspr = new MassiveScanWebSimpleProfileRequest();
            msspr.setLocale(languageUI);
            msspr.setProfileCode(scanWebProfileSelected.getCode());

            scanWebProfileSelected = api.getProfile(msspr);

            // Recuperar un ID de transacció
            {

                final String profileCode = scanWebProfileSelected.getCode();
                final int view = CONSTANTS.getMassiveScanWebSimpleGetTransactionIdRequestVIEWIFRAME();
                // CONSTANTS.getMassiveScanWebSimpleGetTransactionIdRequestVIEWFULLSCREEN()

                final String transactionName = "Transaccio Exemple " + System.currentTimeMillis();

                String funcionariUsername = "u00666";

                MassiveScanWebSimpleGetTransactionIdRequest transacctionIdRequest;

                if (scanWebProfileSelected.getProfileType()
                        .equals(CONSTANTS.getMassiveScanWebSimpleAvailableProfilePROFILETYPEONLYSCAN())) {

                    transacctionIdRequest = new MassiveScanWebSimpleGetTransactionIdRequest();
                    transacctionIdRequest.setTransactionName(transactionName);
                    transacctionIdRequest.setScanWebProfile(profileCode);
                    transacctionIdRequest.setView(view);
                    transacctionIdRequest.setLanguageUI(languageUI);
                    transacctionIdRequest.setFuncionariUsername(funcionariUsername);

                } else if (scanWebProfileSelected.getProfileType()
                        .equals(CONSTANTS.getMassiveScanWebSimpleAvailableProfilePROFILETYPESCANANDSIGNATURE())) {

                    MassiveScanWebSimpleSignatureParameters signatureParameters = getSignatureParameters();

                    transacctionIdRequest = new MassiveScanWebSimpleGetTransactionIdRequest();
                    transacctionIdRequest.setTransactionName(transactionName);
                    transacctionIdRequest.setScanWebProfile(profileCode);
                    transacctionIdRequest.setView(view);
                    transacctionIdRequest.setLanguageUI(languageUI);
                    transacctionIdRequest.setFuncionariUsername(funcionariUsername);
                    transacctionIdRequest.setSignatureParameters(signatureParameters);

                } else if (scanWebProfileSelected.getProfileType().equals(
                        CONSTANTS.getMassiveScanWebSimpleAvailableProfilePROFILETYPESCANANDSIGNATUREANDCUSTODY())) {

                    MassiveScanWebSimpleSignatureParameters signatureParameters = getSignatureParameters();

                    MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
                    arxiuRequiredParameters = getArxiuRequiredParameters();

                    // See getArxiuOptionalParameters() sample
                    MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;

                    transacctionIdRequest = new MassiveScanWebSimpleGetTransactionIdRequest();
                    transacctionIdRequest.setTransactionName(transactionName);
                    transacctionIdRequest.setScanWebProfile(profileCode);
                    transacctionIdRequest.setView(view);
                    transacctionIdRequest.setLanguageUI(languageUI);
                    transacctionIdRequest.setFuncionariUsername(funcionariUsername);
                    transacctionIdRequest.setSignatureParameters(signatureParameters);
                    transacctionIdRequest.setArxiuRequiredParameters(arxiuRequiredParameters);
                    transacctionIdRequest.setArxiuOptionalParameters(arxiuOptionalParameters);

                } else {
                    throw new Exception("Tipus de perfil desconegut " + scanWebProfileSelected.getProfileType());

                }

                // Enviam la part comu de la transacció
                transactionID = api.getTransactionID(transacctionIdRequest);
                System.out.println("languageUI = |" + languageUI + "|");
                System.out.println("TransactionID = |" + transactionID + "|");
            }

            // Servidor TEMPORAL
            String host = Inet4Address.getLocalHost().getHostAddress();
            // final int port = 1989;

            Random r = new Random();
            int low = 1900;
            int high = 2000;
            final int port = r.nextInt(high - low) + low;

            final String returnUrl = "http://" + host + ":" + port + "/returnurl/" + transactionID;

            MassiveScanWebSimpleStartTransactionRequest startTransactionInfo;
            startTransactionInfo = new MassiveScanWebSimpleStartTransactionRequest();

            startTransactionInfo.setReturnUrl(returnUrl);
            startTransactionInfo.setTransactionID(transactionID);

            String redirectUrl = api.startTransaction(startTransactionInfo);

            System.out.println("RedirectUrl = " + redirectUrl);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(redirectUrl));
            } else {
                System.out.println("Per favor obri un Navegador i copia-li la URL anterior ...");
            }

            readFromSocket(port);

            System.out.println(" Cridant a getSubTransactionsOfTransaction(" + transactionID + ") ...");
            MassiveScanWebSimpleSubTransactionsOfTransaction subs = api.getSubTransactionsOfTransaction(transactionID);

            List<String> subtransacions = subs.getSubtransacions();

            int count = 1;

            for (String subTransactionID : subtransacions) {

                // Segons el tipus de perfil ja ho omplirà automàticament
                Boolean returnScannedFile = null;
                Boolean returnSignedFile = null;
                System.out.println();
                System.out.println();

                System.out.println("-------------=====  SUBTRANSACCIO(" + count + ") [" + subTransactionID
                        + "] =====--------------");
                System.out.println();
                count++;
                System.out.println(" Descarregant Informació dels Resultat:");
                System.out.println("     * TransaccioID = " + transactionID);
                System.out.println("     * SubransaccioID = " + subTransactionID);
                System.out.println("     * returnScannedFile = " + returnScannedFile);
                System.out.println("     * returnSignedFile = " + returnSignedFile);

                MassiveScanWebSimpleSubtransactionResultRequest resultRequest;
                resultRequest = new MassiveScanWebSimpleSubtransactionResultRequest();
                resultRequest.setSubtransactionID(subTransactionID);
                resultRequest.setReturnScannedFile(returnScannedFile);
                resultRequest.setReturnSignedFile(returnSignedFile);

                MassiveScanWebSimpleSubtransactionResult result = api.getSubTransactionResult(resultRequest);

                MassiveScanWebSimpleStatus transactionStatus = result.getStatus();

                int status = transactionStatus.getStatus();

                System.out.println(result.toString());
                System.out.println();
                System.out.println();

                // switch (status) {

                if (CONSTANTS.getMassiveScanWebSimpleStatusSTATUSREQUESTEDID().equals(status)) { // = 0;
                    System.out.flush();
                    System.err.println("S'ha rebut un estat inconsistent del procés"
                            + " (requestedid). Pot ser el PLugin no està ben desenvolupat."
                            + " Consulti amb el seu administrador.");
                    System.err.flush();

                } else if (CONSTANTS.getMassiveScanWebSimpleStatusSTATUSINPROGRESS().equals(status)) { // = 1;
                    System.out.flush();
                    System.err.println("S'ha rebut un estat inconsistent del procés"
                            + " (En Progrés). Pot ser el PLugin no està ben desenvolupat."
                            + " Consulti amb el seu administrador.");
                    System.err.flush();

                } else if (CONSTANTS.getMassiveScanWebSimpleStatusSTATUSFINALERROR().equals(status)) { // = -1;

                    System.out.flush();
                    System.err.println("Error durant la realització de l'escaneig/còpia autèntica: "
                            + transactionStatus.getErrorMessage());
                    String desc = transactionStatus.getErrorStackTrace();
                    if (desc != null) {
                        System.err.println(desc);
                    }
                    System.err.flush();

                    continue;
                } else if (CONSTANTS.getMassiveScanWebSimpleStatusSTATUSCANCELLED().equals(status)) { // = -2;

                    System.out.flush();
                    System.err.println("Durant el procés, l'usuari ha cancelat la transacció.");
                    System.err.flush();
                    continue;
                } else

                if (CONSTANTS.getMassiveScanWebSimpleStatusSTATUSFINALOK().equals(status)) { // = 2;
                    {

                        if (result.getScannedFile() != null) {

                            String format = result.getScannedFileInfo().getFormatFile();
                            if (format == null) {
                                format = "unknown";
                            } else {
                                format = format.replace("/", ".");
                            }

                            File scanFile = new File((count - 1) + "_scanfile." + format);

                            FileOutputStream fos = new FileOutputStream(scanFile);
                            fos.write(result.getScannedFile().getData());
                            fos.flush();
                            fos.close();

                            System.out.println();
                            System.out.println();
                            System.out.println("Fitxer Escanejat guardat a " + scanFile.getAbsolutePath());
                        }

                        MassiveScanWebSimpleFile signedFile = result.getSignedFile();

                        if (signedFile != null) {
                            File signed = new File((count - 1) + "_signed." + signedFile.getNom());

                            FileOutputStream fos = new FileOutputStream(signed);
                            fos.write(signedFile.getData());
                            fos.flush();
                            fos.close();

                            System.out.println("Firma del Fitxer Escanejat guardat a " + signed.getAbsolutePath());
                        }

                        MassiveScanWebSimpleFile detachedSignedFile = result.getDetachedSignatureFile();

                        if (detachedSignedFile != null) {
                            File detached = new File((count - 1) + "_detached_sign." + detachedSignedFile.getNom());

                            FileOutputStream fos = new FileOutputStream(detached);
                            fos.write(detachedSignedFile.getData());
                            fos.flush();
                            fos.close();

                            System.out.println("Document Detached de la Firma (Document Escanejat) guardat a "
                                    + detached.getAbsolutePath());
                        }

                    } // Final Case Firma OK
                }
            } // final for

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (api != null && transactionID != null) {
                try {
                    api.closeTransaction(transactionID);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    protected MassiveScanWebSimpleAvailableProfile getAvailableProfiles(ApiMassiveScanWebSimpleApi api,
            final String languageUI) throws Exception {
        MassiveScanWebSimpleAvailableProfiles profiles = api.getAvailableProfiles(languageUI);

        List<MassiveScanWebSimpleAvailableProfile> profilesList = profiles.getAvailableProfiles();

        if (profilesList == null || profilesList.size() == 0) {
            System.err.println("NO HI HA PERFILS PER AQUEST USUARI APLICACIÓ");
            return null;
        }

        MassiveScanWebSimpleAvailableProfile scanWebProfileSelected = null;

        do {
            System.out.println(" ---- Perfils Disponibles ----");
            System.out.println("0.-   + Sortir.");
            int i = 1;
            Map<Integer, MassiveScanWebSimpleAvailableProfile> profilesByIndex = new HashMap<Integer, MassiveScanWebSimpleAvailableProfile>();
            for (MassiveScanWebSimpleAvailableProfile profile : profilesList) {
                System.out.println(i + ".-   + " + profile.getName() + "(CODI: " + profile.getCode() + "): "
                        + profile.getDescription());
                profilesByIndex.put(i, profile);
                i++;
            }

            System.out.print(" Seleccioni un perfil: ");
            Scanner in = new Scanner(System.in);

            try {
                int n = in.nextInt();

                if (n == 0) {
                    return null;
                }

                scanWebProfileSelected = profilesByIndex.get(n);
            } finally {
                in.close();
            }

        } while (scanWebProfileSelected == null);
        return scanWebProfileSelected;
    }

    protected static void getSeparatorPageTest(ApiMassiveScanWebSimpleApi api, final String languageUI)
            throws Exception, FileNotFoundException, IOException {
        MassiveScanWebSimpleFile separador = api.getSeparatorPage(languageUI);
        byte[] data = separador.getData();
        FileOutputStream fos = new FileOutputStream("Separador.pdf");
        fos.write(data);
        fos.close();
    }

    public MassiveScanWebSimpleArxiuRequiredParameters getArxiuRequiredParameters() {
        final List<String> personesInteressades = new ArrayList<String>(Arrays.asList("12345678Z"));

        /**
         * CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTORIGENCIUTADA()
         * CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTORIGENADMINISTRACIO()
         */
        final int origen = CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTORIGENADMINISTRACIO();

        /**
         * @see CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTELABORATIONSTATEORIGINAL()
         * @see CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTELABORATIONSTATECOPIACF()
         * @see CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTELABORATIONSTATECOPIADP()
         * @see CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTELABORATIONSTATECOPIAPR()
         * @see CONSTANTS.getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTELABORATIONSTATEALTRES()
         */
        final String documentEstatElaboracio = CONSTANTS
                .getMassiveScanWebSimpleArxiuRequiredParametersDOCUMENTELABORATIONSTATEORIGINAL();

        String ciutadaNif = "11223344C";

        String ciutadaNom = "Pep Gonella";

        List<String> organsAfectats = new ArrayList<String>(Arrays.asList("A04013511"));

        MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
        arxiuRequiredParameters = new MassiveScanWebSimpleArxiuRequiredParameters();
        arxiuRequiredParameters.setCitizenAdministrationID(ciutadaNif);
        arxiuRequiredParameters.setCitizenFullName(ciutadaNom);
        arxiuRequiredParameters.setDocumentElaborationState(documentEstatElaboracio);
        arxiuRequiredParameters.setDocumentOrigen(origen);
        arxiuRequiredParameters.setInterestedPersons(personesInteressades);
        arxiuRequiredParameters.setAffectedOrganisms(organsAfectats);

        return arxiuRequiredParameters;
    }

    /**
     * 
     */
    public static MassiveScanWebSimpleArxiuOptionalParameters getArxiuOptionalParameters() {

        String procedimentNom = "Subvenciones empleo";

        String procedimentCodi = "organo1_PRO_123456789";

        String serieDocumental = null; // = "S0001"

        // Que ho generi automàticament
        // Si volem que ho fiqui dins d'un expedient o Custòdia ja existent llavors donar-li
        // valor.
        String custodyOrExpedientID = null; // b5d48d50-9e63-4c56-a67a-fe896bdfb130

        MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;
        arxiuOptionalParameters = new MassiveScanWebSimpleArxiuOptionalParameters();
        arxiuOptionalParameters.setProcedureCode(procedimentCodi);
        arxiuOptionalParameters.setProcedureName(procedimentNom);
        arxiuOptionalParameters.setDocumentarySerie(serieDocumental);
        arxiuOptionalParameters.setCustodyIDOrExpedientID(custodyOrExpedientID);

        return arxiuOptionalParameters;
    }

    /**
     * 
     * @return
     */
    public static MassiveScanWebSimpleSignatureParameters getSignatureParameters() {
        final String functionaryDir3Unit = "1254123412";
        final String functionaryFullName = "Funcionari DeProfessio";
        final String functionaryAdministrationID = "12345678X";

        MassiveScanWebSimpleSignatureParameters signatureParameters;
        signatureParameters = new MassiveScanWebSimpleSignatureParameters();

        signatureParameters.setFunctionaryFullName(functionaryFullName);
        signatureParameters.setFunctionaryAdministrationID(functionaryAdministrationID);
        signatureParameters.setFunctionayDIR3Unit(functionaryDir3Unit);

        return signatureParameters;
    }

    public static void readFromSocket(int port) throws Exception {

        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("Servidor escoltant al PORT: " + port);
        {
            Socket clientSocket = serverSocket.accept();
            System.err.println("Nou Client Connectat desde " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);

            String s;
            System.err.println(" =========================== ");
            while ((s = in.readLine()) != null) {
                System.err.println(s);
                break;
            }
            System.err.println(" =========================== ");

            out.println("HTTP/1.0 200 OK");
            out.println("Content-Type: text/html");
            out.println("\r\n");
            out.println("<html><body>OK (Revisi consola per saber l'estat final del proc&eacute;s)</body></html>");

            System.err.println("Connexio amb el client finalitzada.");
            out.flush();
            out.close();
            in.close();
            clientSocket.close();
        }

        serverSocket.close();

    }

}
