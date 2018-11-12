
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Index;
import javax.persistence.UniqueConstraint;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_perfilusrapp"  , uniqueConstraints = {
            @UniqueConstraint( columnNames={"perfilid","usuariaplicacioid"}) } )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class PerfilUsuariAplicacioJPA implements PerfilUsuariAplicacio {



private static final long serialVersionUID = -1571857111L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_perfilusrapp_pk_i")
	@Column(name="perfilusrappid",nullable = false,length = 19)
	long perfilUsrAppID;

	@Index(name="dib_perfilusrapp_perfilid_fk_i")
	@Column(name="perfilid",nullable = false,length = 19)
	long perfilID;

	@Index(name="dib_perfusrapp_usrappid_fk_i")
	@Column(name="usuariaplicacioid",nullable = false,length = 19)
	long usuariAplicacioID;



  /** Constructor Buit */
  public PerfilUsuariAplicacioJPA() {
  }

  /** Constructor amb tots els camps  */
  public PerfilUsuariAplicacioJPA(long perfilUsrAppID , long perfilID , long usuariAplicacioID) {
    this.perfilUsrAppID=perfilUsrAppID;
    this.perfilID=perfilID;
    this.usuariAplicacioID=usuariAplicacioID;
}
  /** Constructor sense valors autoincrementals */
  public PerfilUsuariAplicacioJPA(long perfilID , long usuariAplicacioID) {
    this.perfilID=perfilID;
    this.usuariAplicacioID=usuariAplicacioID;
}
  public PerfilUsuariAplicacioJPA(PerfilUsuariAplicacio __bean) {
    this.setPerfilUsrAppID(__bean.getPerfilUsrAppID());
    this.setPerfilID(__bean.getPerfilID());
    this.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
	}

	public long getPerfilUsrAppID() {
		return(perfilUsrAppID);
	};
	public void setPerfilUsrAppID(long _perfilUsrAppID_) {
		this.perfilUsrAppID = _perfilUsrAppID_;
	};

	public long getPerfilID() {
		return(perfilID);
	};
	public void setPerfilID(long _perfilID_) {
		this.perfilID = _perfilID_;
	};

	public long getUsuariAplicacioID() {
		return(usuariAplicacioID);
	};
	public void setUsuariAplicacioID(long _usuariAplicacioID_) {
		this.usuariAplicacioID = _usuariAplicacioID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof PerfilUsuariAplicacio) {
      PerfilUsuariAplicacio __instance = (PerfilUsuariAplicacio)__obj;
      __result = true;
      __result = __result && (this.getPerfilUsrAppID() == __instance.getPerfilUsrAppID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:perfilid | Table: dib_perfil | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_perfusrapp_perfil_fk")
	@JoinColumn(name = "perfilid", referencedColumnName ="perfilID", nullable = false, insertable=false, updatable=false)
	private PerfilJPA perfil;

	public PerfilJPA getPerfil() {
    return this.perfil;
  }

	public  void setPerfil(PerfilJPA perfil) {
    this.perfil = perfil;
  }

// IMP Field:usuariaplicacioid | Table: dib_usuariaplicacio | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_perfusrapp_usrapp_usrap_fk")
	@JoinColumn(name = "usuariaplicacioid", referencedColumnName ="usuariAplicacioID", nullable = false, insertable=false, updatable=false)
	private UsuariAplicacioJPA usuariAplicacio;

	public UsuariAplicacioJPA getUsuariAplicacio() {
    return this.usuariAplicacio;
  }

	public  void setUsuariAplicacio(UsuariAplicacioJPA usuariAplicacio) {
    this.usuariAplicacio = usuariAplicacio;
  }


 // ---------------  STATIC METHODS ------------------
  public static PerfilUsuariAplicacioJPA toJPA(PerfilUsuariAplicacio __bean) {
    if (__bean == null) { return null;}
    PerfilUsuariAplicacioJPA __tmp = new PerfilUsuariAplicacioJPA();
    __tmp.setPerfilUsrAppID(__bean.getPerfilUsrAppID());
    __tmp.setPerfilID(__bean.getPerfilID());
    __tmp.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
		return __tmp;
	}


  public static PerfilUsuariAplicacioJPA copyJPA(PerfilUsuariAplicacioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<PerfilUsuariAplicacioJPA> copyJPA(java.util.Set<PerfilUsuariAplicacioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<PerfilUsuariAplicacioJPA> __tmpSet = (java.util.Set<PerfilUsuariAplicacioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<PerfilUsuariAplicacioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (PerfilUsuariAplicacioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static PerfilUsuariAplicacioJPA copyJPA(PerfilUsuariAplicacioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    PerfilUsuariAplicacioJPA __tmp = (PerfilUsuariAplicacioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"PerfilJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil()) ) ) {
      __tmp.setPerfil(PerfilJPA.copyJPA(__jpa.getPerfil(), __alreadyCopied,"PerfilUsuariAplicacioJPA"));
    }
    if(!"UsuariAplicacioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.usuariAplicacio) || org.hibernate.Hibernate.isInitialized(__jpa.getUsuariAplicacio()) ) ) {
      __tmp.setUsuariAplicacio(UsuariAplicacioJPA.copyJPA(__jpa.getUsuariAplicacio(), __alreadyCopied,"PerfilUsuariAplicacioJPA"));
    }

    return __tmp;
  }




}
