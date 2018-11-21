package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IInfoCustodyManager extends org.fundaciobit.genapp.common.query.ITableManager<InfoCustody, Long> {


	public InfoCustody create( java.lang.String _custodyFileId_, java.lang.String _custodyFileUrl_, java.lang.String _csv_, java.lang.String _csvValidationWeb_, java.lang.String _csvGenerationDefinition_) throws I18NException;

	public InfoCustody findByPrimaryKey(long _infoCustodyID_);

	public void delete(long _infoCustodyID_);

}
