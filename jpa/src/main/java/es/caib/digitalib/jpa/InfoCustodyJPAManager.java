
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


public class InfoCustodyJPAManager
		 extends AbstractDigitalIBJPAManager<InfoCustody, Long>
		 implements IInfoCustodyManager, InfoCustodyFields {




  private static final long serialVersionUID = -359396075L;

	 public static final TableName<InfoCustody> _TABLENAME =  new TableName<InfoCustody>("InfoCustodyJPA");



  static final ModificationManager<InfoCustody> __eventManager = new ModificationManager<InfoCustody>();


  @PersistenceContext
  protected EntityManager __em;
  public InfoCustodyJPAManager() {
  }
  protected InfoCustodyJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return InfoCustodyJPA. class;
	}



	public ModificationManager<InfoCustody> getEventManager() {
	return __eventManager;
	}


	public TableName<InfoCustody> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public InfoCustody[] listToArray(List<InfoCustody> list)  {
		if(list == null) { return null; };
		return list.toArray(new InfoCustody[list.size()]);
	};

	public synchronized InfoCustody create( java.lang.String _custodyId_, java.lang.String _arxiuExpedientId_, java.lang.String _arxiuDocumentId_, java.lang.String _originalFileUrl_, java.lang.String _printableFileUrl_, java.lang.String _eniFileUrl_, java.lang.String _csv_, java.lang.String _csvValidationWeb_, java.lang.String _csvGenerationDefinition_) throws I18NException {
		InfoCustodyJPA __bean =  new InfoCustodyJPA(_custodyId_,_arxiuExpedientId_,_arxiuDocumentId_,_originalFileUrl_,_printableFileUrl_,_eniFileUrl_,_csv_,_csvValidationWeb_,_csvGenerationDefinition_);
		return create(__bean);
	}



 public void delete(long _infoCustodyID_) {
   delete(findByPrimaryKey(_infoCustodyID_));
 }




	public InfoCustody findByPrimaryKey(long _infoCustodyID_) {
	  return __em.find(InfoCustodyJPA.class, _infoCustodyID_);  
	}
	@Override
	protected InfoCustody getJPAInstance(InfoCustody __bean) {
		return convertToJPA(__bean);
	}


	public static InfoCustodyJPA convertToJPA(InfoCustody __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof InfoCustodyJPA) {
	    return (InfoCustodyJPA)__bean;
	  }
	  
	  return InfoCustodyJPA.toJPA(__bean);
	}


}