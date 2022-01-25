
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


public class TransaccioMultipleJPAManager
		 extends AbstractDigitalIBJPAManager<TransaccioMultiple, Long>
		 implements ITransaccioMultipleManager, TransaccioMultipleFields {




  private static final long serialVersionUID = 807575489L;

	 public static final TableName<TransaccioMultiple> _TABLENAME =  new TableName<TransaccioMultiple>("TransaccioMultipleJPA");



  static final ModificationManager<TransaccioMultiple> __eventManager = new ModificationManager<TransaccioMultiple>();


  @PersistenceContext
  protected EntityManager __em;
  public TransaccioMultipleJPAManager() {
  }
  protected TransaccioMultipleJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return TransaccioMultipleJPA. class;
	}



	public ModificationManager<TransaccioMultiple> getEventManager() {
	return __eventManager;
	}


	public TableName<TransaccioMultiple> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public TransaccioMultiple[] listToArray(List<TransaccioMultiple> list)  {
		if(list == null) { return null; };
		return list.toArray(new TransaccioMultiple[list.size()]);
	};

	public TransaccioMultiple create( long _transmultipleid_, java.lang.String _descripcio_, java.lang.Long _fitxerEscanejatID_) throws I18NException {
		TransaccioMultipleJPA __bean =  new TransaccioMultipleJPA(_transmultipleid_,_descripcio_,_fitxerEscanejatID_);
		return create(__bean);
	}



 public void delete(long _transmultipleid_) {
   delete(findByPrimaryKey(_transmultipleid_));
 }




	public TransaccioMultiple findByPrimaryKey(long _transmultipleid_) {
	  return __em.find(TransaccioMultipleJPA.class, _transmultipleid_);  
	}
	@Override
	protected TransaccioMultiple getJPAInstance(TransaccioMultiple __bean) {
		return convertToJPA(__bean);
	}


	public static TransaccioMultipleJPA convertToJPA(TransaccioMultiple __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof TransaccioMultipleJPA) {
	    return (TransaccioMultipleJPA)__bean;
	  }
	  
	  return TransaccioMultipleJPA.toJPA(__bean);
	}


}