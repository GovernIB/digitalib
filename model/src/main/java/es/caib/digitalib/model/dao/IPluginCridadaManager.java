package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPluginCridadaManager extends org.fundaciobit.genapp.common.query.ITableManager<PluginCridada, Long> {


	public PluginCridada create( java.sql.Timestamp _data_, java.lang.String _metodeplugin_, int _tipusresultat_, java.lang.Long _tempsexecucio_, long _pluginID_, java.lang.Long _usuaripersonaid_, java.lang.Long _usuariaplicacioid_, java.lang.String _parametrestext_, java.lang.Long _parametresFitxerID_, java.lang.String _retorntext_, java.lang.Long _retornFitxerID_) throws I18NException;

	public PluginCridada findByPrimaryKey(long _pluginCridadaID_);

	public void delete(long _pluginCridadaID_);

}
