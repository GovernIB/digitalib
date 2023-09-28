package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPluginCridadaManager extends org.fundaciobit.genapp.common.query.ITableManager<PluginCridada, Long> {


	public PluginCridada create( java.sql.Timestamp _data_, long _pluginID_, java.lang.String _metodePlugin_, int _tipusResultat_, java.lang.Long _tempsExecucio_, java.lang.Long _usuariPersonaId_, java.lang.Long _usuariAplicacioId_, java.lang.String _parametresText_, java.lang.Long _parametresFitxerID_, java.lang.String _retornText_, java.lang.Long _retornFitxerID_) throws I18NException;

	public PluginCridada findByPrimaryKey(long _pluginCridadaID_);

	public void delete(long _pluginCridadaID_);

}
