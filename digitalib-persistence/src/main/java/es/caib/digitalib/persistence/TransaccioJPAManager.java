
package es.caib.digitalib.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import es.caib.digitalib.model.entity.*;
import es.caib.digitalib.model.fields.*;
import es.caib.digitalib.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class TransaccioJPAManager
         extends AbstractJPAManager<Transaccio, Long>
         implements TransaccioIJPAManager, ITransaccioManager, TransaccioFields {



    public static final TableName<Transaccio> _TABLENAME =  new TableName<Transaccio>("TransaccioJPA");


    @PersistenceContext
    protected EntityManager __em;

    public TransaccioJPAManager() {
    }

    protected TransaccioJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return TransaccioJPA. class;
    }



    public TableName<Transaccio> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Transaccio[] listToArray(List<Transaccio> list)  {
        if(list == null) { return null; };
        return list.toArray(new Transaccio[list.size()]);
    };

    public Transaccio create( java.lang.Long _transaccioMultipleID_, java.lang.String _nom_, java.lang.String _transactionWebId_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, java.lang.Long _usuariAplicacioId_, java.lang.Long _usuariPersonaId_, java.lang.String _ip_, java.lang.String _returnUrl_, int _estatCodi_, java.lang.String _estatMissatge_, java.lang.String _estatExcepcio_, java.lang.Long _fitxerEscanejatID_, java.lang.String _hashEscaneig_, java.lang.Long _fitxerSignaturaID_, java.lang.String _hashFirma_, java.lang.String _infoScanPaperSize_, java.lang.Integer _infoScanPixelType_, java.lang.Integer _infoScanResolucioPpp_, java.lang.Boolean _infoScanOcr_, java.lang.Boolean _infoScanDuplex_, java.sql.Timestamp _infoScanDataCaptura_, java.lang.String _infoScanLanguageDoc_, java.lang.String _infoScanDocumentTipus_, java.lang.Integer _view_, java.lang.String _languageUI_, java.lang.String _funcionariUsername_, java.lang.String _signParamFuncionariNom_, java.lang.String _signParamFuncionariNif_, java.lang.String _signParamFuncionariDir3_, java.lang.String _arxiuReqParamDocEstatElabora_, java.lang.Integer _arxiuReqParamOrigen_, java.lang.String _arxiuReqParamInteressats_, java.lang.String _arxiuReqParamCiutadaNif_, java.lang.String _arxiuReqParamCiutadaNom_, java.lang.String _arxiuReqParamOrgans_, java.lang.String _arxiuOptParamProcedimentCodi_, java.lang.String _arxiuOptParamProcedimentNom_, java.lang.String _arxiuOptParamSerieDocumental_, java.lang.String _arxiuOptParamCustodyOrExpedientId_, long _perfilID_, java.lang.Long _infoSignaturaID_, java.lang.Long _infoCustodyID_) throws I18NException {
        TransaccioJPA __bean =  new TransaccioJPA(_transaccioMultipleID_,_nom_,_transactionWebId_,_dataInici_,_dataFi_,_usuariAplicacioId_,_usuariPersonaId_,_ip_,_returnUrl_,_estatCodi_,_estatMissatge_,_estatExcepcio_,_fitxerEscanejatID_,_hashEscaneig_,_fitxerSignaturaID_,_hashFirma_,_infoScanPaperSize_,_infoScanPixelType_,_infoScanResolucioPpp_,_infoScanOcr_,_infoScanDuplex_,_infoScanDataCaptura_,_infoScanLanguageDoc_,_infoScanDocumentTipus_,_view_,_languageUI_,_funcionariUsername_,_signParamFuncionariNom_,_signParamFuncionariNif_,_signParamFuncionariDir3_,_arxiuReqParamDocEstatElabora_,_arxiuReqParamOrigen_,_arxiuReqParamInteressats_,_arxiuReqParamCiutadaNif_,_arxiuReqParamCiutadaNom_,_arxiuReqParamOrgans_,_arxiuOptParamProcedimentCodi_,_arxiuOptParamProcedimentNom_,_arxiuOptParamSerieDocumental_,_arxiuOptParamCustodyOrExpedientId_,_perfilID_,_infoSignaturaID_,_infoCustodyID_);
        return create(__bean);
    }



 public void delete(long _transaccioID_) {
   delete(findByPrimaryKey(_transaccioID_));
 }




    public Transaccio findByPrimaryKey(long _transaccioID_) {
        return __em.find(TransaccioJPA.class, _transaccioID_);  
    }
    @Override
    protected Transaccio getJPAInstance(Transaccio __bean) {
        return convertToJPA(__bean);
    }


    public static TransaccioJPA convertToJPA(Transaccio __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof TransaccioJPA) {
        return (TransaccioJPA)__bean;
      }
      
      return TransaccioJPA.toJPA(__bean);
    }


}