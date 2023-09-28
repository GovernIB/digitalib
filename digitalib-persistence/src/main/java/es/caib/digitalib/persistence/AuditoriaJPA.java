
package es.caib.digitalib.persistence;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;


@Entity(name = "AuditoriaJPA")
@Table(name = "dib_auditoria" , indexes = { 
        @Index(name="dib_auditoria_pk_i", columnList = "auditoriaid")})
@SequenceGenerator(name="AUDITORIA_SEQ", sequenceName="dib_auditoria_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class AuditoriaJPA implements Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="AUDITORIA_SEQ")
    @Column(name="auditoriaid",nullable = false,length = 19)
    long auditoriaID;

    @Column(name="data",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp data;

    @Column(name="transaccioid",nullable = false,length = 19)
    long transaccioId;

    @Column(name="tipus",nullable = false,length = 10)
    int tipus;

    @Column(name="missatge",nullable = false,length = 255)
    java.lang.String missatge;

    @Column(name="additionalinfo",length = 3000)
    java.lang.String additionalInfo;

    @Column(name="isapp",nullable = false,length = 1)
    boolean isApp;

  /** Username d'Aplicacio que realitza aquella acció reportada per l'auditoria. */
    @Column(name="usernameaplicacio",length = 255)
    java.lang.String usernameAplicacio;

  /** Username de Persona que realitza aquella acció reportada per l'auditoria. */
    @Column(name="usernamepersona",length = 255)
    java.lang.String usernamePersona;



  /** Constructor Buit */
  public AuditoriaJPA() {
  }

  /** Constructor amb tots els camps  */
  public AuditoriaJPA(long auditoriaID , java.sql.Timestamp data , long transaccioId , int tipus , java.lang.String missatge , java.lang.String additionalInfo , boolean isApp , java.lang.String usernameAplicacio , java.lang.String usernamePersona) {
    this.auditoriaID=auditoriaID;
    this.data=data;
    this.transaccioId=transaccioId;
    this.tipus=tipus;
    this.missatge=missatge;
    this.additionalInfo=additionalInfo;
    this.isApp=isApp;
    this.usernameAplicacio=usernameAplicacio;
    this.usernamePersona=usernamePersona;
}
  /** Constructor sense valors autoincrementals */
  public AuditoriaJPA(java.sql.Timestamp data , long transaccioId , int tipus , java.lang.String missatge , java.lang.String additionalInfo , boolean isApp , java.lang.String usernameAplicacio , java.lang.String usernamePersona) {
    this.data=data;
    this.transaccioId=transaccioId;
    this.tipus=tipus;
    this.missatge=missatge;
    this.additionalInfo=additionalInfo;
    this.isApp=isApp;
    this.usernameAplicacio=usernameAplicacio;
    this.usernamePersona=usernamePersona;
}
  /** Constructor dels valors Not Null */
  public AuditoriaJPA(long auditoriaID , java.sql.Timestamp data , long transaccioId , int tipus , java.lang.String missatge , boolean isApp) {
    this.auditoriaID=auditoriaID;
    this.data=data;
    this.transaccioId=transaccioId;
    this.tipus=tipus;
    this.missatge=missatge;
    this.isApp=isApp;
}
  public AuditoriaJPA(Auditoria __bean) {
    this.setAuditoriaID(__bean.getAuditoriaID());
    this.setData(__bean.getData());
    this.setTransaccioId(__bean.getTransaccioId());
    this.setTipus(__bean.getTipus());
    this.setMissatge(__bean.getMissatge());
    this.setAdditionalInfo(__bean.getAdditionalInfo());
    this.setIsApp(__bean.isIsApp());
    this.setUsernameAplicacio(__bean.getUsernameAplicacio());
    this.setUsernamePersona(__bean.getUsernamePersona());
	}

	public long getAuditoriaID() {
		return(auditoriaID);
	};
	public void setAuditoriaID(long _auditoriaID_) {
		this.auditoriaID = _auditoriaID_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public long getTransaccioId() {
		return(transaccioId);
	};
	public void setTransaccioId(long _transaccioId_) {
		this.transaccioId = _transaccioId_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
	};

	public java.lang.String getMissatge() {
		return(missatge);
	};
	public void setMissatge(java.lang.String _missatge_) {
		this.missatge = _missatge_;
	};

	public java.lang.String getAdditionalInfo() {
		return(additionalInfo);
	};
	public void setAdditionalInfo(java.lang.String _additionalInfo_) {
		this.additionalInfo = _additionalInfo_;
	};

	public boolean isIsApp() {
		return(isApp);
	};
	public void setIsApp(boolean _isApp_) {
		this.isApp = _isApp_;
	};

	public java.lang.String getUsernameAplicacio() {
		return(usernameAplicacio);
	};
	public void setUsernameAplicacio(java.lang.String _usernameAplicacio_) {
		this.usernameAplicacio = _usernameAplicacio_;
	};

	public java.lang.String getUsernamePersona() {
		return(usernamePersona);
	};
	public void setUsernamePersona(java.lang.String _usernamePersona_) {
		this.usernamePersona = _usernamePersona_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Auditoria) {
      Auditoria __instance = (Auditoria)__obj;
      __result = true;
      __result = __result && (this.getAuditoriaID() == __instance.getAuditoriaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }


 // ---------------  STATIC METHODS ------------------
  public static AuditoriaJPA toJPA(Auditoria __bean) {
    if (__bean == null) { return null;}
    AuditoriaJPA __tmp = new AuditoriaJPA();
    __tmp.setAuditoriaID(__bean.getAuditoriaID());
    __tmp.setData(__bean.getData());
    __tmp.setTransaccioId(__bean.getTransaccioId());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setMissatge(__bean.getMissatge());
    __tmp.setAdditionalInfo(__bean.getAdditionalInfo());
    __tmp.setIsApp(__bean.isIsApp());
    __tmp.setUsernameAplicacio(__bean.getUsernameAplicacio());
    __tmp.setUsernamePersona(__bean.getUsernamePersona());
		return __tmp;
	}


  public static AuditoriaJPA copyJPA(AuditoriaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<AuditoriaJPA> copyJPA(java.util.Set<AuditoriaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<AuditoriaJPA> __tmpSet = (java.util.Set<AuditoriaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<AuditoriaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (AuditoriaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static AuditoriaJPA copyJPA(AuditoriaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    AuditoriaJPA __tmp = (AuditoriaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
