
package es.caib.digitalib.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import es.caib.digitalib.model.entity.*;
import es.caib.digitalib.model.fields.*;
import es.caib.digitalib.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class PerfilUsuariAplicacioJPAManager
         extends AbstractJPAManager<PerfilUsuariAplicacio, Long>
         implements PerfilUsuariAplicacioIJPAManager, IPerfilUsuariAplicacioManager, PerfilUsuariAplicacioFields {



    public static final TableName<PerfilUsuariAplicacio> _TABLENAME =  new TableName<PerfilUsuariAplicacio>("PerfilUsuariAplicacioJPA");


    @PersistenceContext
    protected EntityManager __em;

    public PerfilUsuariAplicacioJPAManager() {
    }

    protected PerfilUsuariAplicacioJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return PerfilUsuariAplicacioJPA. class;
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

    public PerfilUsuariAplicacio create( long _perfilID_, long _usuariAplicacioID_) throws I18NException {
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