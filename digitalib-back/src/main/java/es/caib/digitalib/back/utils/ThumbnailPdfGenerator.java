package es.caib.digitalib.back.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

/**
 * @author anadal
 */
public class ThumbnailPdfGenerator {

    public static void main(String[] args) {
        try {

            System.setProperty("org.jboss.logging.provider", "log4j");

            File file = new File("Blac_i_negre.pdf");
            FileOutputStream fos = new FileOutputStream("Blac_i_negre.jpg");
            thumbnailPDF(file, fos);
            fos.flush();
            fos.close();
            System.out.println("Thumbnail created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param file
     * @param os
     * @throws Exception
     */
    public static void thumbnailPDF(File file, OutputStream os) throws Exception {

        PDDocument pddDoc = Loader.loadPDF(file);

        PDFRenderer pr = new PDFRenderer(pddDoc);

        BufferedImage backImage = pr.renderImage(0, 0.42f);

        ImageIOUtil.writeImage(backImage, "jpeg", os);

    }

}
