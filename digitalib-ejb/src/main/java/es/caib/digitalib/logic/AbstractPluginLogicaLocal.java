package es.caib.digitalib.logic;

import java.util.List;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.model.entity.Plugin;


/**
 * 
 * @author anadal
 *
 */
public interface AbstractPluginLogicaLocal<I> extends PluginLogicaService {

  public List<Plugin> getAllPlugins() throws I18NException;

  public I getInstanceByPluginID(long pluginID) throws I18NException;

  public List<I> getPluginInstancesByEntitatID() throws I18NException;

  public List<I> getPluginInstancesBy(List<Long> filterByPluginID,
      List<String> filterByPluginCode) throws I18NException;
  
  
  public Where getWhere();

}
