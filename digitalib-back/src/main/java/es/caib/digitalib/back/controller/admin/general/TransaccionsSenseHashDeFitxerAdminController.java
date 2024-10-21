package es.caib.digitalib.back.controller.admin.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.KeyValue;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.GroupByItem;
import org.fundaciobit.genapp.common.query.SelectMultipleKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.TransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;

/**
 * 
 * @author anadal
 * 17 oct 2024 8:09:29
 */
@Controller
@RequestMapping(value = "/admin/transaccionssensehashdefitxer")
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccionsSenseHashDeFitxerAdminController extends TransaccioController {

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @Override
    public String getEntityNameCode() {
        return "transaccionssensehashdefitxer";
    }

    @Override
    public String getEntityNameCodePlural() {
        return "transaccionssensehashdefitxer.plural";
    }

    @Override
    public String getTileForm() {
        return "transaccioFormSenseHashFitxer";
    }

    @Override
    public String getTileList() {
        return "transaccioListSenseHashFitxer";
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        Where w1 = ESTATCODI.equal(Constants.TRANSACCIO_ESTAT_CODI_OK);
        
        Where w2_escanejat = Where.AND(HASHESCANEIG.isNull(), FITXERESCANEJATID.isNotNull());
        Where w2_firmat = Where.AND(HASHFIRMA.isNull(), FITXERSIGNATURAID.isNotNull());
        Where w2 = Where.OR(w2_escanejat, w2_firmat);
        
        //Falta que el tipus no sigui NOMES ESCANEIG !!!!!
        Where w3 = INFOSIGNATURAID.isNotNull();
        return Where.AND(w1, w2, w3);
    }

    @Override
    public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {

        TransaccioFilterForm fform = super.getTransaccioFilterForm(pagina, mav, request);

        if (fform.isNou()) {

            fform.setAddButtonVisible(false);
            fform.setViewButtonVisible(true);
            fform.setDeleteButtonVisible(false);
            fform.setEditButtonVisible(false);

            fform.setDeleteSelectedButtonVisible(false);
            //fform.setVisibleMultipleSelection(false);

            Set<Field<?>> ocults = new HashSet<Field<?>>(Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

            ocults.remove(TransaccioFields.TRANSACCIOID);
            ocults.remove(TransaccioFields.TRANSACCIOMULTIPLEID);
            ocults.remove(TransaccioFields.NOM);
            ocults.remove(TransaccioFields.DATAINICI);
            ocults.remove(TransaccioFields.DATAFI);
            ocults.remove(TransaccioFields.USUARIPERSONAID);
            ocults.remove(TransaccioFields.USUARIAPLICACIOID);

            showFields(ocults);

            fform.setHiddenFields(ocults);

            fform.setOrderBy(TransaccioFields.TRANSACCIOID.javaName);
            fform.setOrderAsc(false);

            addAcctionButton(request, fform);

        }

        return fform;

    }

    protected void showFields(Set<Field<?>> ocults) {
        ocults.remove(TransaccioFields.HASHESCANEIG);
        ocults.remove(TransaccioFields.FITXERESCANEJATID);
        ocults.remove(TransaccioFields.HASHFIRMA);
        ocults.remove(TransaccioFields.FITXERSIGNATURAID);
    }

    protected void addAcctionButton(HttpServletRequest request, TransaccioFilterForm fform) {
        fform.addAdditionalButton(new AdditionalButton(
                "fas fa-redo", "transaccionssensehashdefitxer.boto", "javascript:submitTo('transaccio', '"
                        + request.getContextPath() + getContextWeb() + "/regenerartransaccionssensehashdefitxer')",
                AdditionalButtonStyle.WARNING));
    }

    /**
     * Transaccions finalitzades OK sense Hash de Fitxer
     * @param request
     * @return
     */
    @RequestMapping(value = "/regenerartransaccionssensehashdefitxer", method = RequestMethod.POST)
    public String regenerarTransaccionsSenseHashDeFitxer(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute TransaccioFilterForm filterForm) {
        try {
            

            String[] seleccionats = filterForm.getSelectedItems();

            if (seleccionats != null && seleccionats.length != 0) {
                

                List<Long> transacctionsID = new ArrayList<Long>();

                for (int i = 0; i < seleccionats.length; i++) {
                    transacctionsID.add(stringToPK(seleccionats[i]));
                }

                List<Transaccio> transaccions = transaccioLogicaEjb
                        .regenerarTransaccionsSenseHashDeFitxer(transacctionsID);

                // XYZ ZZZ TRA
                HtmlUtils.saveMessageSuccess(request,
                        "S´han regenerat els Hash de Fitxers de " + transaccions.size() + " transaccions.");
            }

        } catch (I18NException i18ne) {
            // XYZ ZZZ TRA
            String msg = "Error revisant Transaccions sense Hash de Fitxer: " + I18NUtils.getMessage(i18ne);
            log.error(msg, i18ne);
            HtmlUtils.saveMessageError(request, msg);

        } catch (Exception e) {
            // XYZ ZZZ TRA
            String msg = "Error no controlat revisant Transaccions Sense Hash de Fitxer: " + e.getMessage();
            log.error(msg, e);
            HtmlUtils.saveMessageError(request, msg);
        }

        return "redirect:" + getContextWeb() + "/list";

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
    public List<StringKeyValue> getReferenceListForUsuariAplicacioId(HttpServletRequest request, ModelAndView mav,
            TransaccioFilterForm transaccioFilterForm, List<Transaccio> list,
            Map<Field<?>, GroupByItem> _groupByItemsMap, Where where) throws I18NException {
        if (transaccioFilterForm.isHiddenField(USUARIAPLICACIOID)
                && !transaccioFilterForm.isGroupByField(USUARIAPLICACIOID)) {
            return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
        }

        Where _w = null;
        List<StringKeyValue> l = getReferenceListForUsuariAplicacioId(request, mav, Where.AND(where, _w));

        if (l.size() != list.size()) {
            Map<String, String> map = org.fundaciobit.genapp.common.utils.Utils.listToMap(l);
            for (Transaccio transaccio : list) {

                final String key = String.valueOf(transaccio.getUsuariAplicacioId());

                String value = map.get(key);

                if (value == null) {
                    l.add(new StringKeyValue(key, key));
                }
            }

        }

        return l;
    }

    @Override
    public List<StringKeyValue> getReferenceListForUsuariAplicacioId(HttpServletRequest request, ModelAndView mav,
            Where where) throws I18NException {

        SelectMultipleKeyValue<Long> select = new SelectMultipleKeyValue<Long>(
                UsuariAplicacioFields.USUARIAPLICACIOID.select, UsuariAplicacioFields.USERNAME.select);
        List<KeyValue<Long>> list = this.usuariAplicacioEjb.executeQuery(select, where);
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        for (KeyValue<Long> keyValue : list) {
            String value = keyValue.getValue();
            String key = String.valueOf(keyValue.getKey());
            __tmp.add(new StringKeyValue(key, (value == null || (value.trim().length() == 0)) ? key : value));
        }

        return __tmp;
    }

}
