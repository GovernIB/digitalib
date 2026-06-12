package es.caib.digitalib.back.controller.admin.grafiquesestadistica;

/**
 * 
 * @author anadal (u80067)
 * 11 jun 2026 7:38:45
 */
public class EstadisticaModel {

    protected String title;
    protected String subtitle;
    
    protected EstadisticaFilterModel filter;
    
    protected EstadisticaValuesModel values;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public EstadisticaFilterModel getFilter() {
        return filter;
    }

    public void setFilter(EstadisticaFilterModel filter) {
        this.filter = filter;
    }

    public EstadisticaValuesModel getValues() {
        return values;
    }

    public void setValues(EstadisticaValuesModel values) {
        this.values = values;
    }
    
    
    
    
}
