
package es.caib.digitalib.persistence;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Id;


@Entity(name = "AvisJPA")
@Table(name = "dib_avis" , indexes = { 
        @Index(name="dib_avis_pk_i", columnList = "avisid"),
        @Index(name="dib_avis_descripcioid_fk_i", columnList = "descripcioid"),
        @Index(name="dib_avis_configgrupid_fk_i", columnList = "configgrupid")})
@SequenceGenerator(name="AVIS_SEQ", sequenceName="dib_avis_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class AvisJPA implements Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="AVIS_SEQ")
    @Column(name="avisid",nullable = false,length = 19)
    long avisID;

    @Column(name="descripcioid",nullable = false,length = 19)
    long descripcioID;

    @org.hibernate.annotations.ColumnDefault("0")
    @Column(name="tipus",nullable = false,length = 10)
    int tipus = 0;

    @Column(name="datainici",length = 29,precision = 6)
    java.sql.Timestamp dataInici;

    @Column(name="datafi",length = 35,precision = 6)
    java.sql.Timestamp dataFi;

    @Column(name="configgrupid",length = 19)
    java.lang.Long configGrupID;

    @Column(name="bloquejar",nullable = false,length = 1)
    boolean bloquejar;



  /** Constructor Buit */
  public AvisJPA() {
  }

  /** Constructor amb tots els camps  */
  public AvisJPA(long avisID , long descripcioID , int tipus , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long configGrupID , boolean bloquejar) {
    this.avisID=avisID;
    this.descripcioID=descripcioID;
    this.tipus=tipus;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.configGrupID=configGrupID;
    this.bloquejar=bloquejar;
}
  /** Constructor sense valors autoincrementals */
  public AvisJPA(long descripcioID , int tipus , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.Long configGrupID , boolean bloquejar) {
    this.descripcioID=descripcioID;
    this.tipus=tipus;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.configGrupID=configGrupID;
    this.bloquejar=bloquejar;
}
  /** Constructor dels valors Not Null */
  public AvisJPA(long avisID , long descripcioID , int tipus , boolean bloquejar) {
    this.avisID=avisID;
    this.descripcioID=descripcioID;
    this.tipus=tipus;
    this.bloquejar=bloquejar;
}
  public AvisJPA(Avis __bean) {
    this.setAvisID(__bean.getAvisID());
    this.setDescripcioID(__bean.getDescripcioID());
    this.setTipus(__bean.getTipus());
    this.setDataInici(__bean.getDataInici());
    this.setDataFi(__bean.getDataFi());
    this.setConfigGrupID(__bean.getConfigGrupID());
    this.setBloquejar(__bean.isBloquejar());
	}

	public long getAvisID() {
		return(avisID);
	};
	public void setAvisID(long _avisID_) {
		this.avisID = _avisID_;
	};

	public long getDescripcioID() {
		return(descripcioID);
	};
	public void setDescripcioID(long _descripcioID_) {
		this.descripcioID = _descripcioID_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
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

	public java.lang.Long getConfigGrupID() {
		return(configGrupID);
	};
	public void setConfigGrupID(java.lang.Long _configGrupID_) {
		this.configGrupID = _configGrupID_;
	};

	public boolean isBloquejar() {
		return(bloquejar);
	};
	public void setBloquejar(boolean _bloquejar_) {
		this.bloquejar = _bloquejar_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Avis) {
      Avis __instance = (Avis)__obj;
      __result = true;
      __result = __result && (this.getAvisID() == __instance.getAvisID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:traduccioid | Table: dib_traduccio | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER, cascade=javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "descripcioid", referencedColumnName ="traduccioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="dib_avis_traduccio_desc_fk"))
    private TraduccioJPA descripcio;

    public TraduccioJPA getDescripcio() {
    return this.descripcio;
  }

    public  void setDescripcio(TraduccioJPA descripcio) {
    this.descripcio = descripcio;
  }

  @javax.xml.bind.annotation.XmlTransient
  public java.util.Map<String, es.caib.digitalib.persistence.TraduccioMapJPA> getDescripcioTraduccions() {
    return this.descripcio.getTraduccions();
  }

  public void setDescripcioTraduccions(java.util.Map<String, es.caib.digitalib.persistence.TraduccioMapJPA> __traduccions__) {
    this.descripcio.setTraduccions(__traduccions__);
  }


// IMP Field:configuraciogrupid | Table: dib_configuraciogrup | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "configgrupid", referencedColumnName ="configuracioGrupID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="dib_avis_cfggrup_configgrup_fk"))
    private ConfiguracioGrupJPA configuracioGrup;

    public ConfiguracioGrupJPA getConfiguracioGrup() {
    return this.configuracioGrup;
  }

    public  void setConfiguracioGrup(ConfiguracioGrupJPA configuracioGrup) {
    this.configuracioGrup = configuracioGrup;
  }


 // ---------------  STATIC METHODS ------------------
  public static AvisJPA toJPA(Avis __bean) {
    if (__bean == null) { return null;}
    AvisJPA __tmp = new AvisJPA();
    __tmp.setAvisID(__bean.getAvisID());
    __tmp.setDescripcioID(__bean.getDescripcioID());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setConfigGrupID(__bean.getConfigGrupID());
    __tmp.setBloquejar(__bean.isBloquejar());
		return __tmp;
	}


  public static AvisJPA copyJPA(AvisJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<AvisJPA> copyJPA(java.util.Set<AvisJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<AvisJPA> __tmpSet = (java.util.Set<AvisJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<AvisJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (AvisJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static AvisJPA copyJPA(AvisJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    AvisJPA __tmp = (AvisJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"TraduccioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.descripcio) || org.hibernate.Hibernate.isInitialized(__jpa.getDescripcio()) ) ) {
      __tmp.setDescripcio(TraduccioJPA.copyJPA(__jpa.getDescripcio(), __alreadyCopied,"AvisJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup()) ) ) {
      __tmp.setConfiguracioGrup(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup(), __alreadyCopied,"AvisJPA"));
    }

    return __tmp;
  }




}
