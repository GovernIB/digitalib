package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IInfoSignaturaManager extends org.fundaciobit.genapp.common.query.ITableManager<InfoSignatura, Long> {


	public InfoSignatura create( int _signOperation_, java.lang.String _signType_, java.lang.String _signAlgorithm_, java.lang.Integer _signMode_, java.lang.Integer _signaturesTableLocation_, boolean _timestampIncluded_, boolean _policyIncluded_, java.lang.String _eniTipoFirma_, java.lang.String _eniPerfilFirma_, java.lang.String _eniRolFirma_, java.lang.String _eniSignerName_, java.lang.String _eniSignerAdministrationId_, java.lang.String _eniSignLevel_, boolean _checkAdministrationIdOfSigner_, boolean _checkDocumentModifications_, boolean _checkValidationSignature_) throws I18NException;

	public InfoSignatura findByPrimaryKey(long _infoSignaturaID_);

	public void delete(long _infoSignaturaID_);

}
