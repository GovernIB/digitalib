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

  // Fitxer
  public <F extends Fitxer> F getLogoHeader();
  // Fitxer
  public <F extends Fitxer> F getLogoFooter();


  // ======================================

}
