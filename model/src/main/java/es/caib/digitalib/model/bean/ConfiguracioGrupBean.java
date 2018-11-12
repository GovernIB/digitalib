
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.ConfiguracioGrup;


public class ConfiguracioGrupBean implements ConfiguracioGrup {



private static final long serialVersionUID = -1444815491L;

	long configuracioGrupID;// PK
	java.lang.String nom;
	java.lang.String suportWeb;
	java.lang.String suportEmail;
	java.lang.String suportTelefon;
	long logoHeaderID;
	long logoFooterID;


  /** Constructor Buit */
  public ConfiguracioGrupBean() {
  }

  /** Constructor amb tots els camps  */
  public ConfiguracioGrupBean(long configuracioGrupID , java.lang.String nom , java.lang.String suportWeb , java.lang.String suportEmail , java.lang.String suportTelefon , long logoHeaderID , long logoFooterID) {
    this.configuracioGrupID=configuracioGrupID;
    this.nom=nom;
    this.suportWeb=suportWeb;
    this.suportEmail=suportEmail;
    this.suportTelefon=suportTelefon;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
}
  /** Constructor sense valors autoincrementals */
  public ConfiguracioGrupBean(java.lang.String nom , java.lang.String suportWeb , java.lang.String suportEmail , java.lang.String suportTelefon , long logoHeaderID , long logoFooterID) {
    this.nom=nom;
    this.suportWeb=suportWeb;
    this.suportEmail=suportEmail;
    this.suportTelefon=suportTelefon;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
}
  /** Constructor dels valors Not Null */
  public ConfiguracioGrupBean(long configuracioGrupID , java.lang.String nom , long logoHeaderID , long logoFooterID) {
    this.configuracioGrupID=configuracioGrupID;
    this.nom=nom;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
}
  public ConfiguracioGrupBean(ConfiguracioGrup __bean) {
    this.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
    this.setNom(__bean.getNom());
    this.setSuportWeb(__bean.getSuportWeb());
    this.setSuportEmail(__bean.getSuportEmail());
    this.setSuportTelefon(__bean.getSuportTelefon());
    this.setLogoHeaderID(__bean.getLogoHeaderID());
    this.setLogoFooterID(__bean.getLogoFooterID());
    // Fitxer
    this.setLogoHeader(FitxerBean.toBean(__bean.getLogoHeader()));
    // Fitxer
    this.setLogoFooter(FitxerBean.toBean(__bean.getLogoFooter()));
	}

	public long getConfiguracioGrupID() {
		return(configuracioGrupID);
	};
	public void setConfiguracioGrupID(long _configuracioGrupID_) {
		this.configuracioGrupID = _configuracioGrupID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getSuportWeb() {
		return(suportWeb);
	};
	public void setSuportWeb(java.lang.String _suportWeb_) {
		this.suportWeb = _suportWeb_;
	};

	public java.lang.String getSuportEmail() {
		return(suportEmail);
	};
	public void setSuportEmail(java.lang.String _suportEmail_) {
		this.suportEmail = _suportEmail_;
	};

	public java.lang.String getSuportTelefon() {
		return(suportTelefon);
	};
	public void setSuportTelefon(java.lang.String _suportTelefon_) {
		this.suportTelefon = _suportTelefon_;
	};

	public long getLogoHeaderID() {
		return(logoHeaderID);
	};
	public void setLogoHeaderID(long _logoHeaderID_) {
		this.logoHeaderID = _logoHeaderID_;
	};

	public long getLogoFooterID() {
		return(logoFooterID);
	};
	public void setLogoFooterID(long _logoFooterID_) {
		this.logoFooterID = _logoFooterID_;
	};



  // ======================================

  public static ConfiguracioGrupBean toBean(ConfiguracioGrup __bean) {
    if (__bean == null) { return null;}
    ConfiguracioGrupBean __tmp = new ConfiguracioGrupBean();
    __tmp.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
    __tmp.setNom(__bean.getNom());
    __tmp.setSuportWeb(__bean.getSuportWeb());
    __tmp.setSuportEmail(__bean.getSuportEmail());
    __tmp.setSuportTelefon(__bean.getSuportTelefon());
    __tmp.setLogoHeaderID(__bean.getLogoHeaderID());
    __tmp.setLogoFooterID(__bean.getLogoFooterID());
    // Fitxer
    __tmp.setLogoHeader(FitxerBean.toBean(__bean.getLogoHeader()));
    // Fitxer
    __tmp.setLogoFooter(FitxerBean.toBean(__bean.getLogoFooter()));
		return __tmp;
	}

  protected FitxerBean logoHeader;
  public FitxerBean getLogoHeader() {
    return logoHeader;
  }
  public void setLogoHeader(FitxerBean __field) {
    this. logoHeader = __field;
  }
  protected FitxerBean logoFooter;
  public FitxerBean getLogoFooter() {
    return logoFooter;
  }
  public void setLogoFooter(FitxerBean __field) {
    this. logoFooter = __field;
  }


}
