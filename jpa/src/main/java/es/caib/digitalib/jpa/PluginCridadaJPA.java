
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

	@Column(name="metodeplugin",nullable = false,length = 100)
	java.lang.String metodeplugin;

	@Column(name="tipusresultat",nullable = false,length = 10)
	int tipusresultat;

	@Column(name="tempsexecucio",length = 19)
	java.lang.Long tempsexecucio;

	@Index(name="dib_plugcrid_pluginid_fk_i")
	@Column(name="pluginid",nullable = false,length = 19)
	long pluginID;

	@Column(name="usuaripersonaid",length = 19)
	java.lang.Long usuaripersonaid;

	@Column(name="usuariaplicacioid",length = 19)
	java.lang.Long usuariaplicacioid;

	@Column(name="parametrestext",length = 2147483647)
  @Lob
	java.lang.String parametrestext;

	@Index(name="dib_plugcrid_paramfitxer_fk_i")
	@Column(name="parametresfitxerid",length = 19)
	java.lang.Long parametresFitxerID;

	@Column(name="retorntext",length = 2147483647)
  @Lob
	java.lang.String retorntext;

	@Index(name="dib_plugcrid_retofitxerid_fk_i")
	@Column(name="retornfitxerid",length = 19)
	java.lang.Long retornFitxerID;



  /** Constructor Buit */
  public PluginCridadaJPA() {
  }

  /** Constructor amb tots els camps  */
  public PluginCridadaJPA(long pluginCridadaID , java.sql.Timestamp data , java.lang.String metodeplugin , int tipusresultat , java.lang.Long tempsexecucio , long pluginID , java.lang.Long usuaripersonaid , java.lang.Long usuariaplicacioid , java.lang.String parametrestext , java.lang.Long parametresFitxerID , java.lang.String retorntext , java.lang.Long retornFitxerID) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.metodeplugin=metodeplugin;
    this.tipusresultat=tipusresultat;
    this.tempsexecucio=tempsexecucio;
    this.pluginID=pluginID;
    this.usuaripersonaid=usuaripersonaid;
    this.usuariaplicacioid=usuariaplicacioid;
    this.parametrestext=parametrestext;
    this.parametresFitxerID=parametresFitxerID;
    this.retorntext=retorntext;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor sense valors autoincrementals */
  public PluginCridadaJPA(java.sql.Timestamp data , java.lang.String metodeplugin , int tipusresultat , java.lang.Long tempsexecucio , long pluginID , java.lang.Long usuaripersonaid , java.lang.Long usuariaplicacioid , java.lang.String parametrestext , java.lang.Long parametresFitxerID , java.lang.String retorntext , java.lang.Long retornFitxerID) {
    this.data=data;
    this.metodeplugin=metodeplugin;
    this.tipusresultat=tipusresultat;
    this.tempsexecucio=tempsexecucio;
    this.pluginID=pluginID;
    this.usuaripersonaid=usuaripersonaid;
    this.usuariaplicacioid=usuariaplicacioid;
    this.parametrestext=parametrestext;
    this.parametresFitxerID=parametresFitxerID;
    this.retorntext=retorntext;
    this.retornFitxerID=retornFitxerID;
}
  /** Constructor dels valors Not Null */
  public PluginCridadaJPA(long pluginCridadaID , java.sql.Timestamp data , java.lang.String metodeplugin , int tipusresultat , long pluginID) {
    this.pluginCridadaID=pluginCridadaID;
    this.data=data;
    this.metodeplugin=metodeplugin;
    this.tipusresultat=tipusresultat;
    this.pluginID=pluginID;
}
  public PluginCridadaJPA(PluginCridada __bean) {
    this.setPluginCridadaID(__bean.getPluginCridadaID());
    this.setData(__bean.getData());
    this.setMetodeplugin(__bean.getMetodeplugin());
    this.setTipusresultat(__bean.getTipusresultat());
    this.setTempsexecucio(__bean.getTempsexecucio());
    this.setPluginID(__bean.getPluginID());
    this.setUsuaripersonaid(__bean.getUsuaripersonaid());
    this.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    this.setParametrestext(__bean.getParametrestext());
    this.setParametresFitxerID(__bean.getParametresFitxerID());
    this.setRetorntext(__bean.getRetorntext());
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

	public java.lang.String getMetodeplugin() {
		return(metodeplugin);
	};
	public void setMetodeplugin(java.lang.String _metodeplugin_) {
		this.metodeplugin = _metodeplugin_;
	};

	public int getTipusresultat() {
		return(tipusresultat);
	};
	public void setTipusresultat(int _tipusresultat_) {
		this.tipusresultat = _tipusresultat_;
	};

	public java.lang.Long getTempsexecucio() {
		return(tempsexecucio);
	};
	public void setTempsexecucio(java.lang.Long _tempsexecucio_) {
		this.tempsexecucio = _tempsexecucio_;
	};

	public long getPluginID() {
		return(pluginID);
	};
	public void setPluginID(long _pluginID_) {
		this.pluginID = _pluginID_;
	};

	public java.lang.Long getUsuaripersonaid() {
		return(usuaripersonaid);
	};
	public void setUsuaripersonaid(java.lang.Long _usuaripersonaid_) {
		this.usuaripersonaid = _usuaripersonaid_;
	};

	public java.lang.Long getUsuariaplicacioid() {
		return(usuariaplicacioid);
	};
	public void setUsuariaplicacioid(java.lang.Long _usuariaplicacioid_) {
		this.usuariaplicacioid = _usuariaplicacioid_;
	};

	public java.lang.String getParametrestext() {
		return(parametrestext);
	};
	public void setParametrestext(java.lang.String _parametrestext_) {
		this.parametrestext = _parametrestext_;
	};

	public java.lang.Long getParametresFitxerID() {
		return(parametresFitxerID);
	};
	public void setParametresFitxerID(java.lang.Long _parametresFitxerID_) {
		this.parametresFitxerID = _parametresFitxerID_;
	};

	public java.lang.String getRetorntext() {
		return(retorntext);
	};
	public void setRetorntext(java.lang.String _retorntext_) {
		this.retorntext = _retorntext_;
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
    __tmp.setMetodeplugin(__bean.getMetodeplugin());
    __tmp.setTipusresultat(__bean.getTipusresultat());
    __tmp.setTempsexecucio(__bean.getTempsexecucio());
    __tmp.setPluginID(__bean.getPluginID());
    __tmp.setUsuaripersonaid(__bean.getUsuaripersonaid());
    __tmp.setUsuariaplicacioid(__bean.getUsuariaplicacioid());
    __tmp.setParametrestext(__bean.getParametrestext());
    __tmp.setParametresFitxerID(__bean.getParametresFitxerID());
    __tmp.setRetorntext(__bean.getRetorntext());
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
