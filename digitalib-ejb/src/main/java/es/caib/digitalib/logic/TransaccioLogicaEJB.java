package es.caib.digitalib.logic;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Status;

import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuOptionalParameters;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuRequiredParameters;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSignatureParameters;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuOptionalParameters;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleArxiuRequiredParameters;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleSignatureParameters;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleStatus;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.TransactionTimeout;

//import org.jboss.ejb3.annotation.TransactionTimeout;

import es.caib.digitalib.ejb.FitxerService;
import es.caib.digitalib.ejb.TransaccioEJB;
import es.caib.digitalib.persistence.MetadadaJPA;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.persistence.TransaccioMultipleJPA;
import es.caib.digitalib.persistence.UsuariAplicacioJPA;
import es.caib.digitalib.persistence.UsuariPersonaJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.LogicUtils;
import es.caib.digitalib.model.entity.Metadada;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.TransaccioMultiple;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.MetadadaFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioQueryPath;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "TransaccioLogicaEJB")

@RunAs(Constants.DIB_ADMIN)
public class TransaccioLogicaEJB extends TransaccioEJB implements TransaccioLogicaService {

    @EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilService perfilEjb;

    @EJB(mappedName = FitxerService.JNDI_NAME)
    protected FitxerService fitxerEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilUsuariAplicacioService perfilUsuariAplicacioEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyService.JNDI_NAME)
    protected es.caib.digitalib.ejb.InfoCustodyService infoCustodyEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.InfoSignaturaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.InfoSignaturaService infoSignaturaEjb;

    @EJB(mappedName = AuditoriaLogicaService.JNDI_NAME)
    protected AuditoriaLogicaService auditoriaLogicaEjb;

    @EJB(mappedName = MetadadaLogicaService.JNDI_NAME)
    protected MetadadaLogicaService metadadaLogicaEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.TransaccioMultipleService.JNDI_NAME)
    protected es.caib.digitalib.ejb.TransaccioMultipleService transaccioMultipleEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioGrupService.JNDI_NAME)
    protected es.caib.digitalib.ejb.ConfiguracioGrupService configuracioGrupEjb;

    @Override
    public Set<Long> deleteFull(Transaccio transaccio, String usernameApp,
            String usernamePerson) throws I18NException {

        Set<Long> filesToDelete = new HashSet<Long>();
        if (transaccio == null) {
            return filesToDelete;
        }

        Long transMultiple = transaccio.getTransaccioMultipleID();

        long count;
        if (transMultiple == null) {
            count = -1;
        } else {
            Long count2 = this.count(TRANSACCIOMULTIPLEID.equal(transMultiple));
            if (count2 == null) {
                // XYZ ZZZ TRA
                throw new I18NException("comodi",
                        "No puc averiguar quantes transaccions hi ha associades a la transacció multiple amb ID "
                                + transMultiple);
            }
            count = count2;
        }

        // Cada transacció té les seves metadades
        final Long transaccioID = transaccio.getTransaccioID();
        {
            metadadaLogicaEjb
                    .delete(MetadadaFields.TRANSACCIOID.equal(transaccioID));
        }

        delete(transaccioID);

        // El perfil és compartit per les diverses transaccions que formen part d'una
        // transacció multiple
        if (count <= 1) {
            Long pid = transaccio.getPerfilID();
            if (pid != null) {
                perfilEjb.delete(pid);
            }
        }

        // Cada transacció té la seva informació de custòdia i signatura
        {
            Long ic = transaccio.getInfoCustodyID();
            if (ic != null) {
                infoCustodyEjb.delete(ic);
            }

            Long is = transaccio.getInfoSignaturaID();
            if (is != null) {
                infoSignaturaEjb.delete(is);
            }
        }

        cleanFilesOfTransaction(transaccio, filesToDelete, false);

        if (count <= 1 && transMultiple != null) {
            filesToDelete.addAll(deleteTransaccioMultipleFull(transMultiple));
        }

        {
            final boolean isApp = (transaccio.getUsuariAplicacioId() != null);
            final String msg = "Esborrada transaccio " + transaccioID;
            final String additionalInfo = null;
            final int auditType = Constants.AUDIT_TYPE_DELETE_TRANSACTION;
            auditoriaLogicaEjb.audita(transaccio, isApp, msg, additionalInfo, auditType,
                    usernameApp, usernamePerson);
        }

        __tsRegistry.registerInterposedSynchronization(
                new CleanFilesSynchronization(transaccioID, filesToDelete));

        return filesToDelete;
    }

    protected void cleanFilesOfTransaction(Transaccio transaccio, Set<Long> fitxers,
            boolean updateTransaction) throws I18NException {
        Long fe = transaccio.getFitxerEscanejatID();
        if (fe != null) {
            fitxers.add(fe);
            transaccio.setFitxerEscanejatID(null);
        }

        Long fs = transaccio.getFitxerSignaturaID();
        if (fs != null) {
            fitxers.add(fs);
            transaccio.setFitxerSignaturaID(null);
        }

        if (updateTransaction && (fe != null || fs != null)) {
            this.update(transaccio);
        }

        // log.info("XYZ ZZZ FFF PRE esborrar fitxers ... " + esborrarFitxers);
        {
            // log.info("XYZ ZZZ FFF Entra a esborrar fitxers " +
            // Arrays.toString(fitxers.toArray()));
            for (Long fid : fitxers) {
                try {
                   fitxerEjb.delete(fid);
                } catch(Throwable th) {
                    String msg;
                    if (th instanceof I18NException) {
                        msg = I18NLogicUtils.getMessage((I18NException)th, new Locale("ca"));
                    } else {
                        msg = th.getMessage();
                    }
                    
                    log.error("Error desconegut esborrant fitxer amb ID " + fid + " de la transacció " + transaccio.getTransaccioID() + ": " + msg, th);                    
                }
            }

        }
    }

    
    @Override
    public MassiveScanWebSimpleFile getSeparator() throws Exception {

        byte[] data;
        InputStream is = TransaccioLogicaEJB.class.getClassLoader()
                .getResourceAsStream(SEPARADOR_ESCANEIG_MASSIU_NOM);

        if (is == null) {
            // XYZ ZZZ TRA
            throw new Exception("No puc carregar el fitxer " + SEPARADOR_ESCANEIG_MASSIU_NOM + " dels recursos.");
        }
        data = FileUtils.toByteArray(is);
        is.close();

        MassiveScanWebSimpleFile msf = new MassiveScanWebSimpleFile(SEPARADOR_ESCANEIG_MASSIU_NOM,
                Constants.MIME_PDF, data);
        
        return msf;
    }
    
    
    
    //@Resource(mappedName="java:jboss/TransactionSynchronizationRegistry")
    //protected TransactionSynchronizationRegistry transactionSynchronizationRegistry;

    @Override
    public void netejaFitxers(Long transaccioID) throws I18NException {

        // log.error("Passa per cleanFiles => INICI");

        Transaccio t = this.findByPrimaryKey(transaccioID);

        netejaFitxers(t);

    }

    protected void netejaFitxers(Transaccio t) throws I18NException {
        Set<Long> filesToDelete = new HashSet<Long>();

        cleanFilesOfTransaction(t, filesToDelete, true);

        __tsRegistry.registerInterposedSynchronization(
                new CleanFilesSynchronization(t.getTransaccioID(), filesToDelete));
        // log.error("Passa per netejaFitxers => FINAL");
    }

    public class CleanFilesSynchronization implements javax.transaction.Synchronization {

        protected final Set<Long> filesToDelete;
        
        protected final Long transactionID;

        public CleanFilesSynchronization(Long transactionID, Set<Long> filesToDelete) {            
            super();
            this.transactionID = transactionID;
            this.filesToDelete = filesToDelete;
        }

        @Override
        public void beforeCompletion() {
        }

        @Override
        public void afterCompletion(int status) {
            if (status == Status.STATUS_COMMITTED) {
                if (!FileSystemManager.eliminarArxius(filesToDelete)) {
                    log.error("No s'ha pogut esborrar alguns dels següents fitxers: "
                            + Arrays.toString(filesToDelete.toArray()));
                }
            } else {
                log.error("Passa per CleanFilesSynchronization::afterCompletion(" + status
                        + "): Estat final no commit de la transaccio " + this.transactionID);
            }
        }
    }

    /**
     * 
     * @param transaccioMultipleID
     * @param esborrarFitxers
     * @return
     * @throws I18NException
     */
    public Set<Long> deleteTransaccioMultipleFull(Long transaccioMultipleID)
            throws I18NException {

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
        {
            for (Long fid : fitxers) {
                fitxerEjb.delete(fid);
            }
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

        List<Transaccio> list = select(
                TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));

        if (list == null || list.size() == 0) {
            return null;
        }

        TransaccioJPA transaccio = (TransaccioJPA) list.get(0);

        internalInitialization(transaccio);

        return transaccio;
    }

    @Override
    public List<TransaccioJPA> searchMassiveTransaccioByTransactionWebID(
            String transactionWebID) throws I18NException {

        // Recordau que la primera transacció conté l'ID de la transacció multiple i que l'ID
        // de la
        // transacció és igual a l'ID de la transacció multiple.

        Long transaccioMultipleID = executeQueryOne(TRANSACCIOMULTIPLEID,
                TRANSACTIONWEBID.equal(transactionWebID));

        if (transaccioMultipleID == null) {
            throw new I18NException("comodi",
                    "No s'ha trobat transaccio multiple per la transaccio web: "
                            + transactionWebID);
        }

        return searchMassiveTransaccioByTransaccioMultipleID(transaccioMultipleID);

    }

    @Override
    public Long[] countTransaccionsByTransaccioMultipleID(long transaccioMultipleID)
            throws I18NException {

        List<Integer> estats = this.executeQuery(TransaccioFields.ESTATCODI,
                TransaccioFields.TRANSACCIOMULTIPLEID.equal(transaccioMultipleID));

        /*
         * Long totals = this
         * .count(TransaccioFields.TRANSACCIOMULTIPLEID.equal(transaccioMultipleID));
         * 
         * Long oks = this.count(
         * Where.AND(TransaccioFields.TRANSACCIOMULTIPLEID.equal(transaccioMultipleID),
         * TransaccioFields.ESTATCODI.equal(Constants.TRANSACCIO_ESTAT_CODI_OK)));
         */

        long oks = 0;

        for (Integer estat : estats) {
            if (estat == Constants.TRANSACCIO_ESTAT_CODI_OK) {
                oks++;
            }
        }
        return new Long[] { (long) estats.size(), oks };

    }

    /**
     * 
     * @param transaccioMultipleID
     * @return
     * @throws I18NException
     */
    @Override
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

            // final String documentLanguage = sp.getDocumentLanguage();

            final String functionaryFullName = sp.getFunctionaryFullName();

            final String functionaryAdministrationID = sp.getFunctionaryAdministrationID();

            String functionaryDir3Unit = null;
            if (usuariPersona != null) {
                if (Configuracio.useDir3OfGroupConfiguration()) {

                    if (usuariPersona.getConfiguracioGrupID() == null) {
                        // XYZ ZZZ
                        throw new I18NException("genapp.comodi",
                                "L'usuari  " + usuariPersona.getUsername()
                                        + " no te definida la Configuració de Grup");
                    }
                    functionaryDir3Unit = configuracioGrupEjb.executeQueryOne(
                            ConfiguracioGrupFields.CODIDIR3PERDEFECTE,
                            ConfiguracioGrupFields.CONFIGURACIOGRUPID
                                    .equal(usuariPersona.getConfiguracioGrupID()));
                } else {
                    functionaryDir3Unit = usuariPersona.getUnitatDir3();
                }
            }

            if (functionaryDir3Unit == null) {
                functionaryDir3Unit = Configuracio.getDefaultFuncionariDir3();
                // log.info("\n\n\n FUNCIONARI DIR3 = " + functionaryDir3Unit + "\n\n\n");
            }

            signatureParameters = new MassiveScanWebSimpleSignatureParameters(
                    functionaryFullName, functionaryAdministrationID, functionaryDir3Unit);
        }

        final MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters;
        if (mrt.getArxiuRequiredParameters() == null) {
            arxiuRequiredParameters = null;
        } else {
            ScanWebSimpleArxiuRequiredParameters arp = mrt.getArxiuRequiredParameters();

            final String citizenAdministrationID = arp.getCitizenAdministrationID();

            final String citizenFullName = arp.getCitizenFullName();

            final String documentElaborationState = arp.getDocumentElaborationState();

            // final String documentType = arp.getDocumentType();

            final Integer documentOrigen = arp.getDocumentOrigen();

            final List<String> interestedPersons = arp.getInterestedPersons();

            final List<String> affectedOrganisms = arp.getAffectedOrganisms();

            arxiuRequiredParameters = new MassiveScanWebSimpleArxiuRequiredParameters(
                    citizenAdministrationID, citizenFullName, documentElaborationState,
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

            arxiuOptionalParameters = new MassiveScanWebSimpleArxiuOptionalParameters(
                    procedureName, procedureCode, documentarySerie, custodyIDOrExpedientID);

        }

        final String transactionName = " "; // No posam buit per no fer petar en Oracle
        MassiveScanWebSimpleGetTransactionIdRequest requestTransaction;

        requestTransaction = new MassiveScanWebSimpleGetTransactionIdRequest(transactionName,
                scanWebProfile, view, languageUI, funcionariUsername, signatureParameters,
                arxiuRequiredParameters, arxiuOptionalParameters);

        // Original Value final boolean isMassive = false;

        final boolean isMassive = Configuracio.isAllowedMassiveScanInWeb();

        return internalCrearTransaccio(requestTransaction, usuariAplicacio, usuariPersona,
                urlBase, returnURL, ip, isMassive);

    }

    @Override
    @PermitAll
    public TransaccioJPA crearTransaccio(
            MassiveScanWebSimpleGetTransactionIdRequest requestTransaction,
            UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase,
            String returnURL, String ip) throws I18NException {

        final boolean isMassive = true;

        return internalCrearTransaccio(requestTransaction, usuariAplicacio, usuariPersona,
                urlBase, returnURL, ip, isMassive);

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
                throw new I18NException("genapp.comodi",
                        "Error desconegut cercant perfil " + scanWebProfile + ": "
                                + I18NLogicUtils.getMessage(e1, new Locale("ca")));
            }

            if (perfilID == null) {
                // XYZ ZZZ Traduir
                throw new I18NException("genapp.comodi",
                        "El perfil " + scanWebProfile + " no està assignat a usuari aplicacio "
                                + usuariAplicacio.getUsername());
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

        // Esborrar !!! Això ja es fa a
        // MassiveScanWebSimpleSignatureParameters sp =
        // requestTransaction.getSignatureParameters();
        // if (sp != null) {
        // t.setSignParamFuncionariNom(sp.getFunctionaryFullName());
        // t.setSignParamFuncionariNif(sp.getFunctionaryAdministrationID());
        // t.setSignParamFuncionariDir3(sp.getFunctionayDIR3Unit());
        // }

        int tipusPerfil = perfil.getUsPerfil();

        if (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA
                || tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

            MassiveScanWebSimpleSignatureParameters signParams = requestTransaction
                    .getSignatureParameters();

            // TOT AIXÒ s'OBTINDRA D'UNA PAGINA POSTERIOR A NO SER QUE JA ESTIGUI DEFINIT
            if (signParams != null) {
                // XYZ ZZZ Check not null
                t.setSignParamFuncionariNom(signParams.getFunctionaryFullName());
                t.setSignParamFuncionariNif(signParams.getFunctionaryAdministrationID());
                t.setSignParamFuncionariDir3(signParams.getFunctionayDIR3Unit());
            }
        }

        if (tipusPerfil == Constants.PERFIL_US_CUSTODIA) {

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

                t.setArxiuReqParamDocEstatElabora(
                        arxiuReqParams.getDocumentElaborationState());

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
                t.setArxiuOptParamCustodyOrExpedientId(
                        arxiuOptParams.getCustodyIDOrExpedientID());
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

            log.error("\n\n  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX NOM => |" + t.getNom() + "|");

            TransaccioMultipleJPA traMul = new TransaccioMultipleJPA(transmultipleid,
                    t.getNom());
            transaccioMultipleEjb.create(traMul);

            String var = getTableNameVariable();

            // Actialitzam IDmultiple de la subtransaccio
            String sql = "UPDATE " + getTableName() + " " + var + " SET " + var + "."
                    + TransaccioFields.TRANSACCIOMULTIPLEID.javaName + " = ?1 " + "WHERE "
                    + var + "." + TransaccioFields.TRANSACCIOID.javaName + " = ?2";
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
        List<Metadada> metas = metadadaLogicaEjb.select(
                MetadadaFields.TRANSACCIOID.equal(transaccioOriginal.getTransaccioID()));

        for (Metadada metadada : metas) {
            MetadadaJPA metaJPA = MetadadaJPA.toJPA(metadada);
            metaJPA.setMetadadaid(0);
            metaJPA.setTransaccioID(transaccio.getTransaccioID());

            metadadaLogicaEjb.create(metaJPA);

        }

        return transaccio;
    }

    // Timeout de transacion
    @TransactionTimeout(value = TransaccioLogicaService.THREE_MINUTS_IN_SECONDS) // Units segons
    @Override
    @PermitAll
    public void netejaDeFitxersNocturnAplicacio() throws I18NException {

        netejaDeFitxersNocturn(true);

    }

    @TransactionTimeout(value = TransaccioLogicaService.THREE_MINUTS_IN_SECONDS) // Units segons
    @Override
    @PermitAll
    public void netejaDeFitxersNocturnPersona() throws I18NException {

        netejaDeFitxersNocturn(false);

    }

    protected void netejaDeFitxersNocturn(boolean isUtilitzatPerAplicacio)
            throws I18NException {

        final long start = System.currentTimeMillis();

        Integer days = isUtilitzatPerAplicacio
                ? Configuracio.getDiesPerNetejaDeFitxersAplicacio()
                : Configuracio.getDiesPerNetejaDeFitxersPersona();

        if (days == null) {
            log.info("Neteja de fitxers no es realitzarà: propietat val null.");

        } else {

            log.info("Neteja de fitxers de transaccions de tipus "
                    + (isUtilitzatPerAplicacio ? "Aplicacio" : "Persona")
                    + " es realitzarà: propietat val " + days + " dies");

            Where w1;

            if (isUtilitzatPerAplicacio == true) {
                w1 = USUARIAPLICACIOID.isNotNull();
            } else {
                w1 = USUARIPERSONAID.isNotNull();
            }

            Where w2;
            {
                Calendar date = Calendar.getInstance();
                date.add(Calendar.DATE, -1 * days);
                Timestamp ts = new Timestamp(date.getTimeInMillis());

                w2 = Where.AND(
                        Where.OR(TransaccioFields.FITXERESCANEJATID.isNotNull(),
                                TransaccioFields.FITXERSIGNATURAID.isNotNull()),
                        TransaccioFields.DATAINICI.lessThan(ts));
            }

            Where w = Where.AND(w1, w2);
            OrderBy order = new OrderBy(DATAINICI, OrderType.ASC);
            List<Long> list = this.executeQuery(TransaccioFields.TRANSACCIOID, w, order);

            final long TIMEOUT_MS =  (TransaccioLogicaService.THREE_MINUTS_IN_SECONDS - 1L * 60L) * 1000L;
            
            int processats = 0;
            
            int error = 0;

            for (Long transaccioID : list) {

                Transaccio t = this.findByPrimaryKey(transaccioID);
                Timestamp ts = t.getDataInici();
                long diff = start - ts.getTime();

                long diffDays = diff / (1000 * 60 * 60 * 24);
                log.info("Iniciant neteja dels fitxers de Transacció amb ID " + t.getTransaccioID() + " ("
                        + diffDays + " dies)");

                try {
                  netejaFitxers(t);
                  log.info("Neteja dels fitxers de la Transacció amb ID " + t.getTransaccioID() + " realitzada correctment.");
                  processats++;
                } catch (I18NException e) {
                    String msg = I18NLogicUtils.getMessage(e, new Locale("ca"));
                    log.error("Error cridant a netejarFitxers de la transaccio " + transaccioID + " : " + msg, e);
                    error++;
                } catch(Throwable th) {
                    log.error("Error cridant a netejarFitxers de la transaccio " + transaccioID + " : "+ th.getMessage(), th);
                    error++;
                }

                long now = System.currentTimeMillis();

                if (now > start + TIMEOUT_MS) {
                    log.warn(
                            "Hem tardat massa temps en esborrar fitxers. Sortim i demà acabarem amb els pendents.");
                    break;
                } else {
                    try {
                        Thread.sleep(300); // Aturam 300ms per no saturar
                    } catch (InterruptedException e) {
                    }
                }
            }

            log.info("Finalitzada Neteja de fitxers => Processats: " + processats + " | Error: " + error);

        }

    }

}
