
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


public class AuditoriaJPAManager
		 extends AbstractDigitalIBJPAManager<Auditoria, Long>
		 implements IAuditoriaManager, AuditoriaFields {




  private static final long serialVersionUID = 1834834024L;

	 public static final TableName<Auditoria> _TABLENAME =  new TableName<Auditoria>("AuditoriaJPA");



  static final ModificationManager<Auditoria> __eventManager = new ModificationManager<Auditoria>();


  @PersistenceContext
  protected EntityManager __em;
  public AuditoriaJPAManager() {
  }
  protected AuditoriaJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return AuditoriaJPA. class;
	}



	public ModificationManager<Auditoria> getEventManager() {
	return __eventManager;
	}


	public TableName<Auditoria> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public Auditoria[] listToArray(List<Auditoria> list)  {
		if(list == null) { return null; };
		return list.toArray(new Auditoria[list.size()]);
	};

	public synchronized Auditoria create( java.sql.Timestamp _data_, long _transaccioId_, int _tipus_, java.lang.String _missatge_, java.lang.String _additionalInfo_, boolean _isApp_, java.lang.String _usernameAplicacio_, java.lang.String _usernamePersona_) throws I18NException {
		AuditoriaJPA __bean =  new AuditoriaJPA(_data_,_transaccioId_,_tipus_,_missatge_,_additionalInfo_,_isApp_,_usernameAplicacio_,_usernamePersona_);
		return create(__bean);
	}



 public void delete(long _auditoriaID_) {
   delete(findByPrimaryKey(_auditoriaID_));
 }




	public Auditoria findByPrimaryKey(long _auditoriaID_) {
	  return __em.find(AuditoriaJPA.class, _auditoriaID_);  
	}
	@Override
	protected Auditoria getJPAInstance(Auditoria __bean) {
		return convertToJPA(__bean);
	}


	public static AuditoriaJPA convertToJPA(Auditoria __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof AuditoriaJPA) {
	    return (AuditoriaJPA)__bean;
	  }
	  
	  return AuditoriaJPA.toJPA(__bean);
	}


}