package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface ITransaccioManager extends org.fundaciobit.genapp.common.query.ITableManager<Transaccio, Long> {


	public Transaccio create( java.lang.String _transactionWebId_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, java.lang.Long _usuariAplicacioId_, java.lang.Long _usuariPersonaId_, int _estatCodi_, java.lang.String _estatMissatge_, java.lang.String _estatExcepcio_, java.lang.Long _fitxerEscanejatID_, java.lang.Long _fitxerSignaturaID_, java.lang.Integer _infoScanPixelType_, java.lang.Integer _infoScanResolucioPpp_, boolean _infoScanOcr_, java.lang.Long _infoSignaturaID_, java.lang.Long _infoCustodyID_, java.lang.String _languageUI_, java.lang.String _languageDoc_, java.lang.String _ciutadaNif_, java.lang.String _ciutadaNom_, java.lang.String _funcionariUsername_, java.lang.String _funcionariNom_, java.lang.String _expedient_, java.lang.String _usernameRequest_, java.lang.String _returnUrl_, java.lang.Integer _view_, long _perfilID_, java.lang.String _ip_, java.lang.String _hashEscaneig_, java.lang.String _hashFirma_) throws I18NException;

	public Transaccio findByPrimaryKey(long _transaccioID_);

	public void delete(long _transaccioID_);

}
