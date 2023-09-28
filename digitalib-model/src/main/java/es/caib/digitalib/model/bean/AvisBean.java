
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Avis;


public class AvisBean implements Avis {



	long avisID;// PK
	long descripcioID;
	int tipus;
	java.sql.Timestamp dataInici;
	java.sql.Timestamp dataFi;
	java.lang.Long configGrupID;
	boolean bloquejar;


  /** Constructor Buit */
  public AvisBean() {
  }

  /** Constructor amb tots els camps  */
  public AvisBean(long avisID , long descripcioID , int tipus , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long configGrupID , boolean bloquejar) {
    this.avisID=avisID;
    this.descripcioID=descripcioID;
    this.tipus=tipus;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.configGrupID=configGrupID;
    this.bloquejar=bloquejar;
}
  /** Constructor sense valors autoincrementals */
  public AvisBean(long descripcioID , int tipus , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long configGrupID , boolean bloquejar) {
    this.descripcioID=descripcioID;
    this.tipus=tipus;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.configGrupID=configGrupID;
    this.bloquejar=bloquejar;
}
  /** Constructor dels valors Not Null */
  public AvisBean(long avisID , long descripcioID , int tipus , boolean bloquejar) {
    this.avisID=avisID;
    this.descripcioID=descripcioID;
    this.tipus=tipus;
    this.bloquejar=bloquejar;
}
  public AvisBean(Avis __bean) {
    this.setAvisID(__bean.getAvisID());
    this.setDescripcioID(__bean.getDescripcioID());
    this.setTipus(__bean.getTipus());
    this.setDataInici(__bean.getDataInici());
    this.setDataFi(__bean.getDataFi());
    this.setConfigGrupID(__bean.getConfigGrupID());
    this.setBloquejar(__bean.isBloquejar());
	}

	public long getAvisID() {
		return(avisID);
	};
	public void setAvisID(long _avisID_) {
		this.avisID = _avisID_;
	};

	public long getDescripcioID() {
		return(descripcioID);
	};
	public void setDescripcioID(long _descripcioID_) {
		this.descripcioID = _descripcioID_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
	};

	public java.sql.Timestamp getDataInici() {
		return(dataInici);
	};
	public void setDataInici(java.sql.Timestamp _dataInici_) {
		this.dataInici = _dataInici_;
	};

	public java.sql.Timestamp getDataFi() {
		return(dataFi);
	};
	public void setDataFi(java.sql.Timestamp _dataFi_) {
		this.dataFi = _dataFi_;
	};

	public java.lang.Long getConfigGrupID() {
		return(configGrupID);
	};
	public void setConfigGrupID(java.lang.Long _configGrupID_) {
		this.configGrupID = _configGrupID_;
	};

	public boolean isBloquejar() {
		return(bloquejar);
	};
	public void setBloquejar(boolean _bloquejar_) {
		this.bloquejar = _bloquejar_;
	};



  // ======================================

  public static AvisBean toBean(Avis __bean) {
    if (__bean == null) { return null;}
    AvisBean __tmp = new AvisBean();
    __tmp.setAvisID(__bean.getAvisID());
    __tmp.setDescripcioID(__bean.getDescripcioID());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setConfigGrupID(__bean.getConfigGrupID());
    __tmp.setBloquejar(__bean.isBloquejar());
		return __tmp;
	}



}
