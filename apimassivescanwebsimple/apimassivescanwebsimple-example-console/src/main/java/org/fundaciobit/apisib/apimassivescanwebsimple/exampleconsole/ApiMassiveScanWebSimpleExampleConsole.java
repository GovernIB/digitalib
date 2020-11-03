package org.fundaciobit.apisib.apimassivescanwebsimple.exampleconsole;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import org.fundaciobit.apisib.apimassivescanwebsimple.v1.jersey.ApiMassiveScanWebSimpleJersey;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.ApiMassiveScanWebSimple;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfiles;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleProfileRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResultRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResult;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSignatureParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStartTransactionRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubTransactionsOfTransaction;

/**
 * 
 * @author anadal(u80067)
 *
 */
public class ApiMassiveScanWebSimpleExampleConsole {

  public static void main(String[] args) {

    ApiMassiveScanWebSimple api = null;
    String transactionID = null;
    final String languageUI = "ca";
    try {

      api = getApiMassiveScanWebSimple();

      // Descarregar Separador
      {
        MassiveScanWebSimpleFile separador = api.getSeparatorPage(languageUI);

        byte[] data = separador.getData();

        FileOutputStream fos = new FileOutputStream("Separador.pdf");

        fos.write(data);

        fos.close();
      }

      // Recuperar Perfils disponibles

      MassiveScanWebSimpleAvailableProfiles profiles = api.getAvailableProfiles(languageUI);

      List<MassiveScanWebSimpleAvailableProfile> profilesList = profiles
          .getAvailableProfiles();

      if (profilesList == null || profilesList.size() == 0) {
        System.err.println("NO HI HA PERFILS PER AQUEST USUARI APLICACIÓ");
        return;
      }

      MassiveScanWebSimpleAvailableProfile scanWebProfileSelected = null;

      do {
        System.out.println(" ---- Perfils Disponibles ----");
        System.out.println("0.-   + Sortir.");
        int i = 1;
        Map<Integer, MassiveScanWebSimpleAvailableProfile> profilesByIndex = new HashMap<Integer, MassiveScanWebSimpleAvailableProfile>();
        for (MassiveScanWebSimpleAvailableProfile profile : profilesList) {
          System.out.println(i + ".-   + " + profile.getName() + "(CODI: " + profile.getCode()
              + "): " + profile.getDescription());
          profilesByIndex.put(i, profile);
          i++;
        }

        System.out.print(" Seleccioni un perfil: ");
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        if (n == 0) {
          return;
        }

        scanWebProfileSelected = profilesByIndex.get(n);

      } while (scanWebProfileSelected == null);

      System.out.println(" -----------------------------");

      // Només per provar el mètode getProfile(). Es pot comentar aquesta linia
      scanWebProfileSelected = api.getProfile(new MassiveScanWebSimpleProfileRequest(
          scanWebProfileSelected.getCode(), languageUI));

      // Recuperar un ID de transacció
      {

        final String profileCode = scanWebProfileSelected.getCode();
        final int view = MassiveScanWebSimpleGetTransactionIdRequest.VIEW_IFRAME;
        // ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN;

        final String transactionName = "Transaccio Exemple " + System.currentTimeMillis();

        String funcionariUsername = "u00666";

        MassiveScanWebSimpleGetTransactionIdRequest transacctionIdRequest;

        switch (scanWebProfileSelected.getProfileType()) {

          case MassiveScanWebSimpleAvailableProfile.PROFILE_TYPE_ONLY_SCAN:

            transacctionIdRequest = new MassiveScanWebSimpleGetTransactionIdRequest(
                transactionName, profileCode, view, languageUI, funcionariUsername);

          break;

          case MassiveScanWebSimpleAvailableProfile.PROFILE_TYPE_SCAN_AND_SIGNATURE: {
            MassiveScanWebSimpleSignatureParameters signatureParameters = getSignatureParameters();

            transacctionIdRequest = new MassiveScanWebSimpleGetTransactionIdRequest(
                transactionName, profileCode, view, languageUI, funcionariUsername,
                signatureParameters);

          }

          break;

          case MassiveScanWebSimpleAvailableProfile.PROFILE_TYPE_SCAN_AND_SIGNATURE_AND_CUSTODY: {

            MassiveScanWebSimpleSignatureParameters signatureParameters = getSignatureParameters();

            MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
            arxiuRequiredParameters = getArxiuRequiredParameters();

            // See getArxiuOptionalParameters() sample
            MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;

            transacctionIdRequest = new MassiveScanWebSimpleGetTransactionIdRequest(
                transactionName, profileCode, view, languageUI, funcionariUsername,
                signatureParameters, arxiuRequiredParameters, arxiuOptionalParameters);

          }
          break;

          default:
            throw new Exception(
                "Tipus de perfil desconegut " + scanWebProfileSelected.getProfileType());

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
      startTransactionInfo = new MassiveScanWebSimpleStartTransactionRequest(transactionID,
          returnUrl);

      String redirectUrl = api.startTransaction(startTransactionInfo);

      System.out.println("RedirectUrl = " + redirectUrl);

      if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().browse(new URI(redirectUrl));
      } else {
        System.out.println("Per favor obri un Navegador i copia-li la URL anterior ...");
      }

      readFromSocket(port);

      MassiveScanWebSimpleSubTransactionsOfTransaction subs = api
          .getSubTransactionsOfTransaction(transactionID);

      List<String> subtransacions = subs.getSubtransacions();

      int count = 1;

      for (String subTransactionID : subtransacions) {

        // Segons el tipus de perfil ja ho omplirà automàticament
        Boolean returnScannedFile = null;
        Boolean returnSignedFile = null;
        System.out.println();
        System.out.println();

        System.out.println("-------------=====  SUBTRANSACCIO(" + count + ") ["
            + subTransactionID + "] =====--------------");
        System.out.println();
        count++;
        System.out.println(" Descarregant Informació dels Resultat:");
        System.out.println("     * TransaccioID = " + transactionID);
        System.out.println("     * SubransaccioID = " + subTransactionID);
        System.out.println("     * returnScannedFile = " + returnScannedFile);
        System.out.println("     * returnSignedFile = " + returnSignedFile);

        MassiveScanWebSimpleSubtransactionResultRequest resultRequest;
        resultRequest = new MassiveScanWebSimpleSubtransactionResultRequest(subTransactionID,
            returnScannedFile, returnSignedFile);

        MassiveScanWebSimpleSubtransactionResult result = api
            .getSubTransactionResult(resultRequest);

        MassiveScanWebSimpleStatus transactionStatus = result.getStatus();

        int status = transactionStatus.getStatus();

        System.out.println(MassiveScanWebSimpleSubtransactionResult.toString(result));
        System.out.println();
        System.out.println();

        switch (status) {

          case MassiveScanWebSimpleStatus.STATUS_REQUESTED_ID: // = 0;
            System.out.flush();
            System.err.println("S'ha rebut un estat inconsistent del procés"
                + " (requestedid). Pot ser el PLugin no està ben desenvolupat."
                + " Consulti amb el seu administrador.");
            System.err.flush();

          case MassiveScanWebSimpleStatus.STATUS_IN_PROGRESS: // = 1;
            System.out.flush();
            System.err.println("S'ha rebut un estat inconsistent del procés"
                + " (En Progrés). Pot ser el PLugin no està ben desenvolupat."
                + " Consulti amb el seu administrador.");
            System.err.flush();

          case MassiveScanWebSimpleStatus.STATUS_FINAL_ERROR: // = -1;
          {
            System.out.flush();
            System.err.println("Error durant la realització de l'escaneig/còpia autèntica: "
                + transactionStatus.getErrorMessage());
            String desc = transactionStatus.getErrorStackTrace();
            if (desc != null) {
              System.err.println(desc);
            }
            System.err.flush();

            continue;
          }

          case MassiveScanWebSimpleStatus.STATUS_CANCELLED: // = -2;
          {
            System.out.flush();
            System.err.println("Durant el procés, l'usuari ha cancelat la transacció.");
            System.err.flush();
            continue;
          }

          case MassiveScanWebSimpleStatus.STATUS_FINAL_OK: // = 2;
          {

            if (result.getScannedFile() != null) {
              File scanFile = new File(
                  (count - 1) + "_scanfile." + result.getScannedFileInfo().getFormatFile());

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

              System.out
                  .println("Firma del Fitxer Escanejat guardat a " + signed.getAbsolutePath());
            }

            MassiveScanWebSimpleFile detachedSignedFile = result.getDetachedSignatureFile();

            if (detachedSignedFile != null) {
              File detached = new File(
                  (count - 1) + "_detached_sign." + detachedSignedFile.getNom());

              FileOutputStream fos = new FileOutputStream(detached);
              fos.write(detachedSignedFile.getData());
              fos.flush();
              fos.close();

              System.out
                  .println("Document Detached de la Firma (Document Escanejat) guardat a "
                      + detached.getAbsolutePath());
            }

          } // Final Case Firma OK
        } // Final Switch Firma
      } // final for

    } catch (Exception e) {
      // TODO: handle exception
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

  public static MassiveScanWebSimpleArxiuRequiredParameters getArxiuRequiredParameters() {
    final List<String> personesInteressades = new ArrayList<String>(
        Arrays.asList("12345678X", "87654321Z"));

    /**
     * ScanWebSimpleArxiuRequiredParameters.CIUTADA
     * ScanWebSimpleArxiuRequiredParameters.ORIGEN_ADMINISTRACIO
     */
    final int origen = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTORIGEN_ADMINISTRACIO;

    /**
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_ORIGINAL
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_CF
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_DP
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_PR
     */
    final String documentEstatElaboracio = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTELABORATIONSTATE_ORIGINAL;

    /**
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_RESOLUCIO
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ACORD
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_CONTRACTE
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_CONVENI
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_DECLARACIO
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_COMUNICACIO
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_NOTIFICACIO
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_PUBLICACIO
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_JUSTIFICANT_RECEPCIO
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ACTA
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_CERTIFICAT
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_DILIGENCIA
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_INFORME
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_SOLICITUD
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_DENUNCIA
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ALEGACIO
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_RECURS
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_COMUNICACIO_CIUTADA
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_FACTURA
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ALTRES_INCAUTATS
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_ALTRES
     */
    final String documentTipus = MassiveScanWebSimpleArxiuRequiredParameters.DOCUMENTTYPE_RESOLUCIO;

    String ciutadaNif = "11223344C";

    String ciutadaNom = "Pep Gonella";

    List<String> organsAfectats = new ArrayList<String>(Arrays.asList("A04013511"));

    MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
    arxiuRequiredParameters = new MassiveScanWebSimpleArxiuRequiredParameters(ciutadaNif,
        ciutadaNom, documentEstatElaboracio, documentTipus, origen, personesInteressades,
        organsAfectats);
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
    // Si volem que ho fiqui dins d'un expedient o Custòdia ja existent llavors donar-li valor.
    String custodyOrExpedientID = null; // b5d48d50-9e63-4c56-a67a-fe896bdfb130

    MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;
    arxiuOptionalParameters = new MassiveScanWebSimpleArxiuOptionalParameters(procedimentNom,
        procedimentCodi, serieDocumental, custodyOrExpedientID);

    return arxiuOptionalParameters;
  }

  /**
   * 
   * @return
   */
  public static MassiveScanWebSimpleSignatureParameters getSignatureParameters() {
    final String languageDoc = "ca";
    final String funcionariNom = "Funcionari DeProfessio";
    final String funcionariNif = "12345678X";

    MassiveScanWebSimpleSignatureParameters signatureParameters;
    signatureParameters = new MassiveScanWebSimpleSignatureParameters(languageDoc,
        funcionariNom, funcionariNif);
    return signatureParameters;
  }

  public static void readFromSocket(int port) throws Exception {

    ServerSocket serverSocket = new ServerSocket(port);
    System.err.println("Servidor escoltant al PORT: " + port);
    {
      Socket clientSocket = serverSocket.accept();
      System.err
          .println("Nou Client Connectat desde " + clientSocket.getRemoteSocketAddress());

      BufferedReader in = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream()));
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
      out.println(
          "<html><body>OK (Revisi consola per saber l'estat final del proc&eacute;s)</body></html>");

      System.err.println("Connexio amb el client finalitzada.");
      out.flush();
      out.close();
      in.close();
      clientSocket.close();
    }

    serverSocket.close();

  }

  protected static ApiMassiveScanWebSimple getApiMassiveScanWebSimple() throws Exception {

    Properties prop = new Properties();

    prop.load(new FileInputStream(new File("./apimassivescanwebsimple.properties")));

    return new ApiMassiveScanWebSimpleJersey(prop.getProperty("endpoint"),
        prop.getProperty("username"), prop.getProperty("password"));
  }

}
