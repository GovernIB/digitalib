
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import org.hibernate.annotations.Cascade;
import javax.persistence.SequenceGenerator;
import java.util.Map;
import javax.persistence.Id;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyCollection;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Index;
import javax.persistence.JoinTable;
import org.hibernate.annotations.ForeignKey;
import java.util.HashMap;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import org.hibernate.annotations.CollectionOfElements;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_traduccio" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class TraduccioJPA implements Traduccio {



private static final long serialVersionUID = -326205279L;

  /**  */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_traduccio_pk_i")
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


  @CollectionOfElements(fetch= FetchType.EAGER,targetElement = es.caib.digitalib.jpa.TraduccioMapJPA.class)
  @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
  @LazyCollection(value= LazyCollectionOption.FALSE)
  @JoinTable(name="dib_traducciomap",joinColumns={@JoinColumn(name="traducciomapid")})
  @org.hibernate.annotations.MapKey(columns={@Column(name="idiomaid")})
  @ForeignKey(name="dib_traducmap_traduccio_fk") 
  private Map<String, es.caib.digitalib.jpa.TraduccioMapJPA> traduccions =  new HashMap<String, es.caib.digitalib.jpa.TraduccioMapJPA>();

  public Map<String, es.caib.digitalib.jpa.TraduccioMapJPA> getTraduccions() {
    return this.traduccions;
  }

  public void setTraduccions(Map<String, es.caib.digitalib.jpa.TraduccioMapJPA> _traduccions_) {
    this.traduccions = _traduccions_;
  }

  public java.util.Set<String> getIdiomes() {
    return this.traduccions.keySet();
  }
  
  public es.caib.digitalib.jpa.TraduccioMapJPA getTraduccio(String idioma) {
    return (es.caib.digitalib.jpa.TraduccioMapJPA) traduccions.get(idioma);
  }
  
  public void addTraduccio(String idioma, es.caib.digitalib.jpa.TraduccioMapJPA traduccio) {
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
    if(!"ConfiguracioFirmaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioFirma_firmatperformatids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioFirma_firmatperformatids())) ) {
      __tmp.setConfiguracioFirma_firmatperformatids(ConfiguracioFirmaJPA.copyJPA(__jpa.getConfiguracioFirma_firmatperformatids(), __alreadyCopied,"TraduccioJPA"));
    }
    if(!"ConfiguracioFirmaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.configuracioFirma_motiudelegacioids) || org.hibernate.Hibernate.isInitialized(__jpa.getConfiguracioFirma_motiudelegacioids())) ) {
      __tmp.setConfiguracioFirma_motiudelegacioids(ConfiguracioFirmaJPA.copyJPA(__jpa.getConfiguracioFirma_motiudelegacioids(), __alreadyCopied,"TraduccioJPA"));
    }
    // Copia de beans complexes (IMP)
    // Aquesta linia s'afeix de forma manual
    __tmp.setTraduccions(new HashMap<String, TraduccioMapJPA>(__jpa.getTraduccions()));

    return __tmp;
  }




}
