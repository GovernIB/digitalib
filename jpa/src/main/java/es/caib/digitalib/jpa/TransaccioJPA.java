
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.HashSet;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Lob;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import java.util.Set;
import org.hibernate.annotations.Index;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
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

	@Index(name="dib_transaccio_transmulid_fk_i")
	@Column(name="transmultipleid",length = 19)
	java.lang.Long transaccioMultipleID;

  /** Nom descriptiu de la transaccio */
	@Column(name="nom",length = 255)
	java.lang.String nom;

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

	@Column(name="ip",nullable = false,length = 50)
	java.lang.String ip;

	@Column(name="returnurl",length = 255)
	java.lang.String returnUrl;

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

	@Column(name="hashescaneig",length = 255)
	java.lang.String hashEscaneig;

	@Index(name="dib_transaccio_filesign_fk_i")
	@Column(name="fitxersignaturaid",length = 19)
	java.lang.Long fitxerSignaturaID;

	@Column(name="hashfirma",length = 255)
	java.lang.String hashFirma;

	@Column(name="infoscanpapersize",length = 100)
	java.lang.String infoScanPaperSize;

	@Column(name="infoscanpixeltype",length = 10)
	java.lang.Integer infoScanPixelType;

	@Column(name="infoscanresolucioppp",length = 10)
	java.lang.Integer infoScanResolucioPpp;

	@Column(name="infoscanocr",length = 1)
	java.lang.Boolean infoScanOcr;

	@Column(name="infoscanduplex",length = 1)
	java.lang.Boolean infoScanDuplex;

	@Column(name="infoscandatacaptura",length = 29,precision = 6)
	java.sql.Timestamp infoScanDataCaptura;

	@Column(name="signparamlanguagedoc",length = 10)
	java.lang.String infoScanLanguageDoc;

  /** TDxx */
	@Column(name="arxiureqparamdocumenttipus",length = 4)
	java.lang.String infoScanDocumentTipus;

	@Column(name="vista",nullable = false,length = 10)
	java.lang.Integer view;

	@Column(name="languageui",nullable = false,length = 10)
	java.lang.String languageUI;

	@Column(name="funcionariusername",nullable = false,length = 255)
	java.lang.String funcionariUsername;

	@Column(name="signparamfuncionarinom",length = 255)
	java.lang.String signParamFuncionariNom;

	@Column(name="signparamfuncionarinif",length = 255)
	java.lang.String signParamFuncionariNif;

  /** Codi DIR3 de l'unitat de la qual depen l'oficina en la que es troba el funcionari. */
	@Column(name="signparamfuncionaridir3",length = 100)
	java.lang.String signParamFuncionariDir3;

  /** documentEstatElaboracio */
	@Column(name="arxiureqparamdocestatelabora",length = 4)
	java.lang.String arxiuReqParamDocEstatElabora;

  /** 0 Ciutada
1 Administracio */
	@Column(name="arxiureqparamorigen",length = 10)
	java.lang.Integer arxiuReqParamOrigen;

  /** Llistat de Nifs dels interessats separats per comes */
	@Column(name="arxiureqparaminteressats",length = 255)
	java.lang.String arxiuReqParamInteressats;

	@Column(name="arxiureqparamciutadanif",length = 15)
	java.lang.String arxiuReqParamCiutadaNif;

	@Column(name="arxiureqparamciutadanom",length = 255)
	java.lang.String arxiuReqParamCiutadaNom;

  /** Codi DIR3 dels organs afectats separats per comes */
	@Column(name="arxiureqparamorgans",length = 255)
	java.lang.String arxiuReqParamOrgans;

	@Column(name="arxiuoptparamprocedimentcodi",length = 255)
	java.lang.String arxiuOptParamProcedimentCodi;

	@Column(name="arxiuoptparamprocedimentnom",length = 255)
	java.lang.String arxiuOptParamProcedimentNom;

	@Column(name="arxiuoptparamseriedocumental",length = 255)
	java.lang.String arxiuOptParamSerieDocumental;

	@Column(name="arxiuoptparamcustorexpid",length = 255)
	java.lang.String arxiuOptParamCustodyOrExpedientId;

	@Index(name="dib_transaccio_perfilid_fk_i")
	@Column(name="perfilid",nullable = false,length = 19)
	long perfilID;

	@Index(name="dib_transaccio_infosignid_fk_i")
	@Column(name="infosignaturaid",length = 19)
	java.lang.Long infoSignaturaID;

	@Index(name="dib_transaccio_infocustid_fk_i")
	@Column(name="infocustodyid",length = 19)
	java.lang.Long infoCustodyID;



  /** Constructor Buit */
  public TransaccioJPA() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioJPA(long transaccioID , java.lang.Long transaccioMultipleID , java.lang.String nom , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , java.lang.String ip , java.lang.String returnUrl , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.String hashEscaneig , java.lang.Long fitxerSignaturaID , java.lang.String hashFirma , java.lang.String infoScanPaperSize , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , java.lang.Boolean infoScanOcr , java.lang.Boolean infoScanDuplex , java.sql.Timestamp infoScanDataCaptura , java.lang.String infoScanLanguageDoc , java.lang.String infoScanDocumentTipus , java.lang.Integer view , java.lang.String languageUI , java.lang.String funcionariUsername , java.lang.String signParamFuncionariNom , java.lang.String signParamFuncionariNif , java.lang.String signParamFuncionariDir3 , java.lang.String arxiuReqParamDocEstatElabora , java.lang.Integer arxiuReqParamOrigen , java.lang.String arxiuReqParamInteressats , java.lang.String arxiuReqParamCiutadaNif , java.lang.String arxiuReqParamCiutadaNom , java.lang.String arxiuReqParamOrgans , java.lang.String arxiuOptParamProcedimentCodi , java.lang.String arxiuOptParamProcedimentNom , java.lang.String arxiuOptParamSerieDocumental , java.lang.String arxiuOptParamCustodyOrExpedientId , long perfilID , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID) {
    this.transaccioID=transaccioID;
    this.transaccioMultipleID=transaccioMultipleID;
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
    this.infoScanDuplex=infoScanDuplex;
    this.infoScanDataCaptura=infoScanDataCaptura;
    this.infoScanLanguageDoc=infoScanLanguageDoc;
    this.infoScanDocumentTipus=infoScanDocumentTipus;
    this.view=view;
    this.languageUI=languageUI;
    this.funcionariUsername=funcionariUsername;
    this.signParamFuncionariNom=signParamFuncionariNom;
    this.signParamFuncionariNif=signParamFuncionariNif;
    this.signParamFuncionariDir3=signParamFuncionariDir3;
    this.arxiuReqParamDocEstatElabora=arxiuReqParamDocEstatElabora;
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
  public TransaccioJPA(java.lang.Long transaccioMultipleID , java.lang.String nom , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long usuariAplicacioId , java.lang.Long usuariPersonaId , java.lang.String ip , java.lang.String returnUrl , int estatCodi , java.lang.String estatMissatge , java.lang.String estatExcepcio , java.lang.Long fitxerEscanejatID , java.lang.String hashEscaneig , java.lang.Long fitxerSignaturaID , java.lang.String hashFirma , java.lang.String infoScanPaperSize , java.lang.Integer infoScanPixelType , java.lang.Integer infoScanResolucioPpp , java.lang.Boolean infoScanOcr , java.lang.Boolean infoScanDuplex , java.sql.Timestamp infoScanDataCaptura , java.lang.String infoScanLanguageDoc , java.lang.String infoScanDocumentTipus , java.lang.Integer view , java.lang.String languageUI , java.lang.String funcionariUsername , java.lang.String signParamFuncionariNom , java.lang.String signParamFuncionariNif , java.lang.String signParamFuncionariDir3 , java.lang.String arxiuReqParamDocEstatElabora , java.lang.Integer arxiuReqParamOrigen , java.lang.String arxiuReqParamInteressats , java.lang.String arxiuReqParamCiutadaNif , java.lang.String arxiuReqParamCiutadaNom , java.lang.String arxiuReqParamOrgans , java.lang.String arxiuOptParamProcedimentCodi , java.lang.String arxiuOptParamProcedimentNom , java.lang.String arxiuOptParamSerieDocumental , java.lang.String arxiuOptParamCustodyOrExpedientId , long perfilID , java.lang.Long infoSignaturaID , java.lang.Long infoCustodyID) {
    this.transaccioMultipleID=transaccioMultipleID;
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
    this.infoScanDuplex=infoScanDuplex;
    this.infoScanDataCaptura=infoScanDataCaptura;
    this.infoScanLanguageDoc=infoScanLanguageDoc;
    this.infoScanDocumentTipus=infoScanDocumentTipus;
    this.view=view;
    this.languageUI=languageUI;
    this.funcionariUsername=funcionariUsername;
    this.signParamFuncionariNom=signParamFuncionariNom;
    this.signParamFuncionariNif=signParamFuncionariNif;
    this.signParamFuncionariDir3=signParamFuncionariDir3;
    this.arxiuReqParamDocEstatElabora=arxiuReqParamDocEstatElabora;
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
  public TransaccioJPA(long transaccioID , java.lang.String transactionWebId , java.sql.Timestamp dataInici , java.lang.String ip , int estatCodi , java.lang.Integer view , java.lang.String languageUI , java.lang.String funcionariUsername , long perfilID) {
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
  public TransaccioJPA(Transaccio __bean) {
    this.setTransaccioID(__bean.getTransaccioID());
    this.setTransaccioMultipleID(__bean.getTransaccioMultipleID());
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
    this.setInfoScanDuplex(__bean.getInfoScanDuplex());
    this.setInfoScanDataCaptura(__bean.getInfoScanDataCaptura());
    this.setInfoScanLanguageDoc(__bean.getInfoScanLanguageDoc());
    this.setInfoScanDocumentTipus(__bean.getInfoScanDocumentTipus());
    this.setView(__bean.getView());
    this.setLanguageUI(__bean.getLanguageUI());
    this.setFuncionariUsername(__bean.getFuncionariUsername());
    this.setSignParamFuncionariNom(__bean.getSignParamFuncionariNom());
    this.setSignParamFuncionariNif(__bean.getSignParamFuncionariNif());
    this.setSignParamFuncionariDir3(__bean.getSignParamFuncionariDir3());
    this.setArxiuReqParamDocEstatElabora(__bean.getArxiuReqParamDocEstatElabora());
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

	public java.lang.Long getTransaccioMultipleID() {
		return(transaccioMultipleID);
	};
	public void setTransaccioMultipleID(java.lang.Long _transaccioMultipleID_) {
		this.transaccioMultipleID = _transaccioMultipleID_;
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

	public java.lang.Boolean getInfoScanDuplex() {
		return(infoScanDuplex);
	};
	public void setInfoScanDuplex(java.lang.Boolean _infoScanDuplex_) {
		this.infoScanDuplex = _infoScanDuplex_;
	};

	public java.sql.Timestamp getInfoScanDataCaptura() {
		return(infoScanDataCaptura);
	};
	public void setInfoScanDataCaptura(java.sql.Timestamp _infoScanDataCaptura_) {
		this.infoScanDataCaptura = _infoScanDataCaptura_;
	};

	public java.lang.String getInfoScanLanguageDoc() {
		return(infoScanLanguageDoc);
	};
	public void setInfoScanLanguageDoc(java.lang.String _infoScanLanguageDoc_) {
		this.infoScanLanguageDoc = _infoScanLanguageDoc_;
	};

	public java.lang.String getInfoScanDocumentTipus() {
		return(infoScanDocumentTipus);
	};
	public void setInfoScanDocumentTipus(java.lang.String _infoScanDocumentTipus_) {
		this.infoScanDocumentTipus = _infoScanDocumentTipus_;
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

	public java.lang.String getSignParamFuncionariDir3() {
		return(signParamFuncionariDir3);
	};
	public void setSignParamFuncionariDir3(java.lang.String _signParamFuncionariDir3_) {
		this.signParamFuncionariDir3 = _signParamFuncionariDir3_;
	};

	public java.lang.String getArxiuReqParamDocEstatElabora() {
		return(arxiuReqParamDocEstatElabora);
	};
	public void setArxiuReqParamDocEstatElabora(java.lang.String _arxiuReqParamDocEstatElabora_) {
		this.arxiuReqParamDocEstatElabora = _arxiuReqParamDocEstatElabora_;
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

// EXP  Field:transaccioid | Table: dib_metadada | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaccio")
	private Set<MetadadaJPA> metadadas = new HashSet<MetadadaJPA>(0);
	public  Set<MetadadaJPA> getMetadadas() {
    return this.metadadas;
  }

	public void setMetadadas(Set<MetadadaJPA> metadadas) {
	  this.metadadas = metadadas;
	}


// IMP Field:transmultipleid | Table: dib_transmultiple | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_transaccio_transmul_tm_fk")
	@JoinColumn(name = "transmultipleid", referencedColumnName ="transmultipleid", nullable = true, insertable=false, updatable=false)
	private TransaccioMultipleJPA transaccioMultiple;

	public TransaccioMultipleJPA getTransaccioMultiple() {
    return this.transaccioMultiple;
  }

	public  void setTransaccioMultiple(TransaccioMultipleJPA transaccioMultiple) {
    this.transaccioMultiple = transaccioMultiple;
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


 // ---------------  STATIC METHODS ------------------
  public static TransaccioJPA toJPA(Transaccio __bean) {
    if (__bean == null) { return null;}
    TransaccioJPA __tmp = new TransaccioJPA();
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setTransaccioMultipleID(__bean.getTransaccioMultipleID());
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
    __tmp.setInfoScanDuplex(__bean.getInfoScanDuplex());
    __tmp.setInfoScanDataCaptura(__bean.getInfoScanDataCaptura());
    __tmp.setInfoScanLanguageDoc(__bean.getInfoScanLanguageDoc());
    __tmp.setInfoScanDocumentTipus(__bean.getInfoScanDocumentTipus());
    __tmp.setView(__bean.getView());
    __tmp.setLanguageUI(__bean.getLanguageUI());
    __tmp.setFuncionariUsername(__bean.getFuncionariUsername());
    __tmp.setSignParamFuncionariNom(__bean.getSignParamFuncionariNom());
    __tmp.setSignParamFuncionariNif(__bean.getSignParamFuncionariNif());
    __tmp.setSignParamFuncionariDir3(__bean.getSignParamFuncionariDir3());
    __tmp.setArxiuReqParamDocEstatElabora(__bean.getArxiuReqParamDocEstatElabora());
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
    if(!"MetadadaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.metadadas) || org.hibernate.Hibernate.isInitialized(__jpa.getMetadadas())) ) {
      __tmp.setMetadadas(MetadadaJPA.copyJPA(__jpa.getMetadadas(), __alreadyCopied,"TransaccioJPA"));
    }
    // Copia de beans complexes (IMP)
    if(!"InfoSignaturaJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.infoSignatura) || org.hibernate.Hibernate.isInitialized(__jpa.getInfoSignatura()) ) ) {
      __tmp.setInfoSignatura(InfoSignaturaJPA.copyJPA(__jpa.getInfoSignatura(), __alreadyCopied,"TransaccioJPA"));
    }
    if(!"PerfilJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil()) ) ) {
      __tmp.setPerfil(PerfilJPA.copyJPA(__jpa.getPerfil(), __alreadyCopied,"TransaccioJPA"));
    }
    if(!"TransaccioMultipleJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccioMultiple) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccioMultiple()) ) ) {
      __tmp.setTransaccioMultiple(TransaccioMultipleJPA.copyJPA(__jpa.getTransaccioMultiple(), __alreadyCopied,"TransaccioJPA"));
    }
    if(!"InfoCustodyJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.infoCustody) || org.hibernate.Hibernate.isInitialized(__jpa.getInfoCustody()) ) ) {
      __tmp.setInfoCustody(InfoCustodyJPA.copyJPA(__jpa.getInfoCustody(), __alreadyCopied,"TransaccioJPA"));
    }

    return __tmp;
  }




}
