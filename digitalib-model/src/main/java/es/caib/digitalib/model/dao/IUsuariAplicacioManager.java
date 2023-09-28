package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IUsuariAplicacioManager extends org.fundaciobit.genapp.common.query.ITableManager<UsuariAplicacio, Long> {


	public UsuariAplicacio create( java.lang.String _username_, java.lang.String _contrasenya_, java.lang.String _emailAdmin_, java.lang.String _descripcio_, boolean _actiu_, boolean _roleScan_, boolean _roleCoAu_, boolean _roleCust_) throws I18NException;

	public UsuariAplicacio findByPrimaryKey(long _usuariAplicacioID_);

	public void delete(long _usuariAplicacioID_);

}
