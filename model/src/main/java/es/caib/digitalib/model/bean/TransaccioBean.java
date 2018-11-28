
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Transaccio;


public class TransaccioBean implements Transaccio {



private static final long serialVersionUID = 2099592239L;

	long transaccioID;// PK
	java.lang.String transactionWebId;
	java.sql.Timestamp dataInici;
	java.sql.Timestamp dataFi;
	java.lang.Long usuariAplicacioId;
	java.lang.Long usuariPersonaId;
	int estatCodi;
	java.lang.String estatMissatge;
	java.lang.String estatExcepcio;
	java.lang.Long fitxerEscanejatID;
	java.lang.Long fitxerSignaturaID;
	java.lang.Integer infoScanPixelType;
	java.lang.Integer infoScanResolucioPpp;
	boolean infoScanOcr;
	java.lang.Long infoSignaturaID;
	java.lang.Long infoCustodyID;
	java.lang.String languageUI;
	java.lang.String languageDoc;
	java.lang.String ciutadaNif;
	java.lang.String ciutadaNom;
	java.lang.String funcionariUsername;
	java.lang.String funcionariNom;
	java.lang.String expedient;
	java.lang.String usernameRequest;
	java.lang.String returnUrl;
	java.lang.Integer view;
	long perfilID;


  /** Constructor Buit */
  public TransaccioBean() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioBean(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.Long fitxerSignaturaID , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , boolean infoScanOcr , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID , java.lang.String languageUI , java.lang.String languageDoc , java.lang.String ciutadaNif , java.lang.String ciutadaNom , java.lang.String funcionariUsername , java.lang.String funcionariNom , java.lang.String expedient , java.lang.String usernameRequest , java.lang.String returnUrl , java.lang.Integer view , long perfilID) {
    this.transaccioID=transaccioID;
    this.transactionWebId=transactionWebId;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacioId=usuariAplicacioId;
    this.usuariPersonaId=usuariPersonaId;
    this.estatCodi=estatCodi;
    this.estatMissatge=estatMissatge;
    this.estatExcepcio=estatExcepcio;
    this.fitxerEscanejatID=fitxerEscanejatID;
    this.fitxerSignaturaID=fitxerSignaturaID;
    this.infoScanPixelType=infoScanPixelType;
    this.infoScanResolucioPpp=infoScanResolucioPpp;
    this.infoScanOcr=infoScanOcr;
    this.infoSignaturaID=infoSignaturaID;
    this.infoCustodyID=infoCustodyID;
    this.languageUI=languageUI;
    this.languageDoc=languageDoc;
    this.ciutadaNif=ciutadaNif;
    this.ciutadaNom=ciutadaNom;
    this.funcionariUsername=funcionariUsername;
    this.funcionariNom=funcionariNom;
    this.expedient=expedient;
    this.usernameRequest=usernameRequest;
    this.returnUrl=returnUrl;
    this.view=view;
    this.perfilID=perfilID;
}
  /** Constructor sense valors autoincrementals */
  public TransaccioBean(java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.Long fitxerSignaturaID , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , boolean infoScanOcr , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID , java.lang.String languageUI , java.lang.String languageDoc , java.lang.String ciutadaNif , java.lang.String ciutadaNom , java.lang.String funcionariUsername , java.lang.String funcionariNom , java.lang.String expedient , java.lang.String usernameRequest , java.lang.String returnUrl , java.lang.Integer view , long perfilID) {
    this.transactionWebId=transactionWebId;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacioId=usuariAplicacioId;
    this.usuariPersonaId=usuariPersonaId;
    this.estatCodi=estatCodi;
    this.estatMissatge=estatMissatge;
    this.estatExcepcio=estatExcepcio;
    this.fitxerEscanejatID=fitxerEscanejatID;
    this.fitxerSignaturaID=fitxerSignaturaID;
    this.infoScanPixelType=infoScanPixelType;
    this.infoScanResolucioPpp=infoScanResolucioPpp;
    this.infoScanOcr=infoScanOcr;
    this.infoSignaturaID=infoSignaturaID;
    this.infoCustodyID=infoCustodyID;
    this.languageUI=languageUI;
    this.languageDoc=languageDoc;
    this.ciutadaNif=ciutadaNif;
    this.ciutadaNom=ciutadaNom;
    this.funcionariUsername=funcionariUsername;
    this.funcionariNom=funcionariNom;
    this.expedient=expedient;
    this.usernameRequest=usernameRequest;
    this.returnUrl=returnUrl;
    this.view=view;
    this.perfilID=perfilID;
}
  /** Constructor dels valors Not Null */
  public TransaccioBean(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp dataInici , int estatCodi , long perfilID) {
    this.transaccioID=transaccioID;
    this.transactionWebId=transactionWebId;
    this.dataInici=dataInici;
    this.estatCodi=estatCodi;
    this.perfilID=perfilID;
}
  public TransaccioBean(Transaccio __bean) {
    this.setTransaccioID(__bean.getTransaccioID());
    this.setTransactionWebId(__bean.getTransactionWebId());
    this.setDataInici(__bean.getDataInici());
    this.setDataFi(__bean.getDataFi());
    this.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    this.setUsuariPersonaId(__bean.getUsuariPersonaId());
    this.setEstatCodi(__bean.getEstatCodi());
    this.setEstatMissatge(__bean.getEstatMissatge());
    this.setEstatExcepcio(__bean.getEstatExcepcio());
    this.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    this.setFitxerSignaturaID(__bean.getFitxerSignaturaID());
    this.setInfoScanPixelType(__bean.getInfoScanPixelType());
    this.setInfoScanResolucioPpp(__bean.getInfoScanResolucioPpp());
    this.setInfoScanOcr(__bean.isInfoScanOcr());
    this.setInfoSignaturaID(__bean.getInfoSignaturaID());
    this.setInfoCustodyID(__bean.getInfoCustodyID());
    this.setLanguageUI(__bean.getLanguageUI());
    this.setLanguageDoc(__bean.getLanguageDoc());
    this.setCiutadaNif(__bean.getCiutadaNif());
    this.setCiutadaNom(__bean.getCiutadaNom());
    this.setFuncionariUsername(__bean.getFuncionariUsername());
    this.setFuncionariNom(__bean.getFuncionariNom());
    this.setExpedient(__bean.getExpedient());
    this.setUsernameRequest(__bean.getUsernameRequest());
    this.setReturnUrl(__bean.getReturnUrl());
    this.setView(__bean.getView());
    this.setPerfilID(__bean.getPerfilID());
    // Fitxer
    this.setFitxerEscanejat(FitxerBean.toBean(__bean.getFitxerEscanejat()));
    // Fitxer
    this.setFitxerSignatura(FitxerBean.toBean(__bean.getFitxerSignatura()));
	}

	public long getTransaccioID() {
		return(transaccioID);
	};
	public void setTransaccioID(long _transaccioID_) {
		this.transaccioID = _transaccioID_;
	};

	public java.lang.String getTransactionWebId() {
		return(transactionWebId);
	};
	public void setTransactionWebId(java.lang.String _transactionWebId_) {
		this.transactionWebId = _transactionWebId_;
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

	public java.lang.Long getUsuariAplicacioId() {
		return(usuariAplicacioId);
	};
	public void setUsuariAplicacioId(java.lang.Long _usuariAplicacioId_) {
		this.usuariAplicacioId = _usuariAplicacioId_;
	};

	public java.lang.Long getUsuariPersonaId() {
		return(usuariPersonaId);
	};
	public void setUsuariPersonaId(java.lang.Long _usuariPersonaId_) {
		this.usuariPersonaId = _usuariPersonaId_;
	};

	public int getEstatCodi() {
		return(estatCodi);
	};
	public void setEstatCodi(int _estatCodi_) {
		this.estatCodi = _estatCodi_;
	};

	public java.lang.String getEstatMissatge() {
		return(estatMissatge);
	};
	public void setEstatMissatge(java.lang.String _estatMissatge_) {
		this.estatMissatge = _estatMissatge_;
	};

	public java.lang.String getEstatExcepcio() {
		return(estatExcepcio);
	};
	public void setEstatExcepcio(java.lang.String _estatExcepcio_) {
		this.estatExcepcio = _estatExcepcio_;
	};

	public java.lang.Long getFitxerEscanejatID() {
		return(fitxerEscanejatID);
	};
	public void setFitxerEscanejatID(java.lang.Long _fitxerEscanejatID_) {
		this.fitxerEscanejatID = _fitxerEscanejatID_;
	};

	public java.lang.Long getFitxerSignaturaID() {
		return(fitxerSignaturaID);
	};
	public void setFitxerSignaturaID(java.lang.Long _fitxerSignaturaID_) {
		this.fitxerSignaturaID = _fitxerSignaturaID_;
	};

	public java.lang.Integer getInfoScanPixelType() {
		return(infoScanPixelType);
	};
	public void setInfoScanPixelType(java.lang.Integer _infoScanPixelType_) {
		this.infoScanPixelType = _infoScanPixelType_;
	};

	public java.lang.Integer getInfoScanResolucioPpp() {
		return(infoScanResolucioPpp);
	};
	public void setInfoScanResolucioPpp(java.lang.Integer _infoScanResolucioPpp_) {
		this.infoScanResolucioPpp = _infoScanResolucioPpp_;
	};

	public boolean isInfoScanOcr() {
		return(infoScanOcr);
	};
	public void setInfoScanOcr(boolean _infoScanOcr_) {
		this.infoScanOcr = _infoScanOcr_;
	};

	public java.lang.Long getInfoSignaturaID() {
		return(infoSignaturaID);
	};
	public void setInfoSignaturaID(java.lang.Long _infoSignaturaID_) {
		this.infoSignaturaID = _infoSignaturaID_;
	};

	public java.lang.Long getInfoCustodyID() {
		return(infoCustodyID);
	};
	public void setInfoCustodyID(java.lang.Long _infoCustodyID_) {
		this.infoCustodyID = _infoCustodyID_;
	};

	public java.lang.String getLanguageUI() {
		return(languageUI);
	};
	public void setLanguageUI(java.lang.String _languageUI_) {
		this.languageUI = _languageUI_;
	};

	public java.lang.String getLanguageDoc() {
		return(languageDoc);
	};
	public void setLanguageDoc(java.lang.String _languageDoc_) {
		this.languageDoc = _languageDoc_;
	};

	public java.lang.String getCiutadaNif() {
		return(ciutadaNif);
	};
	public void setCiutadaNif(java.lang.String _ciutadaNif_) {
		this.ciutadaNif = _ciutadaNif_;
	};

	public java.lang.String getCiutadaNom() {
		return(ciutadaNom);
	};
	public void setCiutadaNom(java.lang.String _ciutadaNom_) {
		this.ciutadaNom = _ciutadaNom_;
	};

	public java.lang.String getFuncionariUsername() {
		return(funcionariUsername);
	};
	public void setFuncionariUsername(java.lang.String _funcionariUsername_) {
		this.funcionariUsername = _funcionariUsername_;
	};

	public java.lang.String getFuncionariNom() {
		return(funcionariNom);
	};
	public void setFuncionariNom(java.lang.String _funcionariNom_) {
		this.funcionariNom = _funcionariNom_;
	};

	public java.lang.String getExpedient() {
		return(expedient);
	};
	public void setExpedient(java.lang.String _expedient_) {
		this.expedient = _expedient_;
	};

	public java.lang.String getUsernameRequest() {
		return(usernameRequest);
	};
	public void setUsernameRequest(java.lang.String _usernameRequest_) {
		this.usernameRequest = _usernameRequest_;
	};

	public java.lang.String getReturnUrl() {
		return(returnUrl);
	};
	public void setReturnUrl(java.lang.String _returnUrl_) {
		this.returnUrl = _returnUrl_;
	};

	public java.lang.Integer getView() {
		return(view);
	};
	public void setView(java.lang.Integer _view_) {
		this.view = _view_;
	};

	public long getPerfilID() {
		return(perfilID);
	};
	public void setPerfilID(long _perfilID_) {
		this.perfilID = _perfilID_;
	};



  // ======================================

  public static TransaccioBean toBean(Transaccio __bean) {
    if (__bean == null) { return null;}
    TransaccioBean __tmp = new TransaccioBean();
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setTransactionWebId(__bean.getTransactionWebId());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    __tmp.setUsuariPersonaId(__bean.getUsuariPersonaId());
    __tmp.setEstatCodi(__bean.getEstatCodi());
    __tmp.setEstatMissatge(__bean.getEstatMissatge());
    __tmp.setEstatExcepcio(__bean.getEstatExcepcio());
    __tmp.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    __tmp.setFitxerSignaturaID(__bean.getFitxerSignaturaID());
    __tmp.setInfoScanPixelType(__bean.getInfoScanPixelType());
    __tmp.setInfoScanResolucioPpp(__bean.getInfoScanResolucioPpp());
    __tmp.setInfoScanOcr(__bean.isInfoScanOcr());
    __tmp.setInfoSignaturaID(__bean.getInfoSignaturaID());
    __tmp.setInfoCustodyID(__bean.getInfoCustodyID());
    __tmp.setLanguageUI(__bean.getLanguageUI());
    __tmp.setLanguageDoc(__bean.getLanguageDoc());
    __tmp.setCiutadaNif(__bean.getCiutadaNif());
    __tmp.setCiutadaNom(__bean.getCiutadaNom());
    __tmp.setFuncionariUsername(__bean.getFuncionariUsername());
    __tmp.setFuncionariNom(__bean.getFuncionariNom());
    __tmp.setExpedient(__bean.getExpedient());
    __tmp.setUsernameRequest(__bean.getUsernameRequest());
    __tmp.setReturnUrl(__bean.getReturnUrl());
    __tmp.setView(__bean.getView());
    __tmp.setPerfilID(__bean.getPerfilID());
    // Fitxer
    __tmp.setFitxerEscanejat(FitxerBean.toBean(__bean.getFitxerEscanejat()));
    // Fitxer
    __tmp.setFitxerSignatura(FitxerBean.toBean(__bean.getFitxerSignatura()));
		return __tmp;
	}

  protected FitxerBean fitxerEscanejat;
  public FitxerBean getFitxerEscanejat() {
    return fitxerEscanejat;
  }
  public void setFitxerEscanejat(FitxerBean __field) {
    this. fitxerEscanejat = __field;
  }
  protected FitxerBean fitxerSignatura;
  public FitxerBean getFitxerSignatura() {
    return fitxerSignatura;
  }
  public void setFitxerSignatura(FitxerBean __field) {
    this. fitxerSignatura = __field;
  }


}
