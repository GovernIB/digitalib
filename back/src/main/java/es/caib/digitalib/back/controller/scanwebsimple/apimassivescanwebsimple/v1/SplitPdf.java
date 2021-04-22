package es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class SplitPdf {
  
  protected static final Logger log = Logger.getLogger(SplitPdf.class);

  protected static final String SEPARADOR_TEXT = "GOIB DIGITALIB SEPARADOR";

  

  public static final File[] detectPagesWithQR(File destDir, final File pdfToSplit, String baseName)
      throws Exception {
    
    final PDDocument document = PDDocument.load(pdfToSplit);
    final InputStream originalFileIS = new FileInputStream(pdfToSplit);
    try {
       return detectPagesWithQR(destDir, document, baseName, originalFileIS);
    } finally {
        try {
          originalFileIS.close();
        } catch (Exception e) {
          log.error("Tancant IS", e);
        }
        document.close();
    
    }
  }
  
  
  public static final File[] detectPagesWithQR(File destDir, final byte[] pdfToSplit, String baseName)
      throws Exception {
    final PDDocument document = PDDocument.load(pdfToSplit);
    final InputStream originalFileIS = new ByteArrayInputStream(pdfToSplit);
    try {
      return detectPagesWithQR(destDir, document, baseName,  originalFileIS);
    } finally {
      document.close();
    }
  }
  
  
  protected static final File[] detectPagesWithQR(File destDir, final PDDocument document, String baseName, InputStream originalFileIS)
      throws Exception {

    final List<Integer> qrPages = new ArrayList<Integer>();

    
    ArrayList<PDRectangle> crops = new ArrayList<PDRectangle>();
    
    {
      log.info("XYZ ZZZ ZZZZZ\n\n detectPagesWithQR:: ENTRAM => ");

   // XYZ ZZZ ZZZ
      PDRectangle rectangle = new PDRectangle();

      final int x = 140;
      final int y = 365;
      final int side = 310;
    
      
      rectangle.setLowerLeftX(x);
      rectangle.setLowerLeftY(y);
      rectangle.setUpperRightX(x + side);
      rectangle.setUpperRightY(y + side);
      
      

      for (int page = 1; page <= document.getNumberOfPages(); page++) {

        PDPage page2 = document.getPage(page - 1);
        
        crops.add(page2.getCropBox());

        page2.setCropBox(rectangle);
      }

      PDFRenderer pdfRenderer = new PDFRenderer(document);

      {


        for (int page = 1; page <= document.getNumberOfPages(); page++) {

          BufferedImage bim = pdfRenderer.renderImage(page - 1, 0.2f, ImageType.BINARY);

          try {
            // ZXING - > Read Data from QR Code
            LuminanceSource source = new BufferedImageLuminanceSource(bim);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            log.info("XYZ ZZZ ZZZZZ detectPagesWithQR:: PROCESSANT PAGINA => " + page);
            Result result = new MultiFormatReader().decode(bitmap);

            
            if (result.getBarcodeFormat().equals(BarcodeFormat.QR_CODE)) {
              String text = result.getText();
              if (text != null && text.startsWith(SEPARADOR_TEXT)) {
                log.info("   XYZ ZZZ ZZZZZ detectPagesWithQR:: TROBAT SEPARADOR => " + page);
                qrPages.add(page);

              }
            }
          } catch (com.google.zxing.NotFoundException nfe) {
            log.info("   XYZ ZZZ ZZZZZ detectPagesWithQR:: NO TROBAT");
          }

        }
      }
     
    }
    
    
    for (int page = 1; page <= document.getNumberOfPages(); page++) {
      PDPage page2 = document.getPage(page - 1);
      page2.setCropBox(crops.get(page - 1));
    }
    

    List<File> listFiles = extractPagesFromPDF(destDir, document, qrPages, baseName, originalFileIS);
    
    document.close();

    return listFiles.toArray(new File[listFiles.size()]);
  }

  /**
   * PDF BOX
   * 
   * @param destDir
   * @param pdfToSplit
   * @param qrPages
   * @return
   */
  protected static List<File> extractPagesFromPDF(File destDir, PDDocument pdfDoc,
      final List<Integer> qrPages, String baseName, InputStream originalFileIS) throws Exception {

    //PDDocument pdfDoc = PDDocument.load(pdfToSplit);

    List<File> listFiles = new ArrayList<File>();

    if (qrPages.size() == 0) {
      
      log.info("   XYZ ZZZ ZZZZZ extractPagesFromPDF => qrPages.size() == 0");
      
      // PdfDocument pdfDest = new PdfDocument(new PdfWriter("RESULT_ONE_PDF.pdf"));
      // pdfDoc.copyPagesTo(1, pdfDoc.getNumberOfPages(), pdfDest);
      // pdfDest.close();
      String name = baseName + "_1_#" + pdfDoc.getNumberOfPages() + ".pdf";
      File pdf = new File(destDir, name); 
      //pdfDoc.save(pdfToSplit);
      org.apache.commons.io.FileUtils.copyInputStreamToFile(originalFileIS, pdf);
      listFiles.add(pdf);
    } else {
      log.info("   XYZ ZZZ ZZZZZ extractPagesFromPDF => TROBATS SEPARADORS: " + qrPages.size());
      // 2) Un ou plusieurs QR code = au moins deux documents
      //log.info("Llista items: " + qrPages.size());
      int start = 1;
      int count = 1;
      for (int index = 0; index < qrPages.size(); index++) {
        //log.info("trobat QR  en pagina " + qrPages.get(index));

        if (qrPages.get(index) != 1) {

          final int fromPage = start;
          final int toPage = qrPages.get(index) - 1;

          final String name = baseName + "_" + count + "_#" + qrPages.size() + ".pdf";

          File f = new File(destDir, name);

          splitPdfpages(pdfDoc, f, fromPage, toPage);

          listFiles.add(f);

          count++;
        }
        start = qrPages.get(index) + 1;
      }

      // La resta de pagines
      if (start <= pdfDoc.getNumberOfPages()) {
        File f = new File(destDir,
            baseName + "_" + count + "_#" + qrPages.size() + ".pdf");

        int fromPage = start;
        int toPage = pdfDoc.getNumberOfPages();
        splitPdfpages(pdfDoc, f, fromPage, toPage);

        listFiles.add(f);
      }

    }

    pdfDoc.close();
    return listFiles;
  }

  protected static void splitPdfpages(PDDocument pdfDoc, File destFile, final int fromPage,
      final int toPage) throws IOException {
    Splitter splitter = new Splitter();

    splitter.setStartPage(fromPage);
    splitter.setEndPage(toPage);
    splitter.setSplitAtPage(toPage - fromPage + 1);

    List<PDDocument> lst = splitter.split(pdfDoc);

    PDDocument pdfDocPartial = lst.get(0);

    pdfDocPartial.save(destFile);
  }

}
