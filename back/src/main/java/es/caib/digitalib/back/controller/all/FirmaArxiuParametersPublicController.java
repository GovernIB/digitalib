package es.caib.digitalib.back.controller.all;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Field;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractFirmaArxiuParametersController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.back.controller.user.ScanWebProcessControllerUser;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.logic.TransaccioPublicLogicaLocal;
import es.caib.digitalib.model.fields.TransaccioFields;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = FirmaArxiuParametersPublicController.CONTEXTWEB_PUBLIC)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class FirmaArxiuParametersPublicController
    extends AbstractFirmaArxiuParametersController {

  public static final String THUMBNAIL_PDF_MASSIVE = "/thumbnailpdf";

  @EJB(mappedName = TransaccioPublicLogicaLocal.JNDI_NAME)
  protected TransaccioPublicLogicaLocal transaccioPublicEjb;

  @Override
  public boolean isPublic() {
    return true;
  }

  @Override
  public boolean isUtilitzatPerAplicacio() {
    return true;
  }

  @Override
  public TransaccioJPA findByPrimaryKey(HttpServletRequest request,
      java.lang.Long transaccioID) throws I18NException {
    return (TransaccioJPA) transaccioPublicEjb.findByPrimaryKey(transaccioID);
  }

  @Override
  public TransaccioJPA update(HttpServletRequest request, TransaccioJPA transaccio)
      throws Exception, I18NException, I18NValidationException {
    return (TransaccioJPA) transaccioPublicEjb.update(transaccio);

  }

  @Override
  public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {

    TransaccioForm transaccioForm = super.getTransaccioForm(_jpa, __isView, request, mav);

    if (transaccioForm.getTransaccio().getTransaccioMultipleID() != null) {

      if (_jpa.getFitxerEscanejatID() == null) {
        // Posam tots els camps a buit excepte nom

        Set<Field<?>> hiddenFields = new HashSet<Field<?>>(
            Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

        // Tots excepte NOM
        hiddenFields.remove(TransaccioFields.NOM);

        transaccioForm.setHiddenFields(hiddenFields);

      } else {

        transaccioForm.setTitleCode("documentescanejat");
        Integer pos = (Integer) request.getSession()
            .getAttribute(AbstractScanWebProcessController.SESSION_MASIVE_POINTER_POST_SCAN);
        transaccioForm.setTitleParam(String.valueOf(pos + 1));

        transaccioForm.setCancelButtonVisible(false);

        mav.addObject("thumbnailPDF", getContextWeb() + "/" + THUMBNAIL_PDF_MASSIVE + "/"
            + transaccioForm.getTransaccio().getTransactionWebId());
        
        transaccioForm.setAttachedAdditionalJspCode(true);
        

        mav.setViewName("transaccionsmassives_public");

      }

      /// XYZ ZZZ ZZZ TODO Si hi ha error en la transacció hem d'anar directament a la següent
      /// !!!!
    }

    return transaccioForm;
  }

  @Override
  public String getRedirectWhenModified(HttpServletRequest request,
      TransaccioForm transaccioForm, Throwable __e) {

    if (transaccioForm.getTransaccio().getFitxerEscanejatID() == null) {
      String str = super.getRedirectWhenModified(request, transaccioForm, __e);
      return str;
    } else {

      Long transaccioMultipleID = transaccioForm.getTransaccio().getTransaccioMultipleID();

      String r = (isPublic() ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH
          : ScanWebProcessControllerUser.CONTEXTWEB)
          + AbstractScanWebProcessController.SCANWEB_CONTEXTPATH_UPDATE_MASSIVE + "/"
          + transaccioMultipleID;

      log.info(
          " XYZ ZZZ FirmaArxiuParametersPublicController ::getRedirectWhenModified  STATUS => "
              + transaccioForm.getTransaccio().getEstatCodi());
      log.info(
          " XYZ ZZZ   FirmaArxiuParametersPublicController ::   PASSAM A SEGÜENT ENTRADA: "
              + r);

      // Venim de MASSIVE
      return "redirect:" + r;

    }

  }

  @RequestMapping(value = THUMBNAIL_PDF_MASSIVE
      + "/{transaccioWebID}", method = RequestMethod.GET)
  public void createThumbnailPdf(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("transaccioWebID") String transaccioWebID)
      throws Exception, I18NException {

    long fitxerID = transaccioPublicEjb.executeQueryOne(FITXERESCANEJATID,
        TRANSACTIONWEBID.equal(transaccioWebID));

    File file = FileSystemManager.getFile(fitxerID);
    final PDDocument document = PDDocument.load(file);
    PDFRenderer pdfRenderer = new PDFRenderer(document);

    {
      BufferedImage bim = pdfRenderer.renderImage(0, 0.5f);

      BufferedImage scaled = scale(bim, 350);

      ImageIO.write(scaled, "PNG", response.getOutputStream());

    }

  }

  public static BufferedImage scale(BufferedImage image, int max) {

    int width = image.getWidth(null);
    int height = image.getHeight(null);
    double dWidth = 0;
    double dHeight = 0;
    if (width == height) {
      dWidth = max;
      dHeight = max;
    } else if (width > height) {
      dWidth = max;
      dHeight = ((double) height / (double) width) * max;
    } else {
      dHeight = max;
      dWidth = ((double) width / (double) height) * max;
    }
    Image scaled = image.getScaledInstance((int) dWidth, (int) dHeight, Image.SCALE_SMOOTH);

    return toBufferedImage(scaled);

  }

  public static BufferedImage toBufferedImage(Image img) {
    if (img instanceof BufferedImage) {
      return (BufferedImage) img;
    }

    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null),
        BufferedImage.TYPE_INT_ARGB);

    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    return bimage;
  }

}
