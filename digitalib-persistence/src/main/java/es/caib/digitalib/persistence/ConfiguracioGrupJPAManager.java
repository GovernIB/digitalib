
package es.caib.digitalib.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import es.caib.digitalib.model.entity.*;
import es.caib.digitalib.model.fields.*;
import es.caib.digitalib.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class ConfiguracioGrupJPAManager
         extends AbstractJPAManager<ConfiguracioGrup, Long>
         implements ConfiguracioGrupIJPAManager, IConfiguracioGrupManager, ConfiguracioGrupFields {



    public static final TableName<ConfiguracioGrup> _TABLENAME =  new TableName<ConfiguracioGrup>("ConfiguracioGrupJPA");


    @PersistenceContext
    protected EntityManager __em;

    public ConfiguracioGrupJPAManager() {
    }

    protected ConfiguracioGrupJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return ConfiguracioGrupJPA. class;
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

    public ConfiguracioGrup create( java.lang.String _nom_, java.lang.String _suportWeb_, java.lang.String _suportEmail_, java.lang.String _suportTelefon_, long _logoHeaderID_, long _logoFooterID_, java.lang.String _adreza_, java.lang.String _codiDir3PerDefecte_, java.lang.Long _perfilNomesEscaneigID_, java.lang.Long _perfilNomesEscaneig2ID_, java.lang.Long _perfilCopiaAutenticaID_, java.lang.Long _perfilCopiaAutentica2ID_, java.lang.Long _perfilCustodiaID_, java.lang.Long _perfilCustodia2ID_) throws I18NException {
        ConfiguracioGrupJPA __bean =  new ConfiguracioGrupJPA(_nom_,_suportWeb_,_suportEmail_,_suportTelefon_,_logoHeaderID_,_logoFooterID_,_adreza_,_codiDir3PerDefecte_,_perfilNomesEscaneigID_,_perfilNomesEscaneig2ID_,_perfilCopiaAutenticaID_,_perfilCopiaAutentica2ID_,_perfilCustodiaID_,_perfilCustodia2ID_);
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