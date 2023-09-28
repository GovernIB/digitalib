package es.caib.digitalib.logic;

import javax.ejb.Local;



import es.caib.digitalib.ejb.AuditoriaService;
import es.caib.digitalib.model.entity.Transaccio;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface AuditoriaLogicaService extends AuditoriaService {

  public static final String JNDI_NAME = "java:app/digitalib-ejb/AuditoriaLogicaEJB";
  
  public String[] audita(TransaccioPublicLogicaService transaccioEjb,
      long transaccioID, final String msg,
      final String additionalInfo, final int auditType, final boolean isApp);

  public String[] audita(Transaccio transaccio, final String msg,
      final String additionalInfo, final int auditType, final boolean isApp);
  
  public Long audita(Transaccio transaccio, final boolean isApp, final String msg,
      final String additionalInfo, final int auditType, String usernameApp,
      String usernamePerson);

}
