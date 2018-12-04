package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IApiSimpleManager extends org.fundaciobit.genapp.common.query.ITableManager<ApiSimple, Long> {


	public ApiSimple create( java.lang.String _nom_, java.lang.String _url_, java.lang.String _username_, java.lang.String _contrasenya_, java.lang.String _perfil_) throws I18NException;

	public ApiSimple findByPrimaryKey(long _apiSimpleID_);

	public void delete(long _apiSimpleID_);

}
