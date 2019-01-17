package es.caib.digitalib.logic;

import java.sql.Timestamp;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.AuditoriaEJB;
import es.caib.digitalib.model.bean.AuditoriaBean;
import es.caib.digitalib.model.entity.Auditoria;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "AuditoriaLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class AuditoriaLogicaEJB extends AuditoriaEJB implements AuditoriaLogicaLocal {

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariPersonaLocal usuariPersonaEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioLocal usuariAplicacioEjb;


  @Override
  public String[] audita(TransaccioPublicLogicaLocal transaccioEjb, long transaccioID, final String msg, final String additionalInfo,
      final int auditType, final boolean isApp) {

    Transaccio transaccio = transaccioEjb.findByPrimaryKey(transaccioID);

    return audita(transaccio, msg, additionalInfo, auditType, isApp);
  }

  @Override
  public String[] audita(Transaccio transaccio, final String msg, final String additionalInfo,
      final int auditType, final boolean isApp) {
    String usrApp = null;

    Long idApp = transaccio.getUsuariAplicacioId();
    if (idApp != null) {
      try {
        usrApp = usuariAplicacioEjb.executeQueryOne(UsuariAplicacioFields.USERNAME,
            UsuariAplicacioFields.USUARIAPLICACIOID.equal(idApp));
      } catch (Throwable th) {
        log.error("Error auditant: " + th.getMessage(), th);
        usrApp = "Error cercant usuari '" + isApp + "' : " + th.getMessage();
      }
    }

    final String usrPerson = transaccio.getFuncionariUsername();
    audita(transaccio, isApp, msg, additionalInfo, auditType, usrApp, usrPerson);
    
    return new String[] { usrApp, usrPerson };

  }

  @Override
  public void audita(Transaccio transaccio, final boolean isApp, final String msg,
      final String additionalInfo, final int auditType, String usernameApp,
      String usernamePerson) {
    try {
      Auditoria audit = new AuditoriaBean(new Timestamp(System.currentTimeMillis()),
          transaccio.getTransaccioID(), auditType, msg, additionalInfo, isApp, usernameApp,
          usernamePerson);

      this.create(audit);
    } catch (Throwable th) {
      log.error("Error auditant: " + th.getMessage(), th);
    }
  }

}
