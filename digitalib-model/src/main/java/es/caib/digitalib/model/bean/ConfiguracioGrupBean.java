
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.ConfiguracioGrup;


public class ConfiguracioGrupBean implements ConfiguracioGrup {



	long configuracioGrupID;// PK
	java.lang.String nom;
	java.lang.String suportWeb;
	java.lang.String suportEmail;
	java.lang.String suportTelefon;
	long logoHeaderID;
	long logoFooterID;
	java.lang.String adreza;
	java.lang.String codiDir3PerDefecte;
	java.lang.Long perfilNomesEscaneigID;
	java.lang.Long perfilNomesEscaneig2ID;
	java.lang.Long perfilCopiaAutenticaID;
	java.lang.Long perfilCopiaAutentica2ID;
	java.lang.Long perfilCustodiaID;
	java.lang.Long perfilCustodia2ID;


  /** Constructor Buit */
  public ConfiguracioGrupBean() {
  }

  /** Constructor amb tots els camps  */
  public ConfiguracioGrupBean(long configuracioGrupID , java.lang.String nom , java.lang.String suportWeb , java.lang.String suportEmail , java.lang.String suportTelefon , long logoHeaderID , long logoFooterID , java.lang.String adreza , java.lang.String codiDir3PerDefecte , java.lang.Long perfilNomesEscaneigID , java.lang.Long perfilNomesEscaneig2ID , java.lang.Long perfilCopiaAutenticaID , java.lang.Long perfilCopiaAutentica2ID , java.lang.Long perfilCustodiaID , java.lang.Long perfilCustodia2ID) {
    this.configuracioGrupID=configuracioGrupID;
    this.nom=nom;
    this.suportWeb=suportWeb;
    this.suportEmail=suportEmail;
    this.suportTelefon=suportTelefon;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
    this.adreza=adreza;
    this.codiDir3PerDefecte=codiDir3PerDefecte;
    this.perfilNomesEscaneigID=perfilNomesEscaneigID;
    this.perfilNomesEscaneig2ID=perfilNomesEscaneig2ID;
    this.perfilCopiaAutenticaID=perfilCopiaAutenticaID;
    this.perfilCopiaAutentica2ID=perfilCopiaAutentica2ID;
    this.perfilCustodiaID=perfilCustodiaID;
    this.perfilCustodia2ID=perfilCustodia2ID;
}
  /** Constructor sense valors autoincrementals */
  public ConfiguracioGrupBean(java.lang.String nom , java.lang.String suportWeb , java.lang.String suportEmail , java.lang.String suportTelefon , long logoHeaderID , long logoFooterID , java.lang.String adreza , java.lang.String codiDir3PerDefecte , java.lang.Long perfilNomesEscaneigID , java.lang.Long perfilNomesEscaneig2ID , java.lang.Long perfilCopiaAutenticaID , java.lang.Long perfilCopiaAutentica2ID , java.lang.Long perfilCustodiaID , java.lang.Long perfilCustodia2ID) {
    this.nom=nom;
    this.suportWeb=suportWeb;
    this.suportEmail=suportEmail;
    this.suportTelefon=suportTelefon;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
    this.adreza=adreza;
    this.codiDir3PerDefecte=codiDir3PerDefecte;
    this.perfilNomesEscaneigID=perfilNomesEscaneigID;
    this.perfilNomesEscaneig2ID=perfilNomesEscaneig2ID;
    this.perfilCopiaAutenticaID=perfilCopiaAutenticaID;
    this.perfilCopiaAutentica2ID=perfilCopiaAutentica2ID;
    this.perfilCustodiaID=perfilCustodiaID;
    this.perfilCustodia2ID=perfilCustodia2ID;
}
  /** Constructor dels valors Not Null */
  public ConfiguracioGrupBean(long configuracioGrupID , java.lang.String nom , long logoHeaderID , long logoFooterID , java.lang.String adreza , java.lang.String codiDir3PerDefecte) {
    this.configuracioGrupID=configuracioGrupID;
    this.nom=nom;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
    this.adreza=adreza;
    this.codiDir3PerDefecte=codiDir3PerDefecte;
}
  public ConfiguracioGrupBean(ConfiguracioGrup __bean) {
    this.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
    this.setNom(__bean.getNom());
    this.setSuportWeb(__bean.getSuportWeb());
    this.setSuportEmail(__bean.getSuportEmail());
    this.setSuportTelefon(__bean.getSuportTelefon());
    this.setLogoHeaderID(__bean.getLogoHeaderID());
    this.setLogoFooterID(__bean.getLogoFooterID());
    this.setAdreza(__bean.getAdreza());
    this.setCodiDir3PerDefecte(__bean.getCodiDir3PerDefecte());
    this.setPerfilNomesEscaneigID(__bean.getPerfilNomesEscaneigID());
    this.setPerfilNomesEscaneig2ID(__bean.getPerfilNomesEscaneig2ID());
    this.setPerfilCopiaAutenticaID(__bean.getPerfilCopiaAutenticaID());
    this.setPerfilCopiaAutentica2ID(__bean.getPerfilCopiaAutentica2ID());
    this.setPerfilCustodiaID(__bean.getPerfilCustodiaID());
    this.setPerfilCustodia2ID(__bean.getPerfilCustodia2ID());
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

	public java.lang.String getAdreza() {
		return(adreza);
	};
	public void setAdreza(java.lang.String _adreza_) {
		this.adreza = _adreza_;
	};

	public java.lang.String getCodiDir3PerDefecte() {
		return(codiDir3PerDefecte);
	};
	public void setCodiDir3PerDefecte(java.lang.String _codiDir3PerDefecte_) {
		this.codiDir3PerDefecte = _codiDir3PerDefecte_;
	};

	public java.lang.Long getPerfilNomesEscaneigID() {
		return(perfilNomesEscaneigID);
	};
	public void setPerfilNomesEscaneigID(java.lang.Long _perfilNomesEscaneigID_) {
		this.perfilNomesEscaneigID = _perfilNomesEscaneigID_;
	};

	public java.lang.Long getPerfilNomesEscaneig2ID() {
		return(perfilNomesEscaneig2ID);
	};
	public void setPerfilNomesEscaneig2ID(java.lang.Long _perfilNomesEscaneig2ID_) {
		this.perfilNomesEscaneig2ID = _perfilNomesEscaneig2ID_;
	};

	public java.lang.Long getPerfilCopiaAutenticaID() {
		return(perfilCopiaAutenticaID);
	};
	public void setPerfilCopiaAutenticaID(java.lang.Long _perfilCopiaAutenticaID_) {
		this.perfilCopiaAutenticaID = _perfilCopiaAutenticaID_;
	};

	public java.lang.Long getPerfilCopiaAutentica2ID() {
		return(perfilCopiaAutentica2ID);
	};
	public void setPerfilCopiaAutentica2ID(java.lang.Long _perfilCopiaAutentica2ID_) {
		this.perfilCopiaAutentica2ID = _perfilCopiaAutentica2ID_;
	};

	public java.lang.Long getPerfilCustodiaID() {
		return(perfilCustodiaID);
	};
	public void setPerfilCustodiaID(java.lang.Long _perfilCustodiaID_) {
		this.perfilCustodiaID = _perfilCustodiaID_;
	};

	public java.lang.Long getPerfilCustodia2ID() {
		return(perfilCustodia2ID);
	};
	public void setPerfilCustodia2ID(java.lang.Long _perfilCustodia2ID_) {
		this.perfilCustodia2ID = _perfilCustodia2ID_;
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
    __tmp.setAdreza(__bean.getAdreza());
    __tmp.setCodiDir3PerDefecte(__bean.getCodiDir3PerDefecte());
    __tmp.setPerfilNomesEscaneigID(__bean.getPerfilNomesEscaneigID());
    __tmp.setPerfilNomesEscaneig2ID(__bean.getPerfilNomesEscaneig2ID());
    __tmp.setPerfilCopiaAutenticaID(__bean.getPerfilCopiaAutenticaID());
    __tmp.setPerfilCopiaAutentica2ID(__bean.getPerfilCopiaAutentica2ID());
    __tmp.setPerfilCustodiaID(__bean.getPerfilCustodiaID());
    __tmp.setPerfilCustodia2ID(__bean.getPerfilCustodia2ID());
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
