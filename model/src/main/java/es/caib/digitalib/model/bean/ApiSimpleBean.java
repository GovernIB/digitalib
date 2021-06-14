
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.ApiSimple;


public class ApiSimpleBean implements ApiSimple {



private static final long serialVersionUID = 541048348L;

	long apiSimpleID;// PK
	java.lang.String nom;
	java.lang.String url;
	java.lang.String username;
	java.lang.String contrasenya;
	java.lang.String perfil;
	java.lang.String configDeFirma;


  /** Constructor Buit */
  public ApiSimpleBean() {
  }

  /** Constructor amb tots els camps  */
  public ApiSimpleBean(long apiSimpleID , java.lang.String nom , java.lang.String url , java.lang.String username , java.lang.String contrasenya , java.lang.String perfil , java.lang.String configDeFirma) {
    this.apiSimpleID=apiSimpleID;
    this.nom=nom;
    this.url=url;
    this.username=username;
    this.contrasenya=contrasenya;
    this.perfil=perfil;
    this.configDeFirma=configDeFirma;
}
  /** Constructor sense valors autoincrementals */
  public ApiSimpleBean(java.lang.String nom , java.lang.String url , java.lang.String username , java.lang.String contrasenya , java.lang.String perfil , java.lang.String configDeFirma) {
    this.nom=nom;
    this.url=url;
    this.username=username;
    this.contrasenya=contrasenya;
    this.perfil=perfil;
    this.configDeFirma=configDeFirma;
}
  public ApiSimpleBean(ApiSimple __bean) {
    this.setApiSimpleID(__bean.getApiSimpleID());
    this.setNom(__bean.getNom());
    this.setUrl(__bean.getUrl());
    this.setUsername(__bean.getUsername());
    this.setContrasenya(__bean.getContrasenya());
    this.setPerfil(__bean.getPerfil());
    this.setConfigDeFirma(__bean.getConfigDeFirma());
	}

	public long getApiSimpleID() {
		return(apiSimpleID);
	};
	public void setApiSimpleID(long _apiSimpleID_) {
		this.apiSimpleID = _apiSimpleID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getUrl() {
		return(url);
	};
	public void setUrl(java.lang.String _url_) {
		this.url = _url_;
	};

	public java.lang.String getUsername() {
		return(username);
	};
	public void setUsername(java.lang.String _username_) {
		this.username = _username_;
	};

	public java.lang.String getContrasenya() {
		return(contrasenya);
	};
	public void setContrasenya(java.lang.String _contrasenya_) {
		this.contrasenya = _contrasenya_;
	};

	public java.lang.String getPerfil() {
		return(perfil);
	};
	public void setPerfil(java.lang.String _perfil_) {
		this.perfil = _perfil_;
	};

	public java.lang.String getConfigDeFirma() {
		return(configDeFirma);
	};
	public void setConfigDeFirma(java.lang.String _configDeFirma_) {
		this.configDeFirma = _configDeFirma_;
	};



  // ======================================

  public static ApiSimpleBean toBean(ApiSimple __bean) {
    if (__bean == null) { return null;}
    ApiSimpleBean __tmp = new ApiSimpleBean();
    __tmp.setApiSimpleID(__bean.getApiSimpleID());
    __tmp.setNom(__bean.getNom());
    __tmp.setUrl(__bean.getUrl());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setContrasenya(__bean.getContrasenya());
    __tmp.setPerfil(__bean.getPerfil());
    __tmp.setConfigDeFirma(__bean.getConfigDeFirma());
		return __tmp;
	}



}
