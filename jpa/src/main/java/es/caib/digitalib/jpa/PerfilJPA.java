
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
@Table(name = "dib_perfil" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class PerfilJPA implements Perfil {



private static final long serialVersionUID = -1815612849L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_perfil_pk_i")
	@Column(name="perfilid",nullable = false,length = 19)
	long perfilID;

	@Column(name="codi",nullable = false,unique = true,length = 25)
	java.lang.String codi;

	@Column(name="nom",nullable = false,length = 100)
	java.lang.String nom;

	@Column(name="descripcio",length = 255)
	java.lang.String descripcio;

	@Index(name="dib_perfil_plugscanwebid_fk_i")
	@Column(name="pluginscanwebid",nullable = false,length = 19)
	long pluginScanWebID;

	@Index(name="dib_perfil_plugin_psid_fk_i")
	@Column(name="pluginfirmaservidorid",length = 19)
	java.lang.Long pluginFirmaServidorID;

	@Index(name="dib_perfil_pluginarxiuid_fk_i")
	@Column(name="pluginarxiuid",length = 19)
	java.lang.Long pluginArxiuID;

	@Index(name="dib_perfil_plugin_pdcid_fk_i")
	@Column(name="plugindoccustodyid",length = 19)
	java.lang.Long pluginDocCustodyID;



  /** Constructor Buit */
  public PerfilJPA() {
  }

  /** Constructor amb tots els camps  */
  public PerfilJPA(long perfilID , java.lang.String codi , java.lang.String nom , java.lang.String descripcio , long pluginScanWebID , java.lang.Long pluginFirmaServidorID , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
}
  /** Constructor sense valors autoincrementals */
  public PerfilJPA(java.lang.String codi , java.lang.String nom , java.lang.String descripcio , long pluginScanWebID , java.lang.Long pluginFirmaServidorID , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID) {
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
}
  /** Constructor dels valors Not Null */
  public PerfilJPA(long perfilID , java.lang.String codi , java.lang.String nom , long pluginScanWebID) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.pluginScanWebID=pluginScanWebID;
}
  public PerfilJPA(Perfil __bean) {
    this.setPerfilID(__bean.getPerfilID());
    this.setCodi(__bean.getCodi());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setPluginScanWebID(__bean.getPluginScanWebID());
    this.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    this.setPluginArxiuID(__bean.getPluginArxiuID());
    this.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
	}

	public long getPerfilID() {
		return(perfilID);
	};
	public void setPerfilID(long _perfilID_) {
		this.perfilID = _perfilID_;
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

	public long getPluginScanWebID() {
		return(pluginScanWebID);
	};
	public void setPluginScanWebID(long _pluginScanWebID_) {
		this.pluginScanWebID = _pluginScanWebID_;
	};

	public java.lang.Long getPluginFirmaServidorID() {
		return(pluginFirmaServidorID);
	};
	public void setPluginFirmaServidorID(java.lang.Long _pluginFirmaServidorID_) {
		this.pluginFirmaServidorID = _pluginFirmaServidorID_;
	};

	public java.lang.Long getPluginArxiuID() {
		return(pluginArxiuID);
	};
	public void setPluginArxiuID(java.lang.Long _pluginArxiuID_) {
		this.pluginArxiuID = _pluginArxiuID_;
	};

	public java.lang.Long getPluginDocCustodyID() {
		return(pluginDocCustodyID);
	};
	public void setPluginDocCustodyID(java.lang.Long _pluginDocCustodyID_) {
		this.pluginDocCustodyID = _pluginDocCustodyID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Perfil) {
      Perfil __instance = (Perfil)__obj;
      __result = true;
      __result = __result && (this.getPerfilID() == __instance.getPerfilID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:perfilid | Table: dib_perfilusrapp | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	private Set<PerfilUsuariAplicacioJPA> perfilUsuariAplicacios = new HashSet<PerfilUsuariAplicacioJPA>(0);
	public  Set<PerfilUsuariAplicacioJPA> getPerfilUsuariAplicacios() {
    return this.perfilUsuariAplicacios;
  }

	public void setPerfilUsuariAplicacios(Set<PerfilUsuariAplicacioJPA> perfilUsuariAplicacios) {
	  this.perfilUsuariAplicacios = perfilUsuariAplicacios;
	}


// IMP Field:pluginid | Table: dib_plugin | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_perfil_plugin_scan_fk")
	@JoinColumn(name = "pluginscanwebid", referencedColumnName ="pluginID", nullable = false, insertable=false, updatable=false)
	private PluginJPA pluginScanWeb;

	public PluginJPA getPluginScanWeb() {
    return this.pluginScanWeb;
  }

	public  void setPluginScanWeb(PluginJPA pluginScanWeb) {
    this.pluginScanWeb = pluginScanWeb;
  }

// IMP Field:pluginid | Table: dib_plugin | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_perfil_plugin_firma_fk")
	@JoinColumn(name = "pluginfirmaservidorid", referencedColumnName ="pluginID", nullable = true, insertable=false, updatable=false)
	private PluginJPA pluginFirmaServidor;

	public PluginJPA getPluginFirmaServidor() {
    return this.pluginFirmaServidor;
  }

	public  void setPluginFirmaServidor(PluginJPA pluginFirmaServidor) {
    this.pluginFirmaServidor = pluginFirmaServidor;
  }

// IMP Field:pluginid | Table: dib_plugin | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_perfil_plugin_arxiu_fk")
	@JoinColumn(name = "pluginarxiuid", referencedColumnName ="pluginID", nullable = true, insertable=false, updatable=false)
	private PluginJPA pluginArxiu;

	public PluginJPA getPluginArxiu() {
    return this.pluginArxiu;
  }

	public  void setPluginArxiu(PluginJPA pluginArxiu) {
    this.pluginArxiu = pluginArxiu;
  }

// IMP Field:pluginid | Table: dib_plugin | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_perfil_plugin_cust_fk")
	@JoinColumn(name = "plugindoccustodyid", referencedColumnName ="pluginID", nullable = true, insertable=false, updatable=false)
	private PluginJPA pluginDocCustody;

	public PluginJPA getPluginDocCustody() {
    return this.pluginDocCustody;
  }

	public  void setPluginDocCustody(PluginJPA pluginDocCustody) {
    this.pluginDocCustody = pluginDocCustody;
  }


 // ---------------  STATIC METHODS ------------------
  public static PerfilJPA toJPA(Perfil __bean) {
    if (__bean == null) { return null;}
    PerfilJPA __tmp = new PerfilJPA();
    __tmp.setPerfilID(__bean.getPerfilID());
    __tmp.setCodi(__bean.getCodi());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setPluginScanWebID(__bean.getPluginScanWebID());
    __tmp.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    __tmp.setPluginArxiuID(__bean.getPluginArxiuID());
    __tmp.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
		return __tmp;
	}


  public static PerfilJPA copyJPA(PerfilJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<PerfilJPA> copyJPA(java.util.Set<PerfilJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<PerfilJPA> __tmpSet = (java.util.Set<PerfilJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<PerfilJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (PerfilJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static PerfilJPA copyJPA(PerfilJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    PerfilJPA __tmp = (PerfilJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"PerfilUsuariAplicacioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfilUsuariAplicacios) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfilUsuariAplicacios())) ) {
      __tmp.setPerfilUsuariAplicacios(PerfilUsuariAplicacioJPA.copyJPA(__jpa.getPerfilUsuariAplicacios(), __alreadyCopied,"PerfilJPA"));
    }
    // Copia de beans complexes (IMP)
    if(!"PluginJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginDocCustody) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginDocCustody()) ) ) {
      __tmp.setPluginDocCustody(PluginJPA.copyJPA(__jpa.getPluginDocCustody(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"PluginJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginScanWeb) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginScanWeb()) ) ) {
      __tmp.setPluginScanWeb(PluginJPA.copyJPA(__jpa.getPluginScanWeb(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"PluginJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginFirmaServidor) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginFirmaServidor()) ) ) {
      __tmp.setPluginFirmaServidor(PluginJPA.copyJPA(__jpa.getPluginFirmaServidor(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"PluginJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginArxiu) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginArxiu()) ) ) {
      __tmp.setPluginArxiu(PluginJPA.copyJPA(__jpa.getPluginArxiu(), __alreadyCopied,"PerfilJPA"));
    }

    return __tmp;
  }




}
