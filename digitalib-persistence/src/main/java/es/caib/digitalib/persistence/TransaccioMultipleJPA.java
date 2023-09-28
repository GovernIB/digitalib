
package es.caib.digitalib.persistence;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Id;


@Entity(name = "TransaccioMultipleJPA")
@Table(name = "dib_transmultiple" , indexes = { 
        @Index(name="dib_transmultiple_pk_i", columnList = "transmultipleid"),
        @Index(name="dib_transmul_fscaned_fk_i", columnList = "fitxerescanejatid")})
@SequenceGenerator(name="TRANSACCIOMULTIPLE_SEQ", sequenceName="dib_transmultiple_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class TransaccioMultipleJPA implements TransaccioMultiple {

    @Id
    @Column(name="transmultipleid",nullable = false,length = 19)
    long transmultipleid;

    @Column(name="descripcio",nullable = false,length = 256)
    java.lang.String descripcio;

    @Column(name="fitxerescanejatid",length = 19)
    java.lang.Long fitxerEscanejatID;



  /** Constructor Buit */
  public TransaccioMultipleJPA() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioMultipleJPA(long transmultipleid , java.lang.String descripcio , java.lang.Long fitxerEscanejatID) {
    this.transmultipleid=transmultipleid;
    this.descripcio=descripcio;
    this.fitxerEscanejatID=fitxerEscanejatID;
}
  /** Constructor dels valors Not Null */
  public TransaccioMultipleJPA(long transmultipleid , java.lang.String descripcio) {
    this.transmultipleid=transmultipleid;
    this.descripcio=descripcio;
}
  public TransaccioMultipleJPA(TransaccioMultiple __bean) {
    this.setTransmultipleid(__bean.getTransmultipleid());
    this.setDescripcio(__bean.getDescripcio());
    this.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    // Fitxer
    this.setFitxerEscanejat(FitxerJPA.toJPA(__bean.getFitxerEscanejat()));
	}

	public long getTransmultipleid() {
		return(transmultipleid);
	};
	public void setTransmultipleid(long _transmultipleid_) {
		this.transmultipleid = _transmultipleid_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.Long getFitxerEscanejatID() {
		return(fitxerEscanejatID);
	};
	public void setFitxerEscanejatID(java.lang.Long _fitxerEscanejatID_) {
		this.fitxerEscanejatID = _fitxerEscanejatID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof TransaccioMultiple) {
      TransaccioMultiple __instance = (TransaccioMultiple)__obj;
      __result = true;
      __result = __result && (this.getTransmultipleid() == __instance.getTransmultipleid()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:transmultipleid | Table: dib_transaccio | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaccioMultiple")
    private Set<TransaccioJPA> transaccios = new HashSet<TransaccioJPA>(0);
    public  Set<TransaccioJPA> getTransaccios() {
    return this.transaccios;
  }

    public void setTransaccios(Set<TransaccioJPA> transaccios) {
      this.transaccios = transaccios;
    }


// IMP Field:fitxerid | Table: dib_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fitxerescanejatid", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="dib_transmul_fitxer_fies_fk"))
    private FitxerJPA fitxerEscanejat;

    public FitxerJPA getFitxerEscanejat() {
    return this.fitxerEscanejat;
  }

    public  void setFitxerEscanejat(FitxerJPA fitxerEscanejat) {
    this.fitxerEscanejat = fitxerEscanejat;
  }


 // ---------------  STATIC METHODS ------------------
  public static TransaccioMultipleJPA toJPA(TransaccioMultiple __bean) {
    if (__bean == null) { return null;}
    TransaccioMultipleJPA __tmp = new TransaccioMultipleJPA();
    __tmp.setTransmultipleid(__bean.getTransmultipleid());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    // Fitxer
    __tmp.setFitxerEscanejat(FitxerJPA.toJPA(__bean.getFitxerEscanejat()));
		return __tmp;
	}


  public static TransaccioMultipleJPA copyJPA(TransaccioMultipleJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<TransaccioMultipleJPA> copyJPA(java.util.Set<TransaccioMultipleJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<TransaccioMultipleJPA> __tmpSet = (java.util.Set<TransaccioMultipleJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<TransaccioMultipleJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (TransaccioMultipleJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static TransaccioMultipleJPA copyJPA(TransaccioMultipleJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    TransaccioMultipleJPA __tmp = (TransaccioMultipleJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"TransaccioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccios) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccios())) ) {
      __tmp.setTransaccios(TransaccioJPA.copyJPA(__jpa.getTransaccios(), __alreadyCopied,"TransaccioMultipleJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
