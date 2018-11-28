
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.UsuariAplicacio;


public class UsuariAplicacioBean implements UsuariAplicacio {



private static final long serialVersionUID = 1703005582L;

	long usuariAplicacioID;// PK
	java.lang.String username;
	java.lang.String contrasenya;
	java.lang.String emailadmin;
	java.lang.String descripcio;
	boolean actiu;


  /** Constructor Buit */
  public UsuariAplicacioBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuariAplicacioBean(long usuariAplicacioID , java.lang.String username , java.lang.String contrasenya , java.lang.String emailadmin , java.lang.String descripcio , boolean actiu) {
    this.usuariAplicacioID=usuariAplicacioID;
    this.username=username;
    this.contrasenya=contrasenya;
    this.emailadmin=emailadmin;
    this.descripcio=descripcio;
    this.actiu=actiu;
}
  /** Constructor sense valors autoincrementals */
  public UsuariAplicacioBean(java.lang.String username , java.lang.String contrasenya , java.lang.String emailadmin , java.lang.String descripcio , boolean actiu) {
    this.username=username;
    this.contrasenya=contrasenya;
    this.emailadmin=emailadmin;
    this.descripcio=descripcio;
    this.actiu=actiu;
}
  /** Constructor dels valors Not Null */
  public UsuariAplicacioBean(long usuariAplicacioID , java.lang.String username , java.lang.String emailadmin , boolean actiu) {
    this.usuariAplicacioID=usuariAplicacioID;
    this.username=username;
    this.emailadmin=emailadmin;
    this.actiu=actiu;
}
  public UsuariAplicacioBean(UsuariAplicacio __bean) {
    this.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    this.setUsername(__bean.getUsername());
    this.setContrasenya(__bean.getContrasenya());
    this.setEmailadmin(__bean.getEmailadmin());
    this.setDescripcio(__bean.getDescripcio());
    this.setActiu(__bean.isActiu());
	}

	public long getUsuariAplicacioID() {
		return(usuariAplicacioID);
	};
	public void setUsuariAplicacioID(long _usuariAplicacioID_) {
		this.usuariAplicacioID = _usuariAplicacioID_;
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

	public java.lang.String getEmailadmin() {
		return(emailadmin);
	};
	public void setEmailadmin(java.lang.String _emailadmin_) {
		this.emailadmin = _emailadmin_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};



  // ======================================

  public static UsuariAplicacioBean toBean(UsuariAplicacio __bean) {
    if (__bean == null) { return null;}
    UsuariAplicacioBean __tmp = new UsuariAplicacioBean();
    __tmp.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setContrasenya(__bean.getContrasenya());
    __tmp.setEmailadmin(__bean.getEmailadmin());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setActiu(__bean.isActiu());
		return __tmp;
	}



}
