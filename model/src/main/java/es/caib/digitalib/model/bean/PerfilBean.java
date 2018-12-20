
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Perfil;


public class PerfilBean implements Perfil {



private static final long serialVersionUID = -449640516L;

	long perfilID;// PK
	java.lang.String codi;
	java.lang.String nom;
	java.lang.String descripcio;
	java.lang.String urlBase;
	int scanFormatFitxer;
	java.lang.Integer scanMinimaResolucio;
	int scanPixelType;
	long pluginScanWebID;
	java.lang.Long pluginScanWeb2ID;
	int tipusFirma;
	java.lang.Long apiSimpleID;
	java.lang.Long pluginFirmaServidorID;
	int tipusCustodia;
	java.lang.Long pluginArxiuID;
	java.lang.Long pluginDocCustodyID;
	int usPerfil;
	java.lang.Boolean utilitzatPerAplicacio;


  /** Constructor Buit */
  public PerfilBean() {
  }

  /** Constructor amb tots els camps  */
  public PerfilBean(long perfilID , java.lang.String codi , java.lang.String nom , java.lang.String descripcio , java.lang.String urlBase , int scanFormatFitxer , java.lang.Integer scanMinimaResolucio , int scanPixelType , long pluginScanWebID , java.lang.Long pluginScanWeb2ID , int tipusFirma , java.lang.Long apiSimpleID , java.lang.Long pluginFirmaServidorID , int tipusCustodia , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID , int usPerfil , java.lang.Boolean utilitzatPerAplicacio) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.urlBase=urlBase;
    this.scanFormatFitxer=scanFormatFitxer;
    this.scanMinimaResolucio=scanMinimaResolucio;
    this.scanPixelType=scanPixelType;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginScanWeb2ID=pluginScanWeb2ID;
    this.tipusFirma=tipusFirma;
    this.apiSimpleID=apiSimpleID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.tipusCustodia=tipusCustodia;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
    this.usPerfil=usPerfil;
    this.utilitzatPerAplicacio=utilitzatPerAplicacio;
}
  /** Constructor sense valors autoincrementals */
  public PerfilBean(java.lang.String codi , java.lang.String nom , java.lang.String descripcio , java.lang.String urlBase , int scanFormatFitxer , java.lang.Integer scanMinimaResolucio , int scanPixelType , long pluginScanWebID , java.lang.Long pluginScanWeb2ID , int tipusFirma , java.lang.Long apiSimpleID , java.lang.Long pluginFirmaServidorID , int tipusCustodia , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID , int usPerfil , java.lang.Boolean utilitzatPerAplicacio) {
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.urlBase=urlBase;
    this.scanFormatFitxer=scanFormatFitxer;
    this.scanMinimaResolucio=scanMinimaResolucio;
    this.scanPixelType=scanPixelType;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginScanWeb2ID=pluginScanWeb2ID;
    this.tipusFirma=tipusFirma;
    this.apiSimpleID=apiSimpleID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.tipusCustodia=tipusCustodia;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
    this.usPerfil=usPerfil;
    this.utilitzatPerAplicacio=utilitzatPerAplicacio;
}
  /** Constructor dels valors Not Null */
  public PerfilBean(long perfilID , java.lang.String codi , java.lang.String nom , java.lang.String descripcio , int scanFormatFitxer , long pluginScanWebID , int tipusFirma , int tipusCustodia , int usPerfil) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.scanFormatFitxer=scanFormatFitxer;
    this.pluginScanWebID=pluginScanWebID;
    this.tipusFirma=tipusFirma;
    this.tipusCustodia=tipusCustodia;
    this.usPerfil=usPerfil;
}
  public PerfilBean(Perfil __bean) {
    this.setPerfilID(__bean.getPerfilID());
    this.setCodi(__bean.getCodi());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setUrlBase(__bean.getUrlBase());
    this.setScanFormatFitxer(__bean.getScanFormatFitxer());
    this.setScanMinimaResolucio(__bean.getScanMinimaResolucio());
    this.setScanPixelType(__bean.getScanPixelType());
    this.setPluginScanWebID(__bean.getPluginScanWebID());
    this.setPluginScanWeb2ID(__bean.getPluginScanWeb2ID());
    this.setTipusFirma(__bean.getTipusFirma());
    this.setApiSimpleID(__bean.getApiSimpleID());
    this.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    this.setTipusCustodia(__bean.getTipusCustodia());
    this.setPluginArxiuID(__bean.getPluginArxiuID());
    this.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
    this.setUsPerfil(__bean.getUsPerfil());
    this.setUtilitzatPerAplicacio(__bean.getUtilitzatPerAplicacio());
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

	public java.lang.String getUrlBase() {
		return(urlBase);
	};
	public void setUrlBase(java.lang.String _urlBase_) {
		this.urlBase = _urlBase_;
	};

	public int getScanFormatFitxer() {
		return(scanFormatFitxer);
	};
	public void setScanFormatFitxer(int _scanFormatFitxer_) {
		this.scanFormatFitxer = _scanFormatFitxer_;
	};

	public java.lang.Integer getScanMinimaResolucio() {
		return(scanMinimaResolucio);
	};
	public void setScanMinimaResolucio(java.lang.Integer _scanMinimaResolucio_) {
		this.scanMinimaResolucio = _scanMinimaResolucio_;
	};

	public int getScanPixelType() {
		return(scanPixelType);
	};
	public void setScanPixelType(int _scanPixelType_) {
		this.scanPixelType = _scanPixelType_;
	};

	public long getPluginScanWebID() {
		return(pluginScanWebID);
	};
	public void setPluginScanWebID(long _pluginScanWebID_) {
		this.pluginScanWebID = _pluginScanWebID_;
	};

	public java.lang.Long getPluginScanWeb2ID() {
		return(pluginScanWeb2ID);
	};
	public void setPluginScanWeb2ID(java.lang.Long _pluginScanWeb2ID_) {
		this.pluginScanWeb2ID = _pluginScanWeb2ID_;
	};

	public int getTipusFirma() {
		return(tipusFirma);
	};
	public void setTipusFirma(int _tipusFirma_) {
		this.tipusFirma = _tipusFirma_;
	};

	public java.lang.Long getApiSimpleID() {
		return(apiSimpleID);
	};
	public void setApiSimpleID(java.lang.Long _apiSimpleID_) {
		this.apiSimpleID = _apiSimpleID_;
	};

	public java.lang.Long getPluginFirmaServidorID() {
		return(pluginFirmaServidorID);
	};
	public void setPluginFirmaServidorID(java.lang.Long _pluginFirmaServidorID_) {
		this.pluginFirmaServidorID = _pluginFirmaServidorID_;
	};

	public int getTipusCustodia() {
		return(tipusCustodia);
	};
	public void setTipusCustodia(int _tipusCustodia_) {
		this.tipusCustodia = _tipusCustodia_;
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

	public int getUsPerfil() {
		return(usPerfil);
	};
	public void setUsPerfil(int _usPerfil_) {
		this.usPerfil = _usPerfil_;
	};

	public java.lang.Boolean getUtilitzatPerAplicacio() {
		return(utilitzatPerAplicacio);
	};
	public void setUtilitzatPerAplicacio(java.lang.Boolean _utilitzatPerAplicacio_) {
		this.utilitzatPerAplicacio = _utilitzatPerAplicacio_;
	};



  // ======================================

  public static PerfilBean toBean(Perfil __bean) {
    if (__bean == null) { return null;}
    PerfilBean __tmp = new PerfilBean();
    __tmp.setPerfilID(__bean.getPerfilID());
    __tmp.setCodi(__bean.getCodi());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setUrlBase(__bean.getUrlBase());
    __tmp.setScanFormatFitxer(__bean.getScanFormatFitxer());
    __tmp.setScanMinimaResolucio(__bean.getScanMinimaResolucio());
    __tmp.setScanPixelType(__bean.getScanPixelType());
    __tmp.setPluginScanWebID(__bean.getPluginScanWebID());
    __tmp.setPluginScanWeb2ID(__bean.getPluginScanWeb2ID());
    __tmp.setTipusFirma(__bean.getTipusFirma());
    __tmp.setApiSimpleID(__bean.getApiSimpleID());
    __tmp.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    __tmp.setTipusCustodia(__bean.getTipusCustodia());
    __tmp.setPluginArxiuID(__bean.getPluginArxiuID());
    __tmp.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
    __tmp.setUsPerfil(__bean.getUsPerfil());
    __tmp.setUtilitzatPerAplicacio(__bean.getUtilitzatPerAplicacio());
		return __tmp;
	}



}
