package es.caib.digitalib.api.interna.all.versio.v1;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Informació de la Versió
 *
 * @author anadal
 */

@Schema(description = "Informació de la Versió de DigitalIB")
public class Versio {

    private String versio;

    private String language;

    private boolean caib;

    public Versio() {
        super();
    }

    public String getVersio() {
        return versio;
    }

    public void setVersio(String versio) {
        this.versio = versio;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isCaib() {
        return caib;
    }

    public void setCaib(boolean caib) {
        this.caib = caib;
    }

    @Override
    public String toString() {
        return "Versio: " + versio;
    }

}
