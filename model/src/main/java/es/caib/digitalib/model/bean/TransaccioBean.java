
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Transaccio;


public class TransaccioBean implements Transaccio {



private static final long serialVersionUID = 2099592239L;

	long transaccioID;// PK
	java.lang.String nom;
	java.lang.String transactionWebId;
	java.sql.Timestamp dataInici;
	java.sql.Timestamp dataFi;
	java.lang.Long usuariAplicacioId;
	java.lang.Long usuariPersonaId;
	java.lang.String ip;
	java.lang.String returnUrl;
	int estatCodi;
	java.lang.String estatMissatge;
	java.lang.String estatExcepcio;
	java.lang.Long fitxerEscanejatID;
	java.lang.String hashEscaneig;
	java.lang.Long fitxerSignaturaID;
	java.lang.String hashFirma;
	java.lang.String infoScanPaperSize;
	java.lang.Integer infoScanPixelType;
	java.lang.Integer infoScanResolucioPpp;
	java.lang.Boolean infoScanOcr;
	java.sql.Timestamp infoScanDataCaptura;
	java.lang.Integer view;
	java.lang.String languageUI;
	java.lang.String funcionariUsername;
	java.lang.String signParamFuncionariNom;
	java.lang.String signParamFuncionariNif;
	java.lang.String signParamLanguageDoc;
	java.lang.String arxiuReqParamDocEstatElabora;
	java.lang.String arxiuReqParamDocumentTipus;
	java.lang.Integer arxiuReqParamOrigen;
	java.lang.String arxiuReqParamInteressats;
	java.lang.String arxiuReqParamCiutadaNif;
	java.lang.String arxiuReqParamCiutadaNom;
	java.lang.String arxiuReqParamOrgans;
	java.lang.String arxiuOptParamProcedimentCodi;
	java.lang.String arxiuOptParamProcedimentNom;
	java.lang.String arxiuOptParamSerieDocumental;
	java.lang.String arxiuOptParamCustodyOrExpedientId;
	long perfilID;
	java.lang.Long infoSignaturaID;
	java.lang.Long infoCustodyID;


  /** Constructor Buit */
  public TransaccioBean() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioBean(long transaccioID , java.lang.String nom , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , java.lang.String ip , java.lang.String returnUrl , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.String hashEscaneig , java.lang.Long fitxerSignaturaID , java.lang.String hashFirma , java.lang.String infoScanPaperSize , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , java.lang.Boolean infoScanOcr , java.sql.Timestamp infoScanDataCaptura , java.lang.Integer view , java.lang.String languageUI , java.lang.String funcionariUsername , java.lang.String signParamFuncionariNom , java.lang.String signParamFuncionariNif , java.lang.String signParamLanguageDoc , java.lang.String arxiuReqParamDocEstatElabora , java.lang.String arxiuReqParamDocumentTipus , java.lang.Integer arxiuReqParamOrigen , java.lang.String arxiuReqParamInteressats , java.lang.String arxiuReqParamCiutadaNif , java.lang.String arxiuReqParamCiutadaNom , java.lang.String arxiuReqParamOrgans , java.lang.String arxiuOptParamProcedimentCodi , java.lang.String arxiuOptParamProcedimentNom , java.lang.String arxiuOptParamSerieDocumental , java.lang.String arxiuOptParamCustodyOrExpedientId , long perfilID , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID) {
    this.transaccioID=transaccioID;
    this.nom=nom;
    this.transactionWebId=transactionWebId;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacioId=usuariAplicacioId;
    this.usuariPersonaId=usuariPersonaId;
    this.ip=ip;
    this.returnUrl=returnUrl;
    this.estatCodi=estatCodi;
    this.estatMissatge=estatMissatge;
    this.estatExcepcio=estatExcepcio;
    this.fitxerEscanejatID=fitxerEscanejatID;
    this.hashEscaneig=hashEscaneig;
    this.fitxerSignaturaID=fitxerSignaturaID;
    this.hashFirma=hashFirma;
    this.infoScanPaperSize=infoScanPaperSize;
    this.infoScanPixelType=infoScanPixelType;
    this.infoScanResolucioPpp=infoScanResolucioPpp;
    this.infoScanOcr=infoScanOcr;
    this.infoScanDataCaptura=infoScanDataCaptura;
    this.view=view;
    this.languageUI=languageUI;
    this.funcionariUsername=funcionariUsername;
    this.signParamFuncionariNom=signParamFuncionariNom;
    this.signParamFuncionariNif=signParamFuncionariNif;
    this.signParamLanguageDoc=signParamLanguageDoc;
    this.arxiuReqParamDocEstatElabora=arxiuReqParamDocEstatElabora;
    this.arxiuReqParamDocumentTipus=arxiuReqParamDocumentTipus;
    this.arxiuReqParamOrigen=arxiuReqParamOrigen;
    this.arxiuReqParamInteressats=arxiuReqParamInteressats;
    this.arxiuReqParamCiutadaNif=arxiuReqParamCiutadaNif;
    this.arxiuReqParamCiutadaNom=arxiuReqParamCiutadaNom;
    this.arxiuReqParamOrgans=arxiuReqParamOrgans;
    this.arxiuOptParamProcedimentCodi=arxiuOptParamProcedimentCodi;
    this.arxiuOptParamProcedimentNom=arxiuOptParamProcedimentNom;
    this.arxiuOptParamSerieDocumental=arxiuOptParamSerieDocumental;
    this.arxiuOptParamCustodyOrExpedientId=arxiuOptParamCustodyOrExpedientId;
    this.perfilID=perfilID;
    this.infoSignaturaID=infoSignaturaID;
    this.infoCustodyID=infoCustodyID;
}
  /** Constructor sense valors autoincrementals */
  public TransaccioBean(java.lang.String nom , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , java.lang.String ip , java.lang.String returnUrl , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.String hashEscaneig , java.lang.Long fitxerSignaturaID , java.lang.String hashFirma , java.lang.String infoScanPaperSize , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , java.lang.Boolean infoScanOcr , java.sql.Timestamp infoScanDataCaptura , java.lang.Integer view , java.lang.String languageUI , java.lang.String funcionariUsername , java.lang.String signParamFuncionariNom , java.lang.String signParamFuncionariNif , java.lang.String signParamLanguageDoc , java.lang.String arxiuReqParamDocEstatElabora , java.lang.String arxiuReqParamDocumentTipus , java.lang.Integer arxiuReqParamOrigen , java.lang.String arxiuReqParamInteressats , java.lang.String arxiuReqParamCiutadaNif , java.lang.String arxiuReqParamCiutadaNom , java.lang.String arxiuReqParamOrgans , java.lang.String arxiuOptParamProcedimentCodi , java.lang.String arxiuOptParamProcedimentNom , java.lang.String arxiuOptParamSerieDocumental , java.lang.String arxiuOptParamCustodyOrExpedientId , long perfilID , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID) {
    this.nom=nom;
    this.transactionWebId=transactionWebId;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacioId=usuariAplicacioId;
    this.usuariPersonaId=usuariPersonaId;
    this.ip=ip;
    this.returnUrl=returnUrl;
    this.estatCodi=estatCodi;
    this.estatMissatge=estatMissatge;
    this.estatExcepcio=estatExcepcio;
    this.fitxerEscanejatID=fitxerEscanejatID;
    this.hashEscaneig=hashEscaneig;
    this.fitxerSignaturaID=fitxerSignaturaID;
    this.hashFirma=hashFirma;
    this.infoScanPaperSize=infoScanPaperSize;
    this.infoScanPixelType=infoScanPixelType;
    this.infoScanResolucioPpp=infoScanResolucioPpp;
    this.infoScanOcr=infoScanOcr;
    this.infoScanDataCaptura=infoScanDataCaptura;
    this.view=view;
    this.languageUI=languageUI;
    this.funcionariUsername=funcionariUsername;
    this.signParamFuncionariNom=signParamFuncionariNom;
    this.signParamFuncionariNif=signParamFuncionariNif;
    this.signParamLanguageDoc=signParamLanguageDoc;
    this.arxiuReqParamDocEstatElabora=arxiuReqParamDocEstatElabora;
    this.arxiuReqParamDocumentTipus=arxiuReqParamDocumentTipus;
    this.arxiuReqParamOrigen=arxiuReqParamOrigen;
    this.arxiuReqParamInteressats=arxiuReqParamInteressats;
    this.arxiuReqParamCiutadaNif=arxiuReqParamCiutadaNif;
    this.arxiuReqParamCiutadaNom=arxiuReqParamCiutadaNom;
    this.arxiuReqParamOrgans=arxiuReqParamOrgans;
    this.arxiuOptParamProcedimentCodi=arxiuOptParamProcedimentCodi;
    this.arxiuOptParamProcedimentNom=arxiuOptParamProcedimentNom;
    this.arxiuOptParamSerieDocumental=arxiuOptParamSerieDocumental;
    this.arxiuOptParamCustodyOrExpedientId=arxiuOptParamCustodyOrExpedientId;
    this.perfilID=perfilID;
    this.infoSignaturaID=infoSignaturaID;
    this.infoCustodyID=infoCustodyID;
}
  /** Constructor dels valors Not Null */
  public TransaccioBean(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.lang.String ip , int estatCodi , java.lang.Integer view , java.lang.String languageUI , java.lang.String funcionariUsername , long perfilID) {
    this.transaccioID=transaccioID;
    this.transactionWebId=transactionWebId;
    this.dataInici=dataInici;
    this.ip=ip;
    this.estatCodi=estatCodi;
    this.view=view;
    this.languageUI=languageUI;
    this.funcionariUsername=funcionariUsername;
    this.perfilID=perfilID;
}
  public TransaccioBean(Transaccio __bean) {
    this.setTransaccioID(__bean.getTransaccioID());
    this.setNom(__bean.getNom());
    this.setTransactionWebId(__bean.getTransactionWebId());
    this.setDataInici(__bean.getDataInici());
    this.setDataFi(__bean.getDataFi());
    this.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    this.setUsuariPersonaId(__bean.getUsuariPersonaId());
    this.setIp(__bean.getIp());
    this.setReturnUrl(__bean.getReturnUrl());
    this.setEstatCodi(__bean.getEstatCodi());
    this.setEstatMissatge(__bean.getEstatMissatge());
    this.setEstatExcepcio(__bean.getEstatExcepcio());
    this.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    this.setHashEscaneig(__bean.getHashEscaneig());
    this.setFitxerSignaturaID(__bean.getFitxerSignaturaID());
    this.setHashFirma(__bean.getHashFirma());
    this.setInfoScanPaperSize(__bean.getInfoScanPaperSize());
    this.setInfoScanPixelType(__bean.getInfoScanPixelType());
    this.setInfoScanResolucioPpp(__bean.getInfoScanResolucioPpp());
    this.setInfoScanOcr(__bean.getInfoScanOcr());
    this.setInfoScanDataCaptura(__bean.getInfoScanDataCaptura());
    this.setView(__bean.getView());
    this.setLanguageUI(__bean.getLanguageUI());
    this.setFuncionariUsername(__bean.getFuncionariUsername());
    this.setSignParamFuncionariNom(__bean.getSignParamFuncionariNom());
    this.setSignParamFuncionariNif(__bean.getSignParamFuncionariNif());
    this.setSignParamLanguageDoc(__bean.getSignParamLanguageDoc());
    this.setArxiuReqParamDocEstatElabora(__bean.getArxiuReqParamDocEstatElabora());
    this.setArxiuReqParamDocumentTipus(__bean.getArxiuReqParamDocumentTipus());
    this.setArxiuReqParamOrigen(__bean.getArxiuReqParamOrigen());
    this.setArxiuReqParamInteressats(__bean.getArxiuReqParamInteressats());
    this.setArxiuReqParamCiutadaNif(__bean.getArxiuReqParamCiutadaNif());
    this.setArxiuReqParamCiutadaNom(__bean.getArxiuReqParamCiutadaNom());
    this.setArxiuReqParamOrgans(__bean.getArxiuReqParamOrgans());
    this.setArxiuOptParamProcedimentCodi(__bean.getArxiuOptParamProcedimentCodi());
    this.setArxiuOptParamProcedimentNom(__bean.getArxiuOptParamProcedimentNom());
    this.setArxiuOptParamSerieDocumental(__bean.getArxiuOptParamSerieDocumental());
    this.setArxiuOptParamCustodyOrExpedientId(__bean.getArxiuOptParamCustodyOrExpedientId());
    this.setPerfilID(__bean.getPerfilID());
    this.setInfoSignaturaID(__bean.getInfoSignaturaID());
    this.setInfoCustodyID(__bean.getInfoCustodyID());
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

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
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

	public java.lang.String getIp() {
		return(ip);
	};
	public void setIp(java.lang.String _ip_) {
		this.ip = _ip_;
	};

	public java.lang.String getReturnUrl() {
		return(returnUrl);
	};
	public void setReturnUrl(java.lang.String _returnUrl_) {
		this.returnUrl = _returnUrl_;
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

	public java.lang.String getHashEscaneig() {
		return(hashEscaneig);
	};
	public void setHashEscaneig(java.lang.String _hashEscaneig_) {
		this.hashEscaneig = _hashEscaneig_;
	};

	public java.lang.Long getFitxerSignaturaID() {
		return(fitxerSignaturaID);
	};
	public void setFitxerSignaturaID(java.lang.Long _fitxerSignaturaID_) {
		this.fitxerSignaturaID = _fitxerSignaturaID_;
	};

	public java.lang.String getHashFirma() {
		return(hashFirma);
	};
	public void setHashFirma(java.lang.String _hashFirma_) {
		this.hashFirma = _hashFirma_;
	};

	public java.lang.String getInfoScanPaperSize() {
		return(infoScanPaperSize);
	};
	public void setInfoScanPaperSize(java.lang.String _infoScanPaperSize_) {
		this.infoScanPaperSize = _infoScanPaperSize_;
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

	public java.lang.Boolean getInfoScanOcr() {
		return(infoScanOcr);
	};
	public void setInfoScanOcr(java.lang.Boolean _infoScanOcr_) {
		this.infoScanOcr = _infoScanOcr_;
	};

	public java.sql.Timestamp getInfoScanDataCaptura() {
		return(infoScanDataCaptura);
	};
	public void setInfoScanDataCaptura(java.sql.Timestamp _infoScanDataCaptura_) {
		this.infoScanDataCaptura = _infoScanDataCaptura_;
	};

	public java.lang.Integer getView() {
		return(view);
	};
	public void setView(java.lang.Integer _view_) {
		this.view = _view_;
	};

	public java.lang.String getLanguageUI() {
		return(languageUI);
	};
	public void setLanguageUI(java.lang.String _languageUI_) {
		this.languageUI = _languageUI_;
	};

	public java.lang.String getFuncionariUsername() {
		return(funcionariUsername);
	};
	public void setFuncionariUsername(java.lang.String _funcionariUsername_) {
		this.funcionariUsername = _funcionariUsername_;
	};

	public java.lang.String getSignParamFuncionariNom() {
		return(signParamFuncionariNom);
	};
	public void setSignParamFuncionariNom(java.lang.String _signParamFuncionariNom_) {
		this.signParamFuncionariNom = _signParamFuncionariNom_;
	};

	public java.lang.String getSignParamFuncionariNif() {
		return(signParamFuncionariNif);
	};
	public void setSignParamFuncionariNif(java.lang.String _signParamFuncionariNif_) {
		this.signParamFuncionariNif = _signParamFuncionariNif_;
	};

	public java.lang.String getSignParamLanguageDoc() {
		return(signParamLanguageDoc);
	};
	public void setSignParamLanguageDoc(java.lang.String _signParamLanguageDoc_) {
		this.signParamLanguageDoc = _signParamLanguageDoc_;
	};

	public java.lang.String getArxiuReqParamDocEstatElabora() {
		return(arxiuReqParamDocEstatElabora);
	};
	public void setArxiuReqParamDocEstatElabora(java.lang.String _arxiuReqParamDocEstatElabora_) {
		this.arxiuReqParamDocEstatElabora = _arxiuReqParamDocEstatElabora_;
	};

	public java.lang.String getArxiuReqParamDocumentTipus() {
		return(arxiuReqParamDocumentTipus);
	};
	public void setArxiuReqParamDocumentTipus(java.lang.String _arxiuReqParamDocumentTipus_) {
		this.arxiuReqParamDocumentTipus = _arxiuReqParamDocumentTipus_;
	};

	public java.lang.Integer getArxiuReqParamOrigen() {
		return(arxiuReqParamOrigen);
	};
	public void setArxiuReqParamOrigen(java.lang.Integer _arxiuReqParamOrigen_) {
		this.arxiuReqParamOrigen = _arxiuReqParamOrigen_;
	};

	public java.lang.String getArxiuReqParamInteressats() {
		return(arxiuReqParamInteressats);
	};
	public void setArxiuReqParamInteressats(java.lang.String _arxiuReqParamInteressats_) {
		this.arxiuReqParamInteressats = _arxiuReqParamInteressats_;
	};

	public java.lang.String getArxiuReqParamCiutadaNif() {
		return(arxiuReqParamCiutadaNif);
	};
	public void setArxiuReqParamCiutadaNif(java.lang.String _arxiuReqParamCiutadaNif_) {
		this.arxiuReqParamCiutadaNif = _arxiuReqParamCiutadaNif_;
	};

	public java.lang.String getArxiuReqParamCiutadaNom() {
		return(arxiuReqParamCiutadaNom);
	};
	public void setArxiuReqParamCiutadaNom(java.lang.String _arxiuReqParamCiutadaNom_) {
		this.arxiuReqParamCiutadaNom = _arxiuReqParamCiutadaNom_;
	};

	public java.lang.String getArxiuReqParamOrgans() {
		return(arxiuReqParamOrgans);
	};
	public void setArxiuReqParamOrgans(java.lang.String _arxiuReqParamOrgans_) {
		this.arxiuReqParamOrgans = _arxiuReqParamOrgans_;
	};

	public java.lang.String getArxiuOptParamProcedimentCodi() {
		return(arxiuOptParamProcedimentCodi);
	};
	public void setArxiuOptParamProcedimentCodi(java.lang.String _arxiuOptParamProcedimentCodi_) {
		this.arxiuOptParamProcedimentCodi = _arxiuOptParamProcedimentCodi_;
	};

	public java.lang.String getArxiuOptParamProcedimentNom() {
		return(arxiuOptParamProcedimentNom);
	};
	public void setArxiuOptParamProcedimentNom(java.lang.String _arxiuOptParamProcedimentNom_) {
		this.arxiuOptParamProcedimentNom = _arxiuOptParamProcedimentNom_;
	};

	public java.lang.String getArxiuOptParamSerieDocumental() {
		return(arxiuOptParamSerieDocumental);
	};
	public void setArxiuOptParamSerieDocumental(java.lang.String _arxiuOptParamSerieDocumental_) {
		this.arxiuOptParamSerieDocumental = _arxiuOptParamSerieDocumental_;
	};

	public java.lang.String getArxiuOptParamCustodyOrExpedientId() {
		return(arxiuOptParamCustodyOrExpedientId);
	};
	public void setArxiuOptParamCustodyOrExpedientId(java.lang.String _arxiuOptParamCustodyOrExpedientId_) {
		this.arxiuOptParamCustodyOrExpedientId = _arxiuOptParamCustodyOrExpedientId_;
	};

	public long getPerfilID() {
		return(perfilID);
	};
	public void setPerfilID(long _perfilID_) {
		this.perfilID = _perfilID_;
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



  // ======================================

  public static TransaccioBean toBean(Transaccio __bean) {
    if (__bean == null) { return null;}
    TransaccioBean __tmp = new TransaccioBean();
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setTransactionWebId(__bean.getTransactionWebId());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    __tmp.setUsuariPersonaId(__bean.getUsuariPersonaId());
    __tmp.setIp(__bean.getIp());
    __tmp.setReturnUrl(__bean.getReturnUrl());
    __tmp.setEstatCodi(__bean.getEstatCodi());
    __tmp.setEstatMissatge(__bean.getEstatMissatge());
    __tmp.setEstatExcepcio(__bean.getEstatExcepcio());
    __tmp.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    __tmp.setHashEscaneig(__bean.getHashEscaneig());
    __tmp.setFitxerSignaturaID(__bean.getFitxerSignaturaID());
    __tmp.setHashFirma(__bean.getHashFirma());
    __tmp.setInfoScanPaperSize(__bean.getInfoScanPaperSize());
    __tmp.setInfoScanPixelType(__bean.getInfoScanPixelType());
    __tmp.setInfoScanResolucioPpp(__bean.getInfoScanResolucioPpp());
    __tmp.setInfoScanOcr(__bean.getInfoScanOcr());
    __tmp.setInfoScanDataCaptura(__bean.getInfoScanDataCaptura());
    __tmp.setView(__bean.getView());
    __tmp.setLanguageUI(__bean.getLanguageUI());
    __tmp.setFuncionariUsername(__bean.getFuncionariUsername());
    __tmp.setSignParamFuncionariNom(__bean.getSignParamFuncionariNom());
    __tmp.setSignParamFuncionariNif(__bean.getSignParamFuncionariNif());
    __tmp.setSignParamLanguageDoc(__bean.getSignParamLanguageDoc());
    __tmp.setArxiuReqParamDocEstatElabora(__bean.getArxiuReqParamDocEstatElabora());
    __tmp.setArxiuReqParamDocumentTipus(__bean.getArxiuReqParamDocumentTipus());
    __tmp.setArxiuReqParamOrigen(__bean.getArxiuReqParamOrigen());
    __tmp.setArxiuReqParamInteressats(__bean.getArxiuReqParamInteressats());
    __tmp.setArxiuReqParamCiutadaNif(__bean.getArxiuReqParamCiutadaNif());
    __tmp.setArxiuReqParamCiutadaNom(__bean.getArxiuReqParamCiutadaNom());
    __tmp.setArxiuReqParamOrgans(__bean.getArxiuReqParamOrgans());
    __tmp.setArxiuOptParamProcedimentCodi(__bean.getArxiuOptParamProcedimentCodi());
    __tmp.setArxiuOptParamProcedimentNom(__bean.getArxiuOptParamProcedimentNom());
    __tmp.setArxiuOptParamSerieDocumental(__bean.getArxiuOptParamSerieDocumental());
    __tmp.setArxiuOptParamCustodyOrExpedientId(__bean.getArxiuOptParamCustodyOrExpedientId());
    __tmp.setPerfilID(__bean.getPerfilID());
    __tmp.setInfoSignaturaID(__bean.getInfoSignaturaID());
    __tmp.setInfoCustodyID(__bean.getInfoCustodyID());
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
