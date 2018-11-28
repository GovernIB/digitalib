package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IInfoSignaturaManager extends org.fundaciobit.genapp.common.query.ITableManager<InfoSignatura, Long> {


	public InfoSignatura create( int _signoperation_, java.lang.String _signtype_, java.lang.String _signalgorithm_, java.lang.Integer _signmode_, java.lang.Integer _signaturestablelocation_, boolean _timestampincluded_, boolean _policyincluded_, java.lang.String _enitipofirma_, java.lang.String _eniperfilfirma_, java.lang.String _enirolfirma_, java.lang.String _enisignername_, java.lang.String _enisigneradministrationid_, java.lang.String _enisignlevel_, boolean _checkadministrationidofsigner_, boolean _checkdocumentmodifications_, boolean _checkvalidationsignature_) throws I18NException;

	public InfoSignatura findByPrimaryKey(long _infoSignaturaID_);

	public void delete(long _infoSignaturaID_);

}
