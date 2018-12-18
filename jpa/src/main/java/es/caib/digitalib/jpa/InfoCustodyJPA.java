
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import java.util.HashSet;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import java.util.Set;
import org.hibernate.annotations.Index;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_infocustody" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class InfoCustodyJPA implements InfoCustody {



private static final long serialVersionUID = -1667677320L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_infocustody_pk_i")
	@Column(name="infocustodyid",nullable = false,length = 19)
	long infoCustodyID;

	@Column(name="custodyid",length = 255)
	java.lang.String custodyId;

	@Column(name="arxiuexpedientid",length = 255)
	java.lang.String arxiuExpedientId;

	@Column(name="arxiudocumentid",length = 255)
	java.lang.String arxiuDocumentId;

	@Column(name="fileurl",length = 255)
	java.lang.String fileUrl;

	@Column(name="csv",length = 255)
	java.lang.String csv;

	@Column(name="csvvalidationweb",length = 255)
	java.lang.String csvValidationWeb;

	@Column(name="csvgenerationdefinition",length = 255)
	java.lang.String csvGenerationDefinition;



  /** Constructor Buit */
  public InfoCustodyJPA() {
  }

  /** Constructor amb tots els camps  */
  public InfoCustodyJPA(long infoCustodyID , java.lang.String custodyId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String fileUrl , java.lang.String csv , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition) {
    this.infoCustodyID=infoCustodyID;
    this.custodyId=custodyId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.fileUrl=fileUrl;
    this.csv=csv;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
}
  /** Constructor sense valors autoincrementals */
  public InfoCustodyJPA(java.lang.String custodyId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String fileUrl , java.lang.String csv , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition) {
    this.custodyId=custodyId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.fileUrl=fileUrl;
    this.csv=csv;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
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
    this.setFileUrl(__bean.getFileUrl());
    this.setCsv(__bean.getCsv());
    this.setCsvValidationWeb(__bean.getCsvValidationWeb());
    this.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
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

	public java.lang.String getFileUrl() {
		return(fileUrl);
	};
	public void setFileUrl(java.lang.String _fileUrl_) {
		this.fileUrl = _fileUrl_;
	};

	public java.lang.String getCsv() {
		return(csv);
	};
	public void setCsv(java.lang.String _csv_) {
		this.csv = _csv_;
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
    __tmp.setFileUrl(__bean.getFileUrl());
    __tmp.setCsv(__bean.getCsv());
    __tmp.setCsvValidationWeb(__bean.getCsvValidationWeb());
    __tmp.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
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
