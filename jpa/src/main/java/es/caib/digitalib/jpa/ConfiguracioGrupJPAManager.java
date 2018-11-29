
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


public class ConfiguracioGrupJPAManager
		 extends AbstractDigitalIBJPAManager<ConfiguracioGrup, Long>
		 implements IConfiguracioGrupManager, ConfiguracioGrupFields {




  private static final long serialVersionUID = -380629153L;

	 public static final TableName<ConfiguracioGrup> _TABLENAME =  new TableName<ConfiguracioGrup>("ConfiguracioGrupJPA");



  static final ModificationManager<ConfiguracioGrup> __eventManager = new ModificationManager<ConfiguracioGrup>();


  @PersistenceContext
  protected EntityManager __em;
  public ConfiguracioGrupJPAManager() {
  }
  protected ConfiguracioGrupJPAManager(EntityManager __em) {
    this.__em = __em;
  }


  protected EntityManager getEntityManager() {
    return this.__em;
  }
	public Class<?> getJPAClass() {
		return ConfiguracioGrupJPA. class;
	}



	public ModificationManager<ConfiguracioGrup> getEventManager() {
	return __eventManager;
	}


	public TableName<ConfiguracioGrup> getTableName() {
		return _TABLENAME;
	}


	@Override
	protected String getTableNameVariable() {
		return _TABLE_MODEL;
	}


	public ConfiguracioGrup[] listToArray(List<ConfiguracioGrup> list)  {
		if(list == null) { return null; };
		return list.toArray(new ConfiguracioGrup[list.size()]);
	};

	public synchronized ConfiguracioGrup create( java.lang.String _nom_, java.lang.String _suportWeb_, java.lang.String _suportEmail_, java.lang.String _suportTelefon_, long _logoHeaderID_, long _logoFooterID_, java.lang.String _adreza_, java.lang.Long _perfilNomesEscaneigID_, java.lang.Long _perfilCopiaAutenticaID_, java.lang.Long _perfilCustodiaID_) throws I18NException {
		ConfiguracioGrupJPA __bean =  new ConfiguracioGrupJPA(_nom_,_suportWeb_,_suportEmail_,_suportTelefon_,_logoHeaderID_,_logoFooterID_,_adreza_,_perfilNomesEscaneigID_,_perfilCopiaAutenticaID_,_perfilCustodiaID_);
		return create(__bean);
	}



 public void delete(long _configuracioGrupID_) {
   delete(findByPrimaryKey(_configuracioGrupID_));
 }




	public ConfiguracioGrup findByPrimaryKey(long _configuracioGrupID_) {
	  return __em.find(ConfiguracioGrupJPA.class, _configuracioGrupID_);  
	}
	@Override
	protected ConfiguracioGrup getJPAInstance(ConfiguracioGrup __bean) {
		return convertToJPA(__bean);
	}


	public static ConfiguracioGrupJPA convertToJPA(ConfiguracioGrup __bean) {
	  if (__bean == null) {
	    return null;
	  }
	  if(__bean instanceof ConfiguracioGrupJPA) {
	    return (ConfiguracioGrupJPA)__bean;
	  }
	  
	  return ConfiguracioGrupJPA.toJPA(__bean);
	}


}