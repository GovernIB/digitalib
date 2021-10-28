package es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
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

    public static final SplitInfo[] detectPagesWithQR(File destDir, final File pdfToSplit,
            String baseName, Integer resolucio) throws Exception {

        final PDDocument document = PDDocument.load(pdfToSplit);
        final InputStream originalFileIS = new FileInputStream(pdfToSplit);
        try {
            return detectPagesWithQR(destDir, document, baseName, originalFileIS, resolucio);
        } finally {
            try {
                originalFileIS.close();
            } catch (Exception e) {
                log.error("Tancant IS", e);
            }
            document.close();

        }
    }

    public static final SplitInfo[] detectPagesWithQR(File destDir, final byte[] pdfToSplit,
            String baseName, Integer resolucio) throws Exception {
        final PDDocument document = PDDocument.load(pdfToSplit);
        final InputStream originalFileIS = new ByteArrayInputStream(pdfToSplit);
        try {
            return detectPagesWithQR(destDir, document, baseName, originalFileIS, resolucio);
        } finally {
            document.close();
        }
    }

    protected static final SplitInfo[] detectPagesWithQR(File destDir, final PDDocument document,
            String baseName, InputStream originalFileIS, Integer resolucio) throws Exception {

        final List<Integer> qrPages = new ArrayList<Integer>();
        final List<Integer> possibleEmptyPage = new ArrayList<Integer>();
 
        ArrayList<PDRectangle> crops = new ArrayList<PDRectangle>();

        log.info("XYZ ZZZ ZZZZZ\n\n detectPagesWithQR:: ENTRAM => resolucio: " + resolucio);

        PDRectangle rectangle = new PDRectangle();
        // XYZ ZZZ ZZZ
        // Incrementar si la zona del QR no s'ajusta exactament a l aposició impresa del QR.
        final int margin = 25;
        final int x = 140 - margin;
        final int y = 365 - margin;
        final int side = 310 + 2 * margin;

        rectangle.setLowerLeftX(x);
        rectangle.setLowerLeftY(y);
        rectangle.setUpperRightX(x + side);
        rectangle.setUpperRightY(y + side);

        for (int page = 1; page <= document.getNumberOfPages(); page++) {

            PDPage page2 = document.getPage(page - 1);

            crops.add(page2.getCropBox());

            page2.setCropBox(rectangle);
        }

        float scale;
        if (resolucio == null || resolucio <= 100) {
            scale = 0.5f;
        } else if (resolucio <= 200) {
            scale = 0.3f;
        } else {
            scale = 0.2f;
        }

        PDFRenderer pdfRenderer = new PDFRenderer(document);
        
        boolean lastPageWasSeparator = false;

        for (int page = 1; page <= document.getNumberOfPages(); page++) {

            BufferedImage bim = pdfRenderer.renderImage(page - 1, scale, ImageType.BINARY);
            
            
            if (lastPageWasSeparator) {
                boolean isEmpty = isBlank(bim);
                if (isEmpty) {
                  possibleEmptyPage.add(page);
                }
            }
            

            boolean isSeparador = false;
            
            try {
                // ZXING - > Read Data from QR Code
                LuminanceSource source = new BufferedImageLuminanceSource(bim);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                log.info("XYZ ZZZ ZZZZZ detectPagesWithQR:: PROCESSANT PAGINA => " + page);
                Result result = new MultiFormatReader().decode(bitmap);

                if (result.getBarcodeFormat().equals(BarcodeFormat.QR_CODE)) {
                    String text = result.getText();
                    if (text != null && text.startsWith(SEPARADOR_TEXT)) {
                        log.info("   XYZ ZZZ ZZZZZ detectPagesWithQR:: TROBAT SEPARADOR => "
                                + page);
                        qrPages.add(page);
                        isSeparador = true;
                    }
                }
            } catch (com.google.zxing.NotFoundException nfe) {
                log.info("   XYZ ZZZ ZZZZZ detectPagesWithQR:: NO TROBAT");
            }
            
            if (isSeparador) {
                lastPageWasSeparator = true;
            } else {
                lastPageWasSeparator = false;
            }

        }

        for (int page = 1; page <= document.getNumberOfPages(); page++) {
            PDPage page2 = document.getPage(page - 1);
            page2.setCropBox(crops.get(page - 1));
        }

        List<SplitInfo> listFiles = extractPagesFromPDF(destDir, document, qrPages, baseName,
                originalFileIS, possibleEmptyPage);

        document.close();

        return listFiles.toArray(new SplitInfo[listFiles.size()]);
    }

    /**
     * PDF BOX
     * 
     * @param destDir
     * @param pdfToSplit
     * @param qrPages
     * @return
     */
    protected static List<SplitInfo> extractPagesFromPDF(File destDir, PDDocument pdfDoc,
            final List<Integer> qrPages, String baseName, InputStream originalFileIS,
            final List<Integer> possibleEmptyPage)
            throws Exception {

        // PDDocument pdfDoc = PDDocument.load(pdfToSplit);

        List<SplitInfo> listFiles = new ArrayList<SplitInfo>();

        if (qrPages.size() == 0) {

            log.info("   XYZ ZZZ ZZZZZ extractPagesFromPDF => qrPages.size() == 0");

            // PdfDocument pdfDest = new PdfDocument(new PdfWriter("RESULT_ONE_PDF.pdf"));
            // pdfDoc.copyPagesTo(1, pdfDoc.getNumberOfPages(), pdfDest);
            // pdfDest.close();
            String name = baseName + "_1_#" + pdfDoc.getNumberOfPages() + ".pdf";
            File pdf = new File(destDir, name);
            // pdfDoc.save(pdfToSplit);
            org.apache.commons.io.FileUtils.copyInputStreamToFile(originalFileIS, pdf);
            listFiles.add(new SplitInfo(pdf, false));
        } else {
            log.info("   XYZ ZZZ ZZZZZ extractPagesFromPDF => TROBATS SEPARADORS: "
                    + qrPages.size());
            // 2) Un ou plusieurs QR code = au moins deux documents
            // log.info("Llista items: " + qrPages.size());
            int start = 1;
            int count = 1;
            for (int index = 0; index < qrPages.size(); index++) {
                // log.info("trobat QR en pagina " + qrPages.get(index));

                if (qrPages.get(index) != 1) {

                    final int fromPage = start;
                    final int toPage = qrPages.get(index) - 1;
                    
                    // Ignorar dos separadors seguits
                    if (toPage >= fromPage) {

                        final String name = baseName + "_" + count + "_#" + qrPages.size()
                                + ".pdf";
    
                        File f = new File(destDir, name);
                        splitPdfpages(pdfDoc, f, fromPage, toPage);
                        listFiles.add(new SplitInfo(f, possibleEmptyPage.contains(fromPage)));
                        count++;
                    }
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

                listFiles.add(new SplitInfo(f, possibleEmptyPage.contains(fromPage)));
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
        
        pdfDocPartial.close();
    }
    
    
    public static boolean isBlank(Image img) throws Exception {
        long start = System.currentTimeMillis();
        //Image img = ImageIO.read(imageFile);
        int w = img.getWidth(null);
        int h = img.getHeight(null);
        int[] pixels = new int[w * h];
        PixelGrabber pg = new PixelGrabber(img, 0, 0, w, h, pixels, 0, w);
        pg.grabPixels();

        long countWhite = 0;
        long countNoWhite = 0;
        long countTotal = pixels.length;

        System.out.println(" - PIXELS => " + countTotal);

        for (int pixel : pixels) {
            Color color = new Color(pixel);
            // color.getAlpha() == 0 ||
            
            boolean isWhite;
            
            //isWhite = (color.getRGB() == Color.WHITE.getRGB());
            {   
                int gray = (int)(color.getRed() * 0.299f +  color.getGreen() * 0.587f + color.getBlue() * 0.114f);
                
                final int UMBRAL = 240;
                
                isWhite = ( gray > UMBRAL);
            }
            
            
            
            
            if (isWhite) {
                countWhite++;
            } else {
                countNoWhite++;
            }
            
            
            
        }

   
        // XYZ ZZZ

        System.out.println(" - Time Blank => " + (System.currentTimeMillis() - start) + "ms");

        System.out.println(" - Count White: " + countWhite);
        System.out.println(" - Count No White: " + countNoWhite);
        final  DecimalFormat df = new DecimalFormat("###.##");
        
        double percent = countWhite * 100.0 / countTotal;
        
        System.out.println(
                " - Percent White: " + df.format(percent) + "%");

        return percent > 99.0;
    }

    
    
    public static void removeFirstPage(File fileOrig, File fileDest) throws Exception {
        PDDocument document = PDDocument.load(fileOrig);

        // Removing the pages
        document.removePage(0);

        // Saving the document
        document.save(fileDest);

        // Closing the document
        document.close();
    }

}
