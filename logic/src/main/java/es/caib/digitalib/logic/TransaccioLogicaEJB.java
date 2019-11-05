package es.caib.digitalib.logic;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleSignatureParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.FitxerLocal;
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
 * @author anadal(u80067)
 *
 */
@Stateless(name = "TransaccioLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class TransaccioLogicaEJB extends TransaccioEJB implements TransaccioLogicaLocal {

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;
  
  @EJB(mappedName = "digitalib/FitxerEJB/local")
  protected FitxerLocal fitxerEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;
  
  @EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoCustodyLocal infoCustodyEjb;
  
  @EJB(mappedName = es.caib.digitalib.ejb.InfoSignaturaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoSignaturaLocal infoSignaturaEjb;
  
  @EJB(mappedName = AuditoriaLogicaLocal.JNDI_NAME)
  protected AuditoriaLogicaLocal auditoriaLogicaEjb;

  @Override
  public Set<Long> deleteFull(Transaccio transaccio, boolean esborrarFitxers, String usernameApp, String usernamePerson) throws I18NException {
    
    Set<Long> fitxers = new HashSet<Long>();
    if (transaccio == null) {
      return fitxers;
    }
    
    delete(transaccio.getTransaccioID());
    
    Long pid = transaccio.getPerfilID();
    if (pid != null) {
      perfilEjb.delete(pid);
    }
    
    Long ic = transaccio.getInfoCustodyID();
    if (ic != null) {
      infoCustodyEjb.delete(ic);
    }
       
    Long is = transaccio.getInfoSignaturaID();
    if (is != null) {
      infoSignaturaEjb.delete(is);
    }

    Long fe = transaccio.getFitxerEscanejatID();
    if (fe != null) {
      fitxers.add(fe);
    }
    Long fs = transaccio.getFitxerSignaturaID();
    if (fs != null) {
      fitxers.add(fs);
    }

 
    //log.info("XYZ ZZZ  FFF PRE esborrar fitxers ... " + esborrarFitxers);
    
    if (esborrarFitxers) {
      //log.info("XYZ ZZZ  FFF Entra a esborrar fitxers " + Arrays.toString(fitxers.toArray()));
      for (Long fid : fitxers) {
        fitxerEjb.delete(fid);   
      }
      //log.info("XYZ ZZZ  FFF 2222  Esborrat Fitxers Fisics = " + FileSystemManager.eliminarArxius(fitxers));
    }
    
    
    final boolean isApp = (transaccio.getUsuariAplicacioId() != null);
    final String msg = "Esborrada transaccio " +  transaccio.getTransaccioID();
    final String additionalInfo = null;
    final int auditType = Constants.AUDIT_TYPE_DELETE_TRANSACTION;
    auditoriaLogicaEjb.audita(transaccio, isApp, msg, additionalInfo, auditType, usernameApp, usernamePerson);
    
    return fitxers;
    
  }

  
  @Override
  @RolesAllowed({"DIB_ADMIN","DIB_USER"})
  public TransaccioJPA findByPrimaryKeyFull(Long _ID_) {

    TransaccioJPA transaccio = findByPrimaryKey(_ID_);

    if (transaccio != null) {
      internalInitialization(transaccio);
    }

    return transaccio;
  }
  
  
  @Override
  public TransaccioJPA searchTransaccioByTransactionWebID(String transactionWebID)
      throws I18NException {

    
    List<Transaccio> list = select(TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));

    if (list == null || list.size() == 0) {
      return null;
    }

    TransaccioJPA transaccio = (TransaccioJPA) list.get(0);

    internalInitialization(transaccio);

    return transaccio;

  }
  
  

  protected void internalInitialization(TransaccioJPA transaccio) {
    Hibernate.initialize(transaccio.getPerfil());

    // XYZ ZZZ Optimitzar-ho si infoID val null
    
    Hibernate.initialize(transaccio.getInfoCustody());
    
    Hibernate.initialize(transaccio.getInfoSignatura());
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
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, 
      String urlBase, String returnURL, String ip) throws I18NException {

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
    clonedPerfil.setNomID(null);
    clonedPerfil.setDescripcioID(null);
    if (urlBase != null) {
      clonedPerfil.setUrlBase(urlBase);
    }
    

    // XYZ ZZZ ZZZ Falten altres comprovacions
    TransaccioJPA t = new TransaccioJPA();

    t.setNom("");
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
        
        log.info("\n\n XYZ ZZZ ZZZ CREAR TRANSACCIO POSAM LANGDOC A " + signParams.getDocumentLanguage() +"\n\n");
        
        t.setSignParamLanguageDoc(signParams.getDocumentLanguage());
        t.setSignParamFuncionariNom(signParams.getFunctionaryFullName());
        t.setSignParamFuncionariNif(signParams.getFunctionaryAdministrationID());
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
  
        t.setArxiuReqParamDocEstatElabora(arxiuReqParams.getDocumentElaborationState());
        t.setArxiuReqParamDocumentTipus(arxiuReqParams.getDocumentType());
        t.setArxiuReqParamOrigen(arxiuReqParams.getDocumentOrigen());
        t.setArxiuReqParamInteressats(LogicUtils.listToString(arxiuReqParams.getInterestedPersons()));
        t.setArxiuReqParamOrgans(LogicUtils.listToString(arxiuReqParams.getAffectedOrganisms()));
        t.setArxiuReqParamCiutadaNif(arxiuReqParams.getCitizenAdministrationID());
        t.setArxiuReqParamCiutadaNom(arxiuReqParams.getCitizenFullName());
      }
    

      // ==== OPCIONALS =======

      ScanWebSimpleArxiuOptionalParameters arxiuOptParams = requestTransaction
          .getArxiuOptionalParameters();
      if (arxiuOptParams != null) {
        t.setArxiuOptParamCustodyOrExpedientId(arxiuOptParams.getCustodyIDOrExpedientID());
        t.setArxiuOptParamProcedimentCodi(arxiuOptParams.getProcedureCode());
        t.setArxiuOptParamProcedimentNom(arxiuOptParams.getProcedureName());
        t.setArxiuOptParamSerieDocumental(arxiuOptParams.getDocumentarySerie());
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
