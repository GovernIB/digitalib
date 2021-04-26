package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IUsuariPersonaManager extends org.fundaciobit.genapp.common.query.ITableManager<UsuariPersona, Long> {


	public UsuariPersona create( java.lang.String _username_, java.lang.String _nom_, java.lang.String _llinatges_, java.lang.String _email_, java.lang.String _nif_, java.lang.String _idiomaID_, java.lang.Long _configuracioGrupID_, java.lang.String _unitatDir3_, boolean _roleScan_, boolean _roleCoAu_, boolean _roleCust_) throws I18NException;

	public UsuariPersona findByPrimaryKey(long _usuariPersonaID_);

	public void delete(long _usuariPersonaID_);

}
