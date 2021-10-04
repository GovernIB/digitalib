
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


public class PluginJPAManager
		 extends AbstractDigitalIBJPAManager<Plugin, Long>
		 implements IPluginManager, PluginFields {




  private static final long serialVersionUID = -1591214331L;

	 public static final TableName<Plugin> _TABLENAME =  new TableName<Plugin>("PluginJPA");



  static final ModificationManager<Plugin> __eventManager = new ModificationManager<Plugin>();


  @PersistenceContext
  protected EntityManager __em;
  public PluginJPAManager() {
  }
  protected PluginJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return PluginJPA. class;
	}



	public ModificationManager<Plugin> getEventManager() {
	return __eventManager;
	}


	public TableName<Plugin> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public Plugin[] listToArray(List<Plugin> list)  {
		if(list == null) { return null; };
		return list.toArray(new Plugin[list.size()]);
	};

	public synchronized Plugin create( java.lang.String _codi_, java.lang.String _nom_, java.lang.String _descripcio_, java.lang.String _classe_, java.lang.String _properties_, boolean _actiu_, int _tipus_, java.lang.Integer _ordre_) throws I18NException {
		PluginJPA __bean =  new PluginJPA(_codi_,_nom_,_descripcio_,_classe_,_properties_,_actiu_,_tipus_,_ordre_);
		return create(__bean);
	}



 public void delete(long _pluginID_) {
   delete(findByPrimaryKey(_pluginID_));
 }




	public Plugin findByPrimaryKey(long _pluginID_) {
	  return __em.find(PluginJPA.class, _pluginID_);  
	}
	@Override
	protected Plugin getJPAInstance(Plugin __bean) {
		return convertToJPA(__bean);
	}


	public static PluginJPA convertToJPA(Plugin __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof PluginJPA) {
	    return (PluginJPA)__bean;
	  }
	  
	  return PluginJPA.toJPA(__bean);
	}


}