package es.caib.digitalib.back.controller.admin.grafiquesestadistica;


/**
 * 
 * @author anadal (u80067)
 * 11 jun 2026 9:55:42
 */
public enum DateRange {
    DIA(1), MES(2), ANY(3);
    
    private final int code;
    
    DateRange(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
    
    public static DateRange fromCode(int code) {
        for (DateRange range : DateRange.values()) {
            if (range.getCode() == code) {
                return range;
            }
        }
        throw new IllegalArgumentException("Codi de rang de data no vàlid: " + code);
    }
}
