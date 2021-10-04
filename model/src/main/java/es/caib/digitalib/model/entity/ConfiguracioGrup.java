package es.caib.digitalib.model.entity;

public interface ConfiguracioGrup extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getConfiguracioGrupID();
	public void setConfiguracioGrupID(long _configuracioGrupID_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getSuportWeb();
	public void setSuportWeb(java.lang.String _suportWeb_);

	public java.lang.String getSuportEmail();
	public void setSuportEmail(java.lang.String _suportEmail_);

	public java.lang.String getSuportTelefon();
	public void setSuportTelefon(java.lang.String _suportTelefon_);

	public long getLogoHeaderID();
	public void setLogoHeaderID(long _logoHeaderID_);

	public long getLogoFooterID();
	public void setLogoFooterID(long _logoFooterID_);

	public java.lang.String getAdreza();
	public void setAdreza(java.lang.String _adreza_);

	public java.lang.String getCodiDir3PerDefecte();
	public void setCodiDir3PerDefecte(java.lang.String _codiDir3PerDefecte_);

	public java.lang.Long getPerfilNomesEscaneigID();
	public void setPerfilNomesEscaneigID(java.lang.Long _perfilNomesEscaneigID_);

	public java.lang.Long getPerfilNomesEscaneig2ID();
	public void setPerfilNomesEscaneig2ID(java.lang.Long _perfilNomesEscaneig2ID_);

	public java.lang.Long getPerfilCopiaAutenticaID();
	public void setPerfilCopiaAutenticaID(java.lang.Long _perfilCopiaAutenticaID_);

	public java.lang.Long getPerfilCopiaAutentica2ID();
	public void setPerfilCopiaAutentica2ID(java.lang.Long _perfilCopiaAutentica2ID_);

	public java.lang.Long getPerfilCustodiaID();
	public void setPerfilCustodiaID(java.lang.Long _perfilCustodiaID_);

	public java.lang.Long getPerfilCustodia2ID();
	public void setPerfilCustodia2ID(java.lang.Long _perfilCustodia2ID_);

  // Fitxer
  public <F extends Fitxer> F getLogoHeader();
  // Fitxer
  public <F extends Fitxer> F getLogoFooter();


  // ======================================

}