package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebimple.v1.test;

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
import java.util.List;
import java.util.Properties;

import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.ApiScanWebSimple;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfile;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleAvailableProfiles;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleFile;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleScanResult;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStartTransactionRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;

/**
 * 
 * @author anadal
 *
 */
public class ApiScanWebSimpleTester {

  public static void main(String[] args) {
    


    final String languageUI = "ca";
    ApiScanWebSimple api = null;
    String transactionID = null;
    try {
      

      api = getApiScanWebSimple();
      
      
      ScanWebSimpleAvailableProfiles profiles = api.getAvailableProfiles(languageUI);
      
      List<ScanWebSimpleAvailableProfile> profilesList = profiles.getAvailableProfiles();
      
      if (profilesList == null || profilesList.size() == 0) {
        System.out.println("NO HI HA PERFILS PER AQUEST USUARI APLICACIÓ");
        return;
      }
          
      System.out.println(" ---- Perfils Disponibles ----");
      String scanWebProfile=null;
      for (ScanWebSimpleAvailableProfile profile : profilesList) {
        System.out.println("   + " + profile.getName() + "(CODI: " + profile.getCode() + "): " + profile.getDescription());
        scanWebProfile = profile.getCode();
      }
      System.out.println(" -----------------------------");

      // Recuperar un ID de transacció
      
      {
        
        String languageDoc = "ca";
        String usernameRequest = "anadal";
        
        String ciutadaNif = "12345678C";
        String ciutadaNom = "Antoni Nadal";
        
        String funcionariUsername = "u00666";
        String funcionariNom = "Funcionari DeProfessio";
        String funcionariNif = "12345678X";
        String expedientID = null;
        
        final int view = ScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN;
        

        ScanWebSimpleGetTransactionIdRequest commonInfo;
        commonInfo = new ScanWebSimpleGetTransactionIdRequest(scanWebProfile, view,
            languageUI, languageDoc, usernameRequest, ciutadaNif, ciutadaNom,
            funcionariUsername, funcionariNom, funcionariNif, expedientID);

        // Enviam la part comu de la transacció
        transactionID = api.getTransactionID(commonInfo);
        System.out.println("languageUI = |" + languageUI + "|");
        System.out.println("TransactionID = |" + transactionID + "|");
     }
      
      
      
     // Servidor TEMPORAL
      String host = Inet4Address.getLocalHost().getHostAddress();
      final int port = 1989;
      final String returnUrl = "http://" + host + ":" + port + "/returnurl/" + transactionID;

      

      ScanWebSimpleStartTransactionRequest startTransactionInfo;
      startTransactionInfo = new ScanWebSimpleStartTransactionRequest(transactionID,
          returnUrl);

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

        System.out.println(ScanWebSimpleScanResult.toString(result));
       
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
            
            System.out.println("Firma Detached del Fitxer Scanejat guardat a " + detached.getAbsolutePath());
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

    return new ApiScanWebSimple(prop.getProperty("endpoint"), prop.getProperty("username"),
        prop.getProperty("password"));

  }

}
