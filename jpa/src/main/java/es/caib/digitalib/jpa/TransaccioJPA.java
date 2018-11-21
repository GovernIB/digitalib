
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
	java.sql.Timestamp datainici;

	@Column(name="datafi",length = 29,precision = 6)
	java.sql.Timestamp datafi;

	@Column(name="usuariaplicacioid",length = 19)
	java.lang.Long usuariaplicacioid;

	@Column(name="usuaripersonaid",length = 19)
	java.lang.Long usuaripersonaid;

	@Column(name="estatcodi",nullable = false,length = 10)
	int estatcodi;

	@Column(name="estatmissatge",length = 3000)
	java.lang.String estatmissatge;

	@Column(name="estatexcepcio",length = 2147483647)
  @Lob
	java.lang.String estatexcepcio;

	@Column(name="fitxerescanejatid",length = 19)
	java.lang.Long fitxerescanejatid;

	@Column(name="fitxersignaturaid",length = 19)
	java.lang.Long fitxersignaturaid;

	@Column(name="infoscanpixeltype",length = 10)
	java.lang.Integer infoscanpixeltype;

	@Column(name="infoscanresolucioppp",length = 10)
	java.lang.Integer infoscanresolucioppp;

	@Column(name="infoscanformatfitxer",length = 100)
	java.lang.String infoscanformatfitxer;

	@Column(name="infoscanocr",length = 1)
	boolean infoscanocr;

	@Index(name="dib_transaccio_infosignid_fk_i")
	@Column(name="infosignaturaid",length = 19)
	java.lang.Long infosignaturaid;

	@Index(name="dib_transaccio_infocustid_fk_i")
	@Column(name="infocustodyid",length = 19)
	java.lang.Long infocustodyid;

	@Column(name="languageui",length = 10)
	java.lang.String languageui;

	@Column(name="languagedoc",length = 10)
	java.lang.String languagedoc;

	@Column(name="ciutadanif",length = 15)
	java.lang.String ciutadanif;

	@Column(name="ciutadanom",length = 255)
	java.lang.String ciutadanom;

	@Column(name="funcionariusername",length = 255)
	java.lang.String funcionariusername;

	@Column(name="funcionarinom",length = 255)
	java.lang.String funcionarinom;

	@Column(name="expedient",length = 255)
	java.lang.String expedient;

	@Index(name="dib_transaccio_perfilid_fk_i")
	@Column(name="perfilid",nullable = false,length = 19)
	long perfilid;

  /** Nom d'usuari de la persona que està loguejada en una altre aplicació web quan es fa una cridada via REST */
	@Column(name="usernamerequest",length = 255)
	java.lang.String usernameRequest;



  /** Constructor Buit */
  public TransaccioJPA() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioJPA(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid , int estatcodi , java.lang.String estatmissatge , java.lang.String estatexcepcio , java.lang.Long fitxerescanejatid , java.lang.Long fitxersignaturaid , java.lang.Integer infoscanpixeltype , java.lang.Integer infoscanresolucioppp , java.lang.String infoscanformatfitxer , boolean infoscanocr , java.lang.Long infosignaturaid , java.lang.Long infocustodyid , java.lang.String languageui , java.lang.String languagedoc , java.lang.String ciutadanif , java.lang.String ciutadanom , java.lang.String funcionariusername , java.lang.String funcionarinom , java.lang.String expedient , long perfilid , java.lang.String usernameRequest) {
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
  public TransaccioJPA(java.lang.String transactionWebId , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid , int estatcodi , java.lang.String estatmissatge , java.lang.String estatexcepcio , java.lang.Long fitxerescanejatid , java.lang.Long fitxersignaturaid , java.lang.Integer infoscanpixeltype , java.lang.Integer infoscanresolucioppp , java.lang.String infoscanformatfitxer , boolean infoscanocr , java.lang.Long infosignaturaid , java.lang.Long infocustodyid , java.lang.String languageui , java.lang.String languagedoc , java.lang.String ciutadanif , java.lang.String ciutadanom , java.lang.String funcionariusername , java.lang.String funcionarinom , java.lang.String expedient , long perfilid , java.lang.String usernameRequest) {
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
  public TransaccioJPA(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp datainici , int estatcodi , long perfilid) {
    this.transaccioID=transaccioID;
    this.transactionWebId=transactionWebId;
    this.datainici=datainici;
    this.estatcodi=estatcodi;
    this.perfilid=perfilid;
}
  public TransaccioJPA(Transaccio __bean) {
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
