package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPerfilUsuariAplicacioManager extends org.fundaciobit.genapp.common.query.ITableManager<PerfilUsuariAplicacio, Long> {


	public PerfilUsuariAplicacio create( long _perfilID_, long _usuariAplicacioID_) throws I18NException;

	public PerfilUsuariAplicacio findByPrimaryKey(long _perfilUsrAppID_);

	public void delete(long _perfilUsrAppID_);

}
