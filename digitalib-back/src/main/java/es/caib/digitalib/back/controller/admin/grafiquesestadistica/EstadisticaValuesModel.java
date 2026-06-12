package es.caib.digitalib.back.controller.admin.grafiquesestadistica;

import java.util.List;

/**
 * Model que conté les etiquetes de l'eix X i les definicions/valors de l'eix Y.
 * 
 * @author anadal (u80067)
 * 11 jun 2026 7:39:04
 */
public class EstadisticaValuesModel {

    protected List<String> xlabels;

    protected List<YAxisValues> yDefinitionsWithValues;


    
   
    public List<String> getXlabels() {
        return xlabels;
    }

    public void setXlabels(List<String> xlabels) {
        this.xlabels = xlabels;
    }

    public List<YAxisValues> getyDefinitionsWithValues() {
        return yDefinitionsWithValues;
    }

    public void setyDefinitionsWithValues(List<YAxisValues> yDefinitionsWithValues) {
        this.yDefinitionsWithValues = yDefinitionsWithValues;
    }

}