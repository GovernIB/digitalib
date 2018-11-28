
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
@Table(name = "dib_usuariaplicacio" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class UsuariAplicacioJPA implements UsuariAplicacio {



private static final long serialVersionUID = -360699331L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_usuariaplicacio_pk_i")
	@Column(name="usuariaplicacioid",nullable = false,length = 19)
	long usuariAplicacioID;

	@Column(name="username",nullable = false,unique = true,length = 101)
	java.lang.String username;

	@Column(name="contrasenya",length = 50)
	java.lang.String contrasenya;

	@Column(name="emailadmin",nullable = false,length = 100)
	java.lang.String emailAdmin;

	@Column(name="descripcio",length = 255)
	java.lang.String descripcio;

	@Column(name="actiu",nullable = false,length = 1)
	boolean actiu;



  /** Constructor Buit */
  public UsuariAplicacioJPA() {
  }

  /** Constructor amb tots els camps  */
  public UsuariAplicacioJPA(long usuariAplicacioID , java.lang.String username , java.lang.String contrasenya , java.lang.String emailAdmin , java.lang.String descripcio , boolean actiu) {
    this.usuariAplicacioID=usuariAplicacioID;
    this.username=username;
    this.contrasenya=contrasenya;
    this.emailAdmin=emailAdmin;
    this.descripcio=descripcio;
    this.actiu=actiu;
}
  /** Constructor sense valors autoincrementals */
  public UsuariAplicacioJPA(java.lang.String username , java.lang.String contrasenya , java.lang.String emailAdmin , java.lang.String descripcio , boolean actiu) {
    this.username=username;
    this.contrasenya=contrasenya;
    this.emailAdmin=emailAdmin;
    this.descripcio=descripcio;
    this.actiu=actiu;
}
  /** Constructor dels valors Not Null */
  public UsuariAplicacioJPA(long usuariAplicacioID , java.lang.String username , java.lang.String emailAdmin , boolean actiu) {
    this.usuariAplicacioID=usuariAplicacioID;
    this.username=username;
    this.emailAdmin=emailAdmin;
    this.actiu=actiu;
}
  public UsuariAplicacioJPA(UsuariAplicacio __bean) {
    this.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    this.setUsername(__bean.getUsername());
    this.setContrasenya(__bean.getContrasenya());
    this.setEmailAdmin(__bean.getEmailAdmin());
    this.setDescripcio(__bean.getDescripcio());
    this.setActiu(__bean.isActiu());
	}

	public long getUsuariAplicacioID() {
		return(usuariAplicacioID);
	};
	public void setUsuariAplicacioID(long _usuariAplicacioID_) {
		this.usuariAplicacioID = _usuariAplicacioID_;
	};

	public java.lang.String getUsername() {
		return(username);
	};
	public void setUsername(java.lang.String _username_) {
		this.username = _username_;
	};

	public java.lang.String getContrasenya() {
		return(contrasenya);
	};
	public void setContrasenya(java.lang.String _contrasenya_) {
		this.contrasenya = _contrasenya_;
	};

	public java.lang.String getEmailAdmin() {
		return(emailAdmin);
	};
	public void setEmailAdmin(java.lang.String _emailAdmin_) {
		this.emailAdmin = _emailAdmin_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof UsuariAplicacio) {
      UsuariAplicacio __instance = (UsuariAplicacio)__obj;
      __result = true;
      __result = __result && (this.getUsuariAplicacioID() == __instance.getUsuariAplicacioID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:usuariaplicacioid | Table: dib_perfilusrapp | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuariAplicacio")
	private Set<PerfilUsuariAplicacioJPA> perfilUsuariAplicacios = new HashSet<PerfilUsuariAplicacioJPA>(0);
	public  Set<PerfilUsuariAplicacioJPA> getPerfilUsuariAplicacios() {
    return this.perfilUsuariAplicacios;
  }

	public void setPerfilUsuariAplicacios(Set<PerfilUsuariAplicacioJPA> perfilUsuariAplicacios) {
	  this.perfilUsuariAplicacios = perfilUsuariAplicacios;
	}



 // ---------------  STATIC METHODS ------------------
  public static UsuariAplicacioJPA toJPA(UsuariAplicacio __bean) {
    if (__bean == null) { return null;}
    UsuariAplicacioJPA __tmp = new UsuariAplicacioJPA();
    __tmp.setUsuariAplicacioID(__bean.getUsuariAplicacioID());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setContrasenya(__bean.getContrasenya());
    __tmp.setEmailAdmin(__bean.getEmailAdmin());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setActiu(__bean.isActiu());
		return __tmp;
	}


  public static UsuariAplicacioJPA copyJPA(UsuariAplicacioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<UsuariAplicacioJPA> copyJPA(java.util.Set<UsuariAplicacioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<UsuariAplicacioJPA> __tmpSet = (java.util.Set<UsuariAplicacioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<UsuariAplicacioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (UsuariAplicacioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static UsuariAplicacioJPA copyJPA(UsuariAplicacioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    UsuariAplicacioJPA __tmp = (UsuariAplicacioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"PerfilUsuariAplicacioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfilUsuariAplicacios) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfilUsuariAplicacios())) ) {
      __tmp.setPerfilUsuariAplicacios(PerfilUsuariAplicacioJPA.copyJPA(__jpa.getPerfilUsuariAplicacios(), __alreadyCopied,"UsuariAplicacioJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
