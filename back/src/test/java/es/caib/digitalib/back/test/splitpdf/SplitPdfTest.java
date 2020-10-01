package es.caib.digitalib.back.test.splitpdf;

import java.io.File;
import java.io.InputStream;

import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.junit.Test;

import es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1.SplitPdf;
import junit.framework.TestCase;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class SplitPdfTest extends TestCase {

  public static class TestItem {

    final String resName;
    final int[] expectedPagesByDoc;

    public TestItem(String resName, int[] expectedPagesByDoc) {
      super();
      this.resName = resName;
      this.expectedPagesByDoc = expectedPagesByDoc;
    }

  }

  public static void main(String[] args) {
    try {

      long mitjaPerPagina = new SplitPdfTest().testSplitPDF();

      System.out.println("    - Mitja de Temps per Pàgina: " + mitjaPerPagina + " ms");

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public long testSplitPDF() throws Exception {
    File destDir = new File("./results");
    destDir.mkdirs();

    final TestItem[] tests = {
        // new TestItem("Separador_test_4.pdf", new int[] { 3, 2, 1 }), // OK

        new TestItem("Test_Color_300dpi_No-Separator-in-1.PDF", new int[] { 3, 2, 1 }), // OK

        new TestItem("Test_Color_300dpi_Separator-in-1.PDF", new int[] { 3, 2, 1 }),

        new TestItem("Test_Gray_75dpi_No-Separator-in-1.PDF", new int[] { 3, 2, 1 }) };

    long mitjaPerPagina = 0;

    for (int i = 0; i < tests.length; i++) {

      TestItem testItem = tests[i];

      System.out.println("\n=======  TEST [" + i + "] " + testItem.resName + "========= ");

      // Parsejar PDF
      final String baseName = testItem.resName;

      InputStream is = FileUtils.readResource(SplitPdfTest.class, testItem.resName);
      byte[] data = FileUtils.toByteArray(is);

      long start = System.currentTimeMillis();

      File[] filesSplitted = SplitPdf.detectPagesWithQR(destDir, data, baseName);

      long end = System.currentTimeMillis();

      long totalMs = (end - start);

      System.out.println("    - Temps: " + totalMs + " ms");

      if (testItem.expectedPagesByDoc.length != filesSplitted.length) {
        System.err.println(
            "    - Test ERROR [" + i + "] => Expected (" + testItem.expectedPagesByDoc.length
                + ")  || Splitted (" + filesSplitted.length + ")");
      } else {
        System.out.println(
            "    - Test OK [" + i + "] => Expected (" + testItem.expectedPagesByDoc.length
                + ")  || Splitted (" + filesSplitted.length + ")");

        int totalPages = 0;

        for (int p : testItem.expectedPagesByDoc) {
          totalPages = totalPages + p + 1;
        }
        totalPages = totalPages - 1;

        if (mitjaPerPagina == 0) {
          mitjaPerPagina = totalMs / totalPages;
        } else {
          mitjaPerPagina = (totalMs + (totalMs / totalPages)) / 2;
        }

      }
      
      assertEquals(testItem.expectedPagesByDoc.length, filesSplitted.length);

    }
    return mitjaPerPagina;
  }

  public static void main2(String[] args) {

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
