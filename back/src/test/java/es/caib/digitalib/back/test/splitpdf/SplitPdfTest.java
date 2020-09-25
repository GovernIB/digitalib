package es.caib.digitalib.back.test.splitpdf;

import java.io.File;

import es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1.SplitPdf;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class SplitPdfTest {

  
  public static void main(String[] args) {

    File destDir = new File(".");
    try {

      long start = System.currentTimeMillis();

      // Parsejar PDF      
      String baseName = "Prova";

      SplitPdf.detectPagesWithQR(destDir, new File("Separador_test_2.pdf"), baseName); // "Separador_test.pdf"

      // Generar QR
      // generateQR(new File(destDir, "generaredQR.jpg"));

      long end = System.currentTimeMillis();

      System.out.println("Temps: " + (end - start) + " ms");

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
