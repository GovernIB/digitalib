
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


public class PerfilUsuariAplicacioJPAManager
		 extends AbstractDigitalIBJPAManager<PerfilUsuariAplicacio, Long>
		 implements IPerfilUsuariAplicacioManager, PerfilUsuariAplicacioFields {




  private static final long serialVersionUID = -63972796L;

	 public static final TableName<PerfilUsuariAplicacio> _TABLENAME =  new TableName<PerfilUsuariAplicacio>("PerfilUsuariAplicacioJPA");



  static final ModificationManager<PerfilUsuariAplicacio> __eventManager = new ModificationManager<PerfilUsuariAplicacio>();


  @PersistenceContext
  protected EntityManager __em;
  public PerfilUsuariAplicacioJPAManager() {
  }
  protected PerfilUsuariAplicacioJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return PerfilUsuariAplicacioJPA. class;
	}



	public ModificationManager<PerfilUsuariAplicacio> getEventManager() {
	return __eventManager;
	}


	public TableName<PerfilUsuariAplicacio> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public PerfilUsuariAplicacio[] listToArray(List<PerfilUsuariAplicacio> list)  {
		if(list == null) { return null; };
		return list.toArray(new PerfilUsuariAplicacio[list.size()]);
	};

	public synchronized PerfilUsuariAplicacio create( long _perfilID_, long _usuariAplicacioID_) throws I18NException {
		PerfilUsuariAplicacioJPA __bean =  new PerfilUsuariAplicacioJPA(_perfilID_,_usuariAplicacioID_);
		return create(__bean);
	}



 public void delete(long _perfilUsrAppID_) {
   delete(findByPrimaryKey(_perfilUsrAppID_));
 }




	public PerfilUsuariAplicacio findByPrimaryKey(long _perfilUsrAppID_) {
	  return __em.find(PerfilUsuariAplicacioJPA.class, _perfilUsrAppID_);  
	}
	@Override
	protected PerfilUsuariAplicacio getJPAInstance(PerfilUsuariAplicacio __bean) {
		return convertToJPA(__bean);
	}


	public static PerfilUsuariAplicacioJPA convertToJPA(PerfilUsuariAplicacio __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof PerfilUsuariAplicacioJPA) {
	    return (PerfilUsuariAplicacioJPA)__bean;
	  }
	  
	  return PerfilUsuariAplicacioJPA.toJPA(__bean);
	}


}