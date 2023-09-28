
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.UsuariAplicacio;


public class UsuariAplicacioBean implements UsuariAplicacio {



	long usuariAplicacioID;// PK
	java.lang.String username;
	java.lang.String contrasenya;
	java.lang.String emailAdmin;
	java.lang.String descripcio;
	boolean actiu;
	boolean roleScan;
	boolean roleCoAu;
	boolean roleCust;


  /** Constructor Buit */
  public UsuariAplicacioBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuariAplicacioBean(long usuariAplicacioID , java.lang.String username , java.lang.String contrasenya , java.lang.String emailAdmin , java.lang.String descripcio , boolean actiu , boolean roleScan , boolean roleCoAu , boolean roleCust) {
    this.usuariAplicacioID=usuariAplicacioID;
    this.username=username;
    this.contrasenya=contrasenya;
    this.emailAdmin=emailAdmin;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.roleScan=roleScan;
    this.roleCoAu=roleCoAu;
    this.roleCust=roleCust;
}
  /** Constructor sense valors autoincrementals */
  public UsuariAplicacioBean(java.lang.String username , java.lang.String contrasenya , java.lang.String emailAdmin , java.lang.String descripcio , boolean actiu , boolean roleScan , boolean roleCoAu , boolean roleCust) {
    this.username=username;
    this.contrasenya=contrasenya;
    this.emailAdmin=emailAdmin;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.roleScan=roleScan;
    this.roleCoAu=roleCoAu;
    this.roleCust=roleCust;
}
  /** Constructor dels valors Not Null */
  public UsuariAplicacioBean(long usuariAplicacioID , java.lang.String username , java.lang.String emailAdmin , boolean actiu , boolean roleScan , boolean roleCoAu , boolean roleCust) {
    this.usuariAplicacioID=usuariAplicacioID;
    this.username=username;
    this.emailAdmin=emailAdmin;
    this.actiu=actiu;
    this.roleScan=roleScan;
    this.roleCoAu=roleCoAu;
    this.roleCust=roleCust;
}
  public UsuariAplicacioBean(UsuariAplicacio __bean) {
    this.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    this.setUsername(__bean.getUsername());
    this.setContrasenya(__bean.getContrasenya());
    this.setEmailAdmin(__bean.getEmailAdmin());
    this.setDescripcio(__bean.getDescripcio());
    this.setActiu(__bean.isActiu());
    this.setRoleScan(__bean.isRoleScan());
    this.setRoleCoAu(__bean.isRoleCoAu());
    this.setRoleCust(__bean.isRoleCust());
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

	public java.lang.String getEmailAdmin() {
		return(emailAdmin);
	};
	public void setEmailAdmin(java.lang.String _emailAdmin_) {
		this.emailAdmin = _emailAdmin_;
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

	public boolean isRoleScan() {
		return(roleScan);
	};
	public void setRoleScan(boolean _roleScan_) {
		this.roleScan = _roleScan_;
	};

	public boolean isRoleCoAu() {
		return(roleCoAu);
	};
	public void setRoleCoAu(boolean _roleCoAu_) {
		this.roleCoAu = _roleCoAu_;
	};

	public boolean isRoleCust() {
		return(roleCust);
	};
	public void setRoleCust(boolean _roleCust_) {
		this.roleCust = _roleCust_;
	};



  // ======================================

  public static UsuariAplicacioBean toBean(UsuariAplicacio __bean) {
    if (__bean == null) { return null;}
    UsuariAplicacioBean __tmp = new UsuariAplicacioBean();
    __tmp.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setContrasenya(__bean.getContrasenya());
    __tmp.setEmailAdmin(__bean.getEmailAdmin());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setActiu(__bean.isActiu());
    __tmp.setRoleScan(__bean.isRoleScan());
    __tmp.setRoleCoAu(__bean.isRoleCoAu());
    __tmp.setRoleCust(__bean.isRoleCust());
		return __tmp;
	}



}
