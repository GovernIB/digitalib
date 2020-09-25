package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface ITransaccioManager extends org.fundaciobit.genapp.common.query.ITableManager<Transaccio, Long> {


	public Transaccio create( java.lang.String _nom_, java.lang.String _transactionWebId_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, java.lang.Long _usuariAplicacioId_, java.lang.Long _usuariPersonaId_, java.lang.String _ip_, java.lang.String _returnUrl_, int _estatCodi_, java.lang.String _estatMissatge_, java.lang.String _estatExcepcio_, java.lang.Long _fitxerEscanejatID_, java.lang.String _hashEscaneig_, java.lang.Long _fitxerSignaturaID_, java.lang.String _hashFirma_, java.lang.String _infoScanPaperSize_, java.lang.Integer _infoScanPixelType_, java.lang.Integer _infoScanResolucioPpp_, java.lang.Boolean _infoScanOcr_, java.sql.Timestamp _infoScanDataCaptura_, java.lang.Integer _view_, java.lang.String _languageUI_, java.lang.String _funcionariUsername_, java.lang.String _signParamFuncionariNom_, java.lang.String _signParamFuncionariNif_, java.lang.String _signParamLanguageDoc_, java.lang.String _arxiuReqParamDocEstatElabora_, java.lang.String _arxiuReqParamDocumentTipus_, java.lang.Integer _arxiuReqParamOrigen_, java.lang.String _arxiuReqParamInteressats_, java.lang.String _arxiuReqParamCiutadaNif_, java.lang.String _arxiuReqParamCiutadaNom_, java.lang.String _arxiuReqParamOrgans_, java.lang.String _arxiuOptParamProcedimentCodi_, java.lang.String _arxiuOptParamProcedimentNom_, java.lang.String _arxiuOptParamSerieDocumental_, java.lang.String _arxiuOptParamCustodyOrExpedientId_, long _perfilID_, java.lang.Long _infoSignaturaID_, java.lang.Long _infoCustodyID_, java.lang.Long _transaccioMultipleID_) throws I18NException;

	public Transaccio findByPrimaryKey(long _transaccioID_);

	public void delete(long _transaccioID_);

}
