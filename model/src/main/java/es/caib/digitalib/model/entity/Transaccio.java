package es.caib.digitalib.model.entity;

public interface Transaccio extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getTransaccioID();
	public void setTransaccioID(long _transaccioID_);

	public java.lang.String getTransactionWebId();
	public void setTransactionWebId(java.lang.String _transactionWebId_);

	public java.sql.Timestamp getDataInici();
	public void setDataInici(java.sql.Timestamp _dataInici_);

	public java.sql.Timestamp getDatafi();
	public void setDatafi(java.sql.Timestamp _datafi_);

	public java.lang.Long getUsuariaplicacioid();
	public void setUsuariaplicacioid(java.lang.Long _usuariaplicacioid_);

	public java.lang.Long getUsuaripersonaid();
	public void setUsuaripersonaid(java.lang.Long _usuaripersonaid_);

	public int getEstatcodi();
	public void setEstatcodi(int _estatcodi_);

	public java.lang.String getEstatmissatge();
	public void setEstatmissatge(java.lang.String _estatmissatge_);

	public java.lang.String getEstatexcepcio();
	public void setEstatexcepcio(java.lang.String _estatexcepcio_);

	public java.lang.Long getFitxerEscanejatID();
	public void setFitxerEscanejatID(java.lang.Long _fitxerEscanejatID_);

	public java.lang.Long getFitxerSignaturaID();
	public void setFitxerSignaturaID(java.lang.Long _fitxerSignaturaID_);

	public java.lang.Integer getInfoscanpixeltype();
	public void setInfoscanpixeltype(java.lang.Integer _infoscanpixeltype_);

	public java.lang.Integer getInfoscanresolucioppp();
	public void setInfoscanresolucioppp(java.lang.Integer _infoscanresolucioppp_);

	public boolean isInfoscanocr();
	public void setInfoscanocr(boolean _infoscanocr_);

	public java.lang.Long getInfosignaturaid();
	public void setInfosignaturaid(java.lang.Long _infosignaturaid_);

	public java.lang.Long getInfocustodyid();
	public void setInfocustodyid(java.lang.Long _infocustodyid_);

	public java.lang.String getLanguageui();
	public void setLanguageui(java.lang.String _languageui_);

	public java.lang.String getLanguagedoc();
	public void setLanguagedoc(java.lang.String _languagedoc_);

	public java.lang.String getCiutadanif();
	public void setCiutadanif(java.lang.String _ciutadanif_);

	public java.lang.String getCiutadanom();
	public void setCiutadanom(java.lang.String _ciutadanom_);

	public java.lang.String getFuncionariusername();
	public void setFuncionariusername(java.lang.String _funcionariusername_);

	public java.lang.String getFuncionarinom();
	public void setFuncionarinom(java.lang.String _funcionarinom_);

	public java.lang.String getExpedient();
	public void setExpedient(java.lang.String _expedient_);

	public long getPerfilid();
	public void setPerfilid(long _perfilid_);

	public java.lang.String getUsernameRequest();
	public void setUsernameRequest(java.lang.String _usernameRequest_);

	public java.lang.String getReturnUrl();
	public void setReturnUrl(java.lang.String _returnUrl_);

	public int getView();
	public void setView(int _view_);

  // Fitxer
  public <F extends Fitxer> F getFitxerEscanejat();
  // Fitxer
  public <F extends Fitxer> F getFitxerSignatura();


  // ======================================

}
