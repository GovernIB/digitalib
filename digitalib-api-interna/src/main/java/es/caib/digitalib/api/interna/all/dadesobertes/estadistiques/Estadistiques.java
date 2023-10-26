package es.caib.digitalib.api.interna.all.dadesobertes.estadistiques;

import java.util.List;


/**
 * 
 * @author anadal (u80067)
 *
 */
public class Estadistiques {

    public Estadistiques(List<EstadistiquesTransaccio> resultat) {
        super();
        this.resultat = resultat;
    }

    public Estadistiques() {
        super();
    }

    protected List<EstadistiquesTransaccio> resultat;

    public List<EstadistiquesTransaccio> getResultat() {
        return resultat;
    }

    public void setResultat(List<EstadistiquesTransaccio> resultat) {
        this.resultat = resultat;
    }

}
