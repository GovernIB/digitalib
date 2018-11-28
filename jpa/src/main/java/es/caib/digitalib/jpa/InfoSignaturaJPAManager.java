
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


public class InfoSignaturaJPAManager
		 extends AbstractDigitalIBJPAManager<InfoSignatura, Long>
		 implements IInfoSignaturaManager, InfoSignaturaFields {




  private static final long serialVersionUID = 1055205240L;

	 public static final TableName<InfoSignatura> _TABLENAME =  new TableName<InfoSignatura>("InfoSignaturaJPA");



  static final ModificationManager<InfoSignatura> __eventManager = new ModificationManager<InfoSignatura>();


  @PersistenceContext
  protected EntityManager __em;
  public InfoSignaturaJPAManager() {
  }
  protected InfoSignaturaJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return InfoSignaturaJPA. class;
	}



	public ModificationManager<InfoSignatura> getEventManager() {
	return __eventManager;
	}


	public TableName<InfoSignatura> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public InfoSignatura[] listToArray(List<InfoSignatura> list)  {
		if(list == null) { return null; };
		return list.toArray(new InfoSignatura[list.size()]);
	};

	public synchronized InfoSignatura create( int _signoperation_, java.lang.String _signtype_, java.lang.String _signalgorithm_, java.lang.Integer _signmode_, java.lang.Integer _signaturestablelocation_, boolean _timestampincluded_, boolean _policyincluded_, java.lang.String _enitipofirma_, java.lang.String _eniperfilfirma_, java.lang.String _enirolfirma_, java.lang.String _enisignername_, java.lang.String _enisigneradministrationid_, java.lang.String _enisignlevel_, boolean _checkadministrationidofsigner_, boolean _checkdocumentmodifications_, boolean _checkvalidationsignature_) throws I18NException {
		InfoSignaturaJPA __bean =  new InfoSignaturaJPA(_signoperation_,_signtype_,_signalgorithm_,_signmode_,_signaturestablelocation_,_timestampincluded_,_policyincluded_,_enitipofirma_,_eniperfilfirma_,_enirolfirma_,_enisignername_,_enisigneradministrationid_,_enisignlevel_,_checkadministrationidofsigner_,_checkdocumentmodifications_,_checkvalidationsignature_);
		return create(__bean);
	}



 public void delete(long _infoSignaturaID_) {
   delete(findByPrimaryKey(_infoSignaturaID_));
 }




	public InfoSignatura findByPrimaryKey(long _infoSignaturaID_) {
	  return __em.find(InfoSignaturaJPA.class, _infoSignaturaID_);  
	}
	@Override
	protected InfoSignatura getJPAInstance(InfoSignatura __bean) {
		return convertToJPA(__bean);
	}


	public static InfoSignaturaJPA convertToJPA(InfoSignatura __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof InfoSignaturaJPA) {
	    return (InfoSignaturaJPA)__bean;
	  }
	  
	  return InfoSignaturaJPA.toJPA(__bean);
	}


}