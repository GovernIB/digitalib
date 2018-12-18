package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPerfilManager extends org.fundaciobit.genapp.common.query.ITableManager<Perfil, Long> {


	public Perfil create( java.lang.String _codi_, java.lang.String _nom_, java.lang.String _descripcio_, java.lang.String _urlBase_, int _scanFormatFitxer_, java.lang.Integer _scanMinimaResolucio_, int _scanPixelType_, long _pluginScanWebID_, java.lang.Long _pluginScanWeb2ID_, int _tipusFirma_, java.lang.Long _apiSimpleID_, java.lang.Long _pluginFirmaServidorID_, int _tipusCustodia_, java.lang.Long _pluginArxiuID_, java.lang.Long _pluginDocCustodyID_, int _usPerfil_, java.lang.Boolean _utilitzatPerAplicacio_) throws I18NException;

	public Perfil findByPrimaryKey(long _perfilID_);

	public void delete(long _perfilID_);

}
