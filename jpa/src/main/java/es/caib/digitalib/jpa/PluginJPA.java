
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import java.util.HashSet;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Lob;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import java.util.Set;
import org.hibernate.annotations.Index;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_plugin" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class PluginJPA implements Plugin {



private static final long serialVersionUID = 190357384L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_plugin_pk_i")
	@Column(name="pluginid",nullable = false,length = 19)
	long pluginID;

	@Column(name="codi",nullable = false,length = 255)
	java.lang.String codi;

	@Column(name="nom",nullable = false,length = 255)
	java.lang.String nom;

	@Column(name="descripcio",length = 255)
	java.lang.String descripcio;

	@Column(name="classe",nullable = false,length = 255)
	java.lang.String classe;

	@Column(name="properties",length = 2147483647)
  @Lob
	java.lang.String properties;

	@Column(name="actiu",nullable = false,length = 1)
	boolean actiu;

	@Column(name="tipus",nullable = false,length = 10)
	int tipus;

	@Column(name="ordre",length = 10)
	java.lang.Integer ordre;



  /** Constructor Buit */
  public PluginJPA() {
  }

  /** Constructor amb tots els camps  */
  public PluginJPA(long pluginID , java.lang.String codi , java.lang.String nom , java.lang.String descripcio , java.lang.String classe , java.lang.String properties , boolean actiu , int tipus , java.lang.Integer ordre) {
    this.pluginID=pluginID;
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.classe=classe;
    this.properties=properties;
    this.actiu=actiu;
    this.tipus=tipus;
    this.ordre=ordre;
}
  /** Constructor sense valors autoincrementals */
  public PluginJPA(java.lang.String codi , java.lang.String nom , java.lang.String descripcio , java.lang.String classe , java.lang.String properties , boolean actiu , int tipus , java.lang.Integer ordre) {
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.classe=classe;
    this.properties=properties;
    this.actiu=actiu;
    this.tipus=tipus;
    this.ordre=ordre;
}
  /** Constructor dels valors Not Null */
  public PluginJPA(long pluginID , java.lang.String codi , java.lang.String nom , java.lang.String classe , boolean actiu , int tipus) {
    this.pluginID=pluginID;
    this.codi=codi;
    this.nom=nom;
    this.classe=classe;
    this.actiu=actiu;
    this.tipus=tipus;
}
  public PluginJPA(Plugin __bean) {
    this.setPluginID(__bean.getPluginID());
    this.setCodi(__bean.getCodi());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setClasse(__bean.getClasse());
    this.setProperties(__bean.getProperties());
    this.setActiu(__bean.isActiu());
    this.setTipus(__bean.getTipus());
    this.setOrdre(__bean.getOrdre());
	}

	public long getPluginID() {
		return(pluginID);
	};
	public void setPluginID(long _pluginID_) {
		this.pluginID = _pluginID_;
	};

	public java.lang.String getCodi() {
		return(codi);
	};
	public void setCodi(java.lang.String _codi_) {
		this.codi = _codi_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.String getClasse() {
		return(classe);
	};
	public void setClasse(java.lang.String _classe_) {
		this.classe = _classe_;
	};

	public java.lang.String getProperties() {
		return(properties);
	};
	public void setProperties(java.lang.String _properties_) {
		this.properties = _properties_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
	};

	public java.lang.Integer getOrdre() {
		return(ordre);
	};
	public void setOrdre(java.lang.Integer _ordre_) {
		this.ordre = _ordre_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Plugin) {
      Plugin __instance = (Plugin)__obj;
      __result = true;
      __result = __result && (this.getPluginID() == __instance.getPluginID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:pluginsegellatid | Table: dib_configuraciofirma | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pluginSegellatID")
	private Set<ConfiguracioFirmaJPA> configuracioFirma_pluginsegellatids = new HashSet<ConfiguracioFirmaJPA>(0);
	public  Set<ConfiguracioFirmaJPA> getConfiguracioFirma_pluginsegellatids() {
    return this.configuracioFirma_pluginsegellatids;
  }

	public void setConfiguracioFirma_pluginsegellatids(Set<ConfiguracioFirmaJPA> configuracioFirma_pluginsegellatids) {
	  this.configuracioFirma_pluginsegellatids = configuracioFirma_pluginsegellatids;
	}


// EXP  Field:pluginfirmaservidorid | Table: dib_configuraciofirma | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pluginFirmaServidorID")
	private Set<ConfiguracioFirmaJPA> configuracioFirma_pluginfirmaservidorids = new HashSet<ConfiguracioFirmaJPA>(0);
	public  Set<ConfiguracioFirmaJPA> getConfiguracioFirma_pluginfirmaservidorids() {
    return this.configuracioFirma_pluginfirmaservidorids;
  }

	public void setConfiguracioFirma_pluginfirmaservidorids(Set<ConfiguracioFirmaJPA> configuracioFirma_pluginfirmaservidorids) {
	  this.configuracioFirma_pluginfirmaservidorids = configuracioFirma_pluginfirmaservidorids;
	}


// EXP  Field:pluginarxiuid | Table: dib_perfil | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pluginArxiuID")
	private Set<PerfilJPA> perfil_pluginarxiuids = new HashSet<PerfilJPA>(0);
	public  Set<PerfilJPA> getPerfil_pluginarxiuids() {
    return this.perfil_pluginarxiuids;
  }

	public void setPerfil_pluginarxiuids(Set<PerfilJPA> perfil_pluginarxiuids) {
	  this.perfil_pluginarxiuids = perfil_pluginarxiuids;
	}


// EXP  Field:plugindoccustodyid | Table: dib_perfil | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pluginDocCustodyID")
	private Set<PerfilJPA> perfil_plugindoccustodyids = new HashSet<PerfilJPA>(0);
	public  Set<PerfilJPA> getPerfil_plugindoccustodyids() {
    return this.perfil_plugindoccustodyids;
  }

	public void setPerfil_plugindoccustodyids(Set<PerfilJPA> perfil_plugindoccustodyids) {
	  this.perfil_plugindoccustodyids = perfil_plugindoccustodyids;
	}


// EXP  Field:pluginscanweb2id | Table: dib_perfil | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pluginScanWeb2ID")
	private Set<PerfilJPA> perfil_pluginscanweb2ids = new HashSet<PerfilJPA>(0);
	public  Set<PerfilJPA> getPerfil_pluginscanweb2ids() {
    return this.perfil_pluginscanweb2ids;
  }

	public void setPerfil_pluginscanweb2ids(Set<PerfilJPA> perfil_pluginscanweb2ids) {
	  this.perfil_pluginscanweb2ids = perfil_pluginscanweb2ids;
	}


// EXP  Field:pluginscanwebid | Table: dib_perfil | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pluginScanWebID")
	private Set<PerfilJPA> perfil_pluginscanwebids = new HashSet<PerfilJPA>(0);
	public  Set<PerfilJPA> getPerfil_pluginscanwebids() {
    return this.perfil_pluginscanwebids;
  }

	public void setPerfil_pluginscanwebids(Set<PerfilJPA> perfil_pluginscanwebids) {
	  this.perfil_pluginscanwebids = perfil_pluginscanwebids;
	}


// EXP  Field:pluginfirmaservidorid | Table: dib_perfil | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pluginFirmaServidorID")
	private Set<PerfilJPA> perfil_pluginfirmaservidorids = new HashSet<PerfilJPA>(0);
	public  Set<PerfilJPA> getPerfil_pluginfirmaservidorids() {
    return this.perfil_pluginfirmaservidorids;
  }

	public void setPerfil_pluginfirmaservidorids(Set<PerfilJPA> perfil_pluginfirmaservidorids) {
	  this.perfil_pluginfirmaservidorids = perfil_pluginfirmaservidorids;
	}


// EXP  Field:pluginid | Table: dib_plugincridada | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plugin")
	private Set<PluginCridadaJPA> pluginCridadas = new HashSet<PluginCridadaJPA>(0);
	public  Set<PluginCridadaJPA> getPluginCridadas() {
    return this.pluginCridadas;
  }

	public void setPluginCridadas(Set<PluginCridadaJPA> pluginCridadas) {
	  this.pluginCridadas = pluginCridadas;
	}



 // ---------------  STATIC METHODS ------------------
  public static PluginJPA toJPA(Plugin __bean) {
    if (__bean == null) { return null;}
    PluginJPA __tmp = new PluginJPA();
    __tmp.setPluginID(__bean.getPluginID());
    __tmp.setCodi(__bean.getCodi());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setClasse(__bean.getClasse());
    __tmp.setProperties(__bean.getProperties());
    __tmp.setActiu(__bean.isActiu());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setOrdre(__bean.getOrdre());
		return __tmp;
	}


  public static PluginJPA copyJPA(PluginJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<PluginJPA> copyJPA(java.util.Set<PluginJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<PluginJPA> __tmpSet = (java.util.Set<PluginJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<PluginJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (PluginJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static PluginJPA copyJPA(PluginJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    PluginJPA __tmp = (PluginJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil_pluginarxiuids) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil_pluginarxiuids())) ) {
      __tmp.setPerfil_pluginarxiuids(PerfilJPA.copyJPA(__jpa.getPerfil_pluginarxiuids(), __alreadyCopied,"PluginJPA"));
    }
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil_plugindoccustodyids) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil_plugindoccustodyids())) ) {
      __tmp.setPerfil_plugindoccustodyids(PerfilJPA.copyJPA(__jpa.getPerfil_plugindoccustodyids(), __alreadyCopied,"PluginJPA"));
    }
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil_pluginfirmaservidorids) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil_pluginfirmaservidorids())) ) {
      __tmp.setPerfil_pluginfirmaservidorids(PerfilJPA.copyJPA(__jpa.getPerfil_pluginfirmaservidorids(), __alreadyCopied,"PluginJPA"));
    }
    if(!"ConfiguracioFirmaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioFirma_pluginfirmaservidorids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioFirma_pluginfirmaservidorids())) ) {
      __tmp.setConfiguracioFirma_pluginfirmaservidorids(ConfiguracioFirmaJPA.copyJPA(__jpa.getConfiguracioFirma_pluginfirmaservidorids(), __alreadyCopied,"PluginJPA"));
    }
    if(!"ConfiguracioFirmaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioFirma_pluginsegellatids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioFirma_pluginsegellatids())) ) {
      __tmp.setConfiguracioFirma_pluginsegellatids(ConfiguracioFirmaJPA.copyJPA(__jpa.getConfiguracioFirma_pluginsegellatids(), __alreadyCopied,"PluginJPA"));
    }
    if(!"PluginCridadaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginCridadas) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginCridadas())) ) {
      __tmp.setPluginCridadas(PluginCridadaJPA.copyJPA(__jpa.getPluginCridadas(), __alreadyCopied,"PluginJPA"));
    }
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil_pluginscanweb2ids) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil_pluginscanweb2ids())) ) {
      __tmp.setPerfil_pluginscanweb2ids(PerfilJPA.copyJPA(__jpa.getPerfil_pluginscanweb2ids(), __alreadyCopied,"PluginJPA"));
    }
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil_pluginscanwebids) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil_pluginscanwebids())) ) {
      __tmp.setPerfil_pluginscanwebids(PerfilJPA.copyJPA(__jpa.getPerfil_pluginscanwebids(), __alreadyCopied,"PluginJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
