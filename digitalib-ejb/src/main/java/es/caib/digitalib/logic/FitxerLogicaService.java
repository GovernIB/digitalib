package es.caib.digitalib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.model.entity.Fitxer;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface FitxerLogicaService extends es.caib.digitalib.ejb.FitxerService {
  
  public static final String JNDI_NAME = "java:app/digitalib-ejb/FitxerLogicaEJB";

  @Override
  public Fitxer create(Fitxer instance) throws I18NException;

}
