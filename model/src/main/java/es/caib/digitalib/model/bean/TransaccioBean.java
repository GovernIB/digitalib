
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Transaccio;


public class TransaccioBean implements Transaccio {



private static final long serialVersionUID = 2099592239L;

	long transaccioID;// PK
	java.sql.Timestamp datainici;
	java.sql.Timestamp datafi;
	java.lang.Long usuariaplicacioid;
	java.lang.Long usuaripersonaid;


  /** Constructor Buit */
  public TransaccioBean() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioBean(long transaccioID , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid) {
    this.transaccioID=transaccioID;
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacioid=usuariaplicacioid;
    this.usuaripersonaid=usuaripersonaid;
}
  /** Constructor sense valors autoincrementals */
  public TransaccioBean(java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid) {
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacioid=usuariaplicacioid;
    this.usuaripersonaid=usuaripersonaid;
}
  /** Constructor dels valors Not Null */
  public TransaccioBean(long transaccioID , java.sql.Timestamp datainici) {
    this.transaccioID=transaccioID;
    this.datainici=datainici;
}
  public TransaccioBean(Transaccio __bean) {
    this.setTransaccioID(__bean.getTransaccioID());
    this.setDatainici(__bean.getDatainici());
    this.setDatafi(__bean.getDatafi());
    this.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    this.setUsuaripersonaid(__bean.getUsuaripersonaid());
	}

	public long getTransaccioID() {
		return(transaccioID);
	};
	public void setTransaccioID(long _transaccioID_) {
		this.transaccioID = _transaccioID_;
	};

	public java.sql.Timestamp getDatainici() {
		return(datainici);
	};
	public void setDatainici(java.sql.Timestamp _datainici_) {
		this.datainici = _datainici_;
	};

	public java.sql.Timestamp getDatafi() {
		return(datafi);
	};
	public void setDatafi(java.sql.Timestamp _datafi_) {
		this.datafi = _datafi_;
	};

	public java.lang.Long getUsuariaplicacioid() {
		return(usuariaplicacioid);
	};
	public void setUsuariaplicacioid(java.lang.Long _usuariaplicacioid_) {
		this.usuariaplicacioid = _usuariaplicacioid_;
	};

	public java.lang.Long getUsuaripersonaid() {
		return(usuaripersonaid);
	};
	public void setUsuaripersonaid(java.lang.Long _usuaripersonaid_) {
		this.usuaripersonaid = _usuaripersonaid_;
	};



  // ======================================

  public static TransaccioBean toBean(Transaccio __bean) {
    if (__bean == null) { return null;}
    TransaccioBean __tmp = new TransaccioBean();
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setDatainici(__bean.getDatainici());
    __tmp.setDatafi(__bean.getDatafi());
    __tmp.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    __tmp.setUsuaripersonaid(__bean.getUsuaripersonaid());
		return __tmp;
	}



}
