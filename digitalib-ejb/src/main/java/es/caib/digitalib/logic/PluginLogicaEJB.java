package es.caib.digitalib.logic;


import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;




import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.core.IPlugin;


import es.caib.digitalib.ejb.PluginEJB;
import es.caib.digitalib.model.entity.Plugin;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "PluginLogicaEJB")

public class PluginLogicaEJB extends PluginEJB implements PluginLogicaService {

  private static Map<Long, IPlugin> pluginsCache = new HashMap<Long, IPlugin>();

  
  @Override
  public Plugin update(Plugin instance) throws I18NException {
    if (instance != null) {
      synchronized (pluginsCache) {
        pluginsCache.remove(instance.getPluginID());
      }
    }
    return super.update(instance);
  }

  
  @Override
  public void delete(Plugin instance) {
    if (instance != null) {
      synchronized (pluginsCache) {
        pluginsCache.remove(instance.getPluginID());
      }
    }
    super.delete(instance);
  }
  
  @Override
  public void clearCache() {
    synchronized (pluginsCache) {
      pluginsCache.clear();
    }
  }
  
  
  public void addPluginToCache(Long pluginID, IPlugin pluginInstance) { 
    synchronized (pluginsCache) {
      pluginsCache.put(pluginID, pluginInstance);  
    }
  }
  
  public IPlugin getPluginFromCache(Long pluginID) {
    synchronized (pluginsCache) {
      return  pluginsCache.get(pluginID);  
    }
  }
  
}