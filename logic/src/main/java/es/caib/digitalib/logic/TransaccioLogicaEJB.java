package es.caib.digitalib.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSignatureParameters;
import org.fundaciobit.apisib.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuOptionalParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleSignatureParameters;
import org.fundaciobit.apisib.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Where;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.FitxerLocal;
import es.caib.digitalib.ejb.TransaccioEJB;
import es.caib.digitalib.jpa.MetadadaJPA;
import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.jpa.TransaccioMultipleJPA;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.entity.Metadada;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.TransaccioMultiple;
import es.caib.digitalib.model.fields.MetadadaFields;
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

  @EJB(mappedName = FitxerLocal.JNDI_NAME)
  protected FitxerLocal fitxerEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoCustodyLocal infoCustodyEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.InfoSignaturaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoSignaturaLocal infoSignaturaEjb;

  @EJB(mappedName = AuditoriaLogicaLocal.JNDI_NAME)
  protected AuditoriaLogicaLocal auditoriaLogicaEjb;

  @EJB(mappedName = MetadadaLogicaLocal.JNDI_NAME)
  protected MetadadaLogicaLocal metadadaLogicaEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.TransaccioMultipleLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioMultipleLocal transaccioMultipleEjb;

  @Override
  public Set<Long> deleteFull(Transaccio transaccio, boolean esborrarFitxers,
      String usernameApp, String usernamePerson) throws I18NException {

    Set<Long> fitxers = new HashSet<Long>();
    if (transaccio == null) {
      return fitxers;
    }

    long count;
    Long transMultiple = transaccio.getTransaccioMultipleID();
    if (transMultiple == null) {
      count = -1;
    } else {
      Long count2 = this.count(TRANSACCIOMULTIPLEID.equal(transMultiple));
      if (count2 == null) {
        throw new I18NException("comodi",
            "No puc averiguar quantes transaccions hi ha associades a la transacció multiple amb ID "
                + transMultiple);
      }
      count = count2;
    }

    if (count <= 1) {
      metadadaLogicaEjb
          .delete(MetadadaFields.TRANSACCIOID.equal(transaccio.getTransaccioID()));
    }

    delete(transaccio.getTransaccioID());

    if (count <= 1) {
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
    }

    Long fe = transaccio.getFitxerEscanejatID();
    if (fe != null) {
      fitxers.add(fe);
    }
    Long fs = transaccio.getFitxerSignaturaID();
    if (fs != null) {
      fitxers.add(fs);
    }

    // log.info("XYZ ZZZ FFF PRE esborrar fitxers ... " + esborrarFitxers);

    if (count <= 1 && transMultiple != null) {
      fitxers.addAll(deleteTransaccioMultipleFull(transMultiple, esborrarFitxers));
    }

    if (esborrarFitxers) {
      // log.info("XYZ ZZZ FFF Entra a esborrar fitxers " +
      // Arrays.toString(fitxers.toArray()));
      for (Long fid : fitxers) {
        fitxerEjb.delete(fid);
      }
      fitxers.clear();
    }

    {
      final boolean isApp = (transaccio.getUsuariAplicacioId() != null);
      final String msg = "Esborrada transaccio " + transaccio.getTransaccioID();
      final String additionalInfo = null;
      final int auditType = Constants.AUDIT_TYPE_DELETE_TRANSACTION;
      auditoriaLogicaEjb.audita(transaccio, isApp, msg, additionalInfo, auditType, usernameApp,
          usernamePerson);
    }

    return fitxers;

  }

  /**
   * 
   * @param transaccioMultipleID
   * @param esborrarFitxers
   * @return
   * @throws I18NException
   */
  public Set<Long> deleteTransaccioMultipleFull(Long transaccioMultipleID,
      boolean esborrarFitxers) throws I18NException {

    Set<Long> fitxers = new HashSet<Long>();
    if (transaccioMultipleID == null) {
      return fitxers;
    }

    TransaccioMultiple tm = transaccioMultipleEjb.findByPrimaryKey(transaccioMultipleID);

    Long fe = tm.getFitxerEscanejatID();

    if (fe != null) {
      fitxers.add(fe);
    }

    transaccioMultipleEjb.delete(tm);
    if (esborrarFitxers) {
      for (Long fid : fitxers) {
        fitxerEjb.delete(fid);
      }
      fitxers.clear();
    }

    return fitxers;

  }

  @Override
  @RolesAllowed({ "DIB_ADMIN", "DIB_USER" })
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

  @Override
  public List<TransaccioJPA> searchMassiveTransaccioByTransactionWebID(String transactionWebID)
      throws I18NException {

    // Recordau que la primera transacció conté l'ID de la transacció multiple i que l'ID de la
    // transacció és igual a l'ID de la transacció multiple.

    Long transaccioMultipleID = executeQueryOne(TRANSACCIOMULTIPLEID,
        TRANSACTIONWEBID.equal(transactionWebID));

    if (transaccioMultipleID == null) {
      throw new I18NException("comodi",
          "No s'ha trobat transaccio multiple per la transaccio web: " + transactionWebID);
    }

    return searchMassiveTransaccioByTransaccioMultipleID(transaccioMultipleID);

  }

  /**
   * 
   * @param transaccioMultipleID
   * @return
   * @throws I18NException
   */
  public List<TransaccioJPA> searchMassiveTransaccioByTransaccioMultipleID(
      long transaccioMultipleID) throws I18NException {

    List<Transaccio> list = this.select(
        TransaccioFields.TRANSACCIOMULTIPLEID.equal(transaccioMultipleID),
        new OrderBy(TRANSACCIOID));

    List<TransaccioJPA> listJPA = new ArrayList<TransaccioJPA>();

    for (Transaccio transaccio : list) {

      TransaccioJPA jpa = (TransaccioJPA) transaccio;

      Hibernate.initialize(jpa.getPerfil());
      Hibernate.initialize(jpa.getFitxerEscanejat());

      listJPA.add(jpa);
    }

    return listJPA;

  }

  protected void internalInitialization(TransaccioJPA transaccio) {
    Hibernate.initialize(transaccio.getPerfil());

    // XYZ ZZZ Optimitzar-ho si infoID val null

    Hibernate.initialize(transaccio.getInfoCustody());

    Hibernate.initialize(transaccio.getInfoSignatura());

  }

  @Override
  @PermitAll
  public Transaccio create(Transaccio instance) throws I18NException {
    return super.create(instance);
  }

  @Override
  @PermitAll
  public Transaccio update(Transaccio instance) throws I18NException {
    return super.update(instance);
  }

  @Override
  @PermitAll
  public TransaccioJPA crearTransaccio(ScanWebSimpleGetTransactionIdRequest mrt,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase,
      String returnURL, String ip) throws I18NException {

    final String scanWebProfile = mrt.getScanWebProfile();
    final int view = mrt.getView();
    final String languageUI = mrt.getLanguageUI();
    final String funcionariUsername = mrt.getFuncionariUsername();

    final MassiveScanWebSimpleSignatureParameters signatureParameters;

    if (mrt.getSignatureParameters() == null) {
      signatureParameters = null;
    } else {

      ScanWebSimpleSignatureParameters sp = mrt.getSignatureParameters();

      final String documentLanguage = sp.getDocumentLanguage();

      final String functionaryFullName = sp.getFunctionaryFullName();

      final String functionaryAdministrationID = sp.getFunctionaryAdministrationID();

      signatureParameters = new MassiveScanWebSimpleSignatureParameters(documentLanguage,
          functionaryFullName, functionaryAdministrationID);
    }

    final MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
    if (mrt.getArxiuRequiredParameters() == null) {
      arxiuRequiredParameters = null;
    } else {
      ScanWebSimpleArxiuRequiredParameters arp = mrt.getArxiuRequiredParameters();

      final String citizenAdministrationID = arp.getCitizenAdministrationID();

      final String citizenFullName = arp.getCitizenFullName();

      final String documentElaborationState = arp.getDocumentElaborationState();

      final String documentType = arp.getDocumentType();

      final Integer documentOrigen = arp.getDocumentOrigen();

      final List<String> interestedPersons = arp.getInterestedPersons();

      final List<String> affectedOrganisms = arp.getAffectedOrganisms();

      arxiuRequiredParameters = new MassiveScanWebSimpleArxiuRequiredParameters(
          citizenAdministrationID, citizenFullName, documentElaborationState, documentType,
          documentOrigen, interestedPersons, affectedOrganisms);
    }

    final MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters;

    if (mrt.getArxiuOptionalParameters() == null) {
      arxiuOptionalParameters = null;
    } else {

      ScanWebSimpleArxiuOptionalParameters aop = mrt.getArxiuOptionalParameters();

      final String procedureName = aop.getProcedureName();

      final String procedureCode = aop.getProcedureCode();

      final String documentarySerie = aop.getDocumentarySerie();

      final String custodyIDOrExpedientID = aop.getCustodyIDOrExpedientID();

      arxiuOptionalParameters = new MassiveScanWebSimpleArxiuOptionalParameters(procedureName,
          procedureCode, documentarySerie, custodyIDOrExpedientID);

    }

    MassiveScanWebSimpleGetTransactionIdRequest requestTransaction = new MassiveScanWebSimpleGetTransactionIdRequest(
        "", scanWebProfile, view, languageUI, funcionariUsername, signatureParameters,
        arxiuRequiredParameters, arxiuOptionalParameters);

    boolean isMassive = false;

    return internalCrearTransaccio(requestTransaction, usuariAplicacio, usuariPersona, urlBase,
        returnURL, ip, isMassive);

  }

  @Override
  @PermitAll
  public TransaccioJPA crearTransaccio(
      MassiveScanWebSimpleGetTransactionIdRequest requestTransaction,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase,
      String returnURL, String ip) throws I18NException {

    boolean isMassive = true;

    return internalCrearTransaccio(requestTransaction, usuariAplicacio, usuariPersona, urlBase,
        returnURL, ip, isMassive);

  }

  protected TransaccioJPA internalCrearTransaccio(
      MassiveScanWebSimpleGetTransactionIdRequest requestTransaction,
      UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase,
      String returnURL, String ip, boolean isMassive) throws I18NException {
    String scanWebProfile = requestTransaction.getScanWebProfile();

    PerfilUsuariAplicacioQueryPath qp = new PerfilUsuariAplicacioQueryPath();

    Long perfilID = null;
    if (usuariPersona == null) {

      try {
        perfilID = perfilUsuariAplicacioEjb.executeQueryOne(qp.PERFIL().PERFILID(),
            Where.AND(
                PerfilUsuariAplicacioFields.USUARIAPLICACIOID
                    .equal(usuariAplicacio.getUsuariAplicacioID()),
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
        throw new I18NException("genapp.comodi",
            "No puc trobar el perfil amb codi " + scanWebProfile);
      }

    }

    final String transactionWebID = generateTransactionWebID();

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

    t.setNom(requestTransaction.getTransactionName());
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

      MassiveScanWebSimpleSignatureParameters signParams = requestTransaction
          .getSignatureParameters();

      // TOT AIXÒ s'OBTINDRA D'UNA PAGINA POSTERIOR A NO SER QUE JA ESTIGUI DEFINIT
      if (signParams != null) {
        // XYZ ZZZ Check not null

        log.info("\n\n XYZ ZZZ ZZZ CREAR TRANSACCIO POSAM LANGDOC A "
            + signParams.getDocumentLanguage() + "\n\n");

        t.setSignParamLanguageDoc(signParams.getDocumentLanguage());
        t.setSignParamFuncionariNom(signParams.getFunctionaryFullName());
        t.setSignParamFuncionariNif(signParams.getFunctionaryAdministrationID());
      }
    }

    if (tipusPerfil == Constants.PERFIL_US_CUSTODIA
        || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

      // ==== OBLIGATORIS =======

      // TOT AIXÒ s'OBTINDRA D'UNA PAGINA POSTERIOR A NO SER QUE JA ESTIGUI DEFINIT

      MassiveScanWebSimpleArxiuRequiredParameters arxiuReqParams = requestTransaction
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
        t.setArxiuReqParamInteressats(
            LogicUtils.listToString(arxiuReqParams.getInterestedPersons()));
        t.setArxiuReqParamOrgans(
            LogicUtils.listToString(arxiuReqParams.getAffectedOrganisms()));
        t.setArxiuReqParamCiutadaNif(arxiuReqParams.getCitizenAdministrationID());
        t.setArxiuReqParamCiutadaNom(arxiuReqParams.getCitizenFullName());
      }

      // ==== OPCIONALS =======

      MassiveScanWebSimpleArxiuOptionalParameters arxiuOptParams = requestTransaction
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

    // És Massiva
    if (isMassive) {
      // Crear massiva

      // A massiva posam el ID de la primera transacció
      long transmultipleid = t.getTransaccioID();
      TransaccioMultipleJPA traMul = new TransaccioMultipleJPA(transmultipleid, t.getNom());
      transaccioMultipleEjb.create(traMul);

      String var = getTableNameVariable();

      // Actialitzam IDmultiple de la subtransaccio
      String sql = "UPDATE " + getTableName() + " " + var + " SET " + var + "."
          + TransaccioFields.TRANSACCIOMULTIPLEID.javaName + " = ?1 " + "WHERE " + var + "."
          + TransaccioFields.TRANSACCIOID.javaName + " = ?2";
      javax.persistence.Query query = getEntityManager().createQuery(sql);

      query.setParameter(1, transmultipleid);
      query.setParameter(2, transmultipleid);

      int updates = query.executeUpdate();

      log.info(" XYZ ZZZ  Actualitzades " + updates + " entrades (hauria de ser 1)");

    }

    return t;
  }

  public String generateTransactionWebID() {
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

  @Override
  @PermitAll
  public TransaccioMultiple findTransaccioMultipleByPrimaryKey(Long transaccioMultipleID)
      throws I18NException {
    return transaccioMultipleEjb.findByPrimaryKey(transaccioMultipleID);
  }

  @Override
  @PermitAll
  public TransaccioMultiple updateTransaccioMultiple(TransaccioMultiple tm)
      throws I18NException {
    return transaccioMultipleEjb.update(tm);
  }

  @Override
  @PermitAll
  public TransaccioJPA cloneTransaccio(TransaccioJPA transaccioOriginal, String nom)
      throws I18NException {
    TransaccioJPA transaccio = TransaccioJPA.toJPA(transaccioOriginal);

    transaccio.setNom(nom);

    transaccio.setTransaccioID(0);
    transaccio.setEstatCodi(MassiveScanWebSimpleStatus.STATUS_IN_PROGRESS);
    transaccio.setEstatExcepcio(null);
    transaccio.setEstatMissatge(null);

    transaccio.setFitxerEscanejatID(null);
    transaccio.setFitxerEscanejat(null);
    transaccio.setHashEscaneig(null);

    transaccio.setTransactionWebId(this.generateTransactionWebID());

    // crear transaccio
    transaccio = (TransaccioJPA) this.create(transaccio);

    // Clone Metadatas
    List<Metadada> metas = metadadaLogicaEjb
        .select(MetadadaFields.TRANSACCIOID.equal(transaccioOriginal.getTransaccioID()));

    for (Metadada metadada : metas) {
      MetadadaJPA metaJPA = MetadadaJPA.toJPA(metadada);
      metaJPA.setMetadadaid(0);
      metaJPA.setTransaccioID(transaccio.getTransaccioID());

      metadadaLogicaEjb.create(metaJPA);

    }

    return transaccio;
  }

}
