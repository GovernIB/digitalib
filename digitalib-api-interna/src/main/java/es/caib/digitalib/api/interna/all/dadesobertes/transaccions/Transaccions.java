package es.caib.digitalib.api.interna.all.dadesobertes.transaccions;

import java.util.List;


/**
 * 
 * @author anadal (u80067)
 *
 */
public class Transaccions {

    public Transaccions(List<TransaccioInfo> resultat) {
        super();
        this.resultat = resultat;
    }

    public Transaccions() {
        super();
    }

    protected List<TransaccioInfo> resultat;

    public List<TransaccioInfo> getResultat() {
        return resultat;
    }

    public void setResultat(List<TransaccioInfo> resultat) {
        this.resultat = resultat;
    }

}
