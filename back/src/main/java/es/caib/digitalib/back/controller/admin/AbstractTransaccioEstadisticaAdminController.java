package es.caib.digitalib.back.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.KeyValue;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.SelectMultipleKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.TransaccioQueryPath;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.model.fields.UsuariPersonaQueryPath;

/**
 * 
 * @author anadal(u80067)
 */
public abstract class AbstractTransaccioEstadisticaAdminController
        extends AbstractTransaccioAdminController {
    

    public static final int CONF_GRUP_COLUMN = 3;

    public static final int FITXER_NOM_COLUMN = 4;

    public static final int FITXER_SIZE_COLUMN = 5;

    public String getTipus() {
        return isUtilitzatPerAplicacio() ? "aplicacio" : "persona";
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "TransaccioAdmin_Estadistica_FilterForm_" + getTipus();
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
            filterForm.setEntityNameCode("transaccio.estadistica");
            filterForm.setEntityNameCodePlural("transaccio.estadistica.plural");

            filterForm.setEditButtonVisible(false);

            Set<Field<?>> hiddens = filterForm.getHiddenFields();

            hiddens.addAll(Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));

            hiddens.remove(ESTATCODI);
            hiddens.remove(TRANSACCIOID);
            hiddens.remove(SIGNPARAMFUNCIONARIDIR3);
            hiddens.remove(FUNCIONARIUSERNAME);

            if (isUtilitzatPerAplicacio()) {
                hiddens.remove(USUARIAPLICACIOID);
                hiddens.remove(TRANSACCIOMULTIPLEID);
            } else {
                hiddens.remove(USUARIPERSONAID);
                
            }
            // hiddens.remove(TransaccioFields.FITXERSIGNATURAID);
            // Fitxer Nom - Fitxer Tamany
            hiddens.remove(INFOSCANPIXELTYPE);
            hiddens.remove(INFOSCANRESOLUCIOPPP);
            hiddens.remove(INFOSCANPAPERSIZE);
            // hiddens.remove(INFOSCANDATACAPTURA);
            hiddens.remove(DATAINICI);
            hiddens.remove(PERFILID);

            filterForm.setOrderBy(DATAINICI.fullName);
            filterForm.setOrderAsc(false);

            // filterForm.setDefaultOrderBy(null);

            //filterForm.getGroupByFields().remove(DATAINICI);
            filterForm.getGroupByFields().remove(DATAFI);
            filterForm.getGroupByFields().remove(PERFILID);
            

            filterForm.getGroupByFields().remove(INFOSCANPAPERSIZE);
            filterForm.getGroupByFields().remove(INFOSCANPIXELTYPE);
            filterForm.getGroupByFields().remove(INFOSCANRESOLUCIOPPP);

            List<Field<?>> filterByFields = new ArrayList<Field<?>>();
            filterByFields.add(DATAINICI);
            filterByFields.add(ESTATCODI);
            filterByFields.add(FUNCIONARIUSERNAME);
            filterByFields.add(ESTATMISSATGE);
            

            
            /*
             * if (isUtilitzatPerAplicacio()) { filterByFields.add(USUARIAPLICACIOID); } else {
             * filterByFields.add(USUARIPERSONAID); }
             */

            filterForm.setFilterByFields(filterByFields);


            
            

            

            if (!isUtilitzatPerAplicacio()) {
                AdditionalField<Long, String> adfield4 = new AdditionalField<Long, String>();
                adfield4.setPosition(CONF_GRUP_COLUMN);
                adfield4.setEscapeXml(false);
                adfield4.setCodeName(ConfiguracioGrupFields._TABLE_MODEL + "."
                        + ConfiguracioGrupFields._TABLE_MODEL);
                // Els valors s'ompliran al mètode postList()
                adfield4.setValueMap(new HashMap<Long, String>());

                filterForm.addAdditionalField(adfield4);
            }

            AdditionalField<Long, String> adfield5 = new AdditionalField<Long, String>();
            adfield5.setPosition(FITXER_NOM_COLUMN);
            adfield5.setValueField(new TransaccioQueryPath().FITXERSIGNATURA().NOM());
            adfield5.setEscapeXml(false);
            adfield5.setCodeName(FITXERSIGNATURAID.fullName);
            adfield5.setOrderBy(new TransaccioQueryPath().FITXERSIGNATURA().NOM());

            filterForm.addAdditionalField(adfield5);
            
          
            

            AdditionalField<Long, Long> adfield6 = new AdditionalField<Long, Long>();
            adfield6.setPosition(FITXER_SIZE_COLUMN);
            adfield6.setValueField(new TransaccioQueryPath().FITXERSIGNATURA().TAMANY());
            adfield6.setEscapeXml(false);
            adfield6.setCodeName("=Bytes");
            adfield6.setOrderBy(new TransaccioQueryPath().FITXERSIGNATURA().TAMANY());

            filterForm.addAdditionalField(adfield6);

            String subtitle = "=EXPIRED: -3 | CANCELLED: -2 | ERROR: -1 | REQUESTED_ID: 0 | IN_PROGRESS: 1 | OK: 2";
            filterForm.setSubTitleCode(subtitle);

        }

        log.info(" ORDER BY: " + filterForm.getOrderBy());

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
    public void postList(HttpServletRequest request, ModelAndView mav,
            TransaccioFilterForm filterForm, List<Transaccio> list) throws I18NException {

        filterForm.getAdditionalButtonsByPK().clear();

        postListNomPersonaAplicacio(request, filterForm, list, isAdmin());

        if (!isUtilitzatPerAplicacio()) {
            AdditionalField<Long, String> af = (AdditionalField<Long, String>) filterForm
                    .getAdditionalField(CONF_GRUP_COLUMN);
            Map<Long, String> configGrup = af.getValueMap();

            configGrup.clear();

            SelectMultipleKeyValue<Long> select = new SelectMultipleKeyValue<Long>(
                    UsuariPersonaFields.USUARIPERSONAID.select,
                    new UsuariPersonaQueryPath().CONFIGURACIOGRUP().NOM().select);

            List<Long> usuaris = new ArrayList<Long>();

            for (Transaccio transaccio : list) {
                usuaris.add(transaccio.getUsuariPersonaId());
            }

            List<KeyValue<Long>> listKV = this.usuariPersonaEjb.executeQuery(select,
                    UsuariPersonaFields.USUARIPERSONAID.in(usuaris));

            Map<Long, String> usuarisMap = listToMap(listKV);

            for (Transaccio t : list) {

                String nomConfGrup = usuarisMap.get(t.getUsuariPersonaId());

                if (nomConfGrup != null) {
                    configGrup.put(t.getTransaccioID(), nomConfGrup);
                }
            }

        }
        
        boolean showErrorColumn = false;
        for (Transaccio t : list) {

            if (t.getEstatCodi() == ScanWebSimpleStatus.STATUS_FINAL_ERROR) {
                // Afegir Columna Error
                showErrorColumn = true;
                break;
            }
        }
        
        
        if (showErrorColumn) {
            filterForm.getHiddenFields().remove(ESTATMISSATGE);
        } else {
            filterForm.getHiddenFields().add(ESTATMISSATGE);
        }
        
        

    }

    public static <T> Map<T, String> listToMap(List<KeyValue<T>> list) {
        if (list == null) {
            return null;
        }

        Map<T, String> map = new HashMap<T, String>();
        for (KeyValue<T> stringKeyValue : list) {
            map.put(stringKeyValue.key, stringKeyValue.value);
        }

        return map;
    }

    @Override
    public List<StringKeyValue> getReferenceListForTransaccioMultipleID(
            HttpServletRequest request, ModelAndView mav, Where where) throws I18NException {

        List<Long> ids = transaccioEjb.executeQuery(TRANSACCIOMULTIPLEID, where);

        List<StringKeyValue> list = new ArrayList<StringKeyValue>();

        for (Long id : ids) {
            list.add(new StringKeyValue(String.valueOf(id), String.valueOf(id)));
        }

        return list;
    }

    @Override
    public List<StringKeyValue> getReferenceListForPerfilID(HttpServletRequest request,
            ModelAndView mav, Where where) throws I18NException {

        List<StringKeyValue> kvList = perfilRefList.getReferenceList(PerfilFields.PERFILID,
                where);

        for (StringKeyValue kv : kvList) {
            String v = kv.getValue();
            int pos = v.lastIndexOf('-');
            if (pos != -1) {
                kv.setValue(v.substring(0, pos));
            }
        }

        return kvList;

    }

}
