
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Index;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_transaccio" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class TransaccioJPA implements Transaccio {



private static final long serialVersionUID = 760472444L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_transaccio_pk_i")
	@Column(name="transaccioid",nullable = false,length = 19)
	long transaccioID;

	@Column(name="webid",nullable = false,unique = true,length = 100)
	java.lang.String transactionWebId;

	@Column(name="datainici",nullable = false,length = 29,precision = 6)
	java.sql.Timestamp dataInici;

	@Column(name="datafi",length = 29,precision = 6)
	java.sql.Timestamp dataFi;

	@Column(name="usuariaplicacioid",length = 19)
	java.lang.Long usuariAplicacioId;

	@Column(name="usuaripersonaid",length = 19)
	java.lang.Long usuariPersonaId;

	@Column(name="estatcodi",nullable = false,length = 10)
	int estatCodi;

	@Column(name="estatmissatge",length = 3000)
	java.lang.String estatMissatge;

	@Column(name="estatexcepcio",length = 2147483647)
  @Lob
	java.lang.String estatExcepcio;

	@Index(name="dib_transaccio_fileplain_fk_i")
	@Column(name="fitxerescanejatid",length = 19)
	java.lang.Long fitxerEscanejatID;

	@Index(name="dib_transaccio_filesign_fk_i")
	@Column(name="fitxersignaturaid",length = 19)
	java.lang.Long fitxerSignaturaID;

	@Column(name="infoscanpixeltype",length = 10)
	java.lang.Integer infoScanPixelType;

	@Column(name="infoscanresolucioppp",length = 10)
	java.lang.Integer infoScanResolucioPpp;

	@Column(name="infoscanocr",length = 1)
	boolean infoScanOcr;

	@Index(name="dib_transaccio_infosignid_fk_i")
	@Column(name="infosignaturaid",length = 19)
	java.lang.Long infoSignaturaID;

	@Index(name="dib_transaccio_infocustid_fk_i")
	@Column(name="infocustodyid",length = 19)
	java.lang.Long infoCustodyID;

	@Column(name="languageui",length = 10)
	java.lang.String languageUI;

	@Column(name="languagedoc",length = 10)
	java.lang.String languageDoc;

	@Column(name="ciutadanif",length = 15)
	java.lang.String ciutadaNif;

	@Column(name="ciutadanom",length = 255)
	java.lang.String ciutadaNom;

	@Column(name="funcionariusername",length = 255)
	java.lang.String funcionariUsername;

	@Column(name="funcionarinom",length = 255)
	java.lang.String funcionariNom;

	@Column(name="expedient",length = 255)
	java.lang.String expedient;

  /** Nom d'usuari de la persona que està loguejada en una altre aplicació web quan es fa una cridada via REST */
	@Column(name="usernamerequest",length = 255)
	java.lang.String usernameRequest;

	@Column(name="returnurl",length = 255)
	java.lang.String returnUrl;

	@Column(name="view",length = 10)
	java.lang.Integer view;

	@Index(name="dib_transaccio_perfilid_fk_i")
	@Column(name="perfilid",nullable = false,length = 19)
	long perfilID;

	@Column(name="ip",nullable = false,length = 50)
	java.lang.String ip;

	@Column(name="hashescaneig",length = 255)
	java.lang.String hashEscaneig;

	@Column(name="hashfirma",length = 255)
	java.lang.String hashFirma;



  /** Constructor Buit */
  public TransaccioJPA() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioJPA(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.Long fitxerSignaturaID , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , boolean infoScanOcr , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID , java.lang.String languageUI , java.lang.String languageDoc , java.lang.String ciutadaNif , java.lang.String ciutadaNom , java.lang.String funcionariUsername , java.lang.String funcionariNom , java.lang.String expedient , java.lang.String usernameRequest , java.lang.String returnUrl , java.lang.Integer view , long perfilID , java.lang.String ip , java.lang.String hashEscaneig , java.lang.String hashFirma) {
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
    this.ip=ip;
    this.hashEscaneig=hashEscaneig;
    this.hashFirma=hashFirma;
}
  /** Constructor sense valors autoincrementals */
  public TransaccioJPA(java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.Long fitxerSignaturaID , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , boolean infoScanOcr , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID , java.lang.String languageUI , java.lang.String languageDoc , java.lang.String ciutadaNif , java.lang.String ciutadaNom , java.lang.String funcionariUsername , java.lang.String funcionariNom , java.lang.String expedient , java.lang.String usernameRequest , java.lang.String returnUrl , java.lang.Integer view , long perfilID , java.lang.String ip , java.lang.String hashEscaneig , java.lang.String hashFirma) {
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
    this.ip=ip;
    this.hashEscaneig=hashEscaneig;
    this.hashFirma=hashFirma;
}
  /** Constructor dels valors Not Null */
  public TransaccioJPA(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp dataInici , int estatCodi , long perfilID , java.lang.String ip) {
    this.transaccioID=transaccioID;
    this.transactionWebId=transactionWebId;
    this.dataInici=dataInici;
    this.estatCodi=estatCodi;
    this.perfilID=perfilID;
    this.ip=ip;
}
  public TransaccioJPA(Transaccio __bean) {
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
    this.setIp(__bean.getIp());
    this.setHashEscaneig(__bean.getHashEscaneig());
    this.setHashFirma(__bean.getHashFirma());
    // Fitxer
    this.setFitxerEscanejat(FitxerJPA.toJPA(__bean.getFitxerEscanejat()));
    // Fitxer
    this.setFitxerSignatura(FitxerJPA.toJPA(__bean.getFitxerSignatura()));
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

	public java.lang.String getIp() {
		return(ip);
	};
	public void setIp(java.lang.String _ip_) {
		this.ip = _ip_;
	};

	public java.lang.String getHashEscaneig() {
		return(hashEscaneig);
	};
	public void setHashEscaneig(java.lang.String _hashEscaneig_) {
		this.hashEscaneig = _hashEscaneig_;
	};

	public java.lang.String getHashFirma() {
		return(hashFirma);
	};
	public void setHashFirma(java.lang.String _hashFirma_) {
		this.hashFirma = _hashFirma_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Transaccio) {
      Transaccio __instance = (Transaccio)__obj;
      __result = true;
      __result = __result && (this.getTransaccioID() == __instance.getTransaccioID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:fitxerid | Table: dib_fitxer | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name="dib_transaccio_fitxer_pla_fk")
	@JoinColumn(name = "fitxerescanejatid", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
	private FitxerJPA fitxerEscanejat;

	public FitxerJPA getFitxerEscanejat() {
    return this.fitxerEscanejat;
  }

	public  void setFitxerEscanejat(FitxerJPA fitxerEscanejat) {
    this.fitxerEscanejat = fitxerEscanejat;
  }

// IMP Field:fitxerid | Table: dib_fitxer | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name="dib_transaccio_fitxer_sign_fk")
	@JoinColumn(name = "fitxersignaturaid", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
	private FitxerJPA fitxerSignatura;

	public FitxerJPA getFitxerSignatura() {
    return this.fitxerSignatura;
  }

	public  void setFitxerSignatura(FitxerJPA fitxerSignatura) {
    this.fitxerSignatura = fitxerSignatura;
  }

// IMP Field:infosignaturaid | Table: dib_infosignatura | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_transaccio_infosign_fk")
	@JoinColumn(name = "infosignaturaid", referencedColumnName ="infoSignaturaID", nullable = true, insertable=false, updatable=false)
	private InfoSignaturaJPA infoSignatura;

	public InfoSignaturaJPA getInfoSignatura() {
    return this.infoSignatura;
  }

	public  void setInfoSignatura(InfoSignaturaJPA infoSignatura) {
    this.infoSignatura = infoSignatura;
  }

// IMP Field:infocustodyid | Table: dib_infocustody | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_transaccio_infocust_fk")
	@JoinColumn(name = "infocustodyid", referencedColumnName ="infoCustodyID", nullable = true, insertable=false, updatable=false)
	private InfoCustodyJPA infoCustody;

	public InfoCustodyJPA getInfoCustody() {
    return this.infoCustody;
  }

	public  void setInfoCustody(InfoCustodyJPA infoCustody) {
    this.infoCustody = infoCustody;
  }

// IMP Field:perfilid | Table: dib_perfil | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_transaccio_perfil_perfi_fk")
	@JoinColumn(name = "perfilid", referencedColumnName ="perfilID", nullable = false, insertable=false, updatable=false)
	private PerfilJPA perfil;

	public PerfilJPA getPerfil() {
    return this.perfil;
  }

	public  void setPerfil(PerfilJPA perfil) {
    this.perfil = perfil;
  }


 // ---------------  STATIC METHODS ------------------
  public static TransaccioJPA toJPA(Transaccio __bean) {
    if (__bean == null) { return null;}
    TransaccioJPA __tmp = new TransaccioJPA();
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
    __tmp.setIp(__bean.getIp());
    __tmp.setHashEscaneig(__bean.getHashEscaneig());
    __tmp.setHashFirma(__bean.getHashFirma());
    // Fitxer
    __tmp.setFitxerEscanejat(FitxerJPA.toJPA(__bean.getFitxerEscanejat()));
    // Fitxer
    __tmp.setFitxerSignatura(FitxerJPA.toJPA(__bean.getFitxerSignatura()));
		return __tmp;
	}


  public static TransaccioJPA copyJPA(TransaccioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<TransaccioJPA> copyJPA(java.util.Set<TransaccioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<TransaccioJPA> __tmpSet = (java.util.Set<TransaccioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<TransaccioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (TransaccioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static TransaccioJPA copyJPA(TransaccioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    TransaccioJPA __tmp = (TransaccioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"InfoSignaturaJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.infoSignatura) || org.hibernate.Hibernate.isInitialized(__jpa.getInfoSignatura()) ) ) {
      __tmp.setInfoSignatura(InfoSignaturaJPA.copyJPA(__jpa.getInfoSignatura(), __alreadyCopied,"TransaccioJPA"));
    }
    if(!"PerfilJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil()) ) ) {
      __tmp.setPerfil(PerfilJPA.copyJPA(__jpa.getPerfil(), __alreadyCopied,"TransaccioJPA"));
    }
    if(!"InfoCustodyJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.infoCustody) || org.hibernate.Hibernate.isInitialized(__jpa.getInfoCustody()) ) ) {
      __tmp.setInfoCustody(InfoCustodyJPA.copyJPA(__jpa.getInfoCustody(), __alreadyCopied,"TransaccioJPA"));
    }

    return __tmp;
  }




}
