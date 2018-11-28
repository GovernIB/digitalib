package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface ITransaccioManager extends org.fundaciobit.genapp.common.query.ITableManager<Transaccio, Long> {


	public Transaccio create( java.lang.String _transactionWebId_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _datafi_, java.lang.Long _usuariaplicacioid_, java.lang.Long _usuaripersonaid_, int _estatCodi_, java.lang.String _estatmissatge_, java.lang.String _estatexcepcio_, java.lang.Long _fitxerEscanejatID_, java.lang.Long _fitxerSignaturaID_, java.lang.Integer _infoscanpixeltype_, java.lang.Integer _infoscanresolucioppp_, boolean _infoscanocr_, java.lang.Long _infosignaturaid_, java.lang.Long _infocustodyid_, java.lang.String _languageui_, java.lang.String _languagedoc_, java.lang.String _ciutadanif_, java.lang.String _ciutadanom_, java.lang.String _funcionariusername_, java.lang.String _funcionarinom_, java.lang.String _expedient_, long _perfilid_, java.lang.String _usernameRequest_, java.lang.String _returnUrl_, java.lang.Integer _view_) throws I18NException;

	public Transaccio findByPrimaryKey(long _transaccioID_);

	public void delete(long _transaccioID_);

}
