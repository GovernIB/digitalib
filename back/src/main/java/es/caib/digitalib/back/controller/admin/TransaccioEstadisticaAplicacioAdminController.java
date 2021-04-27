package es.caib.digitalib.back.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.TransaccioQueryPath;

/**
 * 
 * @author anadal(u80067)
 */
@Controller
@RequestMapping(value = TransaccioEstadisticaAplicacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioEstadisticaAplicacioAdminController
        extends AbstractTransaccioAdminController {

    public static final String CONTEXTWEB = "/admin/transaccioestadisticaaplicacio";

    public static final int FITXER_NOM = 4;

    public static final int FITXER_SIZE = 6;

    public String getTipus() {
        return isUtilitzatPerAplicacio() ? "aplicacio" : "persona";
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "TransaccioAdmin_Estadistica_FilterForm_" + isUtilitzatPerAplicacio();
    }

    @Override
    public TransaccioForm getTransaccioForm(TransaccioJPA _jpa, boolean __isView,
            HttpServletRequest request, ModelAndView mav) throws I18NException {
        TransaccioForm form = super.getTransaccioForm(_jpa, __isView, request, mav);

        form.setEntityNameCode("transaccio.estadistica." + getTipus());
        form.setEntityNameCodePlural("transaccio.estadistica." + getTipus() + ".plural");

        return form;
    }

    @Override
    public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav,
            HttpServletRequest request) throws I18NException {

        TransaccioFilterForm filterForm = super.getTransaccioFilterForm(pagina, mav, request);

        if (filterForm.isNou()) {
            filterForm.setEntityNameCode("transaccio.estadistica." + getTipus());
            filterForm.setEntityNameCodePlural(
                    "transaccio.estadistica." + getTipus() + ".plural");

            filterForm.setEditButtonVisible(false);

            Set<Field<?>> hiddens = filterForm.getHiddenFields();

            hiddens.addAll(Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

            hiddens.remove(TRANSACCIOID);
            // hiddens.remove(TRANSACCIOMULTIPLEID);
            hiddens.remove(FUNCIONARIUSERNAME);
            hiddens.remove(USUARIAPLICACIOID);
            //hiddens.remove(TransaccioFields.FITXERSIGNATURAID);
            // Fitxer Nom - Fitxer Tamany
            hiddens.remove(INFOSCANPIXELTYPE);
            hiddens.remove(INFOSCANRESOLUCIOPPP);
            hiddens.remove(INFOSCANPAPERSIZE);
            hiddens.remove(INFOSCANDATACAPTURA);

            filterForm.setOrderBy(DATAINICI.fullName);
            filterForm.setOrderAsc(false);

            // filterForm.setDefaultOrderBy(null);

            filterForm.getGroupByFields().remove(DATAFI);
            filterForm.getGroupByFields().remove(DATAINICI);
            filterForm.getGroupByFields().add(INFOSCANDATACAPTURA);

            filterForm.getGroupByFields().remove(INFOSCANPAPERSIZE);

            filterForm.getGroupByFields().remove(INFOSCANPIXELTYPE);
            filterForm.getGroupByFields().remove(INFOSCANRESOLUCIOPPP);

            List<Field<?>> filterByFields = new ArrayList<Field<?>>();
            filterByFields.add(DATAINICI);
            filterByFields.add(ESTATCODI);
            filterForm.setFilterByFields(filterByFields);

            AdditionalField<Long, String> adfield4 = new AdditionalField<Long, String>();
            adfield4.setPosition(FITXER_NOM);
            adfield4.setValueField(new TransaccioQueryPath().FITXERSIGNATURA().NOM());
            adfield4.setEscapeXml(false);
            adfield4.setCodeName(FITXERSIGNATURAID.fullName);
            adfield4.setOrderBy(new TransaccioQueryPath().FITXERSIGNATURA().NOM());

            filterForm.addAdditionalField(adfield4);
            
            
            AdditionalField<Long, Long> adfield6 = new AdditionalField<Long, Long>();
            adfield6.setPosition(FITXER_SIZE);
            adfield6.setValueField(new TransaccioQueryPath().FITXERSIGNATURA().TAMANY());
            adfield6.setEscapeXml(false);
            adfield6.setCodeName("=Bytes");
            adfield6.setOrderBy(new TransaccioQueryPath().FITXERSIGNATURA().TAMANY());

            filterForm.addAdditionalField(adfield6);
            
            String subtitle = "=EXPIRED: -3 | CANCELLED: -2 | ERROR: -1 | REQUESTED_ID: 0 | IN_PROGRESS: 1 | OK: 2";
            filterForm.setSubTitleCode(subtitle);

        }

        return filterForm;
    }

    @Override
    public boolean isActiveFormNew() {
        return false;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveDelete() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return true;
    }

    @Override
    public boolean isVisibleExportData() {
        return true;
    }

    @Override
    public boolean isUtilitzatPerAplicacio() {
        return true;
    }

    @Override
    public void postList(HttpServletRequest request, ModelAndView mav,
            TransaccioFilterForm filterForm, List<Transaccio> list) throws I18NException {

        filterForm.getAdditionalButtonsByPK().clear();

        postListNomPersonaAplicacio(request, filterForm, list, isAdmin());

    }

}
