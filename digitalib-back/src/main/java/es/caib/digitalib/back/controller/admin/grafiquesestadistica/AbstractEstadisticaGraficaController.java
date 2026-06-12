package es.caib.digitalib.back.controller.admin.grafiquesestadistica;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.fundaciobit.genapp.common.query.Where;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.commons.utils.Constants;

/**
 * Controlador abstracte per a les estadístiques gràfiques d'ADEN.
 * Utilitza els mètodes abstractes getAllYAxisDefinition() i getEstadistiques()
 * per obtenir de forma dinàmica les definicions dels eixos Y i els seus valors.
 * Passa un bean EstadisticaModel com a model únic cap al JSP.
 * 
 * @author anadal (u80067)
 * 29 may 2026 11:36:13
 */
public abstract class AbstractEstadisticaGraficaController implements Constants {

    protected Logger log = Logger.getLogger(this.getClass());

    protected static final String[] MESOS = new String[] { "Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol",
            "Agost", "Setembre", "Octubre", "Novembre", "Desembre" };

    /**
     * Retorna totes les definicions dels eixos Y disponibles per a aquesta gràfica.
     */
    public abstract List<YAxisDefinition> getAllYAxisDefinition();

    /**
     * Retorna els valors d'un eix Y concret donat el filtre i el rang de dates.
     * L'array values ha de tenir la mateixa longitud que xlabels.
     */
    public abstract EstadisticaValuesModel getEstadistiques(int codeYAxis, EstadisticaFilterModel filter, Date from, Date to) throws Exception;

    /**
     * Retorna els filtres addicionals disponibles (aplicació, grup, etc.).
     * Les subclasses han d'implementar per definir els filtres específics.
     */
    public abstract List<FilterModelItem> getAvailableFilters(Timestamp from, Timestamp to) throws Exception;

    /**
     * Retorna el nom del tile/vista JSP.
     */
    public abstract String getTile();

    /**
     * Retorna el títol principal de la pàgina d'estadístiques.
     */
    public abstract String getTitle();
    
    public abstract Where getAdditionalWhere(EstadisticaFilterModel filter);

    @RequestMapping(value = "/")
    @GET
    @POST
    public ModelAndView index(
            @RequestParam(value = "rang", required = false) Integer rangCode,
            @RequestParam(value = "date", required = false) String dateParam,
            HttpServletRequest request) throws Exception {

        ModelAndView mav = new ModelAndView(getTile());

        // Determinar el rang de dates (per defecte MES)
        if (rangCode == null) {
            rangCode = DateRange.MES.getCode();
        }

        DateRange estadisticaRang = DateRange.fromCode(rangCode);
        LocalDate selectedDate = (dateParam == null || dateParam.isBlank()) ? LocalDate.now()
                : LocalDate.parse(dateParam);
        int any = selectedDate.getYear();
        int mes = selectedDate.getMonthValue();
        int dia = selectedDate.getDayOfMonth();

        // Construir el filtre
        EstadisticaFilterModel filter = new EstadisticaFilterModel();
        filter.setDate(new java.sql.Timestamp(java.sql.Date.valueOf(selectedDate).getTime()));
        filter.setSelectedDate(selectedDate.toString());
        filter.setRangCode(estadisticaRang);

        // Obtenir filtres disponibles es farà després de calcular from/to

        // Calcular rang de dates (from/to) global i descripció del subtítol
        Timestamp from;
        Timestamp to;
        String subtitle;

        switch (estadisticaRang) {
            case ANY: {
                subtitle = "per l'any " + any;
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, any);
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                from = new Timestamp(calendar.getTimeInMillis());

                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                calendar.set(Calendar.DAY_OF_MONTH, 31);
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                to = new Timestamp(calendar.getTimeInMillis());
                break;
            }
            case MES: {
                subtitle = "pel mes de " + MESOS[mes - 1] + " de " + any;
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, any);
                calendar.set(Calendar.MONTH, mes - 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                from = new Timestamp(calendar.getTimeInMillis());

                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                to = new Timestamp(calendar.getTimeInMillis());
                break;
            }
            case DIA: {
                subtitle = "pel dia " + dia + " de " + MESOS[mes - 1] + " de " + any;
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, any);
                calendar.set(Calendar.MONTH, mes - 1);
                calendar.set(Calendar.DAY_OF_MONTH, dia);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                from = new Timestamp(calendar.getTimeInMillis());

                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                to = new Timestamp(calendar.getTimeInMillis());
                break;
            }
            default:
                throw new IllegalArgumentException("Rang no suportat: " + estadisticaRang);
        }

        // Obtenir filtres disponibles i omplir els seus valors des dels paràmetres de la request
        List<FilterModelItem> availableFilters = getAvailableFilters(from, to);
        if (availableFilters != null) {
            for (FilterModelItem fm : availableFilters) {
                String paramValue = request.getParameter(fm.getName());
                if (paramValue != null && !paramValue.isBlank()) {
                    fm.setValue(paramValue);
                }
            }
        }
        filter.setFilters(availableFilters);

        // Obtenir les definicions dels eixos Y
        List<YAxisDefinition> yAxisDefinitions = getAllYAxisDefinition();

        // Per cada definició d'eix Y, cridar getEstadistiques per obtenir els valors
        EstadisticaValuesModel resultatValues = null;
        List<YAxisValues> totsElsValors = new ArrayList<>();

        for (YAxisDefinition yDef : yAxisDefinitions) {
            EstadisticaValuesModel partial = getEstadistiques(yDef.getCode(), filter, from, to);
            if (partial != null) {
                // Agafem les xlabels del primer resultat
                if (resultatValues == null) {
                    resultatValues = partial;
                }
                // Recollir els YAxisValues
                if (partial.getyDefinitionsWithValues() != null) {
                    totsElsValors.addAll(partial.getyDefinitionsWithValues());
                }
            }
        }

        // Construir el model de valors final
        if (resultatValues == null) {
            resultatValues = new EstadisticaValuesModel();
            resultatValues.setXlabels(new ArrayList<>());
        }
        resultatValues.setyDefinitionsWithValues(totsElsValors);

        // Construir el bean EstadisticaModel complet
        EstadisticaModel model = new EstadisticaModel();
        model.setTitle(getTitle());
        model.setSubtitle(subtitle);
        model.setFilter(filter);
        model.setValues(resultatValues);

        // Passar el bean com a atribut únic al JSP
        mav.addObject("model", model);

        return mav;
    }

}