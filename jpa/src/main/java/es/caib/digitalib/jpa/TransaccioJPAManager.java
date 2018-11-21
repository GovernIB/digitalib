
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


public class TransaccioJPAManager
		 extends AbstractDigitalIBJPAManager<Transaccio, Long>
		 implements ITransaccioManager, TransaccioFields {




  private static final long serialVersionUID = 1344938129L;

	 public static final TableName<Transaccio> _TABLENAME =  new TableName<Transaccio>("TransaccioJPA");



  static final ModificationManager<Transaccio> __eventManager = new ModificationManager<Transaccio>();


  @PersistenceContext
  protected EntityManager __em;
  public TransaccioJPAManager() {
  }
  protected TransaccioJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return TransaccioJPA. class;
	}



	public ModificationManager<Transaccio> getEventManager() {
	return __eventManager;
	}


	public TableName<Transaccio> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public Transaccio[] listToArray(List<Transaccio> list)  {
		if(list == null) { return null; };
		return list.toArray(new Transaccio[list.size()]);
	};

	public synchronized Transaccio create( java.lang.String _transactionWebId_, java.sql.Timestamp _datainici_, java.sql.Timestamp _datafi_, java.lang.Long _usuariaplicacioid_, java.lang.Long _usuaripersonaid_, int _estatcodi_, java.lang.String _estatmissatge_, java.lang.String _estatexcepcio_, java.lang.Long _fitxerescanejatid_, java.lang.Long _fitxersignaturaid_, java.lang.Integer _infoscanpixeltype_, java.lang.Integer _infoscanresolucioppp_, java.lang.String _infoscanformatfitxer_, boolean _infoscanocr_, java.lang.Long _infosignaturaid_, java.lang.Long _infocustodyid_, java.lang.String _languageui_, java.lang.String _languagedoc_, java.lang.String _ciutadanif_, java.lang.String _ciutadanom_, java.lang.String _funcionariusername_, java.lang.String _funcionarinom_, java.lang.String _expedient_, long _perfilid_, java.lang.String _usernameRequest_) throws I18NException {
		TransaccioJPA __bean =  new TransaccioJPA(_transactionWebId_,_datainici_,_datafi_,_usuariaplicacioid_,_usuaripersonaid_,_estatcodi_,_estatmissatge_,_estatexcepcio_,_fitxerescanejatid_,_fitxersignaturaid_,_infoscanpixeltype_,_infoscanresolucioppp_,_infoscanformatfitxer_,_infoscanocr_,_infosignaturaid_,_infocustodyid_,_languageui_,_languagedoc_,_ciutadanif_,_ciutadanom_,_funcionariusername_,_funcionarinom_,_expedient_,_perfilid_,_usernameRequest_);
		return create(__bean);
	}



 public void delete(long _transaccioID_) {
   delete(findByPrimaryKey(_transaccioID_));
 }




	public Transaccio findByPrimaryKey(long _transaccioID_) {
	  return __em.find(TransaccioJPA.class, _transaccioID_);  
	}
	@Override
	protected Transaccio getJPAInstance(Transaccio __bean) {
		return convertToJPA(__bean);
	}


	public static TransaccioJPA convertToJPA(Transaccio __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof TransaccioJPA) {
	    return (TransaccioJPA)__bean;
	  }
	  
	  return TransaccioJPA.toJPA(__bean);
	}


}