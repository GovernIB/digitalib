
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


public class UsuariAplicacioJPAManager
		 extends AbstractDigitalIBJPAManager<UsuariAplicacio, Long>
		 implements IUsuariAplicacioManager, UsuariAplicacioFields {




  private static final long serialVersionUID = -1937379664L;

	 public static final TableName<UsuariAplicacio> _TABLENAME =  new TableName<UsuariAplicacio>("UsuariAplicacioJPA");



  static final ModificationManager<UsuariAplicacio> __eventManager = new ModificationManager<UsuariAplicacio>();


  @PersistenceContext
  protected EntityManager __em;
  public UsuariAplicacioJPAManager() {
  }
  protected UsuariAplicacioJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return UsuariAplicacioJPA. class;
	}



	public ModificationManager<UsuariAplicacio> getEventManager() {
	return __eventManager;
	}


	public TableName<UsuariAplicacio> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public UsuariAplicacio[] listToArray(List<UsuariAplicacio> list)  {
		if(list == null) { return null; };
		return list.toArray(new UsuariAplicacio[list.size()]);
	};

	public synchronized UsuariAplicacio create( java.lang.String _username_, java.lang.String _contrasenya_, java.lang.String _emailAdmin_, java.lang.String _descripcio_, boolean _actiu_, boolean _roleScan_, boolean _roleCoAu_, boolean _roleCust_) throws I18NException {
		UsuariAplicacioJPA __bean =  new UsuariAplicacioJPA(_username_,_contrasenya_,_emailAdmin_,_descripcio_,_actiu_,_roleScan_,_roleCoAu_,_roleCust_);
		return create(__bean);
	}



 public void delete(long _usuariAplicacioID_) {
   delete(findByPrimaryKey(_usuariAplicacioID_));
 }




	public UsuariAplicacio findByPrimaryKey(long _usuariAplicacioID_) {
	  return __em.find(UsuariAplicacioJPA.class, _usuariAplicacioID_);  
	}
	@Override
	protected UsuariAplicacio getJPAInstance(UsuariAplicacio __bean) {
		return convertToJPA(__bean);
	}


	public static UsuariAplicacioJPA convertToJPA(UsuariAplicacio __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof UsuariAplicacioJPA) {
	    return (UsuariAplicacioJPA)__bean;
	  }
	  
	  return UsuariAplicacioJPA.toJPA(__bean);
	}


}