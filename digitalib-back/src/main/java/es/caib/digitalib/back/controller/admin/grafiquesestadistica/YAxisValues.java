package es.caib.digitalib.back.controller.admin.grafiquesestadistica;

/**
 * Valors d'un eix Y (hereta la definició i afegeix l'array de valors).
 * @author anadal (u80067)
 * 11 jun 2026 9:58:55
 */
public class YAxisValues extends YAxisDefinition {

    protected Double[] values;

    public YAxisValues() {
    }

    public YAxisValues(int code, String name, String color, Double[] values) {
        super(code, name, color);
        this.values = values;
    }

    public Double[] getValues() {
        return values;
    }

    public void setValues(Double[] values) {
        this.values = values;
    }
}
