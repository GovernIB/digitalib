package es.caib.digitalib.back.controller.admin.grafiquesestadistica;


/**
 *   
      Definició d'un eix Y (codi, nom i color).
     
 * @author anadal (u80067)
 * 11 jun 2026 9:57:15
 */
public class YAxisDefinition {

    protected int code;
    protected String name;
    protected String color;

    public YAxisDefinition() {
    }

    public YAxisDefinition(int code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
