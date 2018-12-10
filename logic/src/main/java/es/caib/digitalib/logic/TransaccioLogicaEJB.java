package es.caib.digitalib.logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.TransaccioEJB;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioQueryPath;
import es.caib.digitalib.model.fields.TransaccioFields;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "TransaccioLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class TransaccioLogicaEJB extends TransaccioEJB implements TransaccioLogicaLocal {

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;

  /*
   * @Override public TransaccioJPA createWithProfile(TransaccioJPA transaccio) throws
   * I18NException {
   * 
   * Perfil perfil = (Perfil) transaccio.getPerfil();
   * 
   * if (perfil == null) { // XYZ ZZZ ZZZ Llança excepcio I18NException }
   * 
   * perfil = perfilEjb.create(perfil);
   * 
   * transaccio.setPerfil(null); transaccio.setPerfilid(perfil.getPerfilID());
   * 
   * return (TransaccioJPA)this.create(transaccio);
   * 
   * }
   */

  @Override
  public TransaccioJPA searchTransaccioByTransactionWebID(String transactionWebID)
      throws I18NException {
    List<Transaccio> list = select(TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));

    if (list == null || list.size() == 0) {
      return null;
    }

    TransaccioJPA transaccio = (TransaccioJPA) list.get(0);

    Hibernate.initialize(transaccio.getPerfil());

    return transaccio;

  }

  @Override
  @PermitAll
  public Transaccio update(Transaccio instance) throws I18NException {
    return super.update(instance);
  }

  @Override
  @PermitAll
  public TransaccioJPA crearTransaccio(
      ScanWebSimpleGetTransactionIdRequest requestTransaction,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String returnURL)
      throws I18NException {

    String scanWebProfile = requestTransaction.getScanWebProfile();

    PerfilUsuariAplicacioQueryPath qp = new PerfilUsuariAplicacioQueryPath();

    Long perfilID = null;
    if (usuariPersona == null) {

      try {
        perfilID = perfilUsuariAplicacioEjb.executeQueryOne(qp.PERFIL().PERFILID(), Where.AND(
            PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(usuariAplicacio
                .getUsuariAplicacioID()),
            // Dels perfils assignats esta el del codi enviat
            qp.PERFIL().CODI().equal(scanWebProfile)));
      } catch (I18NException e1) {
        // XYZ ZZZ YTraduir
        throw new I18NException("genapp.comodi", "Error desconegut cercant perfil "
            + scanWebProfile + ": " + I18NLogicUtils.getMessage(e1, new Locale("ca")));
      }

      if (perfilID == null) {
        // XYZ ZZZ Traduir
        throw new I18NException("genapp.comodi", "El perfil " + scanWebProfile
            + " no està assignat a usuari aplicacio " + usuariAplicacio.getUsername());
      }
    } else {

      perfilID = perfilEjb.executeQueryOne(PerfilFields.PERFILID,
          PerfilFields.CODI.equal(scanWebProfile));

      // XYZ ZZZ Traduir
      if (perfilID == null) {
        throw new I18NException("genapp.comodi", "No puc trobar el perfil amb codi "
            + scanWebProfile);
      }

    }

    final String transactionWebID = internalGetTransacction();

    PerfilJPA perfil = perfilEjb.findByPrimaryKey(perfilID);

    PerfilJPA clonedPerfil = PerfilJPA.toJPA(perfil);

    clonedPerfil.setCodi(clonedPerfil.getCodi() + "-" + transactionWebID);
    clonedPerfil.setPerfilID(0);
    clonedPerfil.setUsPerfil(-1 * clonedPerfil.getUsPerfil());

    // XYZ ZZZ ZZZ Falten altres comprovacions
    TransaccioJPA t = new TransaccioJPA();

    t.setDataInici(new Timestamp(System.currentTimeMillis()));
    t.setEstatCodi(ScanWebSimpleStatus.STATUS_REQUESTED_ID);
    t.setTransactionWebId(transactionWebID);
    t.setLanguageUI(requestTransaction.getLanguageUI());
    t.setLanguageDoc(requestTransaction.getLanguageDoc());

    t.setView(requestTransaction.getView());

    t.setReturnUrl(returnURL);

    if (usuariAplicacio != null) {
      t.setUsuariAplicacioId(usuariAplicacio.getUsuariAplicacioID());
    }

    if (usuariPersona != null) {
      t.setUsuariPersonaId(usuariPersona.getUsuariPersonaID());
    }

    t.setFuncionariUsername(requestTransaction.getFuncionariUsername());
    t.setFuncionariNom(requestTransaction.getFuncionariNom());
    t.setCiutadaNif(requestTransaction.getCiutadaNif());
    t.setCiutadaNom(requestTransaction.getCiutadaNom());
    t.setExpedient(requestTransaction.getExpedientID());

    t.setView(requestTransaction.getView());

    t.setPerfil(clonedPerfil);

    // return createWithProfile(t);

    clonedPerfil = t.getPerfil();

    if (perfil == null) {
      // XYZ ZZZ ZZZ Llança excepcio I18NException
    }

    clonedPerfil = (PerfilJPA) perfilEjb.create(clonedPerfil);

    t.setPerfil(null);
    t.setPerfilID(clonedPerfil.getPerfilID());

    t = (TransaccioJPA) this.create(t);

    t.setPerfil(clonedPerfil);

    return t;

  }

  protected String internalGetTransacction() {
    String transactionID;
    synchronized (this) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
      }

      long nanoTime = System.nanoTime();
      
      transactionID = (nanoTime % 100000) + "" + System.currentTimeMillis() + (nanoTime / 100000);
      transactionID = org.fundaciobit.pluginsib.core.utils.Base64.encode(transactionID)
          .toLowerCase();
      transactionID = transactionID.replaceAll("=", "");

    }

    if (log.isDebugEnabled()) {
      log.info(" Creada transacció amb ID = |" + transactionID + "|");
    }
    return transactionID;
  }

}
