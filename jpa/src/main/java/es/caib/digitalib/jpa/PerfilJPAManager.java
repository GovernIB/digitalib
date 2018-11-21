
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

	public synchronized Perfil create( java.lang.String _codi_, java.lang.String _nom_, java.lang.String _descripcio_, long _pluginScanWebID_, int _tipusFirma_, java.lang.Long _pluginFirmaServidorID_, java.lang.Long _apiSimpleID_, int _tipusCustodia_, java.lang.Long _pluginArxiuID_, java.lang.Long _pluginDocCustodyID_, int _usPerfil_) throws I18NException {
		PerfilJPA __bean =  new PerfilJPA(_codi_,_nom_,_descripcio_,_pluginScanWebID_,_tipusFirma_,_pluginFirmaServidorID_,_apiSimpleID_,_tipusCustodia_,_pluginArxiuID_,_pluginDocCustodyID_,_usPerfil_);
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


}