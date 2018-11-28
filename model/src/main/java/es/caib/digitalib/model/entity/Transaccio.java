package es.caib.digitalib.model.entity;

public interface Transaccio extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getTransaccioID();
	public void setTransaccioID(long _transaccioID_);

	public java.lang.String getTransactionWebId();
	public void setTransactionWebId(java.lang.String _transactionWebId_);

	public java.sql.Timestamp getDataInici();
	public void setDataInici(java.sql.Timestamp _dataInici_);

	public java.sql.Timestamp getDataFi();
	public void setDataFi(java.sql.Timestamp _dataFi_);

	public java.lang.Long getUsuariAplicacioId();
	public void setUsuariAplicacioId(java.lang.Long _usuariAplicacioId_);

	public java.lang.Long getUsuariPersonaId();
	public void setUsuariPersonaId(java.lang.Long _usuariPersonaId_);

	public int getEstatCodi();
	public void setEstatCodi(int _estatCodi_);

	public java.lang.String getEstatMissatge();
	public void setEstatMissatge(java.lang.String _estatMissatge_);

	public java.lang.String getEstatExcepcio();
	public void setEstatExcepcio(java.lang.String _estatExcepcio_);

	public java.lang.Long getFitxerEscanejatID();
	public void setFitxerEscanejatID(java.lang.Long _fitxerEscanejatID_);

	public java.lang.Long getFitxerSignaturaID();
	public void setFitxerSignaturaID(java.lang.Long _fitxerSignaturaID_);

	public java.lang.Integer getInfoScanPixelType();
	public void setInfoScanPixelType(java.lang.Integer _infoScanPixelType_);

	public java.lang.Integer getInfoScanResolucioPpp();
	public void setInfoScanResolucioPpp(java.lang.Integer _infoScanResolucioPpp_);

	public boolean isInfoScanOcr();
	public void setInfoScanOcr(boolean _infoScanOcr_);

	public java.lang.Long getInfoSignaturaID();
	public void setInfoSignaturaID(java.lang.Long _infoSignaturaID_);

	public java.lang.Long getInfoCustodyID();
	public void setInfoCustodyID(java.lang.Long _infoCustodyID_);

	public java.lang.String getLanguageUI();
	public void setLanguageUI(java.lang.String _languageUI_);

	public java.lang.String getLanguageDoc();
	public void setLanguageDoc(java.lang.String _languageDoc_);

	public java.lang.String getCiutadaNif();
	public void setCiutadaNif(java.lang.String _ciutadaNif_);

	public java.lang.String getCiutadaNom();
	public void setCiutadaNom(java.lang.String _ciutadaNom_);

	public java.lang.String getFuncionariUsername();
	public void setFuncionariUsername(java.lang.String _funcionariUsername_);

	public java.lang.String getFuncionariNom();
	public void setFuncionariNom(java.lang.String _funcionariNom_);

	public java.lang.String getExpedient();
	public void setExpedient(java.lang.String _expedient_);

	public java.lang.String getUsernameRequest();
	public void setUsernameRequest(java.lang.String _usernameRequest_);

	public java.lang.String getReturnUrl();
	public void setReturnUrl(java.lang.String _returnUrl_);

	public java.lang.Integer getView();
	public void setView(java.lang.Integer _view_);

	public long getPerfilID();
	public void setPerfilID(long _perfilID_);

  // Fitxer
  public <F extends Fitxer> F getFitxerEscanejat();
  // Fitxer
  public <F extends Fitxer> F getFitxerSignatura();


  // ======================================

}
