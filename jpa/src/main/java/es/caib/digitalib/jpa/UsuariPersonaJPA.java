
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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_usuaripersona" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class UsuariPersonaJPA implements UsuariPersona {



private static final long serialVersionUID = -80349968L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_usuaripersona_pk_i")
	@Column(name="usuaripersonaid",nullable = false,length = 19)
	long usuariPersonaID;

	@Column(name="username",nullable = false,unique = true,length = 50)
	java.lang.String username;

	@Column(name="nom",nullable = false,length = 50)
	java.lang.String nom;

	@Column(name="llinatges",nullable = false,length = 100)
	java.lang.String llinatges;

	@Column(name="email",nullable = false,length = 100)
	java.lang.String email;

	@Column(name="nif",nullable = false,unique = true,length = 9)
	java.lang.String nif;

	@Index(name="dib_usrperson_idiomaid_fk_i")
	@Column(name="idiomaid",nullable = false,length = 5)
	java.lang.String idiomaID;

	@Index(name="dib_usrperson_confgrupid_fk_i")
	@Column(name="configuraciogrupid",nullable = false,length = 19)
	long configuracioGrupID;



  /** Constructor Buit */
  public UsuariPersonaJPA() {
  }

  /** Constructor amb tots els camps  */
  public UsuariPersonaJPA(long usuariPersonaID , java.lang.String username , java.lang.String nom , java.lang.String llinatges , java.lang.String email , java.lang.String nif , java.lang.String idiomaID , long configuracioGrupID) {
    this.usuariPersonaID=usuariPersonaID;
    this.username=username;
    this.nom=nom;
    this.llinatges=llinatges;
    this.email=email;
    this.nif=nif;
    this.idiomaID=idiomaID;
    this.configuracioGrupID=configuracioGrupID;
}
  /** Constructor sense valors autoincrementals */
  public UsuariPersonaJPA(java.lang.String username , java.lang.String nom , java.lang.String llinatges , java.lang.String email , java.lang.String nif , java.lang.String idiomaID , long configuracioGrupID) {
    this.username=username;
    this.nom=nom;
    this.llinatges=llinatges;
    this.email=email;
    this.nif=nif;
    this.idiomaID=idiomaID;
    this.configuracioGrupID=configuracioGrupID;
}
  public UsuariPersonaJPA(UsuariPersona __bean) {
    this.setUsuariPersonaID(__bean.getUsuariPersonaID());
    this.setUsername(__bean.getUsername());
    this.setNom(__bean.getNom());
    this.setLlinatges(__bean.getLlinatges());
    this.setEmail(__bean.getEmail());
    this.setNif(__bean.getNif());
    this.setIdiomaID(__bean.getIdiomaID());
    this.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
	}

	public long getUsuariPersonaID() {
		return(usuariPersonaID);
	};
	public void setUsuariPersonaID(long _usuariPersonaID_) {
		this.usuariPersonaID = _usuariPersonaID_;
	};

	public java.lang.String getUsername() {
		return(username);
	};
	public void setUsername(java.lang.String _username_) {
		this.username = _username_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getLlinatges() {
		return(llinatges);
	};
	public void setLlinatges(java.lang.String _llinatges_) {
		this.llinatges = _llinatges_;
	};

	public java.lang.String getEmail() {
		return(email);
	};
	public void setEmail(java.lang.String _email_) {
		this.email = _email_;
	};

	public java.lang.String getNif() {
		return(nif);
	};
	public void setNif(java.lang.String _nif_) {
		this.nif = _nif_;
	};

	public java.lang.String getIdiomaID() {
		return(idiomaID);
	};
	public void setIdiomaID(java.lang.String _idiomaID_) {
		this.idiomaID = _idiomaID_;
	};

	public long getConfiguracioGrupID() {
		return(configuracioGrupID);
	};
	public void setConfiguracioGrupID(long _configuracioGrupID_) {
		this.configuracioGrupID = _configuracioGrupID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof UsuariPersona) {
      UsuariPersona __instance = (UsuariPersona)__obj;
      __result = true;
      __result = __result && (this.getUsuariPersonaID() == __instance.getUsuariPersonaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:idiomaid | Table: dib_idioma | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_usrperson_idioma_idioma_fk")
	@JoinColumn(name = "idiomaid", referencedColumnName ="idiomaID", nullable = false, insertable=false, updatable=false)
	private IdiomaJPA idioma;

	public IdiomaJPA getIdioma() {
    return this.idioma;
  }

	public  void setIdioma(IdiomaJPA idioma) {
    this.idioma = idioma;
  }

// IMP Field:configuraciogrupid | Table: dib_configuraciogrup | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_usrperson_cfggrup_conf_fk")
	@JoinColumn(name = "configuraciogrupid", referencedColumnName ="configuracioGrupID", nullable = false, insertable=false, updatable=false)
	private ConfiguracioGrupJPA configuracioGrup;

	public ConfiguracioGrupJPA getConfiguracioGrup() {
    return this.configuracioGrup;
  }

	public  void setConfiguracioGrup(ConfiguracioGrupJPA configuracioGrup) {
    this.configuracioGrup = configuracioGrup;
  }


 // ---------------  STATIC METHODS ------------------
  public static UsuariPersonaJPA toJPA(UsuariPersona __bean) {
    if (__bean == null) { return null;}
    UsuariPersonaJPA __tmp = new UsuariPersonaJPA();
    __tmp.setUsuariPersonaID(__bean.getUsuariPersonaID());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setNom(__bean.getNom());
    __tmp.setLlinatges(__bean.getLlinatges());
    __tmp.setEmail(__bean.getEmail());
    __tmp.setNif(__bean.getNif());
    __tmp.setIdiomaID(__bean.getIdiomaID());
    __tmp.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
		return __tmp;
	}


  public static UsuariPersonaJPA copyJPA(UsuariPersonaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<UsuariPersonaJPA> copyJPA(java.util.Set<UsuariPersonaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<UsuariPersonaJPA> __tmpSet = (java.util.Set<UsuariPersonaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<UsuariPersonaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (UsuariPersonaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static UsuariPersonaJPA copyJPA(UsuariPersonaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    UsuariPersonaJPA __tmp = (UsuariPersonaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"IdiomaJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.idioma) || org.hibernate.Hibernate.isInitialized(__jpa.getIdioma()) ) ) {
      __tmp.setIdioma(IdiomaJPA.copyJPA(__jpa.getIdioma(), __alreadyCopied,"UsuariPersonaJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup()) ) ) {
      __tmp.setConfiguracioGrup(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup(), __alreadyCopied,"UsuariPersonaJPA"));
    }

    return __tmp;
  }




}
