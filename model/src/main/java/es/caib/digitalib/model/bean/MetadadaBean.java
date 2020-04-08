
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Metadada;


public class MetadadaBean implements Metadada {



private static final long serialVersionUID = 1026268591L;

	long metadadaid;// PK
	long transaccioID;
	java.lang.String nom;
	java.lang.String valor;


  /** Constructor Buit */
  public MetadadaBean() {
  }

  /** Constructor amb tots els camps  */
  public MetadadaBean(long metadadaid , long transaccioID , java.lang.String nom , java.lang.String valor) {
    this.metadadaid=metadadaid;
    this.transaccioID=transaccioID;
    this.nom=nom;
    this.valor=valor;
}
  /** Constructor sense valors autoincrementals */
  public MetadadaBean(long transaccioID , java.lang.String nom , java.lang.String valor) {
    this.transaccioID=transaccioID;
    this.nom=nom;
    this.valor=valor;
}
  public MetadadaBean(Metadada __bean) {
    this.setMetadadaid(__bean.getMetadadaid());
    this.setTransaccioID(__bean.getTransaccioID());
    this.setNom(__bean.getNom());
    this.setValor(__bean.getValor());
	}

	public long getMetadadaid() {
		return(metadadaid);
	};
	public void setMetadadaid(long _metadadaid_) {
		this.metadadaid = _metadadaid_;
	};

	public long getTransaccioID() {
		return(transaccioID);
	};
	public void setTransaccioID(long _transaccioID_) {
		this.transaccioID = _transaccioID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getValor() {
		return(valor);
	};
	public void setValor(java.lang.String _valor_) {
		this.valor = _valor_;
	};



  // ======================================

  public static MetadadaBean toBean(Metadada __bean) {
    if (__bean == null) { return null;}
    MetadadaBean __tmp = new MetadadaBean();
    __tmp.setMetadadaid(__bean.getMetadadaid());
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setValor(__bean.getValor());
		return __tmp;
	}



}
