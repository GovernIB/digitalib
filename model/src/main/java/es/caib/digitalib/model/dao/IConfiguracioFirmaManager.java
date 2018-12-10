package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IConfiguracioFirmaManager extends org.fundaciobit.genapp.common.query.ITableManager<ConfiguracioFirma, Long> {


	public ConfiguracioFirma create( int _usPoliticaDeFirma_, java.lang.String _policyIdentifier_, java.lang.String _policyIdentifierHash_, java.lang.String _policyIdentifierHashAlgorithm_, java.lang.String _policyUrlDocument_, int _tipusOperacioFirma_, int _tipusFirmaID_, java.lang.Integer _algorismeDeFirmaID_, boolean _modeDeFirma_, int _politicaTaulaFirmes_, int _posicioTaulaFirmesID_, java.lang.Long _firmatPerFormatID_, java.lang.Long _motiuDelegacioID_, java.lang.String _propietatsTaulaFirmes_, java.lang.Long _pluginSegellatID_) throws I18NException;

	public ConfiguracioFirma findByPrimaryKey(long _configuracioFirmaID_);

	public void delete(long _configuracioFirmaID_);

}
