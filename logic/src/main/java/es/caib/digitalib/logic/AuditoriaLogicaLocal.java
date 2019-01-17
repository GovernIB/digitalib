package es.caib.digitalib.logic;

import javax.ejb.Local;



import es.caib.digitalib.ejb.AuditoriaLocal;
import es.caib.digitalib.model.entity.Transaccio;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface AuditoriaLogicaLocal extends AuditoriaLocal {

  public static final String JNDI_NAME = "digitalib/AuditoriaLogicaEJB/local";
  
  public String[] audita(TransaccioPublicLogicaLocal transaccioEjb,
      long transaccioID, final String msg,
      final String additionalInfo, final int auditType, final boolean isApp);

  public String[] audita(Transaccio transaccio, final String msg,
      final String additionalInfo, final int auditType, final boolean isApp);
  
  public void audita(Transaccio transaccio, final boolean isApp, final String msg,
      final String additionalInfo, final int auditType, String usernameApp,
      String usernamePerson);

}
