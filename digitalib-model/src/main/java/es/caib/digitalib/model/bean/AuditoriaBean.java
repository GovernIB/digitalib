
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Auditoria;


public class AuditoriaBean implements Auditoria {



	long auditoriaID;// PK
	java.sql.Timestamp data;
	long transaccioId;
	int tipus;
	java.lang.String missatge;
	java.lang.String additionalInfo;
	boolean isApp;
	java.lang.String usernameAplicacio;
	java.lang.String usernamePersona;


  /** Constructor Buit */
  public AuditoriaBean() {
  }

  /** Constructor amb tots els camps  */
  public AuditoriaBean(long auditoriaID , java.sql.Timestamp data , long transaccioId , int tipus , java.lang.String missatge , java.lang.String additionalInfo , boolean isApp , java.lang.String usernameAplicacio , java.lang.String usernamePersona) {
    this.auditoriaID=auditoriaID;
    this.data=data;
    this.transaccioId=transaccioId;
    this.tipus=tipus;
    this.missatge=missatge;
    this.additionalInfo=additionalInfo;
    this.isApp=isApp;
    this.usernameAplicacio=usernameAplicacio;
    this.usernamePersona=usernamePersona;
}
  /** Constructor sense valors autoincrementals */
  public AuditoriaBean(java.sql.Timestamp data , long transaccioId , int tipus , java.lang.String missatge , java.lang.String additionalInfo , boolean isApp , java.lang.String usernameAplicacio , java.lang.String usernamePersona) {
    this.data=data;
    this.transaccioId=transaccioId;
    this.tipus=tipus;
    this.missatge=missatge;
    this.additionalInfo=additionalInfo;
    this.isApp=isApp;
    this.usernameAplicacio=usernameAplicacio;
    this.usernamePersona=usernamePersona;
}
  /** Constructor dels valors Not Null */
  public AuditoriaBean(long auditoriaID , java.sql.Timestamp data , long transaccioId , int tipus , java.lang.String missatge , boolean isApp) {
    this.auditoriaID=auditoriaID;
    this.data=data;
    this.transaccioId=transaccioId;
    this.tipus=tipus;
    this.missatge=missatge;
    this.isApp=isApp;
}
  public AuditoriaBean(Auditoria __bean) {
    this.setAuditoriaID(__bean.getAuditoriaID());
    this.setData(__bean.getData());
    this.setTransaccioId(__bean.getTransaccioId());
    this.setTipus(__bean.getTipus());
    this.setMissatge(__bean.getMissatge());
    this.setAdditionalInfo(__bean.getAdditionalInfo());
    this.setIsApp(__bean.isIsApp());
    this.setUsernameAplicacio(__bean.getUsernameAplicacio());
    this.setUsernamePersona(__bean.getUsernamePersona());
	}

	public long getAuditoriaID() {
		return(auditoriaID);
	};
	public void setAuditoriaID(long _auditoriaID_) {
		this.auditoriaID = _auditoriaID_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public long getTransaccioId() {
		return(transaccioId);
	};
	public void setTransaccioId(long _transaccioId_) {
		this.transaccioId = _transaccioId_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
	};

	public java.lang.String getMissatge() {
		return(missatge);
	};
	public void setMissatge(java.lang.String _missatge_) {
		this.missatge = _missatge_;
	};

	public java.lang.String getAdditionalInfo() {
		return(additionalInfo);
	};
	public void setAdditionalInfo(java.lang.String _additionalInfo_) {
		this.additionalInfo = _additionalInfo_;
	};

	public boolean isIsApp() {
		return(isApp);
	};
	public void setIsApp(boolean _isApp_) {
		this.isApp = _isApp_;
	};

	public java.lang.String getUsernameAplicacio() {
		return(usernameAplicacio);
	};
	public void setUsernameAplicacio(java.lang.String _usernameAplicacio_) {
		this.usernameAplicacio = _usernameAplicacio_;
	};

	public java.lang.String getUsernamePersona() {
		return(usernamePersona);
	};
	public void setUsernamePersona(java.lang.String _usernamePersona_) {
		this.usernamePersona = _usernamePersona_;
	};



  // ======================================

  public static AuditoriaBean toBean(Auditoria __bean) {
    if (__bean == null) { return null;}
    AuditoriaBean __tmp = new AuditoriaBean();
    __tmp.setAuditoriaID(__bean.getAuditoriaID());
    __tmp.setData(__bean.getData());
    __tmp.setTransaccioId(__bean.getTransaccioId());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setMissatge(__bean.getMissatge());
    __tmp.setAdditionalInfo(__bean.getAdditionalInfo());
    __tmp.setIsApp(__bean.isIsApp());
    __tmp.setUsernameAplicacio(__bean.getUsernameAplicacio());
    __tmp.setUsernamePersona(__bean.getUsernamePersona());
		return __tmp;
	}



}
