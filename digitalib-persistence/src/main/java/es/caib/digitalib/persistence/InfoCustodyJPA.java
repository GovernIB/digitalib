
package es.caib.digitalib.persistence;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Id;


@Entity(name = "InfoCustodyJPA")
@Table(name = "dib_infocustody" , indexes = { 
        @Index(name="dib_infocustody_pk_i", columnList = "infocustodyid")})
@SequenceGenerator(name="INFOCUSTODY_SEQ", sequenceName="dib_infocustody_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class InfoCustodyJPA implements InfoCustody {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="INFOCUSTODY_SEQ")
    @Column(name="infocustodyid",nullable = false,length = 19)
    long infoCustodyID;

    @Column(name="custodyid",length = 255)
    java.lang.String custodyId;

    @Column(name="arxiuexpedientid",length = 255)
    java.lang.String arxiuExpedientId;

    @Column(name="arxiudocumentid",length = 255)
    java.lang.String arxiuDocumentId;

    @Column(name="csv",length = 255)
    java.lang.String csv;

    @Column(name="originalfileurl",length = 255)
    java.lang.String originalFileUrl;

    @Column(name="csvvalidationweb",length = 255)
    java.lang.String csvValidationWeb;

    @Column(name="csvgenerationdefinition",length = 255)
    java.lang.String csvGenerationDefinition;

    @Column(name="printablefileurl",length = 255)
    java.lang.String printableFileUrl;

    @Column(name="enifileurl",length = 255)
    java.lang.String eniFileUrl;

    @Column(name="validationfileurl",length = 255)
    java.lang.String validationFileUrl;



  /** Constructor Buit */
  public InfoCustodyJPA() {
  }

  /** Constructor amb tots els camps  */
  public InfoCustodyJPA(long infoCustodyID , java.lang.String custodyId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String csv , java.lang.String originalFileUrl , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition , java.lang.String printableFileUrl , java.lang.String eniFileUrl , java.lang.String validationFileUrl) {
    this.infoCustodyID=infoCustodyID;
    this.custodyId=custodyId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.csv=csv;
    this.originalFileUrl=originalFileUrl;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
    this.printableFileUrl=printableFileUrl;
    this.eniFileUrl=eniFileUrl;
    this.validationFileUrl=validationFileUrl;
}
  /** Constructor sense valors autoincrementals */
  public InfoCustodyJPA(java.lang.String custodyId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String csv , java.lang.String originalFileUrl , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition , java.lang.String printableFileUrl , java.lang.String eniFileUrl , java.lang.String validationFileUrl) {
    this.custodyId=custodyId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.csv=csv;
    this.originalFileUrl=originalFileUrl;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
    this.printableFileUrl=printableFileUrl;
    this.eniFileUrl=eniFileUrl;
    this.validationFileUrl=validationFileUrl;
}
  /** Constructor dels valors Not Null */
  public InfoCustodyJPA(long infoCustodyID) {
    this.infoCustodyID=infoCustodyID;
}
  public InfoCustodyJPA(InfoCustody __bean) {
    this.setInfoCustodyID(__bean.getInfoCustodyID());
    this.setCustodyId(__bean.getCustodyId());
    this.setArxiuExpedientId(__bean.getArxiuExpedientId());
    this.setArxiuDocumentId(__bean.getArxiuDocumentId());
    this.setCsv(__bean.getCsv());
    this.setOriginalFileUrl(__bean.getOriginalFileUrl());
    this.setCsvValidationWeb(__bean.getCsvValidationWeb());
    this.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
    this.setPrintableFileUrl(__bean.getPrintableFileUrl());
    this.setEniFileUrl(__bean.getEniFileUrl());
    this.setValidationFileUrl(__bean.getValidationFileUrl());
	}

	public long getInfoCustodyID() {
		return(infoCustodyID);
	};
	public void setInfoCustodyID(long _infoCustodyID_) {
		this.infoCustodyID = _infoCustodyID_;
	};

	public java.lang.String getCustodyId() {
		return(custodyId);
	};
	public void setCustodyId(java.lang.String _custodyId_) {
		this.custodyId = _custodyId_;
	};

	public java.lang.String getArxiuExpedientId() {
		return(arxiuExpedientId);
	};
	public void setArxiuExpedientId(java.lang.String _arxiuExpedientId_) {
		this.arxiuExpedientId = _arxiuExpedientId_;
	};

	public java.lang.String getArxiuDocumentId() {
		return(arxiuDocumentId);
	};
	public void setArxiuDocumentId(java.lang.String _arxiuDocumentId_) {
		this.arxiuDocumentId = _arxiuDocumentId_;
	};

	public java.lang.String getCsv() {
		return(csv);
	};
	public void setCsv(java.lang.String _csv_) {
		this.csv = _csv_;
	};

	public java.lang.String getOriginalFileUrl() {
		return(originalFileUrl);
	};
	public void setOriginalFileUrl(java.lang.String _originalFileUrl_) {
		this.originalFileUrl = _originalFileUrl_;
	};

	public java.lang.String getCsvValidationWeb() {
		return(csvValidationWeb);
	};
	public void setCsvValidationWeb(java.lang.String _csvValidationWeb_) {
		this.csvValidationWeb = _csvValidationWeb_;
	};

	public java.lang.String getCsvGenerationDefinition() {
		return(csvGenerationDefinition);
	};
	public void setCsvGenerationDefinition(java.lang.String _csvGenerationDefinition_) {
		this.csvGenerationDefinition = _csvGenerationDefinition_;
	};

	public java.lang.String getPrintableFileUrl() {
		return(printableFileUrl);
	};
	public void setPrintableFileUrl(java.lang.String _printableFileUrl_) {
		this.printableFileUrl = _printableFileUrl_;
	};

	public java.lang.String getEniFileUrl() {
		return(eniFileUrl);
	};
	public void setEniFileUrl(java.lang.String _eniFileUrl_) {
		this.eniFileUrl = _eniFileUrl_;
	};

	public java.lang.String getValidationFileUrl() {
		return(validationFileUrl);
	};
	public void setValidationFileUrl(java.lang.String _validationFileUrl_) {
		this.validationFileUrl = _validationFileUrl_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof InfoCustody) {
      InfoCustody __instance = (InfoCustody)__obj;
      __result = true;
      __result = __result && (this.getInfoCustodyID() == __instance.getInfoCustodyID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:infocustodyid | Table: dib_transaccio | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "infoCustody")
    private Set<TransaccioJPA> transaccios = new HashSet<TransaccioJPA>(0);
    public  Set<TransaccioJPA> getTransaccios() {
    return this.transaccios;
  }

    public void setTransaccios(Set<TransaccioJPA> transaccios) {
      this.transaccios = transaccios;
    }



 // ---------------  STATIC METHODS ------------------
  public static InfoCustodyJPA toJPA(InfoCustody __bean) {
    if (__bean == null) { return null;}
    InfoCustodyJPA __tmp = new InfoCustodyJPA();
    __tmp.setInfoCustodyID(__bean.getInfoCustodyID());
    __tmp.setCustodyId(__bean.getCustodyId());
    __tmp.setArxiuExpedientId(__bean.getArxiuExpedientId());
    __tmp.setArxiuDocumentId(__bean.getArxiuDocumentId());
    __tmp.setCsv(__bean.getCsv());
    __tmp.setOriginalFileUrl(__bean.getOriginalFileUrl());
    __tmp.setCsvValidationWeb(__bean.getCsvValidationWeb());
    __tmp.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
    __tmp.setPrintableFileUrl(__bean.getPrintableFileUrl());
    __tmp.setEniFileUrl(__bean.getEniFileUrl());
    __tmp.setValidationFileUrl(__bean.getValidationFileUrl());
		return __tmp;
	}


  public static InfoCustodyJPA copyJPA(InfoCustodyJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<InfoCustodyJPA> copyJPA(java.util.Set<InfoCustodyJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<InfoCustodyJPA> __tmpSet = (java.util.Set<InfoCustodyJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<InfoCustodyJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (InfoCustodyJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static InfoCustodyJPA copyJPA(InfoCustodyJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    InfoCustodyJPA __tmp = (InfoCustodyJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"TransaccioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccios) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccios())) ) {
      __tmp.setTransaccios(TransaccioJPA.copyJPA(__jpa.getTransaccios(), __alreadyCopied,"InfoCustodyJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
