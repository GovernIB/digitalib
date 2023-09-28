
package es.caib.digitalib.persistence;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Id;


@Entity(name = "FitxerJPA")
@Table(name = "dib_fitxer" , indexes = { 
        @Index(name="dib_fitxer_pk_i", columnList = "fitxerid")})
@SequenceGenerator(name="FITXER_SEQ", sequenceName="dib_fitxer_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class FitxerJPA implements Fitxer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FITXER_SEQ")
    @Column(name="fitxerid",nullable = false,length = 19)
    long fitxerID;

    @Column(name="descripcio",length = 1000)
    java.lang.String descripcio;

    @Column(name="mime",nullable = false,length = 255)
    java.lang.String mime;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="tamany",nullable = false,length = 19)
    long tamany;



  /** Constructor Buit */
  public FitxerJPA() {
  }

  /** Constructor amb tots els camps  */
  public FitxerJPA(long fitxerID , java.lang.String descripcio , java.lang.String mime , java.lang.String nom , long tamany) {
    this.fitxerID=fitxerID;
    this.descripcio=descripcio;
    this.mime=mime;
    this.nom=nom;
    this.tamany=tamany;
}
  /** Constructor sense valors autoincrementals */
  public FitxerJPA(java.lang.String descripcio , java.lang.String mime , java.lang.String nom , long tamany) {
    this.descripcio=descripcio;
    this.mime=mime;
    this.nom=nom;
    this.tamany=tamany;
}
  public FitxerJPA(Fitxer __bean) {
    this.setFitxerID(__bean.getFitxerID());
    this.setDescripcio(__bean.getDescripcio());
    this.setMime(__bean.getMime());
    this.setNom(__bean.getNom());
    this.setTamany(__bean.getTamany());
    // DataHandler
    this.setData(__bean.getData());
    // EncryptedFileID
    this.setEncryptedFileID(__bean.getEncryptedFileID());
	}

	public long getFitxerID() {
		return(fitxerID);
	};
	public void setFitxerID(long _fitxerID_) {
		this.fitxerID = _fitxerID_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.String getMime() {
		return(mime);
	};
	public void setMime(java.lang.String _mime_) {
		this.mime = _mime_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public long getTamany() {
		return(tamany);
	};
	public void setTamany(long _tamany_) {
		this.tamany = _tamany_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Fitxer) {
      Fitxer __instance = (Fitxer)__obj;
      __result = true;
      __result = __result && (this.getFitxerID() == __instance.getFitxerID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:logoheaderid | Table: dib_configuraciogrup | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "logoHeaderID")
    private Set<ConfiguracioGrupJPA> configuracioGrup_logoheaderids = new HashSet<ConfiguracioGrupJPA>(0);
    public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_logoheaderids() {
    return this.configuracioGrup_logoheaderids;
  }

    public void setConfiguracioGrup_logoheaderids(Set<ConfiguracioGrupJPA> configuracioGrup_logoheaderids) {
      this.configuracioGrup_logoheaderids = configuracioGrup_logoheaderids;
    }


// EXP  Field:logofooterid | Table: dib_configuraciogrup | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "logoFooterID")
    private Set<ConfiguracioGrupJPA> configuracioGrup_logofooterids = new HashSet<ConfiguracioGrupJPA>(0);
    public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_logofooterids() {
    return this.configuracioGrup_logofooterids;
  }

    public void setConfiguracioGrup_logofooterids(Set<ConfiguracioGrupJPA> configuracioGrup_logofooterids) {
      this.configuracioGrup_logofooterids = configuracioGrup_logofooterids;
    }


// EXP  Field:parametresfitxerid | Table: dib_plugincridada | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parametresFitxerID")
    private Set<PluginCridadaJPA> pluginCridada_parametresfitxerids = new HashSet<PluginCridadaJPA>(0);
    public  Set<PluginCridadaJPA> getPluginCridada_parametresfitxerids() {
    return this.pluginCridada_parametresfitxerids;
  }

    public void setPluginCridada_parametresfitxerids(Set<PluginCridadaJPA> pluginCridada_parametresfitxerids) {
      this.pluginCridada_parametresfitxerids = pluginCridada_parametresfitxerids;
    }


// EXP  Field:retornfitxerid | Table: dib_plugincridada | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "retornFitxerID")
    private Set<PluginCridadaJPA> pluginCridada_retornfitxerids = new HashSet<PluginCridadaJPA>(0);
    public  Set<PluginCridadaJPA> getPluginCridada_retornfitxerids() {
    return this.pluginCridada_retornfitxerids;
  }

    public void setPluginCridada_retornfitxerids(Set<PluginCridadaJPA> pluginCridada_retornfitxerids) {
      this.pluginCridada_retornfitxerids = pluginCridada_retornfitxerids;
    }


// EXP  Field:fitxerescanejatid | Table: dib_transaccio | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxerEscanejatID")
    private Set<TransaccioJPA> transaccio_fitxerescanejatids = new HashSet<TransaccioJPA>(0);
    public  Set<TransaccioJPA> getTransaccio_fitxerescanejatids() {
    return this.transaccio_fitxerescanejatids;
  }

    public void setTransaccio_fitxerescanejatids(Set<TransaccioJPA> transaccio_fitxerescanejatids) {
      this.transaccio_fitxerescanejatids = transaccio_fitxerescanejatids;
    }


// EXP  Field:fitxersignaturaid | Table: dib_transaccio | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxerSignaturaID")
    private Set<TransaccioJPA> transaccio_fitxersignaturaids = new HashSet<TransaccioJPA>(0);
    public  Set<TransaccioJPA> getTransaccio_fitxersignaturaids() {
    return this.transaccio_fitxersignaturaids;
  }

    public void setTransaccio_fitxersignaturaids(Set<TransaccioJPA> transaccio_fitxersignaturaids) {
      this.transaccio_fitxersignaturaids = transaccio_fitxersignaturaids;
    }


// EXP  Field:fitxerescanejatid | Table: dib_transmultiple | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxerEscanejatID")
    private Set<TransaccioMultipleJPA> transaccioMultiples = new HashSet<TransaccioMultipleJPA>(0);
    public  Set<TransaccioMultipleJPA> getTransaccioMultiples() {
    return this.transaccioMultiples;
  }

    public void setTransaccioMultiples(Set<TransaccioMultipleJPA> transaccioMultiples) {
      this.transaccioMultiples = transaccioMultiples;
    }



  @javax.persistence.Transient
  javax.activation.DataHandler data;

  public javax.activation.DataHandler getData() {
    return data;
  }

  public void setData(javax.activation.DataHandler data) {
    this.data = data;
  }

  @javax.persistence.Transient
  String encryptedFileID;

  public String getEncryptedFileID() {
    return encryptedFileID;
  }

  public void setEncryptedFileID(String encryptedFileID) {
    this.encryptedFileID = encryptedFileID;
  }


  final static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

  public static void enableEncryptedFileIDGeneration() {
    threadLocal.set("");
  }

  public static void disableEncryptedFileIDGeneration() {
    threadLocal.remove();
  }

  @javax.persistence.PostPersist
  @javax.persistence.PostLoad
  void postLoad() {
    if (threadLocal.get() != null) {
      this.encryptedFileID = es.caib.digitalib.hibernate.HibernateFileUtil.encryptFileID(fitxerID);
    }
  }


 // ---------------  STATIC METHODS ------------------
  public static FitxerJPA toJPA(Fitxer __bean) {
    if (__bean == null) { return null;}
    FitxerJPA __tmp = new FitxerJPA();
    __tmp.setFitxerID(__bean.getFitxerID());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setMime(__bean.getMime());
    __tmp.setNom(__bean.getNom());
    __tmp.setTamany(__bean.getTamany());
    // DataHandler
    __tmp.setData(__bean.getData());
    // EncryptedFileID
    __tmp.setEncryptedFileID(__bean.getEncryptedFileID());
		return __tmp;
	}


  public static FitxerJPA copyJPA(FitxerJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<FitxerJPA> copyJPA(java.util.Set<FitxerJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<FitxerJPA> __tmpSet = (java.util.Set<FitxerJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<FitxerJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (FitxerJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static FitxerJPA copyJPA(FitxerJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    FitxerJPA __tmp = (FitxerJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_logofooterids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_logofooterids())) ) {
      __tmp.setConfiguracioGrup_logofooterids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_logofooterids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"TransaccioMultipleJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccioMultiples) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccioMultiples())) ) {
      __tmp.setTransaccioMultiples(TransaccioMultipleJPA.copyJPA(__jpa.getTransaccioMultiples(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"TransaccioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccio_fitxersignaturaids) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccio_fitxersignaturaids())) ) {
      __tmp.setTransaccio_fitxersignaturaids(TransaccioJPA.copyJPA(__jpa.getTransaccio_fitxersignaturaids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_logoheaderids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_logoheaderids())) ) {
      __tmp.setConfiguracioGrup_logoheaderids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_logoheaderids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"PluginCridadaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginCridada_parametresfitxerids) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginCridada_parametresfitxerids())) ) {
      __tmp.setPluginCridada_parametresfitxerids(PluginCridadaJPA.copyJPA(__jpa.getPluginCridada_parametresfitxerids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"TransaccioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccio_fitxerescanejatids) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccio_fitxerescanejatids())) ) {
      __tmp.setTransaccio_fitxerescanejatids(TransaccioJPA.copyJPA(__jpa.getTransaccio_fitxerescanejatids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"PluginCridadaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginCridada_retornfitxerids) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginCridada_retornfitxerids())) ) {
      __tmp.setPluginCridada_retornfitxerids(PluginCridadaJPA.copyJPA(__jpa.getPluginCridada_retornfitxerids(), __alreadyCopied,"FitxerJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
