
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "dib_configuraciofirma" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class ConfiguracioFirmaJPA implements ConfiguracioFirma {



private static final long serialVersionUID = 1621981919L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_configuraciofirma_pk_i")
	@Column(name="configuraciofirmaid",nullable = false,length = 19)
	long configuracioFirmaID;

	@Column(name="nom",nullable = false,unique = true,length = 255)
	java.lang.String nom;

	@Index(name="dib_conffirma_plugfirma_fk_i")
	@Column(name="pluginfirmaservidorid",nullable = false,length = 19)
	long pluginFirmaServidorID;

	@Column(name="inclouresegelldetemps",nullable = false,length = 1)
	boolean incloureSegellDeTemps;

	@Index(name="dib_conffirma_plugsegell_fk_i")
	@Column(name="pluginsegellatid",length = 19)
	java.lang.Long pluginSegellatID;

  /** 0 firma, 1 contrafirma 2, cofirma */
	@Column(name="tipusoperaciofirma",nullable = false,length = 10)
	int tipusOperacioFirma;

	@Column(name="tipusfirmaid",nullable = false,length = 10)
	int tipusFirmaID;

	@Index(name="dib_conffirma_algofirma_fk_i")
	@Column(name="algorismedefirmaid",nullable = false,length = 10)
	int algorismeDeFirmaID;

	@Column(name="modedefirma",nullable = false,length = 1)
	boolean modeDeFirma;

  /** -1=> usar politica de firma de l'entitat, 0 => no usar politica de firma,  1=> usar politica d'aquesta configuracio, 2 => L'usuari web o usuari-app elegeixen la politica de firma */
	@Column(name="uspoliticadefirma",nullable = false,length = 10)
	int usPoliticaDeFirma;

  /** Identificador de la política de firma. Si es defineix aquest valors llavorses generaran 
firmes PAdES-EPES,CAdES-EPES y XAdES-EPES. */
	@Column(name="policyidentifier",length = 100)
	java.lang.String policyIdentifier;

	@Column(name="policyidentifierhash",length = 256)
	java.lang.String policyIdentifierHash;

  /** Indica el algoritmo utilizado para generar la Huella Digital definida en
el campo policyIdentifierHash.  Es obligatorio indicar este parámetro 
si se indicó también policyIdentifier. Los valores posibles son: 
SHA1, SHA-256, SHA-384 o SHA-512 */
	@Column(name="policyidentifierhashalgorithm",length = 50)
	java.lang.String policyIdentifierHashAlgorithm;

  /** URL (universalmente accesible) hacia el documento (normalmente PDF) que
contiene una descripción textual de la política de firma. Este parámetro es
opcional incluso cuando se genera una firma EPES. */
	@Column(name="policyurldocument",length = 255)
	java.lang.String policyUrlDocument;

  /**  Valors: SENSETAULA = 0; PRIMERAPAGINA = 1; DARRERAPAGINA = -1 */
	@Column(name="posiciotaulafirmesid",nullable = false,length = 10)
	int posicioTaulaFirmesID;

	@Index(name="dib_conffirma_firmatper_fk_i")
	@Column(name="firmatperformatid",length = 19)
	java.lang.Long firmatPerFormatID;

	@Index(name="dib_conffirma_motiudele_fk_i")
	@Column(name="motiudelegacioid",length = 19)
	java.lang.Long motiuDelegacioID;

	@Column(name="propietatstaulafirmes",length = 2147483647)
  @Lob
	java.lang.String propietatsTaulaFirmes;



  /** Constructor Buit */
  public ConfiguracioFirmaJPA() {
  }

  /** Constructor amb tots els camps  */
  public ConfiguracioFirmaJPA(long configuracioFirmaID , java.lang.String nom , long pluginFirmaServidorID , boolean incloureSegellDeTemps , java.lang.Long pluginSegellatID , int tipusOperacioFirma , int tipusFirmaID , int algorismeDeFirmaID , boolean modeDeFirma , int usPoliticaDeFirma , java.lang.String policyIdentifier , java.lang.String policyIdentifierHash , java.lang.String policyIdentifierHashAlgorithm , java.lang.String policyUrlDocument , int posicioTaulaFirmesID , java.lang.Long firmatPerFormatID , java.lang.Long motiuDelegacioID , java.lang.String propietatsTaulaFirmes) {
    this.configuracioFirmaID=configuracioFirmaID;
    this.nom=nom;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.incloureSegellDeTemps=incloureSegellDeTemps;
    this.pluginSegellatID=pluginSegellatID;
    this.tipusOperacioFirma=tipusOperacioFirma;
    this.tipusFirmaID=tipusFirmaID;
    this.algorismeDeFirmaID=algorismeDeFirmaID;
    this.modeDeFirma=modeDeFirma;
    this.usPoliticaDeFirma=usPoliticaDeFirma;
    this.policyIdentifier=policyIdentifier;
    this.policyIdentifierHash=policyIdentifierHash;
    this.policyIdentifierHashAlgorithm=policyIdentifierHashAlgorithm;
    this.policyUrlDocument=policyUrlDocument;
    this.posicioTaulaFirmesID=posicioTaulaFirmesID;
    this.firmatPerFormatID=firmatPerFormatID;
    this.motiuDelegacioID=motiuDelegacioID;
    this.propietatsTaulaFirmes=propietatsTaulaFirmes;
}
  /** Constructor sense valors autoincrementals */
  public ConfiguracioFirmaJPA(java.lang.String nom , long pluginFirmaServidorID , boolean incloureSegellDeTemps , java.lang.Long pluginSegellatID , int tipusOperacioFirma , int tipusFirmaID , int algorismeDeFirmaID , boolean modeDeFirma , int usPoliticaDeFirma , java.lang.String policyIdentifier , java.lang.String policyIdentifierHash , java.lang.String policyIdentifierHashAlgorithm , java.lang.String policyUrlDocument , int posicioTaulaFirmesID , java.lang.Long firmatPerFormatID , java.lang.Long motiuDelegacioID , java.lang.String propietatsTaulaFirmes) {
    this.nom=nom;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.incloureSegellDeTemps=incloureSegellDeTemps;
    this.pluginSegellatID=pluginSegellatID;
    this.tipusOperacioFirma=tipusOperacioFirma;
    this.tipusFirmaID=tipusFirmaID;
    this.algorismeDeFirmaID=algorismeDeFirmaID;
    this.modeDeFirma=modeDeFirma;
    this.usPoliticaDeFirma=usPoliticaDeFirma;
    this.policyIdentifier=policyIdentifier;
    this.policyIdentifierHash=policyIdentifierHash;
    this.policyIdentifierHashAlgorithm=policyIdentifierHashAlgorithm;
    this.policyUrlDocument=policyUrlDocument;
    this.posicioTaulaFirmesID=posicioTaulaFirmesID;
    this.firmatPerFormatID=firmatPerFormatID;
    this.motiuDelegacioID=motiuDelegacioID;
    this.propietatsTaulaFirmes=propietatsTaulaFirmes;
}
  /** Constructor dels valors Not Null */
  public ConfiguracioFirmaJPA(long configuracioFirmaID , java.lang.String nom , long pluginFirmaServidorID , boolean incloureSegellDeTemps , int tipusOperacioFirma , int tipusFirmaID , int algorismeDeFirmaID , boolean modeDeFirma , int usPoliticaDeFirma , int posicioTaulaFirmesID) {
    this.configuracioFirmaID=configuracioFirmaID;
    this.nom=nom;
    this.pluginFirmaServidorID=pluginFirmaServidorID;
    this.incloureSegellDeTemps=incloureSegellDeTemps;
    this.tipusOperacioFirma=tipusOperacioFirma;
    this.tipusFirmaID=tipusFirmaID;
    this.algorismeDeFirmaID=algorismeDeFirmaID;
    this.modeDeFirma=modeDeFirma;
    this.usPoliticaDeFirma=usPoliticaDeFirma;
    this.posicioTaulaFirmesID=posicioTaulaFirmesID;
}
  public ConfiguracioFirmaJPA(ConfiguracioFirma __bean) {
    this.setConfiguracioFirmaID(__bean.getConfiguracioFirmaID());
    this.setNom(__bean.getNom());
    this.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    this.setIncloureSegellDeTemps(__bean.isIncloureSegellDeTemps());
    this.setPluginSegellatID(__bean.getPluginSegellatID());
    this.setTipusOperacioFirma(__bean.getTipusOperacioFirma());
    this.setTipusFirmaID(__bean.getTipusFirmaID());
    this.setAlgorismeDeFirmaID(__bean.getAlgorismeDeFirmaID());
    this.setModeDeFirma(__bean.isModeDeFirma());
    this.setUsPoliticaDeFirma(__bean.getUsPoliticaDeFirma());
    this.setPolicyIdentifier(__bean.getPolicyIdentifier());
    this.setPolicyIdentifierHash(__bean.getPolicyIdentifierHash());
    this.setPolicyIdentifierHashAlgorithm(__bean.getPolicyIdentifierHashAlgorithm());
    this.setPolicyUrlDocument(__bean.getPolicyUrlDocument());
    this.setPosicioTaulaFirmesID(__bean.getPosicioTaulaFirmesID());
    this.setFirmatPerFormatID(__bean.getFirmatPerFormatID());
    this.setMotiuDelegacioID(__bean.getMotiuDelegacioID());
    this.setPropietatsTaulaFirmes(__bean.getPropietatsTaulaFirmes());
	}

	public long getConfiguracioFirmaID() {
		return(configuracioFirmaID);
	};
	public void setConfiguracioFirmaID(long _configuracioFirmaID_) {
		this.configuracioFirmaID = _configuracioFirmaID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public long getPluginFirmaServidorID() {
		return(pluginFirmaServidorID);
	};
	public void setPluginFirmaServidorID(long _pluginFirmaServidorID_) {
		this.pluginFirmaServidorID = _pluginFirmaServidorID_;
	};

	public boolean isIncloureSegellDeTemps() {
		return(incloureSegellDeTemps);
	};
	public void setIncloureSegellDeTemps(boolean _incloureSegellDeTemps_) {
		this.incloureSegellDeTemps = _incloureSegellDeTemps_;
	};

	public java.lang.Long getPluginSegellatID() {
		return(pluginSegellatID);
	};
	public void setPluginSegellatID(java.lang.Long _pluginSegellatID_) {
		this.pluginSegellatID = _pluginSegellatID_;
	};

	public int getTipusOperacioFirma() {
		return(tipusOperacioFirma);
	};
	public void setTipusOperacioFirma(int _tipusOperacioFirma_) {
		this.tipusOperacioFirma = _tipusOperacioFirma_;
	};

	public int getTipusFirmaID() {
		return(tipusFirmaID);
	};
	public void setTipusFirmaID(int _tipusFirmaID_) {
		this.tipusFirmaID = _tipusFirmaID_;
	};

	public int getAlgorismeDeFirmaID() {
		return(algorismeDeFirmaID);
	};
	public void setAlgorismeDeFirmaID(int _algorismeDeFirmaID_) {
		this.algorismeDeFirmaID = _algorismeDeFirmaID_;
	};

	public boolean isModeDeFirma() {
		return(modeDeFirma);
	};
	public void setModeDeFirma(boolean _modeDeFirma_) {
		this.modeDeFirma = _modeDeFirma_;
	};

	public int getUsPoliticaDeFirma() {
		return(usPoliticaDeFirma);
	};
	public void setUsPoliticaDeFirma(int _usPoliticaDeFirma_) {
		this.usPoliticaDeFirma = _usPoliticaDeFirma_;
	};

	public java.lang.String getPolicyIdentifier() {
		return(policyIdentifier);
	};
	public void setPolicyIdentifier(java.lang.String _policyIdentifier_) {
		this.policyIdentifier = _policyIdentifier_;
	};

	public java.lang.String getPolicyIdentifierHash() {
		return(policyIdentifierHash);
	};
	public void setPolicyIdentifierHash(java.lang.String _policyIdentifierHash_) {
		this.policyIdentifierHash = _policyIdentifierHash_;
	};

	public java.lang.String getPolicyIdentifierHashAlgorithm() {
		return(policyIdentifierHashAlgorithm);
	};
	public void setPolicyIdentifierHashAlgorithm(java.lang.String _policyIdentifierHashAlgorithm_) {
		this.policyIdentifierHashAlgorithm = _policyIdentifierHashAlgorithm_;
	};

	public java.lang.String getPolicyUrlDocument() {
		return(policyUrlDocument);
	};
	public void setPolicyUrlDocument(java.lang.String _policyUrlDocument_) {
		this.policyUrlDocument = _policyUrlDocument_;
	};

	public int getPosicioTaulaFirmesID() {
		return(posicioTaulaFirmesID);
	};
	public void setPosicioTaulaFirmesID(int _posicioTaulaFirmesID_) {
		this.posicioTaulaFirmesID = _posicioTaulaFirmesID_;
	};

	public java.lang.Long getFirmatPerFormatID() {
		return(firmatPerFormatID);
	};
	public void setFirmatPerFormatID(java.lang.Long _firmatPerFormatID_) {
		this.firmatPerFormatID = _firmatPerFormatID_;
	};

	public java.lang.Long getMotiuDelegacioID() {
		return(motiuDelegacioID);
	};
	public void setMotiuDelegacioID(java.lang.Long _motiuDelegacioID_) {
		this.motiuDelegacioID = _motiuDelegacioID_;
	};

	public java.lang.String getPropietatsTaulaFirmes() {
		return(propietatsTaulaFirmes);
	};
	public void setPropietatsTaulaFirmes(java.lang.String _propietatsTaulaFirmes_) {
		this.propietatsTaulaFirmes = _propietatsTaulaFirmes_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof ConfiguracioFirma) {
      ConfiguracioFirma __instance = (ConfiguracioFirma)__obj;
      __result = true;
      __result = __result && (this.getConfiguracioFirmaID() == __instance.getConfiguracioFirmaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:configuraciofirmaid | Table: dib_perfil | Type: 0  

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "configuracioFirma")
	private Set<PerfilJPA> perfils = new HashSet<PerfilJPA>(0);
	public  Set<PerfilJPA> getPerfils() {
    return this.perfils;
  }

	public void setPerfils(Set<PerfilJPA> perfils) {
	  this.perfils = perfils;
	}


// IMP Field:pluginid | Table: dib_plugin | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_conffirma_plugin_fir_fk")
	@JoinColumn(name = "pluginfirmaservidorid", referencedColumnName ="pluginID", nullable = false, insertable=false, updatable=false)
	private PluginJPA pluginFirmaServidor;

	public PluginJPA getPluginFirmaServidor() {
    return this.pluginFirmaServidor;
  }

	public  void setPluginFirmaServidor(PluginJPA pluginFirmaServidor) {
    this.pluginFirmaServidor = pluginFirmaServidor;
  }

// IMP Field:pluginid | Table: dib_plugin | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_conffirma_plugin_seg_fk")
	@JoinColumn(name = "pluginsegellatid", referencedColumnName ="pluginID", nullable = true, insertable=false, updatable=false)
	private PluginJPA pluginSegellat;

	public PluginJPA getPluginSegellat() {
    return this.pluginSegellat;
  }

	public  void setPluginSegellat(PluginJPA pluginSegellat) {
    this.pluginSegellat = pluginSegellat;
  }

// IMP Field:traduccioid | Table: dib_traduccio | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER, cascade=javax.persistence.CascadeType.ALL)
	@ForeignKey(name="dib_conffirma_traduccio_ff_fk")
	@JoinColumn(name = "firmatperformatid", referencedColumnName ="traduccioID", nullable = true, insertable=false, updatable=false)
	private TraduccioJPA firmatPerFormat;

	public TraduccioJPA getFirmatPerFormat() {
    return this.firmatPerFormat;
  }

	public  void setFirmatPerFormat(TraduccioJPA firmatPerFormat) {
    this.firmatPerFormat = firmatPerFormat;
  }

  @javax.xml.bind.annotation.XmlTransient
  public java.util.Map<String, es.caib.digitalib.jpa.TraduccioMapJPA> getFirmatPerFormatTraduccions() {
    return this.firmatPerFormat.getTraduccions();
  }

  public void setFirmatPerFormatTraduccions(java.util.Map<String, es.caib.digitalib.jpa.TraduccioMapJPA> __traduccions__) {
    this.firmatPerFormat.setTraduccions(__traduccions__);
  }


// IMP Field:traduccioid | Table: dib_traduccio | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER, cascade=javax.persistence.CascadeType.ALL)
	@ForeignKey(name="dib_conffirma_traduccio_md_fk")
	@JoinColumn(name = "motiudelegacioid", referencedColumnName ="traduccioID", nullable = true, insertable=false, updatable=false)
	private TraduccioJPA motiuDelegacio;

	public TraduccioJPA getMotiuDelegacio() {
    return this.motiuDelegacio;
  }

	public  void setMotiuDelegacio(TraduccioJPA motiuDelegacio) {
    this.motiuDelegacio = motiuDelegacio;
  }

  @javax.xml.bind.annotation.XmlTransient
  public java.util.Map<String, es.caib.digitalib.jpa.TraduccioMapJPA> getMotiuDelegacioTraduccions() {
    return this.motiuDelegacio.getTraduccions();
  }

  public void setMotiuDelegacioTraduccions(java.util.Map<String, es.caib.digitalib.jpa.TraduccioMapJPA> __traduccions__) {
    this.motiuDelegacio.setTraduccions(__traduccions__);
  }



 // ---------------  STATIC METHODS ------------------
  public static ConfiguracioFirmaJPA toJPA(ConfiguracioFirma __bean) {
    if (__bean == null) { return null;}
    ConfiguracioFirmaJPA __tmp = new ConfiguracioFirmaJPA();
    __tmp.setConfiguracioFirmaID(__bean.getConfiguracioFirmaID());
    __tmp.setNom(__bean.getNom());
    __tmp.setPluginFirmaServidorID(__bean.getPluginFirmaServidorID());
    __tmp.setIncloureSegellDeTemps(__bean.isIncloureSegellDeTemps());
    __tmp.setPluginSegellatID(__bean.getPluginSegellatID());
    __tmp.setTipusOperacioFirma(__bean.getTipusOperacioFirma());
    __tmp.setTipusFirmaID(__bean.getTipusFirmaID());
    __tmp.setAlgorismeDeFirmaID(__bean.getAlgorismeDeFirmaID());
    __tmp.setModeDeFirma(__bean.isModeDeFirma());
    __tmp.setUsPoliticaDeFirma(__bean.getUsPoliticaDeFirma());
    __tmp.setPolicyIdentifier(__bean.getPolicyIdentifier());
    __tmp.setPolicyIdentifierHash(__bean.getPolicyIdentifierHash());
    __tmp.setPolicyIdentifierHashAlgorithm(__bean.getPolicyIdentifierHashAlgorithm());
    __tmp.setPolicyUrlDocument(__bean.getPolicyUrlDocument());
    __tmp.setPosicioTaulaFirmesID(__bean.getPosicioTaulaFirmesID());
    __tmp.setFirmatPerFormatID(__bean.getFirmatPerFormatID());
    __tmp.setMotiuDelegacioID(__bean.getMotiuDelegacioID());
    __tmp.setPropietatsTaulaFirmes(__bean.getPropietatsTaulaFirmes());
		return __tmp;
	}


  public static ConfiguracioFirmaJPA copyJPA(ConfiguracioFirmaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<ConfiguracioFirmaJPA> copyJPA(java.util.Set<ConfiguracioFirmaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<ConfiguracioFirmaJPA> __tmpSet = (java.util.Set<ConfiguracioFirmaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<ConfiguracioFirmaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (ConfiguracioFirmaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static ConfiguracioFirmaJPA copyJPA(ConfiguracioFirmaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    ConfiguracioFirmaJPA __tmp = (ConfiguracioFirmaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfils) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfils())) ) {
      __tmp.setPerfils(PerfilJPA.copyJPA(__jpa.getPerfils(), __alreadyCopied,"ConfiguracioFirmaJPA"));
    }
    // Copia de beans complexes (IMP)
    if(!"TraduccioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.motiuDelegacio) || org.hibernate.Hibernate.isInitialized(__jpa.getMotiuDelegacio()) ) ) {
      __tmp.setMotiuDelegacio(TraduccioJPA.copyJPA(__jpa.getMotiuDelegacio(), __alreadyCopied,"ConfiguracioFirmaJPA"));
    }
    if(!"TraduccioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.firmatPerFormat) || org.hibernate.Hibernate.isInitialized(__jpa.getFirmatPerFormat()) ) ) {
      __tmp.setFirmatPerFormat(TraduccioJPA.copyJPA(__jpa.getFirmatPerFormat(), __alreadyCopied,"ConfiguracioFirmaJPA"));
    }
    if(!"PluginJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginFirmaServidor) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginFirmaServidor()) ) ) {
      __tmp.setPluginFirmaServidor(PluginJPA.copyJPA(__jpa.getPluginFirmaServidor(), __alreadyCopied,"ConfiguracioFirmaJPA"));
    }
    if(!"PluginJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.pluginSegellat) || org.hibernate.Hibernate.isInitialized(__jpa.getPluginSegellat()) ) ) {
      __tmp.setPluginSegellat(PluginJPA.copyJPA(__jpa.getPluginSegellat(), __alreadyCopied,"ConfiguracioFirmaJPA"));
    }

    return __tmp;
  }




}
