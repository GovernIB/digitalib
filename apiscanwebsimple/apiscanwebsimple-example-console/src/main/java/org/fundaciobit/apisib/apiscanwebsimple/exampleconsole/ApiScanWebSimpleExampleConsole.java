package org.fundaciobit.apisib.apiscanwebsimple.exampleconsole;

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

import org.fundaciobit.apisib.apiscanwebsimple.v1.ApiScanWebSimple;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfile;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfiles;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleFile;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleScanResult;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleSignatureParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStartTransactionRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.apisib.apiscanwebsimple.v1.jersey.ApiScanWebSimpleJersey;

/**
 * 
 * @author anadal(u80067)
 *
 */
public class ApiScanWebSimpleExampleConsole {

  public static void main(String[] args) {

    ApiScanWebSimple api = null;
    String transactionID = null;
    final String languageUI = "ca";
    try {

      api = getApiScanWebSimple();

      // Recuperar Perfils disponibles

      ScanWebSimpleAvailableProfiles profiles = api.getAvailableProfiles(languageUI);

      List<ScanWebSimpleAvailableProfile> profilesList = profiles.getAvailableProfiles();

      if (profilesList == null || profilesList.size() == 0) {
        System.err.println("NO HI HA PERFILS PER AQUEST USUARI APLICACIÓ");
        return;
      }

      ScanWebSimpleAvailableProfile scanWebProfileSelected = null;

      do {
        System.out.println(" ---- Perfils Disponibles ----");
        int i = 1;
        Map<Integer, ScanWebSimpleAvailableProfile> profilesByIndex = new HashMap<Integer, ScanWebSimpleAvailableProfile>();
        for (ScanWebSimpleAvailableProfile profile : profilesList) {
          System.out.println(i + ".-   + " + profile.getName() + "(CODI: " + profile.getCode()
              + "): " + profile.getDescription());
          profilesByIndex.put(i, profile);
          i++;
        }
        System.out.print(" Seleccioni un perfil: ");
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        scanWebProfileSelected = profilesByIndex.get(n);

      } while (scanWebProfileSelected == null);

      System.out.println(" -----------------------------");

      // Recuperar un ID de transacció

      {

        final String profileCode = scanWebProfileSelected.getCode();
        final int view = ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN;

        String funcionariUsername = "u00666";

        ScanWebSimpleGetTransactionIdRequest transacctionIdRequest;

        switch (scanWebProfileSelected.getProfileType()) {

          case ScanWebSimpleAvailableProfile.PROFILE_TYPE_ONLY_SCAN:

            transacctionIdRequest = new ScanWebSimpleGetTransactionIdRequest(profileCode,
                view, languageUI, funcionariUsername);

          break;

          case ScanWebSimpleAvailableProfile.PROFILE_TYPE_SCAN_AND_SIGNATURE: {
            ScanWebSimpleSignatureParameters signatureParameters = getSignatureParameters();

            transacctionIdRequest = new ScanWebSimpleGetTransactionIdRequest(profileCode,
                view, languageUI, funcionariUsername, signatureParameters);
          }

          break;

          case ScanWebSimpleAvailableProfile.PROFILE_TYPE_SCAN_AND_SIGNATURE_AND_CUSTODY: {

            ScanWebSimpleSignatureParameters signatureParameters = getSignatureParameters();

            ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
            arxiuRequiredParameters = getArxiuRequiredParameters();

            // See getArxiuOptionalParameters() sample
            ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;

            transacctionIdRequest = new ScanWebSimpleGetTransactionIdRequest(profileCode,
                view, languageUI, funcionariUsername, signatureParameters,
                arxiuRequiredParameters, arxiuOptionalParameters);
          }
          break;

          default:
            throw new Exception("Tipus de perfil desconegut "
                + scanWebProfileSelected.getProfileType());

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

      ScanWebSimpleStartTransactionRequest startTransactionInfo;
      startTransactionInfo = new ScanWebSimpleStartTransactionRequest(transactionID, returnUrl);

      String redirectUrl = api.startTransaction(startTransactionInfo);

      System.out.println("RedirectUrl = " + redirectUrl);

      if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().browse(new URI(redirectUrl));
      } else {
        System.out.println("Per favor obri un Navegador i copia-li la URL anterior ...");
      }

      readFromSocket(port);

      ScanWebSimpleScanResult result = api.getScanWebResult(transactionID);

      ScanWebSimpleStatus transactionStatus = result.getStatus();

      int status = transactionStatus.getStatus();

      System.out.println(ScanWebSimpleScanResult.toString(result));

      switch (status) {

        case ScanWebSimpleStatus.STATUS_REQUESTED_ID: // = 0;
          throw new Exception("S'ha rebut un estat inconsistent del procés"
              + " (requestedid). Pot ser el PLugin no està ben desenvolupat."
              + " Consulti amb el seu administrador.");

        case ScanWebSimpleStatus.STATUS_IN_PROGRESS: // = 1;
          throw new Exception("S'ha rebut un estat inconsistent del procés"
              + " (En Progrés). Pot ser el PLugin no està ben desenvolupat."
              + " Consulti amb el seu administrador.");

        case ScanWebSimpleStatus.STATUS_FINAL_ERROR: // = -1;
        {
          System.err.println("Error durant la realització de l'escaneig/còpia autèntica: "
              + transactionStatus.getErrorMessage());
          String desc = transactionStatus.getErrorStackTrace();
          if (desc != null) {
            System.err.println(desc);
          }
          return;
        }

        case ScanWebSimpleStatus.STATUS_CANCELLED: // = -2;
        {
          System.err.println("Durant el procés, l'usuari ha cancelat la transacció.");
          return;
        }

        case ScanWebSimpleStatus.STATUS_FINAL_OK: // = 2;
        {

          {
            File scanFile = new File("scanfile." + result.getScannedFileInfo().getFormatFile());

            FileOutputStream fos = new FileOutputStream(scanFile);
            fos.write(result.getScannedFile().getData());
            fos.flush();
            fos.close();

            System.out.println();
            System.out.println();
            System.out.println("Fitxer Escanejat guardat a " + scanFile.getAbsolutePath());
          }
          {
            ScanWebSimpleFile detachedSignInfo = result.getDetachedSignatureFile();

            if (detachedSignInfo != null) {
              File detached = new File("detached_sign_scanfile.sig");

              FileOutputStream fos = new FileOutputStream(detached);
              fos.write(detachedSignInfo.getData());
              fos.flush();
              fos.close();

              System.out.println("Firma Detached del Fitxer Scanejat guardat a "
                  + detached.getAbsolutePath());
            }
          }

        } // Final Case Firma OK
      } // Final Switch Firma

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

  public static ScanWebSimpleArxiuRequiredParameters getArxiuRequiredParameters() {
    final List<String> interessats = new ArrayList<String>(Arrays.asList("12345678X",
        "87654321Z"));

    /**
     * ScanWebSimpleArxiuRequiredParameters.CIUTADA
     * ScanWebSimpleArxiuRequiredParameters.ORIGEN_ADMINISTRACIO
     */
    final int origen = ScanWebSimpleArxiuRequiredParameters.ORIGEN_ADMINISTRACIO;

    /**
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_ORIGINAL
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_CF
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_DP
     * @see ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_COPIA_PR
     */
    final String documentEstatElaboracio = ScanWebSimpleArxiuRequiredParameters.DOCUMENTESTATELABORACIO_ORIGINAL;

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
    final String documentTipus = ScanWebSimpleArxiuRequiredParameters.DOCUMENTTIPUS_RESOLUCIO;

    String ciutadaNif = "11223344C";

    String ciutadaNom = "Pep Gonella";
    
    List<String> organs = new ArrayList<String>(Arrays.asList("A04013511"));

    ScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
    arxiuRequiredParameters = new ScanWebSimpleArxiuRequiredParameters(ciutadaNif, ciutadaNom,
        interessats, origen, documentEstatElaboracio, documentTipus, organs);
    return arxiuRequiredParameters;
  }

  /**
   * 
   */
  public static ScanWebSimpleArxiuOptionalParameters getArxiuOptionalParameters() {

    String procedimentNom = "Subvenciones empleo";

    String procedimentCodi = "organo1_PRO_123456789";

    String serieDocumental = null; // = "S0001"

    // Que ho generi automàticament
    // Si volem que ho fiqui dins d'un expedient o Custòdia ja existent llavors donar-li valor.
    String custodyOrExpedientID = null; // b5d48d50-9e63-4c56-a67a-fe896bdfb130

    ScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;
    arxiuOptionalParameters = new ScanWebSimpleArxiuOptionalParameters(procedimentNom,
        procedimentCodi, serieDocumental, custodyOrExpedientID);

    return arxiuOptionalParameters;
  }

  /**
   * 
   * @return
   */
  public static ScanWebSimpleSignatureParameters getSignatureParameters() {
    final String languageDoc = "ca";
    final String funcionariNom = "Funcionari DeProfessio";
    final String funcionariNif = "12345678X";

    ScanWebSimpleSignatureParameters signatureParameters;
    signatureParameters = new ScanWebSimpleSignatureParameters(languageDoc, funcionariNom,
        funcionariNif);
    return signatureParameters;
  }

  public static void readFromSocket(int port) throws Exception {

    ServerSocket serverSocket = new ServerSocket(port);
    System.err.println("Servidor escoltant al PORT: " + port);
    {
      Socket clientSocket = serverSocket.accept();
      System.err
          .println("Nou Client Connectat desde " + clientSocket.getRemoteSocketAddress());

      BufferedReader in = new BufferedReader(new InputStreamReader(
          clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
          clientSocket.getOutputStream())), true);

      String s;
      System.err.println(" =========================== ");
      while ((s = in.readLine()) != null) {
        System.out.println(s);
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

  protected static ApiScanWebSimple getApiScanWebSimple() throws Exception {

    Properties prop = new Properties();

    prop.load(new FileInputStream(new File("./apiscanwebsimple.properties")));

    // En entorns CAIB aquesta variable ha de valer false
    final boolean ignoreServerCertificates = true;
    
    return new ApiScanWebSimpleJersey(prop.getProperty("endpoint"), prop.getProperty("username"),
        prop.getProperty("password"), ignoreServerCertificates);

  }

}
