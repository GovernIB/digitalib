package es.caib.digitalib.back.test.splitpdf;

import java.io.File;
import java.io.InputStream;

import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.junit.Test;

import es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1.SplitInfo;
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
        final Integer resolucio;
        final int numberOfDocs;

        public TestItem(String resName, Integer resolucio, int[] expectedPagesByDoc) {
            super();
            this.resName = resName;
            this.resolucio = resolucio;
            this.expectedPagesByDoc = expectedPagesByDoc;
            this.numberOfDocs = expectedPagesByDoc.length;
        }
        
        public TestItem(String resName, Integer resolucio, int[] expectedPagesByDoc, int numberOfDocs) {
            super();
            this.resName = resName;
            this.resolucio = resolucio;
            this.expectedPagesByDoc = expectedPagesByDoc;
            this.numberOfDocs = numberOfDocs;
        }


    }

    public static void main(String[] args) {
        try {

            long mitjaPerPagina = new SplitPdfTest().testSplitPDF();

            System.out.println("\n\n\n* Mitja de Temps per Pàgina: " + mitjaPerPagina + " ms");
            
            /*
            File f = new File("doc_amb_1a_pagina_en_blanc.pdf");
            File f2 = new File("doc_sense_1a_pagina_en_blanc.pdf");
            SplitPdf.removeFirstPage(f, f2);
            
            f.delete();
            f2.renameTo(f);
            f2.delete();
            
            System.out.println(" FINAL ");
            */

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

                
                new TestItem("Separador_test_4.pdf", 300, new int[] { 3, 2, 1 }), // OK


                new TestItem("Test_Color_300dpi_No-Separator-in-1.PDF", 300,
                        new int[] { 3, 2, 1 }), // OK
                        

                new TestItem("Test_Color_300dpi_Separator-in-1.PDF", 300,
                        new int[] { 3, 2, 1 }),

                new TestItem("Test_Gray_75dpi_No-Separator-in-1.PDF", 75,
                        new int[] { 3, 2, 1 }),

                new TestItem("Separador_test_NO_FUNCIONA_marilen.pdf", 200,
                        new int[] { 1, 1 }),


                new TestItem("300ppp_BN_Separador_Doble_Cara_i_Una_Cara.pdf", 200,
                        new int[] { 5, 6, 9}),

                new TestItem("300ppp_BN_Separador_Doble_Cara_Darrera_pagina.pdf", 200,
                        new int[] { 5 }),
               
                /*
                new TestItem("TEST_LEGAL_SIZE_1.pdf", 200, new int[] { 3,4,7,8 }, 3),
                
                new TestItem("TEST_LEGAL_SIZE_2.pdf", 200, new int[] { 3,4,7,8 }, 3),
                
                new TestItem("TEST_LEGAL_SIZE_3.pdf", 200, new int[] { 3,4,7,8 }, 3),
                */
                
                //new TestItem("escala_grisos_nofunciona_separador.pdf", 200, new int[] { 4 }, 2),
                
               // new TestItem("NO_FUNCIONA_Test_Gray_75dpi_Separator-in-1.PDF", 75, new int[] { 5, 8 })

        };

        long mitjaPerPagina = 0;

        for (int i = 0; i < tests.length; i++) {

            TestItem testItem = tests[i];

            System.out
                    .println("\n=======  TEST [" + i + "] " + testItem.resName + "========= ");

            // Parsejar PDF
            final String baseName = testItem.resName;

            InputStream is = FileUtils.readResource(SplitPdfTest.class, testItem.resName);
            byte[] data = FileUtils.toByteArray(is);

            long start = System.currentTimeMillis();
            
            File debugDir = null;
            debugDir = new File(destDir, "bitmaps");
            debugDir.mkdirs();
            

            SplitInfo[] filesSplitted = SplitPdf.detectPagesWithQR(destDir, data, baseName,
                    testItem.resolucio, debugDir);
            
           

            long end = System.currentTimeMillis();

            long totalMs = (end - start);

            System.out.println("    - Temps: " + totalMs + " ms");

            if (testItem.numberOfDocs != filesSplitted.length) {
                System.err.println("    - Test ERROR [" + i + "] => Expected ("
                        + testItem.numberOfDocs + ")  || Splitted ("
                        + filesSplitted.length + ")");
            } else {
                System.out.println("    - Test OK [" + i + "] => Expected ("
                        + testItem.numberOfDocs + ")  || Splitted ("
                        + filesSplitted.length + ")");

                int totalPages = 0;

                for (int p : testItem.expectedPagesByDoc) {
                    System.out.println("Bloc 1");
                    totalPages = totalPages + p + 1;
                }
                totalPages = totalPages - 1;

                if (mitjaPerPagina == 0) {
                    mitjaPerPagina = totalMs / totalPages;
                } else {
                    mitjaPerPagina = (totalMs + (totalMs / totalPages)) / 2;
                }
                
                int count = 1;
                for (SplitInfo splitInfo : filesSplitted) {
                   System.out.println("    * Bloc[" + count +"] => Possible First Empty File: " + splitInfo.firstPageEmpty); 
                   count++;
                }

            }

            assertEquals(testItem.numberOfDocs, filesSplitted.length);

        }
        return mitjaPerPagina;
    }

    public static void main2(String[] args) {

        File destDir = new File(".");
        try {

            long start = System.currentTimeMillis();

            // Parsejar PDF
            String baseName = "Prova";

            SplitPdf.detectPagesWithQR(destDir, new File("Separador_test_2.pdf"), baseName,
                    200); // "Separador_test.pdf"

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
