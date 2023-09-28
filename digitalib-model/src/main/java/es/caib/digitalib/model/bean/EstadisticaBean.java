
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Estadistica;


public class EstadisticaBean implements Estadistica {



	long estadisticaID;// PK
	int tipus;
	java.sql.Timestamp data;
	double valor;
	java.lang.String parametres;
	java.lang.Long usuariAplicacioID;
	java.lang.Long usuariPersonaID;


  /** Constructor Buit */
  public EstadisticaBean() {
  }

  /** Constructor amb tots els camps  */
  public EstadisticaBean(long estadisticaID , int tipus , java.sql.Timestamp data , double valor , java.lang.String parametres , java.lang.Long usuariAplicacioID , java.lang.Long usuariPersonaID) {
    this.estadisticaID=estadisticaID;
    this.tipus=tipus;
    this.data=data;
    this.valor=valor;
    this.parametres=parametres;
    this.usuariAplicacioID=usuariAplicacioID;
    this.usuariPersonaID=usuariPersonaID;
}
  /** Constructor sense valors autoincrementals */
  public EstadisticaBean(int tipus , java.sql.Timestamp data , double valor , java.lang.String parametres , java.lang.Long usuariAplicacioID , java.lang.Long usuariPersonaID) {
    this.tipus=tipus;
    this.data=data;
    this.valor=valor;
    this.parametres=parametres;
    this.usuariAplicacioID=usuariAplicacioID;
    this.usuariPersonaID=usuariPersonaID;
}
  /** Constructor dels valors Not Null */
  public EstadisticaBean(long estadisticaID , int tipus , java.sql.Timestamp data , double valor) {
    this.estadisticaID=estadisticaID;
    this.tipus=tipus;
    this.data=data;
    this.valor=valor;
}
  public EstadisticaBean(Estadistica __bean) {
    this.setEstadisticaID(__bean.getEstadisticaID());
    this.setTipus(__bean.getTipus());
    this.setData(__bean.getData());
    this.setValor(__bean.getValor());
    this.setParametres(__bean.getParametres());
    this.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    this.setUsuariPersonaID(__bean.getUsuariPersonaID());
	}

	public long getEstadisticaID() {
		return(estadisticaID);
	};
	public void setEstadisticaID(long _estadisticaID_) {
		this.estadisticaID = _estadisticaID_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public double getValor() {
		return(valor);
	};
	public void setValor(double _valor_) {
		this.valor = _valor_;
	};

	public java.lang.String getParametres() {
		return(parametres);
	};
	public void setParametres(java.lang.String _parametres_) {
		this.parametres = _parametres_;
	};

	public java.lang.Long getUsuariAplicacioID() {
		return(usuariAplicacioID);
	};
	public void setUsuariAplicacioID(java.lang.Long _usuariAplicacioID_) {
		this.usuariAplicacioID = _usuariAplicacioID_;
	};

	public java.lang.Long getUsuariPersonaID() {
		return(usuariPersonaID);
	};
	public void setUsuariPersonaID(java.lang.Long _usuariPersonaID_) {
		this.usuariPersonaID = _usuariPersonaID_;
	};



  // ======================================

  public static EstadisticaBean toBean(Estadistica __bean) {
    if (__bean == null) { return null;}
    EstadisticaBean __tmp = new EstadisticaBean();
    __tmp.setEstadisticaID(__bean.getEstadisticaID());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setData(__bean.getData());
    __tmp.setValor(__bean.getValor());
    __tmp.setParametres(__bean.getParametres());
    __tmp.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    __tmp.setUsuariPersonaID(__bean.getUsuariPersonaID());
		return __tmp;
	}



}
