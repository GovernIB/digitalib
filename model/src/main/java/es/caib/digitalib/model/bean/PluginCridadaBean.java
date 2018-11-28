
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.PluginCridada;


public class PluginCridadaBean implements PluginCridada {



private static final long serialVersionUID = 1378032401L;

	long pluginCridadaID;// PK
	java.sql.Timestamp data;
	java.lang.String metodeplugin;
	int tipusresultat;
	java.lang.Long tempsexecucio;
	long pluginID;
	java.lang.Long usuaripersonaid;
	java.lang.Long usuariaplicacioid;
	java.lang.String parametrestext;
	java.lang.Long parametresFitxerID;
	java.lang.String retorntext;
	java.lang.Long retornFitxerID;


  /** Constructor Buit */
  public PluginCridadaBean() {
  }

  /** Constructor amb tots els camps  */
  public PluginCridadaBean(long pluginCridadaID , java.sql.Timestamp data , java.lang.String metodeplugin , int tipusresultat , java.lang.Long tempsexecucio , long pluginID , java.lang.Long usuaripersonaid , java.lang.Long usuariaplicacioid , java.lang.String parametrestext , java.lang.Long parametresFitxerID , java.lang.String retorntext , java.lang.Long retornFitxerID) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.metodeplugin=metodeplugin;
    this.tipusresultat=tipusresultat;
    this.tempsexecucio=tempsexecucio;
    this.pluginID=pluginID;
    this.usuaripersonaid=usuaripersonaid;
    this.usuariaplicacioid=usuariaplicacioid;
    this.parametrestext=parametrestext;
    this.parametresFitxerID=parametresFitxerID;
    this.retorntext=retorntext;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor sense valors autoincrementals */
  public PluginCridadaBean(java.sql.Timestamp data , java.lang.String metodeplugin , int tipusresultat , java.lang.Long tempsexecucio , long pluginID , java.lang.Long usuaripersonaid , java.lang.Long usuariaplicacioid , java.lang.String parametrestext , java.lang.Long parametresFitxerID , java.lang.String retorntext , java.lang.Long retornFitxerID) {
    this.data=data;
    this.metodeplugin=metodeplugin;
    this.tipusresultat=tipusresultat;
    this.tempsexecucio=tempsexecucio;
    this.pluginID=pluginID;
    this.usuaripersonaid=usuaripersonaid;
    this.usuariaplicacioid=usuariaplicacioid;
    this.parametrestext=parametrestext;
    this.parametresFitxerID=parametresFitxerID;
    this.retorntext=retorntext;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor dels valors Not Null */
  public PluginCridadaBean(long pluginCridadaID , java.sql.Timestamp data , java.lang.String metodeplugin , int tipusresultat , long pluginID) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.metodeplugin=metodeplugin;
    this.tipusresultat=tipusresultat;
    this.pluginID=pluginID;
}
  public PluginCridadaBean(PluginCridada __bean) {
    this.setPluginCridadaID(__bean.getPluginCridadaID());
    this.setData(__bean.getData());
    this.setMetodeplugin(__bean.getMetodeplugin());
    this.setTipusresultat(__bean.getTipusresultat());
    this.setTempsexecucio(__bean.getTempsexecucio());
    this.setPluginID(__bean.getPluginID());
    this.setUsuaripersonaid(__bean.getUsuaripersonaid());
    this.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    this.setParametrestext(__bean.getParametrestext());
    this.setParametresFitxerID(__bean.getParametresFitxerID());
    this.setRetorntext(__bean.getRetorntext());
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

	public java.lang.String getMetodeplugin() {
		return(metodeplugin);
	};
	public void setMetodeplugin(java.lang.String _metodeplugin_) {
		this.metodeplugin = _metodeplugin_;
	};

	public int getTipusresultat() {
		return(tipusresultat);
	};
	public void setTipusresultat(int _tipusresultat_) {
		this.tipusresultat = _tipusresultat_;
	};

	public java.lang.Long getTempsexecucio() {
		return(tempsexecucio);
	};
	public void setTempsexecucio(java.lang.Long _tempsexecucio_) {
		this.tempsexecucio = _tempsexecucio_;
	};

	public long getPluginID() {
		return(pluginID);
	};
	public void setPluginID(long _pluginID_) {
		this.pluginID = _pluginID_;
	};

	public java.lang.Long getUsuaripersonaid() {
		return(usuaripersonaid);
	};
	public void setUsuaripersonaid(java.lang.Long _usuaripersonaid_) {
		this.usuaripersonaid = _usuaripersonaid_;
	};

	public java.lang.Long getUsuariaplicacioid() {
		return(usuariaplicacioid);
	};
	public void setUsuariaplicacioid(java.lang.Long _usuariaplicacioid_) {
		this.usuariaplicacioid = _usuariaplicacioid_;
	};

	public java.lang.String getParametrestext() {
		return(parametrestext);
	};
	public void setParametrestext(java.lang.String _parametrestext_) {
		this.parametrestext = _parametrestext_;
	};

	public java.lang.Long getParametresFitxerID() {
		return(parametresFitxerID);
	};
	public void setParametresFitxerID(java.lang.Long _parametresFitxerID_) {
		this.parametresFitxerID = _parametresFitxerID_;
	};

	public java.lang.String getRetorntext() {
		return(retorntext);
	};
	public void setRetorntext(java.lang.String _retorntext_) {
		this.retorntext = _retorntext_;
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
    __tmp.setMetodeplugin(__bean.getMetodeplugin());
    __tmp.setTipusresultat(__bean.getTipusresultat());
    __tmp.setTempsexecucio(__bean.getTempsexecucio());
    __tmp.setPluginID(__bean.getPluginID());
    __tmp.setUsuaripersonaid(__bean.getUsuaripersonaid());
    __tmp.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    __tmp.setParametrestext(__bean.getParametrestext());
    __tmp.setParametresFitxerID(__bean.getParametresFitxerID());
    __tmp.setRetorntext(__bean.getRetorntext());
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
