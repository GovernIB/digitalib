package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface ITransaccioMultipleManager extends org.fundaciobit.genapp.common.query.ITableManager<TransaccioMultiple, Long> {


	public TransaccioMultiple create( long _transmultipleid_, java.lang.String _descripcio_, java.lang.Long _fitxerEscanejatID_) throws I18NException;

	public TransaccioMultiple findByPrimaryKey(long _transmultipleid_);

	public void delete(long _transmultipleid_);

}
