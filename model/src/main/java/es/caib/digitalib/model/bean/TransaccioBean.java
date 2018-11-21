
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.Transaccio;


public class TransaccioBean implements Transaccio {



private static final long serialVersionUID = 2099592239L;

	long transaccioID;// PK
	java.lang.String transactionWebId;
	java.sql.Timestamp datainici;
	java.sql.Timestamp datafi;
	java.lang.Long usuariaplicacioid;
	java.lang.Long usuaripersonaid;
	int estatcodi;
	java.lang.String estatmissatge;
	java.lang.String estatexcepcio;
	java.lang.Long fitxerescanejatid;
	java.lang.Long fitxersignaturaid;
	java.lang.Integer infoscanpixeltype;
	java.lang.Integer infoscanresolucioppp;
	java.lang.String infoscanformatfitxer;
	boolean infoscanocr;
	java.lang.Long infosignaturaid;
	java.lang.Long infocustodyid;
	java.lang.String languageui;
	java.lang.String languagedoc;
	java.lang.String ciutadanif;
	java.lang.String ciutadanom;
	java.lang.String funcionariusername;
	java.lang.String funcionarinom;
	java.lang.String expedient;
	long perfilid;
	java.lang.String usernameRequest;


  /** Constructor Buit */
  public TransaccioBean() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioBean(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid , int estatcodi , java.lang.String estatmissatge , java.lang.String estatexcepcio , java.lang.Long fitxerescanejatid , java.lang.Long fitxersignaturaid , java.lang.Integer infoscanpixeltype , java.lang.Integer infoscanresolucioppp , java.lang.String infoscanformatfitxer , boolean infoscanocr , java.lang.Long infosignaturaid , java.lang.Long infocustodyid , java.lang.String languageui , java.lang.String languagedoc , java.lang.String ciutadanif , java.lang.String ciutadanom , java.lang.String funcionariusername , java.lang.String funcionarinom , java.lang.String expedient , long perfilid , java.lang.String usernameRequest) {
    this.transaccioID=transaccioID;
    this.transactionWebId=transactionWebId;
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacioid=usuariaplicacioid;
    this.usuaripersonaid=usuaripersonaid;
    this.estatcodi=estatcodi;
    this.estatmissatge=estatmissatge;
    this.estatexcepcio=estatexcepcio;
    this.fitxerescanejatid=fitxerescanejatid;
    this.fitxersignaturaid=fitxersignaturaid;
    this.infoscanpixeltype=infoscanpixeltype;
    this.infoscanresolucioppp=infoscanresolucioppp;
    this.infoscanformatfitxer=infoscanformatfitxer;
    this.infoscanocr=infoscanocr;
    this.infosignaturaid=infosignaturaid;
    this.infocustodyid=infocustodyid;
    this.languageui=languageui;
    this.languagedoc=languagedoc;
    this.ciutadanif=ciutadanif;
    this.ciutadanom=ciutadanom;
    this.funcionariusername=funcionariusername;
    this.funcionarinom=funcionarinom;
    this.expedient=expedient;
    this.perfilid=perfilid;
    this.usernameRequest=usernameRequest;
}
  /** Constructor sense valors autoincrementals */
  public TransaccioBean(java.lang.String transactionWebId , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid , int estatcodi , java.lang.String estatmissatge , java.lang.String estatexcepcio , java.lang.Long fitxerescanejatid , java.lang.Long fitxersignaturaid , java.lang.Integer infoscanpixeltype , java.lang.Integer infoscanresolucioppp , java.lang.String infoscanformatfitxer , boolean infoscanocr , java.lang.Long infosignaturaid , java.lang.Long infocustodyid , java.lang.String languageui , java.lang.String languagedoc , java.lang.String ciutadanif , java.lang.String ciutadanom , java.lang.String funcionariusername , java.lang.String funcionarinom , java.lang.String expedient , long perfilid , java.lang.String usernameRequest) {
    this.transactionWebId=transactionWebId;
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacioid=usuariaplicacioid;
    this.usuaripersonaid=usuaripersonaid;
    this.estatcodi=estatcodi;
    this.estatmissatge=estatmissatge;
    this.estatexcepcio=estatexcepcio;
    this.fitxerescanejatid=fitxerescanejatid;
    this.fitxersignaturaid=fitxersignaturaid;
    this.infoscanpixeltype=infoscanpixeltype;
    this.infoscanresolucioppp=infoscanresolucioppp;
    this.infoscanformatfitxer=infoscanformatfitxer;
    this.infoscanocr=infoscanocr;
    this.infosignaturaid=infosignaturaid;
    this.infocustodyid=infocustodyid;
    this.languageui=languageui;
    this.languagedoc=languagedoc;
    this.ciutadanif=ciutadanif;
    this.ciutadanom=ciutadanom;
    this.funcionariusername=funcionariusername;
    this.funcionarinom=funcionarinom;
    this.expedient=expedient;
    this.perfilid=perfilid;
    this.usernameRequest=usernameRequest;
}
  /** Constructor dels valors Not Null */
  public TransaccioBean(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp datainici , int estatcodi , long perfilid) {
    this.transaccioID=transaccioID;
    this.transactionWebId=transactionWebId;
    this.datainici=datainici;
    this.estatcodi=estatcodi;
    this.perfilid=perfilid;
}
  public TransaccioBean(Transaccio __bean) {
    this.setTransaccioID(__bean.getTransaccioID());
    this.setTransactionWebId(__bean.getTransactionWebId());
    this.setDatainici(__bean.getDatainici());
    this.setDatafi(__bean.getDatafi());
    this.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    this.setUsuaripersonaid(__bean.getUsuaripersonaid());
    this.setEstatcodi(__bean.getEstatcodi());
    this.setEstatmissatge(__bean.getEstatmissatge());
    this.setEstatexcepcio(__bean.getEstatexcepcio());
    this.setFitxerescanejatid(__bean.getFitxerescanejatid());
    this.setFitxersignaturaid(__bean.getFitxersignaturaid());
    this.setInfoscanpixeltype(__bean.getInfoscanpixeltype());
    this.setInfoscanresolucioppp(__bean.getInfoscanresolucioppp());
    this.setInfoscanformatfitxer(__bean.getInfoscanformatfitxer());
    this.setInfoscanocr(__bean.isInfoscanocr());
    this.setInfosignaturaid(__bean.getInfosignaturaid());
    this.setInfocustodyid(__bean.getInfocustodyid());
    this.setLanguageui(__bean.getLanguageui());
    this.setLanguagedoc(__bean.getLanguagedoc());
    this.setCiutadanif(__bean.getCiutadanif());
    this.setCiutadanom(__bean.getCiutadanom());
    this.setFuncionariusername(__bean.getFuncionariusername());
    this.setFuncionarinom(__bean.getFuncionarinom());
    this.setExpedient(__bean.getExpedient());
    this.setPerfilid(__bean.getPerfilid());
    this.setUsernameRequest(__bean.getUsernameRequest());
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

	public java.sql.Timestamp getDatainici() {
		return(datainici);
	};
	public void setDatainici(java.sql.Timestamp _datainici_) {
		this.datainici = _datainici_;
	};

	public java.sql.Timestamp getDatafi() {
		return(datafi);
	};
	public void setDatafi(java.sql.Timestamp _datafi_) {
		this.datafi = _datafi_;
	};

	public java.lang.Long getUsuariaplicacioid() {
		return(usuariaplicacioid);
	};
	public void setUsuariaplicacioid(java.lang.Long _usuariaplicacioid_) {
		this.usuariaplicacioid = _usuariaplicacioid_;
	};

	public java.lang.Long getUsuaripersonaid() {
		return(usuaripersonaid);
	};
	public void setUsuaripersonaid(java.lang.Long _usuaripersonaid_) {
		this.usuaripersonaid = _usuaripersonaid_;
	};

	public int getEstatcodi() {
		return(estatcodi);
	};
	public void setEstatcodi(int _estatcodi_) {
		this.estatcodi = _estatcodi_;
	};

	public java.lang.String getEstatmissatge() {
		return(estatmissatge);
	};
	public void setEstatmissatge(java.lang.String _estatmissatge_) {
		this.estatmissatge = _estatmissatge_;
	};

	public java.lang.String getEstatexcepcio() {
		return(estatexcepcio);
	};
	public void setEstatexcepcio(java.lang.String _estatexcepcio_) {
		this.estatexcepcio = _estatexcepcio_;
	};

	public java.lang.Long getFitxerescanejatid() {
		return(fitxerescanejatid);
	};
	public void setFitxerescanejatid(java.lang.Long _fitxerescanejatid_) {
		this.fitxerescanejatid = _fitxerescanejatid_;
	};

	public java.lang.Long getFitxersignaturaid() {
		return(fitxersignaturaid);
	};
	public void setFitxersignaturaid(java.lang.Long _fitxersignaturaid_) {
		this.fitxersignaturaid = _fitxersignaturaid_;
	};

	public java.lang.Integer getInfoscanpixeltype() {
		return(infoscanpixeltype);
	};
	public void setInfoscanpixeltype(java.lang.Integer _infoscanpixeltype_) {
		this.infoscanpixeltype = _infoscanpixeltype_;
	};

	public java.lang.Integer getInfoscanresolucioppp() {
		return(infoscanresolucioppp);
	};
	public void setInfoscanresolucioppp(java.lang.Integer _infoscanresolucioppp_) {
		this.infoscanresolucioppp = _infoscanresolucioppp_;
	};

	public java.lang.String getInfoscanformatfitxer() {
		return(infoscanformatfitxer);
	};
	public void setInfoscanformatfitxer(java.lang.String _infoscanformatfitxer_) {
		this.infoscanformatfitxer = _infoscanformatfitxer_;
	};

	public boolean isInfoscanocr() {
		return(infoscanocr);
	};
	public void setInfoscanocr(boolean _infoscanocr_) {
		this.infoscanocr = _infoscanocr_;
	};

	public java.lang.Long getInfosignaturaid() {
		return(infosignaturaid);
	};
	public void setInfosignaturaid(java.lang.Long _infosignaturaid_) {
		this.infosignaturaid = _infosignaturaid_;
	};

	public java.lang.Long getInfocustodyid() {
		return(infocustodyid);
	};
	public void setInfocustodyid(java.lang.Long _infocustodyid_) {
		this.infocustodyid = _infocustodyid_;
	};

	public java.lang.String getLanguageui() {
		return(languageui);
	};
	public void setLanguageui(java.lang.String _languageui_) {
		this.languageui = _languageui_;
	};

	public java.lang.String getLanguagedoc() {
		return(languagedoc);
	};
	public void setLanguagedoc(java.lang.String _languagedoc_) {
		this.languagedoc = _languagedoc_;
	};

	public java.lang.String getCiutadanif() {
		return(ciutadanif);
	};
	public void setCiutadanif(java.lang.String _ciutadanif_) {
		this.ciutadanif = _ciutadanif_;
	};

	public java.lang.String getCiutadanom() {
		return(ciutadanom);
	};
	public void setCiutadanom(java.lang.String _ciutadanom_) {
		this.ciutadanom = _ciutadanom_;
	};

	public java.lang.String getFuncionariusername() {
		return(funcionariusername);
	};
	public void setFuncionariusername(java.lang.String _funcionariusername_) {
		this.funcionariusername = _funcionariusername_;
	};

	public java.lang.String getFuncionarinom() {
		return(funcionarinom);
	};
	public void setFuncionarinom(java.lang.String _funcionarinom_) {
		this.funcionarinom = _funcionarinom_;
	};

	public java.lang.String getExpedient() {
		return(expedient);
	};
	public void setExpedient(java.lang.String _expedient_) {
		this.expedient = _expedient_;
	};

	public long getPerfilid() {
		return(perfilid);
	};
	public void setPerfilid(long _perfilid_) {
		this.perfilid = _perfilid_;
	};

	public java.lang.String getUsernameRequest() {
		return(usernameRequest);
	};
	public void setUsernameRequest(java.lang.String _usernameRequest_) {
		this.usernameRequest = _usernameRequest_;
	};



  // ======================================

  public static TransaccioBean toBean(Transaccio __bean) {
    if (__bean == null) { return null;}
    TransaccioBean __tmp = new TransaccioBean();
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setTransactionWebId(__bean.getTransactionWebId());
    __tmp.setDatainici(__bean.getDatainici());
    __tmp.setDatafi(__bean.getDatafi());
    __tmp.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    __tmp.setUsuaripersonaid(__bean.getUsuaripersonaid());
    __tmp.setEstatcodi(__bean.getEstatcodi());
    __tmp.setEstatmissatge(__bean.getEstatmissatge());
    __tmp.setEstatexcepcio(__bean.getEstatexcepcio());
    __tmp.setFitxerescanejatid(__bean.getFitxerescanejatid());
    __tmp.setFitxersignaturaid(__bean.getFitxersignaturaid());
    __tmp.setInfoscanpixeltype(__bean.getInfoscanpixeltype());
    __tmp.setInfoscanresolucioppp(__bean.getInfoscanresolucioppp());
    __tmp.setInfoscanformatfitxer(__bean.getInfoscanformatfitxer());
    __tmp.setInfoscanocr(__bean.isInfoscanocr());
    __tmp.setInfosignaturaid(__bean.getInfosignaturaid());
    __tmp.setInfocustodyid(__bean.getInfocustodyid());
    __tmp.setLanguageui(__bean.getLanguageui());
    __tmp.setLanguagedoc(__bean.getLanguagedoc());
    __tmp.setCiutadanif(__bean.getCiutadanif());
    __tmp.setCiutadanom(__bean.getCiutadanom());
    __tmp.setFuncionariusername(__bean.getFuncionariusername());
    __tmp.setFuncionarinom(__bean.getFuncionarinom());
    __tmp.setExpedient(__bean.getExpedient());
    __tmp.setPerfilid(__bean.getPerfilid());
    __tmp.setUsernameRequest(__bean.getUsernameRequest());
		return __tmp;
	}



}
