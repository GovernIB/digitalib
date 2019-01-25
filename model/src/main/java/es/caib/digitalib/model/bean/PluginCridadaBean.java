
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.PluginCridada;


public class PluginCridadaBean implements PluginCridada {



private static final long serialVersionUID = 1378032401L;

	long pluginCridadaID;// PK
	java.sql.Timestamp data;
	long pluginID;
	java.lang.String metodePlugin;
	int tipusResultat;
	java.lang.Long tempsExecucio;
	java.lang.Long usuariPersonaId;
	java.lang.Long usuariAplicacioId;
	java.lang.String parametresText;
	java.lang.Long parametresFitxerID;
	java.lang.String retornText;
	java.lang.Long retornFitxerID;


  /** Constructor Buit */
  public PluginCridadaBean() {
  }

  /** Constructor amb tots els camps  */
  public PluginCridadaBean(long pluginCridadaID , java.sql.Timestamp data , long pluginID , java.lang.String metodePlugin , int tipusResultat , java.lang.Long tempsExecucio , java.lang.Long usuariPersonaId , java.lang.Long usuariAplicacioId , java.lang.String parametresText , java.lang.Long parametresFitxerID , java.lang.String retornText , java.lang.Long retornFitxerID) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.pluginID=pluginID;
    this.metodePlugin=metodePlugin;
    this.tipusResultat=tipusResultat;
    this.tempsExecucio=tempsExecucio;
    this.usuariPersonaId=usuariPersonaId;
    this.usuariAplicacioId=usuariAplicacioId;
    this.parametresText=parametresText;
    this.parametresFitxerID=parametresFitxerID;
    this.retornText=retornText;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor sense valors autoincrementals */
  public PluginCridadaBean(java.sql.Timestamp data , long pluginID , java.lang.String metodePlugin , int tipusResultat , java.lang.Long tempsExecucio , java.lang.Long usuariPersonaId , java.lang.Long usuariAplicacioId , java.lang.String parametresText , java.lang.Long parametresFitxerID , java.lang.String retornText , java.lang.Long retornFitxerID) {
    this.data=data;
    this.pluginID=pluginID;
    this.metodePlugin=metodePlugin;
    this.tipusResultat=tipusResultat;
    this.tempsExecucio=tempsExecucio;
    this.usuariPersonaId=usuariPersonaId;
    this.usuariAplicacioId=usuariAplicacioId;
    this.parametresText=parametresText;
    this.parametresFitxerID=parametresFitxerID;
    this.retornText=retornText;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor dels valors Not Null */
  public PluginCridadaBean(long pluginCridadaID , java.sql.Timestamp data , long pluginID , java.lang.String metodePlugin , int tipusResultat) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.pluginID=pluginID;
    this.metodePlugin=metodePlugin;
    this.tipusResultat=tipusResultat;
}
  public PluginCridadaBean(PluginCridada __bean) {
    this.setPluginCridadaID(__bean.getPluginCridadaID());
    this.setData(__bean.getData());
    this.setPluginID(__bean.getPluginID());
    this.setMetodePlugin(__bean.getMetodePlugin());
    this.setTipusResultat(__bean.getTipusResultat());
    this.setTempsExecucio(__bean.getTempsExecucio());
    this.setUsuariPersonaId(__bean.getUsuariPersonaId());
    this.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    this.setParametresText(__bean.getParametresText());
    this.setParametresFitxerID(__bean.getParametresFitxerID());
    this.setRetornText(__bean.getRetornText());
    this.setRetornFitxerID(__bean.getRetornFitxerID());
    // Fitxer
    this.setParametresFitxer(FitxerBean.toBean(__bean.getParametresFitxer()));
    // Fitxer
    this.setRetornFitxer(FitxerBean.toBean(__bean.getRetornFitxer()));
	}

	public long getPluginCridadaID() {
		return(pluginCridadaID);
	};
	public void setPluginCridadaID(long _pluginCridadaID_) {
		this.pluginCridadaID = _pluginCridadaID_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public long getPluginID() {
		return(pluginID);
	};
	public void setPluginID(long _pluginID_) {
		this.pluginID = _pluginID_;
	};

	public java.lang.String getMetodePlugin() {
		return(metodePlugin);
	};
	public void setMetodePlugin(java.lang.String _metodePlugin_) {
		this.metodePlugin = _metodePlugin_;
	};

	public int getTipusResultat() {
		return(tipusResultat);
	};
	public void setTipusResultat(int _tipusResultat_) {
		this.tipusResultat = _tipusResultat_;
	};

	public java.lang.Long getTempsExecucio() {
		return(tempsExecucio);
	};
	public void setTempsExecucio(java.lang.Long _tempsExecucio_) {
		this.tempsExecucio = _tempsExecucio_;
	};

	public java.lang.Long getUsuariPersonaId() {
		return(usuariPersonaId);
	};
	public void setUsuariPersonaId(java.lang.Long _usuariPersonaId_) {
		this.usuariPersonaId = _usuariPersonaId_;
	};

	public java.lang.Long getUsuariAplicacioId() {
		return(usuariAplicacioId);
	};
	public void setUsuariAplicacioId(java.lang.Long _usuariAplicacioId_) {
		this.usuariAplicacioId = _usuariAplicacioId_;
	};

	public java.lang.String getParametresText() {
		return(parametresText);
	};
	public void setParametresText(java.lang.String _parametresText_) {
		this.parametresText = _parametresText_;
	};

	public java.lang.Long getParametresFitxerID() {
		return(parametresFitxerID);
	};
	public void setParametresFitxerID(java.lang.Long _parametresFitxerID_) {
		this.parametresFitxerID = _parametresFitxerID_;
	};

	public java.lang.String getRetornText() {
		return(retornText);
	};
	public void setRetornText(java.lang.String _retornText_) {
		this.retornText = _retornText_;
	};

	public java.lang.Long getRetornFitxerID() {
		return(retornFitxerID);
	};
	public void setRetornFitxerID(java.lang.Long _retornFitxerID_) {
		this.retornFitxerID = _retornFitxerID_;
	};



  // ======================================

  public static PluginCridadaBean toBean(PluginCridada __bean) {
    if (__bean == null) { return null;}
    PluginCridadaBean __tmp = new PluginCridadaBean();
    __tmp.setPluginCridadaID(__bean.getPluginCridadaID());
    __tmp.setData(__bean.getData());
    __tmp.setPluginID(__bean.getPluginID());
    __tmp.setMetodePlugin(__bean.getMetodePlugin());
    __tmp.setTipusResultat(__bean.getTipusResultat());
    __tmp.setTempsExecucio(__bean.getTempsExecucio());
    __tmp.setUsuariPersonaId(__bean.getUsuariPersonaId());
    __tmp.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    __tmp.setParametresText(__bean.getParametresText());
    __tmp.setParametresFitxerID(__bean.getParametresFitxerID());
    __tmp.setRetornText(__bean.getRetornText());
    __tmp.setRetornFitxerID(__bean.getRetornFitxerID());
    // Fitxer
    __tmp.setParametresFitxer(FitxerBean.toBean(__bean.getParametresFitxer()));
    // Fitxer
    __tmp.setRetornFitxer(FitxerBean.toBean(__bean.getRetornFitxer()));
		return __tmp;
	}

  protected FitxerBean parametresFitxer;
  public FitxerBean getParametresFitxer() {
    return parametresFitxer;
  }
  public void setParametresFitxer(FitxerBean __field) {
    this. parametresFitxer = __field;
  }
  protected FitxerBean retornFitxer;
  public FitxerBean getRetornFitxer() {
    return retornFitxer;
  }
  public void setRetornFitxer(FitxerBean __field) {
    this. retornFitxer = __field;
  }


}
