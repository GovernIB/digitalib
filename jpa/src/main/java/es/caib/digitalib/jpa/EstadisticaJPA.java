
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_estadistica" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class EstadisticaJPA implements Estadistica {



private static final long serialVersionUID = -2066559243L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Column(name="estadisticaid",nullable = false,length = 19)
	long estadisticaID;

	@Column(name="tipus",nullable = false,length = 10)
	int tipus;

	@Column(name="data",nullable = false,length = 29,precision = 6)
	java.sql.Timestamp data;

	@Column(name="valor",nullable = false,length = 17,precision = 17)
	double valor;

	@Column(name="parametres",length = 3000)
	java.lang.String parametres;

	@Column(name="usuariaplicacioid",length = 19)
	java.lang.Long usuariAplicacioID;

	@Column(name="usuaripersonaid",length = 19)
	java.lang.Long usuariPersonaID;



  /** Constructor Buit */
  public EstadisticaJPA() {
  }

  /** Constructor amb tots els camps  */
  public EstadisticaJPA(long estadisticaID , int tipus , java.sql.Timestamp data , double valor , java.lang.String parametres , java.lang.Long usuariAplicacioID , java.lang.Long usuariPersonaID) {
    this.estadisticaID=estadisticaID;
    this.tipus=tipus;
    this.data=data;
    this.valor=valor;
    this.parametres=parametres;
    this.usuariAplicacioID=usuariAplicacioID;
    this.usuariPersonaID=usuariPersonaID;
}
  /** Constructor sense valors autoincrementals */
  public EstadisticaJPA(int tipus , java.sql.Timestamp data , double valor , java.lang.String parametres , java.lang.Long usuariAplicacioID , java.lang.Long usuariPersonaID) {
    this.tipus=tipus;
    this.data=data;
    this.valor=valor;
    this.parametres=parametres;
    this.usuariAplicacioID=usuariAplicacioID;
    this.usuariPersonaID=usuariPersonaID;
}
  /** Constructor dels valors Not Null */
  public EstadisticaJPA(long estadisticaID , int tipus , java.sql.Timestamp data , double valor) {
    this.estadisticaID=estadisticaID;
    this.tipus=tipus;
    this.data=data;
    this.valor=valor;
}
  public EstadisticaJPA(Estadistica __bean) {
    this.setEstadisticaID(__bean.getEstadisticaID());
    this.setTipus(__bean.getTipus());
    this.setData(__bean.getData());
    this.setValor(__bean.getValor());
    this.setParametres(__bean.getParametres());
    this.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    this.setUsuariPersonaID(__bean.getUsuariPersonaID());
	}

	public long getEstadisticaID() {
		return(estadisticaID);
	};
	public void setEstadisticaID(long _estadisticaID_) {
		this.estadisticaID = _estadisticaID_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public double getValor() {
		return(valor);
	};
	public void setValor(double _valor_) {
		this.valor = _valor_;
	};

	public java.lang.String getParametres() {
		return(parametres);
	};
	public void setParametres(java.lang.String _parametres_) {
		this.parametres = _parametres_;
	};

	public java.lang.Long getUsuariAplicacioID() {
		return(usuariAplicacioID);
	};
	public void setUsuariAplicacioID(java.lang.Long _usuariAplicacioID_) {
		this.usuariAplicacioID = _usuariAplicacioID_;
	};

	public java.lang.Long getUsuariPersonaID() {
		return(usuariPersonaID);
	};
	public void setUsuariPersonaID(java.lang.Long _usuariPersonaID_) {
		this.usuariPersonaID = _usuariPersonaID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Estadistica) {
      Estadistica __instance = (Estadistica)__obj;
      __result = true;
      __result = __result && (this.getEstadisticaID() == __instance.getEstadisticaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }


 // ---------------  STATIC METHODS ------------------
  public static EstadisticaJPA toJPA(Estadistica __bean) {
    if (__bean == null) { return null;}
    EstadisticaJPA __tmp = new EstadisticaJPA();
    __tmp.setEstadisticaID(__bean.getEstadisticaID());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setData(__bean.getData());
    __tmp.setValor(__bean.getValor());
    __tmp.setParametres(__bean.getParametres());
    __tmp.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    __tmp.setUsuariPersonaID(__bean.getUsuariPersonaID());
		return __tmp;
	}


  public static EstadisticaJPA copyJPA(EstadisticaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EstadisticaJPA> copyJPA(java.util.Set<EstadisticaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EstadisticaJPA> __tmpSet = (java.util.Set<EstadisticaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EstadisticaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EstadisticaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EstadisticaJPA copyJPA(EstadisticaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EstadisticaJPA __tmp = (EstadisticaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
