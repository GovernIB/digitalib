
package es.caib.digitalib.jpa;
import es.caib.digitalib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Index;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "dib_plugincridada" )
@SequenceGenerator(name="DIGITALIB_SEQ", sequenceName="dib_digitalib_seq", allocationSize=1)
@javax.xml.bind.annotation.XmlRootElement
public class PluginCridadaJPA implements PluginCridada {



private static final long serialVersionUID = -1618108326L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DIGITALIB_SEQ")
	@Index(name="dib_plugincridada_pk_i")
	@Column(name="plugincridadaid",nullable = false,length = 19)
	long pluginCridadaID;

	@Column(name="data",nullable = false,length = 35,precision = 6)
	java.sql.Timestamp data;

	@Index(name="dib_plugcrid_pluginid_fk_i")
	@Column(name="pluginid",nullable = false,length = 19)
	long pluginID;

	@Column(name="metodeplugin",nullable = false,length = 100)
	java.lang.String metodePlugin;

	@Column(name="tipusresultat",nullable = false,length = 10)
	int tipusResultat;

	@Column(name="tempsexecucio",length = 19)
	java.lang.Long tempsExecucio;

	@Column(name="usuaripersonaid",length = 19)
	java.lang.Long usuariPersonaId;

	@Column(name="usuariaplicacioid",length = 19)
	java.lang.Long usuariAplicacioId;

	@Column(name="parametrestext",length = 2147483647)
  @Lob
	java.lang.String parametresText;

	@Index(name="dib_plugcrid_paramfitxer_fk_i")
	@Column(name="parametresfitxerid",length = 19)
	java.lang.Long parametresFitxerID;

	@Column(name="retorntext",length = 2147483647)
  @Lob
	java.lang.String retornText;

	@Index(name="dib_plugcrid_retofitxerid_fk_i")
	@Column(name="retornfitxerid",length = 19)
	java.lang.Long retornFitxerID;



  /** Constructor Buit */
  public PluginCridadaJPA() {
  }

  /** Constructor amb tots els camps  */
  public PluginCridadaJPA(long pluginCridadaID , java.sql.Timestamp data , long pluginID , java.lang.String metodePlugin , int tipusResultat , java.lang.Long tempsExecucio , java.lang.Long usuariPersonaId , java.lang.Long usuariAplicacioId , java.lang.String parametresText , java.lang.Long parametresFitxerID , java.lang.String retornText , java.lang.Long retornFitxerID) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.pluginID=pluginID;
    this.metodePlugin=metodePlugin;
    this.tipusResultat=tipusResultat;
    this.tempsExecucio=tempsExecucio;
    this.usuariPersonaId=usuariPersonaId;
    this.usuariAplicacioId=usuariAplicacioId;
    this.parametresText=parametresText;
    this.parametresFitxerID=parametresFitxerID;
    this.retornText=retornText;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor sense valors autoincrementals */
  public PluginCridadaJPA(java.sql.Timestamp data , long pluginID , java.lang.String metodePlugin , int tipusResultat , java.lang.Long tempsExecucio , java.lang.Long usuariPersonaId , java.lang.Long usuariAplicacioId , java.lang.String parametresText , java.lang.Long parametresFitxerID , java.lang.String retornText , java.lang.Long retornFitxerID) {
    this.data=data;
    this.pluginID=pluginID;
    this.metodePlugin=metodePlugin;
    this.tipusResultat=tipusResultat;
    this.tempsExecucio=tempsExecucio;
    this.usuariPersonaId=usuariPersonaId;
    this.usuariAplicacioId=usuariAplicacioId;
    this.parametresText=parametresText;
    this.parametresFitxerID=parametresFitxerID;
    this.retornText=retornText;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor dels valors Not Null */
  public PluginCridadaJPA(long pluginCridadaID , java.sql.Timestamp data , long pluginID , java.lang.String metodePlugin , int tipusResultat) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.pluginID=pluginID;
    this.metodePlugin=metodePlugin;
    this.tipusResultat=tipusResultat;
}
  public PluginCridadaJPA(PluginCridada __bean) {
    this.setPluginCridadaID(__bean.getPluginCridadaID());
    this.setData(__bean.getData());
    this.setPluginID(__bean.getPluginID());
    this.setMetodePlugin(__bean.getMetodePlugin());
    this.setTipusResultat(__bean.getTipusResultat());
    this.setTempsExecucio(__bean.getTempsExecucio());
    this.setUsuariPersonaId(__bean.getUsuariPersonaId());
    this.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    this.setParametresText(__bean.getParametresText());
    this.setParametresFitxerID(__bean.getParametresFitxerID());
    this.setRetornText(__bean.getRetornText());
    this.setRetornFitxerID(__bean.getRetornFitxerID());
    // Fitxer
    this.setParametresFitxer(FitxerJPA.toJPA(__bean.getParametresFitxer()));
    // Fitxer
    this.setRetornFitxer(FitxerJPA.toJPA(__bean.getRetornFitxer()));
	}

	public long getPluginCridadaID() {
		return(pluginCridadaID);
	};
	public void setPluginCridadaID(long _pluginCridadaID_) {
		this.pluginCridadaID = _pluginCridadaID_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public long getPluginID() {
		return(pluginID);
	};
	public void setPluginID(long _pluginID_) {
		this.pluginID = _pluginID_;
	};

	public java.lang.String getMetodePlugin() {
		return(metodePlugin);
	};
	public void setMetodePlugin(java.lang.String _metodePlugin_) {
		this.metodePlugin = _metodePlugin_;
	};

	public int getTipusResultat() {
		return(tipusResultat);
	};
	public void setTipusResultat(int _tipusResultat_) {
		this.tipusResultat = _tipusResultat_;
	};

	public java.lang.Long getTempsExecucio() {
		return(tempsExecucio);
	};
	public void setTempsExecucio(java.lang.Long _tempsExecucio_) {
		this.tempsExecucio = _tempsExecucio_;
	};

	public java.lang.Long getUsuariPersonaId() {
		return(usuariPersonaId);
	};
	public void setUsuariPersonaId(java.lang.Long _usuariPersonaId_) {
		this.usuariPersonaId = _usuariPersonaId_;
	};

	public java.lang.Long getUsuariAplicacioId() {
		return(usuariAplicacioId);
	};
	public void setUsuariAplicacioId(java.lang.Long _usuariAplicacioId_) {
		this.usuariAplicacioId = _usuariAplicacioId_;
	};

	public java.lang.String getParametresText() {
		return(parametresText);
	};
	public void setParametresText(java.lang.String _parametresText_) {
		this.parametresText = _parametresText_;
	};

	public java.lang.Long getParametresFitxerID() {
		return(parametresFitxerID);
	};
	public void setParametresFitxerID(java.lang.Long _parametresFitxerID_) {
		this.parametresFitxerID = _parametresFitxerID_;
	};

	public java.lang.String getRetornText() {
		return(retornText);
	};
	public void setRetornText(java.lang.String _retornText_) {
		this.retornText = _retornText_;
	};

	public java.lang.Long getRetornFitxerID() {
		return(retornFitxerID);
	};
	public void setRetornFitxerID(java.lang.Long _retornFitxerID_) {
		this.retornFitxerID = _retornFitxerID_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof PluginCridada) {
      PluginCridada __instance = (PluginCridada)__obj;
      __result = true;
      __result = __result && (this.getPluginCridadaID() == __instance.getPluginCridadaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:pluginid | Table: dib_plugin | Type: 1  

	@ManyToOne(fetch = FetchType.LAZY)
	@ForeignKey(name="dib_plugcrid_plugin_plugini_fk")
	@JoinColumn(name = "pluginid", referencedColumnName ="pluginID", nullable = false, insertable=false, updatable=false)
	private PluginJPA plugin;

	public PluginJPA getPlugin() {
    return this.plugin;
  }

	public  void setPlugin(PluginJPA plugin) {
    this.plugin = plugin;
  }

// IMP Field:fitxerid | Table: dib_fitxer | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name="dib_plugcrid_fitxer_paramet_fk")
	@JoinColumn(name = "parametresfitxerid", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
	private FitxerJPA parametresFitxer;

	public FitxerJPA getParametresFitxer() {
    return this.parametresFitxer;
  }

	public  void setParametresFitxer(FitxerJPA parametresFitxer) {
    this.parametresFitxer = parametresFitxer;
  }

// IMP Field:fitxerid | Table: dib_fitxer | Type: 1  

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name="dib_plugcrid_fitxer_retornf_fk")
	@JoinColumn(name = "retornfitxerid", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
	private FitxerJPA retornFitxer;

	public FitxerJPA getRetornFitxer() {
    return this.retornFitxer;
  }

	public  void setRetornFitxer(FitxerJPA retornFitxer) {
    this.retornFitxer = retornFitxer;
  }


 // ---------------  STATIC METHODS ------------------
  public static PluginCridadaJPA toJPA(PluginCridada __bean) {
    if (__bean == null) { return null;}
    PluginCridadaJPA __tmp = new PluginCridadaJPA();
    __tmp.setPluginCridadaID(__bean.getPluginCridadaID());
    __tmp.setData(__bean.getData());
    __tmp.setPluginID(__bean.getPluginID());
    __tmp.setMetodePlugin(__bean.getMetodePlugin());
    __tmp.setTipusResultat(__bean.getTipusResultat());
    __tmp.setTempsExecucio(__bean.getTempsExecucio());
    __tmp.setUsuariPersonaId(__bean.getUsuariPersonaId());
    __tmp.setUsuariAplicacioId(__bean.getUsuariAplicacioId());
    __tmp.setParametresText(__bean.getParametresText());
    __tmp.setParametresFitxerID(__bean.getParametresFitxerID());
    __tmp.setRetornText(__bean.getRetornText());
    __tmp.setRetornFitxerID(__bean.getRetornFitxerID());
    // Fitxer
    __tmp.setParametresFitxer(FitxerJPA.toJPA(__bean.getParametresFitxer()));
    // Fitxer
    __tmp.setRetornFitxer(FitxerJPA.toJPA(__bean.getRetornFitxer()));
		return __tmp;
	}


  public static PluginCridadaJPA copyJPA(PluginCridadaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<PluginCridadaJPA> copyJPA(java.util.Set<PluginCridadaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<PluginCridadaJPA> __tmpSet = (java.util.Set<PluginCridadaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<PluginCridadaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (PluginCridadaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static PluginCridadaJPA copyJPA(PluginCridadaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    PluginCridadaJPA __tmp = (PluginCridadaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"PluginJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.plugin) || org.hibernate.Hibernate.isInitialized(__jpa.getPlugin()) ) ) {
      __tmp.setPlugin(PluginJPA.copyJPA(__jpa.getPlugin(), __alreadyCopied,"PluginCridadaJPA"));
    }

    return __tmp;
  }




}
