package es.caib.digitalib.back.controller.admin.grafiquesestadistica;

import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * @author anadal (u80067)
 * 11 jun 2026 7:38:27
 */
public class EstadisticaFilterModel {

    

    protected Timestamp date;

    /** Data seleccionada en format ISO (yyyy-MM-dd) per al camp input type="date" del JSP */
    protected String selectedDate;

    /** Això indica si l'agrupació és per dia (hores), mes(dies) o any (mesos) */
    protected DateRange rangCode;

    protected List<FilterModelItem> filters;

    


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<FilterModelItem> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterModelItem> filters) {
        this.filters = filters;
    }

    public DateRange getRangCode() {
        return rangCode;
    }

    public void setRangCode(DateRange rangCode) {
        this.rangCode = rangCode;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

}
