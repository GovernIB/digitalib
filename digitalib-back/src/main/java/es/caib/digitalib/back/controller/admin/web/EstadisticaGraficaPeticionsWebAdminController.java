package es.caib.digitalib.back.controller.admin.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.fundaciobit.genapp.common.query.SelectDistinct;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Columns;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Values;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.genapp.common.web.tiles.Tile;
import org.fundaciobit.genapp.common.web.tiles.TileAttribute;
import org.fundaciobit.genapp.common.web.tiles.TileType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caib.digitalib.back.controller.admin.grafiquesestadistica.AbstractEstadisticaGraficaController;
import es.caib.digitalib.back.controller.admin.grafiquesestadistica.DateRange;
import es.caib.digitalib.back.controller.admin.grafiquesestadistica.EstadisticaFilterModel;
import es.caib.digitalib.back.controller.admin.grafiquesestadistica.EstadisticaValuesModel;
import es.caib.digitalib.back.controller.admin.grafiquesestadistica.FilterModelItem;
import es.caib.digitalib.back.controller.admin.grafiquesestadistica.YAxisDefinition;
import es.caib.digitalib.back.controller.admin.grafiquesestadistica.YAxisValues;
import es.caib.digitalib.back.utils.Tab;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.logic.UsuariPersonaLogicaService;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;

/**
 * Controlador de gràfiques de consultes a EvidènciesIB.
 * 
 * @author anadal (u80067)
 * 29 may 2026 11:05:39
 */
@MenuOption(
        labelCode = "=Gràfiques de transaccions a DigitalIB",
        order = 100,
        group = Tab.MENU_ADMIN,
        baseLink = "/admin/estadisticagraficaweb/",
        relativeLink = "/",
        addSeparatorBefore = true)
@Tile(
        name = "estadisticaAdminDigitalIB",
        extendsTile = Tab.MENU_ADMIN,
        // Els següents atributs no són necessaris si heredes aquesta classe
        contentJsp = "/WEB-INF/jsp/admin/estadistica.jsp",
        type = TileType.WEBDB_FORM,
        attributes = { @TileAttribute(name = "titol", value = "estadistica.estadistica") })
@Controller
@RequestMapping(value = "/admin/estadisticagraficaweb")
public class EstadisticaGraficaPeticionsWebAdminController extends AbstractEstadisticaGraficaController {

    // Codis dels eixos Y
    protected static final int Y_AXIS_EN_PROCES = 0;
    protected static final int Y_AXIS_CANCEL = 1;
    protected static final int Y_AXIS_OK = 2;
    protected static final int Y_AXIS_ERROR = 3;

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @EJB(mappedName = UsuariPersonaLogicaService.JNDI_NAME)
    protected UsuariPersonaLogicaService usuariPersonaLogicaEjb;

    @Override
    public List<YAxisDefinition> getAllYAxisDefinition() {
        // Definir dinàmicament els eixos Y amb el seu color
        List<YAxisDefinition> defs = new ArrayList<>();
        defs.add(new YAxisDefinition(Y_AXIS_EN_PROCES, "Peticions En Procés", "rgba(0, 0, 0, 0.8)"));
        defs.add(new YAxisDefinition(Y_AXIS_CANCEL, "Peticions Cancel·lades", "rgba(170, 170, 170, 0.8)"));
        defs.add(new YAxisDefinition(Y_AXIS_OK, "Peticions Finalitzades", "rgba(68, 219, 68, 0.8)"));
        defs.add(new YAxisDefinition(Y_AXIS_ERROR, "Peticions amb Error", "rgba(242, 50, 52, 0.8)"));
        return defs;
    }

    @Override
    public Where getAdditionalWhere(EstadisticaFilterModel filter) {
        Where where = TransaccioFields.USUARIPERSONAID.isNotNull();

        List<FilterModelItem> filtres = filter.getFilters();

        if (filtres != null && filtres.size() > 0) {
            for (FilterModelItem item : filtres) {
                if ("usuariPersonaId".equals(item.getName()) && item.getValue() != null) {
                    where = Where.AND(where, TransaccioFields.USUARIPERSONAID.equal(Long.valueOf(item.getValue())));
                }
            }
        }

        return where;
    }

    @Override
    public EstadisticaValuesModel getEstadistiques(int codeYAxis, EstadisticaFilterModel filter, Date from, Date to)
            throws Exception {

        try {
            // Determinar quins codis d'estat corresponen a aquest eix Y
            List<Integer> estatCodis;
            switch (codeYAxis) {
                case Y_AXIS_EN_PROCES:
                    estatCodis = List.of(Constants.TRANSACCIO_ESTAT_CODI_ID, Constants.TRANSACCIO_ESTAT_CODI_ENPROGRES);
                break;

                case Y_AXIS_CANCEL:
                    estatCodis = List.of(Constants.TRANSACCIO_ESTAT_CODI_CANCELAT);
                break;

                case Y_AXIS_OK:
                    estatCodis = List.of(Constants.TRANSACCIO_ESTAT_CODI_OK);
                break;
                case Y_AXIS_ERROR:
                    estatCodis = List.of(Constants.TRANSACCIO_ESTAT_CODI_EXPIRAT,
                            Constants.TRANSACCIO_ESTAT_CODI_ERROR);
                break;
                default:
                    return null;
            }

            // Obtenir la definició de l'eix Y
            YAxisDefinition yDef = getAllYAxisDefinition().stream().filter(d -> d.getCode() == codeYAxis).findFirst()
                    .orElse(null);
            if (yDef == null) {
                return null;
            }

            DateRange rang = filter.getRangCode();
            List<String> xlabels = new ArrayList<>();
            List<Double> valors = new ArrayList<>();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(from);

            Where where = Where.AND(TransaccioFields.ESTATCODI.in(estatCodis), getAdditionalWhere(filter));

            switch (rang) {
                case ANY: {
                    // 12 mesos
                    for (int i = 0; i < 12; i++) {
                        xlabels.add(MESOS[i]);
                        calendar.set(Calendar.MONTH, i);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        calendar.set(Calendar.HOUR_OF_DAY, 0);
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 0);
                        Timestamp mesFrom = new Timestamp(calendar.getTimeInMillis());

                        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                        calendar.set(Calendar.HOUR_OF_DAY, 23);
                        calendar.set(Calendar.MINUTE, 59);
                        calendar.set(Calendar.SECOND, 59);
                        Timestamp mesTo = new Timestamp(calendar.getTimeInMillis());

                        Where wData = TransaccioFields.DATAINICI.between(mesFrom, mesTo);
                        Long count = transaccioLogicaEjb.count(Where.AND(wData, where));
                        valors.add(count == null ? 0.0 : count.doubleValue());
                    }
                    break;
                }
                case MES: {
                    int darrerDia = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                    for (int i = 1; i <= darrerDia; i++) {
                        xlabels.add(String.valueOf(i));
                        calendar.set(Calendar.DAY_OF_MONTH, i);
                        calendar.set(Calendar.HOUR_OF_DAY, 0);
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 0);
                        Timestamp diaFrom = new Timestamp(calendar.getTimeInMillis());

                        calendar.set(Calendar.HOUR_OF_DAY, 23);
                        calendar.set(Calendar.MINUTE, 59);
                        calendar.set(Calendar.SECOND, 59);
                        Timestamp diaTo = new Timestamp(calendar.getTimeInMillis());

                        Where wData = TransaccioFields.DATAINICI.between(diaFrom, diaTo);
                        Long count = transaccioLogicaEjb.count(Where.AND(wData, where));
                        valors.add(count == null ? 0.0 : count.doubleValue());
                    }
                    break;
                }
                case DIA: {
                    for (int i = 0; i < 24; i++) {
                        xlabels.add(String.format("%02d:00", i));
                        calendar.set(Calendar.HOUR_OF_DAY, i);
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 0);
                        Timestamp horaFrom = new Timestamp(calendar.getTimeInMillis());

                        calendar.set(Calendar.MINUTE, 59);
                        calendar.set(Calendar.SECOND, 59);
                        Timestamp horaTo = new Timestamp(calendar.getTimeInMillis());

                        Where wData = TransaccioFields.DATAINICI.between(horaFrom, horaTo);
                        Long count = transaccioLogicaEjb.count(Where.AND(wData, where));
                        valors.add(count == null ? 0.0 : count.doubleValue());
                    }
                    break;
                }
            }

            // Construir el resultat
            EstadisticaValuesModel model = new EstadisticaValuesModel();
            model.setXlabels(xlabels);

            YAxisValues yValues = new YAxisValues(yDef.getCode(), yDef.getName(), yDef.getColor(),
                    valors.toArray(new Double[0]));
            model.setyDefinitionsWithValues(List.of(yValues));

            return model;

        } catch (Exception e) {
            log.error("Error obtenint estadístiques per codeYAxis=" + codeYAxis, e);
            return null;
        }
    }

    @Override
    public List<FilterModelItem> getAvailableFilters(Timestamp from, Timestamp to) throws Exception {

        FilterModelItem item = new FilterModelItem();
        item.setLabel("Usuari Persona");
        item.setValue(null);
        item.setName("usuariPersonaId");

        Where wFromTo = Where.AND(TransaccioFields.DATAINICI.between(from, to),
                TransaccioFields.USUARIPERSONAID.isNotNull());

        Map<String, String> personaIdToUsername = new HashMap<String, String>();
        {

            // Llegim les persones que han fet transaccions que han fet peticions en aquesta dates
            List<Long> persones = transaccioLogicaEjb.executeQuery(
                    new SelectDistinct<Long>(TransaccioFields.USUARIPERSONAID),
                    Where.AND(TransaccioFields.USUARIPERSONAID.isNotNull(), wFromTo));
            // Necessitam un MAp de ID aplicació cap a username d'aplicació

            List<Select2Values<Long, String>> llistat = usuariPersonaLogicaEjb
                    .executeQuery(
                            new Select2Columns<Long, String>(UsuariPersonaFields.USUARIPERSONAID.select,
                                    UsuariPersonaFields.USERNAME.select),
                            UsuariPersonaFields.USUARIPERSONAID.in(persones));

            for (Select2Values<Long, String> v : llistat) {
                personaIdToUsername.put(String.valueOf(v.getValue1()), v.getValue2());
            }

            item.setOptions(personaIdToUsername);

        }

        return List.of(item);
    }

    @Override
    public String getTile() {
        return "estadisticagraficaAdminDigitalIB";
    }

    @Override
    public String getTitle() {
        return "Gràfiques de transaccions de Persones";
    }

}
