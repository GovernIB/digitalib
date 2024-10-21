package es.caib.digitalib.logic;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.logic.apiscanwebsimple.v1.beans.ScanWebSimpleGetTransactionIdRequest;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.persistence.UsuariAplicacioJPA;
import es.caib.digitalib.persistence.UsuariPersonaJPA;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.TransaccioMultiple;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface TransaccioLogicaService extends es.caib.digitalib.ejb.TransaccioService {

    public static final String JNDI_NAME = "java:app/digitalib-ejb/TransaccioLogicaEJB";

    public static final int THREE_MINUTS_IN_SECONDS = 3 * 60;

    public static final String SEPARADOR_ESCANEIG_MASSIU_NOM = "separador_escanig_massiu.pdf";

    /**
     * 
     * @return
     * @throws Exception
     */
    public MassiveScanWebSimpleFile getSeparator() throws Exception;

    /**
     * 
     * @param transaccio
     * @param usernameApp
     * @param usernamePerson
     * @return
     * @throws I18NException
     */
    public Set<Long> deleteFull(Transaccio transaccio, String usernameApp, String usernamePerson) throws I18NException;

    /**
     * 
     * @param transaccioID
     * @throws I18NException
     */
    public void netejaFitxers(Long transaccioID) throws I18NException;

    /**
     * 
     * @param transactionWebID
     * @return
     * @throws I18NException
     */
    public TransaccioJPA searchTransaccioByTransactionWebID(String transactionWebID) throws I18NException;

    /**
     * 
     * @param transactionWebID
     * @return
     * @throws I18NException
     */
    public List<TransaccioJPA> searchMassiveTransaccioByTransactionWebID(String transactionWebID) throws I18NException;

    /**
     * 
     * @param transaccioMultipleID
     * @return
     * @throws I18NException
     */
    public List<TransaccioJPA> searchMassiveTransaccioByTransaccioMultipleID(long transaccioMultipleID)
            throws I18NException;

    /**
     * retorna un array de sencers de dues posicions:
     *     - Posició 0: Compte les transaccions associades a una Transacció Massiva
     *     - Posició 1: Numero de transaccions acabades amb OK
     * @param transaccioMultipleID
     * @return
     * @throws I18NException
     */
    public Long[] countTransaccionsByTransaccioMultipleID(long transaccioMultipleID) throws I18NException;

    /**
     * 
     * @param _ID_
     * @return
     */
    public TransaccioJPA findByPrimaryKeyFull(Long _ID_);

    /**
     * 
     * @param transaccioMultipleID
     * @return
     * @throws I18NException
     */
    public TransaccioMultiple findTransaccioMultipleByPrimaryKey(Long transaccioMultipleID) throws I18NException;

    /**
     * 
     * @param tm
     * @return
     * @throws I18NException
     */
    public TransaccioMultiple updateTransaccioMultiple(TransaccioMultiple tm) throws I18NException;

    /**
     * 
     * @return
     */
    public String generateTransactionWebID();

    /**
     * 
     * @param requestTransaction
     * @param usuariAplicacio
     * @param usuariPersona
     * @return
     * @throws I18NException
     */
    public TransaccioJPA crearTransaccio(ScanWebSimpleGetTransactionIdRequest requestTransaction,
            UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase, String returnURL,
            String ip) throws I18NException;

    /**
     * 
     * @param requestTransaction
     * @param usuariAplicacio
     * @param usuariPersona
     * @return
     * @throws I18NException
     */
    public TransaccioJPA crearTransaccio(MassiveScanWebSimpleGetTransactionIdRequest requestTransaction,
            UsuariAplicacioJPA usuariAplicacio, UsuariPersonaJPA usuariPersona, String urlBase, String returnURL,
            String ip) throws I18NException;

    /**
     * 
     * @param transaccioOriginal
     * @param nom
     * @return
     * @throws I18NException
     */
    public TransaccioJPA cloneTransaccio(TransaccioJPA transaccioOriginal, String nom) throws I18NException;

    @Override
    public Transaccio update(Transaccio __bean) throws I18NException;

    /**
     * 
     * @throws I18NException
     */
    public void netejaDeFitxersNocturnAplicacio() throws I18NException;

    /**
     * 
     * @throws I18NException
     */
    public void netejaDeFitxersNocturnPersona() throws I18NException;

    /**
     * 
     * @return
     * @throws I18NException
     */
    public Where getWhereForExpiredTransactions() throws I18NException;

    /**
     * 
     * @throws I18NException
     */
    public List<Transaccio> expiraTransaccionsCaducades() throws I18NException;

    /**
     * 
     * @throws I18NException
     */
    public List<Transaccio> expiraTransaccionsCaducades(List<Long> transactionsID) throws I18NException;

    /**
     * 
     * @param transactionsID
     * @return
     * @throws I18NException
     */
    public List<Transaccio> regenerarTransaccionsSenseHashDeFitxer(List<Long> transactionsID) throws I18NException;
}
