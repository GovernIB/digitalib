
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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_apisimple" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class ApiSimpleJPA implements ApiSimple {



private static final long serialVersionUID = 1125838831L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Column(name="apisimpleid",nullable = false,length = 19)
	long apiSimpleID;

	@Column(name="nom",nullable = false,length = 255)
	java.lang.String nom;

	@Column(name="url",nullable = false,length = 255)
	java.lang.String url;

	@Column(name="username",nullable = false,length = 255)
	java.lang.String username;

	@Column(name="contrasenya",nullable = false,length = 255)
	java.lang.String contrasenya;



  /** Constructor Buit */
  public ApiSimpleJPA() {
  }

  /** Constructor amb tots els camps  */
  public ApiSimpleJPA(long apiSimpleID , java.lang.String nom , java.lang.String url , java.lang.String username , java.lang.String contrasenya) {
    this.apiSimpleID=apiSimpleID;
    this.nom=nom;
    this.url=url;
    this.username=username;
    this.contrasenya=contrasenya;
}
  /** Constructor sense valors autoincrementals */
  public ApiSimpleJPA(java.lang.String nom , java.lang.String url , java.lang.String username , java.lang.String contrasenya) {
    this.nom=nom;
    this.url=url;
    this.username=username;
    this.contrasenya=contrasenya;
}
  public ApiSimpleJPA(ApiSimple __bean) {
    this.setApiSimpleID(__bean.getApiSimpleID());
    this.setNom(__bean.getNom());
    this.setUrl(__bean.getUrl());
    this.setUsername(__bean.getUsername());
    this.setContrasenya(__bean.getContrasenya());
	}

	public long getApiSimpleID() {
		return(apiSimpleID);
	};
	public void setApiSimpleID(long _apiSimpleID_) {
		this.apiSimpleID = _apiSimpleID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getUrl() {
		return(url);
	};
	public void setUrl(java.lang.String _url_) {
		this.url = _url_;
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



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof ApiSimple) {
      ApiSimple __instance = (ApiSimple)__obj;
      __result = true;
      __result = __result && (this.getApiSimpleID() == __instance.getApiSimpleID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:apisimpleid | Table: dib_perfil | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apiSimple")
	private Set<PerfilJPA> perfils = new HashSet<PerfilJPA>(0);
	public  Set<PerfilJPA> getPerfils() {
    return this.perfils;
  }

	public void setPerfils(Set<PerfilJPA> perfils) {
	  this.perfils = perfils;
	}



 // ---------------  STATIC METHODS ------------------
  public static ApiSimpleJPA toJPA(ApiSimple __bean) {
    if (__bean == null) { return null;}
    ApiSimpleJPA __tmp = new ApiSimpleJPA();
    __tmp.setApiSimpleID(__bean.getApiSimpleID());
    __tmp.setNom(__bean.getNom());
    __tmp.setUrl(__bean.getUrl());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setContrasenya(__bean.getContrasenya());
		return __tmp;
	}


  public static ApiSimpleJPA copyJPA(ApiSimpleJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<ApiSimpleJPA> copyJPA(java.util.Set<ApiSimpleJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<ApiSimpleJPA> __tmpSet = (java.util.Set<ApiSimpleJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<ApiSimpleJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (ApiSimpleJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static ApiSimpleJPA copyJPA(ApiSimpleJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    ApiSimpleJPA __tmp = (ApiSimpleJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfils) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfils())) ) {
      __tmp.setPerfils(PerfilJPA.copyJPA(__jpa.getPerfils(), __alreadyCopied,"ApiSimpleJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
