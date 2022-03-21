package es.caib.digitalib.back.controller.scanwebsimple.estadistiques;

import java.util.List;


/**
 * 
 * @author anadal (u80067)
 *
 */
public class EstadistiquesRest {

    public EstadistiquesRest(List<TransaccioRest> resultat) {
        super();
        this.resultat = resultat;
    }

    public EstadistiquesRest() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected List<TransaccioRest> resultat;

    public List<TransaccioRest> getResultat() {
        return resultat;
    }

    public void setResultat(List<TransaccioRest> resultat) {
        this.resultat = resultat;
    }

}
