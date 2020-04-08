package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IMetadadaManager extends org.fundaciobit.genapp.common.query.ITableManager<Metadada, Long> {


	public Metadada create( long _transaccioID_, java.lang.String _nom_, java.lang.String _valor_) throws I18NException;

	public Metadada findByPrimaryKey(long _metadadaid_);

	public void delete(long _metadadaid_);

}
