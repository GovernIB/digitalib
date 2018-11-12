
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.ForeignKey;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_configuraciogrup" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class ConfiguracioGrupJPA implements ConfiguracioGrup {



private static final long serialVersionUID = -185147282L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_configuraciogrup_pk_i")
	@Column(name="configuraciogrupid",nullable = false,length = 19)
	long configuracioGrupID;

	@Column(name="nom",nullable = false,unique = true,length = 100)
	java.lang.String nom;

	@Column(name="suportweb",length = 255)
	java.lang.String suportWeb;

	@Column(name="suportemail",length = 255)
	java.lang.String suportEmail;

	@Column(name="suporttelefon",length = 255)
	java.lang.String suportTelefon;

	@Index(name="dib_cfggrup_logoheaderid_fk_i")
	@Column(name="logoheaderid",nullable = false,length = 19)
	long logoHeaderID;

	@Index(name="dib_cfggrup_logofooterid_fk_i")
	@Column(name="logofooterid",nullable = false,length = 19)
	long logoFooterID;



  /** Constructor Buit */
  public ConfiguracioGrupJPA() {
  }

  /** Constructor amb tots els camps  */
  public ConfiguracioGrupJPA(long configuracioGrupID , java.lang.String nom , java.lang.String suportWeb , java.lang.String suportEmail , java.lang.String suportTelefon , long logoHeaderID , long logoFooterID) {
    this.configuracioGrupID=configuracioGrupID;
    this.nom=nom;
    this.suportWeb=suportWeb;
    this.suportEmail=suportEmail;
    this.suportTelefon=suportTelefon;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
}
  /** Constructor sense valors autoincrementals */
  public ConfiguracioGrupJPA(java.lang.String nom , java.lang.String suportWeb , java.lang.String suportEmail , java.lang.String suportTelefon , long logoHeaderID , long logoFooterID) {
    this.nom=nom;
    this.suportWeb=suportWeb;
    this.suportEmail=suportEmail;
    this.suportTelefon=suportTelefon;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
}
  /** Constructor dels valors Not Null */
  public ConfiguracioGrupJPA(long configuracioGrupID , java.lang.String nom , long logoHeaderID , long logoFooterID) {
    this.configuracioGrupID=configuracioGrupID;
    this.nom=nom;
    this.logoHeaderID=logoHeaderID;
    this.logoFooterID=logoFooterID;
}
  public ConfiguracioGrupJPA(ConfiguracioGrup __bean) {
    this.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
    this.setNom(__bean.getNom());
    this.setSuportWeb(__bean.getSuportWeb());
    this.setSuportEmail(__bean.getSuportEmail());
    this.setSuportTelefon(__bean.getSuportTelefon());
    this.setLogoHeaderID(__bean.getLogoHeaderID());
    this.setLogoFooterID(__bean.getLogoFooterID());
    // Fitxer
    this.setLogoHeader(FitxerJPA.toJPA(__bean.getLogoHeader()));
    // Fitxer
    this.setLogoFooter(FitxerJPA.toJPA(__bean.getLogoFooter()));
	}

	public long getConfiguracioGrupID() {
		return(configuracioGrupID);
	};
	public void setConfiguracioGrupID(long _configuracioGrupID_) {
		this.configuracioGrupID = _configuracioGrupID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getSuportWeb() {
		return(suportWeb);
	};
	public void setSuportWeb(java.lang.String _suportWeb_) {
		this.suportWeb = _suportWeb_;
	};

	public java.lang.String getSuportEmail() {
		return(suportEmail);
	};
	public void setSuportEmail(java.lang.String _suportEmail_) {
		this.suportEmail = _suportEmail_;
	};

	public java.lang.String getSuportTelefon() {
		return(suportTelefon);
	};
	public void setSuportTelefon(java.lang.String _suportTelefon_) {
		this.suportTelefon = _suportTelefon_;
	};

	public long getLogoHeaderID() {
		return(logoHeaderID);
	};
	public void setLogoHeaderID(long _logoHeaderID_) {
		this.logoHeaderID = _logoHeaderID_;
	};

	public long getLogoFooterID() {
		return(logoFooterID);
	};
	public void setLogoFooterID(long _logoFooterID_) {
		this.logoFooterID = _logoFooterID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof ConfiguracioGrup) {
      ConfiguracioGrup __instance = (ConfiguracioGrup)__obj;
      __result = true;
      __result = __result && (this.getConfiguracioGrupID() == __instance.getConfiguracioGrupID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:configuraciogrupid | Table: dib_usuaripersona | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "configuracioGrup")
	private Set<UsuariPersonaJPA> usuariPersonas = new HashSet<UsuariPersonaJPA>(0);
	public  Set<UsuariPersonaJPA> getUsuariPersonas() {
    return this.usuariPersonas;
  }

	public void setUsuariPersonas(Set<UsuariPersonaJPA> usuariPersonas) {
	  this.usuariPersonas = usuariPersonas;
	}


// IMP Field:fitxerid | Table: dib_fitxer | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name="dib_cfggrup_fitxer_cap_fk")
	@JoinColumn(name = "logoheaderid", referencedColumnName ="fitxerID", nullable = false, insertable=false, updatable=false)
	private FitxerJPA logoHeader;

	public FitxerJPA getLogoHeader() {
    return this.logoHeader;
  }

	public  void setLogoHeader(FitxerJPA logoHeader) {
    this.logoHeader = logoHeader;
  }

// IMP Field:fitxerid | Table: dib_fitxer | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name="dib_cfggrup_fitxer_peu_fk")
	@JoinColumn(name = "logofooterid", referencedColumnName ="fitxerID", nullable = false, insertable=false, updatable=false)
	private FitxerJPA logoFooter;

	public FitxerJPA getLogoFooter() {
    return this.logoFooter;
  }

	public  void setLogoFooter(FitxerJPA logoFooter) {
    this.logoFooter = logoFooter;
  }


 // ---------------  STATIC METHODS ------------------
  public static ConfiguracioGrupJPA toJPA(ConfiguracioGrup __bean) {
    if (__bean == null) { return null;}
    ConfiguracioGrupJPA __tmp = new ConfiguracioGrupJPA();
    __tmp.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
    __tmp.setNom(__bean.getNom());
    __tmp.setSuportWeb(__bean.getSuportWeb());
    __tmp.setSuportEmail(__bean.getSuportEmail());
    __tmp.setSuportTelefon(__bean.getSuportTelefon());
    __tmp.setLogoHeaderID(__bean.getLogoHeaderID());
    __tmp.setLogoFooterID(__bean.getLogoFooterID());
    // Fitxer
    __tmp.setLogoHeader(FitxerJPA.toJPA(__bean.getLogoHeader()));
    // Fitxer
    __tmp.setLogoFooter(FitxerJPA.toJPA(__bean.getLogoFooter()));
		return __tmp;
	}


  public static ConfiguracioGrupJPA copyJPA(ConfiguracioGrupJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<ConfiguracioGrupJPA> copyJPA(java.util.Set<ConfiguracioGrupJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<ConfiguracioGrupJPA> __tmpSet = (java.util.Set<ConfiguracioGrupJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<ConfiguracioGrupJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (ConfiguracioGrupJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static ConfiguracioGrupJPA copyJPA(ConfiguracioGrupJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    ConfiguracioGrupJPA __tmp = (ConfiguracioGrupJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"UsuariPersonaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.usuariPersonas) || org.hibernate.Hibernate.isInitialized(__jpa.getUsuariPersonas())) ) {
      __tmp.setUsuariPersonas(UsuariPersonaJPA.copyJPA(__jpa.getUsuariPersonas(), __alreadyCopied,"ConfiguracioGrupJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
