
package es.caib.digitalib.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import es.caib.digitalib.model.entity.*;
import es.caib.digitalib.model.fields.*;
import es.caib.digitalib.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class MetadadaJPAManager
         extends AbstractJPAManager<Metadada, Long>
         implements MetadadaIJPAManager, IMetadadaManager, MetadadaFields {



    public static final TableName<Metadada> _TABLENAME =  new TableName<Metadada>("MetadadaJPA");


    @PersistenceContext
    protected EntityManager __em;

    public MetadadaJPAManager() {
    }

    protected MetadadaJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return MetadadaJPA. class;
    }



    public TableName<Metadada> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Metadada[] listToArray(List<Metadada> list)  {
        if(list == null) { return null; };
        return list.toArray(new Metadada[list.size()]);
    };

    public Metadada create( long _transaccioID_, java.lang.String _nom_, java.lang.String _valor_) throws I18NException {
        MetadadaJPA __bean =  new MetadadaJPA(_transaccioID_,_nom_,_valor_);
        return create(__bean);
    }



 public void delete(long _metadadaid_) {
   delete(findByPrimaryKey(_metadadaid_));
 }




    public Metadada findByPrimaryKey(long _metadadaid_) {
        return __em.find(MetadadaJPA.class, _metadadaid_);  
    }
    @Override
    protected Metadada getJPAInstance(Metadada __bean) {
        return convertToJPA(__bean);
    }


    public static MetadadaJPA convertToJPA(Metadada __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof MetadadaJPA) {
        return (MetadadaJPA)__bean;
      }
      
      return MetadadaJPA.toJPA(__bean);
    }


}