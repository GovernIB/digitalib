
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


@Entity(name = "MetadadaJPA")
@Table(name = "dib_metadada" , indexes = { 
        @Index(name="dib_metadada_pk_i", columnList = "metadadaid"),
        @Index(name="dib_metadada_transaccioid_fk_i", columnList = "transaccioid")})
@SequenceGenerator(name="METADADA_SEQ", sequenceName="dib_metadada_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class MetadadaJPA implements Metadada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="METADADA_SEQ")
    @Column(name="metadadaid",nullable = false,length = 19)
    long metadadaid;

    @Column(name="transaccioid",nullable = false,length = 19)
    long transaccioID;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="valor",nullable = false,length = 3000)
    java.lang.String valor;



  /** Constructor Buit */
  public MetadadaJPA() {
  }

  /** Constructor amb tots els camps  */
  public MetadadaJPA(long metadadaid , long transaccioID , java.lang.String nom , java.lang.String valor) {
    this.metadadaid=metadadaid;
    this.transaccioID=transaccioID;
    this.nom=nom;
    this.valor=valor;
}
  /** Constructor sense valors autoincrementals */
  public MetadadaJPA(long transaccioID , java.lang.String nom , java.lang.String valor) {
    this.transaccioID=transaccioID;
    this.nom=nom;
    this.valor=valor;
}
  public MetadadaJPA(Metadada __bean) {
    this.setMetadadaid(__bean.getMetadadaid());
    this.setTransaccioID(__bean.getTransaccioID());
    this.setNom(__bean.getNom());
    this.setValor(__bean.getValor());
	}

	public long getMetadadaid() {
		return(metadadaid);
	};
	public void setMetadadaid(long _metadadaid_) {
		this.metadadaid = _metadadaid_;
	};

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

	public java.lang.String getValor() {
		return(valor);
	};
	public void setValor(java.lang.String _valor_) {
		this.valor = _valor_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Metadada) {
      Metadada __instance = (Metadada)__obj;
      __result = true;
      __result = __result && (this.getMetadadaid() == __instance.getMetadadaid()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:transaccioid | Table: dib_transaccio | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaccioid", referencedColumnName ="transaccioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="dib_meta_transaccio_trans_fk"))
    private TransaccioJPA transaccio;

    public TransaccioJPA getTransaccio() {
    return this.transaccio;
  }

    public  void setTransaccio(TransaccioJPA transaccio) {
    this.transaccio = transaccio;
  }


 // ---------------  STATIC METHODS ------------------
  public static MetadadaJPA toJPA(Metadada __bean) {
    if (__bean == null) { return null;}
    MetadadaJPA __tmp = new MetadadaJPA();
    __tmp.setMetadadaid(__bean.getMetadadaid());
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setValor(__bean.getValor());
		return __tmp;
	}


  public static MetadadaJPA copyJPA(MetadadaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<MetadadaJPA> copyJPA(java.util.Set<MetadadaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<MetadadaJPA> __tmpSet = (java.util.Set<MetadadaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<MetadadaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (MetadadaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static MetadadaJPA copyJPA(MetadadaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    MetadadaJPA __tmp = (MetadadaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"TransaccioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccio) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccio()) ) ) {
      __tmp.setTransaccio(TransaccioJPA.copyJPA(__jpa.getTransaccio(), __alreadyCopied,"MetadadaJPA"));
    }

    return __tmp;
  }




}
