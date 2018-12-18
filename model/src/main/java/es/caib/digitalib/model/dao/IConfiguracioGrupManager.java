package es.caib.digitalib.model.dao;

import es.caib.digitalib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IConfiguracioGrupManager extends org.fundaciobit.genapp.common.query.ITableManager<ConfiguracioGrup, Long> {


	public ConfiguracioGrup create( java.lang.String _nom_, java.lang.String _suportWeb_, java.lang.String _suportEmail_, java.lang.String _suportTelefon_, long _logoHeaderID_, long _logoFooterID_, java.lang.String _adreza_, java.lang.Long _perfilNomesEscaneigID_, java.lang.Long _perfilNomesEscaneig2ID_, java.lang.Long _perfilCopiaAutenticaID_, java.lang.Long _perfilCopiaAutentica2ID_, java.lang.Long _perfilCustodiaID_, java.lang.Long _perfilCustodia2ID_) throws I18NException;

	public ConfiguracioGrup findByPrimaryKey(long _configuracioGrupID_);

	public void delete(long _configuracioGrupID_);

}
