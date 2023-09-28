package es.caib.digitalib.back.controller.all;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.AbstractFirmaArxiuParametersController;
import es.caib.digitalib.back.controller.AbstractScanWebModuleController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController;
import es.caib.digitalib.back.controller.AbstractScanWebProcessController.FitxerEscanejatInfo;
import es.caib.digitalib.back.controller.scanwebsimple.apimassivescanwebsimple.v1.SplitPdf;
import es.caib.digitalib.back.controller.user.ScanWebProcessControllerUser;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.logic.TransaccioPublicLogicaService;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.commons.utils.Configuracio;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Controller
@RequestMapping(value = FirmaArxiuParametersPublicController.CONTEXTWEB_PUBLIC)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class FirmaArxiuParametersPublicController extends AbstractFirmaArxiuParametersController {

    /**
     * NOTA: Alerta al canviar aquesta constant, ja que està definida en jsp's
     */
    public static final String THUMBNAIL_PDF_MASSIVE = "/thumbnailpdf";

    public String rewriteTileForm = null;

    @EJB(mappedName = TransaccioPublicLogicaService.JNDI_NAME)
    protected TransaccioPublicLogicaService transaccioPublicEjb;

    @Override
    public boolean isPublic() {
        return true;
    }

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return true;
    }

    @Override
    public TransaccioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long transaccioID)
            throws I18NException {
        return (TransaccioJPA) transaccioPublicEjb.findByPrimaryKey(transaccioID);
    }

    @Override
    public TransaccioJPA update(HttpServletRequest request, TransaccioJPA transaccio)
            throws I18NException, I18NValidationException {
        return (TransaccioJPA) transaccioPublicEjb.update(transaccio);

    }

    @Override
    public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {

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

                mav.addObject("thumbnailPDF", getContextWeb() + THUMBNAIL_PDF_MASSIVE + "/"
                        + transaccioForm.getTransaccio().getTransactionWebId());

                transaccioForm.setAttachedAdditionalJspCode(true);

                // En aquesta pàgina web hi ha algun tipus de BUG i no captura correctament
                // l'idioma
                {
                    String languageUI = transaccioForm.getTransaccio().getLanguageUI();
                    String where = "AbstractScanWebModuleController::selectScanWebModule()";
                    HttpServletResponse response = null;
                    AbstractScanWebModuleController.setLanguageUI(request, response, languageUI, where);
                }

                if (Configuracio.showButtonToDeleteFirstPage()) {
                    Map<Long, FitxerEscanejatInfo> infos = (Map<Long, FitxerEscanejatInfo>) request.getSession()
                            .getAttribute(AbstractScanWebProcessController.SESSION_MASSIVE_INFO_BY_ID);
                    if (infos == null) {
                        log.error("\n\n\n ERROR infos val null. \n\n\n");
                    } else {
                        long id = transaccioForm.getTransaccio().getTransaccioID();
                        FitxerEscanejatInfo fei = infos.get(id);
                        if (fei == null) {
                            log.error("\n\n\n infos[" + id + "] => " + fei + "  \n\n\n");
                            log.error("\n\n\n IDs de Transaccions:");
                            for (Long ids : infos.keySet()) {
                                log.info("     => " + ids);
                            }
                        } else {
                            if (fei.firstPageEmpty) {
                                transaccioForm.addAdditionalButton(new AdditionalButton(IconUtils.getWhite(IconUtils.ICON_TRASH),
                                        "esborrarprimerapagina", "javascript:eliminarPrimeraPagina();", "btn-warning"));
                            }
                        }
                    }
                }

                rewriteTileForm = "transaccionsmassives_public";

                mav.setViewName("transaccionsmassives_public");

            }

            /// XYZ ZZZ ZZZ TODO Si hi ha error en la transacció hem d'anar directament a la
            /// següent
            /// !!!!
        }

        return transaccioForm;
    }

    @Override
    @RequestMapping(value = "/{transaccioID}/edit", method = RequestMethod.POST)
    public String editarTransaccioPost(@ModelAttribute TransaccioForm transaccioForm,
        BindingResult result, SessionStatus status, HttpServletRequest request,
        HttpServletResponse response) throws I18NException {

        String resStr = request.getParameter("eliminarpaginaenblanc");

        log.info(" XYZ ZZZ eliminarpaginaenblanc => ]" + resStr + "[");

        if ("true".equals(resStr)) {

            long fid = transaccioForm.getTransaccio().getFitxerEscanejatID();

            File f = FileSystemManager.getFile(fid);

            // XYZ ZZZ ZZZ
            log.info("\n\n\n F = " + f.getAbsolutePath() + " [" + f.length() + "]\n\n\n");

            File f2 = new File(f.getParentFile(), f.getName() + ".withoutfirstpage");

            log.info("\n\n\n F2 PRE= " + f2.getAbsolutePath() + "\n\n\n");

            try {
                SplitPdf.removeFirstPage(f, f2);
                log.info("\n\n\n F2 POST= " + f2.getAbsolutePath() + " [" + f2.length() + "]\n\n\n");

                if (!f.delete()) {
                    log.info("\n\n\n F DELETE = false");
                    log.error("\n\n\n F Hi ha algu que es deixa aquest fitxer obert: " + f.getAbsolutePath());
                } else {
                    log.info("\n\n\n F DELETE = " + f.delete());
                    log.info("\n\n\n F2 RENAMETO = " + f2.renameTo(f));
                    log.info("\n\n\n F2 DELETE = " + f2.delete());

                }

                // Esborram el boto que indica que es pot esborrar la primera pàgina
                transaccioForm.getAdditionalButtons().clear();
            } catch (Exception e) {
                // TODO XYZ ZZZ ZZZ 
                String msg = "Error intentant esborrar primera pàgina del document " + f.getAbsolutePath() + ": "
                        + e.getMessage();
                log.error(msg, e);
                HtmlUtils.saveMessageError(request, msg);
            }

            // Tornam a la mateixa pàgina però amb el document sense la primera pàgina en blanc
            return getTileForm();
        }

        return super.editarTransaccioPost(transaccioForm, result, status, request, response);
    }

    @Override
    public String getTileForm() {

        if (rewriteTileForm == null) {
            return super.getTileForm();
        } else {
            return rewriteTileForm;
        }

    }

    @Override
    public String getRedirectWhenModified(HttpServletRequest request, TransaccioForm transaccioForm, Throwable __e) {

        if (transaccioForm.getTransaccio().getFitxerEscanejatID() == null) {
            String str = super.getRedirectWhenModified(request, transaccioForm, __e);
            return str;
        } else {

            Long transaccioMultipleID = transaccioForm.getTransaccio().getTransaccioMultipleID();

            String r = (isPublic() ? ScanWebProcessControllerPublic.SCANWEB_CONTEXTPATH
                    : ScanWebProcessControllerUser.CONTEXTWEB)
                    + AbstractScanWebProcessController.SCANWEB_CONTEXTPATH_UPDATE_MASSIVE + "/" + transaccioMultipleID;

            log.info("FirmaArxiuParametersPublicController ::getRedirectWhenModified  STATUS => "
                    + transaccioForm.getTransaccio().getEstatCodi());
            log.info("FirmaArxiuParametersPublicController ::   PASSAM A SEGÜENT ENTRADA: " + r);

            // Venim de MASSIVE
            return "redirect:" + r;

        }

    }

    @RequestMapping(value = THUMBNAIL_PDF_MASSIVE + "/{transaccioWebID}", method = RequestMethod.GET)
    public void createThumbnailPdf(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("transaccioWebID") String transaccioWebID) throws Exception, I18NException {

        long fitxerID = transaccioPublicEjb.executeQueryOne(FITXERESCANEJATID, TRANSACTIONWEBID.equal(transaccioWebID));

        PDDocument document = null;
        try {
            File file = FileSystemManager.getFile(fitxerID);
            document = PDDocument.load(file);
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            BufferedImage bim = pdfRenderer.renderImage(0, 0.5f);

            BufferedImage scaled = scale(bim, 350);

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", -1); // Proxies.

            ImageIO.write(scaled, "PNG", response.getOutputStream());

        } finally {
            if (document != null) {
                document.close();
            }
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

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

}
