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
public interface FitxerLogicaLocal extends es.caib.digitalib.ejb.FitxerLocal {
  
  public static final String JNDI_NAME = "digitalib/FitxerLogicaEJB/local";

  @Override
  public Fitxer create(Fitxer instance) throws I18NException;

}
