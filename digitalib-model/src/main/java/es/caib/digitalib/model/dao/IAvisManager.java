package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IAvisManager extends org.fundaciobit.genapp.common.query.ITableManager<Avis, Long> {


	public Avis create( long _descripcioID_, int _tipus_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, java.lang.Long _configGrupID_, boolean _bloquejar_) throws I18NException;

	public Avis findByPrimaryKey(long _avisID_);

	public void delete(long _avisID_);

}
