package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface ITransaccioManager extends org.fundaciobit.genapp.common.query.ITableManager<Transaccio, Long> {


	public Transaccio create( java.sql.Timestamp _datainici_, java.sql.Timestamp _datafi_, java.lang.Long _usuariaplicacioid_, java.lang.Long _usuaripersonaid_) throws I18NException;

	public Transaccio findByPrimaryKey(long _transaccioID_);

	public void delete(long _transaccioID_);

}
