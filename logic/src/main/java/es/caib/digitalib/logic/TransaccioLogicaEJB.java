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
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleSignatureParameters;
import org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.TransaccioEJB;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioQueryPath;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.utils.Constants;

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

    // XYZ ZZZ Optimitzar-ho si infoID val null
    
    Hibernate.initialize(transaccio.getInfoCustody());
    
    Hibernate.initialize(transaccio.getInfoSignatura());

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
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String returnURL,
      String ip) throws I18NException {

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
    
    if (perfil == null) {
      // XYZ ZZZ ZZZ Llança excepcio I18NException
    }

    PerfilJPA clonedPerfil = PerfilJPA.toJPA(perfil);

    clonedPerfil.setCodi(clonedPerfil.getCodi() + "-" + transactionWebID);
    clonedPerfil.setPerfilID(0);
    clonedPerfil.setUsPerfil(-1 * clonedPerfil.getUsPerfil());
    clonedPerfil.setUtilitzatPerAplicacio(usuariAplicacio != null);

    // XYZ ZZZ ZZZ Falten altres comprovacions
    TransaccioJPA t = new TransaccioJPA();

    t.setNom(transactionWebID);
    t.setTransactionWebId(transactionWebID);
    t.setDataInici(new Timestamp(System.currentTimeMillis()));
    if (usuariAplicacio != null) {
      t.setUsuariAplicacioId(usuariAplicacio.getUsuariAplicacioID());
    }
    if (usuariPersona != null) {
      t.setUsuariPersonaId(usuariPersona.getUsuariPersonaID());
    }
    t.setIp(ip);
    t.setReturnUrl(returnURL);
    t.setEstatCodi(ScanWebSimpleStatus.STATUS_REQUESTED_ID);
    t.setView(requestTransaction.getView());
    t.setLanguageUI(requestTransaction.getLanguageUI());
    t.setFuncionariUsername(requestTransaction.getFuncionariUsername());

    int tipusPerfil = perfil.getUsPerfil();

    if (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA
        || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

      ScanWebSimpleSignatureParameters signParams = requestTransaction
          .getSignatureParameters();
      
      // TOT AIXÒ s'OBTINDRA D'UNA PAGINA POSTERIOR A NO SER QUE JA ESTIGUI DEFINIT
      if (signParams != null) {
        // XYZ ZZZ Check not null
        
        log.info("\n\n XYZ ZZZ ZZZ CREAR TRANSACCIO POSAM LANGDOC A " + signParams.getLanguageDoc() +"\n\n");
        
        t.setSignParamLanguageDoc(signParams.getLanguageDoc());
        t.setSignParamFuncionariNom(signParams.getFuncionariNom());
        t.setSignParamFuncionariNif(signParams.getFuncionariNif());
      }
    }

    if (tipusPerfil == Constants.PERFIL_US_CUSTODIA
        || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

      // ==== OBLIGATORIS =======

      // TOT AIXÒ s'OBTINDRA D'UNA PAGINA POSTERIOR A NO SER QUE JA ESTIGUI DEFINIT
     
      ScanWebSimpleArxiuRequiredParameters arxiuReqParams = requestTransaction
          .getArxiuRequiredParameters();

      if (arxiuReqParams != null) {
      
        // XYZ ZZZ
        // arxiuReqParams.getDocumentEstatElaboracio() ==> Valor Valid
  
        // XYZ ZZZ
        // arxiuReqParams.getDocumentTipus() => Valor Valid
  
        // XYZ ZZZ
        // arxiuReqParams.getOrigen() => Valor Valid
  
        t.setArxiuReqParamDocEstatElabora(arxiuReqParams.getDocumentEstatElaboracio());
        t.setArxiuReqParamDocumentTipus(arxiuReqParams.getDocumentTipus());
        t.setArxiuReqParamOrigen(arxiuReqParams.getOrigen());
        t.setArxiuReqParamInteressats(LogicUtils.listToString(arxiuReqParams.getInteressats()));
        
        t.setArxiuReqParamCiutadaNif(arxiuReqParams.getCiutadaNif());
        t.setArxiuReqParamCiutadaNom(arxiuReqParams.getCiutadaNom());
      }
    

      // ==== OPCIONALS =======

      ScanWebSimpleArxiuOptionalParameters arxiuOptParams = requestTransaction
          .getArxiuOptionalParameters();
      if (arxiuOptParams != null) {
        t.setArxiuOptParamCustodyOrExpedientId(arxiuOptParams.getCustodyOrExpedientID());
        t.setArxiuOptParamOrgans(LogicUtils.listToString(arxiuOptParams.getOrgans()));
        t.setArxiuOptParamProcedimentCodi(arxiuOptParams.getProcedimentCodi());
        t.setArxiuOptParamProcedimentNom(arxiuOptParams.getProcedimentNom());
        t.setArxiuOptParamSerieDocumental(arxiuOptParams.getSerieDocumental());
      }
    }

    t.setPerfil(clonedPerfil);

    // return createWithProfile(t);

    clonedPerfil = t.getPerfil();

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

      transactionID = (nanoTime % 100000) + "" + System.currentTimeMillis()
          + (nanoTime / 100000);
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
