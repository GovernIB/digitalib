
package es.caib.digitalib.jpa;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import es.caib.digitalib.model.entity.*;
import es.caib.digitalib.model.fields.*;
import es.caib.digitalib.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.events.ModificationManager;


public class PerfilJPAManager
		 extends AbstractDigitalIBJPAManager<Perfil, Long>
		 implements IPerfilManager, PerfilFields {




  private static final long serialVersionUID = 1849839198L;

	 public static final TableName<Perfil> _TABLENAME =  new TableName<Perfil>("PerfilJPA");



  static final ModificationManager<Perfil> __eventManager = new ModificationManager<Perfil>();


  @PersistenceContext
  protected EntityManager __em;
  public PerfilJPAManager() {
  }
  protected PerfilJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return PerfilJPA. class;
	}



	public ModificationManager<Perfil> getEventManager() {
	return __eventManager;
	}


	public TableName<Perfil> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public Perfil[] listToArray(List<Perfil> list)  {
		if(list == null) { return null; };
		return list.toArray(new Perfil[list.size()]);
	};

	public Perfil create( java.lang.String _codi_, java.lang.Long _nomID_, java.lang.Long _descripcioID_, java.lang.String _urlBase_, int _scanFormatFitxer_, java.lang.Integer _scanMinimaResolucio_, java.lang.Integer _scanPixelType_, long _pluginScanWebID_, java.lang.Long _pluginScanWeb2ID_, int _tipusFirma_, java.lang.Long _apiSimpleID_, java.lang.Long _configuracioFirmaID_, int _tipusCustodia_, java.lang.Long _pluginArxiuID_, java.lang.Long _pluginDocCustodyID_, int _usPerfil_, java.lang.Boolean _utilitzatPerAplicacio_) throws I18NException {
		PerfilJPA __bean =  new PerfilJPA(_codi_,_nomID_,_descripcioID_,_urlBase_,_scanFormatFitxer_,_scanMinimaResolucio_,_scanPixelType_,_pluginScanWebID_,_pluginScanWeb2ID_,_tipusFirma_,_apiSimpleID_,_configuracioFirmaID_,_tipusCustodia_,_pluginArxiuID_,_pluginDocCustodyID_,_usPerfil_,_utilitzatPerAplicacio_);
		return create(__bean);
	}



 public void delete(long _perfilID_) {
   delete(findByPrimaryKey(_perfilID_));
 }




	public Perfil findByPrimaryKey(long _perfilID_) {
	  return __em.find(PerfilJPA.class, _perfilID_);  
	}
	@Override
	protected Perfil getJPAInstance(Perfil __bean) {
		return convertToJPA(__bean);
	}


	public static PerfilJPA convertToJPA(Perfil __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof PerfilJPA) {
	    return (PerfilJPA)__bean;
	  }
	  
	  return PerfilJPA.toJPA(__bean);
	}

  @Override
  public Perfil create(Perfil transientInstance) throws I18NException {
    processTranslations(transientInstance);
    return super.create(transientInstance);
  }


  @Override
  public Perfil update(Perfil transientInstance) throws I18NException {
    processTranslations(transientInstance);
    return super.update(transientInstance);
  }


  private void processTranslations(Perfil transientInstance) {
    if (transientInstance != null) {
      if (transientInstance.getNomID() == null) {
        if (transientInstance instanceof PerfilJPA) {
          PerfilJPA _jpa = (PerfilJPA)transientInstance;
          TraduccioJPA _trad = _jpa.getNom();
           if (_trad != null) {
            if (_trad.getTraduccioID() == 0) {
              getEntityManager().persist(_trad);
            } 
            transientInstance.setNomID(_trad.getTraduccioID());
          }
        }
      }
      if (transientInstance.getDescripcioID() == null) {
        if (transientInstance instanceof PerfilJPA) {
          PerfilJPA _jpa = (PerfilJPA)transientInstance;
          TraduccioJPA _trad = _jpa.getDescripcio();
           if (_trad != null) {
            if (_trad.getTraduccioID() == 0) {
              getEntityManager().persist(_trad);
            } 
            transientInstance.setDescripcioID(_trad.getTraduccioID());
          }
        }
      }
    }
  }


}