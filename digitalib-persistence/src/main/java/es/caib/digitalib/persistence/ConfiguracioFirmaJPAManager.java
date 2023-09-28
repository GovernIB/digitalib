
package es.caib.digitalib.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import es.caib.digitalib.model.entity.*;
import es.caib.digitalib.model.fields.*;
import es.caib.digitalib.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class ConfiguracioFirmaJPAManager
         extends AbstractJPAManager<ConfiguracioFirma, Long>
         implements ConfiguracioFirmaIJPAManager, IConfiguracioFirmaManager, ConfiguracioFirmaFields {



    public static final TableName<ConfiguracioFirma> _TABLENAME =  new TableName<ConfiguracioFirma>("ConfiguracioFirmaJPA");


    @PersistenceContext
    protected EntityManager __em;

    public ConfiguracioFirmaJPAManager() {
    }

    protected ConfiguracioFirmaJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return ConfiguracioFirmaJPA. class;
    }



    public TableName<ConfiguracioFirma> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public ConfiguracioFirma[] listToArray(List<ConfiguracioFirma> list)  {
        if(list == null) { return null; };
        return list.toArray(new ConfiguracioFirma[list.size()]);
    };

    public ConfiguracioFirma create( java.lang.String _nom_, long _pluginFirmaServidorID_, boolean _incloureSegellDeTemps_, java.lang.Long _pluginSegellatID_, int _tipusOperacioFirma_, int _tipusFirmaID_, int _algorismeDeFirmaID_, boolean _modeDeFirma_, int _usPoliticaDeFirma_, java.lang.String _policyIdentifier_, java.lang.String _policyIdentifierHash_, java.lang.String _policyIdentifierHashAlgorithm_, java.lang.String _policyUrlDocument_, int _posicioTaulaFirmesID_, java.lang.Long _firmatPerFormatID_, java.lang.Long _motiuDelegacioID_, java.lang.String _propietatsTaulaFirmes_) throws I18NException {
        ConfiguracioFirmaJPA __bean =  new ConfiguracioFirmaJPA(_nom_,_pluginFirmaServidorID_,_incloureSegellDeTemps_,_pluginSegellatID_,_tipusOperacioFirma_,_tipusFirmaID_,_algorismeDeFirmaID_,_modeDeFirma_,_usPoliticaDeFirma_,_policyIdentifier_,_policyIdentifierHash_,_policyIdentifierHashAlgorithm_,_policyUrlDocument_,_posicioTaulaFirmesID_,_firmatPerFormatID_,_motiuDelegacioID_,_propietatsTaulaFirmes_);
        return create(__bean);
    }



 public void delete(long _configuracioFirmaID_) {
   delete(findByPrimaryKey(_configuracioFirmaID_));
 }




    public ConfiguracioFirma findByPrimaryKey(long _configuracioFirmaID_) {
        return __em.find(ConfiguracioFirmaJPA.class, _configuracioFirmaID_);  
    }
    @Override
    protected ConfiguracioFirma getJPAInstance(ConfiguracioFirma __bean) {
        return convertToJPA(__bean);
    }


    public static ConfiguracioFirmaJPA convertToJPA(ConfiguracioFirma __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof ConfiguracioFirmaJPA) {
        return (ConfiguracioFirmaJPA)__bean;
      }
      
      return ConfiguracioFirmaJPA.toJPA(__bean);
    }

  @Override
  public ConfiguracioFirma create(ConfiguracioFirma transientInstance) throws I18NException {
    processTranslations(transientInstance);
    return super.create(transientInstance);
  }


  @Override
  public ConfiguracioFirma update(ConfiguracioFirma transientInstance) throws I18NException {
    processTranslations(transientInstance);
    return super.update(transientInstance);
  }


  private void processTranslations(ConfiguracioFirma transientInstance) {
    if (transientInstance != null) {
      if (transientInstance.getFirmatPerFormatID() == null) {
        if (transientInstance instanceof ConfiguracioFirmaJPA) {
          ConfiguracioFirmaJPA _jpa = (ConfiguracioFirmaJPA)transientInstance;
          TraduccioJPA _trad = _jpa.getFirmatPerFormat();
           if (_trad != null) {
            if (_trad.getTraduccioID() == 0) {
              getEntityManager().persist(_trad);
            } 
            transientInstance.setFirmatPerFormatID(_trad.getTraduccioID());
          }
        }
      }
      if (transientInstance.getMotiuDelegacioID() == null) {
        if (transientInstance instanceof ConfiguracioFirmaJPA) {
          ConfiguracioFirmaJPA _jpa = (ConfiguracioFirmaJPA)transientInstance;
          TraduccioJPA _trad = _jpa.getMotiuDelegacio();
           if (_trad != null) {
            if (_trad.getTraduccioID() == 0) {
              getEntityManager().persist(_trad);
            } 
            transientInstance.setMotiuDelegacioID(_trad.getTraduccioID());
          }
        }
      }
    }
  }


}