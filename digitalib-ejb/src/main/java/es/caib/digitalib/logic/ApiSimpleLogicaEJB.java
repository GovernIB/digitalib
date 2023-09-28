package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;



import es.caib.digitalib.ejb.ApiSimpleEJB;

import es.caib.digitalib.persistence.ApiSimpleJPA;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "ApiSimpleLogicaEJB")

@RunAs("DIB_ADMIN")
public class ApiSimpleLogicaEJB extends ApiSimpleEJB implements ApiSimpleLogicaService {

    @Override
    @PermitAll
    public ApiSimpleJPA findByPrimaryKey(Long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }

}
