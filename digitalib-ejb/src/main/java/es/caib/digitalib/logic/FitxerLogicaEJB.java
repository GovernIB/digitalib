package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;


import es.caib.digitalib.ejb.FitxerEJB;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.commons.utils.Constants;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "FitxerLogicaEJB")

@RunAs( Constants.DIB_ADMIN) // "DIB_ADMIN"
public class FitxerLogicaEJB extends FitxerEJB implements FitxerLogicaService {

  @Override
  @PermitAll
  public Fitxer create(Fitxer instance) throws I18NException { 
    return super.create(instance);
  }

}
