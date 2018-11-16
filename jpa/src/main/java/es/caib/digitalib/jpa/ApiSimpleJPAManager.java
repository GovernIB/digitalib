
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


public class ApiSimpleJPAManager
		 extends AbstractDigitalIBJPAManager<ApiSimple, Long>
		 implements IApiSimpleManager, ApiSimpleFields {




  private static final long serialVersionUID = -1262175042L;

	 public static final TableName<ApiSimple> _TABLENAME =  new TableName<ApiSimple>("ApiSimpleJPA");



  static final ModificationManager<ApiSimple> __eventManager = new ModificationManager<ApiSimple>();


  @PersistenceContext
  protected EntityManager __em;
  public ApiSimpleJPAManager() {
  }
  protected ApiSimpleJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return ApiSimpleJPA. class;
	}



	public ModificationManager<ApiSimple> getEventManager() {
	return __eventManager;
	}


	public TableName<ApiSimple> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public ApiSimple[] listToArray(List<ApiSimple> list)  {
		if(list == null) { return null; };
		return list.toArray(new ApiSimple[list.size()]);
	};

	public synchronized ApiSimple create( java.lang.String _nom_, java.lang.String _url_, java.lang.String _username_, java.lang.String _contrasenya_) throws I18NException {
		ApiSimpleJPA __bean =  new ApiSimpleJPA(_nom_,_url_,_username_,_contrasenya_);
		return create(__bean);
	}



 public void delete(long _apiSimpleID_) {
   delete(findByPrimaryKey(_apiSimpleID_));
 }




	public ApiSimple findByPrimaryKey(long _apiSimpleID_) {
	  return __em.find(ApiSimpleJPA.class, _apiSimpleID_);  
	}
	@Override
	protected ApiSimple getJPAInstance(ApiSimple __bean) {
		return convertToJPA(__bean);
	}


	public static ApiSimpleJPA convertToJPA(ApiSimple __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof ApiSimpleJPA) {
	    return (ApiSimpleJPA)__bean;
	  }
	  
	  return ApiSimpleJPA.toJPA(__bean);
	}


}