package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IAuditoriaManager extends org.fundaciobit.genapp.common.query.ITableManager<Auditoria, Long> {


	public Auditoria create( java.sql.Timestamp _data_, long _transaccioId_, int _tipus_, java.lang.String _missatge_, java.lang.String _additionalInfo_, boolean _isApp_, java.lang.String _usernameAplicacio_, java.lang.String _usernamePersona_) throws I18NException;

	public Auditoria findByPrimaryKey(long _auditoriaID_);

	public void delete(long _auditoriaID_);

}
