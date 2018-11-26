package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.FitxerEJB;
import es.caib.digitalib.model.entity.Fitxer;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "FitxerLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class FitxerLogicaEJB extends FitxerEJB implements FitxerLogicaLocal {

  @Override
  @PermitAll
  public Fitxer create(Fitxer instance) throws I18NException {
    return super.create(instance);
  }

}
