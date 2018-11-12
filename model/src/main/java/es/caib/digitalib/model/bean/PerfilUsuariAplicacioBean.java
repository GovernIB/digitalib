
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;


public class PerfilUsuariAplicacioBean implements PerfilUsuariAplicacio {



private static final long serialVersionUID = -1483147230L;

	long perfilUsrAppID;// PK
	long perfilID;
	long usuariAplicacioID;


  /** Constructor Buit */
  public PerfilUsuariAplicacioBean() {
  }

  /** Constructor amb tots els camps  */
  public PerfilUsuariAplicacioBean(long perfilUsrAppID , long perfilID , long usuariAplicacioID) {
    this.perfilUsrAppID=perfilUsrAppID;
    this.perfilID=perfilID;
    this.usuariAplicacioID=usuariAplicacioID;
}
  /** Constructor sense valors autoincrementals */
  public PerfilUsuariAplicacioBean(long perfilID , long usuariAplicacioID) {
    this.perfilID=perfilID;
    this.usuariAplicacioID=usuariAplicacioID;
}
  public PerfilUsuariAplicacioBean(PerfilUsuariAplicacio __bean) {
    this.setPerfilUsrAppID(__bean.getPerfilUsrAppID());
    this.setPerfilID(__bean.getPerfilID());
    this.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
	}

	public long getPerfilUsrAppID() {
		return(perfilUsrAppID);
	};
	public void setPerfilUsrAppID(long _perfilUsrAppID_) {
		this.perfilUsrAppID = _perfilUsrAppID_;
	};

	public long getPerfilID() {
		return(perfilID);
	};
	public void setPerfilID(long _perfilID_) {
		this.perfilID = _perfilID_;
	};

	public long getUsuariAplicacioID() {
		return(usuariAplicacioID);
	};
	public void setUsuariAplicacioID(long _usuariAplicacioID_) {
		this.usuariAplicacioID = _usuariAplicacioID_;
	};



  // ======================================

  public static PerfilUsuariAplicacioBean toBean(PerfilUsuariAplicacio __bean) {
    if (__bean == null) { return null;}
    PerfilUsuariAplicacioBean __tmp = new PerfilUsuariAplicacioBean();
    __tmp.setPerfilUsrAppID(__bean.getPerfilUsrAppID());
    __tmp.setPerfilID(__bean.getPerfilID());
    __tmp.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
		return __tmp;
	}



}
