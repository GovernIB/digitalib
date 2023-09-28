
package es.caib.digitalib.persistence;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.HashMap;
import org.hibernate.annotations.Cascade;
import java.util.HashSet;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import java.util.Map;
import javax.persistence.FetchType;
import javax.persistence.ElementCollection;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.Id;


@Entity(name = "TraduccioJPA")
@Table(name = "dib_traduccio" , indexes = { 
        @Index(name="dib_traduccio_pk_i", columnList = "traduccioid")})
@SequenceGenerator(name="TRADUCCIO_SEQ", sequenceName="dib_traduccio_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class TraduccioJPA implements Traduccio {

  /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TRADUCCIO_SEQ")
    @Column(name="traduccioid",nullable = false,length = 19)
    long traduccioID;



  /** Constructor Buit */
  public TraduccioJPA() {
  }

  /** Constructor amb tots els camps  */
  public TraduccioJPA(long traduccioID) {
    this.traduccioID=traduccioID;
}
  public TraduccioJPA(Traduccio __bean) {
    this.setTraduccioID(__bean.getTraduccioID());
	}

	public long getTraduccioID() {
		return(traduccioID);
	};
	public void setTraduccioID(long _traduccioID_) {
		this.traduccioID = _traduccioID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Traduccio) {
      Traduccio __instance = (Traduccio)__obj;
      __result = true;
      __result = __result && (this.getTraduccioID() == __instance.getTraduccioID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:descripcioid | Table: dib_avis | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "descripcioID")
    private Set<AvisJPA> aviss = new HashSet<AvisJPA>(0);
    public  Set<AvisJPA> getAviss() {
    return this.aviss;
  }

    public void setAviss(Set<AvisJPA> aviss) {
      this.aviss = aviss;
    }


// EXP  Field:firmatperformatid | Table: dib_configuraciofirma | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "firmatPerFormatID")
    private Set<ConfiguracioFirmaJPA> configuracioFirma_firmatperformatids = new HashSet<ConfiguracioFirmaJPA>(0);
    public  Set<ConfiguracioFirmaJPA> getConfiguracioFirma_firmatperformatids() {
    return this.configuracioFirma_firmatperformatids;
  }

    public void setConfiguracioFirma_firmatperformatids(Set<ConfiguracioFirmaJPA> configuracioFirma_firmatperformatids) {
      this.configuracioFirma_firmatperformatids = configuracioFirma_firmatperformatids;
    }


// EXP  Field:motiudelegacioid | Table: dib_configuraciofirma | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "motiuDelegacioID")
    private Set<ConfiguracioFirmaJPA> configuracioFirma_motiudelegacioids = new HashSet<ConfiguracioFirmaJPA>(0);
    public  Set<ConfiguracioFirmaJPA> getConfiguracioFirma_motiudelegacioids() {
    return this.configuracioFirma_motiudelegacioids;
  }

    public void setConfiguracioFirma_motiudelegacioids(Set<ConfiguracioFirmaJPA> configuracioFirma_motiudelegacioids) {
      this.configuracioFirma_motiudelegacioids = configuracioFirma_motiudelegacioids;
    }


// EXP  Field:descripcioid | Table: dib_perfil | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "descripcioID")
    private Set<PerfilJPA> perfil_descripcioids = new HashSet<PerfilJPA>(0);
    public  Set<PerfilJPA> getPerfil_descripcioids() {
    return this.perfil_descripcioids;
  }

    public void setPerfil_descripcioids(Set<PerfilJPA> perfil_descripcioids) {
      this.perfil_descripcioids = perfil_descripcioids;
    }


// EXP  Field:nomid | Table: dib_perfil | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nomID")
    private Set<PerfilJPA> perfil_nomids = new HashSet<PerfilJPA>(0);
    public  Set<PerfilJPA> getPerfil_nomids() {
    return this.perfil_nomids;
  }

    public void setPerfil_nomids(Set<PerfilJPA> perfil_nomids) {
      this.perfil_nomids = perfil_nomids;
    }


  @ElementCollection(fetch= FetchType.EAGER, targetClass = es.caib.digitalib.persistence.TraduccioMapJPA.class)
  @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
  @LazyCollection(value= LazyCollectionOption.FALSE)
  @JoinTable(name="dib_traducciomap",joinColumns={@JoinColumn(name="traducciomapid")}, foreignKey=@ForeignKey(name="dib_traducmap_traduccio_fk"))
  @javax.persistence.MapKeyColumn(name="idiomaid")
  private Map<String, es.caib.digitalib.persistence.TraduccioMapJPA> traduccions =  new HashMap<String, es.caib.digitalib.persistence.TraduccioMapJPA>();

  public Map<String, es.caib.digitalib.persistence.TraduccioMapJPA> getTraduccions() {
    return this.traduccions;
  }

  public void setTraduccions(Map<String, es.caib.digitalib.persistence.TraduccioMapJPA> _traduccions_) {
    this.traduccions = _traduccions_;
  }

  public java.util.Set<String> getIdiomes() {
    return this.traduccions.keySet();
  }
  
  public es.caib.digitalib.persistence.TraduccioMapJPA getTraduccio(String idioma) {
    return (es.caib.digitalib.persistence.TraduccioMapJPA) traduccions.get(idioma);
  }
  
  public void addTraduccio(String idioma, es.caib.digitalib.persistence.TraduccioMapJPA traduccio) {
    if (traduccio == null) {
      traduccions.remove(idioma);
    } else {
      traduccions.put(idioma, traduccio);
    }
  }

 // ---------------  STATIC METHODS ------------------
  public static TraduccioJPA toJPA(Traduccio __bean) {
    if (__bean == null) { return null;}
    TraduccioJPA __tmp = new TraduccioJPA();
    __tmp.setTraduccioID(__bean.getTraduccioID());
		return __tmp;
	}


  public static TraduccioJPA copyJPA(TraduccioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<TraduccioJPA> copyJPA(java.util.Set<TraduccioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<TraduccioJPA> __tmpSet = (java.util.Set<TraduccioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<TraduccioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (TraduccioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static TraduccioJPA copyJPA(TraduccioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    TraduccioJPA __tmp = (TraduccioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil_descripcioids) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil_descripcioids())) ) {
      __tmp.setPerfil_descripcioids(PerfilJPA.copyJPA(__jpa.getPerfil_descripcioids(), __alreadyCopied,"TraduccioJPA"));
    }
    if(!"ConfiguracioFirmaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioFirma_motiudelegacioids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioFirma_motiudelegacioids())) ) {
      __tmp.setConfiguracioFirma_motiudelegacioids(ConfiguracioFirmaJPA.copyJPA(__jpa.getConfiguracioFirma_motiudelegacioids(), __alreadyCopied,"TraduccioJPA"));
    }
    if(!"ConfiguracioFirmaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioFirma_firmatperformatids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioFirma_firmatperformatids())) ) {
      __tmp.setConfiguracioFirma_firmatperformatids(ConfiguracioFirmaJPA.copyJPA(__jpa.getConfiguracioFirma_firmatperformatids(), __alreadyCopied,"TraduccioJPA"));
    }
    if(!"PerfilJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.perfil_nomids) || org.hibernate.Hibernate.isInitialized(__jpa.getPerfil_nomids())) ) {
      __tmp.setPerfil_nomids(PerfilJPA.copyJPA(__jpa.getPerfil_nomids(), __alreadyCopied,"TraduccioJPA"));
    }
    if(!"AvisJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.aviss) || org.hibernate.Hibernate.isInitialized(__jpa.getAviss())) ) {
      __tmp.setAviss(AvisJPA.copyJPA(__jpa.getAviss(), __alreadyCopied,"TraduccioJPA"));
    }
    // Copia de beans complexes (IMP)
    // Aquesta linia s'afeix de forma manual
    __tmp.setTraduccions(new HashMap<String, TraduccioMapJPA>(__jpa.getTraduccions()));

    return __tmp;
  }




}
