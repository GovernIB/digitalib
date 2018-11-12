
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Perfil;


public class PerfilBean implements Perfil {



private static final long serialVersionUID = -449640516L;

	long perfilID;// PK
	java.lang.String codi;
	java.lang.String nom;
	java.lang.String descripcio;
	long pluginScanWebID;
	java.lang.Long pluginFirmaServidorID;
	java.lang.Long pluginArxiuID;
	java.lang.Long pluginDocCustodyID;


  /** Constructor Buit */
  public PerfilBean() {
  }

  /** Constructor amb tots els camps  */
  public PerfilBean(long perfilID , java.lang.String codi , java.lang.String nom , java.lang.String descripcio , long pluginScanWebID , java.lang.Long pluginFirmaServidorID , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
}
  /** Constructor sense valors autoincrementals */
  public PerfilBean(java.lang.String codi , java.lang.String nom , java.lang.String descripcio , long pluginScanWebID , java.lang.Long pluginFirmaServidorID , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID) {
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
}
  /** Constructor dels valors Not Null */
  public PerfilBean(long perfilID , java.lang.String codi , java.lang.String nom , long pluginScanWebID) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.pluginScanWebID=pluginScanWebID;
}
  public PerfilBean(Perfil __bean) {
    this.setPerfilID(__bean.getPerfilID());
    this.setCodi(__bean.getCodi());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setPluginScanWebID(__bean.getPluginScanWebID());
    this.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    this.setPluginArxiuID(__bean.getPluginArxiuID());
    this.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
	}

	public long getPerfilID() {
		return(perfilID);
	};
	public void setPerfilID(long _perfilID_) {
		this.perfilID = _perfilID_;
	};

	public java.lang.String getCodi() {
		return(codi);
	};
	public void setCodi(java.lang.String _codi_) {
		this.codi = _codi_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public long getPluginScanWebID() {
		return(pluginScanWebID);
	};
	public void setPluginScanWebID(long _pluginScanWebID_) {
		this.pluginScanWebID = _pluginScanWebID_;
	};

	public java.lang.Long getPluginFirmaServidorID() {
		return(pluginFirmaServidorID);
	};
	public void setPluginFirmaServidorID(java.lang.Long _pluginFirmaServidorID_) {
		this.pluginFirmaServidorID = _pluginFirmaServidorID_;
	};

	public java.lang.Long getPluginArxiuID() {
		return(pluginArxiuID);
	};
	public void setPluginArxiuID(java.lang.Long _pluginArxiuID_) {
		this.pluginArxiuID = _pluginArxiuID_;
	};

	public java.lang.Long getPluginDocCustodyID() {
		return(pluginDocCustodyID);
	};
	public void setPluginDocCustodyID(java.lang.Long _pluginDocCustodyID_) {
		this.pluginDocCustodyID = _pluginDocCustodyID_;
	};



  // ======================================

  public static PerfilBean toBean(Perfil __bean) {
    if (__bean == null) { return null;}
    PerfilBean __tmp = new PerfilBean();
    __tmp.setPerfilID(__bean.getPerfilID());
    __tmp.setCodi(__bean.getCodi());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setPluginScanWebID(__bean.getPluginScanWebID());
    __tmp.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    __tmp.setPluginArxiuID(__bean.getPluginArxiuID());
    __tmp.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
		return __tmp;
	}



}
