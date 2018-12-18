
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

	@Column(name="codi",nullable = false,unique = true,length = 255)
	java.lang.String codi;

	@Column(name="nom",nullable = false,length = 100)
	java.lang.String nom;

	@Column(name="descripcio",length = 255)
	java.lang.String descripcio;

  /** Opcional. Serveix per indicar la url que utilitzaran els client per connectar-se a DigitalIB. Si val null s'obtindrà de la propietat dels properties-service.xml */
	@Column(name="urlbase",length = 255)
	java.lang.String urlBase;

  /** PDF,JPG,PNG, GIF, TIFF */
	@Column(name="scanformatfitxer",nullable = false,length = 10)
	int scanFormatFitxer;

  /** Punts per pulgada (ppp) */
	@Column(name="scanminimaresolucio",length = 10)
	java.lang.Integer scanMinimaResolucio;

	@Column(name="scanpixeltype",length = 10)
	int scanPixelType;

	@Index(name="dib_perfil_plugscanwebid_fk_i")
	@Column(name="pluginscanwebid",nullable = false,length = 19)
	long pluginScanWebID;

	@Index(name="dib_perfil_plugscanweb2_fk_i")
	@Column(name="pluginscanweb2id",length = 19)
	java.lang.Long pluginScanWeb2ID;

	@Column(name="tipusfirma",nullable = false,length = 10)
	int tipusFirma;

	@Index(name="dib_perfil_apisimpleid_fk_i")
	@Column(name="apisimpleid",length = 19)
	java.lang.Long apiSimpleID;

	@Index(name="dib_perfil_plugin_psid_fk_i")
	@Column(name="pluginfirmaservidorid",length = 19)
	java.lang.Long pluginFirmaServidorID;

	@Column(name="tipuscustodia",nullable = false,length = 10)
	int tipusCustodia;

	@Index(name="dib_perfil_pluginarxiuid_fk_i")
	@Column(name="pluginarxiuid",length = 19)
	java.lang.Long pluginArxiuID;

	@Index(name="dib_perfil_plugin_pdcid_fk_i")
	@Column(name="plugindoccustodyid",length = 19)
	java.lang.Long pluginDocCustodyID;

  /** Quin us es farà del perfil: plantilla o informacio perfil en transaccio */
	@Column(name="usperfil",nullable = false,length = 10)
	int usPerfil;

	@Column(name="utilitzatperaplicacio",length = 1)
	java.lang.Boolean utilitzatPerAplicacio;



  /** Constructor Buit */
  public PerfilJPA() {
  }

  /** Constructor amb tots els camps  */
  public PerfilJPA(long perfilID , java.lang.String codi , java.lang.String nom , java.lang.String descripcio , java.lang.String urlBase , int scanFormatFitxer , java.lang.Integer scanMinimaResolucio , int scanPixelType , long pluginScanWebID , java.lang.Long pluginScanWeb2ID , int tipusFirma , java.lang.Long apiSimpleID , java.lang.Long pluginFirmaServidorID , int tipusCustodia , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID , int usPerfil , java.lang.Boolean utilitzatPerAplicacio) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.urlBase=urlBase;
    this.scanFormatFitxer=scanFormatFitxer;
    this.scanMinimaResolucio=scanMinimaResolucio;
    this.scanPixelType=scanPixelType;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginScanWeb2ID=pluginScanWeb2ID;
    this.tipusFirma=tipusFirma;
    this.apiSimpleID=apiSimpleID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.tipusCustodia=tipusCustodia;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
    this.usPerfil=usPerfil;
    this.utilitzatPerAplicacio=utilitzatPerAplicacio;
}
  /** Constructor sense valors autoincrementals */
  public PerfilJPA(java.lang.String codi , java.lang.String nom , java.lang.String descripcio , java.lang.String urlBase , int scanFormatFitxer , java.lang.Integer scanMinimaResolucio , int scanPixelType , long pluginScanWebID , java.lang.Long pluginScanWeb2ID , int tipusFirma , java.lang.Long apiSimpleID , java.lang.Long pluginFirmaServidorID , int tipusCustodia , java.lang.Long pluginArxiuID , java.lang.Long pluginDocCustodyID , int usPerfil , java.lang.Boolean utilitzatPerAplicacio) {
    this.codi=codi;
    this.nom=nom;
    this.descripcio=descripcio;
    this.urlBase=urlBase;
    this.scanFormatFitxer=scanFormatFitxer;
    this.scanMinimaResolucio=scanMinimaResolucio;
    this.scanPixelType=scanPixelType;
    this.pluginScanWebID=pluginScanWebID;
    this.pluginScanWeb2ID=pluginScanWeb2ID;
    this.tipusFirma=tipusFirma;
    this.apiSimpleID=apiSimpleID;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.tipusCustodia=tipusCustodia;
    this.pluginArxiuID=pluginArxiuID;
    this.pluginDocCustodyID=pluginDocCustodyID;
    this.usPerfil=usPerfil;
    this.utilitzatPerAplicacio=utilitzatPerAplicacio;
}
  /** Constructor dels valors Not Null */
  public PerfilJPA(long perfilID , java.lang.String codi , java.lang.String nom , int scanFormatFitxer , long pluginScanWebID , int tipusFirma , int tipusCustodia , int usPerfil) {
    this.perfilID=perfilID;
    this.codi=codi;
    this.nom=nom;
    this.scanFormatFitxer=scanFormatFitxer;
    this.pluginScanWebID=pluginScanWebID;
    this.tipusFirma=tipusFirma;
    this.tipusCustodia=tipusCustodia;
    this.usPerfil=usPerfil;
}
  public PerfilJPA(Perfil __bean) {
    this.setPerfilID(__bean.getPerfilID());
    this.setCodi(__bean.getCodi());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setUrlBase(__bean.getUrlBase());
    this.setScanFormatFitxer(__bean.getScanFormatFitxer());
    this.setScanMinimaResolucio(__bean.getScanMinimaResolucio());
    this.setScanPixelType(__bean.getScanPixelType());
    this.setPluginScanWebID(__bean.getPluginScanWebID());
    this.setPluginScanWeb2ID(__bean.getPluginScanWeb2ID());
    this.setTipusFirma(__bean.getTipusFirma());
    this.setApiSimpleID(__bean.getApiSimpleID());
    this.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    this.setTipusCustodia(__bean.getTipusCustodia());
    this.setPluginArxiuID(__bean.getPluginArxiuID());
    this.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
    this.setUsPerfil(__bean.getUsPerfil());
    this.setUtilitzatPerAplicacio(__bean.getUtilitzatPerAplicacio());
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

	public java.lang.String getUrlBase() {
		return(urlBase);
	};
	public void setUrlBase(java.lang.String _urlBase_) {
		this.urlBase = _urlBase_;
	};

	public int getScanFormatFitxer() {
		return(scanFormatFitxer);
	};
	public void setScanFormatFitxer(int _scanFormatFitxer_) {
		this.scanFormatFitxer = _scanFormatFitxer_;
	};

	public java.lang.Integer getScanMinimaResolucio() {
		return(scanMinimaResolucio);
	};
	public void setScanMinimaResolucio(java.lang.Integer _scanMinimaResolucio_) {
		this.scanMinimaResolucio = _scanMinimaResolucio_;
	};

	public int getScanPixelType() {
		return(scanPixelType);
	};
	public void setScanPixelType(int _scanPixelType_) {
		this.scanPixelType = _scanPixelType_;
	};

	public long getPluginScanWebID() {
		return(pluginScanWebID);
	};
	public void setPluginScanWebID(long _pluginScanWebID_) {
		this.pluginScanWebID = _pluginScanWebID_;
	};

	public java.lang.Long getPluginScanWeb2ID() {
		return(pluginScanWeb2ID);
	};
	public void setPluginScanWeb2ID(java.lang.Long _pluginScanWeb2ID_) {
		this.pluginScanWeb2ID = _pluginScanWeb2ID_;
	};

	public int getTipusFirma() {
		return(tipusFirma);
	};
	public void setTipusFirma(int _tipusFirma_) {
		this.tipusFirma = _tipusFirma_;
	};

	public java.lang.Long getApiSimpleID() {
		return(apiSimpleID);
	};
	public void setApiSimpleID(java.lang.Long _apiSimpleID_) {
		this.apiSimpleID = _apiSimpleID_;
	};

	public java.lang.Long getPluginFirmaServidorID() {
		return(pluginFirmaServidorID);
	};
	public void setPluginFirmaServidorID(java.lang.Long _pluginFirmaServidorID_) {
		this.pluginFirmaServidorID = _pluginFirmaServidorID_;
	};

	public int getTipusCustodia() {
		return(tipusCustodia);
	};
	public void setTipusCustodia(int _tipusCustodia_) {
		this.tipusCustodia = _tipusCustodia_;
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

	public int getUsPerfil() {
		return(usPerfil);
	};
	public void setUsPerfil(int _usPerfil_) {
		this.usPerfil = _usPerfil_;
	};

	public java.lang.Boolean getUtilitzatPerAplicacio() {
		return(utilitzatPerAplicacio);
	};
	public void setUtilitzatPerAplicacio(java.lang.Boolean _utilitzatPerAplicacio_) {
		this.utilitzatPerAplicacio = _utilitzatPerAplicacio_;
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

// EXP  Field:perfilnomesescaneig2id | Table: dib_configuraciogrup | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilNomesEscaneig2ID")
	private Set<ConfiguracioGrupJPA> configuracioGrup_perfilnomesescaneig2ids = new HashSet<ConfiguracioGrupJPA>(0);
	public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_perfilnomesescaneig2ids() {
    return this.configuracioGrup_perfilnomesescaneig2ids;
  }

	public void setConfiguracioGrup_perfilnomesescaneig2ids(Set<ConfiguracioGrupJPA> configuracioGrup_perfilnomesescaneig2ids) {
	  this.configuracioGrup_perfilnomesescaneig2ids = configuracioGrup_perfilnomesescaneig2ids;
	}


// EXP  Field:perfilcopiaautentica2id | Table: dib_configuraciogrup | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilCopiaAutentica2ID")
	private Set<ConfiguracioGrupJPA> configuracioGrup_perfilcopiaautentica2ids = new HashSet<ConfiguracioGrupJPA>(0);
	public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_perfilcopiaautentica2ids() {
    return this.configuracioGrup_perfilcopiaautentica2ids;
  }

	public void setConfiguracioGrup_perfilcopiaautentica2ids(Set<ConfiguracioGrupJPA> configuracioGrup_perfilcopiaautentica2ids) {
	  this.configuracioGrup_perfilcopiaautentica2ids = configuracioGrup_perfilcopiaautentica2ids;
	}


// EXP  Field:perfilcustodia2id | Table: dib_configuraciogrup | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilCustodia2ID")
	private Set<ConfiguracioGrupJPA> configuracioGrup_perfilcustodia2ids = new HashSet<ConfiguracioGrupJPA>(0);
	public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_perfilcustodia2ids() {
    return this.configuracioGrup_perfilcustodia2ids;
  }

	public void setConfiguracioGrup_perfilcustodia2ids(Set<ConfiguracioGrupJPA> configuracioGrup_perfilcustodia2ids) {
	  this.configuracioGrup_perfilcustodia2ids = configuracioGrup_perfilcustodia2ids;
	}


// EXP  Field:perfilnomesescaneigid | Table: dib_configuraciogrup | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilNomesEscaneigID")
	private Set<ConfiguracioGrupJPA> configuracioGrup_perfilnomesescaneigids = new HashSet<ConfiguracioGrupJPA>(0);
	public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_perfilnomesescaneigids() {
    return this.configuracioGrup_perfilnomesescaneigids;
  }

	public void setConfiguracioGrup_perfilnomesescaneigids(Set<ConfiguracioGrupJPA> configuracioGrup_perfilnomesescaneigids) {
	  this.configuracioGrup_perfilnomesescaneigids = configuracioGrup_perfilnomesescaneigids;
	}


// EXP  Field:perfilcopiaautenticaid | Table: dib_configuraciogrup | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilCopiaAutenticaID")
	private Set<ConfiguracioGrupJPA> configuracioGrup_perfilcopiaautenticaids = new HashSet<ConfiguracioGrupJPA>(0);
	public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_perfilcopiaautenticaids() {
    return this.configuracioGrup_perfilcopiaautenticaids;
  }

	public void setConfiguracioGrup_perfilcopiaautenticaids(Set<ConfiguracioGrupJPA> configuracioGrup_perfilcopiaautenticaids) {
	  this.configuracioGrup_perfilcopiaautenticaids = configuracioGrup_perfilcopiaautenticaids;
	}


// EXP  Field:perfilcustodiaid | Table: dib_configuraciogrup | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilCustodiaID")
	private Set<ConfiguracioGrupJPA> configuracioGrup_perfilcustodiaids = new HashSet<ConfiguracioGrupJPA>(0);
	public  Set<ConfiguracioGrupJPA> getConfiguracioGrup_perfilcustodiaids() {
    return this.configuracioGrup_perfilcustodiaids;
  }

	public void setConfiguracioGrup_perfilcustodiaids(Set<ConfiguracioGrupJPA> configuracioGrup_perfilcustodiaids) {
	  this.configuracioGrup_perfilcustodiaids = configuracioGrup_perfilcustodiaids;
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


// EXP  Field:perfilid | Table: dib_transaccio | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	private Set<TransaccioJPA> transaccios = new HashSet<TransaccioJPA>(0);
	public  Set<TransaccioJPA> getTransaccios() {
    return this.transaccios;
  }

	public void setTransaccios(Set<TransaccioJPA> transaccios) {
	  this.transaccios = transaccios;
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
	@ForeignKey(name="dib_perfil_plugin_scan2_fk")
	@JoinColumn(name = "pluginscanweb2id", referencedColumnName ="pluginID", nullable = true, insertable=false, updatable=false)
	private PluginJPA pluginScanWeb2;

	public PluginJPA getPluginScanWeb2() {
    return this.pluginScanWeb2;
  }

	public  void setPluginScanWeb2(PluginJPA pluginScanWeb2) {
    this.pluginScanWeb2 = pluginScanWeb2;
  }

// IMP Field:apisimpleid | Table: dib_apisimple | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_perfil_apisimple_firma_fk")
	@JoinColumn(name = "apisimpleid", referencedColumnName ="apiSimpleID", nullable = true, insertable=false, updatable=false)
	private ApiSimpleJPA apiSimple;

	public ApiSimpleJPA getApiSimple() {
    return this.apiSimple;
  }

	public  void setApiSimple(ApiSimpleJPA apiSimple) {
    this.apiSimple = apiSimple;
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
    __tmp.setUrlBase(__bean.getUrlBase());
    __tmp.setScanFormatFitxer(__bean.getScanFormatFitxer());
    __tmp.setScanMinimaResolucio(__bean.getScanMinimaResolucio());
    __tmp.setScanPixelType(__bean.getScanPixelType());
    __tmp.setPluginScanWebID(__bean.getPluginScanWebID());
    __tmp.setPluginScanWeb2ID(__bean.getPluginScanWeb2ID());
    __tmp.setTipusFirma(__bean.getTipusFirma());
    __tmp.setApiSimpleID(__bean.getApiSimpleID());
    __tmp.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    __tmp.setTipusCustodia(__bean.getTipusCustodia());
    __tmp.setPluginArxiuID(__bean.getPluginArxiuID());
    __tmp.setPluginDocCustodyID(__bean.getPluginDocCustodyID());
    __tmp.setUsPerfil(__bean.getUsPerfil());
    __tmp.setUtilitzatPerAplicacio(__bean.getUtilitzatPerAplicacio());
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
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_perfilcopiaautentica2ids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_perfilcopiaautentica2ids())) ) {
      __tmp.setConfiguracioGrup_perfilcopiaautentica2ids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_perfilcopiaautentica2ids(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"TransaccioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.transaccios) || org.hibernate.Hibernate.isInitialized(__jpa.getTransaccios())) ) {
      __tmp.setTransaccios(TransaccioJPA.copyJPA(__jpa.getTransaccios(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_perfilcopiaautenticaids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_perfilcopiaautenticaids())) ) {
      __tmp.setConfiguracioGrup_perfilcopiaautenticaids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_perfilcopiaautenticaids(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_perfilcustodia2ids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_perfilcustodia2ids())) ) {
      __tmp.setConfiguracioGrup_perfilcustodia2ids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_perfilcustodia2ids(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_perfilnomesescaneig2ids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_perfilnomesescaneig2ids())) ) {
      __tmp.setConfiguracioGrup_perfilnomesescaneig2ids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_perfilnomesescaneig2ids(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_perfilcustodiaids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_perfilcustodiaids())) ) {
      __tmp.setConfiguracioGrup_perfilcustodiaids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_perfilcustodiaids(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"ConfiguracioGrupJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioGrup_perfilnomesescaneigids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioGrup_perfilnomesescaneigids())) ) {
      __tmp.setConfiguracioGrup_perfilnomesescaneigids(ConfiguracioGrupJPA.copyJPA(__jpa.getConfiguracioGrup_perfilnomesescaneigids(), __alreadyCopied,"PerfilJPA"));
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
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginScanWeb2) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginScanWeb2()) ) ) {
      __tmp.setPluginScanWeb2(PluginJPA.copyJPA(__jpa.getPluginScanWeb2(), __alreadyCopied,"PerfilJPA"));
    }
    if(!"ApiSimpleJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.apiSimple) || org.hibernate.Hibernate.isInitialized(__jpa.getApiSimple()) ) ) {
      __tmp.setApiSimple(ApiSimpleJPA.copyJPA(__jpa.getApiSimple(), __alreadyCopied,"PerfilJPA"));
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
