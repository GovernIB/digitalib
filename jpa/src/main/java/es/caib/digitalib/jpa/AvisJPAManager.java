
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


public class AvisJPAManager
		 extends AbstractDigitalIBJPAManager<Avis, Long>
		 implements IAvisManager, AvisFields {




  private static final long serialVersionUID = 1008320753L;

	 public static final TableName<Avis> _TABLENAME =  new TableName<Avis>("AvisJPA");



  static final ModificationManager<Avis> __eventManager = new ModificationManager<Avis>();


  @PersistenceContext
  protected EntityManager __em;
  public AvisJPAManager() {
  }
  protected AvisJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return AvisJPA. class;
	}



	public ModificationManager<Avis> getEventManager() {
	return __eventManager;
	}


	public TableName<Avis> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public Avis[] listToArray(List<Avis> list)  {
		if(list == null) { return null; };
		return list.toArray(new Avis[list.size()]);
	};

	public Avis create( long _descripcioID_, int _tipus_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, java.lang.Long _configGrupID_, boolean _bloquejar_) throws I18NException {
		AvisJPA __bean =  new AvisJPA(_descripcioID_,_tipus_,_dataInici_,_dataFi_,_configGrupID_,_bloquejar_);
		return create(__bean);
	}



 public void delete(long _avisID_) {
   delete(findByPrimaryKey(_avisID_));
 }




	public Avis findByPrimaryKey(long _avisID_) {
	  return __em.find(AvisJPA.class, _avisID_);  
	}
	@Override
	protected Avis getJPAInstance(Avis __bean) {
		return convertToJPA(__bean);
	}


	public static AvisJPA convertToJPA(Avis __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof AvisJPA) {
	    return (AvisJPA)__bean;
	  }
	  
	  return AvisJPA.toJPA(__bean);
	}

  @Override
  public Avis create(Avis transientInstance) throws I18NException {
    processTranslations(transientInstance);
    return super.create(transientInstance);
  }


  @Override
  public Avis update(Avis transientInstance) throws I18NException {
    processTranslations(transientInstance);
    return super.update(transientInstance);
  }


  private void processTranslations(Avis transientInstance) {
    if (transientInstance != null) {
      if (transientInstance.getDescripcioID() == 0) {
        if (transientInstance instanceof AvisJPA) {
          AvisJPA _jpa = (AvisJPA)transientInstance;
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