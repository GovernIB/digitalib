
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Index;
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

	@Column(name="datainici",nullable = false,length = 29,precision = 6)
	java.sql.Timestamp datainici;

	@Column(name="datafi",length = 29,precision = 6)
	java.sql.Timestamp datafi;

	@Column(name="usuariaplicacioid",length = 19)
	java.lang.Long usuariaplicacioid;

	@Column(name="usuaripersonaid",length = 19)
	java.lang.Long usuaripersonaid;



  /** Constructor Buit */
  public TransaccioJPA() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioJPA(long transaccioID , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid) {
    this.transaccioID=transaccioID;
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacioid=usuariaplicacioid;
    this.usuaripersonaid=usuaripersonaid;
}
  /** Constructor sense valors autoincrementals */
  public TransaccioJPA(java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.Long usuariaplicacioid , java.lang.Long usuaripersonaid) {
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacioid=usuariaplicacioid;
    this.usuaripersonaid=usuaripersonaid;
}
  /** Constructor dels valors Not Null */
  public TransaccioJPA(long transaccioID , java.sql.Timestamp datainici) {
    this.transaccioID=transaccioID;
    this.datainici=datainici;
}
  public TransaccioJPA(Transaccio __bean) {
    this.setTransaccioID(__bean.getTransaccioID());
    this.setDatainici(__bean.getDatainici());
    this.setDatafi(__bean.getDatafi());
    this.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    this.setUsuaripersonaid(__bean.getUsuaripersonaid());
	}

	public long getTransaccioID() {
		return(transaccioID);
	};
	public void setTransaccioID(long _transaccioID_) {
		this.transaccioID = _transaccioID_;
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


 // ---------------  STATIC METHODS ------------------
  public static TransaccioJPA toJPA(Transaccio __bean) {
    if (__bean == null) { return null;}
    TransaccioJPA __tmp = new TransaccioJPA();
    __tmp.setTransaccioID(__bean.getTransaccioID());
    __tmp.setDatainici(__bean.getDatainici());
    __tmp.setDatafi(__bean.getDatafi());
    __tmp.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    __tmp.setUsuaripersonaid(__bean.getUsuaripersonaid());
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

    return __tmp;
  }




}
